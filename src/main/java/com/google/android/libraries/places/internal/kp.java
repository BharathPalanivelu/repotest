package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.kq;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class kp<FieldDescriptorType extends kq<FieldDescriptorType>> {

    /* renamed from: d  reason: collision with root package name */
    public static final kp f12884d = new kp((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public final ms<FieldDescriptorType, Object> f12885a = ms.a(16);

    /* renamed from: b  reason: collision with root package name */
    public boolean f12886b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f12887c = false;

    private kp() {
    }

    private kp(byte b2) {
        a();
    }

    public final void a() {
        if (!this.f12886b) {
            this.f12885a.a();
            this.f12886b = true;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kp)) {
            return false;
        }
        return this.f12885a.equals(((kp) obj).f12885a);
    }

    public final int hashCode() {
        return this.f12885a.hashCode();
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> b() {
        if (this.f12887c) {
            return new li(this.f12885a.entrySet().iterator());
        }
        return this.f12885a.entrySet().iterator();
    }

    public final Object a(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f12885a.get(fielddescriptortype);
        return obj instanceof lg ? lg.a() : obj;
    }

    public final void a(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.d()) {
            a(fielddescriptortype.b(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                a(fielddescriptortype.b(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof lg) {
            this.f12887c = true;
        }
        this.f12885a.put(fielddescriptortype, obj);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0015, code lost:
        if ((r3 instanceof com.google.android.libraries.places.internal.lg) == false) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        if ((r3 instanceof com.google.android.libraries.places.internal.ky) == false) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(com.google.android.libraries.places.internal.nr r2, java.lang.Object r3) {
        /*
            com.google.android.libraries.places.internal.kx.a(r3)
            com.google.android.libraries.places.internal.ns r2 = r2.s
            int r2 = r2.ordinal()
            r0 = 1
            r1 = 0
            switch(r2) {
                case 0: goto L_0x003a;
                case 1: goto L_0x0037;
                case 2: goto L_0x0034;
                case 3: goto L_0x0031;
                case 4: goto L_0x002e;
                case 5: goto L_0x002b;
                case 6: goto L_0x0022;
                case 7: goto L_0x0018;
                case 8: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x003d
        L_0x000f:
            boolean r2 = r3 instanceof com.google.android.libraries.places.internal.ma
            if (r2 != 0) goto L_0x0020
            boolean r2 = r3 instanceof com.google.android.libraries.places.internal.lg
            if (r2 == 0) goto L_0x003d
            goto L_0x0020
        L_0x0018:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0020
            boolean r2 = r3 instanceof com.google.android.libraries.places.internal.ky
            if (r2 == 0) goto L_0x003d
        L_0x0020:
            r1 = 1
            goto L_0x003d
        L_0x0022:
            boolean r2 = r3 instanceof com.google.android.libraries.places.internal.kc
            if (r2 != 0) goto L_0x0020
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L_0x003d
            goto L_0x0020
        L_0x002b:
            boolean r0 = r3 instanceof java.lang.String
            goto L_0x003c
        L_0x002e:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L_0x003c
        L_0x0031:
            boolean r0 = r3 instanceof java.lang.Double
            goto L_0x003c
        L_0x0034:
            boolean r0 = r3 instanceof java.lang.Float
            goto L_0x003c
        L_0x0037:
            boolean r0 = r3 instanceof java.lang.Long
            goto L_0x003c
        L_0x003a:
            boolean r0 = r3 instanceof java.lang.Integer
        L_0x003c:
            r1 = r0
        L_0x003d:
            if (r1 == 0) goto L_0x0040
            return
        L_0x0040:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            goto L_0x0049
        L_0x0048:
            throw r2
        L_0x0049:
            goto L_0x0048
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.kp.a(com.google.android.libraries.places.internal.nr, java.lang.Object):void");
    }

    public final boolean c() {
        for (int i = 0; i < this.f12885a.b(); i++) {
            if (!c(this.f12885a.b(i))) {
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> c2 : this.f12885a.c()) {
            if (!c(c2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean c(Map.Entry<FieldDescriptorType, Object> entry) {
        kq kqVar = (kq) entry.getKey();
        if (kqVar.c() == ns.MESSAGE) {
            if (kqVar.d()) {
                for (ma g2 : (List) entry.getValue()) {
                    if (!g2.g()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof ma) {
                    if (!((ma) value).g()) {
                        return false;
                    }
                } else if (value instanceof lg) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    private static Object a(Object obj) {
        if (obj instanceof mf) {
            return ((mf) obj).a();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* access modifiers changed from: package-private */
    public final void a(Map.Entry<FieldDescriptorType, Object> entry) {
        Object obj;
        kq kqVar = (kq) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof lg) {
            value = lg.a();
        }
        if (kqVar.d()) {
            Object a2 = a(kqVar);
            if (a2 == null) {
                a2 = new ArrayList();
            }
            for (Object a3 : (List) value) {
                ((List) a2).add(a(a3));
            }
            this.f12885a.put(kqVar, a2);
        } else if (kqVar.c() == ns.MESSAGE) {
            Object a4 = a(kqVar);
            if (a4 == null) {
                this.f12885a.put(kqVar, a(value));
                return;
            }
            if (a4 instanceof mf) {
                obj = kqVar.g();
            } else {
                ((ma) a4).i();
                obj = kqVar.f().d();
            }
            this.f12885a.put(kqVar, obj);
        } else {
            this.f12885a.put(kqVar, a(value));
        }
    }

    static void a(kk kkVar, nr nrVar, int i, Object obj) throws IOException {
        if (nrVar == nr.GROUP) {
            ma maVar = (ma) obj;
            if (kx.a(maVar)) {
                kkVar.a(i, 3);
                maVar.a(kkVar);
                return;
            }
            kkVar.a(i, 3);
            maVar.a(kkVar);
            kkVar.a(i, 4);
            return;
        }
        kkVar.a(i, nrVar.t);
        switch (nrVar.ordinal()) {
            case 0:
                kkVar.a(((Double) obj).doubleValue());
                return;
            case 1:
                kkVar.a(((Float) obj).floatValue());
                return;
            case 2:
                kkVar.a(((Long) obj).longValue());
                return;
            case 3:
                kkVar.a(((Long) obj).longValue());
                return;
            case 4:
                kkVar.a(((Integer) obj).intValue());
                return;
            case 5:
                kkVar.c(((Long) obj).longValue());
                return;
            case 6:
                kkVar.d(((Integer) obj).intValue());
                return;
            case 7:
                kkVar.a(((Boolean) obj).booleanValue());
                return;
            case 8:
                if (obj instanceof kc) {
                    kkVar.a((kc) obj);
                    return;
                } else {
                    kkVar.a((String) obj);
                    return;
                }
            case 9:
                ((ma) obj).a(kkVar);
                return;
            case 10:
                kkVar.a((ma) obj);
                return;
            case 11:
                if (obj instanceof kc) {
                    kkVar.a((kc) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                kkVar.b(bArr, 0, bArr.length);
                return;
            case 12:
                kkVar.b(((Integer) obj).intValue());
                return;
            case 13:
                if (obj instanceof ky) {
                    kkVar.a(((ky) obj).a());
                    return;
                } else {
                    kkVar.a(((Integer) obj).intValue());
                    return;
                }
            case 14:
                kkVar.d(((Integer) obj).intValue());
                return;
            case 15:
                kkVar.c(((Long) obj).longValue());
                return;
            case 16:
                kkVar.c(((Integer) obj).intValue());
                return;
            case 17:
                kkVar.b(((Long) obj).longValue());
                return;
            default:
                return;
        }
    }

    static int b(Map.Entry<FieldDescriptorType, Object> entry) {
        kq kqVar = (kq) entry.getKey();
        Object value = entry.getValue();
        if (kqVar.c() != ns.MESSAGE || kqVar.d() || kqVar.e()) {
            return b((kq<?>) kqVar, value);
        }
        if (value instanceof lg) {
            return kk.b(((kq) entry.getKey()).a(), (lj) (lg) value);
        }
        return kk.b(((kq) entry.getKey()).a(), (ma) value);
    }

    static int a(nr nrVar, int i, Object obj) {
        int e2 = kk.e(i);
        if (nrVar == nr.GROUP && !kx.a((ma) obj)) {
            e2 <<= 1;
        }
        return e2 + b(nrVar, obj);
    }

    private static int b(nr nrVar, Object obj) {
        switch (nrVar.ordinal()) {
            case 0:
                ((Double) obj).doubleValue();
                return kk.f();
            case 1:
                ((Float) obj).floatValue();
                return kk.e();
            case 2:
                return kk.d(((Long) obj).longValue());
            case 3:
                return kk.e(((Long) obj).longValue());
            case 4:
                return kk.f(((Integer) obj).intValue());
            case 5:
                ((Long) obj).longValue();
                return kk.c();
            case 6:
                ((Integer) obj).intValue();
                return kk.a();
            case 7:
                ((Boolean) obj).booleanValue();
                return kk.g();
            case 8:
                if (obj instanceof kc) {
                    return kk.b((kc) obj);
                }
                return kk.b((String) obj);
            case 9:
                return kk.c((ma) obj);
            case 10:
                if (obj instanceof lg) {
                    return kk.a((lj) (lg) obj);
                }
                return kk.b((ma) obj);
            case 11:
                if (obj instanceof kc) {
                    return kk.b((kc) obj);
                }
                return kk.b((byte[]) obj);
            case 12:
                return kk.g(((Integer) obj).intValue());
            case 13:
                if (obj instanceof ky) {
                    return kk.i(((ky) obj).a());
                }
                return kk.i(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                return kk.b();
            case 15:
                ((Long) obj).longValue();
                return kk.d();
            case 16:
                return kk.h(((Integer) obj).intValue());
            case 17:
                return kk.f(((Long) obj).longValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int b(kq<?> kqVar, Object obj) {
        nr b2 = kqVar.b();
        int a2 = kqVar.a();
        if (!kqVar.d()) {
            return a(b2, a2, obj);
        }
        int i = 0;
        if (kqVar.e()) {
            for (Object b3 : (List) obj) {
                i += b(b2, b3);
            }
            return kk.e(a2) + i + kk.j(i);
        }
        for (Object a3 : (List) obj) {
            i += a(b2, a2, a3);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        kp kpVar = new kp();
        for (int i = 0; i < this.f12885a.b(); i++) {
            Map.Entry<FieldDescriptorType, Object> b2 = this.f12885a.b(i);
            kpVar.a((kq) b2.getKey(), b2.getValue());
        }
        for (Map.Entry next : this.f12885a.c()) {
            kpVar.a((kq) next.getKey(), next.getValue());
        }
        kpVar.f12887c = this.f12887c;
        return kpVar;
    }
}
