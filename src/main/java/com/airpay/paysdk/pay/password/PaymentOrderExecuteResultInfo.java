package com.airpay.paysdk.pay.password;

import android.os.Parcel;
import android.os.Parcelable;
import com.airpay.paysdk.base.bean.BPOrderInfo;
import com.airpay.paysdk.base.proto.PaymentOrderExecuteReplyProto;

public class PaymentOrderExecuteResultInfo implements Parcelable {
    public static final Parcelable.Creator<PaymentOrderExecuteResultInfo> CREATOR = new Parcelable.Creator<PaymentOrderExecuteResultInfo>() {
        /* renamed from: a */
        public PaymentOrderExecuteResultInfo createFromParcel(Parcel parcel) {
            return new PaymentOrderExecuteResultInfo(parcel);
        }

        /* renamed from: a */
        public PaymentOrderExecuteResultInfo[] newArray(int i) {
            return new PaymentOrderExecuteResultInfo[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private BPOrderInfo f4236a;

    /* renamed from: b  reason: collision with root package name */
    private ShoppingCartInfo f4237b;

    public int describeContents() {
        return 0;
    }

    public BPOrderInfo a() {
        return this.f4236a;
    }

    public ShoppingCartInfo b() {
        return this.f4237b;
    }

    public PaymentOrderExecuteResultInfo(PaymentOrderExecuteReplyProto paymentOrderExecuteReplyProto) {
        this.f4236a = new BPOrderInfo(paymentOrderExecuteReplyProto.order);
        this.f4237b = new ShoppingCartInfo(paymentOrderExecuteReplyProto.shopping_cart);
    }

    protected PaymentOrderExecuteResultInfo(Parcel parcel) {
        this.f4237b = (ShoppingCartInfo) parcel.readParcelable(ShoppingCartInfo.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f4237b, i);
    }
}
