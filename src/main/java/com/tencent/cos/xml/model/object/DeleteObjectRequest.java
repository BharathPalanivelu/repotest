package com.tencent.cos.xml.model.object;

import com.tencent.qcloud.core.http.RequestBodySerializer;

public final class DeleteObjectRequest extends ObjectRequest {
    public String getMethod() {
        return "DELETE";
    }

    public RequestBodySerializer getRequestBody() {
        return null;
    }

    public DeleteObjectRequest(String str, String str2) {
        super(str, str2);
    }

    public void setVersionId(String str) {
        if (str != null) {
            this.queryParameters.put("versionId", str);
        }
    }
}
