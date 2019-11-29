package com.shopee.app.d.c.c;

import com.shopee.app.d.c.a;
import com.shopee.app.data.store.ar;
import com.shopee.app.data.viewmodel.chatP2P.VMOffer;
import com.shopee.app.database.orm.bean.chatP2P.DBOffer;
import com.shopee.app.util.n;

public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    private final ar f16660c;

    /* renamed from: d  reason: collision with root package name */
    private long f16661d;

    /* renamed from: e  reason: collision with root package name */
    private long f16662e;

    /* access modifiers changed from: protected */
    public String d() {
        return "GetOfferP2PInteractor";
    }

    protected c(n nVar, ar arVar) {
        super(nVar);
        this.f16660c = arVar;
    }

    public void a(long j) {
        this.f16661d = -1;
        this.f16662e = j;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        long j = this.f16661d;
        if (j > 0) {
            this.f16402a.a("OFFER_P2P_LIST_LOAD", new com.garena.android.appkit.b.a(this.f16660c.a(j)));
            return;
        }
        DBOffer b2 = this.f16660c.b(this.f16662e);
        if (b2 != null) {
            VMOffer vMOffer = new VMOffer();
            VMOffer.map(b2, vMOffer);
            this.f16402a.a().z.a(vMOffer).a();
        }
    }
}
