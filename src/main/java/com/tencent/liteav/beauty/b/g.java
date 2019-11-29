package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import java.nio.Buffer;
import java.util.List;

public class g extends com.tencent.liteav.basic.d.g {
    protected List<com.tencent.liteav.basic.d.g> r;
    protected List<com.tencent.liteav.basic.d.g> s;
    private int[] t;
    private int[] u;
    private com.tencent.liteav.basic.d.g v;

    public boolean b() {
        boolean b2 = super.b();
        if (b2) {
            for (com.tencent.liteav.basic.d.g next : this.r) {
                next.a();
                if (!next.m()) {
                    break;
                }
            }
            b2 = this.v.a();
        }
        return b2 && GLES20.glGetError() == 0;
    }

    public void e() {
        super.e();
        for (com.tencent.liteav.basic.d.g d2 : this.r) {
            d2.d();
        }
    }

    public void f() {
        super.f();
        int[] iArr = this.u;
        if (iArr != null) {
            GLES20.glDeleteTextures(2, iArr, 0);
            this.u = null;
        }
        int[] iArr2 = this.t;
        if (iArr2 != null) {
            GLES20.glDeleteFramebuffers(2, iArr2, 0);
            this.t = null;
        }
    }

    public void a(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        if (this.f31317e != i3 || this.f31318f != i4) {
            if (this.t != null) {
                f();
            }
            super.a(i, i2);
            int size = this.s.size();
            for (int i5 = 0; i5 < size; i5++) {
                this.s.get(i5).a(i3, i4);
            }
            this.v.a(i3, i4);
            List<com.tencent.liteav.basic.d.g> list = this.s;
            if (list != null && list.size() > 0) {
                this.s.size();
                this.t = new int[2];
                this.u = new int[2];
                for (int i6 = 0; i6 < 2; i6++) {
                    GLES20.glGenFramebuffers(1, this.t, i6);
                    GLES20.glGenTextures(1, this.u, i6);
                    GLES20.glBindTexture(3553, this.u[i6]);
                    GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, (Buffer) null);
                    GLES20.glTexParameterf(3553, 10240, 9729.0f);
                    GLES20.glTexParameterf(3553, 10241, 9729.0f);
                    GLES20.glTexParameterf(3553, 10242, 33071.0f);
                    GLES20.glTexParameterf(3553, 10243, 33071.0f);
                    GLES20.glBindFramebuffer(36160, this.t[i6]);
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.u[i6], 0);
                    GLES20.glBindTexture(3553, 0);
                    GLES20.glBindFramebuffer(36160, 0);
                }
            }
        }
    }

    public int a(int i, int i2, int i3) {
        int size = this.s.size();
        k();
        int i4 = i;
        boolean z = false;
        for (int i5 = 0; i5 < size; i5++) {
            com.tencent.liteav.basic.d.g gVar = this.s.get(i5);
            if (z) {
                i4 = gVar.a(i4, i2, i3);
            } else {
                i4 = gVar.a(i4, this.t[0], this.u[0]);
            }
            z = !z;
        }
        if (z) {
            this.v.a(i4, i2, i3);
        }
        return i3;
    }
}
