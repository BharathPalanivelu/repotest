package com.salesforce.android.chat.ui.internal.chatfeed.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.chat.ui.internal.chatfeed.model.Notice;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class NoticeViewHolder extends RecyclerView.w implements DataBinder {
    private TextView mText;

    private NoticeViewHolder(View view) {
        super(view);
        this.mText = (TextView) view.findViewById(R.id.salesforce_notice_text);
    }

    public void setData(Object obj) {
        if (obj instanceof Notice) {
            this.mText.setText(this.itemView.getContext().getString(((Notice) obj).getNoticeText()));
        }
    }

    public static class Builder implements ViewHolderBuilder<NoticeViewHolder> {
        private View mItemView;

        public int getKey() {
            return 11;
        }

        public int getLayoutResource() {
            return R.layout.salesforce_message_notice;
        }

        public Builder itemView(View view) {
            this.mItemView = view;
            return this;
        }

        public NoticeViewHolder build() {
            Arguments.checkNotNull(this.mItemView);
            NoticeViewHolder noticeViewHolder = new NoticeViewHolder(this.mItemView);
            this.mItemView = null;
            return noticeViewHolder;
        }
    }
}
