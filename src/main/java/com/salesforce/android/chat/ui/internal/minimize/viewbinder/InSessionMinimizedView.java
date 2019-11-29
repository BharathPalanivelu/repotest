package com.salesforce.android.chat.ui.internal.minimize.viewbinder;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.salesforce.android.chat.core.model.AgentInformation;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.chat.ui.internal.minimize.presenter.InSessionMinimizedPresenter;
import com.salesforce.android.chat.ui.internal.state.AvatarCache;
import com.salesforce.android.chat.ui.internal.view.AvatarViewBinderBuilder;
import com.salesforce.android.service.common.ui.views.SalesforceTextView;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class InSessionMinimizedView implements MinimizeViewBinder {
    private static final String COUNT_OVERFLOW = "9+";
    private static final Integer MAX_COUNT = 9;
    private ImageView mAgentAvatar;
    /* access modifiers changed from: private */
    public ImageView mAgentMessageIndicatorView;
    private SalesforceTextView mAgentName;
    private ValueAnimator mAlphaAnimation;
    private final AvatarCache mAvatarCache;
    private View mContentView;
    private Integer mCurrentMessageCount;
    private SalesforceTextView mMessageCounterView;
    private final InSessionMinimizedPresenter mPresenter;

    public boolean onBackPressed() {
        return false;
    }

    public void onRestoreInstanceState(Bundle bundle) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    private InSessionMinimizedView(Builder builder) {
        this.mPresenter = builder.mPresenter;
        this.mAvatarCache = builder.mAvatarCache;
        this.mCurrentMessageCount = 0;
    }

    public Boolean maximize() {
        return true;
    }

    public void setAgentInformation(AgentInformation agentInformation) {
        if (agentInformation != null) {
            this.mAgentName.setText(agentInformation.getAgentName());
            this.mAgentAvatar.setImageDrawable(this.mAvatarCache.getAvatar(agentInformation.getAgentId()));
            this.mContentView.setContentDescription(agentInformation.getAgentName());
        }
    }

    public void setIsAgentTyping(Boolean bool) {
        if (this.mAlphaAnimation != null) {
            if (bool.booleanValue()) {
                this.mAlphaAnimation.start();
            } else {
                this.mAlphaAnimation.cancel();
                this.mAgentMessageIndicatorView.setAlpha(1.0f);
            }
            updateMessageIndicatorVisibility();
        }
    }

    public void setMessageCount(Integer num) {
        if (num.intValue() > 0) {
            this.mCurrentMessageCount = num;
            String quantityString = this.mMessageCounterView.getResources().getQuantityString(R.plurals.chat_minimized_unread_message_count, num.intValue(), new Object[]{num, this.mAgentName.getText()});
            this.mMessageCounterView.setText(this.mCurrentMessageCount.intValue() <= MAX_COUNT.intValue() ? this.mCurrentMessageCount.toString() : COUNT_OVERFLOW);
            this.mContentView.setContentDescription(quantityString);
            updateMessageIndicatorVisibility();
        }
    }

    private void updateMessageIndicatorVisibility() {
        ValueAnimator valueAnimator = this.mAlphaAnimation;
        int i = 0;
        boolean z = valueAnimator != null && valueAnimator.isRunning();
        ImageView imageView = this.mAgentMessageIndicatorView;
        if (!z && this.mCurrentMessageCount.intValue() <= 0) {
            i = 4;
        }
        imageView.setVisibility(i);
    }

    public void onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.mContentView = layoutInflater.inflate(R.layout.chat_minimized_in_session, viewGroup, true);
        this.mAgentAvatar = (ImageView) this.mContentView.findViewById(R.id.chat_minimized_agent_avatar);
        this.mAgentMessageIndicatorView = (ImageView) this.mContentView.findViewById(R.id.chat_minimized_agent_message_indicator);
        this.mAgentName = (SalesforceTextView) this.mContentView.findViewById(R.id.chat_minimized_agent_name);
        this.mMessageCounterView = (SalesforceTextView) this.mContentView.findViewById(R.id.chat_minimized_message_counter);
        this.mAgentMessageIndicatorView.setVisibility(4);
        this.mAlphaAnimation = ValueAnimator.ofFloat(new float[]{1.0f, 0.5f});
        this.mAlphaAnimation.setRepeatMode(2);
        this.mAlphaAnimation.setRepeatCount(-1);
        this.mAlphaAnimation.setDuration(750);
        this.mAlphaAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                InSessionMinimizedView.this.mAgentMessageIndicatorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.mPresenter.onViewCreated((MinimizeViewBinder) this);
    }

    public void onDestroyView() {
        this.mPresenter.onViewDestroyed((MinimizeViewBinder) this);
    }

    public static class Builder implements AvatarViewBinderBuilder<InSessionMinimizedView, InSessionMinimizedPresenter> {
        /* access modifiers changed from: private */
        public AvatarCache mAvatarCache;
        /* access modifiers changed from: private */
        public InSessionMinimizedPresenter mPresenter;

        public int getKey() {
            return 4;
        }

        public Builder setPresenter(InSessionMinimizedPresenter inSessionMinimizedPresenter) {
            this.mPresenter = inSessionMinimizedPresenter;
            return this;
        }

        public Builder avatarCache(AvatarCache avatarCache) {
            this.mAvatarCache = avatarCache;
            return this;
        }

        public InSessionMinimizedView build() {
            Arguments.checkNotNull(this.mPresenter);
            Arguments.checkNotNull(this.mAvatarCache);
            return new InSessionMinimizedView(this);
        }
    }
}
