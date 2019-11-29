package com.bca.xco.widget.d.a.a.g;

import com.bca.xco.widget.d.a.a.c;
import com.bca.xco.widget.d.b.h;
import java.io.IOException;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    static final h f4933a = h.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b  reason: collision with root package name */
    static final String[] f4934b = new String[64];

    /* renamed from: c  reason: collision with root package name */
    static final String[] f4935c = new String[256];

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f4936d = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = f4935c;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = c.a("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
            i2++;
        }
        String[] strArr2 = f4934b;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i3 : iArr) {
            f4934b[i3 | 8] = f4934b[i3] + "|PADDED";
        }
        String[] strArr3 = f4934b;
        strArr3[4] = "END_HEADERS";
        strArr3[32] = "PRIORITY";
        strArr3[36] = "END_HEADERS|PRIORITY";
        for (int i4 : new int[]{4, 32, 36}) {
            for (int i5 : iArr) {
                int i6 = i5 | i4;
                f4934b[i6] = f4934b[i5] + '|' + f4934b[i4];
                f4934b[i6 | 8] = f4934b[i5] + '|' + f4934b[i4] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr4 = f4934b;
            if (i < strArr4.length) {
                if (strArr4[i] == null) {
                    strArr4[i] = f4935c[i];
                }
                i++;
            } else {
                return;
            }
        }
    }

    private f() {
    }

    static IllegalArgumentException a(String str, Object... objArr) {
        throw new IllegalArgumentException(c.a(str, objArr));
    }

    static IOException b(String str, Object... objArr) {
        throw new IOException(c.a(str, objArr));
    }

    static String a(boolean z, int i, int i2, byte b2, byte b3) {
        String[] strArr = f4936d;
        String a2 = b2 < strArr.length ? strArr[b2] : c.a("0x%02x", Byte.valueOf(b2));
        String a3 = a(b2, b3);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = a2;
        objArr[4] = a3;
        return c.a("%s 0x%08x %5d %-13s %s", objArr);
    }

    static String a(byte b2, byte b3) {
        if (b3 == 0) {
            return "";
        }
        if (!(b2 == 2 || b2 == 3)) {
            if (b2 == 4 || b2 == 6) {
                return b3 == 1 ? "ACK" : f4935c[b3];
            }
            if (!(b2 == 7 || b2 == 8)) {
                String[] strArr = f4934b;
                String str = b3 < strArr.length ? strArr[b3] : f4935c[b3];
                if (b2 == 5 && (b3 & 4) != 0) {
                    return str.replace("HEADERS", "PUSH_PROMISE");
                }
                if (b2 != 0 || (b3 & 32) == 0) {
                    return str;
                }
                return str.replace("PRIORITY", "COMPRESSED");
            }
        }
        return f4935c[b3];
    }
}
