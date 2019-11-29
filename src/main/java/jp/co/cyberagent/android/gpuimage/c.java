package jp.co.cyberagent.android.gpuimage;

import android.opengl.GLES20;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class c extends e {

    /* renamed from: a  reason: collision with root package name */
    private int f33671a;

    /* renamed from: b  reason: collision with root package name */
    private float f33672b;

    public c() {
        this(BitmapDescriptorFactory.HUE_RED);
    }

    public c(float f2) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform lowp float brightness;\n\nvoid main()\n{\n    lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n    \n    gl_FragColor = (1.0 + brightness) * textureColor;\n}");
        this.f33672b = f2;
    }

    public void b() {
        super.b();
        this.f33671a = GLES20.glGetUniformLocation(j(), "brightness");
    }

    public void a() {
        super.a();
        a(this.f33672b);
    }

    public void a(float f2) {
        this.f33672b = f2;
        a(this.f33671a, this.f33672b);
    }
}
