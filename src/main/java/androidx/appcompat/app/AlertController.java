package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.widget.ad;
import androidx.core.g.w;
import androidx.core.widget.NestedScrollView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.ref.WeakReference;

class AlertController {
    private int A;
    private boolean B = false;
    private CharSequence C;
    private Drawable D;
    private CharSequence E;
    private Drawable F;
    private CharSequence G;
    private Drawable H;
    private int I = 0;
    private Drawable J;
    private ImageView K;
    private TextView L;
    private TextView M;
    private View N;
    private int O;
    private int P;
    private boolean Q;
    private int R = 0;
    private final View.OnClickListener S = new View.OnClickListener() {
        public void onClick(View view) {
            Message message;
            if (view == AlertController.this.f548c && AlertController.this.f549d != null) {
                message = Message.obtain(AlertController.this.f549d);
            } else if (view != AlertController.this.f550e || AlertController.this.f551f == null) {
                message = (view != AlertController.this.f552g || AlertController.this.h == null) ? null : Message.obtain(AlertController.this.h);
            } else {
                message = Message.obtain(AlertController.this.f551f);
            }
            if (message != null) {
                message.sendToTarget();
            }
            AlertController.this.p.obtainMessage(1, AlertController.this.f546a).sendToTarget();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final g f546a;

    /* renamed from: b  reason: collision with root package name */
    ListView f547b;

    /* renamed from: c  reason: collision with root package name */
    Button f548c;

    /* renamed from: d  reason: collision with root package name */
    Message f549d;

    /* renamed from: e  reason: collision with root package name */
    Button f550e;

    /* renamed from: f  reason: collision with root package name */
    Message f551f;

    /* renamed from: g  reason: collision with root package name */
    Button f552g;
    Message h;
    NestedScrollView i;
    ListAdapter j;
    int k = -1;
    int l;
    int m;
    int n;
    int o;
    Handler p;
    private final Context q;
    private final Window r;
    private final int s;
    private CharSequence t;
    private CharSequence u;
    private View v;
    private int w;
    private int x;
    private int y;
    private int z;

    private static final class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<DialogInterface> f587a;

        public b(DialogInterface dialogInterface) {
            this.f587a = new WeakReference<>(dialogInterface);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == -3 || i == -2 || i == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f587a.get(), message.what);
            } else if (i == 1) {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    private static boolean a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(a.C0012a.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            return true;
        }
        return false;
    }

    public AlertController(Context context, g gVar, Window window) {
        this.q = context;
        this.f546a = gVar;
        this.r = window;
        this.p = new b(gVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, a.j.AlertDialog, a.C0012a.alertDialogStyle, 0);
        this.O = obtainStyledAttributes.getResourceId(a.j.AlertDialog_android_layout, 0);
        this.P = obtainStyledAttributes.getResourceId(a.j.AlertDialog_buttonPanelSideLayout, 0);
        this.l = obtainStyledAttributes.getResourceId(a.j.AlertDialog_listLayout, 0);
        this.m = obtainStyledAttributes.getResourceId(a.j.AlertDialog_multiChoiceItemLayout, 0);
        this.n = obtainStyledAttributes.getResourceId(a.j.AlertDialog_singleChoiceItemLayout, 0);
        this.o = obtainStyledAttributes.getResourceId(a.j.AlertDialog_listItemLayout, 0);
        this.Q = obtainStyledAttributes.getBoolean(a.j.AlertDialog_showTitle, true);
        this.s = obtainStyledAttributes.getDimensionPixelSize(a.j.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        gVar.a(1);
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public void a() {
        this.f546a.setContentView(c());
        d();
    }

    private int c() {
        int i2 = this.P;
        if (i2 == 0) {
            return this.O;
        }
        if (this.R == 1) {
            return i2;
        }
        return this.O;
    }

    public void a(CharSequence charSequence) {
        this.t = charSequence;
        TextView textView = this.L;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void b(View view) {
        this.N = view;
    }

    public void b(CharSequence charSequence) {
        this.u = charSequence;
        TextView textView = this.M;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void a(int i2) {
        this.v = null;
        this.w = i2;
        this.B = false;
    }

    public void c(View view) {
        this.v = view;
        this.w = 0;
        this.B = false;
    }

    public void a(View view, int i2, int i3, int i4, int i5) {
        this.v = view;
        this.w = 0;
        this.B = true;
        this.x = i2;
        this.y = i3;
        this.z = i4;
        this.A = i5;
    }

    public void a(int i2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.p.obtainMessage(i2, onClickListener);
        }
        if (i2 == -3) {
            this.G = charSequence;
            this.h = message;
            this.H = drawable;
        } else if (i2 == -2) {
            this.E = charSequence;
            this.f551f = message;
            this.F = drawable;
        } else if (i2 == -1) {
            this.C = charSequence;
            this.f549d = message;
            this.D = drawable;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void b(int i2) {
        this.J = null;
        this.I = i2;
        ImageView imageView = this.K;
        if (imageView == null) {
            return;
        }
        if (i2 != 0) {
            imageView.setVisibility(0);
            this.K.setImageResource(this.I);
            return;
        }
        imageView.setVisibility(8);
    }

    public void a(Drawable drawable) {
        this.J = drawable;
        this.I = 0;
        ImageView imageView = this.K;
        if (imageView == null) {
            return;
        }
        if (drawable != null) {
            imageView.setVisibility(0);
            this.K.setImageDrawable(drawable);
            return;
        }
        imageView.setVisibility(8);
    }

    public int c(int i2) {
        TypedValue typedValue = new TypedValue();
        this.q.getTheme().resolveAttribute(i2, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView b() {
        return this.f547b;
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.i;
        return nestedScrollView != null && nestedScrollView.a(keyEvent);
    }

    public boolean b(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.i;
        return nestedScrollView != null && nestedScrollView.a(keyEvent);
    }

    private ViewGroup a(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private void d() {
        View findViewById = this.r.findViewById(a.f.parentPanel);
        View findViewById2 = findViewById.findViewById(a.f.topPanel);
        View findViewById3 = findViewById.findViewById(a.f.contentPanel);
        View findViewById4 = findViewById.findViewById(a.f.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(a.f.customPanel);
        a(viewGroup);
        View findViewById5 = viewGroup.findViewById(a.f.topPanel);
        View findViewById6 = viewGroup.findViewById(a.f.contentPanel);
        View findViewById7 = viewGroup.findViewById(a.f.buttonPanel);
        ViewGroup a2 = a(findViewById5, findViewById2);
        ViewGroup a3 = a(findViewById6, findViewById3);
        ViewGroup a4 = a(findViewById7, findViewById4);
        c(a3);
        d(a4);
        b(a2);
        char c2 = 0;
        boolean z2 = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z3 = (a2 == null || a2.getVisibility() == 8) ? false : true;
        boolean z4 = (a4 == null || a4.getVisibility() == 8) ? false : true;
        if (!z4 && a3 != null) {
            View findViewById8 = a3.findViewById(a.f.textSpacerNoButtons);
            if (findViewById8 != null) {
                findViewById8.setVisibility(0);
            }
        }
        if (z3) {
            NestedScrollView nestedScrollView = this.i;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View view = null;
            if (!(this.u == null && this.f547b == null)) {
                view = a2.findViewById(a.f.titleDividerNoCustom);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (a3 != null) {
            View findViewById9 = a3.findViewById(a.f.textSpacerNoTitle);
            if (findViewById9 != null) {
                findViewById9.setVisibility(0);
            }
        }
        ListView listView = this.f547b;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z3, z4);
        }
        if (!z2) {
            View view2 = this.f547b;
            if (view2 == null) {
                view2 = this.i;
            }
            if (view2 != null) {
                if (z4) {
                    c2 = 2;
                }
                a(a3, view2, z3 | c2 ? 1 : 0, 3);
            }
        }
        ListView listView2 = this.f547b;
        if (listView2 != null) {
            ListAdapter listAdapter = this.j;
            if (listAdapter != null) {
                listView2.setAdapter(listAdapter);
                int i2 = this.k;
                if (i2 > -1) {
                    listView2.setItemChecked(i2, true);
                    listView2.setSelection(i2);
                }
            }
        }
    }

    private void a(ViewGroup viewGroup, View view, int i2, int i3) {
        final View findViewById = this.r.findViewById(a.f.scrollIndicatorUp);
        View findViewById2 = this.r.findViewById(a.f.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            w.a(view, i2, i3);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        final View view2 = null;
        if (findViewById != null && (i2 & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 == null || (i2 & 2) != 0) {
            view2 = findViewById2;
        } else {
            viewGroup.removeView(findViewById2);
        }
        if (findViewById != null || view2 != null) {
            if (this.u != null) {
                this.i.setOnScrollChangeListener(new NestedScrollView.b() {
                    public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                        AlertController.a(nestedScrollView, findViewById, view2);
                    }
                });
                this.i.post(new Runnable() {
                    public void run() {
                        AlertController.a(AlertController.this.i, findViewById, view2);
                    }
                });
                return;
            }
            ListView listView = this.f547b;
            if (listView != null) {
                listView.setOnScrollListener(new AbsListView.OnScrollListener() {
                    public void onScrollStateChanged(AbsListView absListView, int i) {
                    }

                    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                        AlertController.a(absListView, findViewById, view2);
                    }
                });
                this.f547b.post(new Runnable() {
                    public void run() {
                        AlertController.a(AlertController.this.f547b, findViewById, view2);
                    }
                });
                return;
            }
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (view2 != null) {
                viewGroup.removeView(view2);
            }
        }
    }

    private void a(ViewGroup viewGroup) {
        View view = this.v;
        boolean z2 = false;
        if (view == null) {
            view = this.w != 0 ? LayoutInflater.from(this.q).inflate(this.w, viewGroup, false) : null;
        }
        if (view != null) {
            z2 = true;
        }
        if (!z2 || !a(view)) {
            this.r.setFlags(131072, 131072);
        }
        if (z2) {
            FrameLayout frameLayout = (FrameLayout) this.r.findViewById(a.f.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.B) {
                frameLayout.setPadding(this.x, this.y, this.z, this.A);
            }
            if (this.f547b != null) {
                ((ad.a) viewGroup.getLayoutParams()).f1075g = BitmapDescriptorFactory.HUE_RED;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void b(ViewGroup viewGroup) {
        if (this.N != null) {
            viewGroup.addView(this.N, 0, new ViewGroup.LayoutParams(-1, -2));
            this.r.findViewById(a.f.title_template).setVisibility(8);
            return;
        }
        this.K = (ImageView) this.r.findViewById(16908294);
        if (!(!TextUtils.isEmpty(this.t)) || !this.Q) {
            this.r.findViewById(a.f.title_template).setVisibility(8);
            this.K.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        this.L = (TextView) this.r.findViewById(a.f.alertTitle);
        this.L.setText(this.t);
        int i2 = this.I;
        if (i2 != 0) {
            this.K.setImageResource(i2);
            return;
        }
        Drawable drawable = this.J;
        if (drawable != null) {
            this.K.setImageDrawable(drawable);
            return;
        }
        this.L.setPadding(this.K.getPaddingLeft(), this.K.getPaddingTop(), this.K.getPaddingRight(), this.K.getPaddingBottom());
        this.K.setVisibility(8);
    }

    private void c(ViewGroup viewGroup) {
        this.i = (NestedScrollView) this.r.findViewById(a.f.scrollView);
        this.i.setFocusable(false);
        this.i.setNestedScrollingEnabled(false);
        this.M = (TextView) viewGroup.findViewById(16908299);
        TextView textView = this.M;
        if (textView != null) {
            CharSequence charSequence = this.u;
            if (charSequence != null) {
                textView.setText(charSequence);
                return;
            }
            textView.setVisibility(8);
            this.i.removeView(this.M);
            if (this.f547b != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.i.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.i);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f547b, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    static void a(View view, View view2, View view3) {
        int i2 = 0;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!view.canScrollVertically(1)) {
                i2 = 4;
            }
            view3.setVisibility(i2);
        }
    }

    private void d(ViewGroup viewGroup) {
        boolean z2;
        this.f548c = (Button) viewGroup.findViewById(16908313);
        this.f548c.setOnClickListener(this.S);
        boolean z3 = true;
        if (!TextUtils.isEmpty(this.C) || this.D != null) {
            this.f548c.setText(this.C);
            Drawable drawable = this.D;
            if (drawable != null) {
                int i2 = this.s;
                drawable.setBounds(0, 0, i2, i2);
                this.f548c.setCompoundDrawables(this.D, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f548c.setVisibility(0);
            z2 = true;
        } else {
            this.f548c.setVisibility(8);
            z2 = false;
        }
        this.f550e = (Button) viewGroup.findViewById(16908314);
        this.f550e.setOnClickListener(this.S);
        if (!TextUtils.isEmpty(this.E) || this.F != null) {
            this.f550e.setText(this.E);
            Drawable drawable2 = this.F;
            if (drawable2 != null) {
                int i3 = this.s;
                drawable2.setBounds(0, 0, i3, i3);
                this.f550e.setCompoundDrawables(this.F, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f550e.setVisibility(0);
            z2 |= true;
        } else {
            this.f550e.setVisibility(8);
        }
        this.f552g = (Button) viewGroup.findViewById(16908315);
        this.f552g.setOnClickListener(this.S);
        if (!TextUtils.isEmpty(this.G) || this.H != null) {
            this.f552g.setText(this.G);
            Drawable drawable3 = this.D;
            if (drawable3 != null) {
                int i4 = this.s;
                drawable3.setBounds(0, 0, i4, i4);
                this.f548c.setCompoundDrawables(this.D, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f552g.setVisibility(0);
            z2 |= true;
        } else {
            this.f552g.setVisibility(8);
        }
        if (a(this.q)) {
            if (z2) {
                a(this.f548c);
            } else if (z2) {
                a(this.f550e);
            } else if (z2) {
                a(this.f552g);
            }
        }
        if (!z2) {
            z3 = false;
        }
        if (!z3) {
            viewGroup.setVisibility(8);
        }
    }

    private void a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    public static class RecycleListView extends ListView {

        /* renamed from: a  reason: collision with root package name */
        private final int f566a;

        /* renamed from: b  reason: collision with root package name */
        private final int f567b;

        public RecycleListView(Context context) {
            this(context, (AttributeSet) null);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.RecycleListView);
            this.f567b = obtainStyledAttributes.getDimensionPixelOffset(a.j.RecycleListView_paddingBottomNoButtons, -1);
            this.f566a = obtainStyledAttributes.getDimensionPixelOffset(a.j.RecycleListView_paddingTopNoTitle, -1);
        }

        public void a(boolean z, boolean z2) {
            if (!z2 || !z) {
                setPadding(getPaddingLeft(), z ? getPaddingTop() : this.f566a, getPaddingRight(), z2 ? getPaddingBottom() : this.f567b);
            }
        }
    }

    public static class a {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean E = false;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public int I = -1;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;
        public C0014a O;
        public boolean P = true;

        /* renamed from: a  reason: collision with root package name */
        public final Context f568a;

        /* renamed from: b  reason: collision with root package name */
        public final LayoutInflater f569b;

        /* renamed from: c  reason: collision with root package name */
        public int f570c = 0;

        /* renamed from: d  reason: collision with root package name */
        public Drawable f571d;

        /* renamed from: e  reason: collision with root package name */
        public int f572e = 0;

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f573f;

        /* renamed from: g  reason: collision with root package name */
        public View f574g;
        public CharSequence h;
        public CharSequence i;
        public Drawable j;
        public DialogInterface.OnClickListener k;
        public CharSequence l;
        public Drawable m;
        public DialogInterface.OnClickListener n;
        public CharSequence o;
        public Drawable p;
        public DialogInterface.OnClickListener q;
        public boolean r;
        public DialogInterface.OnCancelListener s;
        public DialogInterface.OnDismissListener t;
        public DialogInterface.OnKeyListener u;
        public CharSequence[] v;
        public ListAdapter w;
        public DialogInterface.OnClickListener x;
        public int y;
        public View z;

        /* renamed from: androidx.appcompat.app.AlertController$a$a  reason: collision with other inner class name */
        public interface C0014a {
            void a(ListView listView);
        }

        public a(Context context) {
            this.f568a = context;
            this.r = true;
            this.f569b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void a(AlertController alertController) {
            View view = this.f574g;
            if (view != null) {
                alertController.b(view);
            } else {
                CharSequence charSequence = this.f573f;
                if (charSequence != null) {
                    alertController.a(charSequence);
                }
                Drawable drawable = this.f571d;
                if (drawable != null) {
                    alertController.a(drawable);
                }
                int i2 = this.f570c;
                if (i2 != 0) {
                    alertController.b(i2);
                }
                int i3 = this.f572e;
                if (i3 != 0) {
                    alertController.b(alertController.c(i3));
                }
            }
            CharSequence charSequence2 = this.h;
            if (charSequence2 != null) {
                alertController.b(charSequence2);
            }
            if (!(this.i == null && this.j == null)) {
                alertController.a(-1, this.i, this.k, (Message) null, this.j);
            }
            if (!(this.l == null && this.m == null)) {
                alertController.a(-2, this.l, this.n, (Message) null, this.m);
            }
            if (!(this.o == null && this.p == null)) {
                alertController.a(-3, this.o, this.q, (Message) null, this.p);
            }
            if (!(this.v == null && this.K == null && this.w == null)) {
                b(alertController);
            }
            View view2 = this.z;
            if (view2 == null) {
                int i4 = this.y;
                if (i4 != 0) {
                    alertController.a(i4);
                }
            } else if (this.E) {
                alertController.a(view2, this.A, this.B, this.C, this.D);
            } else {
                alertController.c(view2);
            }
        }

        /* JADX WARNING: type inference failed for: r9v0, types: [android.widget.ListAdapter] */
        /* JADX WARNING: type inference failed for: r9v3 */
        /* JADX WARNING: type inference failed for: r9v4 */
        /* JADX WARNING: type inference failed for: r2v6, types: [android.widget.SimpleCursorAdapter] */
        /* JADX WARNING: type inference failed for: r1v19, types: [androidx.appcompat.app.AlertController$a$2] */
        /* JADX WARNING: type inference failed for: r1v20, types: [androidx.appcompat.app.AlertController$a$1] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void b(final androidx.appcompat.app.AlertController r12) {
            /*
                r11 = this;
                android.view.LayoutInflater r0 = r11.f569b
                int r1 = r12.l
                r2 = 0
                android.view.View r0 = r0.inflate(r1, r2)
                androidx.appcompat.app.AlertController$RecycleListView r0 = (androidx.appcompat.app.AlertController.RecycleListView) r0
                boolean r1 = r11.G
                r8 = 1
                if (r1 == 0) goto L_0x0033
                android.database.Cursor r4 = r11.K
                if (r4 != 0) goto L_0x0026
                androidx.appcompat.app.AlertController$a$1 r9 = new androidx.appcompat.app.AlertController$a$1
                android.content.Context r3 = r11.f568a
                int r4 = r12.m
                r5 = 16908308(0x1020014, float:2.3877285E-38)
                java.lang.CharSequence[] r6 = r11.v
                r1 = r9
                r2 = r11
                r7 = r0
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x0067
            L_0x0026:
                androidx.appcompat.app.AlertController$a$2 r9 = new androidx.appcompat.app.AlertController$a$2
                android.content.Context r3 = r11.f568a
                r5 = 0
                r1 = r9
                r2 = r11
                r6 = r0
                r7 = r12
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x0067
            L_0x0033:
                boolean r1 = r11.H
                if (r1 == 0) goto L_0x003a
                int r1 = r12.n
                goto L_0x003c
            L_0x003a:
                int r1 = r12.o
            L_0x003c:
                r4 = r1
                android.database.Cursor r5 = r11.K
                r1 = 16908308(0x1020014, float:2.3877285E-38)
                if (r5 == 0) goto L_0x0059
                android.widget.SimpleCursorAdapter r9 = new android.widget.SimpleCursorAdapter
                android.content.Context r3 = r11.f568a
                java.lang.String[] r6 = new java.lang.String[r8]
                java.lang.String r2 = r11.L
                r7 = 0
                r6[r7] = r2
                int[] r10 = new int[r8]
                r10[r7] = r1
                r2 = r9
                r7 = r10
                r2.<init>(r3, r4, r5, r6, r7)
                goto L_0x0067
            L_0x0059:
                android.widget.ListAdapter r9 = r11.w
                if (r9 == 0) goto L_0x005e
                goto L_0x0067
            L_0x005e:
                androidx.appcompat.app.AlertController$c r9 = new androidx.appcompat.app.AlertController$c
                android.content.Context r2 = r11.f568a
                java.lang.CharSequence[] r3 = r11.v
                r9.<init>(r2, r4, r1, r3)
            L_0x0067:
                androidx.appcompat.app.AlertController$a$a r1 = r11.O
                if (r1 == 0) goto L_0x006e
                r1.a(r0)
            L_0x006e:
                r12.j = r9
                int r1 = r11.I
                r12.k = r1
                android.content.DialogInterface$OnClickListener r1 = r11.x
                if (r1 == 0) goto L_0x0081
                androidx.appcompat.app.AlertController$a$3 r1 = new androidx.appcompat.app.AlertController$a$3
                r1.<init>(r12)
                r0.setOnItemClickListener(r1)
                goto L_0x008d
            L_0x0081:
                android.content.DialogInterface$OnMultiChoiceClickListener r1 = r11.J
                if (r1 == 0) goto L_0x008d
                androidx.appcompat.app.AlertController$a$4 r1 = new androidx.appcompat.app.AlertController$a$4
                r1.<init>(r0, r12)
                r0.setOnItemClickListener(r1)
            L_0x008d:
                android.widget.AdapterView$OnItemSelectedListener r1 = r11.N
                if (r1 == 0) goto L_0x0094
                r0.setOnItemSelectedListener(r1)
            L_0x0094:
                boolean r1 = r11.H
                if (r1 == 0) goto L_0x009c
                r0.setChoiceMode(r8)
                goto L_0x00a4
            L_0x009c:
                boolean r1 = r11.G
                if (r1 == 0) goto L_0x00a4
                r1 = 2
                r0.setChoiceMode(r1)
            L_0x00a4:
                r12.f547b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AlertController.a.b(androidx.appcompat.app.AlertController):void");
        }
    }

    private static class c extends ArrayAdapter<CharSequence> {
        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }

        public c(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }
    }
}
