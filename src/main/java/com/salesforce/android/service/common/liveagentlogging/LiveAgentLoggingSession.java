package com.salesforce.android.service.common.liveagentlogging;

import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import com.salesforce.android.service.common.liveagentlogging.internal.response.BatchedEventsResponse;
import com.salesforce.android.service.common.utilities.control.Async;
import java.util.Collection;

public interface LiveAgentLoggingSession {

    public interface Listener {
        void onConnected();

        void onEnded();

        void onFlush(Async<BatchedEventsResponse> async);
    }

    LiveAgentLoggingSession addLoggingSessionListener(Listener listener);

    Async<BatchedEventsResponse> flush();

    void queue(BaseEvent baseEvent);

    void queue(Collection<? extends BaseEvent> collection);

    LiveAgentLoggingSession removeLoggingSessionListener(Listener listener);
}
