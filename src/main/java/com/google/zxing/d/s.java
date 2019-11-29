package com.google.zxing.d;

import com.google.zxing.c;
import com.google.zxing.c.a;
import com.google.zxing.e;
import com.google.zxing.g;
import com.google.zxing.j;
import com.google.zxing.m;
import com.google.zxing.q;
import com.google.zxing.w;
import java.util.Map;

public final class s extends x {

    /* renamed from: a  reason: collision with root package name */
    private final x f14618a = new h();

    public w a(int i, a aVar, int[] iArr, Map<j, ?> map) throws q, m, g {
        return a(this.f14618a.a(i, aVar, iArr, map));
    }

    public w a(int i, a aVar, Map<j, ?> map) throws q, m, g {
        return a(this.f14618a.a(i, aVar, map));
    }

    public w a(e eVar, Map<j, ?> map) throws q, m {
        return a(this.f14618a.a(eVar, map));
    }

    /* access modifiers changed from: package-private */
    public c b() {
        return c.UPC_A;
    }

    /* access modifiers changed from: protected */
    public int a(a aVar, int[] iArr, StringBuilder sb) throws q {
        return this.f14618a.a(aVar, iArr, sb);
    }

    private static w a(w wVar) throws m {
        String a2 = wVar.a();
        if (a2.charAt(0) == '0') {
            return new w(a2.substring(1), (byte[]) null, wVar.c(), c.UPC_A);
        }
        throw m.a();
    }
}
