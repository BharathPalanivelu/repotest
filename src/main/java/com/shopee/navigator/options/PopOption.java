package com.shopee.navigator.options;

import android.os.Parcel;
import android.os.Parcelable;

public class PopOption implements Parcelable {
    public static final Parcelable.Creator<PopOption> CREATOR = new Parcelable.Creator<PopOption>() {
        /* renamed from: a */
        public PopOption createFromParcel(Parcel parcel) {
            return new PopOption(parcel);
        }

        /* renamed from: a */
        public PopOption[] newArray(int i) {
            return new PopOption[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private int f30138a;

    /* renamed from: b  reason: collision with root package name */
    private int f30139b;

    public int describeContents() {
        return 0;
    }

    private PopOption(int i, int i2) {
        this.f30138a = i2;
        this.f30139b = i;
    }

    public int a() {
        return this.f30139b;
    }

    public int b() {
        return this.f30138a;
    }

    public void a(int i) {
        this.f30138a = i;
    }

    public static PopOption b(int i) {
        return new PopOption(0, i);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f30138a);
        parcel.writeInt(this.f30139b);
    }

    protected PopOption(Parcel parcel) {
        this.f30138a = parcel.readInt();
        this.f30139b = parcel.readInt();
    }
}
