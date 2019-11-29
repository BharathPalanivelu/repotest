package com.shopee.app.network;

import com.beetalklib.network.a.b.a;
import com.shopee.app.application.ar;
import com.tencent.imsdk.BaseConstants;

public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private long f17776a;

    public int a() {
        return 2;
    }

    public c(int i) {
        this.f17776a = (long) (i / 4);
        long j = a.d(ar.a()) ? BaseConstants.DEFAULT_MSG_TIMEOUT : 60000;
        if (this.f17776a < j) {
            this.f17776a = j;
        }
    }

    public long b() {
        if (a.a()) {
            return this.f17776a;
        }
        return 1000;
    }

    public a.C0096a c() {
        return a.C0096a.REQUEST_WITH_ID_AND_RESPONSE_WITH_ID;
    }
}
