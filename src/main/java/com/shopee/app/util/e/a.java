package com.shopee.app.util.e;

import android.app.Activity;
import android.view.Window;
import d.d.b.j;

public final class a {
    public final void a(Activity activity, boolean z) {
        j.b(activity, "activity");
        Window window = activity.getWindow();
        if (z) {
            window.clearFlags(128);
        } else {
            window.addFlags(128);
        }
        com.garena.android.appkit.d.a.d("deviceScreenAutoLock isEnabled = " + z, new Object[0]);
    }
}
