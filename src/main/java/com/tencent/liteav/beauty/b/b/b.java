package com.tencent.liteav.beauty.b.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.beauty.NativeLoad;

public class b extends g {
    private int r = -1;
    private int s = -1;
    private float[] t = new float[4];
    private String u = "Beauty3Filter";

    public b() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    public boolean a() {
        NativeLoad.getInstance();
        this.f31313a = NativeLoad.nativeLoadGLProgram(14);
        if (this.f31313a == 0 || !b()) {
            this.f31319g = false;
        } else {
            this.f31319g = true;
        }
        c();
        return this.f31319g;
    }

    public boolean b() {
        boolean b2 = super.b();
        this.r = GLES20.glGetUniformLocation(p(), "singleStepOffset");
        this.s = GLES20.glGetUniformLocation(p(), "beautyParams");
        a(5.0f);
        return b2;
    }

    public void c(int i, int i2) {
        a(this.r, new float[]{2.0f / ((float) i), 2.0f / ((float) i2)});
    }

    public void a(int i, int i2) {
        super.a(i, i2);
        c(i, i2);
    }

    public void a(float f2) {
        float[] fArr = this.t;
        fArr[0] = f2;
        b(fArr);
    }

    public void b(float f2) {
        float[] fArr = this.t;
        fArr[1] = f2;
        b(fArr);
    }

    public void c(float f2) {
        float[] fArr = this.t;
        fArr[2] = f2;
        b(fArr);
    }

    private void b(float[] fArr) {
        c(this.s, fArr);
    }
}
