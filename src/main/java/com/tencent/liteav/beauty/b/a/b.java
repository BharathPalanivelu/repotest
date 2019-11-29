package com.tencent.liteav.beauty.b.a;

import android.opengl.GLES20;
import android.util.Log;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.liteav.beauty.b.t;

public class b extends t {
    private int r = -1;
    private int s = -1;
    private int t = -1;
    private final String x = "BeautyBlend";

    public b() {
        super("varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    public boolean a() {
        NativeLoad.getInstance();
        this.f31313a = NativeLoad.nativeLoadGLProgram(12);
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
        TXCLog.i("BeautyBlend", "setBrightLevel " + f2);
        a(this.s, f2);
    }

    public void b(float f2) {
        Log.i("BeautyBlend", "setRuddyLevel level " + f2);
        a(this.t, f2 / 2.0f);
    }

    private void q() {
        this.s = GLES20.glGetUniformLocation(p(), "whiteDegree");
        this.r = GLES20.glGetUniformLocation(p(), "contrast");
        this.t = GLES20.glGetUniformLocation(p(), "ruddyDegree");
    }
}
