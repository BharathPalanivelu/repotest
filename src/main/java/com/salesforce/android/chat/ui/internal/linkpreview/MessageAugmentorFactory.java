package com.salesforce.android.chat.ui.internal.linkpreview;

import com.salesforce.android.chat.ui.internal.client.InternalChatUIClient;
import com.salesforce.android.service.common.ui.internal.messaging.MessageFeedModel;

public abstract class MessageAugmentorFactory {
    InternalChatUIClient mChatUIClient;
    MessageFeedModel mMessageFeedModel;

    public abstract MessageAugmentorManager createManagerWithAugmentors();

    public MessageAugmentorFactory(InternalChatUIClient internalChatUIClient, MessageFeedModel messageFeedModel) {
        this.mMessageFeedModel = messageFeedModel;
        this.mChatUIClient = internalChatUIClient;
    }

    public static MessageAugmentorFactory createChatFeedAugmentorFactory(InternalChatUIClient internalChatUIClient, MessageFeedModel messageFeedModel) {
        return new BasicMessageAugmentorFactory(internalChatUIClient, messageFeedModel);
    }
}
