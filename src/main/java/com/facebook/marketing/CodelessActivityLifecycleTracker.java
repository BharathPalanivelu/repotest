package com.facebook.marketing;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.facebook.marketing.internal.ButtonIndexer;

public class CodelessActivityLifecycleTracker {
    private static final String TAG = "com.facebook.marketing.CodelessActivityLifecycleTracker";
    /* access modifiers changed from: private */
    public static final ButtonIndexer buttonIndexer = new ButtonIndexer();
    private static Boolean isAppIndexingEnabled = false;

    public static void startTracking(Application application) {
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            public void onActivityDestroyed(Activity activity) {
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public void onActivityStarted(Activity activity) {
            }

            public void onActivityStopped(Activity activity) {
            }

            public void onActivityResumed(Activity activity) {
                CodelessActivityLifecycleTracker.buttonIndexer.add(activity);
            }

            public void onActivityPaused(Activity activity) {
                CodelessActivityLifecycleTracker.buttonIndexer.remove(activity);
            }
        });
    }

    public static boolean getIsAppIndexingEnabled() {
        return isAppIndexingEnabled.booleanValue();
    }

    public static void updateAppIndexing(Boolean bool) {
        isAppIndexingEnabled = bool;
    }
}
