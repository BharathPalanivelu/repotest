package com.google.android.exoplayer2.source.d.a;

import android.net.Uri;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.n.s;
import com.google.android.exoplayer2.n.t;
import com.path.android.jobqueue.JobManager;
import java.util.List;
import java.util.UUID;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f11783a;

    /* renamed from: b  reason: collision with root package name */
    public final int f11784b;

    /* renamed from: c  reason: collision with root package name */
    public final int f11785c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f11786d;

    /* renamed from: e  reason: collision with root package name */
    public final C0191a f11787e;

    /* renamed from: f  reason: collision with root package name */
    public final b[] f11788f;

    /* renamed from: g  reason: collision with root package name */
    public final long f11789g;
    public final long h;

    public a(int i, int i2, long j, long j2, long j3, int i3, boolean z, C0191a aVar, b[] bVarArr) {
        long j4;
        this.f11783a = i;
        this.f11784b = i2;
        this.f11785c = i3;
        this.f11786d = z;
        this.f11787e = aVar;
        this.f11788f = bVarArr;
        long j5 = -9223372036854775807L;
        if (j3 == 0) {
            j4 = -9223372036854775807L;
        } else {
            j4 = t.a(j3, (long) JobManager.NS_PER_MS, j);
        }
        this.h = j4;
        this.f11789g = j2 != 0 ? t.a(j2, (long) JobManager.NS_PER_MS, j) : j5;
    }

    /* renamed from: com.google.android.exoplayer2.source.d.a.a$a  reason: collision with other inner class name */
    public static class C0191a {

        /* renamed from: a  reason: collision with root package name */
        public final UUID f11791a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f11792b;

        public C0191a(UUID uuid, byte[] bArr) {
            this.f11791a = uuid;
            this.f11792b = bArr;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f11793a;

        /* renamed from: b  reason: collision with root package name */
        public final String f11794b;

        /* renamed from: c  reason: collision with root package name */
        public final long f11795c;

        /* renamed from: d  reason: collision with root package name */
        public final String f11796d;

        /* renamed from: e  reason: collision with root package name */
        public final int f11797e;

        /* renamed from: f  reason: collision with root package name */
        public final int f11798f;

        /* renamed from: g  reason: collision with root package name */
        public final int f11799g;
        public final int h;
        public final String i;
        public final j[] j;
        public final int k;
        private final String l;
        private final String m;
        private final List<Long> n;
        private final long[] o;
        private final long p;

        public b(String str, String str2, int i2, String str3, long j2, String str4, int i3, int i4, int i5, int i6, String str5, j[] jVarArr, List<Long> list, long j3) {
            List<Long> list2 = list;
            this.l = str;
            this.m = str2;
            this.f11793a = i2;
            this.f11794b = str3;
            this.f11795c = j2;
            this.f11796d = str4;
            this.f11797e = i3;
            this.f11798f = i4;
            this.f11799g = i5;
            this.h = i6;
            this.i = str5;
            this.j = jVarArr;
            this.k = list.size();
            this.n = list2;
            this.p = t.a(j3, (long) JobManager.NS_PER_MS, j2);
            this.o = t.a(list2, (long) JobManager.NS_PER_MS, j2);
        }

        public int a(long j2) {
            return t.a(this.o, j2, true, true);
        }

        public long a(int i2) {
            return this.o[i2];
        }

        public long b(int i2) {
            if (i2 == this.k - 1) {
                return this.p;
            }
            long[] jArr = this.o;
            return jArr[i2 + 1] - jArr[i2];
        }

        public Uri a(int i2, int i3) {
            boolean z = true;
            com.google.android.exoplayer2.n.a.b(this.j != null);
            com.google.android.exoplayer2.n.a.b(this.n != null);
            if (i3 >= this.n.size()) {
                z = false;
            }
            com.google.android.exoplayer2.n.a.b(z);
            String num = Integer.toString(this.j[i2].f10423b);
            String l2 = this.n.get(i3).toString();
            return s.a(this.l, this.m.replace("{bitrate}", num).replace("{Bitrate}", num).replace("{start time}", l2).replace("{start_time}", l2));
        }
    }
}
