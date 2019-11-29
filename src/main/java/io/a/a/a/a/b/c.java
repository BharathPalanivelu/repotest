package io.a.a.a.a.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.appsflyer.share.Constants;
import io.a.a.a.a.f.d;

class c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f33059a;

    /* renamed from: b  reason: collision with root package name */
    private final io.a.a.a.a.f.c f33060b;

    public c(Context context) {
        this.f33059a = context.getApplicationContext();
        this.f33060b = new d(context, "TwitterAdvertisingInfoPreferences");
    }

    public b a() {
        b b2 = b();
        if (c(b2)) {
            io.a.a.a.c.h().a("Fabric", "Using AdvertisingInfo from Preference Store");
            a(b2);
            return b2;
        }
        b e2 = e();
        b(e2);
        return e2;
    }

    private void a(final b bVar) {
        new Thread(new h() {
            public void a() {
                b a2 = c.this.e();
                if (!bVar.equals(a2)) {
                    io.a.a.a.c.h().a("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
                    c.this.b(a2);
                }
            }
        }).start();
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CommitPrefEdits"})
    public void b(b bVar) {
        if (c(bVar)) {
            io.a.a.a.a.f.c cVar = this.f33060b;
            cVar.a(cVar.b().putString(Constants.URL_ADVERTISING_ID, bVar.f33057a).putBoolean("limit_ad_tracking_enabled", bVar.f33058b));
            return;
        }
        io.a.a.a.a.f.c cVar2 = this.f33060b;
        cVar2.a(cVar2.b().remove(Constants.URL_ADVERTISING_ID).remove("limit_ad_tracking_enabled"));
    }

    /* access modifiers changed from: protected */
    public b b() {
        return new b(this.f33060b.a().getString(Constants.URL_ADVERTISING_ID, ""), this.f33060b.a().getBoolean("limit_ad_tracking_enabled", false));
    }

    public f c() {
        return new d(this.f33059a);
    }

    public f d() {
        return new e(this.f33059a);
    }

    private boolean c(b bVar) {
        return bVar != null && !TextUtils.isEmpty(bVar.f33057a);
    }

    /* access modifiers changed from: private */
    public b e() {
        b a2 = c().a();
        if (!c(a2)) {
            a2 = d().a();
            if (!c(a2)) {
                io.a.a.a.c.h().a("Fabric", "AdvertisingInfo not present");
            } else {
                io.a.a.a.c.h().a("Fabric", "Using AdvertisingInfo from Service Provider");
            }
        } else {
            io.a.a.a.c.h().a("Fabric", "Using AdvertisingInfo from Reflection Provider");
        }
        return a2;
    }
}
