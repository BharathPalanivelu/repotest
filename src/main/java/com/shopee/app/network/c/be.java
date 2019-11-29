package com.shopee.app.network.c;

import com.garena.android.appkit.b.b;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.c;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.h.o;
import com.shopee.app.network.d.ba;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class be extends c {
    public int a() {
        return 96;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        if (a(responseCommon)) {
            c().a(responseCommon);
        }
    }

    private a c() {
        return ar.f().e().removeActivityProcessor();
    }

    private boolean a(ResponseCommon responseCommon) {
        if (responseCommon.errcode.intValue() == 0) {
            return true;
        }
        b(responseCommon);
        return false;
    }

    public void a(String str) {
        ResponseCommon.Builder builder = new ResponseCommon.Builder();
        builder.requestid(str);
        builder.errcode = -100;
        b(builder.build());
    }

    private void b(ResponseCommon responseCommon) {
        if (((ba) o.a().g(responseCommon.requestid)).d() == 0) {
            b.a("ACTIVITY_REMOVE_ERROR", new com.garena.android.appkit.b.a(new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon)), b.a.NETWORK_BUS);
        } else {
            b.a("ACTION_REMOVE_ERROR", new com.garena.android.appkit.b.a(new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon)), b.a.NETWORK_BUS);
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final n f17858a;

        /* renamed from: b  reason: collision with root package name */
        private final ActivityCounter f17859b;

        /* renamed from: c  reason: collision with root package name */
        private final ActionRequiredCounter f17860c;

        /* renamed from: d  reason: collision with root package name */
        private final c f17861d;

        /* renamed from: e  reason: collision with root package name */
        private final com.shopee.app.data.store.a f17862e;

        /* renamed from: f  reason: collision with root package name */
        private final c f17863f;

        public a(n nVar, ActivityCounter activityCounter, ActionRequiredCounter actionRequiredCounter, c cVar, c cVar2, com.shopee.app.data.store.a aVar) {
            this.f17858a = nVar;
            this.f17859b = activityCounter;
            this.f17860c = actionRequiredCounter;
            this.f17863f = cVar;
            this.f17861d = cVar2;
            this.f17862e = aVar;
        }

        public void a(ResponseCommon responseCommon) {
            ba baVar = (ba) o.a().f(responseCommon.requestid);
            if (baVar != null) {
                if (baVar.d() == 0) {
                    this.f17863f.b((long) baVar.c());
                    this.f17859b.remove((long) baVar.c());
                    this.f17858a.a().aa.a(responseCommon.requestid).a();
                    return;
                }
                this.f17861d.b(baVar.b());
                long e2 = baVar.e() > 0 ? baVar.e() : baVar.b();
                this.f17860c.remove(e2, baVar.d());
                this.f17862e.a(baVar.e());
                this.f17858a.a().dd.a(Long.valueOf(e2)).a();
            }
        }
    }
}
