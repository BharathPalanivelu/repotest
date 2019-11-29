package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.qcloud.core.http.RequestBodySerializer;

public final class GetObjectBytesRequest extends ObjectRequest {
    public String getMethod() {
        return "GET";
    }

    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        return null;
    }

    public GetObjectBytesRequest(String str, String str2) {
        super(str, str2);
    }
}
