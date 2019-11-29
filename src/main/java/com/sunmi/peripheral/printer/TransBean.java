package com.sunmi.peripheral.printer;

import android.os.Parcel;
import android.os.Parcelable;

public class TransBean implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    public static Parcelable.Creator<TransBean> f30626a = new Parcelable.Creator<TransBean>() {
        /* renamed from: a */
        public TransBean createFromParcel(Parcel parcel) {
            return new TransBean(parcel);
        }

        /* renamed from: a */
        public TransBean[] newArray(int i) {
            return new TransBean[i];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private byte f30627b;

    /* renamed from: c  reason: collision with root package name */
    private String f30628c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f30629d;

    /* renamed from: e  reason: collision with root package name */
    private int f30630e;

    public int describeContents() {
        return 0;
    }

    public TransBean() {
        this.f30627b = 0;
        this.f30628c = "";
        this.f30629d = null;
        this.f30630e = 0;
        this.f30627b = 0;
        this.f30629d = null;
        this.f30628c = "";
        this.f30630e = 0;
    }

    public TransBean(Parcel parcel) {
        this.f30627b = 0;
        this.f30628c = "";
        this.f30629d = null;
        this.f30630e = 0;
        this.f30627b = parcel.readByte();
        this.f30630e = parcel.readInt();
        this.f30628c = parcel.readString();
        int i = this.f30630e;
        if (i > 0) {
            this.f30629d = new byte[i];
            parcel.readByteArray(this.f30629d);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f30627b);
        parcel.writeInt(this.f30630e);
        parcel.writeString(this.f30628c);
        byte[] bArr = this.f30629d;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }
}
