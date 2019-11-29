package jp.co.cyberagent.android.gpuimage;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f33664a;

    /* renamed from: b  reason: collision with root package name */
    private final i f33665b;

    /* renamed from: c  reason: collision with root package name */
    private a f33666c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public e f33667d;

    /* renamed from: e  reason: collision with root package name */
    private Bitmap f33668e;

    /* renamed from: f  reason: collision with root package name */
    private C0528b f33669f = C0528b.CENTER_CROP;

    public interface a<T> {
        void a(T t);
    }

    /* renamed from: jp.co.cyberagent.android.gpuimage.b$b  reason: collision with other inner class name */
    public enum C0528b {
        CENTER_INSIDE,
        CENTER_CROP
    }

    public b(Context context) {
        if (a(context)) {
            this.f33664a = context;
            this.f33667d = new e();
            this.f33665b = new i(this.f33667d);
            return;
        }
        throw new IllegalStateException("OpenGL ES 2.0 is not supported on this phone.");
    }

    private boolean a(Context context) {
        return ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion >= 131072;
    }

    public void a(a aVar) {
        this.f33666c = aVar;
        this.f33666c.setEGLContextClientVersion(2);
        this.f33666c.a(8, 8, 8, 8, 16, 0);
        this.f33666c.setRenderer(this.f33665b);
        this.f33666c.setRenderMode(0);
        this.f33666c.a();
    }

    public void a() {
        a aVar = this.f33666c;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void a(e eVar) {
        this.f33667d = eVar;
        this.f33665b.a(this.f33667d);
        a();
    }

    public void a(Bitmap bitmap) {
        this.f33668e = bitmap;
        this.f33665b.a(bitmap, false);
        a();
    }

    public void a(C0528b bVar) {
        this.f33669f = bVar;
        this.f33665b.a(bVar);
        this.f33665b.a();
        this.f33668e = null;
        a();
    }

    public void a(p pVar, boolean z, boolean z2) {
        this.f33665b.a(pVar, z, z2);
    }

    public p b() {
        return this.f33665b.b();
    }

    public boolean c() {
        return this.f33665b.c();
    }

    public boolean d() {
        return this.f33665b.d();
    }

    public void e() {
        this.f33665b.a();
        this.f33668e = null;
        a();
    }

    public Bitmap b(Bitmap bitmap) {
        if (this.f33666c != null) {
            this.f33665b.a();
            this.f33665b.a((Runnable) new Runnable() {
                public void run() {
                    synchronized (b.this.f33667d) {
                        b.this.f33667d.f();
                        b.this.f33667d.notify();
                    }
                }
            });
            synchronized (this.f33667d) {
                a();
                try {
                    this.f33667d.wait();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        i iVar = new i(this.f33667d);
        iVar.a(this.f33665b.b(), this.f33665b.c(), this.f33665b.d());
        iVar.a(this.f33669f);
        o oVar = new o(bitmap.getWidth(), bitmap.getHeight());
        oVar.a(iVar);
        iVar.a(bitmap, false);
        Bitmap a2 = oVar.a();
        this.f33667d.f();
        iVar.a();
        oVar.b();
        this.f33665b.a(this.f33667d);
        Bitmap bitmap2 = this.f33668e;
        if (bitmap2 != null) {
            this.f33665b.a(bitmap2, false);
        }
        a();
        return a2;
    }

    public static void a(Bitmap bitmap, List<e> list, a<Bitmap> aVar) {
        if (!list.isEmpty()) {
            i iVar = new i(list.get(0));
            iVar.a(bitmap, false);
            o oVar = new o(bitmap.getWidth(), bitmap.getHeight());
            oVar.a(iVar);
            for (e next : list) {
                iVar.a(next);
                aVar.a(oVar.a());
                next.f();
            }
            iVar.a();
            oVar.b();
        }
    }
}
