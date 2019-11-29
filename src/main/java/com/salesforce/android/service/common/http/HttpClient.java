package com.salesforce.android.service.common.http;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
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

public interface HttpClient {
    Authenticator authenticator();

    Cache cache();

    CertificatePinner certificatePinner();

    int connectTimeoutMillis();

    ConnectionPool connectionPool();

    List<ConnectionSpec> connectionSpecs();

    CookieJar cookieJar();

    Dispatcher dispatcher();

    Dns dns();

    boolean followRedirects();

    boolean followSslRedirects();

    HostnameVerifier hostnameVerifier();

    List<Interceptor> interceptors();

    List<Interceptor> networkInterceptors();

    HttpClientBuilder newBuilder();

    HttpCall newCall(HttpRequest httpRequest);

    List<Protocol> protocols();

    Proxy proxy();

    Authenticator proxyAuthenticator();

    ProxySelector proxySelector();

    int readTimeoutMillis();

    boolean retryOnConnectionFailure();

    SocketFactory socketFactory();

    SSLSocketFactory sslSocketFactory();

    int writeTimeoutMillis();
}
