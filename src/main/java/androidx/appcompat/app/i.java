package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.as;
import androidx.appcompat.widget.y;
import androidx.core.g.w;
import java.util.ArrayList;

class i extends a {

    /* renamed from: a  reason: collision with root package name */
    y f655a;

    /* renamed from: b  reason: collision with root package name */
    boolean f656b;

    /* renamed from: c  reason: collision with root package name */
    Window.Callback f657c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f658d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f659e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<a.b> f660f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private final Runnable f661g = new Runnable() {
        public void run() {
            i.this.i();
        }
    };
    private final Toolbar.c h = new Toolbar.c() {
        public boolean onMenuItemClick(MenuItem menuItem) {
            return i.this.f657c.onMenuItemSelected(0, menuItem);
        }
    };

    public void a(boolean z) {
    }

    public void c(boolean z) {
    }

    public void d(boolean z) {
    }

    i(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.f655a = new as(toolbar, false);
        this.f657c = new c(callback);
        this.f655a.a(this.f657c);
        toolbar.setOnMenuItemClickListener(this.h);
        this.f655a.a(charSequence);
    }

    public Window.Callback h() {
        return this.f657c;
    }

    public void a(float f2) {
        w.b((View) this.f655a.a(), f2);
    }

    public Context b() {
        return this.f655a.b();
    }

    public void a(int i) {
        this.f655a.d(i);
    }

    public void a(Configuration configuration) {
        super.a(configuration);
    }

    public void a(CharSequence charSequence) {
        this.f655a.b(charSequence);
    }

    public void b(CharSequence charSequence) {
        this.f655a.a(charSequence);
    }

    public int a() {
        return this.f655a.o();
    }

    public boolean c() {
        return this.f655a.k();
    }

    public boolean d() {
        return this.f655a.l();
    }

    public boolean e() {
        this.f655a.a().removeCallbacks(this.f661g);
        w.a((View) this.f655a.a(), this.f661g);
        return true;
    }

    public boolean f() {
        if (!this.f655a.c()) {
            return false;
        }
        this.f655a.d();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void i() {
        Menu j = j();
        g gVar = j instanceof g ? (g) j : null;
        if (gVar != null) {
            gVar.h();
        }
        try {
            j.clear();
            if (!this.f657c.onCreatePanelMenu(0, j) || !this.f657c.onPreparePanel(0, (View) null, j)) {
                j.clear();
            }
        } finally {
            if (gVar != null) {
                gVar.i();
            }
        }
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            c();
        }
        return true;
    }

    public boolean a(int i, KeyEvent keyEvent) {
        Menu j = j();
        if (j == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        j.setQwertyMode(z);
        return j.performShortcut(i, keyEvent, 0);
    }

    /* access modifiers changed from: package-private */
    public void g() {
        this.f655a.a().removeCallbacks(this.f661g);
    }

    public void e(boolean z) {
        if (z != this.f659e) {
            this.f659e = z;
            int size = this.f660f.size();
            for (int i = 0; i < size; i++) {
                this.f660f.get(i).a(z);
            }
        }
    }

    private class c extends androidx.appcompat.view.i {
        public c(Window.Callback callback) {
            super(callback);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel && !i.this.f656b) {
                i.this.f655a.m();
                i.this.f656b = true;
            }
            return onPreparePanel;
        }

        public View onCreatePanelView(int i) {
            if (i == 0) {
                return new View(i.this.f655a.b());
            }
            return super.onCreatePanelView(i);
        }
    }

    private Menu j() {
        if (!this.f658d) {
            this.f655a.a((m.a) new a(), (g.a) new b());
            this.f658d = true;
        }
        return this.f655a.q();
    }

    private final class a implements m.a {

        /* renamed from: b  reason: collision with root package name */
        private boolean f665b;

        a() {
        }

        public boolean a(g gVar) {
            if (i.this.f657c == null) {
                return false;
            }
            i.this.f657c.onMenuOpened(108, gVar);
            return true;
        }

        public void a(g gVar, boolean z) {
            if (!this.f665b) {
                this.f665b = true;
                i.this.f655a.n();
                if (i.this.f657c != null) {
                    i.this.f657c.onPanelClosed(108, gVar);
                }
                this.f665b = false;
            }
        }
    }

    private final class b implements g.a {
        public boolean a(g gVar, MenuItem menuItem) {
            return false;
        }

        b() {
        }

        public void a(g gVar) {
            if (i.this.f657c == null) {
                return;
            }
            if (i.this.f655a.i()) {
                i.this.f657c.onPanelClosed(108, gVar);
            } else if (i.this.f657c.onPreparePanel(0, (View) null, gVar)) {
                i.this.f657c.onMenuOpened(108, gVar);
            }
        }
    }
}
