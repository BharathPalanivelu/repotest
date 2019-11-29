package com.garena.rnrecyclerview.library.sticky.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;

public class InternalRecyclerView extends RecyclerView {
    public InternalRecyclerView(Context context) {
        super(context);
    }

    public InternalRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InternalRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(View.MeasureSpec.makeMeasureSpec(i, RNCartPanelDataEntity.NULL_VALUE)), View.MeasureSpec.getSize(View.MeasureSpec.makeMeasureSpec(i2, RNCartPanelDataEntity.NULL_VALUE)));
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!super.onInterceptTouchEvent(motionEvent)) {
            return false;
        }
        NativeGestureUtil.notifyNativeGestureStarted(this, motionEvent);
        return true;
    }
}
