package com.salesforce.android.chat.ui.internal.minimize.presenter;

import android.content.Context;
import com.salesforce.android.chat.core.model.AgentInformation;
import com.salesforce.android.chat.ui.internal.client.InternalChatUIClient;
import com.salesforce.android.chat.ui.internal.minimize.viewbinder.InSessionMinimizedView;
import com.salesforce.android.chat.ui.internal.minimize.viewbinder.MinimizeViewBinder;
import com.salesforce.android.chat.ui.internal.presenter.PresenterBuilder;
import com.salesforce.android.service.common.utilities.internal.android.BackgroundTracker;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class InSessionMinimizedPresenter implements MinimizePresenter, BackgroundTracker.Listener {
    private AgentInformation mAgentInformation;
    private final InternalChatUIClient mChatClient;
    private boolean mIsAgentTyping;
    private boolean mIsBackgrounded;
    private InSessionMinimizedView mMinimizedView;

    public Context getApplicationContext() {
        return null;
    }

    private InSessionMinimizedPresenter(Builder builder) {
        this.mChatClient = builder.mChatClient;
        this.mIsAgentTyping = false;
    }

    public void onCreate() {
        this.mAgentInformation = this.mChatClient.getMessageReceiver().getAgentInformation();
        this.mChatClient.getBackgroundTracker().addListener(this);
    }

    public void onViewCreated(MinimizeViewBinder minimizeViewBinder) {
        this.mMinimizedView = (InSessionMinimizedView) minimizeViewBinder;
        this.mMinimizedView.setAgentInformation(this.mAgentInformation);
        this.mMinimizedView.setIsAgentTyping(Boolean.valueOf(this.mIsAgentTyping));
    }

    public void onViewDestroyed(MinimizeViewBinder minimizeViewBinder) {
        this.mMinimizedView = null;
    }

    public void onDestroy() {
        this.mChatClient.getBackgroundTracker().removeListener(this);
    }

    public Boolean shouldUpdateState() {
        return Boolean.valueOf(this.mIsBackgrounded || this.mMinimizedView != null);
    }

    public void onBackgroundChange(boolean z) {
        this.mIsBackgrounded = z;
    }

    public void setUnreadMessageCount(int i) {
        updateUnreadMessageCount(i);
    }

    public void setAgentInformation(AgentInformation agentInformation) {
        this.mAgentInformation = agentInformation;
        InSessionMinimizedView inSessionMinimizedView = this.mMinimizedView;
        if (inSessionMinimizedView != null) {
            inSessionMinimizedView.setAgentInformation(this.mAgentInformation);
        }
    }

    public void setAgentIsTyping(boolean z) {
        this.mIsAgentTyping = z;
        InSessionMinimizedView inSessionMinimizedView = this.mMinimizedView;
        if (inSessionMinimizedView != null) {
            inSessionMinimizedView.setIsAgentTyping(Boolean.valueOf(this.mIsAgentTyping));
        }
    }

    private void updateUnreadMessageCount(int i) {
        if (shouldUpdateState().booleanValue()) {
            InSessionMinimizedView inSessionMinimizedView = this.mMinimizedView;
            if (inSessionMinimizedView != null) {
                inSessionMinimizedView.setMessageCount(Integer.valueOf(i));
            }
        }
    }

    public static class Builder implements PresenterBuilder<MinimizePresenter> {
        /* access modifiers changed from: private */
        public InternalChatUIClient mChatClient;

        public int getKey() {
            return 4;
        }

        public Builder internalChatUIClient(InternalChatUIClient internalChatUIClient) {
            this.mChatClient = internalChatUIClient;
            return this;
        }

        public InSessionMinimizedPresenter build() {
            Arguments.checkNotNull(this.mChatClient);
            return new InSessionMinimizedPresenter(this);
        }
    }
}
