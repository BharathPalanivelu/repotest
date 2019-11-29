package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.s.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new Parcelable.Creator<SpliceScheduleCommand>() {
        /* renamed from: a */
        public SpliceScheduleCommand createFromParcel(Parcel parcel) {
            return new SpliceScheduleCommand(parcel);
        }

        /* renamed from: a */
        public SpliceScheduleCommand[] newArray(int i) {
            return new SpliceScheduleCommand[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final List<b> f10898a;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final long f10901a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f10902b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f10903c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f10904d;

        /* renamed from: e  reason: collision with root package name */
        public final long f10905e;

        /* renamed from: f  reason: collision with root package name */
        public final List<a> f10906f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f10907g;
        public final long h;
        public final int i;
        public final int j;
        public final int k;

        private b(long j2, boolean z, boolean z2, boolean z3, List<a> list, long j3, boolean z4, long j4, int i2, int i3, int i4) {
            this.f10901a = j2;
            this.f10902b = z;
            this.f10903c = z2;
            this.f10904d = z3;
            this.f10906f = Collections.unmodifiableList(list);
            this.f10905e = j3;
            this.f10907g = z4;
            this.h = j4;
            this.i = i2;
            this.j = i3;
            this.k = i4;
        }

        private b(Parcel parcel) {
            this.f10901a = parcel.readLong();
            boolean z = false;
            this.f10902b = parcel.readByte() == 1;
            this.f10903c = parcel.readByte() == 1;
            this.f10904d = parcel.readByte() == 1;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                arrayList.add(a.b(parcel));
            }
            this.f10906f = Collections.unmodifiableList(arrayList);
            this.f10905e = parcel.readLong();
            this.f10907g = parcel.readByte() == 1 ? true : z;
            this.h = parcel.readLong();
            this.i = parcel.readInt();
            this.j = parcel.readInt();
            this.k = parcel.readInt();
        }

        /* access modifiers changed from: private */
        public static b b(l lVar) {
            boolean z;
            int i2;
            int i3;
            int i4;
            long j2;
            boolean z2;
            long j3;
            ArrayList arrayList;
            boolean z3;
            long j4;
            boolean z4;
            long l = lVar.l();
            boolean z5 = (lVar.g() & 128) != 0;
            ArrayList arrayList2 = new ArrayList();
            if (!z5) {
                int g2 = lVar.g();
                boolean z6 = (g2 & 128) != 0;
                boolean z7 = (g2 & 64) != 0;
                boolean z8 = (g2 & 32) != 0;
                long l2 = z7 ? lVar.l() : -9223372036854775807L;
                if (!z7) {
                    int g3 = lVar.g();
                    ArrayList arrayList3 = new ArrayList(g3);
                    for (int i5 = 0; i5 < g3; i5++) {
                        arrayList3.add(new a(lVar.g(), lVar.l()));
                    }
                    arrayList2 = arrayList3;
                }
                if (z8) {
                    long g4 = (long) lVar.g();
                    z4 = (128 & g4) != 0;
                    j4 = lVar.l() | ((g4 & 1) << 32);
                } else {
                    z4 = false;
                    j4 = -9223372036854775807L;
                }
                int h2 = lVar.h();
                int g5 = lVar.g();
                i2 = lVar.g();
                z = z7;
                j3 = l2;
                j2 = j4;
                arrayList = arrayList2;
                i4 = h2;
                i3 = g5;
                z3 = z6;
                z2 = z4;
            } else {
                arrayList = arrayList2;
                z3 = false;
                j3 = -9223372036854775807L;
                z2 = false;
                j2 = -9223372036854775807L;
                i4 = 0;
                i3 = 0;
                i2 = 0;
                z = false;
            }
            return new b(l, z5, z3, z, arrayList, j3, z2, j2, i4, i3, i2);
        }

        /* access modifiers changed from: private */
        public void b(Parcel parcel) {
            parcel.writeLong(this.f10901a);
            parcel.writeByte(this.f10902b ? (byte) 1 : 0);
            parcel.writeByte(this.f10903c ? (byte) 1 : 0);
            parcel.writeByte(this.f10904d ? (byte) 1 : 0);
            int size = this.f10906f.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.f10906f.get(i2).c(parcel);
            }
            parcel.writeLong(this.f10905e);
            parcel.writeByte(this.f10907g ? (byte) 1 : 0);
            parcel.writeLong(this.h);
            parcel.writeInt(this.i);
            parcel.writeInt(this.j);
            parcel.writeInt(this.k);
        }

        /* access modifiers changed from: private */
        public static b c(Parcel parcel) {
            return new b(parcel);
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f10899a;

        /* renamed from: b  reason: collision with root package name */
        public final long f10900b;

        private a(int i, long j) {
            this.f10899a = i;
            this.f10900b = j;
        }

        /* access modifiers changed from: private */
        public static a b(Parcel parcel) {
            return new a(parcel.readInt(), parcel.readLong());
        }

        /* access modifiers changed from: private */
        public void c(Parcel parcel) {
            parcel.writeInt(this.f10899a);
            parcel.writeLong(this.f10900b);
        }
    }

    private SpliceScheduleCommand(List<b> list) {
        this.f10898a = Collections.unmodifiableList(list);
    }

    private SpliceScheduleCommand(Parcel parcel) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(b.c(parcel));
        }
        this.f10898a = Collections.unmodifiableList(arrayList);
    }

    static SpliceScheduleCommand a(l lVar) {
        int g2 = lVar.g();
        ArrayList arrayList = new ArrayList(g2);
        for (int i = 0; i < g2; i++) {
            arrayList.add(b.b(lVar));
        }
        return new SpliceScheduleCommand((List<b>) arrayList);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int size = this.f10898a.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.f10898a.get(i2).b(parcel);
        }
    }
}
