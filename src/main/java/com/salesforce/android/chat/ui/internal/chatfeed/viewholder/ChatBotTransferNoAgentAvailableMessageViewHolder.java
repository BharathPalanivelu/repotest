package com.salesforce.android.chat.ui.internal.chatfeed.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class ChatBotTransferNoAgentAvailableMessageViewHolder extends RecyclerView.w implements DataBinder {
    public void setData(Object obj) {
    }

    ChatBotTransferNoAgentAvailableMessageViewHolder(View view) {
        super(view);
    }

    public static class Builder implements ViewHolderBuilder<ChatBotTransferNoAgentAvailableMessageViewHolder> {
        private View mItemView;

        public int getKey() {
            return 10;
        }

        public int getLayoutResource() {
            return R.layout.chat_bot_transfer_no_agents_available_message;
        }

        public ViewHolderBuilder<ChatBotTransferNoAgentAvailableMessageViewHolder> itemView(View view) {
            this.mItemView = view;
            return this;
        }

        public ChatBotTransferNoAgentAvailableMessageViewHolder build() {
            Arguments.checkNotNull(this.mItemView);
            ChatBotTransferNoAgentAvailableMessageViewHolder chatBotTransferNoAgentAvailableMessageViewHolder = new ChatBotTransferNoAgentAvailableMessageViewHolder(this.mItemView);
            this.mItemView = null;
            return chatBotTransferNoAgentAvailableMessageViewHolder;
        }
    }
}
