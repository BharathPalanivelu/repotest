package com.airpay.paysdk.pay.password;

import android.os.Parcel;
import android.os.Parcelable;
import com.airpay.paysdk.base.proto.PaymentOrderInitRequestProto;
import com.airpay.paysdk.common.b.a;
import java.io.IOException;

public class BPPaymentProcessingInfo implements Parcelable {
    public static final Parcelable.Creator<BPPaymentProcessingInfo> CREATOR = new Parcelable.Creator<BPPaymentProcessingInfo>() {
        /* renamed from: a */
        public BPPaymentProcessingInfo createFromParcel(Parcel parcel) {
            return new BPPaymentProcessingInfo(parcel);
        }

        /* renamed from: a */
        public BPPaymentProcessingInfo[] newArray(int i) {
            return new BPPaymentProcessingInfo[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final PaymentOrderInitRequestProto f4208a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f4209b;

    /* renamed from: c  reason: collision with root package name */
    public final String f4210c;

    /* renamed from: d  reason: collision with root package name */
    public final String f4211d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f4212e;

    /* renamed from: f  reason: collision with root package name */
    public final int f4213f;

    /* renamed from: g  reason: collision with root package name */
    public String f4214g;

    public int describeContents() {
        return 0;
    }

    public BPPaymentProcessingInfo(PaymentOrderInitRequestProto paymentOrderInitRequestProto, boolean z, String str, String str2, boolean z2, int i, String str3) {
        this.f4208a = paymentOrderInitRequestProto;
        this.f4209b = z;
        this.f4210c = str;
        this.f4211d = str2;
        this.f4212e = z2;
        this.f4213f = i;
        this.f4214g = str3;
    }

    private BPPaymentProcessingInfo(Parcel parcel) {
        PaymentOrderInitRequestProto paymentOrderInitRequestProto;
        byte[] bArr = new byte[parcel.readInt()];
        parcel.readByteArray(bArr);
        try {
            paymentOrderInitRequestProto = PaymentOrderInitRequestProto.ADAPTER.decode(bArr);
        } catch (IOException e2) {
            a.a((Throwable) e2);
            paymentOrderInitRequestProto = null;
        }
        this.f4208a = paymentOrderInitRequestProto;
        boolean z = true;
        this.f4209b = parcel.readInt() != 0;
        this.f4210c = parcel.readString();
        this.f4211d = parcel.readString();
        this.f4212e = parcel.readInt() == 0 ? false : z;
        this.f4213f = parcel.readInt();
        this.f4214g = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte[] encode = this.f4208a.encode();
        parcel.writeInt(encode.length);
        parcel.writeByteArray(encode);
        parcel.writeInt(this.f4209b ? 1 : 0);
        parcel.writeString(this.f4210c);
        parcel.writeString(this.f4211d);
        parcel.writeInt(this.f4212e ? 1 : 0);
        parcel.writeInt(this.f4213f);
        parcel.writeString(this.f4214g);
    }

    public boolean a() {
        return this.f4209b && this.f4213f == 1;
    }

    public String toString() {
        return "BPPaymentProcessingInfo{initRequest=" + this.f4208a + "\n needExecution=" + this.f4209b + "\n deviceFingerprint='" + this.f4210c + '\'' + "\n localJsonData='" + this.f4211d + '\'' + "\n isGiftRedemption=" + this.f4212e + "\n authMethod=" + this.f4213f + "\n secureToken='" + this.f4214g + '\'' + '}';
    }
}
