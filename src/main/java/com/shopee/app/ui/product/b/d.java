package com.shopee.app.ui.product.b;

import android.annotation.SuppressLint;
import com.garena.android.appkit.f.e;
import com.google.a.l;
import com.google.a.o;
import com.shopee.app.application.ar;
import com.shopee.app.network.http.a.g;
import com.shopee.app.network.http.data.ListingConfig;
import com.shopee.app.network.http.data.ListingUploadControlResponse;
import com.shopee.app.util.n;
import com.shopee.app.util.q.f;
import com.shopee.id.R;
import d.d.b.j;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public final class d extends c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final n f24384a;

    /* renamed from: b  reason: collision with root package name */
    private final g f24385b;

    public final d b() {
        return this;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(n nVar, g gVar, a aVar) {
        super(aVar);
        j.b(nVar, "dataEventBus");
        j.b(gVar, "listingUploadControlAPI");
        j.b(aVar, "messageSupplier");
        this.f24384a = nVar;
        this.f24385b = gVar;
        e.a().a(new Runnable(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d f24386a;

            {
                this.f24386a = r1;
            }

            public final void run() {
                final List<f> a2 = this.f24386a.a(this.f24386a.d());
                com.garena.android.appkit.f.f.a().a(new Runnable(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f24387a;

                    {
                        this.f24387a = r1;
                    }

                    public final void run() {
                        this.f24387a.f24386a.a((List<? extends f>) a2);
                        this.f24387a.f24386a.f24384a.a().bV.a();
                    }
                });
            }
        });
    }

    @SuppressLint({"CheckResult"})
    public final void c() {
        this.f24385b.a().b(io.b.h.a.b()).b(new a(this)).a(io.b.a.b.a.a()).a(new b(this), (io.b.d.f<? super Throwable>) c.f24391a);
    }

    static final class a<T, R> implements io.b.d.g<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f24389a;

        a(d dVar) {
            this.f24389a = dVar;
        }

        /* renamed from: a */
        public final List<f> apply(ListingUploadControlResponse listingUploadControlResponse) {
            j.b(listingUploadControlResponse, "response");
            return this.f24389a.a(listingUploadControlResponse.getData());
        }
    }

    static final class b<T> implements io.b.d.f<List<? extends f>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f24390a;

        b(d dVar) {
            this.f24390a = dVar;
        }

        /* renamed from: a */
        public final void accept(List<? extends f> list) {
            d dVar = this.f24390a;
            j.a((Object) list, "validatorList");
            dVar.a(list);
            this.f24390a.f24384a.a().bV.a();
        }
    }

    static final class c<T> implements io.b.d.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f24391a = new c();

        c() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            com.garena.android.appkit.d.a.a(th);
            com.garena.b.a.a.a("Failed to get Server Listing Configs", th);
        }
    }

    /* access modifiers changed from: private */
    public final ListingConfig d() {
        ar f2 = ar.f();
        j.a((Object) f2, "ShopeeApplication.get()");
        return ((ListingUploadControlResponse) com.shopee.web.sdk.bridge.internal.a.f30470a.a((l) ((o) com.shopee.web.sdk.bridge.internal.a.f30470a.a((Reader) new InputStreamReader(f2.getResources().openRawResource(R.raw.list_uploading_config)), o.class)).e("indonesia"), ListingUploadControlResponse.class)).getData();
    }
}
