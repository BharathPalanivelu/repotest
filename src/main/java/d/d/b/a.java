package d.d.b;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class a<T> implements Iterator<T> {

    /* renamed from: a  reason: collision with root package name */
    private int f32657a;

    /* renamed from: b  reason: collision with root package name */
    private final T[] f32658b;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public a(T[] tArr) {
        j.b(tArr, "array");
        this.f32658b = tArr;
    }

    public boolean hasNext() {
        return this.f32657a < this.f32658b.length;
    }

    public T next() {
        try {
            T[] tArr = this.f32658b;
            int i = this.f32657a;
            this.f32657a = i + 1;
            return tArr[i];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f32657a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }
}
