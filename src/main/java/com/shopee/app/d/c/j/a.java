package com.shopee.app.d.c.j;

import cn.tongdun.android.shell.settings.Constants;
import com.shopee.app.d.c.a.a;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.viewmodel.PreInstallData;
import com.shopee.app.tracking.f;
import com.shopee.app.util.n;
import com.shopee.app.util.q;
import com.shopee.app.util.r;
import com.shopee.app.web.WebRegister;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class a extends com.shopee.app.d.c.a.a<C0258a> {

    /* renamed from: d  reason: collision with root package name */
    private final f f17060d;

    /* renamed from: e  reason: collision with root package name */
    private final aa f17061e;

    /* renamed from: f  reason: collision with root package name */
    private final q f17062f;

    public a(f fVar, aa aaVar, q qVar, n nVar) {
        super(nVar);
        this.f17060d = fVar;
        this.f17062f = qVar;
        this.f17061e = aaVar;
    }

    public void a() {
        b(new C0258a());
    }

    /* access modifiers changed from: protected */
    public void a(C0258a aVar) {
        if (!this.f17061e.n()) {
            try {
                if (new File("/data/etc/appchannel/shopee_appchannel.txt").exists()) {
                    PreInstallData preInstallData = (PreInstallData) WebRegister.GSON.a((Reader) new BufferedReader(new FileReader("/data/etc/appchannel/shopee_appchannel.txt")), PreInstallData.class);
                    if ("com.shopee".equals(preInstallData.getApp())) {
                        if ("01a9b1b18ca53346eedc04336cb2a446".equals(preInstallData.getHash())) {
                            this.f17060d.a("OPPO_PRE_INSTALL", this.f17061e.g());
                            this.f17062f.a(r.a());
                        }
                        this.f17061e.o();
                        return;
                    }
                    return;
                }
                this.f17061e.o();
            } catch (Exception e2) {
                com.garena.android.appkit.d.a.a(e2);
            }
        }
    }

    /* renamed from: com.shopee.app.d.c.j.a$a  reason: collision with other inner class name */
    public static class C0258a extends a.C0253a {
        public C0258a() {
            super("AppsFlyerInstallTrackingInteractor", "use_case_1", Constants.DEFAULT_WAIT_TIME, false);
        }
    }
}
