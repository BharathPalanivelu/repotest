package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

public class e implements AdapterView.OnItemClickListener, m {

    /* renamed from: a  reason: collision with root package name */
    Context f835a;

    /* renamed from: b  reason: collision with root package name */
    LayoutInflater f836b;

    /* renamed from: c  reason: collision with root package name */
    g f837c;

    /* renamed from: d  reason: collision with root package name */
    ExpandedMenuView f838d;

    /* renamed from: e  reason: collision with root package name */
    int f839e;

    /* renamed from: f  reason: collision with root package name */
    int f840f;

    /* renamed from: g  reason: collision with root package name */
    int f841g;
    a h;
    private m.a i;
    private int j;

    public boolean a(g gVar, i iVar) {
        return false;
    }

    public boolean b() {
        return false;
    }

    public boolean b(g gVar, i iVar) {
        return false;
    }

    public e(Context context, int i2) {
        this(i2, 0);
        this.f835a = context;
        this.f836b = LayoutInflater.from(this.f835a);
    }

    public e(int i2, int i3) {
        this.f841g = i2;
        this.f840f = i3;
    }

    public void a(Context context, g gVar) {
        int i2 = this.f840f;
        if (i2 != 0) {
            this.f835a = new ContextThemeWrapper(context, i2);
            this.f836b = LayoutInflater.from(this.f835a);
        } else if (this.f835a != null) {
            this.f835a = context;
            if (this.f836b == null) {
                this.f836b = LayoutInflater.from(this.f835a);
            }
        }
        this.f837c = gVar;
        a aVar = this.h;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public n a(ViewGroup viewGroup) {
        if (this.f838d == null) {
            this.f838d = (ExpandedMenuView) this.f836b.inflate(a.g.abc_expanded_menu_layout, viewGroup, false);
            if (this.h == null) {
                this.h = new a();
            }
            this.f838d.setAdapter(this.h);
            this.f838d.setOnItemClickListener(this);
        }
        return this.f838d;
    }

    public ListAdapter a() {
        if (this.h == null) {
            this.h = new a();
        }
        return this.h;
    }

    public void a(boolean z) {
        a aVar = this.h;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public void a(m.a aVar) {
        this.i = aVar;
    }

    public boolean a(r rVar) {
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        new h(rVar).a((IBinder) null);
        m.a aVar = this.i;
        if (aVar == null) {
            return true;
        }
        aVar.a(rVar);
        return true;
    }

    public void a(g gVar, boolean z) {
        m.a aVar = this.i;
        if (aVar != null) {
            aVar.a(gVar, z);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.f837c.a((MenuItem) this.h.getItem(i2), (m) this, 0);
    }

    public void a(Bundle bundle) {
        SparseArray sparseArray = new SparseArray();
        ExpandedMenuView expandedMenuView = this.f838d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    public void b(Bundle bundle) {
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f838d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public int c() {
        return this.j;
    }

    public Parcelable f() {
        if (this.f838d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        a(bundle);
        return bundle;
    }

    public void a(Parcelable parcelable) {
        b((Bundle) parcelable);
    }

    private class a extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        private int f843b = -1;

        public long getItemId(int i) {
            return (long) i;
        }

        public a() {
            a();
        }

        public int getCount() {
            int size = e.this.f837c.m().size() - e.this.f839e;
            return this.f843b < 0 ? size : size - 1;
        }

        /* renamed from: a */
        public i getItem(int i) {
            ArrayList<i> m = e.this.f837c.m();
            int i2 = i + e.this.f839e;
            int i3 = this.f843b;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return m.get(i2);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = e.this.f836b.inflate(e.this.f841g, viewGroup, false);
            }
            ((n.a) view).a(getItem(i), 0);
            return view;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            i s = e.this.f837c.s();
            if (s != null) {
                ArrayList<i> m = e.this.f837c.m();
                int size = m.size();
                for (int i = 0; i < size; i++) {
                    if (m.get(i) == s) {
                        this.f843b = i;
                        return;
                    }
                }
            }
            this.f843b = -1;
        }

        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }
}
