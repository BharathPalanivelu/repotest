package com.tencent.cos.xml;

import com.tencent.cos.xml.common.VersionInfo;

public class CosXmlServiceConfig {
    public static final String DEFAULT_PROTOCOL = "http";
    public static final String DEFAULT_USER_AGENT = VersionInfo.getUserAgent();
    private String appid;
    private String ip;
    private boolean isDebuggable;
    private String protocol;
    private String region;
    private String userAgent;

    public CosXmlServiceConfig(Builder builder) {
        this.protocol = builder.protocol;
        this.userAgent = builder.userAgent;
        this.appid = builder.appid;
        this.region = builder.region;
        this.isDebuggable = builder.isDebuggable;
        this.ip = builder.ip;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public String getRegion() {
        return this.region;
    }

    public String getAppid() {
        return this.appid;
    }

    public String getIp() {
        return this.ip;
    }

    public boolean isDebuggable() {
        return this.isDebuggable;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public String appid;
        /* access modifiers changed from: private */
        public String ip;
        /* access modifiers changed from: private */
        public boolean isDebuggable = false;
        /* access modifiers changed from: private */
        public String protocol = "http";
        /* access modifiers changed from: private */
        public String region;
        /* access modifiers changed from: private */
        public String userAgent = CosXmlServiceConfig.DEFAULT_USER_AGENT;

        public Builder isHttps(boolean z) {
            if (z) {
                this.protocol = "https";
            } else {
                this.protocol = "http";
            }
            return this;
        }

        public Builder setAppidAndRegion(String str, String str2) {
            this.appid = str;
            this.region = str2;
            return this;
        }

        public Builder setHost(String str) {
            this.ip = str;
            return this;
        }

        public Builder setDebuggable(boolean z) {
            this.isDebuggable = z;
            return this;
        }

        public CosXmlServiceConfig builder() {
            return new CosXmlServiceConfig(this);
        }
    }
}
