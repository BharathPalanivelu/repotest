package com.shopee.app.network.c.b;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.p;
import com.shopee.app.database.orm.bean.DBChatMessage;
import com.shopee.app.network.c.c;
import com.shopee.app.network.f;
import com.shopee.protocol.action.ChatMsg;
import com.shopee.protocol.action.ResponseChatMsg;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class e extends c {
    public int a() {
        return 73;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseChatMsg responseChatMsg = (ResponseChatMsg) f.f18486a.parseFrom(bArr, 0, i, ResponseChatMsg.class);
        if (a(responseChatMsg)) {
            p pVar = new p();
            ArrayList arrayList = new ArrayList();
            for (ChatMsg next : responseChatMsg.msg) {
                if (next.msgid != null && !pVar.a(next.msgid.longValue())) {
                    DBChatMessage dBChatMessage = new DBChatMessage();
                    b.a(next, dBChatMessage);
                    arrayList.add(dBChatMessage);
                }
            }
            pVar.a((List<DBChatMessage>) arrayList);
            com.garena.android.appkit.b.b.a("CHAT_MESSAGES_SAVED", new a(), b.a.NETWORK_BUS);
        }
    }

    private boolean a(ResponseChatMsg responseChatMsg) {
        boolean z = responseChatMsg.errcode.intValue() == 0;
        if (!z) {
            responseChatMsg.errcode.intValue();
        }
        return z;
    }
}
