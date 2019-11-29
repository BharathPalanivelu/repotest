package com.tencent.qcloud.core.http;

import com.tencent.qcloud.core.auth.QCloudCredentialProvider;
import com.tencent.qcloud.core.http.HttpConstants;
import com.tencent.qcloud.core.http.HttpLoggingInterceptor;
import com.tencent.qcloud.core.logger.QCloudLogger;
import com.tencent.qcloud.core.task.QCloudTask;
import com.tencent.qcloud.core.task.RetryStrategy;
import com.tencent.qcloud.core.task.TaskManager;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public final class QCloudHttpClient {
    static final String HTTP_LOG_TAG = "QCloudHttp";
    private static volatile QCloudHttpClient gDefault;
    /* access modifiers changed from: private */
    public final Map<String, List<InetAddress>> dnsMap;
    private final HttpLoggingInterceptor logInterceptor;
    private Dns mDns;
    private HostnameVerifier mHostnameVerifier;
    private final OkHttpClient okHttpClient;
    private final TaskManager taskManager;
    /* access modifiers changed from: private */
    public final Set<String> verifiedHost;

    public static QCloudHttpClient getDefault() {
        if (gDefault == null) {
            synchronized (QCloudHttpClient.class) {
                if (gDefault == null) {
                    gDefault = new Builder().build();
                }
            }
        }
        return gDefault;
    }

    public void addVerifiedHost(String str) {
        if (str != null) {
            this.verifiedHost.add(str);
        }
    }

    public void addDnsRecord(String str, String[] strArr) throws UnknownHostException {
        if (strArr.length > 0) {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String byName : strArr) {
                arrayList.add(InetAddress.getByName(byName));
            }
            this.dnsMap.put(str, arrayList);
        }
    }

    public void setDebuggable(boolean z) {
        this.logInterceptor.setLevel((z || QCloudLogger.isLoggableOnLogcat(3, HTTP_LOG_TAG)) ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
    }

    private QCloudHttpClient(Builder builder) {
        this.mHostnameVerifier = new HostnameVerifier() {
            public boolean verify(String str, SSLSession sSLSession) {
                if (QCloudHttpClient.this.verifiedHost.size() > 0) {
                    for (String verify : QCloudHttpClient.this.verifiedHost) {
                        if (HttpsURLConnection.getDefaultHostnameVerifier().verify(verify, sSLSession)) {
                            return true;
                        }
                    }
                }
                return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
            }
        };
        this.mDns = new Dns() {
            public List<InetAddress> lookup(String str) throws UnknownHostException {
                if (QCloudHttpClient.this.dnsMap.containsKey(str)) {
                    return (List) QCloudHttpClient.this.dnsMap.get(str);
                }
                return Dns.SYSTEM.lookup(str);
            }
        };
        this.verifiedHost = new HashSet(5);
        this.dnsMap = new HashMap(3);
        this.taskManager = TaskManager.getInstance();
        this.logInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            public void log(String str) {
                QCloudLogger.i(QCloudHttpClient.HTTP_LOG_TAG, str, new Object[0]);
            }
        });
        setDebuggable(false);
        this.okHttpClient = builder.mBuilder.followRedirects(true).followSslRedirects(true).hostnameVerifier(this.mHostnameVerifier).dns(this.mDns).connectTimeout((long) builder.connectionTimeout, TimeUnit.MILLISECONDS).readTimeout((long) builder.socketTimeout, TimeUnit.MILLISECONDS).writeTimeout((long) builder.socketTimeout, TimeUnit.MILLISECONDS).addInterceptor(this.logInterceptor).addInterceptor(new RetryAndTrafficControlInterceptor(builder.retryStrategy)).build();
    }

    public List<HttpTask> getTasksByTag(String str) {
        ArrayList arrayList = new ArrayList();
        if (str == null) {
            return arrayList;
        }
        for (QCloudTask next : this.taskManager.snapshot()) {
            if ((next instanceof HttpTask) && str.equals(next.getTag())) {
                arrayList.add((HttpTask) next);
            }
        }
        return arrayList;
    }

    public <T> HttpTask<T> resolveRequest(HttpRequest<T> httpRequest) {
        return handleRequest(httpRequest, (QCloudCredentialProvider) null);
    }

    public <T> HttpTask<T> resolveRequest(QCloudHttpRequest<T> qCloudHttpRequest, QCloudCredentialProvider qCloudCredentialProvider) {
        return handleRequest(qCloudHttpRequest, qCloudCredentialProvider);
    }

    /* access modifiers changed from: package-private */
    public Call getOkHttpCall(Request request) {
        return this.okHttpClient.newCall(request);
    }

    private <T> HttpTask<T> handleRequest(HttpRequest<T> httpRequest, QCloudCredentialProvider qCloudCredentialProvider) {
        httpRequest.addHeader(HttpConstants.Header.HOST, httpRequest.host());
        return new HttpTask<>(httpRequest, qCloudCredentialProvider, this);
    }

    public static final class Builder {
        int connectionTimeout = 15000;
        OkHttpClient.Builder mBuilder;
        RetryStrategy retryStrategy;
        int socketTimeout = 30000;

        public Builder setConnectionTimeout(int i) {
            if (i >= 10000) {
                this.connectionTimeout = i;
                return this;
            }
            throw new IllegalArgumentException("connection timeout must be larger than 10 seconds.");
        }

        public Builder setSocketTimeout(int i) {
            if (i >= 10000) {
                this.socketTimeout = i;
                return this;
            }
            throw new IllegalArgumentException("socket timeout must be larger than 10 seconds.");
        }

        public Builder setRetryStrategy(RetryStrategy retryStrategy2) {
            this.retryStrategy = retryStrategy2;
            return this;
        }

        public Builder setInheritBuilder(OkHttpClient.Builder builder) {
            this.mBuilder = builder;
            return this;
        }

        public QCloudHttpClient build() {
            if (this.retryStrategy == null) {
                this.retryStrategy = RetryStrategy.DEFAULT;
            }
            if (this.mBuilder == null) {
                this.mBuilder = new OkHttpClient.Builder();
            }
            return new QCloudHttpClient(this);
        }
    }
}
