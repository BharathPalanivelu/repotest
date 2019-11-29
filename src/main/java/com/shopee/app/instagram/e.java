package com.shopee.app.instagram;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.garena.android.appkit.tools.b;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.shopee.app.data.store.bc;
import com.shopee.app.react.modules.ui.abtesting.AbTestingModule;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.d.a;
import org.d.b.a.d;
import org.d.b.a.j;
import org.d.b.b.b.c;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f17753a = b.e(R.string.ins_app_id);

    /* renamed from: b  reason: collision with root package name */
    private j f17754b;

    /* renamed from: c  reason: collision with root package name */
    private String f17755c;

    /* renamed from: d  reason: collision with root package name */
    private a f17756d;

    /* renamed from: e  reason: collision with root package name */
    private String f17757e;

    /* renamed from: f  reason: collision with root package name */
    private List<h> f17758f;

    /* renamed from: g  reason: collision with root package name */
    private long f17759g;
    private long h;
    private int i;

    public e() {
        this.f17754b = null;
        this.f17755c = null;
        this.f17756d = null;
        this.f17758f = new ArrayList();
        this.f17759g = -1;
        this.h = -1;
        this.i = 20;
        this.f17755c = (String) bc.a().e().b(null);
    }

    public boolean a() {
        if (this.f17755c != null) {
            k();
            return true;
        }
        this.f17755c = (String) bc.a().e().b(null);
        if (this.f17755c != null) {
            return true;
        }
        return false;
    }

    public void a(Context context) {
        InstagramAuthPage_.a(context).a("https://instagram.com/oauth/authorize/?client_id=" + f17753a + "&redirect_uri=" + "shopee://callback" + "&response_type=token").a(23);
    }

    public void a(Intent intent) {
        String stringExtra = intent.getStringExtra(AbTestingModule.KEY_RESULT);
        this.f17755c = stringExtra.substring(stringExtra.indexOf("shopee://callback#access_token=") + 31);
        k();
        f();
    }

    private void k() {
        this.f17756d = new a(new org.d.a.b.b(this.f17755c, (String) null));
        e();
    }

    public void b() {
        this.f17758f = new ArrayList();
        this.f17759g = -1;
        this.h = -1;
    }

    public List<h> c() {
        if (this.h == -1) {
            return i();
        }
        try {
            if (this.f17757e == null) {
                this.f17757e = this.f17756d.a().a().b();
            }
            org.d.b.b.b.b a2 = this.f17756d.a(this.f17757e, this.i, (String) null, (String) null, new Date(this.h), (Date) null);
            List<h> a3 = a(a2);
            this.f17754b = a2.a();
            this.f17758f.addAll(a3);
            return a3;
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    public List<h> d() {
        if (this.f17759g == -1) {
            return i();
        }
        try {
            if (this.f17757e == null) {
                this.f17757e = this.f17756d.a().a().b();
            }
            org.d.b.b.b.b a2 = this.f17756d.a(this.f17757e, this.i, (String) null, (String) null, (Date) null, new Date(this.f17759g + 1));
            List<h> a3 = a(a2);
            this.f17754b = a2.a();
            while (true) {
                List<h> g2 = g();
                if (g2 == null) {
                    a3.addAll(this.f17758f);
                    this.f17758f = a3;
                    return this.f17758f;
                }
                a3.addAll(g2);
            }
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        try {
            this.f17757e = this.f17756d.a().a().b();
        } catch (org.d.c.b e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (!TextUtils.isEmpty(this.f17755c)) {
            bc.a().e().a(this.f17755c).v();
        }
    }

    public List<h> g() {
        j jVar = this.f17754b;
        if (!(jVar == null || jVar.a() == null)) {
            try {
                org.d.b.b.b.b a2 = this.f17756d.a(this.f17754b);
                List<h> a3 = a(a2);
                this.f17758f.addAll(a3);
                this.f17754b = a2.a();
                return a3;
            } catch (Exception e2) {
                com.garena.android.appkit.d.a.a(e2);
            }
        }
        return null;
    }

    public String h() {
        try {
            return this.f17756d.a().a().a();
        } catch (org.d.c.b e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    public List<h> i() {
        try {
            b();
            if (this.f17757e == null) {
                this.f17757e = this.f17756d.a().a().b();
            }
            org.d.b.b.b.b a2 = this.f17756d.a(this.f17757e, this.i, (String) null, (String) null, (Date) null, (Date) null);
            List<h> a3 = a(a2);
            this.f17758f.addAll(a3);
            this.f17754b = a2.a();
            return a3;
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    private List<h> a(org.d.b.b.b.b bVar) {
        ArrayList arrayList = new ArrayList();
        for (c next : bVar.b()) {
            h hVar = new h();
            d a2 = next.d().a();
            hVar.a(a2.a());
            hVar.a(a2.b());
            hVar.b(a2.c());
            if (next.a() != null) {
                hVar.c(next.a().a());
            }
            hVar.b(next.e());
            arrayList.add(hVar);
            long parseLong = Long.parseLong(next.c()) * 1000;
            long j = this.h;
            if (j == -1 || parseLong < j) {
                this.h = parseLong - 1000;
            }
            long j2 = this.f17759g;
            if (j2 == -1 || parseLong > j2) {
                this.f17759g = parseLong + 1000;
            }
        }
        return arrayList;
    }

    public void j() {
        this.f17755c = null;
        b();
        bc.a().e().a(null).v();
        String cookie = CookieManager.getInstance().getCookie("https://www.instagram.com");
        if (!TextUtils.isEmpty(cookie)) {
            String[] split = cookie.split(";");
            for (String split2 : split) {
                String[] split3 = split2.split(SimpleComparison.EQUAL_TO_OPERATION);
                CookieManager.getInstance().setCookie("https://www.instagram.com", split3[0].trim() + "=;");
            }
            CookieSyncManager.getInstance().sync();
        }
    }
}
