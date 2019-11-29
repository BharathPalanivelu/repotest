package com.shopee.app.network.d.d.b;

import com.shopee.app.application.ar;
import com.shopee.app.data.store.aa;
import com.shopee.protocol.action.ServerID;
import com.shopee.protocol.fraud_check.action.Command;
import com.shopee.protocol.fraud_check.action.SyncLoginInfoRequest;
import com.shopee.protocol.shop.UserAgentType;
import com.squareup.wire.Message;
import d.d.b.j;

public final class a extends com.shopee.app.network.d.d.a {

    /* renamed from: a  reason: collision with root package name */
    private SyncLoginInfoRequest f18256a;

    public Message q_() {
        h();
        SyncLoginInfoRequest syncLoginInfoRequest = this.f18256a;
        if (syncLoginInfoRequest == null) {
            j.b("syncLoginInfoRequest");
        }
        return syncLoginInfoRequest;
    }

    /* access modifiers changed from: protected */
    public int c() {
        return ServerID.FRAUD_CHECK_SERVER.getValue();
    }

    public int b() {
        return Command.CMD_FRAUD_SYNC_LOGININFO.getValue();
    }

    public final void a(int i) {
        String a2 = i().a();
        ar f2 = ar.f();
        j.a((Object) f2, "ShopeeApplication.get()");
        aa deviceStore = f2.e().deviceStore();
        j.a((Object) deviceStore, "ShopeeApplication.get().component.deviceStore()");
        String g2 = deviceStore.g();
        j.a((Object) g2, "ShopeeApplication.get().…deviceStore().fingerprint");
        SyncLoginInfoRequest build = new SyncLoginInfoRequest.Builder().requestid(a2).shopee_df(g2).tongdun_blackbox(com.shopee.app.util.p.a.f26481a.b()).userid(Integer.valueOf(i)).country("ID").user_agent_type(Integer.valueOf(UserAgentType.ANDROID.getValue())).build();
        j.a((Object) build, "SyncLoginInfoRequest.Bui…\n                .build()");
        this.f18256a = build;
        g();
    }
}
