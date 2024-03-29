package androidx.b;

import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b<E> implements Collection<E>, Set<E> {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f1274c = new int[0];

    /* renamed from: d  reason: collision with root package name */
    private static final Object[] f1275d = new Object[0];

    /* renamed from: e  reason: collision with root package name */
    private static Object[] f1276e;

    /* renamed from: f  reason: collision with root package name */
    private static int f1277f;

    /* renamed from: g  reason: collision with root package name */
    private static Object[] f1278g;
    private static int h;

    /* renamed from: a  reason: collision with root package name */
    Object[] f1279a;

    /* renamed from: b  reason: collision with root package name */
    int f1280b;
    private int[] i;
    private f<E, E> j;

    private int a(Object obj, int i2) {
        int i3 = this.f1280b;
        if (i3 == 0) {
            return -1;
        }
        int a2 = c.a(this.i, i3, i2);
        if (a2 < 0 || obj.equals(this.f1279a[a2])) {
            return a2;
        }
        int i4 = a2 + 1;
        while (i4 < i3 && this.i[i4] == i2) {
            if (obj.equals(this.f1279a[i4])) {
                return i4;
            }
            i4++;
        }
        int i5 = a2 - 1;
        while (i5 >= 0 && this.i[i5] == i2) {
            if (obj.equals(this.f1279a[i5])) {
                return i5;
            }
            i5--;
        }
        return i4 ^ -1;
    }

    private int a() {
        int i2 = this.f1280b;
        if (i2 == 0) {
            return -1;
        }
        int a2 = c.a(this.i, i2, 0);
        if (a2 < 0 || this.f1279a[a2] == null) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i2 && this.i[i3] == 0) {
            if (this.f1279a[i3] == null) {
                return i3;
            }
            i3++;
        }
        int i4 = a2 - 1;
        while (i4 >= 0 && this.i[i4] == 0) {
            if (this.f1279a[i4] == null) {
                return i4;
            }
            i4--;
        }
        return i3 ^ -1;
    }

    private void d(int i2) {
        if (i2 == 8) {
            synchronized (b.class) {
                if (f1278g != null) {
                    Object[] objArr = f1278g;
                    this.f1279a = objArr;
                    f1278g = (Object[]) objArr[0];
                    this.i = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    h--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (b.class) {
                if (f1276e != null) {
                    Object[] objArr2 = f1276e;
                    this.f1279a = objArr2;
                    f1276e = (Object[]) objArr2[0];
                    this.i = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f1277f--;
                    return;
                }
            }
        }
        this.i = new int[i2];
        this.f1279a = new Object[i2];
    }

    private static void a(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (h < 10) {
                    objArr[0] = f1278g;
                    objArr[1] = iArr;
                    for (int i3 = i2 - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f1278g = objArr;
                    h++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (b.class) {
                if (f1277f < 10) {
                    objArr[0] = f1276e;
                    objArr[1] = iArr;
                    for (int i4 = i2 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f1276e = objArr;
                    f1277f++;
                }
            }
        }
    }

    public b() {
        this(0);
    }

    public b(int i2) {
        if (i2 == 0) {
            this.i = f1274c;
            this.f1279a = f1275d;
        } else {
            d(i2);
        }
        this.f1280b = 0;
    }

    public void clear() {
        int i2 = this.f1280b;
        if (i2 != 0) {
            a(this.i, this.f1279a, i2);
            this.i = f1274c;
            this.f1279a = f1275d;
            this.f1280b = 0;
        }
    }

    public void a(int i2) {
        int[] iArr = this.i;
        if (iArr.length < i2) {
            Object[] objArr = this.f1279a;
            d(i2);
            int i3 = this.f1280b;
            if (i3 > 0) {
                System.arraycopy(iArr, 0, this.i, 0, i3);
                System.arraycopy(objArr, 0, this.f1279a, 0, this.f1280b);
            }
            a(iArr, objArr, this.f1280b);
        }
    }

    public boolean contains(Object obj) {
        return a(obj) >= 0;
    }

    public int a(Object obj) {
        return obj == null ? a() : a(obj, obj.hashCode());
    }

    public E b(int i2) {
        return this.f1279a[i2];
    }

    public boolean isEmpty() {
        return this.f1280b <= 0;
    }

    public boolean add(E e2) {
        int i2;
        int i3;
        if (e2 == null) {
            i3 = a();
            i2 = 0;
        } else {
            int hashCode = e2.hashCode();
            i2 = hashCode;
            i3 = a(e2, hashCode);
        }
        if (i3 >= 0) {
            return false;
        }
        int i4 = i3 ^ -1;
        int i5 = this.f1280b;
        if (i5 >= this.i.length) {
            int i6 = 4;
            if (i5 >= 8) {
                i6 = (i5 >> 1) + i5;
            } else if (i5 >= 4) {
                i6 = 8;
            }
            int[] iArr = this.i;
            Object[] objArr = this.f1279a;
            d(i6);
            int[] iArr2 = this.i;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f1279a, 0, objArr.length);
            }
            a(iArr, objArr, this.f1280b);
        }
        int i7 = this.f1280b;
        if (i4 < i7) {
            int[] iArr3 = this.i;
            int i8 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i8, i7 - i4);
            Object[] objArr2 = this.f1279a;
            System.arraycopy(objArr2, i4, objArr2, i8, this.f1280b - i4);
        }
        this.i[i4] = i2;
        this.f1279a[i4] = e2;
        this.f1280b++;
        return true;
    }

    public void a(b<? extends E> bVar) {
        int i2 = bVar.f1280b;
        a(this.f1280b + i2);
        if (this.f1280b != 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                add(bVar.b(i3));
            }
        } else if (i2 > 0) {
            System.arraycopy(bVar.i, 0, this.i, 0, i2);
            System.arraycopy(bVar.f1279a, 0, this.f1279a, 0, i2);
            this.f1280b = i2;
        }
    }

    public boolean remove(Object obj) {
        int a2 = a(obj);
        if (a2 < 0) {
            return false;
        }
        c(a2);
        return true;
    }

    public E c(int i2) {
        E[] eArr = this.f1279a;
        E e2 = eArr[i2];
        int i3 = this.f1280b;
        if (i3 <= 1) {
            a(this.i, eArr, i3);
            this.i = f1274c;
            this.f1279a = f1275d;
            this.f1280b = 0;
        } else {
            int[] iArr = this.i;
            int i4 = 8;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                this.f1280b--;
                int i5 = this.f1280b;
                if (i2 < i5) {
                    int[] iArr2 = this.i;
                    int i6 = i2 + 1;
                    System.arraycopy(iArr2, i6, iArr2, i2, i5 - i2);
                    Object[] objArr = this.f1279a;
                    System.arraycopy(objArr, i6, objArr, i2, this.f1280b - i2);
                }
                this.f1279a[this.f1280b] = null;
            } else {
                if (i3 > 8) {
                    i4 = i3 + (i3 >> 1);
                }
                int[] iArr3 = this.i;
                Object[] objArr2 = this.f1279a;
                d(i4);
                this.f1280b--;
                if (i2 > 0) {
                    System.arraycopy(iArr3, 0, this.i, 0, i2);
                    System.arraycopy(objArr2, 0, this.f1279a, 0, i2);
                }
                int i7 = this.f1280b;
                if (i2 < i7) {
                    int i8 = i2 + 1;
                    System.arraycopy(iArr3, i8, this.i, i2, i7 - i2);
                    System.arraycopy(objArr2, i8, this.f1279a, i2, this.f1280b - i2);
                }
            }
        }
        return e2;
    }

    public int size() {
        return this.f1280b;
    }

    public Object[] toArray() {
        int i2 = this.f1280b;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.f1279a, 0, objArr, 0, i2);
        return objArr;
    }

    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f1280b) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f1280b);
        }
        System.arraycopy(this.f1279a, 0, tArr, 0, this.f1280b);
        int length = tArr.length;
        int i2 = this.f1280b;
        if (length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            int i2 = 0;
            while (i2 < this.f1280b) {
                try {
                    if (!set.contains(b(i2))) {
                        return false;
                    }
                    i2++;
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int[] iArr = this.i;
        int i2 = this.f1280b;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public String toString() {
        if (isEmpty()) {
            return ServiceLogger.PLACEHOLDER;
        }
        StringBuilder sb = new StringBuilder(this.f1280b * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.f1280b; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object b2 = b(i2);
            if (b2 != this) {
                sb.append(b2);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    private f<E, E> b() {
        if (this.j == null) {
            this.j = new f<E, E>() {
                /* access modifiers changed from: protected */
                public int a() {
                    return b.this.f1280b;
                }

                /* access modifiers changed from: protected */
                public Object a(int i, int i2) {
                    return b.this.f1279a[i];
                }

                /* access modifiers changed from: protected */
                public int a(Object obj) {
                    return b.this.a(obj);
                }

                /* access modifiers changed from: protected */
                public int b(Object obj) {
                    return b.this.a(obj);
                }

                /* access modifiers changed from: protected */
                public Map<E, E> b() {
                    throw new UnsupportedOperationException("not a map");
                }

                /* access modifiers changed from: protected */
                public void a(E e2, E e3) {
                    b.this.add(e2);
                }

                /* access modifiers changed from: protected */
                public E a(int i, E e2) {
                    throw new UnsupportedOperationException("not a map");
                }

                /* access modifiers changed from: protected */
                public void a(int i) {
                    b.this.c(i);
                }

                /* access modifiers changed from: protected */
                public void c() {
                    b.this.clear();
                }
            };
        }
        return this.j;
    }

    public Iterator<E> iterator() {
        return b().e().iterator();
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        a(this.f1280b + collection.size());
        boolean z = false;
        for (Object add : collection) {
            z |= add(add);
        }
        return z;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object remove : collection) {
            z |= remove(remove);
        }
        return z;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i2 = this.f1280b - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.f1279a[i2])) {
                c(i2);
                z = true;
            }
        }
        return z;
    }
}
