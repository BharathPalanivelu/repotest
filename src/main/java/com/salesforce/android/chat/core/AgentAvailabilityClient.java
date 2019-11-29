package com.salesforce.android.chat.core;

import com.salesforce.android.chat.core.model.AvailabilityState;
import com.salesforce.android.service.common.utilities.control.Async;

public interface AgentAvailabilityClient {
    Async<AvailabilityState> check();

    Async<AvailabilityState> verifyLiveAgentPod();
}
