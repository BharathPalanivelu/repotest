package com.shopee.app.network.c;

import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.viewmodel.UserData;
import com.shopee.app.database.orm.bean.DBUserInfo;
import com.shopee.app.h.o;
import com.shopee.app.network.d.au;
import com.shopee.app.network.f;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseUserList;
import com.shopee.protocol.shop.Account;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class aw extends c {
    public int a() {
        return 63;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseUserList responseUserList = (ResponseUserList) f.f18486a.parseFrom(bArr, 0, i, ResponseUserList.class);
        c(responseUserList.requestid);
        c().a(responseUserList);
    }

    private a c() {
        return ar.f().e().getUserInfoProcessor();
    }

    public void a(String str) {
        c().a(-100);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private UserInfo f17830a;

        /* renamed from: b  reason: collision with root package name */
        private n f17831b;

        /* renamed from: c  reason: collision with root package name */
        private bh f17832c;

        a(UserInfo userInfo, n nVar, bh bhVar) {
            this.f17830a = userInfo;
            this.f17831b = nVar;
            this.f17832c = bhVar;
        }

        public void a(ResponseUserList responseUserList) {
            if (b(responseUserList)) {
                ArrayList arrayList = new ArrayList();
                if (!af.a(responseUserList.user)) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Account next : responseUserList.user) {
                        DBUserInfo dBUserInfo = new DBUserInfo();
                        if (next.status == null && next.username == null) {
                            dBUserInfo = DBUserInfo.a(next.userid.intValue());
                        } else {
                            b.a(next, dBUserInfo);
                        }
                        arrayList2.add(dBUserInfo);
                        UserData userData = new UserData();
                        b.a(dBUserInfo, userData);
                        arrayList.add(userData);
                        if (this.f17830a.getUserId() == userData.getUserId()) {
                            b.a(dBUserInfo, this.f17830a);
                            this.f17831b.a().bL.a(this.f17830a).a();
                        }
                    }
                    if (arrayList2.size() > 0) {
                        this.f17832c.a((List<DBUserInfo>) arrayList2);
                    }
                }
                au auVar = (au) o.a().f(responseUserList.requestid);
                if (auVar == null || !auVar.b()) {
                    this.f17831b.a("GET_USER_INFO_LOAD", new com.garena.android.appkit.b.a(arrayList));
                } else {
                    this.f17831b.a("GET_USER_INFO_LOAD_LIST", new com.garena.android.appkit.b.a(arrayList));
                }
                this.f17831b.a("GET_USER_INFO_LOAD_EDIT", new com.garena.android.appkit.b.a(responseUserList.requestid));
            }
        }

        private boolean b(ResponseUserList responseUserList) {
            if (responseUserList.errcode.intValue() == 0) {
                return true;
            }
            a(responseUserList.errcode.intValue());
            return false;
        }

        /* access modifiers changed from: private */
        public void a(int i) {
            this.f17831b.a("GET_USER_INFO_ERROR", new com.garena.android.appkit.b.a(Integer.valueOf(i)));
        }
    }
}
