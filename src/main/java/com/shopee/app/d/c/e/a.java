package com.shopee.app.d.c.e;

import android.util.Pair;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.c.c;
import com.shopee.app.data.viewmodel.income.ShopBalance;
import com.shopee.app.data.viewmodel.income.TransactionItem;
import com.shopee.app.database.orm.bean.DBOrderDetail;
import com.shopee.app.database.orm.bean.DBTransaction;
import com.shopee.app.h.o;
import com.shopee.app.network.d.az;
import com.shopee.app.network.d.h.g;
import com.shopee.app.util.n;
import java.util.ArrayList;
import java.util.List;

public class a extends com.shopee.app.d.c.a {

    /* renamed from: c  reason: collision with root package name */
    private final com.shopee.app.data.store.a.a f16888c;

    /* renamed from: d  reason: collision with root package name */
    private final al f16889d;

    /* renamed from: e  reason: collision with root package name */
    private final c f16890e;

    /* renamed from: f  reason: collision with root package name */
    private int f16891f;

    /* renamed from: g  reason: collision with root package name */
    private int f16892g;

    /* access modifiers changed from: protected */
    public String d() {
        return "GetTransactionInteractor";
    }

    protected a(n nVar, com.shopee.app.data.store.a.a aVar, c cVar, al alVar) {
        super(nVar);
        this.f16888c = aVar;
        this.f16890e = cVar;
        this.f16889d = alVar;
    }

    public void a(int i, int i2) {
        this.f16891f = i;
        this.f16892g = i2;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        List<DBTransaction> a2 = this.f16888c.a(this.f16891f);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (DBTransaction next : a2) {
            TransactionItem transactionItem = new TransactionItem();
            DBOrderDetail b2 = this.f16890e.b(next.c());
            if (b2 != null || next.c() <= 0) {
                b.a(next, b2, transactionItem);
                arrayList.add(transactionItem);
            } else {
                arrayList2.add(Long.valueOf(next.c()));
            }
        }
        if (!arrayList2.isEmpty()) {
            g gVar = new g();
            o.a().a((az) gVar);
            gVar.a(this.f16891f);
            gVar.a((List<Long>) arrayList2);
        }
        this.f16402a.a("AMOUNT_LOCAL_LOAD", new com.garena.android.appkit.b.a(new Pair(e(), Integer.valueOf(this.f16892g))));
        this.f16402a.a("TRANSACTION_HISTORY_LOCAL_LOAD", new com.garena.android.appkit.b.a(new Pair(Integer.valueOf(this.f16891f), arrayList)));
    }

    private ShopBalance e() {
        return this.f16889d.b();
    }
}
