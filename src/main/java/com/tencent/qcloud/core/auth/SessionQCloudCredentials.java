package com.tencent.qcloud.core.auth;

public class SessionQCloudCredentials implements QCloudLifecycleCredentials {
    private final String keyTime;
    private final String secretId;
    private final String signKey;
    private final String token;

    public SessionQCloudCredentials(String str, String str2, String str3, long j) {
        this(str, str2, str3, System.currentTimeMillis() / 1000, j);
    }

    public SessionQCloudCredentials(String str, String str2, String str3, long j, long j2) {
        if (str == null) {
            throw new IllegalArgumentException("secretId cannot be null.");
        } else if (str2 == null) {
            throw new IllegalArgumentException("secretKey cannot be null.");
        } else if (str3 == null) {
            throw new IllegalArgumentException("token cannot be null.");
        } else if (j < j2) {
            this.secretId = str;
            this.keyTime = getKeyTime(j, j2);
            this.signKey = getSignKey(str2, this.keyTime);
            this.token = str3;
        } else {
            throw new IllegalArgumentException("beginTime must be larger than expiredTime.");
        }
    }

    public SessionQCloudCredentials(String str, String str2, String str3, String str4) {
        if (str == null) {
            throw new IllegalArgumentException("secretId cannot be null.");
        } else if (str2 == null) {
            throw new IllegalArgumentException("secretKey cannot be null.");
        } else if (str3 == null) {
            throw new IllegalArgumentException("token cannot be null.");
        } else if (str4 != null) {
            this.secretId = str;
            this.keyTime = str4;
            this.signKey = getSignKey(str2, str4);
            this.token = str3;
        } else {
            throw new IllegalArgumentException("keyTime cannot be null.");
        }
    }

    private String getKeyTime(long j, long j2) {
        return Utils.handleTimeAccuracy(j) + ";" + Utils.handleTimeAccuracy(j2);
    }

    private String getSignKey(String str, String str2) {
        byte[] hmacSha1 = Utils.hmacSha1(str2, str);
        if (hmacSha1 != null) {
            return new String(Utils.encodeHex(hmacSha1));
        }
        return null;
    }

    public String getToken() {
        return this.token;
    }

    public String getKeyTime() {
        return this.keyTime;
    }

    public String getSecretId() {
        return this.secretId;
    }

    public String getSignKey() {
        return this.signKey;
    }
}
