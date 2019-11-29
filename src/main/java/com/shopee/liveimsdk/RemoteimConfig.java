package com.shopee.liveimsdk;

import android.os.Parcel;
import android.os.Parcelable;

public class RemoteimConfig implements Parcelable {
    public static final Parcelable.Creator<RemoteimConfig> CREATOR = new Parcelable.Creator<RemoteimConfig>() {
        /* renamed from: a */
        public RemoteimConfig createFromParcel(Parcel parcel) {
            return new RemoteimConfig(parcel);
        }

        /* renamed from: a */
        public RemoteimConfig[] newArray(int i) {
            return new RemoteimConfig[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public boolean f29509a;

    /* renamed from: b  reason: collision with root package name */
    public String f29510b;

    /* renamed from: c  reason: collision with root package name */
    public String f29511c;

    /* renamed from: d  reason: collision with root package name */
    public String f29512d;

    /* renamed from: e  reason: collision with root package name */
    public int f29513e;

    /* renamed from: f  reason: collision with root package name */
    public String f29514f;

    /* renamed from: g  reason: collision with root package name */
    public String f29515g;

    public int describeContents() {
        return 0;
    }

    public RemoteimConfig(boolean z, String str, String str2, String str3, int i, String str4, String str5) {
        this.f29509a = z;
        this.f29510b = str;
        this.f29511c = str2;
        this.f29512d = str3;
        this.f29513e = i;
        this.f29514f = str4;
        this.f29515g = str5;
    }

    protected RemoteimConfig(Parcel parcel) {
        this.f29509a = parcel.readByte() != 0;
        this.f29510b = parcel.readString();
        this.f29511c = parcel.readString();
        this.f29512d = parcel.readString();
        this.f29513e = parcel.readInt();
        this.f29514f = parcel.readString();
        this.f29515g = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f29509a ? (byte) 1 : 0);
        parcel.writeString(this.f29510b);
        parcel.writeString(this.f29511c);
        parcel.writeString(this.f29512d);
        parcel.writeInt(this.f29513e);
        parcel.writeString(this.f29514f);
        parcel.writeString(this.f29515g);
    }
}
