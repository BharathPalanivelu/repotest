package com.airpay.paysdk.base.bean;

import android.text.TextUtils;
import com.airpay.paysdk.qrcode.model.BankAccountFullInfo;

public class BPTopupChannelWithEvents {
    private boolean mAvailable;
    private BankAccountFullInfo mBankAccountInfo;
    private BPEvent mEvent;
    private String mRebateText = null;
    private BPTopupAmountInfo mTopupAmountInfo;

    public BPTopupChannelWithEvents(BankAccountFullInfo bankAccountFullInfo, BPEvent bPEvent, boolean z) {
        this.mEvent = bPEvent;
        this.mBankAccountInfo = bankAccountFullInfo;
        this.mAvailable = z;
    }

    public BPEvent getEvent() {
        return this.mEvent;
    }

    public void setEvent(BPEvent bPEvent) {
        this.mEvent = bPEvent;
    }

    public BPTopupAmountInfo getTopupAmountInfo() {
        return this.mTopupAmountInfo;
    }

    public void setTopupAmountInfo(BPTopupAmountInfo bPTopupAmountInfo) {
        this.mTopupAmountInfo = bPTopupAmountInfo;
    }

    public BankAccountFullInfo getBankAccountInfo() {
        return this.mBankAccountInfo;
    }

    public String getRebateText() {
        return this.mRebateText;
    }

    public void setRebateText(String str) {
        this.mRebateText = str;
    }

    public void appendRebateText(String str) {
        if (TextUtils.isEmpty(this.mRebateText)) {
            this.mRebateText = str;
            return;
        }
        this.mRebateText += " + " + str;
    }

    public boolean isCompatibleWithCash(long j) {
        if (this.mBankAccountInfo == null) {
            return true;
        }
        BPTopupAmountInfo bPTopupAmountInfo = this.mTopupAmountInfo;
        if (bPTopupAmountInfo == null || j < bPTopupAmountInfo.topupPayment) {
            return true;
        }
        return false;
    }

    public boolean isAvailable() {
        return this.mAvailable;
    }

    public String toString() {
        return "BPTopupChannelWithEvents{mEvent=" + this.mEvent + ", mTopupAmountInfo=" + this.mTopupAmountInfo + ", mBankAccountInfo=" + this.mBankAccountInfo + ", mRebateText='" + this.mRebateText + '\'' + ", mAvailable=" + this.mAvailable + '}';
    }
}
