package com.facebook.react.views.swiperefresh;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class ReactSwipeRefreshLayout extends SwipeRefreshLayout {
    private static final float DEFAULT_CIRCLE_TARGET = 64.0f;
    private boolean mDidLayout = false;
    private boolean mIntercepted;
    private float mPrevTouchX;
    private float mProgressViewOffset = BitmapDescriptorFactory.HUE_RED;
    private boolean mRefreshing = false;
    private int mTouchSlop;

    public ReactSwipeRefreshLayout(ReactContext reactContext) {
        super(reactContext);
        this.mTouchSlop = ViewConfiguration.get(reactContext).getScaledTouchSlop();
    }

    public void setRefreshing(boolean z) {
        this.mRefreshing = z;
        if (this.mDidLayout) {
            super.setRefreshing(z);
        }
    }

    public void setProgressViewOffset(float f2) {
        this.mProgressViewOffset = f2;
        if (this.mDidLayout) {
            int progressCircleDiameter = getProgressCircleDiameter();
            setProgressViewOffset(false, Math.round(PixelUtil.toPixelFromDIP(f2)) - progressCircleDiameter, Math.round(PixelUtil.toPixelFromDIP(f2 + DEFAULT_CIRCLE_TARGET) - ((float) progressCircleDiameter)));
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.mDidLayout) {
            this.mDidLayout = true;
            setProgressViewOffset(this.mProgressViewOffset);
            setRefreshing(this.mRefreshing);
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!shouldInterceptTouchEvent(motionEvent) || !super.onInterceptTouchEvent(motionEvent)) {
            return false;
        }
        NativeGestureUtil.notifyNativeGestureStarted(this, motionEvent);
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return true;
    }

    private boolean shouldInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mPrevTouchX = motionEvent.getX();
            this.mIntercepted = false;
        } else if (action == 2) {
            float abs = Math.abs(motionEvent.getX() - this.mPrevTouchX);
            if (this.mIntercepted || abs > ((float) this.mTouchSlop)) {
                this.mIntercepted = true;
                return false;
            }
        }
        return true;
    }
}
