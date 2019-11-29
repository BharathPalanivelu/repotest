package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.q;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

class j extends q {

    /* renamed from: a  reason: collision with root package name */
    private static final r.a f2214a = new r.a() {
        public <T extends q> T a(Class<T> cls) {
            return new j(true);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final HashSet<Fragment> f2215b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, j> f2216c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<String, s> f2217d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private final boolean f2218e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2219f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2220g = false;

    static j a(s sVar) {
        return (j) new r(sVar, f2214a).a(j.class);
    }

    j(boolean z) {
        this.f2218e = z;
    }

    /* access modifiers changed from: protected */
    public void a() {
        if (i.f2176b) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f2219f = true;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.f2219f;
    }

    /* access modifiers changed from: package-private */
    public boolean a(Fragment fragment) {
        return this.f2215b.add(fragment);
    }

    /* access modifiers changed from: package-private */
    public Collection<Fragment> c() {
        return this.f2215b;
    }

    /* access modifiers changed from: package-private */
    public boolean b(Fragment fragment) {
        if (!this.f2215b.contains(fragment)) {
            return true;
        }
        if (this.f2218e) {
            return this.f2219f;
        }
        return !this.f2220g;
    }

    /* access modifiers changed from: package-private */
    public boolean c(Fragment fragment) {
        return this.f2215b.remove(fragment);
    }

    /* access modifiers changed from: package-private */
    public j d(Fragment fragment) {
        j jVar = this.f2216c.get(fragment.mWho);
        if (jVar != null) {
            return jVar;
        }
        j jVar2 = new j(this.f2218e);
        this.f2216c.put(fragment.mWho, jVar2);
        return jVar2;
    }

    /* access modifiers changed from: package-private */
    public s e(Fragment fragment) {
        s sVar = this.f2217d.get(fragment.mWho);
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s();
        this.f2217d.put(fragment.mWho, sVar2);
        return sVar2;
    }

    /* access modifiers changed from: package-private */
    public void f(Fragment fragment) {
        if (i.f2176b) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        j jVar = this.f2216c.get(fragment.mWho);
        if (jVar != null) {
            jVar.a();
            this.f2216c.remove(fragment.mWho);
        }
        s sVar = this.f2217d.get(fragment.mWho);
        if (sVar != null) {
            sVar.a();
            this.f2217d.remove(fragment.mWho);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        if (!this.f2215b.equals(jVar.f2215b) || !this.f2216c.equals(jVar.f2216c) || !this.f2217d.equals(jVar.f2217d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((this.f2215b.hashCode() * 31) + this.f2216c.hashCode()) * 31) + this.f2217d.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.f2215b.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f2216c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f2217d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
