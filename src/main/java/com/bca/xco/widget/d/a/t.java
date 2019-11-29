package com.bca.xco.widget.d.a;

import com.bca.xco.widget.d.a.a.c;
import com.bca.xco.widget.d.b.g;
import com.tencent.qcloud.core.util.IOUtils;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Marker;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f5135a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f5136b;

    /* renamed from: c  reason: collision with root package name */
    private final String f5137c;

    /* renamed from: d  reason: collision with root package name */
    private final String f5138d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final String f5139e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final int f5140f;

    /* renamed from: g  reason: collision with root package name */
    private final List<String> f5141g;
    private final List<String> h;
    private final String i;
    private final String j;

    static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    /* synthetic */ t(a aVar, AnonymousClass1 r2) {
        this(aVar);
    }

    private t(a aVar) {
        this.f5136b = aVar.f5143a;
        this.f5137c = a(aVar.f5144b, false);
        this.f5138d = a(aVar.f5145c, false);
        this.f5139e = aVar.f5146d;
        this.f5140f = aVar.a();
        this.f5141g = a(aVar.f5148f, false);
        String str = null;
        this.h = aVar.f5149g != null ? a(aVar.f5149g, true) : null;
        this.i = aVar.h != null ? a(aVar.h, false) : str;
        this.j = aVar.toString();
    }

    public URI a() {
        String aVar = n().b().toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e2) {
            try {
                return URI.create(aVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }

    public String b() {
        return this.f5136b;
    }

    public boolean c() {
        return this.f5136b.equals("https");
    }

    public String d() {
        if (this.f5137c.isEmpty()) {
            return "";
        }
        int length = this.f5136b.length() + 3;
        String str = this.j;
        return this.j.substring(length, c.a(str, length, str.length(), ":@"));
    }

    public String e() {
        if (this.f5138d.isEmpty()) {
            return "";
        }
        int indexOf = this.j.indexOf(64);
        return this.j.substring(this.j.indexOf(58, this.f5136b.length() + 3) + 1, indexOf);
    }

    public String f() {
        return this.f5139e;
    }

    public int g() {
        return this.f5140f;
    }

    public static int a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public String h() {
        int indexOf = this.j.indexOf(47, this.f5136b.length() + 3);
        String str = this.j;
        return this.j.substring(indexOf, c.a(str, indexOf, str.length(), "?#"));
    }

    static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb.append(list.get(i2));
        }
    }

    public List<String> i() {
        int indexOf = this.j.indexOf(47, this.f5136b.length() + 3);
        String str = this.j;
        int a2 = c.a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a2) {
            int i2 = indexOf + 1;
            int a3 = c.a(this.j, i2, a2, (char) IOUtils.DIR_SEPARATOR_UNIX);
            arrayList.add(this.j.substring(i2, a3));
            indexOf = a3;
        }
        return arrayList;
    }

    public String j() {
        if (this.h == null) {
            return null;
        }
        int indexOf = this.j.indexOf(63) + 1;
        String str = this.j;
        return this.j.substring(indexOf, c.a(str, indexOf + 1, str.length(), '#'));
    }

    static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            String str = list.get(i2);
            String str2 = list.get(i2 + 1);
            if (i2 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    static List<String> b(String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 <= str.length()) {
            int indexOf = str.indexOf(38, i2);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i2);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i2, indexOf));
                arrayList.add((Object) null);
            } else {
                arrayList.add(str.substring(i2, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i2 = indexOf + 1;
        }
        return arrayList;
    }

    public String k() {
        if (this.h == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        b(sb, this.h);
        return sb.toString();
    }

    public String l() {
        if (this.i == null) {
            return null;
        }
        return this.j.substring(this.j.indexOf(35) + 1);
    }

    public t m() {
        a d2 = d("/...");
        d2.b("");
        d2.c("");
        return d2.c();
    }

    public t c(String str) {
        a d2 = d(str);
        if (d2 != null) {
            return d2.c();
        }
        return null;
    }

    public a n() {
        a aVar = new a();
        aVar.f5143a = this.f5136b;
        aVar.f5144b = d();
        aVar.f5145c = e();
        aVar.f5146d = this.f5139e;
        aVar.f5147e = this.f5140f != a(this.f5136b) ? this.f5140f : -1;
        aVar.f5148f.clear();
        aVar.f5148f.addAll(i());
        aVar.e(j());
        aVar.h = l();
        return aVar;
    }

    public a d(String str) {
        a aVar = new a();
        if (aVar.a(this, str) == a.C0094a.SUCCESS) {
            return aVar;
        }
        return null;
    }

    public static t e(String str) {
        a aVar = new a();
        if (aVar.a((t) null, str) == a.C0094a.SUCCESS) {
            return aVar.c();
        }
        return null;
    }

    /* renamed from: com.bca.xco.widget.d.a.t$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5142a = new int[a.C0094a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.bca.xco.widget.d.a.t$a$a[] r0 = com.bca.xco.widget.d.a.t.a.C0094a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5142a = r0
                int[] r0 = f5142a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.bca.xco.widget.d.a.t$a$a r1 = com.bca.xco.widget.d.a.t.a.C0094a.SUCCESS     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f5142a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.bca.xco.widget.d.a.t$a$a r1 = com.bca.xco.widget.d.a.t.a.C0094a.INVALID_HOST     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f5142a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.bca.xco.widget.d.a.t$a$a r1 = com.bca.xco.widget.d.a.t.a.C0094a.UNSUPPORTED_SCHEME     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f5142a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.bca.xco.widget.d.a.t$a$a r1 = com.bca.xco.widget.d.a.t.a.C0094a.MISSING_SCHEME     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f5142a     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.bca.xco.widget.d.a.t$a$a r1 = com.bca.xco.widget.d.a.t.a.C0094a.INVALID_PORT     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.d.a.t.AnonymousClass1.<clinit>():void");
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof t) && ((t) obj).j.equals(this.j);
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public String toString() {
        return this.j;
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        String f5143a;

        /* renamed from: b  reason: collision with root package name */
        String f5144b = "";

        /* renamed from: c  reason: collision with root package name */
        String f5145c = "";

        /* renamed from: d  reason: collision with root package name */
        String f5146d;

        /* renamed from: e  reason: collision with root package name */
        int f5147e = -1;

        /* renamed from: f  reason: collision with root package name */
        final List<String> f5148f = new ArrayList();

        /* renamed from: g  reason: collision with root package name */
        List<String> f5149g;
        String h;

        /* renamed from: com.bca.xco.widget.d.a.t$a$a  reason: collision with other inner class name */
        enum C0094a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public a() {
            this.f5148f.add("");
        }

        public a a(String str) {
            if (str != null) {
                if (str.equalsIgnoreCase("http")) {
                    this.f5143a = "http";
                } else if (str.equalsIgnoreCase("https")) {
                    this.f5143a = "https";
                } else {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                return this;
            }
            throw new NullPointerException("scheme == null");
        }

        public a b(String str) {
            if (str != null) {
                this.f5144b = t.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("username == null");
        }

        public a c(String str) {
            if (str != null) {
                this.f5145c = t.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("password == null");
        }

        public a d(String str) {
            if (str != null) {
                String e2 = e(str, 0, str.length());
                if (e2 != null) {
                    this.f5146d = e2;
                    return this;
                }
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            throw new NullPointerException("host == null");
        }

        public a a(int i) {
            if (i <= 0 || i > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i);
            }
            this.f5147e = i;
            return this;
        }

        /* access modifiers changed from: package-private */
        public int a() {
            int i = this.f5147e;
            return i != -1 ? i : t.a(this.f5143a);
        }

        public a e(String str) {
            this.f5149g = str != null ? t.b(t.a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        /* access modifiers changed from: package-private */
        public a b() {
            int size = this.f5148f.size();
            for (int i = 0; i < size; i++) {
                this.f5148f.set(i, t.a(this.f5148f.get(i), "[]", true, true, false, true));
            }
            List<String> list = this.f5149g;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.f5149g.get(i2);
                    if (str != null) {
                        this.f5149g.set(i2, t.a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.h;
            if (str2 != null) {
                this.h = t.a(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public t c() {
            if (this.f5143a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.f5146d != null) {
                return new t(this, (AnonymousClass1) null);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f5143a);
            sb.append("://");
            if (!this.f5144b.isEmpty() || !this.f5145c.isEmpty()) {
                sb.append(this.f5144b);
                if (!this.f5145c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f5145c);
                }
                sb.append('@');
            }
            if (this.f5146d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f5146d);
                sb.append(']');
            } else {
                sb.append(this.f5146d);
            }
            int a2 = a();
            if (a2 != t.a(this.f5143a)) {
                sb.append(':');
                sb.append(a2);
            }
            t.a(sb, this.f5148f);
            if (this.f5149g != null) {
                sb.append('?');
                t.b(sb, this.f5149g);
            }
            if (this.h != null) {
                sb.append('#');
                sb.append(this.h);
            }
            return sb.toString();
        }

        /* access modifiers changed from: package-private */
        public C0094a a(t tVar, String str) {
            int a2;
            int i;
            String str2 = str;
            int a3 = c.a(str2, 0, str.length());
            int b2 = c.b(str2, a3, str.length());
            if (b(str2, a3, b2) != -1) {
                if (str.regionMatches(true, a3, "https:", 0, 6)) {
                    this.f5143a = "https";
                    a3 += 6;
                } else if (!str.regionMatches(true, a3, "http:", 0, 5)) {
                    return C0094a.UNSUPPORTED_SCHEME;
                } else {
                    this.f5143a = "http";
                    a3 += 5;
                }
            } else if (tVar == null) {
                return C0094a.MISSING_SCHEME;
            } else {
                this.f5143a = tVar.f5136b;
            }
            int c2 = c(str2, a3, b2);
            char c3 = '?';
            char c4 = '#';
            if (c2 >= 2 || tVar == null || !tVar.f5136b.equals(this.f5143a)) {
                int i2 = a3 + c2;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    a2 = c.a(str2, i2, b2, "@/\\?#");
                    char charAt = a2 != b2 ? str2.charAt(a2) : 65535;
                    if (charAt == 65535 || charAt == c4 || charAt == '/' || charAt == '\\' || charAt == c3) {
                        int i3 = a2;
                        int d2 = d(str2, i2, i3);
                        int i4 = d2 + 1;
                    } else {
                        if (charAt == '@') {
                            if (!z) {
                                int a4 = c.a(str2, i2, a2, ':');
                                int i5 = a4;
                                String str3 = "%40";
                                i = a2;
                                String a5 = t.a(str, i2, a4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                if (z2) {
                                    a5 = this.f5144b + str3 + a5;
                                }
                                this.f5144b = a5;
                                if (i5 != i) {
                                    this.f5145c = t.a(str, i5 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                    z = true;
                                }
                                z2 = true;
                            } else {
                                i = a2;
                                this.f5145c += "%40" + t.a(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                            }
                            i2 = i + 1;
                        }
                        c3 = '?';
                        c4 = '#';
                    }
                }
                int i32 = a2;
                int d22 = d(str2, i2, i32);
                int i42 = d22 + 1;
                if (i42 < i32) {
                    this.f5146d = e(str2, i2, d22);
                    this.f5147e = g(str2, i42, i32);
                    if (this.f5147e == -1) {
                        return C0094a.INVALID_PORT;
                    }
                } else {
                    this.f5146d = e(str2, i2, d22);
                    this.f5147e = t.a(this.f5143a);
                }
                if (this.f5146d == null) {
                    return C0094a.INVALID_HOST;
                }
                a3 = i32;
            } else {
                this.f5144b = tVar.d();
                this.f5145c = tVar.e();
                this.f5146d = tVar.f5139e;
                this.f5147e = tVar.f5140f;
                this.f5148f.clear();
                this.f5148f.addAll(tVar.i());
                if (a3 == b2 || str2.charAt(a3) == '#') {
                    e(tVar.j());
                }
            }
            int a6 = c.a(str2, a3, b2, "?#");
            a(str2, a3, a6);
            if (a6 < b2 && str2.charAt(a6) == '?') {
                int a7 = c.a(str2, a6, b2, '#');
                this.f5149g = t.b(t.a(str, a6 + 1, a7, " \"'<>#", true, false, true, true));
                a6 = a7;
            }
            if (a6 < b2 && str2.charAt(a6) == '#') {
                this.h = t.a(str, 1 + a6, b2, "", true, false, false, false);
            }
            return C0094a.SUCCESS;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0044 A[SYNTHETIC] */
        private void a(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                if (r12 != r13) goto L_0x0003
                return
            L_0x0003:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L_0x001e
                r1 = 92
                if (r0 != r1) goto L_0x0013
                goto L_0x001e
            L_0x0013:
                java.util.List<java.lang.String> r0 = r10.f5148f
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L_0x0029
            L_0x001e:
                java.util.List<java.lang.String> r0 = r10.f5148f
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.f5148f
                r0.add(r2)
                goto L_0x0041
            L_0x0029:
                r6 = r12
                if (r6 >= r13) goto L_0x0044
                java.lang.String r12 = "/\\"
                int r12 = com.bca.xco.widget.d.a.a.c.a((java.lang.String) r11, (int) r6, (int) r13, (java.lang.String) r12)
                if (r12 >= r13) goto L_0x0036
                r0 = 1
                goto L_0x0037
            L_0x0036:
                r0 = 0
            L_0x0037:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.a((java.lang.String) r5, (int) r6, (int) r7, (boolean) r8, (boolean) r9)
                if (r0 == 0) goto L_0x0029
            L_0x0041:
                int r12 = r12 + 1
                goto L_0x0029
            L_0x0044:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.d.a.t.a.a(java.lang.String, int, int):void");
        }

        private void a(String str, int i, int i2, boolean z, boolean z2) {
            String a2 = t.a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true);
            if (!f(a2)) {
                if (g(a2)) {
                    d();
                    return;
                }
                List<String> list = this.f5148f;
                if (list.get(list.size() - 1).isEmpty()) {
                    List<String> list2 = this.f5148f;
                    list2.set(list2.size() - 1, a2);
                } else {
                    this.f5148f.add(a2);
                }
                if (z) {
                    this.f5148f.add("");
                }
            }
        }

        private boolean f(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean g(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private void d() {
            List<String> list = this.f5148f;
            if (!list.remove(list.size() - 1).isEmpty() || this.f5148f.isEmpty()) {
                this.f5148f.add("");
                return;
            }
            List<String> list2 = this.f5148f;
            list2.set(list2.size() - 1, "");
        }

        private static int b(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char charAt2 = str.charAt(i);
                    if ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && !((charAt2 >= '0' && charAt2 <= '9') || charAt2 == '+' || charAt2 == '-' || charAt2 == '.'))) {
                        if (charAt2 == ':') {
                            return i;
                        }
                    }
                }
            }
            return -1;
        }

        private static int c(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        private static int d(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i++;
                        if (i >= i2) {
                            break;
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        private static String e(String str, int i, int i2) {
            InetAddress inetAddress;
            String a2 = t.a(str, i, i2, false);
            if (!a2.contains(":")) {
                return c.a(a2);
            }
            if (!a2.startsWith("[") || !a2.endsWith("]")) {
                inetAddress = f(a2, 0, a2.length());
            } else {
                inetAddress = f(a2, 1, a2.length() - 1);
            }
            if (inetAddress == null) {
                return null;
            }
            byte[] address = inetAddress.getAddress();
            if (address.length == 16) {
                return a(address);
            }
            throw new AssertionError();
        }

        private static InetAddress f(String str, int i, int i2) {
            byte[] bArr = new byte[16];
            int i3 = 0;
            int i4 = -1;
            int i5 = -1;
            while (true) {
                if (i >= i2) {
                    break;
                } else if (i3 == bArr.length) {
                    return null;
                } else {
                    int i6 = i + 2;
                    if (i6 > i2 || !str.regionMatches(i, "::", 0, 2)) {
                        if (i3 != 0) {
                            if (str.regionMatches(i, ":", 0, 1)) {
                                i++;
                            } else if (!str.regionMatches(i, ".", 0, 1) || !a(str, i5, i2, bArr, i3 - 2)) {
                                return null;
                            } else {
                                i3 += 2;
                            }
                        }
                        i5 = i;
                    } else if (i4 != -1) {
                        return null;
                    } else {
                        i3 += 2;
                        if (i6 == i2) {
                            i4 = i3;
                            break;
                        }
                        i4 = i3;
                        i5 = i6;
                    }
                    i = i5;
                    int i7 = 0;
                    while (i < i2) {
                        int a2 = t.a(str.charAt(i));
                        if (a2 == -1) {
                            break;
                        }
                        i7 = (i7 << 4) + a2;
                        i++;
                    }
                    int i8 = i - i5;
                    if (i8 == 0 || i8 > 4) {
                        return null;
                    }
                    int i9 = i3 + 1;
                    bArr[i3] = (byte) ((i7 >>> 8) & 255);
                    i3 = i9 + 1;
                    bArr[i9] = (byte) (i7 & 255);
                }
            }
            if (i3 != bArr.length) {
                if (i4 == -1) {
                    return null;
                }
                int i10 = i3 - i4;
                System.arraycopy(bArr, i4, bArr, bArr.length - i10, i10);
                Arrays.fill(bArr, i4, (bArr.length - i3) + i4, (byte) 0);
            }
            try {
                return InetAddress.getByAddress(bArr);
            } catch (UnknownHostException unused) {
                throw new AssertionError();
            }
        }

        private static boolean a(String str, int i, int i2, byte[] bArr, int i3) {
            int i4 = i3;
            while (i < i2) {
                if (i4 == bArr.length) {
                    return false;
                }
                if (i4 != i3) {
                    if (str.charAt(i) != '.') {
                        return false;
                    }
                    i++;
                }
                int i5 = i;
                int i6 = 0;
                while (i5 < i2) {
                    char charAt = str.charAt(i5);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    } else if (i6 == 0 && i != i5) {
                        return false;
                    } else {
                        i6 = ((i6 * 10) + charAt) - 48;
                        if (i6 > 255) {
                            return false;
                        }
                        i5++;
                    }
                }
                if (i5 - i == 0) {
                    return false;
                }
                bArr[i4] = (byte) i6;
                i4++;
                i = i5;
            }
            if (i4 != i3 + 4) {
                return false;
            }
            return true;
        }

        private static String a(byte[] bArr) {
            int i = 0;
            int i2 = 0;
            int i3 = -1;
            int i4 = 0;
            while (i2 < bArr.length) {
                int i5 = i2;
                while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                    i5 += 2;
                }
                int i6 = i5 - i2;
                if (i6 > i4) {
                    i3 = i2;
                    i4 = i6;
                }
                i2 = i5 + 2;
            }
            g gVar = new g();
            while (i < bArr.length) {
                if (i == i3) {
                    gVar.a(58);
                    i += i4;
                    if (i == 16) {
                        gVar.a(58);
                    }
                } else {
                    if (i > 0) {
                        gVar.a(58);
                    }
                    gVar.b((long) (((bArr[i] & 255) << 8) | (bArr[i + 1] & 255)));
                    i += 2;
                }
            }
            return gVar.q();
        }

        private static int g(String str, int i, int i2) {
            try {
                int parseInt = Integer.parseInt(t.a(str, i, i2, "", false, false, false, true));
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
    }

    static String a(String str, boolean z) {
        return a(str, 0, str.length(), z);
    }

    private List<String> a(List<String> list, boolean z) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            arrayList.add(next != null ? a(next, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String a(String str, int i2, int i3, boolean z) {
        for (int i4 = i2; i4 < i3; i4++) {
            char charAt = str.charAt(i4);
            if (charAt == '%' || (charAt == '+' && z)) {
                g gVar = new g();
                gVar.a(str, i2, i4);
                a(gVar, str, i4, i3, z);
                return gVar.q();
            }
        }
        return str.substring(i2, i3);
    }

    static void a(g gVar, String str, int i2, int i3, boolean z) {
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt == 37) {
                int i4 = i2 + 2;
                if (i4 < i3) {
                    int a2 = a(str.charAt(i2 + 1));
                    int a3 = a(str.charAt(i4));
                    if (!(a2 == -1 || a3 == -1)) {
                        gVar.a((a2 << 4) + a3);
                        i2 = i4;
                        i2 += Character.charCount(codePointAt);
                    }
                    gVar.d(codePointAt);
                    i2 += Character.charCount(codePointAt);
                }
            }
            if (codePointAt == 43 && z) {
                gVar.a(32);
                i2 += Character.charCount(codePointAt);
            }
            gVar.d(codePointAt);
            i2 += Character.charCount(codePointAt);
        }
    }

    static boolean a(String str, int i2, int i3) {
        int i4 = i2 + 2;
        if (i4 >= i3 || str.charAt(i2) != '%' || a(str.charAt(i2 + 1)) == -1 || a(str.charAt(i4)) == -1) {
            return false;
        }
        return true;
    }

    static String a(String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        String str3 = str;
        int i4 = i3;
        int i5 = i2;
        while (i5 < i4) {
            int codePointAt = str.codePointAt(i5);
            if (codePointAt < 32 || codePointAt == 127 || (codePointAt >= 128 && z4)) {
                String str4 = str2;
            } else {
                String str5 = str2;
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || a(str, i5, i3)))) && (codePointAt != 43 || !z3))) {
                    i5 += Character.charCount(codePointAt);
                }
            }
            g gVar = new g();
            int i6 = i2;
            gVar.a(str, i2, i5);
            a(gVar, str, i5, i3, str2, z, z2, z3, z4);
            return gVar.q();
        }
        int i7 = i2;
        return str.substring(i2, i3);
    }

    static void a(g gVar, String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        g gVar2 = null;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (!z || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt == 43 && z3) {
                    gVar.a(z ? Marker.ANY_NON_NULL_MARKER : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !a(str, i2, i3)))))) {
                    if (gVar2 == null) {
                        gVar2 = new g();
                    }
                    gVar2.d(codePointAt);
                    while (!gVar2.d()) {
                        byte e2 = gVar2.e() & 255;
                        gVar.a(37);
                        gVar.a((int) f5135a[(e2 >> 4) & 15]);
                        gVar.a((int) f5135a[e2 & 15]);
                    }
                } else {
                    gVar.d(codePointAt);
                }
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4);
    }
}
