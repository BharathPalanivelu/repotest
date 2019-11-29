package androidx.a.a.b;

import androidx.a.a.b.b;
import java.util.HashMap;
import java.util.Map;

public class a<K, V> extends b<K, V> {

    /* renamed from: b  reason: collision with root package name */
    private HashMap<K, b.c<K, V>> f507b = new HashMap<>();

    /* access modifiers changed from: protected */
    public b.c<K, V> a(K k) {
        return this.f507b.get(k);
    }

    public V a(K k, V v) {
        b.c a2 = a(k);
        if (a2 != null) {
            return a2.f513b;
        }
        this.f507b.put(k, b(k, v));
        return null;
    }

    public V b(K k) {
        V b2 = super.b(k);
        this.f507b.remove(k);
        return b2;
    }

    public boolean c(K k) {
        return this.f507b.containsKey(k);
    }

    public Map.Entry<K, V> d(K k) {
        if (c(k)) {
            return this.f507b.get(k).f515d;
        }
        return null;
    }
}
