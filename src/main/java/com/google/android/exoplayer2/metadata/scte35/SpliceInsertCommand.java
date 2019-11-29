package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.s.l;
import com.google.android.exoplayer2.s.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new Parcelable.Creator<SpliceInsertCommand>() {
        /* renamed from: a */
        public SpliceInsertCommand createFromParcel(Parcel parcel) {
            return new SpliceInsertCommand(parcel);
        }

        /* renamed from: a */
        public SpliceInsertCommand[] newArray(int i) {
            return new SpliceInsertCommand[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final long f10888a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f10889b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f10890c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f10891d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f10892e;

    /* renamed from: f  reason: collision with root package name */
    public final long f10893f;

    /* renamed from: g  reason: collision with root package name */
    public final long f10894g;
    public final List<a> h;
    public final boolean i;
    public final long j;
    public final int k;
    public final int l;
    public final int m;

    private SpliceInsertCommand(long j2, boolean z, boolean z2, boolean z3, boolean z4, long j3, long j4, List<a> list, boolean z5, long j5, int i2, int i3, int i4) {
        this.f10888a = j2;
        this.f10889b = z;
        this.f10890c = z2;
        this.f10891d = z3;
        this.f10892e = z4;
        this.f10893f = j3;
        this.f10894g = j4;
        this.h = Collections.unmodifiableList(list);
        this.i = z5;
        this.j = j5;
        this.k = i2;
        this.l = i3;
        this.m = i4;
    }

    private SpliceInsertCommand(Parcel parcel) {
        this.f10888a = parcel.readLong();
        boolean z = false;
        this.f10889b = parcel.readByte() == 1;
        this.f10890c = parcel.readByte() == 1;
        this.f10891d = parcel.readByte() == 1;
        this.f10892e = parcel.readByte() == 1;
        this.f10893f = parcel.readLong();
        this.f10894g = parcel.readLong();
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

    static SpliceInsertCommand a(l lVar, long j2, s sVar) {
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
        s sVar2 = sVar;
        long l2 = lVar.l();
        boolean z6 = (lVar.g() & 128) != 0;
        List emptyList = Collections.emptyList();
        if (!z6) {
            int g2 = lVar.g();
            boolean z7 = (g2 & 128) != 0;
            boolean z8 = (g2 & 64) != 0;
            boolean z9 = (g2 & 32) != 0;
            boolean z10 = (g2 & 16) != 0;
            long a2 = (!z8 || z10) ? -9223372036854775807L : TimeSignalCommand.a(lVar, j2);
            if (!z8) {
                int g3 = lVar.g();
                list2 = new ArrayList(g3);
                for (int i5 = 0; i5 < g3; i5++) {
                    int g4 = lVar.g();
                    long a3 = !z10 ? TimeSignalCommand.a(lVar, j2) : -9223372036854775807L;
                    list2.add(new a(g4, a3, sVar2.b(a3)));
                }
            } else {
                list2 = emptyList;
            }
            if (z9) {
                long g5 = (long) lVar.g();
                z5 = (128 & g5) != 0;
                j5 = lVar.l() | ((g5 & 1) << 32);
            } else {
                j5 = -9223372036854775807L;
                z5 = false;
            }
            int h2 = lVar.h();
            i3 = lVar.g();
            i2 = lVar.g();
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
        return new SpliceInsertCommand(l2, z6, z4, z, z3, j4, sVar2.b(j4), list, z2, j3, i4, i3, i2);
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f10895a;

        /* renamed from: b  reason: collision with root package name */
        public final long f10896b;

        /* renamed from: c  reason: collision with root package name */
        public final long f10897c;

        private a(int i, long j, long j2) {
            this.f10895a = i;
            this.f10896b = j;
            this.f10897c = j2;
        }

        public void a(Parcel parcel) {
            parcel.writeInt(this.f10895a);
            parcel.writeLong(this.f10896b);
            parcel.writeLong(this.f10897c);
        }

        public static a b(Parcel parcel) {
            return new a(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f10888a);
        parcel.writeByte(this.f10889b ? (byte) 1 : 0);
        parcel.writeByte(this.f10890c ? (byte) 1 : 0);
        parcel.writeByte(this.f10891d ? (byte) 1 : 0);
        parcel.writeByte(this.f10892e ? (byte) 1 : 0);
        parcel.writeLong(this.f10893f);
        parcel.writeLong(this.f10894g);
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
