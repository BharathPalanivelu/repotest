package com.shopee.app.util;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import com.garena.android.appkit.d.a;
import com.garena.android.appkit.tools.a.b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.ijk.media.player.IjkMediaCodecInfo;

public class CartAnimation {

    /* renamed from: a  reason: collision with root package name */
    private static final int f26098a = (b.a.t * 2);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public View f26099b;

    /* renamed from: c  reason: collision with root package name */
    private Activity f26100c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public View f26101d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f26102e;

    /* renamed from: f  reason: collision with root package name */
    private int[] f26103f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Animation.AnimationListener f26104g;

    public CartAnimation imageView(View view) {
        this.f26099b = view;
        return this;
    }

    public CartAnimation startLocation(int[] iArr) {
        this.f26102e = iArr;
        return this;
    }

    public CartAnimation cartLocation(int[] iArr) {
        this.f26103f = iArr;
        return this;
    }

    public CartAnimation activity(Activity activity) {
        this.f26100c = activity;
        return this;
    }

    public CartAnimation cartView(View view) {
        this.f26101d = view;
        return this;
    }

    public CartAnimation animationListener(Animation.AnimationListener animationListener) {
        this.f26104g = animationListener;
        return this;
    }

    public CartAnimation build() {
        a();
        return this;
    }

    public void start() {
        this.f26099b.post(new Runnable() {
            public void run() {
                CartAnimation.this.d();
            }
        });
    }

    private void a() {
        int i = f26098a;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
        layoutParams.setMargins(this.f26103f[0] - b.a.m, (this.f26103f[1] - f26098a) + b.a.o, 0, 0);
        this.f26099b.setLayoutParams(layoutParams);
        this.f26099b.setVisibility(8);
        this.f26099b.clearAnimation();
        if (this.f26099b.getParent() == null) {
            try {
                ((ViewGroup) this.f26100c.getWindow().getDecorView().getRootView().findViewById(16908290)).addView(this.f26099b, layoutParams);
            } catch (Exception e2) {
                a.a(e2);
            }
        }
    }

    private void b() {
        float f2 = (float) (((this.f26103f[1] - this.f26102e[1]) + (b.a.f7696g * 12)) - (b.a.f7696g * 8));
        AnimatorSet animatorSet = new AnimatorSet();
        a aVar = new a();
        float f3 = -((float) ((this.f26103f[0] - this.f26102e[0]) + b.a.f7693d));
        float f4 = -f2;
        aVar.a(f3, f4);
        aVar.a(f3, f4 / 2.0f, f3 / 2.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
        this.f26099b.setVisibility(0);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this, "buttonLoc", new aq(), aVar.a().toArray());
        ofObject.reverse();
        animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.f26099b, "scaleX", new float[]{1.0f, 0.15f}), ObjectAnimator.ofFloat(this.f26099b, "scaleY", new float[]{1.0f, 0.15f}), ObjectAnimator.ofFloat(this.f26099b, "alpha", new float[]{1.0f, 0.4f}), ofObject});
        int i = Math.abs(f2) < ((float) (com.garena.android.appkit.tools.b.d() / 2)) ? IjkMediaCodecInfo.RANK_LAST_CHANCE : 1000;
        animatorSet.setDuration((long) i);
        animatorSet.start();
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                CartAnimation.this.f26099b.setVisibility(8);
            }
        });
        if (this.f26101d != null) {
            this.f26099b.postDelayed(new Runnable() {
                public void run() {
                    CartAnimation.this.c();
                }
            }, (long) (i - 100));
        } else if (this.f26104g != null) {
            this.f26099b.postDelayed(new Runnable() {
                public void run() {
                    CartAnimation.this.f26104g.onAnimationEnd((Animation) null);
                }
            }, (long) ((i - 100) + 300));
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.4f, 1.0f, 1.4f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(new AccelerateInterpolator());
        final ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setInterpolator(new AccelerateInterpolator());
        scaleAnimation.setDuration(150);
        scaleAnimation2.setDuration(150);
        this.f26101d.setAnimation(scaleAnimation);
        scaleAnimation.start();
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                if (CartAnimation.this.f26104g != null) {
                    CartAnimation.this.f26104g.onAnimationEnd((Animation) null);
                }
            }

            public void onAnimationEnd(Animation animation) {
                CartAnimation.this.f26101d.setAnimation(scaleAnimation2);
                scaleAnimation2.start();
            }
        });
        scaleAnimation2.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                CartAnimation.this.f26101d.clearAnimation();
            }
        });
    }

    /* access modifiers changed from: private */
    public void d() {
        b();
    }

    public void setButtonLoc(ar arVar) {
        this.f26099b.setTranslationX(arVar.f26161a);
        this.f26099b.setTranslationY(arVar.f26162b);
    }
}
