package com.salesforce.android.service.common.http;

import com.google.a.f;
import com.google.a.g;
import com.google.a.u;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.ResultReceiver;
import com.salesforce.android.service.common.utilities.functional.Function;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.Job;
import com.salesforce.android.service.common.utilities.threading.JobQueue;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.io.IOException;

public class HttpResponseParseJob<T> implements Job<HttpResponseParseResult<T>> {
    private static final ServiceLogger log = ServiceLogging.getLogger(HttpResponseParseJob.class);
    final f mGson;
    final HttpResponse mHttpResponse;
    final Class<T> mResponseClass;

    public static <T> Function<HttpResponse, Async<HttpResponseParseResult<T>>> handleResponse(final JobQueue jobQueue, final Class<T> cls, final f fVar) {
        return new Function<HttpResponse, Async<HttpResponseParseResult<T>>>() {
            public Async<HttpResponseParseResult<T>> apply(HttpResponse httpResponse) {
                return jobQueue.add(HttpResponseParseJob.create(httpResponse, cls, fVar));
            }
        };
    }

    public static <T> HttpResponseParseJob<T> create(HttpResponse httpResponse, Class<T> cls, f fVar) {
        return new Builder().httpResponse(httpResponse).responseClass(cls).gson(fVar).build();
    }

    protected HttpResponseParseJob(Builder<T> builder) {
        this.mHttpResponse = builder.mHttpResponse;
        this.mResponseClass = builder.mResponseClass;
        this.mGson = builder.mGson;
    }

    public void execute(ResultReceiver<HttpResponseParseResult<T>> resultReceiver) {
        log.trace("Parsing http response to {}", this.mResponseClass.getSimpleName());
        try {
            String readResponseBody = readResponseBody(this.mHttpResponse.body());
            log.trace("Parsed http response: {}", readResponseBody);
            resultReceiver.setResult(new HttpResponseParseResult(this.mHttpResponse.headers().toMultimap(), this.mHttpResponse.code(), this.mGson.a(readResponseBody, this.mResponseClass)));
            resultReceiver.complete();
        } catch (u e2) {
            ServiceLogger serviceLogger = log;
            serviceLogger.error("Invalid JSON syntax found in response body: " + e2);
            resultReceiver.setError(e2);
        } catch (Exception e3) {
            ServiceLogger serviceLogger2 = log;
            serviceLogger2.error("Unable to parse response body: " + e3);
            resultReceiver.setError(e3);
        }
    }

    private String readResponseBody(HttpResponseBody httpResponseBody) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int read = httpResponseBody.charStream().read();
            if (read != -1) {
                sb.append((char) read);
            } else {
                httpResponseBody.charStream().close();
                return sb.toString();
            }
        }
    }

    public static class Builder<T> {
        protected f mGson;
        protected HttpResponse mHttpResponse;
        protected Class<T> mResponseClass;

        public Builder<T> httpResponse(HttpResponse httpResponse) {
            this.mHttpResponse = httpResponse;
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

        public HttpResponseParseJob<T> build() {
            Arguments.checkNotNull(this.mHttpResponse);
            Arguments.checkNotNull(this.mResponseClass);
            if (this.mGson == null) {
                this.mGson = new g().d();
            }
            return new HttpResponseParseJob<>(this);
        }
    }
}
