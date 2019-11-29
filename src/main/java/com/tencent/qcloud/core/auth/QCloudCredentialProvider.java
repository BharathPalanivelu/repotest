package com.tencent.qcloud.core.auth;

import com.tencent.qcloud.core.common.QCloudClientException;

public interface QCloudCredentialProvider {
    QCloudCredentials getCredentials() throws QCloudClientException;

    void refresh() throws QCloudClientException;
}
