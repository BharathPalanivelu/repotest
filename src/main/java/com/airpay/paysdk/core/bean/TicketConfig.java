package com.airpay.paysdk.core.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class TicketConfig implements Parcelable {
    public static final Parcelable.Creator<TicketConfig> CREATOR = new Parcelable.Creator<TicketConfig>() {
        /* renamed from: a */
        public TicketConfig createFromParcel(Parcel parcel) {
            return new TicketConfig(parcel);
        }

        /* renamed from: a */
        public TicketConfig[] newArray(int i) {
            return new TicketConfig[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public int f4119a;

    /* renamed from: b  reason: collision with root package name */
    public String f4120b;

    /* renamed from: c  reason: collision with root package name */
    public String f4121c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4122d;

    public int describeContents() {
        return 0;
    }

    public TicketConfig(int i, String str, String str2, boolean z) {
        this.f4119a = i;
        this.f4120b = str;
        this.f4122d = z;
        this.f4121c = str2;
    }

    protected TicketConfig(Parcel parcel) {
        this.f4119a = parcel.readInt();
        this.f4120b = parcel.readString();
        this.f4121c = parcel.readString();
        this.f4122d = parcel.readByte() != 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4119a);
        parcel.writeString(this.f4120b);
        parcel.writeString(this.f4121c);
        parcel.writeByte(this.f4122d ? (byte) 1 : 0);
    }
}
