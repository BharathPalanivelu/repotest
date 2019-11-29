package com.shopee.app.react.sync;

import com.firebase.jobdispatcher.e;
import com.firebase.jobdispatcher.n;
import com.firebase.jobdispatcher.u;
import com.firebase.jobdispatcher.x;
import com.firebase.jobdispatcher.y;
import com.google.android.gms.common.GoogleApiAvailability;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.jobdispatcher.JobConfig;
import com.shopee.app.data.store.jobdispatcher.ReactJobConfigStore;
import java.util.concurrent.TimeUnit;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private e f19012a;

    public a(e eVar) {
        this.f19012a = eVar;
    }

    public void a() {
        try {
            if (b()) {
                ReactJobConfigStore reactJobConfigStore = ar.f().e().reactJobConfigStore();
                JobConfig localConfig = reactJobConfigStore.getLocalConfig();
                JobConfig remoteConfig = reactJobConfigStore.getRemoteConfig();
                boolean hasConfigChanged = remoteConfig.hasConfigChanged(localConfig);
                int seconds = (int) TimeUnit.MINUTES.toSeconds((long) remoteConfig.getPeriod());
                int[] iArr = {2, 4};
                int[] iArr2 = {2};
                n.a a2 = this.f19012a.a();
                if (!remoteConfig.isNeedCharger()) {
                    iArr = iArr2;
                }
                this.f19012a.b(a2.a(iArr).a(2).a((u) y.a(0, seconds)).b(true).a(x.f7260b).a(hasConfigChanged).a(remoteConfig.getService()).a(remoteConfig.getTag()).j());
                reactJobConfigStore.updateLocalConfig(remoteConfig);
            }
        } catch (Throwable th) {
            com.garena.android.appkit.d.a.a(th);
        }
    }

    private boolean b() {
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(ar.f()) == 0;
    }
}
