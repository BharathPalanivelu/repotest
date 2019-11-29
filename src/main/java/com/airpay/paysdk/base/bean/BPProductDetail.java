package com.airpay.paysdk.base.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class BPProductDetail implements Parcelable {
    public static final Parcelable.Creator<BPProductDetail> CREATOR = new Parcelable.Creator<BPProductDetail>() {
        public BPProductDetail createFromParcel(Parcel parcel) {
            return new BPProductDetail(parcel);
        }

        public BPProductDetail[] newArray(int i) {
            return new BPProductDetail[i];
        }
    };
    public final boolean hasSeparateComponents;
    public final int iconBackup;
    public final String merchant;
    public final String productImageUrl;
    public final CharSequence productName;
    public final CharSequence productNameWithExtra;
    public final CharSequence productNameWithExtraLeft;
    public final CharSequence productNameWithExtraMiddle;
    public final CharSequence productNameWithExtraRight;

    public int describeContents() {
        return 0;
    }

    public BPProductDetail(String str, int i, CharSequence charSequence, String str2, CharSequence charSequence2) {
        this.merchant = str2;
        this.productNameWithExtra = charSequence2;
        this.productNameWithExtraLeft = null;
        this.productNameWithExtraMiddle = null;
        this.productNameWithExtraRight = null;
        this.hasSeparateComponents = false;
        this.productName = charSequence;
        this.productImageUrl = str;
        this.iconBackup = i;
    }

    public BPProductDetail(String str, int i, CharSequence charSequence, CharSequence charSequence2) {
        this.productNameWithExtra = charSequence2;
        this.productNameWithExtraLeft = null;
        this.productNameWithExtraMiddle = null;
        this.productNameWithExtraRight = null;
        this.hasSeparateComponents = false;
        this.merchant = null;
        this.productName = charSequence;
        this.productImageUrl = str;
        this.iconBackup = i;
    }

    public BPProductDetail(String str, int i, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4) {
        this.productNameWithExtra = null;
        this.productNameWithExtraLeft = charSequence2;
        this.productNameWithExtraMiddle = charSequence3;
        this.productNameWithExtraRight = charSequence4;
        this.hasSeparateComponents = true;
        this.merchant = null;
        this.productName = charSequence;
        this.productImageUrl = str;
        this.iconBackup = i;
    }

    protected BPProductDetail(Parcel parcel) {
        this.hasSeparateComponents = parcel.readByte() != 0;
        this.productNameWithExtra = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.productNameWithExtraLeft = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.productNameWithExtraMiddle = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.productNameWithExtraRight = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.merchant = parcel.readString();
        this.productName = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.productImageUrl = parcel.readString();
        this.iconBackup = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.hasSeparateComponents ? (byte) 1 : 0);
        TextUtils.writeToParcel(this.productNameWithExtra, parcel, i);
        TextUtils.writeToParcel(this.productNameWithExtraLeft, parcel, i);
        TextUtils.writeToParcel(this.productNameWithExtraMiddle, parcel, i);
        TextUtils.writeToParcel(this.productNameWithExtraRight, parcel, i);
        parcel.writeString(this.merchant);
        TextUtils.writeToParcel(this.productName, parcel, 0);
        parcel.writeString(this.productImageUrl);
        parcel.writeInt(this.iconBackup);
    }
}
