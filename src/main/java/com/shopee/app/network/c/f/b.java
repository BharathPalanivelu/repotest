package com.shopee.app.network.c.f;

import android.util.Pair;
import com.shopee.app.application.ar;
import com.shopee.app.database.orm.bean.DBTransaction;
import com.shopee.app.h.o;
import com.shopee.app.network.c.c;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseTransHistory;
import com.shopee.protocol.shop.TransHistory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class b extends c {
    public int a() {
        return 51;
    }

    public void c(byte[] bArr, int i) throws IOException {
        c().a((ResponseTransHistory) f.f18486a.parseFrom(bArr, 0, i, ResponseTransHistory.class));
    }

    private a c() {
        return ar.f().e().transactionProcessor();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final n f17910a;

        /* renamed from: b  reason: collision with root package name */
        private final com.shopee.app.data.store.a.a f17911b;

        public a(n nVar, com.shopee.app.data.store.a.a aVar) {
            this.f17910a = nVar;
            this.f17911b = aVar;
        }

        public void a(ResponseTransHistory responseTransHistory) {
            if (b(responseTransHistory)) {
                List<TransHistory> arrayList = responseTransHistory.history != null ? responseTransHistory.history : new ArrayList<>();
                ArrayList arrayList2 = new ArrayList();
                com.shopee.app.network.d.e.b bVar = (com.shopee.app.network.d.e.b) o.a().f(responseTransHistory.requestid);
                if (bVar != null) {
                    if (bVar.c() == 0) {
                        this.f17911b.b(bVar.b());
                    }
                    for (TransHistory a2 : arrayList) {
                        DBTransaction dBTransaction = new DBTransaction();
                        com.shopee.app.d.b.b.a(a2, dBTransaction, bVar.b());
                        arrayList2.add(dBTransaction);
                    }
                    this.f17911b.a((List<DBTransaction>) arrayList2);
                    this.f17910a.a("TRANSACTION_HISTORY_SAVED", new com.garena.android.appkit.b.a(new Pair(Integer.valueOf(bVar.b()), responseTransHistory.sum_income)));
                }
            }
        }

        private boolean b(ResponseTransHistory responseTransHistory) {
            return responseTransHistory.errcode.intValue() == 0;
        }
    }
}
