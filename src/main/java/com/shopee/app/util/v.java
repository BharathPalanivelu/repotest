package com.shopee.app.util;

import android.graphics.drawable.Animatable;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.AnimationListener;

public class v {

    public interface a {
        void a();
    }

    public static void a(Animatable animatable, final a aVar) {
        if (animatable != null && (animatable instanceof AnimatedDrawable2)) {
            AnimatedDrawable2 animatedDrawable2 = (AnimatedDrawable2) animatable;
            animatedDrawable2.setAnimationListener(new AnimationListener() {
                public void onAnimationFrame(AnimatedDrawable2 animatedDrawable2, int i) {
                }

                public void onAnimationReset(AnimatedDrawable2 animatedDrawable2) {
                }

                public void onAnimationStart(AnimatedDrawable2 animatedDrawable2) {
                }

                public void onAnimationStop(AnimatedDrawable2 animatedDrawable2) {
                    a aVar = aVar;
                    if (aVar != null) {
                        aVar.a();
                    }
                }

                public void onAnimationRepeat(AnimatedDrawable2 animatedDrawable2) {
                    a aVar = aVar;
                    if (aVar != null) {
                        aVar.a();
                    }
                }
            });
            animatedDrawable2.start();
        }
    }
}
