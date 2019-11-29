package com.facebook.react.views.common;

import android.content.ContextWrapper;

public class ContextUtils {
    public static <T> T findContextOfType(T t, Class<? extends T> cls) {
        while (!cls.isInstance(t)) {
            if (!(t instanceof ContextWrapper)) {
                return null;
            }
            T baseContext = ((ContextWrapper) t).getBaseContext();
            if (t == baseContext) {
                return null;
            }
            t = baseContext;
        }
        return t;
    }
}
