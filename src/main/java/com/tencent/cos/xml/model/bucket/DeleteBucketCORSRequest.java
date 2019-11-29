package com.tencent.cos.xml.model.bucket;

import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.util.Map;

public final class DeleteBucketCORSRequest extends BucketRequest {
    public String getMethod() {
        return "DELETE";
    }

    public RequestBodySerializer getRequestBody() {
        return null;
    }

    public DeleteBucketCORSRequest(String str) {
        super(str);
    }

    public Map<String, String> getQueryString() {
        this.queryParameters.put("cors", (Object) null);
        return this.queryParameters;
    }
}
