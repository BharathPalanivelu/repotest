package com.google.android.exoplayer2.f;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() {
        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* renamed from: a */
        public a[] newArray(int i) {
            return new a[0];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final C0166a[] f9781a;

    /* renamed from: com.google.android.exoplayer2.f.a$a  reason: collision with other inner class name */
    public interface C0166a extends Parcelable {
    }

    public int describeContents() {
        return 0;
    }

    public a(C0166a... aVarArr) {
        this.f9781a = aVarArr == null ? new C0166a[0] : aVarArr;
    }

    public a(List<? extends C0166a> list) {
        if (list != null) {
            this.f9781a = new C0166a[list.size()];
            list.toArray(this.f9781a);
            return;
        }
        this.f9781a = new C0166a[0];
    }

    a(Parcel parcel) {
        this.f9781a = new C0166a[parcel.readInt()];
        int i = 0;
        while (true) {
            C0166a[] aVarArr = this.f9781a;
            if (i < aVarArr.length) {
                aVarArr[i] = (C0166a) parcel.readParcelable(C0166a.class.getClassLoader());
                i++;
            } else {
                return;
            }
        }
    }

    public int a() {
        return this.f9781a.length;
    }

    public C0166a a(int i) {
        return this.f9781a[i];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f9781a, ((a) obj).f9781a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f9781a);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f9781a.length);
        for (C0166a writeParcelable : this.f9781a) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }
}
