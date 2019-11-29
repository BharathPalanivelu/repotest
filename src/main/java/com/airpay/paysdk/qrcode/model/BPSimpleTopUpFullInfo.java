package com.airpay.paysdk.qrcode.model;

import android.os.Parcel;
import android.os.Parcelable;

public class BPSimpleTopUpFullInfo implements Parcelable {
    public static final Parcelable.Creator<BPSimpleTopUpFullInfo> CREATOR = new Parcelable.Creator<BPSimpleTopUpFullInfo>() {
        /* renamed from: a */
        public BPSimpleTopUpFullInfo createFromParcel(Parcel parcel) {
            return new BPSimpleTopUpFullInfo(parcel);
        }

        /* renamed from: a */
        public BPSimpleTopUpFullInfo[] newArray(int i) {
            return new BPSimpleTopUpFullInfo[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public long f4346a;

    /* renamed from: b  reason: collision with root package name */
    public int f4347b;

    /* renamed from: c  reason: collision with root package name */
    public String f4348c;

    /* renamed from: d  reason: collision with root package name */
    public int f4349d = -1;

    /* renamed from: e  reason: collision with root package name */
    public String f4350e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f4351f;

    /* renamed from: g  reason: collision with root package name */
    private String f4352g;

    public int describeContents() {
        return 0;
    }

    public BPSimpleTopUpFullInfo(a aVar) {
    }

    protected BPSimpleTopUpFullInfo(Parcel parcel) {
        this.f4346a = parcel.readLong();
        this.f4347b = parcel.readInt();
        this.f4348c = parcel.readString();
        this.f4351f = parcel.readString();
        this.f4352g = parcel.readString();
        this.f4349d = parcel.readInt();
        this.f4350e = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f4346a);
        parcel.writeInt(this.f4347b);
        parcel.writeString(this.f4348c);
        parcel.writeString(this.f4351f);
        parcel.writeString(this.f4352g);
        parcel.writeInt(this.f4349d);
        parcel.writeString(this.f4350e);
    }
}
