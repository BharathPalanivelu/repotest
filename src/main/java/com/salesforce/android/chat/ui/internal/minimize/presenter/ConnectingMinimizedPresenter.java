package com.salesforce.android.chat.ui.internal.minimize.presenter;

import android.content.Context;
import com.salesforce.android.chat.core.model.AgentInformation;
import com.salesforce.android.chat.ui.internal.client.InternalChatUIClient;
import com.salesforce.android.chat.ui.internal.minimize.viewbinder.MinimizeViewBinder;
import com.salesforce.android.chat.ui.internal.presenter.PresenterBuilder;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class ConnectingMinimizedPresenter implements MinimizePresenter {
    public Context getApplicationContext() {
        return null;
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onViewCreated(MinimizeViewBinder minimizeViewBinder) {
    }

    public void onViewDestroyed(MinimizeViewBinder minimizeViewBinder) {
    }

    public void setAgentInformation(AgentInformation agentInformation) {
    }

    public void setAgentIsTyping(boolean z) {
    }

    public void setUnreadMessageCount(int i) {
    }

    private ConnectingMinimizedPresenter() {
    }

    public static class Builder implements PresenterBuilder<MinimizePresenter> {
        private InternalChatUIClient mChatClient;

        public int getKey() {
            return 2;
        }

        public Builder internalChatUIClient(InternalChatUIClient internalChatUIClient) {
            this.mChatClient = internalChatUIClient;
            return this;
        }

        public MinimizePresenter build() {
            Arguments.checkNotNull(this.mChatClient);
            return new ConnectingMinimizedPresenter();
        }
    }
}
