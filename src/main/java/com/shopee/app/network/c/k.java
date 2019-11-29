package com.shopee.app.network.c;

import com.facebook.imageutils.JfifUtil;
import com.shopee.app.application.ar;
import com.shopee.app.data.viewmodel.UserBriefInfo;
import com.shopee.app.database.orm.bean.chatP2P.DBBlockUser;
import com.shopee.app.h.t;
import com.shopee.app.network.d.at;
import com.shopee.app.network.f;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.protocol.action.BlockedUser;
import com.shopee.protocol.action.ResponseBlockUserList;
import java.io.IOException;
import java.util.ArrayList;

public class k extends c {
    public int a() {
        return JfifUtil.MARKER_RST0;
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
        return ar.f().e().newCheckUserBlockedProcessor();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private n f18004a;

        /* renamed from: b  reason: collision with root package name */
        private com.shopee.app.data.store.k f18005b;

        public a(n nVar, com.shopee.app.data.store.k kVar) {
            this.f18004a = nVar;
            this.f18005b = kVar;
        }

        public void a(ResponseBlockUserList responseBlockUserList) {
            if (b(responseBlockUserList)) {
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
                this.f18005b.a(arrayList);
                this.f18004a.a("CMD_CHECK_USER_BLOCKED_SUCCUSS", new com.garena.android.appkit.b.a());
            }
        }

        private boolean b(ResponseBlockUserList responseBlockUserList) {
            if (responseBlockUserList.errcode.intValue() == 0) {
                return true;
            }
            this.f18004a.a("CMD_CHECK_USER_BLOCKED_ERROR", new com.garena.android.appkit.b.a(responseBlockUserList.errcode));
            return false;
        }

        public void a() {
            this.f18004a.a("CMD_CHECK_USER_BLOCKED_ERROR", new com.garena.android.appkit.b.a(-100));
        }
    }
}
