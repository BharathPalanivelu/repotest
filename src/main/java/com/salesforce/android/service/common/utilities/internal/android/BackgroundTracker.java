package com.salesforce.android.service.common.utilities.internal.android;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.salesforce.android.service.common.utilities.activity.ActivityTracker;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class BackgroundTracker implements ActivityTracker.OnResumeListener, ActivityTracker.OnStopListener {
    private final ActivityTracker mActivityTracker;
    private final Handler mHandler;
    private boolean mInBackground = false;
    private final Set<Listener> mListeners = Collections.newSetFromMap(new ConcurrentHashMap());

    public interface Listener {
        void onBackgroundChange(boolean z);
    }

    BackgroundTracker(ActivityTracker activityTracker, Handler handler) {
        this.mActivityTracker = activityTracker;
        this.mHandler = handler;
    }

    public static BackgroundTracker create(ActivityTracker activityTracker) {
        return new BackgroundTracker(activityTracker, new Handler(Looper.getMainLooper()));
    }

    public void start() {
        this.mInBackground = this.mActivityTracker.getForegroundActivity() == null;
        this.mActivityTracker.onResume(this).onStop(this);
    }

    public void stop() {
        this.mActivityTracker.removeOnResume(this).removeOnStop(this);
    }

    public void addListener(Listener listener) {
        this.mListeners.add(listener);
    }

    public void removeListener(Listener listener) {
        this.mListeners.remove(listener);
    }

    public ActivityTracker getActivityTracker() {
        return this.mActivityTracker;
    }

    public boolean isInBackground() {
        return this.mInBackground;
    }

    private void setInBackground(boolean z) {
        if (this.mInBackground != z) {
            this.mInBackground = z;
            for (Listener onBackgroundChange : this.mListeners) {
                onBackgroundChange.onBackgroundChange(z);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void checkInBackground() {
        if (this.mActivityTracker.getForegroundActivity() == null) {
            setInBackground(true);
        }
    }

    public void onActivityResume(Activity activity) {
        setInBackground(false);
    }

    public void onActivityStop(Activity activity) {
        this.mHandler.post(new Runnable() {
            public void run() {
                BackgroundTracker.this.checkInBackground();
            }
        });
    }
}
