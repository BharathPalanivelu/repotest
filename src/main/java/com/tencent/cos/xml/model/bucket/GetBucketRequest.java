package com.tencent.cos.xml.model.bucket;

import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.util.Map;

public final class GetBucketRequest extends BucketRequest {
    private String delimiter = null;
    private String encodingType;
    private String marker = null;
    private String maxKeys = "1000";
    private String prefix = null;

    public String getMethod() {
        return "GET";
    }

    public RequestBodySerializer getRequestBody() {
        return null;
    }

    public GetBucketRequest(String str) {
        super(str);
    }

    public Map<String, String> getQueryString() {
        if (this.prefix != null) {
            this.queryParameters.put("prefix", this.prefix);
        }
        if (this.delimiter != null) {
            this.queryParameters.put("delimiter", this.delimiter);
        }
        if (this.encodingType != null) {
            this.queryParameters.put("encoding-type", this.encodingType);
        }
        if (this.marker != null) {
            this.queryParameters.put("marker", this.marker);
        }
        if (this.maxKeys != null) {
            this.queryParameters.put("max-keys", this.maxKeys);
        }
        if (this.prefix != null) {
            this.queryParameters.put("prefix", this.prefix);
        }
        return super.getQueryString();
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setDelimiter(char c2) {
        this.delimiter = String.valueOf(c2);
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public void setEncodingType(String str) {
        this.encodingType = str;
    }

    public String getEncodingType() {
        return this.encodingType;
    }

    public void setMarker(String str) {
        this.marker = str;
    }

    public String getMarker() {
        return this.marker;
    }

    public void setMaxKeys(long j) {
        this.maxKeys = String.valueOf(j);
    }

    public long getMaxKeys() {
        return Long.parseLong(this.maxKeys);
    }
}
