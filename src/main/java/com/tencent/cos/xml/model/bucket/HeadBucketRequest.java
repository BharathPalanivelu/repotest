package com.tencent.cos.xml.model.bucket;

import com.tencent.qcloud.core.http.RequestBodySerializer;

public final class HeadBucketRequest extends BucketRequest {
    public String getMethod() {
        return "HEAD";
    }

    public RequestBodySerializer getRequestBody() {
        return null;
    }

    public HeadBucketRequest(String str) {
        super(str);
    }
}
