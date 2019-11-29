package com.tencent.qcloud.core.common;

public interface QCloudResultListener<T> {
    void onFailure(QCloudClientException qCloudClientException, QCloudServiceException qCloudServiceException);

    void onSuccess(T t);
}
