package com.afollestad.materialdialogs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import com.afollestad.materialdialogs.g;
import com.afollestad.materialdialogs.internal.MDButton;
import com.afollestad.materialdialogs.internal.MDRootLayout;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class f extends c implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: b  reason: collision with root package name */
    protected final a f3148b;

    /* renamed from: c  reason: collision with root package name */
    protected ListView f3149c;

    /* renamed from: d  reason: collision with root package name */
    protected ImageView f3150d;

    /* renamed from: e  reason: collision with root package name */
    protected TextView f3151e;

    /* renamed from: f  reason: collision with root package name */
    protected View f3152f;

    /* renamed from: g  reason: collision with root package name */
    protected FrameLayout f3153g;
    protected ProgressBar h;
    protected TextView i;
    protected TextView j;
    protected TextView k;
    protected EditText l;
    protected TextView m;
    protected MDButton n;
    protected MDButton o;
    protected MDButton p;
    protected g q;
    protected List<Integer> r;
    private final Handler s = new Handler();

    public interface c {
        void a(f fVar, CharSequence charSequence);
    }

    public interface d {
        void a(f fVar, View view, int i, CharSequence charSequence);
    }

    public interface e {
        boolean a(f fVar, Integer[] numArr, CharSequence[] charSequenceArr);
    }

    /* renamed from: com.afollestad.materialdialogs.f$f  reason: collision with other inner class name */
    public interface C0065f {
        boolean a(f fVar, View view, int i, CharSequence charSequence);
    }

    public /* bridge */ /* synthetic */ View findViewById(int i2) {
        return super.findViewById(i2);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ void setContentView(int i2) throws IllegalAccessError {
        super.setContentView(i2);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ void setContentView(View view) throws IllegalAccessError {
        super.setContentView(view);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ void setContentView(View view, ViewGroup.LayoutParams layoutParams) throws IllegalAccessError {
        super.setContentView(view, layoutParams);
    }

    public final a b() {
        return this.f3148b;
    }

    @SuppressLint({"InflateParams"})
    protected f(a aVar) {
        super(aVar.f3160a, d.a(aVar));
        this.f3148b = aVar;
        this.f3144a = (MDRootLayout) LayoutInflater.from(aVar.f3160a).inflate(d.b(aVar), (ViewGroup) null);
        d.a(this);
        if (aVar.f3160a.getResources().getBoolean(g.b.md_is_tablet)) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(getWindow().getAttributes());
            layoutParams.width = aVar.f3160a.getResources().getDimensionPixelSize(g.d.md_default_dialog_width);
            getWindow().setAttributes(layoutParams);
        }
    }

    public final void a(TextView textView, Typeface typeface) {
        if (typeface != null) {
            textView.setPaintFlags(textView.getPaintFlags() | 128);
            textView.setTypeface(typeface);
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        ListView listView = this.f3149c;
        if (listView != null) {
            listView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    int i;
                    if (Build.VERSION.SDK_INT < 16) {
                        f.this.f3149c.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    } else {
                        f.this.f3149c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                    if (f.this.q == g.SINGLE || f.this.q == g.MULTI) {
                        if (f.this.q == g.SINGLE) {
                            if (f.this.f3148b.D >= 0) {
                                i = f.this.f3148b.D;
                            } else {
                                return;
                            }
                        } else if (f.this.r != null && f.this.r.size() != 0) {
                            Collections.sort(f.this.r);
                            i = f.this.r.get(0).intValue();
                        } else {
                            return;
                        }
                        if (f.this.f3149c.getLastVisiblePosition() < i) {
                            final int lastVisiblePosition = i - ((f.this.f3149c.getLastVisiblePosition() - f.this.f3149c.getFirstVisiblePosition()) / 2);
                            if (lastVisiblePosition < 0) {
                                lastVisiblePosition = 0;
                            }
                            f.this.f3149c.post(new Runnable() {
                                public void run() {
                                    f.this.f3149c.requestFocus();
                                    f.this.f3149c.setSelection(lastVisiblePosition);
                                }
                            });
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public final void d() {
        if (this.f3149c != null) {
            if ((this.f3148b.k != null && this.f3148b.k.length != 0) || this.f3148b.L != null) {
                this.f3149c.setAdapter(this.f3148b.L);
                if (this.q != null || this.f3148b.x != null) {
                    this.f3149c.setOnItemClickListener(this);
                }
            }
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        boolean z;
        if (this.f3148b.x != null) {
            CharSequence charSequence = null;
            if (view instanceof TextView) {
                charSequence = ((TextView) view).getText();
            }
            this.f3148b.x.a(this, view, i2, charSequence);
            return;
        }
        g gVar = this.q;
        if (gVar == null || gVar == g.REGULAR) {
            if (this.f3148b.F) {
                dismiss();
            }
            this.f3148b.u.a(this, view, i2, this.f3148b.k[i2]);
        } else if (this.q == g.MULTI) {
            boolean z2 = !this.r.contains(Integer.valueOf(i2));
            CheckBox checkBox = (CheckBox) view.findViewById(g.f.control);
            if (z2) {
                this.r.add(Integer.valueOf(i2));
                if (!this.f3148b.y) {
                    checkBox.setChecked(true);
                } else if (h()) {
                    checkBox.setChecked(true);
                } else {
                    this.r.remove(Integer.valueOf(i2));
                }
            } else {
                this.r.remove(Integer.valueOf(i2));
                checkBox.setChecked(false);
                if (this.f3148b.y) {
                    h();
                }
            }
        } else if (this.q == g.SINGLE) {
            a aVar = (a) this.f3148b.L;
            RadioButton radioButton = (RadioButton) view.findViewById(g.f.control);
            if (this.f3148b.F && this.f3148b.l == null) {
                dismiss();
                this.f3148b.D = i2;
                b(view);
                z = false;
            } else if (this.f3148b.z) {
                int i3 = this.f3148b.D;
                this.f3148b.D = i2;
                z = b(view);
                this.f3148b.D = i3;
            } else {
                z = true;
            }
            if (z && this.f3148b.D != i2) {
                this.f3148b.D = i2;
                if (aVar.f3132a == null) {
                    aVar.f3133b = true;
                    aVar.notifyDataSetChanged();
                }
                if (aVar.f3132a != null) {
                    aVar.f3132a.setChecked(false);
                }
                radioButton.setChecked(true);
                aVar.f3132a = radioButton;
            }
        }
    }

    public static class h extends Error {
        public h(String str) {
            super(str);
        }
    }

    /* access modifiers changed from: protected */
    public final Drawable e() {
        if (this.f3148b.at != 0) {
            return androidx.core.content.a.f.a(this.f3148b.f3160a.getResources(), this.f3148b.at, (Resources.Theme) null);
        }
        Drawable d2 = com.afollestad.materialdialogs.a.a.d(this.f3148b.f3160a, g.a.md_list_selector);
        if (d2 != null) {
            return d2;
        }
        return com.afollestad.materialdialogs.a.a.d(getContext(), g.a.md_list_selector);
    }

    /* access modifiers changed from: package-private */
    public Drawable a(b bVar, boolean z) {
        if (!z) {
            int i2 = AnonymousClass3.f3158a[bVar.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (this.f3148b.av != 0) {
                        return androidx.core.content.a.f.a(this.f3148b.f3160a.getResources(), this.f3148b.av, (Resources.Theme) null);
                    }
                    Drawable d2 = com.afollestad.materialdialogs.a.a.d(this.f3148b.f3160a, g.a.md_btn_positive_selector);
                    if (d2 != null) {
                        return d2;
                    }
                    return com.afollestad.materialdialogs.a.a.d(getContext(), g.a.md_btn_positive_selector);
                } else if (this.f3148b.ax != 0) {
                    return androidx.core.content.a.f.a(this.f3148b.f3160a.getResources(), this.f3148b.ax, (Resources.Theme) null);
                } else {
                    Drawable d3 = com.afollestad.materialdialogs.a.a.d(this.f3148b.f3160a, g.a.md_btn_negative_selector);
                    if (d3 != null) {
                        return d3;
                    }
                    return com.afollestad.materialdialogs.a.a.d(getContext(), g.a.md_btn_negative_selector);
                }
            } else if (this.f3148b.aw != 0) {
                return androidx.core.content.a.f.a(this.f3148b.f3160a.getResources(), this.f3148b.aw, (Resources.Theme) null);
            } else {
                Drawable d4 = com.afollestad.materialdialogs.a.a.d(this.f3148b.f3160a, g.a.md_btn_neutral_selector);
                if (d4 != null) {
                    return d4;
                }
                return com.afollestad.materialdialogs.a.a.d(getContext(), g.a.md_btn_neutral_selector);
            }
        } else if (this.f3148b.au != 0) {
            return androidx.core.content.a.f.a(this.f3148b.f3160a.getResources(), this.f3148b.au, (Resources.Theme) null);
        } else {
            Drawable d5 = com.afollestad.materialdialogs.a.a.d(this.f3148b.f3160a, g.a.md_btn_stacked_selector);
            if (d5 != null) {
                return d5;
            }
            return com.afollestad.materialdialogs.a.a.d(getContext(), g.a.md_btn_stacked_selector);
        }
    }

    private boolean b(View view) {
        return this.f3148b.v.a(this, view, this.f3148b.D, this.f3148b.D >= 0 ? this.f3148b.k[this.f3148b.D] : null);
    }

    private boolean h() {
        Collections.sort(this.r);
        ArrayList arrayList = new ArrayList();
        for (Integer intValue : this.r) {
            arrayList.add(this.f3148b.k[intValue.intValue()]);
        }
        e eVar = this.f3148b.w;
        List<Integer> list = this.r;
        return eVar.a(this, (Integer[]) list.toArray(new Integer[list.size()]), (CharSequence[]) arrayList.toArray(new CharSequence[arrayList.size()]));
    }

    public final void onClick(View view) {
        int i2 = AnonymousClass3.f3158a[((b) view.getTag()).ordinal()];
        if (i2 == 1) {
            if (this.f3148b.t != null) {
                this.f3148b.t.onAny(this);
                this.f3148b.t.onNeutral(this);
            }
            if (this.f3148b.F) {
                dismiss();
            }
        } else if (i2 == 2) {
            if (this.f3148b.t != null) {
                this.f3148b.t.onAny(this);
                this.f3148b.t.onNegative(this);
            }
            if (this.f3148b.F) {
                dismiss();
            }
        } else if (i2 == 3) {
            if (this.f3148b.t != null) {
                this.f3148b.t.onAny(this);
                this.f3148b.t.onPositive(this);
            }
            if (this.f3148b.v != null) {
                b(view);
            }
            if (this.f3148b.w != null) {
                h();
            }
            if (!(this.f3148b.ab == null || this.l == null || this.f3148b.ae)) {
                this.f3148b.ab.a(this, this.l.getText());
            }
            if (this.f3148b.F) {
                dismiss();
            }
        }
    }

    public static class a {
        protected h A = h.LIGHT;
        protected boolean B = true;
        protected float C = 1.2f;
        protected int D = -1;
        protected Integer[] E = null;
        protected boolean F = true;
        protected Typeface G;
        protected Typeface H;
        protected Drawable I;
        protected boolean J;
        protected int K = -1;
        protected ListAdapter L;
        protected DialogInterface.OnDismissListener M;
        protected DialogInterface.OnCancelListener N;
        protected DialogInterface.OnKeyListener O;
        protected DialogInterface.OnShowListener P;
        protected boolean Q;
        protected boolean R;
        protected int S;
        protected int T;
        protected int U;
        protected boolean V;
        protected boolean W;
        protected int X = -2;
        protected int Y = 0;
        protected CharSequence Z;

        /* renamed from: a  reason: collision with root package name */
        protected final Context f3160a;
        protected CharSequence aa;
        protected c ab;
        protected boolean ac;
        protected int ad = -1;
        protected boolean ae;
        protected int af = -1;
        protected int ag = -1;
        protected int ah = 0;
        protected String ai;
        protected NumberFormat aj;
        protected boolean ak;
        protected boolean al = false;
        protected boolean am = false;
        protected boolean an = false;
        protected boolean ao = false;
        protected boolean ap = false;
        protected boolean aq = false;
        protected boolean ar = false;
        protected boolean as = false;
        protected int at;
        protected int au;
        protected int av;
        protected int aw;
        protected int ax;

        /* renamed from: b  reason: collision with root package name */
        protected CharSequence f3161b;

        /* renamed from: c  reason: collision with root package name */
        protected e f3162c = e.START;

        /* renamed from: d  reason: collision with root package name */
        protected e f3163d = e.START;

        /* renamed from: e  reason: collision with root package name */
        protected e f3164e = e.END;

        /* renamed from: f  reason: collision with root package name */
        protected e f3165f = e.START;

        /* renamed from: g  reason: collision with root package name */
        protected e f3166g = e.START;
        protected int h = -1;
        protected int i = -1;
        protected CharSequence j;
        protected CharSequence[] k;
        protected CharSequence l;
        protected CharSequence m;
        protected CharSequence n;
        protected View o;
        protected int p;
        protected ColorStateList q;
        protected ColorStateList r;
        protected ColorStateList s;
        protected b t;
        protected d u;
        protected C0065f v;
        protected e w;
        protected d x;
        protected boolean y = false;
        protected boolean z = false;

        public final Context a() {
            return this.f3160a;
        }

        public a(Context context) {
            this.f3160a = context;
            this.p = com.afollestad.materialdialogs.a.a.a(context, g.a.colorAccent, context.getResources().getColor(g.c.md_material_blue_600));
            if (Build.VERSION.SDK_INT >= 21) {
                this.p = com.afollestad.materialdialogs.a.a.a(context, 16843829, this.p);
            }
            this.q = com.afollestad.materialdialogs.a.a.g(context, this.p);
            this.r = com.afollestad.materialdialogs.a.a.g(context, this.p);
            this.s = com.afollestad.materialdialogs.a.a.g(context, this.p);
            this.aj = NumberFormat.getPercentInstance();
            this.ai = "%1d/%2d";
            this.A = com.afollestad.materialdialogs.a.a.a(com.afollestad.materialdialogs.a.a.b(context, 16842806)) ? h.LIGHT : h.DARK;
            d();
            this.f3162c = com.afollestad.materialdialogs.a.a.a(context, g.a.md_title_gravity, this.f3162c);
            this.f3163d = com.afollestad.materialdialogs.a.a.a(context, g.a.md_content_gravity, this.f3163d);
            this.f3164e = com.afollestad.materialdialogs.a.a.a(context, g.a.md_btnstacked_gravity, this.f3164e);
            this.f3165f = com.afollestad.materialdialogs.a.a.a(context, g.a.md_items_gravity, this.f3165f);
            this.f3166g = com.afollestad.materialdialogs.a.a.a(context, g.a.md_buttons_gravity, this.f3166g);
            a(com.afollestad.materialdialogs.a.a.c(context, g.a.md_medium_font), com.afollestad.materialdialogs.a.a.c(context, g.a.md_regular_font));
            if (this.H == null) {
                try {
                    if (Build.VERSION.SDK_INT >= 21) {
                        this.H = Typeface.create("sans-serif-medium", 0);
                    } else {
                        this.H = Typeface.create("sans-serif", 1);
                    }
                } catch (Exception unused) {
                }
            }
            if (this.G == null) {
                try {
                    this.G = Typeface.create("sans-serif", 0);
                } catch (Exception unused2) {
                }
            }
        }

        private void d() {
            if (com.afollestad.materialdialogs.internal.c.a(false) != null) {
                com.afollestad.materialdialogs.internal.c a2 = com.afollestad.materialdialogs.internal.c.a();
                if (a2.f3188a) {
                    this.A = h.DARK;
                }
                if (a2.f3189b != 0) {
                    this.h = a2.f3189b;
                }
                if (a2.f3190c != 0) {
                    this.i = a2.f3190c;
                }
                if (a2.f3191d != null) {
                    this.q = a2.f3191d;
                }
                if (a2.f3192e != null) {
                    this.s = a2.f3192e;
                }
                if (a2.f3193f != null) {
                    this.r = a2.f3193f;
                }
                if (a2.h != 0) {
                    this.U = a2.h;
                }
                if (a2.i != null) {
                    this.I = a2.i;
                }
                if (a2.j != 0) {
                    this.T = a2.j;
                }
                if (a2.k != 0) {
                    this.S = a2.k;
                }
                if (a2.m != 0) {
                    this.au = a2.m;
                }
                if (a2.l != 0) {
                    this.at = a2.l;
                }
                if (a2.n != 0) {
                    this.av = a2.n;
                }
                if (a2.o != 0) {
                    this.aw = a2.o;
                }
                if (a2.p != 0) {
                    this.ax = a2.p;
                }
                if (a2.f3194g != 0) {
                    this.p = a2.f3194g;
                }
                this.f3162c = a2.q;
                this.f3163d = a2.r;
                this.f3164e = a2.s;
                this.f3165f = a2.t;
                this.f3166g = a2.u;
            }
        }

        public a a(int i2) {
            a(this.f3160a.getText(i2));
            return this;
        }

        public a a(CharSequence charSequence) {
            this.f3161b = charSequence;
            return this;
        }

        public a a(String str, String str2) {
            if (str != null) {
                this.H = com.afollestad.materialdialogs.a.b.a(this.f3160a, str);
                if (this.H == null) {
                    throw new IllegalArgumentException("No font asset found for " + str);
                }
            }
            if (str2 != null) {
                this.G = com.afollestad.materialdialogs.a.b.a(this.f3160a, str2);
                if (this.G == null) {
                    throw new IllegalArgumentException("No font asset found for " + str2);
                }
            }
            return this;
        }

        public a b(int i2) {
            this.I = androidx.core.content.a.f.a(this.f3160a.getResources(), i2, (Resources.Theme) null);
            return this;
        }

        public a c(int i2) {
            b(this.f3160a.getText(i2));
            return this;
        }

        public a b(CharSequence charSequence) {
            if (this.o == null) {
                this.j = charSequence;
                return this;
            }
            throw new IllegalStateException("You cannot set content() when you're using a custom view.");
        }

        public a a(CharSequence[] charSequenceArr) {
            if (this.o == null) {
                this.k = charSequenceArr;
                return this;
            }
            throw new IllegalStateException("You cannot set items() when you're using a custom view.");
        }

        public a a(d dVar) {
            this.u = dVar;
            this.v = null;
            this.w = null;
            return this;
        }

        public a a(int i2, C0065f fVar) {
            this.D = i2;
            this.u = null;
            this.v = fVar;
            this.w = null;
            return this;
        }

        public a d(int i2) {
            c(this.f3160a.getText(i2));
            return this;
        }

        public a c(CharSequence charSequence) {
            this.l = charSequence;
            return this;
        }

        public a e(int i2) {
            return a(com.afollestad.materialdialogs.a.a.g(this.f3160a, i2));
        }

        public a a(ColorStateList colorStateList) {
            this.q = colorStateList;
            this.ao = true;
            return this;
        }

        public a f(int i2) {
            return d(this.f3160a.getText(i2));
        }

        public a d(CharSequence charSequence) {
            this.m = charSequence;
            return this;
        }

        public a g(int i2) {
            return b(com.afollestad.materialdialogs.a.a.g(this.f3160a, i2));
        }

        public a b(ColorStateList colorStateList) {
            this.r = colorStateList;
            this.aq = true;
            return this;
        }

        public a h(int i2) {
            return e(this.f3160a.getText(i2));
        }

        public a e(CharSequence charSequence) {
            this.n = charSequence;
            return this;
        }

        public a i(int i2) {
            return c(com.afollestad.materialdialogs.a.a.g(this.f3160a, i2));
        }

        public a c(ColorStateList colorStateList) {
            this.s = colorStateList;
            this.ap = true;
            return this;
        }

        public a a(View view, boolean z2) {
            if (this.j != null) {
                throw new IllegalStateException("You cannot use customView() when you have content set.");
            } else if (this.k != null) {
                throw new IllegalStateException("You cannot use customView() when you have items set.");
            } else if (this.ab != null) {
                throw new IllegalStateException("You cannot use customView() with an input dialog");
            } else if (this.X > -2 || this.V) {
                throw new IllegalStateException("You cannot use customView() with a progress dialog");
            } else {
                if (view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                this.o = view;
                this.R = z2;
                return this;
            }
        }

        public a j(int i2) {
            this.T = i2;
            return this;
        }

        public a k(int i2) {
            return j(this.f3160a.getResources().getColor(i2));
        }

        public a a(b bVar) {
            this.t = bVar;
            return this;
        }

        public a a(boolean z2) {
            this.B = z2;
            return this;
        }

        public a b(boolean z2) {
            this.F = z2;
            return this;
        }

        public a a(DialogInterface.OnDismissListener onDismissListener) {
            this.M = onDismissListener;
            return this;
        }

        public a a(DialogInterface.OnCancelListener onCancelListener) {
            this.N = onCancelListener;
            return this;
        }

        public f b() {
            return new f(this);
        }

        public f c() {
            f b2 = b();
            b2.show();
            return b2;
        }
    }

    public void show() {
        try {
            super.show();
        } catch (WindowManager.BadTokenException unused) {
        }
    }

    public final MDButton a(b bVar) {
        int i2 = AnonymousClass3.f3158a[bVar.ordinal()];
        if (i2 == 1) {
            return this.o;
        }
        if (i2 != 2) {
            return this.n;
        }
        return this.p;
    }

    public final EditText f() {
        return this.l;
    }

    public final void setTitle(CharSequence charSequence) {
        this.f3151e.setText(charSequence);
    }

    public final void setTitle(int i2) {
        setTitle((CharSequence) this.f3148b.f3160a.getString(i2));
    }

    public final void onShow(DialogInterface dialogInterface) {
        if (this.l != null) {
            com.afollestad.materialdialogs.a.a.a((DialogInterface) this, this.f3148b);
            if (this.l.getText().length() > 0) {
                EditText editText = this.l;
                editText.setSelection(editText.getText().length());
            }
        }
        super.onShow(dialogInterface);
    }

    /* access modifiers changed from: protected */
    public void g() {
        EditText editText = this.l;
        if (editText != null) {
            editText.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable editable) {
                }

                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    int length = charSequence.toString().length();
                    boolean z = false;
                    if (!f.this.f3148b.ac) {
                        if (length == 0) {
                            z = true;
                        }
                        f.this.a(b.POSITIVE).setEnabled(!z);
                    }
                    f.this.a(length, z);
                    if (f.this.f3148b.ae) {
                        f.this.f3148b.ab.a(f.this, charSequence);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i2, boolean z) {
        TextView textView = this.m;
        if (textView != null) {
            boolean z2 = false;
            textView.setText(String.format("%d/%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(this.f3148b.ag)}));
            if ((z && i2 == 0) || i2 > this.f3148b.ag || i2 < this.f3148b.af) {
                z2 = true;
            }
            int i3 = z2 ? this.f3148b.ah : this.f3148b.i;
            int i4 = z2 ? this.f3148b.ah : this.f3148b.p;
            this.m.setTextColor(i3);
            com.afollestad.materialdialogs.internal.b.a(this.l, i4);
            a(b.POSITIVE).setEnabled(!z2);
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        if (this.l != null) {
            com.afollestad.materialdialogs.a.a.b((DialogInterface) this, this.f3148b);
        }
    }

    /* renamed from: com.afollestad.materialdialogs.f$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3158a = new int[b.values().length];

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f3159b = new int[g.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0047 */
        static {
            /*
                com.afollestad.materialdialogs.f$g[] r0 = com.afollestad.materialdialogs.f.g.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3159b = r0
                r0 = 1
                int[] r1 = f3159b     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.afollestad.materialdialogs.f$g r2 = com.afollestad.materialdialogs.f.g.REGULAR     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f3159b     // Catch:{ NoSuchFieldError -> 0x001f }
                com.afollestad.materialdialogs.f$g r3 = com.afollestad.materialdialogs.f.g.SINGLE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f3159b     // Catch:{ NoSuchFieldError -> 0x002a }
                com.afollestad.materialdialogs.f$g r4 = com.afollestad.materialdialogs.f.g.MULTI     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.afollestad.materialdialogs.b[] r3 = com.afollestad.materialdialogs.b.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f3158a = r3
                int[] r3 = f3158a     // Catch:{ NoSuchFieldError -> 0x003d }
                com.afollestad.materialdialogs.b r4 = com.afollestad.materialdialogs.b.NEUTRAL     // Catch:{ NoSuchFieldError -> 0x003d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                int[] r0 = f3158a     // Catch:{ NoSuchFieldError -> 0x0047 }
                com.afollestad.materialdialogs.b r3 = com.afollestad.materialdialogs.b.NEGATIVE     // Catch:{ NoSuchFieldError -> 0x0047 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0047 }
            L_0x0047:
                int[] r0 = f3158a     // Catch:{ NoSuchFieldError -> 0x0051 }
                com.afollestad.materialdialogs.b r1 = com.afollestad.materialdialogs.b.POSITIVE     // Catch:{ NoSuchFieldError -> 0x0051 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0051 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0051 }
            L_0x0051:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.f.AnonymousClass3.<clinit>():void");
        }
    }

    protected enum g {
        REGULAR,
        SINGLE,
        MULTI;

        public static int getLayoutForType(g gVar) {
            int i = AnonymousClass3.f3159b[gVar.ordinal()];
            if (i == 1) {
                return g.C0066g.md_listitem;
            }
            if (i == 2) {
                return g.C0066g.md_listitem_singlechoice;
            }
            if (i == 3) {
                return g.C0066g.md_listitem_multichoice;
            }
            throw new IllegalArgumentException("Not a valid list type");
        }
    }

    public static abstract class b {
        public void onAny(f fVar) {
        }

        public void onNegative(f fVar) {
        }

        public void onNeutral(f fVar) {
        }

        public void onPositive(f fVar) {
        }

        /* access modifiers changed from: protected */
        public final Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public final boolean equals(Object obj) {
            return super.equals(obj);
        }

        /* access modifiers changed from: protected */
        public final void finalize() throws Throwable {
            super.finalize();
        }

        public final int hashCode() {
            return super.hashCode();
        }

        public final String toString() {
            return super.toString();
        }
    }
}
