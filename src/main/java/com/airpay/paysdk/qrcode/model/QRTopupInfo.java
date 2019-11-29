package com.airpay.paysdk.qrcode.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.airpay.paysdk.base.proto.TopupInfoProto;

public class QRTopupInfo implements Parcelable {
    public static final Parcelable.Creator<QRTopupInfo> CREATOR = new Parcelable.Creator<QRTopupInfo>() {
        /* renamed from: a */
        public QRTopupInfo createFromParcel(Parcel parcel) {
            return new QRTopupInfo(parcel);
        }

        /* renamed from: a */
        public QRTopupInfo[] newArray(int i) {
            return new QRTopupInfo[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public int f4370a;

    /* renamed from: b  reason: collision with root package name */
    public long f4371b;

    /* renamed from: c  reason: collision with root package name */
    public String f4372c;

    public int describeContents() {
        return 0;
    }

    public QRTopupInfo(TopupInfoProto topupInfoProto) {
        this.f4370a = topupInfoProto.type.intValue();
        this.f4371b = topupInfoProto.data.longValue();
        this.f4372c = topupInfoProto.message;
    }

    protected QRTopupInfo(Parcel parcel) {
        this.f4370a = parcel.readInt();
        this.f4371b = parcel.readLong();
        this.f4372c = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4370a);
        parcel.writeLong(this.f4371b);
        parcel.writeString(this.f4372c);
    }

    public String toString() {
        return "QRTopupInfo{type=" + this.f4370a + ", data=" + this.f4371b + ", message='" + this.f4372c + '\'' + '}';
    }
}
