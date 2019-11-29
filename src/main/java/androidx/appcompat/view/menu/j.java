package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.g.b;
import java.lang.reflect.Method;

public class j extends c implements MenuItem {

    /* renamed from: b  reason: collision with root package name */
    private final androidx.core.a.a.b f869b;

    /* renamed from: c  reason: collision with root package name */
    private Method f870c;

    public j(Context context, androidx.core.a.a.b bVar) {
        super(context);
        if (bVar != null) {
            this.f869b = bVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public int getItemId() {
        return this.f869b.getItemId();
    }

    public int getGroupId() {
        return this.f869b.getGroupId();
    }

    public int getOrder() {
        return this.f869b.getOrder();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f869b.setTitle(charSequence);
        return this;
    }

    public MenuItem setTitle(int i) {
        this.f869b.setTitle(i);
        return this;
    }

    public CharSequence getTitle() {
        return this.f869b.getTitle();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f869b.setTitleCondensed(charSequence);
        return this;
    }

    public CharSequence getTitleCondensed() {
        return this.f869b.getTitleCondensed();
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f869b.setIcon(drawable);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f869b.setIcon(i);
        return this;
    }

    public Drawable getIcon() {
        return this.f869b.getIcon();
    }

    public MenuItem setIntent(Intent intent) {
        this.f869b.setIntent(intent);
        return this;
    }

    public Intent getIntent() {
        return this.f869b.getIntent();
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.f869b.setShortcut(c2, c3);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3, int i, int i2) {
        this.f869b.setShortcut(c2, c3, i, i2);
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        this.f869b.setNumericShortcut(c2);
        return this;
    }

    public MenuItem setNumericShortcut(char c2, int i) {
        this.f869b.setNumericShortcut(c2, i);
        return this;
    }

    public char getNumericShortcut() {
        return this.f869b.getNumericShortcut();
    }

    public int getNumericModifiers() {
        return this.f869b.getNumericModifiers();
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        this.f869b.setAlphabeticShortcut(c2);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2, int i) {
        this.f869b.setAlphabeticShortcut(c2, i);
        return this;
    }

    public char getAlphabeticShortcut() {
        return this.f869b.getAlphabeticShortcut();
    }

    public int getAlphabeticModifiers() {
        return this.f869b.getAlphabeticModifiers();
    }

    public MenuItem setCheckable(boolean z) {
        this.f869b.setCheckable(z);
        return this;
    }

    public boolean isCheckable() {
        return this.f869b.isCheckable();
    }

    public MenuItem setChecked(boolean z) {
        this.f869b.setChecked(z);
        return this;
    }

    public boolean isChecked() {
        return this.f869b.isChecked();
    }

    public MenuItem setVisible(boolean z) {
        return this.f869b.setVisible(z);
    }

    public boolean isVisible() {
        return this.f869b.isVisible();
    }

    public MenuItem setEnabled(boolean z) {
        this.f869b.setEnabled(z);
        return this;
    }

    public boolean isEnabled() {
        return this.f869b.isEnabled();
    }

    public boolean hasSubMenu() {
        return this.f869b.hasSubMenu();
    }

    public SubMenu getSubMenu() {
        return a(this.f869b.getSubMenu());
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f869b.setOnMenuItemClickListener(onMenuItemClickListener != null ? new e(onMenuItemClickListener) : null);
        return this;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f869b.getMenuInfo();
    }

    public void setShowAsAction(int i) {
        this.f869b.setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        this.f869b.setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new c(view);
        }
        this.f869b.setActionView(view);
        return this;
    }

    public MenuItem setActionView(int i) {
        this.f869b.setActionView(i);
        View actionView = this.f869b.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f869b.setActionView((View) new c(actionView));
        }
        return this;
    }

    public View getActionView() {
        View actionView = this.f869b.getActionView();
        return actionView instanceof c ? ((c) actionView).c() : actionView;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        androidx.core.g.b bVar;
        if (Build.VERSION.SDK_INT >= 16) {
            bVar = new b(this.f815a, actionProvider);
        } else {
            bVar = new a(this.f815a, actionProvider);
        }
        androidx.core.a.a.b bVar2 = this.f869b;
        if (actionProvider == null) {
            bVar = null;
        }
        bVar2.a(bVar);
        return this;
    }

    public ActionProvider getActionProvider() {
        androidx.core.g.b a2 = this.f869b.a();
        if (a2 instanceof a) {
            return ((a) a2).f871a;
        }
        return null;
    }

    public boolean expandActionView() {
        return this.f869b.expandActionView();
    }

    public boolean collapseActionView() {
        return this.f869b.collapseActionView();
    }

    public boolean isActionViewExpanded() {
        return this.f869b.isActionViewExpanded();
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f869b.setOnActionExpandListener(onActionExpandListener != null ? new d(onActionExpandListener) : null);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f869b.a(charSequence);
        return this;
    }

    public CharSequence getContentDescription() {
        return this.f869b.getContentDescription();
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f869b.b(charSequence);
        return this;
    }

    public CharSequence getTooltipText() {
        return this.f869b.getTooltipText();
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f869b.setIconTintList(colorStateList);
        return this;
    }

    public ColorStateList getIconTintList() {
        return this.f869b.getIconTintList();
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f869b.setIconTintMode(mode);
        return this;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f869b.getIconTintMode();
    }

    public void a(boolean z) {
        try {
            if (this.f870c == null) {
                this.f870c = this.f869b.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f870c.invoke(this.f869b, new Object[]{Boolean.valueOf(z)});
        } catch (Exception e2) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e2);
        }
    }

    private class e implements MenuItem.OnMenuItemClickListener {

        /* renamed from: b  reason: collision with root package name */
        private final MenuItem.OnMenuItemClickListener f879b;

        e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f879b = onMenuItemClickListener;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f879b.onMenuItemClick(j.this.a(menuItem));
        }
    }

    private class d implements MenuItem.OnActionExpandListener {

        /* renamed from: b  reason: collision with root package name */
        private final MenuItem.OnActionExpandListener f877b;

        d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f877b = onActionExpandListener;
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f877b.onMenuItemActionExpand(j.this.a(menuItem));
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f877b.onMenuItemActionCollapse(j.this.a(menuItem));
        }
    }

    private class a extends androidx.core.g.b {

        /* renamed from: a  reason: collision with root package name */
        final ActionProvider f871a;

        a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f871a = actionProvider;
        }

        public View a() {
            return this.f871a.onCreateActionView();
        }

        public boolean b() {
            return this.f871a.onPerformDefaultAction();
        }

        public boolean c() {
            return this.f871a.hasSubMenu();
        }

        public void a(SubMenu subMenu) {
            this.f871a.onPrepareSubMenu(j.this.a(subMenu));
        }
    }

    private class b extends a implements ActionProvider.VisibilityListener {

        /* renamed from: d  reason: collision with root package name */
        private b.C0036b f874d;

        b(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        public View a(MenuItem menuItem) {
            return this.f871a.onCreateActionView(menuItem);
        }

        public boolean d() {
            return this.f871a.overridesItemVisibility();
        }

        public boolean e() {
            return this.f871a.isVisible();
        }

        public void a(b.C0036b bVar) {
            this.f874d = bVar;
            this.f871a.setVisibilityListener(bVar != null ? this : null);
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            b.C0036b bVar = this.f874d;
            if (bVar != null) {
                bVar.a(z);
            }
        }
    }

    static class c extends FrameLayout implements androidx.appcompat.view.c {

        /* renamed from: a  reason: collision with root package name */
        final CollapsibleActionView f875a;

        c(View view) {
            super(view.getContext());
            this.f875a = (CollapsibleActionView) view;
            addView(view);
        }

        public void a() {
            this.f875a.onActionViewExpanded();
        }

        public void b() {
            this.f875a.onActionViewCollapsed();
        }

        /* access modifiers changed from: package-private */
        public View c() {
            return (View) this.f875a;
        }
    }
}
