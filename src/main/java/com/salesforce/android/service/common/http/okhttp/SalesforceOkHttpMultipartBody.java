package com.salesforce.android.service.common.http.okhttp;

import com.salesforce.android.service.common.http.HttpMediaType;
import com.salesforce.android.service.common.http.HttpMultipartBodyBuilder;
import com.salesforce.android.service.common.http.HttpRequestBody;
import okhttp3.Headers;
import okhttp3.MultipartBody;

public class SalesforceOkHttpMultipartBody {

    public static class Builder implements HttpMultipartBodyBuilder {
        private MultipartBody.Builder mMultipartBodyBuilder = new MultipartBody.Builder();

        public Builder setType(HttpMediaType httpMediaType) {
            this.mMultipartBodyBuilder.setType(httpMediaType.toOkHttpMediaType());
            return this;
        }

        public Builder addPart(HttpRequestBody httpRequestBody) {
            this.mMultipartBodyBuilder.addPart(httpRequestBody.toOkHttpRequestBody());
            return this;
        }

        public Builder addPart(Headers headers, HttpRequestBody httpRequestBody) {
            this.mMultipartBodyBuilder.addPart(headers, httpRequestBody.toOkHttpRequestBody());
            return this;
        }

        public Builder addFormDataPart(String str, String str2) {
            this.mMultipartBodyBuilder.addFormDataPart(str, str2);
            return this;
        }

        public Builder addFormDataPart(String str, String str2, HttpRequestBody httpRequestBody) {
            this.mMultipartBodyBuilder.addFormDataPart(str, str2, httpRequestBody.toOkHttpRequestBody());
            return this;
        }

        public SalesforceOkHttpRequestBody build() {
            return SalesforceOkHttpRequestBody.wrap(ObservableRequestBody.wrap(this.mMultipartBodyBuilder.build()));
        }
    }
}
