package com.tencent.liteav.renderer;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.liteav.basic.log.TXCLog;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public static int f31955a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f31956b = 2;

    /* renamed from: c  reason: collision with root package name */
    private int f31957c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f31958d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f31959e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f31960f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f31961g = f31956b;
    private int h = 0;
    private boolean i = false;
    private float[] j = new float[16];
    private float[] k = new float[16];
    private float l = 1.0f;
    private float m = 1.0f;
    private boolean n = false;
    private boolean o = true;
    private final float[] p = {-1.0f, -1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, -1.0f, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED, -1.0f, 1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, 1.0f, 1.0f, BitmapDescriptorFactory.HUE_RED, 1.0f, 1.0f};
    private FloatBuffer q;
    private float[] r = new float[16];
    private float[] s = new float[16];
    private int t;
    private int u = -12345;
    private int v = -12345;
    private int w;
    private int x;
    private int y;
    private int z;

    public void a(int i2, int i3) {
        int i4 = i2;
        int i5 = i3;
        if (i4 != this.f31957c || i5 != this.f31958d) {
            TXCLog.d("TXTweenFilter", "Output resolution change: " + this.f31957c + "*" + this.f31958d + " -> " + i4 + "*" + i5);
            this.f31957c = i4;
            this.f31958d = i5;
            if (i4 > i5) {
                Matrix.orthoM(this.j, 0, -1.0f, 1.0f, -1.0f, 1.0f, -1.0f, 1.0f);
                this.l = 1.0f;
                this.m = 1.0f;
            } else {
                Matrix.orthoM(this.j, 0, -1.0f, 1.0f, -1.0f, 1.0f, -1.0f, 1.0f);
                this.l = 1.0f;
                this.m = 1.0f;
            }
            this.n = true;
        }
    }

    public void b(int i2, int i3) {
        if (i2 != this.f31959e || i3 != this.f31960f) {
            TXCLog.d("TXTweenFilter", "Input resolution change: " + this.f31959e + "*" + this.f31960f + " -> " + i2 + "*" + i3);
            this.f31959e = i2;
            this.f31960f = i3;
        }
    }

    public boolean a() {
        return this.o;
    }

    public void a(int i2) {
        this.f31961g = i2;
    }

    public void b(int i2) {
        this.h = i2;
    }

    private void b(float[] fArr) {
        if (this.f31958d != 0 && this.f31957c != 0) {
            int i2 = this.f31959e;
            int i3 = this.f31960f;
            int i4 = this.h;
            if (i4 == 270 || i4 == 90) {
                i2 = this.f31960f;
                i3 = this.f31959e;
            }
            float f2 = (float) i2;
            float f3 = (((float) this.f31957c) * 1.0f) / f2;
            int i5 = this.f31958d;
            float f4 = (float) i3;
            float f5 = (((float) i5) * 1.0f) / f4;
            if (this.f31961g != f31955a ? f3 * f4 > ((float) i5) : f3 * f4 <= ((float) i5)) {
                f3 = f5;
            }
            Matrix.setIdentityM(this.k, 0);
            if (this.i) {
                if (this.h % 180 == 0) {
                    Matrix.scaleM(this.k, 0, -1.0f, 1.0f, 1.0f);
                } else {
                    Matrix.scaleM(this.k, 0, 1.0f, -1.0f, 1.0f);
                }
            }
            Matrix.scaleM(this.k, 0, ((f2 * f3) / ((float) this.f31957c)) * 1.0f, ((f4 * f3) / ((float) this.f31958d)) * 1.0f, 1.0f);
            Matrix.rotateM(this.k, 0, (float) this.h, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, -1.0f);
            Matrix.multiplyMM(fArr, 0, this.j, 0, this.k, 0);
        }
    }

    public h(Boolean bool) {
        this.o = bool.booleanValue();
        this.q = ByteBuffer.allocateDirect(this.p.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.q.put(this.p).position(0);
        Matrix.setIdentityM(this.s, 0);
    }

    public void a(float[] fArr) {
        this.s = fArr;
    }

    public void c(int i2) {
        GLES20.glViewport(0, 0, this.f31957c, this.f31958d);
        GLES20.glClearColor(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f);
        GLES20.glClear(16640);
        GLES20.glUseProgram(this.t);
        a("glUseProgram");
        if (this.o) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, i2);
        } else {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i2);
        }
        this.q.position(0);
        GLES20.glVertexAttribPointer(this.y, 3, 5126, false, 20, this.q);
        a("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.y);
        a("glEnableVertexAttribArray maPositionHandle");
        this.q.position(3);
        GLES20.glVertexAttribPointer(this.z, 2, 5126, false, 20, this.q);
        a("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.z);
        a("glEnableVertexAttribArray maTextureHandle");
        Matrix.setIdentityM(this.r, 0);
        b(this.r);
        GLES20.glUniformMatrix4fv(this.w, 1, false, this.r, 0);
        GLES20.glUniformMatrix4fv(this.x, 1, false, this.s, 0);
        a("glDrawArrays");
        GLES20.glDrawArrays(5, 0, 4);
        a("glDrawArrays");
        if (this.o) {
            GLES20.glBindTexture(36197, 0);
        } else {
            GLES20.glBindTexture(3553, 0);
        }
    }

    public int d(int i2) {
        d();
        int i3 = this.v;
        if (i3 == -12345) {
            TXCLog.d("TXTweenFilter", "invalid frame buffer id");
            return i2;
        }
        GLES20.glBindFramebuffer(36160, i3);
        c(i2);
        GLES20.glBindFramebuffer(36160, 0);
        return this.u;
    }

    public void b() {
        if (this.o) {
            this.t = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        } else {
            this.t = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "varying highp vec2 vTextureCoord;\n \nuniform sampler2D sTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(sTexture, vTextureCoord);\n}");
        }
        int i2 = this.t;
        if (i2 != 0) {
            this.y = GLES20.glGetAttribLocation(i2, "aPosition");
            a("glGetAttribLocation aPosition");
            if (this.y != -1) {
                this.z = GLES20.glGetAttribLocation(this.t, "aTextureCoord");
                a("glGetAttribLocation aTextureCoord");
                if (this.z != -1) {
                    this.w = GLES20.glGetUniformLocation(this.t, "uMVPMatrix");
                    a("glGetUniformLocation uMVPMatrix");
                    if (this.w != -1) {
                        this.x = GLES20.glGetUniformLocation(this.t, "uSTMatrix");
                        a("glGetUniformLocation uSTMatrix");
                        if (this.x == -1) {
                            throw new RuntimeException("Could not get attrib location for uSTMatrix");
                        }
                        return;
                    }
                    throw new RuntimeException("Could not get attrib location for uMVPMatrix");
                }
                throw new RuntimeException("Could not get attrib location for aTextureCoord");
            }
            throw new RuntimeException("Could not get attrib location for aPosition");
        }
        throw new RuntimeException("failed creating program");
    }

    private void d() {
        if (this.n) {
            TXCLog.d("TXTweenFilter", "reloadFrameBuffer. size = " + this.f31957c + "*" + this.f31958d);
            e();
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glGenFramebuffers(1, iArr2, 0);
            this.u = iArr[0];
            this.v = iArr2[0];
            TXCLog.d("TXTweenFilter", "frameBuffer id = " + this.v + ", texture id = " + this.u);
            GLES20.glBindTexture(3553, this.u);
            a("glBindTexture mFrameBufferTextureID");
            GLES20.glTexImage2D(3553, 0, 6408, this.f31957c, this.f31958d, 0, 6408, 5121, (Buffer) null);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            a("glTexParameter");
            GLES20.glBindFramebuffer(36160, this.v);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.u, 0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
            this.n = false;
        }
    }

    public void c() {
        GLES20.glDeleteProgram(this.t);
        e();
    }

    private void e() {
        int i2 = this.v;
        if (i2 != -12345) {
            GLES20.glDeleteFramebuffers(1, new int[]{i2}, 0);
            this.v = -12345;
        }
        int i3 = this.u;
        if (i3 != -12345) {
            GLES20.glDeleteTextures(1, new int[]{i3}, 0);
            this.u = -12345;
        }
    }

    private int a(int i2, String str) {
        int glCreateShader = GLES20.glCreateShader(i2);
        a("glCreateShader type=" + i2);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        TXCLog.e("TXTweenFilter", "Could not compile shader " + i2 + ":");
        StringBuilder sb = new StringBuilder();
        sb.append(SQLBuilder.BLANK);
        sb.append(GLES20.glGetShaderInfoLog(glCreateShader));
        TXCLog.e("TXTweenFilter", sb.toString());
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    private int a(String str, String str2) {
        int a2 = a(35633, str);
        if (a2 == 0) {
            return 0;
        }
        int a3 = a(35632, str2);
        if (a3 == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        a("glCreateProgram");
        if (glCreateProgram == 0) {
            TXCLog.e("TXTweenFilter", "Could not create program");
        }
        GLES20.glAttachShader(glCreateProgram, a2);
        a("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, a3);
        a("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return glCreateProgram;
        }
        TXCLog.e("TXTweenFilter", "Could not link program: ");
        TXCLog.e("TXTweenFilter", GLES20.glGetProgramInfoLog(glCreateProgram));
        GLES20.glDeleteProgram(glCreateProgram);
        return 0;
    }

    private void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            TXCLog.e("TXTweenFilter", str + ": glError " + glGetError);
            throw new RuntimeException(str + ": glError " + glGetError);
        }
    }
}
