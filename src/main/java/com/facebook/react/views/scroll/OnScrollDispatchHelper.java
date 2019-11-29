package com.facebook.react.views.scroll;

import android.os.SystemClock;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;

public class OnScrollDispatchHelper {
    private static final int MIN_EVENT_SEPARATION_MS = 10;
    private long mLastScrollEventTimeMs = -11;
    private int mPrevX = RNCartPanelDataEntity.NULL_VALUE;
    private int mPrevY = RNCartPanelDataEntity.NULL_VALUE;
    private float mXFlingVelocity = BitmapDescriptorFactory.HUE_RED;
    private float mYFlingVelocity = BitmapDescriptorFactory.HUE_RED;

    public boolean onScrollChanged(int i, int i2) {
        long uptimeMillis = SystemClock.uptimeMillis();
        boolean z = (uptimeMillis - this.mLastScrollEventTimeMs <= 10 && this.mPrevX == i && this.mPrevY == i2) ? false : true;
        long j = this.mLastScrollEventTimeMs;
        if (uptimeMillis - j != 0) {
            this.mXFlingVelocity = ((float) (i - this.mPrevX)) / ((float) (uptimeMillis - j));
            this.mYFlingVelocity = ((float) (i2 - this.mPrevY)) / ((float) (uptimeMillis - j));
        }
        this.mLastScrollEventTimeMs = uptimeMillis;
        this.mPrevX = i;
        this.mPrevY = i2;
        return z;
    }

    public float getXFlingVelocity() {
        return this.mXFlingVelocity;
    }

    public float getYFlingVelocity() {
        return this.mYFlingVelocity;
    }
}
