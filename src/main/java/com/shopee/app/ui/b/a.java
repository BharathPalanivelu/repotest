package com.shopee.app.ui.b;

import android.app.Activity;
import android.content.Intent;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.network.d.d;
import com.shopee.app.util.n;
import com.shopee.shopeetracker.EventRepository;
import com.tencent.qcloud.core.http.HttpMetric;
import d.d.b.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private CallbackManager f19947a;

    /* renamed from: b  reason: collision with root package name */
    private final i f19948b;

    /* renamed from: c  reason: collision with root package name */
    private final c f19949c = new c(this);

    /* renamed from: d  reason: collision with root package name */
    private final b f19950d = new b(this);

    /* renamed from: e  reason: collision with root package name */
    private final com.shopee.app.application.a.b f19951e;

    /* renamed from: f  reason: collision with root package name */
    private final n f19952f;

    /* renamed from: g  reason: collision with root package name */
    private final C0300a f19953g;

    public a(com.shopee.app.application.a.b bVar, n nVar, C0300a aVar) {
        j.b(bVar, "mLifeCycleManager");
        j.b(nVar, "mDataEventBus");
        j.b(aVar, "mListener");
        this.f19951e = bVar;
        this.f19952f = nVar;
        this.f19953g = aVar;
        CallbackManager create = CallbackManager.Factory.create();
        j.a((Object) create, "CallbackManager.Factory.create()");
        this.f19947a = create;
        i a2 = com.garena.a.a.a.b.a(this);
        j.a((Object) a2, "EventHandler.get(this)");
        this.f19948b = a2;
        this.f19948b.a();
        LoginManager.getInstance().registerCallback(this.f19947a, new FacebookCallback<LoginResult>(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f19954a;

            {
                this.f19954a = r1;
            }

            /* renamed from: a */
            public void onSuccess(LoginResult loginResult) {
                j.b(loginResult, "loginResult");
                this.f19954a.b().showProgress();
                com.shopee.app.f.a a2 = com.shopee.app.f.a.a();
                j.a((Object) a2, "GAFacebookManager.getInstance()");
                new d().b(a2.d());
            }

            public void onCancel() {
                com.garena.android.appkit.d.a.e("user cancel", new Object[0]);
            }

            public void onError(FacebookException facebookException) {
                j.b(facebookException, HttpMetric.ATTR_EXCEPTION);
                C0300a.C0301a.a(this.f19954a.b(), 0, 1, (Object) null);
            }
        });
    }

    public final C0300a b() {
        return this.f19953g;
    }

    public static final class c extends g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f19956a;

        c(a aVar) {
            this.f19956a = aVar;
        }

        public void onEvent(com.garena.android.appkit.b.a aVar) {
            this.f19956a.b().hideProgress();
            C0300a b2 = this.f19956a.b();
            com.shopee.app.f.a a2 = com.shopee.app.f.a.a();
            j.a((Object) a2, "GAFacebookManager.getInstance()");
            b2.onSuccess(a2.d());
        }
    }

    public static final class b extends g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f19955a;

        b(a aVar) {
            this.f19955a = aVar;
        }

        public void onEvent(com.garena.android.appkit.b.a aVar) {
            this.f19955a.b().hideProgress();
            C0300a.C0301a.a(this.f19955a.b(), 0, 1, (Object) null);
        }
    }

    public final void a() {
        this.f19948b.b();
    }

    public final void a(Activity activity) {
        j.b(activity, "activity");
        this.f19951e.b();
        com.shopee.app.f.a.a().a(activity);
    }

    public final void a(int i, int i2, Intent intent) {
        if (i == CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode()) {
            this.f19947a.onActivityResult(i, i2, intent);
        }
    }

    public final void a(com.shopee.app.ui.auth.a.a aVar) {
        j.b(aVar, EventRepository.TABLE);
        this.f19953g.hideProgress();
        C0300a aVar2 = this.f19953g;
        com.shopee.app.f.a a2 = com.shopee.app.f.a.a();
        j.a((Object) a2, "GAFacebookManager.getInstance()");
        aVar2.onSuccess(a2.d());
    }

    public final void a(com.shopee.app.network.c.d.a aVar) {
        j.b(aVar, "data");
        this.f19953g.hideProgress();
        this.f19953g.onError(aVar.f17892a);
    }

    /* renamed from: com.shopee.app.ui.b.a$a  reason: collision with other inner class name */
    public interface C0300a {
        void hideProgress();

        void onError(int i);

        void onSuccess(String str);

        void showProgress();

        /* renamed from: com.shopee.app.ui.b.a$a$a  reason: collision with other inner class name */
        public static final class C0301a {
            public static /* synthetic */ void a(C0300a aVar, int i, int i2, Object obj) {
                if (obj == null) {
                    if ((i2 & 1) != 0) {
                        i = -1;
                    }
                    aVar.onError(i);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onError");
            }
        }
    }
}
