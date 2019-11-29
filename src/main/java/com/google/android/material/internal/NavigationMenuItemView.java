package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.ad;
import androidx.appcompat.widget.at;
import androidx.core.content.a.f;
import androidx.core.g.a;
import androidx.core.g.a.d;
import androidx.core.g.w;
import com.google.android.material.a;

public class NavigationMenuItemView extends f implements n.a {

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f13361d = {16842912};

    /* renamed from: c  reason: collision with root package name */
    boolean f13362c;

    /* renamed from: e  reason: collision with root package name */
    private final int f13363e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f13364f;

    /* renamed from: g  reason: collision with root package name */
    private final CheckedTextView f13365g;
    private FrameLayout h;
    private i i;
    private ColorStateList j;
    private boolean k;
    private Drawable l;
    private final a m;

    public boolean a() {
        return false;
    }

    public NavigationMenuItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.m = new a() {
            public void onInitializeAccessibilityNodeInfo(View view, d dVar) {
                super.onInitializeAccessibilityNodeInfo(view, dVar);
                dVar.a(NavigationMenuItemView.this.f13362c);
            }
        };
        setOrientation(0);
        LayoutInflater.from(context).inflate(a.h.design_navigation_menu_item, this, true);
        this.f13363e = context.getResources().getDimensionPixelSize(a.d.design_navigation_icon_size);
        this.f13365g = (CheckedTextView) findViewById(a.f.design_menu_item_text);
        this.f13365g.setDuplicateParentStateEnabled(true);
        w.a((View) this.f13365g, this.m);
    }

    public void a(i iVar, int i2) {
        this.i = iVar;
        setVisibility(iVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            w.a((View) this, (Drawable) e());
        }
        setCheckable(iVar.isCheckable());
        setChecked(iVar.isChecked());
        setEnabled(iVar.isEnabled());
        setTitle(iVar.getTitle());
        setIcon(iVar.getIcon());
        setActionView(iVar.getActionView());
        setContentDescription(iVar.getContentDescription());
        at.a(this, iVar.getTooltipText());
        d();
    }

    private boolean c() {
        return this.i.getTitle() == null && this.i.getIcon() == null && this.i.getActionView() != null;
    }

    private void d() {
        if (c()) {
            this.f13365g.setVisibility(8);
            FrameLayout frameLayout = this.h;
            if (frameLayout != null) {
                ad.a aVar = (ad.a) frameLayout.getLayoutParams();
                aVar.width = -1;
                this.h.setLayoutParams(aVar);
                return;
            }
            return;
        }
        this.f13365g.setVisibility(0);
        FrameLayout frameLayout2 = this.h;
        if (frameLayout2 != null) {
            ad.a aVar2 = (ad.a) frameLayout2.getLayoutParams();
            aVar2.width = -2;
            this.h.setLayoutParams(aVar2);
        }
    }

    public void b() {
        FrameLayout frameLayout = this.h;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.f13365g.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.h == null) {
                this.h = (FrameLayout) ((ViewStub) findViewById(a.f.design_menu_item_action_area_stub)).inflate();
            }
            this.h.removeAllViews();
            this.h.addView(view);
        }
    }

    private StateListDrawable e() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(a.C0012a.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f13361d, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    public i getItemData() {
        return this.i;
    }

    public void setTitle(CharSequence charSequence) {
        this.f13365g.setText(charSequence);
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.f13362c != z) {
            this.f13362c = z;
            this.m.sendAccessibilityEvent(this.f13365g, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.f13365g.setChecked(z);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.k) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = androidx.core.graphics.drawable.a.g(drawable).mutate();
                androidx.core.graphics.drawable.a.a(drawable, this.j);
            }
            int i2 = this.f13363e;
            drawable.setBounds(0, 0, i2, i2);
        } else if (this.f13364f) {
            if (this.l == null) {
                this.l = f.a(getResources(), a.e.navigation_empty_icon, getContext().getTheme());
                Drawable drawable2 = this.l;
                if (drawable2 != null) {
                    int i3 = this.f13363e;
                    drawable2.setBounds(0, 0, i3, i3);
                }
            }
            drawable = this.l;
        }
        androidx.core.widget.i.a(this.f13365g, drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        i iVar = this.i;
        if (iVar != null && iVar.isCheckable() && this.i.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f13361d);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: package-private */
    public void setIconTintList(ColorStateList colorStateList) {
        this.j = colorStateList;
        this.k = this.j != null;
        i iVar = this.i;
        if (iVar != null) {
            setIcon(iVar.getIcon());
        }
    }

    public void setTextAppearance(int i2) {
        androidx.core.widget.i.a((TextView) this.f13365g, i2);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f13365g.setTextColor(colorStateList);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.f13364f = z;
    }

    public void setHorizontalPadding(int i2) {
        setPadding(i2, 0, i2, 0);
    }

    public void setIconPadding(int i2) {
        this.f13365g.setCompoundDrawablePadding(i2);
    }
}
