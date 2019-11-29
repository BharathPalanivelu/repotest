package com.shopee.app.network.c;

import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.bg;
import com.shopee.app.data.viewmodel.UserBriefInfo;
import com.shopee.app.database.orm.bean.DBUserBrief;
import com.shopee.app.h.t;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseUserBriefList;
import com.shopee.protocol.action.UserBrief;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class au extends c {
    public int a() {
        return 39;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseUserBriefList responseUserBriefList = (ResponseUserBriefList) f.f18486a.parseFrom(bArr, 0, i, ResponseUserBriefList.class);
        c(responseUserBriefList.requestid);
        c().a(responseUserBriefList);
    }

    private a c() {
        return ar.f().e().getUserBriefProcessor();
    }

    public void a(String str) {
        c().a(str);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final n f17826a;

        /* renamed from: b  reason: collision with root package name */
        private final bg f17827b;

        a(n nVar, bg bgVar) {
            this.f17826a = nVar;
            this.f17827b = bgVar;
        }

        public void a(ResponseUserBriefList responseUserBriefList) {
            DBUserBrief dBUserBrief;
            if (b(responseUserBriefList)) {
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
                    UserBriefInfo userBriefInfo = new UserBriefInfo();
                    b.a(userBriefInfo, userBrief);
                    arrayList3.add(userBriefInfo);
                    arrayList2.add(dBUserBrief);
                }
                this.f17827b.a((List<DBUserBrief>) arrayList2);
                t.a().a((List<UserBriefInfo>) arrayList3);
                this.f17826a.a("USER_BRIEF_LOAD", new com.garena.android.appkit.b.a());
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
            this.f17826a.a("USER_BRIEF_LOAD_FAIL", new com.garena.android.appkit.b.a(Integer.valueOf(i)));
        }

        public void a(String str) {
            a(-100);
        }
    }
}
