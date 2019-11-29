package com.salesforce.android.service.common.ui.internal.minimize;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.salesforce.android.service.common.ui.internal.minimize.MinimizedViewHolder;
import com.salesforce.android.service.common.utilities.activity.ActivityReference;
import com.salesforce.android.service.common.utilities.activity.ActivityTracker;
import com.salesforce.android.service.common.utilities.functional.Consumer;
import com.salesforce.android.service.common.utilities.spatial.Coordinate;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.HashSet;
import java.util.Set;

class MinimizedViewManager implements MinimizedViewHolder.Listener, ActivityTracker.OnPauseListener, ActivityTracker.OnResumeListener {
    final ActivityTracker mActivityTracker;
    ActivityReference<Activity> mAttachedTo = ActivityReference.none();
    final Set<Class<? extends Activity>> mIgnoredActivitySet;
    final MinimizedViewHolder.Factory mMinViewFactory;
    MinimizeListener mMinimizeListener;
    MinimizedViewHolder mMinimizedViewHolder;
    Coordinate mMinimizedViewLocation;
    Minimizer mMinimizer;

    MinimizedViewManager(Builder builder) {
        this.mActivityTracker = builder.mActivityTracker;
        this.mMinimizeListener = builder.mMinimizeListener;
        this.mMinViewFactory = builder.mMinViewFactory;
        this.mIgnoredActivitySet = builder.mIgnoredActivitySet;
    }

    /* access modifiers changed from: package-private */
    public void setMinimizeListener(MinimizeListener minimizeListener) {
        this.mMinimizeListener = minimizeListener;
    }

    /* access modifiers changed from: package-private */
    public void start(Minimizer minimizer) {
        this.mActivityTracker.onResume(this);
        this.mActivityTracker.onPause(this);
        this.mMinimizer = minimizer;
    }

    /* access modifiers changed from: package-private */
    public void show() {
        ActivityReference<Activity> activityReference = this.mAttachedTo;
        Activity foregroundActivity = (activityReference == null || activityReference.get() == null) ? this.mActivityTracker.getForegroundActivity() : this.mAttachedTo.get();
        setAttachedTo(foregroundActivity);
        if (foregroundActivity != null && !this.mIgnoredActivitySet.contains(foregroundActivity.getClass()) && !Minimizer.IGNORED_ACTIVITIES.contains(foregroundActivity.getClass())) {
            createMinView(foregroundActivity);
        }
    }

    /* access modifiers changed from: package-private */
    public void setAttachedTo(Activity activity) {
        this.mAttachedTo = ActivityReference.create(activity);
    }

    /* access modifiers changed from: package-private */
    public boolean isMinimized() {
        return this.mMinimizedViewHolder != null && this.mAttachedTo.isPresent();
    }

    /* access modifiers changed from: package-private */
    public void stop() {
        setMinimizedViewHolder((MinimizedViewHolder) null);
        cleanup();
    }

    /* access modifiers changed from: package-private */
    public void destroy() {
        stop();
    }

    public void onActivityResume(Activity activity) {
        setAttachedTo(activity);
        if (activity != null && !this.mIgnoredActivitySet.contains(activity.getClass()) && !Minimizer.IGNORED_ACTIVITIES.contains(activity.getClass())) {
            createMinView(activity);
        }
    }

    public void onActivityPause(Activity activity) {
        if (this.mAttachedTo.is(activity)) {
            MinimizedViewHolder minimizedViewHolder = this.mMinimizedViewHolder;
            if (minimizedViewHolder != null) {
                minimizedViewHolder.detachImmediate();
                this.mMinimizedViewHolder = null;
            }
        }
        this.mAttachedTo.clearIfSame(activity);
    }

    public void onViewInflated(View view) {
        if (this.mMinimizeListener != null) {
            final ViewGroup viewGroup = (ViewGroup) view;
            viewGroup.removeAllViews();
            this.mAttachedTo.ifPresent(new Consumer<Activity>() {
                public void consume(Activity activity) {
                    MinimizedViewManager.this.mMinimizeListener.onCreate(viewGroup, activity);
                }
            });
        }
    }

    public void onViewClicked(View view) {
        if (this.mMinimizer != null) {
            this.mAttachedTo.ifPresent(new Consumer<Activity>() {
                public void consume(Activity activity) {
                    MinimizedViewManager.this.mMinimizer.maximize(activity);
                }
            });
        }
    }

    public void onCloseClicked(View view) {
        MinimizeListener minimizeListener = this.mMinimizeListener;
        if (minimizeListener != null) {
            minimizeListener.onCloseClicked();
        }
    }

    public void onAttachedAndMeasured(View view) {
        Coordinate coordinate = this.mMinimizedViewLocation;
        if (coordinate != null) {
            MinimizedViewHolder minimizedViewHolder = this.mMinimizedViewHolder;
            if (minimizedViewHolder != null) {
                this.mMinimizedViewLocation = boundToWindow(coordinate, minimizedViewHolder);
                this.mMinimizedViewHolder.moveTo(this.mMinimizedViewLocation);
            }
        }
    }

    public void onDroppedAtLocation(Coordinate coordinate) {
        if (coordinate != null) {
            MinimizedViewHolder minimizedViewHolder = this.mMinimizedViewHolder;
            if (minimizedViewHolder != null) {
                this.mMinimizedViewLocation = boundToWindow(coordinate, minimizedViewHolder);
                if (!this.mMinimizedViewLocation.equals(coordinate)) {
                    this.mMinimizedViewHolder.animateTo(this.mMinimizedViewLocation);
                }
                this.mMinimizeListener.onDropped(coordinate);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void createMinView(Activity activity) {
        MinimizedViewHolder create = this.mMinViewFactory.create(activity, this);
        create.attachTo(activity, this.mMinimizedViewLocation);
        setMinimizedViewHolder(create);
    }

    private void setMinimizedViewHolder(MinimizedViewHolder minimizedViewHolder) {
        MinimizedViewHolder minimizedViewHolder2 = this.mMinimizedViewHolder;
        if (minimizedViewHolder2 != null) {
            minimizedViewHolder2.detachImmediate();
        }
        this.mMinimizedViewHolder = minimizedViewHolder;
    }

    private void cleanup() {
        this.mActivityTracker.removeOnResume(this);
        this.mActivityTracker.removeOnPause(this);
        this.mAttachedTo.clear();
        this.mMinimizer = null;
    }

    static Coordinate boundToWindow(Coordinate coordinate, MinimizedViewHolder minimizedViewHolder) {
        ViewGroup container = minimizedViewHolder.getContainer();
        ViewGroup minimizedView = minimizedViewHolder.getMinimizedView();
        int max = Math.max(coordinate.getX(), 0);
        int max2 = Math.max(coordinate.getY(), 0);
        if (minimizedView.getWidth() + max > container.getWidth()) {
            max = container.getWidth() - minimizedView.getWidth();
        }
        if (minimizedView.getHeight() + max2 > container.getHeight()) {
            max2 = container.getHeight() - minimizedView.getHeight();
        }
        if (max == coordinate.getX() && max2 == coordinate.getY()) {
            return coordinate;
        }
        return Coordinate.create(max, max2);
    }

    static class Builder {
        ActivityTracker mActivityTracker;
        Set<Class<? extends Activity>> mIgnoredActivitySet = new HashSet();
        MinimizedViewHolder.Factory mMinViewFactory = new MinimizedViewHolder.Factory();
        MinimizeListener mMinimizeListener;

        Builder() {
        }

        /* access modifiers changed from: package-private */
        public Builder activityTracker(ActivityTracker activityTracker) {
            this.mActivityTracker = activityTracker;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder listener(MinimizeListener minimizeListener) {
            this.mMinimizeListener = minimizeListener;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder minViewHolderFactory(MinimizedViewHolder.Factory factory) {
            this.mMinViewFactory = factory;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder setIgnoredActivities(Set<Class<? extends Activity>> set) {
            this.mIgnoredActivitySet.addAll(set);
            return this;
        }

        /* access modifiers changed from: package-private */
        public MinimizedViewManager build() {
            Arguments.checkNotNull(this.mActivityTracker, "ActivityTracker must be provided to the MinimizedViewManager");
            return new MinimizedViewManager(this);
        }
    }
}
