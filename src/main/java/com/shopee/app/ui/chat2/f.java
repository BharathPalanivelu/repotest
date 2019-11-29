package com.shopee.app.ui.chat2;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.data.viewmodel.UserData;
import com.shopee.app.data.viewmodel.chat.ChatMessage;
import com.shopee.app.data.viewmodel.chat2.ChatItem2;
import java.util.List;

public final class f implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final e f20411a;

    /* renamed from: b  reason: collision with root package name */
    private final g f20412b = new g() {
        public void onEvent(a aVar) {
            f.this.f20411a.a((List<ChatItem2>) (List) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f20413c = new g() {
        public void onEvent(a aVar) {
            f.this.f20411a.b((List<ChatItem2>) (List) aVar.data);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f20414d = new g() {
        public void onEvent(a aVar) {
            f.this.f20411a.b(((Integer) aVar.data).intValue());
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final com.garena.android.appkit.b.f f20415e = new com.garena.android.appkit.b.f() {
        public void a(a aVar) {
            f.this.f20411a.e();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final g f20416f = new g() {
        public void onEvent(a aVar) {
            f.this.f20411a.a((ChatMessage) aVar.data);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final g f20417g = new g() {
        public void onEvent(a aVar) {
            f.this.f20411a.c((List<Object>) (List) aVar.data);
        }
    };
    private final com.garena.android.appkit.b.f h = new com.garena.android.appkit.b.f() {
        public void a(a aVar) {
            f.this.f20411a.f();
        }
    };
    private final g i = new g() {
        public void onEvent(a aVar) {
            f.this.f20411a.b((ChatMessage) aVar.data);
        }
    };
    private final g j = new g() {
        public void onEvent(a aVar) {
            f.this.f20411a.c(((Integer) aVar.data).intValue());
        }
    };
    private final g k = new g() {
        public void onEvent(a aVar) {
            f.this.f20411a.d((List<UserData>) (List) aVar.data);
        }
    };
    private final g l = new g() {
        public void onEvent(a aVar) {
            f.this.f20411a.g();
        }
    };
    private final g m = new g() {
        public void onEvent(a aVar) {
            f.this.f20411a.h();
        }
    };
    private final g n = new g() {
        public void onEvent(a aVar) {
            f.this.f20411a.e(((Integer) aVar.data).intValue());
        }
    };

    public void c() {
    }

    public void d() {
    }

    public f(e eVar) {
        this.f20411a = eVar;
    }

    public void a() {
        b.a("CHAT_LIST_LOCAL_LOAD", (e) this.f20412b, b.a.NETWORK_BUS);
        b.a("CHAT_UNREAD_LIST_LOAD", (e) this.f20413c, b.a.NETWORK_BUS);
        b.a("CMD_GET_PCHATLIST_SUCCESS", (e) this.f20414d, b.a.NETWORK_BUS);
        b.a("BATCH_ITEM_LOAD", (e) this.f20415e, b.a.NETWORK_BUS);
        b.a("ORDER_IN_BATCH_SAVED", (e) this.f20415e, b.a.NETWORK_BUS);
        b.a("CMD_GET_OFFER_COUNT_SUCCESS", (e) this.f20415e, b.a.NETWORK_BUS);
        b.a("CMD_SET_CHAT_LAST_READ_SUCCESS", (e) this.f20415e, b.a.NETWORK_BUS);
        b.a("CMD_CLEAR_CHAT_MSG_SUCCUSS", (e) this.f20415e, b.a.NETWORK_BUS);
        b.a("CHAT_MESSAGE_ARRIVED_DATA", (e) this.f20416f, b.a.NETWORK_BUS);
        b.a("CHAT_MESSAGE_ARRIVED_NO_DATA", (e) this.f20417g, b.a.NETWORK_BUS);
        b.a("CHAT_MESSAGE_ARRIVED", (e) this.h, b.a.NETWORK_BUS);
        b.a("CHAT_MESSAGES_SAVED", (e) this.h, b.a.NETWORK_BUS);
        b.a("CHAT_MARKED_UNREAD", (e) this.h, b.a.NETWORK_BUS);
        b.a("CHAT_SEND_SUCCESS", (e) this.i, b.a.NETWORK_BUS);
        b.a("CHAT_BADGE_UPDATE2", (e) this.j, b.a.NETWORK_BUS);
        b.a("GET_USER_INFO_LOAD_LIST", (e) this.k, b.a.NETWORK_BUS);
        b.a("USER_BRIEF_LOAD", (e) this.l, b.a.NETWORK_BUS);
        b.a("LOGIN_SUCCESS", (e) this.m, b.a.NETWORK_BUS);
        b.a("CMD_CLEAR_CHAT_MSG_ERROR", (e) this.n, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("CHAT_LIST_LOCAL_LOAD", this.f20412b, b.a.NETWORK_BUS);
        b.b("CHAT_UNREAD_LIST_LOAD", this.f20413c, b.a.NETWORK_BUS);
        b.b("CMD_GET_PCHATLIST_SUCCESS", this.f20414d, b.a.NETWORK_BUS);
        b.b("BATCH_ITEM_LOAD", this.f20415e, b.a.NETWORK_BUS);
        b.b("ORDER_IN_BATCH_SAVED", this.f20415e, b.a.NETWORK_BUS);
        b.b("CMD_GET_OFFER_COUNT_SUCCESS", this.f20415e, b.a.NETWORK_BUS);
        b.b("CMD_SET_CHAT_LAST_READ_SUCCESS", this.f20415e, b.a.NETWORK_BUS);
        b.b("CMD_CLEAR_CHAT_MSG_SUCCUSS", this.f20415e, b.a.NETWORK_BUS);
        b.b("CHAT_MESSAGE_ARRIVED_DATA", this.f20416f, b.a.NETWORK_BUS);
        b.b("CHAT_MESSAGE_ARRIVED_NO_DATA", this.f20417g, b.a.NETWORK_BUS);
        b.b("CHAT_MESSAGE_ARRIVED", this.h, b.a.NETWORK_BUS);
        b.b("CHAT_MESSAGES_SAVED", this.h, b.a.NETWORK_BUS);
        b.b("CHAT_MARKED_UNREAD", this.h, b.a.NETWORK_BUS);
        b.b("CHAT_SEND_SUCCESS", this.i, b.a.NETWORK_BUS);
        b.b("CHAT_BADGE_UPDATE2", this.j, b.a.NETWORK_BUS);
        b.b("GET_USER_INFO_LOAD_LIST", this.k, b.a.NETWORK_BUS);
        b.b("USER_BRIEF_LOAD", this.l, b.a.NETWORK_BUS);
        b.b("LOGIN_SUCCESS", this.m, b.a.NETWORK_BUS);
        b.b("CMD_CLEAR_CHAT_MSG_ERROR", this.n, b.a.NETWORK_BUS);
    }
}
