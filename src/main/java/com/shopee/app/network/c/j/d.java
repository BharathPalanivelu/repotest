package com.shopee.app.network.c.j;

import com.garena.android.appkit.b.b;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.av;
import com.shopee.app.data.store.p;
import com.shopee.app.data.viewmodel.chat.ChatOfferMessage;
import com.shopee.app.database.orm.bean.DBChatMessage;
import com.shopee.app.database.orm.bean.chatP2P.DBChat;
import com.shopee.app.network.c.c;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class d extends c {
    public int a() {
        return 76;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        c().a(responseCommon);
    }

    private a c() {
        return ar.f().e().operateOfferProcessor();
    }

    public void a(String str) {
        ResponseCommon.Builder builder = new ResponseCommon.Builder();
        builder.errcode(-100);
        builder.requestid(str);
        c().c(builder.build());
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final av f18000a;

        /* renamed from: b  reason: collision with root package name */
        private final n f18001b;

        /* renamed from: c  reason: collision with root package name */
        private p f18002c;

        /* renamed from: d  reason: collision with root package name */
        private UserInfo f18003d;

        public a(p pVar, av avVar, UserInfo userInfo, n nVar) {
            this.f18002c = pVar;
            this.f18000a = avVar;
            this.f18003d = userInfo;
            this.f18001b = nVar;
        }

        public void a(ResponseCommon responseCommon) {
            if (b(responseCommon) && !this.f18002c.a(responseCommon.msgid.longValue())) {
                DBChatMessage a2 = this.f18002c.a(responseCommon.requestid);
                if (a2 != null) {
                    a2.a(responseCommon.msgid.longValue());
                    a2.a("");
                    a2.c(responseCommon.chatid.longValue());
                    a2.f(0);
                    a2.a(responseCommon.timestamp.intValue());
                    this.f18002c.a(a2);
                    ChatOfferMessage chatOfferMessage = (ChatOfferMessage) com.shopee.app.d.b.a.a(a2, this.f18003d.isMyShop(a2.h()));
                    DBChat a3 = this.f18000a.a(responseCommon.pchatid.longValue());
                    if (a3 == null) {
                        new com.shopee.app.network.d.b.d(0).g();
                    } else {
                        a3.d(a2.b());
                        a3.e(a2.f());
                        a3.a("");
                        a3.g(0);
                        this.f18000a.a(a3);
                    }
                    this.f18001b.a("REPLY_OFFER_SUCCESS", new com.garena.android.appkit.b.a(chatOfferMessage));
                    this.f18001b.a("CHAT_SEND_SUCCESS", new com.garena.android.appkit.b.a(chatOfferMessage));
                }
            }
        }

        private boolean b(ResponseCommon responseCommon) {
            boolean z = responseCommon.errcode.intValue() == 0;
            if (!z) {
                c(responseCommon);
            }
            return z;
        }

        /* access modifiers changed from: private */
        public void c(ResponseCommon responseCommon) {
            p pVar = new p();
            DBChatMessage a2 = pVar.a(responseCommon.requestid);
            if (a2 != null) {
                pVar.b(a2);
            }
            b.a("OFFER_ACTION_FAILED", new com.garena.android.appkit.b.a(new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon)), b.a.NETWORK_BUS);
        }
    }
}
