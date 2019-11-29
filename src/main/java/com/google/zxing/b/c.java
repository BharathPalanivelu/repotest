package com.google.zxing.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;
import com.google.zxing.n;
import com.google.zxing.r;
import com.google.zxing.t;
import java.io.InputStream;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14464a = "c";

    /* renamed from: b  reason: collision with root package name */
    private final Context f14465b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final b f14466c;

    /* renamed from: d  reason: collision with root package name */
    private Camera f14467d;

    /* renamed from: e  reason: collision with root package name */
    private a f14468e;

    /* renamed from: f  reason: collision with root package name */
    private Rect f14469f;

    /* renamed from: g  reason: collision with root package name */
    private Rect f14470g;
    private boolean h;
    private boolean i;
    private int j;
    private int k;
    private int l;
    private int m = 0;
    private int n = 0;
    private int o = 0;
    private int p = 0;
    private int q = -1;
    private int r = -1;
    private int s = -1;
    private final d t;
    private Uri u;

    public interface a {
        void a(Point point, Point point2);
    }

    public c(Context context, int i2, int i3) {
        this.f14465b = context;
        this.o = i2;
        this.p = i3;
        this.f14466c = new b(context);
        this.t = new d(this.f14466c);
    }

    public void a(int i2) {
        this.o = i2;
    }

    public void b(int i2) {
        this.p = i2;
    }

    public void c(int i2) {
        this.q = i2;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0050 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x007f */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(android.view.SurfaceHolder r7, final com.google.zxing.b.c.a r8) throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            android.hardware.Camera r0 = r6.f14467d     // Catch:{ all -> 0x009c }
            r1 = 0
            if (r0 != 0) goto L_0x0015
            android.hardware.Camera r0 = com.google.zxing.b.a.a.a(r1)     // Catch:{ all -> 0x009c }
            if (r0 == 0) goto L_0x000f
            r6.f14467d = r0     // Catch:{ all -> 0x009c }
            goto L_0x0015
        L_0x000f:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x009c }
            r7.<init>()     // Catch:{ all -> 0x009c }
            throw r7     // Catch:{ all -> 0x009c }
        L_0x0015:
            int r2 = com.google.zxing.b.a.a.f14457a     // Catch:{ all -> 0x009c }
            android.hardware.Camera r3 = r6.f14467d     // Catch:{ all -> 0x009c }
            r6.a((int) r2, (android.hardware.Camera) r3)     // Catch:{ all -> 0x009c }
            r0.setPreviewDisplay(r7)     // Catch:{ all -> 0x009c }
            boolean r7 = r6.h     // Catch:{ all -> 0x009c }
            r2 = 1
            if (r7 != 0) goto L_0x003e
            r6.h = r2     // Catch:{ all -> 0x009c }
            com.google.zxing.b.b r7 = r6.f14466c     // Catch:{ all -> 0x009c }
            r7.a(r0)     // Catch:{ all -> 0x009c }
            int r7 = r6.j     // Catch:{ all -> 0x009c }
            if (r7 <= 0) goto L_0x003e
            int r7 = r6.k     // Catch:{ all -> 0x009c }
            if (r7 <= 0) goto L_0x003e
            int r7 = r6.j     // Catch:{ all -> 0x009c }
            int r3 = r6.k     // Catch:{ all -> 0x009c }
            r6.a((int) r7, (int) r3)     // Catch:{ all -> 0x009c }
            r6.j = r1     // Catch:{ all -> 0x009c }
            r6.k = r1     // Catch:{ all -> 0x009c }
        L_0x003e:
            android.hardware.Camera$Parameters r7 = r0.getParameters()     // Catch:{ all -> 0x009c }
            if (r7 != 0) goto L_0x0046
            r7 = 0
            goto L_0x004a
        L_0x0046:
            java.lang.String r7 = r7.flatten()     // Catch:{ all -> 0x009c }
        L_0x004a:
            com.google.zxing.b.b r3 = r6.f14466c     // Catch:{ RuntimeException -> 0x0050 }
            r3.a((android.hardware.Camera) r0, (boolean) r1)     // Catch:{ RuntimeException -> 0x0050 }
            goto L_0x0087
        L_0x0050:
            java.lang.String r3 = f14464a     // Catch:{ all -> 0x009c }
            java.lang.String r4 = "Camera rejected parameters. Setting only minimal safe-mode parameters"
            android.util.Log.w(r3, r4)     // Catch:{ all -> 0x009c }
            java.lang.String r3 = f14464a     // Catch:{ all -> 0x009c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x009c }
            r4.<init>()     // Catch:{ all -> 0x009c }
            java.lang.String r5 = "Resetting to saved camera params: "
            r4.append(r5)     // Catch:{ all -> 0x009c }
            r4.append(r7)     // Catch:{ all -> 0x009c }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x009c }
            android.util.Log.i(r3, r4)     // Catch:{ all -> 0x009c }
            if (r7 == 0) goto L_0x0086
            android.hardware.Camera$Parameters r3 = r0.getParameters()     // Catch:{ all -> 0x009c }
            r3.unflatten(r7)     // Catch:{ all -> 0x009c }
            r0.setParameters(r3)     // Catch:{ RuntimeException -> 0x007f }
            com.google.zxing.b.b r7 = r6.f14466c     // Catch:{ RuntimeException -> 0x007f }
            r7.a((android.hardware.Camera) r0, (boolean) r2)     // Catch:{ RuntimeException -> 0x007f }
            goto L_0x0087
        L_0x007f:
            java.lang.String r7 = f14464a     // Catch:{ all -> 0x009c }
            java.lang.String r0 = "Camera rejected even safe-mode parameters! No configuration"
            android.util.Log.w(r7, r0)     // Catch:{ all -> 0x009c }
        L_0x0086:
            r2 = 0
        L_0x0087:
            if (r2 == 0) goto L_0x009a
            android.os.Handler r7 = new android.os.Handler     // Catch:{ all -> 0x009c }
            android.os.Looper r0 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x009c }
            r7.<init>(r0)     // Catch:{ all -> 0x009c }
            com.google.zxing.b.c$1 r0 = new com.google.zxing.b.c$1     // Catch:{ all -> 0x009c }
            r0.<init>(r8)     // Catch:{ all -> 0x009c }
            r7.post(r0)     // Catch:{ all -> 0x009c }
        L_0x009a:
            monitor-exit(r6)
            return
        L_0x009c:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.b.c.a(android.view.SurfaceHolder, com.google.zxing.b.c$a):void");
    }

    public void a(int i2, Camera camera) {
        int i3;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i2, cameraInfo);
        int rotation = ((WindowManager) this.f14465b.getSystemService("window")).getDefaultDisplay().getRotation();
        int i4 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i4 = 90;
            } else if (rotation == 2) {
                i4 = 180;
            } else if (rotation == 3) {
                i4 = 270;
            }
        }
        if (cameraInfo.facing == 1) {
            i3 = (360 - ((cameraInfo.orientation + i4) % 360)) % 360;
        } else {
            i3 = ((cameraInfo.orientation - i4) + 360) % 360;
        }
        camera.setDisplayOrientation(i3);
    }

    public synchronized boolean a() {
        return this.f14467d != null;
    }

    public synchronized void b() {
        if (this.f14467d != null) {
            this.f14467d.release();
            this.f14467d = null;
            this.f14469f = null;
            this.f14470g = null;
        }
    }

    public synchronized void c() {
        Camera camera = this.f14467d;
        if (camera != null && !this.i) {
            camera.startPreview();
            this.i = true;
            this.f14468e = new a(this.f14465b, this.f14467d);
        }
    }

    public synchronized void d() {
        if (this.f14468e != null) {
            this.f14468e.b();
            this.f14468e = null;
        }
        if (this.f14467d != null && this.i) {
            this.f14467d.stopPreview();
            this.t.a((Handler) null, 0);
            this.i = false;
        }
    }

    public synchronized void a(boolean z) {
        if (!(z == this.f14466c.b(this.f14467d) || this.f14467d == null)) {
            if (this.f14468e != null) {
                this.f14468e.b();
            }
            this.f14466c.b(this.f14467d, z);
            if (this.f14468e != null) {
                this.f14468e.a();
            }
        }
    }

    public synchronized void d(int i2) {
        this.l = i2;
    }

    public synchronized void a(Uri uri) {
        this.u = uri;
        this.l = 1;
    }

    public synchronized void a(Handler handler, int i2) {
        Camera camera = this.f14467d;
        if (camera != null && this.i) {
            this.t.a(handler, i2);
            camera.setOneShotPreviewCallback(this.t);
        }
    }

    public synchronized Rect e() {
        int i2;
        if (!(this.f14469f != null && this.n == this.p && this.m == this.o)) {
            if (this.f14467d == null) {
                return null;
            }
            Point b2 = this.f14466c.b();
            if (b2 == null) {
                return null;
            }
            int a2 = a(b2);
            int e2 = e(a2);
            int i3 = (b2.x - a2) / 2;
            if (this.q != -1) {
                i2 = ((b2.y - this.q) - e2) / 2;
            } else {
                i2 = (b2.y - e2) / 2;
            }
            this.f14469f = new Rect(i3, i2, a2 + i3, e2 + i2);
            String str = f14464a;
            Log.d(str, "Calculated framing rect: " + this.f14469f);
            this.n = this.p;
            this.m = this.o;
        }
        return this.f14469f;
    }

    private int a(int i2, double d2, double d3, int i3, int i4) {
        double d4;
        if (i4 == -1) {
            if (this.f14465b.getResources().getDisplayMetrics().densityDpi == 120) {
                double d5 = (double) i2;
                Double.isNaN(d5);
                d4 = Math.floor(d5 * d3);
            } else {
                double d6 = (double) i2;
                Double.isNaN(d6);
                d4 = Math.floor(d6 * d2);
            }
            i4 = (int) d4;
        }
        return i4 < i3 ? i3 : i4;
    }

    private int a(Point point) {
        int i2 = this.p;
        if (i2 == 0) {
            return a(Math.min(point.x, point.y), 0.625d, 0.6d, 160, this.s);
        } else if (i2 != 1) {
            return 0;
        } else {
            return a(point.x, 1.0d, 1.0d, 200, this.s);
        }
    }

    private int e(int i2) {
        int i3 = this.p;
        if (i3 == 0) {
            return i2;
        }
        if (i3 != 1) {
            return 0;
        }
        return a(i2, 0.2d, 0.2d, 50, this.r);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00bb, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.graphics.Rect f() {
        /*
            r5 = this;
            monitor-enter(r5)
            android.graphics.Rect r0 = r5.f14470g     // Catch:{ all -> 0x00bc }
            if (r0 == 0) goto L_0x0011
            int r0 = r5.n     // Catch:{ all -> 0x00bc }
            int r1 = r5.p     // Catch:{ all -> 0x00bc }
            if (r0 != r1) goto L_0x0011
            int r0 = r5.m     // Catch:{ all -> 0x00bc }
            int r1 = r5.o     // Catch:{ all -> 0x00bc }
            if (r0 == r1) goto L_0x00b6
        L_0x0011:
            android.graphics.Rect r0 = r5.e()     // Catch:{ all -> 0x00bc }
            r1 = 0
            if (r0 != 0) goto L_0x001a
            monitor-exit(r5)
            return r1
        L_0x001a:
            android.graphics.Rect r2 = new android.graphics.Rect     // Catch:{ all -> 0x00bc }
            r2.<init>(r0)     // Catch:{ all -> 0x00bc }
            com.google.zxing.b.b r0 = r5.f14466c     // Catch:{ all -> 0x00bc }
            android.graphics.Point r0 = r0.a()     // Catch:{ all -> 0x00bc }
            com.google.zxing.b.b r3 = r5.f14466c     // Catch:{ all -> 0x00bc }
            android.graphics.Point r3 = r3.b()     // Catch:{ all -> 0x00bc }
            if (r0 == 0) goto L_0x00ba
            if (r3 != 0) goto L_0x0031
            goto L_0x00ba
        L_0x0031:
            int r1 = r5.o     // Catch:{ all -> 0x00bc }
            if (r1 == 0) goto L_0x0068
            int r1 = r5.o     // Catch:{ all -> 0x00bc }
            r4 = 2
            if (r1 != r4) goto L_0x003b
            goto L_0x0068
        L_0x003b:
            int r1 = r2.left     // Catch:{ all -> 0x00bc }
            int r4 = r0.x     // Catch:{ all -> 0x00bc }
            int r1 = r1 * r4
            int r4 = r3.x     // Catch:{ all -> 0x00bc }
            int r1 = r1 / r4
            r2.left = r1     // Catch:{ all -> 0x00bc }
            int r1 = r2.right     // Catch:{ all -> 0x00bc }
            int r4 = r0.x     // Catch:{ all -> 0x00bc }
            int r1 = r1 * r4
            int r4 = r3.x     // Catch:{ all -> 0x00bc }
            int r1 = r1 / r4
            r2.right = r1     // Catch:{ all -> 0x00bc }
            int r1 = r2.top     // Catch:{ all -> 0x00bc }
            int r4 = r0.y     // Catch:{ all -> 0x00bc }
            int r1 = r1 * r4
            int r4 = r3.y     // Catch:{ all -> 0x00bc }
            int r1 = r1 / r4
            r2.top = r1     // Catch:{ all -> 0x00bc }
            int r1 = r2.bottom     // Catch:{ all -> 0x00bc }
            int r0 = r0.y     // Catch:{ all -> 0x00bc }
            int r1 = r1 * r0
            int r0 = r3.y     // Catch:{ all -> 0x00bc }
            int r1 = r1 / r0
            r2.bottom = r1     // Catch:{ all -> 0x00bc }
            goto L_0x0094
        L_0x0068:
            int r1 = r2.left     // Catch:{ all -> 0x00bc }
            int r4 = r0.y     // Catch:{ all -> 0x00bc }
            int r1 = r1 * r4
            int r4 = r3.x     // Catch:{ all -> 0x00bc }
            int r1 = r1 / r4
            r2.left = r1     // Catch:{ all -> 0x00bc }
            int r1 = r2.right     // Catch:{ all -> 0x00bc }
            int r4 = r0.y     // Catch:{ all -> 0x00bc }
            int r1 = r1 * r4
            int r4 = r3.x     // Catch:{ all -> 0x00bc }
            int r1 = r1 / r4
            r2.right = r1     // Catch:{ all -> 0x00bc }
            int r1 = r2.top     // Catch:{ all -> 0x00bc }
            int r4 = r0.x     // Catch:{ all -> 0x00bc }
            int r1 = r1 * r4
            int r4 = r3.y     // Catch:{ all -> 0x00bc }
            int r1 = r1 / r4
            r2.top = r1     // Catch:{ all -> 0x00bc }
            int r1 = r2.bottom     // Catch:{ all -> 0x00bc }
            int r0 = r0.x     // Catch:{ all -> 0x00bc }
            int r1 = r1 * r0
            int r0 = r3.y     // Catch:{ all -> 0x00bc }
            int r1 = r1 / r0
            r2.bottom = r1     // Catch:{ all -> 0x00bc }
        L_0x0094:
            r5.f14470g = r2     // Catch:{ all -> 0x00bc }
            java.lang.String r0 = f14464a     // Catch:{ all -> 0x00bc }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bc }
            r1.<init>()     // Catch:{ all -> 0x00bc }
            java.lang.String r2 = "Calculated framing rect in preview: "
            r1.append(r2)     // Catch:{ all -> 0x00bc }
            android.graphics.Rect r2 = r5.f14470g     // Catch:{ all -> 0x00bc }
            r1.append(r2)     // Catch:{ all -> 0x00bc }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00bc }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x00bc }
            int r0 = r5.p     // Catch:{ all -> 0x00bc }
            r5.n = r0     // Catch:{ all -> 0x00bc }
            int r0 = r5.o     // Catch:{ all -> 0x00bc }
            r5.m = r0     // Catch:{ all -> 0x00bc }
        L_0x00b6:
            android.graphics.Rect r0 = r5.f14470g     // Catch:{ all -> 0x00bc }
            monitor-exit(r5)
            return r0
        L_0x00ba:
            monitor-exit(r5)
            return r1
        L_0x00bc:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.b.c.f():android.graphics.Rect");
    }

    public synchronized void a(int i2, int i3) {
        if (this.h) {
            Point b2 = this.f14466c.b();
            if (i2 > b2.x) {
                i2 = b2.x;
            }
            if (i3 > b2.y) {
                i3 = b2.y;
            }
            int i4 = (b2.x - i2) / 2;
            int i5 = (b2.y - i3) / 2;
            this.f14469f = new Rect(i4, i5, i2 + i4, i3 + i5);
            String str = f14464a;
            Log.d(str, "Calculated manual framing rect: " + this.f14469f);
            this.f14470g = null;
        } else {
            this.j = i2;
            this.k = i3;
        }
    }

    public n a(byte[] bArr, int i2, int i3) {
        Rect f2 = f();
        if (f2 == null) {
            return null;
        }
        if (this.l == 1) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 2;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                InputStream openInputStream = this.f14465b.getContentResolver().openInputStream(this.u);
                Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream, (Rect) null, options);
                openInputStream.close();
                int[] iArr = new int[(decodeStream.getWidth() * decodeStream.getHeight())];
                decodeStream.getPixels(iArr, 0, decodeStream.getWidth(), 0, 0, decodeStream.getWidth(), decodeStream.getHeight());
                t tVar = new t(decodeStream.getWidth(), decodeStream.getHeight(), iArr);
                decodeStream.recycle();
                return tVar;
            } catch (Exception unused) {
            }
        }
        int i4 = this.o;
        if (i4 == 1 || i4 == 3) {
            f2 = a(f2);
        }
        return new r(bArr, i2, i3, f2.left, f2.top, f2.width(), f2.height(), false);
    }

    private Rect a(Rect rect) {
        int i2;
        Rect rect2 = new Rect(rect);
        if (rect.left < 60) {
            i2 = rect.left;
        } else {
            i2 = Math.max(60, rect.left / 2);
        }
        rect2.left -= i2;
        rect2.right += i2;
        return rect2;
    }

    public void b(int i2, int i3) {
        this.s = i2;
        this.r = i3;
    }
}
