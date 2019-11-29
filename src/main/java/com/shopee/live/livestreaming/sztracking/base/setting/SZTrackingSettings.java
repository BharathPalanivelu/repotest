package com.shopee.live.livestreaming.sztracking.base.setting;

import com.shopee.live.livestreaming.util.k;
import com.shopee.sdk.b;
import com.shopee.sdk.modules.a;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class SZTrackingSettings {
    public static final String SZ_TRACKING_SDK_VERSION = "0.0.3";
    /* access modifiers changed from: private */
    public String clientIp;
    /* access modifiers changed from: private */
    public String clientVersion;
    /* access modifiers changed from: private */
    public String country;
    /* access modifiers changed from: private */
    public String deviceId;
    /* access modifiers changed from: private */
    public String deviceModel;
    /* access modifiers changed from: private */
    public String env;
    /* access modifiers changed from: private */
    public boolean multiCdn;
    /* access modifiers changed from: private */
    public int os;
    /* access modifiers changed from: private */
    public String osVersion;
    /* access modifiers changed from: private */
    public String sdkVersion;
    /* access modifiers changed from: private */
    public long uid;
    /* access modifiers changed from: private */
    public String userAgent;
    /* access modifiers changed from: private */
    public String videoUrl;

    public long getUid() {
        return this.uid;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public int getOs() {
        return this.os;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public String getClientVersion() {
        return this.clientVersion;
    }

    public String getClientIp() {
        return this.clientIp;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public String getEnv() {
        return this.env;
    }

    public String getCountry() {
        return this.country;
    }

    public boolean isMultiCdn() {
        return this.multiCdn;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public void setUid(long j) {
        this.uid = j;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceModel(String str) {
        this.deviceModel = str;
    }

    public void setOs(int i) {
        this.os = i;
    }

    public void setOsVersion(String str) {
        this.osVersion = str;
    }

    public void setClientVersion(String str) {
        this.clientVersion = str;
    }

    public void setClientIp(String str) {
        this.clientIp = str;
    }

    public void setUserAgent(String str) {
        this.userAgent = str;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }

    public void setEnv(String str) {
        this.env = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setMultiCdn(boolean z) {
        this.multiCdn = z;
    }

    public void setVideoUrl(String str) {
        this.videoUrl = str;
    }

    public static class Builder {
        private String clientIp = "";
        private String clientVersion = "";
        private String country = "";
        private String deviceId = "";
        private String deviceModel = "";
        private String env = "";
        private int maxEvents;
        private boolean multiCdn;
        private int netTimeout;
        private int os = 0;
        private String osVersion = "";
        private int remainEvents;
        private String sdkVersion = "";
        private int sendInterval;
        private int sendLimitSize;
        private long uid = 0;
        private String userAgent = "";
        private String videoUrl;

        public Builder uid(long j) {
            this.uid = j;
            return this;
        }

        public Builder deviceId(String str) {
            this.deviceId = str;
            return this;
        }

        public Builder deviceModel(String str) {
            this.deviceModel = str;
            return this;
        }

        public Builder os(int i) {
            this.os = i;
            return this;
        }

        public Builder osVersion(String str) {
            this.osVersion = str;
            return this;
        }

        public Builder clientVersion(String str) {
            this.clientVersion = str;
            return this;
        }

        public Builder clientIp(String str) {
            this.clientIp = str;
            return this;
        }

        public Builder userAgent(String str) {
            this.userAgent = str;
            return this;
        }

        public Builder sdkVersion(String str) {
            this.sdkVersion = str;
            return this;
        }

        public Builder env(String str) {
            this.env = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder multiCdn(boolean z) {
            this.multiCdn = z;
            return this;
        }

        public Builder videoUrl(String str) {
            this.videoUrl = str;
            return this;
        }

        public void maxEvents(int i) {
            this.maxEvents = i;
        }

        public void remainEvents(int i) {
            this.remainEvents = i;
        }

        public void netTimeout(int i) {
            this.netTimeout = i;
        }

        public void sendInterval(int i) {
            this.sendInterval = i;
        }

        public void sendLimitSize(int i) {
            this.sendLimitSize = i;
        }

        public Builder useDefaultData() {
            a a2 = b.a();
            if (a2 == null) {
                return this;
            }
            com.shopee.sdk.modules.app.e.b d2 = a2.d();
            if (d2 == null) {
                return this;
            }
            com.shopee.sdk.modules.app.e.a a3 = d2.a();
            if (a3 == null) {
                return this;
            }
            com.shopee.sdk.modules.app.a.b a4 = a2.a();
            if (a4 == null) {
                return this;
            }
            com.shopee.sdk.modules.app.a.a a5 = a4.a();
            if (a5 == null) {
                return this;
            }
            this.uid = (long) a3.a();
            this.sdkVersion = SZTrackingSettings.SZ_TRACKING_SDK_VERSION;
            this.deviceId = a5.b();
            this.deviceModel = k.a();
            this.clientVersion = a5.a();
            this.clientIp = SZTrackingSettings.getLocalIp();
            this.osVersion = a5.f();
            this.country = a5.d();
            this.env = a5.c();
            this.multiCdn = false;
            this.videoUrl = "";
            return this;
        }

        public SZTrackingSettings build() {
            SZTrackingSettings sZTrackingSettings = new SZTrackingSettings();
            long unused = sZTrackingSettings.uid = this.uid;
            String unused2 = sZTrackingSettings.deviceId = this.deviceId;
            String unused3 = sZTrackingSettings.deviceModel = this.deviceModel;
            int unused4 = sZTrackingSettings.os = this.os;
            String unused5 = sZTrackingSettings.osVersion = this.osVersion;
            String unused6 = sZTrackingSettings.clientVersion = this.clientVersion;
            String unused7 = sZTrackingSettings.clientIp = this.clientIp;
            String unused8 = sZTrackingSettings.userAgent = this.userAgent;
            String unused9 = sZTrackingSettings.sdkVersion = this.sdkVersion;
            String unused10 = sZTrackingSettings.env = this.env;
            String unused11 = sZTrackingSettings.country = this.country;
            boolean unused12 = sZTrackingSettings.multiCdn = this.multiCdn;
            String unused13 = sZTrackingSettings.videoUrl = this.videoUrl;
            return sZTrackingSettings;
        }
    }

    public static String getLocalIp() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return "";
            }
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                            return nextElement.getHostAddress();
                        }
                    }
                }
            }
        } catch (SocketException e2) {
            e2.printStackTrace();
        }
        return "";
    }
}
