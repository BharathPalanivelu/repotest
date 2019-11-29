package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.Toolbar;
import androidx.core.g.aa;
import androidx.core.g.ab;
import androidx.core.g.ac;
import androidx.core.g.w;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class as implements y {

    /* renamed from: a  reason: collision with root package name */
    Toolbar f1152a;

    /* renamed from: b  reason: collision with root package name */
    CharSequence f1153b;

    /* renamed from: c  reason: collision with root package name */
    Window.Callback f1154c;

    /* renamed from: d  reason: collision with root package name */
    boolean f1155d;

    /* renamed from: e  reason: collision with root package name */
    private int f1156e;

    /* renamed from: f  reason: collision with root package name */
    private View f1157f;

    /* renamed from: g  reason: collision with root package name */
    private View f1158g;
    private Drawable h;
    private Drawable i;
    private Drawable j;
    private boolean k;
    private CharSequence l;
    private CharSequence m;
    private ActionMenuPresenter n;
    private int o;
    private int p;
    private Drawable q;

    public void b(boolean z) {
    }

    public as(Toolbar toolbar, boolean z) {
        this(toolbar, z, a.h.abc_action_bar_up_description, a.e.abc_ic_ab_back_material);
    }

    public as(Toolbar toolbar, boolean z, int i2, int i3) {
        this.o = 0;
        this.p = 0;
        this.f1152a = toolbar;
        this.f1153b = toolbar.getTitle();
        this.l = toolbar.getSubtitle();
        this.k = this.f1153b != null;
        this.j = toolbar.getNavigationIcon();
        ar a2 = ar.a(toolbar.getContext(), (AttributeSet) null, a.j.ActionBar, a.C0012a.actionBarStyle, 0);
        this.q = a2.a(a.j.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence c2 = a2.c(a.j.ActionBar_title);
            if (!TextUtils.isEmpty(c2)) {
                b(c2);
            }
            CharSequence c3 = a2.c(a.j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(c3)) {
                c(c3);
            }
            Drawable a3 = a2.a(a.j.ActionBar_logo);
            if (a3 != null) {
                b(a3);
            }
            Drawable a4 = a2.a(a.j.ActionBar_icon);
            if (a4 != null) {
                a(a4);
            }
            if (this.j == null) {
                Drawable drawable = this.q;
                if (drawable != null) {
                    c(drawable);
                }
            }
            c(a2.a(a.j.ActionBar_displayOptions, 0));
            int g2 = a2.g(a.j.ActionBar_customNavigationLayout, 0);
            if (g2 != 0) {
                a(LayoutInflater.from(this.f1152a.getContext()).inflate(g2, this.f1152a, false));
                c(this.f1156e | 16);
            }
            int f2 = a2.f(a.j.ActionBar_height, 0);
            if (f2 > 0) {
                ViewGroup.LayoutParams layoutParams = this.f1152a.getLayoutParams();
                layoutParams.height = f2;
                this.f1152a.setLayoutParams(layoutParams);
            }
            int d2 = a2.d(a.j.ActionBar_contentInsetStart, -1);
            int d3 = a2.d(a.j.ActionBar_contentInsetEnd, -1);
            if (d2 >= 0 || d3 >= 0) {
                this.f1152a.setContentInsetsRelative(Math.max(d2, 0), Math.max(d3, 0));
            }
            int g3 = a2.g(a.j.ActionBar_titleTextStyle, 0);
            if (g3 != 0) {
                Toolbar toolbar2 = this.f1152a;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), g3);
            }
            int g4 = a2.g(a.j.ActionBar_subtitleTextStyle, 0);
            if (g4 != 0) {
                Toolbar toolbar3 = this.f1152a;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), g4);
            }
            int g5 = a2.g(a.j.ActionBar_popupTheme, 0);
            if (g5 != 0) {
                this.f1152a.setPopupTheme(g5);
            }
        } else {
            this.f1156e = r();
        }
        a2.a();
        f(i2);
        this.m = this.f1152a.getNavigationContentDescription();
        this.f1152a.setNavigationOnClickListener(new View.OnClickListener() {

            /* renamed from: a  reason: collision with root package name */
            final androidx.appcompat.view.menu.a f1159a = new androidx.appcompat.view.menu.a(as.this.f1152a.getContext(), 0, 16908332, 0, 0, as.this.f1153b);

            public void onClick(View view) {
                if (as.this.f1154c != null && as.this.f1155d) {
                    as.this.f1154c.onMenuItemSelected(0, this.f1159a);
                }
            }
        });
    }

    public void f(int i2) {
        if (i2 != this.p) {
            this.p = i2;
            if (TextUtils.isEmpty(this.f1152a.getNavigationContentDescription())) {
                d(this.p);
            }
        }
    }

    private int r() {
        if (this.f1152a.getNavigationIcon() == null) {
            return 11;
        }
        this.q = this.f1152a.getNavigationIcon();
        return 15;
    }

    public ViewGroup a() {
        return this.f1152a;
    }

    public Context b() {
        return this.f1152a.getContext();
    }

    public boolean c() {
        return this.f1152a.hasExpandedActionView();
    }

    public void d() {
        this.f1152a.collapseActionView();
    }

    public void a(Window.Callback callback) {
        this.f1154c = callback;
    }

    public void a(CharSequence charSequence) {
        if (!this.k) {
            e(charSequence);
        }
    }

    public CharSequence e() {
        return this.f1152a.getTitle();
    }

    public void b(CharSequence charSequence) {
        this.k = true;
        e(charSequence);
    }

    private void e(CharSequence charSequence) {
        this.f1153b = charSequence;
        if ((this.f1156e & 8) != 0) {
            this.f1152a.setTitle(charSequence);
        }
    }

    public void c(CharSequence charSequence) {
        this.l = charSequence;
        if ((this.f1156e & 8) != 0) {
            this.f1152a.setSubtitle(charSequence);
        }
    }

    public void f() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void a(int i2) {
        a(i2 != 0 ? androidx.appcompat.a.a.a.b(b(), i2) : null);
    }

    public void a(Drawable drawable) {
        this.h = drawable;
        s();
    }

    public void b(int i2) {
        b(i2 != 0 ? androidx.appcompat.a.a.a.b(b(), i2) : null);
    }

    public void b(Drawable drawable) {
        this.i = drawable;
        s();
    }

    private void s() {
        Drawable drawable;
        int i2 = this.f1156e;
        if ((i2 & 2) == 0) {
            drawable = null;
        } else if ((i2 & 1) != 0) {
            drawable = this.i;
            if (drawable == null) {
                drawable = this.h;
            }
        } else {
            drawable = this.h;
        }
        this.f1152a.setLogo(drawable);
    }

    public boolean h() {
        return this.f1152a.canShowOverflowMenu();
    }

    public boolean i() {
        return this.f1152a.isOverflowMenuShowing();
    }

    public boolean j() {
        return this.f1152a.isOverflowMenuShowPending();
    }

    public boolean k() {
        return this.f1152a.showOverflowMenu();
    }

    public boolean l() {
        return this.f1152a.hideOverflowMenu();
    }

    public void m() {
        this.f1155d = true;
    }

    public void a(Menu menu, m.a aVar) {
        if (this.n == null) {
            this.n = new ActionMenuPresenter(this.f1152a.getContext());
            this.n.a(a.f.action_menu_presenter);
        }
        this.n.a(aVar);
        this.f1152a.setMenu((g) menu, this.n);
    }

    public void n() {
        this.f1152a.dismissPopupMenus();
    }

    public int o() {
        return this.f1156e;
    }

    public void c(int i2) {
        int i3 = this.f1156e ^ i2;
        this.f1156e = i2;
        if (i3 != 0) {
            if ((i3 & 4) != 0) {
                if ((i2 & 4) != 0) {
                    u();
                }
                t();
            }
            if ((i3 & 3) != 0) {
                s();
            }
            if ((i3 & 8) != 0) {
                if ((i2 & 8) != 0) {
                    this.f1152a.setTitle(this.f1153b);
                    this.f1152a.setSubtitle(this.l);
                } else {
                    this.f1152a.setTitle((CharSequence) null);
                    this.f1152a.setSubtitle((CharSequence) null);
                }
            }
            if ((i3 & 16) != 0) {
                View view = this.f1158g;
                if (view == null) {
                    return;
                }
                if ((i2 & 16) != 0) {
                    this.f1152a.addView(view);
                } else {
                    this.f1152a.removeView(view);
                }
            }
        }
    }

    public void a(ak akVar) {
        View view = this.f1157f;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f1152a;
            if (parent == toolbar) {
                toolbar.removeView(this.f1157f);
            }
        }
        this.f1157f = akVar;
        if (akVar != null && this.o == 2) {
            this.f1152a.addView(this.f1157f, 0);
            Toolbar.b bVar = (Toolbar.b) this.f1157f.getLayoutParams();
            bVar.width = -2;
            bVar.height = -2;
            bVar.f632a = 8388691;
            akVar.setAllowCollapse(true);
        }
    }

    public void a(boolean z) {
        this.f1152a.setCollapsible(z);
    }

    public int p() {
        return this.o;
    }

    public void a(View view) {
        View view2 = this.f1158g;
        if (!(view2 == null || (this.f1156e & 16) == 0)) {
            this.f1152a.removeView(view2);
        }
        this.f1158g = view;
        if (view != null && (this.f1156e & 16) != 0) {
            this.f1152a.addView(this.f1158g);
        }
    }

    public aa a(final int i2, long j2) {
        return w.n(this.f1152a).a(i2 == 0 ? 1.0f : BitmapDescriptorFactory.HUE_RED).a(j2).a((ab) new ac() {

            /* renamed from: c  reason: collision with root package name */
            private boolean f1163c = false;

            public void a(View view) {
                as.this.f1152a.setVisibility(0);
            }

            public void b(View view) {
                if (!this.f1163c) {
                    as.this.f1152a.setVisibility(i2);
                }
            }

            public void c(View view) {
                this.f1163c = true;
            }
        });
    }

    public void c(Drawable drawable) {
        this.j = drawable;
        t();
    }

    private void t() {
        if ((this.f1156e & 4) != 0) {
            Toolbar toolbar = this.f1152a;
            Drawable drawable = this.j;
            if (drawable == null) {
                drawable = this.q;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.f1152a.setNavigationIcon((Drawable) null);
    }

    public void d(CharSequence charSequence) {
        this.m = charSequence;
        u();
    }

    public void d(int i2) {
        d((CharSequence) i2 == 0 ? null : b().getString(i2));
    }

    private void u() {
        if ((this.f1156e & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.m)) {
            this.f1152a.setNavigationContentDescription(this.p);
        } else {
            this.f1152a.setNavigationContentDescription(this.m);
        }
    }

    public void e(int i2) {
        this.f1152a.setVisibility(i2);
    }

    public void a(m.a aVar, g.a aVar2) {
        this.f1152a.setMenuCallbacks(aVar, aVar2);
    }

    public Menu q() {
        return this.f1152a.getMenu();
    }
}
