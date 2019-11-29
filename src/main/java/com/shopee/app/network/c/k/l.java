package com.shopee.app.network.c.k;

import android.util.Pair;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.c.d;
import com.shopee.app.data.store.c.e;
import com.shopee.app.database.orm.bean.DBReturnItem;
import com.shopee.app.h.o;
import com.shopee.app.network.c.c;
import com.shopee.app.network.f;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseReturnList;
import com.shopee.protocol.shop.Return;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class l extends c implements com.shopee.app.network.a.a<ResponseReturnList> {
    public int a() {
        return 120;
    }

    public void c(byte[] bArr, int i) throws IOException {
        c().a((ResponseReturnList) f.f18486a.parseFrom(bArr, 0, i, ResponseReturnList.class));
    }

    private a c() {
        return ar.f().e().returnListProcessor();
    }

    public Pair<String, ResponseReturnList> a(byte[] bArr) throws IOException {
        ResponseReturnList responseReturnList = (ResponseReturnList) f.f18486a.parseFrom(bArr, 0, bArr.length, ResponseReturnList.class);
        return new Pair<>(responseReturnList.requestid, responseReturnList);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final n f18023a;

        /* renamed from: b  reason: collision with root package name */
        private final e f18024b;

        /* renamed from: c  reason: collision with root package name */
        private final d f18025c;

        public a(n nVar, e eVar, d dVar) {
            this.f18023a = nVar;
            this.f18024b = eVar;
            this.f18025c = dVar;
        }

        public void a(ResponseReturnList responseReturnList) {
            if (b(responseReturnList)) {
                com.shopee.app.network.d.h.n nVar = (com.shopee.app.network.d.h.n) o.a().f(responseReturnList.requestid);
                if (nVar != null) {
                    if (nVar.c() == 0) {
                        this.f18025c.a(nVar.d());
                    }
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    if (!af.a(responseReturnList.returns)) {
                        for (Return a2 : responseReturnList.returns) {
                            DBReturnItem dBReturnItem = new DBReturnItem();
                            b.a(a2, dBReturnItem);
                            arrayList.add(dBReturnItem);
                            arrayList2.add(Long.valueOf(dBReturnItem.b()));
                        }
                    }
                    this.f18024b.a((List<DBReturnItem>) arrayList);
                    this.f18025c.a(nVar.d(), arrayList2);
                    this.f18023a.a("RETURN_LIST_SAVED", new com.garena.android.appkit.b.a());
                }
            }
        }

        private boolean b(ResponseReturnList responseReturnList) {
            return responseReturnList.errcode.intValue() == 0;
        }
    }
}
