package com.salesforce.android.service.common.http.okhttp;

import com.salesforce.android.service.common.http.HttpUrl;
import com.salesforce.android.service.common.http.HttpUrlBuilder;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Set;
import okhttp3.HttpUrl;

public class SalesforceHttpUrl implements HttpUrl {
    private okhttp3.HttpUrl mHttpUrl;

    public static SalesforceHttpUrl parse(String str) {
        okhttp3.HttpUrl parse = okhttp3.HttpUrl.parse(str);
        if (parse != null) {
            return wrap(parse);
        }
        return null;
    }

    public static SalesforceHttpUrl wrap(okhttp3.HttpUrl httpUrl) {
        return new SalesforceHttpUrl(httpUrl);
    }

    protected SalesforceHttpUrl(okhttp3.HttpUrl httpUrl) {
        this.mHttpUrl = httpUrl;
    }

    public URL url() {
        return this.mHttpUrl.url();
    }

    public URI uri() {
        return this.mHttpUrl.uri();
    }

    public String scheme() {
        return this.mHttpUrl.scheme();
    }

    public boolean isHttps() {
        return this.mHttpUrl.isHttps();
    }

    public String encodedUsername() {
        return this.mHttpUrl.encodedUsername();
    }

    public String username() {
        return this.mHttpUrl.username();
    }

    public String encodedPassword() {
        return this.mHttpUrl.encodedPassword();
    }

    public String password() {
        return this.mHttpUrl.password();
    }

    public String host() {
        return this.mHttpUrl.host();
    }

    public int port() {
        return this.mHttpUrl.port();
    }

    public int pathSize() {
        return this.mHttpUrl.pathSize();
    }

    public String encodedPath() {
        return this.mHttpUrl.encodedPath();
    }

    public List<String> encodedPathSegments() {
        return this.mHttpUrl.encodedPathSegments();
    }

    public List<String> pathSegments() {
        return this.mHttpUrl.pathSegments();
    }

    public String encodedQuery() {
        return this.mHttpUrl.encodedQuery();
    }

    public String query() {
        return this.mHttpUrl.query();
    }

    public int querySize() {
        return this.mHttpUrl.querySize();
    }

    public String queryParameter(String str) {
        return this.mHttpUrl.queryParameter(str);
    }

    public Set<String> queryParameterNames() {
        return this.mHttpUrl.queryParameterNames();
    }

    public List<String> queryParameterValues(String str) {
        return this.mHttpUrl.queryParameterValues(str);
    }

    public String queryParameterName(int i) {
        return this.mHttpUrl.queryParameterName(i);
    }

    public String queryParameterValue(int i) {
        return this.mHttpUrl.queryParameterValue(i);
    }

    public String encodedFragment() {
        return this.mHttpUrl.encodedFragment();
    }

    public String fragment() {
        return this.mHttpUrl.fragment();
    }

    public HttpUrl resolve(String str) {
        return new SalesforceHttpUrl(this.mHttpUrl.resolve(str));
    }

    public okhttp3.HttpUrl toOkHttpUrl() {
        return this.mHttpUrl;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.scheme(scheme());
        builder.encodedUsername(encodedUsername());
        builder.encodedPassword(encodedPassword());
        builder.host(host());
        builder.port(port());
        builder.addEncodedPathSegments(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.encodedFragment(encodedFragment());
        return builder;
    }

    public Builder newBuilder(String str) {
        try {
            return new Builder(this.mHttpUrl.newBuilder(str));
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public String toString() {
        return this.mHttpUrl.toString();
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && this.mHttpUrl.equals(((HttpUrl) obj).toOkHttpUrl());
    }

    public int hashCode() {
        return this.mHttpUrl.hashCode();
    }

    public static class Builder implements HttpUrlBuilder {
        private HttpUrl.Builder mBuilder;

        public Builder() {
            this.mBuilder = new HttpUrl.Builder();
        }

        Builder(HttpUrl.Builder builder) {
            this.mBuilder = builder;
        }

        public HttpUrlBuilder parse(String str) {
            return SalesforceHttpUrl.wrap(okhttp3.HttpUrl.parse(str)).newBuilder();
        }

        public HttpUrlBuilder scheme(String str) {
            this.mBuilder.scheme(str);
            return this;
        }

        public HttpUrlBuilder username(String str) {
            this.mBuilder.username(str);
            return this;
        }

        public HttpUrlBuilder encodedUsername(String str) {
            this.mBuilder.encodedUsername(str);
            return this;
        }

        public HttpUrlBuilder password(String str) {
            this.mBuilder.password(str);
            return this;
        }

        public HttpUrlBuilder encodedPassword(String str) {
            this.mBuilder.encodedPassword(str);
            return this;
        }

        public HttpUrlBuilder host(String str) {
            this.mBuilder.host(str);
            return this;
        }

        public HttpUrlBuilder port(int i) {
            this.mBuilder.port(i);
            return this;
        }

        public HttpUrlBuilder addPathSegment(String str) {
            this.mBuilder.addPathSegment(str);
            return this;
        }

        public HttpUrlBuilder addPathSegments(String str) {
            this.mBuilder.addPathSegments(str);
            return this;
        }

        public HttpUrlBuilder addEncodedPathSegment(String str) {
            this.mBuilder.addEncodedPathSegment(str);
            return this;
        }

        public HttpUrlBuilder addEncodedPathSegments(String str) {
            this.mBuilder.addEncodedPathSegments(str);
            return this;
        }

        public HttpUrlBuilder addEncodedPathSegments(List<String> list) {
            for (String addEncodedPathSegment : list) {
                addEncodedPathSegment(addEncodedPathSegment);
            }
            return this;
        }

        public HttpUrlBuilder setPathSegment(int i, String str) {
            this.mBuilder.setPathSegment(i, str);
            return this;
        }

        public HttpUrlBuilder setEncodedPathSegment(int i, String str) {
            this.mBuilder.setEncodedPathSegment(i, str);
            return this;
        }

        public HttpUrlBuilder removePathSegment(int i) {
            this.mBuilder.removePathSegment(i);
            return this;
        }

        public HttpUrlBuilder encodedPath(String str) {
            this.mBuilder.encodedPath(str);
            return this;
        }

        public HttpUrlBuilder query(String str) {
            this.mBuilder.query(str);
            return this;
        }

        public HttpUrlBuilder encodedQuery(String str) {
            this.mBuilder.encodedQuery(str);
            return this;
        }

        public HttpUrlBuilder addQueryParameter(String str, String str2) {
            this.mBuilder.addQueryParameter(str, str2);
            return this;
        }

        public HttpUrlBuilder addEncodedQueryParameter(String str, String str2) {
            this.mBuilder.addEncodedQueryParameter(str, str2);
            return this;
        }

        public HttpUrlBuilder setQueryParameter(String str, String str2) {
            this.mBuilder.setQueryParameter(str, str2);
            return this;
        }

        public HttpUrlBuilder setEncodedQueryParameter(String str, String str2) {
            this.mBuilder.setEncodedQueryParameter(str, str2);
            return this;
        }

        public HttpUrlBuilder removeAllQueryParameters(String str) {
            this.mBuilder.removeAllQueryParameters(str);
            return this;
        }

        public HttpUrlBuilder removeAllEncodedQueryParameters(String str) {
            this.mBuilder.removeAllEncodedQueryParameters(str);
            return this;
        }

        public HttpUrlBuilder fragment(String str) {
            this.mBuilder.fragment(str);
            return this;
        }

        public HttpUrlBuilder encodedFragment(String str) {
            this.mBuilder.encodedFragment(str);
            return this;
        }

        public com.salesforce.android.service.common.http.HttpUrl build() {
            return new SalesforceHttpUrl(this.mBuilder.build());
        }
    }
}
