package com.rengwuxian.materialedittext;

import android.content.Context;
import android.util.TypedValue;

class b {
    public static int a(Context context, float f2) {
        return Math.round(TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics()));
    }
}
