package com.shopee.scanner.camera;

import android.annotation.SuppressLint;
import android.hardware.Camera;
import androidx.b.h;
import com.facebook.react.uimanager.ViewProps;
import com.shopee.scanner.camera.b;
import com.shopee.scanner.camera.e;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicBoolean;

class a extends b {

    /* renamed from: c  reason: collision with root package name */
    private static final h<String> f30295c = new h<>();

    /* renamed from: d  reason: collision with root package name */
    private int f30296d;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicBoolean f30297e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Camera f30298f;

    /* renamed from: g  reason: collision with root package name */
    private Camera.Parameters f30299g;
    private final Camera.CameraInfo h;
    private final g i;
    private final g j;
    private AspectRatio k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private Camera.PreviewCallback q;

    private boolean f(int i2) {
        return i2 == 90 || i2 == 270;
    }

    static {
        f30295c.b(0, "off");
        f30295c.b(1, ViewProps.ON);
        f30295c.b(2, "torch");
        f30295c.b(3, "auto");
        f30295c.b(4, "red-eye");
    }

    a(b.a aVar, e eVar) {
        super(aVar, eVar);
        this.f30297e = new AtomicBoolean(false);
        this.h = new Camera.CameraInfo();
        this.i = new g();
        this.j = new g();
        eVar.a(new e.a() {
            public void a() {
                if (a.this.f30298f != null) {
                    a.this.j();
                    a.this.p();
                }
            }
        });
    }

    a(b.a aVar, e eVar, Camera.PreviewCallback previewCallback) {
        this(aVar, eVar);
        this.q = previewCallback;
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        m();
        try {
            n();
            if (this.f30302b.b()) {
                j();
            }
            this.l = true;
            k();
            return true;
        } catch (RuntimeException e2) {
            g.a.a.b(e2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (this.f30298f != null) {
            l();
        }
        this.l = false;
        q();
    }

    /* access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void j() {
        try {
            this.f30298f.setPreviewTexture(this.f30302b.d());
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private void k() {
        this.f30298f.startPreview();
        Camera.PreviewCallback previewCallback = this.q;
        if (previewCallback != null) {
            this.f30298f.setPreviewCallback(previewCallback);
        }
    }

    private void l() {
        this.f30298f.stopPreview();
        this.f30298f.setPreviewCallback((Camera.PreviewCallback) null);
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return this.f30298f != null;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        if (this.n != i2) {
            this.n = i2;
            if (c()) {
                b();
                a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.n;
    }

    /* access modifiers changed from: package-private */
    public Set<AspectRatio> e() {
        g gVar = this.i;
        for (AspectRatio next : gVar.a()) {
            if (this.j.b(next) == null) {
                gVar.a(next);
            }
        }
        return gVar.a();
    }

    /* access modifiers changed from: package-private */
    public boolean a(AspectRatio aspectRatio) {
        if (this.k == null || !c()) {
            this.k = aspectRatio;
            return true;
        } else if (this.k.equals(aspectRatio)) {
            return false;
        } else {
            if (this.i.b(aspectRatio) != null) {
                this.k = aspectRatio;
                p();
                return true;
            }
            throw new UnsupportedOperationException(aspectRatio + " is not supported");
        }
    }

    /* access modifiers changed from: package-private */
    public AspectRatio f() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        if (this.m != z && b(z)) {
            this.f30298f.setParameters(this.f30299g);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        if (!c()) {
            return this.m;
        }
        String focusMode = this.f30299g.getFocusMode();
        return focusMode != null && focusMode.contains("continuous");
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        if (i2 != this.o && g(i2)) {
            this.f30298f.setParameters(this.f30299g);
        }
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return this.o;
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        if (this.p != i2) {
            this.p = i2;
            if (c()) {
                this.f30299g.setRotation(e(i2));
                this.f30298f.setParameters(this.f30299g);
                this.f30298f.setDisplayOrientation(d(i2));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Object obj) {
        this.q = (Camera.PreviewCallback) obj;
    }

    private void m() {
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.getCameraInfo(i2, this.h);
            if (this.h.facing == this.n) {
                this.f30296d = i2;
                return;
            }
        }
        this.f30296d = -1;
    }

    private void n() {
        if (this.f30298f != null) {
            q();
        }
        this.f30298f = Camera.open(this.f30296d);
        this.f30299g = this.f30298f.getParameters();
        this.i.b();
        for (Camera.Size next : this.f30299g.getSupportedPreviewSizes()) {
            this.i.a(new f(next.width, next.height));
        }
        this.j.b();
        for (Camera.Size next2 : this.f30299g.getSupportedPictureSizes()) {
            this.j.a(new f(next2.width, next2.height));
        }
        if (this.k == null) {
            this.k = c.f30303a;
        }
        p();
        this.f30298f.setDisplayOrientation(d(this.p));
        this.f30301a.a();
    }

    private AspectRatio o() {
        Iterator<AspectRatio> it = this.i.a().iterator();
        AspectRatio aspectRatio = null;
        while (it.hasNext()) {
            aspectRatio = it.next();
            if (aspectRatio.equals(c.f30303a)) {
                break;
            }
        }
        return aspectRatio;
    }

    /* access modifiers changed from: private */
    public void p() {
        SortedSet<f> b2 = this.i.b(this.k);
        if (b2 == null) {
            this.k = o();
            b2 = this.i.b(this.k);
        }
        f a2 = a(b2);
        f last = this.j.b(this.k).last();
        if (this.l) {
            l();
        }
        this.f30299g.setPreviewSize(a2.a(), a2.b());
        this.f30299g.setPictureSize(last.a(), last.b());
        this.f30299g.setRotation(e(this.p));
        b(this.m);
        g(this.o);
        this.f30298f.setParameters(this.f30299g);
        if (this.l) {
            k();
        }
    }

    private f a(SortedSet<f> sortedSet) {
        if (!this.f30302b.b()) {
            return sortedSet.first();
        }
        int e2 = this.f30302b.e();
        int f2 = this.f30302b.f();
        if (f(this.p)) {
            int i2 = f2;
            f2 = e2;
            e2 = i2;
        }
        r2 = null;
        for (f fVar : sortedSet) {
            if (e2 <= fVar.a() && f2 <= fVar.b()) {
                break;
            }
        }
        return fVar;
    }

    private void q() {
        Camera camera = this.f30298f;
        if (camera != null) {
            camera.release();
            this.f30298f = null;
            this.f30301a.b();
        }
    }

    private int d(int i2) {
        if (this.h.facing == 1) {
            return (360 - ((this.h.orientation + i2) % 360)) % 360;
        }
        return ((this.h.orientation - i2) + 360) % 360;
    }

    private int e(int i2) {
        if (this.h.facing == 1) {
            return (this.h.orientation + i2) % 360;
        }
        return ((this.h.orientation + i2) + (f(i2) ? 180 : 0)) % 360;
    }

    private boolean b(boolean z) {
        this.m = z;
        if (!c()) {
            return false;
        }
        List<String> supportedFocusModes = this.f30299g.getSupportedFocusModes();
        if (z && supportedFocusModes.contains("continuous-picture")) {
            this.f30299g.setFocusMode("continuous-picture");
            return true;
        } else if (supportedFocusModes.contains("fixed")) {
            this.f30299g.setFocusMode("fixed");
            return true;
        } else if (supportedFocusModes.contains("infinity")) {
            this.f30299g.setFocusMode("infinity");
            return true;
        } else {
            this.f30299g.setFocusMode(supportedFocusModes.get(0));
            return true;
        }
    }

    private boolean g(int i2) {
        if (c()) {
            List<String> supportedFlashModes = this.f30299g.getSupportedFlashModes();
            String a2 = f30295c.a(i2);
            if (supportedFlashModes == null || !supportedFlashModes.contains(a2)) {
                String a3 = f30295c.a(this.o);
                if (supportedFlashModes != null && supportedFlashModes.contains(a3)) {
                    return false;
                }
                this.f30299g.setFlashMode("off");
                this.o = 0;
                return true;
            }
            this.f30299g.setFlashMode(a2);
            this.o = i2;
            return true;
        }
        this.o = i2;
        return false;
    }
}
