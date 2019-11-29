package com.google.android.material.bottomnavigation;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.n;
import androidx.core.g.w;
import androidx.core.util.Pools;
import androidx.l.p;
import androidx.l.r;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;

public class b extends ViewGroup implements n {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f13237a = {16842912};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f13238b = {-16842910};

    /* renamed from: c  reason: collision with root package name */
    private final r f13239c;

    /* renamed from: d  reason: collision with root package name */
    private final int f13240d;

    /* renamed from: e  reason: collision with root package name */
    private final int f13241e;

    /* renamed from: f  reason: collision with root package name */
    private final int f13242f;

    /* renamed from: g  reason: collision with root package name */
    private final int f13243g;
    private final int h;
    private final View.OnClickListener i;
    private final Pools.a<a> j;
    private boolean k;
    private int l;
    private a[] m;
    private int n;
    private int o;
    private ColorStateList p;
    private int q;
    private ColorStateList r;
    private final ColorStateList s;
    private int t;
    private int u;
    private Drawable v;
    private int w;
    private int[] x;
    private BottomNavigationPresenter y;
    private g z;

    private boolean a(int i2, int i3) {
        if (i2 == -1) {
            if (i3 > 3) {
                return true;
            }
        } else if (i2 == 0) {
            return true;
        }
        return false;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void a(g gVar) {
        this.z = gVar;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = this.z.j().size();
        int childCount = getChildCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.h, 1073741824);
        if (!a(this.l, size2) || !this.k) {
            int min = Math.min(size / (size2 == 0 ? 1 : size2), this.f13242f);
            int i4 = size - (size2 * min);
            for (int i5 = 0; i5 < childCount; i5++) {
                if (getChildAt(i5).getVisibility() != 8) {
                    int[] iArr = this.x;
                    iArr[i5] = min;
                    if (i4 > 0) {
                        iArr[i5] = iArr[i5] + 1;
                        i4--;
                    }
                } else {
                    this.x[i5] = 0;
                }
            }
        } else {
            View childAt = getChildAt(this.o);
            int i6 = this.f13243g;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.f13242f, RNCartPanelDataEntity.NULL_VALUE), makeMeasureSpec);
                i6 = Math.max(i6, childAt.getMeasuredWidth());
            }
            int i7 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int min2 = Math.min(size - (this.f13241e * i7), Math.min(i6, this.f13242f));
            int i8 = size - min2;
            int min3 = Math.min(i8 / (i7 == 0 ? 1 : i7), this.f13240d);
            int i9 = i8 - (i7 * min3);
            int i10 = 0;
            while (i10 < childCount) {
                if (getChildAt(i10).getVisibility() != 8) {
                    this.x[i10] = i10 == this.o ? min2 : min3;
                    if (i9 > 0) {
                        int[] iArr2 = this.x;
                        iArr2[i10] = iArr2[i10] + 1;
                        i9--;
                    }
                } else {
                    this.x[i10] = 0;
                }
                i10++;
            }
        }
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.x[i12], 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i11 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i11, View.MeasureSpec.makeMeasureSpec(i11, 1073741824), 0), View.resolveSizeAndState(this.h, makeMeasureSpec, 0));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                if (w.g(this) == 1) {
                    int i10 = i6 - i8;
                    childAt.layout(i10 - childAt.getMeasuredWidth(), 0, i10, i7);
                } else {
                    childAt.layout(i8, 0, childAt.getMeasuredWidth() + i8, i7);
                }
                i8 += childAt.getMeasuredWidth();
            }
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.p = colorStateList;
        a[] aVarArr = this.m;
        if (aVarArr != null) {
            for (a iconTintList : aVarArr) {
                iconTintList.setIconTintList(colorStateList);
            }
        }
    }

    public ColorStateList getIconTintList() {
        return this.p;
    }

    public void setItemIconSize(int i2) {
        this.q = i2;
        a[] aVarArr = this.m;
        if (aVarArr != null) {
            for (a iconSize : aVarArr) {
                iconSize.setIconSize(i2);
            }
        }
    }

    public int getItemIconSize() {
        return this.q;
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.r = colorStateList;
        a[] aVarArr = this.m;
        if (aVarArr != null) {
            for (a textColor : aVarArr) {
                textColor.setTextColor(colorStateList);
            }
        }
    }

    public ColorStateList getItemTextColor() {
        return this.r;
    }

    public void setItemTextAppearanceInactive(int i2) {
        this.t = i2;
        a[] aVarArr = this.m;
        if (aVarArr != null) {
            for (a aVar : aVarArr) {
                aVar.setTextAppearanceInactive(i2);
                ColorStateList colorStateList = this.r;
                if (colorStateList != null) {
                    aVar.setTextColor(colorStateList);
                }
            }
        }
    }

    public int getItemTextAppearanceInactive() {
        return this.t;
    }

    public void setItemTextAppearanceActive(int i2) {
        this.u = i2;
        a[] aVarArr = this.m;
        if (aVarArr != null) {
            for (a aVar : aVarArr) {
                aVar.setTextAppearanceActive(i2);
                ColorStateList colorStateList = this.r;
                if (colorStateList != null) {
                    aVar.setTextColor(colorStateList);
                }
            }
        }
    }

    public int getItemTextAppearanceActive() {
        return this.u;
    }

    public void setItemBackgroundRes(int i2) {
        this.w = i2;
        a[] aVarArr = this.m;
        if (aVarArr != null) {
            for (a itemBackground : aVarArr) {
                itemBackground.setItemBackground(i2);
            }
        }
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.w;
    }

    public void setItemBackground(Drawable drawable) {
        this.v = drawable;
        a[] aVarArr = this.m;
        if (aVarArr != null) {
            for (a itemBackground : aVarArr) {
                itemBackground.setItemBackground(drawable);
            }
        }
    }

    public Drawable getItemBackground() {
        a[] aVarArr = this.m;
        if (aVarArr == null || aVarArr.length <= 0) {
            return this.v;
        }
        return aVarArr[0].getBackground();
    }

    public void setLabelVisibilityMode(int i2) {
        this.l = i2;
    }

    public int getLabelVisibilityMode() {
        return this.l;
    }

    public void setItemHorizontalTranslationEnabled(boolean z2) {
        this.k = z2;
    }

    public boolean a() {
        return this.k;
    }

    public void setPresenter(BottomNavigationPresenter bottomNavigationPresenter) {
        this.y = bottomNavigationPresenter;
    }

    public void b() {
        removeAllViews();
        a[] aVarArr = this.m;
        if (aVarArr != null) {
            for (a aVar : aVarArr) {
                if (aVar != null) {
                    this.j.release(aVar);
                }
            }
        }
        if (this.z.size() == 0) {
            this.n = 0;
            this.o = 0;
            this.m = null;
            return;
        }
        this.m = new a[this.z.size()];
        boolean a2 = a(this.l, this.z.j().size());
        for (int i2 = 0; i2 < this.z.size(); i2++) {
            this.y.b(true);
            this.z.getItem(i2).setCheckable(true);
            this.y.b(false);
            a newItem = getNewItem();
            this.m[i2] = newItem;
            newItem.setIconTintList(this.p);
            newItem.setIconSize(this.q);
            newItem.setTextColor(this.s);
            newItem.setTextAppearanceInactive(this.t);
            newItem.setTextAppearanceActive(this.u);
            newItem.setTextColor(this.r);
            Drawable drawable = this.v;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.w);
            }
            newItem.setShifting(a2);
            newItem.setLabelVisibilityMode(this.l);
            newItem.a((i) this.z.getItem(i2), 0);
            newItem.setItemPosition(i2);
            newItem.setOnClickListener(this.i);
            addView(newItem);
        }
        this.o = Math.min(this.z.size() - 1, this.o);
        this.z.getItem(this.o).setChecked(true);
    }

    public void c() {
        g gVar = this.z;
        if (gVar != null && this.m != null) {
            int size = gVar.size();
            if (size != this.m.length) {
                b();
                return;
            }
            int i2 = this.n;
            for (int i3 = 0; i3 < size; i3++) {
                MenuItem item = this.z.getItem(i3);
                if (item.isChecked()) {
                    this.n = item.getItemId();
                    this.o = i3;
                }
            }
            if (i2 != this.n) {
                p.a(this, this.f13239c);
            }
            boolean a2 = a(this.l, this.z.j().size());
            for (int i4 = 0; i4 < size; i4++) {
                this.y.b(true);
                this.m[i4].setLabelVisibilityMode(this.l);
                this.m[i4].setShifting(a2);
                this.m[i4].a((i) this.z.getItem(i4), 0);
                this.y.b(false);
            }
        }
    }

    private a getNewItem() {
        a acquire = this.j.acquire();
        return acquire == null ? new a(getContext()) : acquire;
    }

    public int getSelectedItemId() {
        return this.n;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        int size = this.z.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = this.z.getItem(i3);
            if (i2 == item.getItemId()) {
                this.n = i2;
                this.o = i3;
                item.setChecked(true);
                return;
            }
        }
    }
}
