package com.salesforce.android.chat.ui.internal.chatfeed.viewholder;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.chat.ui.internal.chatfeed.model.AgentIsTypingMessage;
import com.salesforce.android.chat.ui.internal.state.AvatarCache;
import com.salesforce.android.service.common.ui.internal.messaging.GroupableView;
import com.salesforce.android.service.common.ui.views.SalesforceTextView;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class AgentIsTypingViewHolder extends RecyclerView.w implements DataBinder, GroupableView {
    private ImageView mAgentAvatar;
    private SalesforceTextView mAgentInitialAvatar;
    private AvatarCache mAvatarCache;
    private View mAvatarContainer;

    AgentIsTypingViewHolder(View view, AvatarCache avatarCache) {
        super(view);
        this.mAvatarCache = avatarCache;
        this.mAvatarContainer = view.findViewById(R.id.salesforce_agent_avatar_container);
        this.mAgentAvatar = (ImageView) view.findViewById(R.id.salesforce_agent_avatar);
        this.mAgentInitialAvatar = (SalesforceTextView) view.findViewById(R.id.agent_initial_avatar_textview);
    }

    public void setData(Object obj) {
        if (obj instanceof AgentIsTypingMessage) {
            AgentIsTypingMessage agentIsTypingMessage = (AgentIsTypingMessage) obj;
            String agentName = agentIsTypingMessage.getAgentName();
            AvatarCache avatarCache = this.mAvatarCache;
            if (avatarCache == null) {
                return;
            }
            if (avatarCache.getInitialAvatar(agentName) != null) {
                this.mAgentInitialAvatar.setText(this.mAvatarCache.getInitialAvatar(agentName));
                this.mAgentAvatar.setVisibility(8);
                this.mAgentInitialAvatar.setVisibility(0);
                this.mAgentInitialAvatar.setBackground(this.mAvatarCache.getInitialDrawableFor(agentName));
                return;
            }
            this.mAvatarCache.getAvatar(agentIsTypingMessage.getAgentId());
            this.mAgentAvatar.setVisibility(0);
            this.mAgentInitialAvatar.setVisibility(8);
        }
    }

    public void onGroupView() {
        this.mAvatarContainer.setVisibility(4);
    }

    public void onUngroupView() {
        this.mAvatarContainer.setVisibility(0);
    }

    public static class Builder implements AvatarViewHolderBuilder<AgentIsTypingViewHolder> {
        private AvatarCache mAvatarCache;
        private View mView;

        public int getKey() {
            return 12;
        }

        public int getLayoutResource() {
            return R.layout.salesforce_message_agent_is_typing;
        }

        public ViewHolderBuilder<AgentIsTypingViewHolder> itemView(View view) {
            this.mView = view;
            return this;
        }

        public AgentIsTypingViewHolder build() {
            Arguments.checkNotNull(this.mView);
            return new AgentIsTypingViewHolder(this.mView, this.mAvatarCache);
        }

        public AvatarViewHolderBuilder avatarCache(AvatarCache avatarCache) {
            this.mAvatarCache = avatarCache;
            return this;
        }
    }
}
