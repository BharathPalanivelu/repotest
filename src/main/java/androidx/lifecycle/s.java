package androidx.lifecycle;

import java.util.HashMap;

public class s {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, q> f2594a = new HashMap<>();

    /* access modifiers changed from: package-private */
    public final void a(String str, q qVar) {
        q put = this.f2594a.put(str, qVar);
        if (put != null) {
            put.a();
        }
    }

    /* access modifiers changed from: package-private */
    public final q a(String str) {
        return this.f2594a.get(str);
    }

    public final void a() {
        for (q d2 : this.f2594a.values()) {
            d2.d();
        }
        this.f2594a.clear();
    }
}
