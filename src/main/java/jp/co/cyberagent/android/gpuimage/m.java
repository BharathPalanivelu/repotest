package jp.co.cyberagent.android.gpuimage;

import android.opengl.GLES20;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class m extends l {
    public float l() {
        return 1.0f;
    }

    public float m() {
        return 1.0f;
    }

    public m(String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
    }

    public void b() {
        super.b();
        n();
    }

    /* access modifiers changed from: protected */
    public void n() {
        float m = m();
        e eVar = (e) this.f33685a.get(0);
        int glGetUniformLocation = GLES20.glGetUniformLocation(eVar.j(), "texelWidthOffset");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(eVar.j(), "texelHeightOffset");
        eVar.a(glGetUniformLocation, m / ((float) this.n));
        eVar.a(glGetUniformLocation2, (float) BitmapDescriptorFactory.HUE_RED);
        float l = l();
        e eVar2 = (e) this.f33685a.get(1);
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(eVar2.j(), "texelWidthOffset");
        int glGetUniformLocation4 = GLES20.glGetUniformLocation(eVar2.j(), "texelHeightOffset");
        eVar2.a(glGetUniformLocation3, (float) BitmapDescriptorFactory.HUE_RED);
        eVar2.a(glGetUniformLocation4, l / ((float) this.o));
    }

    public void a(int i, int i2) {
        super.a(i, i2);
        n();
    }
}
