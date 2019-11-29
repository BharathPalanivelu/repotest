package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.util.Map;

public class ListBucketVersionsRequest extends BucketRequest {
    private String delimiter;
    private String encodingType;
    private String keyMarker;
    private String maxKeys = "1000";
    private String prefix;
    private String versionIdMarker;

    public String getMethod() {
        return "GET";
    }

    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        return null;
    }

    public ListBucketVersionsRequest(String str) {
        super(str);
    }

    public void setPrefix(String str) {
        if (str != null) {
            this.prefix = str;
        }
    }

    public void setKeyMarker(String str) {
        if (str != null) {
            this.keyMarker = str;
        }
    }

    public void setVersionIdMarker(String str) {
        if (str != null) {
            this.versionIdMarker = str;
        }
    }

    public void setDelimiter(String str) {
        this.delimiter = str;
    }

    public void setEncodingType(String str) {
        this.encodingType = str;
    }

    public void setMaxKeys(int i) {
        this.maxKeys = String.valueOf(i);
    }

    public Map<String, String> getQueryString() {
        this.queryParameters.put("versions", (Object) null);
        if (this.prefix != null) {
            this.queryParameters.put("prefix", this.prefix);
        }
        if (this.keyMarker != null) {
            this.queryParameters.put("key-marker", this.keyMarker);
        }
        if (this.versionIdMarker != null) {
            this.queryParameters.put("version-id-marker", this.versionIdMarker);
        }
        if (this.delimiter != null) {
            this.queryParameters.put("delimiter", this.delimiter);
        }
        if (this.encodingType != null) {
            this.queryParameters.put("encoding-type", this.encodingType);
        }
        if (!this.maxKeys.equals("1000")) {
            this.queryParameters.put("max-keys", this.maxKeys);
        }
        return super.getQueryString();
    }
}
