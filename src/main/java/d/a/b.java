package d.a;

import com.appsflyer.share.Constants;
import com.facebook.internal.FacebookRequestErrorClassification;
import d.d.b.j;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

public abstract class b<E> extends a<E> implements List<E> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f32639a = new a((g) null);

    public void add(int i, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public abstract E get(int i);

    public E remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public E set(int i, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    protected b() {
    }

    public Iterator<E> iterator() {
        return new C0496b();
    }

    public ListIterator<E> listIterator() {
        return new c(0);
    }

    public ListIterator<E> listIterator(int i) {
        return new c(i);
    }

    public List<E> subList(int i, int i2) {
        return new d<>(this, i, i2);
    }

    private static final class d<E> extends b<E> implements RandomAccess {

        /* renamed from: b  reason: collision with root package name */
        private int f32643b;

        /* renamed from: c  reason: collision with root package name */
        private final b<E> f32644c;

        /* renamed from: d  reason: collision with root package name */
        private final int f32645d;

        public d(b<? extends E> bVar, int i, int i2) {
            j.b(bVar, "list");
            this.f32644c = bVar;
            this.f32645d = i;
            b.f32639a.a(this.f32645d, i2, this.f32644c.size());
            this.f32643b = i2 - this.f32645d;
        }

        public E get(int i) {
            b.f32639a.a(i, this.f32643b);
            return this.f32644c.get(this.f32645d + i);
        }

        public int a() {
            return this.f32643b;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        return f32639a.a((Collection<?>) this, (Collection<?>) (Collection) obj);
    }

    public int hashCode() {
        return f32639a.a(this);
    }

    /* renamed from: d.a.b$b  reason: collision with other inner class name */
    private class C0496b implements Iterator<E> {

        /* renamed from: b  reason: collision with root package name */
        private int f32641b;

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public C0496b() {
        }

        /* access modifiers changed from: protected */
        public final int a() {
            return this.f32641b;
        }

        /* access modifiers changed from: protected */
        public final void a(int i) {
            this.f32641b = i;
        }

        public boolean hasNext() {
            return this.f32641b < b.this.size();
        }

        public E next() {
            if (hasNext()) {
                b bVar = b.this;
                int i = this.f32641b;
                this.f32641b = i + 1;
                return bVar.get(i);
            }
            throw new NoSuchElementException();
        }
    }

    private class c extends b<E>.b implements ListIterator<E> {
        public void add(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public void set(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public c(int i) {
            super();
            b.f32639a.b(i, b.this.size());
            a(i);
        }

        public boolean hasPrevious() {
            return a() > 0;
        }

        public int nextIndex() {
            return a();
        }

        public E previous() {
            if (hasPrevious()) {
                b bVar = b.this;
                a(a() - 1);
                return bVar.get(a());
            }
            throw new NoSuchElementException();
        }

        public int previousIndex() {
            return a() - 1;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final void a(int i, int i2) {
            if (i < 0 || i >= i2) {
                throw new IndexOutOfBoundsException("index: " + i + ", size: " + i2);
            }
        }

        public final void b(int i, int i2) {
            if (i < 0 || i > i2) {
                throw new IndexOutOfBoundsException("index: " + i + ", size: " + i2);
            }
        }

        public final void a(int i, int i2, int i3) {
            if (i < 0 || i2 > i3) {
                throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i2 + ", size: " + i3);
            } else if (i > i2) {
                throw new IllegalArgumentException("fromIndex: " + i + " > toIndex: " + i2);
            }
        }

        public final int a(Collection<?> collection) {
            j.b(collection, Constants.URL_CAMPAIGN);
            Iterator<?> it = collection.iterator();
            int i = 1;
            while (it.hasNext()) {
                Object next = it.next();
                i = (i * 31) + (next != null ? next.hashCode() : 0);
            }
            return i;
        }

        public final boolean a(Collection<?> collection, Collection<?> collection2) {
            j.b(collection, Constants.URL_CAMPAIGN);
            j.b(collection2, FacebookRequestErrorClassification.KEY_OTHER);
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator<?> it = collection2.iterator();
            for (Object a2 : collection) {
                if (!j.a((Object) a2, (Object) it.next())) {
                    return false;
                }
            }
            return true;
        }
    }

    public int indexOf(Object obj) {
        int i = 0;
        for (Object a2 : this) {
            if (j.a(a2, obj)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int lastIndexOf(Object obj) {
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (j.a(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }
}
