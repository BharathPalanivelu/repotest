package com.airpay.paysdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import com.airpay.paysdk.base.d.o;
import com.airpay.paysdk.base.different.netserver.TcpServerBean;
import com.airpay.paysdk.base.different.netserver.b;
import com.airpay.paysdk.common.net.a.a;
import com.airpay.paysdk.common.net.a.a.d;
import com.airpay.paysdk.common.net.a.a.e;
import com.airpay.paysdk.common.net.tcp.b.c;
import com.airpay.paysdk.core.bean.PayResult;
import com.airpay.paysdk.core.dispatch.DispatchActivity;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f3779a;

    /* renamed from: b  reason: collision with root package name */
    private com.airpay.paysdk.base.different.netserver.a f3780b;

    /* renamed from: c  reason: collision with root package name */
    private volatile int f3781c;

    /* renamed from: com.airpay.paysdk.a$a  reason: collision with other inner class name */
    private static final class C0070a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final a f3782a = new a();
    }

    private a() {
        this.f3781c = 0;
    }

    public static a a() {
        return C0070a.f3782a;
    }

    private void a(Context context, com.airpay.paysdk.base.different.netserver.a aVar) {
        this.f3779a = context.getApplicationContext();
        if (this.f3779a != null) {
            this.f3781c = 1;
            this.f3780b = aVar;
            com.airpay.paysdk.common.b.a.a();
            com.airpay.paysdk.common.b.a.a(aVar.g());
            a(b.a(aVar));
            com.airpay.paysdk.common.c.a.a().b();
            com.airpay.paysdk.base.different.a.a().a(aVar.b());
            com.airpay.paysdk.common.e.a.a(this.f3779a);
            this.f3781c = 2;
            return;
        }
        throw new RuntimeException("init context is null");
    }

    public Context b() {
        return this.f3779a;
    }

    private void a(TcpServerBean tcpServerBean) {
        com.airpay.paysdk.common.net.a.a().a(new a.C0078a().a(new c.a().a(true).a(tcpServerBean.getPort()).a(tcpServerBean.getAddress()).a((d) new com.airpay.paysdk.base.c.a()).a()).a((e) new com.airpay.paysdk.base.c.b()).a());
    }

    public void a(Activity activity, com.airpay.paysdk.core.b bVar, com.airpay.paysdk.base.different.netserver.a aVar, b bVar2) {
        if (activity == null) {
            throw new AndroidRuntimeException("the activity can't be null.");
        } else if (bVar2 == null) {
            throw new AndroidRuntimeException("the IPayCall can't be null.");
        } else if (bVar.a() == null || !aVar.a()) {
            bVar2.onResponse(new PayResult(-1, "the param is not valid"));
        } else if (e()) {
            a(activity, aVar);
            Bundle bundle = new Bundle();
            if (bVar != null) {
                bundle.putParcelable("param", bVar.a());
            }
            o.a(bundle, bVar2);
            activity.startActivity(new Intent(activity, DispatchActivity.class).setAction("airpay.intent.action.OPEN_QR_CODE").putExtras(bundle));
            activity.overridePendingTransition(0, 0);
        }
    }

    public void b(Activity activity, com.airpay.paysdk.core.b bVar, com.airpay.paysdk.base.different.netserver.a aVar, b bVar2) {
        if (activity == null) {
            throw new AndroidRuntimeException("the activity can't be null.");
        } else if (bVar == null) {
            throw new AndroidRuntimeException("the PayParam can't be null.");
        } else if (bVar2 == null) {
            throw new AndroidRuntimeException("the IPayCall can't be null.");
        } else if (bVar.a() == null || TextUtils.isEmpty(bVar.a().b()) || !aVar.a()) {
            bVar2.onResponse(new PayResult(-1, "the param is not valid"));
        } else if (e()) {
            a(activity, aVar);
            Bundle bundle = new Bundle();
            bundle.putParcelable("param", bVar.a());
            o.a(bundle, bVar2);
            activity.startActivity(new Intent(activity, DispatchActivity.class).setAction("airpay.intent.action.SCAN_TO_PAY").putExtras(bundle));
            activity.overridePendingTransition(0, 0);
        }
    }

    public com.airpay.paysdk.base.different.netserver.a c() {
        return this.f3780b;
    }

    private boolean e() {
        return this.f3781c == 0;
    }

    public void d() {
        com.airpay.paysdk.common.net.b.c.a().a(b());
        com.airpay.paysdk.common.net.tcp.a.a.a().b();
        com.airpay.paysdk.common.net.a.a().c();
        com.airpay.paysdk.base.b.d.a().c();
        com.airpay.paysdk.base.b.b.a().c();
        com.airpay.paysdk.qrcode.a.a().c();
        com.airpay.paysdk.common.e.a.c();
        this.f3781c = 0;
        com.airpay.paysdk.common.b.a.a("                                          ", new Object[0]);
        com.airpay.paysdk.common.b.a.a("==========================================", new Object[0]);
        com.airpay.paysdk.common.b.a.a("==>>  release resource and exit, bye  <<==", new Object[0]);
        com.airpay.paysdk.common.b.a.a("==========================================", new Object[0]);
        com.airpay.paysdk.common.b.a.a("                                          ", new Object[0]);
    }
}
