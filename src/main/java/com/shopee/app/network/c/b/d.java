package com.shopee.app.network.c.b;

import com.shopee.app.data.store.p;
import com.shopee.app.h.i;
import com.shopee.app.network.c.c;
import com.shopee.app.network.f;
import com.shopee.app.util.af;
import com.shopee.protocol.action.ResponseChatMsgid;
import java.io.IOException;
import java.util.ArrayList;

public class d extends c {
    public int a() {
        return 72;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseChatMsgid responseChatMsgid = (ResponseChatMsgid) f.f18486a.parseFrom(bArr, 0, i, ResponseChatMsgid.class);
        if (a(responseChatMsgid)) {
            p pVar = new p();
            ArrayList arrayList = new ArrayList();
            i.a a2 = i.a().a(responseChatMsgid.userid.intValue());
            if (af.a(responseChatMsgid.msgid)) {
                a2.f17665b = -1;
                a2.f17664a = -1;
                return;
            }
            for (Long longValue : responseChatMsgid.msgid) {
                long longValue2 = longValue.longValue();
                if (!pVar.a(longValue2)) {
                    arrayList.add(Long.valueOf(longValue2));
                }
            }
            a2.f17665b = responseChatMsgid.msgid.get(responseChatMsgid.msgid.size() - 1).longValue();
            if (pVar.a(a2.f17665b)) {
                a2.f17664a = pVar.a(Long.valueOf(a2.f17665b)).f();
            }
            if (!arrayList.isEmpty()) {
                new com.shopee.app.network.d.b.f().a(arrayList);
            }
        }
    }

    private boolean a(ResponseChatMsgid responseChatMsgid) {
        boolean z = responseChatMsgid.errcode.intValue() == 0;
        if (!z) {
            responseChatMsgid.errcode.intValue();
        }
        return z;
    }
}
