package androidx.b;

import com.salesforce.android.service.common.utilities.logging.ServiceLogger;

public class h<E> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f1311a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private boolean f1312b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f1313c;

    /* renamed from: d  reason: collision with root package name */
    private Object[] f1314d;

    /* renamed from: e  reason: collision with root package name */
    private int f1315e;

    public h() {
        this(10);
    }

    public h(int i) {
        this.f1312b = false;
        if (i == 0) {
            this.f1313c = c.f1282a;
            this.f1314d = c.f1284c;
            return;
        }
        int a2 = c.a(i);
        this.f1313c = new int[a2];
        this.f1314d = new Object[a2];
    }

    /* renamed from: a */
    public h<E> clone() {
        try {
            h<E> hVar = (h) super.clone();
            hVar.f1313c = (int[]) this.f1313c.clone();
            hVar.f1314d = (Object[]) this.f1314d.clone();
            return hVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public E a(int i) {
        return a(i, (Object) null);
    }

    public E a(int i, E e2) {
        int a2 = c.a(this.f1313c, this.f1315e, i);
        if (a2 >= 0) {
            E[] eArr = this.f1314d;
            if (eArr[a2] != f1311a) {
                return eArr[a2];
            }
        }
        return e2;
    }

    public void b(int i) {
        int a2 = c.a(this.f1313c, this.f1315e, i);
        if (a2 >= 0) {
            Object[] objArr = this.f1314d;
            Object obj = objArr[a2];
            Object obj2 = f1311a;
            if (obj != obj2) {
                objArr[a2] = obj2;
                this.f1312b = true;
            }
        }
    }

    private void d() {
        int i = this.f1315e;
        int[] iArr = this.f1313c;
        Object[] objArr = this.f1314d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f1311a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f1312b = false;
        this.f1315e = i2;
    }

    public void b(int i, E e2) {
        int a2 = c.a(this.f1313c, this.f1315e, i);
        if (a2 >= 0) {
            this.f1314d[a2] = e2;
            return;
        }
        int i2 = a2 ^ -1;
        if (i2 < this.f1315e) {
            Object[] objArr = this.f1314d;
            if (objArr[i2] == f1311a) {
                this.f1313c[i2] = i;
                objArr[i2] = e2;
                return;
            }
        }
        if (this.f1312b && this.f1315e >= this.f1313c.length) {
            d();
            i2 = c.a(this.f1313c, this.f1315e, i) ^ -1;
        }
        int i3 = this.f1315e;
        if (i3 >= this.f1313c.length) {
            int a3 = c.a(i3 + 1);
            int[] iArr = new int[a3];
            Object[] objArr2 = new Object[a3];
            int[] iArr2 = this.f1313c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f1314d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1313c = iArr;
            this.f1314d = objArr2;
        }
        int i4 = this.f1315e;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.f1313c;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            Object[] objArr4 = this.f1314d;
            System.arraycopy(objArr4, i2, objArr4, i5, this.f1315e - i2);
        }
        this.f1313c[i2] = i;
        this.f1314d[i2] = e2;
        this.f1315e++;
    }

    public int b() {
        if (this.f1312b) {
            d();
        }
        return this.f1315e;
    }

    public int c(int i) {
        if (this.f1312b) {
            d();
        }
        return this.f1313c[i];
    }

    public E d(int i) {
        if (this.f1312b) {
            d();
        }
        return this.f1314d[i];
    }

    public int e(int i) {
        if (this.f1312b) {
            d();
        }
        return c.a(this.f1313c, this.f1315e, i);
    }

    public void c() {
        int i = this.f1315e;
        Object[] objArr = this.f1314d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f1315e = 0;
        this.f1312b = false;
    }

    public void c(int i, E e2) {
        int i2 = this.f1315e;
        if (i2 == 0 || i > this.f1313c[i2 - 1]) {
            if (this.f1312b && this.f1315e >= this.f1313c.length) {
                d();
            }
            int i3 = this.f1315e;
            if (i3 >= this.f1313c.length) {
                int a2 = c.a(i3 + 1);
                int[] iArr = new int[a2];
                Object[] objArr = new Object[a2];
                int[] iArr2 = this.f1313c;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.f1314d;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f1313c = iArr;
                this.f1314d = objArr;
            }
            this.f1313c[i3] = i;
            this.f1314d[i3] = e2;
            this.f1315e = i3 + 1;
            return;
        }
        b(i, e2);
    }

    public String toString() {
        if (b() <= 0) {
            return ServiceLogger.PLACEHOLDER;
        }
        StringBuilder sb = new StringBuilder(this.f1315e * 28);
        sb.append('{');
        for (int i = 0; i < this.f1315e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(c(i));
            sb.append('=');
            Object d2 = d(i);
            if (d2 != this) {
                sb.append(d2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
