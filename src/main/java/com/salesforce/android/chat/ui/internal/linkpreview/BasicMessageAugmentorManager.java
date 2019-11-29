package com.salesforce.android.chat.ui.internal.linkpreview;

import com.salesforce.android.chat.ui.internal.chatfeed.model.ReceivedMessage;
import com.salesforce.android.service.common.ui.internal.messaging.MessageFeedModel;
import com.salesforce.android.service.common.utilities.threading.JobQueue;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BasicMessageAugmentorManager implements MessageAugmentorManager {
    private final List<MessageAugmentor> mAugmentorList;
    private final MessageFeedModel mFeedModel;

    private BasicMessageAugmentorManager(Builder builder) {
        this.mFeedModel = builder.mMessageFeedModel;
        this.mAugmentorList = new ArrayList();
    }

    public void registerChatFeedAugmentor(MessageAugmentor messageAugmentor) {
        this.mAugmentorList.add(messageAugmentor);
    }

    public void unregisterChatFeedAugmentor(MessageAugmentor messageAugmentor) {
        this.mAugmentorList.remove(messageAugmentor);
    }

    public void onMessageAdded(ReceivedMessage receivedMessage) {
        notifyAugmentors(receivedMessage);
    }

    public List<MessageAugmentor> augmentorList() {
        return Collections.unmodifiableList(this.mAugmentorList);
    }

    /* access modifiers changed from: package-private */
    public void notifyAugmentors(ReceivedMessage receivedMessage) {
        for (MessageAugmentor onMessageAdded : this.mAugmentorList) {
            onMessageAdded.onMessageAdded(receivedMessage, this.mFeedModel);
        }
    }

    public static class Builder {
        private JobQueue mJobQueue;
        /* access modifiers changed from: private */
        public MessageFeedModel mMessageFeedModel;

        public Builder(JobQueue jobQueue, MessageFeedModel messageFeedModel) {
            this.mJobQueue = jobQueue;
            this.mMessageFeedModel = messageFeedModel;
        }

        public BasicMessageAugmentorManager build() {
            Arguments.checkNotNull(this.mJobQueue);
            Arguments.checkNotNull(this.mMessageFeedModel);
            return new BasicMessageAugmentorManager(this);
        }
    }
}
