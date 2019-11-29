package androidx.databinding;

import java.util.ArrayList;
import java.util.List;

public class c<C, T, A> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private List<C> f1979a;

    /* renamed from: b  reason: collision with root package name */
    private long f1980b;

    /* renamed from: c  reason: collision with root package name */
    private long[] f1981c;

    /* renamed from: d  reason: collision with root package name */
    private int f1982d;

    /* renamed from: e  reason: collision with root package name */
    private final a<C, T, A> f1983e;

    public static abstract class a<C, T, A> {
        public abstract void a(C c2, T t, int i, A a2);
    }

    public synchronized void a(T t, int i, A a2) {
        this.f1982d++;
        c(t, i, a2);
        this.f1982d--;
        if (this.f1982d == 0) {
            if (this.f1981c != null) {
                for (int length = this.f1981c.length - 1; length >= 0; length--) {
                    long j = this.f1981c[length];
                    if (j != 0) {
                        a((length + 1) * 64, j);
                        this.f1981c[length] = 0;
                    }
                }
            }
            if (this.f1980b != 0) {
                a(0, this.f1980b);
                this.f1980b = 0;
            }
        }
    }

    private void b(T t, int i, A a2) {
        a(t, i, a2, 0, Math.min(64, this.f1979a.size()), this.f1980b);
    }

    private void c(T t, int i, A a2) {
        int size = this.f1979a.size();
        long[] jArr = this.f1981c;
        int length = jArr == null ? -1 : jArr.length - 1;
        a(t, i, a2, length);
        a(t, i, a2, (length + 2) * 64, size, 0);
    }

    private void a(T t, int i, A a2, int i2) {
        if (i2 < 0) {
            b(t, i, a2);
            return;
        }
        long j = this.f1981c[i2];
        int i3 = (i2 + 1) * 64;
        int min = Math.min(this.f1979a.size(), i3 + 64);
        a(t, i, a2, i2 - 1);
        a(t, i, a2, i3, min, j);
    }

    private void a(T t, int i, A a2, int i2, int i3, long j) {
        long j2 = 1;
        while (i2 < i3) {
            if ((j & j2) == 0) {
                this.f1983e.a(this.f1979a.get(i2), t, i, a2);
            }
            j2 <<= 1;
            i2++;
        }
    }

    private boolean a(int i) {
        if (i < 64) {
            return ((1 << i) & this.f1980b) != 0;
        }
        long[] jArr = this.f1981c;
        if (jArr == null) {
            return false;
        }
        int i2 = (i / 64) - 1;
        if (i2 >= jArr.length) {
            return false;
        }
        if (((1 << (i % 64)) & jArr[i2]) != 0) {
            return true;
        }
        return false;
    }

    private void a(int i, long j) {
        long j2 = Long.MIN_VALUE;
        for (int i2 = (i + 64) - 1; i2 >= i; i2--) {
            if ((j & j2) != 0) {
                this.f1979a.remove(i2);
            }
            j2 >>>= 1;
        }
    }

    /* renamed from: a */
    public synchronized c<C, T, A> clone() {
        c<C, T, A> cVar;
        CloneNotSupportedException e2;
        try {
            cVar = (c) super.clone();
            try {
                cVar.f1980b = 0;
                cVar.f1981c = null;
                cVar.f1982d = 0;
                cVar.f1979a = new ArrayList();
                int size = this.f1979a.size();
                for (int i = 0; i < size; i++) {
                    if (!a(i)) {
                        cVar.f1979a.add(this.f1979a.get(i));
                    }
                }
            } catch (CloneNotSupportedException e3) {
                e2 = e3;
                e2.printStackTrace();
                return cVar;
            }
        } catch (CloneNotSupportedException e4) {
            CloneNotSupportedException cloneNotSupportedException = e4;
            cVar = null;
            e2 = cloneNotSupportedException;
            e2.printStackTrace();
            return cVar;
        }
        return cVar;
    }
}
