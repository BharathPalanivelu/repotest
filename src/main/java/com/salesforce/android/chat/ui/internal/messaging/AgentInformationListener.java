package com.salesforce.android.chat.ui.internal.messaging;

import com.salesforce.android.chat.core.model.AgentInformation;

public interface AgentInformationListener {
    void onAgentJoined(AgentInformation agentInformation);

    void onAgentJoinedConference(String str);

    void onAgentLeftConference(String str);

    void onTransferToButtonInitiated();
}
