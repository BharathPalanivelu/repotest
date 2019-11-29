package com.shopee.sdk.modules.ui.navigator.options;

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
    private int f30449a;

    /* renamed from: b  reason: collision with root package name */
    private int f30450b;

    public int describeContents() {
        return 0;
    }

    private PushOption(int i, int i2) {
        this.f30449a = i;
        this.f30450b = i2;
    }

    public static PushOption a() {
        return new PushOption(0, 0);
    }

    public static PushOption a(int i) {
        return new PushOption(0, i);
    }

    public int b() {
        return this.f30450b;
    }

    public void b(int i) {
        this.f30450b = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f30449a);
        parcel.writeInt(this.f30450b);
    }

    public PushOption() {
    }

    protected PushOption(Parcel parcel) {
        this.f30449a = parcel.readInt();
        this.f30450b = parcel.readInt();
    }
}
