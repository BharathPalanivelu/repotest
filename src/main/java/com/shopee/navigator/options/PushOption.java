package com.shopee.navigator.options;

import android.os.Parcel;
import android.os.Parcelable;

public class PushOption implements Parcelable {
    public static final Parcelable.Creator<PushOption> CREATOR = new Parcelable.Creator<PushOption>() {
        /* renamed from: a */
        public PushOption createFromParcel(Parcel parcel) {
            return new PushOption(parcel);
        }

        /* renamed from: a */
        public PushOption[] newArray(int i) {
            return new PushOption[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private int f30140a;

    /* renamed from: b  reason: collision with root package name */
    private int f30141b;

    public int describeContents() {
        return 0;
    }

    private PushOption(int i, int i2) {
        this.f30140a = i;
        this.f30141b = i2;
    }

    public static PushOption a() {
        return new PushOption(0, 0);
    }

    public static PushOption a(int i, int i2) {
        return new PushOption(i, i2);
    }

    public int b() {
        return this.f30140a;
    }

    public int c() {
        return this.f30141b;
    }

    public void a(int i) {
        this.f30141b = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f30140a);
        parcel.writeInt(this.f30141b);
    }

    public PushOption() {
    }

    protected PushOption(Parcel parcel) {
        this.f30140a = parcel.readInt();
        this.f30141b = parcel.readInt();
    }
}
