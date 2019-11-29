package com.bca.xco.widget.d.a.a.f;

import com.bca.xco.widget.d.a.t;
import com.bca.xco.widget.d.a.x;
import java.net.Proxy;

public final class j {
    public static String a(x xVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(xVar.b());
        sb.append(' ');
        if (b(xVar, type)) {
            sb.append(xVar.a());
        } else {
            sb.append(a(xVar.a()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean b(x xVar, Proxy.Type type) {
        return !xVar.g() && type == Proxy.Type.HTTP;
    }

    public static String a(t tVar) {
        String h = tVar.h();
        String j = tVar.j();
        if (j == null) {
            return h;
        }
        return h + '?' + j;
    }
}
