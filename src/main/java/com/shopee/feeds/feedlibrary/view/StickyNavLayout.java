package com.shopee.feeds.feedlibrary.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import androidx.core.g.n;
import androidx.core.g.w;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.feeds.feedlibrary.c;
import com.tencent.ijk.media.player.IjkMediaCodecInfo;

public class StickyNavLayout extends LinearLayout implements n {

    /* renamed from: a  reason: collision with root package name */
    private int f28486a = 3;

    /* renamed from: b  reason: collision with root package name */
    private View f28487b;

    /* renamed from: c  reason: collision with root package name */
    private View f28488c;

    /* renamed from: d  reason: collision with root package name */
    private ViewPager f28489d;

    /* renamed from: e  reason: collision with root package name */
    private int f28490e;

    /* renamed from: f  reason: collision with root package name */
    private OverScroller f28491f;

    /* renamed from: g  reason: collision with root package name */
    private ValueAnimator f28492g;
    private Interpolator h;
    private int i;
    private int j;
    private int k;

    public int getNestedScrollAxes() {
        return 0;
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return true;
    }

    public void onStopNestedScroll(View view) {
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        boolean z = i3 > 0 && getScrollY() < this.f28490e;
        boolean z2 = i3 < 0 && getScrollY() >= 0 && !w.b(view, -1);
        if (z || z2) {
            scrollBy(0, i3);
            iArr[1] = i3;
        }
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        if ((view instanceof RecyclerView) && f3 < BitmapDescriptorFactory.HUE_RED) {
            RecyclerView recyclerView = (RecyclerView) view;
            z = recyclerView.f(recyclerView.getChildAt(0)) > this.f28486a;
        }
        if (!z) {
            a(f3, a(BitmapDescriptorFactory.HUE_RED), z);
        } else {
            a(f3, a(f3), z);
        }
        return true;
    }

    private int a(float f2) {
        int i2;
        if (f2 > BitmapDescriptorFactory.HUE_RED) {
            i2 = Math.abs(this.f28487b.getHeight() - getScrollY());
        } else {
            i2 = Math.abs(this.f28487b.getHeight() - (this.f28487b.getHeight() - getScrollY()));
        }
        float abs = Math.abs(f2);
        if (abs > BitmapDescriptorFactory.HUE_RED) {
            return Math.round((((float) i2) / abs) * 1000.0f) * 3;
        }
        return (int) (((((float) i2) / ((float) getHeight())) + 1.0f) * 150.0f);
    }

    private void a(float f2, int i2, boolean z) {
        int scrollY = getScrollY();
        int height = this.f28487b.getHeight();
        ValueAnimator valueAnimator = this.f28492g;
        if (valueAnimator == null) {
            this.f28492g = new ValueAnimator();
            this.f28492g.setInterpolator(this.h);
            this.f28492g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (valueAnimator.getAnimatedValue() instanceof Integer) {
                        StickyNavLayout.this.scrollTo(0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.f28492g.setDuration((long) Math.min(i2, IjkMediaCodecInfo.RANK_LAST_CHANCE));
        if (f2 >= BitmapDescriptorFactory.HUE_RED) {
            this.f28492g.setIntValues(new int[]{scrollY, height});
            this.f28492g.start();
        } else if (!z) {
            this.f28492g.setIntValues(new int[]{scrollY, 0});
            this.f28492g.start();
        }
    }

    public StickyNavLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.f28491f = new OverScroller(context);
        this.i = ViewConfiguration.get(context).getScaledTouchSlop();
        this.j = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        this.k = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f28487b = findViewById(c.e.id_stickynavlayout_topview);
        this.f28488c = findViewById(c.e.id_stickynavlayout_indicator);
        View findViewById = findViewById(c.e.id_stickynavlayout_viewpager);
        if (findViewById instanceof ViewPager) {
            this.f28489d = (ViewPager) findViewById;
            return;
        }
        throw new RuntimeException("id_stickynavlayout_viewpager show used by ViewPager !");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        getChildAt(0).measure(i2, View.MeasureSpec.makeMeasureSpec(0, 0));
        this.f28489d.getLayoutParams().height = getMeasuredHeight() - this.f28488c.getMeasuredHeight();
        setMeasuredDimension(getMeasuredWidth(), this.f28487b.getMeasuredHeight() + this.f28488c.getMeasuredHeight() + this.f28489d.getMeasuredHeight());
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f28490e = this.f28487b.getMeasuredHeight();
    }

    public void scrollTo(int i2, int i3) {
        if (i3 < 0) {
            i3 = 0;
        }
        int i4 = this.f28490e;
        if (i3 > i4) {
            i3 = i4;
        }
        if (i3 != getScrollY()) {
            super.scrollTo(i2, i3);
        }
    }

    public void computeScroll() {
        if (this.f28491f.computeScrollOffset()) {
            scrollTo(0, this.f28491f.getCurrY());
            invalidate();
        }
    }
}
