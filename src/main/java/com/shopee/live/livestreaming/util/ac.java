package com.shopee.live.livestreaming.util;

import a.h;
import a.k;
import android.content.Context;
import com.shopee.e.a.a;
import com.shopee.live.livestreaming.b;
import com.shopee.live.livestreaming.data.entity.require.LicenseEntity;
import com.shopee.live.livestreaming.data.store.LiveStreamingStore;
import com.shopee.live.livestreaming.network.service.TxLicensePullHelper;
import com.tencent.rtmp.TXLiveBase;
import java.util.concurrent.Callable;
import okhttp3.Call;

public class ac {

    /* renamed from: a  reason: collision with root package name */
    private static k<LicenseEntity> f29394a;

    /* renamed from: b  reason: collision with root package name */
    private static TxLicensePullHelper f29395b;

    /* renamed from: c  reason: collision with root package name */
    private static Call f29396c;

    public static void a(final Context context) {
        f29394a = k.a(new Callable<LicenseEntity>() {
            /* renamed from: a */
            public LicenseEntity call() throws Exception {
                ac.e(context);
                LicenseEntity a2 = ac.b();
                if (!ac.b(a2)) {
                    return ac.f(context);
                }
                a.c("TxLicenseManager %s", "use stored license");
                return a2;
            }
        });
        f29394a.a(new h<LicenseEntity, Boolean>() {
            /* renamed from: a */
            public Boolean then(k<LicenseEntity> kVar) throws Exception {
                LicenseEntity f2 = kVar.f();
                if (!ac.b(f2)) {
                    return false;
                }
                a.c("TxLicenseManager %s", "initLicense: set license");
                TXLiveBase.getInstance().setLicence(context, f2.getLicense(), f2.getKey());
                return true;
            }
        }, k.f377b);
    }

    public static void b(Context context) {
        if (f29394a == null) {
            a.c("TxLicenseManager %s", "You forget init license, so we init again.");
            a(context);
        }
        if (!f29394a.c()) {
            try {
                f29394a.h();
            } catch (InterruptedException unused) {
                a.b("TxLicenseManager %s", "checkInit interrupted");
            }
        }
    }

    /* access modifiers changed from: private */
    public static LicenseEntity b() {
        LiveStreamingStore a2 = b.b().a();
        return new LicenseEntity(a2.getTxLicenseKey(), a2.getTxLicenseUrl());
    }

    /* access modifiers changed from: private */
    public static void e(final Context context) {
        Call call = f29396c;
        if (call != null) {
            call.cancel();
        }
        f29396c = g(context).pullLicense(new TxLicensePullHelper.PullLicenseListener() {
            public void onPullSuccess(final LicenseEntity licenseEntity) {
                a.c("TxLicenseManager %s", "pull license success");
                LicenseEntity a2 = ac.b();
                if (ac.b(licenseEntity) && !licenseEntity.equals(a2)) {
                    final LiveStreamingStore a3 = b.b().a();
                    k.b(new Callable<Boolean>() {
                        /* renamed from: a */
                        public Boolean call() throws Exception {
                            a.c("TxLicenseManager %s", "write license to store");
                            a3.putTxLicenseKey(licenseEntity.getKey());
                            a3.putTxLicenseUrl(licenseEntity.getLicense());
                            return true;
                        }
                    }).a(new h<Boolean, Boolean>() {
                        /* renamed from: a */
                        public Boolean then(k<Boolean> kVar) throws Exception {
                            a.c("TxLicenseManager %s", "set license from net");
                            TXLiveBase.getInstance().setLicence(context, licenseEntity.getLicense(), licenseEntity.getKey());
                            return true;
                        }
                    }, k.f377b);
                }
            }

            public void onPullError(Throwable th) {
                a.b("TxLicenseManager %s", "pull license err", th);
            }
        });
    }

    /* access modifiers changed from: private */
    public static LicenseEntity f(Context context) {
        LiveStreamingStore a2 = b.b().a();
        LicenseEntity a3 = b.b().b().a(context.getPackageName());
        if (!b(a3)) {
            a.c("TxLicenseManager %s", "use license in assets");
            a3 = b.b().b().a("default");
        }
        if (b(a3)) {
            a2.putTxLicenseKey(a3.getKey());
            a2.putTxLicenseUrl(a3.getLicense());
        }
        return a3;
    }

    /* access modifiers changed from: private */
    public static boolean b(LicenseEntity licenseEntity) {
        return licenseEntity != null && !d.a(licenseEntity.getKey()) && !d.a(licenseEntity.getLicense());
    }

    private static TxLicensePullHelper g(Context context) {
        if (f29395b == null) {
            f29395b = new TxLicensePullHelper(context.getApplicationContext());
        }
        return f29395b;
    }
}
