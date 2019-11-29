package com.shopee.app.network.c.b;

import com.garena.android.appkit.b.b;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.av;
import com.shopee.app.data.store.p;
import com.shopee.app.database.orm.bean.DBChatMessage;
import com.shopee.app.database.orm.bean.chatP2P.DBChat;
import com.shopee.app.h.m;
import com.shopee.app.h.o;
import com.shopee.app.network.c.c;
import com.shopee.app.network.d.b.d;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class f extends c {
    public int a() {
        return 59;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) com.shopee.app.network.f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        c().a(responseCommon);
    }

    public void a(String str) {
        c().a(str, new com.shopee.app.network.c.d.a(-100, (String) null, (ResponseCommon) null));
    }

    private a c() {
        return ar.f().e().sendChatProcessor();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final av f17846a;

        /* renamed from: b  reason: collision with root package name */
        private p f17847b;

        public a(p pVar, av avVar) {
            this.f17847b = pVar;
            this.f17846a = avVar;
        }

        public void a(ResponseCommon responseCommon) {
            if (!b(responseCommon)) {
                a(responseCommon.requestid, new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon));
                return;
            }
            if (!this.f17847b.a(responseCommon.msgid.longValue())) {
                DBChatMessage a2 = this.f17847b.a(responseCommon.requestid);
                if (a2 != null) {
                    a2.a(responseCommon.msgid.longValue());
                    a2.a("");
                    a2.c(responseCommon.chatid.longValue());
                    a2.f(b.a(responseCommon.pchatid));
                    a2.f(0);
                    a2.a(responseCommon.timestamp.intValue());
                    a2.g(b.a(responseCommon.msg_opt));
                    this.f17847b.a(a2);
                    DBChat a3 = this.f17846a.a(b.a(responseCommon.pchatid));
                    if (a3 == null) {
                        new d(0).g();
                    } else {
                        a3.d(a2.b());
                        a3.e(a2.f());
                        a3.a("");
                        a3.g(0);
                        this.f17846a.a(a3);
                    }
                    a(a2);
                }
            }
            com.shopee.app.util.g.a e2 = o.a().e(responseCommon.requestid);
            if (e2 != null) {
                e2.a();
            }
        }

        private void a(DBChatMessage dBChatMessage) {
            com.garena.android.appkit.b.b.a("CHAT_SEND_SUCCESS", new com.garena.android.appkit.b.a(com.shopee.app.d.b.a.a(dBChatMessage, m.a(dBChatMessage.h()))), b.a.NETWORK_BUS);
        }

        /* access modifiers changed from: private */
        public void a(String str, com.shopee.app.network.c.d.a aVar) {
            com.shopee.app.util.g.a e2 = o.a().e(str);
            if (e2 == null) {
                return;
            }
            if (aVar.f17892a != -100) {
                e2.a(aVar);
            } else {
                e2.a(aVar);
            }
        }

        private boolean b(ResponseCommon responseCommon) {
            return responseCommon.errcode.intValue() == 0;
        }
    }
}
