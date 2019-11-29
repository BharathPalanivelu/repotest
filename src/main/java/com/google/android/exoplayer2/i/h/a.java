package com.google.android.exoplayer2.i.h;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.e;
import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.p;
import com.tencent.imsdk.TIMGroupManager;
import java.io.IOException;
import java.util.List;

public final class a implements e, l {

    /* renamed from: a  reason: collision with root package name */
    public static final h f10390a = new h() {
        public e[] a() {
            return new e[]{new a()};
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private g f10391b;

    /* renamed from: c  reason: collision with root package name */
    private m f10392c;

    /* renamed from: d  reason: collision with root package name */
    private b f10393d;

    /* renamed from: e  reason: collision with root package name */
    private int f10394e;

    /* renamed from: f  reason: collision with root package name */
    private int f10395f;

    public boolean a() {
        return true;
    }

    public void c() {
    }

    public boolean a(f fVar) throws IOException, InterruptedException {
        return c.a(fVar) != null;
    }

    public void a(g gVar) {
        this.f10391b = gVar;
        this.f10392c = gVar.a(0, 1);
        this.f10393d = null;
        gVar.a();
    }

    public void a(long j, long j2) {
        this.f10395f = 0;
    }

    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        if (this.f10393d == null) {
            this.f10393d = c.a(fVar);
            b bVar = this.f10393d;
            if (bVar != null) {
                this.f10392c.a(Format.a((String) null, "audio/raw", (String) null, bVar.c(), (int) TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_LAST_MSG, this.f10393d.e(), this.f10393d.d(), this.f10393d.g(), (List<byte[]>) null, (DrmInitData) null, 0, (String) null));
                this.f10394e = this.f10393d.b();
            } else {
                throw new p("Unsupported or unrecognized wav header.");
            }
        }
        if (!this.f10393d.f()) {
            c.a(fVar, this.f10393d);
            this.f10391b.a(this);
        }
        int a2 = this.f10392c.a(fVar, TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_LAST_MSG - this.f10395f, true);
        if (a2 != -1) {
            this.f10395f += a2;
        }
        int i = this.f10395f / this.f10394e;
        if (i > 0) {
            long b2 = this.f10393d.b(fVar.c() - ((long) this.f10395f));
            int i2 = i * this.f10394e;
            this.f10395f -= i2;
            this.f10392c.a(b2, 1, i2, this.f10395f, (m.a) null);
        }
        if (a2 == -1) {
            return -1;
        }
        return 0;
    }

    public long b() {
        return this.f10393d.a();
    }

    public long b(long j) {
        return this.f10393d.a(j);
    }
}
