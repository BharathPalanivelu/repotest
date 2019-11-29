package com.tencent.cos.xml.model.bucket;

import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.util.Map;

public final class GetBucketLifecycleRequest extends BucketRequest {
    public String getMethod() {
        return "GET";
    }

    public RequestBodySerializer getRequestBody() {
        return null;
    }

    public GetBucketLifecycleRequest(String str) {
        super(str);
    }

    public Map<String, String> getQueryString() {
        this.queryParameters.put("lifecycle", (Object) null);
        return super.getQueryString();
    }
}
