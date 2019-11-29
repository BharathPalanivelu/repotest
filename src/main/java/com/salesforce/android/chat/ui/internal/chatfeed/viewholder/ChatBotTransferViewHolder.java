package com.salesforce.android.chat.ui.internal.chatfeed.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import androidx.recyclerview.widget.RecyclerView;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.chat.ui.internal.chatfeed.model.ChatBotTransferWaitingIndicator;
import com.salesforce.android.service.common.ui.views.SalesforceTextView;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class ChatBotTransferViewHolder extends RecyclerView.w implements DataBinder {
    private Button mCancelButton;
    private Context mContext;
    private SalesforceTextView mNoticeTextView;

    private ChatBotTransferViewHolder(View view) {
        super(view);
        this.mContext = view.getContext();
        this.mCancelButton = (Button) view.findViewById(R.id.chatbot_transfer_cancel_button);
        this.mNoticeTextView = (SalesforceTextView) view.findViewById(R.id.salesforce_notice_text);
    }

    public void setData(final Object obj) {
        if (obj instanceof ChatBotTransferWaitingIndicator) {
            this.mCancelButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ((ChatBotTransferWaitingIndicator) obj).setCancelButtonSelected();
                }
            });
            this.mNoticeTextView.setText(this.mContext.getResources().getString(R.string.chatbot_transferring_connecting_message));
        }
    }

    public static class Builder implements ViewHolderBuilder<ChatBotTransferViewHolder> {
        private View mItemView;

        public int getKey() {
            return 9;
        }

        public int getLayoutResource() {
            return R.layout.chatbot_transfer_waiting_indicator;
        }

        public ViewHolderBuilder<ChatBotTransferViewHolder> itemView(View view) {
            this.mItemView = view;
            return this;
        }

        public ChatBotTransferViewHolder build() {
            Arguments.checkNotNull(this.mItemView);
            ChatBotTransferViewHolder chatBotTransferViewHolder = new ChatBotTransferViewHolder(this.mItemView);
            this.mItemView = null;
            return chatBotTransferViewHolder;
        }
    }
}
