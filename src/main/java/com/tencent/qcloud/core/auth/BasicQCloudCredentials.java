package com.tencent.qcloud.core.auth;

public class BasicQCloudCredentials implements QCloudLifecycleCredentials {
    private final String keyTime;
    private final String secretId;
    private final String signKey;

    public BasicQCloudCredentials(String str, String str2, long j, long j2) {
        if (str == null) {
            throw new IllegalArgumentException("secretId cannot be null.");
        } else if (str2 == null) {
            throw new IllegalArgumentException("signKey cannot be null.");
        } else if (j < j2) {
            this.secretId = str;
            this.signKey = str2;
            this.keyTime = Utils.handleTimeAccuracy(j) + ";" + Utils.handleTimeAccuracy(j2);
        } else {
            throw new IllegalArgumentException("beginTime must be larger than expiredTime.");
        }
    }

    public BasicQCloudCredentials(String str, String str2, String str3) {
        if (str == null) {
            throw new IllegalArgumentException("secretId cannot be null.");
        } else if (str2 == null) {
            throw new IllegalArgumentException("signKey cannot be null.");
        } else if (str3 != null) {
            this.secretId = str;
            this.signKey = str2;
            this.keyTime = str3;
        } else {
            throw new IllegalArgumentException("keyTime cannot be null.");
        }
    }

    public String getKeyTime() {
        return this.keyTime;
    }

    public String getSignKey() {
        return this.signKey;
    }

    public String getSecretId() {
        return this.secretId;
    }
}
