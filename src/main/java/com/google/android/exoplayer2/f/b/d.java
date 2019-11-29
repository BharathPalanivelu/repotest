package com.google.android.exoplayer2.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.n.t;
import java.util.Arrays;

public final class d extends h {
    public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() {
        /* renamed from: a */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        /* renamed from: a */
        public d[] newArray(int i) {
            return new d[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f9802a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f9803b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f9804c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f9805d;

    /* renamed from: e  reason: collision with root package name */
    private final h[] f9806e;

    public d(String str, boolean z, boolean z2, String[] strArr, h[] hVarArr) {
        super("CTOC");
        this.f9802a = str;
        this.f9803b = z;
        this.f9804c = z2;
        this.f9805d = strArr;
        this.f9806e = hVarArr;
    }

    d(Parcel parcel) {
        super("CTOC");
        this.f9802a = parcel.readString();
        boolean z = true;
        this.f9803b = parcel.readByte() != 0;
        this.f9804c = parcel.readByte() == 0 ? false : z;
        this.f9805d = parcel.createStringArray();
        int readInt = parcel.readInt();
        this.f9806e = new h[readInt];
        for (int i = 0; i < readInt; i++) {
            this.f9806e[i] = (h) parcel.readParcelable(h.class.getClassLoader());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f9803b != dVar.f9803b || this.f9804c != dVar.f9804c || !t.a((Object) this.f9802a, (Object) dVar.f9802a) || !Arrays.equals(this.f9805d, dVar.f9805d) || !Arrays.equals(this.f9806e, dVar.f9806e)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = (((true + (this.f9803b ? 1 : 0)) * 31) + (this.f9804c ? 1 : 0)) * 31;
        String str = this.f9802a;
        return i + (str != null ? str.hashCode() : 0);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9802a);
        parcel.writeByte(this.f9803b ? (byte) 1 : 0);
        parcel.writeByte(this.f9804c ? (byte) 1 : 0);
        parcel.writeStringArray(this.f9805d);
        parcel.writeInt(this.f9806e.length);
        int i2 = 0;
        while (true) {
            h[] hVarArr = this.f9806e;
            if (i2 < hVarArr.length) {
                parcel.writeParcelable(hVarArr[i2], 0);
                i2++;
            } else {
                return;
            }
        }
    }
}
