package com.airpay.paysdk.base.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.airpay.paysdk.pay.password.ShoppingCartInfo;

public class PayParams implements Parcelable {
    public static final Parcelable.Creator<PayParams> CREATOR = new Parcelable.Creator<PayParams>() {
        public PayParams createFromParcel(Parcel parcel) {
            return new PayParams(parcel);
        }

        public PayParams[] newArray(int i) {
            return new PayParams[i];
        }
    };
    public String accountId;
    public ShoppingCartInfo cart;
    public int channelId;
    public String faceCurrency = null;
    public String faceValue = null;
    public int itemAmount;
    public String itemId;
    public String localJsonData;
    public String mPaymentChannelTxnId;
    public String paymentExtraData;
    public BPOrderPrecheckData precheckData;
    public long subtotal;

    public int describeContents() {
        return 0;
    }

    protected PayParams(Parcel parcel) {
        this.channelId = parcel.readInt();
        this.itemId = parcel.readString();
        this.itemAmount = parcel.readInt();
        this.subtotal = parcel.readLong();
        this.accountId = parcel.readString();
        this.precheckData = (BPOrderPrecheckData) parcel.readParcelable(BPOrderPrecheckData.class.getClassLoader());
        this.localJsonData = parcel.readString();
        this.faceCurrency = parcel.readString();
        this.faceValue = parcel.readString();
        this.mPaymentChannelTxnId = parcel.readString();
        this.paymentExtraData = parcel.readString();
        this.cart = (ShoppingCartInfo) parcel.readParcelable(ShoppingCartInfo.class.getClassLoader());
    }

    public PayParams(int i, String str, int i2, long j, String str2, BPOrderPrecheckData bPOrderPrecheckData, String str3, ShoppingCartInfo shoppingCartInfo) {
        this.channelId = i;
        this.itemId = str;
        this.itemAmount = i2;
        this.subtotal = j;
        if (str2 == null) {
            this.accountId = "";
        } else {
            this.accountId = str2;
        }
        this.precheckData = bPOrderPrecheckData;
        this.localJsonData = str3;
        this.cart = shoppingCartInfo;
    }

    public String toString() {
        return "PayParams{channelId=" + this.channelId + "\n itemId='" + this.itemId + '\'' + "\n itemAmount=" + this.itemAmount + "\n subtotal=" + this.subtotal + "\n accountId='" + this.accountId + '\'' + "\n precheckData=" + this.precheckData + "\n localJsonData='" + this.localJsonData + '\'' + "\n faceCurrency='" + this.faceCurrency + '\'' + "\n faceValue='" + this.faceValue + '\'' + "\n mPaymentChannelTxnId='" + this.mPaymentChannelTxnId + '\'' + "\n paymentExtraData='" + this.paymentExtraData + '\'' + "\n cart=" + this.cart + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.channelId);
        parcel.writeString(this.itemId);
        parcel.writeInt(this.itemAmount);
        parcel.writeLong(this.subtotal);
        parcel.writeString(this.accountId);
        parcel.writeParcelable(this.precheckData, i);
        parcel.writeString(this.localJsonData);
        parcel.writeString(this.faceCurrency);
        parcel.writeString(this.faceValue);
        parcel.writeString(this.mPaymentChannelTxnId);
        parcel.writeString(this.paymentExtraData);
        parcel.writeParcelable(this.cart, i);
    }
}
