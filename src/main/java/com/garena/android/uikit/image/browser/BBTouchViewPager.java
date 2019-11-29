package com.garena.android.uikit.image.browser;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.core.g.v;
import androidx.core.g.w;
import androidx.core.g.x;
import androidx.core.view.KeyEventCompat;
import androidx.viewpager.widget.ViewPager;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.ijk.media.player.IjkMediaCodecInfo;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import tencent.tls.platform.SigType;

public class BBTouchViewPager extends ViewGroup {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f7740a = {16842931};
    private static final i ag = new i();

    /* renamed from: c  reason: collision with root package name */
    private static final Comparator<b> f7741c = new Comparator<b>() {
        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            return bVar.f7752b - bVar2.f7752b;
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private static final Interpolator f7742d = new Interpolator() {
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    private boolean A;
    private boolean B;
    private int C;
    private int D;
    private int E;
    private float F;
    private float G;
    private float H;
    private float I;
    private int J = -1;
    private VelocityTracker K;
    private int L;
    private int M;
    private int N;
    private int O;
    private boolean P;
    private androidx.core.widget.d Q;
    private androidx.core.widget.d R;
    private boolean S = true;
    private boolean T = false;
    private boolean U;
    private int V;
    private f W;
    private f aa;
    private e ab;
    private g ac;
    private Method ad;
    private int ae;
    private ArrayList<View> af;
    private final Runnable ah = new Runnable() {
        public void run() {
            BBTouchViewPager.this.setScrollState(0);
            BBTouchViewPager.this.c();
        }
    };
    private int ai = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f7743b;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<b> f7744e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private final b f7745f = new b();

    /* renamed from: g  reason: collision with root package name */
    private final Rect f7746g = new Rect();
    /* access modifiers changed from: private */
    public androidx.viewpager.widget.a h;
    /* access modifiers changed from: private */
    public int i;
    private int j = -1;
    private Parcelable k = null;
    private ClassLoader l = null;
    private Scroller m;
    private h n;
    private int o;
    private Drawable p;
    private int q;
    private int r;
    private float s = -3.4028235E38f;
    private float t = Float.MAX_VALUE;
    private int u;
    private int v;
    private boolean w;
    private boolean x;
    private boolean y;
    private int z = 1;

    interface a {
    }

    interface e {
        void a(androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2);
    }

    public interface f {
        void a(int i);

        void a(int i, float f2, int i2);

        void b(int i);
    }

    public interface g {
        void a(View view, float f2);
    }

    public BBTouchViewPager(Context context) {
        super(context);
        a();
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        Object f7751a;

        /* renamed from: b  reason: collision with root package name */
        int f7752b;

        /* renamed from: c  reason: collision with root package name */
        boolean f7753c;

        /* renamed from: d  reason: collision with root package name */
        float f7754d;

        /* renamed from: e  reason: collision with root package name */
        float f7755e;

        b() {
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        setWillNotDraw(false);
        setDescendantFocusability(SigType.D2);
        setFocusable(true);
        Context context = getContext();
        this.m = new Scroller(context, f7742d);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.E = x.a(viewConfiguration);
        this.L = (int) (400.0f * f2);
        this.M = viewConfiguration.getScaledMaximumFlingVelocity();
        this.Q = new androidx.core.widget.d(context);
        this.R = new androidx.core.widget.d(context);
        this.N = (int) (25.0f * f2);
        this.O = (int) (2.0f * f2);
        this.C = (int) (f2 * 16.0f);
        w.a((View) this, (androidx.core.g.a) new d());
        if (w.f(this) == 0) {
            w.d((View) this, 1);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.ah);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: private */
    public void setScrollState(int i2) {
        if (this.ai != i2) {
            this.ai = i2;
            if (this.ac != null) {
                b(i2 != 0);
            }
            f fVar = this.W;
            if (fVar != null) {
                fVar.b(i2);
            }
        }
    }

    public void setAdapter(androidx.viewpager.widget.a aVar) {
        androidx.viewpager.widget.a aVar2 = this.h;
        if (aVar2 != null) {
            aVar2.unregisterDataSetObserver(this.n);
            this.h.startUpdate((ViewGroup) this);
            for (int i2 = 0; i2 < this.f7744e.size(); i2++) {
                b bVar = this.f7744e.get(i2);
                this.h.destroyItem((ViewGroup) this, bVar.f7752b, bVar.f7751a);
            }
            this.h.finishUpdate((ViewGroup) this);
            this.f7744e.clear();
            g();
            this.i = 0;
            scrollTo(0, 0);
        }
        androidx.viewpager.widget.a aVar3 = this.h;
        this.h = aVar;
        this.f7743b = 0;
        if (this.h != null) {
            if (this.n == null) {
                this.n = new h();
            }
            this.h.registerDataSetObserver(this.n);
            this.y = false;
            boolean z2 = this.S;
            this.S = true;
            this.f7743b = this.h.getCount();
            if (this.j >= 0) {
                this.h.restoreState(this.k, this.l);
                a(this.j, false, true);
                this.j = -1;
                this.k = null;
                this.l = null;
            } else if (!z2) {
                c();
            } else {
                requestLayout();
            }
        }
        e eVar = this.ab;
        if (eVar != null && aVar3 != aVar) {
            eVar.a(aVar3, aVar);
        }
    }

    private void g() {
        int i2 = 0;
        while (i2 < getChildCount()) {
            if (!((c) getChildAt(i2).getLayoutParams()).f7756a) {
                removeViewAt(i2);
                i2--;
            }
            i2++;
        }
    }

    public androidx.viewpager.widget.a getAdapter() {
        return this.h;
    }

    /* access modifiers changed from: package-private */
    public void setOnAdapterChangeListener(e eVar) {
        this.ab = eVar;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i2) {
        this.y = false;
        a(i2, !this.S, false);
    }

    public void a(int i2, boolean z2) {
        this.y = false;
        a(i2, z2, false);
    }

    public int getCurrentItem() {
        return this.i;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, boolean z2, boolean z3) {
        a(i2, z2, z3, 0);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, boolean z2, boolean z3, int i3) {
        androidx.viewpager.widget.a aVar = this.h;
        if (aVar == null || aVar.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z3 || this.i != i2 || this.f7744e.size() == 0) {
            boolean z4 = true;
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 >= this.h.getCount()) {
                i2 = this.h.getCount() - 1;
            }
            int i4 = this.z;
            int i5 = this.i;
            if (i2 > i5 + i4 || i2 < i5 - i4) {
                for (int i6 = 0; i6 < this.f7744e.size(); i6++) {
                    this.f7744e.get(i6).f7753c = true;
                }
            }
            if (this.i == i2) {
                z4 = false;
            }
            if (this.S) {
                this.i = i2;
                if (z4) {
                    f fVar = this.W;
                    if (fVar != null) {
                        fVar.a(i2);
                    }
                }
                if (z4) {
                    f fVar2 = this.aa;
                    if (fVar2 != null) {
                        fVar2.a(i2);
                    }
                }
                requestLayout();
                return;
            }
            a(i2);
            a(i2, z2, i3, z4);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    private void a(int i2, boolean z2, int i3, boolean z3) {
        b b2 = b(i2);
        int clientWidth = b2 != null ? (int) (((float) getClientWidth()) * Math.max(this.s, Math.min(b2.f7755e, this.t))) : 0;
        if (z2) {
            a(clientWidth, 0, i3);
            if (z3) {
                f fVar = this.W;
                if (fVar != null) {
                    fVar.a(i2);
                }
            }
            if (z3) {
                f fVar2 = this.aa;
                if (fVar2 != null) {
                    fVar2.a(i2);
                    return;
                }
                return;
            }
            return;
        }
        if (z3) {
            f fVar3 = this.W;
            if (fVar3 != null) {
                fVar3.a(i2);
            }
        }
        if (z3) {
            f fVar4 = this.aa;
            if (fVar4 != null) {
                fVar4.a(i2);
            }
        }
        a(false);
        scrollTo(clientWidth, 0);
        d(clientWidth);
    }

    public void setOnPageChangeListener(f fVar) {
        this.W = fVar;
    }

    /* access modifiers changed from: package-private */
    public void setChildrenDrawingOrderEnabledCompat(boolean z2) {
        if (Build.VERSION.SDK_INT >= 7) {
            if (this.ad == null) {
                Class<ViewGroup> cls = ViewGroup.class;
                try {
                    this.ad = cls.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (NoSuchMethodException e2) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e2);
                }
            }
            try {
                this.ad.invoke(this, new Object[]{Boolean.valueOf(z2)});
            } catch (Exception e3) {
                Log.e("ViewPager", "Error changing children drawing order", e3);
            }
        }
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        if (this.ae == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((c) this.af.get(i3).getLayoutParams()).f7761f;
    }

    public int getOffscreenPageLimit() {
        return this.z;
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i2 + " too small; defaulting to " + 1);
            i2 = 1;
        }
        if (i2 != this.z) {
            this.z = i2;
            c();
        }
    }

    public void setPageMargin(int i2) {
        int i3 = this.o;
        this.o = i2;
        int width = getWidth();
        a(width, width, i2, i3);
        requestLayout();
    }

    public int getPageMargin() {
        return this.o;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.p = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i2));
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.p;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.p;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    /* access modifiers changed from: package-private */
    public float a(float f2) {
        double d2 = (double) (f2 - 0.5f);
        Double.isNaN(d2);
        return (float) Math.sin((double) ((float) (d2 * 0.4712389167638204d)));
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, int i4) {
        int i5;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i6 = i2 - scrollX;
        int i7 = i3 - scrollY;
        if (i6 == 0 && i7 == 0) {
            a(false);
            c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i8 = clientWidth / 2;
        float f2 = (float) clientWidth;
        float f3 = (float) i8;
        float a2 = f3 + (a(Math.min(1.0f, (((float) Math.abs(i6)) * 1.0f) / f2)) * f3);
        int abs = Math.abs(i4);
        if (abs > 0) {
            i5 = Math.round(Math.abs(a2 / ((float) abs)) * 1000.0f) * 4;
        } else {
            i5 = (int) (((((float) Math.abs(i6)) / ((f2 * this.h.getPageWidth(this.i)) + ((float) this.o))) + 1.0f) * 100.0f);
        }
        this.m.startScroll(scrollX, scrollY, i6, i7, Math.min(i5, IjkMediaCodecInfo.RANK_LAST_CHANCE));
        w.e(this);
    }

    /* access modifiers changed from: package-private */
    public b a(int i2, int i3) {
        b bVar = new b();
        bVar.f7752b = i2;
        bVar.f7751a = this.h.instantiateItem((ViewGroup) this, i2);
        bVar.f7754d = this.h.getPageWidth(i2);
        if (i3 < 0 || i3 >= this.f7744e.size()) {
            this.f7744e.add(bVar);
        } else {
            this.f7744e.add(i3, bVar);
        }
        return bVar;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        int count = this.h.getCount();
        this.f7743b = count;
        boolean z2 = this.f7744e.size() < (this.z * 2) + 1 && this.f7744e.size() < count;
        int i2 = this.i;
        int i3 = 0;
        boolean z3 = false;
        while (i3 < this.f7744e.size()) {
            b bVar = this.f7744e.get(i3);
            int itemPosition = this.h.getItemPosition(bVar.f7751a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.f7744e.remove(i3);
                    i3--;
                    if (!z3) {
                        this.h.startUpdate((ViewGroup) this);
                        z3 = true;
                    }
                    this.h.destroyItem((ViewGroup) this, bVar.f7752b, bVar.f7751a);
                    if (this.i == bVar.f7752b) {
                        i2 = Math.max(0, Math.min(this.i, count - 1));
                    }
                } else if (bVar.f7752b != itemPosition) {
                    if (bVar.f7752b == this.i) {
                        i2 = itemPosition;
                    }
                    bVar.f7752b = itemPosition;
                }
                z2 = true;
            }
            i3++;
        }
        if (z3) {
            this.h.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.f7744e, f7741c);
        if (z2) {
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                c cVar = (c) getChildAt(i4).getLayoutParams();
                if (!cVar.f7756a) {
                    cVar.f7758c = BitmapDescriptorFactory.HUE_RED;
                }
            }
            a(i2, false, true);
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        a(this.i);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006e, code lost:
        if (r9.f7752b == r0.i) goto L_0x0075;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r0.i
            if (r2 == r1) goto L_0x0018
            if (r2 >= r1) goto L_0x000d
            r2 = 66
            goto L_0x000f
        L_0x000d:
            r2 = 17
        L_0x000f:
            int r4 = r0.i
            com.garena.android.uikit.image.browser.BBTouchViewPager$b r4 = r0.b((int) r4)
            r0.i = r1
            goto L_0x001a
        L_0x0018:
            r2 = 2
            r4 = 0
        L_0x001a:
            androidx.viewpager.widget.a r1 = r0.h
            if (r1 != 0) goto L_0x0022
            r17.h()
            return
        L_0x0022:
            boolean r1 = r0.y
            if (r1 == 0) goto L_0x002a
            r17.h()
            return
        L_0x002a:
            android.os.IBinder r1 = r17.getWindowToken()
            if (r1 != 0) goto L_0x0031
            return
        L_0x0031:
            androidx.viewpager.widget.a r1 = r0.h
            r1.startUpdate((android.view.ViewGroup) r0)
            int r1 = r0.z
            int r5 = r0.i
            int r5 = r5 - r1
            r6 = 0
            int r5 = java.lang.Math.max(r6, r5)
            androidx.viewpager.widget.a r7 = r0.h
            int r7 = r7.getCount()
            int r8 = r7 + -1
            int r9 = r0.i
            int r9 = r9 + r1
            int r1 = java.lang.Math.min(r8, r9)
            int r8 = r0.f7743b
            if (r7 != r8) goto L_0x0223
            r8 = 0
        L_0x0054:
            java.util.ArrayList<com.garena.android.uikit.image.browser.BBTouchViewPager$b> r9 = r0.f7744e
            int r9 = r9.size()
            if (r8 >= r9) goto L_0x0074
            java.util.ArrayList<com.garena.android.uikit.image.browser.BBTouchViewPager$b> r9 = r0.f7744e
            java.lang.Object r9 = r9.get(r8)
            com.garena.android.uikit.image.browser.BBTouchViewPager$b r9 = (com.garena.android.uikit.image.browser.BBTouchViewPager.b) r9
            int r10 = r9.f7752b
            int r11 = r0.i
            if (r10 < r11) goto L_0x0071
            int r10 = r9.f7752b
            int r11 = r0.i
            if (r10 != r11) goto L_0x0074
            goto L_0x0075
        L_0x0071:
            int r8 = r8 + 1
            goto L_0x0054
        L_0x0074:
            r9 = 0
        L_0x0075:
            if (r9 != 0) goto L_0x007f
            if (r7 <= 0) goto L_0x007f
            int r9 = r0.i
            com.garena.android.uikit.image.browser.BBTouchViewPager$b r9 = r0.a((int) r9, (int) r8)
        L_0x007f:
            if (r9 == 0) goto L_0x01a1
            int r11 = r8 + -1
            if (r11 < 0) goto L_0x008e
            java.util.ArrayList<com.garena.android.uikit.image.browser.BBTouchViewPager$b> r12 = r0.f7744e
            java.lang.Object r12 = r12.get(r11)
            com.garena.android.uikit.image.browser.BBTouchViewPager$b r12 = (com.garena.android.uikit.image.browser.BBTouchViewPager.b) r12
            goto L_0x008f
        L_0x008e:
            r12 = 0
        L_0x008f:
            int r13 = r17.getClientWidth()
            r14 = 1073741824(0x40000000, float:2.0)
            if (r13 > 0) goto L_0x0099
            r3 = 0
            goto L_0x00a5
        L_0x0099:
            float r15 = r9.f7754d
            float r15 = r14 - r15
            int r3 = r17.getPaddingLeft()
            float r3 = (float) r3
            float r6 = (float) r13
            float r3 = r3 / r6
            float r3 = r3 + r15
        L_0x00a5:
            int r6 = r0.i
            int r6 = r6 + -1
            r15 = r11
            r11 = r8
            r8 = 0
        L_0x00ac:
            if (r6 < 0) goto L_0x010b
            int r16 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r16 < 0) goto L_0x00da
            if (r6 >= r5) goto L_0x00da
            if (r12 != 0) goto L_0x00b7
            goto L_0x010b
        L_0x00b7:
            int r10 = r12.f7752b
            if (r6 != r10) goto L_0x0108
            boolean r10 = r12.f7753c
            if (r10 != 0) goto L_0x0108
            java.util.ArrayList<com.garena.android.uikit.image.browser.BBTouchViewPager$b> r10 = r0.f7744e
            r10.remove(r15)
            androidx.viewpager.widget.a r10 = r0.h
            java.lang.Object r12 = r12.f7751a
            r10.destroyItem((android.view.ViewGroup) r0, (int) r6, (java.lang.Object) r12)
            int r15 = r15 + -1
            int r11 = r11 + -1
            if (r15 < 0) goto L_0x0106
            java.util.ArrayList<com.garena.android.uikit.image.browser.BBTouchViewPager$b> r10 = r0.f7744e
            java.lang.Object r10 = r10.get(r15)
            com.garena.android.uikit.image.browser.BBTouchViewPager$b r10 = (com.garena.android.uikit.image.browser.BBTouchViewPager.b) r10
            goto L_0x0107
        L_0x00da:
            if (r12 == 0) goto L_0x00f0
            int r10 = r12.f7752b
            if (r6 != r10) goto L_0x00f0
            float r10 = r12.f7754d
            float r8 = r8 + r10
            int r15 = r15 + -1
            if (r15 < 0) goto L_0x0106
            java.util.ArrayList<com.garena.android.uikit.image.browser.BBTouchViewPager$b> r10 = r0.f7744e
            java.lang.Object r10 = r10.get(r15)
            com.garena.android.uikit.image.browser.BBTouchViewPager$b r10 = (com.garena.android.uikit.image.browser.BBTouchViewPager.b) r10
            goto L_0x0107
        L_0x00f0:
            int r10 = r15 + 1
            com.garena.android.uikit.image.browser.BBTouchViewPager$b r10 = r0.a((int) r6, (int) r10)
            float r10 = r10.f7754d
            float r8 = r8 + r10
            int r11 = r11 + 1
            if (r15 < 0) goto L_0x0106
            java.util.ArrayList<com.garena.android.uikit.image.browser.BBTouchViewPager$b> r10 = r0.f7744e
            java.lang.Object r10 = r10.get(r15)
            com.garena.android.uikit.image.browser.BBTouchViewPager$b r10 = (com.garena.android.uikit.image.browser.BBTouchViewPager.b) r10
            goto L_0x0107
        L_0x0106:
            r10 = 0
        L_0x0107:
            r12 = r10
        L_0x0108:
            int r6 = r6 + -1
            goto L_0x00ac
        L_0x010b:
            float r3 = r9.f7754d
            int r5 = r11 + 1
            int r6 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r6 >= 0) goto L_0x019e
            java.util.ArrayList<com.garena.android.uikit.image.browser.BBTouchViewPager$b> r6 = r0.f7744e
            int r6 = r6.size()
            if (r5 >= r6) goto L_0x0124
            java.util.ArrayList<com.garena.android.uikit.image.browser.BBTouchViewPager$b> r6 = r0.f7744e
            java.lang.Object r6 = r6.get(r5)
            com.garena.android.uikit.image.browser.BBTouchViewPager$b r6 = (com.garena.android.uikit.image.browser.BBTouchViewPager.b) r6
            goto L_0x0125
        L_0x0124:
            r6 = 0
        L_0x0125:
            if (r13 > 0) goto L_0x0129
            r10 = 0
            goto L_0x0132
        L_0x0129:
            int r8 = r17.getPaddingRight()
            float r8 = (float) r8
            float r10 = (float) r13
            float r8 = r8 / r10
            float r10 = r8 + r14
        L_0x0132:
            int r8 = r0.i
        L_0x0134:
            int r8 = r8 + 1
            if (r8 >= r7) goto L_0x019e
            int r12 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r12 < 0) goto L_0x0168
            if (r8 <= r1) goto L_0x0168
            if (r6 != 0) goto L_0x0141
            goto L_0x019e
        L_0x0141:
            int r12 = r6.f7752b
            if (r8 != r12) goto L_0x019d
            boolean r12 = r6.f7753c
            if (r12 != 0) goto L_0x019d
            java.util.ArrayList<com.garena.android.uikit.image.browser.BBTouchViewPager$b> r12 = r0.f7744e
            r12.remove(r5)
            androidx.viewpager.widget.a r12 = r0.h
            java.lang.Object r6 = r6.f7751a
            r12.destroyItem((android.view.ViewGroup) r0, (int) r8, (java.lang.Object) r6)
            java.util.ArrayList<com.garena.android.uikit.image.browser.BBTouchViewPager$b> r6 = r0.f7744e
            int r6 = r6.size()
            if (r5 >= r6) goto L_0x0166
            java.util.ArrayList<com.garena.android.uikit.image.browser.BBTouchViewPager$b> r6 = r0.f7744e
            java.lang.Object r6 = r6.get(r5)
            com.garena.android.uikit.image.browser.BBTouchViewPager$b r6 = (com.garena.android.uikit.image.browser.BBTouchViewPager.b) r6
            goto L_0x019d
        L_0x0166:
            r6 = 0
            goto L_0x019d
        L_0x0168:
            if (r6 == 0) goto L_0x0184
            int r12 = r6.f7752b
            if (r8 != r12) goto L_0x0184
            float r6 = r6.f7754d
            float r3 = r3 + r6
            int r5 = r5 + 1
            java.util.ArrayList<com.garena.android.uikit.image.browser.BBTouchViewPager$b> r6 = r0.f7744e
            int r6 = r6.size()
            if (r5 >= r6) goto L_0x0166
            java.util.ArrayList<com.garena.android.uikit.image.browser.BBTouchViewPager$b> r6 = r0.f7744e
            java.lang.Object r6 = r6.get(r5)
            com.garena.android.uikit.image.browser.BBTouchViewPager$b r6 = (com.garena.android.uikit.image.browser.BBTouchViewPager.b) r6
            goto L_0x019d
        L_0x0184:
            com.garena.android.uikit.image.browser.BBTouchViewPager$b r6 = r0.a((int) r8, (int) r5)
            int r5 = r5 + 1
            float r6 = r6.f7754d
            float r3 = r3 + r6
            java.util.ArrayList<com.garena.android.uikit.image.browser.BBTouchViewPager$b> r6 = r0.f7744e
            int r6 = r6.size()
            if (r5 >= r6) goto L_0x0166
            java.util.ArrayList<com.garena.android.uikit.image.browser.BBTouchViewPager$b> r6 = r0.f7744e
            java.lang.Object r6 = r6.get(r5)
            com.garena.android.uikit.image.browser.BBTouchViewPager$b r6 = (com.garena.android.uikit.image.browser.BBTouchViewPager.b) r6
        L_0x019d:
            goto L_0x0134
        L_0x019e:
            r0.a((com.garena.android.uikit.image.browser.BBTouchViewPager.b) r9, (int) r11, (com.garena.android.uikit.image.browser.BBTouchViewPager.b) r4)
        L_0x01a1:
            androidx.viewpager.widget.a r1 = r0.h
            int r3 = r0.i
            if (r9 == 0) goto L_0x01aa
            java.lang.Object r4 = r9.f7751a
            goto L_0x01ab
        L_0x01aa:
            r4 = 0
        L_0x01ab:
            r1.setPrimaryItem((android.view.ViewGroup) r0, (int) r3, (java.lang.Object) r4)
            androidx.viewpager.widget.a r1 = r0.h
            r1.finishUpdate((android.view.ViewGroup) r0)
            int r1 = r17.getChildCount()
            r3 = 0
        L_0x01b8:
            if (r3 >= r1) goto L_0x01e4
            android.view.View r4 = r0.getChildAt(r3)
            android.view.ViewGroup$LayoutParams r5 = r4.getLayoutParams()
            com.garena.android.uikit.image.browser.BBTouchViewPager$c r5 = (com.garena.android.uikit.image.browser.BBTouchViewPager.c) r5
            r5.f7761f = r3
            boolean r6 = r5.f7756a
            if (r6 != 0) goto L_0x01e0
            float r6 = r5.f7758c
            r7 = 0
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 != 0) goto L_0x01e1
            com.garena.android.uikit.image.browser.BBTouchViewPager$b r4 = r0.a((android.view.View) r4)
            if (r4 == 0) goto L_0x01e1
            float r6 = r4.f7754d
            r5.f7758c = r6
            int r4 = r4.f7752b
            r5.f7760e = r4
            goto L_0x01e1
        L_0x01e0:
            r7 = 0
        L_0x01e1:
            int r3 = r3 + 1
            goto L_0x01b8
        L_0x01e4:
            r17.h()
            boolean r1 = r17.hasFocus()
            if (r1 == 0) goto L_0x0222
            android.view.View r1 = r17.findFocus()
            if (r1 == 0) goto L_0x01f8
            com.garena.android.uikit.image.browser.BBTouchViewPager$b r3 = r0.b((android.view.View) r1)
            goto L_0x01f9
        L_0x01f8:
            r3 = 0
        L_0x01f9:
            if (r3 == 0) goto L_0x0201
            int r1 = r3.f7752b
            int r3 = r0.i
            if (r1 == r3) goto L_0x0222
        L_0x0201:
            r1 = 0
        L_0x0202:
            int r3 = r17.getChildCount()
            if (r1 >= r3) goto L_0x0222
            android.view.View r3 = r0.getChildAt(r1)
            com.garena.android.uikit.image.browser.BBTouchViewPager$b r4 = r0.a((android.view.View) r3)
            if (r4 == 0) goto L_0x021f
            int r4 = r4.f7752b
            int r5 = r0.i
            if (r4 != r5) goto L_0x021f
            boolean r3 = r3.requestFocus(r2)
            if (r3 == 0) goto L_0x021f
            goto L_0x0222
        L_0x021f:
            int r1 = r1 + 1
            goto L_0x0202
        L_0x0222:
            return
        L_0x0223:
            android.content.res.Resources r1 = r17.getResources()     // Catch:{ NotFoundException -> 0x0230 }
            int r2 = r17.getId()     // Catch:{ NotFoundException -> 0x0230 }
            java.lang.String r1 = r1.getResourceName(r2)     // Catch:{ NotFoundException -> 0x0230 }
            goto L_0x0238
        L_0x0230:
            int r1 = r17.getId()
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
        L_0x0238:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: "
            r3.append(r4)
            int r4 = r0.f7743b
            r3.append(r4)
            java.lang.String r4 = ", found: "
            r3.append(r4)
            r3.append(r7)
            java.lang.String r4 = " Pager id: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = " Pager class: "
            r3.append(r1)
            java.lang.Class r1 = r17.getClass()
            r3.append(r1)
            java.lang.String r1 = " Problematic adapter: "
            r3.append(r1)
            androidx.viewpager.widget.a r1 = r0.h
            java.lang.Class r1 = r1.getClass()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            goto L_0x027c
        L_0x027b:
            throw r2
        L_0x027c:
            goto L_0x027b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.garena.android.uikit.image.browser.BBTouchViewPager.a(int):void");
    }

    private void h() {
        if (this.ae != 0) {
            ArrayList<View> arrayList = this.af;
            if (arrayList == null) {
                this.af = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.af.add(getChildAt(i2));
            }
            Collections.sort(this.af, ag);
        }
    }

    private void a(b bVar, int i2, b bVar2) {
        b bVar3;
        b bVar4;
        int count = this.h.getCount();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? ((float) this.o) / ((float) clientWidth) : BitmapDescriptorFactory.HUE_RED;
        if (bVar2 != null) {
            int i3 = bVar2.f7752b;
            if (i3 < bVar.f7752b) {
                float f3 = bVar2.f7755e + bVar2.f7754d + f2;
                int i4 = i3 + 1;
                int i5 = 0;
                while (i4 <= bVar.f7752b && i5 < this.f7744e.size()) {
                    Object obj = this.f7744e.get(i5);
                    while (true) {
                        bVar4 = (b) obj;
                        if (i4 > bVar4.f7752b && i5 < this.f7744e.size() - 1) {
                            i5++;
                            obj = this.f7744e.get(i5);
                        }
                    }
                    while (i4 < bVar4.f7752b) {
                        f3 += this.h.getPageWidth(i4) + f2;
                        i4++;
                    }
                    bVar4.f7755e = f3;
                    f3 += bVar4.f7754d + f2;
                    i4++;
                }
            } else if (i3 > bVar.f7752b) {
                int size = this.f7744e.size() - 1;
                float f4 = bVar2.f7755e;
                while (true) {
                    i3--;
                    if (i3 < bVar.f7752b || size < 0) {
                        break;
                    }
                    Object obj2 = this.f7744e.get(size);
                    while (true) {
                        bVar3 = (b) obj2;
                        if (i3 < bVar3.f7752b && size > 0) {
                            size--;
                            obj2 = this.f7744e.get(size);
                        }
                    }
                    while (i3 > bVar3.f7752b) {
                        f4 -= this.h.getPageWidth(i3) + f2;
                        i3--;
                    }
                    f4 -= bVar3.f7754d + f2;
                    bVar3.f7755e = f4;
                }
            }
        }
        int size2 = this.f7744e.size();
        float f5 = bVar.f7755e;
        int i6 = bVar.f7752b - 1;
        this.s = bVar.f7752b == 0 ? bVar.f7755e : -3.4028235E38f;
        int i7 = count - 1;
        this.t = bVar.f7752b == i7 ? (bVar.f7755e + bVar.f7754d) - 1.0f : Float.MAX_VALUE;
        int i8 = i2 - 1;
        while (i8 >= 0) {
            b bVar5 = this.f7744e.get(i8);
            while (i6 > bVar5.f7752b) {
                f5 -= this.h.getPageWidth(i6) + f2;
                i6--;
            }
            f5 -= bVar5.f7754d + f2;
            bVar5.f7755e = f5;
            if (bVar5.f7752b == 0) {
                this.s = f5;
            }
            i8--;
            i6--;
        }
        float f6 = bVar.f7755e + bVar.f7754d + f2;
        int i9 = bVar.f7752b + 1;
        int i10 = i2 + 1;
        while (i10 < size2) {
            b bVar6 = this.f7744e.get(i10);
            while (i9 < bVar6.f7752b) {
                f6 += this.h.getPageWidth(i9) + f2;
                i9++;
            }
            if (bVar6.f7752b == i7) {
                this.t = (bVar6.f7754d + f6) - 1.0f;
            }
            bVar6.f7755e = f6;
            f6 += bVar6.f7754d + f2;
            i10++;
            i9++;
        }
        this.T = false;
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = androidx.core.d.d.a(new androidx.core.d.e<SavedState>() {
            /* renamed from: b */
            public SavedState a(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: b */
            public SavedState[] a(int i) {
                return new SavedState[i];
            }
        });

        /* renamed from: a  reason: collision with root package name */
        int f7748a;

        /* renamed from: b  reason: collision with root package name */
        Parcelable f7749b;

        /* renamed from: c  reason: collision with root package name */
        ClassLoader f7750c;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f7748a);
            parcel.writeParcelable(this.f7749b, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f7748a + "}";
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f7748a = parcel.readInt();
            this.f7749b = parcel.readParcelable(classLoader);
            this.f7750c = classLoader;
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f7748a = this.i;
        androidx.viewpager.widget.a aVar = this.h;
        if (aVar != null) {
            savedState.f7749b = aVar.saveState();
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        androidx.viewpager.widget.a aVar = this.h;
        if (aVar != null) {
            aVar.restoreState(savedState.f7749b, savedState.f7750c);
            a(savedState.f7748a, false, true);
            return;
        }
        this.j = savedState.f7748a;
        this.k = savedState.f7749b;
        this.l = savedState.f7750c;
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        c cVar = (c) layoutParams;
        cVar.f7756a |= view instanceof a;
        if (!this.w) {
            super.addView(view, i2, layoutParams);
        } else if (cVar == null || !cVar.f7756a) {
            cVar.f7759d = true;
            addViewInLayout(view, i2, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public void removeView(View view) {
        if (this.w) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    /* access modifiers changed from: package-private */
    public b a(View view) {
        for (int i2 = 0; i2 < this.f7744e.size(); i2++) {
            b bVar = this.f7744e.get(i2);
            if (this.h.isViewFromObject(view, bVar.f7751a)) {
                return bVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public b b(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return a(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    /* access modifiers changed from: package-private */
    public b b(int i2) {
        for (int i3 = 0; i3 < this.f7744e.size(); i3++) {
            b bVar = this.f7744e.get(i3);
            if (bVar.f7752b == i2) {
                return bVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.S = true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r17, int r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = 0
            r2 = r17
            int r2 = getDefaultSize(r1, r2)
            r3 = r18
            int r3 = getDefaultSize(r1, r3)
            r0.setMeasuredDimension(r2, r3)
            int r2 = r16.getMeasuredWidth()
            int r3 = r2 / 10
            int r4 = r0.C
            int r3 = java.lang.Math.min(r3, r4)
            r0.D = r3
            int r3 = r16.getPaddingLeft()
            int r2 = r2 - r3
            int r3 = r16.getPaddingRight()
            int r2 = r2 - r3
            int r3 = r16.getMeasuredHeight()
            int r4 = r16.getPaddingTop()
            int r3 = r3 - r4
            int r4 = r16.getPaddingBottom()
            int r3 = r3 - r4
            int r4 = r16.getChildCount()
            r5 = r3
            r3 = r2
            r2 = 0
        L_0x003f:
            r6 = 8
            r7 = 1
            r8 = 1073741824(0x40000000, float:2.0)
            if (r2 >= r4) goto L_0x00c7
            android.view.View r9 = r0.getChildAt(r2)
            int r10 = r9.getVisibility()
            if (r10 == r6) goto L_0x00c2
            android.view.ViewGroup$LayoutParams r6 = r9.getLayoutParams()
            com.garena.android.uikit.image.browser.BBTouchViewPager$c r6 = (com.garena.android.uikit.image.browser.BBTouchViewPager.c) r6
            if (r6 == 0) goto L_0x00c2
            boolean r10 = r6.f7756a
            if (r10 == 0) goto L_0x00c2
            int r10 = r6.f7757b
            r10 = r10 & 7
            int r11 = r6.f7757b
            r11 = r11 & 112(0x70, float:1.57E-43)
            r12 = 48
            if (r11 == r12) goto L_0x006f
            r12 = 80
            if (r11 != r12) goto L_0x006d
            goto L_0x006f
        L_0x006d:
            r11 = 0
            goto L_0x0070
        L_0x006f:
            r11 = 1
        L_0x0070:
            r12 = 3
            if (r10 == r12) goto L_0x0078
            r12 = 5
            if (r10 != r12) goto L_0x0077
            goto L_0x0078
        L_0x0077:
            r7 = 0
        L_0x0078:
            r10 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r11 == 0) goto L_0x007f
            r10 = 1073741824(0x40000000, float:2.0)
            goto L_0x0084
        L_0x007f:
            if (r7 == 0) goto L_0x0084
            r12 = 1073741824(0x40000000, float:2.0)
            goto L_0x0086
        L_0x0084:
            r12 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x0086:
            int r13 = r6.width
            r14 = -1
            r15 = -2
            if (r13 == r15) goto L_0x0098
            int r10 = r6.width
            if (r10 == r14) goto L_0x0094
            int r10 = r6.width
            r13 = r10
            goto L_0x0095
        L_0x0094:
            r13 = r3
        L_0x0095:
            r10 = 1073741824(0x40000000, float:2.0)
            goto L_0x0099
        L_0x0098:
            r13 = r3
        L_0x0099:
            int r1 = r6.height
            if (r1 == r15) goto L_0x00a6
            int r1 = r6.height
            if (r1 == r14) goto L_0x00a4
            int r1 = r6.height
            goto L_0x00a8
        L_0x00a4:
            r1 = r5
            goto L_0x00a8
        L_0x00a6:
            r1 = r5
            r8 = r12
        L_0x00a8:
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r13, r10)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            r9.measure(r6, r1)
            if (r11 == 0) goto L_0x00bb
            int r1 = r9.getMeasuredHeight()
            int r5 = r5 - r1
            goto L_0x00c2
        L_0x00bb:
            if (r7 == 0) goto L_0x00c2
            int r1 = r9.getMeasuredWidth()
            int r3 = r3 - r1
        L_0x00c2:
            int r2 = r2 + 1
            r1 = 0
            goto L_0x003f
        L_0x00c7:
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r8)
            r0.u = r1
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r8)
            r0.v = r1
            r0.w = r7
            r16.c()
            r1 = 0
            r0.w = r1
            int r2 = r16.getChildCount()
        L_0x00df:
            if (r1 >= r2) goto L_0x0109
            android.view.View r4 = r0.getChildAt(r1)
            int r5 = r4.getVisibility()
            if (r5 == r6) goto L_0x0106
            android.view.ViewGroup$LayoutParams r5 = r4.getLayoutParams()
            com.garena.android.uikit.image.browser.BBTouchViewPager$c r5 = (com.garena.android.uikit.image.browser.BBTouchViewPager.c) r5
            if (r5 == 0) goto L_0x00f7
            boolean r7 = r5.f7756a
            if (r7 != 0) goto L_0x0106
        L_0x00f7:
            float r7 = (float) r3
            float r5 = r5.f7758c
            float r7 = r7 * r5
            int r5 = (int) r7
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r8)
            int r7 = r0.v
            r4.measure(r5, r7)
        L_0x0106:
            int r1 = r1 + 1
            goto L_0x00df
        L_0x0109:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.garena.android.uikit.image.browser.BBTouchViewPager.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            int i6 = this.o;
            a(i2, i4, i6, i6);
        }
    }

    private void a(int i2, int i3, int i4, int i5) {
        if (i3 <= 0 || this.f7744e.isEmpty()) {
            b b2 = b(this.i);
            int min = (int) ((b2 != null ? Math.min(b2.f7755e, this.t) : BitmapDescriptorFactory.HUE_RED) * ((float) ((i2 - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                a(false);
                scrollTo(min, getScrollY());
                return;
            }
            return;
        }
        int scrollX = (int) ((((float) getScrollX()) / ((float) (((i3 - getPaddingLeft()) - getPaddingRight()) + i5))) * ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)));
        scrollTo(scrollX, getScrollY());
        if (!this.m.isFinished()) {
            this.m.startScroll(scrollX, 0, (int) (b(this.i).f7755e * ((float) i2)), 0, this.m.getDuration() - this.m.timePassed());
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        boolean z3;
        int i6;
        int i7;
        int childCount = getChildCount();
        int i8 = i4 - i2;
        int i9 = i5 - i3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i10 = paddingBottom;
        int i11 = 0;
        int i12 = paddingTop;
        int i13 = paddingLeft;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f7756a) {
                    int i15 = cVar.f7757b & 7;
                    int i16 = cVar.f7757b & 112;
                    if (i15 == 1) {
                        i6 = Math.max((i8 - childAt.getMeasuredWidth()) / 2, i13);
                    } else if (i15 == 3) {
                        i6 = i13;
                        i13 = childAt.getMeasuredWidth() + i13;
                    } else if (i15 != 5) {
                        i6 = i13;
                    } else {
                        i6 = (i8 - paddingRight) - childAt.getMeasuredWidth();
                        paddingRight += childAt.getMeasuredWidth();
                    }
                    if (i16 == 16) {
                        i7 = Math.max((i9 - childAt.getMeasuredHeight()) / 2, i12);
                    } else if (i16 == 48) {
                        i7 = i12;
                        i12 = childAt.getMeasuredHeight() + i12;
                    } else if (i16 != 80) {
                        i7 = i12;
                    } else {
                        i7 = (i9 - i10) - childAt.getMeasuredHeight();
                        i10 += childAt.getMeasuredHeight();
                    }
                    int i17 = i6 + scrollX;
                    childAt.layout(i17, i7, childAt.getMeasuredWidth() + i17, i7 + childAt.getMeasuredHeight());
                    i11++;
                }
            }
        }
        int i18 = (i8 - i13) - paddingRight;
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt2 = getChildAt(i19);
            if (childAt2.getVisibility() != 8) {
                c cVar2 = (c) childAt2.getLayoutParams();
                if (!cVar2.f7756a) {
                    b a2 = a(childAt2);
                    if (a2 != null) {
                        float f2 = (float) i18;
                        int i20 = ((int) (a2.f7755e * f2)) + i13;
                        if (cVar2.f7759d) {
                            cVar2.f7759d = false;
                            childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f2 * cVar2.f7758c), 1073741824), View.MeasureSpec.makeMeasureSpec((i9 - i12) - i10, 1073741824));
                        }
                        childAt2.layout(i20, i12, childAt2.getMeasuredWidth() + i20, childAt2.getMeasuredHeight() + i12);
                    }
                }
            }
        }
        this.q = i12;
        this.r = i9 - i10;
        this.V = i11;
        if (this.S) {
            z3 = false;
            a(this.i, false, 0, false);
        } else {
            z3 = false;
        }
        this.S = z3;
    }

    public void computeScroll() {
        if (this.m.isFinished() || !this.m.computeScrollOffset()) {
            a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.m.getCurrX();
        int currY = this.m.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!d(currX)) {
                this.m.abortAnimation();
                scrollTo(0, currY);
            }
        }
        w.e(this);
    }

    private boolean d(int i2) {
        if (this.f7744e.size() == 0) {
            this.U = false;
            a(0, (float) BitmapDescriptorFactory.HUE_RED, 0);
            if (this.U) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        b i3 = i();
        int clientWidth = getClientWidth();
        int i4 = this.o;
        int i5 = clientWidth + i4;
        float f2 = (float) clientWidth;
        int i6 = i3.f7752b;
        float f3 = ((((float) i2) / f2) - i3.f7755e) / (i3.f7754d + (((float) i4) / f2));
        this.U = false;
        a(i6, f3, (int) (((float) i5) * f3));
        if (this.U) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.V
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L_0x006d
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r4
            r4 = r3
            r3 = 0
        L_0x001d:
            if (r3 >= r6) goto L_0x006d
            android.view.View r8 = r12.getChildAt(r3)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            com.garena.android.uikit.image.browser.BBTouchViewPager$c r9 = (com.garena.android.uikit.image.browser.BBTouchViewPager.c) r9
            boolean r10 = r9.f7756a
            if (r10 != 0) goto L_0x002e
            goto L_0x006a
        L_0x002e:
            int r9 = r9.f7757b
            r9 = r9 & 7
            if (r9 == r2) goto L_0x004f
            r10 = 3
            if (r9 == r10) goto L_0x0049
            r10 = 5
            if (r9 == r10) goto L_0x003c
            r9 = r4
            goto L_0x005e
        L_0x003c:
            int r9 = r5 - r7
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r7 = r7 + r10
            goto L_0x005b
        L_0x0049:
            int r9 = r8.getWidth()
            int r9 = r9 + r4
            goto L_0x005e
        L_0x004f:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r4)
        L_0x005b:
            r11 = r9
            r9 = r4
            r4 = r11
        L_0x005e:
            int r4 = r4 + r0
            int r10 = r8.getLeft()
            int r4 = r4 - r10
            if (r4 == 0) goto L_0x0069
            r8.offsetLeftAndRight(r4)
        L_0x0069:
            r4 = r9
        L_0x006a:
            int r3 = r3 + 1
            goto L_0x001d
        L_0x006d:
            com.garena.android.uikit.image.browser.BBTouchViewPager$f r0 = r12.W
            if (r0 == 0) goto L_0x0074
            r0.a(r13, r14, r15)
        L_0x0074:
            com.garena.android.uikit.image.browser.BBTouchViewPager$f r0 = r12.aa
            if (r0 == 0) goto L_0x007b
            r0.a(r13, r14, r15)
        L_0x007b:
            com.garena.android.uikit.image.browser.BBTouchViewPager$g r13 = r12.ac
            if (r13 == 0) goto L_0x00ac
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L_0x0087:
            if (r1 >= r14) goto L_0x00ac
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            com.garena.android.uikit.image.browser.BBTouchViewPager$c r0 = (com.garena.android.uikit.image.browser.BBTouchViewPager.c) r0
            boolean r0 = r0.f7756a
            if (r0 == 0) goto L_0x0098
            goto L_0x00a9
        L_0x0098:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            com.garena.android.uikit.image.browser.BBTouchViewPager$g r3 = r12.ac
            r3.a(r15, r0)
        L_0x00a9:
            int r1 = r1 + 1
            goto L_0x0087
        L_0x00ac:
            r12.U = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.garena.android.uikit.image.browser.BBTouchViewPager.a(int, float, int):void");
    }

    private void a(boolean z2) {
        boolean z3 = this.ai == 2;
        if (z3) {
            setScrollingCacheEnabled(false);
            this.m.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.m.getCurrX();
            int currY = this.m.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
        }
        this.y = false;
        boolean z4 = z3;
        for (int i2 = 0; i2 < this.f7744e.size(); i2++) {
            b bVar = this.f7744e.get(i2);
            if (bVar.f7753c) {
                bVar.f7753c = false;
                z4 = true;
            }
        }
        if (!z4) {
            return;
        }
        if (z2) {
            w.a((View) this, this.ah);
        } else {
            this.ah.run();
        }
    }

    private boolean a(float f2, float f3) {
        return (f2 < ((float) this.D) && f3 > BitmapDescriptorFactory.HUE_RED) || (f2 > ((float) (getWidth() - this.D)) && f3 < BitmapDescriptorFactory.HUE_RED);
    }

    private void b(boolean z2) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            w.a(getChildAt(i2), z2 ? 2 : 0, (Paint) null);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.A = false;
            this.B = false;
            this.J = -1;
            VelocityTracker velocityTracker = this.K;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.K = null;
            }
            return false;
        }
        if (action != 0) {
            if (this.A) {
                return true;
            }
            if (this.B) {
                return false;
            }
        }
        if (action == 0) {
            float x2 = motionEvent.getX();
            this.H = x2;
            this.F = x2;
            float y2 = motionEvent.getY();
            this.I = y2;
            this.G = y2;
            this.J = androidx.core.g.i.b(motionEvent, 0);
            this.B = false;
            this.m.computeScrollOffset();
            if (this.ai != 2 || Math.abs(this.m.getFinalX() - this.m.getCurrX()) <= this.O) {
                a(false);
                this.A = false;
            } else {
                this.m.abortAnimation();
                this.y = false;
                c();
                this.A = true;
                c(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i2 = this.J;
            if (i2 != -1) {
                int a2 = androidx.core.g.i.a(motionEvent, i2);
                float c2 = androidx.core.g.i.c(motionEvent, a2);
                float f2 = c2 - this.F;
                float abs = Math.abs(f2);
                float d2 = androidx.core.g.i.d(motionEvent, a2);
                Math.abs(d2 - this.I);
                if (f2 != BitmapDescriptorFactory.HUE_RED && !a(this.F, f2)) {
                    if (a(this, false, (int) f2, (int) c2, (int) d2)) {
                        this.F = c2;
                        this.G = d2;
                        this.B = true;
                        return false;
                    }
                }
                if (abs > ((float) this.E)) {
                    this.A = true;
                    c(true);
                    setScrollState(1);
                    this.F = f2 > BitmapDescriptorFactory.HUE_RED ? this.H + ((float) this.E) : this.H - ((float) this.E);
                    this.G = d2;
                    setScrollingCacheEnabled(true);
                }
                if (this.A && b(c2)) {
                    w.e(this);
                }
            }
        } else if (action == 6) {
            a(motionEvent);
        }
        if (this.K == null) {
            this.K = VelocityTracker.obtain();
        }
        this.K.addMovement(motionEvent);
        return this.A;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        boolean z3;
        if (this.P) {
            return true;
        }
        boolean z4 = false;
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        androidx.viewpager.widget.a aVar = this.h;
        if (aVar == null || aVar.getCount() == 0) {
            return false;
        }
        if (this.K == null) {
            this.K = VelocityTracker.obtain();
        }
        this.K.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (!this.A) {
                        int a2 = androidx.core.g.i.a(motionEvent, this.J);
                        float c2 = androidx.core.g.i.c(motionEvent, a2);
                        float abs = Math.abs(c2 - this.F);
                        float d2 = androidx.core.g.i.d(motionEvent, a2);
                        float abs2 = Math.abs(d2 - this.G);
                        if (abs > ((float) this.E) && abs > abs2) {
                            this.A = true;
                            c(true);
                            float f2 = this.H;
                            this.F = c2 - f2 > BitmapDescriptorFactory.HUE_RED ? f2 + ((float) this.E) : f2 - ((float) this.E);
                            this.G = d2;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                    if (this.A) {
                        z4 = false | b(androidx.core.g.i.c(motionEvent, androidx.core.g.i.a(motionEvent, this.J)));
                    }
                } else if (action != 3) {
                    if (action == 5) {
                        int b2 = androidx.core.g.i.b(motionEvent);
                        this.F = androidx.core.g.i.c(motionEvent, b2);
                        this.J = androidx.core.g.i.b(motionEvent, b2);
                    } else if (action == 6) {
                        a(motionEvent);
                        this.F = androidx.core.g.i.c(motionEvent, androidx.core.g.i.a(motionEvent, this.J));
                    }
                } else if (this.A) {
                    a(this.i, true, 0, false);
                    this.J = -1;
                    j();
                    z2 = this.Q.c();
                    z3 = this.R.c();
                }
            } else if (this.A) {
                VelocityTracker velocityTracker = this.K;
                velocityTracker.computeCurrentVelocity(1000, (float) this.M);
                int a3 = (int) v.a(velocityTracker, this.J);
                this.y = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                b i2 = i();
                a(a(i2.f7752b, ((((float) scrollX) / ((float) clientWidth)) - i2.f7755e) / i2.f7754d, a3, (int) (androidx.core.g.i.c(motionEvent, androidx.core.g.i.a(motionEvent, this.J)) - this.H)), true, true, a3);
                this.J = -1;
                j();
                z2 = this.Q.c();
                z3 = this.R.c();
            }
            z4 = z2 | z3;
        } else {
            this.m.abortAnimation();
            this.y = false;
            c();
            float x2 = motionEvent.getX();
            this.H = x2;
            this.F = x2;
            float y2 = motionEvent.getY();
            this.I = y2;
            this.G = y2;
            this.J = androidx.core.g.i.b(motionEvent, 0);
        }
        if (z4) {
            w.e(this);
        }
        return true;
    }

    private void c(boolean z2) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z2);
        }
    }

    private boolean b(float f2) {
        boolean z2;
        float f3 = this.F - f2;
        this.F = f2;
        float scrollX = ((float) getScrollX()) + f3;
        float clientWidth = (float) getClientWidth();
        float f4 = this.s * clientWidth;
        float f5 = this.t * clientWidth;
        boolean z3 = false;
        b bVar = this.f7744e.get(0);
        ArrayList<b> arrayList = this.f7744e;
        boolean z4 = true;
        b bVar2 = arrayList.get(arrayList.size() - 1);
        if (bVar.f7752b != 0) {
            f4 = bVar.f7755e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (bVar2.f7752b != this.h.getCount() - 1) {
            f5 = bVar2.f7755e * clientWidth;
            z4 = false;
        }
        if (scrollX < f4) {
            if (z2) {
                z3 = this.Q.a(Math.abs(f4 - scrollX) / clientWidth);
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z4) {
                z3 = this.R.a(Math.abs(scrollX - f5) / clientWidth);
            }
            scrollX = f5;
        }
        int i2 = (int) scrollX;
        this.F += scrollX - ((float) i2);
        scrollTo(i2, getScrollY());
        d(i2);
        return z3;
    }

    private b i() {
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : BitmapDescriptorFactory.HUE_RED;
        float f2 = clientWidth > 0 ? ((float) this.o) / ((float) clientWidth) : BitmapDescriptorFactory.HUE_RED;
        b bVar = null;
        int i2 = 0;
        boolean z2 = true;
        int i3 = -1;
        float f3 = BitmapDescriptorFactory.HUE_RED;
        float f4 = BitmapDescriptorFactory.HUE_RED;
        while (i2 < this.f7744e.size()) {
            b bVar2 = this.f7744e.get(i2);
            if (!z2) {
                int i4 = i3 + 1;
                if (bVar2.f7752b != i4) {
                    bVar2 = this.f7745f;
                    bVar2.f7755e = f3 + f4 + f2;
                    bVar2.f7752b = i4;
                    bVar2.f7754d = this.h.getPageWidth(bVar2.f7752b);
                    i2--;
                }
            }
            f3 = bVar2.f7755e;
            float f5 = bVar2.f7754d + f3 + f2;
            if (!z2 && scrollX < f3) {
                return bVar;
            }
            if (scrollX < f5 || i2 == this.f7744e.size() - 1) {
                return bVar2;
            }
            i3 = bVar2.f7752b;
            f4 = bVar2.f7754d;
            i2++;
            bVar = bVar2;
            z2 = false;
        }
        return bVar;
    }

    private int a(int i2, float f2, int i3, int i4) {
        if (Math.abs(i4) <= this.N || Math.abs(i3) <= this.L) {
            i2 = (int) (((float) i2) + f2 + (i2 >= this.i ? 0.4f : 0.6f));
        } else if (i3 <= 0) {
            i2++;
        }
        if (this.f7744e.size() <= 0) {
            return i2;
        }
        ArrayList<b> arrayList = this.f7744e;
        return Math.max(this.f7744e.get(0).f7752b, Math.min(i2, arrayList.get(arrayList.size() - 1).f7752b));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r0.getCount() > 1) goto L_0x0024;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r8) {
        /*
            r7 = this;
            super.draw(r8)
            int r0 = androidx.core.g.w.a(r7)
            r1 = 0
            if (r0 == 0) goto L_0x0024
            r2 = 1
            if (r0 != r2) goto L_0x0018
            androidx.viewpager.widget.a r0 = r7.h
            if (r0 == 0) goto L_0x0018
            int r0 = r0.getCount()
            if (r0 <= r2) goto L_0x0018
            goto L_0x0024
        L_0x0018:
            androidx.core.widget.d r8 = r7.Q
            r8.b()
            androidx.core.widget.d r8 = r7.R
            r8.b()
            goto L_0x00a9
        L_0x0024:
            androidx.core.widget.d r0 = r7.Q
            boolean r0 = r0.a()
            if (r0 != 0) goto L_0x0065
            int r0 = r8.save()
            int r2 = r7.getHeight()
            int r3 = r7.getPaddingTop()
            int r2 = r2 - r3
            int r3 = r7.getPaddingBottom()
            int r2 = r2 - r3
            int r3 = r7.getWidth()
            r4 = 1132920832(0x43870000, float:270.0)
            r8.rotate(r4)
            int r4 = -r2
            int r5 = r7.getPaddingTop()
            int r4 = r4 + r5
            float r4 = (float) r4
            float r5 = r7.s
            float r6 = (float) r3
            float r5 = r5 * r6
            r8.translate(r4, r5)
            androidx.core.widget.d r4 = r7.Q
            r4.a(r2, r3)
            androidx.core.widget.d r2 = r7.Q
            boolean r2 = r2.a((android.graphics.Canvas) r8)
            r1 = r1 | r2
            r8.restoreToCount(r0)
        L_0x0065:
            androidx.core.widget.d r0 = r7.R
            boolean r0 = r0.a()
            if (r0 != 0) goto L_0x00a9
            int r0 = r8.save()
            int r2 = r7.getWidth()
            int r3 = r7.getHeight()
            int r4 = r7.getPaddingTop()
            int r3 = r3 - r4
            int r4 = r7.getPaddingBottom()
            int r3 = r3 - r4
            r4 = 1119092736(0x42b40000, float:90.0)
            r8.rotate(r4)
            int r4 = r7.getPaddingTop()
            int r4 = -r4
            float r4 = (float) r4
            float r5 = r7.t
            r6 = 1065353216(0x3f800000, float:1.0)
            float r5 = r5 + r6
            float r5 = -r5
            float r6 = (float) r2
            float r5 = r5 * r6
            r8.translate(r4, r5)
            androidx.core.widget.d r4 = r7.R
            r4.a(r3, r2)
            androidx.core.widget.d r2 = r7.R
            boolean r2 = r2.a((android.graphics.Canvas) r8)
            r1 = r1 | r2
            r8.restoreToCount(r0)
        L_0x00a9:
            if (r1 == 0) goto L_0x00ae
            androidx.core.g.w.e(r7)
        L_0x00ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.garena.android.uikit.image.browser.BBTouchViewPager.draw(android.graphics.Canvas):void");
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        super.onDraw(canvas);
        if (this.o > 0 && this.p != null && this.f7744e.size() > 0 && this.h != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f5 = (float) width;
            float f6 = ((float) this.o) / f5;
            int i2 = 0;
            b bVar = this.f7744e.get(0);
            float f7 = bVar.f7755e;
            int size = this.f7744e.size();
            int i3 = bVar.f7752b;
            int i4 = this.f7744e.get(size - 1).f7752b;
            while (i3 < i4) {
                while (i3 > bVar.f7752b && i2 < size) {
                    i2++;
                    bVar = this.f7744e.get(i2);
                }
                if (i3 == bVar.f7752b) {
                    f3 = (bVar.f7755e + bVar.f7754d) * f5;
                    f2 = bVar.f7755e + bVar.f7754d + f6;
                } else {
                    float pageWidth = this.h.getPageWidth(i3);
                    f2 = f7 + pageWidth + f6;
                    f3 = (f7 + pageWidth) * f5;
                }
                int i5 = this.o;
                if (((float) i5) + f3 > ((float) scrollX)) {
                    f4 = f6;
                    this.p.setBounds((int) f3, this.q, (int) (((float) i5) + f3 + 0.5f), this.r);
                    this.p.draw(canvas);
                } else {
                    Canvas canvas2 = canvas;
                    f4 = f6;
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i3++;
                    f7 = f2;
                    f6 = f4;
                } else {
                    return;
                }
            }
        }
    }

    private void a(MotionEvent motionEvent) {
        int b2 = androidx.core.g.i.b(motionEvent);
        if (androidx.core.g.i.b(motionEvent, b2) == this.J) {
            int i2 = b2 == 0 ? 1 : 0;
            this.F = androidx.core.g.i.c(motionEvent, i2);
            this.J = androidx.core.g.i.b(motionEvent, i2);
            VelocityTracker velocityTracker = this.K;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void j() {
        this.A = false;
        this.B = false;
        VelocityTracker velocityTracker = this.K;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.K = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z2) {
        if (this.x != z2) {
            this.x = z2;
        }
    }

    public boolean canScrollHorizontally(int i2) {
        if (this.h == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i2 < 0) {
            if (scrollX > ((int) (((float) clientWidth) * this.s))) {
                return true;
            }
            return false;
        } else if (i2 <= 0 || scrollX >= ((int) (((float) clientWidth) * this.t))) {
            return false;
        } else {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(View view, boolean z2, int i2, int i3, int i4) {
        View view2 = view;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i3 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight()) {
                    int i6 = i4 + scrollY;
                    if (i6 >= childAt.getTop() && i6 < childAt.getBottom()) {
                        if (a(childAt, true, i2, i5 - childAt.getLeft(), i6 - childAt.getTop())) {
                            return true;
                        }
                    }
                }
            }
        }
        if (!z2 || !w.a(view, -i2)) {
            return false;
        }
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || a(keyEvent);
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                return c(17);
            }
            if (keyCode == 22) {
                return c(66);
            }
            if (keyCode == 61 && Build.VERSION.SDK_INT >= 11) {
                if (KeyEventCompat.hasNoModifiers(keyEvent)) {
                    return c(2);
                }
                if (KeyEventCompat.hasModifiers(keyEvent, 1)) {
                    return c(1);
                }
            }
        }
        return false;
    }

    public boolean c(int i2) {
        boolean requestFocus;
        boolean z2;
        View findFocus = findFocus();
        boolean z3 = false;
        View view = null;
        if (findFocus != this) {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z2 = false;
                        break;
                    } else if (parent == this) {
                        z2 = true;
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (!z2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ");
                        sb.append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i2);
        if (findNextFocus != null && findNextFocus != view) {
            if (i2 == 17) {
                int i3 = a(this.f7746g, findNextFocus).left;
                int i4 = a(this.f7746g, view).left;
                if (view == null || i3 < i4) {
                    requestFocus = findNextFocus.requestFocus();
                } else {
                    requestFocus = d();
                }
            } else if (i2 == 66) {
                int i5 = a(this.f7746g, findNextFocus).left;
                int i6 = a(this.f7746g, view).left;
                if (view == null || i5 > i6) {
                    requestFocus = findNextFocus.requestFocus();
                } else {
                    requestFocus = e();
                }
            }
            z3 = requestFocus;
        } else if (i2 == 17 || i2 == 1) {
            z3 = d();
        } else if (i2 == 66 || i2 == 2) {
            z3 = e();
        }
        if (z3) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i2));
        }
        return z3;
    }

    private Rect a(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        int i2 = this.i;
        if (i2 <= 0) {
            return false;
        }
        a(i2 - 1, true);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        androidx.viewpager.widget.a aVar = this.h;
        if (aVar == null || this.i >= aVar.getCount() - 1) {
            return false;
        }
        a(this.i + 1, true);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0) {
                    b a2 = a(childAt);
                    if (a2 != null && a2.f7752b == this.i) {
                        childAt.addFocusables(arrayList, i2, i3);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i3 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                b a2 = a(childAt);
                if (a2 != null && a2.f7752b == this.i) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        int childCount = getChildCount();
        int i5 = -1;
        if ((i2 & 2) != 0) {
            i5 = childCount;
            i4 = 0;
            i3 = 1;
        } else {
            i4 = childCount - 1;
            i3 = -1;
        }
        while (i4 != i5) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 0) {
                b a2 = a(childAt);
                if (a2 != null && a2.f7752b == this.i && childAt.requestFocus(i2, rect)) {
                    return true;
                }
            }
            i4 += i3;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                b a2 = a(childAt);
                if (a2 != null && a2.f7752b == this.i && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof c) && super.checkLayoutParams(layoutParams);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    class d extends androidx.core.g.a {
        d() {
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            androidx.core.g.a.f a2 = androidx.core.g.a.f.a();
            a2.a(a());
            if (accessibilityEvent.getEventType() == 4096 && BBTouchViewPager.this.h != null) {
                a2.a(BBTouchViewPager.this.h.getCount());
                a2.b(BBTouchViewPager.this.i);
                a2.c(BBTouchViewPager.this.i);
            }
        }

        public void onInitializeAccessibilityNodeInfo(View view, androidx.core.g.a.d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            dVar.b((CharSequence) ViewPager.class.getName());
            dVar.k(a());
            if (BBTouchViewPager.this.canScrollHorizontally(1)) {
                dVar.a(4096);
            }
            if (BBTouchViewPager.this.canScrollHorizontally(-1)) {
                dVar.a(8192);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (i != 4096) {
                if (i != 8192 || !BBTouchViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                BBTouchViewPager bBTouchViewPager = BBTouchViewPager.this;
                bBTouchViewPager.setCurrentItem(bBTouchViewPager.i - 1);
                return true;
            } else if (!BBTouchViewPager.this.canScrollHorizontally(1)) {
                return false;
            } else {
                BBTouchViewPager bBTouchViewPager2 = BBTouchViewPager.this;
                bBTouchViewPager2.setCurrentItem(bBTouchViewPager2.i + 1);
                return true;
            }
        }

        private boolean a() {
            return BBTouchViewPager.this.h != null && BBTouchViewPager.this.h.getCount() > 1;
        }
    }

    private class h extends DataSetObserver {
        private h() {
        }

        public void onChanged() {
            BBTouchViewPager.this.b();
        }

        public void onInvalidated() {
            BBTouchViewPager.this.b();
        }
    }

    public static class c extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f7756a;

        /* renamed from: b  reason: collision with root package name */
        public int f7757b;

        /* renamed from: c  reason: collision with root package name */
        float f7758c = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: d  reason: collision with root package name */
        boolean f7759d;

        /* renamed from: e  reason: collision with root package name */
        int f7760e;

        /* renamed from: f  reason: collision with root package name */
        int f7761f;

        public c() {
            super(-1, -1);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, BBTouchViewPager.f7740a);
            this.f7757b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    static class i implements Comparator<View> {
        i() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            c cVar = (c) view.getLayoutParams();
            c cVar2 = (c) view2.getLayoutParams();
            if (cVar.f7756a != cVar2.f7756a) {
                return cVar.f7756a ? 1 : -1;
            }
            return cVar.f7760e - cVar2.f7760e;
        }
    }
}
