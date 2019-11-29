package com.google.android.material.f;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

public class a {
    public static ColorStateList a(Context context, TypedArray typedArray, int i) {
        if (typedArray.hasValue(i)) {
            int resourceId = typedArray.getResourceId(i, 0);
            if (resourceId != 0) {
                ColorStateList a2 = androidx.appcompat.a.a.a.a(context, resourceId);
                if (a2 != null) {
                    return a2;
                }
            }
        }
        return typedArray.getColorStateList(i);
    }

    public static Drawable b(Context context, TypedArray typedArray, int i) {
        if (typedArray.hasValue(i)) {
            int resourceId = typedArray.getResourceId(i, 0);
            if (resourceId != 0) {
                Drawable b2 = androidx.appcompat.a.a.a.b(context, resourceId);
                if (b2 != null) {
                    return b2;
                }
            }
        }
        return typedArray.getDrawable(i);
    }
}
