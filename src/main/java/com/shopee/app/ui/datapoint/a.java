package com.shopee.app.ui.datapoint;

import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.datapoint.c;
import com.shopee.app.ui.datapoint.data.CollectDataEvent;
import com.shopee.app.ui.datapoint.data.ContactData;
import d.d.b.j;

public final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public static final C0317a f21470a = new C0317a((g) null);

    /* renamed from: c  reason: collision with root package name */
    private final i f21471c;

    /* renamed from: d  reason: collision with root package name */
    private final c.b f21472d;

    public String a() {
        return "contact";
    }

    /* renamed from: com.shopee.app.ui.datapoint.a$a  reason: collision with other inner class name */
    public static final class C0317a {
        private C0317a() {
        }

        public /* synthetic */ C0317a(g gVar) {
            this();
        }
    }

    public a(c.b bVar) {
        j.b(bVar, "resultListener");
        this.f21472d = bVar;
        i a2 = b.a(this);
        a2.a();
        this.f21471c = a2;
    }

    public void b() {
        ar f2 = ar.f();
        j.a((Object) f2, "ShopeeApplication.get()");
        UserComponent e2 = f2.e();
        j.a((Object) e2, "ShopeeApplication.get().component");
        e2.getContactInteractor().a();
    }

    public void c() {
        this.f21471c.b();
    }

    public final void a(int i) {
        this.f21472d.onDone(new CollectDataEvent(a(), 0, "", new ContactData(Integer.valueOf(i), false)));
    }

    public final void a(com.shopee.app.network.c.d.b<Integer> bVar) {
        j.b(bVar, "response");
        this.f21472d.onDone(new CollectDataEvent(a(), bVar.a(), bVar.b(), new ContactData(bVar.c(), false)));
    }

    public final void b(int i) {
        this.f21472d.onDone(new CollectDataEvent(a(), 0, "", new ContactData(Integer.valueOf(i), true)));
    }

    public final void b(com.shopee.app.network.c.d.b<Integer> bVar) {
        j.b(bVar, "response");
        this.f21472d.onDone(new CollectDataEvent(a(), bVar.a(), bVar.b(), new ContactData(bVar.c(), false)));
    }
}
