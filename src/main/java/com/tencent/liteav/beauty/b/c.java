package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import android.util.Log;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.liteav.beauty.NativeLoad;

public class c extends b {
    private static final String r = "c";
    private float A = BitmapDescriptorFactory.HUE_RED;
    private f s;
    private a t;
    private r u = null;
    private int v = -1;
    private int w = -1;
    private float x = BitmapDescriptorFactory.HUE_RED;
    private float y = BitmapDescriptorFactory.HUE_RED;
    private float z = BitmapDescriptorFactory.HUE_RED;

    private static float a(float f2, float f3, float f4) {
        return f3 + ((f4 - f3) * f2);
    }

    public int b(int i) {
        if (this.x > BitmapDescriptorFactory.HUE_RED || this.y > BitmapDescriptorFactory.HUE_RED || this.z > BitmapDescriptorFactory.HUE_RED) {
            i = this.t.a(this.x != BitmapDescriptorFactory.HUE_RED ? this.s.b(i) : i, i, i);
        }
        return this.A > BitmapDescriptorFactory.HUE_RED ? this.u.b(i) : i;
    }

    public void a(int i, int i2) {
        if (this.v != i || this.w != i2) {
            String str = r;
            Log.i(str, "onOutputSizeChanged mFrameWidth = " + i + "  mFrameHeight = " + i2);
            this.v = i;
            this.w = i2;
            c(this.v, this.w);
        }
    }

    public boolean c(int i, int i2) {
        this.v = i;
        this.w = i2;
        String str = r;
        Log.i(str, "init mFrameWidth = " + i + "  mFrameHeight = " + i2);
        if (this.s == null) {
            this.s = new f();
            this.s.a(true);
            if (!this.s.a()) {
                Log.e(r, "mNewFaceFilter init Failed");
                return false;
            }
        }
        this.s.a(this.v, this.w);
        if (this.t == null) {
            this.t = new a();
            this.t.a(true);
            if (!this.t.a()) {
                Log.e(r, "mBeautyCoreFilter init Failed");
                return false;
            }
        }
        this.t.a(this.v, this.w);
        if (this.u == null) {
            this.u = new r();
            this.u.a(true);
            if (!this.u.a()) {
                Log.e(r, "mSharpenessFilter init Failed");
                return false;
            }
        }
        this.u.a(this.v, this.w);
        return true;
    }

    public void e() {
        a aVar = this.t;
        if (aVar != null) {
            aVar.d();
            this.t = null;
        }
        f fVar = this.s;
        if (fVar != null) {
            fVar.d();
            this.s = null;
        }
        r rVar = this.u;
        if (rVar != null) {
            rVar.d();
            this.u = null;
        }
    }

    public void c(int i) {
        float f2 = (float) i;
        this.x = f2;
        a aVar = this.t;
        if (aVar != null) {
            aVar.a(f2);
        }
    }

    public void d(int i) {
        float f2 = (float) i;
        this.y = f2;
        a aVar = this.t;
        if (aVar != null) {
            aVar.b(f2);
        }
    }

    public void e(int i) {
        float f2 = (float) i;
        this.z = f2;
        a aVar = this.t;
        if (aVar != null) {
            aVar.c(f2);
        }
    }

    public void f(int i) {
        this.A = ((float) i) / 15.0f;
        r rVar = this.u;
        if (rVar != null) {
            rVar.a(this.A);
        }
    }

    public static class a extends s {
        private int x = -1;
        private int y = -1;
        private int z = -1;

        public a() {
            super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\nattribute vec4 inputTextureCoordinate3;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvarying vec2 textureCoordinate3;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n    textureCoordinate3 = inputTextureCoordinate3.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        }

        public boolean a() {
            NativeLoad.getInstance();
            this.f31313a = NativeLoad.nativeLoadGLProgram(1);
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
                super.a(i, i2);
                this.x = GLES20.glGetUniformLocation(p(), "smoothDegree");
                this.y = GLES20.glGetUniformLocation(p(), "brightDegree");
                this.z = GLES20.glGetUniformLocation(p(), "ruddyDegree");
            }
        }

        public boolean b() {
            return super.b();
        }

        public void a(float f2) {
            a(this.x, c.b(f2));
        }

        public void b(float f2) {
            a(this.y, f2 / 3.0f);
        }

        public void c(float f2) {
            a(this.z, (f2 / 10.0f) / 2.0f);
        }
    }

    /* access modifiers changed from: private */
    public static float b(float f2) {
        if (f2 <= 1.0f) {
            return 0.1f;
        }
        double d2 = (double) f2;
        if (d2 < 2.5d) {
            f2 = a((f2 - 1.0f) / 1.5f, 1.0f, 4.1f);
        } else if (f2 < 4.0f) {
            f2 = a((f2 - 2.5f) / 1.5f, 4.1f, 5.6f);
        } else if (d2 < 5.5d) {
            f2 = a((f2 - 4.0f) / 1.5f, 5.6f, 6.8f);
        } else if (d2 <= 7.0d) {
            f2 = a((f2 - 5.5f) / 1.5f, 6.8f, 7.0f);
        }
        return f2 / 10.0f;
    }
}
