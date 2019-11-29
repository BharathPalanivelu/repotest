package com.google.android.exoplayer2.source.a;

import android.util.SparseArray;
import com.google.android.exoplayer2.e.e;
import com.google.android.exoplayer2.e.f;
import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.e.h;
import com.google.android.exoplayer2.e.m;
import com.google.android.exoplayer2.e.n;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.n.k;
import java.io.IOException;

public final class d implements h {

    /* renamed from: a  reason: collision with root package name */
    public final f f11503a;

    /* renamed from: b  reason: collision with root package name */
    private final j f11504b;

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray<a> f11505c = new SparseArray<>();

    /* renamed from: d  reason: collision with root package name */
    private boolean f11506d;

    /* renamed from: e  reason: collision with root package name */
    private b f11507e;

    /* renamed from: f  reason: collision with root package name */
    private m f11508f;

    /* renamed from: g  reason: collision with root package name */
    private j[] f11509g;

    public interface b {
        n a(int i, int i2);
    }

    public d(f fVar, j jVar) {
        this.f11503a = fVar;
        this.f11504b = jVar;
    }

    public m b() {
        return this.f11508f;
    }

    public j[] c() {
        return this.f11509g;
    }

    public void a(b bVar) {
        this.f11507e = bVar;
        if (!this.f11506d) {
            this.f11503a.a((h) this);
            this.f11506d = true;
            return;
        }
        this.f11503a.a(0, 0);
        for (int i = 0; i < this.f11505c.size(); i++) {
            this.f11505c.valueAt(i).a(bVar);
        }
    }

    public n a(int i, int i2) {
        a aVar = this.f11505c.get(i);
        if (aVar != null) {
            return aVar;
        }
        com.google.android.exoplayer2.n.a.b(this.f11509g == null);
        a aVar2 = new a(i, i2, this.f11504b);
        aVar2.a(this.f11507e);
        this.f11505c.put(i, aVar2);
        return aVar2;
    }

    public void a() {
        j[] jVarArr = new j[this.f11505c.size()];
        for (int i = 0; i < this.f11505c.size(); i++) {
            jVarArr[i] = this.f11505c.valueAt(i).f11510a;
        }
        this.f11509g = jVarArr;
    }

    public void a(m mVar) {
        this.f11508f = mVar;
    }

    private static final class a implements n {

        /* renamed from: a  reason: collision with root package name */
        public j f11510a;

        /* renamed from: b  reason: collision with root package name */
        private final int f11511b;

        /* renamed from: c  reason: collision with root package name */
        private final int f11512c;

        /* renamed from: d  reason: collision with root package name */
        private final j f11513d;

        /* renamed from: e  reason: collision with root package name */
        private n f11514e;

        public a(int i, int i2, j jVar) {
            this.f11511b = i;
            this.f11512c = i2;
            this.f11513d = jVar;
        }

        public void a(b bVar) {
            if (bVar == null) {
                this.f11514e = new e();
                return;
            }
            this.f11514e = bVar.a(this.f11511b, this.f11512c);
            n nVar = this.f11514e;
            if (nVar != null) {
                nVar.a(this.f11510a);
            }
        }

        public void a(j jVar) {
            this.f11510a = jVar.a(this.f11513d);
            this.f11514e.a(this.f11510a);
        }

        public int a(g gVar, int i, boolean z) throws IOException, InterruptedException {
            return this.f11514e.a(gVar, i, z);
        }

        public void a(k kVar, int i) {
            this.f11514e.a(kVar, i);
        }

        public void a(long j, int i, int i2, int i3, byte[] bArr) {
            this.f11514e.a(j, i, i2, i3, bArr);
        }
    }
}
