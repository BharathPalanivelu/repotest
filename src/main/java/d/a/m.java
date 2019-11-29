package d.a;

import d.d.b.j;
import java.util.Collection;

class m extends l {
    public static final <T> int a(Iterable<? extends T> iterable, int i) {
        j.b(iterable, "$this$collectionSizeOrDefault");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }
}
