package com.shopee.arcatch.page.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.arcatch.a;
import com.shopee.arcatch.c.d.b;

public class ArCatchCountdownView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private AnimatorSet f26986a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f26987b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a f26988c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public TextView f26989d;

    public interface a {
        void c();
    }

    static /* synthetic */ int d(ArCatchCountdownView arCatchCountdownView) {
        int i = arCatchCountdownView.f26987b;
        arCatchCountdownView.f26987b = i - 1;
        return i;
    }

    public ArCatchCountdownView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ArCatchCountdownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArCatchCountdownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f26987b = 3;
        LayoutInflater.from(context).inflate(a.d.arcatch_view_countdown, this, true);
        this.f26989d = (TextView) findViewById(a.c.arcatch_tv_countdown_text);
        this.f26989d.setTextColor(com.shopee.arcatch.c.d.a.a().f26759d);
        this.f26986a = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f26989d, "scaleX", new float[]{0.5f, 1.5f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f26989d, "scaleY", new float[]{0.5f, 1.5f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f26989d, "alpha", new float[]{BitmapDescriptorFactory.HUE_RED, 1.0f});
        ofFloat.setRepeatCount(3);
        ofFloat.setRepeatMode(1);
        ofFloat2.setRepeatCount(3);
        ofFloat2.setRepeatMode(1);
        ofFloat3.setRepeatCount(3);
        ofFloat3.setRepeatMode(1);
        final FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f26989d.getLayoutParams();
        this.f26986a.setDuration(1000);
        this.f26986a.play(ofFloat).with(ofFloat2).with(ofFloat3);
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                layoutParams.gravity = 17;
                ArCatchCountdownView.this.f26989d.setText(String.valueOf(ArCatchCountdownView.this.f26987b));
                ArCatchCountdownView.this.setVisibility(0);
            }

            public void onAnimationEnd(Animator animator) {
                if (ArCatchCountdownView.this.f26988c != null) {
                    ArCatchCountdownView.this.f26988c.c();
                }
                ArCatchCountdownView.this.setVisibility(8);
            }

            public void onAnimationRepeat(Animator animator) {
                b.a().e();
                ArCatchCountdownView.d(ArCatchCountdownView.this);
                if (ArCatchCountdownView.this.f26987b == 0) {
                    ArCatchCountdownView.this.f26989d.setText(com.shopee.arcatch.c.d.a.a().f26758c);
                } else {
                    ArCatchCountdownView.this.f26989d.setText(String.valueOf(ArCatchCountdownView.this.f26987b));
                }
            }
        });
    }

    public void setCountDownListener(a aVar) {
        this.f26988c = aVar;
    }

    public void a() {
        this.f26987b = 3;
        this.f26986a.start();
    }

    public void b() {
        AnimatorSet animatorSet = this.f26986a;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }
}
