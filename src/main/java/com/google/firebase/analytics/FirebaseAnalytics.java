package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzx;
import com.google.android.gms.internal.measurement.zzz;
import com.google.android.gms.measurement.internal.zzfj;
import com.google.android.gms.measurement.internal.zzhi;
import com.google.android.gms.measurement.internal.zzr;
import com.google.firebase.iid.FirebaseInstanceId;
import com.j256.ormlite.field.FieldType;
import com.shopee.livequiz.data.bean.LiveParams;

public final class FirebaseAnalytics {

    /* renamed from: a  reason: collision with root package name */
    private static volatile FirebaseAnalytics f6764a;

    /* renamed from: b  reason: collision with root package name */
    private final zzfj f6765b;

    /* renamed from: c  reason: collision with root package name */
    private final zzz f6766c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f6767d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f6768e;

    @Keep
    public static FirebaseAnalytics getInstance(Context context) {
        if (f6764a == null) {
            synchronized (FirebaseAnalytics.class) {
                if (f6764a == null) {
                    if (zzz.zzf(context)) {
                        f6764a = new FirebaseAnalytics(zzz.zza(context));
                    } else {
                        f6764a = new FirebaseAnalytics(zzfj.zza(context, (zzx) null));
                    }
                }
            }
        }
        return f6764a;
    }

    public final void a(String str, Bundle bundle) {
        if (this.f6767d) {
            this.f6766c.logEvent(str, bundle);
        } else {
            this.f6765b.zzq().zza(LiveParams.SYNC_TYPE_APP, str, bundle, true);
        }
    }

    public final void a(String str, String str2) {
        if (this.f6767d) {
            this.f6766c.setUserProperty(str, str2);
        } else {
            this.f6765b.zzq().zzb(LiveParams.SYNC_TYPE_APP, str, (Object) str2, false);
        }
    }

    @Keep
    public final void setCurrentScreen(Activity activity, String str, String str2) {
        if (this.f6767d) {
            this.f6766c.setCurrentScreen(activity, str, str2);
        } else if (!zzr.isMainThread()) {
            this.f6765b.zzab().zzgn().zzao("setCurrentScreen must be called from the main thread");
        } else {
            this.f6765b.zzt().setCurrentScreen(activity, str, str2);
        }
    }

    public final void a(boolean z) {
        if (this.f6767d) {
            this.f6766c.setMeasurementEnabled(z);
        } else {
            this.f6765b.zzq().setMeasurementEnabled(z);
        }
    }

    public final void a(String str) {
        if (this.f6767d) {
            this.f6766c.setUserId(str);
        } else {
            this.f6765b.zzq().zzb(LiveParams.SYNC_TYPE_APP, FieldType.FOREIGN_ID_FIELD_SUFFIX, (Object) str, true);
        }
    }

    private FirebaseAnalytics(zzfj zzfj) {
        Preconditions.checkNotNull(zzfj);
        this.f6765b = zzfj;
        this.f6766c = null;
        this.f6767d = false;
        this.f6768e = new Object();
    }

    private FirebaseAnalytics(zzz zzz) {
        Preconditions.checkNotNull(zzz);
        this.f6765b = null;
        this.f6766c = zzz;
        this.f6767d = true;
        this.f6768e = new Object();
    }

    @Keep
    public final String getFirebaseInstanceId() {
        return FirebaseInstanceId.getInstance().getId();
    }

    @Keep
    public static zzhi getScionFrontendApiImplementation(Context context, Bundle bundle) {
        if (!zzz.zzf(context)) {
            return null;
        }
        zzz zza = zzz.zza(context, (String) null, (String) null, (String) null, bundle);
        if (zza == null) {
            return null;
        }
        return new a(zza);
    }
}
