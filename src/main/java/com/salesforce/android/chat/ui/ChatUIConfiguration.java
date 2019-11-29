package com.salesforce.android.chat.ui;

import com.salesforce.android.chat.core.ChatConfiguration;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class ChatUIConfiguration {
    private final int mChatBotAvatarDrawableId;
    private final int mChatBotBannerLayoutId;
    private final ChatConfiguration mChatConfiguration;
    private final ChatEventListener mChatEventListener;
    private final boolean mDefaultToMinimized;
    private final boolean mDisablePreChatView;
    private final boolean mHideQueuePosition;
    private final boolean mHyperlinkPreviewEnabled;
    private ChatKnowledgeArticlePreviewClickListener mKnowledgeArticlePreviewClickListener;
    private ChatKnowledgeArticlePreviewDataProvider mKnowledgeArticlePreviewDataProvider;
    private String mKnowledgeCommunityUrl;
    private final String mPhotoDirectoryName;

    public static ChatUIConfiguration create(ChatConfiguration chatConfiguration) {
        return new Builder().chatConfiguration(chatConfiguration).build();
    }

    private ChatUIConfiguration(Builder builder) {
        this.mChatConfiguration = builder.mChatConfiguration;
        this.mPhotoDirectoryName = builder.mContentDirectoryName;
        this.mDisablePreChatView = builder.mDisablePreChatView;
        this.mHideQueuePosition = builder.mHideQueuePosition;
        this.mChatBotBannerLayoutId = builder.mChatBotBannerLayoutId;
        this.mChatBotAvatarDrawableId = builder.mChatBotAvatarDrawableId;
        this.mDefaultToMinimized = builder.mDefaultToMinimized;
        this.mHyperlinkPreviewEnabled = builder.mHyperlinkPreviewEnabled;
        this.mChatEventListener = builder.mChatEventListener;
        this.mKnowledgeCommunityUrl = builder.mKnowledgeCommunityUrl;
        this.mKnowledgeArticlePreviewDataProvider = builder.mKnowledgeArticlePreviewDataProvider;
        this.mKnowledgeArticlePreviewClickListener = builder.mKnowledgeArticlePreviewClickListener;
    }

    public ChatConfiguration getChatCoreConfiguration() {
        return this.mChatConfiguration;
    }

    public String getPhotoDirectoryName() {
        return this.mPhotoDirectoryName;
    }

    public boolean isPreChatDisabled() {
        return this.mDisablePreChatView;
    }

    public boolean isQueuePositionHidden() {
        return this.mHideQueuePosition;
    }

    public boolean isChatBotBannerEnabled() {
        return this.mChatBotBannerLayoutId != 0;
    }

    public int getChatBotBannerLayoutId() {
        return this.mChatBotBannerLayoutId;
    }

    public int getChatBotAvatarDrawableId() {
        return this.mChatBotAvatarDrawableId;
    }

    public boolean isDefaultToMinimized() {
        return this.mDefaultToMinimized;
    }

    public boolean isHyperlinkPreviewEnabled() {
        return this.mHyperlinkPreviewEnabled;
    }

    public ChatEventListener getChatEventListener() {
        return this.mChatEventListener;
    }

    public String getKnowledgeCommunityUrl() {
        return this.mKnowledgeCommunityUrl;
    }

    public ChatKnowledgeArticlePreviewDataProvider getKnowledgeArticlePreviewDataProvider() {
        return this.mKnowledgeArticlePreviewDataProvider;
    }

    public ChatKnowledgeArticlePreviewClickListener getKnowledgeArticlePreviewClickListener() {
        return this.mKnowledgeArticlePreviewClickListener;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public int mChatBotAvatarDrawableId;
        /* access modifiers changed from: private */
        public int mChatBotBannerLayoutId;
        /* access modifiers changed from: private */
        public ChatConfiguration mChatConfiguration;
        /* access modifiers changed from: private */
        public ChatEventListener mChatEventListener;
        /* access modifiers changed from: private */
        public String mContentDirectoryName;
        /* access modifiers changed from: private */
        public boolean mDefaultToMinimized = true;
        /* access modifiers changed from: private */
        public boolean mDisablePreChatView;
        /* access modifiers changed from: private */
        public boolean mHideQueuePosition;
        /* access modifiers changed from: private */
        public boolean mHyperlinkPreviewEnabled = true;
        /* access modifiers changed from: private */
        public ChatKnowledgeArticlePreviewClickListener mKnowledgeArticlePreviewClickListener;
        /* access modifiers changed from: private */
        public ChatKnowledgeArticlePreviewDataProvider mKnowledgeArticlePreviewDataProvider;
        /* access modifiers changed from: private */
        public String mKnowledgeCommunityUrl;

        public Builder chatConfiguration(ChatConfiguration chatConfiguration) {
            this.mChatConfiguration = chatConfiguration;
            return this;
        }

        public Builder photoDirectoryName(String str) {
            this.mContentDirectoryName = str;
            return this;
        }

        public Builder disablePreChatView(boolean z) {
            this.mDisablePreChatView = z;
            return this;
        }

        public Builder hideQueuePosition(boolean z) {
            this.mHideQueuePosition = z;
            return this;
        }

        public Builder enableChatBotBanner(int i) {
            this.mChatBotBannerLayoutId = i;
            return this;
        }

        public Builder chatBotAvatar(int i) {
            this.mChatBotAvatarDrawableId = i;
            return this;
        }

        public Builder defaultToMinimized(boolean z) {
            this.mDefaultToMinimized = z;
            return this;
        }

        public Builder enableHyperlinkPreview(boolean z) {
            this.mHyperlinkPreviewEnabled = z;
            return this;
        }

        public Builder knowledgeCommunityUrl(String str) {
            this.mKnowledgeCommunityUrl = str;
            return this;
        }

        public Builder knowledgeArticlePreviewDataProvider(ChatKnowledgeArticlePreviewDataProvider chatKnowledgeArticlePreviewDataProvider) {
            this.mKnowledgeArticlePreviewDataProvider = chatKnowledgeArticlePreviewDataProvider;
            return this;
        }

        public Builder knowledgeArticlePreviewClickListener(ChatKnowledgeArticlePreviewClickListener chatKnowledgeArticlePreviewClickListener) {
            this.mKnowledgeArticlePreviewClickListener = chatKnowledgeArticlePreviewClickListener;
            return this;
        }

        public Builder chatEventListener(ChatEventListener chatEventListener) {
            this.mChatEventListener = chatEventListener;
            return this;
        }

        public ChatUIConfiguration build() {
            Arguments.checkNotNull(this.mChatConfiguration, "Please provide a ChatConfiguration instance.");
            return new ChatUIConfiguration(this);
        }
    }
}
