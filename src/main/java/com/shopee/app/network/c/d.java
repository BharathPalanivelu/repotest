package com.shopee.app.network.c;

import android.text.TextUtils;
import android.util.Pair;
import com.garena.android.appkit.b.b;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.be;
import com.shopee.app.g.r;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class d extends c implements com.shopee.app.network.a.a<ResponseCommon> {
    public int a() {
        return 92;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        c().a(responseCommon);
    }

    private a c() {
        return ar.f().e().newBindAccountProcessor();
    }

    public void a(String str) {
        c().a();
    }

    public Pair<String, ResponseCommon> a(byte[] bArr) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, bArr.length, ResponseCommon.class);
        return new Pair<>(responseCommon.requestid, responseCommon);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final al f17888a;

        /* renamed from: b  reason: collision with root package name */
        private n f17889b;

        /* renamed from: c  reason: collision with root package name */
        private final UserInfo f17890c;

        /* renamed from: d  reason: collision with root package name */
        private final be f17891d;

        public a(al alVar, n nVar, UserInfo userInfo, be beVar) {
            this.f17888a = alVar;
            this.f17889b = nVar;
            this.f17891d = beVar;
            this.f17890c = userInfo;
        }

        public void a(ResponseCommon responseCommon) {
            if (c(responseCommon)) {
                boolean z = !TextUtils.isEmpty(this.f17890c.getEmail());
                r.b(responseCommon);
                b.a(responseCommon, this.f17890c);
                this.f17888a.a(this.f17890c);
                if (!z && !TextUtils.isEmpty(this.f17890c.getEmail())) {
                    this.f17891d.x();
                }
                this.f17889b.a("BIND_ACCOUNT_SUCCESS", (com.garena.android.appkit.b.a) new com.shopee.app.ui.auth.a.a(responseCommon.requestid, this.f17890c));
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
            com.garena.android.appkit.b.b.a("BIND_ACCOUNT_ERROR", new com.garena.android.appkit.b.a(new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon)), b.a.NETWORK_BUS);
        }

        public void a() {
            ResponseCommon.Builder builder = new ResponseCommon.Builder();
            builder.errcode = -100;
            b(builder.build());
        }
    }
}
