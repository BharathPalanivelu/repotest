package com.shopee.app.ui.b;

import android.text.TextUtils;
import com.shopee.app.h.m;
import com.shopee.app.network.http.a.d;
import com.shopee.app.network.http.data.FacebookGraphResponse;
import d.d.b.j;
import f.h;
import io.b.d.f;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private io.b.b.b f19962a;

    /* renamed from: b  reason: collision with root package name */
    private final m f19963b;

    /* renamed from: c  reason: collision with root package name */
    private final d f19964c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final a f19965d;

    public interface a {
        void onCheckConnectionResult(int i, String str);
    }

    public c(m mVar, d dVar, a aVar) {
        j.b(mVar, "loginManager");
        j.b(dVar, "facebookGraphAPI");
        j.b(aVar, "mListener");
        this.f19963b = mVar;
        this.f19964c = dVar;
        this.f19965d = aVar;
    }

    public final void a() {
        String e2 = this.f19963b.e();
        com.shopee.app.f.a a2 = com.shopee.app.f.a.a();
        j.a((Object) a2, "GAFacebookManager.getInstance()");
        String d2 = a2.d();
        if (TextUtils.isEmpty(e2)) {
            this.f19965d.onCheckConnectionResult(0, d2);
        } else if (TextUtils.isEmpty(d2)) {
            this.f19965d.onCheckConnectionResult(1, d2);
        } else {
            String str = "https://graph.facebook.com/me?access_token=" + d2;
            io.b.b.b bVar = this.f19962a;
            if (bVar != null) {
                bVar.dispose();
            }
            this.f19962a = this.f19964c.a(str).b(io.b.h.a.b()).a(io.b.h.a.b()).a(new b(this, d2), (f<? super Throwable>) new C0302c(this, d2));
        }
    }

    static final class b<T> implements f<FacebookGraphResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f19966a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f19967b;

        b(c cVar, String str) {
            this.f19966a = cVar;
            this.f19967b = str;
        }

        /* renamed from: a */
        public final void accept(FacebookGraphResponse facebookGraphResponse) {
            if (facebookGraphResponse.getError() == null) {
                this.f19966a.f19965d.onCheckConnectionResult(2, this.f19967b);
            } else {
                this.f19966a.f19965d.onCheckConnectionResult(1, this.f19967b);
            }
        }
    }

    /* renamed from: com.shopee.app.ui.b.c$c  reason: collision with other inner class name */
    static final class C0302c<T> implements f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f19968a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f19969b;

        C0302c(c cVar, String str) {
            this.f19968a = cVar;
            this.f19969b = str;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            if (th instanceof h) {
                this.f19968a.f19965d.onCheckConnectionResult(1, this.f19969b);
            } else {
                this.f19968a.f19965d.onCheckConnectionResult(3, this.f19969b);
            }
        }
    }

    public final void b() {
        io.b.b.b bVar = this.f19962a;
        if (bVar != null) {
            bVar.dispose();
        }
    }
}
