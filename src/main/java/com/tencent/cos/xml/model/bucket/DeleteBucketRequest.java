package com.tencent.cos.xml.model.bucket;

import com.tencent.qcloud.core.http.RequestBodySerializer;

public final class DeleteBucketRequest extends BucketRequest {
    public String getMethod() {
        return "DELETE";
    }

    public RequestBodySerializer getRequestBody() {
        return null;
    }

    public DeleteBucketRequest(String str) {
        super(str);
    }
}
