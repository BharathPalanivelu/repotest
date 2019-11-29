package com.tencent.cos.xml.model.bucket;

import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.util.Map;

public final class DeleteBucketLifecycleRequest extends BucketRequest {
    public String getMethod() {
        return "DELETE";
    }

    public RequestBodySerializer getRequestBody() {
        return null;
    }

    public DeleteBucketLifecycleRequest(String str) {
        super(str);
    }

    public Map<String, String> getQueryString() {
        this.queryParameters.put("lifecycle", (Object) null);
        return this.queryParameters;
    }
}
