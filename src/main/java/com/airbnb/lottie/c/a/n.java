package com.airbnb.lottie.c.a;

import com.airbnb.lottie.g.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

abstract class n<V, O> implements m<V, O> {

    /* renamed from: a  reason: collision with root package name */
    final List<a<V>> f3526a;

    n(V v) {
        this(Collections.singletonList(new a(v)));
    }

    n(List<a<V>> list) {
        this.f3526a = list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f3526a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f3526a.toArray()));
        }
        return sb.toString();
    }
}
