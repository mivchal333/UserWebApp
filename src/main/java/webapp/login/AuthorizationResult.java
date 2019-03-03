package webapp.login;

public class AuthorizationResult {
    private String value;
    private AuthorizationResultType type;

    public AuthorizationResult(String value, AuthorizationResultType type) {
        this.value = value;
        this.type = type;
    }

    public AuthorizationResult() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public AuthorizationResultType getType() {
        return type;
    }

    public void setType(AuthorizationResultType type) {
        this.type = type;
    }
}
