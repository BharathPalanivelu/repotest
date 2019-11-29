package com.airpay.paysdk.base.ui.weidget;

import android.app.Activity;
import android.content.DialogInterface;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private e f3935a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f3936b;

    /* renamed from: c  reason: collision with root package name */
    private Runnable f3937c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3938d;

    public interface a {
        void a();
    }

    public f(Activity activity) {
        this.f3936b = activity;
    }

    public void a(String str, boolean z, a aVar) {
        b(str, z, aVar);
    }

    public void a() {
        b();
    }

    private void b(String str, boolean z, a aVar) {
        Activity activity = this.f3936b;
        if (activity != null && !activity.isFinishing()) {
            e eVar = new e(this.f3936b);
            eVar.a(z);
            if (aVar != null) {
                eVar.setOnCancelListener(new b(aVar));
            } else {
                eVar.setOnCancelListener(new b());
            }
            this.f3935a = eVar;
            this.f3935a.a(str);
            this.f3935a.c();
            this.f3938d = true;
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        this.f3938d = false;
        if (this.f3937c != null) {
            com.airpay.paysdk.common.c.a.a().b(this.f3937c);
            this.f3937c = null;
        }
        e eVar = this.f3935a;
        if (eVar != null) {
            eVar.b();
            this.f3935a = null;
        }
    }

    private class b implements DialogInterface.OnCancelListener {

        /* renamed from: b  reason: collision with root package name */
        private a f3940b;

        public b(a aVar) {
            this.f3940b = aVar;
        }

        public b() {
        }

        public void onCancel(DialogInterface dialogInterface) {
            f.this.b();
            a aVar = this.f3940b;
            if (aVar != null) {
                aVar.a();
            }
        }
    }
}
