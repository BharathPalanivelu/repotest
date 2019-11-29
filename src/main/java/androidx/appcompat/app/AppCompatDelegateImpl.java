package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.app.b;
import androidx.appcompat.view.b;
import androidx.appcompat.view.f;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ab;
import androidx.appcompat.widget.ar;
import androidx.appcompat.widget.aw;
import androidx.appcompat.widget.ax;
import androidx.appcompat.widget.j;
import androidx.appcompat.widget.x;
import androidx.core.g.aa;
import androidx.core.g.ac;
import androidx.core.g.ae;
import androidx.core.g.e;
import androidx.core.g.r;
import androidx.core.g.w;
import androidx.lifecycle.e;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.Thread;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

class AppCompatDelegateImpl extends f implements LayoutInflater.Factory2, g.a {
    private static final Map<Class<?>, Integer> t = new androidx.b.a();
    private static final boolean u = (Build.VERSION.SDK_INT < 21);
    private static final int[] v = {16842836};
    private static boolean w = true;
    private static final boolean x;
    private x A;
    private b B;
    private i C;
    private boolean D;
    private boolean E;
    private ViewGroup F;
    private TextView G;
    private View H;
    private boolean I;
    private boolean J;
    private boolean K;
    private PanelFeatureState[] L;
    private PanelFeatureState M;
    private boolean N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private int R;
    private int S;
    private boolean T;
    private boolean U;
    private f V;
    private f W;
    private final Runnable X;
    private boolean Y;
    private Rect Z;

    /* renamed from: a  reason: collision with root package name */
    final Object f588a;
    private Rect aa;
    private AppCompatViewInflater ab;

    /* renamed from: b  reason: collision with root package name */
    final Context f589b;

    /* renamed from: c  reason: collision with root package name */
    Window f590c;

    /* renamed from: d  reason: collision with root package name */
    final e f591d;

    /* renamed from: e  reason: collision with root package name */
    a f592e;

    /* renamed from: f  reason: collision with root package name */
    MenuInflater f593f;

    /* renamed from: g  reason: collision with root package name */
    androidx.appcompat.view.b f594g;
    ActionBarContextView h;
    PopupWindow i;
    Runnable j;
    aa k;
    boolean l;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    boolean q;
    boolean r;
    int s;
    private d y;
    private CharSequence z;

    /* access modifiers changed from: package-private */
    public void a(ViewGroup viewGroup) {
    }

    static {
        boolean z2 = false;
        if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT <= 25) {
            z2 = true;
        }
        x = z2;
        if (u && !w) {
            final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                public void uncaughtException(Thread thread, Throwable th) {
                    if (a(th)) {
                        Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                        notFoundException.initCause(th.getCause());
                        notFoundException.setStackTrace(th.getStackTrace());
                        defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                        return;
                    }
                    defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                }

                private boolean a(Throwable th) {
                    if (!(th instanceof Resources.NotFoundException)) {
                        return false;
                    }
                    String message = th.getMessage();
                    if (message == null) {
                        return false;
                    }
                    if (message.contains("drawable") || message.contains("Drawable")) {
                        return true;
                    }
                    return false;
                }
            });
        }
    }

    AppCompatDelegateImpl(Activity activity, e eVar) {
        this(activity, (Window) null, eVar, activity);
    }

    AppCompatDelegateImpl(Dialog dialog, e eVar) {
        this(dialog.getContext(), dialog.getWindow(), eVar, dialog);
    }

    private AppCompatDelegateImpl(Context context, Window window, e eVar, Object obj) {
        this.k = null;
        this.D = true;
        this.R = -100;
        this.X = new Runnable() {
            public void run() {
                if ((AppCompatDelegateImpl.this.s & 1) != 0) {
                    AppCompatDelegateImpl.this.h(0);
                }
                if ((AppCompatDelegateImpl.this.s & 4096) != 0) {
                    AppCompatDelegateImpl.this.h(108);
                }
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                appCompatDelegateImpl.r = false;
                appCompatDelegateImpl.s = 0;
            }
        };
        this.f589b = context;
        this.f591d = eVar;
        this.f588a = obj;
        if (this.R == -100 && (this.f588a instanceof Dialog)) {
            d C2 = C();
            if (C2 != null) {
                this.R = C2.getDelegate().j();
            }
        }
        if (this.R == -100) {
            Integer num = t.get(this.f588a.getClass());
            if (num != null) {
                this.R = num.intValue();
                t.remove(this.f588a.getClass());
            }
        }
        if (window != null) {
            a(window);
        }
        j.a();
    }

    public void a(Context context) {
        a(false);
        this.O = true;
    }

    public void a(Bundle bundle) {
        this.O = true;
        a(false);
        y();
        Object obj = this.f588a;
        if (obj instanceof Activity) {
            String str = null;
            try {
                str = androidx.core.app.g.b((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                a l2 = l();
                if (l2 == null) {
                    this.Y = true;
                } else {
                    l2.c(true);
                }
            }
        }
        this.P = true;
    }

    public void b(Bundle bundle) {
        z();
    }

    public a a() {
        w();
        return this.f592e;
    }

    /* access modifiers changed from: package-private */
    public final a l() {
        return this.f592e;
    }

    /* access modifiers changed from: package-private */
    public final Window.Callback m() {
        return this.f590c.getCallback();
    }

    private void w() {
        z();
        if (this.l && this.f592e == null) {
            Object obj = this.f588a;
            if (obj instanceof Activity) {
                this.f592e = new l((Activity) obj, this.m);
            } else if (obj instanceof Dialog) {
                this.f592e = new l((Dialog) obj);
            }
            a aVar = this.f592e;
            if (aVar != null) {
                aVar.c(this.Y);
            }
        }
    }

    public void a(Toolbar toolbar) {
        if (this.f588a instanceof Activity) {
            a a2 = a();
            if (!(a2 instanceof l)) {
                this.f593f = null;
                if (a2 != null) {
                    a2.g();
                }
                if (toolbar != null) {
                    i iVar = new i(toolbar, o(), this.y);
                    this.f592e = iVar;
                    this.f590c.setCallback(iVar.h());
                } else {
                    this.f592e = null;
                    this.f590c.setCallback(this.y);
                }
                f();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    /* access modifiers changed from: package-private */
    public final Context n() {
        a a2 = a();
        Context b2 = a2 != null ? a2.b() : null;
        return b2 == null ? this.f589b : b2;
    }

    public MenuInflater b() {
        if (this.f593f == null) {
            w();
            a aVar = this.f592e;
            this.f593f = new androidx.appcompat.view.g(aVar != null ? aVar.b() : this.f589b);
        }
        return this.f593f;
    }

    public <T extends View> T b(int i2) {
        z();
        return this.f590c.findViewById(i2);
    }

    public void a(Configuration configuration) {
        if (this.l && this.E) {
            a a2 = a();
            if (a2 != null) {
                a2.a(configuration);
            }
        }
        j.b().a(this.f589b);
        a(false);
    }

    public void c() {
        this.Q = true;
        u();
        a((f) this);
    }

    public void d() {
        this.Q = false;
        b((f) this);
        a a2 = a();
        if (a2 != null) {
            a2.d(false);
        }
        if (this.f588a instanceof Dialog) {
            x();
        }
    }

    public void e() {
        a a2 = a();
        if (a2 != null) {
            a2.d(true);
        }
    }

    public void a(View view) {
        z();
        ViewGroup viewGroup = (ViewGroup) this.F.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.y.a().onContentChanged();
    }

    public void c(int i2) {
        z();
        ViewGroup viewGroup = (ViewGroup) this.F.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f589b).inflate(i2, viewGroup);
        this.y.a().onContentChanged();
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams) {
        z();
        ViewGroup viewGroup = (ViewGroup) this.F.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.y.a().onContentChanged();
    }

    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        z();
        ((ViewGroup) this.F.findViewById(16908290)).addView(view, layoutParams);
        this.y.a().onContentChanged();
    }

    public void c(Bundle bundle) {
        if (this.R != -100) {
            t.put(this.f588a.getClass(), Integer.valueOf(this.R));
        }
    }

    public void g() {
        b((f) this);
        if (this.r) {
            this.f590c.getDecorView().removeCallbacks(this.X);
        }
        this.Q = false;
        this.q = true;
        a aVar = this.f592e;
        if (aVar != null) {
            aVar.g();
        }
        x();
    }

    private void x() {
        f fVar = this.V;
        if (fVar != null) {
            fVar.e();
        }
        f fVar2 = this.W;
        if (fVar2 != null) {
            fVar2.e();
        }
    }

    public void a(int i2) {
        this.S = i2;
    }

    private void y() {
        if (this.f590c == null) {
            Object obj = this.f588a;
            if (obj instanceof Activity) {
                a(((Activity) obj).getWindow());
            }
        }
        if (this.f590c == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private void a(Window window) {
        if (this.f590c == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof d)) {
                this.y = new d(callback);
                window.setCallback(this.y);
                ar a2 = ar.a(this.f589b, (AttributeSet) null, v);
                Drawable b2 = a2.b(0);
                if (b2 != null) {
                    window.setBackgroundDrawable(b2);
                }
                a2.a();
                this.f590c = window;
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    private void z() {
        if (!this.E) {
            this.F = A();
            CharSequence o2 = o();
            if (!TextUtils.isEmpty(o2)) {
                x xVar = this.A;
                if (xVar != null) {
                    xVar.setWindowTitle(o2);
                } else if (l() != null) {
                    l().b(o2);
                } else {
                    TextView textView = this.G;
                    if (textView != null) {
                        textView.setText(o2);
                    }
                }
            }
            B();
            a(this.F);
            this.E = true;
            PanelFeatureState a2 = a(0, false);
            if (this.q) {
                return;
            }
            if (a2 == null || a2.j == null) {
                k(108);
            }
        }
    }

    private ViewGroup A() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.f589b.obtainStyledAttributes(a.j.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(a.j.AppCompatTheme_windowActionBar)) {
            if (obtainStyledAttributes.getBoolean(a.j.AppCompatTheme_windowNoTitle, false)) {
                d(1);
            } else if (obtainStyledAttributes.getBoolean(a.j.AppCompatTheme_windowActionBar, false)) {
                d(108);
            }
            if (obtainStyledAttributes.getBoolean(a.j.AppCompatTheme_windowActionBarOverlay, false)) {
                d(109);
            }
            if (obtainStyledAttributes.getBoolean(a.j.AppCompatTheme_windowActionModeOverlay, false)) {
                d(10);
            }
            this.o = obtainStyledAttributes.getBoolean(a.j.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            y();
            this.f590c.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.f589b);
            if (this.p) {
                if (this.n) {
                    viewGroup = (ViewGroup) from.inflate(a.g.abc_screen_simple_overlay_action_mode, (ViewGroup) null);
                } else {
                    viewGroup = (ViewGroup) from.inflate(a.g.abc_screen_simple, (ViewGroup) null);
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    w.a((View) viewGroup, (r) new r() {
                        public ae a(View view, ae aeVar) {
                            int b2 = aeVar.b();
                            int i = AppCompatDelegateImpl.this.i(b2);
                            if (b2 != i) {
                                aeVar = aeVar.a(aeVar.a(), i, aeVar.c(), aeVar.d());
                            }
                            return w.a(view, aeVar);
                        }
                    });
                } else {
                    ((ab) viewGroup).setOnFitSystemWindowsListener(new ab.a() {
                        public void a(Rect rect) {
                            rect.top = AppCompatDelegateImpl.this.i(rect.top);
                        }
                    });
                }
            } else if (this.o) {
                viewGroup = (ViewGroup) from.inflate(a.g.abc_dialog_title_material, (ViewGroup) null);
                this.m = false;
                this.l = false;
            } else if (this.l) {
                TypedValue typedValue = new TypedValue();
                this.f589b.getTheme().resolveAttribute(a.C0012a.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    context = new androidx.appcompat.view.d(this.f589b, typedValue.resourceId);
                } else {
                    context = this.f589b;
                }
                viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(a.g.abc_screen_toolbar, (ViewGroup) null);
                this.A = (x) viewGroup.findViewById(a.f.decor_content_parent);
                this.A.setWindowCallback(m());
                if (this.m) {
                    this.A.a(109);
                }
                if (this.I) {
                    this.A.a(2);
                }
                if (this.J) {
                    this.A.a(5);
                }
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                if (this.A == null) {
                    this.G = (TextView) viewGroup.findViewById(a.f.title);
                }
                ax.b(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(a.f.action_bar_activity_content);
                ViewGroup viewGroup2 = (ViewGroup) this.f590c.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground((Drawable) null);
                    }
                }
                this.f590c.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new ContentFrameLayout.a() {
                    public void a() {
                    }

                    public void b() {
                        AppCompatDelegateImpl.this.t();
                    }
                });
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.l + ", windowActionBarOverlay: " + this.m + ", android:windowIsFloating: " + this.o + ", windowActionModeOverlay: " + this.n + ", windowNoTitle: " + this.p + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void B() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.F.findViewById(16908290);
        View decorView = this.f590c.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f589b.obtainStyledAttributes(a.j.AppCompatTheme);
        obtainStyledAttributes.getValue(a.j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(a.j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(a.j.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(a.j.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(a.j.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(a.j.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(a.j.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(a.j.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(a.j.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(a.j.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    public boolean d(int i2) {
        int l2 = l(i2);
        if (this.p && l2 == 108) {
            return false;
        }
        if (this.l && l2 == 1) {
            this.l = false;
        }
        if (l2 == 1) {
            D();
            this.p = true;
            return true;
        } else if (l2 == 2) {
            D();
            this.I = true;
            return true;
        } else if (l2 == 5) {
            D();
            this.J = true;
            return true;
        } else if (l2 == 10) {
            D();
            this.n = true;
            return true;
        } else if (l2 == 108) {
            D();
            this.l = true;
            return true;
        } else if (l2 != 109) {
            return this.f590c.requestFeature(l2);
        } else {
            D();
            this.m = true;
            return true;
        }
    }

    public final void a(CharSequence charSequence) {
        this.z = charSequence;
        x xVar = this.A;
        if (xVar != null) {
            xVar.setWindowTitle(charSequence);
        } else if (l() != null) {
            l().b(charSequence);
        } else {
            TextView textView = this.G;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final CharSequence o() {
        Object obj = this.f588a;
        if (obj instanceof Activity) {
            return ((Activity) obj).getTitle();
        }
        return this.z;
    }

    /* access modifiers changed from: package-private */
    public void e(int i2) {
        if (i2 == 108) {
            a a2 = a();
            if (a2 != null) {
                a2.e(false);
            }
        } else if (i2 == 0) {
            PanelFeatureState a3 = a(i2, true);
            if (a3.o) {
                a(a3, false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f(int i2) {
        if (i2 == 108) {
            a a2 = a();
            if (a2 != null) {
                a2.e(true);
            }
        }
    }

    public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        Window.Callback m2 = m();
        if (m2 == null || this.q) {
            return false;
        }
        PanelFeatureState a2 = a((Menu) gVar.q());
        if (a2 != null) {
            return m2.onMenuItemSelected(a2.f603a, menuItem);
        }
        return false;
    }

    public void a(androidx.appcompat.view.menu.g gVar) {
        a(gVar, true);
    }

    public androidx.appcompat.view.b a(b.a aVar) {
        if (aVar != null) {
            androidx.appcompat.view.b bVar = this.f594g;
            if (bVar != null) {
                bVar.c();
            }
            c cVar = new c(aVar);
            a a2 = a();
            if (a2 != null) {
                this.f594g = a2.a((b.a) cVar);
                androidx.appcompat.view.b bVar2 = this.f594g;
                if (bVar2 != null) {
                    e eVar = this.f591d;
                    if (eVar != null) {
                        eVar.onSupportActionModeStarted(bVar2);
                    }
                }
            }
            if (this.f594g == null) {
                this.f594g = b((b.a) cVar);
            }
            return this.f594g;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    public void f() {
        a a2 = a();
        if (a2 == null || !a2.e()) {
            k(0);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x016a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.appcompat.view.b b(androidx.appcompat.view.b.a r8) {
        /*
            r7 = this;
            r7.r()
            androidx.appcompat.view.b r0 = r7.f594g
            if (r0 == 0) goto L_0x000a
            r0.c()
        L_0x000a:
            boolean r0 = r8 instanceof androidx.appcompat.app.AppCompatDelegateImpl.c
            if (r0 != 0) goto L_0x0014
            androidx.appcompat.app.AppCompatDelegateImpl$c r0 = new androidx.appcompat.app.AppCompatDelegateImpl$c
            r0.<init>(r8)
            r8 = r0
        L_0x0014:
            androidx.appcompat.app.e r0 = r7.f591d
            r1 = 0
            if (r0 == 0) goto L_0x0022
            boolean r2 = r7.q
            if (r2 != 0) goto L_0x0022
            androidx.appcompat.view.b r0 = r0.onWindowStartingSupportActionMode(r8)     // Catch:{ AbstractMethodError -> 0x0022 }
            goto L_0x0023
        L_0x0022:
            r0 = r1
        L_0x0023:
            if (r0 == 0) goto L_0x0029
            r7.f594g = r0
            goto L_0x0166
        L_0x0029:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.h
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x00d6
            boolean r0 = r7.o
            if (r0 == 0) goto L_0x00b7
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            android.content.Context r4 = r7.f589b
            android.content.res.Resources$Theme r4 = r4.getTheme()
            int r5 = androidx.appcompat.a.C0012a.actionBarTheme
            r4.resolveAttribute(r5, r0, r3)
            int r5 = r0.resourceId
            if (r5 == 0) goto L_0x0068
            android.content.Context r5 = r7.f589b
            android.content.res.Resources r5 = r5.getResources()
            android.content.res.Resources$Theme r5 = r5.newTheme()
            r5.setTo(r4)
            int r4 = r0.resourceId
            r5.applyStyle(r4, r3)
            androidx.appcompat.view.d r4 = new androidx.appcompat.view.d
            android.content.Context r6 = r7.f589b
            r4.<init>((android.content.Context) r6, (int) r2)
            android.content.res.Resources$Theme r6 = r4.getTheme()
            r6.setTo(r5)
            goto L_0x006a
        L_0x0068:
            android.content.Context r4 = r7.f589b
        L_0x006a:
            androidx.appcompat.widget.ActionBarContextView r5 = new androidx.appcompat.widget.ActionBarContextView
            r5.<init>(r4)
            r7.h = r5
            android.widget.PopupWindow r5 = new android.widget.PopupWindow
            int r6 = androidx.appcompat.a.C0012a.actionModePopupWindowStyle
            r5.<init>(r4, r1, r6)
            r7.i = r5
            android.widget.PopupWindow r5 = r7.i
            r6 = 2
            androidx.core.widget.h.a((android.widget.PopupWindow) r5, (int) r6)
            android.widget.PopupWindow r5 = r7.i
            androidx.appcompat.widget.ActionBarContextView r6 = r7.h
            r5.setContentView(r6)
            android.widget.PopupWindow r5 = r7.i
            r6 = -1
            r5.setWidth(r6)
            android.content.res.Resources$Theme r5 = r4.getTheme()
            int r6 = androidx.appcompat.a.C0012a.actionBarSize
            r5.resolveAttribute(r6, r0, r3)
            int r0 = r0.data
            android.content.res.Resources r4 = r4.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            int r0 = android.util.TypedValue.complexToDimensionPixelSize(r0, r4)
            androidx.appcompat.widget.ActionBarContextView r4 = r7.h
            r4.setContentHeight(r0)
            android.widget.PopupWindow r0 = r7.i
            r4 = -2
            r0.setHeight(r4)
            androidx.appcompat.app.AppCompatDelegateImpl$6 r0 = new androidx.appcompat.app.AppCompatDelegateImpl$6
            r0.<init>()
            r7.j = r0
            goto L_0x00d6
        L_0x00b7:
            android.view.ViewGroup r0 = r7.F
            int r4 = androidx.appcompat.a.f.action_mode_bar_stub
            android.view.View r0 = r0.findViewById(r4)
            androidx.appcompat.widget.ViewStubCompat r0 = (androidx.appcompat.widget.ViewStubCompat) r0
            if (r0 == 0) goto L_0x00d6
            android.content.Context r4 = r7.n()
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            r0.setLayoutInflater(r4)
            android.view.View r0 = r0.a()
            androidx.appcompat.widget.ActionBarContextView r0 = (androidx.appcompat.widget.ActionBarContextView) r0
            r7.h = r0
        L_0x00d6:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.h
            if (r0 == 0) goto L_0x0166
            r7.r()
            androidx.appcompat.widget.ActionBarContextView r0 = r7.h
            r0.c()
            androidx.appcompat.view.e r0 = new androidx.appcompat.view.e
            androidx.appcompat.widget.ActionBarContextView r4 = r7.h
            android.content.Context r4 = r4.getContext()
            androidx.appcompat.widget.ActionBarContextView r5 = r7.h
            android.widget.PopupWindow r6 = r7.i
            if (r6 != 0) goto L_0x00f1
            goto L_0x00f2
        L_0x00f1:
            r3 = 0
        L_0x00f2:
            r0.<init>(r4, r5, r8, r3)
            android.view.Menu r3 = r0.b()
            boolean r8 = r8.a((androidx.appcompat.view.b) r0, (android.view.Menu) r3)
            if (r8 == 0) goto L_0x0164
            r0.d()
            androidx.appcompat.widget.ActionBarContextView r8 = r7.h
            r8.a(r0)
            r7.f594g = r0
            boolean r8 = r7.p()
            r0 = 1065353216(0x3f800000, float:1.0)
            if (r8 == 0) goto L_0x012e
            androidx.appcompat.widget.ActionBarContextView r8 = r7.h
            r1 = 0
            r8.setAlpha(r1)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.h
            androidx.core.g.aa r8 = androidx.core.g.w.n(r8)
            androidx.core.g.aa r8 = r8.a((float) r0)
            r7.k = r8
            androidx.core.g.aa r8 = r7.k
            androidx.appcompat.app.AppCompatDelegateImpl$7 r0 = new androidx.appcompat.app.AppCompatDelegateImpl$7
            r0.<init>()
            r8.a((androidx.core.g.ab) r0)
            goto L_0x0154
        L_0x012e:
            androidx.appcompat.widget.ActionBarContextView r8 = r7.h
            r8.setAlpha(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.h
            r8.setVisibility(r2)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.h
            r0 = 32
            r8.sendAccessibilityEvent(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.h
            android.view.ViewParent r8 = r8.getParent()
            boolean r8 = r8 instanceof android.view.View
            if (r8 == 0) goto L_0x0154
            androidx.appcompat.widget.ActionBarContextView r8 = r7.h
            android.view.ViewParent r8 = r8.getParent()
            android.view.View r8 = (android.view.View) r8
            androidx.core.g.w.s(r8)
        L_0x0154:
            android.widget.PopupWindow r8 = r7.i
            if (r8 == 0) goto L_0x0166
            android.view.Window r8 = r7.f590c
            android.view.View r8 = r8.getDecorView()
            java.lang.Runnable r0 = r7.j
            r8.post(r0)
            goto L_0x0166
        L_0x0164:
            r7.f594g = r1
        L_0x0166:
            androidx.appcompat.view.b r8 = r7.f594g
            if (r8 == 0) goto L_0x0171
            androidx.appcompat.app.e r0 = r7.f591d
            if (r0 == 0) goto L_0x0171
            r0.onSupportActionModeStarted(r8)
        L_0x0171:
            androidx.appcompat.view.b r8 = r7.f594g
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.b(androidx.appcompat.view.b$a):androidx.appcompat.view.b");
    }

    /* access modifiers changed from: package-private */
    public final boolean p() {
        if (this.E) {
            ViewGroup viewGroup = this.F;
            return viewGroup != null && w.A(viewGroup);
        }
    }

    public boolean q() {
        return this.D;
    }

    /* access modifiers changed from: package-private */
    public void r() {
        aa aaVar = this.k;
        if (aaVar != null) {
            aaVar.b();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean s() {
        androidx.appcompat.view.b bVar = this.f594g;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        a a2 = a();
        if (a2 == null || !a2.f()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2, KeyEvent keyEvent) {
        a a2 = a();
        if (a2 != null && a2.a(i2, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.M;
        if (panelFeatureState == null || !a(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.M == null) {
                PanelFeatureState a3 = a(0, true);
                b(a3, keyEvent);
                boolean a4 = a(a3, keyEvent.getKeyCode(), keyEvent, 1);
                a3.m = false;
                if (a4) {
                    return true;
                }
            }
            return false;
        }
        PanelFeatureState panelFeatureState2 = this.M;
        if (panelFeatureState2 != null) {
            panelFeatureState2.n = true;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean a(KeyEvent keyEvent) {
        Object obj = this.f588a;
        boolean z2 = true;
        if ((obj instanceof e.a) || (obj instanceof g)) {
            View decorView = this.f590c.getDecorView();
            if (decorView != null && androidx.core.g.e.a(decorView, keyEvent)) {
                return true;
            }
        }
        if (keyEvent.getKeyCode() == 82 && this.y.a().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z2 = false;
        }
        return z2 ? c(keyCode, keyEvent) : b(keyCode, keyEvent);
    }

    /* access modifiers changed from: package-private */
    public boolean b(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            boolean z2 = this.N;
            this.N = false;
            PanelFeatureState a2 = a(0, false);
            if (a2 != null && a2.o) {
                if (!z2) {
                    a(a2, true);
                }
                return true;
            } else if (s()) {
                return true;
            }
        } else if (i2 == 82) {
            e(0, keyEvent);
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean c(int i2, KeyEvent keyEvent) {
        boolean z2 = true;
        if (i2 == 4) {
            if ((keyEvent.getFlags() & 128) == 0) {
                z2 = false;
            }
            this.N = z2;
        } else if (i2 == 82) {
            d(0, keyEvent);
            return true;
        }
        return false;
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z2;
        boolean z3 = false;
        if (this.ab == null) {
            String string = this.f589b.obtainStyledAttributes(a.j.AppCompatTheme).getString(a.j.AppCompatTheme_viewInflaterClass);
            if (string == null || AppCompatViewInflater.class.getName().equals(string)) {
                this.ab = new AppCompatViewInflater();
            } else {
                try {
                    this.ab = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.ab = new AppCompatViewInflater();
                }
            }
        }
        if (u) {
            if (!(attributeSet instanceof XmlPullParser)) {
                z3 = a((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z3 = true;
            }
            z2 = z3;
        } else {
            z2 = false;
        }
        return this.ab.createView(view, str, context, attributeSet, z2, u, true, aw.a());
    }

    private boolean a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f590c.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || w.D((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    public void i() {
        LayoutInflater from = LayoutInflater.from(this.f589b);
        if (from.getFactory() == null) {
            androidx.core.g.f.a(from, this);
        } else if (!(from.getFactory2() instanceof AppCompatDelegateImpl)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return a(view, str, context, attributeSet);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    private d C() {
        Context context = this.f589b;
        while (context != null) {
            if (!(context instanceof d)) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                return (d) context;
            }
        }
        return null;
    }

    private void a(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i2;
        if (!panelFeatureState.o && !this.q) {
            if (panelFeatureState.f603a == 0) {
                if ((this.f589b.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }
            }
            Window.Callback m2 = m();
            if (m2 == null || m2.onMenuOpened(panelFeatureState.f603a, panelFeatureState.j)) {
                WindowManager windowManager = (WindowManager) this.f589b.getSystemService("window");
                if (windowManager != null && b(panelFeatureState, keyEvent)) {
                    if (panelFeatureState.f609g == null || panelFeatureState.q) {
                        if (panelFeatureState.f609g == null) {
                            if (!a(panelFeatureState) || panelFeatureState.f609g == null) {
                                return;
                            }
                        } else if (panelFeatureState.q && panelFeatureState.f609g.getChildCount() > 0) {
                            panelFeatureState.f609g.removeAllViews();
                        }
                        if (c(panelFeatureState) && panelFeatureState.a()) {
                            ViewGroup.LayoutParams layoutParams = panelFeatureState.h.getLayoutParams();
                            if (layoutParams == null) {
                                layoutParams = new ViewGroup.LayoutParams(-2, -2);
                            }
                            panelFeatureState.f609g.setBackgroundResource(panelFeatureState.f604b);
                            ViewParent parent = panelFeatureState.h.getParent();
                            if (parent instanceof ViewGroup) {
                                ((ViewGroup) parent).removeView(panelFeatureState.h);
                            }
                            panelFeatureState.f609g.addView(panelFeatureState.h, layoutParams);
                            if (!panelFeatureState.h.hasFocus()) {
                                panelFeatureState.h.requestFocus();
                            }
                        } else {
                            return;
                        }
                    } else if (panelFeatureState.i != null) {
                        ViewGroup.LayoutParams layoutParams2 = panelFeatureState.i.getLayoutParams();
                        if (layoutParams2 != null && layoutParams2.width == -1) {
                            i2 = -1;
                            panelFeatureState.n = false;
                            WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i2, -2, panelFeatureState.f606d, panelFeatureState.f607e, 1002, 8519680, -3);
                            layoutParams3.gravity = panelFeatureState.f605c;
                            layoutParams3.windowAnimations = panelFeatureState.f608f;
                            windowManager.addView(panelFeatureState.f609g, layoutParams3);
                            panelFeatureState.o = true;
                            return;
                        }
                    }
                    i2 = -2;
                    panelFeatureState.n = false;
                    WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i2, -2, panelFeatureState.f606d, panelFeatureState.f607e, 1002, 8519680, -3);
                    layoutParams32.gravity = panelFeatureState.f605c;
                    layoutParams32.windowAnimations = panelFeatureState.f608f;
                    windowManager.addView(panelFeatureState.f609g, layoutParams32);
                    panelFeatureState.o = true;
                    return;
                }
                return;
            }
            a(panelFeatureState, true);
        }
    }

    private boolean a(PanelFeatureState panelFeatureState) {
        panelFeatureState.a(n());
        panelFeatureState.f609g = new h(panelFeatureState.l);
        panelFeatureState.f605c = 81;
        return true;
    }

    private void a(androidx.appcompat.view.menu.g gVar, boolean z2) {
        x xVar = this.A;
        if (xVar == null || !xVar.e() || (ViewConfiguration.get(this.f589b).hasPermanentMenuKey() && !this.A.g())) {
            PanelFeatureState a2 = a(0, true);
            a2.q = true;
            a(a2, false);
            a(a2, (KeyEvent) null);
            return;
        }
        Window.Callback m2 = m();
        if (this.A.f() && z2) {
            this.A.i();
            if (!this.q) {
                m2.onPanelClosed(108, a(0, true).j);
            }
        } else if (m2 != null && !this.q) {
            if (this.r && (this.s & 1) != 0) {
                this.f590c.getDecorView().removeCallbacks(this.X);
                this.X.run();
            }
            PanelFeatureState a3 = a(0, true);
            if (a3.j != null && !a3.r && m2.onPreparePanel(0, a3.i, a3.j)) {
                m2.onMenuOpened(108, a3.j);
                this.A.h();
            }
        }
    }

    private boolean b(PanelFeatureState panelFeatureState) {
        Context context = this.f589b;
        if ((panelFeatureState.f603a == 0 || panelFeatureState.f603a == 108) && this.A != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(a.C0012a.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(a.C0012a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(a.C0012a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
                dVar.getTheme().setTo(theme2);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
        gVar.a((g.a) this);
        panelFeatureState.a(gVar);
        return true;
    }

    private boolean c(PanelFeatureState panelFeatureState) {
        if (panelFeatureState.i != null) {
            panelFeatureState.h = panelFeatureState.i;
            return true;
        } else if (panelFeatureState.j == null) {
            return false;
        } else {
            if (this.C == null) {
                this.C = new i();
            }
            panelFeatureState.h = (View) panelFeatureState.a((m.a) this.C);
            if (panelFeatureState.h != null) {
                return true;
            }
            return false;
        }
    }

    private boolean b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        if (this.q) {
            return false;
        }
        if (panelFeatureState.m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.M;
        if (!(panelFeatureState2 == null || panelFeatureState2 == panelFeatureState)) {
            a(panelFeatureState2, false);
        }
        Window.Callback m2 = m();
        if (m2 != null) {
            panelFeatureState.i = m2.onCreatePanelView(panelFeatureState.f603a);
        }
        boolean z2 = panelFeatureState.f603a == 0 || panelFeatureState.f603a == 108;
        if (z2) {
            x xVar = this.A;
            if (xVar != null) {
                xVar.j();
            }
        }
        if (panelFeatureState.i == null && (!z2 || !(l() instanceof i))) {
            if (panelFeatureState.j == null || panelFeatureState.r) {
                if (panelFeatureState.j == null && (!b(panelFeatureState) || panelFeatureState.j == null)) {
                    return false;
                }
                if (z2 && this.A != null) {
                    if (this.B == null) {
                        this.B = new b();
                    }
                    this.A.a(panelFeatureState.j, this.B);
                }
                panelFeatureState.j.h();
                if (!m2.onCreatePanelMenu(panelFeatureState.f603a, panelFeatureState.j)) {
                    panelFeatureState.a((androidx.appcompat.view.menu.g) null);
                    if (z2) {
                        x xVar2 = this.A;
                        if (xVar2 != null) {
                            xVar2.a((Menu) null, this.B);
                        }
                    }
                    return false;
                }
                panelFeatureState.r = false;
            }
            panelFeatureState.j.h();
            if (panelFeatureState.s != null) {
                panelFeatureState.j.d(panelFeatureState.s);
                panelFeatureState.s = null;
            }
            if (!m2.onPreparePanel(0, panelFeatureState.i, panelFeatureState.j)) {
                if (z2) {
                    x xVar3 = this.A;
                    if (xVar3 != null) {
                        xVar3.a((Menu) null, this.B);
                    }
                }
                panelFeatureState.j.i();
                return false;
            }
            panelFeatureState.p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.j.setQwertyMode(panelFeatureState.p);
            panelFeatureState.j.i();
        }
        panelFeatureState.m = true;
        panelFeatureState.n = false;
        this.M = panelFeatureState;
        return true;
    }

    /* access modifiers changed from: package-private */
    public void b(androidx.appcompat.view.menu.g gVar) {
        if (!this.K) {
            this.K = true;
            this.A.k();
            Window.Callback m2 = m();
            if (m2 != null && !this.q) {
                m2.onPanelClosed(108, gVar);
            }
            this.K = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void g(int i2) {
        a(a(i2, true), true);
    }

    /* access modifiers changed from: package-private */
    public void a(PanelFeatureState panelFeatureState, boolean z2) {
        if (z2 && panelFeatureState.f603a == 0) {
            x xVar = this.A;
            if (xVar != null && xVar.f()) {
                b(panelFeatureState.j);
                return;
            }
        }
        WindowManager windowManager = (WindowManager) this.f589b.getSystemService("window");
        if (!(windowManager == null || !panelFeatureState.o || panelFeatureState.f609g == null)) {
            windowManager.removeView(panelFeatureState.f609g);
            if (z2) {
                a(panelFeatureState.f603a, panelFeatureState, (Menu) null);
            }
        }
        panelFeatureState.m = false;
        panelFeatureState.n = false;
        panelFeatureState.o = false;
        panelFeatureState.h = null;
        panelFeatureState.q = true;
        if (this.M == panelFeatureState) {
            this.M = null;
        }
    }

    private boolean d(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState a2 = a(i2, true);
        if (!a2.o) {
            return b(a2, keyEvent);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean e(int r4, android.view.KeyEvent r5) {
        /*
            r3 = this;
            androidx.appcompat.view.b r0 = r3.f594g
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            r0 = 1
            androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r2 = r3.a((int) r4, (boolean) r0)
            if (r4 != 0) goto L_0x0043
            androidx.appcompat.widget.x r4 = r3.A
            if (r4 == 0) goto L_0x0043
            boolean r4 = r4.e()
            if (r4 == 0) goto L_0x0043
            android.content.Context r4 = r3.f589b
            android.view.ViewConfiguration r4 = android.view.ViewConfiguration.get(r4)
            boolean r4 = r4.hasPermanentMenuKey()
            if (r4 != 0) goto L_0x0043
            androidx.appcompat.widget.x r4 = r3.A
            boolean r4 = r4.f()
            if (r4 != 0) goto L_0x003c
            boolean r4 = r3.q
            if (r4 != 0) goto L_0x0063
            boolean r4 = r3.b((androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState) r2, (android.view.KeyEvent) r5)
            if (r4 == 0) goto L_0x0063
            androidx.appcompat.widget.x r4 = r3.A
            boolean r4 = r4.h()
            goto L_0x006a
        L_0x003c:
            androidx.appcompat.widget.x r4 = r3.A
            boolean r4 = r4.i()
            goto L_0x006a
        L_0x0043:
            boolean r4 = r2.o
            if (r4 != 0) goto L_0x0065
            boolean r4 = r2.n
            if (r4 == 0) goto L_0x004c
            goto L_0x0065
        L_0x004c:
            boolean r4 = r2.m
            if (r4 == 0) goto L_0x0063
            boolean r4 = r2.r
            if (r4 == 0) goto L_0x005b
            r2.m = r1
            boolean r4 = r3.b((androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState) r2, (android.view.KeyEvent) r5)
            goto L_0x005c
        L_0x005b:
            r4 = 1
        L_0x005c:
            if (r4 == 0) goto L_0x0063
            r3.a((androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState) r2, (android.view.KeyEvent) r5)
            r4 = 1
            goto L_0x006a
        L_0x0063:
            r4 = 0
            goto L_0x006a
        L_0x0065:
            boolean r4 = r2.o
            r3.a((androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState) r2, (boolean) r0)
        L_0x006a:
            if (r4 == 0) goto L_0x0083
            android.content.Context r5 = r3.f589b
            java.lang.String r0 = "audio"
            java.lang.Object r5 = r5.getSystemService(r0)
            android.media.AudioManager r5 = (android.media.AudioManager) r5
            if (r5 == 0) goto L_0x007c
            r5.playSoundEffect(r1)
            goto L_0x0083
        L_0x007c:
            java.lang.String r5 = "AppCompatDelegate"
            java.lang.String r0 = "Couldn't get audio manager"
            android.util.Log.w(r5, r0)
        L_0x0083:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.e(int, android.view.KeyEvent):boolean");
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i2 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.L;
                if (i2 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i2];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.o) && !this.q) {
            this.y.a().onPanelClosed(i2, menu);
        }
    }

    /* access modifiers changed from: package-private */
    public PanelFeatureState a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.L;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i2];
            if (panelFeatureState != null && panelFeatureState.j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public PanelFeatureState a(int i2, boolean z2) {
        PanelFeatureState[] panelFeatureStateArr = this.L;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i2) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[(i2 + 1)];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.L = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i2];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i2);
        panelFeatureStateArr[i2] = panelFeatureState2;
        return panelFeatureState2;
    }

    private boolean a(PanelFeatureState panelFeatureState, int i2, KeyEvent keyEvent, int i3) {
        boolean z2 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.m || b(panelFeatureState, keyEvent)) && panelFeatureState.j != null) {
            z2 = panelFeatureState.j.performShortcut(i2, keyEvent, i3);
        }
        if (z2 && (i3 & 1) == 0 && this.A == null) {
            a(panelFeatureState, true);
        }
        return z2;
    }

    private void k(int i2) {
        this.s = (1 << i2) | this.s;
        if (!this.r) {
            w.a(this.f590c.getDecorView(), this.X);
            this.r = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void h(int i2) {
        PanelFeatureState a2 = a(i2, true);
        if (a2.j != null) {
            Bundle bundle = new Bundle();
            a2.j.c(bundle);
            if (bundle.size() > 0) {
                a2.s = bundle;
            }
            a2.j.h();
            a2.j.clear();
        }
        a2.r = true;
        a2.q = true;
        if ((i2 == 108 || i2 == 0) && this.A != null) {
            PanelFeatureState a3 = a(0, false);
            if (a3 != null) {
                a3.m = false;
                b(a3, (KeyEvent) null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int i(int i2) {
        boolean z2;
        boolean z3;
        boolean z4;
        ActionBarContextView actionBarContextView = this.h;
        int i3 = 0;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z2 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.h.getLayoutParams();
            z2 = true;
            if (this.h.isShown()) {
                if (this.Z == null) {
                    this.Z = new Rect();
                    this.aa = new Rect();
                }
                Rect rect = this.Z;
                Rect rect2 = this.aa;
                rect.set(0, i2, 0, 0);
                ax.a(this.F, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i2 : 0)) {
                    marginLayoutParams.topMargin = i2;
                    View view = this.H;
                    if (view == null) {
                        this.H = new View(this.f589b);
                        this.H.setBackgroundColor(this.f589b.getResources().getColor(a.c.abc_input_method_navigation_guard));
                        this.F.addView(this.H, -1, new ViewGroup.LayoutParams(-1, i2));
                    } else {
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams.height != i2) {
                            layoutParams.height = i2;
                            this.H.setLayoutParams(layoutParams);
                        }
                    }
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (this.H == null) {
                    z2 = false;
                }
                if (!this.n && z2) {
                    i2 = 0;
                }
            } else {
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    z4 = true;
                } else {
                    z4 = false;
                }
                z2 = false;
            }
            if (z3) {
                this.h.setLayoutParams(marginLayoutParams);
            }
        }
        View view2 = this.H;
        if (view2 != null) {
            if (!z2) {
                i3 = 8;
            }
            view2.setVisibility(i3);
        }
        return i2;
    }

    private void D() {
        if (this.E) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private int l(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i2 != 9) {
            return i2;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
    }

    /* access modifiers changed from: package-private */
    public void t() {
        x xVar = this.A;
        if (xVar != null) {
            xVar.k();
        }
        if (this.i != null) {
            this.f590c.getDecorView().removeCallbacks(this.j);
            if (this.i.isShowing()) {
                try {
                    this.i.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.i = null;
        }
        r();
        PanelFeatureState a2 = a(0, false);
        if (a2 != null && a2.j != null) {
            a2.j.close();
        }
    }

    public boolean u() {
        return a(true);
    }

    private boolean a(boolean z2) {
        if (this.q) {
            return false;
        }
        int E2 = E();
        boolean b2 = b(j(E2), z2);
        if (E2 == 0) {
            v().d();
        } else {
            f fVar = this.V;
            if (fVar != null) {
                fVar.e();
            }
        }
        if (E2 == 3) {
            F().d();
        } else {
            f fVar2 = this.W;
            if (fVar2 != null) {
                fVar2.e();
            }
        }
        return b2;
    }

    public int j() {
        return this.R;
    }

    /* access modifiers changed from: package-private */
    public int j(int i2) {
        if (i2 == -100) {
            return -1;
        }
        if (i2 == -1) {
            return i2;
        }
        if (i2 != 0) {
            if (i2 == 1 || i2 == 2) {
                return i2;
            }
            if (i2 == 3) {
                return F().a();
            }
            throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
        } else if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) this.f589b.getSystemService(UiModeManager.class)).getNightMode() != 0) {
            return v().a();
        } else {
            return -1;
        }
    }

    private int E() {
        int i2 = this.R;
        return i2 != -100 ? i2 : k();
    }

    private boolean b(int i2, boolean z2) {
        int i3 = this.f589b.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        boolean z3 = true;
        int i4 = i2 != 1 ? i2 != 2 ? i3 : 32 : 16;
        boolean G2 = G();
        boolean z4 = false;
        if ((x || i4 != i3) && !G2 && Build.VERSION.SDK_INT >= 17 && !this.O && (this.f588a instanceof ContextThemeWrapper)) {
            Configuration configuration = new Configuration();
            configuration.uiMode = (configuration.uiMode & -49) | i4;
            try {
                ((ContextThemeWrapper) this.f588a).applyOverrideConfiguration(configuration);
                z4 = true;
            } catch (IllegalStateException e2) {
                Log.e("AppCompatDelegate", "updateForNightMode. Calling applyOverrideConfiguration() failed with an exception. Will fall back to using Resources.updateConfiguration()", e2);
            }
        }
        int i5 = this.f589b.getResources().getConfiguration().uiMode & 48;
        if (!z4 && i5 != i4 && z2 && !G2 && this.O && (Build.VERSION.SDK_INT >= 17 || this.P)) {
            Object obj = this.f588a;
            if (obj instanceof Activity) {
                androidx.core.app.a.f((Activity) obj);
                z4 = true;
            }
        }
        if (z4 || i5 == i4) {
            z3 = z4;
        } else {
            c(i4, G2);
        }
        if (z3) {
            Object obj2 = this.f588a;
            if (obj2 instanceof d) {
                ((d) obj2).onNightModeChanged(i2);
            }
        }
        return z3;
    }

    private void c(int i2, boolean z2) {
        Resources resources = this.f589b.getResources();
        Configuration configuration = new Configuration(resources.getConfiguration());
        configuration.uiMode = i2 | (resources.getConfiguration().uiMode & -49);
        resources.updateConfiguration(configuration, (DisplayMetrics) null);
        if (Build.VERSION.SDK_INT < 26) {
            h.a(resources);
        }
        int i3 = this.S;
        if (i3 != 0) {
            this.f589b.setTheme(i3);
            if (Build.VERSION.SDK_INT >= 23) {
                this.f589b.getTheme().applyStyle(this.S, true);
            }
        }
        if (z2) {
            Object obj = this.f588a;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof androidx.lifecycle.h) {
                    if (((androidx.lifecycle.h) activity).getLifecycle().a().isAtLeast(e.b.STARTED)) {
                        activity.onConfigurationChanged(configuration);
                    }
                } else if (this.Q) {
                    activity.onConfigurationChanged(configuration);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final f v() {
        if (this.V == null) {
            this.V = new g(k.a(this.f589b));
        }
        return this.V;
    }

    private f F() {
        if (this.W == null) {
            this.W = new e(this.f589b);
        }
        return this.W;
    }

    private boolean G() {
        if (!this.U && (this.f588a instanceof Activity)) {
            PackageManager packageManager = this.f589b.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.f589b, this.f588a.getClass()), 0);
                this.T = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                this.T = false;
            }
        }
        this.U = true;
        return this.T;
    }

    class c implements b.a {

        /* renamed from: b  reason: collision with root package name */
        private b.a f616b;

        public c(b.a aVar) {
            this.f616b = aVar;
        }

        public boolean a(androidx.appcompat.view.b bVar, Menu menu) {
            return this.f616b.a(bVar, menu);
        }

        public boolean b(androidx.appcompat.view.b bVar, Menu menu) {
            return this.f616b.b(bVar, menu);
        }

        public boolean a(androidx.appcompat.view.b bVar, MenuItem menuItem) {
            return this.f616b.a(bVar, menuItem);
        }

        public void a(androidx.appcompat.view.b bVar) {
            this.f616b.a(bVar);
            if (AppCompatDelegateImpl.this.i != null) {
                AppCompatDelegateImpl.this.f590c.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.j);
            }
            if (AppCompatDelegateImpl.this.h != null) {
                AppCompatDelegateImpl.this.r();
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                appCompatDelegateImpl.k = w.n(appCompatDelegateImpl.h).a((float) BitmapDescriptorFactory.HUE_RED);
                AppCompatDelegateImpl.this.k.a((androidx.core.g.ab) new ac() {
                    public void b(View view) {
                        AppCompatDelegateImpl.this.h.setVisibility(8);
                        if (AppCompatDelegateImpl.this.i != null) {
                            AppCompatDelegateImpl.this.i.dismiss();
                        } else if (AppCompatDelegateImpl.this.h.getParent() instanceof View) {
                            w.s((View) AppCompatDelegateImpl.this.h.getParent());
                        }
                        AppCompatDelegateImpl.this.h.removeAllViews();
                        AppCompatDelegateImpl.this.k.a((androidx.core.g.ab) null);
                        AppCompatDelegateImpl.this.k = null;
                    }
                });
            }
            if (AppCompatDelegateImpl.this.f591d != null) {
                AppCompatDelegateImpl.this.f591d.onSupportActionModeFinished(AppCompatDelegateImpl.this.f594g);
            }
            AppCompatDelegateImpl.this.f594g = null;
        }
    }

    private final class i implements m.a {
        i() {
        }

        public void a(androidx.appcompat.view.menu.g gVar, boolean z) {
            androidx.appcompat.view.menu.g q = gVar.q();
            boolean z2 = q != gVar;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z2) {
                gVar = q;
            }
            PanelFeatureState a2 = appCompatDelegateImpl.a((Menu) gVar);
            if (a2 == null) {
                return;
            }
            if (z2) {
                AppCompatDelegateImpl.this.a(a2.f603a, a2, q);
                AppCompatDelegateImpl.this.a(a2, true);
                return;
            }
            AppCompatDelegateImpl.this.a(a2, z);
        }

        public boolean a(androidx.appcompat.view.menu.g gVar) {
            if (gVar != null || !AppCompatDelegateImpl.this.l) {
                return true;
            }
            Window.Callback m = AppCompatDelegateImpl.this.m();
            if (m == null || AppCompatDelegateImpl.this.q) {
                return true;
            }
            m.onMenuOpened(108, gVar);
            return true;
        }
    }

    private final class b implements m.a {
        b() {
        }

        public boolean a(androidx.appcompat.view.menu.g gVar) {
            Window.Callback m = AppCompatDelegateImpl.this.m();
            if (m == null) {
                return true;
            }
            m.onMenuOpened(108, gVar);
            return true;
        }

        public void a(androidx.appcompat.view.menu.g gVar, boolean z) {
            AppCompatDelegateImpl.this.b(gVar);
        }
    }

    protected static final class PanelFeatureState {

        /* renamed from: a  reason: collision with root package name */
        int f603a;

        /* renamed from: b  reason: collision with root package name */
        int f604b;

        /* renamed from: c  reason: collision with root package name */
        int f605c;

        /* renamed from: d  reason: collision with root package name */
        int f606d;

        /* renamed from: e  reason: collision with root package name */
        int f607e;

        /* renamed from: f  reason: collision with root package name */
        int f608f;

        /* renamed from: g  reason: collision with root package name */
        ViewGroup f609g;
        View h;
        View i;
        androidx.appcompat.view.menu.g j;
        androidx.appcompat.view.menu.e k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        Bundle s;

        PanelFeatureState(int i2) {
            this.f603a = i2;
        }

        public boolean a() {
            if (this.h == null) {
                return false;
            }
            if (this.i == null && this.k.a().getCount() <= 0) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public void a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(a.C0012a.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(a.C0012a.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(a.i.Theme_AppCompat_CompactMenu, true);
            }
            androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(a.j.AppCompatTheme);
            this.f604b = obtainStyledAttributes.getResourceId(a.j.AppCompatTheme_panelBackground, 0);
            this.f608f = obtainStyledAttributes.getResourceId(a.j.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public void a(androidx.appcompat.view.menu.g gVar) {
            androidx.appcompat.view.menu.g gVar2 = this.j;
            if (gVar != gVar2) {
                if (gVar2 != null) {
                    gVar2.b((m) this.k);
                }
                this.j = gVar;
                if (gVar != null) {
                    androidx.appcompat.view.menu.e eVar = this.k;
                    if (eVar != null) {
                        gVar.a((m) eVar);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public n a(m.a aVar) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                this.k = new androidx.appcompat.view.menu.e(this.l, a.g.abc_list_menu_item_layout);
                this.k.a(aVar);
                this.j.a((m) this.k);
            }
            return this.k.a(this.f609g);
        }

        @SuppressLint({"BanParcelableUsage"})
        private static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
                /* renamed from: a */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.a(parcel, classLoader);
                }

                /* renamed from: a */
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.a(parcel, (ClassLoader) null);
                }

                /* renamed from: a */
                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }
            };

            /* renamed from: a  reason: collision with root package name */
            int f610a;

            /* renamed from: b  reason: collision with root package name */
            boolean f611b;

            /* renamed from: c  reason: collision with root package name */
            Bundle f612c;

            public int describeContents() {
                return 0;
            }

            SavedState() {
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f610a);
                parcel.writeInt(this.f611b ? 1 : 0);
                if (this.f611b) {
                    parcel.writeBundle(this.f612c);
                }
            }

            static SavedState a(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.f610a = parcel.readInt();
                boolean z = true;
                if (parcel.readInt() != 1) {
                    z = false;
                }
                savedState.f611b = z;
                if (savedState.f611b) {
                    savedState.f612c = parcel.readBundle(classLoader);
                }
                return savedState;
            }
        }
    }

    private class h extends ContentFrameLayout {
        public h(Context context) {
            super(context);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImpl.this.g(0);
            return true;
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(androidx.appcompat.a.a.a.b(getContext(), i));
        }

        private boolean a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }
    }

    class d extends androidx.appcompat.view.i {
        public void onContentChanged() {
        }

        d(Window.Callback callback) {
            super(callback);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.a(keyEvent.getKeyCode(), keyEvent);
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof androidx.appcompat.view.menu.g)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            androidx.appcompat.view.menu.g gVar = menu instanceof androidx.appcompat.view.menu.g ? (androidx.appcompat.view.menu.g) menu : null;
            if (i == 0 && gVar == null) {
                return false;
            }
            if (gVar != null) {
                gVar.c(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (gVar != null) {
                gVar.c(false);
            }
            return onPreparePanel;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            AppCompatDelegateImpl.this.f(i);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            AppCompatDelegateImpl.this.e(i);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (AppCompatDelegateImpl.this.q()) {
                return a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        /* access modifiers changed from: package-private */
        public final ActionMode a(ActionMode.Callback callback) {
            f.a aVar = new f.a(AppCompatDelegateImpl.this.f589b, callback);
            androidx.appcompat.view.b a2 = AppCompatDelegateImpl.this.a((b.a) aVar);
            if (a2 != null) {
                return aVar.b(a2);
            }
            return null;
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (!AppCompatDelegateImpl.this.q() || i != 0) {
                return super.onWindowStartingActionMode(callback, i);
            }
            return a(callback);
        }

        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            PanelFeatureState a2 = AppCompatDelegateImpl.this.a(0, true);
            if (a2 == null || a2.j == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, a2.j, i);
            }
        }
    }

    abstract class f {

        /* renamed from: a  reason: collision with root package name */
        private BroadcastReceiver f621a;

        /* access modifiers changed from: package-private */
        public abstract int a();

        /* access modifiers changed from: package-private */
        public abstract void b();

        /* access modifiers changed from: package-private */
        public abstract IntentFilter c();

        f() {
        }

        /* access modifiers changed from: package-private */
        public void d() {
            e();
            IntentFilter c2 = c();
            if (c2 != null && c2.countActions() != 0) {
                if (this.f621a == null) {
                    this.f621a = new BroadcastReceiver() {
                        public void onReceive(Context context, Intent intent) {
                            f.this.b();
                        }
                    };
                }
                AppCompatDelegateImpl.this.f589b.registerReceiver(this.f621a, c2);
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            if (this.f621a != null) {
                try {
                    AppCompatDelegateImpl.this.f589b.unregisterReceiver(this.f621a);
                } catch (IllegalArgumentException unused) {
                }
                this.f621a = null;
            }
        }
    }

    private class g extends f {

        /* renamed from: c  reason: collision with root package name */
        private final k f625c;

        g(k kVar) {
            super();
            this.f625c = kVar;
        }

        public int a() {
            return this.f625c.a() ? 2 : 1;
        }

        public void b() {
            AppCompatDelegateImpl.this.u();
        }

        /* access modifiers changed from: package-private */
        public IntentFilter c() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }
    }

    private class e extends f {

        /* renamed from: c  reason: collision with root package name */
        private final PowerManager f620c;

        e(Context context) {
            super();
            this.f620c = (PowerManager) context.getSystemService("power");
        }

        public int a() {
            if (Build.VERSION.SDK_INT < 21 || !this.f620c.isPowerSaveMode()) {
                return 1;
            }
            return 2;
        }

        public void b() {
            AppCompatDelegateImpl.this.u();
        }

        /* access modifiers changed from: package-private */
        public IntentFilter c() {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }
    }

    public final b.a h() {
        return new a();
    }

    private class a implements b.a {
        a() {
        }

        public void a(int i) {
            a a2 = AppCompatDelegateImpl.this.a();
            if (a2 != null) {
                a2.a(i);
            }
        }
    }
}
