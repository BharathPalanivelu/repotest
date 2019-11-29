package com.shopee.app.network.c;

import com.garena.android.appkit.b.b;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.ah;
import com.shopee.app.database.orm.bean.DBItemDetail;
import com.shopee.app.h.o;
import com.shopee.app.network.d.ad;
import com.shopee.app.network.d.az;
import com.shopee.app.network.f;
import com.shopee.app.ui.follow.following.k;
import com.shopee.app.ui.follow.following.t;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.protocol.action.RecUser;
import com.shopee.protocol.action.ResponseRecUsers;
import com.shopee.protocol.action.ShopItemId;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class aq extends c {
    public int a() {
        return 179;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseRecUsers responseRecUsers = (ResponseRecUsers) f.f18486a.parseFrom(bArr, 0, i, ResponseRecUsers.class);
        if (a(responseRecUsers)) {
            c().a(responseRecUsers);
        }
    }

    public a c() {
        return ar.f().e().getRecommendFriendProcessor();
    }

    private boolean a(ResponseRecUsers responseRecUsers) {
        if (responseRecUsers.errcode.intValue() == 0) {
            return true;
        }
        int intValue = responseRecUsers.errcode.intValue();
        b.a("GET_REC_FRIEND_ERROR", new com.garena.android.appkit.b.a("wrong " + responseRecUsers.errcode), b.a.NETWORK_BUS);
        return false;
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final n f17820a;

        /* renamed from: b  reason: collision with root package name */
        private final ah f17821b;

        public a(n nVar, ah ahVar) {
            this.f17820a = nVar;
            this.f17821b = ahVar;
        }

        /* access modifiers changed from: package-private */
        public void a(ResponseRecUsers responseRecUsers) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (!af.a(responseRecUsers.users)) {
                for (RecUser next : responseRecUsers.users) {
                    ArrayList arrayList3 = new ArrayList();
                    for (Long next2 : next.itemid_list) {
                        DBItemDetail a2 = this.f17821b.a(next2.longValue());
                        if (a2 == null) {
                            ShopItemId.Builder builder = new ShopItemId.Builder();
                            builder.shopid(next.user.shopid).itemid(next2).mtime(0);
                            arrayList2.add(builder.build());
                        } else if (arrayList2.isEmpty()) {
                            k kVar = new k();
                            com.shopee.app.d.b.b.a(kVar, a2);
                            arrayList3.add(kVar);
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        t tVar = new t();
                        tVar.f(2);
                        com.shopee.app.d.b.b.a(tVar, next);
                        tVar.a((List<k>) arrayList3);
                        if (!tVar.g()) {
                            arrayList.add(tVar);
                        }
                    }
                }
            }
            if (arrayList2.isEmpty()) {
                this.f17820a.a("GET_REC_FRIEND_LIST", new com.garena.android.appkit.b.a(arrayList));
                return;
            }
            ad adVar = new ad();
            adVar.a(arrayList2, responseRecUsers);
            o.a().a((az) adVar);
        }
    }
}
