package com.salesforce.android.service.common.ui.internal.minimize;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Build;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.spatial.Coordinate;
import com.salesforce.android.service.common.utilities.validation.Arguments;

class MinimizeViewDrag implements View.OnDragListener, View.OnTouchListener {
    private static final ServiceLogger log = ServiceLogging.getLogger(MinimizeViewDrag.class);
    private final int mAndroidSdkVersion;
    private final View mContainer;
    private boolean mDown;
    private float mDownX;
    private float mDownY;
    private boolean mDragging;
    private final Listener mListener;
    private final View mMinimizedView;
    private Coordinate mOffset;
    private Integer mTouchSlop;

    interface Listener {
        void onDroppedAtLocation(Coordinate coordinate);
    }

    MinimizeViewDrag(Builder builder) {
        this.mListener = builder.mListener;
        this.mMinimizedView = builder.mMinimizedView;
        this.mContainer = builder.mContainer;
        this.mAndroidSdkVersion = builder.mAndroidSdkVersion;
        this.mMinimizedView.setOnTouchListener(this);
        this.mContainer.setOnDragListener(this);
    }

    /* access modifiers changed from: package-private */
    public void teardown() {
        this.mMinimizedView.setOnTouchListener((View.OnTouchListener) null);
        this.mContainer.setOnDragListener((View.OnDragListener) null);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mDownX = motionEvent.getX();
            this.mDownY = motionEvent.getY();
            this.mDown = true;
        } else if (motionEvent.getAction() == 2 && this.mDown) {
            float x = motionEvent.getX() - this.mDownX;
            float y = motionEvent.getY() - this.mDownY;
            if (Math.sqrt((double) ((x * x) + (y * y))) > ((double) getTouchSlop(view).intValue())) {
                this.mOffset = Coordinate.create(Math.max((int) motionEvent.getX(), 0), Math.max((int) motionEvent.getY(), 0));
                this.mDragging = true;
                startDrag(view, (ClipData) null, new ShadowBuilder(view, this.mOffset), (Object) null, 0);
                this.mDown = false;
            }
        }
        return false;
    }

    public boolean onDrag(View view, DragEvent dragEvent) {
        if (!this.mDragging) {
            return false;
        }
        int action = dragEvent.getAction();
        if (action == 1) {
            this.mMinimizedView.setVisibility(4);
        } else if (action == 3) {
            if (this.mOffset == null) {
                this.mOffset = Coordinate.create(0, 0);
            }
            float x = dragEvent.getX() - ((float) this.mOffset.getX());
            float y = dragEvent.getY() - ((float) this.mOffset.getY());
            log.trace("Minimized view dropped at {} {}", Float.valueOf(x), Float.valueOf(y));
            this.mMinimizedView.setX(x);
            this.mMinimizedView.setY(y);
            Listener listener = this.mListener;
            if (listener != null) {
                listener.onDroppedAtLocation(Coordinate.create((int) x, (int) y));
            }
        } else if (action == 4) {
            this.mMinimizedView.setAlpha(0.5f);
            this.mMinimizedView.setVisibility(0);
            this.mMinimizedView.animate().alpha(1.0f).setDuration(100).start();
            this.mDragging = false;
        }
        return true;
    }

    private Integer getTouchSlop(View view) {
        if (this.mTouchSlop == null) {
            this.mTouchSlop = Integer.valueOf(ViewConfiguration.get(view.getContext()).getScaledTouchSlop());
        }
        return this.mTouchSlop;
    }

    @TargetApi(24)
    private void startDrag(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i) {
        if (this.mAndroidSdkVersion >= 24) {
            view.startDragAndDrop(clipData, dragShadowBuilder, obj, i);
        } else {
            view.startDrag(clipData, dragShadowBuilder, obj, i);
        }
    }

    static class ShadowBuilder extends View.DragShadowBuilder {
        Coordinate mOffset;

        ShadowBuilder(View view, Coordinate coordinate) {
            super(view);
            this.mOffset = coordinate;
        }

        public void onDrawShadow(Canvas canvas) {
            getView().draw(canvas);
        }

        public void onProvideShadowMetrics(Point point, Point point2) {
            point.set(getView().getWidth(), getView().getHeight());
            point2.set(this.mOffset.getX(), this.mOffset.getY());
        }
    }

    static class Builder {
        int mAndroidSdkVersion = Build.VERSION.SDK_INT;
        View mContainer;
        Listener mListener;
        View mMinimizedView;

        Builder() {
        }

        /* access modifiers changed from: package-private */
        public Builder container(View view) {
            this.mContainer = view;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder minimizedView(View view) {
            this.mMinimizedView = view;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder listener(Listener listener) {
            this.mListener = listener;
            return this;
        }

        /* access modifiers changed from: package-private */
        public MinimizeViewDrag build() {
            Arguments.checkNotNull(this.mContainer, "Builder must be provided with a container view");
            Arguments.checkNotNull(this.mMinimizedView, "Builder must be provided with the minimized view");
            return new MinimizeViewDrag(this);
        }
    }
}
