package com.salesforce.android.chat.core;

import com.salesforce.android.chat.core.model.ChatFooterMenu;
import com.salesforce.android.chat.core.model.ChatWindowButtonMenu;
import com.salesforce.android.chat.core.model.ChatWindowMenu;

public interface ChatBotListener {
    void onChatButtonMenuReceived(ChatWindowButtonMenu chatWindowButtonMenu);

    void onChatFooterMenuReceived(ChatFooterMenu chatFooterMenu);

    void onChatMenuReceived(ChatWindowMenu chatWindowMenu);
}
