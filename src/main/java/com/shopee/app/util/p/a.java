package com.shopee.app.util.p;

import android.content.Context;
import cn.tongdun.android.shell.FMAgent;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.al;
import d.a.z;
import d.d.b.j;
import d.h.m;
import d.l;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f26481a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f26482b;

    private a() {
    }

    public final boolean a() {
        return f26482b;
    }

    private final String c() {
        int hashCode = "ID".hashCode();
        if (hashCode == 2331) {
            return "Shopee_id";
        }
        if (!(hashCode == 2476 || hashCode == 2552 || hashCode == 2644 || hashCode == 2676 || hashCode == 2691)) {
        }
        return "";
    }

    public final void a(Context context, int i) {
        j.b(context, "context");
        try {
            ar f2 = ar.f();
            j.a((Object) f2, "ShopeeApplication.get()");
            f26482b = f2.e().featureToggleManager().a("tongdun");
            if (f26482b) {
                FMAgent.initWithOptions(context, FMAgent.ENV_PRODUCTION, z.c(l.a(FMAgent.OPTION_PARTNER_CODE, c()), l.a(FMAgent.OPTION_DOMAIN, a(i))));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            f26482b = false;
        }
    }

    public final String b() {
        return f26482b ? FMAgent.onEvent(ar.f()) : "";
    }

    private final String a(int i) {
        if (i == 2) {
            return "https://idfp.tongdun.net";
        }
        ar f2 = ar.f();
        j.a((Object) f2, "ShopeeApplication.get()");
        al loginStore = f2.e().loginStore();
        j.a((Object) loginStore, "ShopeeApplication.get().component.loginStore()");
        String A = loginStore.A();
        CharSequence charSequence = A;
        return charSequence == null || m.a(charSequence) ? "https://idfptest.tongdun.net" : A;
    }
}
