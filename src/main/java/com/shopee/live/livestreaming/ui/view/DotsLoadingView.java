package com.shopee.live.livestreaming.ui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.live.livestreaming.c;

public class DotsLoadingView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    ImageView f29139a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f29140b;

    /* renamed from: c  reason: collision with root package name */
    ImageView f29141c;

    /* renamed from: d  reason: collision with root package name */
    ImageView f29142d;

    /* renamed from: e  reason: collision with root package name */
    ImageView f29143e;

    /* renamed from: f  reason: collision with root package name */
    TextView f29144f;

    /* renamed from: g  reason: collision with root package name */
    private ValueAnimator f29145g;

    public DotsLoadingView(Context context) {
        this(context, (AttributeSet) null);
    }

    public DotsLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DotsLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        View inflate = LayoutInflater.from(context).inflate(c.f.live_streaming_layout_loading_view, this, true);
        this.f29139a = (ImageView) inflate.findViewById(c.e.loading_view_dot_1);
        this.f29140b = (ImageView) inflate.findViewById(c.e.loading_view_dot_2);
        this.f29141c = (ImageView) inflate.findViewById(c.e.loading_view_dot_3);
        this.f29142d = (ImageView) inflate.findViewById(c.e.loading_view_dot_4);
        this.f29143e = (ImageView) inflate.findViewById(c.e.loading_view_dot_5);
        this.f29144f = (TextView) inflate.findViewById(c.e.tv_label);
        this.f29145g = ValueAnimator.ofFloat(new float[]{BitmapDescriptorFactory.HUE_RED, 8.0f});
        this.f29145g.setDuration(1200);
        this.f29145g.setRepeatMode(1);
        this.f29145g.setRepeatCount(-1);
        this.f29145g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float f2 = BitmapDescriptorFactory.HUE_RED;
                float abs = (floatValue < BitmapDescriptorFactory.HUE_RED || floatValue > 4.0f) ? BitmapDescriptorFactory.HUE_RED : 1.0f - (Math.abs(floatValue - 2.0f) / 2.0f);
                float abs2 = (floatValue < 1.0f || floatValue > 5.0f) ? BitmapDescriptorFactory.HUE_RED : 1.0f - (Math.abs(floatValue - 3.0f) / 2.0f);
                float abs3 = (floatValue < 2.0f || floatValue > 6.0f) ? BitmapDescriptorFactory.HUE_RED : 1.0f - (Math.abs(floatValue - 4.0f) / 2.0f);
                float abs4 = (floatValue < 3.0f || floatValue > 7.0f) ? BitmapDescriptorFactory.HUE_RED : 1.0f - (Math.abs(floatValue - 5.0f) / 2.0f);
                if (floatValue >= 4.0f && floatValue <= 8.0f) {
                    f2 = 1.0f - (Math.abs(floatValue - 6.0f) / 2.0f);
                }
                DotsLoadingView.this.f29139a.setScaleX(abs);
                DotsLoadingView.this.f29139a.setScaleY(abs);
                DotsLoadingView.this.f29140b.setScaleX(abs2);
                DotsLoadingView.this.f29140b.setScaleY(abs2);
                DotsLoadingView.this.f29141c.setScaleX(abs3);
                DotsLoadingView.this.f29141c.setScaleY(abs3);
                DotsLoadingView.this.f29142d.setScaleX(abs4);
                DotsLoadingView.this.f29142d.setScaleY(abs4);
                DotsLoadingView.this.f29143e.setScaleX(f2);
                DotsLoadingView.this.f29143e.setScaleY(f2);
            }
        });
    }

    public void a() {
        if (getVisibility() != 0) {
            if (!this.f29145g.isStarted()) {
                this.f29145g.start();
            }
            setVisibility(0);
        }
    }

    public void b() {
        this.f29145g.cancel();
        if (getVisibility() != 8) {
            setVisibility(8);
        }
    }

    public void setLabel(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f29144f.setVisibility(8);
            return;
        }
        this.f29144f.setText(str);
        this.f29144f.setVisibility(0);
    }
}
