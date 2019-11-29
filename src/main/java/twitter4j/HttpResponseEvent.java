package twitter4j;

public final class HttpResponseEvent {
    private final HttpRequest request;
    private final HttpResponse response;
    private final TwitterException twitterException;

    HttpResponseEvent(HttpRequest httpRequest, HttpResponse httpResponse, TwitterException twitterException2) {
        this.request = httpRequest;
        this.response = httpResponse;
        this.twitterException = twitterException2;
    }

    public HttpRequest getRequest() {
        return this.request;
    }

    public HttpResponse getResponse() {
        return this.response;
    }

    public TwitterException getTwitterException() {
        return this.twitterException;
    }

    public boolean isAuthenticated() {
        return this.request.getAuthorization().isEnabled();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HttpResponseEvent httpResponseEvent = (HttpResponseEvent) obj;
        HttpRequest httpRequest = this.request;
        if (httpRequest == null ? httpResponseEvent.request != null : !httpRequest.equals(httpResponseEvent.request)) {
            return false;
        }
        HttpResponse httpResponse = this.response;
        return httpResponse == null ? httpResponseEvent.response == null : httpResponse.equals(httpResponseEvent.response);
    }

    public int hashCode() {
        HttpRequest httpRequest = this.request;
        int i = 0;
        int hashCode = (httpRequest != null ? httpRequest.hashCode() : 0) * 31;
        HttpResponse httpResponse = this.response;
        if (httpResponse != null) {
            i = httpResponse.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "HttpResponseEvent{request=" + this.request + ", response=" + this.response + '}';
    }
}
