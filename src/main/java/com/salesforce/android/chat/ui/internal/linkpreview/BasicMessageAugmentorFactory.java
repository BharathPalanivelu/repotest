package com.salesforce.android.chat.ui.internal.linkpreview;

import com.salesforce.android.chat.ui.ChatKnowledgeArticlePreviewDataProvider;
import com.salesforce.android.chat.ui.internal.client.InternalChatUIClient;
import com.salesforce.android.chat.ui.internal.linkpreview.BasicMessageAugmentorManager;
import com.salesforce.android.chat.ui.internal.linkpreview.LinkPreviewAugmentor;
import com.salesforce.android.service.common.http.HttpClient;
import com.salesforce.android.service.common.http.HttpFactory;
import com.salesforce.android.service.common.ui.internal.messaging.MessageFeedModel;
import com.salesforce.android.service.common.utilities.threading.JobQueue;
import com.salesforce.android.service.common.utilities.threading.PriorityThreadFactory;
import java.util.concurrent.Executors;

class BasicMessageAugmentorFactory extends MessageAugmentorFactory {
    private HttpClient mHttpClient;
    private JobQueue mJobQueue;

    BasicMessageAugmentorFactory(InternalChatUIClient internalChatUIClient, MessageFeedModel messageFeedModel) {
        super(internalChatUIClient, messageFeedModel);
        this.mJobQueue = new JobQueue(Executors.newCachedThreadPool(PriorityThreadFactory.background()));
        this.mHttpClient = HttpFactory.client().build();
    }

    BasicMessageAugmentorFactory(InternalChatUIClient internalChatUIClient, MessageFeedModel messageFeedModel, JobQueue jobQueue, HttpClient httpClient) {
        super(internalChatUIClient, messageFeedModel);
        this.mJobQueue = jobQueue;
        this.mHttpClient = httpClient;
    }

    public MessageAugmentorManager createManagerWithAugmentors() {
        MessageAugmentorManager createBasicChatFeedAugmentorManager = createBasicChatFeedAugmentorManager();
        if (this.mChatUIClient.isHyperlinkPreviewEnabled()) {
            LinkPreviewAugmentor.Builder jobQueue = new LinkPreviewAugmentor.Builder().httpClient(this.mHttpClient).jobQueue(this.mJobQueue);
            ChatKnowledgeArticlePreviewDataProvider knowledgeArticlePreviewDataProvider = this.mChatUIClient.getKnowledgeArticlePreviewDataProvider();
            jobQueue.knowledgeCommunityUrl(this.mChatUIClient.getKnowledgeCommunityUrl());
            jobQueue.knowledgeArticlePreviewDataProvider(knowledgeArticlePreviewDataProvider);
            createBasicChatFeedAugmentorManager.registerChatFeedAugmentor(jobQueue.build());
        }
        return createBasicChatFeedAugmentorManager;
    }

    private MessageAugmentorManager createBasicChatFeedAugmentorManager() {
        return new BasicMessageAugmentorManager.Builder(this.mJobQueue, this.mMessageFeedModel).build();
    }
}
