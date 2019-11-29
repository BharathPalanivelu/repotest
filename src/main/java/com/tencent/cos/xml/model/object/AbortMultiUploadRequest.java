package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.util.Map;

public final class AbortMultiUploadRequest extends ObjectRequest {
    private String uploadId;

    public String getMethod() {
        return "DELETE";
    }

    public RequestBodySerializer getRequestBody() {
        return null;
    }

    public AbortMultiUploadRequest(String str, String str2, String str3) {
        super(str, str2);
        this.uploadId = str3;
    }

    public Map<String, String> getQueryString() {
        this.queryParameters.put("uploadID", this.uploadId);
        return this.queryParameters;
    }

    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        if (this.uploadId == null) {
            throw new CosXmlClientException("uploadID must not be null");
        }
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }

    public String getUploadId() {
        return this.uploadId;
    }
}
