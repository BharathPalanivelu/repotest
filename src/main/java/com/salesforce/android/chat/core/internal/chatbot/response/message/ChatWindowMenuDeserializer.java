package com.salesforce.android.chat.core.internal.chatbot.response.message;

import com.google.a.i;
import com.google.a.j;
import com.google.a.k;
import com.google.a.l;
import com.google.a.p;
import com.salesforce.android.chat.core.internal.chatbot.response.message.ChatWindowMenuMessage;
import java.lang.reflect.Type;

public class ChatWindowMenuDeserializer implements k<ChatWindowMenuMessage> {
    public ChatWindowMenuMessage deserialize(l lVar, Type type, j jVar) throws p {
        String c2 = lVar.m().b("header") ? lVar.m().c("header").c() : null;
        i n = lVar.m().c("items").n();
        ChatWindowMenuMessage chatWindowMenuMessage = new ChatWindowMenuMessage(c2);
        for (int i = 0; i < n.a(); i++) {
            ChatWindowMenuMessage.Item item = (ChatWindowMenuMessage.Item) jVar.a(n.a(i), ChatWindowMenuMessage.Item.class);
            item.setIndex(i);
            chatWindowMenuMessage.addMenuItem(item);
        }
        return chatWindowMenuMessage;
    }
}
