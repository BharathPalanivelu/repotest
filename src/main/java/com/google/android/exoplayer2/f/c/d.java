package com.google.android.exoplayer2.f.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.n.k;
import com.google.android.exoplayer2.n.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class d extends b {
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
    public final long f9832a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f9833b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f9834c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f9835d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f9836e;

    /* renamed from: f  reason: collision with root package name */
    public final long f9837f;

    /* renamed from: g  reason: collision with root package name */
    public final long f9838g;
    public final List<a> h;
    public final boolean i;
    public final long j;
    public final int k;
    public final int l;
    public final int m;

    private d(long j2, boolean z, boolean z2, boolean z3, boolean z4, long j3, long j4, List<a> list, boolean z5, long j5, int i2, int i3, int i4) {
        this.f9832a = j2;
        this.f9833b = z;
        this.f9834c = z2;
        this.f9835d = z3;
        this.f9836e = z4;
        this.f9837f = j3;
        this.f9838g = j4;
        this.h = Collections.unmodifiableList(list);
        this.i = z5;
        this.j = j5;
        this.k = i2;
        this.l = i3;
        this.m = i4;
    }

    private d(Parcel parcel) {
        this.f9832a = parcel.readLong();
        boolean z = false;
        this.f9833b = parcel.readByte() == 1;
        this.f9834c = parcel.readByte() == 1;
        this.f9835d = parcel.readByte() == 1;
        this.f9836e = parcel.readByte() == 1;
        this.f9837f = parcel.readLong();
        this.f9838g = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(a.b(parcel));
        }
        this.h = Collections.unmodifiableList(arrayList);
        this.i = parcel.readByte() == 1 ? true : z;
        this.j = parcel.readLong();
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
    }

    static d a(k kVar, long j2, q qVar) {
        boolean z;
        int i2;
        int i3;
        int i4;
        long j3;
        boolean z2;
        List list;
        long j4;
        boolean z3;
        boolean z4;
        List list2;
        boolean z5;
        long j5;
        q qVar2 = qVar;
        long l2 = kVar.l();
        boolean z6 = (kVar.g() & 128) != 0;
        List emptyList = Collections.emptyList();
        if (!z6) {
            int g2 = kVar.g();
            boolean z7 = (g2 & 128) != 0;
            boolean z8 = (g2 & 64) != 0;
            boolean z9 = (g2 & 32) != 0;
            boolean z10 = (g2 & 16) != 0;
            long a2 = (!z8 || z10) ? -9223372036854775807L : g.a(kVar, j2);
            if (!z8) {
                int g3 = kVar.g();
                list2 = new ArrayList(g3);
                for (int i5 = 0; i5 < g3; i5++) {
                    int g4 = kVar.g();
                    long a3 = !z10 ? g.a(kVar, j2) : -9223372036854775807L;
                    list2.add(new a(g4, a3, qVar2.b(a3)));
                }
            } else {
                list2 = emptyList;
            }
            if (z9) {
                long g5 = (long) kVar.g();
                z5 = (128 & g5) != 0;
                j5 = kVar.l() | ((g5 & 1) << 32);
            } else {
                j5 = -9223372036854775807L;
                z5 = false;
            }
            int h2 = kVar.h();
            i3 = kVar.g();
            i2 = kVar.g();
            z4 = z7;
            z = z8;
            list = list2;
            boolean z11 = z5;
            i4 = h2;
            long j6 = j5;
            z3 = z10;
            j4 = a2;
            z2 = z11;
            j3 = j6;
        } else {
            list = emptyList;
            z4 = false;
            z3 = false;
            j4 = -9223372036854775807L;
            z2 = false;
            j3 = -9223372036854775807L;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            z = false;
        }
        return new d(l2, z6, z4, z, z3, j4, qVar2.b(j4), list, z2, j3, i4, i3, i2);
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f9839a;

        /* renamed from: b  reason: collision with root package name */
        public final long f9840b;

        /* renamed from: c  reason: collision with root package name */
        public final long f9841c;

        private a(int i, long j, long j2) {
            this.f9839a = i;
            this.f9840b = j;
            this.f9841c = j2;
        }

        public void a(Parcel parcel) {
            parcel.writeInt(this.f9839a);
            parcel.writeLong(this.f9840b);
            parcel.writeLong(this.f9841c);
        }

        public static a b(Parcel parcel) {
            return new a(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f9832a);
        parcel.writeByte(this.f9833b ? (byte) 1 : 0);
        parcel.writeByte(this.f9834c ? (byte) 1 : 0);
        parcel.writeByte(this.f9835d ? (byte) 1 : 0);
        parcel.writeByte(this.f9836e ? (byte) 1 : 0);
        parcel.writeLong(this.f9837f);
        parcel.writeLong(this.f9838g);
        int size = this.h.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            this.h.get(i3).a(parcel);
        }
        parcel.writeByte(this.i ? (byte) 1 : 0);
        parcel.writeLong(this.j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
    }
}
