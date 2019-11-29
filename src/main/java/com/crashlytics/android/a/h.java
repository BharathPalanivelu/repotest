package com.crashlytics.android.a;

import android.app.Activity;
import android.os.Bundle;
import com.crashlytics.android.a.ad;
import io.a.a.a.a;

class h extends a.b {

    /* renamed from: a  reason: collision with root package name */
    private final ab f6336a;

    /* renamed from: b  reason: collision with root package name */
    private final l f6337b;

    public void a(Activity activity, Bundle bundle) {
    }

    public void b(Activity activity, Bundle bundle) {
    }

    public void e(Activity activity) {
    }

    public h(ab abVar, l lVar) {
        this.f6336a = abVar;
        this.f6337b = lVar;
    }

    public void a(Activity activity) {
        this.f6336a.a(activity, ad.b.START);
    }

    public void b(Activity activity) {
        this.f6336a.a(activity, ad.b.RESUME);
        this.f6337b.a();
    }

    public void c(Activity activity) {
        this.f6336a.a(activity, ad.b.PAUSE);
        this.f6337b.b();
    }

    public void d(Activity activity) {
        this.f6336a.a(activity, ad.b.STOP);
    }
}
