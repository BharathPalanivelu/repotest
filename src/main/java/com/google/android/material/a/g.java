package com.google.android.material.a;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

public class g implements TypeEvaluator<Matrix> {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f13108a = new float[9];

    /* renamed from: b  reason: collision with root package name */
    private final float[] f13109b = new float[9];

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f13110c = new Matrix();

    /* renamed from: a */
    public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f13108a);
        matrix2.getValues(this.f13109b);
        for (int i = 0; i < 9; i++) {
            float[] fArr = this.f13109b;
            float f3 = fArr[i];
            float[] fArr2 = this.f13108a;
            fArr[i] = fArr2[i] + ((f3 - fArr2[i]) * f2);
        }
        this.f13110c.setValues(this.f13109b);
        return this.f13110c;
    }
}
