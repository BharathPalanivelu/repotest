package com.airpay.paysdk.qrcode.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.airpay.paysdk.base.proto.QRCodeTopupInfoGetReplyProto;
import com.airpay.paysdk.base.proto.TopupInfoProto;
import java.util.ArrayList;
import java.util.List;

public class QRCodeTopupInfo implements Parcelable {
    public static final Parcelable.Creator<QRCodeTopupInfo> CREATOR = new Parcelable.Creator<QRCodeTopupInfo>() {
        /* renamed from: a */
        public QRCodeTopupInfo createFromParcel(Parcel parcel) {
            return new QRCodeTopupInfo(parcel);
        }

        /* renamed from: a */
        public QRCodeTopupInfo[] newArray(int i) {
            return new QRCodeTopupInfo[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public int f4368a = 0;

    /* renamed from: b  reason: collision with root package name */
    public List<QRTopupInfo> f4369b;

    public int describeContents() {
        return 0;
    }

    public QRCodeTopupInfo(QRCodeTopupInfoGetReplyProto qRCodeTopupInfoGetReplyProto) {
        if (qRCodeTopupInfoGetReplyProto.allow_topup_method != null) {
            this.f4368a = qRCodeTopupInfoGetReplyProto.allow_topup_method.intValue();
        }
        ArrayList arrayList = new ArrayList();
        for (TopupInfoProto qRTopupInfo : qRCodeTopupInfoGetReplyProto.topup_options) {
            arrayList.add(new QRTopupInfo(qRTopupInfo));
        }
        this.f4369b = arrayList;
    }

    protected QRCodeTopupInfo(Parcel parcel) {
        this.f4368a = parcel.readInt();
        this.f4369b = parcel.createTypedArrayList(QRTopupInfo.CREATOR);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4368a);
        parcel.writeTypedList(this.f4369b);
    }
}
