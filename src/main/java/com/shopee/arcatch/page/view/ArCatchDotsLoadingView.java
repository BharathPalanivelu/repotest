package com.shopee.arcatch.page.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.arcatch.a;

public class ArCatchDotsLoadingView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private ValueAnimator f26992a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ImageView f26993b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ImageView f26994c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ImageView f26995d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ImageView f26996e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ImageView f26997f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f26998g;

    public ArCatchDotsLoadingView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ArCatchDotsLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArCatchDotsLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(a.d.arcatch_layout_loading_view, this, true);
        this.f26993b = (ImageView) findViewById(a.c.loading_view_dot_1);
        this.f26994c = (ImageView) findViewById(a.c.loading_view_dot_2);
        this.f26995d = (ImageView) findViewById(a.c.loading_view_dot_3);
        this.f26996e = (ImageView) findViewById(a.c.loading_view_dot_4);
        this.f26997f = (ImageView) findViewById(a.c.loading_view_dot_5);
        this.f26998g = (TextView) findViewById(a.c.tv_label);
        this.f26992a = ValueAnimator.ofFloat(new float[]{BitmapDescriptorFactory.HUE_RED, 8.0f});
        this.f26992a.setDuration(1200);
        this.f26992a.setRepeatMode(1);
        this.f26992a.setRepeatCount(-1);
        this.f26992a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
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
                ArCatchDotsLoadingView.this.f26993b.setScaleX(abs);
                ArCatchDotsLoadingView.this.f26993b.setScaleY(abs);
                ArCatchDotsLoadingView.this.f26994c.setScaleX(abs2);
                ArCatchDotsLoadingView.this.f26994c.setScaleY(abs2);
                ArCatchDotsLoadingView.this.f26995d.setScaleX(abs3);
                ArCatchDotsLoadingView.this.f26995d.setScaleY(abs3);
                ArCatchDotsLoadingView.this.f26996e.setScaleX(abs4);
                ArCatchDotsLoadingView.this.f26996e.setScaleY(abs4);
                ArCatchDotsLoadingView.this.f26997f.setScaleX(f2);
                ArCatchDotsLoadingView.this.f26997f.setScaleY(f2);
            }
        });
    }

    public void a() {
        if (!this.f26992a.isStarted()) {
            this.f26992a.start();
        }
    }

    public void b() {
        this.f26992a.cancel();
    }

    public void setLabel(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f26998g.setVisibility(8);
            return;
        }
        this.f26998g.setText(str);
        this.f26998g.setVisibility(0);
    }
}
