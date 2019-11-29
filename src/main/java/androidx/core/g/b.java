package androidx.core.g;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1770a;

    /* renamed from: b  reason: collision with root package name */
    private a f1771b;

    /* renamed from: c  reason: collision with root package name */
    private C0036b f1772c;

    public interface a {
        void d(boolean z);
    }

    /* renamed from: androidx.core.g.b$b  reason: collision with other inner class name */
    public interface C0036b {
        void a(boolean z);
    }

    public abstract View a();

    public void a(SubMenu subMenu) {
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return true;
    }

    public b(Context context) {
        this.f1770a = context;
    }

    public View a(MenuItem menuItem) {
        return a();
    }

    public void a(boolean z) {
        a aVar = this.f1771b;
        if (aVar != null) {
            aVar.d(z);
        }
    }

    public void a(a aVar) {
        this.f1771b = aVar;
    }

    public void a(C0036b bVar) {
        if (!(this.f1772c == null || bVar == null)) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f1772c = bVar;
    }

    public void f() {
        this.f1772c = null;
        this.f1771b = null;
    }
}
