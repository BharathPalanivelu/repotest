package com.google.firebase.analytics;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzz;
import com.google.android.gms.measurement.internal.zzgk;
import com.google.android.gms.measurement.internal.zzgn;
import com.google.android.gms.measurement.internal.zzhi;
import java.util.List;
import java.util.Map;

final class a implements zzhi {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzz f6769a;

    a(zzz zzz) {
        this.f6769a = zzz;
    }

    public final void logEventInternal(String str, String str2, Bundle bundle) {
        this.f6769a.logEventInternal(str, str2, bundle);
    }

    public final void logEventInternalNoInterceptor(String str, String str2, Bundle bundle, long j) {
        this.f6769a.logEventInternalNoInterceptor(str, str2, bundle, j);
    }

    public final void setUserPropertyInternal(String str, String str2, Object obj) {
        this.f6769a.setUserPropertyInternal(str, str2, obj);
    }

    public final void setMeasurementEnabled(boolean z) {
        this.f6769a.setMeasurementEnabled(z);
    }

    public final void setDataCollectionEnabled(boolean z) {
        this.f6769a.setDataCollectionEnabled(z);
    }

    public final Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        return this.f6769a.getUserProperties(str, str2, z);
    }

    public final void zza(zzgk zzgk) {
        this.f6769a.zza(zzgk);
    }

    public final void zza(zzgn zzgn) {
        this.f6769a.zza(zzgn);
    }

    public final void zzb(zzgn zzgn) {
        this.f6769a.zzb(zzgn);
    }

    public final String getCurrentScreenName() {
        return this.f6769a.getCurrentScreenName();
    }

    public final String getCurrentScreenClass() {
        return this.f6769a.getCurrentScreenClass();
    }

    public final String zzi() {
        return this.f6769a.zzi();
    }

    public final String getGmpAppId() {
        return this.f6769a.getGmpAppId();
    }

    public final long generateEventId() {
        return this.f6769a.generateEventId();
    }

    public final void beginAdUnitExposure(String str) {
        this.f6769a.beginAdUnitExposure(str);
    }

    public final void endAdUnitExposure(String str) {
        this.f6769a.endAdUnitExposure(str);
    }

    public final void setConditionalUserProperty(Bundle bundle) {
        this.f6769a.setConditionalUserProperty(bundle);
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.f6769a.clearConditionalUserProperty(str, str2, bundle);
    }

    public final List<Bundle> getConditionalUserProperties(String str, String str2) {
        return this.f6769a.getConditionalUserProperties(str, str2);
    }

    public final int getMaxUserProperties(String str) {
        return this.f6769a.getMaxUserProperties(str);
    }

    public final Object zzb(int i) {
        return this.f6769a.zzb(i);
    }
}
