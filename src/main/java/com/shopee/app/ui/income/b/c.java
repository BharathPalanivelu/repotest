package com.shopee.app.ui.income.b;

import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.data.viewmodel.income.ShopBalance;
import com.shopee.app.data.viewmodel.income.TransactionItem;
import com.shopee.app.ui.income.h;
import java.util.List;

public final class c implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final b f23143a;

    /* renamed from: b  reason: collision with root package name */
    private final g f23144b = new g() {
        public void onEvent(a aVar) {
            c.this.f23143a.a((h) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f23145c = new g() {
        public void onEvent(a aVar) {
            c.this.f23143a.a((ShopBalance) aVar.data);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f23146d = new g() {
        public void onEvent(a aVar) {
            c.this.f23143a.a((ShopDetail) aVar.data);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f23147e = new g() {
        public void onEvent(a aVar) {
            c.this.f23143a.a((Pair<Integer, List<TransactionItem>>) (Pair) aVar.data);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final g f23148f = new g() {
        public void onEvent(a aVar) {
            c.this.f23143a.b(((Integer) aVar.data).intValue());
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final g f23149g = new g() {
        public void onEvent(a aVar) {
            c.this.f23143a.b((Pair<Integer, Long>) (Pair) aVar.data);
        }
    };
    private final g h = new g() {
        public void onEvent(a aVar) {
            c.this.f23143a.c((Pair<ShopBalance, Integer>) (Pair) aVar.data);
        }
    };

    public c(b bVar) {
        this.f23143a = bVar;
    }

    public void a() {
        b.a("SHOP_BALANCE_GET", (e) this.f23145c, b.a.NETWORK_BUS);
        b.a("SHOP_INFO_FETCHED", (e) this.f23146d, b.a.NETWORK_BUS);
        b.a("TRANSACTION_HISTORY_LOCAL_LOAD", (e) this.f23147e, b.a.NETWORK_BUS);
        b.a("MISS_ORDER_FETCHED", (e) this.f23148f, b.a.NETWORK_BUS);
        b.a("TRANSACTION_HISTORY_SAVED", (e) this.f23149g, b.a.NETWORK_BUS);
        b.a("AMOUNT_LOCAL_LOAD", (e) this.h, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("SHOP_BALANCE_GET", this.f23145c, b.a.NETWORK_BUS);
        b.b("SHOP_INFO_FETCHED", this.f23146d, b.a.NETWORK_BUS);
        b.b("TRANSACTION_HISTORY_LOCAL_LOAD", this.f23147e, b.a.NETWORK_BUS);
        b.b("MISS_ORDER_FETCHED", this.f23148f, b.a.NETWORK_BUS);
        b.b("TRANSACTION_HISTORY_SAVED", this.f23149g, b.a.NETWORK_BUS);
        b.b("AMOUNT_LOCAL_LOAD", this.h, b.a.NETWORK_BUS);
    }

    public void c() {
        b.a("INCOME_TIME_FILTER", (e) this.f23144b, b.a.UI_BUS);
    }

    public void d() {
        b.b("INCOME_TIME_FILTER", this.f23144b, b.a.UI_BUS);
    }
}
