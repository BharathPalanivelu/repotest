package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.basic.d.j;
import com.tencent.liteav.basic.d.k;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class s extends g {
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    private ByteBuffer x;
    private ByteBuffer y;

    public s(String str) {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\nattribute vec4 inputTextureCoordinate3;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvarying vec2 textureCoordinate3;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n    textureCoordinate3 = inputTextureCoordinate3.xy;\n}", str);
        a(j.NORMAL, false, true);
    }

    public s(String str, String str2) {
        super(str, str2);
        this.t = -1;
        this.w = -1;
        a(j.NORMAL, false, true);
    }

    public boolean b() {
        boolean b2 = super.b();
        GLES20.glUseProgram(p());
        this.r = GLES20.glGetAttribLocation(p(), "inputTextureCoordinate2");
        this.u = GLES20.glGetAttribLocation(p(), "inputTextureCoordinate3");
        this.s = GLES20.glGetUniformLocation(p(), "inputImageTexture2");
        this.v = GLES20.glGetUniformLocation(p(), "inputImageTexture3");
        GLES20.glEnableVertexAttribArray(this.r);
        GLES20.glEnableVertexAttribArray(this.u);
        return b2;
    }

    public int a(int i, int i2, int i3) {
        return a(i, i2, i3, this.m, this.n);
    }

    public int a(int i, int i2, int i3, int i4, int i5) {
        this.t = i2;
        this.w = i3;
        return super.a(i, i4, i5);
    }

    public void a(int i, int i2) {
        super.a(i, i2);
    }

    /* access modifiers changed from: protected */
    public void i() {
        GLES20.glEnableVertexAttribArray(this.r);
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(3553, this.t);
        GLES20.glUniform1i(this.s, 3);
        this.x.position(0);
        GLES20.glVertexAttribPointer(this.r, 2, 5126, false, 0, this.x);
        GLES20.glEnableVertexAttribArray(this.u);
        GLES20.glActiveTexture(33988);
        GLES20.glBindTexture(3553, this.w);
        GLES20.glUniform1i(this.v, 4);
        this.y.position(0);
        GLES20.glVertexAttribPointer(this.u, 2, 5126, false, 0, this.y);
    }

    public void a(j jVar, boolean z, boolean z2) {
        float[] a2 = k.a(jVar, z, z2);
        ByteBuffer order = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = order.asFloatBuffer();
        asFloatBuffer.put(a2);
        asFloatBuffer.flip();
        this.x = order;
        ByteBuffer order2 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = order2.asFloatBuffer();
        asFloatBuffer2.put(a2);
        asFloatBuffer2.flip();
        this.y = order2;
    }
}
