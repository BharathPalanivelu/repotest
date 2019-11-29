package com.shopee.app.util.c;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

public class d {
    public static void a(View view, boolean z) {
        if (view != null) {
            view.clearAnimation();
            if (z) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.2f, 1.0f, 0.2f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setDuration(100);
                scaleAnimation.setInterpolator(new AccelerateInterpolator());
                scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationEnd(Animation animation) {
                    }

                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }
                });
                view.setVisibility(0);
                view.startAnimation(scaleAnimation);
                return;
            }
            view.setVisibility(8);
        }
    }
}
