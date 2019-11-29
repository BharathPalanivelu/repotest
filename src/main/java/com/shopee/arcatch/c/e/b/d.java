package com.shopee.arcatch.c.e.b;

import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.imsdk.TIMGroupManager;
import java.nio.FloatBuffer;

public class d extends c {

    /* renamed from: a  reason: collision with root package name */
    private static float[] f26828a = {-1.0f, -1.0f, BitmapDescriptorFactory.HUE_RED, 1.0f, -1.0f, BitmapDescriptorFactory.HUE_RED, -1.0f, 1.0f, BitmapDescriptorFactory.HUE_RED, 1.0f, 1.0f, BitmapDescriptorFactory.HUE_RED};

    /* renamed from: b  reason: collision with root package name */
    private static float[] f26829b = {BitmapDescriptorFactory.HUE_RED, 1.0f, 1.0f, 1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED};

    /* renamed from: c  reason: collision with root package name */
    private FloatBuffer f26830c;

    /* renamed from: d  reason: collision with root package name */
    private FloatBuffer f26831d;

    /* renamed from: e  reason: collision with root package name */
    private float[] f26832e = new float[16];

    /* renamed from: f  reason: collision with root package name */
    private float[] f26833f = new float[16];

    /* renamed from: g  reason: collision with root package name */
    private int f26834g;
    private int h = -12345;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private Rect o;

    public d(int i2, int i3, Rect rect) {
        Matrix.setIdentityM(this.f26833f, 0);
        this.m = i2;
        this.n = i3;
        this.o = rect;
        c();
    }

    private void c() {
        float height = ((float) this.m) / ((float) this.o.height());
        int i2 = 0;
        while (true) {
            float[] fArr = f26828a;
            if (i2 < fArr.length) {
                fArr[i2] = i2 % 2 == 0 ? -height : height;
                i2 += 3;
            } else {
                f26829b[0] = ((float) this.o.left) / ((float) this.m);
                f26829b[1] = ((float) this.o.bottom) / ((float) this.n);
                f26829b[2] = ((float) this.o.right) / ((float) this.m);
                float[] fArr2 = f26829b;
                fArr2[3] = fArr2[1];
                fArr2[4] = fArr2[0];
                fArr2[5] = ((float) this.o.top) / ((float) this.n);
                float[] fArr3 = f26829b;
                fArr3[6] = fArr3[2];
                fArr3[7] = fArr3[5];
                this.f26830c = a.a(f26828a);
                this.f26831d = a.a(f26829b);
                return;
            }
        }
    }

    public int a() {
        return this.h;
    }

    public void b() {
        this.f26834g = a.a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n   gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        int i2 = this.f26834g;
        if (i2 != 0) {
            this.k = GLES20.glGetAttribLocation(i2, "aPosition");
            this.l = GLES20.glGetAttribLocation(this.f26834g, "aTextureCoord");
            this.i = GLES20.glGetUniformLocation(this.f26834g, "uMVPMatrix");
            this.j = GLES20.glGetUniformLocation(this.f26834g, "uSTMatrix");
            this.h = a.a();
            return;
        }
        throw new RuntimeException("failed creating program");
    }

    public void a(boolean z) {
        if (z) {
            GLES20.glClearColor(1.0f, 1.0f, 1.0f, BitmapDescriptorFactory.HUE_RED);
            GLES20.glClear(TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE);
        }
        GLES20.glUseProgram(this.f26834g);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.h);
        a("BindTextu0");
        GLES20.glEnableVertexAttribArray(this.k);
        GLES20.glVertexAttribPointer(this.k, 3, 5126, false, 12, this.f26830c);
        a("fill maPositionHandle");
        GLES20.glEnableVertexAttribArray(this.l);
        GLES20.glVertexAttribPointer(this.l, 2, 5126, false, 8, this.f26831d);
        a("fill maTextureHandle");
        Matrix.setIdentityM(this.f26832e, 0);
        GLES20.glUniformMatrix4fv(this.i, 1, false, this.f26832e, 0);
        GLES20.glUniformMatrix4fv(this.j, 1, false, this.f26833f, 0);
        GLES20.glDrawArrays(5, 0, 4);
        a("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.k);
        GLES20.glDisableVertexAttribArray(this.l);
        GLES20.glUseProgram(0);
    }
}
