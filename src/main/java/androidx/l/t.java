package androidx.l;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class t {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f2533a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public View f2534b;

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<n> f2535c = new ArrayList<>();

    public boolean equals(Object obj) {
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.f2534b == tVar.f2534b && this.f2533a.equals(tVar.f2533a);
    }

    public int hashCode() {
        return (this.f2534b.hashCode() * 31) + this.f2533a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f2534b + "\n") + "    values:";
        for (String next : this.f2533a.keySet()) {
            str = str + "    " + next + ": " + this.f2533a.get(next) + "\n";
        }
        return str;
    }
}
