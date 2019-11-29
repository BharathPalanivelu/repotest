package com.shopee.live.livestreaming.ui.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import com.garena.android.appkit.f.f;

public class AutoDismissLayout extends RelativeLayout {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public AnimatorSet f29101a;

    /* renamed from: b  reason: collision with root package name */
    private AnimatorSet f29102b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Runnable f29103c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f29104d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f29105e;

    public AutoDismissLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public AutoDismissLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoDismissLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", new float[]{0.2f, 1.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "scaleX", new float[]{0.5f, 1.0f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, "scaleY", new float[]{0.5f, 1.0f});
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this, "alpha", new float[]{1.0f, 0.2f});
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this, "scaleX", new float[]{1.0f, 0.5f});
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this, "scaleY", new float[]{1.0f, 0.5f});
        this.f29101a = new AnimatorSet().setDuration(300);
        this.f29101a.setInterpolator(new DecelerateInterpolator());
        this.f29101a.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
        this.f29102b = new AnimatorSet().setDuration(300);
        this.f29102b.setInterpolator(new DecelerateInterpolator());
        this.f29102b.playTogether(new Animator[]{ofFloat4, ofFloat5, ofFloat6});
        this.f29103c = new Runnable() {
            public void run() {
                AutoDismissLayout.this.d();
            }
        };
    }

    public boolean a() {
        return this.f29104d;
    }

    public void b() {
        if (!this.f29105e) {
            this.f29105e = true;
            c();
        }
    }

    public void c() {
        if (!a()) {
            this.f29101a.removeAllListeners();
            if (this.f29101a.isRunning()) {
                this.f29101a.cancel();
            }
            this.f29102b.removeAllListeners();
            if (this.f29102b.isRunning()) {
                this.f29102b.cancel();
            }
            this.f29101a.addListener(new Animator.AnimatorListener() {
                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                    boolean unused = AutoDismissLayout.this.f29104d = true;
                    AutoDismissLayout.this.setVisibility(0);
                }

                public void onAnimationEnd(Animator animator) {
                    AutoDismissLayout.this.f29101a.removeAllListeners();
                    f.a().a(AutoDismissLayout.this.f29103c, 5000);
                }

                public void onAnimationCancel(Animator animator) {
                    AutoDismissLayout.this.setVisibility(8);
                    AutoDismissLayout.this.f29101a.removeAllListeners();
                    boolean unused = AutoDismissLayout.this.f29104d = false;
                }
            });
            this.f29101a.start();
        }
    }

    public void d() {
        if (a()) {
            f.a().b(this.f29103c);
            this.f29101a.removeAllListeners();
            if (this.f29101a.isRunning()) {
                this.f29101a.cancel();
            }
            this.f29102b.removeAllListeners();
            if (this.f29102b.isRunning()) {
                this.f29102b.cancel();
            }
            this.f29102b.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                    AutoDismissLayout.this.setVisibility(0);
                }

                public void onAnimationEnd(Animator animator) {
                    AutoDismissLayout.this.setVisibility(8);
                    AutoDismissLayout.this.f29101a.removeAllListeners();
                    boolean unused = AutoDismissLayout.this.f29104d = false;
                }
            });
            this.f29102b.start();
        }
    }
}
