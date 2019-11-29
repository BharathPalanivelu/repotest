package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.a.a.c;

class s extends o implements SubMenu {

    /* renamed from: b  reason: collision with root package name */
    private final c f901b;

    s(Context context, c cVar) {
        super(context, cVar);
        this.f901b = cVar;
    }

    public SubMenu setHeaderTitle(int i) {
        this.f901b.setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f901b.setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        this.f901b.setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        this.f901b.setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        this.f901b.setHeaderView(view);
        return this;
    }

    public void clearHeader() {
        this.f901b.clearHeader();
    }

    public SubMenu setIcon(int i) {
        this.f901b.setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f901b.setIcon(drawable);
        return this;
    }

    public MenuItem getItem() {
        return a(this.f901b.getItem());
    }
}
