package com.salesforce.android.chat.ui.internal.chatfeed.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.chat.ui.internal.chatfeed.model.ChatBanner;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class ChatBannerViewHolder extends RecyclerView.w implements DataBinder {
    private ViewGroup mBannerContainer;

    ChatBannerViewHolder(View view) {
        super(view);
        this.mBannerContainer = (ViewGroup) view;
    }

    public void setData(Object obj) {
        if (obj instanceof ChatBanner) {
            View inflate = LayoutInflater.from(this.itemView.getContext()).inflate(((ChatBanner) obj).getLayoutRes(), this.mBannerContainer, false);
            if (this.mBannerContainer.getChildCount() == 0) {
                this.mBannerContainer.addView(inflate);
            }
        }
    }

    public static class Builder implements ViewHolderBuilder<ChatBannerViewHolder> {
        private View mItemView;

        public int getKey() {
            return 8;
        }

        public int getLayoutResource() {
            return R.layout.chat_banner_container;
        }

        public ViewHolderBuilder<ChatBannerViewHolder> itemView(View view) {
            this.mItemView = view;
            return this;
        }

        public ChatBannerViewHolder build() {
            Arguments.checkNotNull(this.mItemView);
            ChatBannerViewHolder chatBannerViewHolder = new ChatBannerViewHolder(this.mItemView);
            this.mItemView = null;
            return chatBannerViewHolder;
        }
    }
}
