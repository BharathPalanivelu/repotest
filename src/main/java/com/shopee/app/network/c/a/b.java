package com.shopee.app.network.c.a;

import android.util.Pair;
import com.garena.android.appkit.b.b;
import com.shopee.app.application.ar;
import com.shopee.app.database.orm.bean.DBActionContent;
import com.shopee.app.database.orm.bean.DBActionGroup;
import com.shopee.app.h.o;
import com.shopee.app.network.c.c;
import com.shopee.app.network.d.az;
import com.shopee.app.network.f;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.app.web.WebRegister;
import com.shopee.protocol.action.ResponseActionIdList;
import com.shopee.protocol.shop.SimpleAction;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class b extends c implements com.shopee.app.network.a.a<ResponseActionIdList> {
    public int a() {
        return 18;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseActionIdList responseActionIdList = (ResponseActionIdList) f.f18486a.parseFrom(bArr, 0, i, ResponseActionIdList.class);
        c(responseActionIdList.requestid);
        c().a(responseActionIdList);
    }

    private a c() {
        return ar.f().e().newActionGetIDListProcessor();
    }

    public Pair<String, ResponseActionIdList> a(byte[] bArr) throws IOException {
        ResponseActionIdList responseActionIdList = (ResponseActionIdList) f.f18486a.parseFrom(bArr, 0, bArr.length, ResponseActionIdList.class);
        return new Pair<>(responseActionIdList.requestid, responseActionIdList);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final com.shopee.app.data.store.b f17777a;

        /* renamed from: b  reason: collision with root package name */
        private final com.shopee.app.data.store.c f17778b;

        /* renamed from: c  reason: collision with root package name */
        private final n f17779c;

        /* renamed from: d  reason: collision with root package name */
        private final com.shopee.app.data.store.a f17780d;

        public a(n nVar, com.shopee.app.data.store.b bVar, com.shopee.app.data.store.a aVar, com.shopee.app.data.store.c cVar) {
            this.f17779c = nVar;
            this.f17777a = bVar;
            this.f17780d = aVar;
            this.f17778b = cVar;
        }

        public void a(ResponseActionIdList responseActionIdList) {
            if (b(responseActionIdList)) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (SimpleAction simpleAction : responseActionIdList.simple_action_list == null ? new ArrayList() : responseActionIdList.simple_action_list) {
                    DBActionContent a2 = this.f17778b.a(simpleAction.action_id.longValue());
                    if (a2 == null || a2.f() != simpleAction.createtime.intValue()) {
                        arrayList.add(simpleAction.action_id);
                    }
                    arrayList2.add(simpleAction.action_id);
                }
                az f2 = o.a().f(responseActionIdList.requestid);
                if (f2 != null && (f2 instanceof com.shopee.app.network.d.a.b)) {
                    com.shopee.app.network.d.a.b bVar = (com.shopee.app.network.d.a.b) f2;
                    int c2 = bVar.c();
                    if (!bVar.e()) {
                        if (bVar.d() == 0 && bVar.k() == 0) {
                            this.f17777a.b(c2);
                        }
                        if (bVar.k() != 0) {
                            DBActionGroup dBActionGroup = new DBActionGroup();
                            dBActionGroup.a(bVar.k());
                            dBActionGroup.a(WebRegister.GSON.b((Object) arrayList2));
                            this.f17780d.a((List<DBActionGroup>) Collections.singletonList(dBActionGroup));
                        } else {
                            this.f17777a.a((List<Long>) arrayList2, c2);
                        }
                    }
                    if (bVar.d() == 0) {
                        this.f17777a.a(c2, af.a(arrayList2) ? -1 : ((Long) arrayList2.get(0)).longValue());
                    }
                    if (!af.a(arrayList)) {
                        com.shopee.app.network.d.a.a aVar = new com.shopee.app.network.d.a.a();
                        aVar.a(bVar.k());
                        aVar.h();
                        aVar.a((List<Long>) arrayList);
                    }
                    if (!af.a(arrayList)) {
                        return;
                    }
                    if (bVar.j()) {
                        this.f17779c.a().cV.a(Long.valueOf(bVar.k())).a();
                    } else {
                        this.f17779c.a().bt.a(new Pair(Long.valueOf(bVar.d()), Integer.valueOf(c2))).a();
                    }
                }
            }
        }

        private boolean b(ResponseActionIdList responseActionIdList) {
            if (responseActionIdList.errcode.intValue() == 0) {
                return true;
            }
            a(responseActionIdList.errcode.intValue());
            return false;
        }

        private void a(int i) {
            com.garena.android.appkit.b.b.a("ACTION_LIST_LOAD_FAIL", new com.garena.android.appkit.b.a(Integer.valueOf(i)), b.a.NETWORK_BUS);
        }

        public void a(String str) {
            a(-100);
        }
    }

    public void a(String str) {
        c().a(str);
    }
}
