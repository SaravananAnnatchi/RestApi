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
import java.util.Map;

public class YAMLUtilsConfigDefault {
	private Template temp;
	private Map<String, String> map;
	private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(YAMLUtilsConfigDefault.class);

	public YAMLUtilsConfigDefault(String file) throws IOException {
		Configuration cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File(this.getClass().getResource("/").getPath()));
		temp = cfg.getTemplate(file, "UTF-8");
		map = new HashMap<String, String>();
	}

	public String getGeneratedYaml() throws TemplateException {
		StringWriter writer = new StringWriter();
		StringBuffer sb = writer.getBuffer();
		try{
			temp.process(map, writer);
		} catch(IOException e){
			LOG.info(e);
		}
		return sb.toString();
	}

	public Object getYamlObject() throws TemplateException {
		Yaml yaml = new Yaml();
		Iterator<Object> data = yaml.loadAll(getGeneratedYaml()).iterator();
		return data.next();
	}

	public void setMap(String key, String value) {
		map.put(key, value);
	}

	public void setOrigin(String origin) {
		map.put("origin", origin);
	}

	public void setLocale(String locale) {
		map.put("locale", locale);
	}

	public void setDeviceType(String deviceType) {
		map.put("deviceType", deviceType);
	}
}
