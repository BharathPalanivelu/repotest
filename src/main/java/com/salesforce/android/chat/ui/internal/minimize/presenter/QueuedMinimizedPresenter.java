package com.salesforce.android.chat.ui.internal.minimize.presenter;

import android.content.Context;
import com.salesforce.android.chat.core.QueueListener;
import com.salesforce.android.chat.core.model.AgentInformation;
import com.salesforce.android.chat.ui.internal.client.InternalChatUIClient;
import com.salesforce.android.chat.ui.internal.minimize.viewbinder.MinimizeViewBinder;
import com.salesforce.android.chat.ui.internal.minimize.viewbinder.QueuedMinimizedView;
import com.salesforce.android.chat.ui.internal.presenter.PresenterBuilder;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class QueuedMinimizedPresenter implements QueueListener, MinimizePresenter {
    private final InternalChatUIClient mChatClient;
    private QueuedMinimizedView mMinimizedView;
    private int mQueuePosition;

    public void onDestroy() {
    }

    public void setAgentInformation(AgentInformation agentInformation) {
    }

    public void setAgentIsTyping(boolean z) {
    }

    public void setUnreadMessageCount(int i) {
    }

    private QueuedMinimizedPresenter(Builder builder) {
        this.mChatClient = builder.mChatClient;
    }

    public void onCreate() {
        this.mQueuePosition = this.mChatClient.getMessageReceiver().getQueuePosition();
    }

    public void onViewCreated(MinimizeViewBinder minimizeViewBinder) {
        this.mMinimizedView = (QueuedMinimizedView) minimizeViewBinder;
        this.mMinimizedView.setQueuePosition(this.mQueuePosition);
        this.mChatClient.getMessageReceiver().addQueueListener(this);
    }

    public void onViewDestroyed(MinimizeViewBinder minimizeViewBinder) {
        this.mChatClient.getMessageReceiver().removeQueueListener(this);
        this.mMinimizedView = null;
    }

    public Context getApplicationContext() {
        return this.mChatClient.getApplicationContext();
    }

    public void onQueuePositionUpdate(int i) {
        this.mQueuePosition = i;
        QueuedMinimizedView queuedMinimizedView = this.mMinimizedView;
        if (queuedMinimizedView != null) {
            queuedMinimizedView.setQueuePosition(this.mQueuePosition);
        }
    }

    public static class Builder implements PresenterBuilder<MinimizePresenter> {
        /* access modifiers changed from: private */
        public InternalChatUIClient mChatClient;

        public int getKey() {
            return 3;
        }

        public Builder internalChatUIClient(InternalChatUIClient internalChatUIClient) {
            this.mChatClient = internalChatUIClient;
            return this;
        }

        public MinimizePresenter build() {
            Arguments.checkNotNull(this.mChatClient);
            return new QueuedMinimizedPresenter(this);
        }
    }
}
