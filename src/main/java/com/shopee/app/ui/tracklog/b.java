package com.shopee.app.ui.tracklog;

import android.content.SharedPreferences;
import com.shopee.app.data.store.ay;
import com.shopee.app.tracking.trackingv3.model.UserActionV3;
import com.shopee.app.ui.tracklog.g;
import com.shopee.app.util.af;
import com.shopee.app.web.WebRegister;
import com.shopee.shopeetracker.model.UserAction;
import com.shopee.shopeetracker.utils.TrackLogger;
import d.d.b.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class b extends ay implements TrackLogger {

    /* renamed from: a  reason: collision with root package name */
    public static final a f25645a = new a((g) null);

    /* renamed from: d  reason: collision with root package name */
    private static final int f25646d = 40;

    /* renamed from: b  reason: collision with root package name */
    private final com.shopee.app.util.j.b<g> f25647b;

    /* renamed from: c  reason: collision with root package name */
    private C0393b f25648c;

    /* renamed from: com.shopee.app.ui.tracklog.b$b  reason: collision with other inner class name */
    public interface C0393b {
        void a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
        j.b(sharedPreferences, "pref");
        this.f25647b = new com.shopee.app.util.j.b<>(sharedPreferences, "shopee_track_badge_status", new com.google.a.c.a<List<? extends g>>() {
        });
    }

    public synchronized void onStartSendEvents(String str, List<? extends UserAction> list) {
        j.b(str, "tag");
        j.b(list, "userActions");
        com.garena.android.appkit.d.a.b("on start sending tracking events", list);
    }

    public synchronized void onSuccessSendEvents(String str, List<? extends UserAction> list) {
        j.b(str, "tag");
        j.b(list, "userActions");
        int i = 0;
        com.garena.android.appkit.d.a.b("on success sending tracking events", list);
        if (!af.a(list)) {
            i = c.a((UserAction) list.get(0));
        }
        this.f25647b.b(new g.a().a(g.f25655b).a(System.currentTimeMillis()).a(WebRegister.GSON.b((Object) list)).b(i).b(str).a());
        b();
        if (this.f25648c != null) {
            C0393b bVar = this.f25648c;
            if (bVar == null) {
                j.a();
            }
            bVar.a();
        }
    }

    public synchronized void onErrorSendEvents(String str, Exception exc, List<? extends UserAction> list) {
        j.b(str, "tag");
        j.b(exc, "e");
        int i = 0;
        com.garena.android.appkit.d.a.b("on error sending tracking events", list);
        g.a a2 = new g.a().a(g.f25656c).a(System.currentTimeMillis()).a(WebRegister.GSON.b((Object) list));
        if (list != null && !list.isEmpty()) {
            i = ((UserAction) list.get(0)).getType();
        }
        this.f25647b.b(a2.b(i).a(exc).b(str).a());
        b();
        if (this.f25648c != null) {
            C0393b bVar = this.f25648c;
            if (bVar == null) {
                j.a();
            }
            bVar.a();
        }
    }

    public final synchronized List<g> a(boolean z) {
        g a2 = this.f25647b.a();
        j.a((Object) a2, "mLogList.get()");
        List<g> list = (List) a2;
        if (!z) {
            return list;
        }
        Iterable<g> iterable = list;
        Collection arrayList = new ArrayList(d.a.j.a(iterable, 10));
        for (g a3 : iterable) {
            arrayList.add(c.a(a3));
        }
        Collection arrayList2 = new ArrayList();
        for (Object next : (List) arrayList) {
            UserActionV3[] userActionV3Arr = (UserActionV3[]) WebRegister.GSON.a(((g) next).f25659f, UserActionV3[].class);
            boolean z2 = false;
            if (userActionV3Arr != null) {
                if (!(userActionV3Arr.length == 0)) {
                    z2 = true;
                }
            }
            if (z2) {
                arrayList2.add(next);
            }
        }
        return (List) arrayList2;
    }

    public final synchronized void a() {
        this.f25647b.c();
    }

    public final void a(C0393b bVar) {
        this.f25648c = bVar;
    }

    private final synchronized void b() {
        List list = (List) this.f25647b.a();
        if (list != null && list.size() > f25646d) {
            this.f25647b.a(list.subList(list.size() - f25646d, list.size()));
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
}
