package com.garena.imageeditor.a.a;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;
import jp.co.cyberagent.android.gpuimage.a.a;
import jp.co.cyberagent.android.gpuimage.e;
import jp.co.cyberagent.android.gpuimage.f;
import jp.co.cyberagent.android.gpuimage.g;
import jp.co.cyberagent.android.gpuimage.i;
import jp.co.cyberagent.android.gpuimage.p;

public class c extends e {
    private static String p = "varying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\n\nuniform lowp float excludeCircleRadius;\nuniform lowp vec2 excludeCirclePoint;\nuniform lowp float excludeBlurSize;\nuniform highp float aspectRatio;\n\nvoid main()\n{\n\tlowp vec4 sharpImageColor = texture2D(inputImageTexture2, textureCoordinate2);\n\tlowp vec4 blurredImageColor = texture2D(inputImageTexture, textureCoordinate);\n\n\thighp vec2 textureCoordinateToUse = vec2(textureCoordinate.x, (textureCoordinate.y * aspectRatio + 0.5 - 0.5 * aspectRatio));\n\thighp float distanceFromCenter = distance(excludeCirclePoint, textureCoordinateToUse);\n\n\tgl_FragColor = mix(sharpImageColor, blurredImageColor, smoothstep(excludeCircleRadius - excludeBlurSize, excludeCircleRadius, distanceFromCenter));\n}\n";

    /* renamed from: a  reason: collision with root package name */
    g f8053a;

    /* renamed from: b  reason: collision with root package name */
    d f8054b;

    /* renamed from: c  reason: collision with root package name */
    protected List<e> f8055c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    protected List<e> f8056d;

    /* renamed from: e  reason: collision with root package name */
    protected int[] f8057e;

    /* renamed from: f  reason: collision with root package name */
    protected int[] f8058f;

    /* renamed from: g  reason: collision with root package name */
    protected final FloatBuffer f8059g;
    protected final FloatBuffer h;
    protected final FloatBuffer i;
    private boolean q = false;
    private float r;
    private PointF s;
    private float t;
    private float u;
    private float v;
    private int w;

    public c() {
        this.f8055c.add(new e());
        this.f8055c.add(new e());
        this.f8053a = new g();
        this.f8055c.add(this.f8053a);
        this.f8054b = new d(p);
        this.f8055c.add(this.f8054b);
        this.u = 5.0f;
        this.r = 0.1875f;
        this.s = new PointF(0.5f, 0.5f);
        this.t = 0.09375f;
        this.v = 1.0f;
        this.w = -1;
        if (this.f8055c == null) {
            this.f8055c = new ArrayList();
        } else {
            d();
        }
        this.f8059g = ByteBuffer.allocateDirect(i.f33694a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f8059g.put(i.f33694a).position(0);
        this.h = ByteBuffer.allocateDirect(a.f33629a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.h.put(a.f33629a).position(0);
        float[] a2 = a.a(p.NORMAL, false, true);
        this.i = ByteBuffer.allocateDirect(a2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.i.put(a2).position(0);
    }

    public void a() {
        super.a();
        for (e e2 : this.f8055c) {
            e2.e();
        }
        a(this.u);
        this.f8054b.a(this.s);
        this.f8054b.a(this.r);
        this.f8054b.b(this.t);
        this.f8054b.c(this.v);
        this.f8054b.a(this.w);
    }

    public void b() {
        super.b();
        for (e e2 : this.f8055c) {
            e2.e();
        }
    }

    public void c() {
        k();
        for (e f2 : this.f8055c) {
            f2.f();
        }
        super.c();
    }

    private void k() {
        int[] iArr = this.f8058f;
        if (iArr != null) {
            GLES20.glDeleteTextures(iArr.length, iArr, 0);
            this.f8058f = null;
        }
        int[] iArr2 = this.f8057e;
        if (iArr2 != null) {
            GLES20.glDeleteFramebuffers(iArr2.length, iArr2, 0);
            this.f8057e = null;
        }
    }

    public void a(int i2, int i3) {
        super.a(i2, i3);
        if (this.f8057e != null) {
            k();
        }
        int size = this.f8055c.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.f8055c.get(i4).a(i2, i3);
        }
        int i5 = i2;
        int i6 = i3;
        List<e> list = this.f8056d;
        if (list != null && list.size() > 0) {
            int size2 = this.f8056d.size();
            this.f8057e = new int[size2];
            this.f8058f = new int[size2];
            for (int i7 = 0; i7 < size2; i7++) {
                GLES20.glGenFramebuffers(1, this.f8057e, i7);
                GLES20.glGenTextures(1, this.f8058f, i7);
                GLES20.glBindTexture(3553, this.f8058f[i7]);
                GLES20.glTexImage2D(3553, 0, 6408, i2, i3, 0, 6408, 5121, (Buffer) null);
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
                GLES20.glBindFramebuffer(36160, this.f8057e[i7]);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f8058f[i7], 0);
                GLES20.glBindTexture(3553, 0);
                GLES20.glBindFramebuffer(36160, 0);
            }
        }
    }

    @SuppressLint({"WrongCall"})
    public void a(int i2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        h();
        if (i() && this.f8057e != null && this.f8058f != null) {
            List<e> list = this.f8056d;
            if (list != null) {
                int size = list.size();
                int i3 = i2;
                int i4 = 0;
                while (i4 < size) {
                    e eVar = this.f8056d.get(i4);
                    int i5 = size - 1;
                    boolean z = i4 < i5;
                    if (z) {
                        GLES20.glBindFramebuffer(36160, this.f8057e[i4]);
                        GLES20.glClearColor(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
                    }
                    if (i4 == 0) {
                        eVar.a(i3, floatBuffer, floatBuffer2);
                    } else if (i4 == i5) {
                        eVar.a(i3, this.f8059g, size % 2 == 0 ? this.i : this.h);
                    } else {
                        eVar.a(i3, this.f8059g, this.h);
                    }
                    if (z) {
                        GLES20.glBindFramebuffer(36160, 0);
                        i3 = this.f8058f[i4];
                    }
                    if (i4 == 1) {
                        a(i3);
                    }
                    i4++;
                }
            }
        }
    }

    public void d() {
        if (this.f8055c != null) {
            List<e> list = this.f8056d;
            if (list == null) {
                this.f8056d = new ArrayList();
            } else {
                list.clear();
            }
            for (e next : this.f8055c) {
                if (next instanceof f) {
                    f fVar = (f) next;
                    fVar.k();
                    List<e> d2 = fVar.d();
                    if (d2 != null && !d2.isEmpty()) {
                        this.f8056d.addAll(d2);
                    }
                } else {
                    this.f8056d.add(next);
                }
            }
        }
    }

    public void a(int i2) {
        this.w = i2;
        this.f8054b.a(i2);
    }

    public void a(float f2) {
        this.u = f2;
        this.f8053a.a(this.u);
    }

    public void a(PointF pointF) {
        this.s = pointF;
        this.f8054b.a(this.s);
    }

    public void b(float f2) {
        this.r = f2;
        this.f8054b.a(this.r);
    }

    public void c(float f2) {
        this.t = f2;
        this.f8054b.b(this.t);
    }

    public void d(float f2) {
        this.q = true;
        this.v = f2;
        this.f8054b.c(this.v);
    }
}
