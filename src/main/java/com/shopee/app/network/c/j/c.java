package com.shopee.app.network.c.j;

import com.garena.android.appkit.b.b;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.av;
import com.shopee.app.data.store.p;
import com.shopee.app.data.viewmodel.chat.ChatOfferMessage;
import com.shopee.app.database.orm.bean.DBChatMessage;
import com.shopee.app.database.orm.bean.chatP2P.DBChat;
import com.shopee.app.h.o;
import com.shopee.app.network.d.az;
import com.shopee.app.network.d.b.d;
import com.shopee.app.network.f;
import com.shopee.app.util.au;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseCommon;
import com.shopee.protocol.shop.ChatOfferInfo;
import java.io.IOException;

public class c extends com.shopee.app.network.c.c {
    public int a() {
        return 75;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        c().a(responseCommon);
    }

    private a c() {
        return ar.f().e().makeOfferProcessor();
    }

    public void a(String str) {
        ResponseCommon.Builder builder = new ResponseCommon.Builder();
        builder.errcode(-100);
        builder.requestid(str);
        c().b(builder.build());
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final av f17997a;

        /* renamed from: b  reason: collision with root package name */
        private final n f17998b;

        /* renamed from: c  reason: collision with root package name */
        private p f17999c;

        public a(p pVar, av avVar, n nVar) {
            this.f17999c = pVar;
            this.f17997a = avVar;
            this.f17998b = nVar;
        }

        public void a(ResponseCommon responseCommon) {
            if (c(responseCommon) && !this.f17999c.a(responseCommon.msgid.longValue())) {
                DBChatMessage a2 = this.f17999c.a(responseCommon.requestid);
                if (a2 != null) {
                    a2.a(responseCommon.msgid.longValue());
                    a2.a("");
                    a2.c(responseCommon.chatid.longValue());
                    a2.f(responseCommon.pchatid.longValue());
                    a2.f(0);
                    a2.a(responseCommon.timestamp.intValue());
                    try {
                        a2.a(new ChatOfferInfo.Builder((ChatOfferInfo) f.f18486a.parseFrom(a2.c(), 0, a2.c().length, ChatOfferInfo.class)).offerid(responseCommon.offerid).build().toByteArray());
                    } catch (Exception unused) {
                    }
                    this.f17999c.a(a2);
                    ChatOfferMessage chatOfferMessage = (ChatOfferMessage) com.shopee.app.d.b.a.a(a2, false);
                    DBChat a3 = this.f17997a.a(responseCommon.pchatid.longValue());
                    if (a3 == null) {
                        new d(0).g();
                    } else {
                        a3.d(a2.b());
                        a3.e(a2.f());
                        a3.a("");
                        a3.g(0);
                        this.f17997a.a(a3);
                    }
                    az f2 = o.a().f(responseCommon.requestid);
                    if (f2 != null && (f2 instanceof com.shopee.app.network.d.g.c)) {
                        com.shopee.app.network.d.g.c cVar = (com.shopee.app.network.d.g.c) f2;
                        ar.f().e().tracker().a(cVar.d(), "IDR", au.a(cVar.b()), cVar.c(), cVar.e());
                    }
                    this.f17998b.a("MAKE_OFFER_SUCCESS", new com.garena.android.appkit.b.a(chatOfferMessage));
                    this.f17998b.a("CHAT_SEND_SUCCESS", new com.garena.android.appkit.b.a(chatOfferMessage));
                }
            }
        }

        private boolean c(ResponseCommon responseCommon) {
            boolean z = responseCommon.errcode.intValue() == 0;
            if (!z) {
                b(responseCommon);
            }
            return z;
        }

        public void b(ResponseCommon responseCommon) {
            p pVar = new p();
            DBChatMessage a2 = pVar.a(responseCommon.requestid);
            if (a2 != null) {
                pVar.b(a2);
            }
            b.a("OFFER_ACTION_FAILED", new com.garena.android.appkit.b.a(new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon)), b.a.NETWORK_BUS);
        }
    }
}
