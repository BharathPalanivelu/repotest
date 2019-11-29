package d;

import java.io.Serializable;

public final class c<T> implements e<T>, Serializable {
    private final T value;

    public c(T t) {
        this.value = t;
    }

    public T a() {
        return this.value;
    }

    public String toString() {
        return String.valueOf(a());
    }
}
