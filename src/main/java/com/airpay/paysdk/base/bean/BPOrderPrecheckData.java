package com.airpay.paysdk.base.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.airpay.paysdk.base.proto.PaymentOrderPrecheckReplyProto;
import com.airpay.paysdk.base.proto.TopupInfoProto;
import com.airpay.paysdk.common.b.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BPOrderPrecheckData implements Parcelable {
    public static final Parcelable.Creator<BPOrderPrecheckData> CREATOR = new Parcelable.Creator<BPOrderPrecheckData>() {
        public BPOrderPrecheckData createFromParcel(Parcel parcel) {
            return new BPOrderPrecheckData(parcel);
        }

        public BPOrderPrecheckData[] newArray(int i) {
            return new BPOrderPrecheckData[i];
        }
    };
    private final String mAddBankCardMsg;
    private final boolean mAllowPartialPayment;
    private final int mAllowedAuthMethods;
    private final String mExtraData;
    private final List<TopupInfoProto> mPaymentOptions;
    private final boolean mShowAddBankCard;
    private final List<TopupInfoProto> mUnavailablePaymentOptions;

    public int describeContents() {
        return 0;
    }

    public BPOrderPrecheckData(PaymentOrderPrecheckReplyProto paymentOrderPrecheckReplyProto) {
        this.mExtraData = paymentOrderPrecheckReplyProto.extra_data;
        this.mAllowedAuthMethods = paymentOrderPrecheckReplyProto.allowed_auth_methods.intValue();
        this.mAllowPartialPayment = paymentOrderPrecheckReplyProto.allow_partial_payment.booleanValue();
        if (paymentOrderPrecheckReplyProto.payment_options != null) {
            this.mPaymentOptions = paymentOrderPrecheckReplyProto.payment_options;
        } else {
            this.mPaymentOptions = Collections.emptyList();
        }
        if (paymentOrderPrecheckReplyProto.unavailable_payment_options != null) {
            this.mUnavailablePaymentOptions = paymentOrderPrecheckReplyProto.unavailable_payment_options;
        } else {
            this.mUnavailablePaymentOptions = Collections.emptyList();
        }
        if (paymentOrderPrecheckReplyProto.show_add_bank_card != null) {
            this.mShowAddBankCard = paymentOrderPrecheckReplyProto.show_add_bank_card.booleanValue();
        } else {
            this.mShowAddBankCard = false;
        }
        this.mAddBankCardMsg = paymentOrderPrecheckReplyProto.add_bank_card_message;
    }

    private BPOrderPrecheckData(Parcel parcel) {
        this.mExtraData = parcel.readString();
        this.mAllowedAuthMethods = parcel.readInt();
        boolean z = true;
        this.mAllowPartialPayment = parcel.readInt() > 0;
        int readInt = parcel.readInt();
        this.mPaymentOptions = new ArrayList();
        for (int i = 0; i < readInt; i++) {
            try {
                this.mPaymentOptions.add(TopupInfoProto.ADAPTER.decode(parcel.createByteArray()));
            } catch (IOException e2) {
                a.a((Throwable) e2);
            }
        }
        this.mUnavailablePaymentOptions = new ArrayList();
        int readInt2 = parcel.readInt();
        for (int i2 = 0; i2 < readInt2; i2++) {
            try {
                this.mUnavailablePaymentOptions.add(TopupInfoProto.ADAPTER.decode(parcel.createByteArray()));
            } catch (IOException e3) {
                a.a((Throwable) e3);
            }
        }
        this.mShowAddBankCard = parcel.readInt() <= 0 ? false : z;
        this.mAddBankCardMsg = parcel.readString();
    }

    public String getExtraData() {
        return this.mExtraData;
    }

    public int getAllowedAuthMethods() {
        return this.mAllowedAuthMethods;
    }

    public List<TopupInfoProto> getPaymentOptions() {
        return this.mPaymentOptions;
    }

    public List<TopupInfoProto> getUnavailablePaymentOptions() {
        return this.mUnavailablePaymentOptions;
    }

    public boolean allowCash() {
        for (TopupInfoProto next : this.mPaymentOptions) {
            if (next.type.intValue() == 1 && next.data.longValue() == 11000) {
                return true;
            }
        }
        return false;
    }

    public boolean allowPartialPayment() {
        return this.mAllowPartialPayment;
    }

    public boolean showAddBankCard() {
        return this.mShowAddBankCard;
    }

    public String addBankCardMsg() {
        return this.mAddBankCardMsg;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mExtraData);
        parcel.writeInt(this.mAllowedAuthMethods);
        parcel.writeInt(this.mAllowPartialPayment ? 1 : 0);
        parcel.writeInt(this.mPaymentOptions.size());
        for (TopupInfoProto encode : this.mPaymentOptions) {
            parcel.writeByteArray(encode.encode());
        }
        parcel.writeInt(this.mUnavailablePaymentOptions.size());
        for (TopupInfoProto encode2 : this.mUnavailablePaymentOptions) {
            parcel.writeByteArray(encode2.encode());
        }
        parcel.writeInt(this.mShowAddBankCard ? 1 : 0);
        parcel.writeString(this.mAddBankCardMsg);
    }

    public String toString() {
        return "BPOrderPrecheckData{mExtraData='" + this.mExtraData + '\'' + ", mAllowedAuthMethods=" + this.mAllowedAuthMethods + ", mPaymentOptions=" + this.mPaymentOptions + ", mUnavailablePaymentOptions=" + this.mUnavailablePaymentOptions + ", mAllowPartialPayment=" + this.mAllowPartialPayment + ", mShowAddBankCard=" + this.mShowAddBankCard + ", mAddBankCardMsg='" + this.mAddBankCardMsg + '\'' + '}';
    }
}
