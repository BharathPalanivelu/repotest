package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ar;
import androidx.appcompat.widget.z;
import androidx.core.g.h;
import com.facebook.soloader.MinElf;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class g extends MenuInflater {

    /* renamed from: a  reason: collision with root package name */
    static final Class<?>[] f758a = {Context.class};

    /* renamed from: b  reason: collision with root package name */
    static final Class<?>[] f759b = f758a;

    /* renamed from: c  reason: collision with root package name */
    final Object[] f760c;

    /* renamed from: d  reason: collision with root package name */
    final Object[] f761d = this.f760c;

    /* renamed from: e  reason: collision with root package name */
    Context f762e;

    /* renamed from: f  reason: collision with root package name */
    private Object f763f;

    public g(Context context) {
        super(context);
        this.f762e = context;
        this.f760c = new Object[]{context};
    }

    public void inflate(int i, Menu menu) {
        if (!(menu instanceof androidx.core.a.a.a)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.f762e.getResources().getLayout(i);
            a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        } catch (XmlPullParserException e2) {
            throw new InflateException("Error inflating menu XML", e2);
        } catch (IOException e3) {
            throw new InflateException("Error inflating menu XML", e3);
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    private void a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 2) {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
            }
        }
        int i = eventType;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        String name2 = xmlPullParser.getName();
                        if (z2 && name2.equals(str)) {
                            str = null;
                            z2 = false;
                        } else if (name2.equals("group")) {
                            bVar.a();
                        } else if (name2.equals("item")) {
                            if (!bVar.d()) {
                                if (bVar.f767a == null || !bVar.f767a.c()) {
                                    bVar.b();
                                } else {
                                    bVar.c();
                                }
                            }
                        } else if (name2.equals("menu")) {
                            z = true;
                        }
                    }
                } else if (!z2) {
                    String name3 = xmlPullParser.getName();
                    if (name3.equals("group")) {
                        bVar.a(attributeSet);
                    } else if (name3.equals("item")) {
                        bVar.b(attributeSet);
                    } else if (name3.equals("menu")) {
                        a(xmlPullParser, attributeSet, bVar.c());
                    } else {
                        str = name3;
                        z2 = true;
                    }
                }
                i = xmlPullParser.next();
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Object a() {
        if (this.f763f == null) {
            this.f763f = a(this.f762e);
        }
        return this.f763f;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    private static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        private static final Class<?>[] f764a = {MenuItem.class};

        /* renamed from: b  reason: collision with root package name */
        private Object f765b;

        /* renamed from: c  reason: collision with root package name */
        private Method f766c;

        public a(Object obj, String str) {
            this.f765b = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f766c = cls.getMethod(str, f764a);
            } catch (Exception e2) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e2);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f766c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f766c.invoke(this.f765b, new Object[]{menuItem})).booleanValue();
                }
                this.f766c.invoke(this.f765b, new Object[]{menuItem});
                return true;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    private class b {
        private String A;
        private String B;
        private CharSequence C;
        private CharSequence D;
        private ColorStateList E = null;
        private PorterDuff.Mode F = null;

        /* renamed from: a  reason: collision with root package name */
        androidx.core.g.b f767a;

        /* renamed from: c  reason: collision with root package name */
        private Menu f769c;

        /* renamed from: d  reason: collision with root package name */
        private int f770d;

        /* renamed from: e  reason: collision with root package name */
        private int f771e;

        /* renamed from: f  reason: collision with root package name */
        private int f772f;

        /* renamed from: g  reason: collision with root package name */
        private int f773g;
        private boolean h;
        private boolean i;
        private boolean j;
        private int k;
        private int l;
        private CharSequence m;
        private CharSequence n;
        private int o;
        private char p;
        private int q;
        private char r;
        private int s;
        private int t;
        private boolean u;
        private boolean v;
        private boolean w;
        private int x;
        private int y;
        private String z;

        public b(Menu menu) {
            this.f769c = menu;
            a();
        }

        public void a() {
            this.f770d = 0;
            this.f771e = 0;
            this.f772f = 0;
            this.f773g = 0;
            this.h = true;
            this.i = true;
        }

        public void a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.f762e.obtainStyledAttributes(attributeSet, a.j.MenuGroup);
            this.f770d = obtainStyledAttributes.getResourceId(a.j.MenuGroup_android_id, 0);
            this.f771e = obtainStyledAttributes.getInt(a.j.MenuGroup_android_menuCategory, 0);
            this.f772f = obtainStyledAttributes.getInt(a.j.MenuGroup_android_orderInCategory, 0);
            this.f773g = obtainStyledAttributes.getInt(a.j.MenuGroup_android_checkableBehavior, 0);
            this.h = obtainStyledAttributes.getBoolean(a.j.MenuGroup_android_visible, true);
            this.i = obtainStyledAttributes.getBoolean(a.j.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void b(AttributeSet attributeSet) {
            ar a2 = ar.a(g.this.f762e, attributeSet, a.j.MenuItem);
            this.k = a2.g(a.j.MenuItem_android_id, 0);
            this.l = (a2.a(a.j.MenuItem_android_menuCategory, this.f771e) & -65536) | (a2.a(a.j.MenuItem_android_orderInCategory, this.f772f) & MinElf.PN_XNUM);
            this.m = a2.c(a.j.MenuItem_android_title);
            this.n = a2.c(a.j.MenuItem_android_titleCondensed);
            this.o = a2.g(a.j.MenuItem_android_icon, 0);
            this.p = a(a2.d(a.j.MenuItem_android_alphabeticShortcut));
            this.q = a2.a(a.j.MenuItem_alphabeticModifiers, 4096);
            this.r = a(a2.d(a.j.MenuItem_android_numericShortcut));
            this.s = a2.a(a.j.MenuItem_numericModifiers, 4096);
            if (a2.g(a.j.MenuItem_android_checkable)) {
                this.t = a2.a(a.j.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.t = this.f773g;
            }
            this.u = a2.a(a.j.MenuItem_android_checked, false);
            this.v = a2.a(a.j.MenuItem_android_visible, this.h);
            this.w = a2.a(a.j.MenuItem_android_enabled, this.i);
            this.x = a2.a(a.j.MenuItem_showAsAction, -1);
            this.B = a2.d(a.j.MenuItem_android_onClick);
            this.y = a2.g(a.j.MenuItem_actionLayout, 0);
            this.z = a2.d(a.j.MenuItem_actionViewClass);
            this.A = a2.d(a.j.MenuItem_actionProviderClass);
            boolean z2 = this.A != null;
            if (z2 && this.y == 0 && this.z == null) {
                this.f767a = (androidx.core.g.b) a(this.A, g.f759b, g.this.f761d);
            } else {
                if (z2) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f767a = null;
            }
            this.C = a2.c(a.j.MenuItem_contentDescription);
            this.D = a2.c(a.j.MenuItem_tooltipText);
            if (a2.g(a.j.MenuItem_iconTintMode)) {
                this.F = z.a(a2.a(a.j.MenuItem_iconTintMode, -1), this.F);
            } else {
                this.F = null;
            }
            if (a2.g(a.j.MenuItem_iconTint)) {
                this.E = a2.e(a.j.MenuItem_iconTint);
            } else {
                this.E = null;
            }
            a2.a();
            this.j = false;
        }

        private char a(String str) {
            if (str == null) {
                return 0;
            }
            return str.charAt(0);
        }

        private void a(MenuItem menuItem) {
            boolean z2 = false;
            menuItem.setChecked(this.u).setVisible(this.v).setEnabled(this.w).setCheckable(this.t >= 1).setTitleCondensed(this.n).setIcon(this.o);
            int i2 = this.x;
            if (i2 >= 0) {
                menuItem.setShowAsAction(i2);
            }
            if (this.B != null) {
                if (!g.this.f762e.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new a(g.this.a(), this.B));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            boolean z3 = menuItem instanceof i;
            if (z3) {
                i iVar = (i) menuItem;
            }
            if (this.t >= 2) {
                if (z3) {
                    ((i) menuItem).a(true);
                } else if (menuItem instanceof j) {
                    ((j) menuItem).a(true);
                }
            }
            String str = this.z;
            if (str != null) {
                menuItem.setActionView((View) a(str, g.f758a, g.this.f760c));
                z2 = true;
            }
            int i3 = this.y;
            if (i3 > 0) {
                if (!z2) {
                    menuItem.setActionView(i3);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            androidx.core.g.b bVar = this.f767a;
            if (bVar != null) {
                h.a(menuItem, bVar);
            }
            h.a(menuItem, this.C);
            h.b(menuItem, this.D);
            h.b(menuItem, this.p, this.q);
            h.a(menuItem, this.r, this.s);
            PorterDuff.Mode mode = this.F;
            if (mode != null) {
                h.a(menuItem, mode);
            }
            ColorStateList colorStateList = this.E;
            if (colorStateList != null) {
                h.a(menuItem, colorStateList);
            }
        }

        public void b() {
            this.j = true;
            a(this.f769c.add(this.f770d, this.k, this.l, this.m));
        }

        public SubMenu c() {
            this.j = true;
            SubMenu addSubMenu = this.f769c.addSubMenu(this.f770d, this.k, this.l, this.m);
            a(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean d() {
            return this.j;
        }

        private <T> T a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f762e.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e2) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e2);
                return null;
            }
        }
    }
}
