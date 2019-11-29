package d.f;

import d.d.a.b;
import d.f.e;

public interface f<T, R> extends b<T, R>, e<R> {

    public interface a<T, R> extends b<T, R>, e.a<R> {
    }

    R b(T t);

    a<T, R> i();
}
