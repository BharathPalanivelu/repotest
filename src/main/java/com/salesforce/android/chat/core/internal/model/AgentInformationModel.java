package com.salesforce.android.chat.core.internal.model;

import com.salesforce.android.chat.core.model.AgentInformation;

public class AgentInformationModel implements AgentInformation {
    private final String mAgentId;
    private final String mAgentName;
    private final boolean mIsChatBot;
    private final boolean mIsSneakPeekEnabled;

    public AgentInformationModel(String str, String str2, boolean z, boolean z2) {
        this.mAgentName = str;
        this.mAgentId = str2;
        this.mIsSneakPeekEnabled = z;
        this.mIsChatBot = z2;
    }

    public String getAgentName() {
        return this.mAgentName;
    }

    public String getAgentId() {
        return this.mAgentId;
    }

    public boolean isSneakPeekEnabled() {
        return this.mIsSneakPeekEnabled;
    }

    public boolean isChatBot() {
        return this.mIsChatBot;
    }
}
