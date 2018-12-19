package rest.verification;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class YAMLUtilsVerifierDefault {

	private YAMLUtilsVerifierFactory factory;
    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(YAMLUtilsVerifierDefault.class);

	public YAMLUtilsResult verifyYaml(YAMLUtilsConfigDefault configuration, Object jsonObject) throws TemplateException {
		factory = new YAMLUtilsVerifierFactory();
		boolean result = false;
		String errorMessage = "No Errors";
		try {
			result = factory.getVerifier().verifyYaml(configuration.getYamlObject(), jsonObject, factory.getVerifier());
		} catch (YAMLUtilsException e) {
            LOG.info(e);
			errorMessage = e.getMessage();
		}
		return new YAMLUtilsResult(result, errorMessage);
	}

	public boolean verifyYaml(Object yamlVerifyObject, Object currentJsonObject, YAMLUtilsVerifierDefault verifier) throws YAMLUtilsException {
		factory = new YAMLUtilsVerifierFactory();
		try{
			if (yamlVerifyObject instanceof Map) {
				return verifier.verifyYamlMap((Map) yamlVerifyObject, (Map) currentJsonObject, factory.getVerifier((Map) yamlVerifyObject));
			} else if (yamlVerifyObject instanceof String) {
				return verifier.verifyYamlString((String) yamlVerifyObject, currentJsonObject, verifier);
			} else if (yamlVerifyObject instanceof List) {
				return verifier.verifyYamlList((List) yamlVerifyObject, (List) currentJsonObject, verifier);
			} else if (yamlVerifyObject instanceof Integer) {
				return verifyYamlInt((Integer) yamlVerifyObject, currentJsonObject);
			}
		} catch (NullPointerException | IndexOutOfBoundsException | NumberFormatException aEx){
			throw new YAMLUtilsException(String.format("yamlVerifyObject: %s, currentJsonObject: %s, exception: %s, message: %s"
					, yamlVerifyObject.toString(), currentJsonObject.toString(), aEx.getClass().getSimpleName(), aEx.getMessage()));
		}
		return true;
	}

	protected boolean verifyYamlInt(Integer yamlVerifyObject, Object currentJsonObject) throws YAMLUtilsException {
		if (yamlVerifyObject.intValue() != Integer.parseInt(currentJsonObject.toString())) {
			throw new YAMLUtilsException("int dont match. Expected <" + yamlVerifyObject + "> was <" + Integer.valueOf(currentJsonObject.toString()) + ">");
		}
		return true;
	}

	protected boolean verifyYamlList(List yaml, List json, YAMLUtilsVerifierDefault verifier) throws YAMLUtilsException {
		for (int i = 0; i < yaml.size(); i++) {
			if (!verifyYaml(yaml.get(i), json.get(i), verifier)) {
				return false;
			}
		}
		return true;
	}

	protected boolean verifyYamlMap(Map yaml, Map json, YAMLUtilsVerifierDefault verifier) throws YAMLUtilsException {
        for (Object entry: yaml.entrySet()) {
            if(json==null) throw new YAMLUtilsException("Json is null on:"+entry);
            Object jsonValue = json.get(((Map.Entry) entry).getKey());
			Object yamlValue = yaml.get(((Map.Entry) entry).getKey());
            if (!verifyYaml(yamlValue, jsonValue, verifier)) {
                return false;
            }
        }
        return true;
	}

	protected boolean verifyYamlString(String yaml, Object json, YAMLUtilsVerifierDefault verifier) throws YAMLUtilsException {
		LOG.info(verifier);
		if (json.toString().matches(yaml)) {
			return true;
		} else {
			throw new YAMLUtilsException("String dont match. Expected <" + yaml + "> was <" + json + ">");
		}
	}
}
