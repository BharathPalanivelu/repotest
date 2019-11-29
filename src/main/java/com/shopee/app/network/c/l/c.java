package com.shopee.app.network.c.l;

import com.shopee.app.application.ar;
import com.shopee.app.network.c.l.d;
import com.shopee.app.network.f;
import com.shopee.protocol.action.ResponseUserBriefList;
import java.io.IOException;

public class c extends com.shopee.app.network.c.c {
    public int a() {
        return 100;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseUserBriefList responseUserBriefList = (ResponseUserBriefList) f.f18486a.parseFrom(bArr, 0, i, ResponseUserBriefList.class);
        c(responseUserBriefList.requestid);
        c().a(responseUserBriefList);
    }

    private d.a c() {
        return ar.f().e().newSearchUserProcessor();
    }

    public void a(String str) {
        c().a(str);
    }
}
