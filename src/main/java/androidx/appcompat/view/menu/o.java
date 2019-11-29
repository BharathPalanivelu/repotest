package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.core.a.a.a;

public class o extends c implements Menu {

    /* renamed from: b  reason: collision with root package name */
    private final a f889b;

    public o(Context context, a aVar) {
        super(context);
        if (aVar != null) {
            this.f889b = aVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public MenuItem add(CharSequence charSequence) {
        return a(this.f889b.add(charSequence));
    }

    public MenuItem add(int i) {
        return a(this.f889b.add(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(this.f889b.add(i, i2, i3, charSequence));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(this.f889b.add(i, i2, i3, i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return a(this.f889b.addSubMenu(charSequence));
    }

    public SubMenu addSubMenu(int i) {
        return a(this.f889b.addSubMenu(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return a(this.f889b.addSubMenu(i, i2, i3, charSequence));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return a(this.f889b.addSubMenu(i, i2, i3, i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr;
        MenuItem[] menuItemArr3 = menuItemArr2 != null ? new MenuItem[menuItemArr2.length] : null;
        int addIntentOptions = this.f889b.addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr3);
        if (menuItemArr3 != null) {
            int length = menuItemArr3.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr2[i5] = a(menuItemArr3[i5]);
            }
        }
        return addIntentOptions;
    }

    public void removeItem(int i) {
        b(i);
        this.f889b.removeItem(i);
    }

    public void removeGroup(int i) {
        a(i);
        this.f889b.removeGroup(i);
    }

    public void clear() {
        a();
        this.f889b.clear();
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        this.f889b.setGroupCheckable(i, z, z2);
    }

    public void setGroupVisible(int i, boolean z) {
        this.f889b.setGroupVisible(i, z);
    }

    public void setGroupEnabled(int i, boolean z) {
        this.f889b.setGroupEnabled(i, z);
    }

    public boolean hasVisibleItems() {
        return this.f889b.hasVisibleItems();
    }

    public MenuItem findItem(int i) {
        return a(this.f889b.findItem(i));
    }

    public int size() {
        return this.f889b.size();
    }

    public MenuItem getItem(int i) {
        return a(this.f889b.getItem(i));
    }

    public void close() {
        this.f889b.close();
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return this.f889b.performShortcut(i, keyEvent, i2);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return this.f889b.isShortcutKey(i, keyEvent);
    }

    public boolean performIdentifierAction(int i, int i2) {
        return this.f889b.performIdentifierAction(i, i2);
    }

    public void setQwertyMode(boolean z) {
        this.f889b.setQwertyMode(z);
    }
}
