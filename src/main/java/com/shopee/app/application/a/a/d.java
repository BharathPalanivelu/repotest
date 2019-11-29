package com.shopee.app.application.a.a;

import android.app.Activity;
import com.garena.android.appkit.d.a;
import com.shopee.app.application.a.b;
import com.shopee.app.application.ar;

public class d implements b.a {
    public void a(Activity activity) {
        a.b("LIFECYCLE || CREATED: %1$s", activity.getLocalClassName());
    }

    public void b(Activity activity) {
        a.b("LIFECYCLE || STARTED: %1$s", activity.getLocalClassName());
    }

    public void c(Activity activity) {
        a.b("LIFECYCLE || RESUMED: %1$s", activity.getLocalClassName());
    }

    public void d(Activity activity) {
        a.b("LIFECYCLE || PAUSED: %1$s", activity.getLocalClassName());
    }

    public void e(Activity activity) {
        a.b("LIFECYCLE || STOPPED: %1$s", activity.getLocalClassName());
    }

    public void f(Activity activity) {
        a.b("LIFECYCLE || DESTROYED: %1$s", activity.getLocalClassName());
    }

    public void a(ar arVar, Activity activity) {
        a.b("LIFECYCLE || FOREGROUND: %1$s", "SHOPEE");
    }

    public void b(ar arVar, Activity activity) {
        a.b("LIFECYCLE || BACKGROUND: %1$s", "SHOPEE");
    }
}
