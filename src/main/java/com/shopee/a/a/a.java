package com.shopee.a.a;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

public class a implements Application.ActivityLifecycleCallbacks {
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        com.shopee.a.a.a((Object) activity);
    }

    public void onActivityPaused(Activity activity) {
        com.shopee.a.a.b(activity);
    }

    public void onActivityDestroyed(Activity activity) {
        com.shopee.a.a.c(activity);
    }
}
