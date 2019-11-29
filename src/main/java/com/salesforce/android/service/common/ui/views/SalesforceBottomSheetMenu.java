package com.salesforce.android.service.common.ui.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class SalesforceBottomSheetMenu extends LinearLayout {
    protected BottomSheetBehavior<SalesforceBottomSheetMenu> mBehavior;
    protected OnVisibilityChangedListener mOnVisibilityChangedListener;

    public interface Adapter {
        int getItemCount();

        View onCreateMenuItem(SalesforceBottomSheetMenu salesforceBottomSheetMenu, int i);
    }

    public interface OnVisibilityChangedListener {
        void onVisibilityChanged(boolean z);
    }

    public SalesforceBottomSheetMenu(Context context) {
        this(context, (AttributeSet) null);
    }

    public SalesforceBottomSheetMenu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SalesforceBottomSheetMenu(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    @SuppressLint({"CustomViewStyleable"})
    public SalesforceBottomSheetMenu(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        setOrientation(1);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mBehavior = BottomSheetBehavior.b(this);
        this.mBehavior.a((BottomSheetBehavior.a) new BottomSheetBehavior.a() {
            public void onSlide(View view, float f2) {
            }

            public void onStateChanged(View view, int i) {
                if (SalesforceBottomSheetMenu.this.mOnVisibilityChangedListener != null) {
                    SalesforceBottomSheetMenu.this.mOnVisibilityChangedListener.onVisibilityChanged(i == 3);
                }
            }
        });
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        BottomSheetBehavior<SalesforceBottomSheetMenu> bottomSheetBehavior = this.mBehavior;
        if (bottomSheetBehavior != null && bottomSheetBehavior.b() == 3 && ((float) this.mBehavior.a()) < motionEvent.getY() && motionEvent.getAction() == 1) {
            postDelayed(new Runnable() {
                public void run() {
                    SalesforceBottomSheetMenu.this.collapse();
                }
            }, 200);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setAdapter(Adapter adapter) {
        removeAllViews();
        for (int i = 0; i < adapter.getItemCount(); i++) {
            addView(adapter.onCreateMenuItem(this, i));
        }
    }

    public void setOnVisibilityChangedListener(OnVisibilityChangedListener onVisibilityChangedListener) {
        this.mOnVisibilityChangedListener = onVisibilityChangedListener;
    }

    public boolean isVisible() {
        BottomSheetBehavior<SalesforceBottomSheetMenu> bottomSheetBehavior = this.mBehavior;
        return bottomSheetBehavior != null && bottomSheetBehavior.b() == 3;
    }

    public void show() {
        BottomSheetBehavior<SalesforceBottomSheetMenu> bottomSheetBehavior = this.mBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.b(3);
        }
    }

    public void collapse() {
        BottomSheetBehavior<SalesforceBottomSheetMenu> bottomSheetBehavior = this.mBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.b(4);
        }
    }

    public void toggleVisibility() {
        if (isVisible()) {
            collapse();
        } else {
            show();
        }
    }
}
