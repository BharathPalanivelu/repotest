package com.shopee.app.ui.image.editor.d;

import android.content.Context;
import android.util.TypedValue;

public class d {
    public static int a(int i, Context context) {
        return (int) TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
    }
}
