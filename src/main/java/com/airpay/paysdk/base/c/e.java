package com.airpay.paysdk.base.c;

import android.text.TextUtils;
import com.airpay.paysdk.base.b.d;
import com.airpay.paysdk.common.b.a;
import com.airpay.paysdk.common.net.a.a.g;
import com.airpay.paysdk.common.net.tcp.b.b;
import com.airpay.paysdk.common.net.tcp.b.f;
import java.util.concurrent.atomic.AtomicInteger;

public class e implements c {

    /* renamed from: a  reason: collision with root package name */
    private AtomicInteger f3801a = new AtomicInteger(0);

    public boolean a(com.airpay.paysdk.common.net.tcp.b.e eVar, f fVar) {
        a.a("koneng----cmd---" + eVar.e(), new Object[0]);
        Class g2 = eVar.g();
        com.airpay.paysdk.common.net.a.a.a f2 = eVar.f();
        if (!TextUtils.isEmpty(d.a().b())) {
            if (this.f3801a.getAndIncrement() <= 1) {
                com.airpay.paysdk.common.net.a.a().a((g) new com.airpay.paysdk.common.net.tcp.b.e(b.a(), eVar.e(), eVar.d()), g2, f2);
                return true;
            }
            this.f3801a.set(0);
        }
        return false;
    }
}
