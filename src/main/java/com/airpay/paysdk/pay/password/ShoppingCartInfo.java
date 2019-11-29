package com.airpay.paysdk.pay.password;

import android.os.Parcel;
import android.os.Parcelable;
import com.airpay.paysdk.base.bean.BPOrderInfo;
import com.airpay.paysdk.base.proto.OrderProto;
import com.airpay.paysdk.base.proto.ShoppingCartProto;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartInfo implements Parcelable {
    public static final Parcelable.Creator<ShoppingCartInfo> CREATOR = new Parcelable.Creator<ShoppingCartInfo>() {
        /* renamed from: a */
        public ShoppingCartInfo createFromParcel(Parcel parcel) {
            return new ShoppingCartInfo(parcel);
        }

        /* renamed from: a */
        public ShoppingCartInfo[] newArray(int i) {
            return new ShoppingCartInfo[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private List<BPOrderInfo> f4239a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private ShoppingCartProto f4240b;

    public int describeContents() {
        return 0;
    }

    public ShoppingCartInfo(ShoppingCartProto shoppingCartProto) {
        if (!(shoppingCartProto == null || shoppingCartProto.orders == null || shoppingCartProto.orders.size() <= 0)) {
            for (OrderProto bPOrderInfo : shoppingCartProto.orders) {
                this.f4239a.add(new BPOrderInfo(bPOrderInfo));
            }
        }
        this.f4240b = shoppingCartProto;
    }

    protected ShoppingCartInfo(Parcel parcel) {
        this.f4239a = parcel.createTypedArrayList(BPOrderInfo.CREATOR);
        this.f4240b = (ShoppingCartProto) parcel.readSerializable();
    }

    public List<BPOrderInfo> a() {
        return this.f4239a;
    }

    public ShoppingCartProto b() {
        return this.f4240b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f4239a);
        parcel.writeSerializable(this.f4240b);
    }
}
