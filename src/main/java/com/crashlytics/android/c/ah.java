package com.crashlytics.android.c;

import android.annotation.SuppressLint;
import io.a.a.a.a.f.c;
import io.a.a.a.a.f.d;

@SuppressLint({"CommitPrefEdits"})
class ah {

    /* renamed from: a  reason: collision with root package name */
    private final c f6411a;

    public static ah a(c cVar, k kVar) {
        if (!cVar.a().getBoolean("preferences_migration_complete", false)) {
            d dVar = new d(kVar);
            if (!cVar.a().contains("always_send_reports_opt_in") && dVar.a().contains("always_send_reports_opt_in")) {
                cVar.a(cVar.b().putBoolean("always_send_reports_opt_in", dVar.a().getBoolean("always_send_reports_opt_in", false)));
            }
            cVar.a(cVar.b().putBoolean("preferences_migration_complete", true));
        }
        return new ah(cVar);
    }

    public ah(c cVar) {
        this.f6411a = cVar;
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        c cVar = this.f6411a;
        cVar.a(cVar.b().putBoolean("always_send_reports_opt_in", z));
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.f6411a.a().getBoolean("always_send_reports_opt_in", false);
    }
}
