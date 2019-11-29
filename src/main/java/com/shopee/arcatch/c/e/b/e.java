package com.shopee.arcatch.c.e.b;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.arcatch.c.d.a;
import com.tencent.imsdk.TIMGroupManager;
import java.nio.FloatBuffer;

public class e extends c {

    /* renamed from: a  reason: collision with root package name */
    private static float[] f26835a = {-1.0f, -1.0f, BitmapDescriptorFactory.HUE_RED, 1.0f, -1.0f, BitmapDescriptorFactory.HUE_RED, -1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};

    /* renamed from: b  reason: collision with root package name */
    private static float[] f26836b = {BitmapDescriptorFactory.HUE_RED, 1.0f, 1.0f, 1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED};

    /* renamed from: c  reason: collision with root package name */
    private FloatBuffer f26837c;

    /* renamed from: d  reason: collision with root package name */
    private FloatBuffer f26838d = a.a(f26836b);

    /* renamed from: e  reason: collision with root package name */
    private int f26839e;

    /* renamed from: f  reason: collision with root package name */
    private int f26840f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f26841g;
    private int h;
    private int i;

    private void a(int i2, int i3) {
        float f2 = (((float) (i3 * 2)) / ((float) i2)) - 1.0f;
        float[] fArr = f26835a;
        fArr[7] = f2;
        fArr[10] = f2;
        this.f26837c = a.a(fArr);
    }

    public void a() {
        this.f26839e = a.a("attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position =  aPosition;\n    vTextureCoord = aTextureCoord.xy;\n}\n", "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sWaterMarkTexture;\nvoid main() {\n   gl_FragColor = texture2D(sWaterMarkTexture, vTextureCoord);\n}\n");
        int i2 = this.f26839e;
        if (i2 != 0) {
            this.f26841g = GLES20.glGetAttribLocation(i2, "aPosition");
            this.h = GLES20.glGetAttribLocation(this.f26839e, "aTextureCoord");
            this.i = GLES20.glGetUniformLocation(this.f26839e, "sWaterMarkTexture");
            Bitmap k = a.a().k();
            if (k != null) {
                a(k.getWidth(), k.getHeight());
            }
            this.f26840f = a.a(k, true);
            return;
        }
        throw new RuntimeException("failed creating program");
    }

    public void a(boolean z) {
        if (z) {
            GLES20.glClearColor(1.0f, 1.0f, 1.0f, BitmapDescriptorFactory.HUE_RED);
            GLES20.glClear(TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE);
        }
        GLES20.glUseProgram(this.f26839e);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f26840f);
        GLES20.glUniform1i(this.i, 1);
        a("fill glUniformTexture");
        GLES20.glEnableVertexAttribArray(this.f26841g);
        GLES20.glVertexAttribPointer(this.f26841g, 3, 5126, false, 12, this.f26837c);
        a("fill maPositionHandle");
        GLES20.glEnableVertexAttribArray(this.h);
        GLES20.glVertexAttribPointer(this.h, 2, 5126, false, 8, this.f26838d);
        a("fill maTextureHandle");
        GLES20.glDrawArrays(5, 0, 4);
        a("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.f26841g);
        GLES20.glDisableVertexAttribArray(this.h);
        GLES20.glDisable(3042);
        GLES20.glUseProgram(0);
    }
}
