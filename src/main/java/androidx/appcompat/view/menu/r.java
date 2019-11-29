package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.g;

public class r extends g implements SubMenu {

    /* renamed from: d  reason: collision with root package name */
    private g f899d;

    /* renamed from: e  reason: collision with root package name */
    private i f900e;

    public r(Context context, g gVar, i iVar) {
        super(context);
        this.f899d = gVar;
        this.f900e = iVar;
    }

    public void setQwertyMode(boolean z) {
        this.f899d.setQwertyMode(z);
    }

    public boolean c() {
        return this.f899d.c();
    }

    public boolean d() {
        return this.f899d.d();
    }

    public Menu t() {
        return this.f899d;
    }

    public MenuItem getItem() {
        return this.f900e;
    }

    public void a(g.a aVar) {
        this.f899d.a(aVar);
    }

    public g q() {
        return this.f899d.q();
    }

    /* access modifiers changed from: package-private */
    public boolean a(g gVar, MenuItem menuItem) {
        return super.a(gVar, menuItem) || this.f899d.a(gVar, menuItem);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f900e.setIcon(drawable);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.f900e.setIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.a(drawable);
    }

    public SubMenu setHeaderIcon(int i) {
        return (SubMenu) super.e(i);
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.a(charSequence);
    }

    public SubMenu setHeaderTitle(int i) {
        return (SubMenu) super.d(i);
    }

    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.a(view);
    }

    public boolean c(i iVar) {
        return this.f899d.c(iVar);
    }

    public boolean d(i iVar) {
        return this.f899d.d(iVar);
    }

    public String a() {
        i iVar = this.f900e;
        int itemId = iVar != null ? iVar.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.a() + ":" + itemId;
    }

    public void setGroupDividerEnabled(boolean z) {
        this.f899d.setGroupDividerEnabled(z);
    }

    public boolean b() {
        return this.f899d.b();
    }
}
