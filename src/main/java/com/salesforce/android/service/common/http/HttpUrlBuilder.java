package com.salesforce.android.service.common.http;

import java.util.List;

public interface HttpUrlBuilder {
    HttpUrlBuilder addEncodedPathSegment(String str);

    HttpUrlBuilder addEncodedPathSegments(String str);

    HttpUrlBuilder addEncodedPathSegments(List<String> list);

    HttpUrlBuilder addEncodedQueryParameter(String str, String str2);

    HttpUrlBuilder addPathSegment(String str);

    HttpUrlBuilder addPathSegments(String str);

    HttpUrlBuilder addQueryParameter(String str, String str2);

    HttpUrl build();

    HttpUrlBuilder encodedFragment(String str);

    HttpUrlBuilder encodedPassword(String str);

    HttpUrlBuilder encodedPath(String str);

    HttpUrlBuilder encodedQuery(String str);

    HttpUrlBuilder encodedUsername(String str);

    HttpUrlBuilder fragment(String str);

    HttpUrlBuilder host(String str);

    HttpUrlBuilder parse(String str);

    HttpUrlBuilder password(String str);

    HttpUrlBuilder port(int i);

    HttpUrlBuilder query(String str);

    HttpUrlBuilder removeAllEncodedQueryParameters(String str);

    HttpUrlBuilder removeAllQueryParameters(String str);

    HttpUrlBuilder removePathSegment(int i);

    HttpUrlBuilder scheme(String str);

    HttpUrlBuilder setEncodedPathSegment(int i, String str);

    HttpUrlBuilder setEncodedQueryParameter(String str, String str2);

    HttpUrlBuilder setPathSegment(int i, String str);

    HttpUrlBuilder setQueryParameter(String str, String str2);

    HttpUrlBuilder username(String str);
}
