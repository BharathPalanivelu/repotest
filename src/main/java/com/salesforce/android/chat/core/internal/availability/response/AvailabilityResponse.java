package com.salesforce.android.chat.core.internal.availability.response;

import com.salesforce.android.chat.core.model.AvailabilityState;

public class AvailabilityResponse implements AvailabilityState {
    private final String mLiveAgentPod;
    private final AvailabilityState.Status mStatus;

    public AvailabilityResponse(AvailabilityState.Status status, String str) {
        this.mStatus = status;
        this.mLiveAgentPod = str;
    }

    public AvailabilityState.Status getStatus() {
        return this.mStatus;
    }

    public String getLiveAgentPod() {
        return this.mLiveAgentPod;
    }
}
