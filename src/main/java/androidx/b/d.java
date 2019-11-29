package androidx.b;

import com.salesforce.android.service.common.utilities.logging.ServiceLogger;

public class d<E> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f1285a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private boolean f1286b;

    /* renamed from: c  reason: collision with root package name */
    private long[] f1287c;

    /* renamed from: d  reason: collision with root package name */
    private Object[] f1288d;

    /* renamed from: e  reason: collision with root package name */
    private int f1289e;

    public d() {
        this(10);
    }

    public d(int i) {
        this.f1286b = false;
        if (i == 0) {
            this.f1287c = c.f1283b;
            this.f1288d = c.f1284c;
            return;
        }
        int b2 = c.b(i);
        this.f1287c = new long[b2];
        this.f1288d = new Object[b2];
    }

    /* renamed from: a */
    public d<E> clone() {
        try {
            d<E> dVar = (d) super.clone();
            dVar.f1287c = (long[]) this.f1287c.clone();
            dVar.f1288d = (Object[]) this.f1288d.clone();
            return dVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public E a(long j) {
        return a(j, (Object) null);
    }

    public E a(long j, E e2) {
        int a2 = c.a(this.f1287c, this.f1289e, j);
        if (a2 >= 0) {
            E[] eArr = this.f1288d;
            if (eArr[a2] != f1285a) {
                return eArr[a2];
            }
        }
        return e2;
    }

    @Deprecated
    public void b(long j) {
        c(j);
    }

    public void c(long j) {
        int a2 = c.a(this.f1287c, this.f1289e, j);
        if (a2 >= 0) {
            Object[] objArr = this.f1288d;
            Object obj = objArr[a2];
            Object obj2 = f1285a;
            if (obj != obj2) {
                objArr[a2] = obj2;
                this.f1286b = true;
            }
        }
    }

    public void a(int i) {
        Object[] objArr = this.f1288d;
        Object obj = objArr[i];
        Object obj2 = f1285a;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.f1286b = true;
        }
    }

    private void d() {
        int i = this.f1289e;
        long[] jArr = this.f1287c;
        Object[] objArr = this.f1288d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f1285a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f1286b = false;
        this.f1289e = i2;
    }

    public void b(long j, E e2) {
        int a2 = c.a(this.f1287c, this.f1289e, j);
        if (a2 >= 0) {
            this.f1288d[a2] = e2;
            return;
        }
        int i = a2 ^ -1;
        if (i < this.f1289e) {
            Object[] objArr = this.f1288d;
            if (objArr[i] == f1285a) {
                this.f1287c[i] = j;
                objArr[i] = e2;
                return;
            }
        }
        if (this.f1286b && this.f1289e >= this.f1287c.length) {
            d();
            i = c.a(this.f1287c, this.f1289e, j) ^ -1;
        }
        int i2 = this.f1289e;
        if (i2 >= this.f1287c.length) {
            int b2 = c.b(i2 + 1);
            long[] jArr = new long[b2];
            Object[] objArr2 = new Object[b2];
            long[] jArr2 = this.f1287c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f1288d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1287c = jArr;
            this.f1288d = objArr2;
        }
        int i3 = this.f1289e;
        if (i3 - i != 0) {
            long[] jArr3 = this.f1287c;
            int i4 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i4, i3 - i);
            Object[] objArr4 = this.f1288d;
            System.arraycopy(objArr4, i, objArr4, i4, this.f1289e - i);
        }
        this.f1287c[i] = j;
        this.f1288d[i] = e2;
        this.f1289e++;
    }

    public int b() {
        if (this.f1286b) {
            d();
        }
        return this.f1289e;
    }

    public long b(int i) {
        if (this.f1286b) {
            d();
        }
        return this.f1287c[i];
    }

    public E c(int i) {
        if (this.f1286b) {
            d();
        }
        return this.f1288d[i];
    }

    public int d(long j) {
        if (this.f1286b) {
            d();
        }
        return c.a(this.f1287c, this.f1289e, j);
    }

    public void c() {
        int i = this.f1289e;
        Object[] objArr = this.f1288d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f1289e = 0;
        this.f1286b = false;
    }

    public void c(long j, E e2) {
        int i = this.f1289e;
        if (i == 0 || j > this.f1287c[i - 1]) {
            if (this.f1286b && this.f1289e >= this.f1287c.length) {
                d();
            }
            int i2 = this.f1289e;
            if (i2 >= this.f1287c.length) {
                int b2 = c.b(i2 + 1);
                long[] jArr = new long[b2];
                Object[] objArr = new Object[b2];
                long[] jArr2 = this.f1287c;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr2 = this.f1288d;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f1287c = jArr;
                this.f1288d = objArr;
            }
            this.f1287c[i2] = j;
            this.f1288d[i2] = e2;
            this.f1289e = i2 + 1;
            return;
        }
        b(j, e2);
    }

    public String toString() {
        if (b() <= 0) {
            return ServiceLogger.PLACEHOLDER;
        }
        StringBuilder sb = new StringBuilder(this.f1289e * 28);
        sb.append('{');
        for (int i = 0; i < this.f1289e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(b(i));
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
