package com.google.zxing;

import com.google.zxing.c.b;
import com.google.zxing.d.d;
import com.google.zxing.d.f;
import com.google.zxing.d.i;
import com.google.zxing.d.k;
import com.google.zxing.d.n;
import com.google.zxing.d.t;
import java.util.Map;

public final class p implements ab {
    public b a(String str, c cVar, int i, int i2, Map<l, ?> map) throws ac {
        ab abVar;
        switch (cVar) {
            case EAN_8:
                abVar = new k();
                break;
            case EAN_13:
                abVar = new i();
                break;
            case UPC_A:
                abVar = new t();
                break;
            case QR_CODE:
                abVar = new com.google.zxing.e.b();
                break;
            case CODE_39:
                abVar = new f();
                break;
            case CODE_128:
                abVar = new d();
                break;
            case ITF:
                abVar = new n();
                break;
            case CODABAR:
                abVar = new com.google.zxing.d.b();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format " + cVar);
        }
        return abVar.a(str, cVar, i, i2, map);
    }
}
