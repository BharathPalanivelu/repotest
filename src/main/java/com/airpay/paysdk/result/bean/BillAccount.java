package com.airpay.paysdk.result.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class BillAccount implements Parcelable {
    public static final Parcelable.Creator<BillAccount> CREATOR = new Parcelable.Creator<BillAccount>() {
        /* renamed from: a */
        public BillAccount createFromParcel(Parcel parcel) {
            return new BillAccount(parcel);
        }

        /* renamed from: a */
        public BillAccount[] newArray(int i) {
            return new BillAccount[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private long f4452a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f4453b = -1;

    /* renamed from: c  reason: collision with root package name */
    private String f4454c;

    /* renamed from: d  reason: collision with root package name */
    private int f4455d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f4456e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f4457f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f4458g = -1;
    private String h;
    private long i = -1;
    private int j = -1;
    private long k = -1;
    private int l = -1;
    private int m = -1;
    private String n;
    private String o;
    private BillChannelInfo p;
    private boolean q = false;

    public int describeContents() {
        return 0;
    }

    BillAccount() {
    }

    protected BillAccount(Parcel parcel) {
        this.f4452a = parcel.readLong();
        this.f4453b = parcel.readInt();
        this.f4454c = parcel.readString();
        this.f4455d = parcel.readInt();
        this.f4456e = parcel.readInt();
        this.f4457f = parcel.readInt();
        this.f4458g = parcel.readInt();
        this.h = parcel.readString();
        this.i = parcel.readLong();
        this.j = parcel.readInt();
        this.k = parcel.readLong();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
        this.n = parcel.readString();
        this.o = parcel.readString();
        this.p = (BillChannelInfo) parcel.readParcelable(BillChannelInfo.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f4452a);
        parcel.writeInt(this.f4453b);
        parcel.writeString(this.f4454c);
        parcel.writeInt(this.f4455d);
        parcel.writeInt(this.f4456e);
        parcel.writeInt(this.f4457f);
        parcel.writeInt(this.f4458g);
        parcel.writeString(this.h);
        parcel.writeLong(this.i);
        parcel.writeInt(this.j);
        parcel.writeLong(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeParcelable(this.p, i2);
    }
}
