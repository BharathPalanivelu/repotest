package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.liteav.basic.log.TXCLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f31919a = {-1.0f, -1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, -1.0f, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED, -1.0f, 1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, 1.0f, 1.0f, BitmapDescriptorFactory.HUE_RED, 1.0f, 1.0f};

    /* renamed from: b  reason: collision with root package name */
    private final float[] f31920b = {1.0f, -1.0f, BitmapDescriptorFactory.HUE_RED, 1.0f, 1.0f, -1.0f, -1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, 1.0f, 1.0f, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED, -1.0f, 1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};

    /* renamed from: c  reason: collision with root package name */
    private FloatBuffer f31921c;

    /* renamed from: d  reason: collision with root package name */
    private float[] f31922d = new float[16];

    /* renamed from: e  reason: collision with root package name */
    private float[] f31923e = new float[16];

    /* renamed from: f  reason: collision with root package name */
    private int f31924f;

    /* renamed from: g  reason: collision with root package name */
    private int f31925g = -12345;
    private int h;
    private int i;
    private int j;
    private int k;
    private boolean l = false;
    private boolean m = true;
    private boolean n = false;
    private int o = -1;
    private int p = 0;
    private int q = 0;

    public c(boolean z) {
        this.m = z;
        if (this.m) {
            this.f31921c = ByteBuffer.allocateDirect(this.f31919a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.f31921c.put(this.f31919a).position(0);
        } else {
            this.f31921c = ByteBuffer.allocateDirect(this.f31920b.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.f31921c.put(this.f31920b).position(0);
        }
        Matrix.setIdentityM(this.f31923e, 0);
    }

    public int a() {
        return this.f31925g;
    }

    public void a(SurfaceTexture surfaceTexture) {
        if (surfaceTexture != null) {
            a("onDrawFrame start");
            surfaceTexture.getTransformMatrix(this.f31923e);
            b(36197, this.f31925g);
        }
    }

    public void a(int i2, int i3) {
        this.p = i2;
        this.q = i3;
    }

    public void a(int i2, boolean z, int i3) {
        if (!(this.n == z && this.o == i3)) {
            this.n = z;
            this.o = i3;
            float[] fArr = new float[20];
            for (int i4 = 0; i4 < 20; i4++) {
                fArr[i4] = this.f31920b[i4];
            }
            if (this.n) {
                fArr[0] = -fArr[0];
                fArr[5] = -fArr[5];
                fArr[10] = -fArr[10];
                fArr[15] = -fArr[15];
            }
            int i5 = i3 / 90;
            for (int i6 = 0; i6 < i5; i6++) {
                float f2 = fArr[3];
                float f3 = fArr[4];
                fArr[3] = fArr[8];
                fArr[4] = fArr[9];
                fArr[8] = fArr[18];
                fArr[9] = fArr[19];
                fArr[18] = fArr[13];
                fArr[19] = fArr[14];
                fArr[13] = f2;
                fArr[14] = f3;
            }
            this.f31921c.clear();
            this.f31921c.put(fArr).position(0);
        }
        b(3553, i2);
    }

    private void b(int i2, int i3) {
        GLES20.glClearColor(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f);
        GLES20.glClear(16640);
        if (this.l) {
            this.l = false;
            return;
        }
        GLES20.glUseProgram(this.f31924f);
        a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(i2, i3);
        this.f31921c.position(0);
        GLES20.glVertexAttribPointer(this.j, 3, 5126, false, 20, this.f31921c);
        a("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.j);
        a("glEnableVertexAttribArray maPositionHandle");
        this.f31921c.position(3);
        GLES20.glVertexAttribPointer(this.k, 2, 5126, false, 20, this.f31921c);
        a("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.k);
        a("glEnableVertexAttribArray maTextureHandle");
        Matrix.setIdentityM(this.f31922d, 0);
        GLES20.glUniformMatrix4fv(this.h, 1, false, this.f31922d, 0);
        int i4 = this.p;
        if (i4 % 8 != 0) {
            Matrix.scaleM(this.f31923e, 0, (((float) (i4 - 1)) * 1.0f) / ((float) (((i4 + 7) / 8) * 8)), 1.0f, 1.0f);
        }
        int i5 = this.q;
        if (i5 % 8 != 0) {
            Matrix.scaleM(this.f31923e, 0, 1.0f, (((float) (i5 - 1)) * 1.0f) / ((float) (((i5 + 7) / 8) * 8)), 1.0f);
        }
        GLES20.glUniformMatrix4fv(this.i, 1, false, this.f31923e, 0);
        GLES20.glDrawArrays(5, 0, 4);
        a("glDrawArrays");
        GLES20.glFinish();
    }

    public void b() {
        if (this.m) {
            this.f31924f = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        } else {
            this.f31924f = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "varying highp vec2 vTextureCoord;\n \nuniform sampler2D sTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(sTexture, vTextureCoord);\n}");
        }
        int i2 = this.f31924f;
        if (i2 != 0) {
            this.j = GLES20.glGetAttribLocation(i2, "aPosition");
            a("glGetAttribLocation aPosition");
            if (this.j != -1) {
                this.k = GLES20.glGetAttribLocation(this.f31924f, "aTextureCoord");
                a("glGetAttribLocation aTextureCoord");
                if (this.k != -1) {
                    this.h = GLES20.glGetUniformLocation(this.f31924f, "uMVPMatrix");
                    a("glGetUniformLocation uMVPMatrix");
                    if (this.h != -1) {
                        this.i = GLES20.glGetUniformLocation(this.f31924f, "uSTMatrix");
                        a("glGetUniformLocation uSTMatrix");
                        if (this.i != -1) {
                            if (this.m) {
                                d();
                            }
                            GLES20.glTexParameterf(36197, 10241, 9729.0f);
                            GLES20.glTexParameterf(36197, 10240, 9729.0f);
                            GLES20.glTexParameteri(36197, 10242, 33071);
                            GLES20.glTexParameteri(36197, 10243, 33071);
                            a("glTexParameter");
                            return;
                        }
                        throw new RuntimeException("Could not get attrib location for uSTMatrix");
                    }
                    throw new RuntimeException("Could not get attrib location for uMVPMatrix");
                }
                throw new RuntimeException("Could not get attrib location for aTextureCoord");
            }
            throw new RuntimeException("Could not get attrib location for aPosition");
        }
        throw new RuntimeException("failed creating program");
    }

    public void c() {
        int i2 = this.f31924f;
        if (i2 != 0) {
            GLES20.glDeleteProgram(i2);
        }
        GLES20.glDeleteTextures(1, new int[]{this.f31925g}, 0);
        this.f31925g = -1;
    }

    private void d() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.f31925g = iArr[0];
        GLES20.glBindTexture(36197, this.f31925g);
        a("glBindTexture mTextureID");
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
        TXCLog.e("TXCOesTextureRender", "Could not compile shader " + i2 + ":");
        StringBuilder sb = new StringBuilder();
        sb.append(SQLBuilder.BLANK);
        sb.append(GLES20.glGetShaderInfoLog(glCreateShader));
        TXCLog.e("TXCOesTextureRender", sb.toString());
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
            TXCLog.e("TXCOesTextureRender", "Could not create program");
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
        TXCLog.e("TXCOesTextureRender", "Could not link program: ");
        TXCLog.e("TXCOesTextureRender", GLES20.glGetProgramInfoLog(glCreateProgram));
        GLES20.glDeleteProgram(glCreateProgram);
        return 0;
    }

    public void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            TXCLog.e("TXCOesTextureRender", str + ": glError " + glGetError);
        }
    }
}
