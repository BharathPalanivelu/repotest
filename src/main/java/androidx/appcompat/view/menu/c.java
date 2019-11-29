package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.b.a;
import androidx.core.a.a.b;
import java.util.Iterator;
import java.util.Map;

abstract class c {

    /* renamed from: a  reason: collision with root package name */
    final Context f815a;

    /* renamed from: b  reason: collision with root package name */
    private Map<b, MenuItem> f816b;

    /* renamed from: c  reason: collision with root package name */
    private Map<androidx.core.a.a.c, SubMenu> f817c;

    c(Context context) {
        this.f815a = context;
    }

    /* access modifiers changed from: package-private */
    public final MenuItem a(MenuItem menuItem) {
        if (!(menuItem instanceof b)) {
            return menuItem;
        }
        b bVar = (b) menuItem;
        if (this.f816b == null) {
            this.f816b = new a();
        }
        MenuItem menuItem2 = this.f816b.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        j jVar = new j(this.f815a, bVar);
        this.f816b.put(bVar, jVar);
        return jVar;
    }

    /* access modifiers changed from: package-private */
    public final SubMenu a(SubMenu subMenu) {
        if (!(subMenu instanceof androidx.core.a.a.c)) {
            return subMenu;
        }
        androidx.core.a.a.c cVar = (androidx.core.a.a.c) subMenu;
        if (this.f817c == null) {
            this.f817c = new a();
        }
        SubMenu subMenu2 = this.f817c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        s sVar = new s(this.f815a, cVar);
        this.f817c.put(cVar, sVar);
        return sVar;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        Map<b, MenuItem> map = this.f816b;
        if (map != null) {
            map.clear();
        }
        Map<androidx.core.a.a.c, SubMenu> map2 = this.f817c;
        if (map2 != null) {
            map2.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i) {
        Map<b, MenuItem> map = this.f816b;
        if (map != null) {
            Iterator<b> it = map.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(int i) {
        Map<b, MenuItem> map = this.f816b;
        if (map != null) {
            Iterator<b> it = map.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
