package rest.verification;

public class YAMLUtilsResult {

    private final boolean result;
    private final String message;

    public YAMLUtilsResult(boolean b, String errorMessage) {
        result = b;
        message = errorMessage;
    }

    public String getMessage() {
        return message;
    }

    public boolean getResult() {
        return result;
    }
}
