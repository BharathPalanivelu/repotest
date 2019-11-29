package com.tencent.qcloud.core.auth;

import java.util.Date;

public class OAuth2Credentials implements QCloudCredentials {
    private String accessToken;
    private String authorizationCode;
    private String openId;
    private String platform;
    private String refreshToken;
    private String scope;
    private Date tokenStartTime;
    private Date validFromDate;

    private OAuth2Credentials(Builder builder) {
        this.platform = builder.platform;
        this.accessToken = builder.accessToken;
        this.tokenStartTime = new Date(builder.tokenStartTime);
        this.validFromDate = new Date(builder.tokenStartTime + (builder.expiresIn * 1000));
        this.refreshToken = builder.refreshToken;
        this.openId = builder.openId;
        this.scope = builder.scope;
        this.authorizationCode = builder.authorizationCode;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getSecretId() {
        return this.openId;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getOpenId() {
        return this.openId;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > this.validFromDate.getTime();
    }

    public long getExpiresInSeconds() {
        return (this.validFromDate.getTime() - this.tokenStartTime.getTime()) / 1000;
    }

    public Date getValidFromDate() {
        return this.validFromDate;
    }

    public Date getTokenStartTime() {
        return this.tokenStartTime;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public String getScope() {
        return this.scope;
    }

    public String getAuthorizationCode() {
        return this.authorizationCode;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public String accessToken;
        /* access modifiers changed from: private */
        public String authorizationCode;
        /* access modifiers changed from: private */
        public long expiresIn;
        /* access modifiers changed from: private */
        public String openId;
        /* access modifiers changed from: private */
        public String platform;
        /* access modifiers changed from: private */
        public String refreshToken;
        /* access modifiers changed from: private */
        public String scope;
        /* access modifiers changed from: private */
        public long tokenStartTime;

        public Builder platform(String str) {
            this.platform = str;
            return this;
        }

        public Builder accessToken(String str) {
            this.accessToken = str;
            return this;
        }

        public Builder expiresInSeconds(long j) {
            this.expiresIn = j;
            return this;
        }

        public Builder tokenStartTime(long j) {
            this.tokenStartTime = j;
            return this;
        }

        public Builder refreshToken(String str) {
            this.refreshToken = str;
            return this;
        }

        public Builder openId(String str) {
            this.openId = str;
            return this;
        }

        public Builder authorizationCode(String str) {
            this.authorizationCode = str;
            return this;
        }

        public Builder scope(String str) {
            this.scope = str;
            return this;
        }

        public OAuth2Credentials build() {
            return new OAuth2Credentials(this);
        }
    }
}
