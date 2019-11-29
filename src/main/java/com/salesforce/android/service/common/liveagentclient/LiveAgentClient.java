package com.salesforce.android.service.common.liveagentclient;

import com.google.a.f;
import com.google.a.g;
import com.salesforce.android.service.common.http.HttpClient;
import com.salesforce.android.service.common.http.HttpClientBuilder;
import com.salesforce.android.service.common.http.HttpFactory;
import com.salesforce.android.service.common.http.HttpJob;
import com.salesforce.android.service.common.http.HttpRequest;
import com.salesforce.android.service.common.http.HttpResponseParseJob;
import com.salesforce.android.service.common.http.HttpResponseParseResult;
import com.salesforce.android.service.common.http.HttpSendJob;
import com.salesforce.android.service.common.http.TlsSocketFactory;
import com.salesforce.android.service.common.liveagentclient.json.GsonFactory;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.JobQueue;
import com.salesforce.android.service.common.utilities.threading.PriorityThreadFactory;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionSpec;
import okhttp3.Interceptor;
import okhttp3.TlsVersion;

public class LiveAgentClient {
    private static final int NUMBER_OF_CONCURRENT_REQUESTS = 2;
    private static final ServiceLogger log = ServiceLogging.getLogger(LiveAgentClient.class);
    private final f mGson;
    private final HttpClient mHttpClient;
    private final JobQueue mJobQueue;
    String mLiveAgentPod;

    protected LiveAgentClient(Builder builder) {
        log.trace("Initializing LiveAgentClient for pod {}", builder.mLiveAgentPod);
        this.mLiveAgentPod = builder.mLiveAgentPod;
        this.mHttpClient = builder.mHttpClient;
        this.mJobQueue = builder.mJobQueue;
        this.mGson = builder.mGson;
    }

    public void setLiveAgentPod(String str) {
        log.trace("Updating LiveAgentClient pod: {} --> {}", this.mLiveAgentPod, str);
        this.mLiveAgentPod = str;
    }

    public <T> Async<T> send(LiveAgentRequest liveAgentRequest, Class<T> cls) {
        return sendUsingHttpClient(liveAgentRequest, cls, this.mHttpClient, 0);
    }

    public <T> Async<T> send(LiveAgentRequest liveAgentRequest, Class<T> cls, int i) {
        return sendUsingHttpClient(liveAgentRequest, cls, this.mHttpClient, i);
    }

    public <T> Async<T> send(LiveAgentRequest liveAgentRequest, Class<T> cls, long j) {
        return sendUsingHttpClient(liveAgentRequest, cls, this.mHttpClient.newBuilder().readTimeout(j, TimeUnit.MILLISECONDS).build(), 0);
    }

    public <T> Async<T> send(LiveAgentRequest liveAgentRequest, Class<T> cls, long j, int i) {
        return sendUsingHttpClient(liveAgentRequest, cls, this.mHttpClient.newBuilder().readTimeout(j, TimeUnit.MILLISECONDS).build(), i);
    }

    public <T> Async<HttpResponseParseResult<T>> sendAndGetResponse(LiveAgentRequest liveAgentRequest, Class<T> cls) {
        return sendAndGetResponse(liveAgentRequest, cls, this.mHttpClient, 0);
    }

    public <T> Async<HttpResponseParseResult<T>> sendAndGetResponse(LiveAgentRequest liveAgentRequest, Class<T> cls, long j) {
        return sendAndGetResponse(liveAgentRequest, cls, this.mHttpClient.newBuilder().readTimeout(j, TimeUnit.MILLISECONDS).build(), 0);
    }

    /* access modifiers changed from: package-private */
    public <T> Async<T> sendUsingHttpClient(LiveAgentRequest liveAgentRequest, Class<T> cls, HttpClient httpClient, int i) {
        return this.mJobQueue.add(HttpJob.create(httpClient, createRequest(liveAgentRequest, cls, httpClient, i), cls, this.mGson));
    }

    /* access modifiers changed from: package-private */
    public <T> Async<HttpResponseParseResult<T>> sendAndGetResponse(LiveAgentRequest liveAgentRequest, Class<T> cls, HttpClient httpClient, int i) {
        return this.mJobQueue.add(HttpSendJob.create(httpClient, createRequest(liveAgentRequest, cls, httpClient, i))).chain(HttpResponseParseJob.handleResponse(this.mJobQueue, cls, this.mGson));
    }

    /* access modifiers changed from: package-private */
    public <T> HttpRequest createRequest(LiveAgentRequest liveAgentRequest, Class<T> cls, HttpClient httpClient, int i) {
        if (i > 0) {
            log.trace("Sending #{} {} to LiveAgent: URL[{}] - Body[{}]", Integer.valueOf(i), liveAgentRequest.getClass().getSimpleName(), liveAgentRequest.getUrl(this.mLiveAgentPod), liveAgentRequest.toJson(this.mGson));
        } else {
            log.trace("Sending {} to LiveAgent: URL[{}] - Body[{}]", liveAgentRequest.getClass().getSimpleName(), liveAgentRequest.getUrl(this.mLiveAgentPod), liveAgentRequest.toJson(this.mGson));
        }
        return liveAgentRequest.build(this.mLiveAgentPod, this.mGson, i);
    }

    public static class Builder {
        protected f mGson;
        private g mGsonBuilder;
        protected HttpClient mHttpClient;
        private Interceptor[] mInterceptors;
        protected JobQueue mJobQueue;
        private LiveAgentMessageRegistry mLiveAgentMessageRegistry;
        protected String mLiveAgentPod;
        private boolean mOmitEmptyArraysOnSend = false;

        public Builder liveAgentPod(String str) {
            this.mLiveAgentPod = str;
            return this;
        }

        public Builder jobQueue(JobQueue jobQueue) {
            this.mJobQueue = jobQueue;
            return this;
        }

        public Builder httpClient(HttpClient httpClient) {
            this.mHttpClient = httpClient;
            return this;
        }

        public Builder gsonBuilder(g gVar) {
            this.mGsonBuilder = gVar;
            return this;
        }

        public Builder liveAgentMessageRegistry(LiveAgentMessageRegistry liveAgentMessageRegistry) {
            this.mLiveAgentMessageRegistry = liveAgentMessageRegistry;
            return this;
        }

        public Builder omitEmptyArraysOnSend(boolean z) {
            this.mOmitEmptyArraysOnSend = z;
            return this;
        }

        public Builder interceptors(Interceptor... interceptorArr) {
            this.mInterceptors = interceptorArr;
            return this;
        }

        public LiveAgentClient build() throws NoSuchAlgorithmException, KeyManagementException {
            Arguments.checkValidLiveAgentPod(this.mLiveAgentPod);
            if (this.mJobQueue == null) {
                this.mJobQueue = new JobQueue(Executors.newFixedThreadPool(2, PriorityThreadFactory.background()));
            }
            if (this.mHttpClient == null) {
                this.mHttpClient = HttpFactory.client().connectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).tlsVersions(TlsVersion.TLS_1_2).build(), ConnectionSpec.CLEARTEXT})).sslSocketFactory(new TlsSocketFactory(), TlsSocketFactory.systemDefaultTrustManager()).build();
            }
            if (this.mInterceptors != null) {
                HttpClientBuilder newBuilder = this.mHttpClient.newBuilder();
                for (Interceptor addInterceptor : this.mInterceptors) {
                    newBuilder.addInterceptor(addInterceptor);
                }
                this.mHttpClient = newBuilder.build();
            }
            if (this.mLiveAgentMessageRegistry == null) {
                this.mLiveAgentMessageRegistry = new LiveAgentMessageRegistry();
            }
            if (this.mGsonBuilder == null) {
                this.mGsonBuilder = new g();
            }
            this.mGson = GsonFactory.createGson(this.mGsonBuilder, this.mLiveAgentMessageRegistry, this.mOmitEmptyArraysOnSend);
            return new LiveAgentClient(this);
        }
    }
}
