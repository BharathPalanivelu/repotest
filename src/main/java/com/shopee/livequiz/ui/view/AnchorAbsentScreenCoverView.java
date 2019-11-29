package com.shopee.livequiz.ui.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.livequiz.b.e;
import com.shopee.livequiz.c;

public class AnchorAbsentScreenCoverView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f29944a;

    /* renamed from: b  reason: collision with root package name */
    private ObjectAnimator f29945b;

    /* renamed from: c  reason: collision with root package name */
    private ObjectAnimator f29946c;

    /* renamed from: d  reason: collision with root package name */
    private long f29947d;

    public AnchorAbsentScreenCoverView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AnchorAbsentScreenCoverView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AnchorAbsentScreenCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f29944a = (TextView) LayoutInflater.from(context).inflate(c.f.livesdk_shopee_layout_anchor_absent, this).findViewById(c.d.tv_notify);
        this.f29945b = ObjectAnimator.ofFloat(this, "alpha", new float[]{BitmapDescriptorFactory.HUE_RED, 1.0f});
        this.f29946c = ObjectAnimator.ofFloat(this, "alpha", new float[]{1.0f, BitmapDescriptorFactory.HUE_RED});
        this.f29946c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() >= 1.0f) {
                    AnchorAbsentScreenCoverView.this.setVisibility(8);
                }
            }
        });
    }

    public TextView getNotifyTextView() {
        return this.f29944a;
    }

    public void a() {
        if (!b()) {
            this.f29947d = System.currentTimeMillis();
            e.a(this.f29947d);
        }
        setVisibility(0);
    }

    public void a(boolean z) {
        if (b()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.f29947d;
            if (j > 0) {
                e.a(currentTimeMillis, currentTimeMillis - j, z);
            }
        }
        setVisibility(8);
    }

    public boolean b() {
        return getVisibility() == 0;
    }
}
