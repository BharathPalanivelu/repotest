package com.airpay.paysdk.pay.password;

import android.os.Parcel;
import android.os.Parcelable;
import com.airpay.paysdk.base.bean.BPOrderInfo;
import com.airpay.paysdk.base.proto.PaymentOrderInitReplyProto;

public class PaymentOrderInitResultInfo implements Parcelable {
    public static final Parcelable.Creator<PaymentOrderInitResultInfo> CREATOR = new Parcelable.Creator<PaymentOrderInitResultInfo>() {
        /* renamed from: a */
        public PaymentOrderInitResultInfo createFromParcel(Parcel parcel) {
            return new PaymentOrderInitResultInfo(parcel);
        }

        /* renamed from: a */
        public PaymentOrderInitResultInfo[] newArray(int i) {
            return new PaymentOrderInitResultInfo[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private BPOrderInfo f4238a;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    public BPOrderInfo a() {
        return this.f4238a;
    }

    public PaymentOrderInitResultInfo(PaymentOrderInitReplyProto paymentOrderInitReplyProto) {
        this.f4238a = new BPOrderInfo(paymentOrderInitReplyProto.order);
    }

    protected PaymentOrderInitResultInfo(Parcel parcel) {
    }
}
