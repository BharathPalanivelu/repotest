package com.google.android.exoplayer2.i.a;

import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.s.l;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

final class c extends d {

    /* renamed from: b  reason: collision with root package name */
    private long f9957b = -9223372036854775807L;

    /* access modifiers changed from: protected */
    public boolean a(l lVar) {
        return true;
    }

    public c(m mVar) {
        super(mVar);
    }

    public long a() {
        return this.f9957b;
    }

    /* access modifiers changed from: protected */
    public void a(l lVar, long j) throws p {
        if (b(lVar) != 2) {
            throw new p();
        } else if ("onMetaData".equals(e(lVar)) && b(lVar) == 8) {
            HashMap<String, Object> h = h(lVar);
            if (h.containsKey("duration")) {
                double doubleValue = ((Double) h.get("duration")).doubleValue();
                if (doubleValue > 0.0d) {
                    this.f9957b = (long) (doubleValue * 1000000.0d);
                }
            }
        }
    }

    private static int b(l lVar) {
        return lVar.g();
    }

    private static Boolean c(l lVar) {
        boolean z = true;
        if (lVar.g() != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    private static Double d(l lVar) {
        return Double.valueOf(Double.longBitsToDouble(lVar.p()));
    }

    private static String e(l lVar) {
        int h = lVar.h();
        int d2 = lVar.d();
        lVar.d(h);
        return new String(lVar.f11422a, d2, h);
    }

    private static ArrayList<Object> f(l lVar) {
        int t = lVar.t();
        ArrayList<Object> arrayList = new ArrayList<>(t);
        for (int i = 0; i < t; i++) {
            arrayList.add(a(lVar, b(lVar)));
        }
        return arrayList;
    }

    private static HashMap<String, Object> g(l lVar) {
        HashMap<String, Object> hashMap = new HashMap<>();
        while (true) {
            String e2 = e(lVar);
            int b2 = b(lVar);
            if (b2 == 9) {
                return hashMap;
            }
            hashMap.put(e2, a(lVar, b2));
        }
    }

    private static HashMap<String, Object> h(l lVar) {
        int t = lVar.t();
        HashMap<String, Object> hashMap = new HashMap<>(t);
        for (int i = 0; i < t; i++) {
            hashMap.put(e(lVar), a(lVar, b(lVar)));
        }
        return hashMap;
    }

    private static Date i(l lVar) {
        Date date = new Date((long) d(lVar).doubleValue());
        lVar.d(2);
        return date;
    }

    private static Object a(l lVar, int i) {
        if (i == 0) {
            return d(lVar);
        }
        if (i == 1) {
            return c(lVar);
        }
        if (i == 2) {
            return e(lVar);
        }
        if (i == 3) {
            return g(lVar);
        }
        if (i == 8) {
            return h(lVar);
        }
        if (i == 10) {
            return f(lVar);
        }
        if (i != 11) {
            return null;
        }
        return i(lVar);
    }
}
