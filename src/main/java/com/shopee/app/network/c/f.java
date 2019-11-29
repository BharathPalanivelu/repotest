package com.shopee.app.network.c;

import com.garena.android.appkit.b.b;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.at;
import com.shopee.app.data.store.c.b;
import com.shopee.app.data.store.c.c;
import com.shopee.app.data.store.q;
import com.shopee.app.data.store.r;
import com.shopee.app.data.viewmodel.OrderKey;
import com.shopee.app.database.orm.bean.DBCheckoutItem;
import com.shopee.app.database.orm.bean.DBCheckoutOrder;
import com.shopee.app.database.orm.bean.DBOrderDetail;
import com.shopee.app.network.d.e;
import com.shopee.app.network.d.h.i;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class f extends c {
    public int a() {
        return 124;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) com.shopee.app.network.f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        c().a(responseCommon, (e) b(responseCommon.requestid));
    }

    private a c() {
        return ar.f().e().cancelCheckoutProcess();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final q f17902a;

        /* renamed from: b  reason: collision with root package name */
        private final r f17903b;

        /* renamed from: c  reason: collision with root package name */
        private final c f17904c;

        /* renamed from: d  reason: collision with root package name */
        private final b f17905d;

        /* renamed from: e  reason: collision with root package name */
        private final at f17906e;

        /* renamed from: f  reason: collision with root package name */
        private final com.shopee.app.tracking.f f17907f;

        public a(q qVar, r rVar, c cVar, b bVar, at atVar, com.shopee.app.tracking.f fVar) {
            this.f17902a = qVar;
            this.f17903b = rVar;
            this.f17904c = cVar;
            this.f17905d = bVar;
            this.f17906e = atVar;
            this.f17907f = fVar;
        }

        /* access modifiers changed from: private */
        public void a(ResponseCommon responseCommon, e eVar) {
            if (a(responseCommon) && eVar != null) {
                long b2 = eVar.b();
                this.f17902a.a(Long.valueOf(b2));
                this.f17906e.b(new OrderKey(false, 9), b2);
                DBCheckoutItem a2 = this.f17903b.a(b2);
                if (a2 != null) {
                    List<DBCheckoutOrder> i = a2.i();
                    if (i != null) {
                        ArrayList arrayList = new ArrayList();
                        OrderKey orderKey = new OrderKey(false, 4);
                        for (DBCheckoutOrder next : i) {
                            DBOrderDetail b3 = this.f17904c.b(next.b());
                            if (b3 != null) {
                                b3.f(5);
                                arrayList.add(b3);
                                this.f17905d.a(orderKey, next.b());
                                this.f17906e.a(orderKey, next.b());
                            }
                            new i().a(next.b(), next.a());
                        }
                        this.f17904c.a((List<DBOrderDetail>) arrayList);
                    }
                }
                this.f17903b.b(b2);
                com.garena.android.appkit.b.b.a("CANCEL_CHECKOUT_SUCCESS", new com.garena.android.appkit.b.a(responseCommon.requestid), b.a.NETWORK_BUS);
            }
        }

        private boolean a(ResponseCommon responseCommon) {
            if (responseCommon.errcode.intValue() == 0) {
                return true;
            }
            b(responseCommon);
            return false;
        }

        /* access modifiers changed from: private */
        public void b(ResponseCommon responseCommon) {
            com.garena.android.appkit.b.b.a("CANCEL_CHECKOUT_ERROR", new com.garena.android.appkit.b.a(new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon)), b.a.NETWORK_BUS);
        }
    }

    public void a(String str) {
        ResponseCommon.Builder builder = new ResponseCommon.Builder();
        builder.errcode = -100;
        c().b(builder.build());
    }
}
