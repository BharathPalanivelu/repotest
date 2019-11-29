package com.salesforce.android.chat.ui.internal.chatfeed.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.w;
import com.salesforce.android.chat.ui.internal.util.SparseArrayEntry;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

interface ViewHolderBuilder<VH extends RecyclerView.w> extends SparseArrayEntry {
    public static final int TYPE_AGENT_IS_TYPING_MESSAGE = 12;
    public static final int TYPE_AGENT_JOINED_CONFERENCE = 14;
    public static final int TYPE_AGENT_LEFT_CONFERENCE = 15;
    public static final int TYPE_CHATBOT_TRANSFER_NO_AGENTS_AVAILABLE_MESSAGE = 10;
    public static final int TYPE_CHATBOT_TRANSFER_WAITING_INDICATOR = 9;
    public static final int TYPE_CHAT_BANNER = 8;
    public static final int TYPE_CHAT_BUTTON_MENU = 7;
    public static final int TYPE_CHAT_MENU = 6;
    public static final int TYPE_HORIZONTAL_RULE = 3;
    public static final int TYPE_MESSAGE_SPACER = 4;
    public static final int TYPE_NOTICE = 11;
    public static final int TYPE_RECEIVED_LINK_PREVIEW = 13;
    public static final int TYPE_RECEIVED_MESSAGE = 1;
    public static final int TYPE_SENT_MESSAGE = 2;
    public static final int TYPE_SENT_PHOTO_MESSAGE = 5;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewHolderType {
    }

    VH build();

    int getKey();

    int getLayoutResource();

    ViewHolderBuilder<VH> itemView(View view);
}
