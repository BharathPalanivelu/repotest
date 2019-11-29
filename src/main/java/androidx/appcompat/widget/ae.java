package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.p;
import androidx.core.g.w;
import androidx.core.widget.h;
import java.lang.reflect.Method;

public class ae implements p {

    /* renamed from: a  reason: collision with root package name */
    private static Method f1076a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f1077b;
    private static Method h;
    private Drawable A;
    private AdapterView.OnItemClickListener B;
    private AdapterView.OnItemSelectedListener C;
    private final d D;
    private final c E;
    private final a F;
    private Runnable G;
    private final Rect H;
    private Rect I;
    private boolean J;

    /* renamed from: c  reason: collision with root package name */
    aa f1078c;

    /* renamed from: d  reason: collision with root package name */
    int f1079d;

    /* renamed from: e  reason: collision with root package name */
    final e f1080e;

    /* renamed from: f  reason: collision with root package name */
    final Handler f1081f;

    /* renamed from: g  reason: collision with root package name */
    PopupWindow f1082g;
    private Context i;
    private ListAdapter j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private int t;
    private boolean u;
    private boolean v;
    private View w;
    private int x;
    private DataSetObserver y;
    private View z;

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            Class<PopupWindow> cls = PopupWindow.class;
            try {
                f1076a = cls.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                h = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            Class<PopupWindow> cls2 = PopupWindow.class;
            try {
                f1077b = cls2.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public ae(Context context) {
        this(context, (AttributeSet) null, a.C0012a.listPopupWindowStyle);
    }

    public ae(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public ae(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.k = -2;
        this.l = -2;
        this.o = 1002;
        this.q = true;
        this.t = 0;
        this.u = false;
        this.v = false;
        this.f1079d = Integer.MAX_VALUE;
        this.x = 0;
        this.f1080e = new e();
        this.D = new d();
        this.E = new c();
        this.F = new a();
        this.H = new Rect();
        this.i = context;
        this.f1081f = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.ListPopupWindow, i2, i3);
        this.m = obtainStyledAttributes.getDimensionPixelOffset(a.j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.n = obtainStyledAttributes.getDimensionPixelOffset(a.j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.n != 0) {
            this.p = true;
        }
        obtainStyledAttributes.recycle();
        this.f1082g = new o(context, attributeSet, i2, i3);
        this.f1082g.setInputMethodMode(1);
    }

    public void a(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.y;
        if (dataSetObserver == null) {
            this.y = new b();
        } else {
            ListAdapter listAdapter2 = this.j;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.j = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.y);
        }
        aa aaVar = this.f1078c;
        if (aaVar != null) {
            aaVar.setAdapter(this.j);
        }
    }

    public void d(int i2) {
        this.x = i2;
    }

    public void a(boolean z2) {
        this.J = z2;
        this.f1082g.setFocusable(z2);
    }

    public boolean j() {
        return this.J;
    }

    public Drawable b() {
        return this.f1082g.getBackground();
    }

    public void a(Drawable drawable) {
        this.f1082g.setBackgroundDrawable(drawable);
    }

    public void e(int i2) {
        this.f1082g.setAnimationStyle(i2);
    }

    public View k() {
        return this.z;
    }

    public void b(View view) {
        this.z = view;
    }

    public int f() {
        return this.m;
    }

    public void b(int i2) {
        this.m = i2;
    }

    public int c() {
        if (!this.p) {
            return 0;
        }
        return this.n;
    }

    public void a(int i2) {
        this.n = i2;
        this.p = true;
    }

    public void a(Rect rect) {
        this.I = rect != null ? new Rect(rect) : null;
    }

    public void f(int i2) {
        this.t = i2;
    }

    public int l() {
        return this.l;
    }

    public void g(int i2) {
        this.l = i2;
    }

    public void h(int i2) {
        Drawable background = this.f1082g.getBackground();
        if (background != null) {
            background.getPadding(this.H);
            this.l = this.H.left + this.H.right + i2;
            return;
        }
        g(i2);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.B = onItemClickListener;
    }

    public void a_() {
        int i2 = i();
        boolean n2 = n();
        h.a(this.f1082g, this.o);
        boolean z2 = true;
        if (!this.f1082g.isShowing()) {
            int i3 = this.l;
            if (i3 == -1) {
                i3 = -1;
            } else if (i3 == -2) {
                i3 = k().getWidth();
            }
            int i4 = this.k;
            if (i4 == -1) {
                i2 = -1;
            } else if (i4 != -2) {
                i2 = i4;
            }
            this.f1082g.setWidth(i3);
            this.f1082g.setHeight(i2);
            c(true);
            this.f1082g.setOutsideTouchable(!this.v && !this.u);
            this.f1082g.setTouchInterceptor(this.D);
            if (this.s) {
                h.a(this.f1082g, this.r);
            }
            if (Build.VERSION.SDK_INT <= 28) {
                Method method = h;
                if (method != null) {
                    try {
                        method.invoke(this.f1082g, new Object[]{this.I});
                    } catch (Exception e2) {
                        Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                    }
                }
            } else {
                this.f1082g.setEpicenterBounds(this.I);
            }
            h.a(this.f1082g, k(), this.m, this.n, this.t);
            this.f1078c.setSelection(-1);
            if (!this.J || this.f1078c.isInTouchMode()) {
                m();
            }
            if (!this.J) {
                this.f1081f.post(this.F);
            }
        } else if (w.D(k())) {
            int i5 = this.l;
            if (i5 == -1) {
                i5 = -1;
            } else if (i5 == -2) {
                i5 = k().getWidth();
            }
            int i6 = this.k;
            if (i6 == -1) {
                if (!n2) {
                    i2 = -1;
                }
                if (n2) {
                    this.f1082g.setWidth(this.l == -1 ? -1 : 0);
                    this.f1082g.setHeight(0);
                } else {
                    this.f1082g.setWidth(this.l == -1 ? -1 : 0);
                    this.f1082g.setHeight(-1);
                }
            } else if (i6 != -2) {
                i2 = i6;
            }
            PopupWindow popupWindow = this.f1082g;
            if (this.v || this.u) {
                z2 = false;
            }
            popupWindow.setOutsideTouchable(z2);
            this.f1082g.update(k(), this.m, this.n, i5 < 0 ? -1 : i5, i2 < 0 ? -1 : i2);
        }
    }

    public void d() {
        this.f1082g.dismiss();
        h();
        this.f1082g.setContentView((View) null);
        this.f1078c = null;
        this.f1081f.removeCallbacks(this.f1080e);
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.f1082g.setOnDismissListener(onDismissListener);
    }

    private void h() {
        View view = this.w;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.w);
            }
        }
    }

    public void i(int i2) {
        this.f1082g.setInputMethodMode(i2);
    }

    public void j(int i2) {
        aa aaVar = this.f1078c;
        if (e() && aaVar != null) {
            aaVar.setListSelectionHidden(false);
            aaVar.setSelection(i2);
            if (aaVar.getChoiceMode() != 0) {
                aaVar.setItemChecked(i2, true);
            }
        }
    }

    public void m() {
        aa aaVar = this.f1078c;
        if (aaVar != null) {
            aaVar.setListSelectionHidden(true);
            aaVar.requestLayout();
        }
    }

    public boolean e() {
        return this.f1082g.isShowing();
    }

    public boolean n() {
        return this.f1082g.getInputMethodMode() == 2;
    }

    public ListView g() {
        return this.f1078c;
    }

    /* access modifiers changed from: package-private */
    public aa a(Context context, boolean z2) {
        return new aa(context, z2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: androidx.appcompat.widget.aa} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v25, resolved type: androidx.appcompat.widget.aa} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: android.widget.LinearLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v30, resolved type: androidx.appcompat.widget.aa} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int i() {
        /*
            r12 = this;
            androidx.appcompat.widget.aa r0 = r12.f1078c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = -1
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x00c1
            android.content.Context r0 = r12.i
            androidx.appcompat.widget.ae$1 r5 = new androidx.appcompat.widget.ae$1
            r5.<init>()
            r12.G = r5
            boolean r5 = r12.J
            r5 = r5 ^ r3
            androidx.appcompat.widget.aa r5 = r12.a(r0, r5)
            r12.f1078c = r5
            android.graphics.drawable.Drawable r5 = r12.A
            if (r5 == 0) goto L_0x0024
            androidx.appcompat.widget.aa r6 = r12.f1078c
            r6.setSelector(r5)
        L_0x0024:
            androidx.appcompat.widget.aa r5 = r12.f1078c
            android.widget.ListAdapter r6 = r12.j
            r5.setAdapter(r6)
            androidx.appcompat.widget.aa r5 = r12.f1078c
            android.widget.AdapterView$OnItemClickListener r6 = r12.B
            r5.setOnItemClickListener(r6)
            androidx.appcompat.widget.aa r5 = r12.f1078c
            r5.setFocusable(r3)
            androidx.appcompat.widget.aa r5 = r12.f1078c
            r5.setFocusableInTouchMode(r3)
            androidx.appcompat.widget.aa r5 = r12.f1078c
            androidx.appcompat.widget.ae$2 r6 = new androidx.appcompat.widget.ae$2
            r6.<init>()
            r5.setOnItemSelectedListener(r6)
            androidx.appcompat.widget.aa r5 = r12.f1078c
            androidx.appcompat.widget.ae$c r6 = r12.E
            r5.setOnScrollListener(r6)
            android.widget.AdapterView$OnItemSelectedListener r5 = r12.C
            if (r5 == 0) goto L_0x0056
            androidx.appcompat.widget.aa r6 = r12.f1078c
            r6.setOnItemSelectedListener(r5)
        L_0x0056:
            androidx.appcompat.widget.aa r5 = r12.f1078c
            android.view.View r6 = r12.w
            if (r6 == 0) goto L_0x00ba
            android.widget.LinearLayout r7 = new android.widget.LinearLayout
            r7.<init>(r0)
            r7.setOrientation(r3)
            android.widget.LinearLayout$LayoutParams r0 = new android.widget.LinearLayout$LayoutParams
            r8 = 1065353216(0x3f800000, float:1.0)
            r0.<init>(r2, r4, r8)
            int r8 = r12.x
            if (r8 == 0) goto L_0x0091
            if (r8 == r3) goto L_0x008a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "Invalid hint position "
            r0.append(r5)
            int r5 = r12.x
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.String r5 = "ListPopupWindow"
            android.util.Log.e(r5, r0)
            goto L_0x0097
        L_0x008a:
            r7.addView(r5, r0)
            r7.addView(r6)
            goto L_0x0097
        L_0x0091:
            r7.addView(r6)
            r7.addView(r5, r0)
        L_0x0097:
            int r0 = r12.l
            if (r0 < 0) goto L_0x009e
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x00a0
        L_0x009e:
            r0 = 0
            r5 = 0
        L_0x00a0:
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r5)
            r6.measure(r0, r4)
            android.view.ViewGroup$LayoutParams r0 = r6.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r5 = r6.getMeasuredHeight()
            int r6 = r0.topMargin
            int r5 = r5 + r6
            int r0 = r0.bottomMargin
            int r5 = r5 + r0
            r0 = r5
            r5 = r7
            goto L_0x00bb
        L_0x00ba:
            r0 = 0
        L_0x00bb:
            android.widget.PopupWindow r6 = r12.f1082g
            r6.setContentView(r5)
            goto L_0x00df
        L_0x00c1:
            android.widget.PopupWindow r0 = r12.f1082g
            android.view.View r0 = r0.getContentView()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.view.View r0 = r12.w
            if (r0 == 0) goto L_0x00de
            android.view.ViewGroup$LayoutParams r5 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r5 = (android.widget.LinearLayout.LayoutParams) r5
            int r0 = r0.getMeasuredHeight()
            int r6 = r5.topMargin
            int r0 = r0 + r6
            int r5 = r5.bottomMargin
            int r0 = r0 + r5
            goto L_0x00df
        L_0x00de:
            r0 = 0
        L_0x00df:
            android.widget.PopupWindow r5 = r12.f1082g
            android.graphics.drawable.Drawable r5 = r5.getBackground()
            if (r5 == 0) goto L_0x0101
            android.graphics.Rect r6 = r12.H
            r5.getPadding(r6)
            android.graphics.Rect r5 = r12.H
            int r5 = r5.top
            android.graphics.Rect r6 = r12.H
            int r6 = r6.bottom
            int r5 = r5 + r6
            boolean r6 = r12.p
            if (r6 != 0) goto L_0x0107
            android.graphics.Rect r6 = r12.H
            int r6 = r6.top
            int r6 = -r6
            r12.n = r6
            goto L_0x0107
        L_0x0101:
            android.graphics.Rect r5 = r12.H
            r5.setEmpty()
            r5 = 0
        L_0x0107:
            android.widget.PopupWindow r6 = r12.f1082g
            int r6 = r6.getInputMethodMode()
            r7 = 2
            if (r6 != r7) goto L_0x0111
            goto L_0x0112
        L_0x0111:
            r3 = 0
        L_0x0112:
            android.view.View r4 = r12.k()
            int r6 = r12.n
            int r3 = r12.a(r4, r6, r3)
            boolean r4 = r12.u
            if (r4 != 0) goto L_0x0188
            int r4 = r12.k
            if (r4 != r2) goto L_0x0125
            goto L_0x0188
        L_0x0125:
            int r4 = r12.l
            r6 = -2
            if (r4 == r6) goto L_0x014f
            r1 = 1073741824(0x40000000, float:2.0)
            if (r4 == r2) goto L_0x0134
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r1)
        L_0x0132:
            r7 = r1
            goto L_0x016a
        L_0x0134:
            android.content.Context r2 = r12.i
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.graphics.Rect r4 = r12.H
            int r4 = r4.left
            android.graphics.Rect r6 = r12.H
            int r6 = r6.right
            int r4 = r4 + r6
            int r2 = r2 - r4
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
            goto L_0x0132
        L_0x014f:
            android.content.Context r2 = r12.i
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.graphics.Rect r4 = r12.H
            int r4 = r4.left
            android.graphics.Rect r6 = r12.H
            int r6 = r6.right
            int r4 = r4 + r6
            int r2 = r2 - r4
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
            goto L_0x0132
        L_0x016a:
            androidx.appcompat.widget.aa r6 = r12.f1078c
            r8 = 0
            r9 = -1
            int r10 = r3 - r0
            r11 = -1
            int r1 = r6.a(r7, r8, r9, r10, r11)
            if (r1 <= 0) goto L_0x0186
            androidx.appcompat.widget.aa r2 = r12.f1078c
            int r2 = r2.getPaddingTop()
            androidx.appcompat.widget.aa r3 = r12.f1078c
            int r3 = r3.getPaddingBottom()
            int r2 = r2 + r3
            int r5 = r5 + r2
            int r0 = r0 + r5
        L_0x0186:
            int r1 = r1 + r0
            return r1
        L_0x0188:
            int r3 = r3 + r5
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ae.i():int");
    }

    public void b(boolean z2) {
        this.s = true;
        this.r = z2;
    }

    private class b extends DataSetObserver {
        b() {
        }

        public void onChanged() {
            if (ae.this.e()) {
                ae.this.a_();
            }
        }

        public void onInvalidated() {
            ae.this.d();
        }
    }

    private class a implements Runnable {
        a() {
        }

        public void run() {
            ae.this.m();
        }
    }

    private class e implements Runnable {
        e() {
        }

        public void run() {
            if (ae.this.f1078c != null && w.D(ae.this.f1078c) && ae.this.f1078c.getCount() > ae.this.f1078c.getChildCount() && ae.this.f1078c.getChildCount() <= ae.this.f1079d) {
                ae.this.f1082g.setInputMethodMode(2);
                ae.this.a_();
            }
        }
    }

    private class d implements View.OnTouchListener {
        d() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && ae.this.f1082g != null && ae.this.f1082g.isShowing() && x >= 0 && x < ae.this.f1082g.getWidth() && y >= 0 && y < ae.this.f1082g.getHeight()) {
                ae.this.f1081f.postDelayed(ae.this.f1080e, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                ae.this.f1081f.removeCallbacks(ae.this.f1080e);
                return false;
            }
        }
    }

    private class c implements AbsListView.OnScrollListener {
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        c() {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !ae.this.n() && ae.this.f1082g.getContentView() != null) {
                ae.this.f1081f.removeCallbacks(ae.this.f1080e);
                ae.this.f1080e.run();
            }
        }
    }

    private void c(boolean z2) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f1076a;
            if (method != null) {
                try {
                    method.invoke(this.f1082g, new Object[]{Boolean.valueOf(z2)});
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            this.f1082g.setIsClippedToScreen(z2);
        }
    }

    private int a(View view, int i2, boolean z2) {
        if (Build.VERSION.SDK_INT > 23) {
            return this.f1082g.getMaxAvailableHeight(view, i2, z2);
        }
        Method method = f1077b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.f1082g, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z2)})).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.f1082g.getMaxAvailableHeight(view, i2);
    }
}
