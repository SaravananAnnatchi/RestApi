package rest.verification;

import java.util.Map;


public class YAMLUtilsVerifierFactory {

    private YAMLUtilsVerifierDefault verifier = null;

    public YAMLUtilsVerifierDefault getVerifier(Map yaml) {
        if (yaml.containsKey("TEST_CONFIG")) {
            switch (yaml.get("TEST_CONFIG").toString()) {
                case YAMLUtilsVerifierExactCount.TEST_CONFIG_NAME:
                    verifier = new YAMLUtilsVerifierExactCount();
                    break;
                default:break;
            }
        }
        return getVerifier();
    }

	public YAMLUtilsVerifierDefault getVerifier() {
        if (verifier == null) {
            this.verifier = new YAMLUtilsVerifierDefault();
        }
        return verifier;
    }

}
