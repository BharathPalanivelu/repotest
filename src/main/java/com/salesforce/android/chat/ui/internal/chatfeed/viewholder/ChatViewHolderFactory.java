package com.salesforce.android.chat.ui.internal.chatfeed.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.b.h;
import androidx.recyclerview.widget.RecyclerView;
import com.salesforce.android.chat.ui.ChatKnowledgeArticlePreviewClickListener;
import com.salesforce.android.chat.ui.internal.chatfeed.model.AgentHasJoinedConferenceMessage;
import com.salesforce.android.chat.ui.internal.chatfeed.model.AgentHasLeftConferenceMessage;
import com.salesforce.android.chat.ui.internal.chatfeed.model.AgentIsTypingMessage;
import com.salesforce.android.chat.ui.internal.chatfeed.model.ChatBanner;
import com.salesforce.android.chat.ui.internal.chatfeed.model.ChatBotTransferNoAgentAvailableMessage;
import com.salesforce.android.chat.ui.internal.chatfeed.model.ChatBotTransferWaitingIndicator;
import com.salesforce.android.chat.ui.internal.chatfeed.model.ChatButtonMenuMessage;
import com.salesforce.android.chat.ui.internal.chatfeed.model.ChatMenuMessage;
import com.salesforce.android.chat.ui.internal.chatfeed.model.HorizontalRule;
import com.salesforce.android.chat.ui.internal.chatfeed.model.MessageSpacer;
import com.salesforce.android.chat.ui.internal.chatfeed.model.Notice;
import com.salesforce.android.chat.ui.internal.chatfeed.model.ReceivedLinkPreviewMessage;
import com.salesforce.android.chat.ui.internal.chatfeed.model.ReceivedMessage;
import com.salesforce.android.chat.ui.internal.chatfeed.model.SentMessage;
import com.salesforce.android.chat.ui.internal.chatfeed.model.SentPhotoMessage;
import com.salesforce.android.chat.ui.internal.chatfeed.viewholder.AgentHasJoinedConferenceViewHolder;
import com.salesforce.android.chat.ui.internal.chatfeed.viewholder.AgentHasLeftConferenceViewHolder;
import com.salesforce.android.chat.ui.internal.chatfeed.viewholder.AgentIsTypingViewHolder;
import com.salesforce.android.chat.ui.internal.chatfeed.viewholder.ChatBannerViewHolder;
import com.salesforce.android.chat.ui.internal.chatfeed.viewholder.ChatBotTransferNoAgentAvailableMessageViewHolder;
import com.salesforce.android.chat.ui.internal.chatfeed.viewholder.ChatBotTransferViewHolder;
import com.salesforce.android.chat.ui.internal.chatfeed.viewholder.ChatButtonMenuViewHolder;
import com.salesforce.android.chat.ui.internal.chatfeed.viewholder.ChatMenuViewHolder;
import com.salesforce.android.chat.ui.internal.chatfeed.viewholder.HorizontalRuleViewHolder;
import com.salesforce.android.chat.ui.internal.chatfeed.viewholder.MessageSpacerViewHolder;
import com.salesforce.android.chat.ui.internal.chatfeed.viewholder.NoticeViewHolder;
import com.salesforce.android.chat.ui.internal.chatfeed.viewholder.ReceivedLinkPreviewMessageViewHolder;
import com.salesforce.android.chat.ui.internal.chatfeed.viewholder.ReceivedMessageViewHolder;
import com.salesforce.android.chat.ui.internal.chatfeed.viewholder.SentMessageViewHolder;
import com.salesforce.android.chat.ui.internal.chatfeed.viewholder.SentPhotoMessageViewHolder;
import com.salesforce.android.chat.ui.internal.state.AvatarCache;
import com.salesforce.android.chat.ui.internal.util.SparseArrayUtil;
import com.salesforce.android.service.common.ui.internal.messaging.ViewHolderFactory;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class ChatViewHolderFactory implements ViewHolderFactory {
    private final AvatarCache mAvatarCache;
    private final ChatKnowledgeArticlePreviewClickListener mClickListener;
    private h<Class<?>> mItemTypes;
    private h<ViewHolderBuilder> mViewHolderBuilders;
    private h<Class<? extends RecyclerView.w>> mViewHolderTypes;

    private ChatViewHolderFactory(Builder builder) {
        this.mAvatarCache = builder.mAvatarCache;
        this.mClickListener = builder.mClickListener;
        this.mViewHolderBuilders = SparseArrayUtil.asSparseArray(builder.mViewHolderBuilders, ViewHolderBuilder.class);
        this.mViewHolderTypes = builder.mViewHolderTypes;
        this.mItemTypes = builder.mItemTypes;
    }

    public int getItemViewType(Object obj) {
        for (int i = 0; i < this.mItemTypes.b(); i++) {
            if (this.mItemTypes.d(i) == obj.getClass()) {
                return this.mItemTypes.c(i);
            }
        }
        throw new IllegalArgumentException("Unknown item type: " + obj.getClass().getCanonicalName());
    }

    public RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i, LayoutInflater layoutInflater) {
        if (this.mViewHolderBuilders.a(i) != null) {
            ViewHolderBuilder a2 = this.mViewHolderBuilders.a(i);
            View inflate = layoutInflater.inflate(a2.getLayoutResource(), viewGroup, false);
            if (a2 instanceof AvatarViewHolderBuilder) {
                ((AvatarViewHolderBuilder) a2).avatarCache(this.mAvatarCache);
            }
            if (a2 instanceof ReceivedLinkPreviewMessageViewHolder.Builder) {
                ((ReceivedLinkPreviewMessageViewHolder.Builder) a2).clickListener(this.mClickListener);
            }
            return a2.itemView(inflate).build();
        }
        throw new IllegalArgumentException("Unknown viewType: " + i);
    }

    public void onBindViewHolder(RecyclerView.w wVar, int i, Object obj) {
        if (this.mViewHolderTypes.a(i) == null) {
            throw new IllegalArgumentException("Unknown ViewHolder for viewType: " + i);
        } else if (wVar instanceof DataBinder) {
            ((DataBinder) wVar).setData(obj);
        }
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public AvatarCache mAvatarCache;
        /* access modifiers changed from: private */
        public ChatKnowledgeArticlePreviewClickListener mClickListener;
        /* access modifiers changed from: private */
        public h<Class<?>> mItemTypes = new h<>();
        /* access modifiers changed from: private */
        public ViewHolderBuilder<? extends RecyclerView.w>[] mViewHolderBuilders;
        /* access modifiers changed from: private */
        public h<Class<? extends RecyclerView.w>> mViewHolderTypes = new h<>();

        public Builder avatarCache(AvatarCache avatarCache) {
            this.mAvatarCache = avatarCache;
            return this;
        }

        public Builder clickListener(ChatKnowledgeArticlePreviewClickListener chatKnowledgeArticlePreviewClickListener) {
            this.mClickListener = chatKnowledgeArticlePreviewClickListener;
            return this;
        }

        /* access modifiers changed from: package-private */
        @SafeVarargs
        public final Builder viewHolderBuilders(ViewHolderBuilder<? extends RecyclerView.w>... viewHolderBuilderArr) {
            this.mViewHolderBuilders = viewHolderBuilderArr;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder addViewHolderType(int i, Class<? extends RecyclerView.w> cls) {
            this.mViewHolderTypes.b(i, cls);
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder addItemType(int i, Class<?> cls) {
            this.mItemTypes.b(i, cls);
            return this;
        }

        public ChatViewHolderFactory build() {
            if (this.mViewHolderBuilders == null) {
                viewHolderBuilders(new ReceivedMessageViewHolder.Builder(), new SentMessageViewHolder.Builder(), new HorizontalRuleViewHolder.Builder(), new MessageSpacerViewHolder.Builder(), new SentPhotoMessageViewHolder.Builder(), new ChatMenuViewHolder.Builder(), new ChatButtonMenuViewHolder.Builder(), new ChatBannerViewHolder.Builder(), new ChatBotTransferViewHolder.Builder(), new ChatBotTransferNoAgentAvailableMessageViewHolder.Builder(), new NoticeViewHolder.Builder(), new AgentIsTypingViewHolder.Builder(), new ReceivedLinkPreviewMessageViewHolder.Builder(), new AgentHasJoinedConferenceViewHolder.Builder().avatarCache(this.mAvatarCache), new AgentHasLeftConferenceViewHolder.Builder());
            }
            if (this.mViewHolderTypes.b() == 0) {
                addViewHolderType(1, ReceivedMessageViewHolder.class);
                addViewHolderType(2, SentMessageViewHolder.class);
                addViewHolderType(3, HorizontalRuleViewHolder.class);
                addViewHolderType(4, MessageSpacerViewHolder.class);
                addViewHolderType(5, SentPhotoMessageViewHolder.class);
                addViewHolderType(6, ChatMenuViewHolder.class);
                addViewHolderType(7, ChatButtonMenuViewHolder.class);
                addViewHolderType(8, ChatBannerViewHolder.class);
                addViewHolderType(9, ChatBotTransferViewHolder.class);
                addViewHolderType(10, ChatBotTransferNoAgentAvailableMessageViewHolder.class);
                addViewHolderType(11, NoticeViewHolder.class);
                addViewHolderType(12, AgentIsTypingViewHolder.class);
                addViewHolderType(13, ReceivedLinkPreviewMessageViewHolder.class);
                addViewHolderType(14, AgentHasJoinedConferenceViewHolder.class);
                addViewHolderType(15, AgentHasLeftConferenceViewHolder.class);
            }
            if (this.mItemTypes.b() == 0) {
                addItemType(1, ReceivedMessage.class);
                addItemType(2, SentMessage.class);
                addItemType(3, HorizontalRule.class);
                addItemType(4, MessageSpacer.class);
                addItemType(5, SentPhotoMessage.class);
                addItemType(6, ChatMenuMessage.class);
                addItemType(7, ChatButtonMenuMessage.class);
                addItemType(8, ChatBanner.class);
                addItemType(9, ChatBotTransferWaitingIndicator.class);
                addItemType(10, ChatBotTransferNoAgentAvailableMessage.class);
                addItemType(11, Notice.class);
                addItemType(12, AgentIsTypingMessage.class);
                addItemType(13, ReceivedLinkPreviewMessage.class);
                addItemType(14, AgentHasJoinedConferenceMessage.class);
                addItemType(15, AgentHasLeftConferenceMessage.class);
            }
            Arguments.checkNotNull(this.mViewHolderBuilders);
            Arguments.check(this.mViewHolderTypes.b() > 0);
            Arguments.check(this.mItemTypes.b() > 0);
            return new ChatViewHolderFactory(this);
        }
    }
}
