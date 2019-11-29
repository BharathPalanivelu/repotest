package com.afollestad.materialdialogs.internal.progress;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;

@TargetApi(14)
public class e {
    public static ObjectAnimator a(Object obj, String str, String str2, Path path) {
        if (Build.VERSION.SDK_INT >= 21) {
            return g.a(obj, str, str2, path);
        }
        return f.a(obj, str, str2, path);
    }
}
