package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ag;
import androidx.core.g.w;

final class q extends k implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener, m {

    /* renamed from: e  reason: collision with root package name */
    private static final int f890e = a.g.abc_popup_menu_item_layout;

    /* renamed from: a  reason: collision with root package name */
    final ag f891a;

    /* renamed from: b  reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f892b = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (q.this.e() && !q.this.f891a.j()) {
                View view = q.this.f893c;
                if (view == null || !view.isShown()) {
                    q.this.d();
                } else {
                    q.this.f891a.a_();
                }
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    View f893c;

    /* renamed from: d  reason: collision with root package name */
    ViewTreeObserver f894d;

    /* renamed from: f  reason: collision with root package name */
    private final Context f895f;

    /* renamed from: g  reason: collision with root package name */
    private final g f896g;
    private final f h;
    private final boolean i;
    private final int j;
    private final int k;
    private final int l;
    private final View.OnAttachStateChangeListener m = new View.OnAttachStateChangeListener() {
        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            if (q.this.f894d != null) {
                if (!q.this.f894d.isAlive()) {
                    q.this.f894d = view.getViewTreeObserver();
                }
                q.this.f894d.removeGlobalOnLayoutListener(q.this.f892b);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private PopupWindow.OnDismissListener n;
    private View o;
    private m.a p;
    private boolean q;
    private boolean r;
    private int s;
    private int t = 0;
    private boolean u;

    public void a(Parcelable parcelable) {
    }

    public void a(g gVar) {
    }

    public boolean b() {
        return false;
    }

    public Parcelable f() {
        return null;
    }

    public q(Context context, g gVar, View view, int i2, int i3, boolean z) {
        this.f895f = context;
        this.f896g = gVar;
        this.i = z;
        this.h = new f(gVar, LayoutInflater.from(context), this.i, f890e);
        this.k = i2;
        this.l = i3;
        Resources resources = context.getResources();
        this.j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
        this.o = view;
        this.f891a = new ag(this.f895f, (AttributeSet) null, this.k, this.l);
        gVar.a((m) this, context);
    }

    public void b(boolean z) {
        this.h.a(z);
    }

    public void a(int i2) {
        this.t = i2;
    }

    private boolean j() {
        if (e()) {
            return true;
        }
        if (!this.q) {
            View view = this.o;
            if (view != null) {
                this.f893c = view;
                this.f891a.a((PopupWindow.OnDismissListener) this);
                this.f891a.a((AdapterView.OnItemClickListener) this);
                this.f891a.a(true);
                View view2 = this.f893c;
                boolean z = this.f894d == null;
                this.f894d = view2.getViewTreeObserver();
                if (z) {
                    this.f894d.addOnGlobalLayoutListener(this.f892b);
                }
                view2.addOnAttachStateChangeListener(this.m);
                this.f891a.b(view2);
                this.f891a.f(this.t);
                if (!this.r) {
                    this.s = a(this.h, (ViewGroup) null, this.f895f, this.j);
                    this.r = true;
                }
                this.f891a.h(this.s);
                this.f891a.i(2);
                this.f891a.a(i());
                this.f891a.a_();
                ListView g2 = this.f891a.g();
                g2.setOnKeyListener(this);
                if (this.u && this.f896g.n() != null) {
                    FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f895f).inflate(a.g.abc_popup_menu_header_item_layout, g2, false);
                    TextView textView = (TextView) frameLayout.findViewById(16908310);
                    if (textView != null) {
                        textView.setText(this.f896g.n());
                    }
                    frameLayout.setEnabled(false);
                    g2.addHeaderView(frameLayout, (Object) null, false);
                }
                this.f891a.a((ListAdapter) this.h);
                this.f891a.a_();
                return true;
            }
        }
        return false;
    }

    public void a_() {
        if (!j()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public void d() {
        if (e()) {
            this.f891a.d();
        }
    }

    public boolean e() {
        return !this.q && this.f891a.e();
    }

    public void onDismiss() {
        this.q = true;
        this.f896g.close();
        ViewTreeObserver viewTreeObserver = this.f894d;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f894d = this.f893c.getViewTreeObserver();
            }
            this.f894d.removeGlobalOnLayoutListener(this.f892b);
            this.f894d = null;
        }
        this.f893c.removeOnAttachStateChangeListener(this.m);
        PopupWindow.OnDismissListener onDismissListener = this.n;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void a(boolean z) {
        this.r = false;
        f fVar = this.h;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    public void a(m.a aVar) {
        this.p = aVar;
    }

    public boolean a(r rVar) {
        if (rVar.hasVisibleItems()) {
            l lVar = new l(this.f895f, rVar, this.f893c, this.i, this.k, this.l);
            lVar.a(this.p);
            lVar.a(k.b((g) rVar));
            lVar.a(this.n);
            this.n = null;
            this.f896g.a(false);
            int f2 = this.f891a.f();
            int c2 = this.f891a.c();
            if ((Gravity.getAbsoluteGravity(this.t, w.g(this.o)) & 7) == 5) {
                f2 += this.o.getWidth();
            }
            if (lVar.a(f2, c2)) {
                m.a aVar = this.p;
                if (aVar == null) {
                    return true;
                }
                aVar.a(rVar);
                return true;
            }
        }
        return false;
    }

    public void a(g gVar, boolean z) {
        if (gVar == this.f896g) {
            d();
            m.a aVar = this.p;
            if (aVar != null) {
                aVar.a(gVar, z);
            }
        }
    }

    public void a(View view) {
        this.o = view;
    }

    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        d();
        return true;
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.n = onDismissListener;
    }

    public ListView g() {
        return this.f891a.g();
    }

    public void b(int i2) {
        this.f891a.b(i2);
    }

    public void c(int i2) {
        this.f891a.a(i2);
    }

    public void c(boolean z) {
        this.u = z;
    }
}
