package com.tencent.qcloud.core.http;

import com.appsflyer.share.Constants;
import com.tencent.qcloud.core.auth.QCloudSignSourceProvider;
import com.tencent.qcloud.core.auth.QCloudSigner;
import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.http.HttpConstants;
import com.tencent.qcloud.core.util.QCloudStringUtils;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.CacheControl;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpRequest<T> {
    private final boolean calculateContentMD5;
    private final Map<String, List<String>> headers;
    private final String method;
    private final RequestBody requestBody;
    private final Request.Builder requestBuilder;
    private final ResponseBodyConverter<T> responseBodyConverter;
    private final Object tag;
    private final URL url;

    /* access modifiers changed from: package-private */
    public QCloudSigner getQCloudSigner() throws QCloudClientException {
        return null;
    }

    /* access modifiers changed from: package-private */
    public QCloudSignSourceProvider getSignProvider() {
        return null;
    }

    HttpRequest(Builder<T> builder) {
        this.requestBuilder = builder.requestBuilder;
        this.responseBodyConverter = builder.responseBodyConverter;
        this.headers = builder.headers;
        this.method = builder.method;
        this.calculateContentMD5 = builder.calculateContentMD5;
        if (builder.tag == null) {
            this.tag = toString();
        } else {
            this.tag = builder.tag;
        }
        this.url = builder.httpUrlBuilder.build().url();
        if (builder.requestBodySerializer != null) {
            this.requestBody = builder.requestBodySerializer.body();
        } else {
            this.requestBody = null;
        }
        this.requestBuilder.method(builder.method, this.requestBody);
    }

    public Map<String, List<String>> headers() {
        return this.headers;
    }

    public String header(String str) {
        List list = this.headers.get(str);
        if (list != null) {
            return (String) list.get(0);
        }
        return null;
    }

    public Object tag() {
        return this.tag;
    }

    /* access modifiers changed from: package-private */
    public void setOkHttpRequestTag(String str) {
        this.requestBuilder.tag(str);
    }

    public void addHeader(String str, String str2) {
        List list = this.headers.get(str);
        if (list == null || list.size() < 1) {
            this.requestBuilder.addHeader(str, str2);
            addHeaderNameValue(this.headers, str, str2);
        }
    }

    public void removeHeader(String str) {
        this.requestBuilder.removeHeader(str);
        this.headers.remove(str);
    }

    /* access modifiers changed from: package-private */
    public boolean shouldCalculateContentMD5() {
        return this.calculateContentMD5 && QCloudStringUtils.isEmpty(header(HttpConstants.Header.MD5));
    }

    public String method() {
        return this.method;
    }

    public String host() {
        return this.url.getHost();
    }

    public String contentType() {
        MediaType contentType = this.requestBody.contentType();
        if (contentType != null) {
            return contentType.toString();
        }
        return null;
    }

    public long contentLength() throws IOException {
        return this.requestBody.contentLength();
    }

    public URL url() {
        return this.url;
    }

    /* access modifiers changed from: package-private */
    public ResponseBodyConverter<T> getResponseBodyConverter() {
        return this.responseBodyConverter;
    }

    /* access modifiers changed from: package-private */
    public RequestBody getRequestBody() {
        return this.requestBody;
    }

    /* access modifiers changed from: package-private */
    public Request buildRealRequest() {
        return this.requestBuilder.build();
    }

    /* access modifiers changed from: private */
    public static void addHeaderNameValue(Map<String, List<String>> map, String str, String str2) {
        List list = map.get(str);
        if (list == null) {
            list = new ArrayList(2);
            map.put(str, list);
        }
        list.add(str2.trim());
    }

    public static class Builder<T> {
        boolean calculateContentMD5;
        Map<String, List<String>> headers = new HashMap(10);
        HttpUrl.Builder httpUrlBuilder = new HttpUrl.Builder();
        boolean isCacheEnabled = true;
        String method;
        RequestBodySerializer requestBodySerializer;
        Request.Builder requestBuilder = new Request.Builder();
        ResponseBodyConverter<T> responseBodyConverter;
        Object tag;

        public Builder<T> url(URL url) {
            HttpUrl httpUrl = HttpUrl.get(url);
            if (httpUrl != null) {
                this.httpUrlBuilder = httpUrl.newBuilder();
                return this;
            }
            throw new IllegalArgumentException("url is not legal : " + url);
        }

        public Builder<T> scheme(String str) {
            this.httpUrlBuilder.scheme(str);
            return this;
        }

        public Builder<T> tag(Object obj) {
            this.tag = obj;
            return this;
        }

        public Builder<T> host(String str) {
            this.httpUrlBuilder.host(str);
            return this;
        }

        public Builder<T> path(String str) {
            if (str.startsWith(Constants.URL_PATH_DELIMITER)) {
                str = str.substring(1);
            }
            if (str.length() > 0) {
                this.httpUrlBuilder.addPathSegments(str);
            }
            return this;
        }

        public Builder<T> method(String str) {
            this.method = str;
            return this;
        }

        public Builder<T> query(String str, String str2) {
            if (str != null) {
                this.httpUrlBuilder.addQueryParameter(str, str2);
            }
            return this;
        }

        public Builder<T> encodedQuery(String str, String str2) {
            if (str != null) {
                this.httpUrlBuilder.addEncodedQueryParameter(str, str2);
            }
            return this;
        }

        public Builder<T> query(Map<String, String> map) {
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    if (str != null) {
                        this.httpUrlBuilder.addQueryParameter(str, (String) next.getValue());
                    }
                }
            }
            return this;
        }

        public Builder<T> encodedQuery(Map<String, String> map) {
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    if (str != null) {
                        this.httpUrlBuilder.addEncodedQueryParameter(str, (String) next.getValue());
                    }
                }
            }
            return this;
        }

        public Builder<T> contentMD5() {
            this.calculateContentMD5 = true;
            return this;
        }

        public Builder<T> addHeader(String str, String str2) {
            if (!(str == null || str2 == null)) {
                this.requestBuilder.addHeader(str, str2);
                HttpRequest.addHeaderNameValue(this.headers, str, str2);
            }
            return this;
        }

        public Builder<T> addHeaders(Map<String, List<String>> map) {
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    for (String str2 : (List) next.getValue()) {
                        if (!(str == null || str2 == null)) {
                            this.requestBuilder.addHeader(str, str2);
                            HttpRequest.addHeaderNameValue(map, str, str2);
                        }
                    }
                }
            }
            return this;
        }

        public Builder<T> removeHeader(String str) {
            this.requestBuilder.removeHeader(str);
            this.headers.remove(str);
            return this;
        }

        public Builder<T> userAgent(String str) {
            this.requestBuilder.addHeader(HttpConstants.Header.USER_AGENT, str);
            return this;
        }

        public Builder<T> setUseCache(boolean z) {
            this.isCacheEnabled = z;
            return this;
        }

        public Builder<T> body(RequestBodySerializer requestBodySerializer2) {
            this.requestBodySerializer = requestBodySerializer2;
            return this;
        }

        public Builder<T> converter(ResponseBodyConverter<T> responseBodyConverter2) {
            this.responseBodyConverter = responseBodyConverter2;
            return this;
        }

        /* access modifiers changed from: protected */
        public void prepareBuild() {
            this.requestBuilder.url(this.httpUrlBuilder.build());
            if (!this.isCacheEnabled) {
                this.requestBuilder.cacheControl(CacheControl.FORCE_NETWORK);
            }
            if (this.responseBodyConverter == null) {
                this.responseBodyConverter = ResponseBodyConverter.string();
            }
        }

        public HttpRequest<T> build() {
            prepareBuild();
            return new HttpRequest<>(this);
        }
    }
}
