package com.shopee.app.util.datapoint;

import com.firebase.jobdispatcher.e;
import com.firebase.jobdispatcher.n;
import com.firebase.jobdispatcher.u;
import com.firebase.jobdispatcher.x;
import com.firebase.jobdispatcher.y;
import com.google.android.gms.common.GoogleApiAvailability;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.jobdispatcher.DataPointJobConfigStore;
import com.shopee.app.data.store.jobdispatcher.JobConfig;
import java.util.concurrent.TimeUnit;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private e f26309a;

    public a(e eVar) {
        this.f26309a = eVar;
    }

    public void a() {
        try {
            if (c()) {
                DataPointJobConfigStore dataPointJobConfigStore = ar.f().e().dataPointJobConfigStore();
                JobConfig localConfig = dataPointJobConfigStore.getLocalConfig();
                JobConfig remoteConfig = dataPointJobConfigStore.getRemoteConfig();
                boolean hasConfigChanged = remoteConfig.hasConfigChanged(localConfig);
                int seconds = (int) TimeUnit.MINUTES.toSeconds((long) remoteConfig.getPeriod());
                int[] iArr = {2, 4};
                int[] iArr2 = {2};
                n.a a2 = this.f26309a.a();
                if (!remoteConfig.isNeedCharger()) {
                    iArr = iArr2;
                }
                this.f26309a.b(a2.a(iArr).a(2).a((u) y.a(0, seconds)).b(true).a(x.f7260b).a(hasConfigChanged).a(remoteConfig.getService()).a(remoteConfig.getTag()).j());
            }
        } catch (Throwable th) {
            com.garena.android.appkit.d.a.a(th);
        }
    }

    public void b() {
        try {
            this.f26309a.a("DataPointService");
        } catch (Throwable th) {
            com.garena.android.appkit.d.a.a(th);
        }
    }

    private boolean c() {
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(ar.f()) == 0;
    }
}
