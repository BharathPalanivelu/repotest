package com.airpay.paysdk.result.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class BPShowTicketOrderDetail implements Parcelable {
    public static final Parcelable.Creator<BPShowTicketOrderDetail> CREATOR = new Parcelable.Creator<BPShowTicketOrderDetail>() {
        /* renamed from: a */
        public BPShowTicketOrderDetail createFromParcel(Parcel parcel) {
            return new BPShowTicketOrderDetail(parcel);
        }

        /* renamed from: a */
        public BPShowTicketOrderDetail[] newArray(int i) {
            return new BPShowTicketOrderDetail[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final int f4448a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4449b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4450c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4451d;

    public int describeContents() {
        return 0;
    }

    public BPShowTicketOrderDetail(int i, int i2, int i3, int i4) {
        this.f4448a = i;
        this.f4449b = i2;
        this.f4450c = i3;
        this.f4451d = i4;
    }

    protected BPShowTicketOrderDetail(Parcel parcel) {
        this.f4448a = parcel.readInt();
        this.f4449b = parcel.readInt();
        this.f4450c = parcel.readInt();
        this.f4451d = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4448a);
        parcel.writeInt(this.f4449b);
        parcel.writeInt(this.f4450c);
        parcel.writeInt(this.f4451d);
    }
}
