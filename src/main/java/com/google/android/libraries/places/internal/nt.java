package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.List;
import java.util.Map;

class nt {

    /* renamed from: a  reason: collision with root package name */
    public final kk f13049a;

    public nu a() {
        return nu.ASCENDING;
    }

    public void a(int i, int i2) throws IOException {
        this.f13049a.e(i, i2);
    }

    public void a(int i, long j) throws IOException {
        this.f13049a.a(i, j);
    }

    public void b(int i, long j) throws IOException {
        this.f13049a.c(i, j);
    }

    public void a(int i, float f2) throws IOException {
        this.f13049a.a(i, f2);
    }

    public void a(int i, double d2) throws IOException {
        this.f13049a.a(i, d2);
    }

    public void b(int i, int i2) throws IOException {
        this.f13049a.b(i, i2);
    }

    public void c(int i, long j) throws IOException {
        this.f13049a.a(i, j);
    }

    public void c(int i, int i2) throws IOException {
        this.f13049a.b(i, i2);
    }

    public void d(int i, long j) throws IOException {
        this.f13049a.c(i, j);
    }

    public void d(int i, int i2) throws IOException {
        this.f13049a.e(i, i2);
    }

    public void a(int i, boolean z) throws IOException {
        this.f13049a.a(i, z);
    }

    public void a(int i, String str) throws IOException {
        this.f13049a.a(i, str);
    }

    public void a(int i, kc kcVar) throws IOException {
        this.f13049a.a(i, kcVar);
    }

    public void e(int i, int i2) throws IOException {
        this.f13049a.c(i, i2);
    }

    public void f(int i, int i2) throws IOException {
        this.f13049a.d(i, i2);
    }

    public void e(int i, long j) throws IOException {
        this.f13049a.b(i, j);
    }

    public void a(int i, Object obj, mp mpVar) throws IOException {
        this.f13049a.a(i, (ma) obj, mpVar);
    }

    @Deprecated
    public void b(int i, Object obj, mp mpVar) throws IOException {
        kk kkVar = this.f13049a;
        kkVar.a(i, 3);
        mpVar.a((ma) obj, kkVar.f12873c);
        kkVar.a(i, 4);
    }

    @Deprecated
    public void a(int i) throws IOException {
        this.f13049a.a(i, 3);
    }

    @Deprecated
    public void b(int i) throws IOException {
        this.f13049a.a(i, 4);
    }

    public void a(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13049a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += kk.f(list.get(i4).intValue());
            }
            this.f13049a.b(i3);
            while (i2 < list.size()) {
                this.f13049a.a(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13049a.b(i, list.get(i2).intValue());
            i2++;
        }
    }

    public void b(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13049a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                list.get(i4).intValue();
                i3 += kk.a();
            }
            this.f13049a.b(i3);
            while (i2 < list.size()) {
                this.f13049a.d(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13049a.e(i, list.get(i2).intValue());
            i2++;
        }
    }

    public void c(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13049a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += kk.d(list.get(i4).longValue());
            }
            this.f13049a.b(i3);
            while (i2 < list.size()) {
                this.f13049a.a(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13049a.a(i, list.get(i2).longValue());
            i2++;
        }
    }

    public void d(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13049a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += kk.e(list.get(i4).longValue());
            }
            this.f13049a.b(i3);
            while (i2 < list.size()) {
                this.f13049a.a(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13049a.a(i, list.get(i2).longValue());
            i2++;
        }
    }

    public void e(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13049a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                list.get(i4).longValue();
                i3 += kk.c();
            }
            this.f13049a.b(i3);
            while (i2 < list.size()) {
                this.f13049a.c(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13049a.c(i, list.get(i2).longValue());
            i2++;
        }
    }

    public void f(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13049a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                list.get(i4).floatValue();
                i3 += kk.e();
            }
            this.f13049a.b(i3);
            while (i2 < list.size()) {
                this.f13049a.a(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13049a.a(i, list.get(i2).floatValue());
            i2++;
        }
    }

    public void g(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13049a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                list.get(i4).doubleValue();
                i3 += kk.f();
            }
            this.f13049a.b(i3);
            while (i2 < list.size()) {
                this.f13049a.a(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13049a.a(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    public void h(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13049a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += kk.i(list.get(i4).intValue());
            }
            this.f13049a.b(i3);
            while (i2 < list.size()) {
                this.f13049a.a(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13049a.b(i, list.get(i2).intValue());
            i2++;
        }
    }

    public void i(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13049a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                list.get(i4).booleanValue();
                i3 += kk.g();
            }
            this.f13049a.b(i3);
            while (i2 < list.size()) {
                this.f13049a.a(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13049a.a(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    public void a(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof ll) {
            ll llVar = (ll) list;
            while (i2 < list.size()) {
                b(i, llVar.a(i2));
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13049a.a(i, list.get(i2));
            i2++;
        }
    }

    public void b(int i, List<kc> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f13049a.a(i, list.get(i2));
        }
    }

    public void j(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13049a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += kk.g(list.get(i4).intValue());
            }
            this.f13049a.b(i3);
            while (i2 < list.size()) {
                this.f13049a.b(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13049a.c(i, list.get(i2).intValue());
            i2++;
        }
    }

    public void k(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13049a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                list.get(i4).intValue();
                i3 += kk.b();
            }
            this.f13049a.b(i3);
            while (i2 < list.size()) {
                this.f13049a.d(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13049a.e(i, list.get(i2).intValue());
            i2++;
        }
    }

    public void l(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13049a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                list.get(i4).longValue();
                i3 += kk.d();
            }
            this.f13049a.b(i3);
            while (i2 < list.size()) {
                this.f13049a.c(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13049a.c(i, list.get(i2).longValue());
            i2++;
        }
    }

    public void m(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13049a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += kk.h(list.get(i4).intValue());
            }
            this.f13049a.b(i3);
            while (i2 < list.size()) {
                this.f13049a.c(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13049a.d(i, list.get(i2).intValue());
            i2++;
        }
    }

    public void n(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13049a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += kk.f(list.get(i4).longValue());
            }
            this.f13049a.b(i3);
            while (i2 < list.size()) {
                this.f13049a.b(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13049a.b(i, list.get(i2).longValue());
            i2++;
        }
    }

    public void a(int i, List<?> list, mp mpVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            a(i, (Object) list.get(i2), mpVar);
        }
    }

    @Deprecated
    public void b(int i, List<?> list, mp mpVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            b(i, (Object) list.get(i2), mpVar);
        }
    }

    public void a(int i, Object obj) throws IOException {
        if (obj instanceof kc) {
            this.f13049a.b(i, (kc) obj);
        } else {
            this.f13049a.a(i, (ma) obj);
        }
    }

    public <K, V> void a(int i, lu<K, V> luVar, Map<K, V> map) throws IOException {
        kk kkVar = this.f13049a;
        for (Map.Entry next : map.entrySet()) {
            this.f13049a.a(i, 2);
            this.f13049a.b(lt.a(luVar, next.getKey(), next.getValue()));
            lt.a(this.f13049a, luVar, next.getKey(), next.getValue());
        }
    }

    public static nt a(kk kkVar) {
        if (kkVar.f12873c != null) {
            return kkVar.f12873c;
        }
        return new nt(kkVar);
    }

    nt(kk kkVar) {
        this.f13049a = (kk) kx.a(kkVar, "output");
        this.f13049a.f12873c = this;
    }

    /* access modifiers changed from: package-private */
    public void b(int i, Object obj) throws IOException {
        if (obj instanceof String) {
            this.f13049a.a(i, (String) obj);
        } else {
            this.f13049a.a(i, (kc) obj);
        }
    }
}
