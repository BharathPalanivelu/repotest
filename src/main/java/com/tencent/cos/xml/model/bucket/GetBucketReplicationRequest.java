package com.tencent.cos.xml.model.bucket;

import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.util.Map;

public class GetBucketReplicationRequest extends BucketRequest {
    public String getMethod() {
        return "GET";
    }

    public RequestBodySerializer getRequestBody() {
        return null;
    }

    public GetBucketReplicationRequest(String str) {
        super(str);
    }

    public Map<String, String> getQueryString() {
        this.queryParameters.put("replication", (Object) null);
        return this.queryParameters;
    }
}
