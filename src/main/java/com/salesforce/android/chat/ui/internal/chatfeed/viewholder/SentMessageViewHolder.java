package com.salesforce.android.chat.ui.internal.chatfeed.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.chat.ui.internal.chatfeed.model.SentMessage;
import com.salesforce.android.service.common.ui.internal.messaging.GroupableView;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class SentMessageViewHolder extends RecyclerView.w implements DataBinder, GroupableView {
    private Space mFooterSpace;
    private TextView mMessage;
    private TextView mTimestamp;
    private ViewGroup mWarningContainer;
    private TextView mWarningText;

    private SentMessageViewHolder(View view) {
        super(view);
        this.mMessage = (TextView) view.findViewById(R.id.salesforce_sent_message_text);
        this.mTimestamp = (TextView) view.findViewById(R.id.salesforce_sent_message_timestamp);
        this.mFooterSpace = (Space) view.findViewById(R.id.salesforce_sent_message_footer_space);
        this.mWarningContainer = (ViewGroup) view.findViewById(R.id.salesforce_sent_message_warning);
        this.mWarningText = (TextView) view.findViewById(R.id.salesforce_sent_message_warning_text);
        this.mTimestamp.setVisibility(8);
        this.mWarningContainer.setVisibility(8);
        this.mFooterSpace.setVisibility(0);
    }

    public void setData(Object obj) {
        if (obj instanceof SentMessage) {
            SentMessage sentMessage = (SentMessage) obj;
            this.mMessage.setText(sentMessage.getMessageText());
            this.mMessage.setTextIsSelectable(true);
            int deliveryState = sentMessage.getDeliveryState();
            if (deliveryState == 0) {
                this.mMessage.setAlpha(0.3f);
            } else if (deliveryState == 1) {
                this.mMessage.setAlpha(1.0f);
                this.mWarningContainer.setVisibility(8);
            } else if (deliveryState == 3) {
                this.mMessage.setAlpha(1.0f);
                this.mWarningText.setText(R.string.chat_message_modified);
                this.mWarningContainer.setVisibility(0);
            } else if (deliveryState != 4) {
                this.mMessage.setAlpha(0.3f);
                this.mWarningText.setText(R.string.chat_message_delivery_failed);
                this.mWarningContainer.setVisibility(0);
            } else {
                this.mMessage.setAlpha(0.3f);
                this.mWarningText.setText(R.string.chat_message_not_sent_privacy);
                this.mWarningContainer.setVisibility(0);
            }
        }
    }

    public void onGroupView() {
        this.mFooterSpace.setVisibility(8);
    }

    public void onUngroupView() {
        this.mFooterSpace.setVisibility(0);
    }

    public static class Builder implements ViewHolderBuilder<SentMessageViewHolder> {
        private View mItemView;

        public int getKey() {
            return 2;
        }

        public int getLayoutResource() {
            return R.layout.salesforce_message_sent;
        }

        public Builder itemView(View view) {
            this.mItemView = view;
            return this;
        }

        public SentMessageViewHolder build() {
            Arguments.checkNotNull(this.mItemView);
            SentMessageViewHolder sentMessageViewHolder = new SentMessageViewHolder(this.mItemView);
            this.mItemView = null;
            return sentMessageViewHolder;
        }
    }
}
