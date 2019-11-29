package com.salesforce.android.service.common.http;

import okhttp3.Headers;

public interface HttpMultipartBodyBuilder {
    HttpMultipartBodyBuilder addFormDataPart(String str, String str2);

    HttpMultipartBodyBuilder addFormDataPart(String str, String str2, HttpRequestBody httpRequestBody);

    HttpMultipartBodyBuilder addPart(HttpRequestBody httpRequestBody);

    HttpMultipartBodyBuilder addPart(Headers headers, HttpRequestBody httpRequestBody);

    HttpRequestBody build();

    HttpMultipartBodyBuilder setType(HttpMediaType httpMediaType);
}
