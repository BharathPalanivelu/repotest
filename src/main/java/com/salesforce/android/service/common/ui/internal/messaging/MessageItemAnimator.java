package com.salesforce.android.service.common.ui.internal.messaging;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.salesforce.android.service.common.ui.R;
import com.salesforce.android.service.common.ui.internal.utils.SimpleItemAnimatorAdapter;

public class MessageItemAnimator extends SimpleItemAnimatorAdapter {
    public MessageItemAnimator() {
        setSupportsChangeAnimations(false);
    }

    public boolean animateAdd(final RecyclerView.w wVar) {
        int integer = wVar.itemView.getResources().getInteger(R.integer.salesforce_message_item_enter_duration_ms);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                MessageItemAnimator.this.dispatchAddStarting(wVar);
            }

            public void onAnimationEnd(Animator animator) {
                MessageItemAnimator.this.dispatchAddFinished(wVar);
            }

            public void onAnimationCancel(Animator animator) {
                MessageItemAnimator.this.dispatchAddFinished(wVar);
            }
        });
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.setDuration((long) integer);
        animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(wVar.itemView, "alpha", new float[]{BitmapDescriptorFactory.HUE_RED, 1.0f}), ObjectAnimator.ofFloat(wVar.itemView, "translationY", new float[]{(float) (((ViewGroup) wVar.itemView.getParent()).getHeight() / 5), 0.0f})});
        animatorSet.start();
        return false;
    }

    public boolean animateRemove(final RecyclerView.w wVar) {
        int integer = wVar.itemView.getResources().getInteger(R.integer.salesforce_message_item_exit_duration_ms);
        int width = wVar.itemView.getWidth();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                MessageItemAnimator.this.dispatchRemoveStarting(wVar);
            }

            public void onAnimationEnd(Animator animator) {
                MessageItemAnimator.this.dispatchRemoveFinished(wVar);
                wVar.itemView.setAlpha(1.0f);
                wVar.itemView.setScaleY(1.0f);
                wVar.itemView.setTranslationX(BitmapDescriptorFactory.HUE_RED);
            }

            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }
        });
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.setDuration((long) integer);
        animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(wVar.itemView, "alpha", new float[]{1.0f, BitmapDescriptorFactory.HUE_RED}), ObjectAnimator.ofFloat(wVar.itemView, "scaleY", new float[]{1.0f, BitmapDescriptorFactory.HUE_RED}), ObjectAnimator.ofFloat(wVar.itemView, "translationX", new float[]{0.0f, (float) (-width)})});
        animatorSet.start();
        return false;
    }
}
