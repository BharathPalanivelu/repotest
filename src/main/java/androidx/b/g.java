package androidx.b;

import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import java.util.ConcurrentModificationException;
import java.util.Map;

public class g<K, V> {

    /* renamed from: b  reason: collision with root package name */
    static Object[] f1305b;

    /* renamed from: c  reason: collision with root package name */
    static int f1306c;

    /* renamed from: d  reason: collision with root package name */
    static Object[] f1307d;

    /* renamed from: e  reason: collision with root package name */
    static int f1308e;

    /* renamed from: f  reason: collision with root package name */
    int[] f1309f;

    /* renamed from: g  reason: collision with root package name */
    Object[] f1310g;
    int h;

    private static int a(int[] iArr, int i, int i2) {
        try {
            return c.a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    /* access modifiers changed from: package-private */
    public int a(Object obj, int i) {
        int i2 = this.h;
        if (i2 == 0) {
            return -1;
        }
        int a2 = a(this.f1309f, i2, i);
        if (a2 < 0 || obj.equals(this.f1310g[a2 << 1])) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i2 && this.f1309f[i3] == i) {
            if (obj.equals(this.f1310g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        int i4 = a2 - 1;
        while (i4 >= 0 && this.f1309f[i4] == i) {
            if (obj.equals(this.f1310g[i4 << 1])) {
                return i4;
            }
            i4--;
        }
        return i3 ^ -1;
    }

    /* access modifiers changed from: package-private */
    public int a() {
        int i = this.h;
        if (i == 0) {
            return -1;
        }
        int a2 = a(this.f1309f, i, 0);
        if (a2 < 0 || this.f1310g[a2 << 1] == null) {
            return a2;
        }
        int i2 = a2 + 1;
        while (i2 < i && this.f1309f[i2] == 0) {
            if (this.f1310g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        int i3 = a2 - 1;
        while (i3 >= 0 && this.f1309f[i3] == 0) {
            if (this.f1310g[i3 << 1] == null) {
                return i3;
            }
            i3--;
        }
        return i2 ^ -1;
    }

    private void e(int i) {
        if (i == 8) {
            synchronized (g.class) {
                if (f1307d != null) {
                    Object[] objArr = f1307d;
                    this.f1310g = objArr;
                    f1307d = (Object[]) objArr[0];
                    this.f1309f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f1308e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (g.class) {
                if (f1305b != null) {
                    Object[] objArr2 = f1305b;
                    this.f1310g = objArr2;
                    f1305b = (Object[]) objArr2[0];
                    this.f1309f = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f1306c--;
                    return;
                }
            }
        }
        this.f1309f = new int[i];
        this.f1310g = new Object[(i << 1)];
    }

    private static void a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (g.class) {
                if (f1308e < 10) {
                    objArr[0] = f1307d;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f1307d = objArr;
                    f1308e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (g.class) {
                if (f1306c < 10) {
                    objArr[0] = f1305b;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f1305b = objArr;
                    f1306c++;
                }
            }
        }
    }

    public g() {
        this.f1309f = c.f1282a;
        this.f1310g = c.f1284c;
        this.h = 0;
    }

    public g(int i) {
        if (i == 0) {
            this.f1309f = c.f1282a;
            this.f1310g = c.f1284c;
        } else {
            e(i);
        }
        this.h = 0;
    }

    public g(g<K, V> gVar) {
        this();
        if (gVar != null) {
            a(gVar);
        }
    }

    public void clear() {
        int i = this.h;
        if (i > 0) {
            int[] iArr = this.f1309f;
            Object[] objArr = this.f1310g;
            this.f1309f = c.f1282a;
            this.f1310g = c.f1284c;
            this.h = 0;
            a(iArr, objArr, i);
        }
        if (this.h > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public void a(int i) {
        int i2 = this.h;
        int[] iArr = this.f1309f;
        if (iArr.length < i) {
            Object[] objArr = this.f1310g;
            e(i);
            if (this.h > 0) {
                System.arraycopy(iArr, 0, this.f1309f, 0, i2);
                System.arraycopy(objArr, 0, this.f1310g, 0, i2 << 1);
            }
            a(iArr, objArr, i2);
        }
        if (this.h != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return a(obj) >= 0;
    }

    public int a(Object obj) {
        return obj == null ? a() : a(obj, obj.hashCode());
    }

    /* access modifiers changed from: package-private */
    public int b(Object obj) {
        int i = this.h * 2;
        Object[] objArr = this.f1310g;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return b(obj) >= 0;
    }

    public V get(Object obj) {
        return getOrDefault(obj, (Object) null);
    }

    public V getOrDefault(Object obj, V v) {
        int a2 = a(obj);
        return a2 >= 0 ? this.f1310g[(a2 << 1) + 1] : v;
    }

    public K b(int i) {
        return this.f1310g[i << 1];
    }

    public V c(int i) {
        return this.f1310g[(i << 1) + 1];
    }

    public V a(int i, V v) {
        int i2 = (i << 1) + 1;
        V[] vArr = this.f1310g;
        V v2 = vArr[i2];
        vArr[i2] = v;
        return v2;
    }

    public boolean isEmpty() {
        return this.h <= 0;
    }

    public V put(K k, V v) {
        int i;
        int i2;
        int i3 = this.h;
        if (k == null) {
            i2 = a();
            i = 0;
        } else {
            int hashCode = k.hashCode();
            i = hashCode;
            i2 = a((Object) k, hashCode);
        }
        if (i2 >= 0) {
            int i4 = (i2 << 1) + 1;
            V[] vArr = this.f1310g;
            V v2 = vArr[i4];
            vArr[i4] = v;
            return v2;
        }
        int i5 = i2 ^ -1;
        if (i3 >= this.f1309f.length) {
            int i6 = 4;
            if (i3 >= 8) {
                i6 = (i3 >> 1) + i3;
            } else if (i3 >= 4) {
                i6 = 8;
            }
            int[] iArr = this.f1309f;
            Object[] objArr = this.f1310g;
            e(i6);
            if (i3 == this.h) {
                int[] iArr2 = this.f1309f;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr, 0, this.f1310g, 0, objArr.length);
                }
                a(iArr, objArr, i3);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i5 < i3) {
            int[] iArr3 = this.f1309f;
            int i7 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i7, i3 - i5);
            Object[] objArr2 = this.f1310g;
            System.arraycopy(objArr2, i5 << 1, objArr2, i7 << 1, (this.h - i5) << 1);
        }
        int i8 = this.h;
        if (i3 == i8) {
            int[] iArr4 = this.f1309f;
            if (i5 < iArr4.length) {
                iArr4[i5] = i;
                Object[] objArr3 = this.f1310g;
                int i9 = i5 << 1;
                objArr3[i9] = k;
                objArr3[i9 + 1] = v;
                this.h = i8 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void a(g<? extends K, ? extends V> gVar) {
        int i = gVar.h;
        a(this.h + i);
        if (this.h != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(gVar.b(i2), gVar.c(i2));
            }
        } else if (i > 0) {
            System.arraycopy(gVar.f1309f, 0, this.f1309f, 0, i);
            System.arraycopy(gVar.f1310g, 0, this.f1310g, 0, i << 1);
            this.h = i;
        }
    }

    public V putIfAbsent(K k, V v) {
        V v2 = get(k);
        return v2 == null ? put(k, v) : v2;
    }

    public V remove(Object obj) {
        int a2 = a(obj);
        if (a2 >= 0) {
            return d(a2);
        }
        return null;
    }

    public boolean remove(Object obj, Object obj2) {
        int a2 = a(obj);
        if (a2 < 0) {
            return false;
        }
        Object c2 = c(a2);
        if (obj2 != c2 && (obj2 == null || !obj2.equals(c2))) {
            return false;
        }
        d(a2);
        return true;
    }

    public V d(int i) {
        int i2;
        V[] vArr = this.f1310g;
        int i3 = i << 1;
        V v = vArr[i3 + 1];
        int i4 = this.h;
        if (i4 <= 1) {
            a(this.f1309f, (Object[]) vArr, i4);
            this.f1309f = c.f1282a;
            this.f1310g = c.f1284c;
            i2 = 0;
        } else {
            i2 = i4 - 1;
            int[] iArr = this.f1309f;
            int i5 = 8;
            if (iArr.length <= 8 || i4 >= iArr.length / 3) {
                if (i < i2) {
                    int[] iArr2 = this.f1309f;
                    int i6 = i + 1;
                    int i7 = i2 - i;
                    System.arraycopy(iArr2, i6, iArr2, i, i7);
                    Object[] objArr = this.f1310g;
                    System.arraycopy(objArr, i6 << 1, objArr, i3, i7 << 1);
                }
                Object[] objArr2 = this.f1310g;
                int i8 = i2 << 1;
                objArr2[i8] = null;
                objArr2[i8 + 1] = null;
            } else {
                if (i4 > 8) {
                    i5 = i4 + (i4 >> 1);
                }
                int[] iArr3 = this.f1309f;
                Object[] objArr3 = this.f1310g;
                e(i5);
                if (i4 == this.h) {
                    if (i > 0) {
                        System.arraycopy(iArr3, 0, this.f1309f, 0, i);
                        System.arraycopy(objArr3, 0, this.f1310g, 0, i3);
                    }
                    if (i < i2) {
                        int i9 = i + 1;
                        int i10 = i2 - i;
                        System.arraycopy(iArr3, i9, this.f1309f, i, i10);
                        System.arraycopy(objArr3, i9 << 1, this.f1310g, i3, i10 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            }
        }
        if (i4 == this.h) {
            this.h = i2;
            return v;
        }
        throw new ConcurrentModificationException();
    }

    public V replace(K k, V v) {
        int a2 = a((Object) k);
        if (a2 >= 0) {
            return a(a2, v);
        }
        return null;
    }

    public boolean replace(K k, V v, V v2) {
        int a2 = a((Object) k);
        if (a2 < 0) {
            return false;
        }
        V c2 = c(a2);
        if (c2 != v && (v == null || !v.equals(c2))) {
            return false;
        }
        a(a2, v2);
        return true;
    }

    public int size() {
        return this.h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (size() != gVar.size()) {
                return false;
            }
            int i = 0;
            while (i < this.h) {
                try {
                    Object b2 = b(i);
                    Object c2 = c(i);
                    Object obj2 = gVar.get(b2);
                    if (c2 == null) {
                        if (obj2 != null || !gVar.containsKey(b2)) {
                            return false;
                        }
                    } else if (!c2.equals(obj2)) {
                        return false;
                    }
                    i++;
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            int i2 = 0;
            while (i2 < this.h) {
                try {
                    Object b3 = b(i2);
                    Object c3 = c(i2);
                    Object obj3 = map.get(b3);
                    if (c3 == null) {
                        if (obj3 != null || !map.containsKey(b3)) {
                            return false;
                        }
                    } else if (!c3.equals(obj3)) {
                        return false;
                    }
                    i2++;
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int[] iArr = this.f1309f;
        Object[] objArr = this.f1310g;
        int i = this.h;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < i) {
            Object obj = objArr[i4];
            i3 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i2];
            i2++;
            i4 += 2;
        }
        return i3;
    }

    public String toString() {
        if (isEmpty()) {
            return ServiceLogger.PLACEHOLDER;
        }
        StringBuilder sb = new StringBuilder(this.h * 28);
        sb.append('{');
        for (int i = 0; i < this.h; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object b2 = b(i);
            if (b2 != this) {
                sb.append(b2);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object c2 = c(i);
            if (c2 != this) {
                sb.append(c2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
