package com.salesforce.android.chat.core.model;

public interface AvailabilityState {

    public enum Status {
        NoAgentsAvailable,
        AgentsAvailable,
        Unknown
    }

    String getLiveAgentPod();

    Status getStatus();
}
