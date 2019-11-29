package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.d.h;
import com.tencent.liteav.basic.log.TXCLog;

public class j {
    private static String j = "GPUGreenScreen";

    /* renamed from: a  reason: collision with root package name */
    private int f31496a;

    /* renamed from: b  reason: collision with root package name */
    private int f31497b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f31498c;

    /* renamed from: d  reason: collision with root package name */
    private w f31499d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f31500e;

    /* renamed from: f  reason: collision with root package name */
    private h f31501f;

    /* renamed from: g  reason: collision with root package name */
    private e f31502g;
    private p h;
    private boolean i;
    private a k;

    public int a(int i2) {
        return i2;
    }

    public void a(a aVar) {
        TXCLog.i(j, "set notify");
        this.k = aVar;
    }

    private void b() {
        TXCLog.d(j, "come into destroyPlayer");
        w wVar = this.f31499d;
        if (wVar != null) {
            wVar.a();
        }
        this.f31499d = null;
        this.f31500e = false;
        this.i = false;
        TXCLog.d(j, "come out destroyPlayer");
    }

    public void a() {
        TXCLog.d(j, "come into GreenScreen destroy");
        b();
        c();
        h hVar = this.f31501f;
        if (hVar != null) {
            hVar.d();
            this.f31501f = null;
        }
        e eVar = this.f31502g;
        if (eVar != null) {
            eVar.d();
            this.f31502g = null;
        }
        p pVar = this.h;
        if (pVar != null) {
            pVar.d();
            this.h = null;
        }
        this.f31498c = false;
        TXCLog.d(j, "come out GreenScreen destroy");
    }

    private void c() {
        int i2 = this.f31497b;
        if (!(i2 == -1 || i2 == this.f31496a)) {
            GLES20.glDeleteTextures(1, new int[]{i2}, 0);
            this.f31497b = -1;
        }
        int i3 = this.f31496a;
        if (i3 != -1) {
            GLES20.glDeleteTextures(1, new int[]{i3}, 0);
            this.f31496a = -1;
        }
    }
}
