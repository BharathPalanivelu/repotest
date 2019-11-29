package com.airpay.paysdk.core.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.airpay.paysdk.base.d.n;

public class Param implements Parcelable {
    public static final Parcelable.Creator<Param> CREATOR = new Parcelable.Creator<Param>() {
        /* renamed from: a */
        public Param createFromParcel(Parcel parcel) {
            return new Param(parcel);
        }

        /* renamed from: a */
        public Param[] newArray(int i) {
            return new Param[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f4111a;

    /* renamed from: b  reason: collision with root package name */
    private String f4112b;

    public int describeContents() {
        return 0;
    }

    public Param(String str, String str2) {
        this.f4111a = n.a(str);
        this.f4112b = str2;
    }

    public String a() {
        return this.f4111a;
    }

    public String b() {
        return this.f4112b;
    }

    protected Param(Parcel parcel) {
        this.f4111a = n.a(parcel.readString());
        this.f4112b = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4111a);
        parcel.writeString(this.f4112b);
    }
}
