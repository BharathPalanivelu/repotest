package com.salesforce.android.service.common.ui.internal.minimize;

import android.app.Activity;
import android.content.Context;
import com.salesforce.android.service.common.ui.internal.minimize.MinimizedViewManager;
import com.salesforce.android.service.common.utilities.activity.ActivityTracker;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.HashSet;
import java.util.Set;

public class Minimizer {
    static final Set<Class<? extends Activity>> IGNORED_ACTIVITIES = new HashSet();
    private MinimizeListener mMinimizeListener;
    private final MinimizedViewManager mMinimizedViewManager;

    public static void addIgnoredActivity(Class<? extends Activity> cls) {
        IGNORED_ACTIVITIES.add(cls);
    }

    public static void removeIgnoredActivity(Class<? extends Activity> cls) {
        IGNORED_ACTIVITIES.remove(cls);
    }

    Minimizer(Builder builder) {
        this.mMinimizedViewManager = builder.mMinimizedViewManager;
        this.mMinimizeListener = builder.mMinimizeListener;
    }

    public boolean isMinimized() {
        return this.mMinimizedViewManager.isMinimized();
    }

    public void attachTo(Activity activity) {
        this.mMinimizedViewManager.setAttachedTo(activity);
    }

    public Minimizer setMinimizeListener(MinimizeListener minimizeListener) {
        this.mMinimizeListener = minimizeListener;
        this.mMinimizedViewManager.setMinimizeListener(minimizeListener);
        return this;
    }

    public void show() {
        minimize();
        this.mMinimizedViewManager.show();
    }

    public void minimize() {
        if (!isMinimized() && this.mMinimizeListener != null) {
            this.mMinimizedViewManager.start(this);
            this.mMinimizeListener.onMinimize();
        }
    }

    public void maximize(Context context) {
        if (isMinimized()) {
            MinimizeListener minimizeListener = this.mMinimizeListener;
            if (minimizeListener != null) {
                minimizeListener.onMaximize(context);
            }
        }
    }

    public void stop() {
        this.mMinimizedViewManager.stop();
    }

    public void destroy() {
        this.mMinimizedViewManager.destroy();
    }

    public static class Builder {
        ActivityTracker mActivityTracker;
        Set<Class<? extends Activity>> mIgnoredActivitySet = new HashSet();
        MinimizeListener mMinimizeListener;
        MinimizedViewManager mMinimizedViewManager;

        public Builder minimizedViewManager(MinimizedViewManager minimizedViewManager) {
            this.mMinimizedViewManager = minimizedViewManager;
            return this;
        }

        public Builder activityTracker(ActivityTracker activityTracker) {
            this.mActivityTracker = activityTracker;
            return this;
        }

        public Builder listener(MinimizeListener minimizeListener) {
            this.mMinimizeListener = minimizeListener;
            return this;
        }

        public Builder addIgnoredActivity(Class<? extends Activity> cls) {
            this.mIgnoredActivitySet.add(cls);
            return this;
        }

        public Minimizer build() {
            Arguments.checkNotNull(this.mActivityTracker, "Activity tracker must be provided to the Minimizer");
            if (this.mMinimizedViewManager == null) {
                this.mMinimizedViewManager = new MinimizedViewManager.Builder().activityTracker(this.mActivityTracker).listener(this.mMinimizeListener).setIgnoredActivities(this.mIgnoredActivitySet).build();
            }
            return new Minimizer(this);
        }
    }
}
