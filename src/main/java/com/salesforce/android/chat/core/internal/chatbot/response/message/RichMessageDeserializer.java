package com.salesforce.android.chat.core.internal.chatbot.response.message;

import com.google.a.k;

public class RichMessageDeserializer implements k<RichMessage> {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.salesforce.android.chat.core.internal.chatbot.response.message.RichMessage deserialize(com.google.a.l r4, java.lang.reflect.Type r5, com.google.a.j r6) throws com.google.a.p {
        /*
            r3 = this;
            com.google.a.o r4 = r4.m()
            java.lang.String r5 = "type"
            com.google.a.l r5 = r4.c(r5)
            java.lang.String r5 = r5.c()
            int r0 = r5.hashCode()
            r1 = -585227558(0xffffffffdd1e22da, float:-7.1218186E17)
            r2 = 1
            if (r0 == r1) goto L_0x0028
            r1 = 1242159879(0x4a09db07, float:2258625.8)
            if (r0 == r1) goto L_0x001e
            goto L_0x0032
        L_0x001e:
            java.lang.String r0 = "ChatWindowMenu"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0032
            r0 = 0
            goto L_0x0033
        L_0x0028:
            java.lang.String r0 = "ChatWindowButton"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0032
            r0 = 1
            goto L_0x0033
        L_0x0032:
            r0 = -1
        L_0x0033:
            if (r0 == 0) goto L_0x0049
            if (r0 == r2) goto L_0x003d
            com.salesforce.android.chat.core.internal.chatbot.response.message.RichMessage r6 = new com.salesforce.android.chat.core.internal.chatbot.response.message.RichMessage
            r6.<init>(r5, r4)
            return r6
        L_0x003d:
            com.salesforce.android.chat.core.internal.chatbot.response.message.RichMessage r0 = new com.salesforce.android.chat.core.internal.chatbot.response.message.RichMessage
            java.lang.Class<com.salesforce.android.chat.core.internal.chatbot.response.message.ChatWindowButtonMenuMessage> r1 = com.salesforce.android.chat.core.internal.chatbot.response.message.ChatWindowButtonMenuMessage.class
            java.lang.Object r4 = r6.a(r4, r1)
            r0.<init>(r5, r4)
            return r0
        L_0x0049:
            com.salesforce.android.chat.core.internal.chatbot.response.message.RichMessage r0 = new com.salesforce.android.chat.core.internal.chatbot.response.message.RichMessage
            java.lang.Class<com.salesforce.android.chat.core.internal.chatbot.response.message.ChatWindowMenuMessage> r1 = com.salesforce.android.chat.core.internal.chatbot.response.message.ChatWindowMenuMessage.class
            java.lang.Object r4 = r6.a(r4, r1)
            r0.<init>(r5, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.android.chat.core.internal.chatbot.response.message.RichMessageDeserializer.deserialize(com.google.a.l, java.lang.reflect.Type, com.google.a.j):com.salesforce.android.chat.core.internal.chatbot.response.message.RichMessage");
    }
}
