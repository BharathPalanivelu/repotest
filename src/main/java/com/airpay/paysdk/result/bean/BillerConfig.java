package com.airpay.paysdk.result.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class BillerConfig implements Parcelable {
    public static final Parcelable.Creator<BillerConfig> CREATOR = new Parcelable.Creator<BillerConfig>() {
        /* renamed from: a */
        public BillerConfig createFromParcel(Parcel parcel) {
            return new BillerConfig(parcel);
        }

        /* renamed from: a */
        public BillerConfig[] newArray(int i) {
            return new BillerConfig[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f4466a;

    /* renamed from: b  reason: collision with root package name */
    private String f4467b;

    /* renamed from: c  reason: collision with root package name */
    private String f4468c;

    /* renamed from: d  reason: collision with root package name */
    private String f4469d;

    /* renamed from: e  reason: collision with root package name */
    private int f4470e;

    /* renamed from: f  reason: collision with root package name */
    private int f4471f;

    /* renamed from: g  reason: collision with root package name */
    private String f4472g;
    private List<BillRef> h;
    private int i;
    private String j;
    private String k;

    public int describeContents() {
        return 0;
    }

    public BillerConfig(String str, String str2, String str3, String str4, int i2, int i3, String str5, List<BillRef> list, int i4, String str6, String str7) {
        this.f4466a = str;
        this.f4467b = str2;
        this.f4468c = str3;
        this.f4469d = str4;
        this.f4470e = i2;
        this.f4471f = i3;
        this.f4472g = str5;
        this.h = list;
        this.i = i4;
        this.j = str6;
        this.k = str7;
    }

    protected BillerConfig(Parcel parcel) {
        this.f4466a = parcel.readString();
        this.f4467b = parcel.readString();
        this.f4468c = parcel.readString();
        this.f4469d = parcel.readString();
        this.f4470e = parcel.readInt();
        this.f4471f = parcel.readInt();
        this.f4472g = parcel.readString();
        this.i = parcel.readInt();
        this.j = parcel.readString();
        this.k = parcel.readString();
    }

    public String a() {
        return this.f4467b;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f4466a);
        parcel.writeString(this.f4467b);
        parcel.writeString(this.f4468c);
        parcel.writeString(this.f4469d);
        parcel.writeInt(this.f4470e);
        parcel.writeInt(this.f4471f);
        parcel.writeString(this.f4472g);
        parcel.writeInt(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
    }
}
