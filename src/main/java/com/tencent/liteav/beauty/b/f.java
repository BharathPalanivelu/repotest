package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.beauty.NativeLoad;
import java.nio.Buffer;

public class f extends g {
    private int[] A;
    private float B = 4.0f;
    int r;
    int s;
    boolean t;
    private d u;
    private g v;
    private c w;
    private a x;
    private b y;
    private int[] z;

    private static class c extends t {
        int r;
        int s;
        float t = 1.5f;

        public c() {
            super((String) null, (String) null);
        }

        public boolean a() {
            NativeLoad.getInstance();
            this.f31313a = NativeLoad.nativeLoadGLProgram(2);
            if (this.f31313a == 0 || !b()) {
                this.f31319g = false;
            } else {
                this.f31319g = true;
            }
            c();
            return this.f31319g;
        }

        public boolean b() {
            if (!super.b()) {
                return false;
            }
            this.r = GLES20.glGetUniformLocation(this.f31313a, "texelWidthOffset");
            this.s = GLES20.glGetUniformLocation(this.f31313a, "texelHeightOffset");
            return true;
        }

        /* access modifiers changed from: package-private */
        public void a(float f2) {
            this.t = f2;
            a(this.r, this.t / ((float) this.f31317e));
            a(this.s, this.t / ((float) this.f31318f));
        }

        public void a(int i, int i2) {
            super.a(i, i2);
            a(this.t);
        }
    }

    private static class a extends t {
        public a(String str) {
            super(str);
        }

        public boolean b() {
            return super.b();
        }
    }

    private static class b extends s {
        public b(String str) {
            super(str);
        }

        public boolean b() {
            return super.b();
        }
    }

    public boolean b() {
        boolean b2 = super.b();
        if (b2) {
            this.u = new d();
            if (b2) {
                b2 = this.u.a();
            }
            this.w = new c();
            if (b2) {
                b2 = this.w.a();
            }
            this.x = new a("precision highp float;  \nuniform sampler2D inputImageTexture;  \nuniform sampler2D inputImageTexture2;  \nvarying vec2 textureCoordinate;  \nvarying vec2 textureCoordinate2;  \nvoid main()  \n{  \n\tgl_FragColor = texture2D(inputImageTexture2, textureCoordinate2) - texture2D(inputImageTexture, textureCoordinate) * texture2D(inputImageTexture2, textureCoordinate2);  \n}  \n");
            if (b2) {
                b2 = this.x.a();
            }
            this.y = new b("precision highp float;   \nuniform sampler2D inputImageTexture;   \nuniform sampler2D inputImageTexture2;  \nuniform sampler2D inputImageTexture3;   \nvarying vec2 textureCoordinate;   \nvarying vec2 textureCoordinate2;  \nvarying vec2 textureCoordinate3;    \nvoid main()   \n{   \n\tgl_FragColor = texture2D(inputImageTexture, textureCoordinate) * texture2D(inputImageTexture3, textureCoordinate3) + texture2D(inputImageTexture2, textureCoordinate2);   \n}   \n");
            if (b2) {
                b2 = this.y.a();
            }
            this.v = new g();
            this.v.a(true);
            if (b2) {
                b2 = this.v.a();
            }
            if (b2) {
                return true;
            }
        }
        d();
        return false;
    }

    public void a(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        if (this.f31318f != i4 || this.f31317e != i3) {
            super.a(i, i2);
            if (!this.t) {
                if (i3 < i4) {
                    if (i3 < 540) {
                        this.B = 1.0f;
                    } else {
                        this.B = 4.0f;
                    }
                } else if (i4 < 540) {
                    this.B = 1.0f;
                } else {
                    this.B = 4.0f;
                }
            }
            float f2 = this.B;
            this.r = (int) (((float) i3) / f2);
            this.s = (int) (((float) i4) / f2);
            this.v.a(this.r, this.s);
            this.w.a(this.r, this.s);
            this.x.a(this.r, this.s);
            this.y.a(i3, i4);
            this.u.a(this.r, this.s);
            int[] iArr = this.z;
            if (iArr != null) {
                GLES20.glDeleteFramebuffers(iArr.length, iArr, 0);
                GLES20.glDeleteTextures(this.z.length, this.A, 0);
                this.z = null;
                this.A = null;
            }
            this.z = new int[8];
            int[] iArr2 = this.z;
            this.A = new int[iArr2.length];
            GLES20.glGenFramebuffers(iArr2.length, iArr2, 0);
            GLES20.glGenTextures(this.z.length, this.A, 0);
            for (int i5 = 0; i5 < this.z.length; i5++) {
                GLES20.glBindTexture(3553, this.A[i5]);
                if (i5 >= 5) {
                    GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, (Buffer) null);
                } else {
                    GLES20.glTexImage2D(3553, 0, 6408, this.r, this.s, 0, 6408, 5121, (Buffer) null);
                }
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
                GLES20.glBindFramebuffer(36160, this.z[i5]);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.A[i5], 0);
                GLES20.glBindTexture(3553, 0);
                GLES20.glBindFramebuffer(36160, 0);
            }
        }
    }

    public int b(int i) {
        int i2;
        if (this.B != 1.0f) {
            GLES20.glViewport(0, 0, this.r, this.s);
            i2 = this.v.b(i);
        } else {
            i2 = i;
        }
        int a2 = this.u.a(i2, this.z[4], this.A[4]);
        int a3 = this.w.a(i2, a2, this.z[0], this.A[0]);
        int a4 = this.x.a(a3, a2, this.z[1], this.A[1]);
        int a5 = this.u.a(a3, this.z[2], this.A[2]);
        int a6 = this.u.a(a4, this.z[3], this.A[3]);
        if (this.B != 1.0f) {
            GLES20.glViewport(0, 0, this.f31317e, this.f31318f);
            a5 = this.v.a(a5, this.z[5], this.A[5]);
            a6 = this.v.a(a6, this.z[6], this.A[6]);
        }
        return this.y.a(a5, a6, i, this.z[7], this.A[7]);
    }

    public void e() {
        if (this.f31319g) {
            super.e();
            this.u.d();
            this.w.d();
            this.x.d();
            this.y.d();
            this.v.d();
            int[] iArr = this.z;
            if (iArr != null) {
                GLES20.glDeleteFramebuffers(iArr.length, iArr, 0);
                GLES20.glDeleteTextures(this.z.length, this.A, 0);
                this.z = null;
            }
            this.A = null;
        }
    }
}
