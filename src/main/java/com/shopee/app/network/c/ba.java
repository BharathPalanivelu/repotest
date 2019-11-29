package com.shopee.app.network.c;

import android.util.Pair;
import com.shopee.app.application.ar;
import com.shopee.app.h.o;
import com.shopee.app.network.d.aw;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseWallet;
import java.io.IOException;

public class ba extends c implements com.shopee.app.network.a.a<ResponseWallet> {
    public int a() {
        return 226;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseWallet responseWallet = (ResponseWallet) f.f18486a.parseFrom(bArr, 0, i, ResponseWallet.class);
        c(responseWallet.requestid);
        c().a(responseWallet);
    }

    public void a(String str) {
        c().a();
    }

    private a c() {
        return ar.f().e().newGetWalletProcessor();
    }

    public Pair<String, ResponseWallet> a(byte[] bArr) throws IOException {
        ResponseWallet responseWallet = (ResponseWallet) f.f18486a.parseFrom(bArr, 0, bArr.length, ResponseWallet.class);
        return new Pair<>(responseWallet.requestid, responseWallet);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private n f17848a;

        public void a() {
        }

        public a(n nVar) {
            this.f17848a = nVar;
        }

        public void a(ResponseWallet responseWallet) {
            if (b(responseWallet)) {
                aw awVar = (aw) o.a().f(responseWallet.requestid);
                if (awVar != null) {
                    this.f17848a.a("CMD_GET_WALLET_SUCCESS", new com.garena.android.appkit.b.a(new Pair(Integer.valueOf(awVar.e()), responseWallet.wallet)));
                }
            }
        }

        private boolean b(ResponseWallet responseWallet) {
            return responseWallet.errcode == null || responseWallet.errcode.intValue() == 0;
        }
    }
}
