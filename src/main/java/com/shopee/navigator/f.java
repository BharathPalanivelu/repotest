package com.shopee.navigator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.google.a.o;
import com.shopee.navigator.a.b;
import com.shopee.navigator.b.a;
import com.shopee.navigator.c;
import com.shopee.navigator.c.d;
import com.shopee.navigator.options.PopOption;
import com.shopee.navigator.options.PushOption;

public class f extends e {

    /* renamed from: a  reason: collision with root package name */
    private final Class<? extends Object> f30132a;

    /* renamed from: b  reason: collision with root package name */
    private final b f30133b;

    /* renamed from: c  reason: collision with root package name */
    private d f30134c;

    f(d dVar, b bVar, Class<? extends Object> cls) {
        this.f30134c = dVar;
        this.f30132a = cls;
        this.f30133b = bVar;
    }

    public void a(Activity activity, NavigationPath navigationPath) {
        b(activity, navigationPath, new o(), PushOption.a());
    }

    public void a(Activity activity, NavigationPath navigationPath, o oVar) {
        if (oVar == null) {
            oVar = new o();
        }
        b(activity, navigationPath, oVar, PushOption.a());
    }

    public void a(Activity activity, NavigationPath navigationPath, o oVar, PushOption pushOption) {
        if (oVar == null) {
            oVar = new o();
        }
        b(activity, navigationPath, oVar, pushOption);
    }

    public void a(Activity activity, o oVar, PopOption popOption) {
        if (oVar == null) {
            oVar = new o();
        }
        b(activity, oVar, popOption, a(activity));
    }

    public void a(Activity activity, int i, int i2, Intent intent) {
        if (i2 == -98) {
            if (intent != null) {
                c cVar = new c(intent);
                b(activity, cVar.c(), cVar.b(), cVar.f());
            }
        } else if (i2 == -99) {
            if (intent != null) {
                c cVar2 = new c(intent);
                b(activity, cVar2.e(), cVar2.c(), cVar2.a());
            }
        } else if (activity instanceof a) {
            a aVar = (a) activity;
            if (intent == null) {
                aVar.a(i2, "", new o());
                return;
            }
            c cVar3 = new c(intent);
            aVar.a(i2, cVar3.f(), cVar3.c());
        }
    }

    private void b(Activity activity, NavigationPath navigationPath, o oVar, PushOption pushOption) {
        if (pushOption.c() <= 0) {
            a(activity, navigationPath, oVar, false, this.f30133b.a(pushOption.b()));
            this.f30133b.a(activity, pushOption.b());
        } else if (pushOption.c() == 1) {
            a(activity, navigationPath, oVar, true, this.f30133b.a(pushOption.b()));
            activity.finish();
            this.f30133b.a(activity, pushOption.b());
        } else if (pushOption.c() > 1) {
            pushOption.a(pushOption.c() - 1);
            c(activity, navigationPath, oVar, pushOption);
        }
    }

    private void a(Activity activity, NavigationPath navigationPath, o oVar, boolean z, boolean z2) {
        Intent intent;
        if (navigationPath.c()) {
            intent = d.a(activity, navigationPath.a(), oVar);
        } else {
            if (this.f30134c != null && navigationPath.d()) {
                com.shopee.navigator.c.a aVar = new com.shopee.navigator.c.a(navigationPath.b());
                com.shopee.navigator.c.b a2 = this.f30134c.a(aVar);
                if (a2 != null && a2.e()) {
                    a2.a(activity, aVar, d.a(aVar.d(), oVar), z2, z);
                    return;
                } else if (a2 != null && !a2.e()) {
                    intent = a2.a(activity, aVar, d.a(aVar.d(), oVar), z2);
                }
            }
            intent = null;
        }
        if (intent == null) {
            a((Context) activity);
        } else if (z) {
            intent.addFlags(33554432);
            activity.startActivity(intent);
        } else {
            activity.startActivityForResult(intent, 1021);
        }
    }

    private void c(Activity activity, NavigationPath navigationPath, o oVar, PushOption pushOption) {
        activity.setResult(-99, new c.a().a(pushOption).a(navigationPath).a(oVar).a().i());
        activity.finish();
        activity.overridePendingTransition(0, 0);
    }

    private void a(Activity activity, o oVar, PopOption popOption, String str) {
        activity.setResult(-98, new c.a().a(oVar).a(popOption).a(str).a().i());
        activity.finish();
        activity.overridePendingTransition(0, 0);
    }

    private void b(Activity activity, o oVar, PopOption popOption, String str) {
        if (popOption.b() > 1) {
            popOption.a(popOption.b() - 1);
            a(activity, oVar, popOption, str);
            return;
        }
        activity.setResult(-1, new c.a().a(oVar).a(str).a().i());
        activity.finish();
        this.f30133b.b(activity, popOption.a());
    }

    private String a(Activity activity) {
        if (activity instanceof a) {
            return ((a) activity).a();
        }
        return activity.getClass().getSimpleName();
    }

    private void a(Context context) {
        Toast.makeText(context, "Feature not available", 0).show();
    }
}
