package com.shopee.arcatch.c.e.b;

import android.opengl.GLES20;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.arcatch.c.d.a;
import java.nio.FloatBuffer;

public class b extends c {

    /* renamed from: a  reason: collision with root package name */
    private float[] f26821a = {-1.0f, -1.0f, BitmapDescriptorFactory.HUE_RED, 1.0f, -1.0f, BitmapDescriptorFactory.HUE_RED, -1.0f, 1.0f, BitmapDescriptorFactory.HUE_RED, 1.0f, 1.0f, BitmapDescriptorFactory.HUE_RED};

    /* renamed from: b  reason: collision with root package name */
    private float[] f26822b = {BitmapDescriptorFactory.HUE_RED, 1.0f, 1.0f, 1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED};

    /* renamed from: c  reason: collision with root package name */
    private FloatBuffer f26823c = a.a(this.f26821a);

    /* renamed from: d  reason: collision with root package name */
    private FloatBuffer f26824d = a.a(this.f26822b);

    /* renamed from: e  reason: collision with root package name */
    private int f26825e;

    /* renamed from: f  reason: collision with root package name */
    private int f26826f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f26827g;
    private int h;
    private int i;

    public void a() {
        this.f26825e = a.a("attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\ngl_Position =  aPosition;\nvTextureCoord = aTextureCoord.xy;\n}\n", "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n   gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        int i2 = this.f26825e;
        if (i2 != 0) {
            this.f26827g = GLES20.glGetAttribLocation(i2, "aPosition");
            this.h = GLES20.glGetAttribLocation(this.f26825e, "aTextureCoord");
            this.i = GLES20.glGetUniformLocation(this.f26825e, "sWaterMarkTexture");
            this.f26826f = a.a(a.a().l(), false);
            return;
        }
        throw new RuntimeException("failed creating program");
    }

    public void a(boolean z) {
        if (z) {
            GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
            GLES20.glClear(16640);
        }
        if (this.f26826f != -1) {
            GLES20.glUseProgram(this.f26825e);
            GLES20.glEnableVertexAttribArray(this.f26827g);
            GLES20.glVertexAttribPointer(this.f26827g, 3, 5126, false, 12, this.f26823c);
            GLES20.glEnableVertexAttribArray(this.h);
            GLES20.glVertexAttribPointer(this.h, 2, 5126, false, 8, this.f26824d);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.f26826f);
            GLES20.glUniform1i(this.i, 0);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.f26827g);
            GLES20.glDisableVertexAttribArray(this.h);
            GLES20.glBindTexture(3553, 0);
            GLES20.glUseProgram(0);
        }
    }
}
