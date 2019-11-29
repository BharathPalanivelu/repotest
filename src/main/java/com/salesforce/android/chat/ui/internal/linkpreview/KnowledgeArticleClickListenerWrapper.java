package com.salesforce.android.chat.ui.internal.linkpreview;

import android.content.Context;
import com.salesforce.android.chat.ui.ChatKnowledgeArticlePreviewClickListener;

public class KnowledgeArticleClickListenerWrapper implements ChatKnowledgeArticlePreviewClickListener {
    private final ChatKnowledgeArticlePreviewClickListener mCustomerListener;

    private KnowledgeArticleClickListenerWrapper(ChatKnowledgeArticlePreviewClickListener chatKnowledgeArticlePreviewClickListener) {
        this.mCustomerListener = chatKnowledgeArticlePreviewClickListener;
    }

    public static KnowledgeArticleClickListenerWrapper create(ChatKnowledgeArticlePreviewClickListener chatKnowledgeArticlePreviewClickListener) {
        return new KnowledgeArticleClickListenerWrapper(chatKnowledgeArticlePreviewClickListener);
    }

    public boolean onClick(Context context, String str) {
        ChatKnowledgeArticlePreviewClickListener chatKnowledgeArticlePreviewClickListener = this.mCustomerListener;
        if (chatKnowledgeArticlePreviewClickListener == null) {
            return false;
        }
        chatKnowledgeArticlePreviewClickListener.onClick(context, str);
        return true;
    }
}
