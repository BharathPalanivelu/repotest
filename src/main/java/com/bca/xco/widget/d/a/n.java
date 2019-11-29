package com.bca.xco.widget.d.a;

import com.bca.xco.widget.d.a.a.c;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static final n f5090a = new a(true).a(f5093d).a(ac.TLS_1_2).a(true).a();

    /* renamed from: b  reason: collision with root package name */
    public static final n f5091b = new a(f5090a).a(ac.TLS_1_0).a(true).a();

    /* renamed from: c  reason: collision with root package name */
    public static final n f5092c = new a(false).a();

    /* renamed from: d  reason: collision with root package name */
    private static final l[] f5093d = {l.aW, l.ba, l.aX, l.bb, l.ax, l.aH, l.ay, l.aI};
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final boolean f5094e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final boolean f5095f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final String[] f5096g;
    /* access modifiers changed from: private */
    public final String[] h;

    private n(a aVar) {
        this.f5094e = aVar.f5097a;
        this.f5096g = aVar.f5098b;
        this.h = aVar.f5099c;
        this.f5095f = aVar.f5100d;
    }

    public boolean a() {
        return this.f5094e;
    }

    public List<l> b() {
        String[] strArr = this.f5096g;
        if (strArr == null) {
            return null;
        }
        l[] lVarArr = new l[strArr.length];
        int i = 0;
        while (true) {
            String[] strArr2 = this.f5096g;
            if (i >= strArr2.length) {
                return c.a((T[]) lVarArr);
            }
            lVarArr[i] = l.a(strArr2[i]);
            i++;
        }
    }

    public List<ac> c() {
        String[] strArr = this.h;
        if (strArr == null) {
            return null;
        }
        ac[] acVarArr = new ac[strArr.length];
        int i = 0;
        while (true) {
            String[] strArr2 = this.h;
            if (i >= strArr2.length) {
                return c.a((T[]) acVarArr);
            }
            acVarArr[i] = ac.a(strArr2[i]);
            i++;
        }
    }

    public boolean d() {
        return this.f5095f;
    }

    /* access modifiers changed from: package-private */
    public void a(SSLSocket sSLSocket, boolean z) {
        n b2 = b(sSLSocket, z);
        String[] strArr = b2.h;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = b2.f5096g;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    private n b(SSLSocket sSLSocket, boolean z) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3 = this.f5096g;
        if (strArr3 != null) {
            strArr = (String[]) c.a(String.class, (T[]) strArr3, (T[]) sSLSocket.getEnabledCipherSuites());
        } else {
            strArr = sSLSocket.getEnabledCipherSuites();
        }
        String[] strArr4 = this.h;
        if (strArr4 != null) {
            strArr2 = (String[]) c.a(String.class, (T[]) strArr4, (T[]) sSLSocket.getEnabledProtocols());
        } else {
            strArr2 = sSLSocket.getEnabledProtocols();
        }
        if (z && c.a((T[]) sSLSocket.getSupportedCipherSuites(), "TLS_FALLBACK_SCSV") != -1) {
            strArr = c.a(strArr, "TLS_FALLBACK_SCSV");
        }
        return new a(this).a(strArr).b(strArr2).a();
    }

    public boolean a(SSLSocket sSLSocket) {
        if (!this.f5094e) {
            return false;
        }
        String[] strArr = this.h;
        if (strArr != null && !a(strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f5096g;
        if (strArr2 == null || a(strArr2, sSLSocket.getEnabledCipherSuites())) {
            return true;
        }
        return false;
    }

    private static boolean a(String[] strArr, String[] strArr2) {
        if (!(strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0)) {
            for (String a2 : strArr) {
                if (c.a((T[]) strArr2, a2) != -1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        n nVar = (n) obj;
        boolean z = this.f5094e;
        if (z != nVar.f5094e) {
            return false;
        }
        return !z || (Arrays.equals(this.f5096g, nVar.f5096g) && Arrays.equals(this.h, nVar.h) && this.f5095f == nVar.f5095f);
    }

    public int hashCode() {
        if (this.f5094e) {
            return ((((527 + Arrays.hashCode(this.f5096g)) * 31) + Arrays.hashCode(this.h)) * 31) + (this.f5095f ^ true ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f5094e) {
            return "ConnectionSpec()";
        }
        String str = "[all enabled]";
        String obj = this.f5096g != null ? b().toString() : str;
        if (this.h != null) {
            str = c().toString();
        }
        return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + str + ", supportsTlsExtensions=" + this.f5095f + SQLBuilder.PARENTHESES_RIGHT;
    }

    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public boolean f5097a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String[] f5098b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String[] f5099c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public boolean f5100d;

        a(boolean z) {
            this.f5097a = z;
        }

        public a(n nVar) {
            this.f5097a = nVar.f5094e;
            this.f5098b = nVar.f5096g;
            this.f5099c = nVar.h;
            this.f5100d = nVar.f5095f;
        }

        public a a(l... lVarArr) {
            if (this.f5097a) {
                String[] strArr = new String[lVarArr.length];
                for (int i = 0; i < lVarArr.length; i++) {
                    strArr[i] = lVarArr[i].bi;
                }
                return a(strArr);
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a a(String... strArr) {
            if (!this.f5097a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length != 0) {
                this.f5098b = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
        }

        public a a(ac... acVarArr) {
            if (this.f5097a) {
                String[] strArr = new String[acVarArr.length];
                for (int i = 0; i < acVarArr.length; i++) {
                    strArr[i] = acVarArr[i].f5041e;
                }
                return b(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a b(String... strArr) {
            if (!this.f5097a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length != 0) {
                this.f5099c = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
        }

        public a a(boolean z) {
            if (this.f5097a) {
                this.f5100d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public n a() {
            return new n(this);
        }
    }
}
