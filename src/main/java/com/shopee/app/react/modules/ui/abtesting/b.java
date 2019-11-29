package com.shopee.app.react.modules.ui.abtesting;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.shopee.app.react.modules.ui.abtesting.a;
import d.d.b.j;
import d.d.b.p;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final b f18796a = new b();

    private b() {
    }

    /* renamed from: com.shopee.app.react.modules.ui.abtesting.b$b  reason: collision with other inner class name */
    public static final class C0286b<TResult> implements OnCompleteListener<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.C0285a f18798a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.remoteconfig.a f18799b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f18800c;

        public C0286b(a.C0285a aVar, com.google.firebase.remoteconfig.a aVar2, String str) {
            this.f18798a = aVar;
            this.f18799b = aVar2;
            this.f18800c = str;
        }

        public final void onComplete(Task<Boolean> task) {
            j.b(task, "it");
            if (!task.isSuccessful()) {
                this.f18798a.a(new Exception("Cannot get FirebaseRemoteConfig"));
                return;
            }
            d.f.b a2 = p.a(String.class);
            if (j.a((Object) a2, (Object) p.a(Boolean.TYPE))) {
                this.f18798a.a((Object) Boolean.valueOf(this.f18799b.b(this.f18800c)));
            } else if (j.a((Object) a2, (Object) p.a(Double.TYPE))) {
                this.f18798a.a((Object) Double.valueOf(this.f18799b.c(this.f18800c)));
            } else if (j.a((Object) a2, (Object) p.a(Long.TYPE))) {
                this.f18798a.a((Object) Long.valueOf(this.f18799b.d(this.f18800c)));
            } else if (j.a((Object) a2, (Object) p.a(String.class))) {
                a.C0285a aVar = this.f18798a;
                String a3 = this.f18799b.a(this.f18800c);
                j.a((Object) a3, "remoteConfig.getString(key)");
                aVar.a((Object) a3);
            }
        }
    }

    public static final class a implements OnFailureListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.C0285a f18797a;

        public a(a.C0285a aVar) {
            this.f18797a = aVar;
        }

        public final void onFailure(Exception exc) {
            j.b(exc, "it");
            this.f18797a.a(exc);
        }
    }

    public void a(String str, a.C0285a aVar) {
        j.b(str, "key");
        j.b(aVar, "callback");
        com.google.firebase.remoteconfig.a a2 = com.google.firebase.remoteconfig.a.a();
        j.a((Object) a2, "remoteConfig");
        a2.b().addOnCompleteListener(new C0286b(aVar, a2, str)).addOnFailureListener(new a(aVar));
    }
}
