package com.shopee.app.network.c.b;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.p;
import com.shopee.app.database.orm.bean.DBChatToOffer;
import com.shopee.app.network.f;
import com.shopee.app.util.af;
import com.shopee.protocol.action.Chat;
import com.shopee.protocol.action.ResponseChatList;
import java.io.IOException;
import java.util.ArrayList;

public class c extends com.shopee.app.network.c.c {
    public int a() {
        return 71;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseChatList responseChatList = (ResponseChatList) f.f18486a.parseFrom(bArr, 0, i, ResponseChatList.class);
        if (a(responseChatList)) {
            if (!af.a(responseChatList.chat)) {
                p pVar = new p();
                ArrayList arrayList = new ArrayList();
                for (Chat a2 : responseChatList.chat) {
                    DBChatToOffer dBChatToOffer = new DBChatToOffer();
                    b.a(a2, dBChatToOffer);
                    arrayList.add(dBChatToOffer);
                }
                pVar.c(arrayList);
            }
            com.garena.android.appkit.b.b.a("CHAT_OFFER_LIST_LOAD", new a(), b.a.NETWORK_BUS);
        }
    }

    private boolean a(ResponseChatList responseChatList) {
        if (responseChatList.errcode.intValue() == 0) {
            return true;
        }
        com.garena.android.appkit.b.b.a("CHAT_OFFER_LIST_ERROR", new a(), b.a.NETWORK_BUS);
        return false;
    }
}
