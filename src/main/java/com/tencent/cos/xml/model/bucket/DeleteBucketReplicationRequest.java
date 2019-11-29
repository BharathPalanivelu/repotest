package com.tencent.cos.xml.model.bucket;

import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.util.Map;

public class DeleteBucketReplicationRequest extends BucketRequest {
    public String getMethod() {
        return "DELETE";
    }

    public RequestBodySerializer getRequestBody() {
        return null;
    }

    public DeleteBucketReplicationRequest(String str) {
        super(str);
    }

    public Map<String, String> getQueryString() {
        this.queryParameters.put("replication", (Object) null);
        return this.queryParameters;
    }
}
