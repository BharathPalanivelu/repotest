package com.shopee.shopeetracker.callbacks;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.shopee.shopeetracker.manager.SessionManager;
import java.util.ArrayList;
import java.util.List;

public class TrackerLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    private Context context;
    private boolean isAppInBackground = true;
    private boolean mAppInBackground = true;
    private final List<Listener> mListeners;
    private int mStartedCount = 0;
    private SessionListener sessionListener;
    private TrackerSendListener trackerSendListener;

    public interface Listener {
        void onActivityCreated(Activity activity);

        void onActivityDestroyed(Activity activity);

        void onActivityPaused(Activity activity);

        void onActivityResumed(Activity activity);

        void onActivityStarted(Activity activity);

        void onActivityStopped(Activity activity);

        void onAppInBackground(Activity activity);

        void onAppInForeground(Activity activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public TrackerLifecycleCallbacks(Context context2) {
        this.context = context2;
        this.mListeners = new ArrayList();
        initListeners();
    }

    private void initListeners() {
        this.sessionListener = new SessionListener();
        this.trackerSendListener = new TrackerSendListener();
        this.mListeners.add(this.sessionListener);
        this.mListeners.add(this.trackerSendListener);
    }

    public void setSessionIntervalTime(long j) {
        SessionManager.getInstance().setSessionIntervalTime(j);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        for (Listener onActivityCreated : this.mListeners) {
            onActivityCreated.onActivityCreated(activity);
        }
    }

    public void onActivityStarted(Activity activity) {
        if (this.mStartedCount == 0) {
            appCameIntoForeground(activity);
        }
        this.mStartedCount++;
        for (Listener onActivityStarted : this.mListeners) {
            onActivityStarted.onActivityStarted(activity);
        }
    }

    public void onActivityResumed(Activity activity) {
        for (Listener onActivityResumed : this.mListeners) {
            onActivityResumed.onActivityResumed(activity);
        }
    }

    public void onActivityPaused(Activity activity) {
        for (Listener onActivityPaused : this.mListeners) {
            onActivityPaused.onActivityPaused(activity);
        }
    }

    public void onActivityStopped(Activity activity) {
        this.mStartedCount--;
        if (this.mStartedCount == 0) {
            appWentIntoBackground(activity);
        }
        for (Listener onActivityStopped : this.mListeners) {
            onActivityStopped.onActivityStopped(activity);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        for (Listener onActivityDestroyed : this.mListeners) {
            onActivityDestroyed.onActivityDestroyed(activity);
        }
    }

    private void appCameIntoForeground(Activity activity) {
        this.isAppInBackground = false;
        for (Listener onAppInForeground : this.mListeners) {
            onAppInForeground.onAppInForeground(activity);
        }
    }

    private void appWentIntoBackground(Activity activity) {
        this.isAppInBackground = true;
        for (Listener onAppInBackground : this.mListeners) {
            onAppInBackground.onAppInBackground(activity);
        }
    }

    public boolean isAppInBackground() {
        return this.isAppInBackground;
    }
}
