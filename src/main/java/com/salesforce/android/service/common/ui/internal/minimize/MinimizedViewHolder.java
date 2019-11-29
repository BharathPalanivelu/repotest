package com.salesforce.android.service.common.ui.internal.minimize;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.salesforce.android.service.common.ui.R;
import com.salesforce.android.service.common.ui.internal.minimize.MinimizeViewDrag;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.spatial.Coordinate;

class MinimizedViewHolder implements View.OnAttachStateChangeListener, View.OnLayoutChangeListener {
    private static final ServiceLogger log = ServiceLogging.getLogger(MinimizedViewHolder.class);
    final ViewGroup mContainer;
    final Listener mListener;
    final MinimizeViewDrag mMinimizeViewDrag;
    final ViewGroup mMinimizedView;
    final View mThumbnailView;

    interface Listener extends MinimizeViewDrag.Listener {
        void onAttachedAndMeasured(View view);

        void onCloseClicked(View view);

        void onViewClicked(View view);

        void onViewInflated(View view);
    }

    MinimizedViewHolder(Builder builder) {
        this.mContainer = builder.mContainer;
        this.mMinimizedView = builder.mMinimizedView;
        this.mListener = builder.mListener;
        this.mMinimizeViewDrag = builder.mMinimizeViewDrag;
        this.mThumbnailView = builder.mThumbnailView;
        initializeListeners();
    }

    /* access modifiers changed from: package-private */
    public void initializeListeners() {
        this.mMinimizedView.addOnAttachStateChangeListener(this);
        this.mMinimizedView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MinimizedViewHolder.this.mListener.onViewClicked(view);
            }
        });
        this.mContainer.findViewById(R.id.common_minview_close).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MinimizedViewHolder.this.mListener.onCloseClicked(view);
            }
        });
        this.mListener.onViewInflated(this.mThumbnailView);
    }

    /* access modifiers changed from: package-private */
    public void attachTo(Activity activity, Coordinate coordinate) {
        detachImmediate();
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (viewGroup != null) {
            viewGroup.addView(this.mContainer);
        } else {
            log.warn("Couldn't find android.R.id.content in {}. Are you calling Activity.setContentView and AppCompatDelegate.setContentView?", activity.getClass().getSimpleName());
            ((ViewGroup) activity.getWindow().getDecorView()).addView(this.mContainer);
        }
        if (coordinate != null) {
            log.trace("Setting minimized location to {} {}", Integer.valueOf(coordinate.getX()), Integer.valueOf(coordinate.getY()));
            this.mMinimizedView.setX((float) coordinate.getX());
            this.mMinimizedView.setY((float) coordinate.getY());
            ((FrameLayout.LayoutParams) this.mMinimizedView.getLayoutParams()).gravity = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public void detachImmediate() {
        ViewGroup viewGroup = (ViewGroup) this.mContainer.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.mContainer);
        }
    }

    /* access modifiers changed from: package-private */
    public void animateDetach() {
        ViewPropertyAnimator scaleY = this.mMinimizedView.animate().setDuration(250).alpha(BitmapDescriptorFactory.HUE_RED).scaleX(BitmapDescriptorFactory.HUE_RED).scaleY(BitmapDescriptorFactory.HUE_RED);
        scaleY.setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                MinimizedViewHolder.this.detachImmediate();
                MinimizedViewHolder.this.mMinimizedView.setScaleX(1.0f);
                MinimizedViewHolder.this.mMinimizedView.setScaleY(1.0f);
                MinimizedViewHolder.this.mMinimizedView.setAlpha(1.0f);
            }
        });
        scaleY.start();
    }

    /* access modifiers changed from: package-private */
    public void moveTo(Coordinate coordinate) {
        log.trace("Setting minimized location to {} {}", Integer.valueOf(coordinate.getX()), Integer.valueOf(coordinate.getY()));
        this.mMinimizedView.setX((float) coordinate.getX());
        this.mMinimizedView.setY((float) coordinate.getY());
    }

    /* access modifiers changed from: package-private */
    public void animateTo(Coordinate coordinate) {
        this.mMinimizedView.animate().x((float) coordinate.getX()).y((float) coordinate.getY()).setDuration(250).start();
    }

    /* access modifiers changed from: package-private */
    public void notifyListenerOnViewChange(final View view) {
        view.post(new Runnable() {
            public void run() {
                MinimizedViewHolder.this.mListener.onAttachedAndMeasured(view);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public ViewGroup getContainer() {
        return this.mContainer;
    }

    /* access modifiers changed from: package-private */
    public ViewGroup getMinimizedView() {
        return this.mMinimizedView;
    }

    /* access modifiers changed from: package-private */
    public View getThumbnailView() {
        return this.mThumbnailView;
    }

    public void onViewAttachedToWindow(View view) {
        notifyListenerOnViewChange(view);
        this.mMinimizedView.addOnLayoutChangeListener(this);
    }

    public void onViewDetachedFromWindow(View view) {
        this.mMinimizedView.removeOnAttachStateChangeListener(this);
        this.mMinimizedView.removeOnLayoutChangeListener(this);
        this.mMinimizedView.setOnClickListener((View.OnClickListener) null);
        this.mMinimizeViewDrag.teardown();
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        notifyListenerOnViewChange(view);
    }

    static class Builder {
        ViewGroup mContainer;
        Listener mListener;
        MinimizeViewDrag mMinimizeViewDrag;
        ViewGroup mMinimizedView;
        View mThumbnailView;

        Builder() {
        }

        /* access modifiers changed from: package-private */
        public Builder container(ViewGroup viewGroup) {
            this.mContainer = viewGroup;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder minimizedView(ViewGroup viewGroup) {
            this.mMinimizedView = viewGroup;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder thumbnailView(View view) {
            this.mThumbnailView = view;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder listener(Listener listener) {
            this.mListener = listener;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder minimizeViewDrag(MinimizeViewDrag minimizeViewDrag) {
            this.mMinimizeViewDrag = minimizeViewDrag;
            return this;
        }

        /* access modifiers changed from: package-private */
        public MinimizedViewHolder build(Activity activity) {
            if (this.mContainer == null) {
                this.mContainer = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.minimized_container, (ViewGroup) activity.getWindow().getDecorView(), false);
                ((FrameLayout.LayoutParams) this.mContainer.getLayoutParams()).gravity = 0;
            }
            if (this.mMinimizedView == null) {
                this.mMinimizedView = (ViewGroup) this.mContainer.findViewById(R.id.salesforce_minview_thumbnail);
            }
            if (this.mThumbnailView == null) {
                this.mThumbnailView = this.mMinimizedView.findViewById(R.id.common_minview_content);
            }
            if (this.mMinimizeViewDrag == null) {
                this.mMinimizeViewDrag = new MinimizeViewDrag.Builder().container(this.mContainer).minimizedView(this.mMinimizedView).listener(this.mListener).build();
            }
            return new MinimizedViewHolder(this);
        }
    }

    static class Factory {
        Factory() {
        }

        /* access modifiers changed from: package-private */
        public MinimizedViewHolder create(Activity activity, Listener listener) {
            return new Builder().listener(listener).build(activity);
        }
    }
}
