package com.shopee.app.ui.sharing.base;

import android.app.Activity;
import com.google.a.p;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.sharing.base.data.ShareImage;
import com.shopee.app.ui.sharing.base.data.ShareVideo;
import com.shopee.app.ui.sharing.base.helper.b;
import com.shopee.app.ui.sharing.base.helper.d;
import com.shopee.app.ui.sharing.base.helper.e;
import com.shopee.app.web.WebRegister;
import d.d.b.j;
import java.lang.ref.WeakReference;

public abstract class a<T> implements com.shopee.app.ui.sharing.base.helper.a, d {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<Activity> f25344a;

    /* renamed from: b  reason: collision with root package name */
    private r f25345b;

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<b> f25346c;

    /* renamed from: d  reason: collision with root package name */
    private T f25347d;

    /* renamed from: e  reason: collision with root package name */
    private b f25348e;

    /* renamed from: f  reason: collision with root package name */
    private e f25349f;

    /* renamed from: g  reason: collision with root package name */
    private final Class<T> f25350g;

    public abstract boolean a(Activity activity);

    public void b(String str) {
        j.b(str, "filePath");
    }

    public abstract boolean b(T t);

    /* access modifiers changed from: protected */
    public abstract void c(T t);

    public a(Class<T> cls, Activity activity, b bVar) {
        j.b(cls, "dataClass");
        j.b(activity, "activity");
        j.b(bVar, "shareListener");
        this.f25350g = cls;
        this.f25344a = new WeakReference<>(activity);
        this.f25346c = new WeakReference<>(bVar);
    }

    /* access modifiers changed from: protected */
    public final T a() {
        return this.f25347d;
    }

    public final void a(String str) {
        j.b(str, "jsonString");
        try {
            a(WebRegister.GSON.a(str, this.f25350g));
        } catch (p unused) {
            a(new com.shopee.app.ui.sharing.base.data.a(1, (String) null, 2, (g) null));
        }
    }

    public final void a(T t) {
        Activity b2 = b();
        if (b2 != null) {
            try {
                this.f25347d = t;
                if (!a(b2)) {
                    a(new com.shopee.app.ui.sharing.base.data.a(2, (String) null, 2, (g) null));
                } else if (!b(t)) {
                    a(new com.shopee.app.ui.sharing.base.data.a(1, (String) null, 2, (g) null));
                } else {
                    c(t);
                }
            } catch (Exception unused) {
                a(new com.shopee.app.ui.sharing.base.data.a(-1, (String) null, 2, (g) null));
            }
        }
    }

    public final void a(com.shopee.app.ui.sharing.base.data.a aVar) {
        j.b(aVar, "shareResult");
        b bVar = (b) this.f25346c.get();
        if (bVar != null) {
            bVar.onResult(aVar);
        }
    }

    public final Activity b() {
        return (Activity) this.f25344a.get();
    }

    public void c() {
        b bVar = this.f25348e;
        if (bVar != null) {
            bVar.cancel(true);
        }
        e eVar = this.f25349f;
        if (eVar != null) {
            eVar.a(true);
        }
    }

    public final void a(ShareImage shareImage) {
        j.b(shareImage, "image");
        Activity b2 = b();
        if (b2 != null) {
            b bVar = this.f25348e;
            if (bVar != null) {
                bVar.cancel(true);
            }
            b bVar2 = new b(b2, this);
            bVar2.execute(new ShareImage[]{shareImage});
            this.f25348e = bVar2;
        }
    }

    public final void a(ShareVideo shareVideo) {
        j.b(shareVideo, "video");
        Activity b2 = b();
        if (b2 != null) {
            r rVar = new r(b2);
            rVar.a();
            this.f25345b = rVar;
            e eVar = this.f25349f;
            if (eVar != null) {
                eVar.a(true);
            }
            e eVar2 = new e(this);
            eVar2.a(shareVideo);
            this.f25349f = eVar2;
        }
    }

    public void d() {
        b bVar = (b) this.f25346c.get();
        if (bVar != null) {
            bVar.onPreProcessingData();
        }
    }

    public void e() {
        a(new com.shopee.app.ui.sharing.base.data.a(1, (String) null, 2, (g) null));
    }

    public void f() {
        b bVar = (b) this.f25346c.get();
        if (bVar != null) {
            bVar.onPreProcessingData();
        }
    }

    public void c(String str) {
        j.b(str, "filePath");
        r rVar = this.f25345b;
        if (rVar != null) {
            rVar.b();
        }
    }

    public void g() {
        r rVar = this.f25345b;
        if (rVar != null) {
            rVar.b();
        }
        a(new com.shopee.app.ui.sharing.base.data.a(1, (String) null, 2, (g) null));
    }
}
