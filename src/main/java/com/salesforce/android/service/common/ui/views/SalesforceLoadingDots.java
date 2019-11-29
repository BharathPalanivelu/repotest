package com.salesforce.android.service.common.ui.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.salesforce.android.service.common.ui.R;

public class SalesforceLoadingDots extends FrameLayout {
    private static final int DEFAULT_ANIMATION_DURATION = 600;
    private static final float DEFAULT_ANIMATION_SCALE_FROM = 1.0f;
    private static final float DEFAULT_ANIMATION_SCALE_TO = 1.5f;

    public SalesforceLoadingDots(Context context) {
        this(context, (AttributeSet) null);
    }

    public SalesforceLoadingDots(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SalesforceLoadingDots(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(getContext()).inflate(R.layout.salesforce_loading_balls, this, true);
        startLoadingDotAnimation();
    }

    /* access modifiers changed from: package-private */
    public void startLoadingDotAnimation() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{scaleDot((ImageView) findViewById(R.id.salesforce_loading_ball_1), 0), scaleDot((ImageView) findViewById(R.id.salesforce_loading_ball_2), 300), scaleDot((ImageView) findViewById(R.id.salesforce_loading_ball_3), 600)});
        animatorSet.setDuration(600);
        animatorSet.start();
    }

    private Animator scaleDot(View view, int i) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", new float[]{DEFAULT_ANIMATION_SCALE_FROM, DEFAULT_ANIMATION_SCALE_TO});
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", new float[]{DEFAULT_ANIMATION_SCALE_FROM, DEFAULT_ANIMATION_SCALE_TO});
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.setStartDelay((long) i);
        return animatorSet;
    }
}
