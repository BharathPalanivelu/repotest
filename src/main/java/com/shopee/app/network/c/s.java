package com.shopee.app.network.c;

import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.d;
import com.shopee.app.data.store.e;
import com.shopee.app.database.orm.bean.DBActivityItem;
import com.shopee.app.h.o;
import com.shopee.app.network.d.r;
import com.shopee.app.network.f;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ActivityItem;
import com.shopee.protocol.action.ResponseActivityList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class s extends c {
    public int a() {
        return 95;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseActivityList responseActivityList = (ResponseActivityList) f.f18486a.parseFrom(bArr, 0, i, ResponseActivityList.class);
        c(responseActivityList.requestid);
        c().a(responseActivityList);
    }

    private a c() {
        return ar.f().e().newGetActivityListProcessor();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final e f18046a;

        /* renamed from: b  reason: collision with root package name */
        private final d f18047b;

        /* renamed from: c  reason: collision with root package name */
        private n f18048c;

        public a(n nVar, e eVar, d dVar) {
            this.f18048c = nVar;
            this.f18046a = eVar;
            this.f18047b = dVar;
        }

        public void a(ResponseActivityList responseActivityList) {
            if (b(responseActivityList)) {
                r rVar = (r) o.a().f(responseActivityList.requestid);
                if (!(rVar == null || rVar.b() != 0 || rVar.c() == 1)) {
                    this.f18047b.a(rVar.d());
                }
                if (rVar != null) {
                    if (!af.a(responseActivityList.activity_items)) {
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        for (ActivityItem next : responseActivityList.activity_items) {
                            arrayList.add(next.activity_id);
                            DBActivityItem dBActivityItem = new DBActivityItem();
                            b.a(next, dBActivityItem);
                            arrayList2.add(dBActivityItem);
                        }
                        this.f18047b.a((List<Integer>) arrayList, rVar.d());
                        this.f18046a.a((List<DBActivityItem>) arrayList2);
                    }
                    this.f18048c.a("ACTIVITY_LIST_SAVED", new com.garena.android.appkit.b.a(Integer.valueOf(rVar.d())));
                }
            }
        }

        private boolean b(ResponseActivityList responseActivityList) {
            if (responseActivityList.errcode.intValue() == 0) {
                return true;
            }
            this.f18048c.a("ACTIVITY_LIST_ERROR", new com.garena.android.appkit.b.a("Network Error"));
            return false;
        }
    }
}
