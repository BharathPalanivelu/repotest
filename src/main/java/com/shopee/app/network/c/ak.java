package com.shopee.app.network.c;

import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.ap;
import com.shopee.app.data.store.bg;
import com.shopee.app.database.orm.bean.DBUserBrief;
import com.shopee.app.h.o;
import com.shopee.app.network.d.ah;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseUserBriefList;
import com.shopee.protocol.action.UserBrief;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ak extends c {
    public int a() {
        return 30;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseUserBriefList responseUserBriefList = (ResponseUserBriefList) f.f18486a.parseFrom(bArr, 0, i, ResponseUserBriefList.class);
        c(responseUserBriefList.requestid);
        c().a(responseUserBriefList);
    }

    private a c() {
        return ar.f().e().myCustomerProcessor();
    }

    public void a(String str) {
        c().a(str);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final n f17803a;

        /* renamed from: b  reason: collision with root package name */
        private final ap f17804b;

        /* renamed from: c  reason: collision with root package name */
        private final bg f17805c;

        a(n nVar, ap apVar, bg bgVar) {
            this.f17803a = nVar;
            this.f17804b = apVar;
            this.f17805c = bgVar;
        }

        public void a(ResponseUserBriefList responseUserBriefList) {
            DBUserBrief dBUserBrief;
            if (b(responseUserBriefList)) {
                ah ahVar = (ah) o.a().f(responseUserBriefList.requestid);
                if (ahVar != null && ahVar.b() == 0) {
                    this.f17804b.a();
                }
                List<UserBrief> arrayList = responseUserBriefList.user == null ? new ArrayList<>() : responseUserBriefList.user;
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                for (UserBrief userBrief : arrayList) {
                    if (userBrief.username == null && userBrief.status == null) {
                        dBUserBrief = DBUserBrief.a(userBrief.userid.intValue());
                    } else {
                        dBUserBrief = new DBUserBrief();
                        b.a(userBrief, dBUserBrief);
                    }
                    arrayList3.add(userBrief.userid);
                    arrayList2.add(dBUserBrief);
                }
                this.f17804b.b(arrayList3);
                this.f17805c.a((List<DBUserBrief>) arrayList2);
                this.f17803a.a("MY_CUSTOMER_SAVE", new com.garena.android.appkit.b.a());
            }
        }

        private boolean b(ResponseUserBriefList responseUserBriefList) {
            if (responseUserBriefList.errcode.intValue() == 0) {
                return true;
            }
            a(responseUserBriefList.errcode.intValue());
            return false;
        }

        private void a(int i) {
            this.f17803a.a("MY_CUSTOMER_ERROR", new com.garena.android.appkit.b.a(Integer.valueOf(i)));
        }

        public void a(String str) {
            a(-100);
        }
    }
}
