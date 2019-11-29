package com.beetalk.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.beetalk.sdk.b;
import com.beetalk.sdk.data.d;
import com.beetalk.sdk.e.g;
import java.util.List;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static f f5409a;

    /* renamed from: b  reason: collision with root package name */
    private static f f5410b;

    /* renamed from: c  reason: collision with root package name */
    private static Context f5411c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Handler f5412d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final List<a> f5413e;

    /* renamed from: f  reason: collision with root package name */
    private com.beetalk.sdk.a.f f5414f;

    /* renamed from: g  reason: collision with root package name */
    private m f5415g;
    private Integer h;
    private b i;
    private com.beetalk.sdk.data.a j;
    private int k;
    private int l;

    public interface a {
        void a(f fVar, Exception exc);
    }

    public static Context a() {
        return f5411c;
    }

    public static void a(Context context) {
        if (context != null && f5411c == null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            f5411c = context;
        }
    }

    public static synchronized f b() {
        f fVar;
        synchronized (f.class) {
            fVar = f5409a;
        }
        return fVar;
    }

    public static synchronized f c() {
        f fVar;
        synchronized (f.class) {
            fVar = f5410b;
        }
        return fVar;
    }

    /* access modifiers changed from: private */
    public static void b(Handler handler, Runnable runnable) {
        if (handler != null) {
            handler.post(runnable);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:13|14|15|16|(1:18)|19|20|21|22) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0015 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean d() {
        /*
            java.lang.Class<com.beetalk.sdk.f> r0 = com.beetalk.sdk.f.class
            monitor-enter(r0)
            com.beetalk.sdk.f r1 = f5409a     // Catch:{ all -> 0x004b }
            r2 = 0
            if (r1 != 0) goto L_0x000a
            monitor-exit(r0)
            return r2
        L_0x000a:
            android.content.Context r1 = f5411c     // Catch:{ all -> 0x004b }
            if (r1 != 0) goto L_0x0010
            monitor-exit(r0)
            return r2
        L_0x0010:
            android.content.Context r1 = f5411c     // Catch:{ Error -> 0x0015 }
            com.beetalk.sdk.c.a.a(r1)     // Catch:{ Error -> 0x0015 }
        L_0x0015:
            com.beetalk.sdk.f r1 = f5409a     // Catch:{ all -> 0x004b }
            r1.j()     // Catch:{ all -> 0x004b }
            r1 = 0
            f5409a = r1     // Catch:{ all -> 0x004b }
            com.beetalk.sdk.f r2 = f5410b     // Catch:{ all -> 0x004b }
            if (r2 == 0) goto L_0x0028
            com.beetalk.sdk.f r2 = f5410b     // Catch:{ all -> 0x004b }
            r2.j()     // Catch:{ all -> 0x004b }
            f5410b = r1     // Catch:{ all -> 0x004b }
        L_0x0028:
            android.os.Handler r1 = new android.os.Handler     // Catch:{ all -> 0x004b }
            android.os.Looper r2 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x004b }
            r1.<init>(r2)     // Catch:{ all -> 0x004b }
            com.beetalk.sdk.f$1 r2 = new com.beetalk.sdk.f$1     // Catch:{ all -> 0x004b }
            r2.<init>()     // Catch:{ all -> 0x004b }
            r1.post(r2)     // Catch:{ all -> 0x004b }
            com.beetalk.sdk.a.c r1 = com.beetalk.sdk.a.c.a()     // Catch:{ all -> 0x004b }
            r1.b()     // Catch:{ all -> 0x004b }
            com.beetalk.sdk.a.e r1 = new com.beetalk.sdk.a.e     // Catch:{ all -> 0x004b }
            r1.<init>()     // Catch:{ all -> 0x004b }
            r1.a()     // Catch:{ all -> 0x004b }
            r1 = 1
            monitor-exit(r0)
            return r1
        L_0x004b:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beetalk.sdk.f.d():boolean");
    }

    public m e() {
        return this.f5415g;
    }

    public Integer f() {
        return this.h;
    }

    public com.beetalk.sdk.data.a g() {
        return this.j;
    }

    public String h() {
        return g() != null ? g().a() : "";
    }

    public int i() {
        return this.k;
    }

    public void j() {
        com.beetalk.sdk.a.f fVar = this.f5414f;
        if (fVar != null) {
            fVar.c();
        }
    }

    public boolean k() {
        return com.beetalk.sdk.e.b.a() > this.j.c();
    }

    public Integer l() {
        return Integer.valueOf(m().getValue());
    }

    private void a(m mVar, m mVar2, final Exception exc) {
        synchronized (this.f5413e) {
            if (mVar != mVar2) {
                b(this.f5412d, new Runnable() {
                    public void run() {
                        for (final a aVar : f.this.f5413e) {
                            f.b(f.this.f5412d, new Runnable() {
                                public void run() {
                                    aVar.a(f.this, exc);
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    public b m() {
        return this.i;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(Activity activity, int i2, int i3, Intent intent) {
        b.c cVar;
        g.a(activity, "currentActivity");
        a((Context) activity);
        if (i2 != this.l) {
            return false;
        }
        if (intent == null || i3 != -1) {
            if (i3 == 0) {
                synchronized (f.class) {
                    m mVar = this.f5415g;
                    try {
                        cVar = (b.c) intent.getExtras().getSerializable("auth_result");
                    } catch (NullPointerException e2) {
                        com.beetalk.sdk.e.a.a((Exception) e2);
                        cVar = null;
                    }
                    if (cVar == null || cVar.errorCode != 0) {
                        this.k = cVar == null ? com.garena.pay.android.a.UNKNOWN_ERROR.getCode().intValue() : cVar.errorCode;
                        this.f5415g = m.CLOSED_WITH_ERROR;
                    } else {
                        this.f5415g = m.CLOSED;
                    }
                    a(mVar, this.f5415g, (Exception) null);
                }
            }
            return false;
        }
        synchronized (f.class) {
            m mVar2 = this.f5415g;
            b.c cVar2 = (b.c) intent.getExtras().getSerializable("auth_result");
            this.j = cVar2.token;
            this.j.a(cVar2.openId);
            this.f5414f.a(this.j);
            if (this.i == b.GUEST) {
                this.f5414f.b(this.j);
            }
            this.f5415g = m.TOKEN_AVAILABLE;
            a(mVar2, m.TOKEN_AVAILABLE, (Exception) null);
        }
        return true;
    }

    public enum b {
        BEETALK(2),
        GARENA(1),
        FACEBOOK(3),
        GUEST(4),
        REFRESH_TOKEN(0);
        
        private int val;

        private b(int i) {
            this.val = i;
        }

        public static boolean isEqualToSessionProvider(b bVar, d dVar) {
            if (bVar == BEETALK && dVar == d.BEETALK_NATIVE_ANDROID) {
                return true;
            }
            if (bVar == FACEBOOK && dVar == d.FACEBOOK) {
                return true;
            }
            if ((bVar == GUEST && dVar == d.GUEST) || bVar == REFRESH_TOKEN) {
                return true;
            }
            if (bVar != GARENA) {
                return false;
            }
            if (dVar == d.GARENA_WEB_ANDROID || dVar == d.GARENA_NATIVE_ANDROID) {
                return true;
            }
            return false;
        }

        public int getValue() {
            return this.val;
        }
    }
}
