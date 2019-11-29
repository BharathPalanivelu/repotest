package com.airpay.paysdk.qrcode.model;

import android.os.Parcel;
import android.os.Parcelable;

public class BPChannelDisplayInfo implements Parcelable {
    public static final Parcelable.Creator<BPChannelDisplayInfo> CREATOR = new Parcelable.Creator<BPChannelDisplayInfo>() {
        /* renamed from: a */
        public BPChannelDisplayInfo createFromParcel(Parcel parcel) {
            return new BPChannelDisplayInfo(parcel);
        }

        /* renamed from: a */
        public BPChannelDisplayInfo[] newArray(int i) {
            return new BPChannelDisplayInfo[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f4340a;

    /* renamed from: b  reason: collision with root package name */
    private String f4341b;

    /* renamed from: c  reason: collision with root package name */
    private String f4342c;

    /* renamed from: d  reason: collision with root package name */
    private String f4343d;

    /* renamed from: e  reason: collision with root package name */
    private String f4344e;

    /* renamed from: f  reason: collision with root package name */
    private String f4345f;

    public int describeContents() {
        return 0;
    }

    public BPChannelDisplayInfo(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f4340a = str;
        this.f4341b = str2;
        this.f4342c = str3;
        this.f4343d = str4;
        this.f4344e = str5;
        this.f4345f = str6;
    }

    protected BPChannelDisplayInfo(Parcel parcel) {
        this.f4340a = parcel.readString();
        this.f4341b = parcel.readString();
        this.f4342c = parcel.readString();
        this.f4343d = parcel.readString();
        this.f4344e = parcel.readString();
        this.f4345f = parcel.readString();
    }

    public String a() {
        return this.f4341b;
    }

    public String b() {
        return this.f4343d;
    }

    public String c() {
        return this.f4345f;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4340a);
        parcel.writeString(this.f4341b);
        parcel.writeString(this.f4342c);
        parcel.writeString(this.f4343d);
        parcel.writeString(this.f4344e);
        parcel.writeString(this.f4345f);
    }
}
