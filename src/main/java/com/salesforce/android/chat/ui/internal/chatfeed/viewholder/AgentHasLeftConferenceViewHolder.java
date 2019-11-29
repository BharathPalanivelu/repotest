package com.salesforce.android.chat.ui.internal.chatfeed.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.chat.ui.internal.chatfeed.model.AgentHasLeftConferenceMessage;
import com.salesforce.android.chat.ui.internal.util.AgentNameUtil;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class AgentHasLeftConferenceViewHolder extends RecyclerView.w implements DataBinder {
    private TextView mTextView;

    public AgentHasLeftConferenceViewHolder(View view) {
        super(view);
        this.mTextView = (TextView) view.findViewById(R.id.agent_left_conference_textview);
    }

    public void setData(Object obj) {
        if (obj instanceof AgentHasLeftConferenceMessage) {
            AgentHasLeftConferenceMessage agentHasLeftConferenceMessage = (AgentHasLeftConferenceMessage) obj;
            String format = new SimpleDateFormat("HH:mm a", Locale.getDefault()).format(agentHasLeftConferenceMessage.getDate());
            String agentFirstName = AgentNameUtil.getAgentFirstName(agentHasLeftConferenceMessage.getAgentName());
            this.mTextView.setText(this.mTextView.getResources().getString(R.string.agent_has_left_conference_message, new Object[]{agentFirstName, format}));
        }
    }

    public static class Builder implements ViewHolderBuilder<AgentHasLeftConferenceViewHolder> {
        private View mItemView;

        public int getKey() {
            return 15;
        }

        public int getLayoutResource() {
            return R.layout.chat_agent_left_conference;
        }

        public ViewHolderBuilder<AgentHasLeftConferenceViewHolder> itemView(View view) {
            this.mItemView = view;
            return this;
        }

        public AgentHasLeftConferenceViewHolder build() {
            Arguments.checkNotNull(this.mItemView);
            AgentHasLeftConferenceViewHolder agentHasLeftConferenceViewHolder = new AgentHasLeftConferenceViewHolder(this.mItemView);
            this.mItemView = null;
            return agentHasLeftConferenceViewHolder;
        }
    }
}
