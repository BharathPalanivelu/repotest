package com.c.a.c.b.b;

import android.util.Log;
import com.c.a.a.a;
import com.c.a.c.b.b.a;
import com.c.a.c.h;
import java.io.File;
import java.io.IOException;

public class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private static e f5732a;

    /* renamed from: b  reason: collision with root package name */
    private final j f5733b;

    /* renamed from: c  reason: collision with root package name */
    private final File f5734c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5735d;

    /* renamed from: e  reason: collision with root package name */
    private final c f5736e = new c();

    /* renamed from: f  reason: collision with root package name */
    private a f5737f;

    public static synchronized a a(File file, int i) {
        e eVar;
        synchronized (e.class) {
            if (f5732a == null) {
                f5732a = new e(file, i);
            }
            eVar = f5732a;
        }
        return eVar;
    }

    protected e(File file, int i) {
        this.f5734c = file;
        this.f5735d = i;
        this.f5733b = new j();
    }

    private synchronized a a() throws IOException {
        if (this.f5737f == null) {
            this.f5737f = a.a(this.f5734c, 1, 1, (long) this.f5735d);
        }
        return this.f5737f;
    }

    public File a(h hVar) {
        String a2 = this.f5733b.a(hVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + a2 + " for for Key: " + hVar);
        }
        try {
            a.d a3 = a().a(a2);
            if (a3 != null) {
                return a3.a(0);
            }
            return null;
        } catch (IOException e2) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e2);
            return null;
        }
    }

    public void a(h hVar, a.b bVar) {
        a.b b2;
        String a2 = this.f5733b.a(hVar);
        this.f5736e.a(a2);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + a2 + " for for Key: " + hVar);
            }
            try {
                com.c.a.a.a a3 = a();
                if (a3.a(a2) == null) {
                    b2 = a3.b(a2);
                    if (b2 != null) {
                        if (bVar.a(b2.a(0))) {
                            b2.a();
                        }
                        b2.c();
                        this.f5736e.b(a2);
                        return;
                    }
                    throw new IllegalStateException("Had two simultaneous puts for: " + a2);
                }
            } catch (IOException e2) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e2);
                }
            } catch (Throwable th) {
                b2.c();
                throw th;
            }
        } finally {
            this.f5736e.b(a2);
        }
    }
}
