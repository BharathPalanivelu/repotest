package com.tencent.cos.xml.model.bucket;

import com.facebook.places.model.PlaceFields;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.util.Map;

public final class GetBucketLocationRequest extends BucketRequest {
    public String getMethod() {
        return "GET";
    }

    public RequestBodySerializer getRequestBody() {
        return null;
    }

    public GetBucketLocationRequest(String str) {
        super(str);
    }

    public Map<String, String> getQueryString() {
        this.queryParameters.put(PlaceFields.LOCATION, (Object) null);
        return super.getQueryString();
    }
}
