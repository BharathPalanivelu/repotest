package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.r;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.g.b;
import java.util.ArrayList;

class ActionMenuPresenter extends androidx.appcompat.view.menu.b implements b.a {

    /* renamed from: g  reason: collision with root package name */
    d f922g;
    e h;
    a i;
    c j;
    final f k = new f();
    int l;
    private Drawable m;
    private boolean n;
    private boolean o;
    private boolean p;
    private int q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private int x;
    private final SparseBooleanArray y = new SparseBooleanArray();
    private b z;

    public ActionMenuPresenter(Context context) {
        super(context, a.g.abc_action_menu_layout, a.g.abc_action_menu_item_layout);
    }

    public void a(Context context, g gVar) {
        super.a(context, gVar);
        Resources resources = context.getResources();
        androidx.appcompat.view.a a2 = androidx.appcompat.view.a.a(context);
        if (!this.p) {
            this.o = a2.b();
        }
        if (!this.v) {
            this.q = a2.c();
        }
        if (!this.t) {
            this.s = a2.a();
        }
        int i2 = this.q;
        if (this.o) {
            if (this.f922g == null) {
                this.f922g = new d(this.f808a);
                if (this.n) {
                    this.f922g.setImageDrawable(this.m);
                    this.m = null;
                    this.n = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f922g.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i2 -= this.f922g.getMeasuredWidth();
        } else {
            this.f922g = null;
        }
        this.r = i2;
        this.x = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public void a(Configuration configuration) {
        if (!this.t) {
            this.s = androidx.appcompat.view.a.a(this.f809b).a();
        }
        if (this.f810c != null) {
            this.f810c.b(true);
        }
    }

    public void b(boolean z2) {
        this.o = z2;
        this.p = true;
    }

    public void c(boolean z2) {
        this.w = z2;
    }

    public void a(Drawable drawable) {
        d dVar = this.f922g;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
            return;
        }
        this.n = true;
        this.m = drawable;
    }

    public Drawable d() {
        d dVar = this.f922g;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.n) {
            return this.m;
        }
        return null;
    }

    public n a(ViewGroup viewGroup) {
        n nVar = this.f813f;
        n a2 = super.a(viewGroup);
        if (nVar != a2) {
            ((ActionMenuView) a2).setPresenter(this);
        }
        return a2;
    }

    public View a(i iVar, View view, ViewGroup viewGroup) {
        View actionView = iVar.getActionView();
        if (actionView == null || iVar.n()) {
            actionView = super.a(iVar, view, viewGroup);
        }
        actionView.setVisibility(iVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    public void a(i iVar, n.a aVar) {
        aVar.a(iVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f813f);
        if (this.z == null) {
            this.z = new b();
        }
        actionMenuItemView.setPopupCallback(this.z);
    }

    public boolean a(int i2, i iVar) {
        return iVar.j();
    }

    public void a(boolean z2) {
        super.a(z2);
        ((View) this.f813f).requestLayout();
        boolean z3 = false;
        if (this.f810c != null) {
            ArrayList<i> l2 = this.f810c.l();
            int size = l2.size();
            for (int i2 = 0; i2 < size; i2++) {
                androidx.core.g.b a2 = l2.get(i2).a();
                if (a2 != null) {
                    a2.a((b.a) this);
                }
            }
        }
        ArrayList<i> m2 = this.f810c != null ? this.f810c.m() : null;
        if (this.o && m2 != null) {
            int size2 = m2.size();
            if (size2 == 1) {
                z3 = !m2.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z3 = true;
            }
        }
        if (z3) {
            if (this.f922g == null) {
                this.f922g = new d(this.f808a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f922g.getParent();
            if (viewGroup != this.f813f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f922g);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f813f;
                actionMenuView.addView(this.f922g, actionMenuView.c());
            }
        } else {
            d dVar = this.f922g;
            if (dVar != null && dVar.getParent() == this.f813f) {
                ((ViewGroup) this.f813f).removeView(this.f922g);
            }
        }
        ((ActionMenuView) this.f813f).setOverflowReserved(this.o);
    }

    public boolean a(ViewGroup viewGroup, int i2) {
        if (viewGroup.getChildAt(i2) == this.f922g) {
            return false;
        }
        return super.a(viewGroup, i2);
    }

    public boolean a(r rVar) {
        boolean z2 = false;
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        r rVar2 = rVar;
        while (rVar2.t() != this.f810c) {
            rVar2 = (r) rVar2.t();
        }
        View a2 = a(rVar2.getItem());
        if (a2 == null) {
            return false;
        }
        this.l = rVar.getItem().getItemId();
        int size = rVar.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            MenuItem item = rVar.getItem(i2);
            if (item.isVisible() && item.getIcon() != null) {
                z2 = true;
                break;
            }
            i2++;
        }
        this.i = new a(this.f809b, rVar, a2);
        this.i.a(z2);
        this.i.a();
        super.a(rVar);
        return true;
    }

    private View a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f813f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof n.a) && ((n.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean e() {
        if (!this.o || j() || this.f810c == null || this.f813f == null || this.j != null || this.f810c.m().isEmpty()) {
            return false;
        }
        this.j = new c(new e(this.f809b, this.f810c, this.f922g, true));
        ((View) this.f813f).post(this.j);
        super.a((r) null);
        return true;
    }

    public boolean g() {
        if (this.j == null || this.f813f == null) {
            e eVar = this.h;
            if (eVar == null) {
                return false;
            }
            eVar.d();
            return true;
        }
        ((View) this.f813f).removeCallbacks(this.j);
        this.j = null;
        return true;
    }

    public boolean h() {
        return g() | i();
    }

    public boolean i() {
        a aVar = this.i;
        if (aVar == null) {
            return false;
        }
        aVar.d();
        return true;
    }

    public boolean j() {
        e eVar = this.h;
        return eVar != null && eVar.f();
    }

    public boolean k() {
        return this.j != null || j();
    }

    public boolean b() {
        int i2;
        ArrayList<i> arrayList;
        int i3;
        int i4;
        int i5;
        boolean z2;
        ActionMenuPresenter actionMenuPresenter = this;
        View view = null;
        int i6 = 0;
        if (actionMenuPresenter.f810c != null) {
            arrayList = actionMenuPresenter.f810c.j();
            i2 = arrayList.size();
        } else {
            arrayList = null;
            i2 = 0;
        }
        int i7 = actionMenuPresenter.s;
        int i8 = actionMenuPresenter.r;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.f813f;
        int i9 = i7;
        boolean z3 = false;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < i2; i12++) {
            i iVar = arrayList.get(i12);
            if (iVar.l()) {
                i10++;
            } else if (iVar.k()) {
                i11++;
            } else {
                z3 = true;
            }
            if (actionMenuPresenter.w && iVar.isActionViewExpanded()) {
                i9 = 0;
            }
        }
        if (actionMenuPresenter.o && (z3 || i11 + i10 > i9)) {
            i9--;
        }
        int i13 = i9 - i10;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.y;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.u) {
            int i14 = actionMenuPresenter.x;
            i3 = i8 / i14;
            i4 = i14 + ((i8 % i14) / i3);
        } else {
            i4 = 0;
            i3 = 0;
        }
        int i15 = i8;
        int i16 = 0;
        int i17 = 0;
        while (i16 < i2) {
            i iVar2 = arrayList.get(i16);
            if (iVar2.l()) {
                View a2 = actionMenuPresenter.a(iVar2, view, viewGroup);
                if (actionMenuPresenter.u) {
                    i3 -= ActionMenuView.a(a2, i4, i3, makeMeasureSpec, i6);
                } else {
                    a2.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = a2.getMeasuredWidth();
                i15 -= measuredWidth;
                if (i17 != 0) {
                    measuredWidth = i17;
                }
                int groupId = iVar2.getGroupId();
                if (groupId != 0) {
                    z2 = true;
                    sparseBooleanArray.put(groupId, true);
                } else {
                    z2 = true;
                }
                iVar2.d(z2);
                i17 = measuredWidth;
                i5 = i2;
            } else if (iVar2.k()) {
                int groupId2 = iVar2.getGroupId();
                boolean z4 = sparseBooleanArray.get(groupId2);
                boolean z5 = (i13 > 0 || z4) && i15 > 0 && (!actionMenuPresenter.u || i3 > 0);
                if (z5) {
                    boolean z6 = z5;
                    i5 = i2;
                    View a3 = actionMenuPresenter.a(iVar2, (View) null, viewGroup);
                    if (actionMenuPresenter.u) {
                        int a4 = ActionMenuView.a(a3, i4, i3, makeMeasureSpec, 0);
                        i3 -= a4;
                        z6 = a4 == 0 ? false : z6;
                    } else {
                        a3.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    int measuredWidth2 = a3.getMeasuredWidth();
                    i15 -= measuredWidth2;
                    if (i17 == 0) {
                        i17 = measuredWidth2;
                    }
                    z5 = z6 & (!actionMenuPresenter.u ? i15 + i17 > 0 : i15 >= 0);
                } else {
                    boolean z7 = z5;
                    i5 = i2;
                }
                if (z5 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z4) {
                    sparseBooleanArray.put(groupId2, false);
                    int i18 = 0;
                    while (i18 < i16) {
                        i iVar3 = arrayList.get(i18);
                        if (iVar3.getGroupId() == groupId2) {
                            if (iVar3.j()) {
                                i13++;
                            }
                            iVar3.d(false);
                        }
                        i18++;
                    }
                }
                if (z5) {
                    i13--;
                }
                iVar2.d(z5);
            } else {
                i5 = i2;
                iVar2.d(false);
                i16++;
                actionMenuPresenter = this;
                i2 = i5;
                view = null;
                i6 = 0;
            }
            i16++;
            actionMenuPresenter = this;
            i2 = i5;
            view = null;
            i6 = 0;
        }
        return true;
    }

    public void a(g gVar, boolean z2) {
        h();
        super.a(gVar, z2);
    }

    public Parcelable f() {
        SavedState savedState = new SavedState();
        savedState.f923a = this.l;
        return savedState;
    }

    public void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            if (savedState.f923a > 0) {
                MenuItem findItem = this.f810c.findItem(savedState.f923a);
                if (findItem != null) {
                    a((r) findItem.getSubMenu());
                }
            }
        }
    }

    public void d(boolean z2) {
        if (z2) {
            super.a((r) null);
        } else if (this.f810c != null) {
            this.f810c.a(false);
        }
    }

    public void a(ActionMenuView actionMenuView) {
        this.f813f = actionMenuView;
        actionMenuView.a(this.f810c);
    }

    @SuppressLint({"BanParcelableUsage"})
    private static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        public int f923a;

        public int describeContents() {
            return 0;
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f923a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f923a);
        }
    }

    private class d extends AppCompatImageView implements ActionMenuView.a {

        /* renamed from: b  reason: collision with root package name */
        private final float[] f929b = new float[2];

        public boolean c() {
            return false;
        }

        public boolean d() {
            return false;
        }

        public d(Context context) {
            super(context, (AttributeSet) null, a.C0012a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            at.a(this, getContentDescription());
            setOnTouchListener(new ac(this, ActionMenuPresenter.this) {
                public p a() {
                    if (ActionMenuPresenter.this.h == null) {
                        return null;
                    }
                    return ActionMenuPresenter.this.h.b();
                }

                public boolean b() {
                    ActionMenuPresenter.this.e();
                    return true;
                }

                public boolean c() {
                    if (ActionMenuPresenter.this.j != null) {
                        return false;
                    }
                    ActionMenuPresenter.this.g();
                    return true;
                }
            });
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.e();
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.a(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    private class e extends l {
        public e(Context context, g gVar, View view, boolean z) {
            super(context, gVar, view, z, a.C0012a.actionOverflowMenuStyle);
            a(8388613);
            a((m.a) ActionMenuPresenter.this.k);
        }

        /* access modifiers changed from: protected */
        public void e() {
            if (ActionMenuPresenter.this.f810c != null) {
                ActionMenuPresenter.this.f810c.close();
            }
            ActionMenuPresenter.this.h = null;
            super.e();
        }
    }

    private class a extends l {
        public a(Context context, r rVar, View view) {
            super(context, rVar, view, false, a.C0012a.actionOverflowMenuStyle);
            if (!((i) rVar.getItem()).j()) {
                a(ActionMenuPresenter.this.f922g == null ? (View) ActionMenuPresenter.this.f813f : ActionMenuPresenter.this.f922g);
            }
            a((m.a) ActionMenuPresenter.this.k);
        }

        /* access modifiers changed from: protected */
        public void e() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.i = null;
            actionMenuPresenter.l = 0;
            super.e();
        }
    }

    private class f implements m.a {
        f() {
        }

        public boolean a(g gVar) {
            if (gVar == null) {
                return false;
            }
            ActionMenuPresenter.this.l = ((r) gVar).getItem().getItemId();
            m.a a2 = ActionMenuPresenter.this.a();
            if (a2 != null) {
                return a2.a(gVar);
            }
            return false;
        }

        public void a(g gVar, boolean z) {
            if (gVar instanceof r) {
                gVar.q().a(false);
            }
            m.a a2 = ActionMenuPresenter.this.a();
            if (a2 != null) {
                a2.a(gVar, z);
            }
        }
    }

    private class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private e f927b;

        public c(e eVar) {
            this.f927b = eVar;
        }

        public void run() {
            if (ActionMenuPresenter.this.f810c != null) {
                ActionMenuPresenter.this.f810c.g();
            }
            View view = (View) ActionMenuPresenter.this.f813f;
            if (!(view == null || view.getWindowToken() == null || !this.f927b.c())) {
                ActionMenuPresenter.this.h = this.f927b;
            }
            ActionMenuPresenter.this.j = null;
        }
    }

    private class b extends ActionMenuItemView.b {
        b() {
        }

        public p a() {
            if (ActionMenuPresenter.this.i != null) {
                return ActionMenuPresenter.this.i.b();
            }
            return null;
        }
    }
}
