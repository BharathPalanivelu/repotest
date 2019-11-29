package io.a.a.a.a.c;

import io.a.a.a.a.c.b;
import io.a.a.a.a.c.i;
import io.a.a.a.a.c.l;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class c<E extends b & l & i> extends PriorityBlockingQueue<E> {
    final Queue<E> blockedQueue = new LinkedList();
    private final ReentrantLock lock = new ReentrantLock();

    /* renamed from: a */
    public E take() throws InterruptedException {
        return b(0, (Long) null, (TimeUnit) null);
    }

    /* renamed from: b */
    public E peek() {
        try {
            return b(1, (Long) null, (TimeUnit) null);
        } catch (InterruptedException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        return b(3, Long.valueOf(j), timeUnit);
    }

    /* renamed from: c */
    public E poll() {
        try {
            return b(2, (Long) null, (TimeUnit) null);
        } catch (InterruptedException unused) {
            return null;
        }
    }

    public int size() {
        try {
            this.lock.lock();
            return this.blockedQueue.size() + super.size();
        } finally {
            this.lock.unlock();
        }
    }

    public <T> T[] toArray(T[] tArr) {
        try {
            this.lock.lock();
            return a((T[]) super.toArray(tArr), (T[]) this.blockedQueue.toArray(tArr));
        } finally {
            this.lock.unlock();
        }
    }

    public Object[] toArray() {
        try {
            this.lock.lock();
            return a((T[]) super.toArray(), (T[]) this.blockedQueue.toArray());
        } finally {
            this.lock.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection) {
        try {
            this.lock.lock();
            int drainTo = super.drainTo(collection) + this.blockedQueue.size();
            while (!this.blockedQueue.isEmpty()) {
                collection.add(this.blockedQueue.poll());
            }
            return drainTo;
        } finally {
            this.lock.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection, int i) {
        try {
            this.lock.lock();
            int drainTo = super.drainTo(collection, i);
            while (!this.blockedQueue.isEmpty() && drainTo <= i) {
                collection.add(this.blockedQueue.poll());
                drainTo++;
            }
            return drainTo;
        } finally {
            this.lock.unlock();
        }
    }

    public boolean contains(Object obj) {
        try {
            this.lock.lock();
            return super.contains(obj) || this.blockedQueue.contains(obj);
        } finally {
            this.lock.unlock();
        }
    }

    public void clear() {
        try {
            this.lock.lock();
            this.blockedQueue.clear();
            super.clear();
        } finally {
            this.lock.unlock();
        }
    }

    public boolean remove(Object obj) {
        try {
            this.lock.lock();
            return super.remove(obj) || this.blockedQueue.remove(obj);
        } finally {
            this.lock.unlock();
        }
    }

    public boolean removeAll(Collection<?> collection) {
        try {
            this.lock.lock();
            return this.blockedQueue.removeAll(collection) | super.removeAll(collection);
        } finally {
            this.lock.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public E a(int i, Long l, TimeUnit timeUnit) throws InterruptedException {
        if (i == 0) {
            return (b) super.take();
        }
        if (i == 1) {
            return (b) super.peek();
        }
        if (i == 2) {
            return (b) super.poll();
        }
        if (i != 3) {
            return null;
        }
        return (b) super.poll(l.longValue(), timeUnit);
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i, E e2) {
        try {
            this.lock.lock();
            if (i == 1) {
                super.remove(e2);
            }
            return this.blockedQueue.offer(e2);
        } finally {
            this.lock.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public E b(int i, Long l, TimeUnit timeUnit) throws InterruptedException {
        E a2;
        while (true) {
            a2 = a(i, l, timeUnit);
            if (a2 == null || a(a2)) {
                return a2;
            }
            a(i, a2);
        }
        return a2;
    }

    /* access modifiers changed from: package-private */
    public boolean a(E e2) {
        return e2.d();
    }

    public void d() {
        try {
            this.lock.lock();
            Iterator it = this.blockedQueue.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (a(bVar)) {
                    super.offer(bVar);
                    it.remove();
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public <T> T[] a(T[] tArr, T[] tArr2) {
        int length = tArr.length;
        int length2 = tArr2.length;
        T[] tArr3 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), length + length2);
        System.arraycopy(tArr, 0, tArr3, 0, length);
        System.arraycopy(tArr2, 0, tArr3, length, length2);
        return tArr3;
    }
}
