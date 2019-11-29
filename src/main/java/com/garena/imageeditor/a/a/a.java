package com.garena.imageeditor.a.a;

import jp.co.cyberagent.android.gpuimage.k;

public class a extends k {
    public a() {
        super("varying highp vec2 textureCoordinate;\n varying highp vec2 textureCoordinate2; // TODO: This is not used\n \n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2; // lookup texture\n \n void main()\n {\n     highp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     highp float blueColor = textureColor.b * 32.0;\n     highp vec2 texPos1;\n     texPos1.x = textureColor.r;\n     texPos1.y = ((floor(blueColor) * 33.0) + textureColor.g * 32.0 + 0.5) / 1089.0;\n     highp vec2 texPos2;\n     texPos2.x = textureColor.r;\n     texPos2.y = ((ceil(blueColor) * 33.0) + textureColor.g * 32.0 + 0.5) / 1089.0;\n     highp vec4 newColor1 = texture2D(inputImageTexture2, texPos1);\n     highp vec4 newColor2 = texture2D(inputImageTexture2, texPos2);\n     highp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n     gl_FragColor = vec4(newColor.rgb, textureColor.w);\n }");
    }
}
