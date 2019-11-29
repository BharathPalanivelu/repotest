package d.a;

import com.facebook.share.internal.MessengerShareContentUtility;
import d.d.b.j;
import java.util.HashSet;

class ag extends af {
    public static final <T> HashSet<T> a(T... tArr) {
        j.b(tArr, MessengerShareContentUtility.ELEMENTS);
        return (HashSet) d.a(tArr, new HashSet(z.a(tArr.length)));
    }
}
