package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.af;
import androidx.appcompat.widget.ag;
import androidx.core.g.w;
import java.util.ArrayList;
import java.util.List;

final class d extends k implements View.OnKeyListener, PopupWindow.OnDismissListener, m {

    /* renamed from: g  reason: collision with root package name */
    private static final int f818g = a.g.abc_cascading_menu_item_layout;
    private PopupWindow.OnDismissListener A;

    /* renamed from: a  reason: collision with root package name */
    final Handler f819a;

    /* renamed from: b  reason: collision with root package name */
    final List<a> f820b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f821c = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (d.this.e() && d.this.f820b.size() > 0 && !d.this.f820b.get(0).f832a.j()) {
                View view = d.this.f822d;
                if (view == null || !view.isShown()) {
                    d.this.d();
                    return;
                }
                for (a aVar : d.this.f820b) {
                    aVar.f832a.a_();
                }
            }
        }
    };

    /* renamed from: d  reason: collision with root package name */
    View f822d;

    /* renamed from: e  reason: collision with root package name */
    ViewTreeObserver f823e;

    /* renamed from: f  reason: collision with root package name */
    boolean f824f;
    private final Context h;
    private final int i;
    private final int j;
    private final int k;
    private final boolean l;
    private final List<g> m = new ArrayList();
    private final View.OnAttachStateChangeListener n = new View.OnAttachStateChangeListener() {
        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            if (d.this.f823e != null) {
                if (!d.this.f823e.isAlive()) {
                    d.this.f823e = view.getViewTreeObserver();
                }
                d.this.f823e.removeGlobalOnLayoutListener(d.this.f821c);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private final af o = new af() {
        public void a(g gVar, MenuItem menuItem) {
            d.this.f819a.removeCallbacksAndMessages(gVar);
        }

        public void b(final g gVar, final MenuItem menuItem) {
            final a aVar = null;
            d.this.f819a.removeCallbacksAndMessages((Object) null);
            int size = d.this.f820b.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (gVar == d.this.f820b.get(i).f833b) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                int i2 = i + 1;
                if (i2 < d.this.f820b.size()) {
                    aVar = d.this.f820b.get(i2);
                }
                d.this.f819a.postAtTime(new Runnable() {
                    public void run() {
                        if (aVar != null) {
                            d.this.f824f = true;
                            aVar.f833b.a(false);
                            d.this.f824f = false;
                        }
                        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                            gVar.a(menuItem, 4);
                        }
                    }
                }, gVar, SystemClock.uptimeMillis() + 200);
            }
        }
    };
    private int p = 0;
    private int q = 0;
    private View r;
    private int s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private boolean x;
    private boolean y;
    private m.a z;

    public void a(Parcelable parcelable) {
    }

    public boolean b() {
        return false;
    }

    public Parcelable f() {
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        return false;
    }

    public d(Context context, View view, int i2, int i3, boolean z2) {
        this.h = context;
        this.r = view;
        this.j = i2;
        this.k = i3;
        this.l = z2;
        this.x = false;
        this.s = k();
        Resources resources = context.getResources();
        this.i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
        this.f819a = new Handler();
    }

    public void b(boolean z2) {
        this.x = z2;
    }

    private ag j() {
        ag agVar = new ag(this.h, (AttributeSet) null, this.j, this.k);
        agVar.a(this.o);
        agVar.a((AdapterView.OnItemClickListener) this);
        agVar.a((PopupWindow.OnDismissListener) this);
        agVar.b(this.r);
        agVar.f(this.q);
        agVar.a(true);
        agVar.i(2);
        return agVar;
    }

    public void a_() {
        if (!e()) {
            for (g c2 : this.m) {
                c(c2);
            }
            this.m.clear();
            this.f822d = this.r;
            if (this.f822d != null) {
                boolean z2 = this.f823e == null;
                this.f823e = this.f822d.getViewTreeObserver();
                if (z2) {
                    this.f823e.addOnGlobalLayoutListener(this.f821c);
                }
                this.f822d.addOnAttachStateChangeListener(this.n);
            }
        }
    }

    public void d() {
        int size = this.f820b.size();
        if (size > 0) {
            a[] aVarArr = (a[]) this.f820b.toArray(new a[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                a aVar = aVarArr[i2];
                if (aVar.f832a.e()) {
                    aVar.f832a.d();
                }
            }
        }
    }

    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        d();
        return true;
    }

    private int k() {
        return w.g(this.r) == 1 ? 0 : 1;
    }

    private int d(int i2) {
        List<a> list = this.f820b;
        ListView a2 = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        a2.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f822d.getWindowVisibleDisplayFrame(rect);
        if (this.s == 1) {
            if (iArr[0] + a2.getWidth() + i2 > rect.right) {
                return 0;
            }
            return 1;
        } else if (iArr[0] - i2 < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public void a(g gVar) {
        gVar.a((m) this, this.h);
        if (e()) {
            c(gVar);
        } else {
            this.m.add(gVar);
        }
    }

    private void c(g gVar) {
        View view;
        a aVar;
        int i2;
        int i3;
        int i4;
        LayoutInflater from = LayoutInflater.from(this.h);
        f fVar = new f(gVar, from, this.l, f818g);
        if (!e() && this.x) {
            fVar.a(true);
        } else if (e()) {
            fVar.a(k.b(gVar));
        }
        int a2 = a(fVar, (ViewGroup) null, this.h, this.i);
        ag j2 = j();
        j2.a((ListAdapter) fVar);
        j2.h(a2);
        j2.f(this.q);
        if (this.f820b.size() > 0) {
            List<a> list = this.f820b;
            aVar = list.get(list.size() - 1);
            view = a(aVar, gVar);
        } else {
            aVar = null;
            view = null;
        }
        if (view != null) {
            j2.c(false);
            j2.a((Object) null);
            int d2 = d(a2);
            boolean z2 = d2 == 1;
            this.s = d2;
            if (Build.VERSION.SDK_INT >= 26) {
                j2.b(view);
                i3 = 0;
                i2 = 0;
            } else {
                int[] iArr = new int[2];
                this.r.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.q & 7) == 5) {
                    iArr[0] = iArr[0] + this.r.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i2 = iArr2[0] - iArr[0];
                i3 = iArr2[1] - iArr[1];
            }
            if ((this.q & 5) != 5) {
                if (z2) {
                    a2 = view.getWidth();
                }
                i4 = i2 - a2;
                j2.b(i4);
                j2.b(true);
                j2.a(i3);
            } else if (!z2) {
                a2 = view.getWidth();
                i4 = i2 - a2;
                j2.b(i4);
                j2.b(true);
                j2.a(i3);
            }
            i4 = i2 + a2;
            j2.b(i4);
            j2.b(true);
            j2.a(i3);
        } else {
            if (this.t) {
                j2.b(this.v);
            }
            if (this.u) {
                j2.a(this.w);
            }
            j2.a(i());
        }
        this.f820b.add(new a(j2, gVar, this.s));
        j2.a_();
        ListView g2 = j2.g();
        g2.setOnKeyListener(this);
        if (aVar == null && this.y && gVar.n() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(a.g.abc_popup_menu_header_item_layout, g2, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(gVar.n());
            g2.addHeaderView(frameLayout, (Object) null, false);
            j2.a_();
        }
    }

    private MenuItem a(g gVar, g gVar2) {
        int size = gVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = gVar.getItem(i2);
            if (item.hasSubMenu() && gVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View a(a aVar, g gVar) {
        int i2;
        f fVar;
        MenuItem a2 = a(aVar.f833b, gVar);
        if (a2 == null) {
            return null;
        }
        ListView a3 = aVar.a();
        ListAdapter adapter = a3.getAdapter();
        int i3 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i2 = headerViewListAdapter.getHeadersCount();
            fVar = (f) headerViewListAdapter.getWrappedAdapter();
        } else {
            fVar = (f) adapter;
            i2 = 0;
        }
        int count = fVar.getCount();
        while (true) {
            if (i3 >= count) {
                i3 = -1;
                break;
            } else if (a2 == fVar.getItem(i3)) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 == -1) {
            return null;
        }
        int firstVisiblePosition = (i3 + i2) - a3.getFirstVisiblePosition();
        if (firstVisiblePosition < 0 || firstVisiblePosition >= a3.getChildCount()) {
            return null;
        }
        return a3.getChildAt(firstVisiblePosition);
    }

    public boolean e() {
        return this.f820b.size() > 0 && this.f820b.get(0).f832a.e();
    }

    public void onDismiss() {
        a aVar;
        int size = this.f820b.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                aVar = null;
                break;
            }
            aVar = this.f820b.get(i2);
            if (!aVar.f832a.e()) {
                break;
            }
            i2++;
        }
        if (aVar != null) {
            aVar.f833b.a(false);
        }
    }

    public void a(boolean z2) {
        for (a a2 : this.f820b) {
            a(a2.a().getAdapter()).notifyDataSetChanged();
        }
    }

    public void a(m.a aVar) {
        this.z = aVar;
    }

    public boolean a(r rVar) {
        for (a next : this.f820b) {
            if (rVar == next.f833b) {
                next.a().requestFocus();
                return true;
            }
        }
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        a((g) rVar);
        m.a aVar = this.z;
        if (aVar != null) {
            aVar.a(rVar);
        }
        return true;
    }

    private int d(g gVar) {
        int size = this.f820b.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (gVar == this.f820b.get(i2).f833b) {
                return i2;
            }
        }
        return -1;
    }

    public void a(g gVar, boolean z2) {
        int d2 = d(gVar);
        if (d2 >= 0) {
            int i2 = d2 + 1;
            if (i2 < this.f820b.size()) {
                this.f820b.get(i2).f833b.a(false);
            }
            a remove = this.f820b.remove(d2);
            remove.f833b.b((m) this);
            if (this.f824f) {
                remove.f832a.b((Object) null);
                remove.f832a.e(0);
            }
            remove.f832a.d();
            int size = this.f820b.size();
            if (size > 0) {
                this.s = this.f820b.get(size - 1).f834c;
            } else {
                this.s = k();
            }
            if (size == 0) {
                d();
                m.a aVar = this.z;
                if (aVar != null) {
                    aVar.a(gVar, true);
                }
                ViewTreeObserver viewTreeObserver = this.f823e;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.f823e.removeGlobalOnLayoutListener(this.f821c);
                    }
                    this.f823e = null;
                }
                this.f822d.removeOnAttachStateChangeListener(this.n);
                this.A.onDismiss();
            } else if (z2) {
                this.f820b.get(0).f833b.a(false);
            }
        }
    }

    public void a(int i2) {
        if (this.p != i2) {
            this.p = i2;
            this.q = androidx.core.g.d.a(i2, w.g(this.r));
        }
    }

    public void a(View view) {
        if (this.r != view) {
            this.r = view;
            this.q = androidx.core.g.d.a(this.p, w.g(this.r));
        }
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.A = onDismissListener;
    }

    public ListView g() {
        if (this.f820b.isEmpty()) {
            return null;
        }
        List<a> list = this.f820b;
        return list.get(list.size() - 1).a();
    }

    public void b(int i2) {
        this.t = true;
        this.v = i2;
    }

    public void c(int i2) {
        this.u = true;
        this.w = i2;
    }

    public void c(boolean z2) {
        this.y = z2;
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public final ag f832a;

        /* renamed from: b  reason: collision with root package name */
        public final g f833b;

        /* renamed from: c  reason: collision with root package name */
        public final int f834c;

        public a(ag agVar, g gVar, int i) {
            this.f832a = agVar;
            this.f833b = gVar;
            this.f834c = i;
        }

        public ListView a() {
            return this.f832a.g();
        }
    }
}
