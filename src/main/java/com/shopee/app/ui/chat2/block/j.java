package com.shopee.app.ui.chat2.block;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.data.viewmodel.UserBriefInfo;
import com.shopee.app.database.orm.bean.chatP2P.DBBlockUser;
import java.util.List;

public final class j implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final i f20329a;

    /* renamed from: b  reason: collision with root package name */
    private final g f20330b = new g() {
        public void onEvent(a aVar) {
            j.this.f20329a.a((UserBriefInfo) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f20331c = new g() {
        public void onEvent(a aVar) {
            j.this.f20329a.a((List<UserBriefInfo>) (List) aVar.data);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f20332d = new g() {
        public void onEvent(a aVar) {
            j.this.f20329a.e();
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f20333e = new g() {
        public void onEvent(a aVar) {
            j.this.f20329a.a((DBBlockUser) aVar.data);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final g f20334f = new g() {
        public void onEvent(a aVar) {
            j.this.f20329a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    public j(i iVar) {
        this.f20329a = iVar;
    }

    public void a() {
        b.a("BLOCKED_USER_LOAD", (e) this.f20331c, b.a.NETWORK_BUS);
        b.a("USER_BRIEF_LOAD", (e) this.f20332d, b.a.NETWORK_BUS);
        b.a("CMD_GET_BLOCK_USER_LIST_SUCCESS", (e) this.f20332d, b.a.NETWORK_BUS);
        b.a("CMD_CHAT_BLOCK_USER_SUCCESS", (e) this.f20333e, b.a.NETWORK_BUS);
        b.a("CMD_CHAT_BLOCK_USER_ERROR", (e) this.f20334f, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("BLOCKED_USER_LOAD", this.f20331c, b.a.NETWORK_BUS);
        b.b("USER_BRIEF_LOAD", this.f20332d, b.a.NETWORK_BUS);
        b.b("CMD_GET_BLOCK_USER_LIST_SUCCESS", this.f20332d, b.a.NETWORK_BUS);
        b.b("CMD_CHAT_BLOCK_USER_SUCCESS", this.f20333e, b.a.NETWORK_BUS);
        b.b("CMD_CHAT_BLOCK_USER_ERROR", this.f20334f, b.a.NETWORK_BUS);
    }

    public void c() {
        b.a("BLOCK_USER_CHAT", (e) this.f20330b, b.a.UI_BUS);
    }

    public void d() {
        b.b("BLOCK_USER_CHAT", this.f20330b, b.a.UI_BUS);
    }
}
