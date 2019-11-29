package com.tencent.liteav.beauty.b.b;

import android.util.Log;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.liteav.beauty.b.b;
import com.tencent.liteav.beauty.b.r;

public class a extends b {
    private b r = null;
    private r s = null;
    private String t = "TXCBeauty3Filter";
    private float u = BitmapDescriptorFactory.HUE_RED;
    private float v = BitmapDescriptorFactory.HUE_RED;
    private float w = BitmapDescriptorFactory.HUE_RED;
    private float x = BitmapDescriptorFactory.HUE_RED;

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

    private boolean d(int i, int i2) {
        if (this.r == null) {
            this.r = new b();
            this.r.a(true);
            if (!this.r.a()) {
                Log.e(this.t, "m_verticalFilter init failed!!, break init");
                return false;
            }
        }
        this.r.a(i, i2);
        if (this.s == null) {
            this.s = new r();
            this.s.a(true);
            if (!this.s.a()) {
                Log.e(this.t, "mSharpnessFilter init failed!!, break init");
                return false;
            }
        }
        this.s.a(i, i2);
        return true;
    }

    public int b(int i) {
        if (this.u > BitmapDescriptorFactory.HUE_RED || this.v > BitmapDescriptorFactory.HUE_RED || this.w > BitmapDescriptorFactory.HUE_RED) {
            i = this.r.b(i);
        }
        return this.x > BitmapDescriptorFactory.HUE_RED ? this.s.b(i) : i;
    }

    public void c(int i) {
        this.u = ((float) i) / 10.0f;
        b bVar = this.r;
        if (bVar != null) {
            bVar.a(this.u);
        }
    }

    public void d(int i) {
        this.v = ((float) i) / 10.0f;
        b bVar = this.r;
        if (bVar != null) {
            bVar.b(this.v);
        }
    }

    public void e(int i) {
        this.w = ((float) i) / 10.0f;
        b bVar = this.r;
        if (bVar != null) {
            bVar.c(this.w);
        }
    }

    public void f(int i) {
        this.x = ((float) i) / 20.0f;
        r rVar = this.s;
        if (rVar != null) {
            rVar.a(this.x);
        }
    }

    /* access modifiers changed from: package-private */
    public void q() {
        b bVar = this.r;
        if (bVar != null) {
            bVar.e();
            this.r = null;
        }
        r rVar = this.s;
        if (rVar != null) {
            rVar.e();
            this.s = null;
        }
    }

    public void e() {
        super.e();
        q();
    }
}
