package com.airpay.paysdk.result.bean;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.airpay.paysdk.c;
import com.airpay.paysdk.core.bean.ChannelInfo;
import com.airpay.paysdk.pay.b.a;
import com.airpay.paysdk.qrcode.model.BPChannelDisplayInfo;

public class BillChannelInfo extends ChannelInfo implements Parcelable {
    public static final Parcelable.Creator<BillChannelInfo> CREATOR = new Parcelable.Creator<BillChannelInfo>() {
        /* renamed from: a */
        public BillChannelInfo createFromParcel(Parcel parcel) {
            return new BillChannelInfo(parcel);
        }

        /* renamed from: a */
        public BillChannelInfo[] newArray(int i) {
            return new BillChannelInfo[i];
        }
    };
    private BillerConfig s;
    private BPChannelDisplayInfo t;

    public int describeContents() {
        return 0;
    }

    protected BillChannelInfo(Parcel parcel) {
        super(parcel);
        this.s = (BillerConfig) parcel.readParcelable(BillerConfig.class.getClassLoader());
        this.t = (BPChannelDisplayInfo) parcel.readParcelable(BPChannelDisplayInfo.class.getClassLoader());
    }

    public BillChannelInfo(ChannelInfo channelInfo) {
        super(channelInfo);
        this.s = a.t(channelInfo.d());
    }

    public String a(Context context, String str) {
        if (this.t == null) {
            this.t = a.b(str, this.f4106d);
        }
        BPChannelDisplayInfo bPChannelDisplayInfo = this.t;
        if (bPChannelDisplayInfo != null) {
            String a2 = bPChannelDisplayInfo.a();
            if (!TextUtils.isEmpty(a2)) {
                return a2;
            }
        }
        if (!TextUtils.isEmpty(this.f4104b)) {
            return this.f4104b;
        }
        BillerConfig billerConfig = this.s;
        if (billerConfig != null) {
            String a3 = billerConfig.a();
            if (!TextUtils.isEmpty(a3)) {
                return a3;
            }
        }
        return context.getResources().getString(c.i.com_garena_beepay_label_bill);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.s, i);
        parcel.writeParcelable(this.t, i);
    }
}
