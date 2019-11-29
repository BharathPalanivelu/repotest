package com.shopee.app.application.a;

import android.app.Activity;
import com.shopee.app.application.a.a.c;
import com.shopee.app.application.a.a.d;
import com.shopee.app.application.a.a.e;
import com.shopee.app.application.a.a.f;
import com.shopee.app.application.a.a.g;
import com.shopee.app.application.a.a.h;
import com.shopee.app.application.ar;
import java.util.ArrayList;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final ar f15837a;

    /* renamed from: b  reason: collision with root package name */
    private final a f15838b;

    /* renamed from: c  reason: collision with root package name */
    private final List<a> f15839c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f15840d = true;

    /* renamed from: e  reason: collision with root package name */
    private g f15841e;

    public interface a {
        void a(Activity activity);

        void a(ar arVar, Activity activity);

        void b(Activity activity);

        void b(ar arVar, Activity activity);

        void c(Activity activity);

        void d(Activity activity);

        void e(Activity activity);

        void f(Activity activity);
    }

    public b(ar arVar) {
        this.f15837a = arVar;
        this.f15838b = new a(this);
        this.f15839c = new ArrayList();
        c();
    }

    private void c() {
        this.f15841e = new g();
        this.f15839c.add(this.f15841e);
        this.f15839c.add(new d());
        this.f15839c.add(new com.shopee.app.application.a.a.a());
        this.f15839c.add(new c());
        this.f15839c.add(new h());
        this.f15839c.add(new com.shopee.app.application.a.a.b());
        this.f15839c.add(new f());
        if (this.f15837a.e().settingConfigStore().enableStackManager()) {
            this.f15839c.add(new e());
        }
    }

    public void a(Activity activity) {
        for (a a2 : this.f15839c) {
            a2.a(activity);
        }
    }

    public void b(Activity activity) {
        this.f15838b.a(activity);
        for (a b2 : this.f15839c) {
            b2.b(activity);
        }
    }

    public void c(Activity activity) {
        for (a c2 : this.f15839c) {
            c2.c(activity);
        }
    }

    public void d(Activity activity) {
        for (a d2 : this.f15839c) {
            d2.d(activity);
        }
    }

    public void e(Activity activity) {
        this.f15838b.b(activity);
        for (a e2 : this.f15839c) {
            e2.e(activity);
        }
    }

    public void f(Activity activity) {
        for (a f2 : this.f15839c) {
            f2.f(activity);
        }
    }

    /* access modifiers changed from: package-private */
    public void g(Activity activity) {
        this.f15840d = false;
        for (a a2 : this.f15839c) {
            a2.a(this.f15837a, activity);
        }
    }

    /* access modifiers changed from: package-private */
    public void h(Activity activity) {
        this.f15840d = true;
        for (a b2 : this.f15839c) {
            b2.b(this.f15837a, activity);
        }
    }

    public boolean a() {
        return this.f15840d;
    }

    public void b() {
        this.f15841e.a();
    }
}
