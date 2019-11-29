package com.bca.xco.widget.d.a.a.f;

import com.bca.xco.widget.d.a.v;
import java.net.ProtocolException;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final v f4888a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4889b;

    /* renamed from: c  reason: collision with root package name */
    public final String f4890c;

    public l(v vVar, int i, String str) {
        this.f4888a = vVar;
        this.f4889b = i;
        this.f4890c = str;
    }

    public static l a(String str) {
        v vVar;
        String str2;
        int i = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                vVar = v.HTTP_1_0;
            } else if (charAt == 1) {
                vVar = v.HTTP_1_1;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            vVar = v.HTTP_1_0;
            i = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        int i2 = i + 3;
        if (str.length() >= i2) {
            try {
                int parseInt = Integer.parseInt(str.substring(i, i2));
                if (str.length() <= i2) {
                    str2 = "";
                } else if (str.charAt(i2) == ' ') {
                    str2 = str.substring(i + 4);
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                return new l(vVar, parseInt, str2);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4888a == v.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f4889b);
        if (this.f4890c != null) {
            sb.append(' ');
            sb.append(this.f4890c);
        }
        return sb.toString();
    }
}
