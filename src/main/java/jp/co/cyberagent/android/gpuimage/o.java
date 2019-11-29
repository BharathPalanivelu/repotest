package jp.co.cyberagent.android.gpuimage;

import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import android.util.Log;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

public class o {

    /* renamed from: a  reason: collision with root package name */
    GLSurfaceView.Renderer f33720a;

    /* renamed from: b  reason: collision with root package name */
    int f33721b;

    /* renamed from: c  reason: collision with root package name */
    int f33722c;

    /* renamed from: d  reason: collision with root package name */
    Bitmap f33723d;

    /* renamed from: e  reason: collision with root package name */
    EGL10 f33724e = ((EGL10) EGLContext.getEGL());

    /* renamed from: f  reason: collision with root package name */
    EGLDisplay f33725f = this.f33724e.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);

    /* renamed from: g  reason: collision with root package name */
    EGLConfig[] f33726g;
    EGLConfig h;
    EGLContext i;
    EGLSurface j;
    GL10 k;
    String l;

    public o(int i2, int i3) {
        this.f33721b = i2;
        this.f33722c = i3;
        int[] iArr = {12375, this.f33721b, 12374, this.f33722c, 12344};
        this.f33724e.eglInitialize(this.f33725f, new int[2]);
        this.h = c();
        this.i = this.f33724e.eglCreateContext(this.f33725f, this.h, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
        this.j = this.f33724e.eglCreatePbufferSurface(this.f33725f, this.h, iArr);
        EGL10 egl10 = this.f33724e;
        EGLDisplay eGLDisplay = this.f33725f;
        EGLSurface eGLSurface = this.j;
        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.i);
        this.k = (GL10) this.i.getGL();
        this.l = Thread.currentThread().getName();
    }

    public void a(GLSurfaceView.Renderer renderer) {
        this.f33720a = renderer;
        if (!Thread.currentThread().getName().equals(this.l)) {
            Log.e("PixelBuffer", "setRenderer: This thread does not own the OpenGL context.");
            return;
        }
        this.f33720a.onSurfaceCreated(this.k, this.h);
        this.f33720a.onSurfaceChanged(this.k, this.f33721b, this.f33722c);
    }

    public Bitmap a() {
        if (this.f33720a == null) {
            Log.e("PixelBuffer", "getBitmap: Renderer was not set.");
            return null;
        } else if (!Thread.currentThread().getName().equals(this.l)) {
            Log.e("PixelBuffer", "getBitmap: This thread does not own the OpenGL context.");
            return null;
        } else {
            this.f33720a.onDrawFrame(this.k);
            this.f33720a.onDrawFrame(this.k);
            d();
            return this.f33723d;
        }
    }

    public void b() {
        this.f33720a.onDrawFrame(this.k);
        this.f33720a.onDrawFrame(this.k);
        this.f33724e.eglMakeCurrent(this.f33725f, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        this.f33724e.eglDestroySurface(this.f33725f, this.j);
        this.f33724e.eglDestroyContext(this.f33725f, this.i);
        this.f33724e.eglTerminate(this.f33725f);
    }

    private EGLConfig c() {
        int[] iArr = new int[1];
        int[] iArr2 = {12325, 0, 12326, 0, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344};
        int[] iArr3 = iArr;
        this.f33724e.eglChooseConfig(this.f33725f, iArr2, (EGLConfig[]) null, 0, iArr3);
        int i2 = iArr[0];
        this.f33726g = new EGLConfig[i2];
        this.f33724e.eglChooseConfig(this.f33725f, iArr2, this.f33726g, i2, iArr3);
        return this.f33726g[0];
    }

    private void d() {
        IntBuffer allocate = IntBuffer.allocate(this.f33721b * this.f33722c);
        this.k.glReadPixels(0, 0, this.f33721b, this.f33722c, 6408, 5121, allocate);
        int[] array = allocate.array();
        int i2 = 0;
        while (true) {
            int i3 = this.f33721b;
            if (i2 < i3) {
                int i4 = 0;
                for (int i5 = this.f33722c - 1; i4 < i5; i5--) {
                    int i6 = this.f33721b;
                    int i7 = array[(i4 * i6) + i2];
                    array[(i4 * i6) + i2] = array[(i5 * i6) + i2];
                    array[(i6 * i5) + i2] = i7;
                    i4++;
                }
                i2++;
            } else {
                this.f33723d = Bitmap.createBitmap(i3, this.f33722c, Bitmap.Config.ARGB_8888);
                this.f33723d.copyPixelsFromBuffer(IntBuffer.wrap(array));
                return;
            }
        }
    }
}
