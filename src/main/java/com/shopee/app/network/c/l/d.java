package com.shopee.app.network.c.l;

import android.util.Pair;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.viewmodel.UserBriefInfo;
import com.shopee.app.h.o;
import com.shopee.app.network.c.c;
import com.shopee.app.network.d.az;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseUserBriefList;
import com.shopee.protocol.action.UserBrief;
import java.io.IOException;
import java.util.ArrayList;

public class d extends c implements com.shopee.app.network.a.a<ResponseUserBriefList> {
    public int a() {
        return 90;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseUserBriefList responseUserBriefList = (ResponseUserBriefList) f.f18486a.parseFrom(bArr, 0, i, ResponseUserBriefList.class);
        c(responseUserBriefList.requestid);
        c().a(responseUserBriefList);
    }

    public void a(String str) {
        c().a(str);
    }

    private a c() {
        return ar.f().e().newSearchUserProcessor();
    }

    public Pair<String, ResponseUserBriefList> a(byte[] bArr) throws IOException {
        ResponseUserBriefList responseUserBriefList = (ResponseUserBriefList) f.f18486a.parseFrom(bArr, 0, bArr.length, ResponseUserBriefList.class);
        return new Pair<>(responseUserBriefList.requestid, responseUserBriefList);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final n f18039a;

        public a(n nVar) {
            this.f18039a = nVar;
        }

        public void a(ResponseUserBriefList responseUserBriefList) {
            if (b(responseUserBriefList)) {
                az f2 = o.a().f(responseUserBriefList.requestid);
                String c2 = f2 instanceof com.shopee.app.network.d.i.d ? ((com.shopee.app.network.d.i.d) f2).c() : "";
                ArrayList arrayList = new ArrayList();
                for (UserBrief a2 : responseUserBriefList.user) {
                    UserBriefInfo userBriefInfo = new UserBriefInfo();
                    b.a(userBriefInfo, a2);
                    userBriefInfo.setMatchKeyword(c2);
                    arrayList.add(userBriefInfo);
                }
                this.f18039a.a("SEARCH_USER_LOAD", new com.garena.android.appkit.b.a(new Pair(c2, arrayList)));
            }
        }

        private boolean b(ResponseUserBriefList responseUserBriefList) {
            if (responseUserBriefList.errcode.intValue() == 0 && responseUserBriefList.user != null) {
                return true;
            }
            if (responseUserBriefList.errcode.intValue() == 0) {
                this.f18039a.a("SEARCH_USER_EMPTY", new com.garena.android.appkit.b.a());
                return false;
            }
            a(responseUserBriefList.errcode.intValue());
            return false;
        }

        private void a(int i) {
            this.f18039a.a("SEARCH_USER_ERROR", new com.garena.android.appkit.b.a(Integer.valueOf(i)));
        }

        public void a(String str) {
            a(-100);
        }
    }
}
