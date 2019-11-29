package d.a;

import com.facebook.share.internal.MessengerShareContentUtility;
import d.d.b.f;
import d.d.b.j;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class x implements Serializable, Set {

    /* renamed from: a  reason: collision with root package name */
    public static final x f32653a = new x();
    private static final long serialVersionUID = 3406603774387020532L;

    public int a() {
        return 0;
    }

    public boolean a(Void voidR) {
        j.b(voidR, "element");
        return false;
    }

    public /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public int hashCode() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object[] toArray() {
        return f.a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        return f.a(this, tArr);
    }

    public String toString() {
        return "[]";
    }

    private x() {
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Void) {
            return a((Void) obj);
        }
        return false;
    }

    public final int size() {
        return a();
    }

    public boolean equals(Object obj) {
        return (obj instanceof Set) && ((Set) obj).isEmpty();
    }

    public boolean containsAll(Collection collection) {
        j.b(collection, MessengerShareContentUtility.ELEMENTS);
        return collection.isEmpty();
    }

    public Iterator iterator() {
        return u.f32650a;
    }

    private final Object readResolve() {
        return f32653a;
    }
}
