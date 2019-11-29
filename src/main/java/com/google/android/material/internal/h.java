package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.r;
import androidx.core.g.w;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.a;
import java.util.ArrayList;

public class h implements m {

    /* renamed from: a  reason: collision with root package name */
    LinearLayout f13392a;

    /* renamed from: b  reason: collision with root package name */
    androidx.appcompat.view.menu.g f13393b;

    /* renamed from: c  reason: collision with root package name */
    b f13394c;

    /* renamed from: d  reason: collision with root package name */
    LayoutInflater f13395d;

    /* renamed from: e  reason: collision with root package name */
    int f13396e;

    /* renamed from: f  reason: collision with root package name */
    boolean f13397f;

    /* renamed from: g  reason: collision with root package name */
    ColorStateList f13398g;
    ColorStateList h;
    Drawable i;
    int j;
    int k;
    int l;
    final View.OnClickListener m;
    private NavigationMenuView n;
    private m.a o;
    private int p;

    private interface d {
    }

    public boolean a(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.i iVar) {
        return false;
    }

    public boolean a(r rVar) {
        return false;
    }

    public boolean b() {
        return false;
    }

    public boolean b(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.i iVar) {
        return false;
    }

    public void a(Context context, androidx.appcompat.view.menu.g gVar) {
        this.f13395d = LayoutInflater.from(context);
        this.f13393b = gVar;
        this.l = context.getResources().getDimensionPixelOffset(a.d.design_navigation_separator_vertical_padding);
    }

    public void a(boolean z) {
        b bVar = this.f13394c;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void a(m.a aVar) {
        this.o = aVar;
    }

    public void a(androidx.appcompat.view.menu.g gVar, boolean z) {
        m.a aVar = this.o;
        if (aVar != null) {
            aVar.a(gVar, z);
        }
    }

    public int c() {
        return this.p;
    }

    public Parcelable f() {
        Bundle bundle = new Bundle();
        if (this.n != null) {
            SparseArray sparseArray = new SparseArray();
            this.n.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        b bVar = this.f13394c;
        if (bVar != null) {
            bundle.putBundle("android:menu:adapter", bVar.c());
        }
        if (this.f13392a != null) {
            SparseArray sparseArray2 = new SparseArray();
            this.f13392a.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray2);
        }
        return bundle;
    }

    public void a(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.n.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.f13394c.a(bundle2);
            }
            SparseArray sparseParcelableArray2 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray2 != null) {
                this.f13392a.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    public void a(androidx.appcompat.view.menu.i iVar) {
        this.f13394c.a(iVar);
    }

    public androidx.appcompat.view.menu.i a() {
        return this.f13394c.b();
    }

    public int d() {
        return this.f13392a.getChildCount();
    }

    public ColorStateList e() {
        return this.h;
    }

    public void a(ColorStateList colorStateList) {
        this.h = colorStateList;
        a(false);
    }

    public ColorStateList g() {
        return this.f13398g;
    }

    public void b(ColorStateList colorStateList) {
        this.f13398g = colorStateList;
        a(false);
    }

    public void a(int i2) {
        this.f13396e = i2;
        this.f13397f = true;
        a(false);
    }

    public Drawable h() {
        return this.i;
    }

    public void a(Drawable drawable) {
        this.i = drawable;
        a(false);
    }

    public int i() {
        return this.j;
    }

    public void b(int i2) {
        this.j = i2;
        a(false);
    }

    public int j() {
        return this.k;
    }

    public void c(int i2) {
        this.k = i2;
        a(false);
    }

    private static abstract class j extends RecyclerView.w {
        public j(View view) {
            super(view);
        }
    }

    private static class g extends j {
        public g(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(a.h.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    private static class i extends j {
        public i(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(a.h.design_navigation_item_subheader, viewGroup, false));
        }
    }

    /* renamed from: com.google.android.material.internal.h$h  reason: collision with other inner class name */
    private static class C0219h extends j {
        public C0219h(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(a.h.design_navigation_item_separator, viewGroup, false));
        }
    }

    private static class a extends j {
        public a(View view) {
            super(view);
        }
    }

    private class b extends RecyclerView.a<j> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f13399a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<d> f13400b;

        /* renamed from: c  reason: collision with root package name */
        private androidx.appcompat.view.menu.i f13401c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f13402d;

        public long getItemId(int i) {
            return (long) i;
        }

        public int getItemCount() {
            return this.f13400b.size();
        }

        public int getItemViewType(int i) {
            d dVar = this.f13400b.get(i);
            if (dVar instanceof e) {
                return 2;
            }
            if (dVar instanceof c) {
                return 3;
            }
            if (dVar instanceof f) {
                return ((f) dVar).a().hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        /* renamed from: a */
        public j onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 0) {
                return new g(this.f13399a.f13395d, viewGroup, this.f13399a.m);
            }
            if (i == 1) {
                return new i(this.f13399a.f13395d, viewGroup);
            }
            if (i == 2) {
                return new C0219h(this.f13399a.f13395d, viewGroup);
            }
            if (i != 3) {
                return null;
            }
            return new a(this.f13399a.f13392a);
        }

        /* renamed from: a */
        public void onBindViewHolder(j jVar, int i) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) jVar.itemView;
                navigationMenuItemView.setIconTintList(this.f13399a.h);
                if (this.f13399a.f13397f) {
                    navigationMenuItemView.setTextAppearance(this.f13399a.f13396e);
                }
                if (this.f13399a.f13398g != null) {
                    navigationMenuItemView.setTextColor(this.f13399a.f13398g);
                }
                w.a((View) navigationMenuItemView, this.f13399a.i != null ? this.f13399a.i.getConstantState().newDrawable() : null);
                f fVar = (f) this.f13400b.get(i);
                navigationMenuItemView.setNeedsEmptyIcon(fVar.f13405a);
                navigationMenuItemView.setHorizontalPadding(this.f13399a.j);
                navigationMenuItemView.setIconPadding(this.f13399a.k);
                navigationMenuItemView.a(fVar.a(), 0);
            } else if (itemViewType == 1) {
                ((TextView) jVar.itemView).setText(((f) this.f13400b.get(i)).a().getTitle());
            } else if (itemViewType == 2) {
                e eVar = (e) this.f13400b.get(i);
                jVar.itemView.setPadding(0, eVar.a(), 0, eVar.b());
            }
        }

        /* renamed from: a */
        public void onViewRecycled(j jVar) {
            if (jVar instanceof g) {
                ((NavigationMenuItemView) jVar.itemView).b();
            }
        }

        public void a() {
            d();
            notifyDataSetChanged();
        }

        private void d() {
            if (!this.f13402d) {
                this.f13402d = true;
                this.f13400b.clear();
                this.f13400b.add(new c());
                int size = this.f13399a.f13393b.j().size();
                int i = -1;
                boolean z = false;
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    androidx.appcompat.view.menu.i iVar = this.f13399a.f13393b.j().get(i3);
                    if (iVar.isChecked()) {
                        a(iVar);
                    }
                    if (iVar.isCheckable()) {
                        iVar.a(false);
                    }
                    if (iVar.hasSubMenu()) {
                        SubMenu subMenu = iVar.getSubMenu();
                        if (subMenu.hasVisibleItems()) {
                            if (i3 != 0) {
                                this.f13400b.add(new e(this.f13399a.l, 0));
                            }
                            this.f13400b.add(new f(iVar));
                            int size2 = this.f13400b.size();
                            int size3 = subMenu.size();
                            boolean z2 = false;
                            for (int i4 = 0; i4 < size3; i4++) {
                                androidx.appcompat.view.menu.i iVar2 = (androidx.appcompat.view.menu.i) subMenu.getItem(i4);
                                if (iVar2.isVisible()) {
                                    if (!z2 && iVar2.getIcon() != null) {
                                        z2 = true;
                                    }
                                    if (iVar2.isCheckable()) {
                                        iVar2.a(false);
                                    }
                                    if (iVar.isChecked()) {
                                        a(iVar);
                                    }
                                    this.f13400b.add(new f(iVar2));
                                }
                            }
                            if (z2) {
                                a(size2, this.f13400b.size());
                            }
                        }
                    } else {
                        int groupId = iVar.getGroupId();
                        if (groupId != i) {
                            i2 = this.f13400b.size();
                            boolean z3 = iVar.getIcon() != null;
                            if (i3 != 0) {
                                i2++;
                                this.f13400b.add(new e(this.f13399a.l, this.f13399a.l));
                            }
                            z = z3;
                        } else if (!z && iVar.getIcon() != null) {
                            a(i2, this.f13400b.size());
                            z = true;
                        }
                        f fVar = new f(iVar);
                        fVar.f13405a = z;
                        this.f13400b.add(fVar);
                        i = groupId;
                    }
                }
                this.f13402d = false;
            }
        }

        private void a(int i, int i2) {
            while (i < i2) {
                ((f) this.f13400b.get(i)).f13405a = true;
                i++;
            }
        }

        public void a(androidx.appcompat.view.menu.i iVar) {
            if (this.f13401c != iVar && iVar.isCheckable()) {
                androidx.appcompat.view.menu.i iVar2 = this.f13401c;
                if (iVar2 != null) {
                    iVar2.setChecked(false);
                }
                this.f13401c = iVar;
                iVar.setChecked(true);
            }
        }

        public androidx.appcompat.view.menu.i b() {
            return this.f13401c;
        }

        public Bundle c() {
            Bundle bundle = new Bundle();
            androidx.appcompat.view.menu.i iVar = this.f13401c;
            if (iVar != null) {
                bundle.putInt("android:menu:checked", iVar.getItemId());
            }
            SparseArray sparseArray = new SparseArray();
            int size = this.f13400b.size();
            for (int i = 0; i < size; i++) {
                d dVar = this.f13400b.get(i);
                if (dVar instanceof f) {
                    androidx.appcompat.view.menu.i a2 = ((f) dVar).a();
                    View actionView = a2 != null ? a2.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(a2.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        public void a(Bundle bundle) {
            int i = bundle.getInt("android:menu:checked", 0);
            if (i != 0) {
                this.f13402d = true;
                int size = this.f13400b.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    d dVar = this.f13400b.get(i2);
                    if (dVar instanceof f) {
                        androidx.appcompat.view.menu.i a2 = ((f) dVar).a();
                        if (a2 != null && a2.getItemId() == i) {
                            a(a2);
                            break;
                        }
                    }
                    i2++;
                }
                this.f13402d = false;
                d();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            if (sparseParcelableArray != null) {
                int size2 = this.f13400b.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    d dVar2 = this.f13400b.get(i3);
                    if (dVar2 instanceof f) {
                        androidx.appcompat.view.menu.i a3 = ((f) dVar2).a();
                        if (a3 != null) {
                            View actionView = a3.getActionView();
                            if (actionView != null) {
                                ParcelableSparseArray parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(a3.getItemId());
                                if (parcelableSparseArray != null) {
                                    actionView.restoreHierarchyState(parcelableSparseArray);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static class f implements d {

        /* renamed from: a  reason: collision with root package name */
        boolean f13405a;

        /* renamed from: b  reason: collision with root package name */
        private final androidx.appcompat.view.menu.i f13406b;

        f(androidx.appcompat.view.menu.i iVar) {
            this.f13406b = iVar;
        }

        public androidx.appcompat.view.menu.i a() {
            return this.f13406b;
        }
    }

    private static class e implements d {

        /* renamed from: a  reason: collision with root package name */
        private final int f13403a;

        /* renamed from: b  reason: collision with root package name */
        private final int f13404b;

        public e(int i, int i2) {
            this.f13403a = i;
            this.f13404b = i2;
        }

        public int a() {
            return this.f13403a;
        }

        public int b() {
            return this.f13404b;
        }
    }

    private static class c implements d {
        c() {
        }
    }
}
