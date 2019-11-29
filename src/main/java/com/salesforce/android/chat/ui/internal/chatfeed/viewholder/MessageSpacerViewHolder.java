package com.salesforce.android.chat.ui.internal.chatfeed.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class MessageSpacerViewHolder extends RecyclerView.w {
    private MessageSpacerViewHolder(View view) {
        super(view);
    }

    public static class Builder implements ViewHolderBuilder<MessageSpacerViewHolder> {
        private View mItemView;

        public int getKey() {
            return 4;
        }

        public int getLayoutResource() {
            return R.layout.chat_message_spacer;
        }

        public Builder itemView(View view) {
            this.mItemView = view;
            return this;
        }

        public MessageSpacerViewHolder build() {
            Arguments.checkNotNull(this.mItemView);
            MessageSpacerViewHolder messageSpacerViewHolder = new MessageSpacerViewHolder(this.mItemView);
            this.mItemView = null;
            return messageSpacerViewHolder;
        }
    }
}
