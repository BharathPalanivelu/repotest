package com.modiface.mfemakeupkit.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.core.g.c;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.modiface.mfemakeupkit.MFEMakeupEngine;
import com.modiface.mfemakeupkit.utils.n;

public class MFEBeforeAfterMakeupView extends RelativeLayout {
    protected static final int DefaultDividerColor = -65536;
    protected static final int DefaultDividerWidthInDp = 2;
    protected MFEMakeupView mBackgroundMakeupView;
    protected BeforeViewSide mBeforeViewSide = BeforeViewSide.LEFT;
    protected float mBeforeVisibleAmount = 0.5f;
    protected MFEMakeupView mCroppedMakeupView;
    protected Paint mDividerPaint = new Paint();
    protected View mOverlayView;
    protected c mOverlayViewGestureDetector;
    protected ScrollView mScrollView;
    protected FrameLayout mScrollViewContainer;
    protected boolean mShowBefore = true;

    public enum BeforeViewSide {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM
    }

    protected class a extends GestureDetector.SimpleOnGestureListener {
        protected a() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0022, code lost:
            if (r0 == com.modiface.mfemakeupkit.widgets.MFEBeforeAfterMakeupView.BeforeViewSide.BOTTOM) goto L_0x0037;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0035, code lost:
            if (r0 == com.modiface.mfemakeupkit.widgets.MFEBeforeAfterMakeupView.BeforeViewSide.RIGHT) goto L_0x0037;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(android.view.MotionEvent r4) {
            /*
                r3 = this;
                if (r4 != 0) goto L_0x0003
                return
            L_0x0003:
                com.modiface.mfemakeupkit.widgets.MFEBeforeAfterMakeupView r0 = com.modiface.mfemakeupkit.widgets.MFEBeforeAfterMakeupView.this
                com.modiface.mfemakeupkit.widgets.MFEBeforeAfterMakeupView$BeforeViewSide r0 = r0.mBeforeViewSide
                com.modiface.mfemakeupkit.widgets.MFEBeforeAfterMakeupView$BeforeViewSide r1 = com.modiface.mfemakeupkit.widgets.MFEBeforeAfterMakeupView.BeforeViewSide.LEFT
                r2 = 1065353216(0x3f800000, float:1.0)
                if (r0 == r1) goto L_0x0025
                com.modiface.mfemakeupkit.widgets.MFEBeforeAfterMakeupView$BeforeViewSide r1 = com.modiface.mfemakeupkit.widgets.MFEBeforeAfterMakeupView.BeforeViewSide.RIGHT
                if (r0 != r1) goto L_0x0012
                goto L_0x0025
            L_0x0012:
                float r4 = r4.getY()
                com.modiface.mfemakeupkit.widgets.MFEBeforeAfterMakeupView r1 = com.modiface.mfemakeupkit.widgets.MFEBeforeAfterMakeupView.this
                android.view.View r1 = r1.mOverlayView
                int r1 = r1.getHeight()
                float r1 = (float) r1
                float r4 = r4 / r1
                com.modiface.mfemakeupkit.widgets.MFEBeforeAfterMakeupView$BeforeViewSide r1 = com.modiface.mfemakeupkit.widgets.MFEBeforeAfterMakeupView.BeforeViewSide.BOTTOM
                if (r0 != r1) goto L_0x0039
                goto L_0x0037
            L_0x0025:
                float r4 = r4.getX()
                com.modiface.mfemakeupkit.widgets.MFEBeforeAfterMakeupView r1 = com.modiface.mfemakeupkit.widgets.MFEBeforeAfterMakeupView.this
                android.view.View r1 = r1.mOverlayView
                int r1 = r1.getWidth()
                float r1 = (float) r1
                float r4 = r4 / r1
                com.modiface.mfemakeupkit.widgets.MFEBeforeAfterMakeupView$BeforeViewSide r1 = com.modiface.mfemakeupkit.widgets.MFEBeforeAfterMakeupView.BeforeViewSide.RIGHT
                if (r0 != r1) goto L_0x0039
            L_0x0037:
                float r4 = r2 - r4
            L_0x0039:
                r0 = 0
                int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r0 < 0) goto L_0x0047
                int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r0 > 0) goto L_0x0047
                com.modiface.mfemakeupkit.widgets.MFEBeforeAfterMakeupView r0 = com.modiface.mfemakeupkit.widgets.MFEBeforeAfterMakeupView.this
                r0.setBeforeVisibleAmount(r4)
            L_0x0047:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.modiface.mfemakeupkit.widgets.MFEBeforeAfterMakeupView.a.a(android.view.MotionEvent):void");
        }

        public boolean onDown(MotionEvent motionEvent) {
            a(motionEvent);
            return true;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            a(motionEvent2);
            return true;
        }
    }

    public MFEBeforeAfterMakeupView(Context context) {
        super(context);
        init(context);
    }

    private MFEMakeupView getAfterMakeupView() {
        BeforeViewSide beforeViewSide = this.mBeforeViewSide;
        if (beforeViewSide == BeforeViewSide.LEFT || beforeViewSide == BeforeViewSide.TOP) {
            return this.mBackgroundMakeupView;
        }
        return this.mCroppedMakeupView;
    }

    private MFEMakeupView getBeforeMakeupView() {
        BeforeViewSide beforeViewSide = this.mBeforeViewSide;
        if (beforeViewSide == BeforeViewSide.LEFT || beforeViewSide == BeforeViewSide.TOP) {
            return this.mCroppedMakeupView;
        }
        return this.mBackgroundMakeupView;
    }

    private void init(Context context) {
        this.mDividerPaint.setStyle(Paint.Style.STROKE);
        this.mDividerPaint.setAntiAlias(true);
        this.mDividerPaint.setColor(DefaultDividerColor);
        this.mDividerPaint.setStrokeWidth((float) n.a(context, 2));
        this.mOverlayViewGestureDetector = new c(context, new a());
        this.mCroppedMakeupView = new MFEMakeupView(context);
        this.mBackgroundMakeupView = new MFEMakeupView(context);
        this.mScrollView = new ScrollView(context);
        this.mScrollViewContainer = new FrameLayout(context);
        this.mOverlayView = new a(this, context);
        this.mScrollView.setFillViewport(true);
        this.mScrollView.setSmoothScrollingEnabled(false);
        this.mScrollView.setOverScrollMode(2);
        this.mScrollView.setHorizontalScrollBarEnabled(false);
        this.mScrollView.setVerticalScrollBarEnabled(false);
        this.mOverlayView.addOnLayoutChangeListener(new b(this));
        this.mOverlayView.setOnTouchListener(new c(this));
        this.mScrollViewContainer.addView(this.mCroppedMakeupView, new ViewGroup.LayoutParams(1, 1));
        this.mScrollView.addView(this.mScrollViewContainer, new ViewGroup.LayoutParams(-2, -2));
        addView(this.mBackgroundMakeupView, new RelativeLayout.LayoutParams(-1, -1));
        addView(this.mScrollView, new RelativeLayout.LayoutParams(-1, -1));
        addView(this.mOverlayView, new RelativeLayout.LayoutParams(-1, -1));
        setBeforeViewSide(this.mBeforeViewSide);
        setBeforeVisibleAmount(this.mBeforeVisibleAmount);
    }

    /* access modifiers changed from: protected */
    public void drawOnOverlayView(Canvas canvas) {
        if (this.mShowBefore) {
            float f2 = this.mBeforeVisibleAmount;
            BeforeViewSide beforeViewSide = this.mBeforeViewSide;
            float width = (float) this.mOverlayView.getWidth();
            float height = (float) this.mOverlayView.getHeight();
            float paddingLeft = (float) this.mOverlayView.getPaddingLeft();
            float paddingTop = (float) this.mOverlayView.getPaddingTop();
            float paddingRight = width - ((float) this.mOverlayView.getPaddingRight());
            float paddingBottom = height - ((float) this.mOverlayView.getPaddingBottom());
            Paint paint = this.mDividerPaint;
            int i = d.f15466a[beforeViewSide.ordinal()];
            if (i == 1) {
                float f3 = f2 * width;
                canvas.drawLine(f3, paddingTop, f3, paddingBottom, paint);
            } else if (i == 2) {
                float f4 = (1.0f - f2) * width;
                canvas.drawLine(f4, paddingTop, f4, paddingBottom, paint);
            } else if (i == 3) {
                float f5 = f2 * height;
                canvas.drawLine(paddingLeft, f5, paddingRight, f5, paint);
            } else if (i == 4) {
                float f6 = (1.0f - f2) * height;
                canvas.drawLine(paddingLeft, f6, paddingRight, f6, paint);
            }
        }
    }

    public boolean isBeforeViewVisible() {
        return getBeforeMakeupView().getVisibility() == 0;
    }

    /* access modifiers changed from: protected */
    public void overlayViewOnTouch(View view, MotionEvent motionEvent) {
        this.mOverlayViewGestureDetector.a(motionEvent);
    }

    public void setAfterViewZoomArea(MFEMakeupZoomArea mFEMakeupZoomArea) {
        getAfterMakeupView().setZoomArea(mFEMakeupZoomArea);
    }

    public void setBeforeViewSide(BeforeViewSide beforeViewSide) {
        if (beforeViewSide != null) {
            this.mBeforeViewSide = beforeViewSide;
            getBeforeMakeupView().setShowBefore(true);
            getAfterMakeupView().setShowBefore(false);
            updateSplit();
            return;
        }
        throw new IllegalArgumentException("Cannot set a null before view side");
    }

    public void setBeforeViewVisible(boolean z) {
        this.mShowBefore = z;
        updateSplit();
    }

    public void setBeforeViewZoomArea(MFEMakeupZoomArea mFEMakeupZoomArea) {
        getBeforeMakeupView().setZoomArea(mFEMakeupZoomArea);
    }

    public void setBeforeVisibleAmount(float f2) {
        if (f2 < BitmapDescriptorFactory.HUE_RED || f2 > 1.0f) {
            throw new IllegalArgumentException("Cannot set the before visible amount outside of range [0.0, 1.0]");
        }
        this.mBeforeVisibleAmount = f2;
        updateSplit();
    }

    public void setDividerColor(int i) {
        this.mDividerPaint.setColor(i);
        this.mOverlayView.invalidate();
    }

    public void setDividerWidth(float f2) {
        this.mDividerPaint.setStrokeWidth(f2);
        this.mOverlayView.invalidate();
    }

    public void setZoomArea(MFEMakeupZoomArea mFEMakeupZoomArea) {
        setBeforeViewZoomArea(mFEMakeupZoomArea);
        setAfterViewZoomArea(mFEMakeupZoomArea);
    }

    public void setup(MFEMakeupEngine mFEMakeupEngine) {
        if (mFEMakeupEngine != null) {
            mFEMakeupEngine.attachMakeupView(this.mCroppedMakeupView);
            mFEMakeupEngine.attachMakeupView(this.mBackgroundMakeupView);
            return;
        }
        throw new IllegalArgumentException("Cannot setup with a null makeup engine");
    }

    /* access modifiers changed from: protected */
    public void updateSplit() {
        float f2 = this.mBeforeVisibleAmount;
        BeforeViewSide beforeViewSide = this.mBeforeViewSide;
        boolean z = this.mShowBefore;
        getBeforeMakeupView().setVisibility(z ? 0 : 8);
        getAfterMakeupView().setVisibility(0);
        if (!z && getAfterMakeupView() == this.mCroppedMakeupView) {
            f2 = BitmapDescriptorFactory.HUE_RED;
        }
        float width = (float) this.mOverlayView.getWidth();
        float height = (float) this.mOverlayView.getHeight();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mScrollView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        layoutParams.width = -1;
        layoutParams.height = -1;
        int i = d.f15466a[beforeViewSide.ordinal()];
        if (i == 1) {
            layoutParams.width = Math.round(f2 * width);
        } else if (i == 2) {
            layoutParams.width = Math.round((1.0f - f2) * width);
        } else if (i == 3) {
            layoutParams.height = Math.round(f2 * height);
        } else if (i == 4) {
            layoutParams.height = Math.round((1.0f - f2) * height);
        }
        this.mScrollView.setLayoutParams(layoutParams);
        requestLayout();
        this.mScrollView.invalidate();
        this.mOverlayView.invalidate();
    }

    public MFEBeforeAfterMakeupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public MFEBeforeAfterMakeupView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
