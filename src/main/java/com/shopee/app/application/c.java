package com.shopee.app.application;

import android.content.Context;
import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.JobManager;
import com.path.android.jobqueue.config.Configuration;
import com.path.android.jobqueue.di.DependencyInjector;
import com.path.android.jobqueue.log.CustomLogger;
import com.shopee.app.application.a.b;
import com.shopee.app.data.store.RegionConfigStore;
import com.shopee.app.data.store.ServerConfigStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.ShareConfigStore;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.ae;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.am;
import com.shopee.app.data.store.bd;
import com.shopee.app.data.store.theme.ThemeStore;
import com.shopee.app.data.store.v;
import com.shopee.app.data.store.z;
import com.shopee.app.h.a.a;
import com.shopee.app.h.p;
import com.shopee.app.react.modules.app.data.c;
import com.shopee.app.react.modules.app.data.k;
import com.shopee.app.ui.home.HomeActivity_;
import com.shopee.app.upload.UploadJob;
import com.shopee.app.util.bh;
import com.shopee.app.util.bi;
import com.shopee.app.util.datapoint.a.d;
import com.shopee.app.util.i;
import com.shopee.app.util.n;
import com.shopee.app.util.q;
import f.a.a.h;
import f.c;
import f.e;
import f.n;
import okhttp3.OkHttpClient;

public class c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ar f6934a;

    public c(ar arVar) {
        this.f6934a = arVar;
    }

    /* access modifiers changed from: package-private */
    public ar a() {
        return this.f6934a;
    }

    /* access modifiers changed from: package-private */
    public n b() {
        return new n();
    }

    /* access modifiers changed from: package-private */
    public bi c() {
        return new bi();
    }

    /* access modifiers changed from: package-private */
    public al d() {
        return new al(this.f6934a.getSharedPreferences("loginStore", 0));
    }

    /* access modifiers changed from: package-private */
    public bh e() {
        return new bh();
    }

    /* access modifiers changed from: package-private */
    public a f() {
        return a.a();
    }

    /* access modifiers changed from: package-private */
    public ServerConfigStore a(bh bhVar, a aVar, al alVar) {
        ServerConfigStore serverConfigStore = new ServerConfigStore(this.f6934a.getSharedPreferences("serverConfig", 0), bhVar, aVar);
        serverConfigStore.checkDownload();
        return serverConfigStore;
    }

    /* access modifiers changed from: package-private */
    public p a(ServerConfigStore serverConfigStore, bh bhVar) {
        p pVar = new p(serverConfigStore, bhVar);
        pVar.a();
        return pVar;
    }

    /* access modifiers changed from: package-private */
    public ShareConfigStore g() {
        return new ShareConfigStore(this.f6934a.getSharedPreferences("share_config", 0), new aa(this.f6934a.getSharedPreferences("device_config", 0)).b());
    }

    /* access modifiers changed from: package-private */
    public am h() {
        return new am(this.f6934a.getSharedPreferences("message_shortcut", 0));
    }

    /* access modifiers changed from: package-private */
    public SettingConfigStore i() {
        return SettingConfigStore.getInstance();
    }

    /* access modifiers changed from: package-private */
    public aa j() {
        return new aa(this.f6934a.getSharedPreferences("device_config", 0));
    }

    /* access modifiers changed from: package-private */
    public bd k() {
        return new bd(this.f6934a.getSharedPreferences("tool_tip_config", 0));
    }

    /* access modifiers changed from: package-private */
    public b l() {
        return new b(this.f6934a);
    }

    /* access modifiers changed from: package-private */
    public v m() {
        return new v.a(ar.f()).a();
    }

    /* access modifiers changed from: package-private */
    public ae n() {
        return new ae.a(this.f6934a).a();
    }

    /* access modifiers changed from: package-private */
    public z o() {
        return new z.a(this.f6934a).a();
    }

    /* access modifiers changed from: package-private */
    public com.shopee.app.util.datapoint.b.a a(f.n nVar, aa aaVar) {
        return new com.shopee.app.util.datapoint.b.a((com.shopee.app.network.http.a.c) nVar.a(com.shopee.app.network.http.a.c.class), aaVar);
    }

    /* access modifiers changed from: package-private */
    public com.shopee.app.util.datapoint.a.a a(f.n nVar, aa aaVar, z zVar) {
        return new com.shopee.app.util.datapoint.a.a((com.shopee.app.network.http.a.c) nVar.a(com.shopee.app.network.http.a.c.class), aaVar, zVar);
    }

    /* access modifiers changed from: package-private */
    public d b(f.n nVar, aa aaVar, z zVar) {
        return new d((com.shopee.app.network.http.a.c) nVar.a(com.shopee.app.network.http.a.c.class), aaVar, zVar);
    }

    /* access modifiers changed from: package-private */
    public com.shopee.app.util.datapoint.a.c c(f.n nVar, aa aaVar, z zVar) {
        return new com.shopee.app.util.datapoint.a.c((com.shopee.app.network.http.a.c) nVar.a(com.shopee.app.network.http.a.c.class), aaVar, zVar);
    }

    /* access modifiers changed from: package-private */
    public com.shopee.app.util.datapoint.a.b d(f.n nVar, aa aaVar, z zVar) {
        return new com.shopee.app.util.datapoint.a.b((com.shopee.app.network.http.a.c) nVar.a(com.shopee.app.network.http.a.c.class), aaVar, zVar);
    }

    /* access modifiers changed from: package-private */
    public RegionConfigStore p() {
        return new RegionConfigStore(this.f6934a.getSharedPreferences("region_config_store", 0));
    }

    /* access modifiers changed from: package-private */
    public ThemeStore q() {
        return new ThemeStore(this.f6934a.getSharedPreferences("theme_config_store", 0));
    }

    /* access modifiers changed from: package-private */
    public com.shopee.app.util.am r() {
        return new com.shopee.app.util.am();
    }

    /* access modifiers changed from: package-private */
    public f.n a(OkHttpClient okHttpClient) {
        return new n.a().a(i.f7040c).a((e.a) f.b.a.a.a()).a(okHttpClient).a((c.a) h.a()).a();
    }

    /* access modifiers changed from: package-private */
    public OkHttpClient a(ae aeVar) {
        return this.f6934a.l().a(aeVar.a(), aeVar.b(), (Context) this.f6934a);
    }

    /* access modifiers changed from: package-private */
    public q s() {
        return new q();
    }

    /* access modifiers changed from: package-private */
    public com.garena.sticker.b a(aa aaVar, al alVar, OkHttpClient okHttpClient) {
        return new com.garena.sticker.b(this.f6934a.getSharedPreferences("sticker_store", 0), okHttpClient, String.format("https://%s/shopee-sticker-%s-%s/", new Object[]{"cdn.shopee.co.id/shopee", "live", "ID".toLowerCase()}), "ID", aaVar.b(), this.f6934a.getResources().getDisplayMetrics().density);
    }

    /* access modifiers changed from: package-private */
    public JobManager a(com.shopee.app.util.am amVar) {
        return new JobManager((Context) this.f6934a, new Configuration.Builder(this.f6934a).injector(new DependencyInjector() {
            public void inject(Job job) {
                if (job instanceof com.shopee.app.util.k.c) {
                    c.this.f6934a.e().inject((com.shopee.app.util.k.c) job);
                } else if (job instanceof com.shopee.app.util.g.b) {
                    c.this.f6934a.e().inject((com.shopee.app.util.g.b) job);
                } else if (job instanceof com.shopee.app.util.g.d) {
                    c.this.f6934a.e().inject((com.shopee.app.util.g.d) job);
                } else if (job instanceof UploadJob) {
                    c.this.f6934a.e().inject((UploadJob) job);
                }
            }
        }).loadFactor(2).customLogger(new CustomLogger() {
            public boolean isDebugEnabled() {
                return false;
            }

            public void d(String str, Object... objArr) {
                com.garena.android.appkit.d.a.b("JOB_MANAGER: " + str, objArr);
            }

            public void e(Throwable th, String str, Object... objArr) {
                com.garena.android.appkit.d.a.a(th);
            }

            public void e(String str, Object... objArr) {
                com.garena.android.appkit.d.a.a("JOB_MANAGER: " + str, objArr);
            }
        }).networkUtil(amVar).build());
    }

    /* access modifiers changed from: package-private */
    public com.shopee.app.react.modules.app.data.c t() {
        return new c.a(this.f6934a).a();
    }

    /* access modifiers changed from: package-private */
    public k a(com.shopee.app.util.n nVar) {
        return new k(nVar);
    }

    /* access modifiers changed from: package-private */
    public com.shopee.navigator.e u() {
        return com.shopee.navigator.e.a(com.shopee.navigator.c.d.b(), (Class<? extends Object>) HomeActivity_.class);
    }

    /* access modifiers changed from: package-private */
    public com.shopee.b.a v() {
        return new com.shopee.b.a(this.f6934a);
    }
}
