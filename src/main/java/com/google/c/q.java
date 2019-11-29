package com.google.c;

import com.google.c.ad;
import com.google.c.ay;
import com.google.c.q.a;
import com.google.c.u;
import com.google.c.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class q<FieldDescriptorType extends a<FieldDescriptorType>> {

    /* renamed from: d  reason: collision with root package name */
    private static final q f13996d = new q(true);

    /* renamed from: a  reason: collision with root package name */
    private final ao<FieldDescriptorType, Object> f13997a = ao.a(16);

    /* renamed from: b  reason: collision with root package name */
    private boolean f13998b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13999c = false;

    public interface a<T extends a<T>> extends Comparable<T> {
        ad.a a(ad.a aVar, ad adVar);

        int f();

        ay.b h();

        ay.a k();

        boolean p();

        boolean q();
    }

    private q() {
    }

    private q(boolean z) {
        c();
    }

    public static <T extends a<T>> q<T> a() {
        return new q<>();
    }

    public static <T extends a<T>> q<T> b() {
        return f13996d;
    }

    public void c() {
        if (!this.f13998b) {
            this.f13997a.a();
            this.f13998b = true;
        }
    }

    public boolean d() {
        return this.f13998b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        return this.f13997a.equals(((q) obj).f13997a);
    }

    public int hashCode() {
        return this.f13997a.hashCode();
    }

    /* renamed from: e */
    public q<FieldDescriptorType> clone() {
        q<FieldDescriptorType> a2 = a();
        for (int i = 0; i < this.f13997a.c(); i++) {
            Map.Entry<FieldDescriptorType, Object> b2 = this.f13997a.b(i);
            a2.a((FieldDescriptorType) (a) b2.getKey(), b2.getValue());
        }
        for (Map.Entry next : this.f13997a.e()) {
            a2.a((FieldDescriptorType) (a) next.getKey(), next.getValue());
        }
        a2.f13999c = this.f13999c;
        return a2;
    }

    public Map<FieldDescriptorType, Object> f() {
        if (!this.f13999c) {
            return this.f13997a.b() ? this.f13997a : Collections.unmodifiableMap(this.f13997a);
        }
        ao a2 = ao.a(16);
        for (int i = 0; i < this.f13997a.c(); i++) {
            a(a2, this.f13997a.b(i));
        }
        for (Map.Entry<FieldDescriptorType, Object> a3 : this.f13997a.e()) {
            a(a2, a3);
        }
        if (this.f13997a.b()) {
            a2.a();
        }
        return a2;
    }

    private void a(Map<FieldDescriptorType, Object> map, Map.Entry<FieldDescriptorType, Object> entry) {
        a aVar = (a) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof w) {
            map.put(aVar, ((w) value).a());
        } else {
            map.put(aVar, value);
        }
    }

    public Iterator<Map.Entry<FieldDescriptorType, Object>> g() {
        if (this.f13999c) {
            return new w.b(this.f13997a.entrySet().iterator());
        }
        return this.f13997a.entrySet().iterator();
    }

    public boolean a(FieldDescriptorType fielddescriptortype) {
        if (!fielddescriptortype.p()) {
            return this.f13997a.get(fielddescriptortype) != null;
        }
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }

    public Object b(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f13997a.get(fielddescriptortype);
        return obj instanceof w ? ((w) obj).a() : obj;
    }

    public void a(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.p()) {
            b(fielddescriptortype.k(), obj);
        } else if (obj instanceof List) {
            ArrayList<Object> arrayList = new ArrayList<>();
            arrayList.addAll((List) obj);
            for (Object b2 : arrayList) {
                b(fielddescriptortype.k(), b2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof w) {
            this.f13999c = true;
        }
        this.f13997a.put(fielddescriptortype, obj);
    }

    public void c(FieldDescriptorType fielddescriptortype) {
        this.f13997a.remove(fielddescriptortype);
        if (this.f13997a.isEmpty()) {
            this.f13999c = false;
        }
    }

    public void b(FieldDescriptorType fielddescriptortype, Object obj) {
        List list;
        if (fielddescriptortype.p()) {
            b(fielddescriptortype.k(), obj);
            Object b2 = b(fielddescriptortype);
            if (b2 == null) {
                list = new ArrayList();
                this.f13997a.put(fielddescriptortype, list);
            } else {
                list = (List) b2;
            }
            list.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        if ((r3 instanceof com.google.c.u.a) == false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002d, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if ((r3 instanceof com.google.c.w) == false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        r1 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(com.google.c.ay.a r2, java.lang.Object r3) {
        /*
            if (r3 == 0) goto L_0x004c
            int[] r0 = com.google.c.q.AnonymousClass1.f14000a
            com.google.c.ay$b r2 = r2.getJavaType()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L_0x003f;
                case 2: goto L_0x003c;
                case 3: goto L_0x0039;
                case 4: goto L_0x0036;
                case 5: goto L_0x0033;
                case 6: goto L_0x0030;
                case 7: goto L_0x0027;
                case 8: goto L_0x001e;
                case 9: goto L_0x0014;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x0041
        L_0x0014:
            boolean r2 = r3 instanceof com.google.c.ad
            if (r2 != 0) goto L_0x001c
            boolean r2 = r3 instanceof com.google.c.w
            if (r2 == 0) goto L_0x0041
        L_0x001c:
            r1 = 1
            goto L_0x0041
        L_0x001e:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x001c
            boolean r2 = r3 instanceof com.google.c.u.a
            if (r2 == 0) goto L_0x0041
            goto L_0x001c
        L_0x0027:
            boolean r2 = r3 instanceof com.google.c.f
            if (r2 != 0) goto L_0x001c
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L_0x0041
            goto L_0x001c
        L_0x0030:
            boolean r1 = r3 instanceof java.lang.String
            goto L_0x0041
        L_0x0033:
            boolean r1 = r3 instanceof java.lang.Boolean
            goto L_0x0041
        L_0x0036:
            boolean r1 = r3 instanceof java.lang.Double
            goto L_0x0041
        L_0x0039:
            boolean r1 = r3 instanceof java.lang.Float
            goto L_0x0041
        L_0x003c:
            boolean r1 = r3 instanceof java.lang.Long
            goto L_0x0041
        L_0x003f:
            boolean r1 = r3 instanceof java.lang.Integer
        L_0x0041:
            if (r1 == 0) goto L_0x0044
            return
        L_0x0044:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        L_0x004c:
            java.lang.NullPointerException r2 = new java.lang.NullPointerException
            r2.<init>()
            goto L_0x0053
        L_0x0052:
            throw r2
        L_0x0053:
            goto L_0x0052
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.c.q.b(com.google.c.ay$a, java.lang.Object):void");
    }

    public boolean h() {
        for (int i = 0; i < this.f13997a.c(); i++) {
            if (!a(this.f13997a.b(i))) {
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> a2 : this.f13997a.e()) {
            if (!a(a2)) {
                return false;
            }
        }
        return true;
    }

    private boolean a(Map.Entry<FieldDescriptorType, Object> entry) {
        a aVar = (a) entry.getKey();
        if (aVar.h() == ay.b.MESSAGE) {
            if (aVar.p()) {
                for (ad a2 : (List) entry.getValue()) {
                    if (!a2.a()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof ad) {
                    if (!((ad) value).a()) {
                        return false;
                    }
                } else if (value instanceof w) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    static int a(ay.a aVar, boolean z) {
        if (z) {
            return 2;
        }
        return aVar.getWireType();
    }

    public void a(q<FieldDescriptorType> qVar) {
        for (int i = 0; i < qVar.f13997a.c(); i++) {
            b(qVar.f13997a.b(i));
        }
        for (Map.Entry<FieldDescriptorType, Object> b2 : qVar.f13997a.e()) {
            b(b2);
        }
    }

    private Object a(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private void b(Map.Entry<FieldDescriptorType, Object> entry) {
        a aVar = (a) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof w) {
            value = ((w) value).a();
        }
        if (aVar.p()) {
            Object b2 = b(aVar);
            if (b2 == null) {
                b2 = new ArrayList();
            }
            for (Object a2 : (List) value) {
                ((List) b2).add(a(a2));
            }
            this.f13997a.put(aVar, b2);
        } else if (aVar.h() == ay.b.MESSAGE) {
            Object b3 = b(aVar);
            if (b3 == null) {
                this.f13997a.put(aVar, a(value));
                return;
            }
            this.f13997a.put(aVar, aVar.a(((ad) b3).I(), (ad) value).w());
        } else {
            this.f13997a.put(aVar, a(value));
        }
    }

    public void a(h hVar) throws IOException {
        for (int i = 0; i < this.f13997a.c(); i++) {
            Map.Entry<FieldDescriptorType, Object> b2 = this.f13997a.b(i);
            a((a<?>) (a) b2.getKey(), b2.getValue(), hVar);
        }
        for (Map.Entry next : this.f13997a.e()) {
            a((a<?>) (a) next.getKey(), next.getValue(), hVar);
        }
    }

    public void b(h hVar) throws IOException {
        for (int i = 0; i < this.f13997a.c(); i++) {
            a(this.f13997a.b(i), hVar);
        }
        for (Map.Entry<FieldDescriptorType, Object> a2 : this.f13997a.e()) {
            a(a2, hVar);
        }
    }

    private void a(Map.Entry<FieldDescriptorType, Object> entry, h hVar) throws IOException {
        a aVar = (a) entry.getKey();
        if (aVar.h() != ay.b.MESSAGE || aVar.p() || aVar.q()) {
            a((a<?>) aVar, entry.getValue(), hVar);
            return;
        }
        Object value = entry.getValue();
        if (value instanceof w) {
            value = ((w) value).a();
        }
        hVar.b(((a) entry.getKey()).f(), (ad) value);
    }

    static void a(h hVar, ay.a aVar, int i, Object obj) throws IOException {
        if (aVar == ay.a.GROUP) {
            hVar.e(i, (ad) obj);
            return;
        }
        hVar.a(i, a(aVar, false));
        a(hVar, aVar, obj);
    }

    static void a(h hVar, ay.a aVar, Object obj) throws IOException {
        switch (aVar) {
            case DOUBLE:
                hVar.a(((Double) obj).doubleValue());
                return;
            case FLOAT:
                hVar.a(((Float) obj).floatValue());
                return;
            case INT64:
                hVar.a(((Long) obj).longValue());
                return;
            case UINT64:
                hVar.b(((Long) obj).longValue());
                return;
            case INT32:
                hVar.a(((Integer) obj).intValue());
                return;
            case FIXED64:
                hVar.d(((Long) obj).longValue());
                return;
            case FIXED32:
                hVar.d(((Integer) obj).intValue());
                return;
            case BOOL:
                hVar.a(((Boolean) obj).booleanValue());
                return;
            case GROUP:
                hVar.c((ad) obj);
                return;
            case MESSAGE:
                hVar.a((ad) obj);
                return;
            case STRING:
                if (obj instanceof f) {
                    hVar.a((f) obj);
                    return;
                } else {
                    hVar.a((String) obj);
                    return;
                }
            case BYTES:
                if (obj instanceof f) {
                    hVar.a((f) obj);
                    return;
                } else {
                    hVar.b((byte[]) obj);
                    return;
                }
            case UINT32:
                hVar.b(((Integer) obj).intValue());
                return;
            case SFIXED32:
                hVar.e(((Integer) obj).intValue());
                return;
            case SFIXED64:
                hVar.e(((Long) obj).longValue());
                return;
            case SINT32:
                hVar.c(((Integer) obj).intValue());
                return;
            case SINT64:
                hVar.c(((Long) obj).longValue());
                return;
            case ENUM:
                if (obj instanceof u.a) {
                    hVar.f(((u.a) obj).getNumber());
                    return;
                } else {
                    hVar.f(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public static void a(a<?> aVar, Object obj, h hVar) throws IOException {
        ay.a k = aVar.k();
        int f2 = aVar.f();
        if (aVar.p()) {
            List<Object> list = (List) obj;
            if (aVar.q()) {
                hVar.a(f2, 2);
                int i = 0;
                for (Object a2 : list) {
                    i += a(k, a2);
                }
                hVar.p(i);
                for (Object a3 : list) {
                    a(hVar, k, a3);
                }
                return;
            }
            for (Object a4 : list) {
                a(hVar, k, f2, a4);
            }
        } else if (obj instanceof w) {
            a(hVar, k, f2, ((w) obj).a());
        } else {
            a(hVar, k, f2, obj);
        }
    }

    public int i() {
        int i = 0;
        for (int i2 = 0; i2 < this.f13997a.c(); i2++) {
            Map.Entry<FieldDescriptorType, Object> b2 = this.f13997a.b(i2);
            i += c((a) b2.getKey(), b2.getValue());
        }
        for (Map.Entry next : this.f13997a.e()) {
            i += c((a) next.getKey(), next.getValue());
        }
        return i;
    }

    public int j() {
        int i = 0;
        for (int i2 = 0; i2 < this.f13997a.c(); i2++) {
            i += c(this.f13997a.b(i2));
        }
        for (Map.Entry<FieldDescriptorType, Object> c2 : this.f13997a.e()) {
            i += c(c2);
        }
        return i;
    }

    private int c(Map.Entry<FieldDescriptorType, Object> entry) {
        a aVar = (a) entry.getKey();
        Object value = entry.getValue();
        if (aVar.h() != ay.b.MESSAGE || aVar.p() || aVar.q()) {
            return c(aVar, value);
        }
        if (value instanceof w) {
            return h.b(((a) entry.getKey()).f(), (x) (w) value);
        }
        return h.d(((a) entry.getKey()).f(), (ad) value);
    }

    static int a(ay.a aVar, int i, Object obj) {
        int g2 = h.g(i);
        if (aVar == ay.a.GROUP) {
            g2 *= 2;
        }
        return g2 + a(aVar, obj);
    }

    static int a(ay.a aVar, Object obj) {
        switch (aVar) {
            case DOUBLE:
                return h.b(((Double) obj).doubleValue());
            case FLOAT:
                return h.b(((Float) obj).floatValue());
            case INT64:
                return h.f(((Long) obj).longValue());
            case UINT64:
                return h.g(((Long) obj).longValue());
            case INT32:
                return h.h(((Integer) obj).intValue());
            case FIXED64:
                return h.i(((Long) obj).longValue());
            case FIXED32:
                return h.k(((Integer) obj).intValue());
            case BOOL:
                return h.b(((Boolean) obj).booleanValue());
            case GROUP:
                return h.d((ad) obj);
            case MESSAGE:
                if (obj instanceof w) {
                    return h.a((x) (w) obj);
                }
                return h.b((ad) obj);
            case STRING:
                if (obj instanceof f) {
                    return h.b((f) obj);
                }
                return h.b((String) obj);
            case BYTES:
                if (obj instanceof f) {
                    return h.b((f) obj);
                }
                return h.c((byte[]) obj);
            case UINT32:
                return h.i(((Integer) obj).intValue());
            case SFIXED32:
                return h.l(((Integer) obj).intValue());
            case SFIXED64:
                return h.j(((Long) obj).longValue());
            case SINT32:
                return h.j(((Integer) obj).intValue());
            case SINT64:
                return h.h(((Long) obj).longValue());
            case ENUM:
                if (obj instanceof u.a) {
                    return h.m(((u.a) obj).getNumber());
                }
                return h.m(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int c(a<?> aVar, Object obj) {
        ay.a k = aVar.k();
        int f2 = aVar.f();
        if (!aVar.p()) {
            return a(k, f2, obj);
        }
        int i = 0;
        if (aVar.q()) {
            for (Object a2 : (List) obj) {
                i += a(k, a2);
            }
            return h.g(f2) + i + h.q(i);
        }
        for (Object a3 : (List) obj) {
            i += a(k, f2, a3);
        }
        return i;
    }
}
