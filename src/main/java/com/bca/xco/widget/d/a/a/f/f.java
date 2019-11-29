package com.bca.xco.widget.d.a.a.f;

import com.bca.xco.widget.d.a.e;
import com.bca.xco.widget.d.a.o;
import com.bca.xco.widget.d.a.r;
import com.bca.xco.widget.d.a.t;
import com.bca.xco.widget.d.a.z;
import com.tencent.qcloud.core.http.HttpConstants;
import java.util.List;

public final class f {
    public static long a(z zVar) {
        return a(zVar.d());
    }

    public static long a(r rVar) {
        return a(rVar.a(HttpConstants.Header.CONTENT_LENGTH));
    }

    private static long a(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static void a(e eVar, t tVar, r rVar) {
        if (eVar != e.f5042a) {
            List<o> a2 = o.a(tVar, rVar);
            if (!a2.isEmpty()) {
                eVar.a(tVar, a2);
            }
        }
    }

    public static boolean b(z zVar) {
        if (zVar.a().b().equals("HEAD")) {
            return false;
        }
        int b2 = zVar.b();
        if (((b2 >= 100 && b2 < 200) || b2 == 204 || b2 == 304) && a(zVar) == -1 && !"chunked".equalsIgnoreCase(zVar.a(HttpConstants.Header.TRANSFER_ENCODING))) {
            return false;
        }
        return true;
    }

    public static int a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt != ' ' && charAt != 9) {
                break;
            }
            i++;
        }
        return i;
    }

    public static int b(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
