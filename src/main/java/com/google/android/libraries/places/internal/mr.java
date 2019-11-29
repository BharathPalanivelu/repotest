package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.kv;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class mr {

    /* renamed from: a  reason: collision with root package name */
    public static final nf<?, ?> f12980a = a(false);

    /* renamed from: b  reason: collision with root package name */
    public static final nf<?, ?> f12981b = a(true);

    /* renamed from: c  reason: collision with root package name */
    public static final nf<?, ?> f12982c = new nf<>((byte) 0);

    /* renamed from: d  reason: collision with root package name */
    private static final Class<?> f12983d = a();

    public static void a(Class<?> cls) {
        if (!kv.class.isAssignableFrom(cls)) {
            Class<?> cls2 = f12983d;
            if (cls2 != null && !cls2.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            }
        }
    }

    public static void a(int i, List<Double> list, nt ntVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            ntVar.g(i, list, z);
        }
    }

    public static void b(int i, List<Float> list, nt ntVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            ntVar.f(i, list, z);
        }
    }

    public static void c(int i, List<Long> list, nt ntVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            ntVar.c(i, list, z);
        }
    }

    public static void d(int i, List<Long> list, nt ntVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            ntVar.d(i, list, z);
        }
    }

    public static void e(int i, List<Long> list, nt ntVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            ntVar.n(i, list, z);
        }
    }

    public static void f(int i, List<Long> list, nt ntVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            ntVar.e(i, list, z);
        }
    }

    public static void g(int i, List<Long> list, nt ntVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            ntVar.l(i, list, z);
        }
    }

    public static void h(int i, List<Integer> list, nt ntVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            ntVar.a(i, list, z);
        }
    }

    public static void i(int i, List<Integer> list, nt ntVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            ntVar.j(i, list, z);
        }
    }

    public static void j(int i, List<Integer> list, nt ntVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            ntVar.m(i, list, z);
        }
    }

    public static void k(int i, List<Integer> list, nt ntVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            ntVar.b(i, list, z);
        }
    }

    public static void l(int i, List<Integer> list, nt ntVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            ntVar.k(i, list, z);
        }
    }

    public static void m(int i, List<Integer> list, nt ntVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            ntVar.h(i, list, z);
        }
    }

    public static void n(int i, List<Boolean> list, nt ntVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            ntVar.i(i, list, z);
        }
    }

    public static void a(int i, List<String> list, nt ntVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            ntVar.a(i, list);
        }
    }

    public static void b(int i, List<kc> list, nt ntVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            ntVar.b(i, list);
        }
    }

    public static void a(int i, List<?> list, nt ntVar, mp mpVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            ntVar.a(i, list, mpVar);
        }
    }

    public static void b(int i, List<?> list, nt ntVar, mp mpVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            ntVar.b(i, list, mpVar);
        }
    }

    static int a(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof lp) {
            lp lpVar = (lp) list;
            i = 0;
            while (i2 < size) {
                i += kk.d(lpVar.a(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + kk.d(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int a(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return a(list) + (list.size() * kk.e(i));
    }

    static int b(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof lp) {
            lp lpVar = (lp) list;
            i = 0;
            while (i2 < size) {
                i += kk.e(lpVar.a(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + kk.e(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int b(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return b(list) + (size * kk.e(i));
    }

    static int c(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof lp) {
            lp lpVar = (lp) list;
            i = 0;
            while (i2 < size) {
                i += kk.f(lpVar.a(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + kk.f(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int c(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return c(list) + (size * kk.e(i));
    }

    static int d(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof kw) {
            kw kwVar = (kw) list;
            i = 0;
            while (i2 < size) {
                i += kk.i(kwVar.a(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + kk.i(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int d(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return d(list) + (size * kk.e(i));
    }

    static int e(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof kw) {
            kw kwVar = (kw) list;
            i = 0;
            while (i2 < size) {
                i += kk.f(kwVar.a(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + kk.f(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int e(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return e(list) + (size * kk.e(i));
    }

    static int f(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof kw) {
            kw kwVar = (kw) list;
            i = 0;
            while (i2 < size) {
                i += kk.g(kwVar.a(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + kk.g(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int f(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return f(list) + (size * kk.e(i));
    }

    static int g(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof kw) {
            kw kwVar = (kw) list;
            i = 0;
            while (i2 < size) {
                i += kk.h(kwVar.a(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + kk.h(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int g(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return g(list) + (size * kk.e(i));
    }

    static int h(List<?> list) {
        return list.size() << 2;
    }

    static int h(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * kk.i(i, 0);
    }

    static int i(List<?> list) {
        return list.size() << 3;
    }

    static int i(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * kk.g(i, 0);
    }

    static int j(List<?> list) {
        return list.size();
    }

    static int j(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * kk.b(i, true);
    }

    static int a(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int e2 = kk.e(i) * size;
        if (list instanceof ll) {
            ll llVar = (ll) list;
            while (i4 < size) {
                Object a2 = llVar.a(i4);
                if (a2 instanceof kc) {
                    i3 = kk.b((kc) a2);
                } else {
                    i3 = kk.b((String) a2);
                }
                e2 += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof kc) {
                    i2 = kk.b((kc) obj);
                } else {
                    i2 = kk.b((String) obj);
                }
                e2 += i2;
                i4++;
            }
        }
        return e2;
    }

    static int a(int i, Object obj, mp mpVar) {
        if (obj instanceof lj) {
            return kk.a(i, (lj) obj);
        }
        return kk.b(i, (ma) obj, mpVar);
    }

    static int a(int i, List<?> list, mp mpVar) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e2 = kk.e(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof lj) {
                i2 = kk.a((lj) obj);
            } else {
                i2 = kk.a((ma) obj, mpVar);
            }
            e2 += i2;
        }
        return e2;
    }

    static int b(int i, List<kc> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e2 = size * kk.e(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            e2 += kk.b(list.get(i2));
        }
        return e2;
    }

    static int b(int i, List<ma> list, mp mpVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += kk.c(i, list.get(i3), mpVar);
        }
        return i2;
    }

    private static nf<?, ?> a(boolean z) {
        try {
            Class<?> b2 = b();
            if (b2 == null) {
                return null;
            }
            return (nf) b2.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> a() {
        try {
            return Class.forName("com.google.c.r");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> b() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static <T> void a(lw lwVar, T t, T t2, long j) {
        nk.a((Object) t, j, lwVar.a(nk.f(t, j), nk.f(t2, j)));
    }

    static <T, FT extends kq<FT>> void a(kn<FT> knVar, T t, T t2) {
        kp<kv.c> a2 = knVar.a((Object) t2);
        if (!a2.f12885a.isEmpty()) {
            kp<kv.c> b2 = knVar.b(t);
            for (int i = 0; i < a2.f12885a.b(); i++) {
                b2.a((Map.Entry<kv.c, Object>) a2.f12885a.b(i));
            }
            for (Map.Entry<FieldDescriptorType, Object> a3 : a2.f12885a.c()) {
                b2.a((Map.Entry<kv.c, Object>) a3);
            }
        }
    }

    static <T, UT, UB> void a(nf<UT, UB> nfVar, T t, T t2) {
        nfVar.a((Object) t, nfVar.b(nfVar.a((Object) t), nfVar.a((Object) t2)));
    }
}
