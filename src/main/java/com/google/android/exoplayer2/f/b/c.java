package com.google.android.exoplayer2.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.n.t;
import java.util.Arrays;

public final class c extends h {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() {
        /* renamed from: a */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        /* renamed from: a */
        public c[] newArray(int i) {
            return new c[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f9796a;

    /* renamed from: b  reason: collision with root package name */
    public final int f9797b;

    /* renamed from: c  reason: collision with root package name */
    public final int f9798c;

    /* renamed from: d  reason: collision with root package name */
    public final long f9799d;

    /* renamed from: e  reason: collision with root package name */
    public final long f9800e;

    /* renamed from: g  reason: collision with root package name */
    private final h[] f9801g;

    public int describeContents() {
        return 0;
    }

    public c(String str, int i, int i2, long j, long j2, h[] hVarArr) {
        super("CHAP");
        this.f9796a = str;
        this.f9797b = i;
        this.f9798c = i2;
        this.f9799d = j;
        this.f9800e = j2;
        this.f9801g = hVarArr;
    }

    c(Parcel parcel) {
        super("CHAP");
        this.f9796a = parcel.readString();
        this.f9797b = parcel.readInt();
        this.f9798c = parcel.readInt();
        this.f9799d = parcel.readLong();
        this.f9800e = parcel.readLong();
        int readInt = parcel.readInt();
        this.f9801g = new h[readInt];
        for (int i = 0; i < readInt; i++) {
            this.f9801g[i] = (h) parcel.readParcelable(h.class.getClassLoader());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f9797b == cVar.f9797b && this.f9798c == cVar.f9798c && this.f9799d == cVar.f9799d && this.f9800e == cVar.f9800e && t.a((Object) this.f9796a, (Object) cVar.f9796a) && Arrays.equals(this.f9801g, cVar.f9801g)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = (((((((527 + this.f9797b) * 31) + this.f9798c) * 31) + ((int) this.f9799d)) * 31) + ((int) this.f9800e)) * 31;
        String str = this.f9796a;
        return i + (str != null ? str.hashCode() : 0);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9796a);
        parcel.writeInt(this.f9797b);
        parcel.writeInt(this.f9798c);
        parcel.writeLong(this.f9799d);
        parcel.writeLong(this.f9800e);
        parcel.writeInt(this.f9801g.length);
        for (h writeParcelable : this.f9801g) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }
}
