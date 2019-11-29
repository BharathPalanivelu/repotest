package com.garena.imageeditor.a.a;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.facebook.react.uimanager.ViewProps;
import java.nio.FloatBuffer;
import jp.co.cyberagent.android.gpuimage.k;

public class d extends k {

    /* renamed from: d  reason: collision with root package name */
    private int f8060d;

    /* renamed from: e  reason: collision with root package name */
    private int f8061e;

    /* renamed from: f  reason: collision with root package name */
    private int f8062f;

    /* renamed from: g  reason: collision with root package name */
    private int f8063g;

    public d(String str) {
        super(str);
    }

    public void b() {
        super.b();
        this.f8060d = GLES20.glGetUniformLocation(j(), "excludeCirclePoint");
        this.f8061e = GLES20.glGetUniformLocation(j(), "excludeCircleRadius");
        this.f8062f = GLES20.glGetUniformLocation(j(), "excludeBlurSize");
        this.f8063g = GLES20.glGetUniformLocation(j(), ViewProps.ASPECT_RATIO);
    }

    public void a(int i) {
        this.f33715c = i;
    }

    public void a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        super.a(i, floatBuffer, floatBuffer2);
    }

    public void a() {
        super.a();
    }

    public void a(PointF pointF) {
        a(this.f8060d, pointF);
    }

    public void a(float f2) {
        a(this.f8061e, f2);
    }

    public void b(float f2) {
        a(this.f8062f, f2);
    }

    public void c(float f2) {
        a(this.f8063g, f2);
    }
}
