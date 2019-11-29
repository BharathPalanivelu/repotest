package com.airpay.paysdk.pay.password;

import android.os.Parcel;
import android.os.Parcelable;
import com.airpay.paysdk.base.bean.BPOrderInfo;
import com.airpay.paysdk.base.proto.PaymentConfirmDetailProto;
import com.airpay.paysdk.pay.b;

public class PaymentConfirmDetailInfo implements Parcelable {
    public static final Parcelable.Creator<PaymentConfirmDetailInfo> CREATOR = new Parcelable.Creator<PaymentConfirmDetailInfo>() {
        /* renamed from: a */
        public PaymentConfirmDetailInfo createFromParcel(Parcel parcel) {
            return new PaymentConfirmDetailInfo(parcel);
        }

        /* renamed from: a */
        public PaymentConfirmDetailInfo[] newArray(int i) {
            return new PaymentConfirmDetailInfo[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f4231a;

    /* renamed from: b  reason: collision with root package name */
    private String f4232b;

    /* renamed from: c  reason: collision with root package name */
    private int f4233c;

    /* renamed from: d  reason: collision with root package name */
    private BPOrderInfo f4234d;

    /* renamed from: e  reason: collision with root package name */
    private ShoppingCartInfo f4235e;

    public int describeContents() {
        return 0;
    }

    public PaymentConfirmDetailInfo(PaymentConfirmDetailProto paymentConfirmDetailProto) {
        this.f4231a = paymentConfirmDetailProto.payee_name;
        this.f4232b = paymentConfirmDetailProto.payee_icon_url;
        this.f4233c = paymentConfirmDetailProto.allowed_auth_methods.intValue();
        if (!(paymentConfirmDetailProto.shopping_cart == null || paymentConfirmDetailProto.shopping_cart.orders == null || paymentConfirmDetailProto.shopping_cart.orders.isEmpty())) {
            this.f4234d = new BPOrderInfo(paymentConfirmDetailProto.shopping_cart.orders.get(0));
        }
        this.f4235e = new ShoppingCartInfo(paymentConfirmDetailProto.shopping_cart);
    }

    protected PaymentConfirmDetailInfo(Parcel parcel) {
        this.f4231a = parcel.readString();
        this.f4232b = parcel.readString();
        this.f4233c = parcel.readInt();
        this.f4234d = (BPOrderInfo) parcel.readParcelable(BPOrderInfo.class.getClassLoader());
        this.f4235e = (ShoppingCartInfo) parcel.readParcelable(ShoppingCartInfo.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4231a);
        parcel.writeString(this.f4232b);
        parcel.writeInt(this.f4233c);
        parcel.writeParcelable(this.f4234d, i);
        parcel.writeParcelable(this.f4235e, i);
    }

    public String a() {
        return this.f4231a;
    }

    public ShoppingCartInfo b() {
        return this.f4235e;
    }

    public CharSequence c() {
        BPOrderInfo bPOrderInfo = this.f4234d;
        return bPOrderInfo != null ? b.b((double) bPOrderInfo.getPaymentPayableAmount()) : "";
    }
}
