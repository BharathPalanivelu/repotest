package com.airpay.paysdk.pay.password;

import android.os.Parcel;
import android.os.Parcelable;
import com.airpay.paysdk.base.proto.AuthMethodVerifyReplyProto;
import com.airpay.paysdk.base.proto.VerifyLimitProto;

public class VerifyAuthMehodResultInfo implements Parcelable {
    public static final Parcelable.Creator<VerifyAuthMehodResultInfo> CREATOR = new Parcelable.Creator<VerifyAuthMehodResultInfo>() {
        /* renamed from: a */
        public VerifyAuthMehodResultInfo createFromParcel(Parcel parcel) {
            return new VerifyAuthMehodResultInfo(parcel);
        }

        /* renamed from: a */
        public VerifyAuthMehodResultInfo[] newArray(int i) {
            return new VerifyAuthMehodResultInfo[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private int f4241a;

    /* renamed from: b  reason: collision with root package name */
    private int f4242b;

    /* renamed from: c  reason: collision with root package name */
    private String f4243c;

    public int describeContents() {
        return 0;
    }

    public String a() {
        return this.f4243c;
    }

    public VerifyAuthMehodResultInfo(AuthMethodVerifyReplyProto authMethodVerifyReplyProto) {
        VerifyLimitProto verifyLimitProto = authMethodVerifyReplyProto.verify_limit;
        if (verifyLimitProto != null) {
            int i = -1;
            this.f4241a = verifyLimitProto.left_count != null ? verifyLimitProto.left_count.intValue() : -1;
            this.f4242b = verifyLimitProto.expiry != null ? verifyLimitProto.expiry.intValue() : i;
        }
        this.f4243c = authMethodVerifyReplyProto.secure_token;
    }

    protected VerifyAuthMehodResultInfo(Parcel parcel) {
        this.f4241a = parcel.readInt();
        this.f4242b = parcel.readInt();
        this.f4243c = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4241a);
        parcel.writeInt(this.f4242b);
        parcel.writeString(this.f4243c);
    }

    public String toString() {
        return "VerifyAuthMehodResultInfo{mLeftTimes=" + this.f4241a + ", mExpiryTime=" + this.f4242b + ", mSecureToken='" + this.f4243c + '\'' + '}';
    }
}
