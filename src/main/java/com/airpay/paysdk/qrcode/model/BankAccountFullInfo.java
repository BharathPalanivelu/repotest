package com.airpay.paysdk.qrcode.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.airpay.paysdk.core.bean.ChannelInfo;

public class BankAccountFullInfo implements Parcelable {
    public static final Parcelable.Creator<BankAccountFullInfo> CREATOR = new Parcelable.Creator<BankAccountFullInfo>() {
        /* renamed from: a */
        public BankAccountFullInfo createFromParcel(Parcel parcel) {
            return new BankAccountFullInfo(parcel);
        }

        /* renamed from: a */
        public BankAccountFullInfo[] newArray(int i) {
            return new BankAccountFullInfo[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    protected BankAccountInfo f4353a;

    /* renamed from: b  reason: collision with root package name */
    protected ChannelInfo f4354b;

    public int describeContents() {
        return 0;
    }

    public BankAccountFullInfo(BankAccountInfo bankAccountInfo, ChannelInfo channelInfo) {
        this.f4353a = bankAccountInfo;
        this.f4354b = channelInfo;
    }

    protected BankAccountFullInfo(Parcel parcel) {
        this.f4353a = (BankAccountInfo) parcel.readParcelable(BankAccountInfo.class.getClassLoader());
        this.f4354b = (ChannelInfo) parcel.readParcelable(ChannelInfo.class.getClassLoader());
    }

    public int a() {
        BankAccountInfo bankAccountInfo = this.f4353a;
        if (bankAccountInfo != null) {
            return bankAccountInfo.f4357c;
        }
        ChannelInfo channelInfo = this.f4354b;
        if (channelInfo != null) {
            return channelInfo.a();
        }
        return -1;
    }

    public String b() {
        BankAccountInfo bankAccountInfo = this.f4353a;
        if (bankAccountInfo == null) {
            return "";
        }
        return bankAccountInfo.f4358d;
    }

    public long c() {
        BankAccountInfo bankAccountInfo = this.f4353a;
        if (bankAccountInfo == null) {
            return -1;
        }
        return bankAccountInfo.f4355a;
    }

    public BankAccountInfo d() {
        return this.f4353a;
    }

    public ChannelInfo e() {
        return this.f4354b;
    }

    public boolean f() {
        return this.f4353a != null;
    }

    public boolean g() {
        ChannelInfo channelInfo = this.f4354b;
        return channelInfo != null && channelInfo.b() == 3;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f4353a, i);
        parcel.writeParcelable(this.f4354b, i);
    }
}
