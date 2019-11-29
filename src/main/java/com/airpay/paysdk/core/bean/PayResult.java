package com.airpay.paysdk.core.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class PayResult implements Parcelable {
    public static final Parcelable.Creator<PayResult> CREATOR = new Parcelable.Creator<PayResult>() {
        /* renamed from: a */
        public PayResult createFromParcel(Parcel parcel) {
            return new PayResult(parcel);
        }

        /* renamed from: a */
        public PayResult[] newArray(int i) {
            return new PayResult[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public static PayResult f4113a = new PayResult(1, "payment success.");

    /* renamed from: b  reason: collision with root package name */
    public static PayResult f4114b = new PayResult(0, "user cancel the payment!");

    /* renamed from: c  reason: collision with root package name */
    public static PayResult f4115c = new PayResult(2, "payment complete.");

    /* renamed from: d  reason: collision with root package name */
    private int f4116d;

    /* renamed from: e  reason: collision with root package name */
    private String f4117e;

    /* renamed from: f  reason: collision with root package name */
    private ServiceMsg f4118f;

    public int describeContents() {
        return 0;
    }

    public PayResult(int i, String str) {
        this.f4116d = i;
        this.f4117e = str;
        this.f4118f = new ServiceMsg(i, str);
    }

    public PayResult(int i, int i2, String str) {
        this.f4116d = i;
        this.f4117e = "service error, please check serviceMsg.message for more info";
        this.f4118f = new ServiceMsg(i2, str);
    }

    public int a() {
        return this.f4116d;
    }

    public ServiceMsg b() {
        return this.f4118f;
    }

    protected PayResult(Parcel parcel) {
        this.f4116d = parcel.readInt();
        this.f4117e = parcel.readString();
        this.f4118f = (ServiceMsg) parcel.readParcelable(ServiceMsg.class.getClassLoader());
    }

    public String toString() {
        return "PayResult{code=" + this.f4116d + ", message='" + this.f4117e + '\'' + ", service=" + this.f4118f + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4116d);
        parcel.writeString(this.f4117e);
        parcel.writeParcelable(this.f4118f, i);
    }
}
