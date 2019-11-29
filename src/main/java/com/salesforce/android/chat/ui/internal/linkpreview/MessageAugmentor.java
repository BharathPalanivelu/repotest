package com.salesforce.android.chat.ui.internal.linkpreview;

import com.salesforce.android.chat.ui.internal.chatfeed.model.ReceivedMessage;
import com.salesforce.android.service.common.ui.internal.messaging.MessageFeedModel;

interface MessageAugmentor {
    void onMessageAdded(ReceivedMessage receivedMessage, MessageFeedModel messageFeedModel);
}
