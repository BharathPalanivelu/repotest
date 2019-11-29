package jp.co.cyberagent.android.gpuimage;

import android.opengl.GLES20;

public class j extends e {

    /* renamed from: a  reason: collision with root package name */
    private int f33711a;

    /* renamed from: b  reason: collision with root package name */
    private float f33712b;

    public j() {
        this(1.0f);
    }

    public j(float f2) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", " varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform lowp float saturation;\n \n // Values from \"Graphics Shaders: Theory and Practice\" by Bailey and Cunningham\n const mediump vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);\n \n void main()\n {\n    lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n    lowp float luminance = dot(textureColor.rgb, luminanceWeighting);\n    lowp vec3 greyScaleColor = vec3(luminance);\n    \n    gl_FragColor = vec4(mix(greyScaleColor, textureColor.rgb, saturation), textureColor.w);\n     \n }");
        this.f33712b = f2;
    }

    public void b() {
        super.b();
        this.f33711a = GLES20.glGetUniformLocation(j(), "saturation");
    }

    public void a() {
        super.a();
        a(this.f33712b);
    }

    public void a(float f2) {
        this.f33712b = f2;
        a(this.f33711a, this.f33712b);
    }
}
