package rest.verification;


import java.util.List;

public class YAMLUtilsVerifierExactCount extends YAMLUtilsVerifierDefault {

    public static final String TEST_CONFIG_NAME = "MATCH_EXCACT_COUNT";

    protected boolean verifyYamlList(List yaml, List json, YAMLUtilsVerifierDefault verifier) throws YAMLUtilsException {
        if (yaml.size() != json.size()) {
            throw new YAMLUtilsException("The list size wasn't the same expected <" + yaml.size() + "> got <" + json.size() + ">");
        }
        return super.verifyYamlList(yaml, json, verifier);
    }

    protected boolean verifyYamlString(String yaml, Object json, YAMLUtilsVerifierDefault verifier) throws YAMLUtilsException {
        return yaml.matches(TEST_CONFIG_NAME) || super.verifyYamlString(yaml, json, verifier);
    }
}
