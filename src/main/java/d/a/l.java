package d.a;

import com.facebook.share.internal.MessengerShareContentUtility;
import d.d.b.j;
import d.e.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class l extends k {
    public static final <T> List<T> a() {
        return v.f32651a;
    }

    public static final <T> List<T> a(T... tArr) {
        j.b(tArr, MessengerShareContentUtility.ELEMENTS);
        return tArr.length > 0 ? d.a(tArr) : j.a();
    }

    public static final <T> ArrayList<T> b(T... tArr) {
        j.b(tArr, MessengerShareContentUtility.ELEMENTS);
        return tArr.length == 0 ? new ArrayList<>() : new ArrayList<>(new c(tArr, true));
    }

    public static final c a(Collection<?> collection) {
        j.b(collection, "$this$indices");
        return new c(0, collection.size() - 1);
    }

    public static final <T> int a(List<? extends T> list) {
        j.b(list, "$this$lastIndex");
        return list.size() - 1;
    }

    public static final <T> List<T> b(List<? extends T> list) {
        j.b(list, "$this$optimizeReadOnlyList");
        int size = list.size();
        if (size == 0) {
            return j.a();
        }
        if (size != 1) {
            return list;
        }
        return j.a(list.get(0));
    }

    public static final void b() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
