package com.salesforce.android.chat.core.internal.chatbot.response.message;

import com.google.a.i;
import com.google.a.j;
import com.google.a.k;
import com.google.a.l;
import com.google.a.p;
import com.salesforce.android.chat.core.internal.chatbot.response.message.ChatWindowButtonMenuMessage;
import java.lang.reflect.Type;

public class ChatButtonDeserializer implements k<ChatWindowButtonMenuMessage> {
    public ChatWindowButtonMenuMessage deserialize(l lVar, Type type, j jVar) throws p {
        i n = lVar.m().c("items").n();
        ChatWindowButtonMenuMessage chatWindowButtonMenuMessage = new ChatWindowButtonMenuMessage();
        for (int i = 0; i < n.a(); i++) {
            ChatWindowButtonMenuMessage.Button button = (ChatWindowButtonMenuMessage.Button) jVar.a(n.a(i), ChatWindowButtonMenuMessage.Button.class);
            button.setIndex(i);
            chatWindowButtonMenuMessage.addButton(button);
        }
        return chatWindowButtonMenuMessage;
    }
}
