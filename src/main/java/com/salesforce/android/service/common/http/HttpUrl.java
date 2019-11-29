package com.salesforce.android.service.common.http;

import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Set;

public interface HttpUrl {
    String encodedFragment();

    String encodedPassword();

    String encodedPath();

    List<String> encodedPathSegments();

    String encodedQuery();

    String encodedUsername();

    String fragment();

    String host();

    boolean isHttps();

    HttpUrlBuilder newBuilder();

    HttpUrlBuilder newBuilder(String str);

    String password();

    List<String> pathSegments();

    int pathSize();

    int port();

    String query();

    String queryParameter(String str);

    String queryParameterName(int i);

    Set<String> queryParameterNames();

    String queryParameterValue(int i);

    List<String> queryParameterValues(String str);

    int querySize();

    HttpUrl resolve(String str);

    String scheme();

    okhttp3.HttpUrl toOkHttpUrl();

    URI uri();

    URL url();

    String username();
}
