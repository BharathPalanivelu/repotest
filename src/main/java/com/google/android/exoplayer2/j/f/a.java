package com.google.android.exoplayer2.j.f;

import android.text.TextUtils;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.exoplayer2.n.c;
import com.google.android.exoplayer2.n.k;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f10575a = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* renamed from: b  reason: collision with root package name */
    private final k f10576b = new k();

    /* renamed from: c  reason: collision with root package name */
    private final StringBuilder f10577c = new StringBuilder();

    public d a(k kVar) {
        this.f10577c.setLength(0);
        int d2 = kVar.d();
        c(kVar);
        this.f10576b.a(kVar.f10948a, kVar.d());
        this.f10576b.c(d2);
        String b2 = b(this.f10576b, this.f10577c);
        if (b2 == null || !"{".equals(a(this.f10576b, this.f10577c))) {
            return null;
        }
        d dVar = new d();
        a(dVar, b2);
        String str = null;
        boolean z = false;
        while (!z) {
            int d3 = this.f10576b.d();
            str = a(this.f10576b, this.f10577c);
            boolean z2 = str == null || "}".equals(str);
            if (!z2) {
                this.f10576b.c(d3);
                a(this.f10576b, dVar, this.f10577c);
            }
            z = z2;
        }
        if ("}".equals(str)) {
            return dVar;
        }
        return null;
    }

    private static String b(k kVar, StringBuilder sb) {
        b(kVar);
        if (kVar.b() < 5 || !"::cue".equals(kVar.e(5))) {
            return null;
        }
        int d2 = kVar.d();
        String a2 = a(kVar, sb);
        if (a2 == null) {
            return null;
        }
        if ("{".equals(a2)) {
            kVar.c(d2);
            return "";
        }
        String d3 = SQLBuilder.PARENTHESES_LEFT.equals(a2) ? d(kVar) : null;
        String a3 = a(kVar, sb);
        if (!SQLBuilder.PARENTHESES_RIGHT.equals(a3) || a3 == null) {
            return null;
        }
        return d3;
    }

    private static String d(k kVar) {
        int d2 = kVar.d();
        int c2 = kVar.c();
        boolean z = false;
        while (d2 < c2 && !z) {
            int i = d2 + 1;
            z = ((char) kVar.f10948a[d2]) == ')';
            d2 = i;
        }
        return kVar.e((d2 - 1) - kVar.d()).trim();
    }

    private static void a(k kVar, d dVar, StringBuilder sb) {
        b(kVar);
        String d2 = d(kVar, sb);
        if (!"".equals(d2) && ":".equals(a(kVar, sb))) {
            b(kVar);
            String c2 = c(kVar, sb);
            if (c2 != null && !"".equals(c2)) {
                int d3 = kVar.d();
                String a2 = a(kVar, sb);
                if (!";".equals(a2)) {
                    if ("}".equals(a2)) {
                        kVar.c(d3);
                    } else {
                        return;
                    }
                }
                if (ViewProps.COLOR.equals(d2)) {
                    dVar.a(c.b(c2));
                } else if ("background-color".equals(d2)) {
                    dVar.b(c.b(c2));
                } else if ("text-decoration".equals(d2)) {
                    if ("underline".equals(c2)) {
                        dVar.a(true);
                    }
                } else if ("font-family".equals(d2)) {
                    dVar.d(c2);
                } else if ("font-weight".equals(d2)) {
                    if ("bold".equals(c2)) {
                        dVar.b(true);
                    }
                } else if ("font-style".equals(d2) && "italic".equals(c2)) {
                    dVar.c(true);
                }
            }
        }
    }

    static void b(k kVar) {
        while (true) {
            boolean z = true;
            while (kVar.b() > 0 && z) {
                if (!e(kVar) && !f(kVar)) {
                    z = false;
                }
            }
            return;
        }
    }

    static String a(k kVar, StringBuilder sb) {
        b(kVar);
        if (kVar.b() == 0) {
            return null;
        }
        String d2 = d(kVar, sb);
        if (!"".equals(d2)) {
            return d2;
        }
        return "" + ((char) kVar.g());
    }

    private static boolean e(k kVar) {
        char a2 = a(kVar, kVar.d());
        if (a2 != 9 && a2 != 10 && a2 != 12 && a2 != 13 && a2 != ' ') {
            return false;
        }
        kVar.d(1);
        return true;
    }

    static void c(k kVar) {
        do {
        } while (!TextUtils.isEmpty(kVar.y()));
    }

    private static char a(k kVar, int i) {
        return (char) kVar.f10948a[i];
    }

    private static String c(k kVar, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        boolean z = false;
        while (!z) {
            int d2 = kVar.d();
            String a2 = a(kVar, sb);
            if (a2 == null) {
                return null;
            }
            if ("}".equals(a2) || ";".equals(a2)) {
                kVar.c(d2);
                z = true;
            } else {
                sb2.append(a2);
            }
        }
        return sb2.toString();
    }

    private static boolean f(k kVar) {
        int d2 = kVar.d();
        int c2 = kVar.c();
        byte[] bArr = kVar.f10948a;
        if (d2 + 2 > c2) {
            return false;
        }
        int i = d2 + 1;
        if (bArr[d2] != 47) {
            return false;
        }
        int i2 = i + 1;
        if (bArr[i] != 42) {
            return false;
        }
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= c2) {
                kVar.d(c2 - kVar.d());
                return true;
            } else if (((char) bArr[i2]) == '*' && ((char) bArr[i3]) == '/') {
                i2 = i3 + 1;
                c2 = i2;
            } else {
                i2 = i3;
            }
        }
    }

    private static String d(k kVar, StringBuilder sb) {
        boolean z = false;
        sb.setLength(0);
        int d2 = kVar.d();
        int c2 = kVar.c();
        while (d2 < c2 && !z) {
            char c3 = (char) kVar.f10948a[d2];
            if ((c3 < 'A' || c3 > 'Z') && ((c3 < 'a' || c3 > 'z') && !((c3 >= '0' && c3 <= '9') || c3 == '#' || c3 == '-' || c3 == '.' || c3 == '_'))) {
                z = true;
            } else {
                d2++;
                sb.append(c3);
            }
        }
        kVar.d(d2 - kVar.d());
        return sb.toString();
    }

    private void a(d dVar, String str) {
        if (!"".equals(str)) {
            int indexOf = str.indexOf(91);
            if (indexOf != -1) {
                Matcher matcher = f10575a.matcher(str.substring(indexOf));
                if (matcher.matches()) {
                    dVar.c(matcher.group(1));
                }
                str = str.substring(0, indexOf);
            }
            String[] split = str.split("\\.");
            String str2 = split[0];
            int indexOf2 = str2.indexOf(35);
            if (indexOf2 != -1) {
                dVar.b(str2.substring(0, indexOf2));
                dVar.a(str2.substring(indexOf2 + 1));
            } else {
                dVar.b(str2);
            }
            if (split.length > 1) {
                dVar.a((String[]) Arrays.copyOfRange(split, 1, split.length));
            }
        }
    }
}
