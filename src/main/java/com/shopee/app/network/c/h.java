package com.shopee.app.network.c;

import com.shopee.app.application.ar;
import com.shopee.app.h.o;
import com.shopee.app.network.d.g;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.app.web.protocol.AddCartMessage;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class h extends c {
    public int a() {
        return 84;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        c().a(responseCommon);
    }

    private a c() {
        return ar.f().e().cartAddItemProcessor();
    }

    public void a(String str) {
        ResponseCommon.Builder builder = new ResponseCommon.Builder();
        builder.errcode = -100;
        c().b(builder.build());
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final n f17920a;

        public a(n nVar) {
            this.f17920a = nVar;
        }

        public void a(ResponseCommon responseCommon) {
            if (c(responseCommon)) {
                g gVar = (g) o.a().f(responseCommon.requestid);
                AddCartMessage addCartMessage = null;
                if (gVar != null) {
                    addCartMessage = gVar.b();
                    addCartMessage.setQuantity(gVar.c());
                }
                this.f17920a.a().cM.a(addCartMessage).a();
            }
        }

        private boolean c(ResponseCommon responseCommon) {
            if (responseCommon.errcode.intValue() == 0) {
                return true;
            }
            b(responseCommon);
            return false;
        }

        public void b(ResponseCommon responseCommon) {
            this.f17920a.a("ADD_CART_ITEM_FAIL", new com.garena.android.appkit.b.a(new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon)));
        }
    }
}
