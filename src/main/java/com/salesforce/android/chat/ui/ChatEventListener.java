package com.salesforce.android.chat.ui;

import com.salesforce.android.chat.core.model.AgentInformation;
import com.salesforce.android.chat.core.model.ChatFooterMenu;
import com.salesforce.android.chat.core.model.ChatMessage;
import com.salesforce.android.chat.core.model.ChatWindowButtonMenu;
import com.salesforce.android.chat.core.model.ChatWindowMenu;

public interface ChatEventListener {
    void agentIsTyping(boolean z);

    void agentJoined(AgentInformation agentInformation);

    void didReceiveMessage(ChatMessage chatMessage);

    void didSelectButtonItem(ChatWindowButtonMenu.Button button);

    void didSelectFooterMenuItem(ChatFooterMenu.MenuItem menuItem);

    void didSelectMenuItem(ChatWindowMenu.MenuItem menuItem);

    void processedOutgoingMessage(String str);

    void transferToButtonInitiated();
}
