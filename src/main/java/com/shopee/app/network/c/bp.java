package com.shopee.app.network.c;

import android.util.Pair;
import com.shopee.app.application.ar;
import com.shopee.app.h.o;
import com.shopee.app.network.c.d.b;
import com.shopee.app.network.d.b.h;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class bp extends c implements com.shopee.app.network.a.a<ResponseCommon> {
    public int a() {
        return 110;
    }

    public void c(byte[] bArr, int i) throws IOException {
        c().a((ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class));
    }

    private a c() {
        return ar.f().e().updateContactProcessor();
    }

    public void a(String str) {
        c().a(str);
    }

    public Pair<String, ResponseCommon> a(byte[] bArr) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, bArr.length, ResponseCommon.class);
        return new Pair<>(responseCommon.requestid, responseCommon);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final n f17874a;

        public a(n nVar) {
            this.f17874a = nVar;
        }

        public void a(ResponseCommon responseCommon) {
            if (b(responseCommon)) {
                h hVar = (h) o.a().f(responseCommon.requestid);
                this.f17874a.a().cc.a(Integer.valueOf(hVar != null ? hVar.c() : 0)).a();
            }
        }

        public void a(String str) {
            ResponseCommon.Builder builder = new ResponseCommon.Builder();
            builder.errcode = -100;
            builder.requestid = str;
            c(builder.build());
        }

        private boolean b(ResponseCommon responseCommon) {
            if (responseCommon.errcode.intValue() == 0) {
                return true;
            }
            c(responseCommon);
            return false;
        }

        private void c(ResponseCommon responseCommon) {
            h hVar = (h) o.a().f(responseCommon.requestid);
            this.f17874a.a().cp.a(new b(responseCommon.errcode.intValue(), responseCommon.err_message, Integer.valueOf(hVar != null ? hVar.c() : 0))).a();
        }
    }
}
