package com.airpay.paysdk.qrcode.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.airpay.paysdk.base.proto.QRCodeGetReplyProto;

public class QRCodeGetInfo implements Parcelable {
    public static final Parcelable.Creator<QRCodeGetInfo> CREATOR = new Parcelable.Creator<QRCodeGetInfo>() {
        /* renamed from: a */
        public QRCodeGetInfo createFromParcel(Parcel parcel) {
            return new QRCodeGetInfo(parcel);
        }

        /* renamed from: a */
        public QRCodeGetInfo[] newArray(int i) {
            return new QRCodeGetInfo[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public String f4363a;

    /* renamed from: b  reason: collision with root package name */
    public int f4364b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4365c;

    /* renamed from: d  reason: collision with root package name */
    public int f4366d = -1;

    /* renamed from: e  reason: collision with root package name */
    public String f4367e;

    public int describeContents() {
        return 0;
    }

    public QRCodeGetInfo(QRCodeGetReplyProto qRCodeGetReplyProto) {
        int i = -1;
        if (qRCodeGetReplyProto != null) {
            String str = "";
            this.f4363a = qRCodeGetReplyProto.qr_code != null ? qRCodeGetReplyProto.qr_code : str;
            this.f4364b = qRCodeGetReplyProto.expiry_time != null ? qRCodeGetReplyProto.expiry_time.intValue() : -1;
            this.f4365c = qRCodeGetReplyProto.use_cash != null ? qRCodeGetReplyProto.use_cash.booleanValue() : false;
            this.f4366d = qRCodeGetReplyProto.topup_channel_id != null ? qRCodeGetReplyProto.topup_channel_id.intValue() : i;
            this.f4367e = qRCodeGetReplyProto.topup_account_id != null ? qRCodeGetReplyProto.topup_account_id : str;
        }
    }

    protected QRCodeGetInfo(Parcel parcel) {
        this.f4363a = parcel.readString();
        this.f4364b = parcel.readInt();
        this.f4365c = parcel.readByte() != 0;
        this.f4366d = parcel.readInt();
        this.f4367e = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4363a);
        parcel.writeInt(this.f4364b);
        parcel.writeByte(this.f4365c ? (byte) 1 : 0);
        parcel.writeInt(this.f4366d);
        parcel.writeString(this.f4367e);
    }

    public String toString() {
        return "QRCodeGetInfo{qrCode='" + this.f4363a + '\'' + ", expiryTime=" + this.f4364b + ", useCash=" + this.f4365c + ", topUpChannelId=" + this.f4366d + ", topUpAccountId='" + this.f4367e + '\'' + '}';
    }
}
