package com.google.android.exoplayer2.f.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.n.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class f extends b {
    public static final Parcelable.Creator<f> CREATOR = new Parcelable.Creator<f>() {
        /* renamed from: a */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        /* renamed from: a */
        public f[] newArray(int i) {
            return new f[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final List<b> f9842a;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final long f9845a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f9846b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f9847c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f9848d;

        /* renamed from: e  reason: collision with root package name */
        public final long f9849e;

        /* renamed from: f  reason: collision with root package name */
        public final List<a> f9850f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f9851g;
        public final long h;
        public final int i;
        public final int j;
        public final int k;

        private b(long j2, boolean z, boolean z2, boolean z3, List<a> list, long j3, boolean z4, long j4, int i2, int i3, int i4) {
            this.f9845a = j2;
            this.f9846b = z;
            this.f9847c = z2;
            this.f9848d = z3;
            this.f9850f = Collections.unmodifiableList(list);
            this.f9849e = j3;
            this.f9851g = z4;
            this.h = j4;
            this.i = i2;
            this.j = i3;
            this.k = i4;
        }

        private b(Parcel parcel) {
            this.f9845a = parcel.readLong();
            boolean z = false;
            this.f9846b = parcel.readByte() == 1;
            this.f9847c = parcel.readByte() == 1;
            this.f9848d = parcel.readByte() == 1;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                arrayList.add(a.b(parcel));
            }
            this.f9850f = Collections.unmodifiableList(arrayList);
            this.f9849e = parcel.readLong();
            this.f9851g = parcel.readByte() == 1 ? true : z;
            this.h = parcel.readLong();
            this.i = parcel.readInt();
            this.j = parcel.readInt();
            this.k = parcel.readInt();
        }

        /* access modifiers changed from: private */
        public static b b(k kVar) {
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
            long l = kVar.l();
            boolean z5 = (kVar.g() & 128) != 0;
            ArrayList arrayList2 = new ArrayList();
            if (!z5) {
                int g2 = kVar.g();
                boolean z6 = (g2 & 128) != 0;
                boolean z7 = (g2 & 64) != 0;
                boolean z8 = (g2 & 32) != 0;
                long l2 = z7 ? kVar.l() : -9223372036854775807L;
                if (!z7) {
                    int g3 = kVar.g();
                    ArrayList arrayList3 = new ArrayList(g3);
                    for (int i5 = 0; i5 < g3; i5++) {
                        arrayList3.add(new a(kVar.g(), kVar.l()));
                    }
                    arrayList2 = arrayList3;
                }
                if (z8) {
                    long g4 = (long) kVar.g();
                    z4 = (128 & g4) != 0;
                    j4 = kVar.l() | ((g4 & 1) << 32);
                } else {
                    z4 = false;
                    j4 = -9223372036854775807L;
                }
                int h2 = kVar.h();
                int g5 = kVar.g();
                i2 = kVar.g();
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
            parcel.writeLong(this.f9845a);
            parcel.writeByte(this.f9846b ? (byte) 1 : 0);
            parcel.writeByte(this.f9847c ? (byte) 1 : 0);
            parcel.writeByte(this.f9848d ? (byte) 1 : 0);
            int size = this.f9850f.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.f9850f.get(i2).c(parcel);
            }
            parcel.writeLong(this.f9849e);
            parcel.writeByte(this.f9851g ? (byte) 1 : 0);
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
        public final int f9843a;

        /* renamed from: b  reason: collision with root package name */
        public final long f9844b;

        private a(int i, long j) {
            this.f9843a = i;
            this.f9844b = j;
        }

        /* access modifiers changed from: private */
        public static a b(Parcel parcel) {
            return new a(parcel.readInt(), parcel.readLong());
        }

        /* access modifiers changed from: private */
        public void c(Parcel parcel) {
            parcel.writeInt(this.f9843a);
            parcel.writeLong(this.f9844b);
        }
    }

    private f(List<b> list) {
        this.f9842a = Collections.unmodifiableList(list);
    }

    private f(Parcel parcel) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(b.c(parcel));
        }
        this.f9842a = Collections.unmodifiableList(arrayList);
    }

    static f a(k kVar) {
        int g2 = kVar.g();
        ArrayList arrayList = new ArrayList(g2);
        for (int i = 0; i < g2; i++) {
            arrayList.add(b.b(kVar));
        }
        return new f((List<b>) arrayList);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int size = this.f9842a.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.f9842a.get(i2).b(parcel);
        }
    }
}
