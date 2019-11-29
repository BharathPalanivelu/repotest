package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;

public class e extends s {
    private int A;
    private float[] B;
    private int x;
    private int y;
    private int z;

    public void c() {
        super.c();
        this.x = GLES20.glGetUniformLocation(p(), "screenMode");
        this.y = GLES20.glGetUniformLocation(p(), "screenReplaceColor");
        this.z = GLES20.glGetUniformLocation(p(), "screenMirrorX");
        this.A = GLES20.glGetUniformLocation(p(), "screenMirrorY");
        b(this.B);
    }

    public void b(float[] fArr) {
        float[] fArr2 = new float[3];
        double d2 = (double) fArr[0];
        Double.isNaN(d2);
        double d3 = (double) fArr[1];
        Double.isNaN(d3);
        double d4 = (double) fArr[2];
        Double.isNaN(d4);
        fArr2[0] = (float) ((d2 * 0.2989d) + (d3 * 0.5866d) + (d4 * 0.1145d));
        double d5 = (double) (fArr[0] - fArr2[0]);
        Double.isNaN(d5);
        fArr2[1] = (float) (d5 * 0.7132d);
        double d6 = (double) (fArr[2] - fArr2[0]);
        Double.isNaN(d6);
        fArr2[2] = (float) (d6 * 0.5647d);
        b(this.y, fArr2);
    }
}
