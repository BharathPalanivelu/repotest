package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.qcloud.core.http.RequestBodySerializer;

public final class OptionObjectRequest extends ObjectRequest {
    private String accessControlHeaders;
    private String accessControlMethod;
    private String origin;

    public String getMethod() {
        return "OPTIONS";
    }

    public RequestBodySerializer getRequestBody() {
        return null;
    }

    public OptionObjectRequest(String str, String str2, String str3, String str4) {
        super(str, str2);
        this.origin = str3;
        this.accessControlMethod = str4;
        setOrigin(str3);
        setAccessControlMethod(str4);
    }

    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        if (this.origin == null) {
            throw new CosXmlClientException("option request origin must not be null");
        } else if (this.accessControlMethod == null) {
            throw new CosXmlClientException("option request accessControlMethod must not be null");
        }
    }

    public void setOrigin(String str) {
        this.origin = str;
        if (str != null) {
            addHeader(COSRequestHeaderKey.ORIGIN, str);
        }
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setAccessControlMethod(String str) {
        if (str != null) {
            this.accessControlMethod = str.toUpperCase();
            addHeader(COSRequestHeaderKey.ACCESS_CONTROL_REQUEST_METHOD, this.accessControlMethod);
        }
    }

    public String getAccessControlMethod() {
        return this.accessControlMethod;
    }

    public void setAccessControlHeaders(String str) {
        this.accessControlHeaders = str;
        if (str != null) {
            addHeader(COSRequestHeaderKey.ACCESS_CONTROL_REQUEST_HEADERS, str);
        }
    }

    public String getAccessControlHeaders() {
        return this.accessControlHeaders;
    }
}
