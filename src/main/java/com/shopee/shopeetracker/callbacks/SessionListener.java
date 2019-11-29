package com.shopee.shopeetracker.callbacks;

import android.app.Activity;
import com.shopee.shopeetracker.callbacks.TrackerLifecycleCallbacks;
import com.shopee.shopeetracker.manager.SessionManager;

public class SessionListener implements TrackerLifecycleCallbacks.Listener {
    public void onActivityCreated(Activity activity) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onAppInForeground(Activity activity) {
        SessionManager.getInstance().refreshSessionId();
    }

    public void onAppInBackground(Activity activity) {
        SessionManager.getInstance().setLastTimeEnterBackground();
    }
}
