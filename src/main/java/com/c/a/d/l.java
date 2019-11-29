package com.c.a.d;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.h;
import com.c.a.c;
import com.c.a.i.i;
import com.c.a.j;
import java.util.HashMap;
import java.util.Map;

public class l implements Handler.Callback {
    private static final a i = new a() {
        public j a(c cVar, h hVar, m mVar, Context context) {
            return new j(cVar, hVar, mVar, context);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final Map<FragmentManager, k> f6137a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    final Map<h, o> f6138b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private volatile j f6139c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f6140d;

    /* renamed from: e  reason: collision with root package name */
    private final a f6141e;

    /* renamed from: f  reason: collision with root package name */
    private final androidx.b.a<View, Fragment> f6142f = new androidx.b.a<>();

    /* renamed from: g  reason: collision with root package name */
    private final androidx.b.a<View, android.app.Fragment> f6143g = new androidx.b.a<>();
    private final Bundle h = new Bundle();

    public interface a {
        j a(c cVar, h hVar, m mVar, Context context);
    }

    public l(a aVar) {
        this.f6141e = aVar == null ? i : aVar;
        this.f6140d = new Handler(Looper.getMainLooper(), this);
    }

    private j b(Context context) {
        if (this.f6139c == null) {
            synchronized (this) {
                if (this.f6139c == null) {
                    this.f6139c = this.f6141e.a(c.a(context.getApplicationContext()), new b(), new g(), context.getApplicationContext());
                }
            }
        }
        return this.f6139c;
    }

    public j a(Context context) {
        if (context != null) {
            if (i.c() && !(context instanceof Application)) {
                if (context instanceof androidx.fragment.app.c) {
                    return a((androidx.fragment.app.c) context);
                }
                if (context instanceof Activity) {
                    return a((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    return a(((ContextWrapper) context).getBaseContext());
                }
            }
            return b(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public j a(androidx.fragment.app.c cVar) {
        if (i.d()) {
            return a(cVar.getApplicationContext());
        }
        b((Activity) cVar);
        return a((Context) cVar, cVar.getSupportFragmentManager(), (Fragment) null);
    }

    public j a(Activity activity) {
        if (i.d()) {
            return a(activity.getApplicationContext());
        }
        b(activity);
        return a((Context) activity, activity.getFragmentManager(), (android.app.Fragment) null);
    }

    @TargetApi(17)
    private static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(17)
    public k a(FragmentManager fragmentManager, android.app.Fragment fragment) {
        k kVar = (k) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (kVar != null) {
            return kVar;
        }
        k kVar2 = this.f6137a.get(fragmentManager);
        if (kVar2 != null) {
            return kVar2;
        }
        k kVar3 = new k();
        kVar3.a(fragment);
        this.f6137a.put(fragmentManager, kVar3);
        fragmentManager.beginTransaction().add(kVar3, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.f6140d.obtainMessage(1, fragmentManager).sendToTarget();
        return kVar3;
    }

    private j a(Context context, FragmentManager fragmentManager, android.app.Fragment fragment) {
        k a2 = a(fragmentManager, fragment);
        j b2 = a2.b();
        if (b2 != null) {
            return b2;
        }
        j a3 = this.f6141e.a(c.a(context), a2.a(), a2.c(), context);
        a2.a(a3);
        return a3;
    }

    /* access modifiers changed from: package-private */
    public o a(h hVar, Fragment fragment) {
        o oVar = (o) hVar.a("com.bumptech.glide.manager");
        if (oVar != null) {
            return oVar;
        }
        o oVar2 = this.f6138b.get(hVar);
        if (oVar2 != null) {
            return oVar2;
        }
        o oVar3 = new o();
        oVar3.a(fragment);
        this.f6138b.put(hVar, oVar3);
        hVar.a().a((Fragment) oVar3, "com.bumptech.glide.manager").c();
        this.f6140d.obtainMessage(2, hVar).sendToTarget();
        return oVar3;
    }

    private j a(Context context, h hVar, Fragment fragment) {
        o a2 = a(hVar, fragment);
        j b2 = a2.b();
        if (b2 != null) {
            return b2;
        }
        j a3 = this.f6141e.a(c.a(context), a2.a(), a2.c(), context);
        a2.a(a3);
        return a3;
    }

    public boolean handleMessage(Message message) {
        Object obj;
        int i2 = message.what;
        Object obj2 = null;
        boolean z = true;
        if (i2 == 1) {
            obj2 = (FragmentManager) message.obj;
            obj = this.f6137a.remove(obj2);
        } else if (i2 != 2) {
            z = false;
            obj = null;
        } else {
            obj2 = (h) message.obj;
            obj = this.f6138b.remove(obj2);
        }
        if (z && obj == null && Log.isLoggable("RMRetriever", 5)) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
        }
        return z;
    }
}
