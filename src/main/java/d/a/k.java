package d.a;

import d.d.b.j;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class k {
    public static final <T> List<T> a(T t) {
        List<T> singletonList = Collections.singletonList(t);
        j.a((Object) singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }

    public static final <T> Object[] a(T[] tArr, boolean z) {
        j.b(tArr, "$this$copyToArrayOfAny");
        if (z && j.a((Object) tArr.getClass(), (Object) Object[].class)) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        j.a((Object) copyOf, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
        return copyOf;
    }
}
