package com.shopee.app.network.c.c;

import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.av;
import com.shopee.app.data.store.o;
import com.shopee.app.database.orm.bean.chatP2P.DBChat;
import com.shopee.app.network.c.c;
import com.shopee.app.network.f;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.live.livestreaming.data.entity.DanmaKuEntity;
import com.shopee.protocol.action.Chat;
import com.shopee.protocol.action.ResponseChatList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class d extends c {
    public int a() {
        return DanmaKuEntity.MESSAGE_PUBLIC;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseChatList responseChatList = (ResponseChatList) f.f18486a.parseFrom(bArr, 0, i, ResponseChatList.class);
        c(responseChatList.requestid);
        a(responseChatList);
    }

    private void a(final ResponseChatList responseChatList) {
        org.a.a.a.a(new Runnable() {
            public void run() {
                d.this.c().a(responseChatList);
            }
        }, "GetPChatListProcessor", "low_priority_processor");
    }

    public void a(String str) {
        c().a();
    }

    /* access modifiers changed from: private */
    public a c() {
        return ar.f().e().newGetPchatListProcessor();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private n f17884a;

        /* renamed from: b  reason: collision with root package name */
        private av f17885b;

        /* renamed from: c  reason: collision with root package name */
        private ChatBadgeStore f17886c;

        /* renamed from: d  reason: collision with root package name */
        private o f17887d;

        public a(n nVar, o oVar, ChatBadgeStore chatBadgeStore, av avVar) {
            this.f17884a = nVar;
            this.f17885b = avVar;
            this.f17886c = chatBadgeStore;
            this.f17887d = oVar;
        }

        public void a(ResponseChatList responseChatList) {
            if (b(responseChatList)) {
                if (!af.a(responseChatList.chat)) {
                    ArrayList arrayList = new ArrayList(responseChatList.chat.size());
                    for (Chat next : responseChatList.chat) {
                        DBChat a2 = this.f17885b.a(next.pchatid.longValue());
                        if (a2 == null) {
                            a2 = new DBChat();
                        }
                        DBChat.a(next, a2);
                        arrayList.add(a2);
                        if (next.last_read.longValue() < next.last_msgid.longValue()) {
                            this.f17886c.setChatUnreadServer(next.userid.intValue());
                        }
                    }
                    this.f17885b.a((List<DBChat>) arrayList);
                }
                com.shopee.app.network.d.c.d dVar = (com.shopee.app.network.d.c.d) com.shopee.app.h.o.a().f(responseChatList.requestid);
                if (dVar == null || dVar.b()) {
                    if (dVar != null) {
                        this.f17887d.b(dVar.c());
                    }
                    if (b.a(responseChatList.next_timestamp) > 0) {
                        new com.shopee.app.network.d.c.d().a(responseChatList.next_timestamp.intValue(), true);
                    } else if (com.shopee.app.network.c.h.f.f17922a) {
                        com.shopee.app.network.c.h.f.f17922a = false;
                        new com.shopee.app.network.d.b.c().g();
                    }
                } else {
                    this.f17887d.a(dVar.c());
                    if (b.a(responseChatList.next_timestamp) > 0) {
                        new com.shopee.app.network.d.c.d().a(responseChatList.next_timestamp.intValue(), false);
                    } else {
                        this.f17887d.d();
                        if (com.shopee.app.network.c.h.f.f17922a) {
                            com.shopee.app.network.c.h.f.f17922a = false;
                            new com.shopee.app.network.d.b.c().g();
                        }
                    }
                }
                this.f17884a.a().bD.a(Integer.valueOf(b.a(responseChatList.next_timestamp))).a();
            }
        }

        private boolean b(ResponseChatList responseChatList) {
            if (responseChatList.errcode.intValue() == 0) {
                return true;
            }
            this.f17884a.a("CMD_GET_PCHATLIST_ERROR", new com.garena.android.appkit.b.a(responseChatList.errcode));
            return false;
        }

        public void a() {
            this.f17884a.a("CMD_GET_PCHATLIST_ERROR", new com.garena.android.appkit.b.a(-100));
        }
    }
}
