package io.a.a.a.a.e;

import io.a.a.a.l;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class b implements e {

    /* renamed from: a  reason: collision with root package name */
    private final l f33168a;

    /* renamed from: b  reason: collision with root package name */
    private g f33169b;

    /* renamed from: c  reason: collision with root package name */
    private SSLSocketFactory f33170c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f33171d;

    public b() {
        this(new io.a.a.a.b());
    }

    public b(l lVar) {
        this.f33168a = lVar;
    }

    public void a(g gVar) {
        if (this.f33169b != gVar) {
            this.f33169b = gVar;
            a();
        }
    }

    private synchronized void a() {
        this.f33171d = false;
        this.f33170c = null;
    }

    /* renamed from: io.a.a.a.a.e.b$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33172a = new int[c.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                io.a.a.a.a.e.c[] r0 = io.a.a.a.a.e.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f33172a = r0
                int[] r0 = f33172a     // Catch:{ NoSuchFieldError -> 0x0014 }
                io.a.a.a.a.e.c r1 = io.a.a.a.a.e.c.GET     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f33172a     // Catch:{ NoSuchFieldError -> 0x001f }
                io.a.a.a.a.e.c r1 = io.a.a.a.a.e.c.POST     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f33172a     // Catch:{ NoSuchFieldError -> 0x002a }
                io.a.a.a.a.e.c r1 = io.a.a.a.a.e.c.PUT     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f33172a     // Catch:{ NoSuchFieldError -> 0x0035 }
                io.a.a.a.a.e.c r1 = io.a.a.a.a.e.c.DELETE     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.a.a.a.a.e.b.AnonymousClass1.<clinit>():void");
        }
    }

    public d a(c cVar, String str, Map<String, String> map) {
        d dVar;
        int i = AnonymousClass1.f33172a[cVar.ordinal()];
        if (i == 1) {
            dVar = d.a((CharSequence) str, (Map<?, ?>) map, true);
        } else if (i == 2) {
            dVar = d.b((CharSequence) str, (Map<?, ?>) map, true);
        } else if (i == 3) {
            dVar = d.d((CharSequence) str);
        } else if (i == 4) {
            dVar = d.e((CharSequence) str);
        } else {
            throw new IllegalArgumentException("Unsupported HTTP method!");
        }
        if (a(str) && this.f33169b != null) {
            SSLSocketFactory b2 = b();
            if (b2 != null) {
                ((HttpsURLConnection) dVar.a()).setSSLSocketFactory(b2);
            }
        }
        return dVar;
    }

    private boolean a(String str) {
        return str != null && str.toLowerCase(Locale.US).startsWith("https");
    }

    private synchronized SSLSocketFactory b() {
        if (this.f33170c == null && !this.f33171d) {
            this.f33170c = c();
        }
        return this.f33170c;
    }

    private synchronized SSLSocketFactory c() {
        SSLSocketFactory a2;
        this.f33171d = true;
        try {
            a2 = f.a(this.f33169b);
            this.f33168a.a("Fabric", "Custom SSL pinning enabled");
        } catch (Exception e2) {
            this.f33168a.e("Fabric", "Exception while validating pinned certs", e2);
            return null;
        }
        return a2;
    }
}
