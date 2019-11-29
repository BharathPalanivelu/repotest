package d.a;

import com.facebook.share.internal.MessengerShareContentUtility;
import d.d.a.b;
import d.d.b.f;
import d.d.b.j;
import d.d.b.k;
import d.m;
import java.util.Collection;

public abstract class a<E> implements Collection<E> {
    public abstract int a();

    public boolean add(E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends E> collection) {
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

    protected a() {
    }

    public final int size() {
        return a();
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

    public boolean isEmpty() {
        return size() == 0;
    }

    /* renamed from: d.a.a$a  reason: collision with other inner class name */
    static final class C0495a extends k implements b<E, CharSequence> {
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0495a(a aVar) {
            super(1);
            this.this$0 = aVar;
        }

        /* renamed from: b */
        public final CharSequence a(E e2) {
            return e2 == this.this$0 ? "(this Collection)" : String.valueOf(e2);
        }
    }

    public String toString() {
        return j.a(this, ", ", "[", "]", 0, (CharSequence) null, new C0495a(this), 24, (Object) null);
    }

    public Object[] toArray() {
        return f.a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        j.b(tArr, "array");
        T[] a2 = f.a(this, tArr);
        if (a2 != null) {
            return a2;
        }
        throw new m("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public boolean contains(Object obj) {
        if ((this instanceof Collection) && isEmpty()) {
            return false;
        }
        for (Object a2 : this) {
            if (j.a(a2, obj)) {
                return true;
            }
        }
        return false;
    }
}
