package com.salesforce.android.chat.core.model;

public interface AgentInformation {
    String getAgentId();

    String getAgentName();

    boolean isChatBot();

    boolean isSneakPeekEnabled();
}
