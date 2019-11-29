package com.salesforce.android.chat.core.internal.availability;

import com.salesforce.android.chat.core.ChatConfiguration;
import com.salesforce.android.chat.core.internal.availability.response.AvailabilityResponse;
import com.salesforce.android.chat.core.model.AvailabilityState;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;

class AvailabilityResponseHandler implements Async.Handler<AvailabilityResponse> {
    private final ServiceLogger log = ServiceLogging.getLogger(SwitchServerResponseHandler.class);
    final ChatConfiguration mChatConfiguration;
    private final BasicAsync<AvailabilityState> mOutput;

    AvailabilityResponseHandler(ChatConfiguration chatConfiguration, BasicAsync<AvailabilityState> basicAsync) {
        this.mChatConfiguration = chatConfiguration;
        this.mOutput = basicAsync;
    }

    public void handleResult(Async<?> async, AvailabilityResponse availabilityResponse) {
        this.mOutput.setResult(availabilityResponse);
    }

    public void handleComplete(Async<?> async) {
        this.mOutput.complete();
    }

    public void handleError(Async<?> async, Throwable th) {
        this.mOutput.setResult(new AvailabilityResponse(AvailabilityState.Status.Unknown, this.mChatConfiguration.getLiveAgentPod()));
        this.mOutput.setError(th);
        this.log.error("Error encountered checking agent availability\n{}", th.getLocalizedMessage());
    }
}
