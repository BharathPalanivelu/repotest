package com.google.android.exoplayer2.p.g;

import android.text.TextUtils;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.exoplayer2.s.d;
import com.google.android.exoplayer2.s.l;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f11180a = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* renamed from: b  reason: collision with root package name */
    private final l f11181b = new l();

    /* renamed from: c  reason: collision with root package name */
    private final StringBuilder f11182c = new StringBuilder();

    public d a(l lVar) {
        this.f11182c.setLength(0);
        int d2 = lVar.d();
        c(lVar);
        this.f11181b.a(lVar.f11422a, lVar.d());
        this.f11181b.c(d2);
        String b2 = b(this.f11181b, this.f11182c);
        if (b2 == null || !"{".equals(a(this.f11181b, this.f11182c))) {
            return null;
        }
        d dVar = new d();
        a(dVar, b2);
        String str = null;
        boolean z = false;
        while (!z) {
            int d3 = this.f11181b.d();
            str = a(this.f11181b, this.f11182c);
            boolean z2 = str == null || "}".equals(str);
            if (!z2) {
                this.f11181b.c(d3);
                a(this.f11181b, dVar, this.f11182c);
            }
            z = z2;
        }
        if ("}".equals(str)) {
            return dVar;
        }
        return null;
    }

    private static String b(l lVar, StringBuilder sb) {
        b(lVar);
        if (lVar.b() < 5 || !"::cue".equals(lVar.e(5))) {
            return null;
        }
        int d2 = lVar.d();
        String a2 = a(lVar, sb);
        if (a2 == null) {
            return null;
        }
        if ("{".equals(a2)) {
            lVar.c(d2);
            return "";
        }
        String d3 = SQLBuilder.PARENTHESES_LEFT.equals(a2) ? d(lVar) : null;
        String a3 = a(lVar, sb);
        if (!SQLBuilder.PARENTHESES_RIGHT.equals(a3) || a3 == null) {
            return null;
        }
        return d3;
    }

    private static String d(l lVar) {
        int d2 = lVar.d();
        int c2 = lVar.c();
        boolean z = false;
        while (d2 < c2 && !z) {
            int i = d2 + 1;
            z = ((char) lVar.f11422a[d2]) == ')';
            d2 = i;
        }
        return lVar.e((d2 - 1) - lVar.d()).trim();
    }

    private static void a(l lVar, d dVar, StringBuilder sb) {
        b(lVar);
        String d2 = d(lVar, sb);
        if (!"".equals(d2) && ":".equals(a(lVar, sb))) {
            b(lVar);
            String c2 = c(lVar, sb);
            if (c2 != null && !"".equals(c2)) {
                int d3 = lVar.d();
                String a2 = a(lVar, sb);
                if (!";".equals(a2)) {
                    if ("}".equals(a2)) {
                        lVar.c(d3);
                    } else {
                        return;
                    }
                }
                if (ViewProps.COLOR.equals(d2)) {
                    dVar.a(d.b(c2));
                } else if ("background-color".equals(d2)) {
                    dVar.b(d.b(c2));
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

    static void b(l lVar) {
        while (true) {
            boolean z = true;
            while (lVar.b() > 0 && z) {
                if (!e(lVar) && !f(lVar)) {
                    z = false;
                }
            }
            return;
        }
    }

    static String a(l lVar, StringBuilder sb) {
        b(lVar);
        if (lVar.b() == 0) {
            return null;
        }
        String d2 = d(lVar, sb);
        if (!"".equals(d2)) {
            return d2;
        }
        return "" + ((char) lVar.g());
    }

    private static boolean e(l lVar) {
        char a2 = a(lVar, lVar.d());
        if (a2 != 9 && a2 != 10 && a2 != 12 && a2 != 13 && a2 != ' ') {
            return false;
        }
        lVar.d(1);
        return true;
    }

    static void c(l lVar) {
        do {
        } while (!TextUtils.isEmpty(lVar.y()));
    }

    private static char a(l lVar, int i) {
        return (char) lVar.f11422a[i];
    }

    private static String c(l lVar, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        boolean z = false;
        while (!z) {
            int d2 = lVar.d();
            String a2 = a(lVar, sb);
            if (a2 == null) {
                return null;
            }
            if ("}".equals(a2) || ";".equals(a2)) {
                lVar.c(d2);
                z = true;
            } else {
                sb2.append(a2);
            }
        }
        return sb2.toString();
    }

    private static boolean f(l lVar) {
        int d2 = lVar.d();
        int c2 = lVar.c();
        byte[] bArr = lVar.f11422a;
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
                lVar.d(c2 - lVar.d());
                return true;
            } else if (((char) bArr[i2]) == '*' && ((char) bArr[i3]) == '/') {
                i2 = i3 + 1;
                c2 = i2;
            } else {
                i2 = i3;
            }
        }
    }

    private static String d(l lVar, StringBuilder sb) {
        boolean z = false;
        sb.setLength(0);
        int d2 = lVar.d();
        int c2 = lVar.c();
        while (d2 < c2 && !z) {
            char c3 = (char) lVar.f11422a[d2];
            if ((c3 < 'A' || c3 > 'Z') && ((c3 < 'a' || c3 > 'z') && !((c3 >= '0' && c3 <= '9') || c3 == '#' || c3 == '-' || c3 == '.' || c3 == '_'))) {
                z = true;
            } else {
                d2++;
                sb.append(c3);
            }
        }
        lVar.d(d2 - lVar.d());
        return sb.toString();
    }

    private void a(d dVar, String str) {
        if (!"".equals(str)) {
            int indexOf = str.indexOf(91);
            if (indexOf != -1) {
                Matcher matcher = f11180a.matcher(str.substring(indexOf));
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
