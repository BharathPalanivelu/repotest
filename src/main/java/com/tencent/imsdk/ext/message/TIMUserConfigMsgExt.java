package com.tencent.imsdk.ext.message;

import com.tencent.imsdk.TIMUserConfig;

public class TIMUserConfigMsgExt extends TIMUserConfig {
    public TIMUserConfigMsgExt(TIMUserConfig tIMUserConfig) {
        super(tIMUserConfig);
    }

    public TIMUserConfigMsgExt enableAutoReport(boolean z) {
        this.isAutoReportEnabled = z;
        return this;
    }

    public TIMUserConfigMsgExt enableReadReceipt(boolean z) {
        this.isReadReceiptEnabled = z;
        return this;
    }

    public TIMUserConfigMsgExt enableRecentContact(boolean z) {
        this.isRecentContactEnabled = z;
        return this;
    }

    public TIMUserConfigMsgExt enableRecentContactNotify(boolean z) {
        this.isRecentContactNotifyEnabled = z;
        return this;
    }

    public TIMUserConfigMsgExt enableStorage(boolean z) {
        this.isStorageEnabled = z;
        return this;
    }

    public TIMMessageReceiptListener getMessageReceiptListener() {
        if (this.receiptListener instanceof TIMMessageReceiptListener) {
            return (TIMMessageReceiptListener) this.receiptListener;
        }
        return null;
    }

    public TIMMessageRevokedListener getMessageRevokedListener() {
        if (this.msgRevokedListener instanceof TIMMessageRevokedListener) {
            return (TIMMessageRevokedListener) this.msgRevokedListener;
        }
        return null;
    }

    public boolean isAutoReportEnabled() {
        return this.isAutoReportEnabled;
    }

    public boolean isReadReceiptEnabled() {
        return this.isReadReceiptEnabled;
    }

    public boolean isRecentContactEnabled() {
        return this.isRecentContactEnabled;
    }

    public boolean isRecentContactNotifyEnabled() {
        return this.isRecentContactNotifyEnabled;
    }

    public boolean isStorageEnabled() {
        return this.isStorageEnabled;
    }

    public TIMUserConfigMsgExt setMessageReceiptListener(TIMMessageReceiptListener tIMMessageReceiptListener) {
        this.receiptListener = tIMMessageReceiptListener;
        return this;
    }

    public TIMUserConfigMsgExt setMessageRevokedListener(TIMMessageRevokedListener tIMMessageRevokedListener) {
        this.msgRevokedListener = tIMMessageRevokedListener;
        return this;
    }
}
