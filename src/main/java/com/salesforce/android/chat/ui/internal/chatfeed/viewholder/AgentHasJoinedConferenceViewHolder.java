package com.salesforce.android.chat.ui.internal.chatfeed.viewholder;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.chat.ui.internal.chatfeed.model.AgentHasJoinedConferenceMessage;
import com.salesforce.android.chat.ui.internal.state.AvatarCache;
import com.salesforce.android.chat.ui.internal.util.AgentNameUtil;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class AgentHasJoinedConferenceViewHolder extends RecyclerView.w implements DataBinder {
    private TextView mAgentInitial;
    private AvatarCache mAvatarCache;
    private View mInitialAvatarContainer;
    private TextView mMessageTextView;

    private AgentHasJoinedConferenceViewHolder(View view, AvatarCache avatarCache) {
        super(view);
        this.mMessageTextView = (TextView) view.findViewById(R.id.agent_joined_conference_textview);
        this.mAgentInitial = (TextView) view.findViewById(R.id.agent_joined_avatar_text);
        this.mInitialAvatarContainer = view.findViewById(R.id.agent_joined_conference_message_container);
        this.mAvatarCache = avatarCache;
    }

    public void setData(Object obj) {
        if (obj instanceof AgentHasJoinedConferenceMessage) {
            Resources resources = this.mMessageTextView.getResources();
            AgentHasJoinedConferenceMessage agentHasJoinedConferenceMessage = (AgentHasJoinedConferenceMessage) obj;
            String agentFirstName = AgentNameUtil.getAgentFirstName(agentHasJoinedConferenceMessage.getAgentName());
            String agentName = agentHasJoinedConferenceMessage.getAgentName();
            String format = new SimpleDateFormat("HH:mm a", Locale.getDefault()).format(agentHasJoinedConferenceMessage.getDate());
            String agentInitial = AgentNameUtil.getAgentInitial(agentHasJoinedConferenceMessage.getAgentName());
            String string = resources.getString(R.string.agent_has_joined_conference_message, new Object[]{agentFirstName, format});
            setupAvatarColor(agentName);
            this.mAgentInitial.setText(agentInitial);
            this.mMessageTextView.setText(string);
        }
    }

    private void setupAvatarColor(String str) {
        this.mInitialAvatarContainer.setBackground(this.mAvatarCache.getInitialDrawableFor(str));
    }

    public static class Builder implements ViewHolderBuilder<AgentHasJoinedConferenceViewHolder> {
        private AvatarCache avatarCache;
        private View mItemView;

        public int getKey() {
            return 14;
        }

        public Builder avatarCache(AvatarCache avatarCache2) {
            this.avatarCache = avatarCache2;
            return this;
        }

        public int getLayoutResource() {
            return R.layout.chat_agent_joined_conference;
        }

        public ViewHolderBuilder<AgentHasJoinedConferenceViewHolder> itemView(View view) {
            this.mItemView = view;
            return this;
        }

        public AgentHasJoinedConferenceViewHolder build() {
            Arguments.checkNotNull(this.mItemView);
            AgentHasJoinedConferenceViewHolder agentHasJoinedConferenceViewHolder = new AgentHasJoinedConferenceViewHolder(this.mItemView, this.avatarCache);
            this.mItemView = null;
            return agentHasJoinedConferenceViewHolder;
        }
    }
}
