package com.tencent.liteav.beauty.b.a;

import android.opengl.GLES20;
import android.os.Build;
import android.util.Log;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.liteav.beauty.b.t;

public class e extends t {
    private String A = "SmoothVertical";
    private int r = -1;
    private int s = -1;
    private int t = -1;
    private int x = -1;
    private float y = 2.0f;
    private float z = 0.5f;

    e() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    public boolean a() {
        if (!Build.BRAND.equals("samsung") || !Build.MODEL.equals("GT-I9500") || !Build.VERSION.RELEASE.equals("4.3")) {
            NativeLoad.getInstance();
            this.f31313a = NativeLoad.nativeLoadGLProgram(5);
        } else {
            Log.d(this.A, "SAMSUNG_S4 GT-I9500 + Android 4.3; use diffrent shader!");
            NativeLoad.getInstance();
            this.f31313a = NativeLoad.nativeLoadGLProgram(15);
        }
        if (this.f31313a == 0 || !b()) {
            this.f31319g = false;
        } else {
            this.f31319g = true;
        }
        c();
        return this.f31319g;
    }

    public boolean b() {
        super.b();
        q();
        return true;
    }

    public void a(float f2) {
        this.z = f2;
        String str = this.A;
        TXCLog.i(str, "setBeautyLevel " + f2);
        a(this.t, f2);
    }

    public void q() {
        this.r = GLES20.glGetUniformLocation(p(), "texelWidthOffset");
        this.s = GLES20.glGetUniformLocation(p(), "texelHeightOffset");
        this.t = GLES20.glGetUniformLocation(p(), "smoothDegree");
    }

    public void a(int i, int i2) {
        super.a(i, i2);
        if (i > i2) {
            if (i2 < 540) {
                this.y = 2.0f;
            } else {
                this.y = 4.0f;
            }
        } else if (i < 540) {
            this.y = 2.0f;
        } else {
            this.y = 4.0f;
        }
        String str = this.A;
        TXCLog.i(str, "m_textureRation " + this.y);
        a(this.r, this.y / ((float) i));
        a(this.s, this.y / ((float) i2));
    }
}
