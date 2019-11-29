package com.shopee.app.ui.auth.signup.b;

import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.d.c.dc;
import com.shopee.app.h.f;
import com.shopee.app.network.d.f.g;
import com.shopee.app.ui.auth.signup.thirdparty.c;
import com.shopee.app.ui.auth.signup.thirdparty.d;
import com.shopee.app.util.n;
import com.shopee.id.R;
import com.shopee.protocol.action.ResponseCommon;
import d.d.b.j;
import d.h.k;
import d.h.m;
import java.io.Serializable;

public final class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private final i f19807a;

    /* renamed from: c  reason: collision with root package name */
    private com.shopee.app.line.a f19808c;

    /* renamed from: d  reason: collision with root package name */
    private final n f19809d;

    /* renamed from: e  reason: collision with root package name */
    private final dc f19810e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(n nVar, dc dcVar) {
        super(nVar, dcVar);
        j.b(nVar, "dataEventBus");
        j.b(dcVar, "processImageInteractor");
        this.f19809d = nVar;
        this.f19810e = dcVar;
        i a2 = b.a(this);
        j.a((Object) a2, "EventHandler.get(this)");
        this.f19807a = a2;
    }

    public void a() {
        super.a();
        this.f19807a.a();
    }

    public void b() {
        super.b();
        this.f19807a.b();
    }

    public void a(Serializable serializable) {
        if (!(serializable instanceof com.shopee.app.line.a)) {
            serializable = null;
        }
        this.f19808c = (com.shopee.app.line.a) serializable;
    }

    public void a(String str) {
        com.shopee.app.line.a aVar = this.f19808c;
        if (aVar != null) {
            com.shopee.app.h.b.a.a().a(aVar.c(), aVar.b(), new C0299a(aVar, this));
        }
    }

    /* renamed from: com.shopee.app.ui.auth.signup.b.a$a  reason: collision with other inner class name */
    static final class C0299a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.line.a f19811a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f19812b;

        C0299a(com.shopee.app.line.a aVar, a aVar2) {
            this.f19811a = aVar;
            this.f19812b = aVar2;
        }

        public final void run() {
            this.f19812b.b("file:///" + f.a().b(this.f19811a.b()));
        }
    }

    public void e() {
        com.shopee.app.line.a aVar = this.f19808c;
        if (aVar != null) {
            d dVar = (d) this.f19220b;
            if (dVar != null) {
                dVar.a(new k("\\s").a((CharSequence) aVar.d(), ""), (String) null, 0, 0);
            }
        }
    }

    public void a(String str, String str2, String str3, String str4) {
        g gVar = new g();
        com.shopee.app.line.a aVar = this.f19808c;
        gVar.a(aVar != null ? aVar.a() : null);
        gVar.b(str);
        gVar.d(str3);
        gVar.c(str2);
        gVar.g();
    }

    public final void a(com.shopee.app.network.c.d.a aVar) {
        String str;
        j.b(aVar, "response");
        int i = aVar.f17892a;
        if (i == 5) {
            ((d) this.f19220b).b(com.garena.android.appkit.tools.b.e(R.string.sp_try_another_email));
        } else if (i == 11) {
            ((d) this.f19220b).b(com.garena.android.appkit.tools.b.e(R.string.sp_duplicate_user_name));
        } else if (i != 12) {
            CharSequence charSequence = aVar.f17893b;
            if (!(charSequence == null || m.a(charSequence))) {
                str = aVar.f17893b;
            } else {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
            }
            ((d) this.f19220b).b(str);
        } else {
            ((d) this.f19220b).b(com.garena.android.appkit.tools.b.e(R.string.sp_line_login_error_country_restricted));
        }
    }

    public final void a(ResponseCommon responseCommon) {
        j.b(responseCommon, "response");
        Integer num = responseCommon.userid;
        j.a((Object) num, "response.userid");
        ((d) this.f19220b).a(num.intValue(), "line");
    }
}
