package com.shopee.app.network.c.b;

import com.garena.android.appkit.b.b;
import com.shopee.app.data.store.p;
import com.shopee.app.database.orm.bean.DBChatToOffer;
import com.shopee.app.h.o;
import com.shopee.app.network.c.c;
import com.shopee.app.network.f;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;
import java.util.List;

public class a extends c {
    public int a() {
        return 136;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        if (b(responseCommon)) {
            com.shopee.app.network.d.b.a aVar = (com.shopee.app.network.d.b.a) o.a().f(responseCommon.requestid);
            if (aVar != null) {
                p pVar = new p();
                List<DBChatToOffer> b2 = pVar.b(aVar.b());
                for (DBChatToOffer f2 : b2) {
                    f2.f(aVar.c());
                }
                pVar.c(b2);
            }
            b.a("ARCHIVE_CHAT_SUCCESS", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    }

    private boolean b(ResponseCommon responseCommon) {
        if (responseCommon.errcode.intValue() == 0) {
            return true;
        }
        a(responseCommon);
        return false;
    }

    public void a(ResponseCommon responseCommon) {
        b.a("ARCHIVE_CHAT_FAIL", new com.garena.android.appkit.b.a(new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon)), b.a.NETWORK_BUS);
    }

    public void a(String str) {
        ResponseCommon.Builder builder = new ResponseCommon.Builder();
        builder.errcode = -100;
        a(builder.build());
    }
}
