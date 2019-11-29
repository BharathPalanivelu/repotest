package com.salesforce.android.chat.ui.internal.chatfeed.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.chat.ui.internal.chatfeed.model.HorizontalRule;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class HorizontalRuleViewHolder extends RecyclerView.w implements DataBinder {
    private TextView mText;

    private HorizontalRuleViewHolder(View view) {
        super(view);
        this.mText = (TextView) view.findViewById(R.id.salesforce_horizontal_rule_text);
    }

    public void setData(Object obj) {
        if (obj instanceof HorizontalRule) {
            this.mText.setText(((HorizontalRule) obj).getRuleText());
        }
    }

    public static class Builder implements ViewHolderBuilder<HorizontalRuleViewHolder> {
        private View mItemView;

        public int getKey() {
            return 3;
        }

        public int getLayoutResource() {
            return R.layout.salesforce_message_horizontal_rule;
        }

        public Builder itemView(View view) {
            this.mItemView = view;
            return this;
        }

        public HorizontalRuleViewHolder build() {
            Arguments.checkNotNull(this.mItemView);
            HorizontalRuleViewHolder horizontalRuleViewHolder = new HorizontalRuleViewHolder(this.mItemView);
            this.mItemView = null;
            return horizontalRuleViewHolder;
        }
    }
}
