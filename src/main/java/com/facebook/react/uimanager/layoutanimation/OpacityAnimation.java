package com.facebook.react.uimanager.layoutanimation;

import android.graphics.Paint;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class OpacityAnimation extends Animation {
    private final float mDeltaOpacity;
    private final float mStartOpacity;
    private final View mView;

    public boolean willChangeBounds() {
        return false;
    }

    static class OpacityAnimationListener implements Animation.AnimationListener {
        private boolean mLayerTypeChanged = false;
        private final View mView;

        public void onAnimationRepeat(Animation animation) {
        }

        public OpacityAnimationListener(View view) {
            this.mView = view;
        }

        public void onAnimationStart(Animation animation) {
            if (this.mView.hasOverlappingRendering() && this.mView.getLayerType() == 0) {
                this.mLayerTypeChanged = true;
                this.mView.setLayerType(2, (Paint) null);
            }
        }

        public void onAnimationEnd(Animation animation) {
            if (this.mLayerTypeChanged) {
                this.mView.setLayerType(0, (Paint) null);
            }
        }
    }

    public OpacityAnimation(View view, float f2, float f3) {
        this.mView = view;
        this.mStartOpacity = f2;
        this.mDeltaOpacity = f3 - f2;
        setAnimationListener(new OpacityAnimationListener(view));
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float f2, Transformation transformation) {
        this.mView.setAlpha(this.mStartOpacity + (this.mDeltaOpacity * f2));
    }
}
