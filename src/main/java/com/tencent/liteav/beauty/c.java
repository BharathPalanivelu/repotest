package com.tencent.liteav.beauty;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Bitmap;
import android.os.Build;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.liteav.basic.d.i;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class c extends com.tencent.liteav.basic.module.a implements d {

    /* renamed from: a  reason: collision with root package name */
    protected Context f31519a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f31520b = true;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f31521c = false;

    /* renamed from: d  reason: collision with root package name */
    protected int f31522d = 0;

    /* renamed from: e  reason: collision with root package name */
    protected int f31523e = 0;

    /* renamed from: f  reason: collision with root package name */
    protected int f31524f = 0;

    /* renamed from: g  reason: collision with root package name */
    protected com.tencent.liteav.basic.d.a f31525g = null;
    protected b h;
    protected b i = new b();
    protected C0488c j = null;
    e k;
    private boolean l = true;
    private long m = 0;
    private long n = 0;
    private long o = 0;
    private Object p;
    private a q = new a(this);

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public f f31542a = f.TXE_FILL_MODE_SCALL_ASPECT_FILL;

        /* renamed from: b  reason: collision with root package name */
        public boolean f31543b = false;
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public Bitmap f31544a;

        /* renamed from: b  reason: collision with root package name */
        public float f31545b;

        /* renamed from: c  reason: collision with root package name */
        public float f31546c;

        /* renamed from: d  reason: collision with root package name */
        public float f31547d;
    }

    public enum f {
        TXE_FILL_MODE_SCALL_TO_FILL,
        TXE_FILL_MODE_SCALL_ASPECT_FILL
    }

    private int m(int i2) {
        if (i2 == 1) {
            return 90;
        }
        if (i2 == 2) {
            return 180;
        }
        if (i2 != 3) {
            return i2;
        }
        return 270;
    }

    public int a(int i2, int i3, int i4) {
        boolean z = false;
        if (this.k == null) {
            return 0;
        }
        com.tencent.liteav.basic.structs.b bVar = new com.tencent.liteav.basic.structs.b();
        bVar.f31408e = i3;
        bVar.f31409f = i4;
        C0488c cVar = this.j;
        bVar.j = cVar != null ? cVar.j : 0;
        C0488c cVar2 = this.j;
        if (cVar2 != null) {
            z = cVar2.f31541g;
        }
        bVar.i = z;
        bVar.f31404a = i2;
        return this.k.a(bVar);
    }

    public void a(int i2, int i3, int i4, long j2) {
        c();
        if (this.k != null) {
            com.tencent.liteav.basic.structs.b bVar = new com.tencent.liteav.basic.structs.b();
            bVar.f31408e = i3;
            bVar.f31409f = i4;
            C0488c cVar = this.j;
            boolean z = false;
            bVar.j = cVar != null ? cVar.j : 0;
            C0488c cVar2 = this.j;
            if (cVar2 != null) {
                z = cVar2.f31541g;
            }
            bVar.i = z;
            bVar.f31404a = i2;
            this.k.a(bVar, j2);
        }
    }

    public void a(byte[] bArr, int i2, int i3, int i4, long j2) {
        e eVar = this.k;
        if (eVar != null) {
            eVar.b(bArr, i2, i3, i4, j2);
        }
    }

    private void c() {
        if (this.m != 0) {
            setStatusValue(3002, Long.valueOf(System.currentTimeMillis() - this.m));
        }
        this.n++;
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.o;
        if (currentTimeMillis > 2000 + j2) {
            double d2 = (double) this.n;
            Double.isNaN(d2);
            double d3 = (double) (currentTimeMillis - j2);
            Double.isNaN(d3);
            setStatusValue(3003, Double.valueOf((d2 * 1000.0d) / d3));
            this.n = 0;
            this.o = currentTimeMillis;
        }
    }

    /* renamed from: com.tencent.liteav.beauty.c$c  reason: collision with other inner class name */
    private static class C0488c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f31535a;

        /* renamed from: b  reason: collision with root package name */
        public int f31536b;

        /* renamed from: c  reason: collision with root package name */
        public int f31537c;

        /* renamed from: d  reason: collision with root package name */
        public int f31538d;

        /* renamed from: e  reason: collision with root package name */
        public int f31539e;

        /* renamed from: f  reason: collision with root package name */
        public int f31540f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f31541g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;
        public com.tencent.liteav.basic.d.a m;

        private C0488c() {
            this.f31541g = false;
            this.k = 5;
            this.l = 0;
            this.m = null;
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        int f31528a;

        /* renamed from: b  reason: collision with root package name */
        int f31529b;

        /* renamed from: c  reason: collision with root package name */
        int f31530c;

        /* renamed from: d  reason: collision with root package name */
        int f31531d;

        /* renamed from: e  reason: collision with root package name */
        int f31532e;

        /* renamed from: f  reason: collision with root package name */
        int f31533f;

        /* renamed from: g  reason: collision with root package name */
        int f31534g;
        int h;
        boolean i;
        boolean j;
        public int k = 5;
        public int l = 0;
        com.tencent.liteav.basic.d.a m = null;

        b() {
        }
    }

    public c(Context context, boolean z) {
        TXCLog.i("TXCVideoPreprocessor", "TXCVideoPreprocessor version: VideoPreprocessor-v1.1");
        ConfigurationInfo deviceConfigurationInfo = ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo();
        if (deviceConfigurationInfo != null) {
            TXCLog.i("TXCVideoPreprocessor", "opengl es version " + deviceConfigurationInfo.reqGlEsVersion);
            TXCLog.i("TXCVideoPreprocessor", "set GLContext " + z);
            if (deviceConfigurationInfo.reqGlEsVersion > 131072) {
                TXCLog.i("TXCVideoPreprocessor", "This devices is OpenGlUtils.OPENGL_ES_3");
                i.a(3);
            } else {
                TXCLog.i("TXCVideoPreprocessor", "This devices is OpenGlUtils.OPENGL_ES_2");
                i.a(2);
            }
        } else {
            TXCLog.e("TXCVideoPreprocessor", "getDeviceConfigurationInfo opengl Info failed!");
        }
        this.f31519a = context;
        this.f31520b = z;
        this.h = new b(this.f31519a, this.f31520b);
        a.a().a(context);
    }

    public void a(float[] fArr) {
        b bVar = this.h;
        if (bVar != null) {
            bVar.a(fArr);
        }
    }

    public void a(boolean z) {
        b bVar = this.h;
        if (bVar != null) {
            bVar.a(z);
        }
    }

    public synchronized int a(byte[] bArr, int i2, int i3, int i4, int i5, int i6) {
        a(i2, i3, m(i4), i5, i6);
        this.h.b(this.i);
        return this.h.a(bArr, i5);
    }

    public synchronized int a(int i2, int i3, int i4, int i5, int i6, int i7, long j2) {
        a(i3, i4, m(i5), i6, i7);
        this.h.b(this.i);
        return this.h.a(i2, i6, j2);
    }

    public synchronized int a(com.tencent.liteav.basic.structs.b bVar, int i2, int i3, long j2) {
        this.m = System.currentTimeMillis();
        a(bVar.l);
        a(bVar.f31410g, bVar.h);
        b(bVar.i);
        a(bVar.j);
        a(bVar.f31406c);
        a(bVar.f31407d);
        if (bVar.m == null || bVar.f31404a != -1) {
            return a(bVar.f31404a, bVar.f31408e, bVar.f31409f, bVar.j, i2, i3, j2);
        }
        return a(bVar.m, bVar.f31408e, bVar.f31409f, bVar.j, i2, i3);
    }

    public synchronized void a(com.tencent.liteav.basic.d.a aVar) {
        this.f31525g = aVar;
    }

    public synchronized void a(int i2, int i3) {
        this.f31522d = i2;
        this.f31523e = i3;
    }

    public synchronized void a(int i2) {
        this.f31524f = i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(android.graphics.Bitmap r6, float r7, float r8, float r9) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            int r1 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r1 < 0) goto L_0x001d
            int r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x001d
            double r0 = (double) r9
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x0012
            goto L_0x001d
        L_0x0012:
            com.tencent.liteav.beauty.b r0 = r5.h     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x001b
            com.tencent.liteav.beauty.b r0 = r5.h     // Catch:{ all -> 0x0026 }
            r0.a((android.graphics.Bitmap) r6, (float) r7, (float) r8, (float) r9)     // Catch:{ all -> 0x0026 }
        L_0x001b:
            monitor-exit(r5)
            return
        L_0x001d:
            java.lang.String r6 = "TXCVideoPreprocessor"
            java.lang.String r7 = "WaterMark param is Error!"
            com.tencent.liteav.basic.log.TXCLog.e(r6, r7)     // Catch:{ all -> 0x0026 }
            monitor-exit(r5)
            return
        L_0x0026:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.beauty.c.a(android.graphics.Bitmap, float, float, float):void");
    }

    public synchronized void b(boolean z) {
        this.f31521c = z;
    }

    public synchronized void a(Object obj) {
        this.p = obj;
    }

    public synchronized Object a() {
        return this.p;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.tencent.liteav.beauty.e r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            com.tencent.liteav.beauty.b r0 = r1.h     // Catch:{ all -> 0x0020 }
            if (r0 != 0) goto L_0x000e
            java.lang.String r2 = "TXCVideoPreprocessor"
            java.lang.String r0 = "setListener mDrawer is null!"
            com.tencent.liteav.basic.log.TXCLog.e(r2, r0)     // Catch:{ all -> 0x0020 }
            monitor-exit(r1)
            return
        L_0x000e:
            r1.k = r2     // Catch:{ all -> 0x0020 }
            if (r2 != 0) goto L_0x0019
            com.tencent.liteav.beauty.b r2 = r1.h     // Catch:{ all -> 0x0020 }
            r0 = 0
            r2.a((com.tencent.liteav.beauty.d) r0)     // Catch:{ all -> 0x0020 }
            goto L_0x001e
        L_0x0019:
            com.tencent.liteav.beauty.b r2 = r1.h     // Catch:{ all -> 0x0020 }
            r2.a((com.tencent.liteav.beauty.d) r1)     // Catch:{ all -> 0x0020 }
        L_0x001e:
            monitor-exit(r1)
            return
        L_0x0020:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.beauty.c.a(com.tencent.liteav.beauty.e):void");
    }

    public synchronized void a(com.tencent.liteav.basic.c.a aVar) {
        if (this.h == null) {
            TXCLog.e("TXCVideoPreprocessor", "setListener mDrawer is null!");
        } else {
            this.h.a(aVar);
        }
    }

    private boolean a(int i2, int i3, int i4, int i5, int i6) {
        if (this.j == null) {
            this.j = new C0488c();
            this.n = 0;
            this.o = System.currentTimeMillis();
        }
        if (i2 == this.j.f31536b && i3 == this.j.f31537c && i4 == this.j.f31540f) {
            int i7 = this.f31522d;
            if (i7 <= 0 || i7 == this.j.h) {
                int i8 = this.f31523e;
                if (i8 <= 0 || i8 == this.j.i) {
                    int i9 = this.f31524f;
                    if (i9 <= 0 || i9 == this.j.j) {
                        com.tencent.liteav.basic.d.a aVar = this.f31525g;
                        if ((aVar == null || ((aVar.f31256c <= 0 || (this.j.m != null && this.f31525g.f31256c == this.j.m.f31256c)) && ((this.f31525g.f31257d <= 0 || (this.j.m != null && this.f31525g.f31257d == this.j.m.f31257d)) && ((this.f31525g.f31254a < 0 || (this.j.m != null && this.f31525g.f31254a == this.j.m.f31254a)) && (this.f31525g.f31255b < 0 || (this.j.m != null && this.f31525g.f31255b == this.j.m.f31255b)))))) && this.f31521c == this.j.f31541g && this.j.k == i5) {
                            if (!(i5 == this.j.k && i6 == this.j.l)) {
                                C0488c cVar = this.j;
                                cVar.k = i5;
                                b bVar = this.i;
                                bVar.k = i5;
                                cVar.l = i6;
                                bVar.l = i6;
                                this.h.a(i6);
                            }
                            return true;
                        }
                    }
                }
            }
        }
        TXCLog.i("TXCVideoPreprocessor", "Init sdk");
        TXCLog.i("TXCVideoPreprocessor", "Input widht " + i2 + " height " + i3);
        C0488c cVar2 = this.j;
        cVar2.f31536b = i2;
        cVar2.f31537c = i3;
        com.tencent.liteav.basic.d.a aVar2 = this.f31525g;
        if (aVar2 != null && aVar2.f31254a >= 0 && this.f31525g.f31255b >= 0 && this.f31525g.f31256c > 0 && this.f31525g.f31257d > 0) {
            TXCLog.i("TXCVideoPreprocessor", "set Crop Rect; init ");
            int i10 = i2 - this.f31525g.f31254a > this.f31525g.f31256c ? this.f31525g.f31256c : i2 - this.f31525g.f31254a;
            int i11 = i3 - this.f31525g.f31255b > this.f31525g.f31257d ? this.f31525g.f31257d : i3 - this.f31525g.f31255b;
            com.tencent.liteav.basic.d.a aVar3 = this.f31525g;
            aVar3.f31256c = i10;
            aVar3.f31257d = i11;
            i2 = aVar3.f31256c;
            i3 = this.f31525g.f31257d;
        }
        C0488c cVar3 = this.j;
        cVar3.m = this.f31525g;
        cVar3.f31540f = i4;
        cVar3.f31535a = this.f31520b;
        cVar3.k = i5;
        cVar3.l = i6;
        if (true == this.l) {
            cVar3.h = this.f31522d;
            cVar3.i = this.f31523e;
        } else {
            cVar3.h = 0;
            cVar3.i = 0;
        }
        C0488c cVar4 = this.j;
        cVar4.j = this.f31524f;
        if (cVar4.j <= 0) {
            this.j.j = 0;
        }
        if (this.j.h <= 0 || this.j.i <= 0) {
            if (90 == this.j.j || 270 == this.j.j) {
                C0488c cVar5 = this.j;
                cVar5.h = i3;
                cVar5.i = i2;
            } else {
                C0488c cVar6 = this.j;
                cVar6.h = i2;
                cVar6.i = i3;
            }
        }
        if (90 == this.j.j || 270 == this.j.j) {
            C0488c cVar7 = this.j;
            cVar7.f31538d = cVar7.i;
            C0488c cVar8 = this.j;
            cVar8.f31539e = cVar8.h;
        } else {
            C0488c cVar9 = this.j;
            cVar9.f31538d = cVar9.h;
            C0488c cVar10 = this.j;
            cVar10.f31539e = cVar10.i;
        }
        if (true != this.l) {
            C0488c cVar11 = this.j;
            cVar11.h = this.f31522d;
            cVar11.i = this.f31523e;
            if (cVar11.h <= 0 || this.j.i <= 0) {
                if (90 == this.j.j || 270 == this.j.j) {
                    C0488c cVar12 = this.j;
                    cVar12.h = i3;
                    cVar12.i = i2;
                } else {
                    C0488c cVar13 = this.j;
                    cVar13.h = i2;
                    cVar13.i = i3;
                }
            }
        }
        C0488c cVar14 = this.j;
        cVar14.f31541g = this.f31521c;
        if (!a(cVar14)) {
            TXCLog.e("TXCVideoPreprocessor", "init failed!");
            return false;
        }
        return true;
    }

    private boolean a(C0488c cVar) {
        this.i.f31531d = cVar.f31536b;
        this.i.f31532e = cVar.f31537c;
        this.i.m = cVar.m;
        this.i.f31534g = cVar.f31538d;
        this.i.f31533f = cVar.f31539e;
        this.i.h = (cVar.f31540f + 360) % 360;
        this.i.f31529b = cVar.h;
        this.i.f31530c = cVar.i;
        this.i.f31528a = cVar.j;
        this.i.j = cVar.f31535a;
        this.i.i = cVar.f31541g;
        this.i.k = cVar.k;
        this.i.l = cVar.l;
        if (this.h == null) {
            this.h = new b(this.f31519a, cVar.f31535a);
        }
        return this.h.a(this.i);
    }

    public synchronized void b() {
        if (this.h != null) {
            this.h.a();
        }
        this.j = null;
    }

    public synchronized void b(int i2) {
        if (this.h != null) {
            this.h.c(i2);
        }
        this.q.a("beautyStyle", i2);
    }

    public synchronized void c(int i2) {
        if (i2 > 9) {
            try {
                TXCLog.e("TXCVideoPreprocessor", "Beauty value too large! set max value 9");
                i2 = 9;
            } catch (Throwable th) {
                throw th;
            }
        } else if (i2 < 0) {
            TXCLog.e("TXCVideoPreprocessor", "Beauty < 0; set 0");
            i2 = 0;
        }
        if (this.h != null) {
            this.h.b(i2);
        }
        this.q.a("beautyLevel", i2);
    }

    public synchronized void d(int i2) {
        if (i2 > 9) {
            try {
                TXCLog.e("TXCVideoPreprocessor", "Brightness value too large! set max value 9");
                i2 = 9;
            } catch (Throwable th) {
                throw th;
            }
        } else if (i2 < 0) {
            TXCLog.e("TXCVideoPreprocessor", "Brightness < 0; set 0");
            i2 = 0;
        }
        if (this.h != null) {
            this.h.d(i2);
        }
        this.q.a("whiteLevel", i2);
    }

    public synchronized void e(int i2) {
        if (i2 > 9) {
            try {
                TXCLog.e("TXCVideoPreprocessor", "Ruddy value too large! set max value 9");
                i2 = 9;
            } catch (Throwable th) {
                throw th;
            }
        } else if (i2 < 0) {
            TXCLog.e("TXCVideoPreprocessor", "Ruddy < 0; set 0");
            i2 = 0;
        }
        if (this.h != null) {
            this.h.f(i2);
        }
        this.q.a("ruddyLevel", i2);
    }

    public void f(int i2) {
        if (i2 > 9) {
            TXCLog.e("TXCVideoPreprocessor", "Brightness value too large! set max value 9");
            i2 = 9;
        } else if (i2 < 0) {
            TXCLog.e("TXCVideoPreprocessor", "Brightness < 0; set 0");
            i2 = 0;
        }
        b bVar = this.h;
        if (bVar != null) {
            bVar.e(i2);
        }
    }

    public synchronized void a(String str) {
        if (this.h != null) {
            this.h.a(str);
        }
    }

    public synchronized void c(boolean z) {
        if (this.h != null) {
            this.h.b(z);
        }
    }

    @TargetApi(18)
    public boolean a(String str, boolean z) {
        if (Build.VERSION.SDK_INT < 18) {
            return false;
        }
        b bVar = this.h;
        if (bVar == null) {
            return true;
        }
        bVar.a(str, z);
        return true;
    }

    public synchronized void g(int i2) {
        if (this.h != null) {
            this.h.g(i2);
        }
        this.q.a("eyeBigScale", i2);
    }

    public synchronized void h(int i2) {
        if (this.h != null) {
            this.h.h(i2);
        }
        this.q.a("faceSlimLevel", i2);
    }

    public void i(int i2) {
        b bVar = this.h;
        if (bVar != null) {
            bVar.i(i2);
        }
        this.q.a("faceVLevel", i2);
    }

    public void j(int i2) {
        b bVar = this.h;
        if (bVar != null) {
            bVar.j(i2);
        }
        this.q.a("faceShortLevel", i2);
    }

    public void k(int i2) {
        b bVar = this.h;
        if (bVar != null) {
            bVar.k(i2);
        }
        this.q.a("chinLevel", i2);
    }

    public void l(int i2) {
        b bVar = this.h;
        if (bVar != null) {
            bVar.l(i2);
        }
        this.q.a("noseSlimLevel", i2);
    }

    public synchronized void a(float f2) {
        if (this.h != null) {
            this.h.a(f2);
        }
    }

    public synchronized void a(Bitmap bitmap) {
        if (this.h != null) {
            this.h.a(bitmap);
        }
    }

    public void setID(String str) {
        super.setID(str);
        setStatusValue(3001, this.q.a());
    }

    protected static class a {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<c> f31526a;

        /* renamed from: b  reason: collision with root package name */
        private HashMap<String, String> f31527b = new HashMap<>();

        public a(c cVar) {
            this.f31526a = new WeakReference<>(cVar);
        }

        public void a(String str, int i) {
            this.f31527b.put(str, String.valueOf(i));
            c cVar = (c) this.f31526a.get();
            if (cVar != null) {
                String id = cVar.getID();
                if (id != null && id.length() > 0) {
                    cVar.setStatusValue(3001, a());
                }
            }
        }

        public String a() {
            String str = "";
            for (String next : this.f31527b.keySet()) {
                str = str + next + ":" + this.f31527b.get(next) + SQLBuilder.BLANK;
            }
            return "{" + str + "}";
        }
    }
}
