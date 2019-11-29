package com.google.android.exoplayer2.q;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.o;
import java.util.Arrays;
import java.util.Comparator;

public abstract class b implements f {

    /* renamed from: a  reason: collision with root package name */
    protected final o f11250a;

    /* renamed from: b  reason: collision with root package name */
    protected final int f11251b;

    /* renamed from: c  reason: collision with root package name */
    protected final int[] f11252c;

    /* renamed from: d  reason: collision with root package name */
    private final Format[] f11253d;

    /* renamed from: e  reason: collision with root package name */
    private final long[] f11254e;

    /* renamed from: f  reason: collision with root package name */
    private int f11255f;

    public b(o oVar, int... iArr) {
        int i = 0;
        com.google.android.exoplayer2.s.a.b(iArr.length > 0);
        this.f11250a = (o) com.google.android.exoplayer2.s.a.a(oVar);
        this.f11251b = iArr.length;
        this.f11253d = new Format[this.f11251b];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.f11253d[i2] = oVar.a(iArr[i2]);
        }
        Arrays.sort(this.f11253d, new a());
        this.f11252c = new int[this.f11251b];
        while (true) {
            int i3 = this.f11251b;
            if (i < i3) {
                this.f11252c[i] = oVar.a(this.f11253d[i]);
                i++;
            } else {
                this.f11254e = new long[i3];
                return;
            }
        }
    }

    public final o d() {
        return this.f11250a;
    }

    public final int e() {
        return this.f11252c.length;
    }

    public final Format a(int i) {
        return this.f11253d[i];
    }

    public final int b(int i) {
        return this.f11252c[i];
    }

    public final int a(Format format) {
        for (int i = 0; i < this.f11251b; i++) {
            if (this.f11253d[i] == format) {
                return i;
            }
        }
        return -1;
    }

    public final int c(int i) {
        for (int i2 = 0; i2 < this.f11251b; i2++) {
            if (this.f11252c[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public final Format f() {
        return this.f11253d[a()];
    }

    public final int g() {
        return this.f11252c[a()];
    }

    public final boolean a(int i, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean b2 = b(i, elapsedRealtime);
        int i2 = 0;
        while (i2 < this.f11251b && !b2) {
            b2 = i2 != i && !b(i2, elapsedRealtime);
            i2++;
        }
        if (!b2) {
            return false;
        }
        long[] jArr = this.f11254e;
        jArr[i] = Math.max(jArr[i], elapsedRealtime + j);
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean b(int i, long j) {
        return this.f11254e[i] > j;
    }

    public int hashCode() {
        if (this.f11255f == 0) {
            this.f11255f = (System.identityHashCode(this.f11250a) * 31) + Arrays.hashCode(this.f11252c);
        }
        return this.f11255f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f11250a != bVar.f11250a || !Arrays.equals(this.f11252c, bVar.f11252c)) {
            return false;
        }
        return true;
    }

    private static final class a implements Comparator<Format> {
        private a() {
        }

        /* renamed from: a */
        public int compare(Format format, Format format2) {
            return format2.f8954b - format.f8954b;
        }
    }
}
