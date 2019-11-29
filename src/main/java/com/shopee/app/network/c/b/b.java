package com.shopee.app.network.c.b;

import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.f.m;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.av;
import com.shopee.app.data.store.p;
import com.shopee.app.database.orm.bean.DBChatMessage;
import com.shopee.app.database.orm.bean.chatP2P.DBChat;
import com.shopee.app.network.c.c;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ChatMsg;
import java.io.IOException;
import java.util.ArrayList;

public class b extends c {
    public int a() {
        return 60;
    }

    public void c(byte[] bArr, int i) throws IOException {
        a((ChatMsg) f.f18486a.parseFrom(bArr, 0, i, ChatMsg.class));
    }

    private void a(final ChatMsg chatMsg) {
        org.a.a.a.a(new Runnable() {
            public void run() {
                ar.f().e().chatArrivedProcessor().a(chatMsg);
            }
        }, "ChatArrivedProcessor", "low_priority_processor");
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final UserInfo f17840a;

        /* renamed from: b  reason: collision with root package name */
        private final av f17841b;

        /* renamed from: c  reason: collision with root package name */
        private final n f17842c;

        /* renamed from: d  reason: collision with root package name */
        private p f17843d;

        /* renamed from: e  reason: collision with root package name */
        private ChatBadgeStore f17844e;

        /* renamed from: f  reason: collision with root package name */
        private m f17845f;

        public a(n nVar, p pVar, av avVar, ChatBadgeStore chatBadgeStore, m mVar, UserInfo userInfo) {
            this.f17842c = nVar;
            this.f17843d = pVar;
            this.f17844e = chatBadgeStore;
            this.f17841b = avVar;
            this.f17840a = userInfo;
            this.f17845f = mVar;
        }

        public void a(ChatMsg chatMsg) {
            if (!this.f17843d.a(chatMsg.msgid.longValue())) {
                if (chatMsg.content != null) {
                    DBChatMessage dBChatMessage = new DBChatMessage();
                    com.shopee.app.d.b.b.a(chatMsg, dBChatMessage);
                    DBChat a2 = this.f17841b.a(com.shopee.app.d.b.b.a(chatMsg.pchatid));
                    if (a2 == null) {
                        this.f17845f.a(true);
                    } else {
                        a2.d(dBChatMessage.b());
                        a2.a("");
                        a2.g(0);
                        a2.e(dBChatMessage.f());
                        this.f17841b.a(a2);
                    }
                    this.f17842c.a().q.a(com.shopee.app.d.b.a.a(dBChatMessage, this.f17840a.isMyShop(dBChatMessage.h()))).a();
                    this.f17843d.a(dBChatMessage);
                } else {
                    DBChat a3 = this.f17841b.a(com.shopee.app.d.b.b.a(chatMsg.pchatid));
                    if (a3 == null) {
                        this.f17845f.a();
                    } else {
                        a3.d(chatMsg.msgid.longValue());
                        a3.a("");
                        this.f17841b.a(a3);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(chatMsg.from_userid);
                    arrayList.add(chatMsg.to_userid);
                    arrayList.add(chatMsg.msgid);
                    this.f17842c.a().dh.a(arrayList).a();
                }
            }
            if (chatMsg.from_userid.intValue() != this.f17840a.getUserId()) {
                this.f17844e.incrementChatCount(chatMsg.from_userid.intValue(), chatMsg.msgid.longValue());
                if (this.f17844e.getTotalCount() <= 200) {
                    this.f17842c.a().bH.a(Integer.valueOf(this.f17844e.getTotalCount())).a();
                }
            }
            new com.shopee.app.network.d.b.b().a(chatMsg.msgid, chatMsg.pchatid);
            this.f17842c.a("CHAT_MESSAGE_ARRIVED", new com.garena.android.appkit.b.a());
        }
    }
}
