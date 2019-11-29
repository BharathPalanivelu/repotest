package com.salesforce.android.chat.core.internal.filetransfer;

import com.salesforce.android.service.common.http.HttpFactory;
import com.salesforce.android.service.common.http.HttpMediaType;
import com.salesforce.android.service.common.http.HttpMultipartBodyBuilder;
import com.salesforce.android.service.common.http.HttpRequest;
import com.salesforce.android.service.common.http.HttpRequestBody;
import com.salesforce.android.service.common.http.HttpRequestBuilder;
import com.salesforce.android.service.common.http.HttpUrl;
import com.salesforce.android.service.common.liveagentclient.SessionInfo;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.qcloud.core.http.HttpConstants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import okhttp3.Headers;

class FileUploadRequestComposer {
    private static final DateFormat FILE_NAME_FORMAT = new SimpleDateFormat("d MMM yyyy HH:mm:ss Z", Locale.getDefault());
    static final String PARAMETER_CHAT_KEY = "chatKey";
    static final String PARAMETER_ENCODING = "encoding";
    static final String PARAMETER_FILE_TOKEN = "fileToken";
    static final String PARAMETER_ORG_ID = "orgId";
    private static final String PART_NAME = "file";
    static final HttpMediaType REQUEST_MEDIA_TYPE = HttpFactory.mediaType(HttpConstants.ContentType.MULTIPART_FORM_DATA);
    private final HttpMediaType mFileMediaType;
    private final HttpRequestBody mFilePart;
    private final String mFileToken;
    private final String mFileUploadUrl;
    private final HttpMultipartBodyBuilder mMultipartBodyBuilder;
    private final String mOrganizationId;
    private final HttpRequestBuilder mRequestBuilder;
    private final SessionInfo mSessionInfo;

    private FileUploadRequestComposer(Builder builder) {
        this.mOrganizationId = builder.mOrganizationId;
        this.mSessionInfo = builder.mSessionInfo;
        this.mFileUploadUrl = builder.mFileUploadUrl;
        this.mFileToken = builder.mFileToken;
        this.mFileMediaType = builder.mFileMediaType;
        this.mFilePart = builder.mFilePart;
        this.mRequestBuilder = builder.mRequestBuilder;
        this.mMultipartBodyBuilder = builder.mMultipartBodyBuilder;
    }

    /* access modifiers changed from: package-private */
    public HttpUrl createUrl() {
        return HttpFactory.url().parse(this.mFileUploadUrl).addQueryParameter(PARAMETER_ORG_ID, this.mOrganizationId).addQueryParameter(PARAMETER_CHAT_KEY, this.mSessionInfo.getSessionId()).addQueryParameter(PARAMETER_FILE_TOKEN, this.mFileToken).addQueryParameter(PARAMETER_ENCODING, "UTF-8").build();
    }

    /* access modifiers changed from: package-private */
    public HttpRequestBody createRequestBody() {
        String format = String.format(Locale.getDefault(), "%s.%s", new Object[]{FILE_NAME_FORMAT.format(new Date()), this.mFileMediaType.subtype()});
        HttpMultipartBodyBuilder addFormDataPart = this.mMultipartBodyBuilder.setType(REQUEST_MEDIA_TYPE).addFormDataPart(PARAMETER_ORG_ID, this.mOrganizationId).addFormDataPart(PARAMETER_CHAT_KEY, this.mSessionInfo.getSessionId()).addFormDataPart(PARAMETER_FILE_TOKEN, this.mFileToken).addFormDataPart(PARAMETER_ENCODING, "UTF-8");
        return addFormDataPart.addPart(Headers.of(COSRequestHeaderKey.CONTENT_DISPOSITION, "form-data; name=\"file\"; filename=\"" + format + "\""), this.mFilePart).build();
    }

    /* access modifiers changed from: package-private */
    public HttpRequest createRequest() {
        return this.mRequestBuilder.url(createUrl()).post(createRequestBody()).build();
    }

    static class Factory {
        Factory() {
        }

        /* access modifiers changed from: package-private */
        public Builder createBuilder() {
            return new Builder();
        }
    }

    static class Builder {
        /* access modifiers changed from: private */
        public HttpMediaType mFileMediaType;
        /* access modifiers changed from: private */
        public HttpRequestBody mFilePart;
        /* access modifiers changed from: private */
        public String mFileToken;
        /* access modifiers changed from: private */
        public String mFileUploadUrl;
        private byte[] mImageBytes;
        /* access modifiers changed from: private */
        public HttpMultipartBodyBuilder mMultipartBodyBuilder;
        /* access modifiers changed from: private */
        public String mOrganizationId;
        /* access modifiers changed from: private */
        public HttpRequestBuilder mRequestBuilder;
        /* access modifiers changed from: private */
        public SessionInfo mSessionInfo;

        Builder() {
        }

        public Builder organizationId(String str) {
            this.mOrganizationId = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder sessionInfo(SessionInfo sessionInfo) {
            this.mSessionInfo = sessionInfo;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder fileUploadUrl(String str) {
            this.mFileUploadUrl = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder fileToken(String str) {
            this.mFileToken = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder imageBytes(byte[] bArr) {
            this.mImageBytes = bArr;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder fileMediaType(HttpMediaType httpMediaType) {
            this.mFileMediaType = httpMediaType;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder filePart(HttpRequestBody httpRequestBody) {
            this.mFilePart = httpRequestBody;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder requestBuilder(HttpRequestBuilder httpRequestBuilder) {
            this.mRequestBuilder = httpRequestBuilder;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder multipartBodyBuilder(HttpMultipartBodyBuilder httpMultipartBodyBuilder) {
            this.mMultipartBodyBuilder = httpMultipartBodyBuilder;
            return this;
        }

        public FileUploadRequestComposer build() {
            Arguments.checkValidSalesforceId(this.mOrganizationId, "Invalid Organization ID");
            Arguments.checkNotNull(this.mSessionInfo);
            Arguments.checkNotNull(this.mFileUploadUrl);
            Arguments.checkNotNull(this.mFileToken);
            Arguments.checkNotNull(this.mFileMediaType);
            if (this.mRequestBuilder == null) {
                this.mRequestBuilder = HttpFactory.request();
            }
            if (this.mMultipartBodyBuilder == null) {
                this.mMultipartBodyBuilder = HttpFactory.multipartBody();
            }
            if (this.mFilePart == null) {
                Arguments.checkNotNull(this.mImageBytes);
                HttpMediaType httpMediaType = this.mFileMediaType;
                byte[] bArr = this.mImageBytes;
                this.mFilePart = HttpFactory.requestBody(httpMediaType, bArr, 0, bArr.length);
            }
            return new FileUploadRequestComposer(this);
        }
    }
}
