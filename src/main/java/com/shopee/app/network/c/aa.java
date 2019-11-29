package com.shopee.app.network.c;

import android.util.Pair;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.viewmodel.MeCounter;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseCoin;
import java.io.IOException;

public class aa extends c implements com.shopee.app.network.a.a<ResponseCoin> {
    public int a() {
        return 230;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCoin responseCoin = (ResponseCoin) f.f18486a.parseFrom(bArr, 0, i, ResponseCoin.class);
        c(responseCoin.requestid);
        c().a(responseCoin);
    }

    public void a(String str) {
        c().a();
    }

    private a c() {
        return ar.f().e().newGetCoinProcessor();
    }

    public Pair<String, ResponseCoin> a(byte[] bArr) throws IOException {
        ResponseCoin responseCoin = (ResponseCoin) f.f18486a.parseFrom(bArr, 0, bArr.length, ResponseCoin.class);
        return new Pair<>(responseCoin.requestid, responseCoin);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private n f17781a;

        /* renamed from: b  reason: collision with root package name */
        private MeCounter f17782b;

        public a(n nVar, MeCounter meCounter) {
            this.f17781a = nVar;
            this.f17782b = meCounter;
        }

        public void a(ResponseCoin responseCoin) {
            if (b(responseCoin)) {
                this.f17782b.setCoinCount(b.a(responseCoin.coin.available_amount));
                this.f17781a.a("CMD_GET_COIN_SUCCESS", new com.garena.android.appkit.b.a());
            }
        }

        private boolean b(ResponseCoin responseCoin) {
            if (responseCoin.errcode == null || responseCoin.errcode.intValue() == 0) {
                return true;
            }
            this.f17781a.a("CMD_GET_COIN_ERROR", new com.garena.android.appkit.b.a(responseCoin.errcode));
            return false;
        }

        public void a() {
            this.f17781a.a("CMD_GET_COIN_ERROR", new com.garena.android.appkit.b.a(-100));
        }
    }
}
