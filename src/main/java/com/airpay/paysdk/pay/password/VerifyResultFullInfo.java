package com.airpay.paysdk.pay.password;

import android.os.Parcel;
import android.os.Parcelable;

public class VerifyResultFullInfo implements Parcelable {
    public static final Parcelable.Creator<VerifyResultFullInfo> CREATOR = new Parcelable.Creator<VerifyResultFullInfo>() {
        /* renamed from: a */
        public VerifyResultFullInfo createFromParcel(Parcel parcel) {
            return new VerifyResultFullInfo(parcel);
        }

        /* renamed from: a */
        public VerifyResultFullInfo[] newArray(int i) {
            return new VerifyResultFullInfo[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private VerifyAuthMehodResultInfo f4244a;

    /* renamed from: b  reason: collision with root package name */
    private PasswordResultInfo f4245b;

    public int describeContents() {
        return 0;
    }

    public VerifyAuthMehodResultInfo a() {
        return this.f4244a;
    }

    public PasswordResultInfo b() {
        return this.f4245b;
    }

    public VerifyResultFullInfo(VerifyAuthMehodResultInfo verifyAuthMehodResultInfo, PasswordResultInfo passwordResultInfo) {
        this.f4244a = verifyAuthMehodResultInfo;
        this.f4245b = passwordResultInfo;
    }

    protected VerifyResultFullInfo(Parcel parcel) {
        this.f4244a = (VerifyAuthMehodResultInfo) parcel.readParcelable(VerifyAuthMehodResultInfo.class.getClassLoader());
        this.f4245b = (PasswordResultInfo) parcel.readParcelable(PasswordResultInfo.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f4244a, i);
        parcel.writeParcelable(this.f4245b, i);
    }
}
