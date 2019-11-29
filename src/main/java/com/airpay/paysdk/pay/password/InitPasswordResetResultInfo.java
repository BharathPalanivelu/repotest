package com.airpay.paysdk.pay.password;

import android.os.Parcel;
import android.os.Parcelable;
import com.airpay.paysdk.base.proto.PaymentPasswordResetInitReplyProto;

public class InitPasswordResetResultInfo implements Parcelable {
    public static final Parcelable.Creator<InitPasswordResetResultInfo> CREATOR = new Parcelable.Creator<InitPasswordResetResultInfo>() {
        /* renamed from: a */
        public InitPasswordResetResultInfo createFromParcel(Parcel parcel) {
            return new InitPasswordResetResultInfo(parcel);
        }

        /* renamed from: a */
        public InitPasswordResetResultInfo[] newArray(int i) {
            return new InitPasswordResetResultInfo[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private long f4215a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f4216b;

    /* renamed from: c  reason: collision with root package name */
    private int f4217c = -1;

    public int describeContents() {
        return 0;
    }

    public int a() {
        return this.f4216b;
    }

    public InitPasswordResetResultInfo(PaymentPasswordResetInitReplyProto paymentPasswordResetInitReplyProto) {
        this.f4216b = paymentPasswordResetInitReplyProto.reset_type.intValue();
        this.f4215a = paymentPasswordResetInitReplyProto.bank_account_id.longValue();
        this.f4217c = paymentPasswordResetInitReplyProto.reset_type.intValue();
    }

    protected InitPasswordResetResultInfo(Parcel parcel) {
        this.f4215a = parcel.readLong();
        this.f4216b = parcel.readInt();
        this.f4217c = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f4215a);
        parcel.writeInt(this.f4216b);
        parcel.writeInt(this.f4217c);
    }
}
