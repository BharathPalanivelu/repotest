package com.airpay.paysdk.pay.password;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class PasswordResultInfo implements Parcelable {
    public static final Parcelable.Creator<PasswordResultInfo> CREATOR = new Parcelable.Creator<PasswordResultInfo>() {
        /* renamed from: a */
        public PasswordResultInfo createFromParcel(Parcel parcel) {
            return new PasswordResultInfo(parcel);
        }

        /* renamed from: a */
        public PasswordResultInfo[] newArray(int i) {
            return new PasswordResultInfo[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final int f4227a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4228b;

    /* renamed from: c  reason: collision with root package name */
    public final String f4229c;

    /* renamed from: d  reason: collision with root package name */
    public final String f4230d;

    public int describeContents() {
        return 0;
    }

    public PasswordResultInfo(int i, String str, String str2) {
        this(i, str, str2, (String) null);
    }

    public PasswordResultInfo(int i, String str, String str2, String str3) {
        this.f4227a = i;
        this.f4228b = TextUtils.isEmpty(str) ? "" : str;
        this.f4229c = str2;
        this.f4230d = str3;
    }

    protected PasswordResultInfo(Parcel parcel) {
        this.f4227a = parcel.readInt();
        this.f4228b = parcel.readString();
        this.f4229c = parcel.readString();
        this.f4230d = parcel.readString();
    }

    public boolean a() {
        return this.f4227a == 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4227a);
        parcel.writeString(this.f4228b);
        parcel.writeString(this.f4229c);
        parcel.writeString(this.f4230d);
    }
}
