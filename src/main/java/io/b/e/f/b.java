package io.b.e.f;

import io.b.e.c.d;
import io.b.e.h.i;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class b<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    static final int f33478a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object j = new Object();

    /* renamed from: b  reason: collision with root package name */
    final AtomicLong f33479b = new AtomicLong();

    /* renamed from: c  reason: collision with root package name */
    int f33480c;

    /* renamed from: d  reason: collision with root package name */
    long f33481d;

    /* renamed from: e  reason: collision with root package name */
    final int f33482e;

    /* renamed from: f  reason: collision with root package name */
    AtomicReferenceArray<Object> f33483f;

    /* renamed from: g  reason: collision with root package name */
    final int f33484g;
    AtomicReferenceArray<Object> h;
    final AtomicLong i = new AtomicLong();

    private static int b(int i2) {
        return i2;
    }

    public b(int i2) {
        int a2 = i.a(Math.max(8, i2));
        int i3 = a2 - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(a2 + 1);
        this.f33483f = atomicReferenceArray;
        this.f33482e = i3;
        a(a2);
        this.h = atomicReferenceArray;
        this.f33484g = i3;
        this.f33481d = (long) (i3 - 1);
        a(0);
    }

    public boolean offer(T t) {
        if (t != null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.f33483f;
            long c2 = c();
            int i2 = this.f33482e;
            int a2 = a(c2, i2);
            if (c2 < this.f33481d) {
                return a(atomicReferenceArray, t, c2, a2);
            }
            long j2 = ((long) this.f33480c) + c2;
            if (b(atomicReferenceArray, a(j2, i2)) == null) {
                this.f33481d = j2 - 1;
                return a(atomicReferenceArray, t, c2, a2);
            } else if (b(atomicReferenceArray, a(1 + c2, i2)) == null) {
                return a(atomicReferenceArray, t, c2, a2);
            } else {
                a(atomicReferenceArray, c2, a2, t, (long) i2);
                return true;
            }
        } else {
            throw new NullPointerException("Null is not a valid element");
        }
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j2, int i2) {
        a(atomicReferenceArray, i2, (Object) t);
        a(j2 + 1);
        return true;
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2, T t, long j3) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f33483f = atomicReferenceArray2;
        this.f33481d = (j3 + j2) - 1;
        a(atomicReferenceArray2, i2, (Object) t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i2, j);
        a(j2 + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, b(atomicReferenceArray.length() - 1), (Object) atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        int b2 = b(i2);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) b(atomicReferenceArray, b2);
        a(atomicReferenceArray, b2, (Object) null);
        return atomicReferenceArray2;
    }

    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.h;
        long d2 = d();
        int i2 = this.f33484g;
        int a2 = a(d2, i2);
        T b2 = b(atomicReferenceArray, a2);
        boolean z = b2 == j;
        if (b2 != null && !z) {
            a(atomicReferenceArray, a2, (Object) null);
            b(d2 + 1);
            return b2;
        } else if (z) {
            return a(a(atomicReferenceArray, i2 + 1), d2, i2);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2) {
        this.h = atomicReferenceArray;
        int a2 = a(j2, i2);
        T b2 = b(atomicReferenceArray, a2);
        if (b2 != null) {
            a(atomicReferenceArray, a2, (Object) null);
            b(j2 + 1);
        }
        return b2;
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public boolean isEmpty() {
        return a() == b();
    }

    private void a(int i2) {
        this.f33480c = Math.min(i2 / 4, f33478a);
    }

    private long a() {
        return this.f33479b.get();
    }

    private long b() {
        return this.i.get();
    }

    private long c() {
        return this.f33479b.get();
    }

    private long d() {
        return this.i.get();
    }

    private void a(long j2) {
        this.f33479b.lazySet(j2);
    }

    private void b(long j2) {
        this.i.lazySet(j2);
    }

    private static int a(long j2, int i2) {
        return b(((int) j2) & i2);
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i2, Object obj) {
        atomicReferenceArray.lazySet(i2, obj);
    }

    private static <E> Object b(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        return atomicReferenceArray.get(i2);
    }
}
