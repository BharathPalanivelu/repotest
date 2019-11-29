package com.salesforce.android.service.common.utilities.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.util.HashSet;
import java.util.Set;

public class ActivityTracker {
    /* access modifiers changed from: private */
    public static final ServiceLogger log = ServiceLogging.getLogger(ActivityTracker.class);
    private Application mApplication;
    final Set<OnCreateListener> mCreateListeners = new HashSet();
    final Set<OnDestroyListener> mDestroyListeners = new HashSet();
    ActivityReference<Activity> mForegroundActivity = ActivityReference.none();
    final LifecycleCallbacks mLifecycleCallbacks = new LifecycleCallbacks();
    final Set<OnPauseListener> mPauseListeners = new HashSet();
    final Set<OnResumeListener> mResumeListeners = new HashSet();
    final Set<OnStartListener> mStartListeners = new HashSet();
    final Set<OnStopListener> mStopListeners = new HashSet();

    public interface OnCreateListener {
        void onActivityCreate(Activity activity);
    }

    public interface OnDestroyListener {
        void onActivityDestroy(Activity activity);
    }

    public interface OnPauseListener {
        void onActivityPause(Activity activity);
    }

    public interface OnResumeListener {
        void onActivityResume(Activity activity);
    }

    public interface OnStartListener {
        void onActivityStart(Activity activity);
    }

    public interface OnStopListener {
        void onActivityStop(Activity activity);
    }

    public void register(Context context) {
        this.mApplication = (Application) context.getApplicationContext();
        this.mApplication.registerActivityLifecycleCallbacks(this.mLifecycleCallbacks);
    }

    public void unregister() {
        Application application = this.mApplication;
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(this.mLifecycleCallbacks);
            this.mApplication = null;
        }
    }

    public Activity getForegroundActivity() {
        return this.mForegroundActivity.get();
    }

    public void setForegroundActivity(Activity activity) {
        this.mForegroundActivity = ActivityReference.create(activity);
    }

    public ActivityTracker onCreate(OnCreateListener onCreateListener) {
        this.mCreateListeners.add(onCreateListener);
        return this;
    }

    public ActivityTracker removeOnCreate(OnCreateListener onCreateListener) {
        this.mCreateListeners.remove(onCreateListener);
        return this;
    }

    public ActivityTracker onStart(OnStartListener onStartListener) {
        this.mStartListeners.add(onStartListener);
        return this;
    }

    public ActivityTracker removeOnStart(OnStartListener onStartListener) {
        this.mStartListeners.remove(onStartListener);
        return this;
    }

    public ActivityTracker onResume(OnResumeListener onResumeListener) {
        this.mResumeListeners.add(onResumeListener);
        return this;
    }

    public ActivityTracker removeOnResume(OnResumeListener onResumeListener) {
        this.mResumeListeners.remove(onResumeListener);
        return this;
    }

    public ActivityTracker onPause(OnPauseListener onPauseListener) {
        this.mPauseListeners.add(onPauseListener);
        return this;
    }

    public ActivityTracker removeOnPause(OnPauseListener onPauseListener) {
        this.mPauseListeners.remove(onPauseListener);
        return this;
    }

    public ActivityTracker onDestroy(OnDestroyListener onDestroyListener) {
        this.mDestroyListeners.add(onDestroyListener);
        return this;
    }

    public ActivityTracker removeOnDestroy(OnDestroyListener onDestroyListener) {
        this.mDestroyListeners.remove(onDestroyListener);
        return this;
    }

    public ActivityTracker onStop(OnStopListener onStopListener) {
        this.mStopListeners.add(onStopListener);
        return this;
    }

    public ActivityTracker removeOnStop(OnStopListener onStopListener) {
        this.mStopListeners.remove(onStopListener);
        return this;
    }

    private class LifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        LifecycleCallbacks() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            for (OnCreateListener onActivityCreate : ActivityTracker.this.mCreateListeners) {
                onActivityCreate.onActivityCreate(activity);
            }
        }

        public void onActivityStarted(Activity activity) {
            for (OnStartListener onActivityStart : ActivityTracker.this.mStartListeners) {
                onActivityStart.onActivityStart(activity);
            }
        }

        public void onActivityResumed(Activity activity) {
            if (!ActivityTracker.this.mForegroundActivity.isPresent()) {
                ActivityTracker.this.mForegroundActivity = ActivityReference.create(activity);
                for (OnResumeListener onActivityResume : ActivityTracker.this.mResumeListeners) {
                    onActivityResume.onActivityResume(activity);
                }
                return;
            }
            ActivityTracker.log.info("Ignoring onActivityResume on {}. It is behind another activity.", activity);
        }

        public void onActivityPaused(Activity activity) {
            ActivityTracker.this.mForegroundActivity.clearIfSame(activity);
            for (OnPauseListener onActivityPause : ActivityTracker.this.mPauseListeners) {
                onActivityPause.onActivityPause(activity);
            }
        }

        public void onActivityStopped(Activity activity) {
            for (OnStopListener onActivityStop : ActivityTracker.this.mStopListeners) {
                onActivityStop.onActivityStop(activity);
            }
        }

        public void onActivityDestroyed(Activity activity) {
            for (OnDestroyListener onActivityDestroy : ActivityTracker.this.mDestroyListeners) {
                onActivityDestroy.onActivityDestroy(activity);
            }
        }
    }
}
