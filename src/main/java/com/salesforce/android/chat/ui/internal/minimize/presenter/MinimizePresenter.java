package com.salesforce.android.chat.ui.internal.minimize.presenter;

import com.salesforce.android.chat.core.model.AgentInformation;
import com.salesforce.android.chat.ui.internal.minimize.viewbinder.MinimizeViewBinder;
import com.salesforce.android.chat.ui.internal.presenter.Presenter;

public interface MinimizePresenter extends Presenter<MinimizeViewBinder> {
    void setAgentInformation(AgentInformation agentInformation);

    void setAgentIsTyping(boolean z);

    void setUnreadMessageCount(int i);
}
