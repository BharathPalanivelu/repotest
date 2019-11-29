package com.tencent.qcloud.core.auth;

public interface QCloudLifecycleCredentials extends QCloudCredentials {
    String getKeyTime();

    String getSignKey();
}
