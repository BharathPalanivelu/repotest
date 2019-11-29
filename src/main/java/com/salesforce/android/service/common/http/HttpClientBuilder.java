package com.salesforce.android.service.common.http;

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
import okhttp3.Protocol;

public interface HttpClientBuilder {
    HttpClientBuilder addInterceptor(Interceptor interceptor);

    HttpClientBuilder addNetworkInterceptor(Interceptor interceptor);

    HttpClientBuilder authenticator(Authenticator authenticator);

    HttpClient build();

    HttpClientBuilder cache(Cache cache);

    HttpClientBuilder certificatePinner(CertificatePinner certificatePinner);

    HttpClientBuilder connectTimeout(long j, TimeUnit timeUnit);

    HttpClientBuilder connectionPool(ConnectionPool connectionPool);

    HttpClientBuilder connectionSpecs(List<ConnectionSpec> list);

    HttpClientBuilder cookieJar(CookieJar cookieJar);

    HttpClientBuilder dispatcher(Dispatcher dispatcher);

    HttpClientBuilder dns(Dns dns);

    HttpClientBuilder followRedirects(boolean z);

    HttpClientBuilder followSslRedirects(boolean z);

    HttpClientBuilder hostnameVerifier(HostnameVerifier hostnameVerifier);

    List<Interceptor> interceptors();

    List<Interceptor> networkInterceptors();

    HttpClientBuilder protocols(List<Protocol> list);

    HttpClientBuilder proxy(Proxy proxy);

    HttpClientBuilder proxyAuthenticator(Authenticator authenticator);

    HttpClientBuilder proxySelector(ProxySelector proxySelector);

    HttpClientBuilder readTimeout(long j, TimeUnit timeUnit);

    HttpClientBuilder retryOnConnectionFailure(boolean z);

    HttpClientBuilder socketFactory(SocketFactory socketFactory);

    HttpClientBuilder sslSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager);

    HttpClientBuilder writeTimeout(long j, TimeUnit timeUnit);
}
