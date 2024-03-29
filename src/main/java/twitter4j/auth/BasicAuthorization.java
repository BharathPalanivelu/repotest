package twitter4j.auth;

import java.io.Serializable;
import twitter4j.BASE64Encoder;
import twitter4j.HttpRequest;

public class BasicAuthorization implements Serializable, Authorization {
    private static final long serialVersionUID = 7420629998989177351L;
    private final String basic = encodeBasicAuthenticationString();
    private final String password;
    private final String userId;

    public boolean isEnabled() {
        return true;
    }

    public BasicAuthorization(String str, String str2) {
        this.userId = str;
        this.password = str2;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getPassword() {
        return this.password;
    }

    private String encodeBasicAuthenticationString() {
        if (this.userId == null || this.password == null) {
            return null;
        }
        return "Basic " + BASE64Encoder.encode((this.userId + ":" + this.password).getBytes());
    }

    public String getAuthorizationHeader(HttpRequest httpRequest) {
        return this.basic;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BasicAuthorization)) {
            return false;
        }
        return this.basic.equals(((BasicAuthorization) obj).basic);
    }

    public int hashCode() {
        return this.basic.hashCode();
    }

    public String toString() {
        return "BasicAuthorization{userId='" + this.userId + '\'' + ", password='**********''" + '}';
    }
}
