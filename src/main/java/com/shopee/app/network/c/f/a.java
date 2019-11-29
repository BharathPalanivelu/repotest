package com.shopee.app.network.c.f;

import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.al;
import com.shopee.app.data.viewmodel.income.ShopBalance;
import com.shopee.app.network.c.c;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseShopBalance;
import java.io.IOException;

public class a extends c {
    public int a() {
        return 50;
    }

    public void c(byte[] bArr, int i) throws IOException {
        c().a((ResponseShopBalance) f.f18486a.parseFrom(bArr, 0, i, ResponseShopBalance.class));
    }

    private C0267a c() {
        return ar.f().e().shopBalanceProcessor();
    }

    /* renamed from: com.shopee.app.network.c.f.a$a  reason: collision with other inner class name */
    public static class C0267a {

        /* renamed from: a  reason: collision with root package name */
        private final n f17908a;

        /* renamed from: b  reason: collision with root package name */
        private final al f17909b;

        public C0267a(n nVar, al alVar) {
            this.f17908a = nVar;
            this.f17909b = alVar;
        }

        public void a(ResponseShopBalance responseShopBalance) {
            if (b(responseShopBalance) && responseShopBalance.balance != null) {
                ShopBalance shopBalance = new ShopBalance();
                b.a(responseShopBalance, shopBalance);
                this.f17909b.a(shopBalance);
                this.f17908a.a("SHOP_BALANCE_GET", new com.garena.android.appkit.b.a(shopBalance));
            }
        }

        private boolean b(ResponseShopBalance responseShopBalance) {
            return responseShopBalance.errcode.intValue() == 0;
        }
    }
}
