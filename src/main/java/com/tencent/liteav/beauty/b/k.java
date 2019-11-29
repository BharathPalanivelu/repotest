package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.basic.d.i;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.NativeLoad;
import java.nio.FloatBuffer;

public class k extends g {
    private static String y = "YUV420pToRGBFilter";
    private byte[] r = null;
    private int s = 1;
    private int[] t = null;
    private int[] u = null;
    private int v = 0;
    private int w = 0;
    private int[] x = null;

    public k(int i) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        this.s = i;
        String str = y;
        TXCLog.i(str, "yuv Type " + i);
    }

    public boolean a() {
        int i = this.s;
        int i2 = 7;
        if (i != 1) {
            if (i == 3) {
                i2 = 9;
            } else if (i == 2) {
                return super.a();
            } else {
                String str = y;
                TXCLog.e(str, "don't support yuv format " + this.s);
            }
        }
        NativeLoad.getInstance();
        this.f31313a = NativeLoad.nativeLoadGLProgram(i2);
        if (this.f31313a == 0 || !b()) {
            this.f31319g = false;
        } else {
            this.f31319g = true;
        }
        c();
        return this.f31319g;
    }

    public void a(int i, int i2) {
        if (this.f31318f != i2 || this.f31317e != i) {
            s();
            if (this.t == null) {
                this.t = new int[1];
                int[] iArr = this.t;
                iArr[0] = i.a(i, i2, 6409, 6409, iArr);
            }
            this.v = GLES20.glGetUniformLocation(p(), "yTexture");
            this.w = GLES20.glGetUniformLocation(p(), "uvTexture");
            int i3 = this.s;
            if (1 == i3) {
                GLES20.glActiveTexture(33984);
                GLES20.glActiveTexture(33985);
                this.u = new int[1];
                int[] iArr2 = this.u;
                iArr2[0] = i.a(i, i2 / 2, 6409, 6409, iArr2);
                GLES20.glUniform1i(this.v, 0);
                GLES20.glUniform1i(this.w, 1);
            } else if (3 == i3) {
                GLES20.glActiveTexture(33984);
                GLES20.glActiveTexture(33985);
                this.v = GLES20.glGetUniformLocation(p(), "yTexture");
                this.w = GLES20.glGetUniformLocation(p(), "uvTexture");
                this.u = new int[1];
                int[] iArr3 = this.u;
                iArr3[0] = i.a(i / 2, i2 / 2, 6410, 6410, iArr3);
                GLES20.glUniform1i(this.v, 0);
                GLES20.glUniform1i(this.w, 1);
            } else if (2 == i3 && this.x == null) {
                this.x = new int[1];
                int[] iArr4 = this.x;
                iArr4[0] = i.a(i, i2, 6408, 6408, iArr4);
            }
            super.a(i, i2);
        }
    }

    public void a(byte[] bArr) {
        this.r = bArr;
    }

    /* access modifiers changed from: protected */
    public void i() {
        int[] iArr;
        super.i();
        if (this.f31317e % 4 != 0) {
            iArr = new int[1];
            GLES20.glGetIntegerv(3317, iArr, 0);
            GLES20.glPixelStorei(3317, 1);
        } else {
            iArr = null;
        }
        int i = this.s;
        if (1 == i) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.t[0]);
            GLES20.glUniform1i(this.v, 0);
            NativeLoad.getInstance();
            NativeLoad.nativeglTexImage2D(3553, 0, 6409, this.f31317e, this.f31318f, 0, 6409, 5121, this.r, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, this.u[0]);
            GLES20.glUniform1i(this.w, 1);
            NativeLoad.getInstance();
            NativeLoad.nativeglTexImage2D(3553, 0, 6409, this.f31317e, this.f31318f / 2, 0, 6409, 5121, this.r, this.f31317e * this.f31318f);
        } else if (3 == i) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.t[0]);
            GLES20.glUniform1i(this.v, 0);
            NativeLoad.getInstance();
            NativeLoad.nativeglTexImage2D(3553, 0, 6409, this.f31317e, this.f31318f, 0, 6409, 5121, this.r, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, this.u[0]);
            GLES20.glUniform1i(this.w, 1);
            NativeLoad.getInstance();
            NativeLoad.nativeglTexImage2D(3553, 0, 6410, this.f31317e / 2, this.f31318f / 2, 0, 6410, 5121, this.r, this.f31317e * this.f31318f);
        } else if (2 == i) {
            r();
        }
        if (this.f31317e % 4 == 0) {
            return;
        }
        if (iArr == null || iArr[0] <= 0) {
            GLES20.glPixelStorei(3317, 4);
        } else {
            GLES20.glPixelStorei(3317, iArr[0]);
        }
    }

    public int q() {
        if (2 != this.s) {
            return super.b(-1);
        }
        int r2 = r();
        GLES20.glBindTexture(3553, 0);
        return r2;
    }

    private int r() {
        GLES20.glBindTexture(3553, this.x[0]);
        if (this.r != null) {
            NativeLoad.getInstance();
            NativeLoad.nativeglTexImage2D(3553, 0, 6408, this.f31317e, this.f31318f, 0, 6408, 5121, this.r, 0);
        }
        return this.x[0];
    }

    public void a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        super.a(-1, floatBuffer, floatBuffer2);
    }

    private void s() {
        int[] iArr = this.t;
        if (iArr != null && iArr[0] > 0) {
            GLES20.glDeleteTextures(1, iArr, 0);
            this.t = null;
        }
        int[] iArr2 = this.u;
        if (iArr2 != null && iArr2[0] > 0) {
            GLES20.glDeleteTextures(1, iArr2, 0);
            this.u = null;
        }
    }

    public void e() {
        super.e();
        s();
    }
}
