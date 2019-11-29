package com.salesforce.android.service.common.utilities.internal.connectivity;

import android.net.NetworkInfo;
import java.util.Locale;

public class ConnectionInfo {
    private final boolean mIsConnected;
    private final RadioType mRadioType;
    private final Technology mTechnology;

    protected ConnectionInfo(Builder builder) {
        NetworkInfo networkInfo = builder.mNetworkInfo;
        if (networkInfo == null) {
            this.mTechnology = Technology.WIFI;
            this.mRadioType = RadioType.UNKNOWN;
            this.mIsConnected = false;
            return;
        }
        this.mTechnology = Technology.fromType(networkInfo.getType());
        this.mRadioType = RadioType.fromType(networkInfo.getSubtype());
        this.mIsConnected = networkInfo.isConnected();
    }

    public boolean isConnected() {
        return this.mIsConnected;
    }

    public boolean isConnectedWifi() {
        return this.mIsConnected && this.mTechnology == Technology.WIFI;
    }

    public boolean isConnectedMobile() {
        return this.mIsConnected && this.mTechnology == Technology.RADIO;
    }

    public Technology getTechnology() {
        return this.mTechnology;
    }

    public RadioType getRadioType() {
        return this.mRadioType;
    }

    public boolean isFastConnection() {
        if (!this.mIsConnected) {
            return false;
        }
        if (this.mTechnology == Technology.WIFI) {
            return true;
        }
        if (this.mTechnology == Technology.RADIO) {
            return this.mRadioType.isFastConnection();
        }
        return false;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "ConnectionInfo[IsConnected=%s, Technology=%s, RadioType=%s]", new Object[]{Boolean.valueOf(this.mIsConnected), this.mTechnology, this.mRadioType});
    }

    public static class Builder {
        protected NetworkInfo mNetworkInfo;

        public Builder networkInfo(NetworkInfo networkInfo) {
            this.mNetworkInfo = networkInfo;
            return this;
        }

        public ConnectionInfo build() {
            return new ConnectionInfo(this);
        }
    }
}
