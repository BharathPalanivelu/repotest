package com.tencent.liteav.basic.d;

import android.opengl.GLES20;
import com.facebook.react.uimanager.ViewProps;
import com.tencent.liteav.basic.log.TXCLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.LinkedList;

public class g {

    /* renamed from: a  reason: collision with root package name */
    protected int f31313a;

    /* renamed from: b  reason: collision with root package name */
    protected int f31314b;

    /* renamed from: c  reason: collision with root package name */
    protected int f31315c;

    /* renamed from: d  reason: collision with root package name */
    protected int f31316d;

    /* renamed from: e  reason: collision with root package name */
    protected int f31317e;

    /* renamed from: f  reason: collision with root package name */
    protected int f31318f;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f31319g;
    protected FloatBuffer h;
    protected FloatBuffer i;
    protected float[] j;
    protected float[] k;
    protected a l;
    protected int m;
    protected int n;
    protected boolean o;
    protected boolean p;
    protected boolean q;
    private final LinkedList<Runnable> r;
    private final String s;
    private final String t;
    private boolean u;
    private int v;
    private float[] w;
    private String x;

    public interface a {
        void a(int i);
    }

    public void c() {
    }

    /* access modifiers changed from: protected */
    public void i() {
    }

    /* access modifiers changed from: protected */
    public void j() {
    }

    public g() {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}", false);
    }

    public g(String str, String str2) {
        this(str, str2, false);
    }

    public g(String str, String str2, boolean z) {
        this.u = false;
        this.v = -1;
        this.w = null;
        this.m = -1;
        this.n = -1;
        this.o = false;
        this.p = false;
        this.q = false;
        this.x = "TXCGPUFilter";
        this.r = new LinkedList<>();
        this.s = str;
        this.t = str2;
        this.q = z;
        if (true == z) {
            TXCLog.i(this.x, "set Oes fileter");
        }
        this.h = ByteBuffer.allocateDirect(k.f31351e.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.j = k.f31351e;
        this.h.put(this.j).position(0);
        this.i = ByteBuffer.allocateDirect(k.f31347a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.k = k.a(j.NORMAL, false, true);
        this.i.put(this.k).position(0);
    }

    public boolean a() {
        this.f31313a = i.a(this.s, this.t);
        if (this.f31313a == 0 || !b()) {
            this.f31319g = false;
        } else {
            this.f31319g = true;
        }
        c();
        return this.f31319g;
    }

    public void a(boolean z) {
        this.o = z;
    }

    public void b(boolean z) {
        this.p = z;
        String str = this.x;
        TXCLog.i(str, "set Nearest model " + z);
    }

    public void a(a aVar) {
        this.u = aVar != null;
        this.l = aVar;
    }

    public boolean b() {
        this.f31314b = GLES20.glGetAttribLocation(this.f31313a, ViewProps.POSITION);
        this.f31315c = GLES20.glGetUniformLocation(this.f31313a, "inputImageTexture");
        this.v = GLES20.glGetUniformLocation(this.f31313a, "textureTransform");
        this.f31316d = GLES20.glGetAttribLocation(this.f31313a, "inputTextureCoordinate");
        return true;
    }

    public void d() {
        GLES20.glDeleteProgram(this.f31313a);
        e();
        this.f31319g = false;
    }

    public void e() {
        f();
        this.f31318f = -1;
        this.f31317e = -1;
    }

    private static float[] a(FloatBuffer floatBuffer) {
        if (floatBuffer.limit() <= 0) {
            return null;
        }
        float[] fArr = new float[floatBuffer.limit()];
        for (int i2 = 0; i2 < floatBuffer.limit(); i2++) {
            fArr[i2] = floatBuffer.get(i2);
        }
        return fArr;
    }

    public void f() {
        int i2 = this.m;
        if (i2 != -1) {
            GLES20.glDeleteFramebuffers(1, new int[]{i2}, 0);
            this.m = -1;
        }
        int i3 = this.n;
        if (i3 != -1) {
            GLES20.glDeleteTextures(1, new int[]{i3}, 0);
            this.n = -1;
        }
    }

    public void a(int i2, int i3) {
        if (this.f31318f != i3 || this.f31317e != i2) {
            this.f31317e = i2;
            this.f31318f = i3;
            if (this.o) {
                if (this.m != -1) {
                    f();
                }
                int[] iArr = new int[1];
                GLES20.glGenFramebuffers(1, iArr, 0);
                this.m = iArr[0];
                this.n = i.a(i2, i3, 6408, 6408);
                GLES20.glBindFramebuffer(36160, this.m);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.n, 0);
                GLES20.glBindFramebuffer(36160, 0);
            }
        }
    }

    public void a(int i2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        GLES20.glUseProgram(this.f31313a);
        k();
        if (this.f31319g) {
            floatBuffer.position(0);
            GLES20.glVertexAttribPointer(this.f31314b, 2, 5126, false, 0, floatBuffer);
            GLES20.glEnableVertexAttribArray(this.f31314b);
            floatBuffer2.position(0);
            GLES20.glVertexAttribPointer(this.f31316d, 2, 5126, false, 0, floatBuffer2);
            GLES20.glEnableVertexAttribArray(this.f31316d);
            int i3 = this.v;
            if (i3 >= 0) {
                float[] fArr = this.w;
                if (fArr != null) {
                    GLES20.glUniformMatrix4fv(i3, 1, false, fArr, 0);
                }
            }
            if (i2 != -1) {
                GLES20.glActiveTexture(33984);
                if (true == this.q) {
                    GLES20.glBindTexture(36197, i2);
                } else {
                    GLES20.glBindTexture(3553, i2);
                }
                GLES20.glUniform1i(this.f31315c, 0);
            }
            i();
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.f31314b);
            GLES20.glDisableVertexAttribArray(this.f31316d);
            j();
            if (true == this.q) {
                GLES20.glBindTexture(36197, 0);
            } else {
                GLES20.glBindTexture(3553, 0);
            }
        }
    }

    public void a(float[] fArr) {
        this.w = fArr;
    }

    public void g() {
        if (this.k != null) {
            for (int i2 = 0; i2 < 8; i2 += 2) {
                float[] fArr = this.k;
                fArr[i2] = 1.0f - fArr[i2];
            }
            a(this.j, this.k);
        }
    }

    public void h() {
        if (this.k != null) {
            for (int i2 = 1; i2 < 8; i2 += 2) {
                float[] fArr = this.k;
                fArr[i2] = 1.0f - fArr[i2];
            }
            a(this.j, this.k);
        }
    }

    public int b(int i2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (!this.f31319g) {
            return -1;
        }
        a(i2, floatBuffer, floatBuffer2);
        a aVar = this.l;
        if (!(aVar instanceof a)) {
            return 1;
        }
        aVar.a(i2);
        return 1;
    }

    public int a(int i2) {
        return b(i2, this.h, this.i);
    }

    /* access modifiers changed from: protected */
    public void k() {
        while (!this.r.isEmpty()) {
            this.r.removeFirst().run();
        }
    }

    public int a(int i2, int i3, int i4) {
        if (!this.f31319g) {
            return -1;
        }
        GLES20.glBindFramebuffer(36160, i3);
        a(i2, this.h, this.i);
        a aVar = this.l;
        if (aVar instanceof a) {
            aVar.a(i4);
        }
        GLES20.glBindFramebuffer(36160, 0);
        return i4;
    }

    public int b(int i2) {
        return a(i2, this.m, this.n);
    }

    public int l() {
        return this.n;
    }

    public void a(float[] fArr, float[] fArr2) {
        this.j = fArr;
        this.h = ByteBuffer.allocateDirect(k.f31351e.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.h.put(fArr).position(0);
        this.k = fArr2;
        this.i = ByteBuffer.allocateDirect(k.f31347a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.i.put(fArr2).position(0);
    }

    public float[] a(int i2, int i3, FloatBuffer floatBuffer, a aVar, int i4) {
        float[] fArr;
        if (floatBuffer != null) {
            fArr = a(floatBuffer);
        } else if (4 == i4) {
            fArr = k.a(j.NORMAL, false, false);
        } else {
            fArr = k.a(j.NORMAL, false, true);
        }
        if (aVar != null) {
            float f2 = ((float) i2) * 1.0f;
            float f3 = ((float) aVar.f31254a) / f2;
            float f4 = ((float) ((i2 - aVar.f31254a) - aVar.f31256c)) / f2;
            float f5 = ((float) i3) * 1.0f;
            float f6 = ((float) aVar.f31255b) / f5;
            float f7 = ((float) ((i3 - aVar.f31255b) - aVar.f31257d)) / f5;
            for (int i5 = 0; i5 < fArr.length / 2; i5++) {
                int i6 = i5 * 2;
                if (fArr[i6] < 0.5f) {
                    fArr[i6] = fArr[i6] + f3;
                } else {
                    fArr[i6] = fArr[i6] - f4;
                }
                int i7 = i6 + 1;
                if (fArr[i7] < 0.5f) {
                    fArr[i7] = fArr[i7] + f6;
                } else {
                    fArr[i7] = fArr[i7] - f7;
                }
            }
        }
        return fArr;
    }

    public void a(int i2, int i3, int i4, float[] fArr, float f2, boolean z, boolean z2) {
        float[] fArr2;
        int i5;
        if (fArr == null) {
            fArr2 = k.a(j.NORMAL, false, true);
            i5 = i2;
        } else {
            i5 = i2;
            fArr2 = fArr;
        }
        float f3 = (float) i5;
        int i6 = i3;
        float f4 = (float) i6;
        float f5 = f3 / f4;
        if (f5 > f2) {
            i5 = (int) (f4 * f2);
        } else if (f5 < f2) {
            i6 = (int) (f3 / f2);
        }
        float f6 = (1.0f - (((float) i5) / f3)) / 2.0f;
        float f7 = (1.0f - (((float) i6) / f4)) / 2.0f;
        for (int i7 = 0; i7 < fArr2.length / 2; i7++) {
            int i8 = i7 * 2;
            if (fArr2[i8] < 0.5f) {
                fArr2[i8] = fArr2[i8] + f6;
            } else {
                fArr2[i8] = fArr2[i8] - f6;
            }
            int i9 = i8 + 1;
            if (fArr2[i9] < 0.5f) {
                fArr2[i9] = fArr2[i9] + f7;
            } else {
                fArr2[i9] = fArr2[i9] - f7;
            }
        }
        int i10 = i4 / 90;
        for (int i11 = 0; i11 < i10; i11++) {
            float f8 = fArr2[0];
            float f9 = fArr2[1];
            fArr2[0] = fArr2[2];
            fArr2[1] = fArr2[3];
            fArr2[2] = fArr2[6];
            fArr2[3] = fArr2[7];
            fArr2[6] = fArr2[4];
            fArr2[7] = fArr2[5];
            fArr2[4] = f8;
            fArr2[5] = f9;
        }
        if (i10 == 0 || i10 == 2) {
            if (z) {
                fArr2[0] = 1.0f - fArr2[0];
                fArr2[2] = 1.0f - fArr2[2];
                fArr2[4] = 1.0f - fArr2[4];
                fArr2[6] = 1.0f - fArr2[6];
            }
            if (z2) {
                fArr2[1] = 1.0f - fArr2[1];
                fArr2[3] = 1.0f - fArr2[3];
                fArr2[5] = 1.0f - fArr2[5];
                fArr2[7] = 1.0f - fArr2[7];
            }
        } else {
            if (z2) {
                fArr2[0] = 1.0f - fArr2[0];
                fArr2[2] = 1.0f - fArr2[2];
                fArr2[4] = 1.0f - fArr2[4];
                fArr2[6] = 1.0f - fArr2[6];
            }
            if (z) {
                fArr2[1] = 1.0f - fArr2[1];
                fArr2[3] = 1.0f - fArr2[3];
                fArr2[5] = 1.0f - fArr2[5];
                fArr2[7] = 1.0f - fArr2[7];
            }
        }
        a((float[]) k.f31351e.clone(), fArr2);
    }

    public void a(int i2, FloatBuffer floatBuffer) {
        float[] fArr;
        if (floatBuffer == null) {
            fArr = k.a(j.NORMAL, false, true);
        } else {
            fArr = a(floatBuffer);
        }
        int i3 = i2 / 90;
        for (int i4 = 0; i4 < i3; i4++) {
            float f2 = fArr[0];
            float f3 = fArr[1];
            fArr[0] = fArr[2];
            fArr[1] = fArr[3];
            fArr[2] = fArr[6];
            fArr[3] = fArr[7];
            fArr[6] = fArr[4];
            fArr[7] = fArr[5];
            fArr[4] = f2;
            fArr[5] = f3;
        }
        a((float[]) k.f31351e.clone(), fArr);
    }

    public boolean m() {
        return this.f31319g;
    }

    public int n() {
        return this.f31317e;
    }

    public int o() {
        return this.f31318f;
    }

    public int p() {
        return this.f31313a;
    }

    public void b(final int i2, final int i3) {
        a((Runnable) new Runnable() {
            public void run() {
                GLES20.glUniform1i(i2, i3);
            }
        });
    }

    public void a(final int i2, final float f2) {
        a((Runnable) new Runnable() {
            public void run() {
                GLES20.glUniform1f(i2, f2);
            }
        });
    }

    public void a(final int i2, final float[] fArr) {
        a((Runnable) new Runnable() {
            public void run() {
                GLES20.glUniform2fv(i2, 1, FloatBuffer.wrap(fArr));
            }
        });
    }

    public void b(final int i2, final float[] fArr) {
        a((Runnable) new Runnable() {
            public void run() {
                GLES20.glUniform3fv(i2, 1, FloatBuffer.wrap(fArr));
            }
        });
    }

    public void c(final int i2, final float[] fArr) {
        a((Runnable) new Runnable() {
            public void run() {
                GLES20.glUniform4fv(i2, 1, FloatBuffer.wrap(fArr));
            }
        });
    }

    public void a(Runnable runnable) {
        synchronized (this.r) {
            this.r.addLast(runnable);
        }
    }
}
