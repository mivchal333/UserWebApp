package webapp.util;

public class ValidateResult {
    private String value;
    private ValidateResultType type;

    public ValidateResult(String value, ValidateResultType type) {
        this.value = value;
        this.type = type;
    }

    public ValidateResult() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ValidateResultType getType() {
        return type;
    }

    public void setType(ValidateResultType type) {
        this.type = type;
    }
}
