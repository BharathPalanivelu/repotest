package com.shopee.app.network.c;

import com.garena.android.appkit.b.b;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.s;
import com.shopee.app.network.f;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class n extends c {
    public int a() {
        return 99;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        if (responseCommon.errcode.intValue() != 0) {
            a(responseCommon);
            return;
        }
        c().a(responseCommon);
        b.a("DEL_ITEM_COMMENT_SUCCESS", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
    }

    /* access modifiers changed from: package-private */
    public void a(ResponseCommon responseCommon) {
        b.a("DEL_ITEM_COMMENT_FAIL", new com.garena.android.appkit.b.a(new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon)), b.a.NETWORK_BUS);
    }

    private a c() {
        return ar.f().e().delItemCommentProcessor();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private com.shopee.app.util.n f18044a;

        /* renamed from: b  reason: collision with root package name */
        private s f18045b;

        public a(com.shopee.app.util.n nVar, s sVar) {
            this.f18044a = nVar;
            this.f18045b = sVar;
        }

        public void a(ResponseCommon responseCommon) {
            this.f18045b.a(responseCommon.shopid.intValue(), responseCommon.itemid.longValue(), responseCommon.cmtid.longValue());
            this.f18044a.a("DEL_ITEM_COMMENT_SUCCESS", new com.garena.android.appkit.b.a());
        }
    }

    public void a(String str) {
        ResponseCommon.Builder builder = new ResponseCommon.Builder();
        builder.errcode = -100;
        a(builder.build());
    }
}
