package com.shopee.sdk.modules.ui.navigator.options;

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
    private int f30448a;

    public int describeContents() {
        return 0;
    }

    private PopOption(int i) {
        this.f30448a = i;
    }

    public int a() {
        return this.f30448a;
    }

    public void a(int i) {
        this.f30448a = i;
    }

    public static PopOption b(int i) {
        return new PopOption(i);
    }

    public static PopOption b() {
        return new PopOption(0);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f30448a);
    }

    protected PopOption(Parcel parcel) {
        this.f30448a = parcel.readInt();
    }
}
