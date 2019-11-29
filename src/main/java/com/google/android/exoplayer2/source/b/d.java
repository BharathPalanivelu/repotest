package com.google.android.exoplayer2.source.b;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.e;
import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.m;
import java.io.IOException;

public final class d implements g {

    /* renamed from: a  reason: collision with root package name */
    public final e f11550a;

    /* renamed from: b  reason: collision with root package name */
    private final Format f11551b;

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray<a> f11552c = new SparseArray<>();

    /* renamed from: d  reason: collision with root package name */
    private boolean f11553d;

    /* renamed from: e  reason: collision with root package name */
    private b f11554e;

    /* renamed from: f  reason: collision with root package name */
    private l f11555f;

    /* renamed from: g  reason: collision with root package name */
    private Format[] f11556g;

    public interface b {
        m a(int i, int i2);
    }

    public d(e eVar, Format format) {
        this.f11550a = eVar;
        this.f11551b = format;
    }

    public l b() {
        return this.f11555f;
    }

    public Format[] c() {
        return this.f11556g;
    }

    public void a(b bVar) {
        this.f11554e = bVar;
        if (!this.f11553d) {
            this.f11550a.a((g) this);
            this.f11553d = true;
            return;
        }
        this.f11550a.a(0, 0);
        for (int i = 0; i < this.f11552c.size(); i++) {
            this.f11552c.valueAt(i).a(bVar);
        }
    }

    public m a(int i, int i2) {
        a aVar = this.f11552c.get(i);
        if (aVar != null) {
            return aVar;
        }
        com.google.android.exoplayer2.s.a.b(this.f11556g == null);
        a aVar2 = new a(i, i2, this.f11551b);
        aVar2.a(this.f11554e);
        this.f11552c.put(i, aVar2);
        return aVar2;
    }

    public void a() {
        Format[] formatArr = new Format[this.f11552c.size()];
        for (int i = 0; i < this.f11552c.size(); i++) {
            formatArr[i] = this.f11552c.valueAt(i).f11557a;
        }
        this.f11556g = formatArr;
    }

    public void a(l lVar) {
        this.f11555f = lVar;
    }

    private static final class a implements m {

        /* renamed from: a  reason: collision with root package name */
        public Format f11557a;

        /* renamed from: b  reason: collision with root package name */
        private final int f11558b;

        /* renamed from: c  reason: collision with root package name */
        private final int f11559c;

        /* renamed from: d  reason: collision with root package name */
        private final Format f11560d;

        /* renamed from: e  reason: collision with root package name */
        private m f11561e;

        public a(int i, int i2, Format format) {
            this.f11558b = i;
            this.f11559c = i2;
            this.f11560d = format;
        }

        public void a(b bVar) {
            if (bVar == null) {
                this.f11561e = new com.google.android.exoplayer2.i.d();
                return;
            }
            this.f11561e = bVar.a(this.f11558b, this.f11559c);
            m mVar = this.f11561e;
            if (mVar != null) {
                mVar.a(this.f11557a);
            }
        }

        public void a(Format format) {
            this.f11557a = format.a(this.f11560d);
            this.f11561e.a(this.f11557a);
        }

        public int a(f fVar, int i, boolean z) throws IOException, InterruptedException {
            return this.f11561e.a(fVar, i, z);
        }

        public void a(com.google.android.exoplayer2.s.l lVar, int i) {
            this.f11561e.a(lVar, i);
        }

        public void a(long j, int i, int i2, int i3, m.a aVar) {
            this.f11561e.a(j, i, i2, i3, aVar);
        }
    }
}
