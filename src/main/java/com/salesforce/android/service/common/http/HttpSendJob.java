package com.salesforce.android.service.common.http;

import com.salesforce.android.service.common.utilities.control.ResultReceiver;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.Job;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class HttpSendJob implements Job<HttpResponse> {
    private static final ServiceLogger log = ServiceLogging.getLogger(HttpSendJob.class);
    final HttpClient mHttpClient;
    final HttpRequest mHttpRequest;

    public static <T> HttpSendJob create(HttpClient httpClient, HttpRequest httpRequest) {
        return new Builder().httpClient(httpClient).httpRequest(httpRequest).build();
    }

    protected HttpSendJob(Builder builder) {
        this.mHttpClient = builder.mHttpClient;
        this.mHttpRequest = builder.mHttpRequest;
    }

    public void execute(ResultReceiver<HttpResponse> resultReceiver) {
        log.trace("Submitting HTTP {} request to {} with headers\n{}", this.mHttpRequest.method(), this.mHttpRequest.url(), this.mHttpRequest.headers());
        try {
            HttpResponse execute = this.mHttpClient.newCall(this.mHttpRequest).execute();
            if (execute.isSuccessful()) {
                log.trace("HTTP request successfully sent. Status code {}", Integer.valueOf(execute.code()));
                resultReceiver.setResult(execute);
                resultReceiver.complete();
                return;
            }
            log.warn("Unsuccessful HTTP request: {}\nResponse: {}", this.mHttpRequest.toString(), execute);
            resultReceiver.setError(new ResponseException("Unsuccessful HTTP request: " + this.mHttpRequest.toString(), execute.code(), execute.body().string()));
        } catch (Exception e2) {
            log.warn("Encountered Exception during HTTP request {}\nResponse: {}", e2, null);
            resultReceiver.setError(e2);
        }
    }

    public String getUrlString() {
        return this.mHttpRequest.url().toString();
    }

    public HttpRequest getHttpRequest() {
        return this.mHttpRequest;
    }

    public static class Builder {
        protected HttpClient mHttpClient;
        protected HttpRequest mHttpRequest;

        public Builder httpClient(HttpClient httpClient) {
            this.mHttpClient = httpClient;
            return this;
        }

        public Builder httpRequest(HttpRequest httpRequest) {
            this.mHttpRequest = httpRequest;
            return this;
        }

        public HttpSendJob build() {
            Arguments.checkNotNull(this.mHttpClient);
            Arguments.checkNotNull(this.mHttpRequest);
            return new HttpSendJob(this);
        }
    }
}
