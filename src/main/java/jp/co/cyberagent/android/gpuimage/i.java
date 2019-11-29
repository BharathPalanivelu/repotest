package jp.co.cyberagent.android.gpuimage;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import jp.co.cyberagent.android.gpuimage.a.a;
import jp.co.cyberagent.android.gpuimage.b;

@TargetApi(11)
public class i implements Camera.PreviewCallback, GLSurfaceView.Renderer {

    /* renamed from: a  reason: collision with root package name */
    public static final float[] f33694a = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: b  reason: collision with root package name */
    public final Object f33695b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public e f33696c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f33697d = -1;

    /* renamed from: e  reason: collision with root package name */
    private SurfaceTexture f33698e = null;

    /* renamed from: f  reason: collision with root package name */
    private final FloatBuffer f33699f;

    /* renamed from: g  reason: collision with root package name */
    private final FloatBuffer f33700g;
    /* access modifiers changed from: private */
    public IntBuffer h;
    /* access modifiers changed from: private */
    public int i;
    /* access modifiers changed from: private */
    public int j;
    /* access modifiers changed from: private */
    public int k;
    /* access modifiers changed from: private */
    public int l;
    /* access modifiers changed from: private */
    public int m;
    private final Queue<Runnable> n;
    private final Queue<Runnable> o;
    private p p;
    private boolean q;
    private boolean r;
    private b.C0528b s = b.C0528b.CENTER_CROP;

    private float a(float f2, float f3) {
        return f2 == BitmapDescriptorFactory.HUE_RED ? f3 : 1.0f - f3;
    }

    public i(e eVar) {
        this.f33696c = eVar;
        this.n = new LinkedList();
        this.o = new LinkedList();
        this.f33699f = ByteBuffer.allocateDirect(f33694a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f33699f.put(f33694a).position(0);
        this.f33700g = ByteBuffer.allocateDirect(a.f33629a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        a(p.NORMAL, false, false);
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        GLES20.glClearColor(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f);
        GLES20.glDisable(2929);
        this.f33696c.e();
    }

    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        this.i = i2;
        this.j = i3;
        GLES20.glViewport(0, 0, i2, i3);
        GLES20.glUseProgram(this.f33696c.j());
        this.f33696c.a(i2, i3);
        e();
        synchronized (this.f33695b) {
            this.f33695b.notifyAll();
        }
    }

    public void onDrawFrame(GL10 gl10) {
        GLES20.glClear(16640);
        a(this.n);
        this.f33696c.a(this.f33697d, this.f33699f, this.f33700g);
        a(this.o);
        SurfaceTexture surfaceTexture = this.f33698e;
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
        }
    }

    private void a(Queue<Runnable> queue) {
        synchronized (queue) {
            while (!queue.isEmpty()) {
                queue.poll().run();
            }
        }
    }

    public void onPreviewFrame(final byte[] bArr, final Camera camera) {
        final Camera.Size previewSize = camera.getParameters().getPreviewSize();
        if (this.h == null) {
            this.h = IntBuffer.allocate(previewSize.width * previewSize.height);
        }
        if (this.n.isEmpty()) {
            a((Runnable) new Runnable() {
                public void run() {
                    GPUImageNativeLibrary.YUVtoRBGA(bArr, previewSize.width, previewSize.height, i.this.h.array());
                    i iVar = i.this;
                    int unused = iVar.f33697d = n.a(iVar.h, previewSize, i.this.f33697d);
                    camera.addCallbackBuffer(bArr);
                    if (i.this.k != previewSize.width) {
                        int unused2 = i.this.k = previewSize.width;
                        int unused3 = i.this.l = previewSize.height;
                        i.this.e();
                    }
                }
            });
        }
    }

    public void a(final e eVar) {
        a((Runnable) new Runnable() {
            public void run() {
                e e2 = i.this.f33696c;
                e unused = i.this.f33696c = eVar;
                if (e2 != null) {
                    e2.f();
                }
                i.this.f33696c.e();
                GLES20.glUseProgram(i.this.f33696c.j());
                i.this.f33696c.a(i.this.i, i.this.j);
            }
        });
    }

    public void a() {
        a((Runnable) new Runnable() {
            public void run() {
                GLES20.glDeleteTextures(1, new int[]{i.this.f33697d}, 0);
                int unused = i.this.f33697d = -1;
            }
        });
    }

    public void a(final Bitmap bitmap, final boolean z) {
        if (bitmap != null) {
            a((Runnable) new Runnable() {
                public void run() {
                    Bitmap bitmap;
                    if (bitmap.getWidth() % 2 == 1) {
                        bitmap = Bitmap.createBitmap(bitmap.getWidth() + 1, bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(bitmap);
                        canvas.drawARGB(0, 0, 0, 0);
                        canvas.drawBitmap(bitmap, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (Paint) null);
                        int unused = i.this.m = 1;
                    } else {
                        int unused2 = i.this.m = 0;
                        bitmap = null;
                    }
                    int unused3 = i.this.f33697d = n.a(bitmap != null ? bitmap : bitmap, i.this.f33697d, z);
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                    int unused4 = i.this.k = bitmap.getWidth();
                    int unused5 = i.this.l = bitmap.getHeight();
                    i.this.e();
                }
            });
        }
    }

    public void a(b.C0528b bVar) {
        this.s = bVar;
    }

    /* access modifiers changed from: private */
    public void e() {
        float[] fArr;
        float f2 = (float) this.i;
        float f3 = (float) this.j;
        if (this.p == p.ROTATION_270 || this.p == p.ROTATION_90) {
            f2 = (float) this.j;
            f3 = (float) this.i;
        }
        float max = Math.max(f2 / ((float) this.k), f3 / ((float) this.l));
        float round = ((float) Math.round(((float) this.k) * max)) / f2;
        float round2 = ((float) Math.round(((float) this.l) * max)) / f3;
        float[] fArr2 = f33694a;
        float[] a2 = a.a(this.p, this.q, this.r);
        if (this.s == b.C0528b.CENTER_CROP) {
            float f4 = (1.0f - (1.0f / round)) / 2.0f;
            float f5 = (1.0f - (1.0f / round2)) / 2.0f;
            fArr = new float[]{a(a2[0], f4), a(a2[1], f5), a(a2[2], f4), a(a2[3], f5), a(a2[4], f4), a(a2[5], f5), a(a2[6], f4), a(a2[7], f5)};
        } else {
            float[] fArr3 = f33694a;
            fArr2 = new float[]{fArr3[0] / round2, fArr3[1] / round, fArr3[2] / round2, fArr3[3] / round, fArr3[4] / round2, fArr3[5] / round, fArr3[6] / round2, fArr3[7] / round};
            fArr = a2;
        }
        this.f33699f.clear();
        this.f33699f.put(fArr2).position(0);
        this.f33700g.clear();
        this.f33700g.put(fArr).position(0);
    }

    public void a(p pVar) {
        this.p = pVar;
        e();
    }

    public void a(p pVar, boolean z, boolean z2) {
        this.q = z;
        this.r = z2;
        a(pVar);
    }

    public p b() {
        return this.p;
    }

    public boolean c() {
        return this.q;
    }

    public boolean d() {
        return this.r;
    }

    /* access modifiers changed from: protected */
    public void a(Runnable runnable) {
        synchronized (this.n) {
            this.n.add(runnable);
        }
    }
}
