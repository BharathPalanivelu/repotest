package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.qcloud.core.http.RequestBodySerializer;

public final class HeadObjectRequest extends ObjectRequest {
    public String getMethod() {
        return "HEAD";
    }

    public RequestBodySerializer getRequestBody() {
        return null;
    }

    public HeadObjectRequest(String str, String str2) {
        super(str, str2);
    }

    public void setVersionId(String str) {
        if (str != null) {
            this.queryParameters.put("versionId", str);
        }
    }

    public void setIfModifiedSince(String str) {
        if (str != null) {
            addHeader(COSRequestHeaderKey.IF_MODIFIED_SINCE, str);
        }
    }
}
