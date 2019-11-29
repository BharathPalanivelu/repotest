package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.e;
import java.util.Map;

@SuppressLint({"RestrictedApi"})
public final class a {

    /* renamed from: a  reason: collision with root package name */
    boolean f2986a = true;

    /* renamed from: b  reason: collision with root package name */
    private androidx.a.a.b.b<String, b> f2987b = new androidx.a.a.b.b<>();

    /* renamed from: c  reason: collision with root package name */
    private Bundle f2988c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2989d;

    /* renamed from: androidx.savedstate.a$a  reason: collision with other inner class name */
    public interface C0063a {
        void a(c cVar);
    }

    public interface b {
        Bundle a();
    }

    a() {
    }

    public Bundle a(String str) {
        if (this.f2989d) {
            Bundle bundle = this.f2988c;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle.getBundle(str);
            this.f2988c.remove(str);
            if (this.f2988c.isEmpty()) {
                this.f2988c = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    /* access modifiers changed from: package-private */
    public void a(e eVar, Bundle bundle) {
        if (!this.f2989d) {
            if (bundle != null) {
                this.f2988c = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            }
            eVar.a(new SavedStateRegistry$1(this));
            this.f2989d = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already restored.");
    }

    /* access modifiers changed from: package-private */
    public void a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f2988c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        androidx.a.a.b.b<K, V>.d c2 = this.f2987b.c();
        while (c2.hasNext()) {
            Map.Entry entry = (Map.Entry) c2.next();
            bundle2.putBundle((String) entry.getKey(), ((b) entry.getValue()).a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
