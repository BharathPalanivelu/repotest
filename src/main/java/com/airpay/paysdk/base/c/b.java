package com.airpay.paysdk.base.c;

import android.text.TextUtils;
import com.airpay.paysdk.common.b.a;
import com.airpay.paysdk.common.net.a.a.e;
import com.airpay.paysdk.common.net.tcp.b.f;

public class b implements e {

    /* renamed from: a  reason: collision with root package name */
    private d f3797a = new d();

    public boolean a(com.airpay.paysdk.common.net.tcp.b.e eVar, f fVar) {
        int d2 = fVar.d();
        String e2 = fVar.e();
        if (TextUtils.isEmpty(e2)) {
            e2 = com.airpay.paysdk.base.d.f.c(d2);
            fVar.a(e2);
        }
        a.a("koneng handleError, code:" + d2 + ", msg: " + e2, new Object[0]);
        return this.f3797a.a(eVar).a(fVar).a();
    }
}
