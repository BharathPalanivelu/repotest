package com.tencent.liteav.beauty.b.a;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.b.b;
import com.tencent.liteav.beauty.b.h;
import com.tencent.liteav.beauty.b.q;

public class a extends b {
    private int A = 0;
    private float B = 1.0f;
    private final float C = 0.7f;
    private float D = 0.8f;
    private float E = 2.0f;
    private int F = 0;
    private int G = 0;
    private int H = 0;
    private int I = 0;
    private c r = null;
    private d s = null;
    private e t = null;
    private h u = null;
    private q v = null;
    private b w = null;
    private String x = "TXCBeauty2Filter";
    private int y = 0;
    private int z = 0;

    public boolean c(int i, int i2) {
        return d(i, i2);
    }

    public void a(int i, int i2) {
        if (this.f31317e != i || this.f31318f != i2) {
            this.f31317e = i;
            this.f31318f = i2;
            d(i, i2);
        }
    }

    public void c(int i) {
        e eVar = this.t;
        if (eVar != null) {
            eVar.a(((float) i) / 10.0f);
        }
        this.y = i;
        g(i);
    }

    public void d(int i) {
        b bVar = this.w;
        if (bVar != null) {
            bVar.a(((float) i) / 10.0f);
        }
        this.z = i;
    }

    public void e(int i) {
        b bVar = this.w;
        if (bVar != null) {
            bVar.b(((float) i) / 10.0f);
        }
        this.A = i;
    }

    private void g(int i) {
        this.B = 1.0f - (((float) i) / 50.0f);
        h hVar = this.u;
        if (hVar != null) {
            hVar.a(this.B);
        }
    }

    public void f(int i) {
        this.D = (((float) i) / 12.0f) + 0.7f;
        String str = this.x;
        TXCLog.i(str, "set mSharpenLevel " + i);
        q qVar = this.v;
        if (qVar != null) {
            qVar.a(this.D);
        }
    }

    public int b(int i) {
        if (1.0f != this.E) {
            GLES20.glViewport(0, 0, this.H, this.I);
        }
        int c2 = this.t.c(this.s.b(i), i);
        if (1.0f != this.E) {
            GLES20.glViewport(0, 0, this.F, this.G);
        }
        if (this.D > 0.7f) {
            c2 = this.v.b(c2);
        }
        return this.w.c(c2, i);
    }

    private boolean d(int i, int i2) {
        this.F = i;
        this.G = i2;
        this.H = i;
        this.I = i2;
        float f2 = this.E;
        if (1.0f != f2) {
            this.H = (int) (((float) this.H) / f2);
            this.I = (int) (((float) this.I) / f2);
        }
        String str = this.x;
        TXCLog.i(str, "mResampleRatio " + this.E + " mResampleWidth " + this.H + " mResampleHeight " + this.I);
        if (this.w == null) {
            this.w = new b();
            this.w.a(true);
            if (!this.w.a()) {
                TXCLog.e(this.x, "mBeautyBlendFilter init failed!!, break init");
                return false;
            }
        }
        this.w.a(i, i2);
        if (this.s == null) {
            this.s = new d();
            this.s.a(true);
            if (!this.s.a()) {
                TXCLog.e(this.x, "m_horizontalFilter init failed!!, break init");
                return false;
            }
        }
        this.s.a(this.H, this.I);
        if (this.t == null) {
            this.t = new e();
            this.t.a(true);
            this.t.b(1.0f != this.E);
            if (!this.t.a()) {
                TXCLog.e(this.x, "m_verticalFilter init failed!!, break init");
                return false;
            }
        }
        this.t.a(this.H, this.I);
        if (this.u == null) {
            this.u = new h(1.0f);
            this.u.a(true);
            if (!this.u.a()) {
                TXCLog.e(this.x, "m_gammaFilter init failed!!, break init");
                return false;
            }
        }
        this.u.a(this.H, this.I);
        if (this.v == null) {
            this.v = new q();
            this.v.a(true);
            if (!this.v.a()) {
                TXCLog.e(this.x, "mSharpenFilter init failed!!, break init");
                return false;
            }
        }
        this.v.a(i, i2);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void q() {
        b bVar = this.w;
        if (bVar != null) {
            bVar.d();
            this.w = null;
        }
        d dVar = this.s;
        if (dVar != null) {
            dVar.d();
            this.s = null;
        }
        e eVar = this.t;
        if (eVar != null) {
            eVar.d();
            this.t = null;
        }
        h hVar = this.u;
        if (hVar != null) {
            hVar.d();
            this.u = null;
        }
        q qVar = this.v;
        if (qVar != null) {
            qVar.d();
            this.v = null;
        }
    }

    public void e() {
        super.e();
        q();
    }
}
