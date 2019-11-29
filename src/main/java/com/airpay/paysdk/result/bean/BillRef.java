package com.airpay.paysdk.result.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class BillRef implements Parcelable {
    public static final Parcelable.Creator<BillRef> CREATOR = new Parcelable.Creator<BillRef>() {
        /* renamed from: a */
        public BillRef createFromParcel(Parcel parcel) {
            return new BillRef(parcel);
        }

        /* renamed from: a */
        public BillRef[] newArray(int i) {
            return new BillRef[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f4459a;

    /* renamed from: b  reason: collision with root package name */
    private String f4460b;

    /* renamed from: c  reason: collision with root package name */
    private String f4461c;

    /* renamed from: d  reason: collision with root package name */
    private String f4462d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4463e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4464f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f4465g;
    private boolean h;

    public int describeContents() {
        return 0;
    }

    public BillRef(String str, String str2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f4459a = str;
        this.f4460b = str2;
        this.f4461c = str3;
        this.f4462d = str4;
        this.f4463e = z;
        this.f4464f = z2;
        this.f4465g = z3;
        this.h = z4;
    }

    protected BillRef(Parcel parcel) {
        this.f4459a = parcel.readString();
        this.f4460b = parcel.readString();
        this.f4461c = parcel.readString();
        this.f4462d = parcel.readString();
        boolean z = true;
        this.f4463e = parcel.readByte() != 0;
        this.f4464f = parcel.readByte() != 0;
        this.f4465g = parcel.readByte() != 0;
        this.h = parcel.readByte() == 0 ? false : z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4459a);
        parcel.writeString(this.f4460b);
        parcel.writeString(this.f4461c);
        parcel.writeString(this.f4462d);
        parcel.writeByte(this.f4463e ? (byte) 1 : 0);
        parcel.writeByte(this.f4464f ? (byte) 1 : 0);
        parcel.writeByte(this.f4465g ? (byte) 1 : 0);
        parcel.writeByte(this.h ? (byte) 1 : 0);
    }
}
