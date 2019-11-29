package com.shopee.app.network.c.c;

import com.shopee.app.application.ar;
import com.shopee.app.data.store.k;
import com.shopee.app.database.orm.bean.chatP2P.DBBlockUser;
import com.shopee.app.h.o;
import com.shopee.app.network.c.c;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseCommon;
import com.tencent.qalsdk.im_open.http;
import java.io.IOException;
import java.util.ArrayList;

public class a extends c {
    public int a() {
        return http.Partial_Content;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        c().a(responseCommon);
    }

    public void a(String str) {
        c().a();
    }

    private C0265a c() {
        return ar.f().e().newChatBlockUserProcessor();
    }

    /* renamed from: com.shopee.app.network.c.c.a$a  reason: collision with other inner class name */
    public static class C0265a {

        /* renamed from: a  reason: collision with root package name */
        private n f17876a;

        /* renamed from: b  reason: collision with root package name */
        private k f17877b;

        public C0265a(n nVar, k kVar) {
            this.f17876a = nVar;
            this.f17877b = kVar;
        }

        public void a(ResponseCommon responseCommon) {
            if (b(responseCommon)) {
                com.shopee.app.network.d.c.a aVar = (com.shopee.app.network.d.c.a) o.a().f(responseCommon.requestid);
                DBBlockUser dBBlockUser = new DBBlockUser();
                dBBlockUser.a(aVar.c());
                dBBlockUser.a(aVar.b());
                boolean z = false;
                for (DBBlockUser a2 : this.f17877b.b()) {
                    if (a2.a() == aVar.c()) {
                        z = true;
                    }
                }
                if (!z) {
                    dBBlockUser.b(this.f17877b.b().size());
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(dBBlockUser);
                this.f17877b.a(arrayList);
                this.f17876a.a("CMD_CHAT_BLOCK_USER_SUCCESS", new com.garena.android.appkit.b.a(dBBlockUser));
            }
        }

        private boolean b(ResponseCommon responseCommon) {
            if (responseCommon.errcode.intValue() == 0) {
                return true;
            }
            this.f17876a.a("CMD_CHAT_BLOCK_USER_ERROR", new com.garena.android.appkit.b.a(new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon)));
            return false;
        }

        public void a() {
            this.f17876a.a("CMD_CHAT_BLOCK_USER_ERROR", new com.garena.android.appkit.b.a(new com.shopee.app.network.c.d.a(-100, (String) null, (ResponseCommon) null)));
        }
    }
}
