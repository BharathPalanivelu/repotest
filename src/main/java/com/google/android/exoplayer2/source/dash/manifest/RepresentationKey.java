package com.google.android.exoplayer2.source.dash.manifest;

import android.os.Parcel;
import android.os.Parcelable;

public final class RepresentationKey implements Parcelable, Comparable<RepresentationKey> {
    public static final Parcelable.Creator<RepresentationKey> CREATOR = new Parcelable.Creator<RepresentationKey>() {
        /* renamed from: a */
        public RepresentationKey createFromParcel(Parcel parcel) {
            return new RepresentationKey(parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        /* renamed from: a */
        public RepresentationKey[] newArray(int i) {
            return new RepresentationKey[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final int f11989a;

    /* renamed from: b  reason: collision with root package name */
    public final int f11990b;

    /* renamed from: c  reason: collision with root package name */
    public final int f11991c;

    public int describeContents() {
        return 0;
    }

    public RepresentationKey(int i, int i2, int i3) {
        this.f11989a = i;
        this.f11990b = i2;
        this.f11991c = i3;
    }

    public String toString() {
        return this.f11989a + "." + this.f11990b + "." + this.f11991c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f11989a);
        parcel.writeInt(this.f11990b);
        parcel.writeInt(this.f11991c);
    }

    /* renamed from: a */
    public int compareTo(RepresentationKey representationKey) {
        int i = this.f11989a - representationKey.f11989a;
        if (i != 0) {
            return i;
        }
        int i2 = this.f11990b - representationKey.f11990b;
        return i2 == 0 ? this.f11991c - representationKey.f11991c : i2;
    }
}
