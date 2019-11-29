package com.threatmetrix.TrustDefenderMobile;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.util.Log;
import android.util.TimingLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class aa {
    /* access modifiers changed from: private */
    public static final String w = "aa";
    private static final Executor x = Executors.newFixedThreadPool(6);

    /* renamed from: a  reason: collision with root package name */
    final ab f32523a = new ab();

    /* renamed from: b  reason: collision with root package name */
    AndroidHttpClient f32524b = null;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<n> f32525c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final ReadWriteLock f32526d = new ReentrantReadWriteLock();

    /* renamed from: e  reason: collision with root package name */
    private final Lock f32527e = this.f32526d.readLock();

    /* renamed from: f  reason: collision with root package name */
    private final Lock f32528f = this.f32526d.writeLock();

    /* renamed from: g  reason: collision with root package name */
    private final ReentrantLock f32529g = new ReentrantLock();
    private p h = null;
    private Thread i = null;
    private volatile boolean j = false;
    private volatile AtomicBoolean k = new AtomicBoolean(false);
    private int l = 0;
    /* access modifiers changed from: private */
    public int m = 10000;
    private int n = 0;
    private boolean o = false;
    private boolean p = false;
    private AtomicBoolean q = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public CountDownLatch r = new CountDownLatch(1);
    private final z s = new z();
    /* access modifiers changed from: private */
    public final c t = new c();
    /* access modifiers changed from: private */
    public Context u = null;
    /* access modifiers changed from: private */
    public TimingLogger v = null;

    public enum b {
        THM_NotYet,
        THM_OK,
        THM_Connection_Error,
        THM_HostNotFound_Error,
        THM_NetworkTimeout_Error,
        THM_Internal_Error,
        THM_HostVerification_Error,
        THM_Interrupted_Error,
        THM_InvalidOrgID,
        THM_ConfigurationError,
        THM_PartialProfile;
        
        private final String desc;
        private final String label;

        public String toString() {
            return this.label;
        }

        public String getDesc() {
            return this.desc;
        }

        /* access modifiers changed from: package-private */
        public k a() {
            return k.valueOf(name());
        }

        static b a(k kVar) {
            return valueOf(kVar.name());
        }
    }

    public void a(String str) {
        if (this.f32523a.b() != str) {
            this.f32523a.a(str);
        }
        if (this.f32523a.b() == null || this.f32523a.b().isEmpty()) {
            this.p = false;
            return;
        }
        this.o = false;
        this.p = true;
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, boolean z) {
        if (!this.q.compareAndSet(false, true)) {
            Log.d(w, "Already init'd");
            return;
        }
        final Context context2 = context;
        final boolean z2 = z;
        new Thread(new d(this, (CountDownLatch) null) {
            public void run() {
                try {
                    Log.d(aa.w, "Doing slow init stuff");
                    aa.this.t.a(context2, z2, 0);
                    if (aa.this.v != null) {
                        aa.this.v.addSplit("init - initJSExecutor");
                    }
                    String d2 = aa.this.t.d();
                    if (aa.this.v != null) {
                        aa.this.v.addSplit("getUserAgent");
                    }
                    if (aa.this.f32524b == null) {
                        aa.this.f32524b = AndroidHttpClient.newInstance(d2, aa.this.u);
                        HttpParams params = aa.this.f32524b.getParams();
                        HttpConnectionParams.setConnectionTimeout(params, aa.this.m);
                        HttpConnectionParams.setSoTimeout(params, aa.this.m);
                        ad.a(context2, aa.this.f32524b, aa.this.m);
                        HttpConnectionParams.setTcpNoDelay(params, true);
                        HttpConnectionParams.setStaleCheckingEnabled(params, false);
                    }
                    if (aa.this.v != null) {
                        aa.this.v.addSplit("create AndroidHttpClient");
                    }
                    NativeGatherer.INSTANCE.isAvailable();
                    v.b((String) null);
                } finally {
                    if (aa.this.r != null) {
                        aa.this.r.countDown();
                    }
                }
            }
        }).start();
    }

    public b a(Context context, String str, String str2) {
        return a(context, str, str2, (String) null, 3327);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x015d, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0161, code lost:
        if (r4.i != null) goto L_0x0163;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0163, code lost:
        r4.i.interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0168, code lost:
        r4.j = false;
        r5 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_Interrupted_Error;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x016e, code lost:
        r4.f32528f.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0174, code lost:
        throw r5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x015f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.threatmetrix.TrustDefenderMobile.aa.b a(android.content.Context r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, int r9) {
        /*
            r4 = this;
            if (r5 != 0) goto L_0x0005
            com.threatmetrix.TrustDefenderMobile.aa$b r5 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_Internal_Error
            return r5
        L_0x0005:
            r0 = 0
            java.util.concurrent.locks.Lock r1 = r4.f32528f     // Catch:{ InterruptedException -> 0x015f }
            r1.lockInterruptibly()     // Catch:{ InterruptedException -> 0x015f }
            java.lang.String r1 = w     // Catch:{ InterruptedException -> 0x015f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x015f }
            r2.<init>()     // Catch:{ InterruptedException -> 0x015f }
            java.lang.String r3 = "starting profile request using - 2.5-16 with options "
            r2.append(r3)     // Catch:{ InterruptedException -> 0x015f }
            r2.append(r9)     // Catch:{ InterruptedException -> 0x015f }
            java.lang.String r2 = r2.toString()     // Catch:{ InterruptedException -> 0x015f }
            android.util.Log.d(r1, r2)     // Catch:{ InterruptedException -> 0x015f }
            boolean r1 = r4.j     // Catch:{ InterruptedException -> 0x015f }
            if (r1 == 0) goto L_0x002d
            com.threatmetrix.TrustDefenderMobile.aa$b r5 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_NotYet     // Catch:{ InterruptedException -> 0x015f }
        L_0x0027:
            java.util.concurrent.locks.Lock r6 = r4.f32528f
            r6.unlock()
            return r5
        L_0x002d:
            com.threatmetrix.TrustDefenderMobile.ab r1 = r4.f32523a     // Catch:{ InterruptedException -> 0x015f }
            boolean r1 = r1.a((int) r9)     // Catch:{ InterruptedException -> 0x015f }
            if (r1 != 0) goto L_0x0038
            com.threatmetrix.TrustDefenderMobile.aa$b r5 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_Internal_Error     // Catch:{ InterruptedException -> 0x015f }
            goto L_0x0027
        L_0x0038:
            r4.n = r9     // Catch:{ InterruptedException -> 0x015f }
            r4.c()     // Catch:{ InterruptedException -> 0x015f }
            com.threatmetrix.TrustDefenderMobile.ab r9 = r4.f32523a     // Catch:{ InterruptedException -> 0x015f }
            java.util.concurrent.atomic.AtomicBoolean r1 = r4.k     // Catch:{ InterruptedException -> 0x015f }
            r9.a((java.util.concurrent.atomic.AtomicBoolean) r1)     // Catch:{ InterruptedException -> 0x015f }
            java.util.concurrent.atomic.AtomicBoolean r9 = r4.k     // Catch:{ InterruptedException -> 0x015f }
            r9.set(r0)     // Catch:{ InterruptedException -> 0x015f }
            com.threatmetrix.TrustDefenderMobile.ab r9 = r4.f32523a     // Catch:{ InterruptedException -> 0x015f }
            com.threatmetrix.TrustDefenderMobile.aa$b r1 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_NotYet     // Catch:{ InterruptedException -> 0x015f }
            com.threatmetrix.TrustDefenderMobile.k r1 = r1.a()     // Catch:{ InterruptedException -> 0x015f }
            r9.a((com.threatmetrix.TrustDefenderMobile.k) r1)     // Catch:{ InterruptedException -> 0x015f }
            java.util.ArrayList<com.threatmetrix.TrustDefenderMobile.n> r9 = r4.f32525c     // Catch:{ InterruptedException -> 0x015f }
            int r9 = r9.size()     // Catch:{ InterruptedException -> 0x015f }
            r1 = 1
            if (r9 <= 0) goto L_0x0067
            java.lang.String r9 = w     // Catch:{ InterruptedException -> 0x015f }
            java.lang.String r2 = "outstanding requests... interrupting"
            android.util.Log.d(r9, r2)     // Catch:{ InterruptedException -> 0x015f }
            r4.b((boolean) r1)     // Catch:{ InterruptedException -> 0x015f }
        L_0x0067:
            java.util.ArrayList<com.threatmetrix.TrustDefenderMobile.n> r9 = r4.f32525c     // Catch:{ InterruptedException -> 0x015f }
            r9.clear()     // Catch:{ InterruptedException -> 0x015f }
            com.threatmetrix.TrustDefenderMobile.ab r9 = r4.f32523a     // Catch:{ InterruptedException -> 0x015f }
            boolean r7 = r9.b(r7)     // Catch:{ InterruptedException -> 0x015f }
            if (r7 != 0) goto L_0x0077
            com.threatmetrix.TrustDefenderMobile.aa$b r5 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_ConfigurationError     // Catch:{ InterruptedException -> 0x015f }
            goto L_0x0027
        L_0x0077:
            com.threatmetrix.TrustDefenderMobile.ab r7 = r4.f32523a     // Catch:{ InterruptedException -> 0x015f }
            boolean r6 = r7.c(r6)     // Catch:{ InterruptedException -> 0x015f }
            if (r6 != 0) goto L_0x008b
            android.util.TimingLogger r5 = r4.v     // Catch:{ InterruptedException -> 0x015f }
            if (r5 == 0) goto L_0x0088
            android.util.TimingLogger r5 = r4.v     // Catch:{ InterruptedException -> 0x015f }
            r5.dumpToLog()     // Catch:{ InterruptedException -> 0x015f }
        L_0x0088:
            com.threatmetrix.TrustDefenderMobile.aa$b r5 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_InvalidOrgID     // Catch:{ InterruptedException -> 0x015f }
            goto L_0x0027
        L_0x008b:
            r4.j = r1     // Catch:{ InterruptedException -> 0x015f }
            boolean r6 = r4.o     // Catch:{ InterruptedException -> 0x015f }
            if (r6 != 0) goto L_0x0099
            com.threatmetrix.TrustDefenderMobile.ab r6 = r4.f32523a     // Catch:{ InterruptedException -> 0x015f }
            java.lang.String r6 = r6.b()     // Catch:{ InterruptedException -> 0x015f }
            if (r6 != 0) goto L_0x00a2
        L_0x0099:
            com.threatmetrix.TrustDefenderMobile.ab r6 = r4.f32523a     // Catch:{ InterruptedException -> 0x015f }
            java.lang.String r7 = com.threatmetrix.TrustDefenderMobile.v.a()     // Catch:{ InterruptedException -> 0x015f }
            r6.a((java.lang.String) r7)     // Catch:{ InterruptedException -> 0x015f }
        L_0x00a2:
            boolean r6 = r4.p     // Catch:{ InterruptedException -> 0x015f }
            if (r6 == 0) goto L_0x00b1
            boolean r6 = r4.o     // Catch:{ InterruptedException -> 0x015f }
            if (r6 == 0) goto L_0x00b1
            java.lang.String r6 = w     // Catch:{ InterruptedException -> 0x015f }
            java.lang.String r7 = "Previous profile used manually specified session ID, but generated session ID used this time. This is likely a bug, make sure setSessionID() is called before every profile"
            android.util.Log.w(r6, r7)     // Catch:{ InterruptedException -> 0x015f }
        L_0x00b1:
            r4.o = r1     // Catch:{ InterruptedException -> 0x015f }
            android.content.Context r5 = r5.getApplicationContext()     // Catch:{ InterruptedException -> 0x015f }
            r4.u = r5     // Catch:{ InterruptedException -> 0x015f }
            com.threatmetrix.TrustDefenderMobile.ab r5 = r4.f32523a     // Catch:{ InterruptedException -> 0x015f }
            android.content.Context r6 = r4.u     // Catch:{ InterruptedException -> 0x015f }
            r5.a((android.content.Context) r6)     // Catch:{ InterruptedException -> 0x015f }
            android.content.Context r5 = r4.u     // Catch:{ InterruptedException -> 0x015f }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ InterruptedException -> 0x015f }
            com.threatmetrix.TrustDefenderMobile.ab r6 = r4.f32523a     // Catch:{ InterruptedException -> 0x015f }
            r6.a(r8, r5)     // Catch:{ InterruptedException -> 0x015f }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x015f }
            r6.<init>()     // Catch:{ InterruptedException -> 0x015f }
            r6.append(r5)     // Catch:{ InterruptedException -> 0x015f }
            java.lang.String r5 = "TDM"
            r6.append(r5)     // Catch:{ InterruptedException -> 0x015f }
            java.lang.String r5 = r6.toString()     // Catch:{ InterruptedException -> 0x015f }
            r4.l = r0     // Catch:{ InterruptedException -> 0x015f }
            android.content.Context r6 = r4.u     // Catch:{ InterruptedException -> 0x015f }
            android.content.SharedPreferences r5 = r6.getSharedPreferences(r5, r0)     // Catch:{ InterruptedException -> 0x015f }
            java.lang.String r6 = "options"
            int r5 = r5.getInt(r6, r0)     // Catch:{ ClassCastException -> 0x00ed }
            r4.l = r5     // Catch:{ ClassCastException -> 0x00ed }
            goto L_0x00f5
        L_0x00ed:
            r5 = move-exception
            java.lang.String r6 = w     // Catch:{ InterruptedException -> 0x015f }
            java.lang.String r7 = "Found preference of different type"
            android.util.Log.d(r6, r7, r5)     // Catch:{ InterruptedException -> 0x015f }
        L_0x00f5:
            java.util.concurrent.atomic.AtomicBoolean r5 = r4.k     // Catch:{ InterruptedException -> 0x015f }
            boolean r5 = r5.get()     // Catch:{ InterruptedException -> 0x015f }
            if (r5 != 0) goto L_0x0157
            java.lang.String r5 = w     // Catch:{ InterruptedException -> 0x015f }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x015f }
            r6.<init>()     // Catch:{ InterruptedException -> 0x015f }
            java.lang.String r7 = "applying inverted saved options - "
            r6.append(r7)     // Catch:{ InterruptedException -> 0x015f }
            int r7 = r4.l     // Catch:{ InterruptedException -> 0x015f }
            r6.append(r7)     // Catch:{ InterruptedException -> 0x015f }
            java.lang.String r7 = " with options, resulting in  "
            r6.append(r7)     // Catch:{ InterruptedException -> 0x015f }
            int r7 = r4.n     // Catch:{ InterruptedException -> 0x015f }
            r6.append(r7)     // Catch:{ InterruptedException -> 0x015f }
            java.lang.String r6 = r6.toString()     // Catch:{ InterruptedException -> 0x015f }
            android.util.Log.d(r5, r6)     // Catch:{ InterruptedException -> 0x015f }
            int r5 = r4.n     // Catch:{ InterruptedException -> 0x015f }
            int r6 = r4.l     // Catch:{ InterruptedException -> 0x015f }
            r6 = r6 & 38
            r5 = r5 ^ r6
            int r6 = r4.l     // Catch:{ InterruptedException -> 0x015f }
            r6 = r6 & 768(0x300, float:1.076E-42)
            r5 = r5 | r6
            r4.n = r5     // Catch:{ InterruptedException -> 0x015f }
            int r5 = r4.n     // Catch:{ InterruptedException -> 0x015f }
            r5 = r5 & r1
            if (r5 != 0) goto L_0x0141
            r4.b()     // Catch:{ InterruptedException -> 0x015f }
            com.threatmetrix.TrustDefenderMobile.ab r5 = r4.f32523a     // Catch:{ InterruptedException -> 0x015f }
            com.threatmetrix.TrustDefenderMobile.k r5 = r5.c()     // Catch:{ InterruptedException -> 0x015f }
            com.threatmetrix.TrustDefenderMobile.aa$b r5 = com.threatmetrix.TrustDefenderMobile.aa.b.a(r5)     // Catch:{ InterruptedException -> 0x015f }
            goto L_0x0027
        L_0x0141:
            java.lang.Thread r5 = new java.lang.Thread     // Catch:{ InterruptedException -> 0x015f }
            com.threatmetrix.TrustDefenderMobile.d r6 = new com.threatmetrix.TrustDefenderMobile.d     // Catch:{ InterruptedException -> 0x015f }
            r7 = 0
            r6.<init>(r4, r7)     // Catch:{ InterruptedException -> 0x015f }
            r5.<init>(r6)     // Catch:{ InterruptedException -> 0x015f }
            r4.i = r5     // Catch:{ InterruptedException -> 0x015f }
            java.lang.Thread r5 = r4.i     // Catch:{ InterruptedException -> 0x015f }
            r5.start()     // Catch:{ InterruptedException -> 0x015f }
            com.threatmetrix.TrustDefenderMobile.aa$b r5 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_OK     // Catch:{ InterruptedException -> 0x015f }
            goto L_0x0027
        L_0x0157:
            java.lang.InterruptedException r5 = new java.lang.InterruptedException     // Catch:{ InterruptedException -> 0x015f }
            r5.<init>()     // Catch:{ InterruptedException -> 0x015f }
            throw r5     // Catch:{ InterruptedException -> 0x015f }
        L_0x015d:
            r5 = move-exception
            goto L_0x016e
        L_0x015f:
            java.lang.Thread r5 = r4.i     // Catch:{ all -> 0x015d }
            if (r5 == 0) goto L_0x0168
            java.lang.Thread r5 = r4.i     // Catch:{ all -> 0x015d }
            r5.interrupt()     // Catch:{ all -> 0x015d }
        L_0x0168:
            r4.j = r0     // Catch:{ all -> 0x015d }
            com.threatmetrix.TrustDefenderMobile.aa$b r5 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_Interrupted_Error     // Catch:{ all -> 0x015d }
            goto L_0x0027
        L_0x016e:
            java.util.concurrent.locks.Lock r6 = r4.f32528f
            r6.unlock()
            goto L_0x0175
        L_0x0174:
            throw r5
        L_0x0175:
            goto L_0x0174
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefenderMobile.aa.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, int):com.threatmetrix.TrustDefenderMobile.aa$b");
    }

    private boolean e() {
        if (!this.q.get()) {
            return true;
        }
        Log.d(w, "Waiting for init to complete");
        boolean z = false;
        try {
            z = this.r.await((long) this.m, TimeUnit.MILLISECONDS);
            if (!z) {
                Log.e(w, "Timed out waiting for init to complete");
            }
        } catch (InterruptedException e2) {
            Log.e(w, "Waiting for init to complete interrupted", e2);
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        this.f32523a.a(bVar.a());
    }

    private n a(Runnable runnable) {
        if (runnable == null || this.k.get()) {
            return null;
        }
        try {
            n nVar = new n(runnable);
            if (runnable instanceof i) {
                this.f32528f.lock();
                this.f32525c.add(nVar);
                this.f32528f.unlock();
            }
            nVar.start();
            return nVar;
        } catch (RuntimeException e2) {
            Log.v(w, "Failed to create network request", e2);
            return null;
        } catch (Throwable th) {
            this.f32528f.unlock();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public g a() {
        g gVar = new g(this.f32524b, this.f32523a.g(), this.f32523a.h(), this.f32523a.j(), this);
        if (a((Runnable) gVar) != null) {
            return gVar;
        }
        return null;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        b(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ae, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bb A[Catch:{ all -> 0x00dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.threatmetrix.TrustDefenderMobile.aa.b a(boolean r10) throws java.lang.InterruptedException {
        /*
            r9 = this;
            java.lang.String r0 = "wait for network threads"
            com.threatmetrix.TrustDefenderMobile.aa$b r1 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_NotYet
            java.util.concurrent.locks.Lock r2 = r9.f32527e     // Catch:{ all -> 0x00dd }
            r2.lockInterruptibly()     // Catch:{ all -> 0x00dd }
            java.util.ArrayList<com.threatmetrix.TrustDefenderMobile.n> r2 = r9.f32525c     // Catch:{ all -> 0x00dd }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00dd }
        L_0x000f:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x00dd }
            if (r3 == 0) goto L_0x00ca
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x00dd }
            com.threatmetrix.TrustDefenderMobile.n r3 = (com.threatmetrix.TrustDefenderMobile.n) r3     // Catch:{ all -> 0x00dd }
            java.util.concurrent.atomic.AtomicBoolean r4 = r9.k     // Catch:{ all -> 0x00dd }
            boolean r4 = r4.get()     // Catch:{ all -> 0x00dd }
            if (r4 != 0) goto L_0x00c8
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x00dd }
            boolean r4 = r4.isInterrupted()     // Catch:{ all -> 0x00dd }
            if (r4 == 0) goto L_0x002f
            goto L_0x00c8
        L_0x002f:
            r4 = 1
            int r5 = r9.m     // Catch:{ InterruptedException -> 0x00b6 }
            long r5 = (long) r5     // Catch:{ InterruptedException -> 0x00b6 }
            r3.join(r5)     // Catch:{ InterruptedException -> 0x00b6 }
            java.lang.Thread$State r5 = r3.getState()     // Catch:{ InterruptedException -> 0x00b6 }
            java.lang.Thread$State r6 = java.lang.Thread.State.TERMINATED     // Catch:{ InterruptedException -> 0x00b6 }
            if (r5 == r6) goto L_0x004b
            com.threatmetrix.TrustDefenderMobile.aa$b r1 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_Connection_Error     // Catch:{ InterruptedException -> 0x00b6 }
            if (r10 != 0) goto L_0x0047
            r9.b((boolean) r4)     // Catch:{ InterruptedException -> 0x00b6 }
            goto L_0x00ca
        L_0x0047:
            r9.a((java.lang.Thread) r3)     // Catch:{ InterruptedException -> 0x00b6 }
            goto L_0x000f
        L_0x004b:
            com.threatmetrix.TrustDefenderMobile.i r5 = r3.a()     // Catch:{ InterruptedException -> 0x00b6 }
            if (r5 == 0) goto L_0x000f
            com.threatmetrix.TrustDefenderMobile.i r3 = r3.a()     // Catch:{ InterruptedException -> 0x00b6 }
            com.threatmetrix.TrustDefenderMobile.aa$b r3 = r3.a()     // Catch:{ InterruptedException -> 0x00b6 }
            com.threatmetrix.TrustDefenderMobile.aa$b r6 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_OK     // Catch:{ InterruptedException -> 0x00b6 }
            if (r3 != r6) goto L_0x0087
            int r6 = r5.b()     // Catch:{ InterruptedException -> 0x00b6 }
            r7 = 200(0xc8, float:2.8E-43)
            if (r6 == r7) goto L_0x0087
            java.lang.String r3 = w     // Catch:{ InterruptedException -> 0x00b6 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x00b6 }
            r6.<init>()     // Catch:{ InterruptedException -> 0x00b6 }
            java.lang.String r7 = "Connection returned http status code:"
            r6.append(r7)     // Catch:{ InterruptedException -> 0x00b6 }
            int r5 = r5.b()     // Catch:{ InterruptedException -> 0x00b6 }
            r6.append(r5)     // Catch:{ InterruptedException -> 0x00b6 }
            java.lang.String r5 = r6.toString()     // Catch:{ InterruptedException -> 0x00b6 }
            android.util.Log.d(r3, r5)     // Catch:{ InterruptedException -> 0x00b6 }
            com.threatmetrix.TrustDefenderMobile.aa$b r1 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_Connection_Error     // Catch:{ InterruptedException -> 0x00b6 }
            if (r10 != 0) goto L_0x000f
            r9.b((boolean) r4)     // Catch:{ InterruptedException -> 0x00b6 }
            goto L_0x00ca
        L_0x0087:
            com.threatmetrix.TrustDefenderMobile.aa$b r6 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_OK     // Catch:{ InterruptedException -> 0x00b6 }
            if (r3 == r6) goto L_0x000f
            java.lang.String r6 = w     // Catch:{ InterruptedException -> 0x00b6 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x00b6 }
            r7.<init>()     // Catch:{ InterruptedException -> 0x00b6 }
            java.lang.String r8 = "Connection returned status :"
            r7.append(r8)     // Catch:{ InterruptedException -> 0x00b6 }
            com.threatmetrix.TrustDefenderMobile.aa$b r5 = r5.a()     // Catch:{ InterruptedException -> 0x00b6 }
            java.lang.String r5 = r5.getDesc()     // Catch:{ InterruptedException -> 0x00b6 }
            r7.append(r5)     // Catch:{ InterruptedException -> 0x00b6 }
            java.lang.String r5 = r7.toString()     // Catch:{ InterruptedException -> 0x00b6 }
            android.util.Log.d(r6, r5)     // Catch:{ InterruptedException -> 0x00b6 }
            if (r10 != 0) goto L_0x00b3
            r9.b((boolean) r4)     // Catch:{ InterruptedException -> 0x00b0 }
            r1 = r3
            goto L_0x00ca
        L_0x00b0:
            r10 = move-exception
            r1 = r3
            goto L_0x00b7
        L_0x00b3:
            r1 = r3
            goto L_0x000f
        L_0x00b6:
            r10 = move-exception
        L_0x00b7:
            com.threatmetrix.TrustDefenderMobile.aa$b r2 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_NotYet     // Catch:{ all -> 0x00dd }
            if (r1 != r2) goto L_0x00bd
            com.threatmetrix.TrustDefenderMobile.aa$b r1 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_Connection_Error     // Catch:{ all -> 0x00dd }
        L_0x00bd:
            r9.b((boolean) r4)     // Catch:{ all -> 0x00dd }
            java.lang.String r2 = w     // Catch:{ all -> 0x00dd }
            java.lang.String r3 = "thread join"
            android.util.Log.d(r2, r3, r10)     // Catch:{ all -> 0x00dd }
            goto L_0x00ca
        L_0x00c8:
            com.threatmetrix.TrustDefenderMobile.aa$b r1 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_Interrupted_Error     // Catch:{ all -> 0x00dd }
        L_0x00ca:
            android.util.TimingLogger r10 = r9.v
            if (r10 == 0) goto L_0x00d1
            r10.addSplit(r0)
        L_0x00d1:
            java.util.concurrent.locks.Lock r10 = r9.f32527e
            r10.unlock()
            com.threatmetrix.TrustDefenderMobile.aa$b r10 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_NotYet
            if (r1 != r10) goto L_0x00dc
            com.threatmetrix.TrustDefenderMobile.aa$b r1 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_OK
        L_0x00dc:
            return r1
        L_0x00dd:
            r10 = move-exception
            android.util.TimingLogger r1 = r9.v
            if (r1 == 0) goto L_0x00e5
            r1.addSplit(r0)
        L_0x00e5:
            java.util.concurrent.locks.Lock r0 = r9.f32527e
            r0.unlock()
            goto L_0x00ec
        L_0x00eb:
            throw r10
        L_0x00ec:
            goto L_0x00eb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefenderMobile.aa.a(boolean):com.threatmetrix.TrustDefenderMobile.aa$b");
    }

    private void f() throws InterruptedException {
        try {
            this.f32528f.lockInterruptibly();
            this.f32525c.clear();
        } finally {
            this.f32528f.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z) {
        if (!z) {
            try {
                this.f32527e.lock();
            } catch (Throwable th) {
                if (!z) {
                    this.f32527e.unlock();
                }
                throw th;
            }
        }
        Iterator<n> it = this.f32525c.iterator();
        while (it.hasNext()) {
            a((Thread) it.next());
        }
        if (!z) {
            this.f32527e.unlock();
        }
    }

    final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final Thread f32533a;

        a(Thread thread) {
            this.f32533a = thread;
        }

        public void run() {
            String d2 = aa.w;
            Log.d(d2, "sending interrupt to TID: " + this.f32533a.getId());
            this.f32533a.interrupt();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Thread thread) {
        x.execute(new a(thread));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0314, code lost:
        if (r13.f32529g.isHeldByCurrentThread() != false) goto L_0x0316;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0316, code lost:
        r13.f32529g.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x032a, code lost:
        if (r13.f32529g.isHeldByCurrentThread() == false) goto L_0x032d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x032d, code lost:
        r13.j = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x032f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x04c3, code lost:
        if (r13.f32529g.isHeldByCurrentThread() != false) goto L_0x05e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x04d5, code lost:
        if (r13.f32529g.isHeldByCurrentThread() == false) goto L_0x05f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x055e, code lost:
        if (r13.f32529g.isHeldByCurrentThread() == false) goto L_0x05f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x0570, code lost:
        if (r13.f32529g.isHeldByCurrentThread() == false) goto L_0x05f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x05de, code lost:
        if (r13.f32529g.isHeldByCurrentThread() == false) goto L_0x05f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x05e0, code lost:
        r13.f32529g.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x05f4, code lost:
        if (r13.f32529g.isHeldByCurrentThread() == false) goto L_0x05f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x05f7, code lost:
        r13.j = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x05f9, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:280:0x0652, code lost:
        if (r13.f32529g.isHeldByCurrentThread() == false) goto L_0x066b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x0654, code lost:
        r13.f32529g.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x0668, code lost:
        if (r13.f32529g.isHeldByCurrentThread() == false) goto L_0x066b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x066b, code lost:
        r13.j = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x066d, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c3, code lost:
        if (r13.f32529g.isHeldByCurrentThread() != false) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c5, code lost:
        r13.f32529g.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d9, code lost:
        if (r13.f32529g.isHeldByCurrentThread() == false) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00dc, code lost:
        r13.j = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00de, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0189, code lost:
        if (r13.f32529g.isHeldByCurrentThread() != false) goto L_0x018b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x018b, code lost:
        r13.f32529g.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x019f, code lost:
        if (r13.f32529g.isHeldByCurrentThread() == false) goto L_0x01a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01a2, code lost:
        r13.j = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01a4, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r13 = this;
            java.lang.String r0 = "profileNotify callback interrupted"
            r1 = 0
            java.lang.String r2 = w     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r3.<init>()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r4 = "continuing profile request "
            r3.append(r4)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.util.concurrent.atomic.AtomicBoolean r4 = r13.q     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            boolean r4 = r4.get()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            if (r4 == 0) goto L_0x001a
            java.lang.String r4 = "inited already"
            goto L_0x001c
        L_0x001a:
            java.lang.String r4 = " needs init"
        L_0x001c:
            r3.append(r4)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r3 = r3.toString()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            android.util.Log.d(r2, r3)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            android.util.TimingLogger r2 = r13.v     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            if (r2 == 0) goto L_0x0031
            android.util.TimingLogger r2 = r13.v     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r3 = "after startup and thread split"
            r2.addSplit(r3)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
        L_0x0031:
            java.util.concurrent.atomic.AtomicBoolean r2 = r13.k     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            boolean r2 = r2.get()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            if (r2 != 0) goto L_0x04f8
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            boolean r2 = r2.isInterrupted()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            if (r2 != 0) goto L_0x04f8
            java.util.concurrent.atomic.AtomicBoolean r2 = r13.q     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            boolean r2 = r2.get()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r3 = 1
            if (r2 != 0) goto L_0x0061
            java.lang.String r2 = w     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r4 = "Calling init"
            android.util.Log.d(r2, r4)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            android.content.Context r2 = r13.u     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            int r4 = r13.n     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r4 = r4 & 38
            if (r4 == 0) goto L_0x005d
            r4 = 1
            goto L_0x005e
        L_0x005d:
            r4 = 0
        L_0x005e:
            r13.a(r2, r4)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
        L_0x0061:
            boolean r2 = r13.e()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            if (r2 != 0) goto L_0x00ed
            java.lang.String r2 = w     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r3 = "Timed out waiting for init thread, aborting"
            android.util.Log.e(r2, r3)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.ab r2 = r13.f32523a     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.aa$b r3 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_Internal_Error     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.k r3 = r3.a()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r2.a((com.threatmetrix.TrustDefenderMobile.k) r3)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.util.concurrent.atomic.AtomicBoolean r2 = r13.k
            boolean r2 = r2.get()
            if (r2 == 0) goto L_0x008f
            com.threatmetrix.TrustDefenderMobile.ab r2 = r13.f32523a
            com.threatmetrix.TrustDefenderMobile.aa$b r3 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_Interrupted_Error
            com.threatmetrix.TrustDefenderMobile.k r3 = r3.a()
            r2.a((com.threatmetrix.TrustDefenderMobile.k) r3)
            java.lang.Thread.interrupted()
        L_0x008f:
            java.util.concurrent.locks.ReentrantLock r2 = r13.f32529g     // Catch:{ InterruptedException -> 0x00cd }
            r2.lockInterruptibly()     // Catch:{ InterruptedException -> 0x00cd }
            com.threatmetrix.TrustDefenderMobile.p r2 = r13.h     // Catch:{ InterruptedException -> 0x00cd }
            if (r2 == 0) goto L_0x00bd
            com.threatmetrix.TrustDefenderMobile.p r2 = r13.h     // Catch:{ InterruptedException -> 0x00cd }
            boolean r2 = r2 instanceof com.threatmetrix.TrustDefenderMobile.o     // Catch:{ InterruptedException -> 0x00cd }
            if (r2 == 0) goto L_0x00a6
            com.threatmetrix.TrustDefenderMobile.p r2 = r13.h     // Catch:{ InterruptedException -> 0x00cd }
            com.threatmetrix.TrustDefenderMobile.o r2 = (com.threatmetrix.TrustDefenderMobile.o) r2     // Catch:{ InterruptedException -> 0x00cd }
            r2.a()     // Catch:{ InterruptedException -> 0x00cd }
            goto L_0x00bd
        L_0x00a6:
            com.threatmetrix.TrustDefenderMobile.p r2 = r13.h     // Catch:{ InterruptedException -> 0x00cd }
            boolean r2 = r2 instanceof com.threatmetrix.TrustDefenderMobile.q     // Catch:{ InterruptedException -> 0x00cd }
            if (r2 == 0) goto L_0x00bd
            com.threatmetrix.TrustDefenderMobile.p r2 = r13.h     // Catch:{ InterruptedException -> 0x00cd }
            com.threatmetrix.TrustDefenderMobile.q r2 = (com.threatmetrix.TrustDefenderMobile.q) r2     // Catch:{ InterruptedException -> 0x00cd }
            com.threatmetrix.TrustDefenderMobile.ab r3 = r13.f32523a     // Catch:{ InterruptedException -> 0x00cd }
            com.threatmetrix.TrustDefenderMobile.k r3 = r3.c()     // Catch:{ InterruptedException -> 0x00cd }
            com.threatmetrix.TrustDefenderMobile.aa$b r3 = com.threatmetrix.TrustDefenderMobile.aa.b.a(r3)     // Catch:{ InterruptedException -> 0x00cd }
            r2.a(r3)     // Catch:{ InterruptedException -> 0x00cd }
        L_0x00bd:
            java.util.concurrent.locks.ReentrantLock r0 = r13.f32529g
            boolean r0 = r0.isHeldByCurrentThread()
            if (r0 == 0) goto L_0x00dc
        L_0x00c5:
            java.util.concurrent.locks.ReentrantLock r0 = r13.f32529g
            r0.unlock()
            goto L_0x00dc
        L_0x00cb:
            r0 = move-exception
            goto L_0x00df
        L_0x00cd:
            r2 = move-exception
            java.lang.String r3 = w     // Catch:{ all -> 0x00cb }
            android.util.Log.e(r3, r0, r2)     // Catch:{ all -> 0x00cb }
            java.util.concurrent.locks.ReentrantLock r0 = r13.f32529g
            boolean r0 = r0.isHeldByCurrentThread()
            if (r0 == 0) goto L_0x00dc
            goto L_0x00c5
        L_0x00dc:
            r13.j = r1
            return
        L_0x00df:
            java.util.concurrent.locks.ReentrantLock r1 = r13.f32529g
            boolean r1 = r1.isHeldByCurrentThread()
            if (r1 == 0) goto L_0x00ec
            java.util.concurrent.locks.ReentrantLock r1 = r13.f32529g
            r1.unlock()
        L_0x00ec:
            throw r0
        L_0x00ed:
            com.threatmetrix.TrustDefenderMobile.c r2 = r13.t     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            android.content.Context r4 = r13.u     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            int r5 = r13.n     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r5 = r5 & 38
            if (r5 == 0) goto L_0x00f9
            r5 = 1
            goto L_0x00fa
        L_0x00f9:
            r5 = 0
        L_0x00fa:
            int r6 = r13.n     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r2.a((android.content.Context) r4, (boolean) r5, (int) r6)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            android.util.TimingLogger r2 = r13.v     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            if (r2 == 0) goto L_0x010a
            android.util.TimingLogger r2 = r13.v     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r4 = "initJSExecutor"
            r2.addSplit(r4)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
        L_0x010a:
            java.util.concurrent.atomic.AtomicBoolean r2 = r13.k     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            boolean r2 = r2.get()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            if (r2 != 0) goto L_0x04f2
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            boolean r2 = r2.isInterrupted()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            if (r2 != 0) goto L_0x04f2
            com.threatmetrix.TrustDefenderMobile.g r2 = r13.a()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            android.util.TimingLogger r4 = r13.v     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            if (r4 == 0) goto L_0x012b
            android.util.TimingLogger r4 = r13.v     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r5 = "get Config"
            r4.addSplit(r5)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
        L_0x012b:
            if (r2 != 0) goto L_0x01b3
            java.lang.String r2 = w     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r3 = "Failed to connect to server, aborting"
            android.util.Log.e(r2, r3)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.ab r2 = r13.f32523a     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.aa$b r3 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_Internal_Error     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.k r3 = r3.a()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r2.a((com.threatmetrix.TrustDefenderMobile.k) r3)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.util.concurrent.atomic.AtomicBoolean r2 = r13.k
            boolean r2 = r2.get()
            if (r2 == 0) goto L_0x0155
            com.threatmetrix.TrustDefenderMobile.ab r2 = r13.f32523a
            com.threatmetrix.TrustDefenderMobile.aa$b r3 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_Interrupted_Error
            com.threatmetrix.TrustDefenderMobile.k r3 = r3.a()
            r2.a((com.threatmetrix.TrustDefenderMobile.k) r3)
            java.lang.Thread.interrupted()
        L_0x0155:
            java.util.concurrent.locks.ReentrantLock r2 = r13.f32529g     // Catch:{ InterruptedException -> 0x0193 }
            r2.lockInterruptibly()     // Catch:{ InterruptedException -> 0x0193 }
            com.threatmetrix.TrustDefenderMobile.p r2 = r13.h     // Catch:{ InterruptedException -> 0x0193 }
            if (r2 == 0) goto L_0x0183
            com.threatmetrix.TrustDefenderMobile.p r2 = r13.h     // Catch:{ InterruptedException -> 0x0193 }
            boolean r2 = r2 instanceof com.threatmetrix.TrustDefenderMobile.o     // Catch:{ InterruptedException -> 0x0193 }
            if (r2 == 0) goto L_0x016c
            com.threatmetrix.TrustDefenderMobile.p r2 = r13.h     // Catch:{ InterruptedException -> 0x0193 }
            com.threatmetrix.TrustDefenderMobile.o r2 = (com.threatmetrix.TrustDefenderMobile.o) r2     // Catch:{ InterruptedException -> 0x0193 }
            r2.a()     // Catch:{ InterruptedException -> 0x0193 }
            goto L_0x0183
        L_0x016c:
            com.threatmetrix.TrustDefenderMobile.p r2 = r13.h     // Catch:{ InterruptedException -> 0x0193 }
            boolean r2 = r2 instanceof com.threatmetrix.TrustDefenderMobile.q     // Catch:{ InterruptedException -> 0x0193 }
            if (r2 == 0) goto L_0x0183
            com.threatmetrix.TrustDefenderMobile.p r2 = r13.h     // Catch:{ InterruptedException -> 0x0193 }
            com.threatmetrix.TrustDefenderMobile.q r2 = (com.threatmetrix.TrustDefenderMobile.q) r2     // Catch:{ InterruptedException -> 0x0193 }
            com.threatmetrix.TrustDefenderMobile.ab r3 = r13.f32523a     // Catch:{ InterruptedException -> 0x0193 }
            com.threatmetrix.TrustDefenderMobile.k r3 = r3.c()     // Catch:{ InterruptedException -> 0x0193 }
            com.threatmetrix.TrustDefenderMobile.aa$b r3 = com.threatmetrix.TrustDefenderMobile.aa.b.a(r3)     // Catch:{ InterruptedException -> 0x0193 }
            r2.a(r3)     // Catch:{ InterruptedException -> 0x0193 }
        L_0x0183:
            java.util.concurrent.locks.ReentrantLock r0 = r13.f32529g
            boolean r0 = r0.isHeldByCurrentThread()
            if (r0 == 0) goto L_0x01a2
        L_0x018b:
            java.util.concurrent.locks.ReentrantLock r0 = r13.f32529g
            r0.unlock()
            goto L_0x01a2
        L_0x0191:
            r0 = move-exception
            goto L_0x01a5
        L_0x0193:
            r2 = move-exception
            java.lang.String r3 = w     // Catch:{ all -> 0x0191 }
            android.util.Log.e(r3, r0, r2)     // Catch:{ all -> 0x0191 }
            java.util.concurrent.locks.ReentrantLock r0 = r13.f32529g
            boolean r0 = r0.isHeldByCurrentThread()
            if (r0 == 0) goto L_0x01a2
            goto L_0x018b
        L_0x01a2:
            r13.j = r1
            return
        L_0x01a5:
            java.util.concurrent.locks.ReentrantLock r1 = r13.f32529g
            boolean r1 = r1.isHeldByCurrentThread()
            if (r1 == 0) goto L_0x01b2
            java.util.concurrent.locks.ReentrantLock r1 = r13.f32529g
            r1.unlock()
        L_0x01b2:
            throw r0
        L_0x01b3:
            java.util.concurrent.atomic.AtomicBoolean r4 = r13.k     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            boolean r4 = r4.get()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            if (r4 != 0) goto L_0x04ec
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            boolean r4 = r4.isInterrupted()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            if (r4 != 0) goto L_0x04ec
            com.threatmetrix.TrustDefenderMobile.c r4 = r13.t     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            boolean r4 = r4.i()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            if (r4 == 0) goto L_0x01dd
            com.threatmetrix.TrustDefenderMobile.c r5 = r13.t     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r5.j()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            android.util.TimingLogger r5 = r13.v     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            if (r5 == 0) goto L_0x01dd
            android.util.TimingLogger r5 = r13.v     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r6 = "get browser info"
            r5.addSplit(r6)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
        L_0x01dd:
            com.threatmetrix.TrustDefenderMobile.ab r5 = r13.f32523a     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r5.i()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.util.concurrent.atomic.AtomicBoolean r5 = r13.k     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            boolean r5 = r5.get()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            if (r5 != 0) goto L_0x04e6
            java.lang.Thread r5 = java.lang.Thread.currentThread()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            boolean r5 = r5.isInterrupted()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            if (r5 != 0) goto L_0x04e6
            if (r4 == 0) goto L_0x0202
            com.threatmetrix.TrustDefenderMobile.c r4 = r13.t     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r4.h()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.ab r4 = r13.f32523a     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.c r5 = r13.t     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r4.a((com.threatmetrix.TrustDefenderMobile.b) r5)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
        L_0x0202:
            android.util.TimingLogger r4 = r13.v     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            if (r4 == 0) goto L_0x020d
            android.util.TimingLogger r4 = r13.v     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r5 = "wait for browser info"
            r4.addSplit(r5)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
        L_0x020d:
            int r4 = r13.n     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r4 = r4 & 1024(0x400, float:1.435E-42)
            r5 = 64
            if (r4 == 0) goto L_0x0291
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r4.<init>()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.ab r6 = r13.f32523a     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r6 = r6.f()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r4.append(r6)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r6 = "-"
            r4.append(r6)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.ab r6 = r13.f32523a     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r6 = r6.b()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r6 = com.threatmetrix.TrustDefenderMobile.v.c(r6)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r4.append(r6)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r6 = "-mob"
            r4.append(r6)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r4 = r4.toString()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            int r6 = r4.length()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            if (r6 < r5) goto L_0x024c
            java.lang.String r4 = w     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r6 = "combined session id and org id too long for host name fragment"
            android.util.Log.w(r4, r6)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            goto L_0x0286
        L_0x024c:
            java.lang.String r6 = w     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r7 = "Launching DNS profiling request"
            android.util.Log.d(r6, r7)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r6 = "d"
            com.threatmetrix.TrustDefenderMobile.ab r7 = r13.f32523a     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r7 = r7.e()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r8 = "qa2-h.online-metrix.net"
            boolean r7 = r7.equals(r8)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            if (r7 == 0) goto L_0x0265
            java.lang.String r6 = "q"
        L_0x0265:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r7.<init>()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r7.append(r4)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r4 = "."
            r7.append(r4)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r7.append(r6)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r4 = ".aa.online-metrix.net"
            r7.append(r4)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r4 = r7.toString()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.e r6 = new com.threatmetrix.TrustDefenderMobile.e     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r6.<init>(r4)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r13.a((java.lang.Runnable) r6)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
        L_0x0286:
            android.util.TimingLogger r4 = r13.v     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            if (r4 == 0) goto L_0x0291
            android.util.TimingLogger r4 = r13.v     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r6 = "Started DNS request"
            r4.addSplit(r6)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
        L_0x0291:
            com.threatmetrix.TrustDefenderMobile.aa$b r4 = r13.a((boolean) r1)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            android.util.TimingLogger r6 = r13.v     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            if (r6 == 0) goto L_0x02a0
            android.util.TimingLogger r6 = r13.v     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r7 = "wait for config network request"
            r6.addSplit(r7)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
        L_0x02a0:
            r13.f()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.aa$b r6 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_OK     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            if (r4 == r6) goto L_0x033e
            java.lang.String r2 = w     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r3.<init>()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r5 = "Failed to retrieve config, aborting: "
            r3.append(r5)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r5 = r4.toString()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r3.append(r5)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r3 = r3.toString()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            android.util.Log.e(r2, r3)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.ab r2 = r13.f32523a     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.k r3 = r4.a()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r2.a((com.threatmetrix.TrustDefenderMobile.k) r3)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.util.concurrent.atomic.AtomicBoolean r2 = r13.k
            boolean r2 = r2.get()
            if (r2 == 0) goto L_0x02e0
            com.threatmetrix.TrustDefenderMobile.ab r2 = r13.f32523a
            com.threatmetrix.TrustDefenderMobile.aa$b r3 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_Interrupted_Error
            com.threatmetrix.TrustDefenderMobile.k r3 = r3.a()
            r2.a((com.threatmetrix.TrustDefenderMobile.k) r3)
            java.lang.Thread.interrupted()
        L_0x02e0:
            java.util.concurrent.locks.ReentrantLock r2 = r13.f32529g     // Catch:{ InterruptedException -> 0x031e }
            r2.lockInterruptibly()     // Catch:{ InterruptedException -> 0x031e }
            com.threatmetrix.TrustDefenderMobile.p r2 = r13.h     // Catch:{ InterruptedException -> 0x031e }
            if (r2 == 0) goto L_0x030e
            com.threatmetrix.TrustDefenderMobile.p r2 = r13.h     // Catch:{ InterruptedException -> 0x031e }
            boolean r2 = r2 instanceof com.threatmetrix.TrustDefenderMobile.o     // Catch:{ InterruptedException -> 0x031e }
            if (r2 == 0) goto L_0x02f7
            com.threatmetrix.TrustDefenderMobile.p r2 = r13.h     // Catch:{ InterruptedException -> 0x031e }
            com.threatmetrix.TrustDefenderMobile.o r2 = (com.threatmetrix.TrustDefenderMobile.o) r2     // Catch:{ InterruptedException -> 0x031e }
            r2.a()     // Catch:{ InterruptedException -> 0x031e }
            goto L_0x030e
        L_0x02f7:
            com.threatmetrix.TrustDefenderMobile.p r2 = r13.h     // Catch:{ InterruptedException -> 0x031e }
            boolean r2 = r2 instanceof com.threatmetrix.TrustDefenderMobile.q     // Catch:{ InterruptedException -> 0x031e }
            if (r2 == 0) goto L_0x030e
            com.threatmetrix.TrustDefenderMobile.p r2 = r13.h     // Catch:{ InterruptedException -> 0x031e }
            com.threatmetrix.TrustDefenderMobile.q r2 = (com.threatmetrix.TrustDefenderMobile.q) r2     // Catch:{ InterruptedException -> 0x031e }
            com.threatmetrix.TrustDefenderMobile.ab r3 = r13.f32523a     // Catch:{ InterruptedException -> 0x031e }
            com.threatmetrix.TrustDefenderMobile.k r3 = r3.c()     // Catch:{ InterruptedException -> 0x031e }
            com.threatmetrix.TrustDefenderMobile.aa$b r3 = com.threatmetrix.TrustDefenderMobile.aa.b.a(r3)     // Catch:{ InterruptedException -> 0x031e }
            r2.a(r3)     // Catch:{ InterruptedException -> 0x031e }
        L_0x030e:
            java.util.concurrent.locks.ReentrantLock r0 = r13.f32529g
            boolean r0 = r0.isHeldByCurrentThread()
            if (r0 == 0) goto L_0x032d
        L_0x0316:
            java.util.concurrent.locks.ReentrantLock r0 = r13.f32529g
            r0.unlock()
            goto L_0x032d
        L_0x031c:
            r0 = move-exception
            goto L_0x0330
        L_0x031e:
            r2 = move-exception
            java.lang.String r3 = w     // Catch:{ all -> 0x031c }
            android.util.Log.e(r3, r0, r2)     // Catch:{ all -> 0x031c }
            java.util.concurrent.locks.ReentrantLock r0 = r13.f32529g
            boolean r0 = r0.isHeldByCurrentThread()
            if (r0 == 0) goto L_0x032d
            goto L_0x0316
        L_0x032d:
            r13.j = r1
            return
        L_0x0330:
            java.util.concurrent.locks.ReentrantLock r1 = r13.f32529g
            boolean r1 = r1.isHeldByCurrentThread()
            if (r1 == 0) goto L_0x033d
            java.util.concurrent.locks.ReentrantLock r1 = r13.f32529g
            r1.unlock()
        L_0x033d:
            throw r0
        L_0x033e:
            com.threatmetrix.TrustDefenderMobile.ab r4 = r13.f32523a     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.w r2 = r2.f32577a     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r4.a((com.threatmetrix.TrustDefenderMobile.w) r2)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.ab r2 = r13.f32523a     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.w r2 = r2.d()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            int r2 = r2.f32627a     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            int r4 = r13.l     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            if (r2 == r4) goto L_0x03b5
            java.lang.String r2 = w     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r4.<init>()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r6 = "dynamic options ("
            r4.append(r6)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.ab r6 = r13.f32523a     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.w r6 = r6.d()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            int r6 = r6.f32627a     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r4.append(r6)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r6 = ") != saved: "
            r4.append(r6)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            int r6 = r13.l     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r4.append(r6)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r4 = r4.toString()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            android.util.Log.d(r2, r4)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r2.<init>()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            android.content.Context r4 = r13.u     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r2.append(r4)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r4 = "TDM"
            r2.append(r4)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r2 = r2.toString()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            android.content.Context r4 = r13.u     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            android.content.SharedPreferences r2 = r4.getSharedPreferences(r2, r1)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            android.content.SharedPreferences$Editor r2 = r2.edit()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r4 = "options"
            com.threatmetrix.TrustDefenderMobile.ab r6 = r13.f32523a     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.w r6 = r6.d()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            int r6 = r6.f32627a     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r2.putInt(r4, r6)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r2.apply()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            android.util.TimingLogger r2 = r13.v     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            if (r2 == 0) goto L_0x03b5
            android.util.TimingLogger r2 = r13.v     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r4 = "Processed stored options"
            r2.addSplit(r4)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
        L_0x03b5:
            com.threatmetrix.TrustDefenderMobile.ab r2 = r13.f32523a     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.z r4 = r13.s     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            android.location.Location r4 = r4.c()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r2.a((android.location.Location) r4)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.ab r2 = r13.f32523a     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.h r10 = r2.l()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.ab r2 = r13.f32523a     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.util.Map r11 = r2.k()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.i r2 = new com.threatmetrix.TrustDefenderMobile.i     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            android.net.http.AndroidHttpClient r7 = r13.f32524b     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.i$a r8 = com.threatmetrix.TrustDefenderMobile.i.a.POST_CONSUME     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r4.<init>()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r6 = "https://"
            r4.append(r6)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.ab r6 = r13.f32523a     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r6 = r6.e()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r4.append(r6)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r6 = "/fp/clear.png"
            r4.append(r6)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r9 = r4.toString()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r6 = r2
            r12 = r13
            r6.<init>(r7, r8, r9, r10, r11, r12)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r13.a((java.lang.Runnable) r2)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            int r2 = r13.n     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r2 = r2 & r5
            if (r2 == 0) goto L_0x0420
            com.threatmetrix.TrustDefenderMobile.s r2 = new com.threatmetrix.TrustDefenderMobile.s     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.ab r4 = r13.f32523a     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r5 = r4.e()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.ab r4 = r13.f32523a     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r6 = r4.f()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.ab r4 = r13.f32523a     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r7 = r4.b()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.ab r4 = r13.f32523a     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.w r4 = r4.d()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r8 = r4.f32628b     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            int r9 = r13.m     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r4 = r2
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r13.a((java.lang.Runnable) r2)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
        L_0x0420:
            android.util.TimingLogger r2 = r13.v     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            if (r2 == 0) goto L_0x042b
            android.util.TimingLogger r2 = r13.v     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r4 = "build network threads"
            r2.addSplit(r4)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
        L_0x042b:
            com.threatmetrix.TrustDefenderMobile.aa$b r2 = r13.a((boolean) r3)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.ab r3 = r13.f32523a     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.k r4 = r2.a()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r3.a((com.threatmetrix.TrustDefenderMobile.k) r4)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.aa$b r3 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_OK     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            if (r2 == r3) goto L_0x0466
            java.lang.String r3 = w     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r4.<init>()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r5 = "Received "
            r4.append(r5)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r2 = r2.getDesc()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r4.append(r2)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r2 = " error, profiling will be incomplete"
            r4.append(r2)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r2 = r4.toString()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            android.util.Log.w(r3, r2)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.ab r2 = r13.f32523a     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.aa$b r3 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_PartialProfile     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            com.threatmetrix.TrustDefenderMobile.k r3 = r3.a()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r2.a((com.threatmetrix.TrustDefenderMobile.k) r3)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
        L_0x0466:
            r13.f()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r2 = w     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            java.lang.String r3 = "profile request complete"
            android.util.Log.d(r2, r3)     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            android.util.TimingLogger r2 = r13.v     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            if (r2 == 0) goto L_0x0479
            android.util.TimingLogger r2 = r13.v     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r2.dumpToLog()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
        L_0x0479:
            java.util.concurrent.atomic.AtomicBoolean r2 = r13.k
            boolean r2 = r2.get()
            if (r2 == 0) goto L_0x048f
            com.threatmetrix.TrustDefenderMobile.ab r2 = r13.f32523a
            com.threatmetrix.TrustDefenderMobile.aa$b r3 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_Interrupted_Error
            com.threatmetrix.TrustDefenderMobile.k r3 = r3.a()
            r2.a((com.threatmetrix.TrustDefenderMobile.k) r3)
            java.lang.Thread.interrupted()
        L_0x048f:
            java.util.concurrent.locks.ReentrantLock r2 = r13.f32529g     // Catch:{ InterruptedException -> 0x04c9 }
            r2.lockInterruptibly()     // Catch:{ InterruptedException -> 0x04c9 }
            com.threatmetrix.TrustDefenderMobile.p r2 = r13.h     // Catch:{ InterruptedException -> 0x04c9 }
            if (r2 == 0) goto L_0x04bd
            com.threatmetrix.TrustDefenderMobile.p r2 = r13.h     // Catch:{ InterruptedException -> 0x04c9 }
            boolean r2 = r2 instanceof com.threatmetrix.TrustDefenderMobile.o     // Catch:{ InterruptedException -> 0x04c9 }
            if (r2 == 0) goto L_0x04a6
            com.threatmetrix.TrustDefenderMobile.p r2 = r13.h     // Catch:{ InterruptedException -> 0x04c9 }
            com.threatmetrix.TrustDefenderMobile.o r2 = (com.threatmetrix.TrustDefenderMobile.o) r2     // Catch:{ InterruptedException -> 0x04c9 }
            r2.a()     // Catch:{ InterruptedException -> 0x04c9 }
            goto L_0x04bd
        L_0x04a6:
            com.threatmetrix.TrustDefenderMobile.p r2 = r13.h     // Catch:{ InterruptedException -> 0x04c9 }
            boolean r2 = r2 instanceof com.threatmetrix.TrustDefenderMobile.q     // Catch:{ InterruptedException -> 0x04c9 }
            if (r2 == 0) goto L_0x04bd
            com.threatmetrix.TrustDefenderMobile.p r2 = r13.h     // Catch:{ InterruptedException -> 0x04c9 }
            com.threatmetrix.TrustDefenderMobile.q r2 = (com.threatmetrix.TrustDefenderMobile.q) r2     // Catch:{ InterruptedException -> 0x04c9 }
            com.threatmetrix.TrustDefenderMobile.ab r3 = r13.f32523a     // Catch:{ InterruptedException -> 0x04c9 }
            com.threatmetrix.TrustDefenderMobile.k r3 = r3.c()     // Catch:{ InterruptedException -> 0x04c9 }
            com.threatmetrix.TrustDefenderMobile.aa$b r3 = com.threatmetrix.TrustDefenderMobile.aa.b.a(r3)     // Catch:{ InterruptedException -> 0x04c9 }
            r2.a(r3)     // Catch:{ InterruptedException -> 0x04c9 }
        L_0x04bd:
            java.util.concurrent.locks.ReentrantLock r0 = r13.f32529g
            boolean r0 = r0.isHeldByCurrentThread()
            if (r0 == 0) goto L_0x05f7
        L_0x04c5:
            goto L_0x05e0
        L_0x04c7:
            r0 = move-exception
            goto L_0x04d8
        L_0x04c9:
            r2 = move-exception
            java.lang.String r3 = w     // Catch:{ all -> 0x04c7 }
            android.util.Log.e(r3, r0, r2)     // Catch:{ all -> 0x04c7 }
            java.util.concurrent.locks.ReentrantLock r0 = r13.f32529g
            boolean r0 = r0.isHeldByCurrentThread()
            if (r0 == 0) goto L_0x05f7
            goto L_0x04c5
        L_0x04d8:
            java.util.concurrent.locks.ReentrantLock r1 = r13.f32529g
            boolean r1 = r1.isHeldByCurrentThread()
            if (r1 == 0) goto L_0x04e5
            java.util.concurrent.locks.ReentrantLock r1 = r13.f32529g
            r1.unlock()
        L_0x04e5:
            throw r0
        L_0x04e6:
            java.lang.InterruptedException r2 = new java.lang.InterruptedException     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r2.<init>()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            throw r2     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
        L_0x04ec:
            java.lang.InterruptedException r2 = new java.lang.InterruptedException     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r2.<init>()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            throw r2     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
        L_0x04f2:
            java.lang.InterruptedException r2 = new java.lang.InterruptedException     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r2.<init>()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            throw r2     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
        L_0x04f8:
            java.lang.InterruptedException r2 = new java.lang.InterruptedException     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            r2.<init>()     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
            throw r2     // Catch:{ InterruptedException -> 0x0581, Exception -> 0x0501 }
        L_0x04fe:
            r2 = move-exception
            goto L_0x0608
        L_0x0501:
            r2 = move-exception
            com.threatmetrix.TrustDefenderMobile.ab r3 = r13.f32523a     // Catch:{ all -> 0x04fe }
            com.threatmetrix.TrustDefenderMobile.aa$b r4 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_Internal_Error     // Catch:{ all -> 0x04fe }
            com.threatmetrix.TrustDefenderMobile.k r4 = r4.a()     // Catch:{ all -> 0x04fe }
            r3.a((com.threatmetrix.TrustDefenderMobile.k) r4)     // Catch:{ all -> 0x04fe }
            java.lang.String r3 = w     // Catch:{ all -> 0x04fe }
            java.lang.String r4 = "profile request failed"
            android.util.Log.d(r3, r4, r2)     // Catch:{ all -> 0x04fe }
            java.util.concurrent.atomic.AtomicBoolean r2 = r13.k
            boolean r2 = r2.get()
            if (r2 == 0) goto L_0x052a
            com.threatmetrix.TrustDefenderMobile.ab r2 = r13.f32523a
            com.threatmetrix.TrustDefenderMobile.aa$b r3 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_Interrupted_Error
            com.threatmetrix.TrustDefenderMobile.k r3 = r3.a()
            r2.a((com.threatmetrix.TrustDefenderMobile.k) r3)
            java.lang.Thread.interrupted()
        L_0x052a:
            java.util.concurrent.locks.ReentrantLock r2 = r13.f32529g     // Catch:{ InterruptedException -> 0x0564 }
            r2.lockInterruptibly()     // Catch:{ InterruptedException -> 0x0564 }
            com.threatmetrix.TrustDefenderMobile.p r2 = r13.h     // Catch:{ InterruptedException -> 0x0564 }
            if (r2 == 0) goto L_0x0558
            com.threatmetrix.TrustDefenderMobile.p r2 = r13.h     // Catch:{ InterruptedException -> 0x0564 }
            boolean r2 = r2 instanceof com.threatmetrix.TrustDefenderMobile.o     // Catch:{ InterruptedException -> 0x0564 }
            if (r2 == 0) goto L_0x0541
            com.threatmetrix.TrustDefenderMobile.p r2 = r13.h     // Catch:{ InterruptedException -> 0x0564 }
            com.threatmetrix.TrustDefenderMobile.o r2 = (com.threatmetrix.TrustDefenderMobile.o) r2     // Catch:{ InterruptedException -> 0x0564 }
            r2.a()     // Catch:{ InterruptedException -> 0x0564 }
            goto L_0x0558
        L_0x0541:
            com.threatmetrix.TrustDefenderMobile.p r2 = r13.h     // Catch:{ InterruptedException -> 0x0564 }
            boolean r2 = r2 instanceof com.threatmetrix.TrustDefenderMobile.q     // Catch:{ InterruptedException -> 0x0564 }
            if (r2 == 0) goto L_0x0558
            com.threatmetrix.TrustDefenderMobile.p r2 = r13.h     // Catch:{ InterruptedException -> 0x0564 }
            com.threatmetrix.TrustDefenderMobile.q r2 = (com.threatmetrix.TrustDefenderMobile.q) r2     // Catch:{ InterruptedException -> 0x0564 }
            com.threatmetrix.TrustDefenderMobile.ab r3 = r13.f32523a     // Catch:{ InterruptedException -> 0x0564 }
            com.threatmetrix.TrustDefenderMobile.k r3 = r3.c()     // Catch:{ InterruptedException -> 0x0564 }
            com.threatmetrix.TrustDefenderMobile.aa$b r3 = com.threatmetrix.TrustDefenderMobile.aa.b.a(r3)     // Catch:{ InterruptedException -> 0x0564 }
            r2.a(r3)     // Catch:{ InterruptedException -> 0x0564 }
        L_0x0558:
            java.util.concurrent.locks.ReentrantLock r0 = r13.f32529g
            boolean r0 = r0.isHeldByCurrentThread()
            if (r0 == 0) goto L_0x05f7
        L_0x0560:
            goto L_0x05e0
        L_0x0562:
            r0 = move-exception
            goto L_0x0573
        L_0x0564:
            r2 = move-exception
            java.lang.String r3 = w     // Catch:{ all -> 0x0562 }
            android.util.Log.e(r3, r0, r2)     // Catch:{ all -> 0x0562 }
            java.util.concurrent.locks.ReentrantLock r0 = r13.f32529g
            boolean r0 = r0.isHeldByCurrentThread()
            if (r0 == 0) goto L_0x05f7
            goto L_0x0560
        L_0x0573:
            java.util.concurrent.locks.ReentrantLock r1 = r13.f32529g
            boolean r1 = r1.isHeldByCurrentThread()
            if (r1 == 0) goto L_0x0580
            java.util.concurrent.locks.ReentrantLock r1 = r13.f32529g
            r1.unlock()
        L_0x0580:
            throw r0
        L_0x0581:
            r2 = move-exception
            java.lang.String r3 = w     // Catch:{ all -> 0x04fe }
            java.lang.String r4 = "profile request interrupted"
            android.util.Log.d(r3, r4, r2)     // Catch:{ all -> 0x04fe }
            com.threatmetrix.TrustDefenderMobile.ab r2 = r13.f32523a     // Catch:{ all -> 0x04fe }
            com.threatmetrix.TrustDefenderMobile.aa$b r3 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_Internal_Error     // Catch:{ all -> 0x04fe }
            com.threatmetrix.TrustDefenderMobile.k r3 = r3.a()     // Catch:{ all -> 0x04fe }
            r2.a((com.threatmetrix.TrustDefenderMobile.k) r3)     // Catch:{ all -> 0x04fe }
            java.util.concurrent.atomic.AtomicBoolean r2 = r13.k
            boolean r2 = r2.get()
            if (r2 == 0) goto L_0x05aa
            com.threatmetrix.TrustDefenderMobile.ab r2 = r13.f32523a
            com.threatmetrix.TrustDefenderMobile.aa$b r3 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_Interrupted_Error
            com.threatmetrix.TrustDefenderMobile.k r3 = r3.a()
            r2.a((com.threatmetrix.TrustDefenderMobile.k) r3)
            java.lang.Thread.interrupted()
        L_0x05aa:
            java.util.concurrent.locks.ReentrantLock r2 = r13.f32529g     // Catch:{ InterruptedException -> 0x05e8 }
            r2.lockInterruptibly()     // Catch:{ InterruptedException -> 0x05e8 }
            com.threatmetrix.TrustDefenderMobile.p r2 = r13.h     // Catch:{ InterruptedException -> 0x05e8 }
            if (r2 == 0) goto L_0x05d8
            com.threatmetrix.TrustDefenderMobile.p r2 = r13.h     // Catch:{ InterruptedException -> 0x05e8 }
            boolean r2 = r2 instanceof com.threatmetrix.TrustDefenderMobile.o     // Catch:{ InterruptedException -> 0x05e8 }
            if (r2 == 0) goto L_0x05c1
            com.threatmetrix.TrustDefenderMobile.p r2 = r13.h     // Catch:{ InterruptedException -> 0x05e8 }
            com.threatmetrix.TrustDefenderMobile.o r2 = (com.threatmetrix.TrustDefenderMobile.o) r2     // Catch:{ InterruptedException -> 0x05e8 }
            r2.a()     // Catch:{ InterruptedException -> 0x05e8 }
            goto L_0x05d8
        L_0x05c1:
            com.threatmetrix.TrustDefenderMobile.p r2 = r13.h     // Catch:{ InterruptedException -> 0x05e8 }
            boolean r2 = r2 instanceof com.threatmetrix.TrustDefenderMobile.q     // Catch:{ InterruptedException -> 0x05e8 }
            if (r2 == 0) goto L_0x05d8
            com.threatmetrix.TrustDefenderMobile.p r2 = r13.h     // Catch:{ InterruptedException -> 0x05e8 }
            com.threatmetrix.TrustDefenderMobile.q r2 = (com.threatmetrix.TrustDefenderMobile.q) r2     // Catch:{ InterruptedException -> 0x05e8 }
            com.threatmetrix.TrustDefenderMobile.ab r3 = r13.f32523a     // Catch:{ InterruptedException -> 0x05e8 }
            com.threatmetrix.TrustDefenderMobile.k r3 = r3.c()     // Catch:{ InterruptedException -> 0x05e8 }
            com.threatmetrix.TrustDefenderMobile.aa$b r3 = com.threatmetrix.TrustDefenderMobile.aa.b.a(r3)     // Catch:{ InterruptedException -> 0x05e8 }
            r2.a(r3)     // Catch:{ InterruptedException -> 0x05e8 }
        L_0x05d8:
            java.util.concurrent.locks.ReentrantLock r0 = r13.f32529g
            boolean r0 = r0.isHeldByCurrentThread()
            if (r0 == 0) goto L_0x05f7
        L_0x05e0:
            java.util.concurrent.locks.ReentrantLock r0 = r13.f32529g
            r0.unlock()
            goto L_0x05f7
        L_0x05e6:
            r0 = move-exception
            goto L_0x05fa
        L_0x05e8:
            r2 = move-exception
            java.lang.String r3 = w     // Catch:{ all -> 0x05e6 }
            android.util.Log.e(r3, r0, r2)     // Catch:{ all -> 0x05e6 }
            java.util.concurrent.locks.ReentrantLock r0 = r13.f32529g
            boolean r0 = r0.isHeldByCurrentThread()
            if (r0 == 0) goto L_0x05f7
            goto L_0x05e0
        L_0x05f7:
            r13.j = r1
            return
        L_0x05fa:
            java.util.concurrent.locks.ReentrantLock r1 = r13.f32529g
            boolean r1 = r1.isHeldByCurrentThread()
            if (r1 == 0) goto L_0x0607
            java.util.concurrent.locks.ReentrantLock r1 = r13.f32529g
            r1.unlock()
        L_0x0607:
            throw r0
        L_0x0608:
            java.util.concurrent.atomic.AtomicBoolean r3 = r13.k
            boolean r3 = r3.get()
            if (r3 == 0) goto L_0x061e
            com.threatmetrix.TrustDefenderMobile.ab r3 = r13.f32523a
            com.threatmetrix.TrustDefenderMobile.aa$b r4 = com.threatmetrix.TrustDefenderMobile.aa.b.THM_Interrupted_Error
            com.threatmetrix.TrustDefenderMobile.k r4 = r4.a()
            r3.a((com.threatmetrix.TrustDefenderMobile.k) r4)
            java.lang.Thread.interrupted()
        L_0x061e:
            java.util.concurrent.locks.ReentrantLock r3 = r13.f32529g     // Catch:{ InterruptedException -> 0x065c }
            r3.lockInterruptibly()     // Catch:{ InterruptedException -> 0x065c }
            com.threatmetrix.TrustDefenderMobile.p r3 = r13.h     // Catch:{ InterruptedException -> 0x065c }
            if (r3 == 0) goto L_0x064c
            com.threatmetrix.TrustDefenderMobile.p r3 = r13.h     // Catch:{ InterruptedException -> 0x065c }
            boolean r3 = r3 instanceof com.threatmetrix.TrustDefenderMobile.o     // Catch:{ InterruptedException -> 0x065c }
            if (r3 == 0) goto L_0x0635
            com.threatmetrix.TrustDefenderMobile.p r3 = r13.h     // Catch:{ InterruptedException -> 0x065c }
            com.threatmetrix.TrustDefenderMobile.o r3 = (com.threatmetrix.TrustDefenderMobile.o) r3     // Catch:{ InterruptedException -> 0x065c }
            r3.a()     // Catch:{ InterruptedException -> 0x065c }
            goto L_0x064c
        L_0x0635:
            com.threatmetrix.TrustDefenderMobile.p r3 = r13.h     // Catch:{ InterruptedException -> 0x065c }
            boolean r3 = r3 instanceof com.threatmetrix.TrustDefenderMobile.q     // Catch:{ InterruptedException -> 0x065c }
            if (r3 == 0) goto L_0x064c
            com.threatmetrix.TrustDefenderMobile.p r3 = r13.h     // Catch:{ InterruptedException -> 0x065c }
            com.threatmetrix.TrustDefenderMobile.q r3 = (com.threatmetrix.TrustDefenderMobile.q) r3     // Catch:{ InterruptedException -> 0x065c }
            com.threatmetrix.TrustDefenderMobile.ab r4 = r13.f32523a     // Catch:{ InterruptedException -> 0x065c }
            com.threatmetrix.TrustDefenderMobile.k r4 = r4.c()     // Catch:{ InterruptedException -> 0x065c }
            com.threatmetrix.TrustDefenderMobile.aa$b r4 = com.threatmetrix.TrustDefenderMobile.aa.b.a(r4)     // Catch:{ InterruptedException -> 0x065c }
            r3.a(r4)     // Catch:{ InterruptedException -> 0x065c }
        L_0x064c:
            java.util.concurrent.locks.ReentrantLock r0 = r13.f32529g
            boolean r0 = r0.isHeldByCurrentThread()
            if (r0 == 0) goto L_0x066b
        L_0x0654:
            java.util.concurrent.locks.ReentrantLock r0 = r13.f32529g
            r0.unlock()
            goto L_0x066b
        L_0x065a:
            r0 = move-exception
            goto L_0x066e
        L_0x065c:
            r3 = move-exception
            java.lang.String r4 = w     // Catch:{ all -> 0x065a }
            android.util.Log.e(r4, r0, r3)     // Catch:{ all -> 0x065a }
            java.util.concurrent.locks.ReentrantLock r0 = r13.f32529g
            boolean r0 = r0.isHeldByCurrentThread()
            if (r0 == 0) goto L_0x066b
            goto L_0x0654
        L_0x066b:
            r13.j = r1
            throw r2
        L_0x066e:
            java.util.concurrent.locks.ReentrantLock r1 = r13.f32529g
            boolean r1 = r1.isHeldByCurrentThread()
            if (r1 == 0) goto L_0x067b
            java.util.concurrent.locks.ReentrantLock r1 = r13.f32529g
            r1.unlock()
        L_0x067b:
            goto L_0x067d
        L_0x067c:
            throw r0
        L_0x067d:
            goto L_0x067c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefenderMobile.aa.b():void");
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f32523a.a();
        this.s.b();
    }
}
