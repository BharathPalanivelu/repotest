package com.salesforce.android.service.common.http;

import com.google.a.f;
import com.google.a.g;
import com.salesforce.android.service.common.utilities.control.ResultReceiver;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.Job;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.io.IOException;

public class HttpJob<T> implements Job<T> {
    private static final ServiceLogger log = ServiceLogging.getLogger(HttpJob.class);
    final f mGson;
    final HttpClient mHttpClient;
    final HttpRequest mHttpRequest;
    final Class<T> mResponseClass;

    public static <T> HttpJob<T> create(HttpClient httpClient, HttpRequest httpRequest, Class<T> cls, f fVar) {
        return new Builder().httpClient(httpClient).httpRequest(httpRequest).responseClass(cls).gson(fVar).build();
    }

    protected HttpJob(Builder<T> builder) {
        this.mHttpClient = builder.mHttpClient;
        this.mHttpRequest = builder.mHttpRequest;
        this.mResponseClass = builder.mResponseClass;
        this.mGson = builder.mGson;
    }

    public void execute(ResultReceiver<T> resultReceiver) {
        log.trace("Submitting http request to {}", this.mHttpRequest.url());
        HttpResponse httpResponse = null;
        try {
            HttpResponse execute = this.mHttpClient.newCall(this.mHttpRequest).execute();
            if (execute.isSuccessful()) {
                resultReceiver.setResult(this.mGson.a(execute.body().charStream(), this.mResponseClass));
                resultReceiver.complete();
            } else {
                log.warn("Unsuccessful HTTP request: {}", execute.toString());
                resultReceiver.setError(new ResponseException("Unsuccessful HTTP request: " + execute.toString(), execute.code(), execute.body().string()));
            }
            if (execute != null) {
                try {
                    execute.close();
                } catch (IOException e2) {
                    log.warn("Unable to close HTTP response stream.\n{}", e2);
                }
            }
        } catch (Exception e3) {
            log.warn("Encountered Exception during HTTP request {}\nResponse: {}", e3, httpResponse);
            resultReceiver.setError(e3);
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e4) {
                    log.warn("Unable to close HTTP response stream.\n{}", e4);
                }
            }
        } catch (Throwable th) {
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e5) {
                    log.warn("Unable to close HTTP response stream.\n{}", e5);
                }
            }
            throw th;
        }
    }

    public String getUrlString() {
        return this.mHttpRequest.url().toString();
    }

    public HttpRequest getHttpRequest() {
        return this.mHttpRequest;
    }

    public static class Builder<T> {
        protected f mGson;
        protected HttpClient mHttpClient;
        protected HttpRequest mHttpRequest;
        protected Class<T> mResponseClass;

        public Builder<T> httpClient(HttpClient httpClient) {
            this.mHttpClient = httpClient;
            return this;
        }

        public Builder<T> httpRequest(HttpRequest httpRequest) {
            this.mHttpRequest = httpRequest;
            return this;
        }

        public Builder<T> responseClass(Class<T> cls) {
            this.mResponseClass = cls;
            return this;
        }

        public Builder<T> gson(f fVar) {
            this.mGson = fVar;
            return this;
        }

        public HttpJob<T> build() {
            Arguments.checkNotNull(this.mHttpClient);
            Arguments.checkNotNull(this.mHttpRequest);
            Arguments.checkNotNull(this.mResponseClass);
            if (this.mGson == null) {
                this.mGson = new g().d();
            }
            return new HttpJob<>(this);
        }
    }
}
