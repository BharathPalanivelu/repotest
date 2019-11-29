package com.salesforce.android.chat.core.internal.chatbot.response.message;

import com.google.a.i;
import com.google.a.j;
import com.google.a.k;
import com.google.a.l;
import com.google.a.p;
import com.salesforce.android.chat.core.internal.chatbot.response.message.ChatFooterMenuMessage;
import java.lang.reflect.Type;

public class ChatFooterMenuDeserializer implements k<ChatFooterMenuMessage> {
    public ChatFooterMenuMessage deserialize(l lVar, Type type, j jVar) throws p {
        i n = lVar.n();
        ChatFooterMenuMessage chatFooterMenuMessage = new ChatFooterMenuMessage();
        for (int i = 0; i < n.a(); i++) {
            ChatFooterMenuMessage.Item item = (ChatFooterMenuMessage.Item) jVar.a(n.a(i), ChatFooterMenuMessage.Item.class);
            item.setIndex(i);
            chatFooterMenuMessage.addMenuItem(item);
        }
        return chatFooterMenuMessage;
    }
}
