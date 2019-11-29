package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.widget.LinearLayout;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.n;
import androidx.core.a.a.b;
import androidx.core.g.b;
import com.facebook.internal.NativeProtocol;

public final class i implements b {
    private View A;
    private androidx.core.g.b B;
    private MenuItem.OnActionExpandListener C;
    private boolean D = false;
    private ContextMenu.ContextMenuInfo E;

    /* renamed from: a  reason: collision with root package name */
    g f861a;

    /* renamed from: b  reason: collision with root package name */
    private final int f862b;

    /* renamed from: c  reason: collision with root package name */
    private final int f863c;

    /* renamed from: d  reason: collision with root package name */
    private final int f864d;

    /* renamed from: e  reason: collision with root package name */
    private final int f865e;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f866f;

    /* renamed from: g  reason: collision with root package name */
    private CharSequence f867g;
    private Intent h;
    private char i;
    private int j = 4096;
    private char k;
    private int l = 4096;
    private Drawable m;
    private int n = 0;
    private r o;
    private Runnable p;
    private MenuItem.OnMenuItemClickListener q;
    private CharSequence r;
    private CharSequence s;
    private ColorStateList t = null;
    private PorterDuff.Mode u = null;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private int y = 16;
    private int z = 0;

    i(g gVar, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        this.f861a = gVar;
        this.f862b = i3;
        this.f863c = i2;
        this.f864d = i4;
        this.f865e = i5;
        this.f866f = charSequence;
        this.z = i6;
    }

    public boolean b() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        g gVar = this.f861a;
        if (gVar.a(gVar, (MenuItem) this)) {
            return true;
        }
        Runnable runnable = this.p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.h != null) {
            try {
                this.f861a.f().startActivity(this.h);
                return true;
            } catch (ActivityNotFoundException e2) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e2);
            }
        }
        androidx.core.g.b bVar = this.B;
        if (bVar == null || !bVar.b()) {
            return false;
        }
        return true;
    }

    public boolean isEnabled() {
        return (this.y & 16) != 0;
    }

    public MenuItem setEnabled(boolean z2) {
        if (z2) {
            this.y |= 16;
        } else {
            this.y &= -17;
        }
        this.f861a.b(false);
        return this;
    }

    public int getGroupId() {
        return this.f863c;
    }

    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f862b;
    }

    public int getOrder() {
        return this.f864d;
    }

    public int c() {
        return this.f865e;
    }

    public Intent getIntent() {
        return this.h;
    }

    public MenuItem setIntent(Intent intent) {
        this.h = intent;
        return this;
    }

    public char getAlphabeticShortcut() {
        return this.k;
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        if (this.k == c2) {
            return this;
        }
        this.k = Character.toLowerCase(c2);
        this.f861a.b(false);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        if (this.k == c2 && this.l == i2) {
            return this;
        }
        this.k = Character.toLowerCase(c2);
        this.l = KeyEvent.normalizeMetaState(i2);
        this.f861a.b(false);
        return this;
    }

    public int getAlphabeticModifiers() {
        return this.l;
    }

    public char getNumericShortcut() {
        return this.i;
    }

    public int getNumericModifiers() {
        return this.j;
    }

    public MenuItem setNumericShortcut(char c2) {
        if (this.i == c2) {
            return this;
        }
        this.i = c2;
        this.f861a.b(false);
        return this;
    }

    public MenuItem setNumericShortcut(char c2, int i2) {
        if (this.i == c2 && this.j == i2) {
            return this;
        }
        this.i = c2;
        this.j = KeyEvent.normalizeMetaState(i2);
        this.f861a.b(false);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.i = c2;
        this.k = Character.toLowerCase(c3);
        this.f861a.b(false);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.i = c2;
        this.j = KeyEvent.normalizeMetaState(i2);
        this.k = Character.toLowerCase(c3);
        this.l = KeyEvent.normalizeMetaState(i3);
        this.f861a.b(false);
        return this;
    }

    /* access modifiers changed from: package-private */
    public char d() {
        return this.f861a.c() ? this.k : this.i;
    }

    /* access modifiers changed from: package-private */
    public String e() {
        char d2 = d();
        if (d2 == 0) {
            return "";
        }
        Resources resources = this.f861a.f().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f861a.f()).hasPermanentMenuKey()) {
            sb.append(resources.getString(a.h.abc_prepend_shortcut_label));
        }
        int i2 = this.f861a.c() ? this.l : this.j;
        a(sb, i2, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, resources.getString(a.h.abc_menu_meta_shortcut_label));
        a(sb, i2, 4096, resources.getString(a.h.abc_menu_ctrl_shortcut_label));
        a(sb, i2, 2, resources.getString(a.h.abc_menu_alt_shortcut_label));
        a(sb, i2, 1, resources.getString(a.h.abc_menu_shift_shortcut_label));
        a(sb, i2, 4, resources.getString(a.h.abc_menu_sym_shortcut_label));
        a(sb, i2, 8, resources.getString(a.h.abc_menu_function_shortcut_label));
        if (d2 == 8) {
            sb.append(resources.getString(a.h.abc_menu_delete_shortcut_label));
        } else if (d2 == 10) {
            sb.append(resources.getString(a.h.abc_menu_enter_shortcut_label));
        } else if (d2 != ' ') {
            sb.append(d2);
        } else {
            sb.append(resources.getString(a.h.abc_menu_space_shortcut_label));
        }
        return sb.toString();
    }

    private static void a(StringBuilder sb, int i2, int i3, String str) {
        if ((i2 & i3) == i3) {
            sb.append(str);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return this.f861a.d() && d() != 0;
    }

    public SubMenu getSubMenu() {
        return this.o;
    }

    public boolean hasSubMenu() {
        return this.o != null;
    }

    public void a(r rVar) {
        this.o = rVar;
        rVar.setHeaderTitle(getTitle());
    }

    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f866f;
    }

    /* access modifiers changed from: package-private */
    public CharSequence a(n.a aVar) {
        if (aVar == null || !aVar.a()) {
            return getTitle();
        }
        return getTitleCondensed();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f866f = charSequence;
        this.f861a.b(false);
        r rVar = this.o;
        if (rVar != null) {
            rVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitle(int i2) {
        return setTitle((CharSequence) this.f861a.f().getString(i2));
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f867g;
        if (charSequence == null) {
            charSequence = this.f866f;
        }
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f867g = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f866f;
        }
        this.f861a.b(false);
        return this;
    }

    public Drawable getIcon() {
        Drawable drawable = this.m;
        if (drawable != null) {
            return a(drawable);
        }
        if (this.n == 0) {
            return null;
        }
        Drawable b2 = androidx.appcompat.a.a.a.b(this.f861a.f(), this.n);
        this.n = 0;
        this.m = b2;
        return a(b2);
    }

    public MenuItem setIcon(Drawable drawable) {
        this.n = 0;
        this.m = drawable;
        this.x = true;
        this.f861a.b(false);
        return this;
    }

    public MenuItem setIcon(int i2) {
        this.m = null;
        this.n = i2;
        this.x = true;
        this.f861a.b(false);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.t = colorStateList;
        this.v = true;
        this.x = true;
        this.f861a.b(false);
        return this;
    }

    public ColorStateList getIconTintList() {
        return this.t;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.u = mode;
        this.w = true;
        this.x = true;
        this.f861a.b(false);
        return this;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.u;
    }

    private Drawable a(Drawable drawable) {
        if (drawable != null && this.x && (this.v || this.w)) {
            drawable = androidx.core.graphics.drawable.a.g(drawable).mutate();
            if (this.v) {
                androidx.core.graphics.drawable.a.a(drawable, this.t);
            }
            if (this.w) {
                androidx.core.graphics.drawable.a.a(drawable, this.u);
            }
            this.x = false;
        }
        return drawable;
    }

    public boolean isCheckable() {
        return (this.y & 1) == 1;
    }

    public MenuItem setCheckable(boolean z2) {
        int i2 = this.y;
        this.y = z2 | (i2 & true) ? 1 : 0;
        if (i2 != this.y) {
            this.f861a.b(false);
        }
        return this;
    }

    public void a(boolean z2) {
        this.y = (z2 ? 4 : 0) | (this.y & -5);
    }

    public boolean g() {
        return (this.y & 4) != 0;
    }

    public boolean isChecked() {
        return (this.y & 2) == 2;
    }

    public MenuItem setChecked(boolean z2) {
        if ((this.y & 4) != 0) {
            this.f861a.a((MenuItem) this);
        } else {
            b(z2);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z2) {
        int i2 = this.y;
        this.y = (z2 ? 2 : 0) | (i2 & -3);
        if (i2 != this.y) {
            this.f861a.b(false);
        }
    }

    public boolean isVisible() {
        androidx.core.g.b bVar = this.B;
        if (bVar == null || !bVar.d()) {
            if ((this.y & 8) == 0) {
                return true;
            }
            return false;
        } else if ((this.y & 8) != 0 || !this.B.e()) {
            return false;
        } else {
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c(boolean z2) {
        int i2 = this.y;
        this.y = (z2 ? 0 : 8) | (i2 & -9);
        if (i2 != this.y) {
            return true;
        }
        return false;
    }

    public MenuItem setVisible(boolean z2) {
        if (c(z2)) {
            this.f861a.a(this);
        }
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.q = onMenuItemClickListener;
        return this;
    }

    public String toString() {
        CharSequence charSequence = this.f866f;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    public void h() {
        this.f861a.b(this);
    }

    public boolean i() {
        return this.f861a.r();
    }

    public boolean j() {
        return (this.y & 32) == 32;
    }

    public boolean k() {
        return (this.z & 1) == 1;
    }

    public boolean l() {
        return (this.z & 2) == 2;
    }

    public void d(boolean z2) {
        if (z2) {
            this.y |= 32;
        } else {
            this.y &= -33;
        }
    }

    public boolean m() {
        return (this.z & 4) == 4;
    }

    public void setShowAsAction(int i2) {
        int i3 = i2 & 3;
        if (i3 == 0 || i3 == 1 || i3 == 2) {
            this.z = i2;
            this.f861a.b(this);
            return;
        }
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }

    /* renamed from: a */
    public b setActionView(View view) {
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1) {
            int i2 = this.f862b;
            if (i2 > 0) {
                view.setId(i2);
            }
        }
        this.f861a.b(this);
        return this;
    }

    /* renamed from: a */
    public b setActionView(int i2) {
        Context f2 = this.f861a.f();
        setActionView(LayoutInflater.from(f2).inflate(i2, new LinearLayout(f2), false));
        return this;
    }

    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        androidx.core.g.b bVar = this.B;
        if (bVar == null) {
            return null;
        }
        this.A = bVar.a((MenuItem) this);
        return this.A;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public androidx.core.g.b a() {
        return this.B;
    }

    public b a(androidx.core.g.b bVar) {
        androidx.core.g.b bVar2 = this.B;
        if (bVar2 != null) {
            bVar2.f();
        }
        this.A = null;
        this.B = bVar;
        this.f861a.b(true);
        androidx.core.g.b bVar3 = this.B;
        if (bVar3 != null) {
            bVar3.a((b.C0036b) new b.C0036b() {
                public void a(boolean z) {
                    i.this.f861a.a(i.this);
                }
            });
        }
        return this;
    }

    /* renamed from: b */
    public androidx.core.a.a.b setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    public boolean expandActionView() {
        if (!n()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f861a.c(this);
        }
        return false;
    }

    public boolean collapseActionView() {
        if ((this.z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f861a.d(this);
        }
        return false;
    }

    public boolean n() {
        if ((this.z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            androidx.core.g.b bVar = this.B;
            if (bVar != null) {
                this.A = bVar.a((MenuItem) this);
            }
        }
        if (this.A != null) {
            return true;
        }
        return false;
    }

    public void e(boolean z2) {
        this.D = z2;
        this.f861a.b(false);
    }

    public boolean isActionViewExpanded() {
        return this.D;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    /* renamed from: a */
    public androidx.core.a.a.b setContentDescription(CharSequence charSequence) {
        this.r = charSequence;
        this.f861a.b(false);
        return this;
    }

    public CharSequence getContentDescription() {
        return this.r;
    }

    /* renamed from: b */
    public androidx.core.a.a.b setTooltipText(CharSequence charSequence) {
        this.s = charSequence;
        this.f861a.b(false);
        return this;
    }

    public CharSequence getTooltipText() {
        return this.s;
    }
}
