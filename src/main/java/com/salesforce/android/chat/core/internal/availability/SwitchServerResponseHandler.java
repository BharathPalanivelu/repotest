package com.salesforce.android.chat.core.internal.availability;

import com.salesforce.android.chat.core.ChatConfiguration;
import com.salesforce.android.chat.core.internal.availability.response.AvailabilityResponse;
import com.salesforce.android.chat.core.model.AvailabilityState;
import com.salesforce.android.service.common.liveagentclient.LiveAgentClient;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;

class SwitchServerResponseHandler extends AvailabilityResponseHandler {
    private static final int MAX_RETRIES = 2;
    private final LiveAgentClient mClient;
    private final LiveAgentRequest mLiveAgentRequest;
    private int mNumberOfRetries = 0;

    public SwitchServerResponseHandler(ChatConfiguration chatConfiguration, BasicAsync<AvailabilityState> basicAsync, LiveAgentRequest liveAgentRequest, LiveAgentClient liveAgentClient) {
        super(chatConfiguration, basicAsync);
        this.mLiveAgentRequest = liveAgentRequest;
        this.mClient = liveAgentClient;
    }

    public void handleResult(Async<?> async, AvailabilityResponse availabilityResponse) {
        String liveAgentPod = availabilityResponse.getLiveAgentPod();
        if (shouldRedirect(liveAgentPod)) {
            async.removeHandler(this);
            this.mClient.setLiveAgentPod(liveAgentPod);
            this.mNumberOfRetries++;
            this.mClient.send(this.mLiveAgentRequest, AvailabilityResponse.class).addHandler(this);
            return;
        }
        super.handleResult(async, availabilityResponse);
    }

    private boolean shouldRedirect(String str) {
        if (!(!str.equalsIgnoreCase(this.mChatConfiguration.getLiveAgentPod())) || this.mNumberOfRetries >= 2) {
            return false;
        }
        return true;
    }
}
