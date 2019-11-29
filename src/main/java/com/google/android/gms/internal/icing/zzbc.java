package com.google.android.gms.internal.icing;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import androidx.b.a;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzbc implements zzbg {
    static final Map<Uri, zzbc> zzcj = new a();
    private static final String[] zzco = {"key", AppMeasurementSdk.ConditionalUserProperty.VALUE};
    private final Uri uri;
    private final ContentResolver zzck;
    private final Object zzcl = new Object();
    private volatile Map<String, String> zzcm;
    private final List<zzbd> zzcn = new ArrayList();

    private zzbc(ContentResolver contentResolver, Uri uri2) {
        this.zzck = contentResolver;
        this.uri = uri2;
        this.zzck.registerContentObserver(uri2, false, new zzbe(this, (Handler) null));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(5:5|6|7|8|9)|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0018 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.icing.zzbc zza(android.content.ContentResolver r3, android.net.Uri r4) {
        /*
            java.lang.Class<com.google.android.gms.internal.icing.zzbc> r0 = com.google.android.gms.internal.icing.zzbc.class
            monitor-enter(r0)
            java.util.Map<android.net.Uri, com.google.android.gms.internal.icing.zzbc> r1 = zzcj     // Catch:{ all -> 0x001a }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.icing.zzbc r1 = (com.google.android.gms.internal.icing.zzbc) r1     // Catch:{ all -> 0x001a }
            if (r1 != 0) goto L_0x0018
            com.google.android.gms.internal.icing.zzbc r2 = new com.google.android.gms.internal.icing.zzbc     // Catch:{ SecurityException -> 0x0018 }
            r2.<init>(r3, r4)     // Catch:{ SecurityException -> 0x0018 }
            java.util.Map<android.net.Uri, com.google.android.gms.internal.icing.zzbc> r3 = zzcj     // Catch:{ SecurityException -> 0x0017 }
            r3.put(r4, r2)     // Catch:{ SecurityException -> 0x0017 }
        L_0x0017:
            r1 = r2
        L_0x0018:
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            return r1
        L_0x001a:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.icing.zzbc.zza(android.content.ContentResolver, android.net.Uri):com.google.android.gms.internal.icing.zzbc");
    }

    private final Map<String, String> zzm() {
        Map<String, String> map = this.zzcm;
        if (map == null) {
            synchronized (this.zzcl) {
                map = this.zzcm;
                if (map == null) {
                    map = zzo();
                    this.zzcm = map;
                }
            }
        }
        if (map != null) {
            return map;
        }
        return Collections.emptyMap();
    }

    public final void zzn() {
        synchronized (this.zzcl) {
            this.zzcm = null;
            zzbo.zzr();
        }
        synchronized (this) {
            for (zzbd zzq : this.zzcn) {
                zzq.zzq();
            }
        }
    }

    private final Map<String, String> zzo() {
        try {
            return (Map) zzbf.zza(new zzbb(this));
        } catch (SQLiteException | IllegalStateException | SecurityException unused) {
            Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
            return null;
        }
    }

    public final /* synthetic */ Object zzi(String str) {
        return zzm().get(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Map zzp() {
        Map map;
        Cursor query = this.zzck.query(this.uri, zzco, (String) null, (String[]) null, (String) null);
        if (query == null) {
            return Collections.emptyMap();
        }
        try {
            int count = query.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            if (count <= 256) {
                map = new a(count);
            } else {
                map = new HashMap(count, 1.0f);
            }
            while (query.moveToNext()) {
                map.put(query.getString(0), query.getString(1));
            }
            query.close();
            return map;
        } finally {
            query.close();
        }
    }
}
