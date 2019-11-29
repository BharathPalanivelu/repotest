package com.shopee.app.network.c.c;

import com.shopee.app.application.ar;
import com.shopee.app.database.orm.bean.chatP2P.DBOffer;
import com.shopee.app.network.f;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseOffer;
import com.shopee.protocol.shop.Offer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class c extends com.shopee.app.network.c.c {
    public int a() {
        return 203;
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
        return ar.f().e().newGetOfferProcessor();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private n f17880a;

        /* renamed from: b  reason: collision with root package name */
        private com.shopee.app.data.store.ar f17881b;

        public a(n nVar, com.shopee.app.data.store.ar arVar) {
            this.f17880a = nVar;
            this.f17881b = arVar;
        }

        public void a(ResponseOffer responseOffer) {
            if (b(responseOffer)) {
                ArrayList arrayList = new ArrayList();
                if (!af.a(responseOffer.offer)) {
                    for (Offer a2 : responseOffer.offer) {
                        DBOffer dBOffer = new DBOffer();
                        DBOffer.a(a2, dBOffer);
                        arrayList.add(dBOffer);
                    }
                }
                this.f17881b.b((List<DBOffer>) arrayList);
                this.f17880a.a("CMD_GET_OFFER_SUCCESS", new com.garena.android.appkit.b.a());
            }
        }

        private boolean b(ResponseOffer responseOffer) {
            if (responseOffer.errcode.intValue() == 0) {
                return true;
            }
            this.f17880a.a("CMD_GET_OFFER_ERROR", new com.garena.android.appkit.b.a(responseOffer.errcode));
            return false;
        }

        public void a() {
            this.f17880a.a("CMD_GET_OFFER_ERROR", new com.garena.android.appkit.b.a(-100));
        }
    }
}
