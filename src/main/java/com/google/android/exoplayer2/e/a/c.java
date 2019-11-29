package com.google.android.exoplayer2.e.a;

import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.e.n;
import com.google.android.exoplayer2.n.k;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

final class c extends d {

    /* renamed from: b  reason: collision with root package name */
    private long f9321b = -9223372036854775807L;

    /* access modifiers changed from: protected */
    public boolean a(k kVar) {
        return true;
    }

    public c(n nVar) {
        super(nVar);
    }

    public long a() {
        return this.f9321b;
    }

    /* access modifiers changed from: protected */
    public void a(k kVar, long j) throws ak {
        if (b(kVar) != 2) {
            throw new ak();
        } else if ("onMetaData".equals(e(kVar)) && b(kVar) == 8) {
            HashMap<String, Object> h = h(kVar);
            if (h.containsKey("duration")) {
                double doubleValue = ((Double) h.get("duration")).doubleValue();
                if (doubleValue > 0.0d) {
                    this.f9321b = (long) (doubleValue * 1000000.0d);
                }
            }
        }
    }

    private static int b(k kVar) {
        return kVar.g();
    }

    private static Boolean c(k kVar) {
        boolean z = true;
        if (kVar.g() != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    private static Double d(k kVar) {
        return Double.valueOf(Double.longBitsToDouble(kVar.p()));
    }

    private static String e(k kVar) {
        int h = kVar.h();
        int d2 = kVar.d();
        kVar.d(h);
        return new String(kVar.f10948a, d2, h);
    }

    private static ArrayList<Object> f(k kVar) {
        int t = kVar.t();
        ArrayList<Object> arrayList = new ArrayList<>(t);
        for (int i = 0; i < t; i++) {
            arrayList.add(a(kVar, b(kVar)));
        }
        return arrayList;
    }

    private static HashMap<String, Object> g(k kVar) {
        HashMap<String, Object> hashMap = new HashMap<>();
        while (true) {
            String e2 = e(kVar);
            int b2 = b(kVar);
            if (b2 == 9) {
                return hashMap;
            }
            hashMap.put(e2, a(kVar, b2));
        }
    }

    private static HashMap<String, Object> h(k kVar) {
        int t = kVar.t();
        HashMap<String, Object> hashMap = new HashMap<>(t);
        for (int i = 0; i < t; i++) {
            hashMap.put(e(kVar), a(kVar, b(kVar)));
        }
        return hashMap;
    }

    private static Date i(k kVar) {
        Date date = new Date((long) d(kVar).doubleValue());
        kVar.d(2);
        return date;
    }

    private static Object a(k kVar, int i) {
        if (i == 0) {
            return d(kVar);
        }
        if (i == 1) {
            return c(kVar);
        }
        if (i == 2) {
            return e(kVar);
        }
        if (i == 3) {
            return g(kVar);
        }
        if (i == 8) {
            return h(kVar);
        }
        if (i == 10) {
            return f(kVar);
        }
        if (i != 11) {
            return null;
        }
        return i(kVar);
    }
}
