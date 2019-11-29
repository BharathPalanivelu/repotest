package com.google.android.exoplayer2.f.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.n.k;
import com.google.android.exoplayer2.n.q;

public final class g extends b {
    public static final Parcelable.Creator<g> CREATOR = new Parcelable.Creator<g>() {
        /* renamed from: a */
        public g createFromParcel(Parcel parcel) {
            return new g(parcel.readLong(), parcel.readLong());
        }

        /* renamed from: a */
        public g[] newArray(int i) {
            return new g[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final long f9852a;

    /* renamed from: b  reason: collision with root package name */
    public final long f9853b;

    private g(long j, long j2) {
        this.f9852a = j;
        this.f9853b = j2;
    }

    static g a(k kVar, long j, q qVar) {
        long a2 = a(kVar, j);
        return new g(a2, qVar.b(a2));
    }

    static long a(k kVar, long j) {
        long g2 = (long) kVar.g();
        if ((128 & g2) != 0) {
            return 8589934591L & ((((g2 & 1) << 32) | kVar.l()) + j);
        }
        return -9223372036854775807L;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f9852a);
        parcel.writeLong(this.f9853b);
    }
}
