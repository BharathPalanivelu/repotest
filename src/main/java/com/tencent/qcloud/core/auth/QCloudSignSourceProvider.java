package com.tencent.qcloud.core.auth;

import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.http.HttpRequest;

public interface QCloudSignSourceProvider {
    <T> String source(HttpRequest<T> httpRequest) throws QCloudClientException;
}
