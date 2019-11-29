package com.afollestad.materialdialogs.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.a.a;
import com.afollestad.materialdialogs.e;
import com.afollestad.materialdialogs.f;
import com.afollestad.materialdialogs.g;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class MDRootLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private View f3172a;

    /* renamed from: b  reason: collision with root package name */
    private View f3173b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f3174c = false;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f3175d = false;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final MDButton[] f3176e = new MDButton[3];

    /* renamed from: f  reason: collision with root package name */
    private boolean f3177f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3178g = false;
    private boolean h = true;
    private boolean i;
    private boolean j;
    private int k;
    private int l;
    private int m;
    private e n = e.START;
    private int o;
    private Paint p;
    private ViewTreeObserver.OnScrollChangedListener q;
    private ViewTreeObserver.OnScrollChangedListener r;
    private int s;

    public MDRootLayout(Context context) {
        super(context);
        a(context, (AttributeSet) null, 0);
    }

    public MDRootLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    @TargetApi(11)
    public MDRootLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet, i2);
    }

    @TargetApi(21)
    public MDRootLayout(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context, attributeSet, i2);
    }

    private void a(Context context, AttributeSet attributeSet, int i2) {
        Resources resources = context.getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.i.MDRootLayout, i2, 0);
        this.i = obtainStyledAttributes.getBoolean(g.i.MDRootLayout_md_reduce_padding_no_title_no_buttons, true);
        obtainStyledAttributes.recycle();
        this.k = resources.getDimensionPixelSize(g.d.md_notitle_vertical_padding);
        this.l = resources.getDimensionPixelSize(g.d.md_button_frame_vertical_padding);
        this.o = resources.getDimensionPixelSize(g.d.md_button_padding_frame_side);
        this.m = resources.getDimensionPixelSize(g.d.md_button_height);
        this.p = new Paint();
        this.s = resources.getDimensionPixelSize(g.d.md_divider_height);
        this.p.setColor(a.b(context, g.a.md_divider_color));
        setWillNotDraw(false);
    }

    public void a() {
        this.j = true;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getId() == g.f.titleFrame) {
                this.f3172a = childAt;
            } else if (childAt.getId() == g.f.buttonDefaultNeutral) {
                this.f3176e[0] = (MDButton) childAt;
            } else if (childAt.getId() == g.f.buttonDefaultNegative) {
                this.f3176e[1] = (MDButton) childAt;
            } else if (childAt.getId() == g.f.buttonDefaultPositive) {
                this.f3176e[2] = (MDButton) childAt;
            } else {
                this.f3173b = childAt;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0103  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r12, int r13) {
        /*
            r11 = this;
            int r0 = android.view.View.MeasureSpec.getSize(r12)
            int r1 = android.view.View.MeasureSpec.getSize(r13)
            r2 = 1
            r11.h = r2
            boolean r3 = r11.f3177f
            r4 = 0
            if (r3 != 0) goto L_0x0049
            com.afollestad.materialdialogs.internal.MDButton[] r3 = r11.f3176e
            int r5 = r3.length
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x0016:
            if (r6 >= r5) goto L_0x0031
            r9 = r3[r6]
            if (r9 == 0) goto L_0x002e
            boolean r10 = a((android.view.View) r9)
            if (r10 == 0) goto L_0x002e
            r9.a(r4, r4)
            r11.measureChild(r9, r12, r13)
            int r8 = r9.getMeasuredWidth()
            int r7 = r7 + r8
            r8 = 1
        L_0x002e:
            int r6 = r6 + 1
            goto L_0x0016
        L_0x0031:
            android.content.Context r3 = r11.getContext()
            android.content.res.Resources r3 = r3.getResources()
            int r5 = com.afollestad.materialdialogs.g.d.md_neutral_button_margin
            int r3 = r3.getDimensionPixelSize(r5)
            int r3 = r3 * 2
            int r3 = r0 - r3
            if (r7 <= r3) goto L_0x0047
            r3 = 1
            goto L_0x004b
        L_0x0047:
            r3 = 0
            goto L_0x004b
        L_0x0049:
            r3 = 1
            r8 = 0
        L_0x004b:
            r11.f3178g = r3
            if (r3 == 0) goto L_0x006f
            com.afollestad.materialdialogs.internal.MDButton[] r3 = r11.f3176e
            int r5 = r3.length
            r6 = 0
            r7 = 0
        L_0x0054:
            if (r6 >= r5) goto L_0x0070
            r9 = r3[r6]
            if (r9 == 0) goto L_0x006c
            boolean r10 = a((android.view.View) r9)
            if (r10 == 0) goto L_0x006c
            r9.a(r2, r4)
            r11.measureChild(r9, r12, r13)
            int r8 = r9.getMeasuredHeight()
            int r7 = r7 + r8
            r8 = 1
        L_0x006c:
            int r6 = r6 + 1
            goto L_0x0054
        L_0x006f:
            r7 = 0
        L_0x0070:
            if (r8 == 0) goto L_0x008c
            boolean r12 = r11.f3178g
            if (r12 == 0) goto L_0x0081
            int r12 = r1 - r7
            int r13 = r11.l
            int r3 = r13 * 2
            int r3 = r3 + r4
            int r13 = r13 * 2
            int r13 = r13 + r4
            goto L_0x0094
        L_0x0081:
            int r12 = r11.m
            int r12 = r1 - r12
            int r13 = r11.l
            int r13 = r13 * 2
            int r3 = r13 + 0
            goto L_0x0093
        L_0x008c:
            int r12 = r11.l
            int r12 = r12 * 2
            int r3 = r12 + 0
            r12 = r1
        L_0x0093:
            r13 = 0
        L_0x0094:
            android.view.View r5 = r11.f3172a
            boolean r5 = a((android.view.View) r5)
            r6 = 1073741824(0x40000000, float:2.0)
            if (r5 == 0) goto L_0x00af
            android.view.View r5 = r11.f3172a
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r6)
            r5.measure(r7, r4)
            android.view.View r5 = r11.f3172a
            int r5 = r5.getMeasuredHeight()
            int r12 = r12 - r5
            goto L_0x00b6
        L_0x00af:
            boolean r5 = r11.j
            if (r5 != 0) goto L_0x00b6
            int r5 = r11.k
            int r3 = r3 + r5
        L_0x00b6:
            android.view.View r5 = r11.f3173b
            boolean r5 = a((android.view.View) r5)
            if (r5 == 0) goto L_0x0103
            android.view.View r5 = r11.f3173b
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r6)
            int r7 = r12 - r13
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r9)
            r5.measure(r6, r7)
            android.view.View r5 = r11.f3173b
            int r5 = r5.getMeasuredHeight()
            int r6 = r12 - r3
            if (r5 > r6) goto L_0x0100
            boolean r5 = r11.i
            if (r5 == 0) goto L_0x00f4
            android.view.View r5 = r11.f3172a
            boolean r5 = a((android.view.View) r5)
            if (r5 != 0) goto L_0x00f4
            if (r8 == 0) goto L_0x00e8
            goto L_0x00f4
        L_0x00e8:
            r11.h = r4
            android.view.View r2 = r11.f3173b
            int r2 = r2.getMeasuredHeight()
            int r2 = r2 + r13
            int r4 = r12 - r2
            goto L_0x0104
        L_0x00f4:
            r11.h = r2
            android.view.View r13 = r11.f3173b
            int r13 = r13.getMeasuredHeight()
            int r13 = r13 + r3
            int r4 = r12 - r13
            goto L_0x0104
        L_0x0100:
            r11.h = r4
            goto L_0x0104
        L_0x0103:
            r4 = r12
        L_0x0104:
            int r1 = r1 - r4
            r11.setMeasuredDimension(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.internal.MDRootLayout.onMeasure(int, int):void");
    }

    private static boolean a(View view) {
        boolean z = (view == null || view.getVisibility() == 8) ? false : true;
        if (!z || !(view instanceof MDButton)) {
            return z;
        }
        return ((MDButton) view).getText().toString().trim().length() > 0;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        View view = this.f3173b;
        if (view != null) {
            if (this.f3174c) {
                int top = view.getTop();
                canvas.drawRect(BitmapDescriptorFactory.HUE_RED, (float) (top - this.s), (float) getMeasuredWidth(), (float) top, this.p);
            }
            if (this.f3175d) {
                int bottom = this.f3173b.getBottom();
                canvas.drawRect(BitmapDescriptorFactory.HUE_RED, (float) bottom, (float) getMeasuredWidth(), (float) (bottom + this.s), this.p);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        if (a(this.f3172a)) {
            int measuredHeight = this.f3172a.getMeasuredHeight() + i3;
            this.f3172a.layout(i2, i3, i4, measuredHeight);
            i3 = measuredHeight;
        } else if (!this.j && this.h) {
            i3 += this.k;
        }
        if (a(this.f3173b)) {
            View view = this.f3173b;
            view.layout(i2, i3, i4, view.getMeasuredHeight() + i3);
        }
        if (this.f3178g) {
            int i15 = i5 - this.l;
            for (MDButton mDButton : this.f3176e) {
                if (a((View) mDButton)) {
                    mDButton.layout(i2, i15 - mDButton.getMeasuredHeight(), i4, i15);
                    i15 -= mDButton.getMeasuredHeight();
                }
            }
        } else {
            if (this.h) {
                i5 -= this.l;
            }
            int i16 = i5 - this.m;
            int i17 = this.o;
            if (a((View) this.f3176e[2])) {
                if (this.n == e.END) {
                    i14 = i2 + i17;
                    i13 = this.f3176e[2].getMeasuredWidth() + i14;
                    i6 = -1;
                } else {
                    i13 = i4 - i17;
                    i14 = i13 - this.f3176e[2].getMeasuredWidth();
                    i6 = i14;
                }
                this.f3176e[2].layout(i14, i16, i13, i5);
                i17 += this.f3176e[2].getMeasuredWidth();
            } else {
                i6 = -1;
            }
            if (a((View) this.f3176e[1])) {
                if (this.n == e.END) {
                    i12 = i17 + i2;
                    i11 = this.f3176e[1].getMeasuredWidth() + i12;
                } else if (this.n == e.START) {
                    i11 = i4 - i17;
                    i12 = i11 - this.f3176e[1].getMeasuredWidth();
                } else {
                    i12 = this.o + i2;
                    i11 = this.f3176e[1].getMeasuredWidth() + i12;
                    i7 = i11;
                    this.f3176e[1].layout(i12, i16, i11, i5);
                }
                i7 = -1;
                this.f3176e[1].layout(i12, i16, i11, i5);
            } else {
                i7 = -1;
            }
            if (a((View) this.f3176e[0])) {
                if (this.n == e.END) {
                    i8 = i4 - this.o;
                    i9 = i8 - this.f3176e[0].getMeasuredWidth();
                } else if (this.n == e.START) {
                    i9 = i2 + this.o;
                    i8 = this.f3176e[0].getMeasuredWidth() + i9;
                } else {
                    if (i7 != -1 || i6 == -1) {
                        if (i6 == -1 && i7 != -1) {
                            i10 = this.f3176e[0].getMeasuredWidth();
                        } else if (i6 == -1) {
                            i7 = ((i4 - i2) / 2) - (this.f3176e[0].getMeasuredWidth() / 2);
                            i10 = this.f3176e[0].getMeasuredWidth();
                        }
                        i6 = i7 + i10;
                    } else {
                        i7 = i6 - this.f3176e[0].getMeasuredWidth();
                    }
                    i9 = i7;
                    i8 = i6;
                }
                this.f3176e[0].layout(i9, i16, i8, i5);
            }
        }
        a(this.f3173b, true, true);
    }

    public void setForceStack(boolean z) {
        this.f3177f = z;
        invalidate();
    }

    public void setDividerColor(int i2) {
        this.p.setColor(i2);
        invalidate();
    }

    public void setButtonGravity(e eVar) {
        this.n = eVar;
        b();
    }

    private void b() {
        if (Build.VERSION.SDK_INT >= 17 && getResources().getConfiguration().getLayoutDirection() == 1) {
            int i2 = AnonymousClass3.f3187a[this.n.ordinal()];
            if (i2 == 1) {
                this.n = e.END;
            } else if (i2 == 2) {
                this.n = e.START;
            }
        }
    }

    /* renamed from: com.afollestad.materialdialogs.internal.MDRootLayout$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3187a = new int[e.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.afollestad.materialdialogs.e[] r0 = com.afollestad.materialdialogs.e.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3187a = r0
                int[] r0 = f3187a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.afollestad.materialdialogs.e r1 = com.afollestad.materialdialogs.e.START     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f3187a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.afollestad.materialdialogs.e r1 = com.afollestad.materialdialogs.e.END     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.internal.MDRootLayout.AnonymousClass3.<clinit>():void");
        }
    }

    public void setButtonStackedGravity(e eVar) {
        for (MDButton mDButton : this.f3176e) {
            if (mDButton != null) {
                mDButton.setStackedGravity(eVar);
            }
        }
    }

    private void a(final View view, final boolean z, final boolean z2) {
        if (view != null) {
            if (view instanceof ScrollView) {
                ScrollView scrollView = (ScrollView) view;
                if (a(scrollView)) {
                    a((ViewGroup) scrollView, z, z2);
                    return;
                }
                if (z) {
                    this.f3174c = false;
                }
                if (z2) {
                    this.f3175d = false;
                }
            } else if (view instanceof AdapterView) {
                AdapterView adapterView = (AdapterView) view;
                if (a(adapterView)) {
                    a((ViewGroup) adapterView, z, z2);
                    return;
                }
                if (z) {
                    this.f3174c = false;
                }
                if (z2) {
                    this.f3175d = false;
                }
            } else if (view instanceof WebView) {
                view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    public boolean onPreDraw() {
                        if (view.getMeasuredHeight() == 0) {
                            return true;
                        }
                        if (!MDRootLayout.b((WebView) view)) {
                            if (z) {
                                boolean unused = MDRootLayout.this.f3174c = false;
                            }
                            if (z2) {
                                boolean unused2 = MDRootLayout.this.f3175d = false;
                            }
                        } else {
                            MDRootLayout.this.a((ViewGroup) view, z, z2);
                        }
                        view.getViewTreeObserver().removeOnPreDrawListener(this);
                        return true;
                    }
                });
            } else if (view instanceof RecyclerView) {
                boolean a2 = a((RecyclerView) view);
                if (z) {
                    this.f3174c = a2;
                }
                if (z2) {
                    this.f3175d = a2;
                }
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                View b2 = b(viewGroup);
                a(b2, z, z2);
                View a3 = a(viewGroup);
                if (a3 != b2) {
                    a(a3, false, true);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(final ViewGroup viewGroup, final boolean z, final boolean z2) {
        if ((!z2 && this.q == null) || (z2 && this.r == null)) {
            AnonymousClass2 r0 = new ViewTreeObserver.OnScrollChangedListener() {
                public void onScrollChanged() {
                    MDButton[] a2 = MDRootLayout.this.f3176e;
                    int length = a2.length;
                    boolean z = false;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        MDButton mDButton = a2[i];
                        if (mDButton != null && mDButton.getVisibility() != 8) {
                            z = true;
                            break;
                        }
                        i++;
                    }
                    ViewGroup viewGroup = viewGroup;
                    if (viewGroup instanceof WebView) {
                        MDRootLayout.this.a((WebView) viewGroup, z, z2, z);
                    } else {
                        MDRootLayout.this.a(viewGroup, z, z2, z);
                    }
                    MDRootLayout.this.invalidate();
                }
            };
            if (!z2) {
                this.q = r0;
                viewGroup.getViewTreeObserver().addOnScrollChangedListener(this.q);
            } else {
                this.r = r0;
                viewGroup.getViewTreeObserver().addOnScrollChangedListener(this.r);
            }
            r0.onScrollChanged();
        }
    }

    /* access modifiers changed from: private */
    public void a(ViewGroup viewGroup, boolean z, boolean z2, boolean z3) {
        boolean z4 = true;
        if (z && viewGroup.getChildCount() > 0) {
            View view = this.f3172a;
            this.f3174c = (view == null || view.getVisibility() == 8 || viewGroup.getScrollY() + viewGroup.getPaddingTop() <= viewGroup.getChildAt(0).getTop()) ? false : true;
        }
        if (z2 && viewGroup.getChildCount() > 0) {
            if (!z3 || (viewGroup.getScrollY() + viewGroup.getHeight()) - viewGroup.getPaddingBottom() >= viewGroup.getChildAt(viewGroup.getChildCount() - 1).getBottom()) {
                z4 = false;
            }
            this.f3175d = z4;
        }
    }

    /* access modifiers changed from: private */
    public void a(WebView webView, boolean z, boolean z2, boolean z3) {
        boolean z4 = true;
        if (z) {
            View view = this.f3172a;
            this.f3174c = (view == null || view.getVisibility() == 8 || webView.getScrollY() + webView.getPaddingTop() <= 0) ? false : true;
        }
        if (z2) {
            if (!z3 || ((float) ((webView.getScrollY() + webView.getMeasuredHeight()) - webView.getPaddingBottom())) >= ((float) webView.getContentHeight()) * webView.getScale()) {
                z4 = false;
            }
            this.f3175d = z4;
        }
    }

    public static boolean a(RecyclerView recyclerView) {
        if (recyclerView == null || recyclerView.getAdapter() == null || recyclerView.getLayoutManager() == null) {
            return false;
        }
        RecyclerView.i layoutManager = recyclerView.getLayoutManager();
        int itemCount = recyclerView.getAdapter().getItemCount();
        if (layoutManager instanceof LinearLayoutManager) {
            int p2 = ((LinearLayoutManager) layoutManager).p();
            if (p2 == -1) {
                return false;
            }
            if (!(p2 == itemCount - 1) || (recyclerView.getChildCount() > 0 && recyclerView.getChildAt(recyclerView.getChildCount() - 1).getBottom() > recyclerView.getHeight() - recyclerView.getPaddingBottom())) {
                return true;
            }
            return false;
        }
        throw new f.h("Material Dialogs currently only supports LinearLayoutManager. Please report any new layout managers.");
    }

    private static boolean a(ScrollView scrollView) {
        if (scrollView.getChildCount() != 0 && (scrollView.getMeasuredHeight() - scrollView.getPaddingTop()) - scrollView.getPaddingBottom() < scrollView.getChildAt(0).getMeasuredHeight()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static boolean b(WebView webView) {
        return ((float) webView.getMeasuredHeight()) < ((float) webView.getContentHeight()) * webView.getScale();
    }

    private static boolean a(AdapterView adapterView) {
        if (adapterView.getLastVisiblePosition() == -1) {
            return false;
        }
        boolean z = adapterView.getFirstVisiblePosition() == 0;
        boolean z2 = adapterView.getLastVisiblePosition() == adapterView.getCount() - 1;
        if (!z || !z2 || adapterView.getChildCount() <= 0 || adapterView.getChildAt(0).getTop() < adapterView.getPaddingTop() || adapterView.getChildAt(adapterView.getChildCount() - 1).getBottom() > adapterView.getHeight() - adapterView.getPaddingBottom()) {
            return true;
        }
        return false;
    }

    private static View a(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() == 0) {
            return null;
        }
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt.getVisibility() == 0 && childAt.getBottom() == viewGroup.getMeasuredHeight()) {
                return childAt;
            }
        }
        return null;
    }

    private static View b(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() == 0) {
            return null;
        }
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt.getVisibility() == 0 && childAt.getTop() == 0) {
                return childAt;
            }
        }
        return null;
    }
}
