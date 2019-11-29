package jp.co.cyberagent.android.gpuimage;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

public class a extends TextureView implements TextureView.SurfaceTextureListener, View.OnLayoutChangeListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final j f33622a = new j();

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<a> f33623b = new WeakReference<>(this);

    /* renamed from: c  reason: collision with root package name */
    private i f33624c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public GLSurfaceView.Renderer f33625d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f33626e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public e f33627f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public f f33628g;
    /* access modifiers changed from: private */
    public g h;
    /* access modifiers changed from: private */
    public k i;
    /* access modifiers changed from: private */
    public int j;
    /* access modifiers changed from: private */
    public int k;
    /* access modifiers changed from: private */
    public boolean l;

    public interface e {
        EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    public interface f {
        EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    public interface g {
        EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    public interface k {
        GL a(GL gl);
    }

    public a(Context context) {
        super(context);
        c();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (this.f33624c != null) {
                this.f33624c.f();
            }
        } finally {
            super.finalize();
        }
    }

    private void c() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(k kVar) {
        this.i = kVar;
    }

    public void setDebugFlags(int i2) {
        this.j = i2;
    }

    public int getDebugFlags() {
        return this.j;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.l = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.l;
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        d();
        if (this.f33627f == null) {
            this.f33627f = new m(true);
        }
        if (this.f33628g == null) {
            this.f33628g = new c();
        }
        if (this.h == null) {
            this.h = new d();
        }
        this.f33625d = renderer;
        this.f33624c = new i(this.f33623b);
        this.f33624c.start();
    }

    public void setEGLContextFactory(f fVar) {
        d();
        this.f33628g = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        d();
        this.h = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        d();
        this.f33627f = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser((e) new m(z));
    }

    public void a(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser((e) new b(i2, i3, i4, i5, i6, i7));
    }

    public void setEGLContextClientVersion(int i2) {
        d();
        this.k = i2;
    }

    public void setRenderMode(int i2) {
        this.f33624c.a(i2);
    }

    public int getRenderMode() {
        return this.f33624c.b();
    }

    public void a() {
        this.f33624c.c();
    }

    public void a(SurfaceTexture surfaceTexture) {
        this.f33624c.d();
    }

    public void b(SurfaceTexture surfaceTexture) {
        this.f33624c.e();
    }

    public void a(SurfaceTexture surfaceTexture, int i2, int i3, int i4) {
        this.f33624c.a(i3, i4);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d("GLTextureView", "onAttachedToWindow reattach =" + this.f33626e);
        if (this.f33626e && this.f33625d != null) {
            i iVar = this.f33624c;
            int b2 = iVar != null ? iVar.b() : 1;
            this.f33624c = new i(this.f33623b);
            if (b2 != 1) {
                this.f33624c.a(b2);
            }
            this.f33624c.start();
        }
        this.f33626e = false;
    }

    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        a(getSurfaceTexture(), 0, i4 - i2, i5 - i3);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        a(surfaceTexture);
        a(surfaceTexture, 0, i2, i3);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        a(surfaceTexture, 0, i2, i3);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        b(surfaceTexture);
        return true;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        a();
    }

    private class c implements f {

        /* renamed from: b  reason: collision with root package name */
        private int f33642b;

        private c() {
            this.f33642b = 12440;
        }

        public EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.f33642b, a.this.k, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (a.this.k == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                StringBuilder sb = new StringBuilder();
                sb.append("tid=");
                sb.append(Thread.currentThread().getId());
                Log.i("DefaultContextFactory", sb.toString());
                h.a("eglDestroyContex", egl10.eglGetError());
            }
        }
    }

    private static class d implements g {
        private d() {
        }

        public EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, (int[]) null);
            } catch (IllegalArgumentException e2) {
                Log.e("GLTextureView", "eglCreateWindowSurface", e2);
                return null;
            }
        }

        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* renamed from: jp.co.cyberagent.android.gpuimage.a$a  reason: collision with other inner class name */
    private abstract class C0527a implements e {

        /* renamed from: a  reason: collision with root package name */
        protected int[] f33633a;

        /* access modifiers changed from: package-private */
        public abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public C0527a(int[] iArr) {
            this.f33633a = a(iArr);
        }

        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.f33633a, (EGLConfig[]) null, 0, iArr)) {
                int i = iArr[0];
                if (i > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i];
                    if (egl10.eglChooseConfig(eGLDisplay, this.f33633a, eGLConfigArr, i, iArr)) {
                        EGLConfig a2 = a(egl10, eGLDisplay, eGLConfigArr);
                        if (a2 != null) {
                            return a2;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }

        private int[] a(int[] iArr) {
            if (a.this.k != 2) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[(length + 2)];
            int i = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr2[i] = 12352;
            iArr2[length] = 4;
            iArr2[length + 1] = 12344;
            return iArr2;
        }
    }

    private class b extends C0527a {

        /* renamed from: c  reason: collision with root package name */
        protected int f33636c;

        /* renamed from: d  reason: collision with root package name */
        protected int f33637d;

        /* renamed from: e  reason: collision with root package name */
        protected int f33638e;

        /* renamed from: f  reason: collision with root package name */
        protected int f33639f;

        /* renamed from: g  reason: collision with root package name */
        protected int f33640g;
        protected int h;
        private int[] j = new int[1];

        public b(int i2, int i3, int i4, int i5, int i6, int i7) {
            super(new int[]{12324, i2, 12323, i3, 12322, i4, 12321, i5, 12325, i6, 12326, i7, 12344});
            this.f33636c = i2;
            this.f33637d = i3;
            this.f33638e = i4;
            this.f33639f = i5;
            this.f33640g = i6;
            this.h = i7;
        }

        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                EGL10 egl102 = egl10;
                EGLDisplay eGLDisplay2 = eGLDisplay;
                EGLConfig eGLConfig2 = eGLConfig;
                int a2 = a(egl102, eGLDisplay2, eGLConfig2, 12325, 0);
                int a3 = a(egl102, eGLDisplay2, eGLConfig2, 12326, 0);
                if (a2 >= this.f33640g && a3 >= this.h) {
                    EGL10 egl103 = egl10;
                    EGLDisplay eGLDisplay3 = eGLDisplay;
                    EGLConfig eGLConfig3 = eGLConfig;
                    int a4 = a(egl103, eGLDisplay3, eGLConfig3, 12324, 0);
                    int a5 = a(egl103, eGLDisplay3, eGLConfig3, 12323, 0);
                    int a6 = a(egl103, eGLDisplay3, eGLConfig3, 12322, 0);
                    int a7 = a(egl103, eGLDisplay3, eGLConfig3, 12321, 0);
                    if (a4 == this.f33636c && a5 == this.f33637d && a6 == this.f33638e && a7 == this.f33639f) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2, int i3) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, this.j) ? this.j[0] : i3;
        }
    }

    private class m extends b {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    private static class h {

        /* renamed from: a  reason: collision with root package name */
        EGL10 f33643a;

        /* renamed from: b  reason: collision with root package name */
        EGLDisplay f33644b;

        /* renamed from: c  reason: collision with root package name */
        EGLSurface f33645c;

        /* renamed from: d  reason: collision with root package name */
        EGLConfig f33646d;

        /* renamed from: e  reason: collision with root package name */
        EGLContext f33647e;

        /* renamed from: f  reason: collision with root package name */
        private WeakReference<a> f33648f;

        public h(WeakReference<a> weakReference) {
            this.f33648f = weakReference;
        }

        public void a() {
            Log.w("EglHelper", "start() tid=" + Thread.currentThread().getId());
            this.f33643a = (EGL10) EGLContext.getEGL();
            this.f33644b = this.f33643a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.f33644b != EGL10.EGL_NO_DISPLAY) {
                if (this.f33643a.eglInitialize(this.f33644b, new int[2])) {
                    a aVar = (a) this.f33648f.get();
                    if (aVar == null) {
                        this.f33646d = null;
                        this.f33647e = null;
                    } else {
                        this.f33646d = aVar.f33627f.a(this.f33643a, this.f33644b);
                        this.f33647e = aVar.f33628g.a(this.f33643a, this.f33644b, this.f33646d);
                    }
                    EGLContext eGLContext = this.f33647e;
                    if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                        this.f33647e = null;
                        a("createContext");
                    }
                    Log.w("EglHelper", "createContext " + this.f33647e + " tid=" + Thread.currentThread().getId());
                    this.f33645c = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        public boolean b() {
            Log.w("EglHelper", "createSurface()  tid=" + Thread.currentThread().getId());
            if (this.f33643a == null) {
                throw new RuntimeException("egl not initialized");
            } else if (this.f33644b == null) {
                throw new RuntimeException("eglDisplay not initialized");
            } else if (this.f33646d != null) {
                g();
                a aVar = (a) this.f33648f.get();
                if (aVar != null) {
                    this.f33645c = aVar.h.a(this.f33643a, this.f33644b, this.f33646d, aVar.getSurfaceTexture());
                } else {
                    this.f33645c = null;
                }
                EGLSurface eGLSurface = this.f33645c;
                if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                    if (this.f33643a.eglGetError() == 12299) {
                        Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    }
                    return false;
                }
                EGL10 egl10 = this.f33643a;
                EGLDisplay eGLDisplay = this.f33644b;
                EGLSurface eGLSurface2 = this.f33645c;
                if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface2, eGLSurface2, this.f33647e)) {
                    return true;
                }
                a("EGLHelper", "eglMakeCurrent", this.f33643a.eglGetError());
                return false;
            } else {
                throw new RuntimeException("mEglConfig not initialized");
            }
        }

        /* access modifiers changed from: package-private */
        public GL c() {
            GL gl = this.f33647e.getGL();
            a aVar = (a) this.f33648f.get();
            if (aVar == null) {
                return gl;
            }
            if (aVar.i != null) {
                gl = aVar.i.a(gl);
            }
            if ((aVar.j & 3) == 0) {
                return gl;
            }
            int i = 0;
            l lVar = null;
            if ((aVar.j & 1) != 0) {
                i = 1;
            }
            if ((aVar.j & 2) != 0) {
                lVar = new l();
            }
            return GLDebugHelper.wrap(gl, i, lVar);
        }

        public int d() {
            if (!this.f33643a.eglSwapBuffers(this.f33644b, this.f33645c)) {
                return this.f33643a.eglGetError();
            }
            return 12288;
        }

        public void e() {
            Log.w("EglHelper", "destroySurface()  tid=" + Thread.currentThread().getId());
            g();
        }

        private void g() {
            EGLSurface eGLSurface = this.f33645c;
            if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                this.f33643a.eglMakeCurrent(this.f33644b, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                a aVar = (a) this.f33648f.get();
                if (aVar != null) {
                    aVar.h.a(this.f33643a, this.f33644b, this.f33645c);
                }
                this.f33645c = null;
            }
        }

        public void f() {
            Log.w("EglHelper", "finish() tid=" + Thread.currentThread().getId());
            if (this.f33647e != null) {
                a aVar = (a) this.f33648f.get();
                if (aVar != null) {
                    aVar.f33628g.a(this.f33643a, this.f33644b, this.f33647e);
                }
                this.f33647e = null;
            }
            EGLDisplay eGLDisplay = this.f33644b;
            if (eGLDisplay != null) {
                this.f33643a.eglTerminate(eGLDisplay);
                this.f33644b = null;
            }
        }

        private void a(String str) {
            a(str, this.f33643a.eglGetError());
        }

        public static void a(String str, int i) {
            String b2 = b(str, i);
            Log.e("EglHelper", "throwEglException tid=" + Thread.currentThread().getId() + SQLBuilder.BLANK + b2);
            throw new RuntimeException(b2);
        }

        public static void a(String str, String str2, int i) {
            Log.w(str, b(str2, i));
        }

        public static String b(String str, int i) {
            return str + " failed: " + i;
        }
    }

    static class i extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private boolean f33649a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f33650b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f33651c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f33652d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f33653e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f33654f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f33655g;
        private boolean h;
        private boolean i;
        private boolean j;
        private int k = 0;
        private int l = 0;
        private int m = 1;
        private boolean n = true;
        private boolean o;
        private ArrayList<Runnable> p = new ArrayList<>();
        private boolean q = true;
        private h r;
        private WeakReference<a> s;

        i(WeakReference<a> weakReference) {
            this.s = weakReference;
        }

        public void run() {
            setName("GLThread " + getId());
            Log.i("GLThread", "starting tid=" + getId());
            try {
                j();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                a.f33622a.a(this);
                throw th;
            }
            a.f33622a.a(this);
        }

        private void h() {
            if (this.i) {
                this.i = false;
                this.r.e();
            }
        }

        private void i() {
            if (this.h) {
                this.r.f();
                this.h = false;
                a.f33622a.c(this);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:104:0x025d, code lost:
            if (r7 == null) goto L_0x0268;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:106:?, code lost:
            r7.run();
            r5 = r17;
            r7 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:107:0x0268, code lost:
            if (r9 == false) goto L_0x0292;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:108:0x026a, code lost:
            android.util.Log.w("GLThread", "egl createSurface");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:109:0x0277, code lost:
            if (r1.r.b() != false) goto L_0x0291;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:110:0x0279, code lost:
            r5 = jp.co.cyberagent.android.gpuimage.a.b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:111:0x027d, code lost:
            monitor-enter(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:114:?, code lost:
            r1.f33654f = true;
            jp.co.cyberagent.android.gpuimage.a.b().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:115:0x0288, code lost:
            monitor-exit(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:116:0x0289, code lost:
            r5 = r17;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:121:0x0291, code lost:
            r9 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:122:0x0292, code lost:
            if (r10 == false) goto L_0x02a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:123:0x0294, code lost:
            r0 = (javax.microedition.khronos.opengles.GL10) r1.r.c();
            jp.co.cyberagent.android.gpuimage.a.b().a(r0);
            r5 = r0;
            r10 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:124:0x02a6, code lost:
            r5 = r17;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:125:0x02a8, code lost:
            if (r8 == false) goto L_0x02c7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:126:0x02aa, code lost:
            android.util.Log.w("GLThread", "onSurfaceCreated");
            r0 = (jp.co.cyberagent.android.gpuimage.a) r1.s.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:127:0x02b9, code lost:
            if (r0 == null) goto L_0x02c6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:128:0x02bb, code lost:
            jp.co.cyberagent.android.gpuimage.a.h(r0).onSurfaceCreated(r5, r1.r.f33646d);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:129:0x02c6, code lost:
            r8 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:130:0x02c7, code lost:
            if (r12 == false) goto L_0x02fe;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:131:0x02c9, code lost:
            android.util.Log.w("GLThread", "onSurfaceChanged(" + r4 + ", " + r6 + com.litesuits.orm.db.assit.SQLBuilder.PARENTHESES_RIGHT);
            r0 = (jp.co.cyberagent.android.gpuimage.a) r1.s.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:132:0x02f4, code lost:
            if (r0 == null) goto L_0x02fd;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:133:0x02f6, code lost:
            jp.co.cyberagent.android.gpuimage.a.h(r0).onSurfaceChanged(r5, r4, r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:134:0x02fd, code lost:
            r12 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:136:?, code lost:
            r0 = (jp.co.cyberagent.android.gpuimage.a) r1.s.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:137:0x0306, code lost:
            if (r0 == null) goto L_0x030f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:139:?, code lost:
            jp.co.cyberagent.android.gpuimage.a.h(r0).onDrawFrame(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:141:?, code lost:
            r0 = r1.r.d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:143:0x0317, code lost:
            if (r0 == 12288) goto L_0x0354;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:145:0x031b, code lost:
            if (r0 == 12302) goto L_0x0338;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:148:?, code lost:
            jp.co.cyberagent.android.gpuimage.a.h.a("GLThread", "eglSwapBuffers", r0);
            r2 = jp.co.cyberagent.android.gpuimage.a.b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:149:0x0328, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:152:?, code lost:
            r1.f33654f = true;
            jp.co.cyberagent.android.gpuimage.a.b().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:153:0x0333, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:161:?, code lost:
            android.util.Log.i("GLThread", "egl context lost tid=" + getId());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:162:0x0353, code lost:
            r11 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:163:0x0354, code lost:
            if (r13 == false) goto L_0x0357;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:164:0x0356, code lost:
            r14 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:165:0x0357, code lost:
            r1 = r19;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:166:0x035c, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:167:0x035d, code lost:
            r2 = r19;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:186:0x0404, code lost:
            monitor-enter(jp.co.cyberagent.android.gpuimage.a.b());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:188:?, code lost:
            h();
            i();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:190:0x040c, code lost:
            throw r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void j() throws java.lang.InterruptedException {
            /*
                r19 = this;
                r1 = r19
                jp.co.cyberagent.android.gpuimage.a$h r0 = new jp.co.cyberagent.android.gpuimage.a$h
                java.lang.ref.WeakReference<jp.co.cyberagent.android.gpuimage.a> r2 = r1.s
                r0.<init>(r2)
                r1.r = r0
                r0 = 0
                r1.h = r0
                r1.i = r0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
            L_0x001c:
                jp.co.cyberagent.android.gpuimage.a$j r15 = jp.co.cyberagent.android.gpuimage.a.f33622a     // Catch:{ all -> 0x03fe }
                monitor-enter(r15)     // Catch:{ all -> 0x03fe }
            L_0x0021:
                boolean r2 = r1.f33649a     // Catch:{ all -> 0x03f6 }
                if (r2 == 0) goto L_0x0036
                monitor-exit(r15)     // Catch:{ all -> 0x03f6 }
                jp.co.cyberagent.android.gpuimage.a$j r2 = jp.co.cyberagent.android.gpuimage.a.f33622a
                monitor-enter(r2)
                r19.h()     // Catch:{ all -> 0x0033 }
                r19.i()     // Catch:{ all -> 0x0033 }
                monitor-exit(r2)     // Catch:{ all -> 0x0033 }
                return
            L_0x0033:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0033 }
                throw r0
            L_0x0036:
                java.util.ArrayList<java.lang.Runnable> r2 = r1.p     // Catch:{ all -> 0x03f6 }
                boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x03f6 }
                if (r2 != 0) goto L_0x004d
                java.util.ArrayList<java.lang.Runnable> r2 = r1.p     // Catch:{ all -> 0x03f6 }
                r7 = 0
                java.lang.Object r2 = r2.remove(r7)     // Catch:{ all -> 0x03f6 }
                java.lang.Runnable r2 = (java.lang.Runnable) r2     // Catch:{ all -> 0x03f6 }
                r7 = r2
                r17 = r5
                r2 = 0
                goto L_0x025c
            L_0x004d:
                boolean r2 = r1.f33652d     // Catch:{ all -> 0x03f6 }
                boolean r0 = r1.f33651c     // Catch:{ all -> 0x03f6 }
                if (r2 == r0) goto L_0x008b
                boolean r0 = r1.f33651c     // Catch:{ all -> 0x03f6 }
                boolean r2 = r1.f33651c     // Catch:{ all -> 0x03f6 }
                r1.f33652d = r2     // Catch:{ all -> 0x03f6 }
                jp.co.cyberagent.android.gpuimage.a$j r2 = jp.co.cyberagent.android.gpuimage.a.f33622a     // Catch:{ all -> 0x03f6 }
                r2.notifyAll()     // Catch:{ all -> 0x03f6 }
                java.lang.String r2 = "GLThread"
                r16 = r0
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x03f6 }
                r0.<init>()     // Catch:{ all -> 0x03f6 }
                r17 = r3
                java.lang.String r3 = "mPaused is now "
                r0.append(r3)     // Catch:{ all -> 0x03f6 }
                boolean r3 = r1.f33652d     // Catch:{ all -> 0x03f6 }
                r0.append(r3)     // Catch:{ all -> 0x03f6 }
                java.lang.String r3 = " tid="
                r0.append(r3)     // Catch:{ all -> 0x03f6 }
                r18 = r4
                long r3 = r19.getId()     // Catch:{ all -> 0x03f6 }
                r0.append(r3)     // Catch:{ all -> 0x03f6 }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x03f6 }
                android.util.Log.i(r2, r0)     // Catch:{ all -> 0x03f6 }
                goto L_0x0091
            L_0x008b:
                r17 = r3
                r18 = r4
                r16 = 0
            L_0x0091:
                boolean r0 = r1.j     // Catch:{ all -> 0x03f6 }
                if (r0 == 0) goto L_0x00ba
                java.lang.String r0 = "GLThread"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x03f6 }
                r2.<init>()     // Catch:{ all -> 0x03f6 }
                java.lang.String r3 = "releasing EGL context because asked to tid="
                r2.append(r3)     // Catch:{ all -> 0x03f6 }
                long r3 = r19.getId()     // Catch:{ all -> 0x03f6 }
                r2.append(r3)     // Catch:{ all -> 0x03f6 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x03f6 }
                android.util.Log.i(r0, r2)     // Catch:{ all -> 0x03f6 }
                r19.h()     // Catch:{ all -> 0x03f6 }
                r19.i()     // Catch:{ all -> 0x03f6 }
                r0 = 0
                r1.j = r0     // Catch:{ all -> 0x03f6 }
                r0 = 1
                goto L_0x00bc
            L_0x00ba:
                r0 = r17
            L_0x00bc:
                if (r11 == 0) goto L_0x00c5
                r19.h()     // Catch:{ all -> 0x03f6 }
                r19.i()     // Catch:{ all -> 0x03f6 }
                r11 = 0
            L_0x00c5:
                if (r16 == 0) goto L_0x00eb
                boolean r2 = r1.i     // Catch:{ all -> 0x03f6 }
                if (r2 == 0) goto L_0x00eb
                java.lang.String r2 = "GLThread"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x03f6 }
                r3.<init>()     // Catch:{ all -> 0x03f6 }
                java.lang.String r4 = "releasing EGL surface because paused tid="
                r3.append(r4)     // Catch:{ all -> 0x03f6 }
                r17 = r5
                long r4 = r19.getId()     // Catch:{ all -> 0x03f6 }
                r3.append(r4)     // Catch:{ all -> 0x03f6 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x03f6 }
                android.util.Log.i(r2, r3)     // Catch:{ all -> 0x03f6 }
                r19.h()     // Catch:{ all -> 0x03f6 }
                goto L_0x00ed
            L_0x00eb:
                r17 = r5
            L_0x00ed:
                if (r16 == 0) goto L_0x012c
                boolean r2 = r1.h     // Catch:{ all -> 0x03f6 }
                if (r2 == 0) goto L_0x012c
                java.lang.ref.WeakReference<jp.co.cyberagent.android.gpuimage.a> r2 = r1.s     // Catch:{ all -> 0x03f6 }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x03f6 }
                jp.co.cyberagent.android.gpuimage.a r2 = (jp.co.cyberagent.android.gpuimage.a) r2     // Catch:{ all -> 0x03f6 }
                if (r2 != 0) goto L_0x00ff
                r2 = 0
                goto L_0x0103
            L_0x00ff:
                boolean r2 = r2.l     // Catch:{ all -> 0x03f6 }
            L_0x0103:
                if (r2 == 0) goto L_0x010f
                jp.co.cyberagent.android.gpuimage.a$j r2 = jp.co.cyberagent.android.gpuimage.a.f33622a     // Catch:{ all -> 0x03f6 }
                boolean r2 = r2.a()     // Catch:{ all -> 0x03f6 }
                if (r2 == 0) goto L_0x012c
            L_0x010f:
                r19.i()     // Catch:{ all -> 0x03f6 }
                java.lang.String r2 = "GLThread"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x03f6 }
                r3.<init>()     // Catch:{ all -> 0x03f6 }
                java.lang.String r4 = "releasing EGL context because paused tid="
                r3.append(r4)     // Catch:{ all -> 0x03f6 }
                long r4 = r19.getId()     // Catch:{ all -> 0x03f6 }
                r3.append(r4)     // Catch:{ all -> 0x03f6 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x03f6 }
                android.util.Log.i(r2, r3)     // Catch:{ all -> 0x03f6 }
            L_0x012c:
                if (r16 == 0) goto L_0x0157
                jp.co.cyberagent.android.gpuimage.a$j r2 = jp.co.cyberagent.android.gpuimage.a.f33622a     // Catch:{ all -> 0x03f6 }
                boolean r2 = r2.b()     // Catch:{ all -> 0x03f6 }
                if (r2 == 0) goto L_0x0157
                jp.co.cyberagent.android.gpuimage.a$h r2 = r1.r     // Catch:{ all -> 0x03f6 }
                r2.f()     // Catch:{ all -> 0x03f6 }
                java.lang.String r2 = "GLThread"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x03f6 }
                r3.<init>()     // Catch:{ all -> 0x03f6 }
                java.lang.String r4 = "terminating EGL because paused tid="
                r3.append(r4)     // Catch:{ all -> 0x03f6 }
                long r4 = r19.getId()     // Catch:{ all -> 0x03f6 }
                r3.append(r4)     // Catch:{ all -> 0x03f6 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x03f6 }
                android.util.Log.i(r2, r3)     // Catch:{ all -> 0x03f6 }
            L_0x0157:
                boolean r2 = r1.f33653e     // Catch:{ all -> 0x03f6 }
                if (r2 != 0) goto L_0x018d
                boolean r2 = r1.f33655g     // Catch:{ all -> 0x03f6 }
                if (r2 != 0) goto L_0x018d
                java.lang.String r2 = "GLThread"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x03f6 }
                r3.<init>()     // Catch:{ all -> 0x03f6 }
                java.lang.String r4 = "noticed surfaceView surface lost tid="
                r3.append(r4)     // Catch:{ all -> 0x03f6 }
                long r4 = r19.getId()     // Catch:{ all -> 0x03f6 }
                r3.append(r4)     // Catch:{ all -> 0x03f6 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x03f6 }
                android.util.Log.i(r2, r3)     // Catch:{ all -> 0x03f6 }
                boolean r2 = r1.i     // Catch:{ all -> 0x03f6 }
                if (r2 == 0) goto L_0x0180
                r19.h()     // Catch:{ all -> 0x03f6 }
            L_0x0180:
                r2 = 1
                r1.f33655g = r2     // Catch:{ all -> 0x03f6 }
                r2 = 0
                r1.f33654f = r2     // Catch:{ all -> 0x03f6 }
                jp.co.cyberagent.android.gpuimage.a$j r2 = jp.co.cyberagent.android.gpuimage.a.f33622a     // Catch:{ all -> 0x03f6 }
                r2.notifyAll()     // Catch:{ all -> 0x03f6 }
            L_0x018d:
                boolean r2 = r1.f33653e     // Catch:{ all -> 0x03f6 }
                if (r2 == 0) goto L_0x01b9
                boolean r2 = r1.f33655g     // Catch:{ all -> 0x03f6 }
                if (r2 == 0) goto L_0x01b9
                java.lang.String r2 = "GLThread"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x03f6 }
                r3.<init>()     // Catch:{ all -> 0x03f6 }
                java.lang.String r4 = "noticed surfaceView surface acquired tid="
                r3.append(r4)     // Catch:{ all -> 0x03f6 }
                long r4 = r19.getId()     // Catch:{ all -> 0x03f6 }
                r3.append(r4)     // Catch:{ all -> 0x03f6 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x03f6 }
                android.util.Log.i(r2, r3)     // Catch:{ all -> 0x03f6 }
                r2 = 0
                r1.f33655g = r2     // Catch:{ all -> 0x03f6 }
                jp.co.cyberagent.android.gpuimage.a$j r2 = jp.co.cyberagent.android.gpuimage.a.f33622a     // Catch:{ all -> 0x03f6 }
                r2.notifyAll()     // Catch:{ all -> 0x03f6 }
            L_0x01b9:
                if (r14 == 0) goto L_0x01e1
                java.lang.String r2 = "GLThread"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x03f6 }
                r3.<init>()     // Catch:{ all -> 0x03f6 }
                java.lang.String r4 = "sending render notification tid="
                r3.append(r4)     // Catch:{ all -> 0x03f6 }
                long r4 = r19.getId()     // Catch:{ all -> 0x03f6 }
                r3.append(r4)     // Catch:{ all -> 0x03f6 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x03f6 }
                android.util.Log.i(r2, r3)     // Catch:{ all -> 0x03f6 }
                r2 = 1
                r1.o = r2     // Catch:{ all -> 0x03f6 }
                jp.co.cyberagent.android.gpuimage.a$j r2 = jp.co.cyberagent.android.gpuimage.a.f33622a     // Catch:{ all -> 0x03f6 }
                r2.notifyAll()     // Catch:{ all -> 0x03f6 }
                r13 = 0
                r14 = 0
            L_0x01e1:
                boolean r2 = r19.k()     // Catch:{ all -> 0x03f6 }
                if (r2 == 0) goto L_0x0366
                boolean r2 = r1.h     // Catch:{ all -> 0x0361 }
                if (r2 != 0) goto L_0x0213
                if (r0 == 0) goto L_0x01ef
                r0 = 0
                goto L_0x0213
            L_0x01ef:
                jp.co.cyberagent.android.gpuimage.a$j r2 = jp.co.cyberagent.android.gpuimage.a.f33622a     // Catch:{ all -> 0x03f6 }
                boolean r2 = r2.b(r1)     // Catch:{ all -> 0x03f6 }
                if (r2 == 0) goto L_0x0213
                jp.co.cyberagent.android.gpuimage.a$h r2 = r1.r     // Catch:{ RuntimeException -> 0x020a }
                r2.a()     // Catch:{ RuntimeException -> 0x020a }
                r2 = 1
                r1.h = r2     // Catch:{ all -> 0x03f6 }
                jp.co.cyberagent.android.gpuimage.a$j r2 = jp.co.cyberagent.android.gpuimage.a.f33622a     // Catch:{ all -> 0x03f6 }
                r2.notifyAll()     // Catch:{ all -> 0x03f6 }
                r8 = 1
                goto L_0x0213
            L_0x020a:
                r0 = move-exception
                jp.co.cyberagent.android.gpuimage.a$j r2 = jp.co.cyberagent.android.gpuimage.a.f33622a     // Catch:{ all -> 0x03f6 }
                r2.c(r1)     // Catch:{ all -> 0x03f6 }
                throw r0     // Catch:{ all -> 0x03f6 }
            L_0x0213:
                boolean r2 = r1.h     // Catch:{ all -> 0x0361 }
                if (r2 == 0) goto L_0x0221
                boolean r2 = r1.i     // Catch:{ all -> 0x03f6 }
                if (r2 != 0) goto L_0x0221
                r2 = 1
                r1.i = r2     // Catch:{ all -> 0x03f6 }
                r9 = 1
                r10 = 1
                r12 = 1
            L_0x0221:
                boolean r2 = r1.i     // Catch:{ all -> 0x0361 }
                if (r2 == 0) goto L_0x0366
                boolean r2 = r1.q     // Catch:{ all -> 0x0361 }
                if (r2 == 0) goto L_0x024f
                int r4 = r1.k     // Catch:{ all -> 0x03f6 }
                int r6 = r1.l     // Catch:{ all -> 0x03f6 }
                java.lang.String r2 = "GLThread"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x03f6 }
                r3.<init>()     // Catch:{ all -> 0x03f6 }
                java.lang.String r5 = "noticing that we want render notification tid="
                r3.append(r5)     // Catch:{ all -> 0x03f6 }
                long r12 = r19.getId()     // Catch:{ all -> 0x03f6 }
                r3.append(r12)     // Catch:{ all -> 0x03f6 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x03f6 }
                android.util.Log.i(r2, r3)     // Catch:{ all -> 0x03f6 }
                r2 = 0
                r1.q = r2     // Catch:{ all -> 0x03f6 }
                r2 = 0
                r9 = 1
                r12 = 1
                r13 = 1
                goto L_0x0252
            L_0x024f:
                r4 = r18
                r2 = 0
            L_0x0252:
                r1.n = r2     // Catch:{ all -> 0x0361 }
                jp.co.cyberagent.android.gpuimage.a$j r3 = jp.co.cyberagent.android.gpuimage.a.f33622a     // Catch:{ all -> 0x0361 }
                r3.notifyAll()     // Catch:{ all -> 0x0361 }
                r3 = r0
            L_0x025c:
                monitor-exit(r15)     // Catch:{ all -> 0x0361 }
                if (r7 == 0) goto L_0x0268
                r7.run()     // Catch:{ all -> 0x03fe }
                r5 = r17
                r0 = 0
                r7 = 0
                goto L_0x001c
            L_0x0268:
                if (r9 == 0) goto L_0x0292
                java.lang.String r0 = "GLThread"
                java.lang.String r5 = "egl createSurface"
                android.util.Log.w(r0, r5)     // Catch:{ all -> 0x03fe }
                jp.co.cyberagent.android.gpuimage.a$h r0 = r1.r     // Catch:{ all -> 0x03fe }
                boolean r0 = r0.b()     // Catch:{ all -> 0x03fe }
                if (r0 != 0) goto L_0x0291
                jp.co.cyberagent.android.gpuimage.a$j r5 = jp.co.cyberagent.android.gpuimage.a.f33622a     // Catch:{ all -> 0x03fe }
                monitor-enter(r5)     // Catch:{ all -> 0x03fe }
                r0 = 1
                r1.f33654f = r0     // Catch:{ all -> 0x028e }
                jp.co.cyberagent.android.gpuimage.a$j r0 = jp.co.cyberagent.android.gpuimage.a.f33622a     // Catch:{ all -> 0x028e }
                r0.notifyAll()     // Catch:{ all -> 0x028e }
                monitor-exit(r5)     // Catch:{ all -> 0x028e }
                r5 = r17
                r0 = 0
                goto L_0x001c
            L_0x028e:
                r0 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x028e }
                throw r0     // Catch:{ all -> 0x03fe }
            L_0x0291:
                r9 = 0
            L_0x0292:
                if (r10 == 0) goto L_0x02a6
                jp.co.cyberagent.android.gpuimage.a$h r0 = r1.r     // Catch:{ all -> 0x03fe }
                javax.microedition.khronos.opengles.GL r0 = r0.c()     // Catch:{ all -> 0x03fe }
                javax.microedition.khronos.opengles.GL10 r0 = (javax.microedition.khronos.opengles.GL10) r0     // Catch:{ all -> 0x03fe }
                jp.co.cyberagent.android.gpuimage.a$j r5 = jp.co.cyberagent.android.gpuimage.a.f33622a     // Catch:{ all -> 0x03fe }
                r5.a((javax.microedition.khronos.opengles.GL10) r0)     // Catch:{ all -> 0x03fe }
                r5 = r0
                r10 = 0
                goto L_0x02a8
            L_0x02a6:
                r5 = r17
            L_0x02a8:
                if (r8 == 0) goto L_0x02c7
                java.lang.String r0 = "GLThread"
                java.lang.String r8 = "onSurfaceCreated"
                android.util.Log.w(r0, r8)     // Catch:{ all -> 0x03fe }
                java.lang.ref.WeakReference<jp.co.cyberagent.android.gpuimage.a> r0 = r1.s     // Catch:{ all -> 0x03fe }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x03fe }
                jp.co.cyberagent.android.gpuimage.a r0 = (jp.co.cyberagent.android.gpuimage.a) r0     // Catch:{ all -> 0x03fe }
                if (r0 == 0) goto L_0x02c6
                android.opengl.GLSurfaceView$Renderer r0 = r0.f33625d     // Catch:{ all -> 0x03fe }
                jp.co.cyberagent.android.gpuimage.a$h r8 = r1.r     // Catch:{ all -> 0x03fe }
                javax.microedition.khronos.egl.EGLConfig r8 = r8.f33646d     // Catch:{ all -> 0x03fe }
                r0.onSurfaceCreated(r5, r8)     // Catch:{ all -> 0x03fe }
            L_0x02c6:
                r8 = 0
            L_0x02c7:
                if (r12 == 0) goto L_0x02fe
                java.lang.String r0 = "GLThread"
                java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x03fe }
                r12.<init>()     // Catch:{ all -> 0x03fe }
                java.lang.String r15 = "onSurfaceChanged("
                r12.append(r15)     // Catch:{ all -> 0x03fe }
                r12.append(r4)     // Catch:{ all -> 0x03fe }
                java.lang.String r15 = ", "
                r12.append(r15)     // Catch:{ all -> 0x03fe }
                r12.append(r6)     // Catch:{ all -> 0x03fe }
                java.lang.String r15 = ")"
                r12.append(r15)     // Catch:{ all -> 0x03fe }
                java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x03fe }
                android.util.Log.w(r0, r12)     // Catch:{ all -> 0x03fe }
                java.lang.ref.WeakReference<jp.co.cyberagent.android.gpuimage.a> r0 = r1.s     // Catch:{ all -> 0x03fe }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x03fe }
                jp.co.cyberagent.android.gpuimage.a r0 = (jp.co.cyberagent.android.gpuimage.a) r0     // Catch:{ all -> 0x03fe }
                if (r0 == 0) goto L_0x02fd
                android.opengl.GLSurfaceView$Renderer r0 = r0.f33625d     // Catch:{ all -> 0x03fe }
                r0.onSurfaceChanged(r5, r4, r6)     // Catch:{ all -> 0x03fe }
            L_0x02fd:
                r12 = 0
            L_0x02fe:
                java.lang.ref.WeakReference<jp.co.cyberagent.android.gpuimage.a> r0 = r1.s     // Catch:{ all -> 0x035c }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x035c }
                jp.co.cyberagent.android.gpuimage.a r0 = (jp.co.cyberagent.android.gpuimage.a) r0     // Catch:{ all -> 0x035c }
                if (r0 == 0) goto L_0x030f
                android.opengl.GLSurfaceView$Renderer r0 = r0.f33625d     // Catch:{ all -> 0x03fe }
                r0.onDrawFrame(r5)     // Catch:{ all -> 0x03fe }
            L_0x030f:
                jp.co.cyberagent.android.gpuimage.a$h r0 = r1.r     // Catch:{ all -> 0x035c }
                int r0 = r0.d()     // Catch:{ all -> 0x035c }
                r15 = 12288(0x3000, float:1.7219E-41)
                if (r0 == r15) goto L_0x0354
                r15 = 12302(0x300e, float:1.7239E-41)
                if (r0 == r15) goto L_0x0338
                java.lang.String r15 = "GLThread"
                java.lang.String r2 = "eglSwapBuffers"
                jp.co.cyberagent.android.gpuimage.a.h.a(r15, r2, r0)     // Catch:{ all -> 0x03fe }
                jp.co.cyberagent.android.gpuimage.a$j r2 = jp.co.cyberagent.android.gpuimage.a.f33622a     // Catch:{ all -> 0x03fe }
                monitor-enter(r2)     // Catch:{ all -> 0x03fe }
                r0 = 1
                r1.f33654f = r0     // Catch:{ all -> 0x0335 }
                jp.co.cyberagent.android.gpuimage.a$j r15 = jp.co.cyberagent.android.gpuimage.a.f33622a     // Catch:{ all -> 0x0335 }
                r15.notifyAll()     // Catch:{ all -> 0x0335 }
                monitor-exit(r2)     // Catch:{ all -> 0x0335 }
                goto L_0x0354
            L_0x0335:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0335 }
                throw r0     // Catch:{ all -> 0x03fe }
            L_0x0338:
                r0 = 1
                java.lang.String r2 = "GLThread"
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x035c }
                r11.<init>()     // Catch:{ all -> 0x035c }
                java.lang.String r15 = "egl context lost tid="
                r11.append(r15)     // Catch:{ all -> 0x035c }
                long r0 = r19.getId()     // Catch:{ all -> 0x035c }
                r11.append(r0)     // Catch:{ all -> 0x035c }
                java.lang.String r0 = r11.toString()     // Catch:{ all -> 0x035c }
                android.util.Log.i(r2, r0)     // Catch:{ all -> 0x035c }
                r11 = 1
            L_0x0354:
                if (r13 == 0) goto L_0x0357
                r14 = 1
            L_0x0357:
                r0 = 0
                r1 = r19
                goto L_0x001c
            L_0x035c:
                r0 = move-exception
                r2 = r19
                goto L_0x0400
            L_0x0361:
                r0 = move-exception
                r2 = r19
                goto L_0x03f8
            L_0x0366:
                r3 = r0
                java.lang.String r0 = "GLThread"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0361 }
                r1.<init>()     // Catch:{ all -> 0x0361 }
                java.lang.String r2 = "waiting tid="
                r1.append(r2)     // Catch:{ all -> 0x0361 }
                long r4 = r19.getId()     // Catch:{ all -> 0x0361 }
                r1.append(r4)     // Catch:{ all -> 0x0361 }
                java.lang.String r2 = " mHaveEglContext: "
                r1.append(r2)     // Catch:{ all -> 0x0361 }
                r2 = r19
                boolean r4 = r2.h     // Catch:{ all -> 0x03fc }
                r1.append(r4)     // Catch:{ all -> 0x03fc }
                java.lang.String r4 = " mHaveEglSurface: "
                r1.append(r4)     // Catch:{ all -> 0x03fc }
                boolean r4 = r2.i     // Catch:{ all -> 0x03fc }
                r1.append(r4)     // Catch:{ all -> 0x03fc }
                java.lang.String r4 = " mPaused: "
                r1.append(r4)     // Catch:{ all -> 0x03fc }
                boolean r4 = r2.f33652d     // Catch:{ all -> 0x03fc }
                r1.append(r4)     // Catch:{ all -> 0x03fc }
                java.lang.String r4 = " mHasSurface: "
                r1.append(r4)     // Catch:{ all -> 0x03fc }
                boolean r4 = r2.f33653e     // Catch:{ all -> 0x03fc }
                r1.append(r4)     // Catch:{ all -> 0x03fc }
                java.lang.String r4 = " mSurfaceIsBad: "
                r1.append(r4)     // Catch:{ all -> 0x03fc }
                boolean r4 = r2.f33654f     // Catch:{ all -> 0x03fc }
                r1.append(r4)     // Catch:{ all -> 0x03fc }
                java.lang.String r4 = " mWaitingForSurface: "
                r1.append(r4)     // Catch:{ all -> 0x03fc }
                boolean r4 = r2.f33655g     // Catch:{ all -> 0x03fc }
                r1.append(r4)     // Catch:{ all -> 0x03fc }
                java.lang.String r4 = " mWidth: "
                r1.append(r4)     // Catch:{ all -> 0x03fc }
                int r4 = r2.k     // Catch:{ all -> 0x03fc }
                r1.append(r4)     // Catch:{ all -> 0x03fc }
                java.lang.String r4 = " mHeight: "
                r1.append(r4)     // Catch:{ all -> 0x03fc }
                int r4 = r2.l     // Catch:{ all -> 0x03fc }
                r1.append(r4)     // Catch:{ all -> 0x03fc }
                java.lang.String r4 = " mRequestRender: "
                r1.append(r4)     // Catch:{ all -> 0x03fc }
                boolean r4 = r2.n     // Catch:{ all -> 0x03fc }
                r1.append(r4)     // Catch:{ all -> 0x03fc }
                java.lang.String r4 = " mRenderMode: "
                r1.append(r4)     // Catch:{ all -> 0x03fc }
                int r4 = r2.m     // Catch:{ all -> 0x03fc }
                r1.append(r4)     // Catch:{ all -> 0x03fc }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x03fc }
                android.util.Log.i(r0, r1)     // Catch:{ all -> 0x03fc }
                jp.co.cyberagent.android.gpuimage.a$j r0 = jp.co.cyberagent.android.gpuimage.a.f33622a     // Catch:{ all -> 0x03fc }
                r0.wait()     // Catch:{ all -> 0x03fc }
                r1 = r2
                r5 = r17
                r4 = r18
                r0 = 0
                goto L_0x0021
            L_0x03f6:
                r0 = move-exception
                r2 = r1
            L_0x03f8:
                monitor-exit(r15)     // Catch:{ all -> 0x03fc }
                throw r0     // Catch:{ all -> 0x03fa }
            L_0x03fa:
                r0 = move-exception
                goto L_0x0400
            L_0x03fc:
                r0 = move-exception
                goto L_0x03f8
            L_0x03fe:
                r0 = move-exception
                r2 = r1
            L_0x0400:
                jp.co.cyberagent.android.gpuimage.a$j r1 = jp.co.cyberagent.android.gpuimage.a.f33622a
                monitor-enter(r1)
                r19.h()     // Catch:{ all -> 0x040d }
                r19.i()     // Catch:{ all -> 0x040d }
                monitor-exit(r1)     // Catch:{ all -> 0x040d }
                throw r0
            L_0x040d:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x040d }
                goto L_0x0411
            L_0x0410:
                throw r0
            L_0x0411:
                goto L_0x0410
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.cyberagent.android.gpuimage.a.i.j():void");
        }

        public boolean a() {
            return this.h && this.i && k();
        }

        private boolean k() {
            return !this.f33652d && this.f33653e && !this.f33654f && this.k > 0 && this.l > 0 && (this.n || this.m == 1);
        }

        public void a(int i2) {
            if (i2 < 0 || i2 > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (a.f33622a) {
                this.m = i2;
                a.f33622a.notifyAll();
            }
        }

        public int b() {
            int i2;
            synchronized (a.f33622a) {
                i2 = this.m;
            }
            return i2;
        }

        public void c() {
            synchronized (a.f33622a) {
                this.n = true;
                a.f33622a.notifyAll();
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:9|10|11|12|22|18|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0029, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0039 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void d() {
            /*
                r5 = this;
                jp.co.cyberagent.android.gpuimage.a$j r0 = jp.co.cyberagent.android.gpuimage.a.f33622a
                monitor-enter(r0)
                java.lang.String r1 = "GLThread"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0043 }
                r2.<init>()     // Catch:{ all -> 0x0043 }
                java.lang.String r3 = "surfaceCreated tid="
                r2.append(r3)     // Catch:{ all -> 0x0043 }
                long r3 = r5.getId()     // Catch:{ all -> 0x0043 }
                r2.append(r3)     // Catch:{ all -> 0x0043 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0043 }
                android.util.Log.i(r1, r2)     // Catch:{ all -> 0x0043 }
                r1 = 1
                r5.f33653e = r1     // Catch:{ all -> 0x0043 }
                jp.co.cyberagent.android.gpuimage.a$j r1 = jp.co.cyberagent.android.gpuimage.a.f33622a     // Catch:{ all -> 0x0043 }
                r1.notifyAll()     // Catch:{ all -> 0x0043 }
            L_0x0029:
                boolean r1 = r5.f33655g     // Catch:{ all -> 0x0043 }
                if (r1 == 0) goto L_0x0041
                boolean r1 = r5.f33650b     // Catch:{ all -> 0x0043 }
                if (r1 != 0) goto L_0x0041
                jp.co.cyberagent.android.gpuimage.a$j r1 = jp.co.cyberagent.android.gpuimage.a.f33622a     // Catch:{ InterruptedException -> 0x0039 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0039 }
                goto L_0x0029
            L_0x0039:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0043 }
                r1.interrupt()     // Catch:{ all -> 0x0043 }
                goto L_0x0029
            L_0x0041:
                monitor-exit(r0)     // Catch:{ all -> 0x0043 }
                return
            L_0x0043:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0043 }
                goto L_0x0047
            L_0x0046:
                throw r1
            L_0x0047:
                goto L_0x0046
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.cyberagent.android.gpuimage.a.i.d():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:9|10|11|12|22|18|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0029, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0039 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void e() {
            /*
                r5 = this;
                jp.co.cyberagent.android.gpuimage.a$j r0 = jp.co.cyberagent.android.gpuimage.a.f33622a
                monitor-enter(r0)
                java.lang.String r1 = "GLThread"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0043 }
                r2.<init>()     // Catch:{ all -> 0x0043 }
                java.lang.String r3 = "surfaceDestroyed tid="
                r2.append(r3)     // Catch:{ all -> 0x0043 }
                long r3 = r5.getId()     // Catch:{ all -> 0x0043 }
                r2.append(r3)     // Catch:{ all -> 0x0043 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0043 }
                android.util.Log.i(r1, r2)     // Catch:{ all -> 0x0043 }
                r1 = 0
                r5.f33653e = r1     // Catch:{ all -> 0x0043 }
                jp.co.cyberagent.android.gpuimage.a$j r1 = jp.co.cyberagent.android.gpuimage.a.f33622a     // Catch:{ all -> 0x0043 }
                r1.notifyAll()     // Catch:{ all -> 0x0043 }
            L_0x0029:
                boolean r1 = r5.f33655g     // Catch:{ all -> 0x0043 }
                if (r1 != 0) goto L_0x0041
                boolean r1 = r5.f33650b     // Catch:{ all -> 0x0043 }
                if (r1 != 0) goto L_0x0041
                jp.co.cyberagent.android.gpuimage.a$j r1 = jp.co.cyberagent.android.gpuimage.a.f33622a     // Catch:{ InterruptedException -> 0x0039 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0039 }
                goto L_0x0029
            L_0x0039:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0043 }
                r1.interrupt()     // Catch:{ all -> 0x0043 }
                goto L_0x0029
            L_0x0041:
                monitor-exit(r0)     // Catch:{ all -> 0x0043 }
                return
            L_0x0043:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0043 }
                goto L_0x0047
            L_0x0046:
                throw r1
            L_0x0047:
                goto L_0x0046
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.cyberagent.android.gpuimage.a.i.e():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(8:12|13|14|15|16|28|22|4) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0018, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x004c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(int r4, int r5) {
            /*
                r3 = this;
                jp.co.cyberagent.android.gpuimage.a$j r0 = jp.co.cyberagent.android.gpuimage.a.f33622a
                monitor-enter(r0)
                r3.k = r4     // Catch:{ all -> 0x0056 }
                r3.l = r5     // Catch:{ all -> 0x0056 }
                r4 = 1
                r3.q = r4     // Catch:{ all -> 0x0056 }
                r3.n = r4     // Catch:{ all -> 0x0056 }
                r4 = 0
                r3.o = r4     // Catch:{ all -> 0x0056 }
                jp.co.cyberagent.android.gpuimage.a$j r4 = jp.co.cyberagent.android.gpuimage.a.f33622a     // Catch:{ all -> 0x0056 }
                r4.notifyAll()     // Catch:{ all -> 0x0056 }
            L_0x0018:
                boolean r4 = r3.f33650b     // Catch:{ all -> 0x0056 }
                if (r4 != 0) goto L_0x0054
                boolean r4 = r3.f33652d     // Catch:{ all -> 0x0056 }
                if (r4 != 0) goto L_0x0054
                boolean r4 = r3.o     // Catch:{ all -> 0x0056 }
                if (r4 != 0) goto L_0x0054
                boolean r4 = r3.a()     // Catch:{ all -> 0x0056 }
                if (r4 == 0) goto L_0x0054
                java.lang.String r4 = "Main thread"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0056 }
                r5.<init>()     // Catch:{ all -> 0x0056 }
                java.lang.String r1 = "onWindowResize waiting for render complete from tid="
                r5.append(r1)     // Catch:{ all -> 0x0056 }
                long r1 = r3.getId()     // Catch:{ all -> 0x0056 }
                r5.append(r1)     // Catch:{ all -> 0x0056 }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0056 }
                android.util.Log.i(r4, r5)     // Catch:{ all -> 0x0056 }
                jp.co.cyberagent.android.gpuimage.a$j r4 = jp.co.cyberagent.android.gpuimage.a.f33622a     // Catch:{ InterruptedException -> 0x004c }
                r4.wait()     // Catch:{ InterruptedException -> 0x004c }
                goto L_0x0018
            L_0x004c:
                java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0056 }
                r4.interrupt()     // Catch:{ all -> 0x0056 }
                goto L_0x0018
            L_0x0054:
                monitor-exit(r0)     // Catch:{ all -> 0x0056 }
                return
            L_0x0056:
                r4 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0056 }
                goto L_0x005a
            L_0x0059:
                throw r4
            L_0x005a:
                goto L_0x0059
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.cyberagent.android.gpuimage.a.i.a(int, int):void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:7|8|9|10|19|16|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x000f, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void f() {
            /*
                r2 = this;
                jp.co.cyberagent.android.gpuimage.a$j r0 = jp.co.cyberagent.android.gpuimage.a.f33622a
                monitor-enter(r0)
                r1 = 1
                r2.f33649a = r1     // Catch:{ all -> 0x0025 }
                jp.co.cyberagent.android.gpuimage.a$j r1 = jp.co.cyberagent.android.gpuimage.a.f33622a     // Catch:{ all -> 0x0025 }
                r1.notifyAll()     // Catch:{ all -> 0x0025 }
            L_0x000f:
                boolean r1 = r2.f33650b     // Catch:{ all -> 0x0025 }
                if (r1 != 0) goto L_0x0023
                jp.co.cyberagent.android.gpuimage.a$j r1 = jp.co.cyberagent.android.gpuimage.a.f33622a     // Catch:{ InterruptedException -> 0x001b }
                r1.wait()     // Catch:{ InterruptedException -> 0x001b }
                goto L_0x000f
            L_0x001b:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0025 }
                r1.interrupt()     // Catch:{ all -> 0x0025 }
                goto L_0x000f
            L_0x0023:
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                return
            L_0x0025:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                goto L_0x0029
            L_0x0028:
                throw r1
            L_0x0029:
                goto L_0x0028
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.cyberagent.android.gpuimage.a.i.f():void");
        }

        public void g() {
            this.j = true;
            a.f33622a.notifyAll();
        }
    }

    static class l extends Writer {

        /* renamed from: a  reason: collision with root package name */
        private StringBuilder f33663a = new StringBuilder();

        l() {
        }

        public void close() {
            a();
        }

        public void flush() {
            a();
        }

        public void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c2 = cArr[i + i3];
                if (c2 == 10) {
                    a();
                } else {
                    this.f33663a.append(c2);
                }
            }
        }

        private void a() {
            if (this.f33663a.length() > 0) {
                Log.v("GLTextureView", this.f33663a.toString());
                StringBuilder sb = this.f33663a;
                sb.delete(0, sb.length());
            }
        }
    }

    private void d() {
        if (this.f33624c != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    private static class j {

        /* renamed from: a  reason: collision with root package name */
        private static String f33656a = "GLThreadManager";

        /* renamed from: b  reason: collision with root package name */
        private boolean f33657b;

        /* renamed from: c  reason: collision with root package name */
        private int f33658c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f33659d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f33660e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f33661f;

        /* renamed from: g  reason: collision with root package name */
        private i f33662g;

        private j() {
        }

        public synchronized void a(i iVar) {
            Log.i("GLThread", "exiting tid=" + iVar.getId());
            boolean unused = iVar.f33650b = true;
            if (this.f33662g == iVar) {
                this.f33662g = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            i iVar2 = this.f33662g;
            if (iVar2 == iVar || iVar2 == null) {
                this.f33662g = iVar;
                notifyAll();
                return true;
            }
            c();
            if (this.f33660e) {
                return true;
            }
            i iVar3 = this.f33662g;
            if (iVar3 == null) {
                return false;
            }
            iVar3.g();
            return false;
        }

        public void c(i iVar) {
            if (this.f33662g == iVar) {
                this.f33662g = null;
            }
            notifyAll();
        }

        public synchronized boolean a() {
            return this.f33661f;
        }

        public synchronized boolean b() {
            c();
            return !this.f33660e;
        }

        public synchronized void a(GL10 gl10) {
            if (!this.f33659d) {
                c();
                String glGetString = gl10.glGetString(7937);
                boolean z = false;
                if (this.f33658c < 131072) {
                    this.f33660e = !glGetString.startsWith("Q3Dimension MSM7500 ");
                    notifyAll();
                }
                if (!this.f33660e) {
                    z = true;
                }
                this.f33661f = z;
                String str = f33656a;
                Log.w(str, "checkGLDriver renderer = \"" + glGetString + "\" multipleContextsAllowed = " + this.f33660e + " mLimitedGLESContexts = " + this.f33661f);
                this.f33659d = true;
            }
        }

        private void c() {
            if (!this.f33657b) {
                this.f33657b = true;
            }
        }
    }
}
