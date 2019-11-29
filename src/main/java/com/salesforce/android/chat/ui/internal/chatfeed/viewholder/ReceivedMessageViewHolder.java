package com.salesforce.android.chat.ui.internal.chatfeed.viewholder;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.text.util.Linkify;
import android.view.View;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.chat.ui.internal.chatfeed.model.ReceivedMessage;
import com.salesforce.android.chat.ui.internal.state.AvatarCache;
import com.salesforce.android.service.common.ui.internal.messaging.GroupableView;
import com.salesforce.android.service.common.ui.views.SalesforceTextView;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class ReceivedMessageViewHolder extends RecyclerView.w implements DataBinder, GroupableView {
    private ImageView mAgentAvatar;
    private SalesforceTextView mAgentInitialAvatar;
    private TextView mAgentName;
    private final AvatarCache mAvatarCache;
    private View mAvatarContainer;
    private View mFooter;
    private Space mFooterSpace;
    private TextView mMessage;
    private TextView mTimestamp;

    private ReceivedMessageViewHolder(View view, AvatarCache avatarCache) {
        super(view);
        this.mAvatarCache = avatarCache;
        this.mMessage = (TextView) view.findViewById(R.id.salesforce_received_message_text);
        this.mAgentName = (TextView) view.findViewById(R.id.salesforce_received_message_agent_name);
        this.mTimestamp = (TextView) view.findViewById(R.id.salesforce_received_message_timestamp);
        this.mAvatarContainer = view.findViewById(R.id.salesforce_agent_avatar_container);
        this.mAgentAvatar = (ImageView) view.findViewById(R.id.salesforce_agent_avatar);
        this.mAgentInitialAvatar = (SalesforceTextView) view.findViewById(R.id.agent_initial_avatar_textview);
        this.mFooter = view.findViewById(R.id.salesforce_received_message_footer);
        this.mFooterSpace = (Space) view.findViewById(R.id.salesforce_received_message_footer_space);
        this.mFooter.setVisibility(8);
        this.mFooterSpace.setVisibility(0);
    }

    public void setData(Object obj) {
        if (obj instanceof ReceivedMessage) {
            ReceivedMessage receivedMessage = (ReceivedMessage) obj;
            this.mMessage.setText(parseHtmlText(receivedMessage.getMessageText()));
            String agentName = receivedMessage.getAgentName();
            Linkify.addLinks(this.mMessage, 15);
            this.mMessage.setTextIsSelectable(true);
            this.mMessage.setLinksClickable(true);
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
            this.mAgentAvatar.setImageDrawable(this.mAvatarCache.getAvatar(receivedMessage.getId()));
            this.mAgentAvatar.setVisibility(0);
            this.mAgentInitialAvatar.setVisibility(8);
        }
    }

    public void onGroupView() {
        this.mAvatarContainer.setVisibility(4);
        this.mFooterSpace.setVisibility(8);
    }

    public void onUngroupView() {
        this.mAvatarContainer.setVisibility(0);
        this.mFooterSpace.setVisibility(0);
    }

    private Spanned parseHtmlText(String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Html.fromHtml(str, 63);
        }
        return Html.fromHtml(str);
    }

    public static class Builder implements AvatarViewHolderBuilder<ReceivedMessageViewHolder> {
        private AvatarCache mAvatarCache;
        private View mItemView;

        public int getKey() {
            return 1;
        }

        public int getLayoutResource() {
            return R.layout.salesforce_message_received;
        }

        public Builder itemView(View view) {
            this.mItemView = view;
            return this;
        }

        public Builder avatarCache(AvatarCache avatarCache) {
            this.mAvatarCache = avatarCache;
            return this;
        }

        public ReceivedMessageViewHolder build() {
            Arguments.checkNotNull(this.mItemView);
            ReceivedMessageViewHolder receivedMessageViewHolder = new ReceivedMessageViewHolder(this.mItemView, this.mAvatarCache);
            this.mItemView = null;
            return receivedMessageViewHolder;
        }
    }
}
