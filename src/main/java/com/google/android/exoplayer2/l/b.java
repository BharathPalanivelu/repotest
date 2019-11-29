package com.google.android.exoplayer2.l;

import android.os.SystemClock;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.source.ac;
import java.util.Arrays;
import java.util.Comparator;

public abstract class b implements f {

    /* renamed from: a  reason: collision with root package name */
    protected final ac f10701a;

    /* renamed from: b  reason: collision with root package name */
    protected final int f10702b;

    /* renamed from: c  reason: collision with root package name */
    protected final int[] f10703c;

    /* renamed from: d  reason: collision with root package name */
    private final j[] f10704d;

    /* renamed from: e  reason: collision with root package name */
    private final long[] f10705e;

    /* renamed from: f  reason: collision with root package name */
    private int f10706f;

    public b(ac acVar, int... iArr) {
        int i = 0;
        com.google.android.exoplayer2.n.a.b(iArr.length > 0);
        this.f10701a = (ac) com.google.android.exoplayer2.n.a.a(acVar);
        this.f10702b = iArr.length;
        this.f10704d = new j[this.f10702b];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.f10704d[i2] = acVar.a(iArr[i2]);
        }
        Arrays.sort(this.f10704d, new a());
        this.f10703c = new int[this.f10702b];
        while (true) {
            int i3 = this.f10702b;
            if (i < i3) {
                this.f10703c[i] = acVar.a(this.f10704d[i]);
                i++;
            } else {
                this.f10705e = new long[i3];
                return;
            }
        }
    }

    public final ac d() {
        return this.f10701a;
    }

    public final int e() {
        return this.f10703c.length;
    }

    public final j a(int i) {
        return this.f10704d[i];
    }

    public final int b(int i) {
        return this.f10703c[i];
    }

    public final int a(j jVar) {
        for (int i = 0; i < this.f10702b; i++) {
            if (this.f10704d[i] == jVar) {
                return i;
            }
        }
        return -1;
    }

    public final int c(int i) {
        for (int i2 = 0; i2 < this.f10702b; i2++) {
            if (this.f10703c[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public final j f() {
        return this.f10704d[a()];
    }

    public final int g() {
        return this.f10703c[a()];
    }

    public final boolean a(int i, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean b2 = b(i, elapsedRealtime);
        int i2 = 0;
        while (i2 < this.f10702b && !b2) {
            b2 = i2 != i && !b(i2, elapsedRealtime);
            i2++;
        }
        if (!b2) {
            return false;
        }
        long[] jArr = this.f10705e;
        jArr[i] = Math.max(jArr[i], elapsedRealtime + j);
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean b(int i, long j) {
        return this.f10705e[i] > j;
    }

    public int hashCode() {
        if (this.f10706f == 0) {
            this.f10706f = (System.identityHashCode(this.f10701a) * 31) + Arrays.hashCode(this.f10703c);
        }
        return this.f10706f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f10701a != bVar.f10701a || !Arrays.equals(this.f10703c, bVar.f10703c)) {
            return false;
        }
        return true;
    }

    private static final class a implements Comparator<j> {
        private a() {
        }

        /* renamed from: a */
        public int compare(j jVar, j jVar2) {
            return jVar2.f10423b - jVar.f10423b;
        }
    }
}
