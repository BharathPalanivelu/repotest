package com.tencent.cos.xml.model.object;

import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.util.Map;

public final class GetObjectACLRequest extends ObjectRequest {
    public String getMethod() {
        return "GET";
    }

    public RequestBodySerializer getRequestBody() {
        return null;
    }

    public GetObjectACLRequest(String str, String str2) {
        super(str, str2);
    }

    public Map<String, String> getQueryString() {
        this.queryParameters.put("acl", (Object) null);
        return this.queryParameters;
    }
}
