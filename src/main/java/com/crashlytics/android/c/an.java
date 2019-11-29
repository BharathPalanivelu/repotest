package com.crashlytics.android.c;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import io.a.a.a.a.b.h;
import io.a.a.a.l;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class an {

    /* renamed from: a  reason: collision with root package name */
    static final Map<String, String> f6427a = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", "1");
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final short[] f6428b = {10, 20, 30, 60, 120, 300};

    /* renamed from: c  reason: collision with root package name */
    private final Object f6429c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private final s f6430d;

    /* renamed from: e  reason: collision with root package name */
    private final String f6431e;

    /* renamed from: f  reason: collision with root package name */
    private final c f6432f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final b f6433g;
    /* access modifiers changed from: private */
    public Thread h;

    interface b {
        boolean a();
    }

    interface c {
        File[] a();

        File[] b();

        File[] c();
    }

    interface d {
        boolean a();
    }

    static final class a implements d {
        public boolean a() {
            return true;
        }

        a() {
        }
    }

    public an(String str, s sVar, c cVar, b bVar) {
        if (sVar != null) {
            this.f6430d = sVar;
            this.f6431e = str;
            this.f6432f = cVar;
            this.f6433g = bVar;
            return;
        }
        throw new IllegalArgumentException("createReportCall must not be null.");
    }

    public synchronized void a(float f2, d dVar) {
        if (this.h != null) {
            io.a.a.a.c.h().a("CrashlyticsCore", "Report upload has already been started.");
            return;
        }
        this.h = new Thread(new e(f2, dVar), "Crashlytics Report Uploader");
        this.h.start();
    }

    /* access modifiers changed from: package-private */
    public boolean a(am amVar) {
        boolean z;
        synchronized (this.f6429c) {
            z = false;
            try {
                boolean a2 = this.f6430d.a(new r(this.f6431e, amVar));
                l h2 = io.a.a.a.c.h();
                StringBuilder sb = new StringBuilder();
                sb.append("Crashlytics report upload ");
                sb.append(a2 ? "complete: " : "FAILED: ");
                sb.append(amVar.b());
                h2.c("CrashlyticsCore", sb.toString());
                if (a2) {
                    amVar.f();
                    z = true;
                }
            } catch (Exception e2) {
                l h3 = io.a.a.a.c.h();
                h3.e("CrashlyticsCore", "Error occurred sending report " + amVar, e2);
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public List<am> a() {
        File[] a2;
        File[] b2;
        File[] c2;
        io.a.a.a.c.h().a("CrashlyticsCore", "Checking for crash reports...");
        synchronized (this.f6429c) {
            a2 = this.f6432f.a();
            b2 = this.f6432f.b();
            c2 = this.f6432f.c();
        }
        LinkedList linkedList = new LinkedList();
        if (a2 != null) {
            for (File file : a2) {
                io.a.a.a.c.h().a("CrashlyticsCore", "Found crash report " + file.getPath());
                linkedList.add(new ap(file));
            }
        }
        HashMap hashMap = new HashMap();
        if (b2 != null) {
            for (File file2 : b2) {
                String a3 = j.a(file2);
                if (!hashMap.containsKey(a3)) {
                    hashMap.put(a3, new LinkedList());
                }
                ((List) hashMap.get(a3)).add(file2);
            }
        }
        for (String str : hashMap.keySet()) {
            io.a.a.a.c.h().a("CrashlyticsCore", "Found invalid session: " + str);
            List list = (List) hashMap.get(str);
            linkedList.add(new x(str, (File[]) list.toArray(new File[list.size()])));
        }
        if (c2 != null) {
            for (File afVar : c2) {
                linkedList.add(new af(afVar));
            }
        }
        if (linkedList.isEmpty()) {
            io.a.a.a.c.h().a("CrashlyticsCore", "No reports found.");
        }
        return linkedList;
    }

    private class e extends h {

        /* renamed from: b  reason: collision with root package name */
        private final float f6435b;

        /* renamed from: c  reason: collision with root package name */
        private final d f6436c;

        e(float f2, d dVar) {
            this.f6435b = f2;
            this.f6436c = dVar;
        }

        public void a() {
            try {
                b();
            } catch (Exception e2) {
                io.a.a.a.c.h().e("CrashlyticsCore", "An unexpected error occurred while attempting to upload crash reports.", e2);
            }
            Thread unused = an.this.h = null;
        }

        private void b() {
            l h = io.a.a.a.c.h();
            h.a("CrashlyticsCore", "Starting report processing in " + this.f6435b + " second(s)...");
            float f2 = this.f6435b;
            if (f2 > BitmapDescriptorFactory.HUE_RED) {
                try {
                    Thread.sleep((long) (f2 * 1000.0f));
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            List<am> a2 = an.this.a();
            if (!an.this.f6433g.a()) {
                if (a2.isEmpty() || this.f6436c.a()) {
                    int i = 0;
                    while (!a2.isEmpty() && !an.this.f6433g.a()) {
                        l h2 = io.a.a.a.c.h();
                        h2.a("CrashlyticsCore", "Attempting to send " + a2.size() + " report(s)");
                        for (am a3 : a2) {
                            an.this.a(a3);
                        }
                        a2 = an.this.a();
                        if (!a2.isEmpty()) {
                            int i2 = i + 1;
                            long j = (long) an.f6428b[Math.min(i, an.f6428b.length - 1)];
                            l h3 = io.a.a.a.c.h();
                            h3.a("CrashlyticsCore", "Report submisson: scheduling delayed retry in " + j + " seconds");
                            try {
                                Thread.sleep(j * 1000);
                                i = i2;
                            } catch (InterruptedException unused2) {
                                Thread.currentThread().interrupt();
                                return;
                            }
                        }
                    }
                    return;
                }
                l h4 = io.a.a.a.c.h();
                h4.a("CrashlyticsCore", "User declined to send. Removing " + a2.size() + " Report(s).");
                for (am f3 : a2) {
                    f3.f();
                }
            }
        }
    }
}
