package com.salesforce.android.service.common.liveagentclient;

import com.salesforce.android.service.common.liveagentclient.response.MessagesResponse;

public interface MessagesListener {
    void onMessagesResponse(MessagesResponse messagesResponse);
}
