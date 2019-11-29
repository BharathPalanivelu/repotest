package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.a;

public class ActivityChooserView extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    final a f948a;

    /* renamed from: b  reason: collision with root package name */
    final FrameLayout f949b;

    /* renamed from: c  reason: collision with root package name */
    final FrameLayout f950c;

    /* renamed from: d  reason: collision with root package name */
    androidx.core.g.b f951d;

    /* renamed from: e  reason: collision with root package name */
    final DataSetObserver f952e;

    /* renamed from: f  reason: collision with root package name */
    PopupWindow.OnDismissListener f953f;

    /* renamed from: g  reason: collision with root package name */
    boolean f954g;
    int h;
    private final b i;
    private final View j;
    private final ImageView k;
    private final int l;
    private final ViewTreeObserver.OnGlobalLayoutListener m;
    private ae n;
    private boolean o;
    private int p;

    public void setActivityChooserModel(c cVar) {
        this.f948a.a(cVar);
        if (c()) {
            b();
            a();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.k.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i2) {
        this.k.setContentDescription(getContext().getString(i2));
    }

    public void setProvider(androidx.core.g.b bVar) {
        this.f951d = bVar;
    }

    public boolean a() {
        if (c() || !this.o) {
            return false;
        }
        this.f954g = false;
        a(this.h);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        if (this.f948a.d() != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.m);
            boolean z = this.f950c.getVisibility() == 0;
            int c2 = this.f948a.c();
            if (i2 == Integer.MAX_VALUE || c2 <= i2 + (z ? 1 : 0)) {
                this.f948a.a(false);
                this.f948a.a(i2);
            } else {
                this.f948a.a(true);
                this.f948a.a(i2 - 1);
            }
            ae listPopupWindow = getListPopupWindow();
            if (!listPopupWindow.e()) {
                if (this.f954g || !z) {
                    this.f948a.a(true, z);
                } else {
                    this.f948a.a(false, false);
                }
                listPopupWindow.h(Math.min(this.f948a.a(), this.l));
                listPopupWindow.a_();
                androidx.core.g.b bVar = this.f951d;
                if (bVar != null) {
                    bVar.a(true);
                }
                listPopupWindow.g().setContentDescription(getContext().getString(a.h.abc_activitychooserview_choose_application));
                listPopupWindow.g().setSelector(new ColorDrawable(0));
                return;
            }
            return;
        }
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    public boolean b() {
        if (!c()) {
            return true;
        }
        getListPopupWindow().d();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.m);
        return true;
    }

    public boolean c() {
        return getListPopupWindow().e();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c d2 = this.f948a.d();
        if (d2 != null) {
            d2.registerObserver(this.f952e);
        }
        this.o = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c d2 = this.f948a.d();
        if (d2 != null) {
            d2.unregisterObserver(this.f952e);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.m);
        }
        if (c()) {
            b();
        }
        this.o = false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        View view = this.j;
        if (this.f950c.getVisibility() != 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3), 1073741824);
        }
        measureChild(view, i2, i3);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.j.layout(0, 0, i4 - i2, i5 - i3);
        if (!c()) {
            b();
        }
    }

    public c getDataModel() {
        return this.f948a.d();
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f953f = onDismissListener;
    }

    public void setInitialActivityCount(int i2) {
        this.h = i2;
    }

    public void setDefaultActionButtonContentDescription(int i2) {
        this.p = i2;
    }

    /* access modifiers changed from: package-private */
    public ae getListPopupWindow() {
        if (this.n == null) {
            this.n = new ae(getContext());
            this.n.a((ListAdapter) this.f948a);
            this.n.b((View) this);
            this.n.a(true);
            this.n.a((AdapterView.OnItemClickListener) this.i);
            this.n.a((PopupWindow.OnDismissListener) this.i);
        }
        return this.n;
    }

    private class b implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ActivityChooserView f962a;

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int itemViewType = ((a) adapterView.getAdapter()).getItemViewType(i);
            if (itemViewType == 0) {
                this.f962a.b();
                if (!this.f962a.f954g) {
                    if (!this.f962a.f948a.e()) {
                        i++;
                    }
                    Intent b2 = this.f962a.f948a.d().b(i);
                    if (b2 != null) {
                        b2.addFlags(524288);
                        this.f962a.getContext().startActivity(b2);
                    }
                } else if (i > 0) {
                    this.f962a.f948a.d().c(i);
                }
            } else if (itemViewType == 1) {
                this.f962a.a(Integer.MAX_VALUE);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void onClick(View view) {
            if (view == this.f962a.f950c) {
                this.f962a.b();
                Intent b2 = this.f962a.f948a.d().b(this.f962a.f948a.d().a(this.f962a.f948a.b()));
                if (b2 != null) {
                    b2.addFlags(524288);
                    this.f962a.getContext().startActivity(b2);
                }
            } else if (view == this.f962a.f949b) {
                ActivityChooserView activityChooserView = this.f962a;
                activityChooserView.f954g = false;
                activityChooserView.a(activityChooserView.h);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public boolean onLongClick(View view) {
            if (view == this.f962a.f950c) {
                if (this.f962a.f948a.getCount() > 0) {
                    ActivityChooserView activityChooserView = this.f962a;
                    activityChooserView.f954g = true;
                    activityChooserView.a(activityChooserView.h);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        public void onDismiss() {
            a();
            if (this.f962a.f951d != null) {
                this.f962a.f951d.a(false);
            }
        }

        private void a() {
            if (this.f962a.f953f != null) {
                this.f962a.f953f.onDismiss();
            }
        }
    }

    private class a extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ActivityChooserView f956a;

        /* renamed from: b  reason: collision with root package name */
        private c f957b;

        /* renamed from: c  reason: collision with root package name */
        private int f958c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f959d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f960e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f961f;

        public long getItemId(int i) {
            return (long) i;
        }

        public int getViewTypeCount() {
            return 3;
        }

        public void a(c cVar) {
            c d2 = this.f956a.f948a.d();
            if (d2 != null && this.f956a.isShown()) {
                d2.unregisterObserver(this.f956a.f952e);
            }
            this.f957b = cVar;
            if (cVar != null && this.f956a.isShown()) {
                cVar.registerObserver(this.f956a.f952e);
            }
            notifyDataSetChanged();
        }

        public int getItemViewType(int i) {
            return (!this.f961f || i != getCount() - 1) ? 0 : 1;
        }

        public int getCount() {
            int a2 = this.f957b.a();
            if (!this.f959d && this.f957b.b() != null) {
                a2--;
            }
            int min = Math.min(a2, this.f958c);
            return this.f961f ? min + 1 : min;
        }

        public Object getItem(int i) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                if (!this.f959d && this.f957b.b() != null) {
                    i++;
                }
                return this.f957b.a(i);
            } else if (itemViewType == 1) {
                return null;
            } else {
                throw new IllegalArgumentException();
            }
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                if (view == null || view.getId() != a.f.list_item) {
                    view = LayoutInflater.from(this.f956a.getContext()).inflate(a.g.abc_activity_chooser_view_list_item, viewGroup, false);
                }
                PackageManager packageManager = this.f956a.getContext().getPackageManager();
                ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                ((ImageView) view.findViewById(a.f.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                ((TextView) view.findViewById(a.f.title)).setText(resolveInfo.loadLabel(packageManager));
                if (!this.f959d || i != 0 || !this.f960e) {
                    view.setActivated(false);
                } else {
                    view.setActivated(true);
                }
                return view;
            } else if (itemViewType != 1) {
                throw new IllegalArgumentException();
            } else if (view != null && view.getId() == 1) {
                return view;
            } else {
                View inflate = LayoutInflater.from(this.f956a.getContext()).inflate(a.g.abc_activity_chooser_view_list_item, viewGroup, false);
                inflate.setId(1);
                ((TextView) inflate.findViewById(a.f.title)).setText(this.f956a.getContext().getString(a.h.abc_activity_chooser_view_see_all));
                return inflate;
            }
        }

        public int a() {
            int i = this.f958c;
            this.f958c = Integer.MAX_VALUE;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i2 = 0;
            for (int i3 = 0; i3 < count; i3++) {
                view = getView(i3, view, (ViewGroup) null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i2 = Math.max(i2, view.getMeasuredWidth());
            }
            this.f958c = i;
            return i2;
        }

        public void a(int i) {
            if (this.f958c != i) {
                this.f958c = i;
                notifyDataSetChanged();
            }
        }

        public ResolveInfo b() {
            return this.f957b.b();
        }

        public void a(boolean z) {
            if (this.f961f != z) {
                this.f961f = z;
                notifyDataSetChanged();
            }
        }

        public int c() {
            return this.f957b.a();
        }

        public c d() {
            return this.f957b;
        }

        public void a(boolean z, boolean z2) {
            if (this.f959d != z || this.f960e != z2) {
                this.f959d = z;
                this.f960e = z2;
                notifyDataSetChanged();
            }
        }

        public boolean e() {
            return this.f959d;
        }
    }

    public static class InnerLayout extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        private static final int[] f955a = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            ar a2 = ar.a(context, attributeSet, f955a);
            setBackgroundDrawable(a2.a(0));
            a2.a();
        }
    }
}
