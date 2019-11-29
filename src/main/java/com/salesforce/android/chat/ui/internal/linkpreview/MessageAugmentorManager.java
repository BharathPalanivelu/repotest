package com.salesforce.android.chat.ui.internal.linkpreview;

import com.salesforce.android.chat.ui.internal.chatfeed.model.ReceivedMessage;
import java.util.List;

public interface MessageAugmentorManager {
    List<MessageAugmentor> augmentorList();

    void onMessageAdded(ReceivedMessage receivedMessage);

    void registerChatFeedAugmentor(MessageAugmentor messageAugmentor);

    void unregisterChatFeedAugmentor(MessageAugmentor messageAugmentor);
}
