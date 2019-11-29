package com.afollestad.materialdialogs.internal.progress;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.graphics.Path;

@TargetApi(21)
class g {
    public static ObjectAnimator a(Object obj, String str, String str2, Path path) {
        return ObjectAnimator.ofFloat(obj, str, str2, path);
    }
}
