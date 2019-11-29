package com.shopee.app.network.c;

import com.shopee.app.d.b.b;
import com.shopee.app.data.store.bg;
import com.shopee.app.database.orm.bean.DBUserBrief;
import com.shopee.app.h.o;
import com.shopee.app.network.d.an;
import com.shopee.app.network.f;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseSearchShopCustomer;
import com.shopee.protocol.action.ShopCustomer;
import com.shopee.protocol.action.ShopCustomerGroup;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ar extends c {
    public int a() {
        return 31;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseSearchShopCustomer responseSearchShopCustomer = (ResponseSearchShopCustomer) f.f18486a.parseFrom(bArr, 0, i, ResponseSearchShopCustomer.class);
        c(responseSearchShopCustomer.requestid);
        c().a(responseSearchShopCustomer);
    }

    public void a(String str) {
        c().a();
    }

    private a c() {
        return com.shopee.app.application.ar.f().e().newReqSearchShopCustomerProcessor();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private n f17822a;

        /* renamed from: b  reason: collision with root package name */
        private bg f17823b;

        public a(n nVar, bg bgVar) {
            this.f17822a = nVar;
            this.f17823b = bgVar;
        }

        public void a(ResponseSearchShopCustomer responseSearchShopCustomer) {
            if (b(responseSearchShopCustomer)) {
                an anVar = (an) o.a().f(responseSearchShopCustomer.requestid);
                ArrayList arrayList = new ArrayList();
                String str = "CMD_GET_SEARCH_CUSTOMER_SUCCESS";
                if (anVar == null) {
                    arrayList.addAll(a(responseSearchShopCustomer.groups, "", true));
                } else {
                    String str2 = anVar.f18113c;
                    if (anVar.f18116f == 0) {
                        arrayList.addAll(a(responseSearchShopCustomer.groups, str2, true));
                    } else if (anVar.f18116f == 1) {
                        arrayList.addAll(a(responseSearchShopCustomer.groups, str2, false));
                        str = "CMD_GET_LOAD_CUSTOMER_SUCCESS";
                    }
                }
                this.f17822a.a(str, new com.garena.android.appkit.b.a(arrayList));
            }
        }

        private List<com.shopee.app.ui.order.search.f> a(List<ShopCustomerGroup> list, String str, boolean z) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (ShopCustomerGroup next : list) {
                if (next.total == null || next.total.intValue() > 0) {
                    if (z) {
                        com.shopee.app.ui.order.search.f fVar = new com.shopee.app.ui.order.search.f();
                        b.a(next, str, fVar);
                        arrayList.add(fVar);
                    }
                    for (ShopCustomer next2 : next.customers) {
                        com.shopee.app.ui.order.search.f fVar2 = new com.shopee.app.ui.order.search.f();
                        b.a(next, next2, str, fVar2);
                        arrayList.add(fVar2);
                        if (next2.user != null && !this.f17823b.a(next2.user.userid.intValue())) {
                            DBUserBrief dBUserBrief = new DBUserBrief();
                            b.a(next2.user, dBUserBrief);
                            arrayList2.add(dBUserBrief);
                        }
                    }
                    if (z) {
                        com.shopee.app.ui.order.search.f fVar3 = new com.shopee.app.ui.order.search.f();
                        fVar3.f23810a = 0;
                        arrayList.add(fVar3);
                    }
                }
            }
            if (!af.a(arrayList2)) {
                this.f17823b.a((List<DBUserBrief>) arrayList2);
            }
            if (arrayList.size() > 0 && ((com.shopee.app.ui.order.search.f) arrayList.get(arrayList.size() - 1)).f23810a == 0) {
                arrayList.remove(arrayList.size() - 1);
            }
            return arrayList;
        }

        private boolean b(ResponseSearchShopCustomer responseSearchShopCustomer) {
            if (responseSearchShopCustomer.errcode.intValue() == 0) {
                return true;
            }
            this.f17822a.a("CMD_GET_SEARCH_CUSTOMER_ERROR", new com.garena.android.appkit.b.a(responseSearchShopCustomer.errcode));
            return false;
        }

        public void a() {
            this.f17822a.a("CMD_GET_SEARCH_CUSTOMER_ERROR", new com.garena.android.appkit.b.a(-100));
        }
    }
}
