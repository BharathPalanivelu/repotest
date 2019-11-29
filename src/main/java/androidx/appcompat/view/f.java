package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.o;
import androidx.b.g;
import java.util.ArrayList;

public class f extends ActionMode {

    /* renamed from: a  reason: collision with root package name */
    final Context f752a;

    /* renamed from: b  reason: collision with root package name */
    final b f753b;

    public f(Context context, b bVar) {
        this.f752a = context;
        this.f753b = bVar;
    }

    public Object getTag() {
        return this.f753b.j();
    }

    public void setTag(Object obj) {
        this.f753b.a(obj);
    }

    public void setTitle(CharSequence charSequence) {
        this.f753b.b(charSequence);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f753b.a(charSequence);
    }

    public void invalidate() {
        this.f753b.d();
    }

    public void finish() {
        this.f753b.c();
    }

    public Menu getMenu() {
        return new o(this.f752a, (androidx.core.a.a.a) this.f753b.b());
    }

    public CharSequence getTitle() {
        return this.f753b.f();
    }

    public void setTitle(int i) {
        this.f753b.a(i);
    }

    public CharSequence getSubtitle() {
        return this.f753b.g();
    }

    public void setSubtitle(int i) {
        this.f753b.b(i);
    }

    public View getCustomView() {
        return this.f753b.i();
    }

    public void setCustomView(View view) {
        this.f753b.a(view);
    }

    public MenuInflater getMenuInflater() {
        return this.f753b.a();
    }

    public boolean getTitleOptionalHint() {
        return this.f753b.k();
    }

    public void setTitleOptionalHint(boolean z) {
        this.f753b.a(z);
    }

    public boolean isTitleOptional() {
        return this.f753b.h();
    }

    public static class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final ActionMode.Callback f754a;

        /* renamed from: b  reason: collision with root package name */
        final Context f755b;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<f> f756c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        final g<Menu, Menu> f757d = new g<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f755b = context;
            this.f754a = callback;
        }

        public boolean a(b bVar, Menu menu) {
            return this.f754a.onCreateActionMode(b(bVar), a(menu));
        }

        public boolean b(b bVar, Menu menu) {
            return this.f754a.onPrepareActionMode(b(bVar), a(menu));
        }

        public boolean a(b bVar, MenuItem menuItem) {
            return this.f754a.onActionItemClicked(b(bVar), new j(this.f755b, (androidx.core.a.a.b) menuItem));
        }

        public void a(b bVar) {
            this.f754a.onDestroyActionMode(b(bVar));
        }

        private Menu a(Menu menu) {
            Menu menu2 = this.f757d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            o oVar = new o(this.f755b, (androidx.core.a.a.a) menu);
            this.f757d.put(menu, oVar);
            return oVar;
        }

        public ActionMode b(b bVar) {
            int size = this.f756c.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.f756c.get(i);
                if (fVar != null && fVar.f753b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f755b, bVar);
            this.f756c.add(fVar2);
            return fVar2;
        }
    }
}
