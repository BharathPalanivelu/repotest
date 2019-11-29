package com.shopee.app.ui.chat2.search;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.f;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.data.viewmodel.UserData;
import com.shopee.app.data.viewmodel.chat.ChatMessage;
import com.shopee.app.data.viewmodel.chat2.ChatItem2;
import java.util.List;

public final class c implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final b f20875a;

    /* renamed from: b  reason: collision with root package name */
    private final g f20876b = new g() {
        public void onEvent(a aVar) {
            c.this.f20875a.a(((Integer) aVar.data).intValue());
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f20877c = new g() {
        public void onEvent(a aVar) {
            c.this.f20875a.a((List<UserData>) (List) aVar.data);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f20878d = new g() {
        public void onEvent(a aVar) {
            c.this.f20875a.b((List<UserData>) (List) aVar.data);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f20879e = new g() {
        public void onEvent(a aVar) {
            c.this.f20875a.d((String) aVar.data);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final g f20880f = new g() {
        public void onEvent(a aVar) {
            c.this.f20875a.e();
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final g f20881g = new g() {
        public void onEvent(a aVar) {
            c.this.f20875a.c((List<ChatItem2>) (List) aVar.data);
        }
    };
    private final f h = new f() {
        public void a(a aVar) {
            c.this.f20875a.f();
        }
    };
    private final g i = new g() {
        public void onEvent(a aVar) {
            c.this.f20875a.a((ChatMessage) aVar.data);
        }
    };
    private final g j = new g() {
        public void onEvent(a aVar) {
            c.this.f20875a.d((List<Object>) (List) aVar.data);
        }
    };
    private final f k = new f() {
        public void a(a aVar) {
            c.this.f20875a.g();
        }
    };
    private final g l = new g() {
        public void onEvent(a aVar) {
            c.this.f20875a.b(((Integer) aVar.data).intValue());
        }
    };
    private final g m = new g() {
        public void onEvent(a aVar) {
            c.this.f20875a.b((ChatMessage) aVar.data);
        }
    };
    private final g n = new g() {
        public void onEvent(a aVar) {
            c.this.f20875a.c(((Integer) aVar.data).intValue());
        }
    };

    public c(b bVar) {
        this.f20875a = bVar;
    }

    public void a() {
        b.a("CMD_GET_PCHATLIST_SUCCESS", (e) this.f20876b, b.a.NETWORK_BUS);
        b.a("ON_CHAT_SEARCH_DATA_READY", (e) this.f20877c, b.a.NETWORK_BUS);
        b.a("GET_USER_INFO_LOAD_LIST", (e) this.f20878d, b.a.NETWORK_BUS);
        b.a("SEARCH_CHAT_LOCAL_RESULT", (e) this.f20881g, b.a.NETWORK_BUS);
        b.a("BATCH_ITEM_LOAD", (e) this.h, b.a.NETWORK_BUS);
        b.a("ORDER_IN_BATCH_SAVED", (e) this.h, b.a.NETWORK_BUS);
        b.a("CMD_GET_OFFER_COUNT_SUCCESS", (e) this.h, b.a.NETWORK_BUS);
        b.a("CMD_SET_CHAT_LAST_READ_SUCCESS", (e) this.h, b.a.NETWORK_BUS);
        b.a("CMD_CLEAR_CHAT_MSG_SUCCUSS", (e) this.h, b.a.NETWORK_BUS);
        b.a("CHAT_MESSAGE_ARRIVED_DATA", (e) this.i, b.a.NETWORK_BUS);
        b.a("CHAT_MESSAGE_ARRIVED_NO_DATA", (e) this.j, b.a.NETWORK_BUS);
        b.a("CHAT_MESSAGE_ARRIVED", (e) this.k, b.a.NETWORK_BUS);
        b.a("CHAT_MESSAGES_SAVED", (e) this.k, b.a.NETWORK_BUS);
        b.a("CHAT_BADGE_UPDATE2", (e) this.l, b.a.NETWORK_BUS);
        b.a("CHAT_SEND_SUCCESS", (e) this.m, b.a.NETWORK_BUS);
        b.a("CMD_CLEAR_CHAT_MSG_ERROR", (e) this.n, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("CMD_GET_PCHATLIST_SUCCESS", this.f20876b, b.a.NETWORK_BUS);
        b.b("ON_CHAT_SEARCH_DATA_READY", this.f20877c, b.a.NETWORK_BUS);
        b.b("GET_USER_INFO_LOAD_LIST", this.f20878d, b.a.NETWORK_BUS);
        b.b("SEARCH_CHAT_LOCAL_RESULT", this.f20881g, b.a.NETWORK_BUS);
        b.b("BATCH_ITEM_LOAD", this.h, b.a.NETWORK_BUS);
        b.b("ORDER_IN_BATCH_SAVED", this.h, b.a.NETWORK_BUS);
        b.b("CMD_GET_OFFER_COUNT_SUCCESS", this.h, b.a.NETWORK_BUS);
        b.b("CMD_SET_CHAT_LAST_READ_SUCCESS", this.h, b.a.NETWORK_BUS);
        b.b("CMD_CLEAR_CHAT_MSG_SUCCUSS", this.h, b.a.NETWORK_BUS);
        b.b("CHAT_MESSAGE_ARRIVED_DATA", this.i, b.a.NETWORK_BUS);
        b.b("CHAT_MESSAGE_ARRIVED_NO_DATA", this.j, b.a.NETWORK_BUS);
        b.b("CHAT_MESSAGE_ARRIVED", this.k, b.a.NETWORK_BUS);
        b.b("CHAT_MESSAGES_SAVED", this.k, b.a.NETWORK_BUS);
        b.b("CHAT_BADGE_UPDATE2", this.l, b.a.NETWORK_BUS);
        b.b("CHAT_SEND_SUCCESS", this.m, b.a.NETWORK_BUS);
        b.b("CMD_CLEAR_CHAT_MSG_ERROR", this.n, b.a.NETWORK_BUS);
    }

    public void c() {
        b.a("SEARCH_TEXT_CHANGED", (e) this.f20879e, b.a.UI_BUS);
        b.a("SEARCH_TEXT_DONE", (e) this.f20879e, b.a.UI_BUS);
        b.a("SEARCH_TEXT_CANCELLED", (e) this.f20880f, b.a.UI_BUS);
    }

    public void d() {
        b.b("SEARCH_TEXT_CHANGED", this.f20879e, b.a.UI_BUS);
        b.b("SEARCH_TEXT_DONE", this.f20879e, b.a.UI_BUS);
        b.b("SEARCH_TEXT_CANCELLED", this.f20880f, b.a.UI_BUS);
    }
}
