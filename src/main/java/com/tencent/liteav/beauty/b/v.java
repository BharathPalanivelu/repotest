package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.liteav.basic.d.g;

public class v extends u {
    protected float u;

    public boolean b() {
        return super.b() && GLES20.glGetError() == 0;
    }

    /* access modifiers changed from: protected */
    public void s() {
        float r = r();
        g gVar = (g) this.r.get(0);
        int glGetUniformLocation = GLES20.glGetUniformLocation(gVar.p(), "texelWidthOffset");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(gVar.p(), "texelHeightOffset");
        gVar.a(glGetUniformLocation, r / ((float) this.f31317e));
        gVar.a(glGetUniformLocation2, (float) BitmapDescriptorFactory.HUE_RED);
        float q = q();
        g gVar2 = (g) this.r.get(1);
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(gVar2.p(), "texelWidthOffset");
        int glGetUniformLocation4 = GLES20.glGetUniformLocation(gVar2.p(), "texelHeightOffset");
        gVar2.a(glGetUniformLocation3, (float) BitmapDescriptorFactory.HUE_RED);
        gVar2.a(glGetUniformLocation4, q / ((float) this.f31318f));
    }

    public void a(int i, int i2) {
        super.a(i, i2);
        s();
    }

    public float q() {
        return this.u;
    }

    public float r() {
        return this.u;
    }
}
