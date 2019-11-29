package com.airpay.paysdk.core.dispatch;

import android.content.Intent;
import android.util.AndroidRuntimeException;
import com.airpay.paysdk.base.b.c;
import com.airpay.paysdk.base.d.o;
import com.airpay.paysdk.base.ui.a.a;
import com.airpay.paysdk.core.bean.Param;

abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private a f4132a;

    /* renamed from: b  reason: collision with root package name */
    private Param f4133b;

    /* renamed from: c  reason: collision with root package name */
    private com.airpay.paysdk.b f4134c;

    /* access modifiers changed from: package-private */
    public abstract void a(a aVar, com.airpay.paysdk.b bVar, Param param);

    b() {
    }

    static b a(String str) {
        if ("airpay.intent.action.OPEN_QR_CODE".equals(str)) {
            return new a();
        }
        if ("airpay.intent.action.SCAN_TO_PAY".equals(str)) {
            return new c();
        }
        throw new AndroidRuntimeException("don't support the action, the current action is: " + str);
    }

    /* access modifiers changed from: package-private */
    public b a(a aVar) {
        this.f4132a = aVar;
        return this;
    }

    /* access modifiers changed from: package-private */
    public b a(Intent intent) {
        this.f4134c = o.a(intent.getExtras());
        this.f4133b = (Param) intent.getParcelableExtra("param");
        c.a().a(com.airpay.paysdk.base.different.a.a().f());
        return this;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        a(this.f4132a, this.f4134c, this.f4133b);
    }
}
