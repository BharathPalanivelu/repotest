package com.bca.xco.widget.d.a;

import java.util.concurrent.TimeUnit;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final j f5053a = new a().a().c();

    /* renamed from: b  reason: collision with root package name */
    public static final j f5054b = new a().b().a(Integer.MAX_VALUE, TimeUnit.SECONDS).c();

    /* renamed from: c  reason: collision with root package name */
    String f5055c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f5056d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f5057e;

    /* renamed from: f  reason: collision with root package name */
    private final int f5058f;

    /* renamed from: g  reason: collision with root package name */
    private final int f5059g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final int k;
    private final int l;
    private final boolean m;
    private final boolean n;

    private j(boolean z, boolean z2, int i2, int i3, boolean z3, boolean z4, boolean z5, int i4, int i5, boolean z6, boolean z7, String str) {
        this.f5056d = z;
        this.f5057e = z2;
        this.f5058f = i2;
        this.f5059g = i3;
        this.h = z3;
        this.i = z4;
        this.j = z5;
        this.k = i4;
        this.l = i5;
        this.m = z6;
        this.n = z7;
        this.f5055c = str;
    }

    private j(a aVar) {
        this.f5056d = aVar.f5060a;
        this.f5057e = aVar.f5061b;
        this.f5058f = aVar.f5062c;
        this.f5059g = -1;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = aVar.f5063d;
        this.l = aVar.f5064e;
        this.m = aVar.f5065f;
        this.n = aVar.f5066g;
    }

    public boolean a() {
        return this.f5056d;
    }

    public boolean b() {
        return this.f5057e;
    }

    public int c() {
        return this.f5058f;
    }

    public boolean d() {
        return this.h;
    }

    public boolean e() {
        return this.i;
    }

    public boolean f() {
        return this.j;
    }

    public int g() {
        return this.k;
    }

    public int h() {
        return this.l;
    }

    public boolean i() {
        return this.m;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.bca.xco.widget.d.a.j a(com.bca.xco.widget.d.a.r r21) {
        /*
            r0 = r21
            int r1 = r21.a()
            r6 = 0
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = -1
            r12 = -1
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = -1
            r17 = -1
            r18 = 0
            r19 = 0
        L_0x0018:
            if (r6 >= r1) goto L_0x0138
            java.lang.String r2 = r0.a((int) r6)
            java.lang.String r4 = r0.b((int) r6)
            java.lang.String r3 = "Cache-Control"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x002f
            if (r8 == 0) goto L_0x002d
            goto L_0x0037
        L_0x002d:
            r8 = r4
            goto L_0x0038
        L_0x002f:
            java.lang.String r3 = "Pragma"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x0131
        L_0x0037:
            r7 = 0
        L_0x0038:
            r2 = 0
        L_0x0039:
            int r3 = r4.length()
            if (r2 >= r3) goto L_0x0131
            java.lang.String r3 = "=,;"
            int r3 = com.bca.xco.widget.d.a.a.f.f.a((java.lang.String) r4, (int) r2, (java.lang.String) r3)
            java.lang.String r2 = r4.substring(r2, r3)
            java.lang.String r2 = r2.trim()
            int r5 = r4.length()
            if (r3 == r5) goto L_0x0097
            char r5 = r4.charAt(r3)
            r0 = 44
            if (r5 == r0) goto L_0x0097
            char r0 = r4.charAt(r3)
            r5 = 59
            if (r0 != r5) goto L_0x0064
            goto L_0x0097
        L_0x0064:
            int r3 = r3 + 1
            int r0 = com.bca.xco.widget.d.a.a.f.f.a(r4, r3)
            int r3 = r4.length()
            if (r0 >= r3) goto L_0x0087
            char r3 = r4.charAt(r0)
            r5 = 34
            if (r3 != r5) goto L_0x0087
            int r0 = r0 + 1
            java.lang.String r3 = "\""
            int r3 = com.bca.xco.widget.d.a.a.f.f.a((java.lang.String) r4, (int) r0, (java.lang.String) r3)
            java.lang.String r0 = r4.substring(r0, r3)
            r5 = 1
            int r3 = r3 + r5
            goto L_0x009b
        L_0x0087:
            r5 = 1
            java.lang.String r3 = ",;"
            int r3 = com.bca.xco.widget.d.a.a.f.f.a((java.lang.String) r4, (int) r0, (java.lang.String) r3)
            java.lang.String r0 = r4.substring(r0, r3)
            java.lang.String r0 = r0.trim()
            goto L_0x009b
        L_0x0097:
            r5 = 1
            int r3 = r3 + 1
            r0 = 0
        L_0x009b:
            java.lang.String r5 = "no-cache"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00a7
            r5 = -1
            r9 = 1
            goto L_0x012c
        L_0x00a7:
            java.lang.String r5 = "no-store"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00b3
            r5 = -1
            r10 = 1
            goto L_0x012c
        L_0x00b3:
            java.lang.String r5 = "max-age"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00c3
            r5 = -1
            int r0 = com.bca.xco.widget.d.a.a.f.f.b(r0, r5)
            r11 = r0
            goto L_0x012c
        L_0x00c3:
            java.lang.String r5 = "s-maxage"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00d2
            r5 = -1
            int r0 = com.bca.xco.widget.d.a.a.f.f.b(r0, r5)
            r12 = r0
            goto L_0x012c
        L_0x00d2:
            java.lang.String r5 = "private"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00dd
            r5 = -1
            r13 = 1
            goto L_0x012c
        L_0x00dd:
            java.lang.String r5 = "public"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00e8
            r5 = -1
            r14 = 1
            goto L_0x012c
        L_0x00e8:
            java.lang.String r5 = "must-revalidate"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00f3
            r5 = -1
            r15 = 1
            goto L_0x012c
        L_0x00f3:
            java.lang.String r5 = "max-stale"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x0106
            r2 = 2147483647(0x7fffffff, float:NaN)
            int r0 = com.bca.xco.widget.d.a.a.f.f.b(r0, r2)
            r16 = r0
            r5 = -1
            goto L_0x012c
        L_0x0106:
            java.lang.String r5 = "min-fresh"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x0116
            r5 = -1
            int r0 = com.bca.xco.widget.d.a.a.f.f.b(r0, r5)
            r17 = r0
            goto L_0x012c
        L_0x0116:
            r5 = -1
            java.lang.String r0 = "only-if-cached"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0122
            r18 = 1
            goto L_0x012c
        L_0x0122:
            java.lang.String r0 = "no-transform"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x012c
            r19 = 1
        L_0x012c:
            r0 = r21
            r2 = r3
            goto L_0x0039
        L_0x0131:
            r5 = -1
            int r6 = r6 + 1
            r0 = r21
            goto L_0x0018
        L_0x0138:
            if (r7 != 0) goto L_0x013d
            r20 = 0
            goto L_0x013f
        L_0x013d:
            r20 = r8
        L_0x013f:
            com.bca.xco.widget.d.a.j r0 = new com.bca.xco.widget.d.a.j
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.d.a.j.a(com.bca.xco.widget.d.a.r):com.bca.xco.widget.d.a.j");
    }

    public String toString() {
        String str = this.f5055c;
        if (str != null) {
            return str;
        }
        String j2 = j();
        this.f5055c = j2;
        return j2;
    }

    private String j() {
        StringBuilder sb = new StringBuilder();
        if (this.f5056d) {
            sb.append("no-cache, ");
        }
        if (this.f5057e) {
            sb.append("no-store, ");
        }
        if (this.f5058f != -1) {
            sb.append("max-age=");
            sb.append(this.f5058f);
            sb.append(", ");
        }
        if (this.f5059g != -1) {
            sb.append("s-maxage=");
            sb.append(this.f5059g);
            sb.append(", ");
        }
        if (this.h) {
            sb.append("private, ");
        }
        if (this.i) {
            sb.append("public, ");
        }
        if (this.j) {
            sb.append("must-revalidate, ");
        }
        if (this.k != -1) {
            sb.append("max-stale=");
            sb.append(this.k);
            sb.append(", ");
        }
        if (this.l != -1) {
            sb.append("min-fresh=");
            sb.append(this.l);
            sb.append(", ");
        }
        if (this.m) {
            sb.append("only-if-cached, ");
        }
        if (this.n) {
            sb.append("no-transform, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f5060a;

        /* renamed from: b  reason: collision with root package name */
        boolean f5061b;

        /* renamed from: c  reason: collision with root package name */
        int f5062c = -1;

        /* renamed from: d  reason: collision with root package name */
        int f5063d = -1;

        /* renamed from: e  reason: collision with root package name */
        int f5064e = -1;

        /* renamed from: f  reason: collision with root package name */
        boolean f5065f;

        /* renamed from: g  reason: collision with root package name */
        boolean f5066g;

        public a a() {
            this.f5060a = true;
            return this;
        }

        public a a(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds((long) i);
                this.f5063d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i);
        }

        public a b() {
            this.f5065f = true;
            return this;
        }

        public j c() {
            return new j(this);
        }
    }
}
