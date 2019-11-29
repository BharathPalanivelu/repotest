package com.shopee.app.network.c.k;

import android.util.Pair;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.c.d;
import com.shopee.app.data.store.c.e;
import com.shopee.app.database.orm.bean.DBReturnItem;
import com.shopee.app.network.c.c;
import com.shopee.app.network.d.h.o;
import com.shopee.app.network.f;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseReturnRefundList;
import com.shopee.protocol.action.ReturnWithRefund;
import com.shopee.protocol.shop.Refund;
import com.shopee.protocol.shop.Return;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class m extends c implements com.shopee.app.network.a.a<ResponseReturnRefundList> {
    public int a() {
        return 143;
    }

    public void c(byte[] bArr, int i) throws IOException {
        c().a((ResponseReturnRefundList) f.f18486a.parseFrom(bArr, 0, i, ResponseReturnRefundList.class));
    }

    private a c() {
        return ar.f().e().returnRefundListProcessor();
    }

    public Pair<String, ResponseReturnRefundList> a(byte[] bArr) throws IOException {
        ResponseReturnRefundList responseReturnRefundList = (ResponseReturnRefundList) f.f18486a.parseFrom(bArr, 0, bArr.length, ResponseReturnRefundList.class);
        return new Pair<>(responseReturnRefundList.requestid, responseReturnRefundList);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final n f18026a;

        /* renamed from: b  reason: collision with root package name */
        private final e f18027b;

        /* renamed from: c  reason: collision with root package name */
        private final d f18028c;

        public a(n nVar, e eVar, d dVar) {
            this.f18026a = nVar;
            this.f18027b = eVar;
            this.f18028c = dVar;
        }

        public void a(ResponseReturnRefundList responseReturnRefundList) {
            if (b(responseReturnRefundList)) {
                o oVar = (o) com.shopee.app.h.o.a().f(responseReturnRefundList.requestid);
                if (oVar != null) {
                    if (oVar.c() == 0) {
                        this.f18028c.a(oVar.d());
                    }
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    if (!af.a(responseReturnRefundList.items)) {
                        for (ReturnWithRefund next : responseReturnRefundList.items) {
                            Return returnR = next._return;
                            Refund refund = next.refund;
                            DBReturnItem dBReturnItem = new DBReturnItem();
                            b.a(returnR, refund, dBReturnItem);
                            arrayList.add(dBReturnItem);
                            arrayList2.add(Long.valueOf(dBReturnItem.b()));
                        }
                    }
                    this.f18027b.a((List<DBReturnItem>) arrayList);
                    this.f18028c.a(oVar.d(), arrayList2);
                    this.f18026a.a("RETURN_LIST_SAVED", new com.garena.android.appkit.b.a());
                }
            }
        }

        private boolean b(ResponseReturnRefundList responseReturnRefundList) {
            return responseReturnRefundList.errcode.intValue() == 0;
        }
    }
}
