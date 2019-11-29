package com.bca.xco.widget.d.a;

import com.bca.xco.widget.d.a.a.c;
import com.bca.xco.widget.d.a.a.f.e;
import com.facebook.common.time.Clock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f5101a = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f5102b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f5103c = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f5104d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: e  reason: collision with root package name */
    private final String f5105e;

    /* renamed from: f  reason: collision with root package name */
    private final String f5106f;

    /* renamed from: g  reason: collision with root package name */
    private final long f5107g;
    private final String h;
    private final String i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final boolean m;

    private o(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f5105e = str;
        this.f5106f = str2;
        this.f5107g = j2;
        this.h = str3;
        this.i = str4;
        this.j = z;
        this.k = z2;
        this.m = z3;
        this.l = z4;
    }

    public String a() {
        return this.f5105e;
    }

    public String b() {
        return this.f5106f;
    }

    private static boolean b(t tVar, String str) {
        String f2 = tVar.f();
        if (f2.equals(str)) {
            return true;
        }
        if (!f2.endsWith(str) || f2.charAt((f2.length() - str.length()) - 1) != '.' || c.b(f2)) {
            return false;
        }
        return true;
    }

    public static o a(t tVar, String str) {
        return a(System.currentTimeMillis(), tVar, str);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x010b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.bca.xco.widget.d.a.o a(long r24, com.bca.xco.widget.d.a.t r26, java.lang.String r27) {
        /*
            r0 = r27
            int r1 = r27.length()
            r2 = 59
            r3 = 0
            int r4 = com.bca.xco.widget.d.a.a.c.a((java.lang.String) r0, (int) r3, (int) r1, (char) r2)
            r5 = 61
            int r6 = com.bca.xco.widget.d.a.a.c.a((java.lang.String) r0, (int) r3, (int) r4, (char) r5)
            r7 = 0
            if (r6 != r4) goto L_0x0017
            return r7
        L_0x0017:
            java.lang.String r9 = com.bca.xco.widget.d.a.a.c.c(r0, r3, r6)
            boolean r8 = r9.isEmpty()
            if (r8 == 0) goto L_0x0022
            return r7
        L_0x0022:
            r8 = 1
            int r6 = r6 + r8
            java.lang.String r10 = com.bca.xco.widget.d.a.a.c.c(r0, r6, r4)
            int r4 = r4 + r8
            r11 = -1
            r13 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            r6 = r7
            r8 = r6
            r15 = r11
            r18 = r13
            r20 = 0
            r21 = 0
            r22 = 1
            r23 = 0
        L_0x003d:
            if (r4 >= r1) goto L_0x00b0
            int r7 = com.bca.xco.widget.d.a.a.c.a((java.lang.String) r0, (int) r4, (int) r1, (char) r2)
            int r2 = com.bca.xco.widget.d.a.a.c.a((java.lang.String) r0, (int) r4, (int) r7, (char) r5)
            java.lang.String r4 = com.bca.xco.widget.d.a.a.c.c(r0, r4, r2)
            if (r2 >= r7) goto L_0x0054
            int r2 = r2 + 1
            java.lang.String r2 = com.bca.xco.widget.d.a.a.c.c(r0, r2, r7)
            goto L_0x0056
        L_0x0054:
            java.lang.String r2 = ""
        L_0x0056:
            java.lang.String r5 = "expires"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0069
            int r4 = r2.length()     // Catch:{ IllegalArgumentException -> 0x00a8 }
            long r4 = a((java.lang.String) r2, (int) r3, (int) r4)     // Catch:{ IllegalArgumentException -> 0x00a8 }
            r18 = r4
            goto L_0x0076
        L_0x0069:
            java.lang.String r5 = "max-age"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0079
            long r4 = a((java.lang.String) r2)     // Catch:{  }
            r15 = r4
        L_0x0076:
            r23 = 1
            goto L_0x00a8
        L_0x0079:
            java.lang.String r5 = "domain"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0089
            java.lang.String r2 = b(r2)     // Catch:{ IllegalArgumentException -> 0x00a8 }
            r6 = r2
            r22 = 0
            goto L_0x00a8
        L_0x0089:
            java.lang.String r5 = "path"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0093
            r8 = r2
            goto L_0x00a8
        L_0x0093:
            java.lang.String r2 = "secure"
            boolean r2 = r4.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x009e
            r20 = 1
            goto L_0x00a8
        L_0x009e:
            java.lang.String r2 = "httponly"
            boolean r2 = r4.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x00a8
            r21 = 1
        L_0x00a8:
            int r4 = r7 + 1
            r2 = 59
            r5 = 61
            r7 = 0
            goto L_0x003d
        L_0x00b0:
            r0 = -9223372036854775808
            int r2 = (r15 > r0 ? 1 : (r15 == r0 ? 0 : -1))
            if (r2 != 0) goto L_0x00b8
        L_0x00b6:
            r11 = r0
            goto L_0x00dd
        L_0x00b8:
            int r0 = (r15 > r11 ? 1 : (r15 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x00db
            r0 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
            int r2 = (r15 > r0 ? 1 : (r15 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00ca
            r0 = 1000(0x3e8, double:4.94E-321)
            long r15 = r15 * r0
            goto L_0x00cf
        L_0x00ca:
            r15 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x00cf:
            long r0 = r24 + r15
            int r2 = (r0 > r24 ? 1 : (r0 == r24 ? 0 : -1))
            if (r2 < 0) goto L_0x00d9
            int r2 = (r0 > r13 ? 1 : (r0 == r13 ? 0 : -1))
            if (r2 <= 0) goto L_0x00b6
        L_0x00d9:
            r11 = r13
            goto L_0x00dd
        L_0x00db:
            r11 = r18
        L_0x00dd:
            if (r6 != 0) goto L_0x00e7
            java.lang.String r0 = r26.f()
            r13 = r0
            r0 = r26
            goto L_0x00f2
        L_0x00e7:
            r0 = r26
            boolean r1 = b(r0, r6)
            if (r1 != 0) goto L_0x00f1
            r1 = 0
            return r1
        L_0x00f1:
            r13 = r6
        L_0x00f2:
            java.lang.String r1 = "/"
            if (r8 == 0) goto L_0x00ff
            boolean r2 = r8.startsWith(r1)
            if (r2 != 0) goto L_0x00fd
            goto L_0x00ff
        L_0x00fd:
            r14 = r8
            goto L_0x0110
        L_0x00ff:
            java.lang.String r0 = r26.h()
            r2 = 47
            int r2 = r0.lastIndexOf(r2)
            if (r2 == 0) goto L_0x010f
            java.lang.String r1 = r0.substring(r3, r2)
        L_0x010f:
            r14 = r1
        L_0x0110:
            com.bca.xco.widget.d.a.o r0 = new com.bca.xco.widget.d.a.o
            r8 = r0
            r15 = r20
            r16 = r21
            r17 = r22
            r18 = r23
            r8.<init>(r9, r10, r11, r13, r14, r15, r16, r17, r18)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.d.a.o.a(long, com.bca.xco.widget.d.a.t, java.lang.String):com.bca.xco.widget.d.a.o");
    }

    private static long a(String str, int i2, int i3) {
        int a2 = a(str, i2, i3, false);
        Matcher matcher = f5104d.matcher(str);
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        while (a2 < i3) {
            int a3 = a(str, a2 + 1, i3, true);
            matcher.region(a2, a3);
            if (i5 == -1 && matcher.usePattern(f5104d).matches()) {
                int parseInt = Integer.parseInt(matcher.group(1));
                int parseInt2 = Integer.parseInt(matcher.group(2));
                i9 = Integer.parseInt(matcher.group(3));
                i8 = parseInt2;
                i5 = parseInt;
            } else if (i6 == -1 && matcher.usePattern(f5103c).matches()) {
                i6 = Integer.parseInt(matcher.group(1));
            } else if (i7 == -1 && matcher.usePattern(f5102b).matches()) {
                i7 = f5102b.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i4 == -1 && matcher.usePattern(f5101a).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
            }
            a2 = a(str, a3 + 1, i3, false);
        }
        if (i4 >= 70 && i4 <= 99) {
            i4 += 1900;
        }
        if (i4 >= 0 && i4 <= 69) {
            i4 += 2000;
        }
        if (i4 < 1601) {
            throw new IllegalArgumentException();
        } else if (i7 == -1) {
            throw new IllegalArgumentException();
        } else if (i6 < 1 || i6 > 31) {
            throw new IllegalArgumentException();
        } else if (i5 < 0 || i5 > 23) {
            throw new IllegalArgumentException();
        } else if (i8 < 0 || i8 > 59) {
            throw new IllegalArgumentException();
        } else if (i9 < 0 || i9 > 59) {
            throw new IllegalArgumentException();
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(c.f4798d);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i4);
            gregorianCalendar.set(2, i7 - 1);
            gregorianCalendar.set(5, i6);
            gregorianCalendar.set(11, i5);
            gregorianCalendar.set(12, i8);
            gregorianCalendar.set(13, i9);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    private static int a(String str, int i2, int i3, boolean z) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (((charAt < ' ' && charAt != 9) || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    private static long a(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e2) {
            if (!str.matches("-?\\d+")) {
                throw e2;
            } else if (str.startsWith("-")) {
                return Long.MIN_VALUE;
            } else {
                return Clock.MAX_TIME;
            }
        }
    }

    private static String b(String str) {
        if (!str.endsWith(".")) {
            if (str.startsWith(".")) {
                str = str.substring(1);
            }
            String a2 = c.a(str);
            if (a2 != null) {
                return a2;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    public static List<o> a(t tVar, r rVar) {
        List<String> c2 = rVar.c("Set-Cookie");
        int size = c2.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            o a2 = a(tVar, c2.get(i2));
            if (a2 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(a2);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public String toString() {
        return a(false);
    }

    /* access modifiers changed from: package-private */
    public String a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5105e);
        sb.append('=');
        sb.append(this.f5106f);
        if (this.l) {
            if (this.f5107g == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(e.a(new Date(this.f5107g)));
            }
        }
        if (!this.m) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.h);
        }
        sb.append("; path=");
        sb.append(this.i);
        if (this.j) {
            sb.append("; secure");
        }
        if (this.k) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (oVar.f5105e.equals(this.f5105e) && oVar.f5106f.equals(this.f5106f) && oVar.h.equals(this.h) && oVar.i.equals(this.i) && oVar.f5107g == this.f5107g && oVar.j == this.j && oVar.k == this.k && oVar.l == this.l && oVar.m == this.m) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.f5107g;
        return ((((((((((((((((527 + this.f5105e.hashCode()) * 31) + this.f5106f.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (this.j ^ true ? 1 : 0)) * 31) + (this.k ^ true ? 1 : 0)) * 31) + (this.l ^ true ? 1 : 0)) * 31) + (this.m ^ true ? 1 : 0);
    }
}
