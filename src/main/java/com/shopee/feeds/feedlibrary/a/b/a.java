package com.shopee.feeds.feedlibrary.a.b;

import android.app.Activity;
import android.content.Context;
import android.os.Build;

public final class a {
    public static boolean a(Context context) {
        if (!(context instanceof Activity)) {
            return true;
        }
        Activity activity = (Activity) context;
        if (Build.VERSION.SDK_INT < 17) {
            return activity.isFinishing();
        }
        if (activity.isDestroyed() || activity.isFinishing()) {
            return true;
        }
        return false;
    }
}
