package com.tencent.qcloud.core.http;

import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.common.QCloudServiceException;
import java.io.IOException;

public abstract class ResponseBodyConverter<T> {
    /* access modifiers changed from: protected */
    public abstract T convert(HttpResponse<T> httpResponse) throws QCloudClientException, QCloudServiceException;

    private static final class StringConverter extends ResponseBodyConverter<String> {
        private StringConverter() {
        }

        /* access modifiers changed from: protected */
        public String convert(HttpResponse<String> httpResponse) throws QCloudClientException, QCloudServiceException {
            try {
                return httpResponse.string();
            } catch (IOException e2) {
                throw new QCloudClientException((Throwable) e2);
            }
        }
    }

    private static final class BytesConverter extends ResponseBodyConverter<byte[]> {
        private BytesConverter() {
        }

        /* access modifiers changed from: protected */
        public byte[] convert(HttpResponse<byte[]> httpResponse) throws QCloudClientException, QCloudServiceException {
            try {
                return httpResponse.bytes();
            } catch (IOException e2) {
                throw new QCloudClientException((Throwable) e2);
            }
        }
    }

    public static ResponseBodyConverter<Void> file(String str) {
        return file(str, -1);
    }

    public static ResponseBodyConverter<Void> file(String str, long j) {
        return new ResponseFileConverter(str, j);
    }

    public static ResponseBodyConverter<String> string() {
        return new StringConverter();
    }

    public static ResponseBodyConverter<byte[]> bytes() {
        return new BytesConverter();
    }
}
