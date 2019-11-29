package com.salesforce.android.chat.ui.internal.linkpreview;

import com.salesforce.android.chat.ui.ChatKnowledgeArticlePreviewDataHelper;
import com.salesforce.android.chat.ui.ChatKnowledgeArticlePreviewDataProvider;

public class KnowledgeArticleDataProviderWrapper implements ChatKnowledgeArticlePreviewDataProvider {
    private final ChatKnowledgeArticlePreviewDataProvider mCustomerProvider;

    private KnowledgeArticleDataProviderWrapper(ChatKnowledgeArticlePreviewDataProvider chatKnowledgeArticlePreviewDataProvider) {
        this.mCustomerProvider = chatKnowledgeArticlePreviewDataProvider;
    }

    public static ChatKnowledgeArticlePreviewDataProvider create(ChatKnowledgeArticlePreviewDataProvider chatKnowledgeArticlePreviewDataProvider) {
        return new KnowledgeArticleDataProviderWrapper(chatKnowledgeArticlePreviewDataProvider);
    }

    public boolean onPreviewDataRequested(String str, ChatKnowledgeArticlePreviewDataHelper chatKnowledgeArticlePreviewDataHelper) {
        ChatKnowledgeArticlePreviewDataProvider chatKnowledgeArticlePreviewDataProvider = this.mCustomerProvider;
        if (chatKnowledgeArticlePreviewDataProvider == null) {
            return false;
        }
        chatKnowledgeArticlePreviewDataProvider.onPreviewDataRequested(str, chatKnowledgeArticlePreviewDataHelper);
        return true;
    }
}
