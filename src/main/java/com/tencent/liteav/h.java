package com.tencent.liteav;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.b;
import com.tencent.liteav.screencapture.a;
import com.tencent.liteav.screencapture.c;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGLContext;

public class h implements l, c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f31634a = "h";

    /* renamed from: b  reason: collision with root package name */
    private m f31635b;

    /* renamed from: c  reason: collision with root package name */
    private a f31636c = null;

    /* renamed from: d  reason: collision with root package name */
    private EGLContext f31637d = null;

    /* renamed from: e  reason: collision with root package name */
    private int f31638e;

    /* renamed from: f  reason: collision with root package name */
    private int f31639f;

    /* renamed from: g  reason: collision with root package name */
    private int f31640g;
    private int h;
    private int i;
    private String j = "";
    private final Queue<Runnable> k = new LinkedList();

    public void a(float f2) {
    }

    public void a(float f2, float f3) {
    }

    public void a(b bVar) {
    }

    public boolean a(int i2) {
        return false;
    }

    public void b(int i2) {
    }

    public void b(boolean z) {
    }

    public void c(int i2) {
    }

    public void c(boolean z) {
    }

    public void d(int i2) {
    }

    public boolean d() {
        return true;
    }

    public boolean d(boolean z) {
        return false;
    }

    public int e() {
        return 0;
    }

    public void e(int i2) {
    }

    public void e(boolean z) {
    }

    public void f(int i2) {
    }

    public boolean g() {
        return false;
    }

    public h(Context context, f fVar) {
        this.f31636c = new a(context, fVar.O);
        this.f31636c.a((c) this);
        boolean a2 = fVar.a();
        this.f31638e = fVar.h;
        if (fVar.f31618a > 1280 || fVar.f31619b > 1280) {
            this.f31639f = a2 ? Math.max(fVar.f31618a, fVar.f31619b) : Math.min(fVar.f31618a, fVar.f31619b);
            this.f31640g = a2 ? Math.min(fVar.f31618a, fVar.f31619b) : Math.max(fVar.f31618a, fVar.f31619b);
        } else {
            int i2 = 720;
            this.f31639f = a2 ? 1280 : 720;
            this.f31640g = !a2 ? 1280 : i2;
        }
        this.h = fVar.f31618a;
        this.i = fVar.f31619b;
    }

    public void a() {
        this.f31636c.a(this.f31639f, this.f31640g, this.f31638e);
        this.f31636c.a(true);
    }

    public void a(boolean z) {
        this.f31636c.a((Object) null);
        this.f31636c.a(false);
    }

    public void a(String str) {
        this.j = str;
    }

    public void c() {
        this.f31636c.a(false);
    }

    public void b() {
        this.f31636c.a(true);
    }

    public EGLContext f() {
        return this.f31637d;
    }

    public void a(m mVar) {
        this.f31635b = mVar;
    }

    public void a(Runnable runnable) {
        a aVar = this.f31636c;
        if (aVar != null) {
            aVar.a(runnable);
        }
    }

    public void a(com.tencent.liteav.basic.c.a aVar) {
        a aVar2 = this.f31636c;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
    }

    public void a(int i2, int i3) {
        this.h = i2;
        this.i = i3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
        r0.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        if (r0 != null) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.util.Queue<java.lang.Runnable> r3) {
        /*
            r2 = this;
            monitor-enter(r3)
            boolean r0 = r3.isEmpty()     // Catch:{ all -> 0x0019 }
            r1 = 0
            if (r0 == 0) goto L_0x000a
            monitor-exit(r3)     // Catch:{ all -> 0x0019 }
            return r1
        L_0x000a:
            java.lang.Object r0 = r3.poll()     // Catch:{ all -> 0x0019 }
            java.lang.Runnable r0 = (java.lang.Runnable) r0     // Catch:{ all -> 0x0019 }
            monitor-exit(r3)     // Catch:{ all -> 0x0019 }
            if (r0 != 0) goto L_0x0014
            return r1
        L_0x0014:
            r0.run()
            r3 = 1
            return r3
        L_0x0019:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0019 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.h.a(java.util.Queue):boolean");
    }

    public void a(int i2, EGLContext eGLContext) {
        if (i2 == 0) {
            this.f31637d = eGLContext;
            return;
        }
        this.f31637d = null;
        TXCLog.e(f31634a, "Start screen capture failed");
    }

    public void a(int i2, int i3, int i4, int i5, long j2) {
        do {
        } while (a(this.k));
        if (i2 != 0) {
            TXCLog.e(f31634a, "onScreenCaptureFrame failed");
        } else if (this.f31635b != null) {
            f(i4 < i5);
            b bVar = new b();
            bVar.f31408e = i4;
            bVar.f31409f = i5;
            bVar.f31410g = this.h;
            bVar.h = this.i;
            bVar.f31404a = i3;
            bVar.f31405b = 0;
            bVar.j = 0;
            bVar.l = com.tencent.liteav.basic.util.b.a(bVar.f31408e, bVar.f31409f, this.h, this.i);
            this.f31635b.b(bVar);
        }
    }

    public void a(Object obj) {
        do {
        } while (a(this.k));
        m mVar = this.f31635b;
        if (mVar != null) {
            mVar.u();
        }
    }

    private void f(boolean z) {
        if (z) {
            int i2 = this.h;
            int i3 = this.i;
            if (i2 > i3) {
                a(i3, i2);
                return;
            }
            return;
        }
        int i4 = this.h;
        int i5 = this.i;
        if (i4 < i5) {
            a(i5, i4);
        }
    }
}
