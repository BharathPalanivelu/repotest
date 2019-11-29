package com.shopee.app.network.c;

import com.shopee.app.application.ar;
import com.shopee.app.data.store.az;
import com.shopee.app.database.orm.bean.chatP2P.DBOffer;
import com.shopee.app.h.o;
import com.shopee.app.network.d.aj;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseOffer;
import com.shopee.protocol.shop.Offer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class an extends c {
    public int a() {
        return 209;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseOffer responseOffer = (ResponseOffer) f.f18486a.parseFrom(bArr, 0, i, ResponseOffer.class);
        c(responseOffer.requestid);
        c().a(responseOffer);
    }

    public void a(String str) {
        c().a();
    }

    private a c() {
        return ar.f().e().newGetOfferListProcessor();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final com.shopee.app.data.store.ar f17811a;

        /* renamed from: b  reason: collision with root package name */
        private final az f17812b;

        /* renamed from: c  reason: collision with root package name */
        private n f17813c;

        public a(n nVar, com.shopee.app.data.store.ar arVar, az azVar) {
            this.f17813c = nVar;
            this.f17811a = arVar;
            this.f17812b = azVar;
        }

        public void a(ResponseOffer responseOffer) {
            if (b(responseOffer)) {
                com.shopee.app.network.d.az f2 = o.a().f(responseOffer.requestid);
                if (f2 != null && (f2 instanceof aj)) {
                    aj ajVar = (aj) f2;
                    List<Offer> arrayList = responseOffer.offer == null ? new ArrayList<>() : responseOffer.offer;
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    for (Offer a2 : arrayList) {
                        DBOffer dBOffer = new DBOffer();
                        DBOffer.a(a2, dBOffer);
                        arrayList2.add(dBOffer);
                        arrayList3.add(Long.valueOf(dBOffer.a()));
                    }
                    this.f17811a.b((List<DBOffer>) arrayList2);
                    this.f17812b.a(ajVar.b(), ajVar.c(), arrayList3);
                    this.f17813c.a("CMD_GET_OFFER_LIST_SUCCUSS", new com.garena.android.appkit.b.a(Integer.valueOf(ajVar.b())));
                }
            }
        }

        private boolean b(ResponseOffer responseOffer) {
            if (responseOffer.errcode.intValue() == 0) {
                return true;
            }
            this.f17813c.a("CMD_GET_OFFER_LIST_ERROR", new com.garena.android.appkit.b.a(responseOffer.errcode));
            return false;
        }

        public void a() {
            this.f17813c.a("CMD_GET_OFFER_LIST_ERROR", new com.garena.android.appkit.b.a(-100));
        }
    }
}
