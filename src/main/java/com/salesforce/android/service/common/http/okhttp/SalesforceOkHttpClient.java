package com.salesforce.android.service.common.http.okhttp;

import com.salesforce.android.service.common.http.HttpCall;
import com.salesforce.android.service.common.http.HttpClient;
import com.salesforce.android.service.common.http.HttpClientBuilder;
import com.salesforce.android.service.common.http.HttpRequest;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Authenticator;
import okhttp3.Cache;
import okhttp3.CertificatePinner;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.CookieJar;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;

public class SalesforceOkHttpClient implements HttpClient {
    protected final OkHttpClient mOkHttpClient;

    public static HttpClient wrap(OkHttpClient okHttpClient) {
        return new SalesforceOkHttpClient(okHttpClient);
    }

    public static HttpClientBuilder builder() {
        return new Builder();
    }

    SalesforceOkHttpClient(OkHttpClient okHttpClient) {
        this.mOkHttpClient = okHttpClient;
    }

    public Authenticator authenticator() {
        return this.mOkHttpClient.authenticator();
    }

    public int connectTimeoutMillis() {
        return this.mOkHttpClient.connectTimeoutMillis();
    }

    public int readTimeoutMillis() {
        return this.mOkHttpClient.readTimeoutMillis();
    }

    public int writeTimeoutMillis() {
        return this.mOkHttpClient.writeTimeoutMillis();
    }

    public Proxy proxy() {
        return this.mOkHttpClient.proxy();
    }

    public ProxySelector proxySelector() {
        return this.mOkHttpClient.proxySelector();
    }

    public CookieJar cookieJar() {
        return this.mOkHttpClient.cookieJar();
    }

    public Cache cache() {
        return this.mOkHttpClient.cache();
    }

    public Dns dns() {
        return this.mOkHttpClient.dns();
    }

    public SocketFactory socketFactory() {
        return this.mOkHttpClient.socketFactory();
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.mOkHttpClient.sslSocketFactory();
    }

    public HostnameVerifier hostnameVerifier() {
        return this.mOkHttpClient.hostnameVerifier();
    }

    public CertificatePinner certificatePinner() {
        return this.mOkHttpClient.certificatePinner();
    }

    public Authenticator proxyAuthenticator() {
        return this.mOkHttpClient.proxyAuthenticator();
    }

    public ConnectionPool connectionPool() {
        return this.mOkHttpClient.connectionPool();
    }

    public boolean followSslRedirects() {
        return this.mOkHttpClient.followSslRedirects();
    }

    public boolean followRedirects() {
        return this.mOkHttpClient.followRedirects();
    }

    public boolean retryOnConnectionFailure() {
        return this.mOkHttpClient.retryOnConnectionFailure();
    }

    public Dispatcher dispatcher() {
        return this.mOkHttpClient.dispatcher();
    }

    public List<Protocol> protocols() {
        return this.mOkHttpClient.protocols();
    }

    public List<ConnectionSpec> connectionSpecs() {
        return this.mOkHttpClient.connectionSpecs();
    }

    public List<Interceptor> interceptors() {
        return this.mOkHttpClient.interceptors();
    }

    public List<Interceptor> networkInterceptors() {
        return this.mOkHttpClient.networkInterceptors();
    }

    public HttpCall newCall(HttpRequest httpRequest) {
        return SalesforceHttpCall.wrap(this.mOkHttpClient.newCall(httpRequest.toOkHttpRequest()));
    }

    public HttpClientBuilder newBuilder() {
        return new Builder(this);
    }

    public static class Builder implements HttpClientBuilder {
        protected final OkHttpClient.Builder mOkHttpClientBuilder;

        public Builder() {
            this.mOkHttpClientBuilder = new OkHttpClient.Builder();
        }

        protected Builder(SalesforceOkHttpClient salesforceOkHttpClient) {
            this.mOkHttpClientBuilder = salesforceOkHttpClient.mOkHttpClient.newBuilder();
        }

        public HttpClientBuilder addInterceptor(Interceptor interceptor) {
            this.mOkHttpClientBuilder.addInterceptor(interceptor);
            return this;
        }

        public HttpClientBuilder connectTimeout(long j, TimeUnit timeUnit) {
            this.mOkHttpClientBuilder.connectTimeout(j, timeUnit);
            return this;
        }

        public HttpClientBuilder readTimeout(long j, TimeUnit timeUnit) {
            this.mOkHttpClientBuilder.readTimeout(j, timeUnit);
            return this;
        }

        public HttpClientBuilder writeTimeout(long j, TimeUnit timeUnit) {
            this.mOkHttpClientBuilder.writeTimeout(j, timeUnit);
            return this;
        }

        public HttpClientBuilder proxy(Proxy proxy) {
            this.mOkHttpClientBuilder.proxy(proxy);
            return this;
        }

        public HttpClientBuilder proxySelector(ProxySelector proxySelector) {
            this.mOkHttpClientBuilder.proxySelector(proxySelector);
            return this;
        }

        public HttpClientBuilder cookieJar(CookieJar cookieJar) {
            this.mOkHttpClientBuilder.cookieJar(cookieJar);
            return this;
        }

        public HttpClientBuilder cache(Cache cache) {
            this.mOkHttpClientBuilder.cache(cache);
            return this;
        }

        public HttpClientBuilder dns(Dns dns) {
            this.mOkHttpClientBuilder.dns(dns);
            return this;
        }

        public HttpClientBuilder socketFactory(SocketFactory socketFactory) {
            this.mOkHttpClientBuilder.socketFactory(socketFactory);
            return this;
        }

        public HttpClientBuilder sslSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            this.mOkHttpClientBuilder.sslSocketFactory(sSLSocketFactory, x509TrustManager);
            return this;
        }

        public HttpClientBuilder hostnameVerifier(HostnameVerifier hostnameVerifier) {
            this.mOkHttpClientBuilder.hostnameVerifier(hostnameVerifier);
            return this;
        }

        public HttpClientBuilder certificatePinner(CertificatePinner certificatePinner) {
            this.mOkHttpClientBuilder.certificatePinner(certificatePinner);
            return this;
        }

        public HttpClientBuilder authenticator(Authenticator authenticator) {
            this.mOkHttpClientBuilder.authenticator(authenticator);
            return this;
        }

        public HttpClientBuilder proxyAuthenticator(Authenticator authenticator) {
            this.mOkHttpClientBuilder.proxyAuthenticator(authenticator);
            return this;
        }

        public HttpClientBuilder connectionPool(ConnectionPool connectionPool) {
            this.mOkHttpClientBuilder.connectionPool(connectionPool);
            return this;
        }

        public HttpClientBuilder followSslRedirects(boolean z) {
            this.mOkHttpClientBuilder.followSslRedirects(z);
            return this;
        }

        public HttpClientBuilder followRedirects(boolean z) {
            this.mOkHttpClientBuilder.followRedirects(z);
            return this;
        }

        public HttpClientBuilder retryOnConnectionFailure(boolean z) {
            this.mOkHttpClientBuilder.retryOnConnectionFailure(z);
            return this;
        }

        public HttpClientBuilder dispatcher(Dispatcher dispatcher) {
            this.mOkHttpClientBuilder.dispatcher(dispatcher);
            return this;
        }

        public HttpClientBuilder protocols(List<Protocol> list) {
            this.mOkHttpClientBuilder.protocols(list);
            return this;
        }

        public HttpClientBuilder connectionSpecs(List<ConnectionSpec> list) {
            this.mOkHttpClientBuilder.connectionSpecs(list);
            return this;
        }

        public List<Interceptor> interceptors() {
            return this.mOkHttpClientBuilder.interceptors();
        }

        public List<Interceptor> networkInterceptors() {
            return this.mOkHttpClientBuilder.networkInterceptors();
        }

        public HttpClientBuilder addNetworkInterceptor(Interceptor interceptor) {
            this.mOkHttpClientBuilder.addNetworkInterceptor(interceptor);
            return this;
        }

        public HttpClient build() {
            return new SalesforceOkHttpClient(this.mOkHttpClientBuilder.build());
        }
    }
}
