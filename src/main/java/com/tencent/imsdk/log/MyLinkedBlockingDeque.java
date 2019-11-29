package com.tencent.imsdk.log;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyLinkedBlockingDeque<E> extends AbstractQueue<E> implements Serializable {
    private static final long serialVersionUID = -387911632671998426L;
    private final int capacity;
    private transient int count;
    transient Node<E> first;
    transient Node<E> last;
    final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    static final class Node<E> {

        /* renamed from: a  reason: collision with root package name */
        E f31086a;

        /* renamed from: b  reason: collision with root package name */
        Node<E> f31087b;

        /* renamed from: c  reason: collision with root package name */
        Node<E> f31088c;

        Node(E e2) {
            this.f31086a = e2;
        }
    }

    private abstract class aa implements Iterator<E> {

        /* renamed from: a  reason: collision with root package name */
        private Node<E> f31089a;

        /* renamed from: b  reason: collision with root package name */
        private E f31090b;

        /* renamed from: c  reason: collision with root package name */
        private Node<E> f31091c;

        aa() {
            ReentrantLock reentrantLock = MyLinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                this.f31089a = a();
                this.f31090b = this.f31089a == null ? null : this.f31089a.f31086a;
            } finally {
                reentrantLock.unlock();
            }
        }

        private void b() {
            Node<E> a2;
            E e2;
            ReentrantLock reentrantLock = MyLinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                Node<E> node = this.f31089a;
                while (true) {
                    a2 = a(node);
                    e2 = null;
                    if (a2 == null) {
                        a2 = null;
                        break;
                    } else if (a2.f31086a != null) {
                        break;
                    } else if (a2 == node) {
                        a2 = a();
                        break;
                    } else {
                        node = a2;
                    }
                }
                this.f31089a = a2;
                if (this.f31089a != null) {
                    e2 = this.f31089a.f31086a;
                }
                this.f31090b = e2;
            } finally {
                reentrantLock.unlock();
            }
        }

        /* access modifiers changed from: package-private */
        public abstract Node<E> a();

        /* access modifiers changed from: package-private */
        public abstract Node<E> a(Node<E> node);

        public boolean hasNext() {
            return this.f31089a != null;
        }

        public E next() {
            Node<E> node = this.f31089a;
            if (node != null) {
                this.f31091c = node;
                E e2 = this.f31090b;
                b();
                return e2;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            Node<E> node = this.f31091c;
            if (node != null) {
                this.f31091c = null;
                ReentrantLock reentrantLock = MyLinkedBlockingDeque.this.lock;
                reentrantLock.lock();
                try {
                    if (node.f31086a != null) {
                        MyLinkedBlockingDeque.this.unlink(node);
                    }
                } finally {
                    reentrantLock.unlock();
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    private class ab extends MyLinkedBlockingDeque<E>.aa {
        private ab() {
            super();
        }

        /* synthetic */ ab(MyLinkedBlockingDeque myLinkedBlockingDeque, byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final Node<E> a() {
            return MyLinkedBlockingDeque.this.last;
        }

        /* access modifiers changed from: package-private */
        public final Node<E> a(Node<E> node) {
            return node.f31087b;
        }
    }

    private class ac extends MyLinkedBlockingDeque<E>.aa {
        private ac() {
            super();
        }

        /* synthetic */ ac(MyLinkedBlockingDeque myLinkedBlockingDeque, byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final Node<E> a() {
            return MyLinkedBlockingDeque.this.first;
        }

        /* access modifiers changed from: package-private */
        public final Node<E> a(Node<E> node) {
            return node.f31088c;
        }
    }

    public MyLinkedBlockingDeque() {
        this(Integer.MAX_VALUE);
    }

    public MyLinkedBlockingDeque(int i) {
        this.lock = new ReentrantLock();
        this.notEmpty = this.lock.newCondition();
        this.notFull = this.lock.newCondition();
        if (i > 0) {
            this.capacity = i;
            return;
        }
        throw new IllegalArgumentException();
    }

    public MyLinkedBlockingDeque(Collection<? extends E> collection) {
        this(Integer.MAX_VALUE);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (Object next : collection) {
                if (next == null) {
                    throw new NullPointerException();
                } else if (!linkLast(new Node(next))) {
                    throw new IllegalStateException("Deque full");
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private boolean linkFirst(Node<E> node) {
        if (this.count >= this.capacity) {
            return false;
        }
        Node<E> node2 = this.first;
        node.f31088c = node2;
        this.first = node;
        if (this.last == null) {
            this.last = node;
        } else {
            node2.f31087b = node;
        }
        this.count++;
        this.notEmpty.signal();
        return true;
    }

    private boolean linkLast(Node<E> node) {
        if (this.count >= this.capacity) {
            return false;
        }
        Node<E> node2 = this.last;
        node.f31087b = node2;
        this.last = node;
        if (this.first == null) {
            this.first = node;
        } else {
            node2.f31088c = node;
        }
        this.count++;
        this.notEmpty.signal();
        return true;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.count = 0;
        this.first = null;
        this.last = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject != null) {
                add(readObject);
            } else {
                return;
            }
        }
    }

    private E unlinkFirst() {
        Node<E> node = this.first;
        if (node == null) {
            return null;
        }
        Node<E> node2 = node.f31088c;
        E e2 = node.f31086a;
        node.f31086a = null;
        node.f31088c = node;
        this.first = node2;
        if (node2 == null) {
            this.last = null;
        } else {
            node2.f31087b = null;
        }
        this.count--;
        this.notFull.signal();
        return e2;
    }

    private E unlinkLast() {
        Node<E> node = this.last;
        if (node == null) {
            return null;
        }
        Node<E> node2 = node.f31087b;
        E e2 = node.f31086a;
        node.f31086a = null;
        node.f31087b = node;
        this.last = node2;
        if (node2 == null) {
            this.first = null;
        } else {
            node2.f31088c = null;
        }
        this.count--;
        this.notFull.signal();
        return e2;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            objectOutputStream.defaultWriteObject();
            for (Node<E> node = this.first; node != null; node = node.f31088c) {
                objectOutputStream.writeObject(node.f31086a);
            }
            objectOutputStream.writeObject((Object) null);
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean add(E e2) {
        addLast(e2);
        return true;
    }

    public void addFirst(E e2) {
        if (!offerFirst(e2)) {
            throw new IllegalStateException("Deque full");
        }
    }

    public void addLast(E e2) {
        if (!offerLast(e2)) {
            throw new IllegalStateException("Deque full");
        }
    }

    public void clear() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Node<E> node = this.first;
            while (node != null) {
                node.f31086a = null;
                Node<E> node2 = node.f31088c;
                node.f31087b = null;
                node.f31088c = null;
                node = node2;
            }
            this.last = null;
            this.first = null;
            this.count = 0;
            this.notFull.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (Node<E> node = this.first; node != null; node = node.f31088c) {
                if (obj.equals(node.f31086a)) {
                    reentrantLock.unlock();
                    return true;
                }
            }
            reentrantLock.unlock();
            return false;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public Iterator<E> descendingIterator() {
        return new ab(this, (byte) 0);
    }

    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    public int drainTo(Collection<? super E> collection, int i) {
        if (collection == null) {
            throw new NullPointerException();
        } else if (collection != this) {
            if (i <= 0) {
                return 0;
            }
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                int min = Math.min(i, this.count);
                for (int i2 = 0; i2 < min; i2++) {
                    collection.add(this.first.f31086a);
                    unlinkFirst();
                }
                return min;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public E element() {
        return getFirst();
    }

    public E getFirst() {
        E peekFirst = peekFirst();
        if (peekFirst != null) {
            return peekFirst;
        }
        throw new NoSuchElementException();
    }

    public E getLast() {
        E peekLast = peekLast();
        if (peekLast != null) {
            return peekLast;
        }
        throw new NoSuchElementException();
    }

    public Iterator<E> iterator() {
        return new ac(this, (byte) 0);
    }

    public boolean offer(E e2) {
        return offerLast(e2);
    }

    public boolean offer(E e2, long j, TimeUnit timeUnit) throws InterruptedException {
        return offerLast(e2, j, timeUnit);
    }

    public boolean offerFirst(E e2) {
        if (e2 != null) {
            Node node = new Node(e2);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                return linkFirst(node);
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new NullPointerException();
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean offerFirst(E e2, long j, TimeUnit timeUnit) throws InterruptedException {
        if (e2 != null) {
            Node node = new Node(e2);
            long nanos = timeUnit.toNanos(j);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lockInterruptibly();
            while (!linkFirst(node)) {
                try {
                    if (nanos <= 0) {
                        reentrantLock.unlock();
                        return false;
                    }
                    nanos = this.notFull.awaitNanos(nanos);
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            }
            reentrantLock.unlock();
            return true;
        }
        throw new NullPointerException();
    }

    public boolean offerLast(E e2) {
        if (e2 != null) {
            Node node = new Node(e2);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                return linkLast(node);
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new NullPointerException();
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean offerLast(E e2, long j, TimeUnit timeUnit) throws InterruptedException {
        if (e2 != null) {
            Node node = new Node(e2);
            long nanos = timeUnit.toNanos(j);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lockInterruptibly();
            while (!linkLast(node)) {
                try {
                    if (nanos <= 0) {
                        reentrantLock.unlock();
                        return false;
                    }
                    nanos = this.notFull.awaitNanos(nanos);
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            }
            reentrantLock.unlock();
            return true;
        }
        throw new NullPointerException();
    }

    public E peek() {
        return peekFirst();
    }

    public E peekFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.first == null ? null : this.first.f31086a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E peekLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.last == null ? null : this.last.f31086a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E poll() {
        return pollFirst();
    }

    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        return pollFirst(j, timeUnit);
    }

    public E pollFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return unlinkFirst();
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public E pollFirst(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E unlinkFirst = unlinkFirst();
                if (unlinkFirst != null) {
                    reentrantLock.unlock();
                    return unlinkFirst;
                } else if (nanos <= 0) {
                    reentrantLock.unlock();
                    return null;
                } else {
                    nanos = this.notEmpty.awaitNanos(nanos);
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    public E pollLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return unlinkLast();
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public E pollLast(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E unlinkLast = unlinkLast();
                if (unlinkLast != null) {
                    reentrantLock.unlock();
                    return unlinkLast;
                } else if (nanos <= 0) {
                    reentrantLock.unlock();
                    return null;
                } else {
                    nanos = this.notEmpty.awaitNanos(nanos);
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    public E pop() {
        return removeFirst();
    }

    public void push(E e2) {
        addFirst(e2);
    }

    public void put(E e2) throws InterruptedException {
        putLast(e2);
    }

    public void putFirst(E e2) throws InterruptedException {
        if (e2 != null) {
            Node node = new Node(e2);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            while (!linkFirst(node)) {
                try {
                    this.notFull.await();
                } finally {
                    reentrantLock.unlock();
                }
            }
            return;
        }
        throw new NullPointerException();
    }

    public void putLast(E e2) throws InterruptedException {
        if (e2 != null) {
            Node node = new Node(e2);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            while (!linkLast(node)) {
                try {
                    this.notFull.await();
                } finally {
                    reentrantLock.unlock();
                }
            }
            return;
        }
        throw new NullPointerException();
    }

    public int remainingCapacity() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.capacity - this.count;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E remove() {
        return removeFirst();
    }

    public boolean remove(Object obj) {
        return removeFirstOccurrence(obj);
    }

    public E removeFirst() {
        E pollFirst = pollFirst();
        if (pollFirst != null) {
            return pollFirst;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: finally extract failed */
    public boolean removeFirstOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (Node<E> node = this.first; node != null; node = node.f31088c) {
                if (obj.equals(node.f31086a)) {
                    unlink(node);
                    reentrantLock.unlock();
                    return true;
                }
            }
            reentrantLock.unlock();
            return false;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public E removeLast() {
        E pollLast = pollLast();
        if (pollLast != null) {
            return pollLast;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: finally extract failed */
    public boolean removeLastOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (Node<E> node = this.last; node != null; node = node.f31087b) {
                if (obj.equals(node.f31086a)) {
                    unlink(node);
                    reentrantLock.unlock();
                    return true;
                }
            }
            reentrantLock.unlock();
            return false;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public int size() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.count;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E take() throws InterruptedException {
        return takeFirst();
    }

    public E takeFirst() throws InterruptedException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                E unlinkFirst = unlinkFirst();
                if (unlinkFirst != null) {
                    return unlinkFirst;
                }
                this.notEmpty.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public E takeLast() throws InterruptedException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                E unlinkLast = unlinkLast();
                if (unlinkLast != null) {
                    return unlinkLast;
                }
                this.notEmpty.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public Object[] toArray() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object[] objArr = new Object[this.count];
            int i = 0;
            Node<E> node = this.first;
            while (node != null) {
                int i2 = i + 1;
                objArr[i] = node.f31086a;
                node = node.f31088c;
                i = i2;
            }
            return objArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    public <T> T[] toArray(T[] tArr) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int length = tArr.length;
            T[] tArr2 = tArr;
            if (length < this.count) {
                tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.count);
            }
            int i = 0;
            Node<E> node = this.first;
            while (node != null) {
                tArr2[i] = node.f31086a;
                node = node.f31088c;
                i++;
            }
            if (tArr2.length > i) {
                tArr2[i] = null;
            }
            return tArr2;
        } finally {
            reentrantLock.unlock();
        }
    }

    public String toString() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Node<E> node = this.first;
            if (node == null) {
                return "[]";
            }
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            while (true) {
                E e2 = node.f31086a;
                if (e2 == this) {
                    e2 = "(this Collection)";
                }
                sb.append(e2);
                node = node.f31088c;
                if (node == null) {
                    sb.append(']');
                    String sb2 = sb.toString();
                    reentrantLock.unlock();
                    return sb2;
                }
                sb.append(',');
                sb.append(' ');
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public void unlink(Node<E> node) {
        Node<E> node2 = node.f31087b;
        Node<E> node3 = node.f31088c;
        if (node2 == null) {
            unlinkFirst();
        } else if (node3 == null) {
            unlinkLast();
        } else {
            node2.f31088c = node3;
            node3.f31087b = node2;
            node.f31086a = null;
            this.count--;
            this.notFull.signal();
        }
    }
}
