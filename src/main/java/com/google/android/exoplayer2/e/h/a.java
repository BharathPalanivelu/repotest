package com.google.android.exoplayer2.e.h;

import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.e.f;
import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.e.h;
import com.google.android.exoplayer2.e.i;
import com.google.android.exoplayer2.e.l;
import com.google.android.exoplayer2.e.m;
import com.google.android.exoplayer2.e.n;
import com.google.android.exoplayer2.j;
import com.tencent.imsdk.TIMGroupManager;
import java.io.IOException;
import java.util.List;

public final class a implements f, m {

    /* renamed from: a  reason: collision with root package name */
    public static final i f9753a = new i() {
        public f[] a() {
            return new f[]{new a()};
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private h f9754b;

    /* renamed from: c  reason: collision with root package name */
    private n f9755c;

    /* renamed from: d  reason: collision with root package name */
    private b f9756d;

    /* renamed from: e  reason: collision with root package name */
    private int f9757e;

    /* renamed from: f  reason: collision with root package name */
    private int f9758f;

    public boolean a() {
        return true;
    }

    public void c() {
    }

    public boolean a(g gVar) throws IOException, InterruptedException {
        return c.a(gVar) != null;
    }

    public void a(h hVar) {
        this.f9754b = hVar;
        this.f9755c = hVar.a(0, 1);
        this.f9756d = null;
        hVar.a();
    }

    public void a(long j, long j2) {
        this.f9758f = 0;
    }

    public int a(g gVar, l lVar) throws IOException, InterruptedException {
        if (this.f9756d == null) {
            this.f9756d = c.a(gVar);
            b bVar = this.f9756d;
            if (bVar != null) {
                this.f9755c.a(j.a((String) null, "audio/raw", (String) null, bVar.c(), (int) TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_LAST_MSG, this.f9756d.e(), this.f9756d.d(), this.f9756d.g(), (List<byte[]>) null, (com.google.android.exoplayer2.c.a) null, 0, (String) null));
                this.f9757e = this.f9756d.b();
            } else {
                throw new ak("Unsupported or unrecognized wav header.");
            }
        }
        if (!this.f9756d.f()) {
            c.a(gVar, this.f9756d);
            this.f9754b.a(this);
        }
        int a2 = this.f9755c.a(gVar, TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_LAST_MSG - this.f9758f, true);
        if (a2 != -1) {
            this.f9758f += a2;
        }
        int i = this.f9758f / this.f9757e;
        if (i > 0) {
            long b2 = this.f9756d.b(gVar.c() - ((long) this.f9758f));
            int i2 = i * this.f9757e;
            this.f9758f -= i2;
            this.f9755c.a(b2, 1, i2, this.f9758f, (byte[]) null);
        }
        if (a2 == -1) {
            return -1;
        }
        return 0;
    }

    public long b() {
        return this.f9756d.a();
    }

    public long b(long j) {
        return this.f9756d.a(j);
    }
}
