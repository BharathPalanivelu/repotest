package com.google.android.gms.internal.firebase_remote_config;

import android.content.SharedPreferences;
import com.google.firebase.remoteconfig.f;
import com.google.firebase.remoteconfig.h;
import java.util.Date;

public final class zzev {
    static final Date zzli = new Date(-1);
    static final Date zzlj = new Date(-1);
    private final SharedPreferences zzlk;
    private final Object zzll = new Object();
    private final Object zzlm = new Object();

    public zzev(SharedPreferences sharedPreferences) {
        this.zzlk = sharedPreferences;
    }

    public final boolean isDeveloperModeEnabled() {
        return this.zzlk.getBoolean("is_developer_mode_enabled", false);
    }

    public final long getFetchTimeoutInSeconds() {
        return this.zzlk.getLong("fetch_timeout_in_seconds", 5);
    }

    public final long getMinimumFetchIntervalInSeconds() {
        return this.zzlk.getLong("minimum_fetch_interval_in_seconds", zzes.zzla);
    }

    /* access modifiers changed from: package-private */
    public final Date zzcy() {
        return new Date(this.zzlk.getLong("last_fetch_time_in_millis", -1));
    }

    /* access modifiers changed from: package-private */
    public final String zzcz() {
        return this.zzlk.getString("last_fetch_etag", (String) null);
    }

    public final void zzm(int i) {
        synchronized (this.zzll) {
            this.zzlk.edit().putInt("last_fetch_status", i).apply();
        }
    }

    public final void zzf(Date date) {
        synchronized (this.zzll) {
            this.zzlk.edit().putLong("last_fetch_time_in_millis", date.getTime()).apply();
        }
    }

    public final f getInfo() {
        zzez zzdf;
        synchronized (this.zzll) {
            long j = this.zzlk.getLong("last_fetch_time_in_millis", -1);
            int i = this.zzlk.getInt("last_fetch_status", 0);
            zzdf = new zzfb().zzn(i).zzc(j).zzc(new h.a().a(this.zzlk.getBoolean("is_developer_mode_enabled", false)).a(this.zzlk.getLong("fetch_timeout_in_seconds", 5)).b(this.zzlk.getLong("minimum_fetch_interval_in_seconds", zzes.zzla)).a()).zzdf();
        }
        return zzdf;
    }

    public final void clear() {
        synchronized (this.zzll) {
            this.zzlk.edit().clear().commit();
        }
    }

    public final void setConfigSettings(h hVar) {
        synchronized (this.zzll) {
            this.zzlk.edit().putBoolean("is_developer_mode_enabled", hVar.a()).putLong("fetch_timeout_in_seconds", hVar.b()).putLong("minimum_fetch_interval_in_seconds", hVar.c()).commit();
        }
    }

    public final void zzb(h hVar) {
        synchronized (this.zzll) {
            this.zzlk.edit().putBoolean("is_developer_mode_enabled", hVar.a()).putLong("fetch_timeout_in_seconds", hVar.b()).putLong("minimum_fetch_interval_in_seconds", hVar.c()).apply();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzbd(String str) {
        synchronized (this.zzll) {
            this.zzlk.edit().putString("last_fetch_etag", str).apply();
        }
    }

    /* access modifiers changed from: package-private */
    public final zzey zzda() {
        zzey zzey;
        synchronized (this.zzlm) {
            zzey = new zzey(this.zzlk.getInt("num_failed_fetches", 0), new Date(this.zzlk.getLong("backoff_end_time_in_millis", -1)));
        }
        return zzey;
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, Date date) {
        synchronized (this.zzlm) {
            this.zzlk.edit().putInt("num_failed_fetches", i).putLong("backoff_end_time_in_millis", date.getTime()).apply();
        }
    }
}
