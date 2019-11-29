package com.tencent.qcloud.core.auth;

import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.common.QCloudServiceException;
import com.tencent.qcloud.core.http.HttpRequest;
import com.tencent.qcloud.core.http.HttpResult;
import com.tencent.qcloud.core.http.QCloudHttpClient;

public class ShortTimeCredentialProvider extends BasicLifecycleCredentialProvider {
    private long duration;
    protected HttpRequest<String> httpRequest;
    private String secretId;
    private String secretKey;

    /* access modifiers changed from: protected */
    public QCloudLifecycleCredentials onRemoteCredentialReceived(String str) throws QCloudClientException {
        return null;
    }

    @Deprecated
    public ShortTimeCredentialProvider(String str, String str2, long j) {
        this.secretId = str;
        this.secretKey = str2;
        this.duration = j;
    }

    public ShortTimeCredentialProvider(HttpRequest<String> httpRequest2) {
        this.httpRequest = httpRequest2;
    }

    /* access modifiers changed from: protected */
    public QCloudLifecycleCredentials fetchNewCredentials() throws QCloudClientException {
        String str = this.secretId;
        if (str != null) {
            String str2 = this.secretKey;
            if (str2 != null) {
                return onGetCredentialFromLocal(str, str2);
            }
        }
        if (this.httpRequest == null) {
            return null;
        }
        try {
            return onRemoteCredentialReceived((String) ((HttpResult) QCloudHttpClient.getDefault().resolveRequest(this.httpRequest).executeNow()).content());
        } catch (QCloudServiceException e2) {
            throw new QCloudClientException("get session json fails", e2);
        }
    }

    /* access modifiers changed from: package-private */
    public QCloudLifecycleCredentials onGetCredentialFromLocal(String str, String str2) throws QCloudClientException {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String str3 = currentTimeMillis + ";" + (this.duration + currentTimeMillis);
        return new BasicQCloudCredentials(str, secretKey2SignKey(str2, str3), str3);
    }

    private String secretKey2SignKey(String str, String str2) {
        byte[] hmacSha1 = Utils.hmacSha1(str2, str);
        if (hmacSha1 != null) {
            return new String(Utils.encodeHex(hmacSha1));
        }
        return null;
    }
}
