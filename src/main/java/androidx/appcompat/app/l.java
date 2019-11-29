package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.a;
import androidx.appcompat.app.a;
import androidx.appcompat.view.b;
import androidx.appcompat.view.h;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ak;
import androidx.appcompat.widget.y;
import androidx.core.g.aa;
import androidx.core.g.ab;
import androidx.core.g.ac;
import androidx.core.g.ad;
import androidx.core.g.w;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class l extends a implements ActionBarOverlayLayout.a {
    static final /* synthetic */ boolean s = (!l.class.desiredAssertionStatus());
    private static final Interpolator t = new AccelerateInterpolator();
    private static final Interpolator u = new DecelerateInterpolator();
    private boolean A;
    private boolean B;
    private ArrayList<a.b> C = new ArrayList<>();
    private boolean D;
    private int E = 0;
    private boolean F;
    private boolean G = true;
    private boolean H;

    /* renamed from: a  reason: collision with root package name */
    Context f682a;

    /* renamed from: b  reason: collision with root package name */
    ActionBarOverlayLayout f683b;

    /* renamed from: c  reason: collision with root package name */
    ActionBarContainer f684c;

    /* renamed from: d  reason: collision with root package name */
    y f685d;

    /* renamed from: e  reason: collision with root package name */
    ActionBarContextView f686e;

    /* renamed from: f  reason: collision with root package name */
    View f687f;

    /* renamed from: g  reason: collision with root package name */
    ak f688g;
    a h;
    b i;
    b.a j;
    boolean k = true;
    boolean l;
    boolean m;
    h n;
    boolean o;
    final ab p = new ac() {
        public void b(View view) {
            if (l.this.k && l.this.f687f != null) {
                l.this.f687f.setTranslationY(BitmapDescriptorFactory.HUE_RED);
                l.this.f684c.setTranslationY(BitmapDescriptorFactory.HUE_RED);
            }
            l.this.f684c.setVisibility(8);
            l.this.f684c.setTransitioning(false);
            l lVar = l.this;
            lVar.n = null;
            lVar.h();
            if (l.this.f683b != null) {
                w.s(l.this.f683b);
            }
        }
    };
    final ab q = new ac() {
        public void b(View view) {
            l lVar = l.this;
            lVar.n = null;
            lVar.f684c.requestLayout();
        }
    };
    final ad r = new ad() {
        public void a(View view) {
            ((View) l.this.f684c.getParent()).invalidate();
        }
    };
    private Context v;
    private Activity w;
    private Dialog x;
    private ArrayList<Object> y = new ArrayList<>();
    private int z = -1;

    static boolean a(boolean z2, boolean z3, boolean z4) {
        if (z4) {
            return true;
        }
        return !z2 && !z3;
    }

    public void m() {
    }

    public l(Activity activity, boolean z2) {
        this.w = activity;
        View decorView = activity.getWindow().getDecorView();
        a(decorView);
        if (!z2) {
            this.f687f = decorView.findViewById(16908290);
        }
    }

    public l(Dialog dialog) {
        this.x = dialog;
        a(dialog.getWindow().getDecorView());
    }

    private void a(View view) {
        this.f683b = (ActionBarOverlayLayout) view.findViewById(a.f.decor_content_parent);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f683b;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f685d = b(view.findViewById(a.f.action_bar));
        this.f686e = (ActionBarContextView) view.findViewById(a.f.action_context_bar);
        this.f684c = (ActionBarContainer) view.findViewById(a.f.action_bar_container);
        y yVar = this.f685d;
        if (yVar == null || this.f686e == null || this.f684c == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f682a = yVar.b();
        boolean z2 = (this.f685d.o() & 4) != 0;
        if (z2) {
            this.A = true;
        }
        androidx.appcompat.view.a a2 = androidx.appcompat.view.a.a(this.f682a);
        a(a2.f() || z2);
        k(a2.d());
        TypedArray obtainStyledAttributes = this.f682a.obtainStyledAttributes((AttributeSet) null, a.j.ActionBar, a.C0012a.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(a.j.ActionBar_hideOnContentScroll, false)) {
            b(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(a.j.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            a((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private y b(View view) {
        if (view instanceof y) {
            return (y) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != null ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    public void a(float f2) {
        w.b((View) this.f684c, f2);
    }

    public void a(Configuration configuration) {
        k(androidx.appcompat.view.a.a(this.f682a).d());
    }

    private void k(boolean z2) {
        this.D = z2;
        if (!this.D) {
            this.f685d.a((ak) null);
            this.f684c.setTabContainer(this.f688g);
        } else {
            this.f684c.setTabContainer((ak) null);
            this.f685d.a(this.f688g);
        }
        boolean z3 = true;
        boolean z4 = i() == 2;
        ak akVar = this.f688g;
        if (akVar != null) {
            if (z4) {
                akVar.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f683b;
                if (actionBarOverlayLayout != null) {
                    w.s(actionBarOverlayLayout);
                }
            } else {
                akVar.setVisibility(8);
            }
        }
        this.f685d.a(!this.D && z4);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f683b;
        if (this.D || !z4) {
            z3 = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z3);
    }

    /* access modifiers changed from: package-private */
    public void h() {
        b.a aVar = this.j;
        if (aVar != null) {
            aVar.a(this.i);
            this.i = null;
            this.j = null;
        }
    }

    public void b(int i2) {
        this.E = i2;
    }

    public void d(boolean z2) {
        this.H = z2;
        if (!z2) {
            h hVar = this.n;
            if (hVar != null) {
                hVar.c();
            }
        }
    }

    public void e(boolean z2) {
        if (z2 != this.B) {
            this.B = z2;
            int size = this.C.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.C.get(i2).a(z2);
            }
        }
    }

    public void f(boolean z2) {
        a(z2 ? 4 : 0, 4);
    }

    public void a(boolean z2) {
        this.f685d.b(z2);
    }

    public void a(CharSequence charSequence) {
        this.f685d.b(charSequence);
    }

    public void b(CharSequence charSequence) {
        this.f685d.a(charSequence);
    }

    public void a(int i2, int i3) {
        int o2 = this.f685d.o();
        if ((i3 & 4) != 0) {
            this.A = true;
        }
        this.f685d.c((i2 & i3) | ((i3 ^ -1) & o2));
    }

    public int i() {
        return this.f685d.p();
    }

    public int a() {
        return this.f685d.o();
    }

    public b a(b.a aVar) {
        a aVar2 = this.h;
        if (aVar2 != null) {
            aVar2.c();
        }
        this.f683b.setHideOnContentScrollEnabled(false);
        this.f686e.c();
        a aVar3 = new a(this.f686e.getContext(), aVar);
        if (!aVar3.e()) {
            return null;
        }
        this.h = aVar3;
        aVar3.d();
        this.f686e.a(aVar3);
        j(true);
        this.f686e.sendAccessibilityEvent(32);
        return aVar3;
    }

    public void g(boolean z2) {
        this.k = z2;
    }

    private void n() {
        if (!this.F) {
            this.F = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f683b;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            l(false);
        }
    }

    public void j() {
        if (this.m) {
            this.m = false;
            l(true);
        }
    }

    private void o() {
        if (this.F) {
            this.F = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f683b;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            l(false);
        }
    }

    public void k() {
        if (!this.m) {
            this.m = true;
            l(true);
        }
    }

    public void b(boolean z2) {
        if (!z2 || this.f683b.a()) {
            this.o = z2;
            this.f683b.setHideOnContentScrollEnabled(z2);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    private void l(boolean z2) {
        if (a(this.l, this.m, this.F)) {
            if (!this.G) {
                this.G = true;
                h(z2);
            }
        } else if (this.G) {
            this.G = false;
            i(z2);
        }
    }

    public void h(boolean z2) {
        h hVar = this.n;
        if (hVar != null) {
            hVar.c();
        }
        this.f684c.setVisibility(0);
        if (this.E != 0 || (!this.H && !z2)) {
            this.f684c.setAlpha(1.0f);
            this.f684c.setTranslationY(BitmapDescriptorFactory.HUE_RED);
            if (this.k) {
                View view = this.f687f;
                if (view != null) {
                    view.setTranslationY(BitmapDescriptorFactory.HUE_RED);
                }
            }
            this.q.b((View) null);
        } else {
            this.f684c.setTranslationY(BitmapDescriptorFactory.HUE_RED);
            float f2 = (float) (-this.f684c.getHeight());
            if (z2) {
                int[] iArr = {0, 0};
                this.f684c.getLocationInWindow(iArr);
                f2 -= (float) iArr[1];
            }
            this.f684c.setTranslationY(f2);
            h hVar2 = new h();
            aa b2 = w.n(this.f684c).b((float) BitmapDescriptorFactory.HUE_RED);
            b2.a(this.r);
            hVar2.a(b2);
            if (this.k) {
                View view2 = this.f687f;
                if (view2 != null) {
                    view2.setTranslationY(f2);
                    hVar2.a(w.n(this.f687f).b((float) BitmapDescriptorFactory.HUE_RED));
                }
            }
            hVar2.a(u);
            hVar2.a(250);
            hVar2.a(this.q);
            this.n = hVar2;
            hVar2.a();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f683b;
        if (actionBarOverlayLayout != null) {
            w.s(actionBarOverlayLayout);
        }
    }

    public void i(boolean z2) {
        h hVar = this.n;
        if (hVar != null) {
            hVar.c();
        }
        if (this.E != 0 || (!this.H && !z2)) {
            this.p.b((View) null);
            return;
        }
        this.f684c.setAlpha(1.0f);
        this.f684c.setTransitioning(true);
        h hVar2 = new h();
        float f2 = (float) (-this.f684c.getHeight());
        if (z2) {
            int[] iArr = {0, 0};
            this.f684c.getLocationInWindow(iArr);
            f2 -= (float) iArr[1];
        }
        aa b2 = w.n(this.f684c).b(f2);
        b2.a(this.r);
        hVar2.a(b2);
        if (this.k) {
            View view = this.f687f;
            if (view != null) {
                hVar2.a(w.n(view).b(f2));
            }
        }
        hVar2.a(t);
        hVar2.a(250);
        hVar2.a(this.p);
        this.n = hVar2;
        hVar2.a();
    }

    public void j(boolean z2) {
        aa aaVar;
        aa aaVar2;
        if (z2) {
            n();
        } else {
            o();
        }
        if (p()) {
            if (z2) {
                aaVar = this.f685d.a(4, 100);
                aaVar2 = this.f686e.a(0, 200);
            } else {
                aaVar2 = this.f685d.a(0, 200);
                aaVar = this.f686e.a(8, 100);
            }
            h hVar = new h();
            hVar.a(aaVar, aaVar2);
            hVar.a();
        } else if (z2) {
            this.f685d.e(4);
            this.f686e.setVisibility(0);
        } else {
            this.f685d.e(0);
            this.f686e.setVisibility(8);
        }
    }

    private boolean p() {
        return w.A(this.f684c);
    }

    public Context b() {
        if (this.v == null) {
            TypedValue typedValue = new TypedValue();
            this.f682a.getTheme().resolveAttribute(a.C0012a.actionBarWidgetTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.v = new ContextThemeWrapper(this.f682a, i2);
            } else {
                this.v = this.f682a;
            }
        }
        return this.v;
    }

    public void a(int i2) {
        this.f685d.d(i2);
    }

    public void l() {
        h hVar = this.n;
        if (hVar != null) {
            hVar.c();
            this.n = null;
        }
    }

    public boolean f() {
        y yVar = this.f685d;
        if (yVar == null || !yVar.c()) {
            return false;
        }
        this.f685d.d();
        return true;
    }

    public class a extends b implements g.a {

        /* renamed from: b  reason: collision with root package name */
        private final Context f693b;

        /* renamed from: c  reason: collision with root package name */
        private final g f694c;

        /* renamed from: d  reason: collision with root package name */
        private b.a f695d;

        /* renamed from: e  reason: collision with root package name */
        private WeakReference<View> f696e;

        public a(Context context, b.a aVar) {
            this.f693b = context;
            this.f695d = aVar;
            this.f694c = new g(context).a(1);
            this.f694c.a((g.a) this);
        }

        public MenuInflater a() {
            return new androidx.appcompat.view.g(this.f693b);
        }

        public Menu b() {
            return this.f694c;
        }

        public void c() {
            if (l.this.h == this) {
                if (!l.a(l.this.l, l.this.m, false)) {
                    l lVar = l.this;
                    lVar.i = this;
                    lVar.j = this.f695d;
                } else {
                    this.f695d.a(this);
                }
                this.f695d = null;
                l.this.j(false);
                l.this.f686e.b();
                l.this.f685d.a().sendAccessibilityEvent(32);
                l.this.f683b.setHideOnContentScrollEnabled(l.this.o);
                l.this.h = null;
            }
        }

        public void d() {
            if (l.this.h == this) {
                this.f694c.h();
                try {
                    this.f695d.b(this, this.f694c);
                } finally {
                    this.f694c.i();
                }
            }
        }

        public boolean e() {
            this.f694c.h();
            try {
                return this.f695d.a((b) this, (Menu) this.f694c);
            } finally {
                this.f694c.i();
            }
        }

        public void a(View view) {
            l.this.f686e.setCustomView(view);
            this.f696e = new WeakReference<>(view);
        }

        public void a(CharSequence charSequence) {
            l.this.f686e.setSubtitle(charSequence);
        }

        public void b(CharSequence charSequence) {
            l.this.f686e.setTitle(charSequence);
        }

        public void a(int i) {
            b((CharSequence) l.this.f682a.getResources().getString(i));
        }

        public void b(int i) {
            a((CharSequence) l.this.f682a.getResources().getString(i));
        }

        public CharSequence f() {
            return l.this.f686e.getTitle();
        }

        public CharSequence g() {
            return l.this.f686e.getSubtitle();
        }

        public void a(boolean z) {
            super.a(z);
            l.this.f686e.setTitleOptional(z);
        }

        public boolean h() {
            return l.this.f686e.d();
        }

        public View i() {
            WeakReference<View> weakReference = this.f696e;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        public boolean a(g gVar, MenuItem menuItem) {
            b.a aVar = this.f695d;
            if (aVar != null) {
                return aVar.a((b) this, menuItem);
            }
            return false;
        }

        public void a(g gVar) {
            if (this.f695d != null) {
                d();
                l.this.f686e.a();
            }
        }
    }

    public void c(boolean z2) {
        if (!this.A) {
            f(z2);
        }
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        a aVar = this.h;
        if (aVar == null) {
            return false;
        }
        Menu b2 = aVar.b();
        if (b2 == null) {
            return false;
        }
        boolean z2 = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z2 = false;
        }
        b2.setQwertyMode(z2);
        return b2.performShortcut(i2, keyEvent, 0);
    }
}
