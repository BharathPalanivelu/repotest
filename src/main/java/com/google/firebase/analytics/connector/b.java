package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.a;
import com.google.firebase.a.d;
import com.google.firebase.analytics.connector.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class b implements a {

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f6777b;
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    final Map<String, Object> f6778a = new ConcurrentHashMap();
    @VisibleForTesting

    /* renamed from: c  reason: collision with root package name */
    private final AppMeasurement f6779c;

    private b(AppMeasurement appMeasurement) {
        Preconditions.checkNotNull(appMeasurement);
        this.f6779c = appMeasurement;
    }

    @KeepForSdk
    public static a a(com.google.firebase.b bVar, Context context, d dVar) {
        Preconditions.checkNotNull(bVar);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(dVar);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (f6777b == null) {
            synchronized (b.class) {
                if (f6777b == null) {
                    Bundle bundle = new Bundle(1);
                    if (bVar.f()) {
                        dVar.a(a.class, d.f6781a, c.f6780a);
                        bundle.putBoolean("dataCollectionDefaultEnabled", bVar.e());
                    }
                    f6777b = new b(AppMeasurement.zza(context, bundle));
                }
            }
        }
        return f6777b;
    }

    @KeepForSdk
    public void a(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (com.google.firebase.analytics.connector.internal.b.a(str) && com.google.firebase.analytics.connector.internal.b.a(str2, bundle) && com.google.firebase.analytics.connector.internal.b.a(str, str2, bundle)) {
            this.f6779c.logEventInternal(str, str2, bundle);
        }
    }

    @KeepForSdk
    public void a(String str, String str2, Object obj) {
        if (com.google.firebase.analytics.connector.internal.b.a(str) && com.google.firebase.analytics.connector.internal.b.a(str, str2)) {
            this.f6779c.setUserPropertyInternal(str, str2, obj);
        }
    }

    @KeepForSdk
    public Map<String, Object> a(boolean z) {
        return this.f6779c.getUserProperties(z);
    }

    @KeepForSdk
    public void a(a.C0117a aVar) {
        if (com.google.firebase.analytics.connector.internal.b.a(aVar)) {
            this.f6779c.setConditionalUserProperty(com.google.firebase.analytics.connector.internal.b.b(aVar));
        }
    }

    @KeepForSdk
    public void b(String str, String str2, Bundle bundle) {
        if (str2 == null || com.google.firebase.analytics.connector.internal.b.a(str2, bundle)) {
            this.f6779c.clearConditionalUserProperty(str, str2, bundle);
        }
    }

    @KeepForSdk
    public List<a.C0117a> a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        for (AppMeasurement.ConditionalUserProperty a2 : this.f6779c.getConditionalUserProperties(str, str2)) {
            arrayList.add(com.google.firebase.analytics.connector.internal.b.a(a2));
        }
        return arrayList;
    }

    @KeepForSdk
    public int a(String str) {
        return this.f6779c.getMaxUserProperties(str);
    }

    static final /* synthetic */ void a(com.google.firebase.a.a aVar) {
        boolean z = ((com.google.firebase.a) aVar.b()).f6747a;
        synchronized (b.class) {
            ((b) f6777b).f6779c.zza(z);
        }
    }
}
