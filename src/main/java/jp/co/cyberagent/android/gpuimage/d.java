package jp.co.cyberagent.android.gpuimage;

import android.opengl.GLES20;

public class d extends e {

    /* renamed from: a  reason: collision with root package name */
    private int f33673a;

    /* renamed from: b  reason: collision with root package name */
    private float f33674b;

    public d() {
        this(1.2f);
    }

    public d(float f2) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform lowp float contrast;\n \n void main()\n {\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     gl_FragColor = vec4(((textureColor.rgb - vec3(0.5)) * contrast + vec3(0.5)), textureColor.w);\n }");
        this.f33674b = f2;
    }

    public void b() {
        super.b();
        this.f33673a = GLES20.glGetUniformLocation(j(), "contrast");
    }

    public void a() {
        super.a();
        a(this.f33674b);
    }

    public void a(float f2) {
        this.f33674b = f2;
        a(this.f33673a, this.f33674b);
    }
}
