package io.b.e.f;

import io.b.e.c.d;
import io.b.e.h.i;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class a<E> extends AtomicReferenceArray<E> implements d<E> {

    /* renamed from: a  reason: collision with root package name */
    private static final Integer f33477a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    private static final long serialVersionUID = -1296597691183856449L;
    final AtomicLong consumerIndex = new AtomicLong();
    final int lookAheadStep;
    final int mask = (length() - 1);
    final AtomicLong producerIndex = new AtomicLong();
    long producerLookAhead;

    /* access modifiers changed from: package-private */
    public int a(long j, int i) {
        return ((int) j) & i;
    }

    public a(int i) {
        super(i.a(i));
        this.lookAheadStep = Math.min(i / 4, f33477a.intValue());
    }

    public boolean offer(E e2) {
        if (e2 != null) {
            int i = this.mask;
            long j = this.producerIndex.get();
            int a2 = a(j, i);
            if (j >= this.producerLookAhead) {
                long j2 = ((long) this.lookAheadStep) + j;
                if (a(a(j2, i)) == null) {
                    this.producerLookAhead = j2;
                } else if (a(a2) != null) {
                    return false;
                }
            }
            a(a2, e2);
            a(j + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public E poll() {
        long j = this.consumerIndex.get();
        int c2 = c(j);
        E a2 = a(c2);
        if (a2 == null) {
            return null;
        }
        b(j + 1);
        a(c2, (Object) null);
        return a2;
    }

    public boolean isEmpty() {
        return this.producerIndex.get() == this.consumerIndex.get();
    }

    /* access modifiers changed from: package-private */
    public void a(long j) {
        this.producerIndex.lazySet(j);
    }

    /* access modifiers changed from: package-private */
    public void b(long j) {
        this.consumerIndex.lazySet(j);
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int c(long j) {
        return this.mask & ((int) j);
    }

    /* access modifiers changed from: package-private */
    public void a(int i, E e2) {
        lazySet(i, e2);
    }

    /* access modifiers changed from: package-private */
    public E a(int i) {
        return get(i);
    }
}
