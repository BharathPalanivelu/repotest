package d.a;

import com.facebook.share.internal.MessengerShareContentUtility;
import d.d.b.b;
import d.d.b.f;
import d.d.b.j;
import java.util.Collection;
import java.util.Iterator;

final class c<T> implements Collection<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T[] f32646a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f32647b;

    public boolean add(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public <T> T[] toArray(T[] tArr) {
        return f.a(this, tArr);
    }

    public c(T[] tArr, boolean z) {
        j.b(tArr, "values");
        this.f32646a = tArr;
        this.f32647b = z;
    }

    public final int size() {
        return a();
    }

    public int a() {
        return this.f32646a.length;
    }

    public boolean isEmpty() {
        return this.f32646a.length == 0;
    }

    public boolean contains(Object obj) {
        return d.a(this.f32646a, obj);
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        j.b(collection, MessengerShareContentUtility.ELEMENTS);
        Iterable<Object> iterable = collection;
        if (((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Object contains : iterable) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<T> iterator() {
        return b.a(this.f32646a);
    }

    public final Object[] toArray() {
        return j.a(this.f32646a, this.f32647b);
    }
}
