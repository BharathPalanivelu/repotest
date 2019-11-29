package com.tencent.qcloud.core.auth;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.http.HttpConstants;
import com.tencent.qcloud.core.http.QCloudHttpRequest;

public class COSXmlSigner implements QCloudSigner {
    private static final String COS_SESSION_TOKEN = "x-cos-security-token";

    public void sign(QCloudHttpRequest qCloudHttpRequest, QCloudCredentials qCloudCredentials) throws QCloudClientException {
        COSXmlSignSourceProvider cOSXmlSignSourceProvider = (COSXmlSignSourceProvider) qCloudHttpRequest.getSignProvider();
        if (cOSXmlSignSourceProvider != null) {
            StringBuilder sb = new StringBuilder();
            QCloudLifecycleCredentials qCloudLifecycleCredentials = (QCloudLifecycleCredentials) qCloudCredentials;
            String signature = signature(cOSXmlSignSourceProvider.source(qCloudHttpRequest), qCloudLifecycleCredentials.getSignKey());
            sb.append(AuthConstants.Q_SIGN_ALGORITHM);
            sb.append(SimpleComparison.EQUAL_TO_OPERATION);
            sb.append(AuthConstants.SHA1);
            sb.append("&");
            sb.append(AuthConstants.Q_AK);
            sb.append(SimpleComparison.EQUAL_TO_OPERATION);
            sb.append(qCloudCredentials.getSecretId());
            sb.append("&");
            sb.append(AuthConstants.Q_SIGN_TIME);
            sb.append(SimpleComparison.EQUAL_TO_OPERATION);
            sb.append(cOSXmlSignSourceProvider.getSignTime());
            sb.append("&");
            sb.append(AuthConstants.Q_KEY_TIME);
            sb.append(SimpleComparison.EQUAL_TO_OPERATION);
            sb.append(qCloudLifecycleCredentials.getKeyTime());
            sb.append("&");
            sb.append(AuthConstants.Q_HEADER_LIST);
            sb.append(SimpleComparison.EQUAL_TO_OPERATION);
            sb.append(cOSXmlSignSourceProvider.getRealHeaderList().toLowerCase());
            sb.append("&");
            sb.append(AuthConstants.Q_URL_PARAM_LIST);
            sb.append(SimpleComparison.EQUAL_TO_OPERATION);
            sb.append(cOSXmlSignSourceProvider.getRealParameterList().toLowerCase());
            sb.append("&");
            sb.append(AuthConstants.Q_SIGNATURE);
            sb.append(SimpleComparison.EQUAL_TO_OPERATION);
            sb.append(signature);
            qCloudHttpRequest.addHeader(HttpConstants.Header.AUTHORIZATION, sb.toString());
            if (qCloudCredentials instanceof SessionQCloudCredentials) {
                qCloudHttpRequest.addHeader(COS_SESSION_TOKEN, ((SessionQCloudCredentials) qCloudCredentials).getToken());
                return;
            }
            return;
        }
        throw new QCloudClientException("no sign provider for cos xml signer");
    }

    private String signature(String str, String str2) throws QCloudClientException {
        byte[] hmacSha1 = Utils.hmacSha1(str, str2);
        return hmacSha1 != null ? new String(Utils.encodeHex(hmacSha1)) : "";
    }
}
