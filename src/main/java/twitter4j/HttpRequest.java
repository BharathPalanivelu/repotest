package twitter4j;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import twitter4j.auth.Authorization;

public final class HttpRequest implements Serializable {
    private static final HttpParameter[] NULL_PARAMETERS = new HttpParameter[0];
    private static final long serialVersionUID = 3365496352032493020L;
    private final Authorization authorization;
    private final RequestMethod method;
    private final HttpParameter[] parameters;
    private final Map<String, String> requestHeaders;
    private final String url;

    public HttpRequest(RequestMethod requestMethod, String str, HttpParameter[] httpParameterArr, Authorization authorization2, Map<String, String> map) {
        this.method = requestMethod;
        if (requestMethod == RequestMethod.POST || httpParameterArr == null || httpParameterArr.length == 0) {
            this.url = str;
            this.parameters = httpParameterArr;
        } else {
            this.url = str + "?" + HttpParameter.encodeParameters(httpParameterArr);
            this.parameters = NULL_PARAMETERS;
        }
        this.authorization = authorization2;
        this.requestHeaders = map;
    }

    public RequestMethod getMethod() {
        return this.method;
    }

    public HttpParameter[] getParameters() {
        return this.parameters;
    }

    public String getURL() {
        return this.url;
    }

    public Authorization getAuthorization() {
        return this.authorization;
    }

    public Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HttpRequest httpRequest = (HttpRequest) obj;
        Authorization authorization2 = this.authorization;
        if (authorization2 == null ? httpRequest.authorization != null : !authorization2.equals(httpRequest.authorization)) {
            return false;
        }
        if (!Arrays.equals(this.parameters, httpRequest.parameters)) {
            return false;
        }
        Map<String, String> map = this.requestHeaders;
        if (map == null ? httpRequest.requestHeaders != null : !map.equals(httpRequest.requestHeaders)) {
            return false;
        }
        RequestMethod requestMethod = this.method;
        if (requestMethod == null ? httpRequest.method != null : !requestMethod.equals(httpRequest.method)) {
            return false;
        }
        String str = this.url;
        return str == null ? httpRequest.url == null : str.equals(httpRequest.url);
    }

    public int hashCode() {
        RequestMethod requestMethod = this.method;
        int i = 0;
        int hashCode = (requestMethod != null ? requestMethod.hashCode() : 0) * 31;
        String str = this.url;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        HttpParameter[] httpParameterArr = this.parameters;
        int hashCode3 = (hashCode2 + (httpParameterArr != null ? Arrays.hashCode(httpParameterArr) : 0)) * 31;
        Authorization authorization2 = this.authorization;
        int hashCode4 = (hashCode3 + (authorization2 != null ? authorization2.hashCode() : 0)) * 31;
        Map<String, String> map = this.requestHeaders;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        List list;
        StringBuilder sb = new StringBuilder();
        sb.append("HttpRequest{requestMethod=");
        sb.append(this.method);
        sb.append(", url='");
        sb.append(this.url);
        sb.append('\'');
        sb.append(", postParams=");
        HttpParameter[] httpParameterArr = this.parameters;
        if (httpParameterArr == null) {
            list = null;
        } else {
            list = Arrays.asList(httpParameterArr);
        }
        sb.append(list);
        sb.append(", authentication=");
        sb.append(this.authorization);
        sb.append(", requestHeaders=");
        sb.append(this.requestHeaders);
        sb.append('}');
        return sb.toString();
    }
}
