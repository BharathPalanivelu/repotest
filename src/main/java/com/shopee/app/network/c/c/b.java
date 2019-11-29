package com.shopee.app.network.c.c;

import com.shopee.app.application.ar;
import com.shopee.app.data.store.k;
import com.shopee.app.data.viewmodel.UserBriefInfo;
import com.shopee.app.database.orm.bean.chatP2P.DBBlockUser;
import com.shopee.app.h.t;
import com.shopee.app.network.c.c;
import com.shopee.app.network.d.at;
import com.shopee.app.network.f;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.protocol.action.BlockedUser;
import com.shopee.protocol.action.ResponseBlockUserList;
import java.io.IOException;
import java.util.ArrayList;

public class b extends c {
    public int a() {
        return 207;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseBlockUserList responseBlockUserList = (ResponseBlockUserList) f.f18486a.parseFrom(bArr, 0, i, ResponseBlockUserList.class);
        c(responseBlockUserList.requestid);
        c().a(responseBlockUserList);
    }

    public void a(String str) {
        c().a();
    }

    private a c() {
        return ar.f().e().newGetBlockUserListProcessor();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private n f17878a;

        /* renamed from: b  reason: collision with root package name */
        private k f17879b;

        public a(n nVar, k kVar) {
            this.f17878a = nVar;
            this.f17879b = kVar;
        }

        public void a(ResponseBlockUserList responseBlockUserList) {
            if (b(responseBlockUserList)) {
                this.f17879b.a();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                if (!af.a(responseBlockUserList.user)) {
                    int i = 0;
                    for (BlockedUser next : responseBlockUserList.user) {
                        DBBlockUser dBBlockUser = new DBBlockUser();
                        DBBlockUser.a(next, dBBlockUser);
                        dBBlockUser.b(i);
                        arrayList.add(dBBlockUser);
                        UserBriefInfo a2 = t.a().a(next.userid.intValue());
                        if (a2 == null) {
                            arrayList2.add(next.userid);
                        } else {
                            a2.setIsChatBlocked(next.blocked.booleanValue());
                        }
                        i++;
                    }
                }
                if (arrayList2.size() > 0) {
                    new at().a(arrayList2, new ArrayList(), true);
                }
                this.f17879b.a(arrayList);
                this.f17878a.a("CMD_GET_BLOCK_USER_LIST_SUCCESS", new com.garena.android.appkit.b.a());
            }
        }

        private boolean b(ResponseBlockUserList responseBlockUserList) {
            if (responseBlockUserList.errcode.intValue() == 0) {
                return true;
            }
            this.f17878a.a("CMD_GET_BLOCK_USER_LIST_ERROR", new com.garena.android.appkit.b.a(responseBlockUserList.errcode));
            return false;
        }

        public void a() {
            this.f17878a.a("CMD_GET_BLOCK_USER_LIST_ERROR", new com.garena.android.appkit.b.a(-100));
        }
    }
}
