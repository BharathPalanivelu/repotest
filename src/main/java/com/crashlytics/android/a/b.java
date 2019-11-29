package com.crashlytics.android.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import io.a.a.a.a.b.j;
import io.a.a.a.a.b.o;
import io.a.a.a.a.g.q;
import io.a.a.a.a.g.t;
import io.a.a.a.c;
import io.a.a.a.i;
import io.a.a.a.l;
import java.io.File;

public class b extends i<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    boolean f6308a = false;

    /* renamed from: b  reason: collision with root package name */
    ab f6309b;

    public String a() {
        return "1.4.1.19";
    }

    public String b() {
        return "com.crashlytics.sdk.android:answers";
    }

    public static b c() {
        return (b) c.a(b.class);
    }

    public void a(m mVar) {
        if (mVar == null) {
            throw new NullPointerException("event must not be null");
        } else if (this.f6308a) {
            a("logCustom");
        } else {
            ab abVar = this.f6309b;
            if (abVar != null) {
                abVar.a(mVar);
            }
        }
    }

    public void a(j.b bVar) {
        ab abVar = this.f6309b;
        if (abVar != null) {
            abVar.a(bVar.a());
        }
    }

    public void a(j.a aVar) {
        ab abVar = this.f6309b;
        if (abVar != null) {
            abVar.a(aVar.a(), aVar.b());
        }
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"NewApi"})
    public boolean h_() {
        long lastModified;
        try {
            Context r = r();
            PackageManager packageManager = r.getPackageManager();
            String packageName = r.getPackageName();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            String num = Integer.toString(packageInfo.versionCode);
            String str = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
            if (Build.VERSION.SDK_INT >= 9) {
                lastModified = packageInfo.firstInstallTime;
            } else {
                lastModified = new File(packageManager.getApplicationInfo(packageName, 0).sourceDir).lastModified();
            }
            this.f6309b = ab.a(this, r, q(), num, str, lastModified);
            this.f6309b.b();
            this.f6308a = new o().b(r);
            return true;
        } catch (Exception e2) {
            c.h().e("Answers", "Error retrieving app properties", e2);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public Boolean f() {
        try {
            t b2 = q.a().b();
            if (b2 == null) {
                c.h().e("Answers", "Failed to retrieve settings");
                return false;
            } else if (b2.f33265d.f33238d) {
                c.h().a("Answers", "Analytics collection enabled");
                this.f6309b.a(b2.f33266e, g());
                return true;
            } else {
                c.h().a("Answers", "Analytics collection disabled");
                this.f6309b.c();
                return false;
            }
        } catch (Exception e2) {
            c.h().e("Answers", "Error dealing with settings", e2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public String g() {
        return io.a.a.a.a.b.i.b(r(), "com.crashlytics.ApiEndpoint");
    }

    private void a(String str) {
        l h = c.h();
        h.d("Answers", "Method " + str + " is not supported when using Crashlytics through Firebase.");
    }
}
