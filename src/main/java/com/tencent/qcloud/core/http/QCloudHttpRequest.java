package com.tencent.qcloud.core.http;

import com.tencent.qcloud.core.auth.QCloudSignSourceProvider;
import com.tencent.qcloud.core.auth.QCloudSigner;
import com.tencent.qcloud.core.auth.SignerFactory;
import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.http.HttpConstants;
import com.tencent.qcloud.core.http.HttpRequest;
import com.tencent.qcloud.core.util.QCloudStringUtils;
import java.net.URL;

public final class QCloudHttpRequest<T> extends HttpRequest<T> {
    private final QCloudSignSourceProvider signProvider;
    private final String signerType;

    public QCloudHttpRequest(Builder<T> builder) {
        super(builder);
        this.signerType = builder.signerType;
        this.signProvider = builder.signProvider;
    }

    public QCloudSignSourceProvider getSignProvider() {
        if (shouldCalculateAuth()) {
            return this.signProvider;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public QCloudSigner getQCloudSigner() throws QCloudClientException {
        if (this.signerType == null || !shouldCalculateAuth()) {
            return null;
        }
        QCloudSigner signer = SignerFactory.getSigner(this.signerType);
        if (signer != null) {
            return signer;
        }
        throw new QCloudClientException("can't get signer for type : " + this.signerType);
    }

    private boolean shouldCalculateAuth() {
        return QCloudStringUtils.isEmpty(header(HttpConstants.Header.AUTHORIZATION));
    }

    public static class Builder<T> extends HttpRequest.Builder<T> {
        /* access modifiers changed from: private */
        public QCloudSignSourceProvider signProvider;
        /* access modifiers changed from: private */
        public String signerType;

        public Builder<T> signer(String str, QCloudSignSourceProvider qCloudSignSourceProvider) {
            this.signerType = str;
            this.signProvider = qCloudSignSourceProvider;
            return this;
        }

        public Builder<T> url(URL url) {
            return (Builder) super.url(url);
        }

        public Builder<T> scheme(String str) {
            return (Builder) super.scheme(str);
        }

        public Builder<T> path(String str) {
            return (Builder) super.path(str);
        }

        public Builder<T> host(String str) {
            return (Builder) super.host(str);
        }

        public Builder<T> method(String str) {
            return (Builder) super.method(str);
        }

        public Builder<T> query(String str, String str2) {
            return (Builder) super.query(str, str2);
        }

        public Builder<T> contentMD5() {
            return (Builder) super.contentMD5();
        }

        public Builder<T> addHeader(String str, String str2) {
            return (Builder) super.addHeader(str, str2);
        }

        public Builder<T> removeHeader(String str) {
            return (Builder) super.removeHeader(str);
        }

        public Builder<T> userAgent(String str) {
            return (Builder) super.userAgent(str);
        }

        public Builder<T> setUseCache(boolean z) {
            return (Builder) super.setUseCache(z);
        }

        public Builder<T> body(RequestBodySerializer requestBodySerializer) {
            return (Builder) super.body(requestBodySerializer);
        }

        public Builder<T> tag(Object obj) {
            return (Builder) super.tag(obj);
        }

        public Builder<T> converter(ResponseBodyConverter<T> responseBodyConverter) {
            return (Builder) super.converter(responseBodyConverter);
        }

        public QCloudHttpRequest<T> build() {
            prepareBuild();
            return new QCloudHttpRequest<>(this);
        }
    }
}
