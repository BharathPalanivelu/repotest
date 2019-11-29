package com.afollestad.materialdialogs.internal.progress;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.graphics.Path;
import android.graphics.PathMeasure;

@TargetApi(14)
class f {
    public static ObjectAnimator a(Object obj, String str, String str2, Path path) {
        float[] fArr = new float[500];
        float[] fArr2 = new float[500];
        a(path, fArr, fArr2);
        return ObjectAnimator.ofPropertyValuesHolder(obj, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(str, fArr), PropertyValuesHolder.ofFloat(str2, fArr2)});
    }

    private static void a(Path path, float[] fArr, float[] fArr2) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        float[] fArr3 = new float[2];
        for (int i = 0; i < 500; i++) {
            pathMeasure.getPosTan((((float) i) * length) / 499.0f, fArr3, (float[]) null);
            fArr[i] = fArr3[0];
            fArr2[i] = fArr3[1];
        }
    }
}
