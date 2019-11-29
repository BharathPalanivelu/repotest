package com.airpay.paysdk.qrcode.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.airpay.paysdk.base.proto.BankAccountProto;
import com.airpay.paysdk.pay.b.a;

public class BankAccountInfo implements Parcelable {
    public static final Parcelable.Creator<BankAccountInfo> CREATOR = new Parcelable.Creator<BankAccountInfo>() {
        /* renamed from: a */
        public BankAccountInfo createFromParcel(Parcel parcel) {
            return new BankAccountInfo(parcel);
        }

        /* renamed from: a */
        public BankAccountInfo[] newArray(int i) {
            return new BankAccountInfo[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public long f4355a;

    /* renamed from: b  reason: collision with root package name */
    public int f4356b;

    /* renamed from: c  reason: collision with root package name */
    public int f4357c;

    /* renamed from: d  reason: collision with root package name */
    public String f4358d;

    /* renamed from: e  reason: collision with root package name */
    public int f4359e;

    /* renamed from: f  reason: collision with root package name */
    public int f4360f;

    /* renamed from: g  reason: collision with root package name */
    public String f4361g;
    public String h;
    public int i;
    public int j;
    public String k;
    public String l;
    public int m;
    public String n;
    private long o;
    private boolean p;

    public int describeContents() {
        return 0;
    }

    public BankAccountInfo(BankAccountProto bankAccountProto) {
        this.o = 0;
        this.p = false;
        if (bankAccountProto != null) {
            this.f4355a = bankAccountProto.id != null ? bankAccountProto.id.longValue() : -1;
            int i2 = -1;
            this.f4356b = bankAccountProto.type != null ? bankAccountProto.type.intValue() : -1;
            this.f4357c = bankAccountProto.channel_id != null ? bankAccountProto.channel_id.intValue() : -1;
            this.f4358d = bankAccountProto.account_no;
            this.f4359e = bankAccountProto.flag != null ? bankAccountProto.flag.intValue() : -1;
            this.f4360f = bankAccountProto.bind_time != null ? bankAccountProto.bind_time.intValue() : -1;
            this.f4361g = bankAccountProto.mobile_no;
            this.h = bankAccountProto.ic_no;
            this.i = bankAccountProto.ic_verified != null ? bankAccountProto.ic_verified.intValue() : -1;
            this.j = bankAccountProto.expiry_date != null ? bankAccountProto.expiry_date.intValue() : -1;
            this.k = bankAccountProto.cvv;
            this.l = bankAccountProto.extra_data;
            this.m = bankAccountProto.update_time != null ? bankAccountProto.update_time.intValue() : i2;
            this.n = a.q(bankAccountProto.extra_data);
        }
    }

    protected BankAccountInfo(Parcel parcel) {
        this.o = 0;
        boolean z = false;
        this.p = false;
        this.f4355a = parcel.readLong();
        this.f4356b = parcel.readInt();
        this.f4357c = parcel.readInt();
        this.f4358d = parcel.readString();
        this.f4359e = parcel.readInt();
        this.f4360f = parcel.readInt();
        this.f4361g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readInt();
        this.j = parcel.readInt();
        this.k = parcel.readString();
        this.l = parcel.readString();
        this.m = parcel.readInt();
        this.n = parcel.readString();
        this.o = parcel.readLong();
        this.p = parcel.readByte() != 0 ? true : z;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f4355a);
        parcel.writeInt(this.f4356b);
        parcel.writeInt(this.f4357c);
        parcel.writeString(this.f4358d);
        parcel.writeInt(this.f4359e);
        parcel.writeInt(this.f4360f);
        parcel.writeString(this.f4361g);
        parcel.writeString(this.h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeInt(this.m);
        parcel.writeString(this.n);
        parcel.writeLong(this.o);
        parcel.writeByte(this.p ? (byte) 1 : 0);
    }

    public String toString() {
        return "BankAccountInfo{id=" + this.f4355a + ", type=" + this.f4356b + ", channel_id=" + this.f4357c + ", account_no='" + this.f4358d + '\'' + ", flag=" + this.f4359e + ", bind_time=" + this.f4360f + ", mobile_no='" + this.f4361g + '\'' + ", ic_no='" + this.h + '\'' + ", ic_verified=" + this.i + ", expiry_date=" + this.j + ", cvv='" + this.k + '\'' + ", extra_data='" + this.l + '\'' + ", update_time=" + this.m + ", nickname='" + this.n + '\'' + ", mExpiryInMillis=" + this.o + ", mHasParsedExpiry=" + this.p + '}';
    }
}
