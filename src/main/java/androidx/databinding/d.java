package androidx.databinding;

import java.io.Serializable;

public class d<T> extends b implements Serializable {
    static final long serialVersionUID = 1;
    private T mValue;

    public d(T t) {
        this.mValue = t;
    }

    public d() {
    }

    public T a() {
        return this.mValue;
    }
}
