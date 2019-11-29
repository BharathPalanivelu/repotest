package com.shopee.app.tracking.d;

import android.app.Activity;
import com.facebook.react.bridge.UiThreadUtil;
import com.google.firebase.analytics.FirebaseAnalytics;
import d.d.b.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private String f19162a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Activity f19163b;

    public a(Activity activity) {
        j.b(activity, "activity");
        this.f19163b = activity;
    }

    public final void a(String str) {
        this.f19162a = str;
        b(str);
    }

    public final void a() {
        b(this.f19162a);
    }

    /* renamed from: com.shopee.app.tracking.d.a$a  reason: collision with other inner class name */
    static final class C0293a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f19164a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f19165b;

        C0293a(a aVar, String str) {
            this.f19164a = aVar;
            this.f19165b = str;
        }

        public final void run() {
            String str = this.f19165b;
            if (str != null) {
                FirebaseAnalytics.getInstance(this.f19164a.f19163b).setCurrentScreen(this.f19164a.f19163b, str, (String) null);
            }
        }
    }

    private final void b(String str) {
        UiThreadUtil.runOnUiThread(new C0293a(this, str));
    }
}
