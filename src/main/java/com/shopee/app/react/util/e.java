package com.shopee.app.react.util;

import android.app.Activity;
import com.shopee.app.react.c;

public final class e {
    public static final boolean a(int i, Activity activity) {
        return activity != null && (activity instanceof c) && ((c) activity).getReactTag() == i;
    }
}
