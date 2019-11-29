package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.g.a.d;
import androidx.core.g.x;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.a;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.d;
import androidx.recyclerview.widget.h;
import androidx.recyclerview.widget.t;
import androidx.recyclerview.widget.u;
import com.facebook.common.time.Clock;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import com.tencent.imsdk.TIMGroupManager;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tencent.tls.platform.SigType;

public class RecyclerView extends ViewGroup implements androidx.core.g.k {
    static final Interpolator L = new Interpolator() {
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    private static final int[] M = {16843830};
    private static final int[] N = {16842987};
    private static final boolean O = (Build.VERSION.SDK_INT <= 15);
    private static final boolean P = (Build.VERSION.SDK_INT <= 15);
    private static final Class<?>[] Q = {Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};

    /* renamed from: a  reason: collision with root package name */
    static final boolean f2701a = (Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20);

    /* renamed from: b  reason: collision with root package name */
    static final boolean f2702b = (Build.VERSION.SDK_INT >= 23);

    /* renamed from: c  reason: collision with root package name */
    static final boolean f2703c = (Build.VERSION.SDK_INT >= 16);

    /* renamed from: d  reason: collision with root package name */
    static final boolean f2704d = (Build.VERSION.SDK_INT >= 21);
    final v A;
    h B;
    h.a C;
    final t D;
    boolean E;
    boolean F;
    boolean G;
    q H;
    final int[] I;
    final int[] J;
    final List<w> K;
    private final r R;
    private SavedState S;
    private final Rect T;
    private final ArrayList<m> U;
    private m V;
    private int W;
    private List<n> aA;
    private f.b aB;
    private d aC;
    private final int[] aD;
    private androidx.core.g.m aE;
    private final int[] aF;
    private final int[] aG;
    private Runnable aH;
    private final u.b aI;
    private boolean aa;
    private int ab;
    private final AccessibilityManager ac;
    private List<k> ad;
    private int ae;
    private int af;
    private e ag;
    private EdgeEffect ah;
    private EdgeEffect ai;
    private EdgeEffect aj;
    private EdgeEffect ak;
    private int al;
    private int am;
    private VelocityTracker an;
    private int ao;
    private int ap;
    private int aq;
    private int ar;
    private int as;
    private l at;
    private final int au;
    private final int av;
    private float aw;
    private float ax;
    private boolean ay;
    private n az;

    /* renamed from: e  reason: collision with root package name */
    final p f2705e;

    /* renamed from: f  reason: collision with root package name */
    a f2706f;

    /* renamed from: g  reason: collision with root package name */
    d f2707g;
    final u h;
    boolean i;
    final Runnable j;
    final Rect k;
    final RectF l;
    a m;
    i n;
    q o;
    final ArrayList<h> p;
    boolean q;
    boolean r;
    boolean s;
    boolean t;
    boolean u;
    boolean v;
    boolean w;
    boolean x;
    boolean y;
    f z;

    public interface d {
        int a(int i, int i2);
    }

    public interface k {
        void a(View view);

        void b(View view);
    }

    public static abstract class l {
        public abstract boolean a(int i, int i2);
    }

    public interface m {
        void a(boolean z);

        boolean a(RecyclerView recyclerView, MotionEvent motionEvent);

        void b(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public static abstract class n {
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public interface q {
        void a(w wVar);
    }

    public static abstract class u {
        public abstract View a(p pVar, int i, int i2);
    }

    public void h(int i2) {
    }

    public void h(int i2, int i3) {
    }

    public void h(View view) {
    }

    public void i(View view) {
    }

    public RecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.R = new r();
        this.f2705e = new p();
        this.h = new u();
        this.j = new Runnable() {
            public void run() {
                if (RecyclerView.this.t && !RecyclerView.this.isLayoutRequested()) {
                    if (!RecyclerView.this.q) {
                        RecyclerView.this.requestLayout();
                    } else if (RecyclerView.this.v) {
                        RecyclerView.this.u = true;
                    } else {
                        RecyclerView.this.d();
                    }
                }
            }
        };
        this.k = new Rect();
        this.T = new Rect();
        this.l = new RectF();
        this.p = new ArrayList<>();
        this.U = new ArrayList<>();
        this.W = 0;
        this.x = false;
        this.y = false;
        this.ae = 0;
        this.af = 0;
        this.ag = new e();
        this.z = new e();
        this.al = 0;
        this.am = -1;
        this.aw = Float.MIN_VALUE;
        this.ax = Float.MIN_VALUE;
        boolean z2 = true;
        this.ay = true;
        this.A = new v();
        this.C = f2704d ? new h.a() : null;
        this.D = new t();
        this.E = false;
        this.F = false;
        this.aB = new g();
        this.G = false;
        this.aD = new int[2];
        this.aF = new int[2];
        this.I = new int[2];
        this.aG = new int[2];
        this.J = new int[2];
        this.K = new ArrayList();
        this.aH = new Runnable() {
            public void run() {
                if (RecyclerView.this.z != null) {
                    RecyclerView.this.z.runPendingAnimations();
                }
                RecyclerView.this.G = false;
            }
        };
        this.aI = new u.b() {
            public void a(w wVar, f.c cVar, f.c cVar2) {
                RecyclerView.this.f2705e.c(wVar);
                RecyclerView.this.b(wVar, cVar, cVar2);
            }

            public void b(w wVar, f.c cVar, f.c cVar2) {
                RecyclerView.this.a(wVar, cVar, cVar2);
            }

            public void c(w wVar, f.c cVar, f.c cVar2) {
                wVar.setIsRecyclable(false);
                if (RecyclerView.this.x) {
                    if (RecyclerView.this.z.animateChange(wVar, wVar, cVar, cVar2)) {
                        RecyclerView.this.p();
                    }
                } else if (RecyclerView.this.z.animatePersistence(wVar, cVar, cVar2)) {
                    RecyclerView.this.p();
                }
            }

            public void a(w wVar) {
                RecyclerView.this.n.a(wVar.itemView, RecyclerView.this.f2705e);
            }
        };
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, N, i2, 0);
            this.i = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.i = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.as = viewConfiguration.getScaledTouchSlop();
        this.aw = x.a(viewConfiguration, context);
        this.ax = x.b(viewConfiguration, context);
        this.au = viewConfiguration.getScaledMinimumFlingVelocity();
        this.av = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.z.setListener(this.aB);
        b();
        z();
        y();
        if (androidx.core.g.w.f(this) == 0) {
            androidx.core.g.w.d((View) this, 1);
        }
        this.ac = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new q(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, a.c.RecyclerView, i2, 0);
            String string = obtainStyledAttributes2.getString(a.c.RecyclerView_layoutManager);
            if (obtainStyledAttributes2.getInt(a.c.RecyclerView_android_descendantFocusability, -1) == -1) {
                setDescendantFocusability(SigType.D2);
            }
            this.s = obtainStyledAttributes2.getBoolean(a.c.RecyclerView_fastScrollEnabled, false);
            if (this.s) {
                a((StateListDrawable) obtainStyledAttributes2.getDrawable(a.c.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes2.getDrawable(a.c.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes2.getDrawable(a.c.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes2.getDrawable(a.c.RecyclerView_fastScrollHorizontalTrackDrawable));
            }
            obtainStyledAttributes2.recycle();
            a(context, string, attributeSet, i2, 0);
            if (Build.VERSION.SDK_INT >= 21) {
                TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, M, i2, 0);
                boolean z3 = obtainStyledAttributes3.getBoolean(0, true);
                obtainStyledAttributes3.recycle();
                z2 = z3;
            }
        } else {
            setDescendantFocusability(SigType.D2);
        }
        setNestedScrollingEnabled(z2);
    }

    /* access modifiers changed from: package-private */
    public String a() {
        return SQLBuilder.BLANK + super.toString() + ", adapter:" + this.m + ", layout:" + this.n + ", context:" + getContext();
    }

    @SuppressLint({"InlinedApi"})
    private void y() {
        if (androidx.core.g.w.b(this) == 0) {
            androidx.core.g.w.c((View) this, 8);
        }
    }

    public q getCompatAccessibilityDelegate() {
        return this.H;
    }

    public void setAccessibilityDelegateCompat(q qVar) {
        this.H = qVar;
        androidx.core.g.w.a((View) this, (androidx.core.g.a) this.H);
    }

    private void a(Context context, String str, AttributeSet attributeSet, int i2, int i3) {
        ClassLoader classLoader;
        Constructor<? extends U> constructor;
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String a2 = a(context, trim);
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = classLoader.loadClass(a2).asSubclass(i.class);
                    Object[] objArr = null;
                    try {
                        constructor = asSubclass.getConstructor(Q);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
                    } catch (NoSuchMethodException e2) {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((i) constructor.newInstance(objArr));
                } catch (NoSuchMethodException e3) {
                    e3.initCause(e2);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + a2, e3);
                } catch (ClassNotFoundException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + a2, e4);
                } catch (InvocationTargetException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a2, e5);
                } catch (InstantiationException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a2, e6);
                } catch (IllegalAccessException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + a2, e7);
                } catch (ClassCastException e8) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + a2, e8);
                }
            }
        }
    }

    private String a(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(".")) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + '.' + str;
        }
    }

    private void z() {
        this.f2707g = new d(new d.b() {
            public int a() {
                return RecyclerView.this.getChildCount();
            }

            public void a(View view, int i) {
                RecyclerView.this.addView(view, i);
                RecyclerView.this.m(view);
            }

            public int a(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            public void a(int i) {
                View childAt = RecyclerView.this.getChildAt(i);
                if (childAt != null) {
                    RecyclerView.this.l(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i);
            }

            public View b(int i) {
                return RecyclerView.this.getChildAt(i);
            }

            public void b() {
                int a2 = a();
                for (int i = 0; i < a2; i++) {
                    View b2 = b(i);
                    RecyclerView.this.l(b2);
                    b2.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            public w b(View view) {
                return RecyclerView.e(view);
            }

            public void a(View view, int i, ViewGroup.LayoutParams layoutParams) {
                w e2 = RecyclerView.e(view);
                if (e2 != null) {
                    if (e2.isTmpDetached() || e2.shouldIgnore()) {
                        e2.clearTmpDetachFlag();
                    } else {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + e2 + RecyclerView.this.a());
                    }
                }
                RecyclerView.this.attachViewToParent(view, i, layoutParams);
            }

            public void c(int i) {
                View b2 = b(i);
                if (b2 != null) {
                    w e2 = RecyclerView.e(b2);
                    if (e2 != null) {
                        if (!e2.isTmpDetached() || e2.shouldIgnore()) {
                            e2.addFlags(256);
                        } else {
                            throw new IllegalArgumentException("called detach on an already detached child " + e2 + RecyclerView.this.a());
                        }
                    }
                }
                RecyclerView.this.detachViewFromParent(i);
            }

            public void c(View view) {
                w e2 = RecyclerView.e(view);
                if (e2 != null) {
                    e2.onEnteredHiddenState(RecyclerView.this);
                }
            }

            public void d(View view) {
                w e2 = RecyclerView.e(view);
                if (e2 != null) {
                    e2.onLeftHiddenState(RecyclerView.this);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f2706f = new a(new a.C0062a() {
            public w a(int i) {
                w a2 = RecyclerView.this.a(i, true);
                if (a2 != null && !RecyclerView.this.f2707g.c(a2.itemView)) {
                    return a2;
                }
                return null;
            }

            public void a(int i, int i2) {
                RecyclerView.this.a(i, i2, true);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.E = true;
                recyclerView.D.f2766c += i2;
            }

            public void b(int i, int i2) {
                RecyclerView.this.a(i, i2, false);
                RecyclerView.this.E = true;
            }

            public void a(int i, int i2, Object obj) {
                RecyclerView.this.a(i, i2, obj);
                RecyclerView.this.F = true;
            }

            public void a(a.b bVar) {
                c(bVar);
            }

            /* access modifiers changed from: package-private */
            public void c(a.b bVar) {
                int i = bVar.f2821a;
                if (i == 1) {
                    RecyclerView.this.n.a(RecyclerView.this, bVar.f2822b, bVar.f2824d);
                } else if (i == 2) {
                    RecyclerView.this.n.b(RecyclerView.this, bVar.f2822b, bVar.f2824d);
                } else if (i == 4) {
                    RecyclerView.this.n.a(RecyclerView.this, bVar.f2822b, bVar.f2824d, bVar.f2823c);
                } else if (i == 8) {
                    RecyclerView.this.n.a(RecyclerView.this, bVar.f2822b, bVar.f2824d, 1);
                }
            }

            public void b(a.b bVar) {
                c(bVar);
            }

            public void c(int i, int i2) {
                RecyclerView.this.g(i, i2);
                RecyclerView.this.E = true;
            }

            public void d(int i, int i2) {
                RecyclerView.this.f(i, i2);
                RecyclerView.this.E = true;
            }
        });
    }

    public void setHasFixedSize(boolean z2) {
        this.r = z2;
    }

    public void setClipToPadding(boolean z2) {
        if (z2 != this.i) {
            k();
        }
        this.i = z2;
        super.setClipToPadding(z2);
        if (this.t) {
            requestLayout();
        }
    }

    public boolean getClipToPadding() {
        return this.i;
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 != 1) {
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
            } else {
                this.as = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.as = viewConfiguration.getScaledTouchSlop();
    }

    public void setAdapter(a aVar) {
        setLayoutFrozen(false);
        a(aVar, false, true);
        c(false);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void c() {
        f fVar = this.z;
        if (fVar != null) {
            fVar.endAnimations();
        }
        i iVar = this.n;
        if (iVar != null) {
            iVar.c(this.f2705e);
            this.n.b(this.f2705e);
        }
        this.f2705e.a();
    }

    private void a(a aVar, boolean z2, boolean z3) {
        a aVar2 = this.m;
        if (aVar2 != null) {
            aVar2.unregisterAdapterDataObserver(this.R);
            this.m.onDetachedFromRecyclerView(this);
        }
        if (!z2 || z3) {
            c();
        }
        this.f2706f.a();
        a aVar3 = this.m;
        this.m = aVar;
        if (aVar != null) {
            aVar.registerAdapterDataObserver(this.R);
            aVar.onAttachedToRecyclerView(this);
        }
        i iVar = this.n;
        if (iVar != null) {
            iVar.a(aVar3, this.m);
        }
        this.f2705e.a(aVar3, this.m, z2);
        this.D.f2769f = true;
    }

    public a getAdapter() {
        return this.m;
    }

    public void setRecyclerListener(q qVar) {
        this.o = qVar;
    }

    public int getBaseline() {
        i iVar = this.n;
        if (iVar != null) {
            return iVar.x();
        }
        return super.getBaseline();
    }

    public void a(k kVar) {
        if (this.ad == null) {
            this.ad = new ArrayList();
        }
        this.ad.add(kVar);
    }

    public void b(k kVar) {
        List<k> list = this.ad;
        if (list != null) {
            list.remove(kVar);
        }
    }

    public void setLayoutManager(i iVar) {
        if (iVar != this.n) {
            f();
            if (this.n != null) {
                f fVar = this.z;
                if (fVar != null) {
                    fVar.endAnimations();
                }
                this.n.c(this.f2705e);
                this.n.b(this.f2705e);
                this.f2705e.a();
                if (this.q) {
                    this.n.b(this, this.f2705e);
                }
                this.n.b((RecyclerView) null);
                this.n = null;
            } else {
                this.f2705e.a();
            }
            this.f2707g.a();
            this.n = iVar;
            if (iVar != null) {
                if (iVar.q == null) {
                    this.n.b(this);
                    if (this.q) {
                        this.n.c(this);
                    }
                } else {
                    throw new IllegalArgumentException("LayoutManager " + iVar + " is already attached to a RecyclerView:" + iVar.q.a());
                }
            }
            this.f2705e.b();
            requestLayout();
        }
    }

    public void setOnFlingListener(l lVar) {
        this.at = lVar;
    }

    public l getOnFlingListener() {
        return this.at;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.S;
        if (savedState2 != null) {
            savedState.a(savedState2);
        } else {
            i iVar = this.n;
            if (iVar != null) {
                savedState.f2713a = iVar.e();
            } else {
                savedState.f2713a = null;
            }
        }
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.S = (SavedState) parcelable;
        super.onRestoreInstanceState(this.S.a());
        if (this.n != null && this.S.f2713a != null) {
            this.n.a(this.S.f2713a);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void e(w wVar) {
        View view = wVar.itemView;
        boolean z2 = view.getParent() == this;
        this.f2705e.c(b(view));
        if (wVar.isTmpDetached()) {
            this.f2707g.a(view, -1, view.getLayoutParams(), true);
        } else if (!z2) {
            this.f2707g.a(view, true);
        } else {
            this.f2707g.d(view);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(View view) {
        e();
        boolean f2 = this.f2707g.f(view);
        if (f2) {
            w e2 = e(view);
            this.f2705e.c(e2);
            this.f2705e.b(e2);
        }
        a(!f2);
        return f2;
    }

    public i getLayoutManager() {
        return this.n;
    }

    public o getRecycledViewPool() {
        return this.f2705e.g();
    }

    public void setRecycledViewPool(o oVar) {
        this.f2705e.a(oVar);
    }

    public void setViewCacheExtension(u uVar) {
        this.f2705e.a(uVar);
    }

    public void setItemViewCacheSize(int i2) {
        this.f2705e.a(i2);
    }

    public int getScrollState() {
        return this.al;
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i2) {
        if (i2 != this.al) {
            this.al = i2;
            if (i2 != 2) {
                B();
            }
            i(i2);
        }
    }

    public void a(h hVar, int i2) {
        i iVar = this.n;
        if (iVar != null) {
            iVar.a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.p.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.p.add(hVar);
        } else {
            this.p.add(i2, hVar);
        }
        r();
        requestLayout();
    }

    public void a(h hVar) {
        a(hVar, -1);
    }

    public int getItemDecorationCount() {
        return this.p.size();
    }

    public void b(h hVar) {
        i iVar = this.n;
        if (iVar != null) {
            iVar.a("Cannot remove item decoration during a scroll  or layout");
        }
        this.p.remove(hVar);
        if (this.p.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        r();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(d dVar) {
        if (dVar != this.aC) {
            this.aC = dVar;
            setChildrenDrawingOrderEnabled(this.aC != null);
        }
    }

    @Deprecated
    public void setOnScrollListener(n nVar) {
        this.az = nVar;
    }

    public void a(n nVar) {
        if (this.aA == null) {
            this.aA = new ArrayList();
        }
        this.aA.add(nVar);
    }

    public void b(n nVar) {
        List<n> list = this.aA;
        if (list != null) {
            list.remove(nVar);
        }
    }

    public void b(int i2) {
        if (!this.v) {
            f();
            i iVar = this.n;
            if (iVar == null) {
                Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            iVar.e(i2);
            awakenScrollBars();
        }
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        i iVar = this.n;
        if (iVar != null) {
            iVar.e(i2);
            awakenScrollBars();
        }
    }

    public void d(int i2) {
        if (!this.v) {
            i iVar = this.n;
            if (iVar == null) {
                Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                iVar.a(this, this.D, i2);
            }
        }
    }

    public void scrollTo(int i2, int i3) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollBy(int i2, int i3) {
        i iVar = this.n;
        if (iVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.v) {
            boolean f2 = iVar.f();
            boolean g2 = this.n.g();
            if (f2 || g2) {
                if (!f2) {
                    i2 = 0;
                }
                if (!g2) {
                    i3 = 0;
                }
                a(i2, i3, (MotionEvent) null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, int[] iArr) {
        e();
        l();
        androidx.core.d.f.a("RV Scroll");
        a(this.D);
        int a2 = i2 != 0 ? this.n.a(i2, this.f2705e, this.D) : 0;
        int b2 = i3 != 0 ? this.n.b(i3, this.f2705e, this.D) : 0;
        androidx.core.d.f.a();
        w();
        m();
        a(false);
        if (iArr != null) {
            iArr[0] = a2;
            iArr[1] = b2;
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (!this.t || this.x) {
            androidx.core.d.f.a("RV FullInvalidate");
            q();
            androidx.core.d.f.a();
        } else if (this.f2706f.d()) {
            if (this.f2706f.a(4) && !this.f2706f.a(11)) {
                androidx.core.d.f.a("RV PartialInvalidate");
                e();
                l();
                this.f2706f.b();
                if (!this.u) {
                    if (A()) {
                        q();
                    } else {
                        this.f2706f.c();
                    }
                }
                a(true);
                m();
                androidx.core.d.f.a();
            } else if (this.f2706f.d()) {
                androidx.core.d.f.a("RV FullInvalidate");
                q();
                androidx.core.d.f.a();
            }
        }
    }

    private boolean A() {
        int b2 = this.f2707g.b();
        for (int i2 = 0; i2 < b2; i2++) {
            w e2 = e(this.f2707g.b(i2));
            if (e2 != null && !e2.shouldIgnore() && e2.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x009b, code lost:
        if (r0 != 0) goto L_0x00a0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(int r19, int r20, android.view.MotionEvent r21) {
        /*
            r18 = this;
            r7 = r18
            r8 = r19
            r9 = r20
            r10 = r21
            r18.d()
            androidx.recyclerview.widget.RecyclerView$a r0 = r7.m
            r11 = 1
            r12 = 0
            if (r0 == 0) goto L_0x0025
            int[] r0 = r7.J
            r7.a((int) r8, (int) r9, (int[]) r0)
            int[] r0 = r7.J
            r1 = r0[r12]
            r0 = r0[r11]
            int r2 = r8 - r1
            int r3 = r9 - r0
            r6 = r0
            r15 = r1
            r13 = r2
            r14 = r3
            goto L_0x0029
        L_0x0025:
            r6 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x0029:
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$h> r0 = r7.p
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0034
            r18.invalidate()
        L_0x0034:
            int[] r5 = r7.aF
            r16 = 0
            r0 = r18
            r1 = r15
            r2 = r6
            r3 = r13
            r4 = r14
            r17 = r6
            r6 = r16
            boolean r0 = r0.a((int) r1, (int) r2, (int) r3, (int) r4, (int[]) r5, (int) r6)
            if (r0 == 0) goto L_0x0076
            int r0 = r7.aq
            int[] r1 = r7.aF
            r2 = r1[r12]
            int r0 = r0 - r2
            r7.aq = r0
            int r0 = r7.ar
            r2 = r1[r11]
            int r0 = r0 - r2
            r7.ar = r0
            if (r10 == 0) goto L_0x0063
            r0 = r1[r12]
            float r0 = (float) r0
            r1 = r1[r11]
            float r1 = (float) r1
            r10.offsetLocation(r0, r1)
        L_0x0063:
            int[] r0 = r7.aG
            r1 = r0[r12]
            int[] r2 = r7.aF
            r3 = r2[r12]
            int r1 = r1 + r3
            r0[r12] = r1
            r1 = r0[r11]
            r2 = r2[r11]
            int r1 = r1 + r2
            r0[r11] = r1
            goto L_0x0097
        L_0x0076:
            int r0 = r18.getOverScrollMode()
            r1 = 2
            if (r0 == r1) goto L_0x0097
            if (r10 == 0) goto L_0x0094
            r0 = 8194(0x2002, float:1.1482E-41)
            boolean r0 = androidx.core.g.i.e(r10, r0)
            if (r0 != 0) goto L_0x0094
            float r0 = r21.getX()
            float r1 = (float) r13
            float r2 = r21.getY()
            float r3 = (float) r14
            r7.a((float) r0, (float) r1, (float) r2, (float) r3)
        L_0x0094:
            r18.c(r19, r20)
        L_0x0097:
            if (r15 != 0) goto L_0x009e
            r0 = r17
            if (r0 == 0) goto L_0x00a3
            goto L_0x00a0
        L_0x009e:
            r0 = r17
        L_0x00a0:
            r7.i(r15, r0)
        L_0x00a3:
            boolean r1 = r18.awakenScrollBars()
            if (r1 != 0) goto L_0x00ac
            r18.invalidate()
        L_0x00ac:
            if (r15 != 0) goto L_0x00b0
            if (r0 == 0) goto L_0x00b1
        L_0x00b0:
            r12 = 1
        L_0x00b1:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.a(int, int, android.view.MotionEvent):boolean");
    }

    public int computeHorizontalScrollOffset() {
        i iVar = this.n;
        if (iVar != null && iVar.f()) {
            return this.n.c(this.D);
        }
        return 0;
    }

    public int computeHorizontalScrollExtent() {
        i iVar = this.n;
        if (iVar != null && iVar.f()) {
            return this.n.e(this.D);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        i iVar = this.n;
        if (iVar != null && iVar.f()) {
            return this.n.g(this.D);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        i iVar = this.n;
        if (iVar != null && iVar.g()) {
            return this.n.d(this.D);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        i iVar = this.n;
        if (iVar != null && iVar.g()) {
            return this.n.f(this.D);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        i iVar = this.n;
        if (iVar != null && iVar.g()) {
            return this.n.h(this.D);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.W++;
        if (this.W == 1 && !this.v) {
            this.u = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        if (this.W < 1) {
            this.W = 1;
        }
        if (!z2 && !this.v) {
            this.u = false;
        }
        if (this.W == 1) {
            if (z2 && this.u && !this.v && this.n != null && this.m != null) {
                q();
            }
            if (!this.v) {
                this.u = false;
            }
        }
        this.W--;
    }

    public void setLayoutFrozen(boolean z2) {
        if (z2 != this.v) {
            a("Do not setLayoutFrozen in layout or scroll");
            if (!z2) {
                this.v = false;
                if (!(!this.u || this.n == null || this.m == null)) {
                    requestLayout();
                }
                this.u = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0));
            this.v = true;
            this.aa = true;
            f();
        }
    }

    public void a(int i2, int i3) {
        a(i2, i3, (Interpolator) null);
    }

    public void a(int i2, int i3, Interpolator interpolator) {
        i iVar = this.n;
        if (iVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.v) {
            if (!iVar.f()) {
                i2 = 0;
            }
            if (!this.n.g()) {
                i3 = 0;
            }
            if (i2 != 0 || i3 != 0) {
                this.A.a(i2, i3, interpolator);
            }
        }
    }

    public boolean b(int i2, int i3) {
        i iVar = this.n;
        int i4 = 0;
        if (iVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.v) {
            return false;
        } else {
            boolean f2 = iVar.f();
            boolean g2 = this.n.g();
            if (!f2 || Math.abs(i2) < this.au) {
                i2 = 0;
            }
            if (!g2 || Math.abs(i3) < this.au) {
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return false;
            }
            float f3 = (float) i2;
            float f4 = (float) i3;
            if (!dispatchNestedPreFling(f3, f4)) {
                boolean z2 = f2 || g2;
                dispatchNestedFling(f3, f4, z2);
                l lVar = this.at;
                if (lVar != null && lVar.a(i2, i3)) {
                    return true;
                }
                if (z2) {
                    if (f2) {
                        i4 = 1;
                    }
                    if (g2) {
                        i4 |= 2;
                    }
                    j(i4, 1);
                    int i5 = this.av;
                    int max = Math.max(-i5, Math.min(i2, i5));
                    int i6 = this.av;
                    this.A.a(max, Math.max(-i6, Math.min(i3, i6)));
                    return true;
                }
            }
            return false;
        }
    }

    public void f() {
        setScrollState(0);
        B();
    }

    private void B() {
        this.A.b();
        i iVar = this.n;
        if (iVar != null) {
            iVar.L();
        }
    }

    public int getMinFlingVelocity() {
        return this.au;
    }

    public int getMaxFlingVelocity() {
        return this.av;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0021
            r6.g()
            android.widget.EdgeEffect r3 = r6.ah
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
            androidx.core.widget.d.a(r3, r4, r9)
        L_0x001f:
            r9 = 1
            goto L_0x003c
        L_0x0021:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x003b
            r6.h()
            android.widget.EdgeEffect r3 = r6.aj
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            androidx.core.widget.d.a(r3, r4, r9)
            goto L_0x001f
        L_0x003b:
            r9 = 0
        L_0x003c:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0056
            r6.i()
            android.widget.EdgeEffect r9 = r6.ai
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            androidx.core.widget.d.a(r9, r0, r7)
            goto L_0x0072
        L_0x0056:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x0071
            r6.j()
            android.widget.EdgeEffect r9 = r6.ak
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            androidx.core.widget.d.a(r9, r3, r0)
            goto L_0x0072
        L_0x0071:
            r1 = r9
        L_0x0072:
            if (r1 != 0) goto L_0x007c
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L_0x007c
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L_0x007f
        L_0x007c:
            androidx.core.g.w.e(r6)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.a(float, float, float, float):void");
    }

    private void C() {
        boolean z2;
        EdgeEffect edgeEffect = this.ah;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z2 = this.ah.isFinished();
        } else {
            z2 = false;
        }
        EdgeEffect edgeEffect2 = this.ai;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z2 |= this.ai.isFinished();
        }
        EdgeEffect edgeEffect3 = this.aj;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z2 |= this.aj.isFinished();
        }
        EdgeEffect edgeEffect4 = this.ak;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z2 |= this.ak.isFinished();
        }
        if (z2) {
            androidx.core.g.w.e(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(int i2, int i3) {
        boolean z2;
        EdgeEffect edgeEffect = this.ah;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            z2 = false;
        } else {
            this.ah.onRelease();
            z2 = this.ah.isFinished();
        }
        EdgeEffect edgeEffect2 = this.aj;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.aj.onRelease();
            z2 |= this.aj.isFinished();
        }
        EdgeEffect edgeEffect3 = this.ai;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.ai.onRelease();
            z2 |= this.ai.isFinished();
        }
        EdgeEffect edgeEffect4 = this.ak;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.ak.onRelease();
            z2 |= this.ak.isFinished();
        }
        if (z2) {
            androidx.core.g.w.e(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void d(int i2, int i3) {
        if (i2 < 0) {
            g();
            this.ah.onAbsorb(-i2);
        } else if (i2 > 0) {
            h();
            this.aj.onAbsorb(i2);
        }
        if (i3 < 0) {
            i();
            this.ai.onAbsorb(-i3);
        } else if (i3 > 0) {
            j();
            this.ak.onAbsorb(i3);
        }
        if (i2 != 0 || i3 != 0) {
            androidx.core.g.w.e(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (this.ah == null) {
            this.ah = this.ag.a(this, 0);
            if (this.i) {
                this.ah.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.ah.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void h() {
        if (this.aj == null) {
            this.aj = this.ag.a(this, 2);
            if (this.i) {
                this.aj.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.aj.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void i() {
        if (this.ai == null) {
            this.ai = this.ag.a(this, 1);
            if (this.i) {
                this.ai.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.ai.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        if (this.ak == null) {
            this.ak = this.ag.a(this, 3);
            if (this.i) {
                this.ak.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.ak.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void k() {
        this.ak = null;
        this.ai = null;
        this.aj = null;
        this.ah = null;
    }

    public void setEdgeEffectFactory(e eVar) {
        androidx.core.util.e.a(eVar);
        this.ag = eVar;
        k();
    }

    public e getEdgeEffectFactory() {
        return this.ag;
    }

    public View focusSearch(View view, int i2) {
        View view2;
        boolean z2;
        View d2 = this.n.d(view, i2);
        if (d2 != null) {
            return d2;
        }
        boolean z3 = this.m != null && this.n != null && !o() && !this.v;
        FocusFinder instance = FocusFinder.getInstance();
        if (!z3 || !(i2 == 2 || i2 == 1)) {
            View findNextFocus = instance.findNextFocus(this, view, i2);
            if (findNextFocus != null || !z3) {
                view2 = findNextFocus;
            } else {
                d();
                if (c(view) == null) {
                    return null;
                }
                e();
                view2 = this.n.a(view, i2, this.f2705e, this.D);
                a(false);
            }
        } else {
            if (this.n.g()) {
                int i3 = i2 == 2 ? 130 : 33;
                z2 = instance.findNextFocus(this, view, i3) == null;
                if (O) {
                    i2 = i3;
                }
            } else {
                z2 = false;
            }
            if (!z2 && this.n.f()) {
                int i4 = (this.n.w() == 1) ^ (i2 == 2) ? 66 : 17;
                z2 = instance.findNextFocus(this, view, i4) == null;
                if (O) {
                    i2 = i4;
                }
            }
            if (z2) {
                d();
                if (c(view) == null) {
                    return null;
                }
                e();
                this.n.a(view, i2, this.f2705e, this.D);
                a(false);
            }
            view2 = instance.findNextFocus(this, view, i2);
        }
        if (view2 == null || view2.hasFocusable()) {
            return a(view, view2, i2) ? view2 : super.focusSearch(view, i2);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        }
        a(view2, (View) null);
        return view;
    }

    private boolean a(View view, View view2, int i2) {
        int i3;
        if (view2 == null || view2 == this || c(view2) == null) {
            return false;
        }
        if (view == null || c(view) == null) {
            return true;
        }
        this.k.set(0, 0, view.getWidth(), view.getHeight());
        this.T.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.k);
        offsetDescendantRectToMyCoords(view2, this.T);
        char c2 = 65535;
        int i4 = this.n.w() == 1 ? -1 : 1;
        if ((this.k.left < this.T.left || this.k.right <= this.T.left) && this.k.right < this.T.right) {
            i3 = 1;
        } else {
            i3 = ((this.k.right > this.T.right || this.k.left >= this.T.right) && this.k.left > this.T.left) ? -1 : 0;
        }
        if ((this.k.top < this.T.top || this.k.bottom <= this.T.top) && this.k.bottom < this.T.bottom) {
            c2 = 1;
        } else if ((this.k.bottom <= this.T.bottom && this.k.top < this.T.bottom) || this.k.top <= this.T.top) {
            c2 = 0;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 17) {
                    if (i2 != 33) {
                        if (i2 != 66) {
                            if (i2 != 130) {
                                throw new IllegalArgumentException("Invalid direction: " + i2 + a());
                            } else if (c2 > 0) {
                                return true;
                            } else {
                                return false;
                            }
                        } else if (i3 > 0) {
                            return true;
                        } else {
                            return false;
                        }
                    } else if (c2 < 0) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (i3 < 0) {
                    return true;
                } else {
                    return false;
                }
            } else if (c2 > 0 || (c2 == 0 && i3 * i4 >= 0)) {
                return true;
            } else {
                return false;
            }
        } else if (c2 < 0 || (c2 == 0 && i3 * i4 <= 0)) {
            return true;
        } else {
            return false;
        }
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.n.a(this, this.D, view, view2) && view2 != null) {
            a(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    private void a(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.k.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof j) {
            j jVar = (j) layoutParams;
            if (!jVar.f2734e) {
                Rect rect = jVar.f2733d;
                this.k.left -= rect.left;
                this.k.right += rect.right;
                this.k.top -= rect.top;
                this.k.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.k);
            offsetRectIntoDescendantCoords(view, this.k);
        }
        this.n.a(this, view, this.k, !this.t, view2 == null);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.n.a(this, view, rect, z2);
    }

    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        i iVar = this.n;
        if (iVar == null || !iVar.a(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (o()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        if (r0 >= 30.0f) goto L_0x0054;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAttachedToWindow() {
        /*
            r4 = this;
            super.onAttachedToWindow()
            r0 = 0
            r4.ae = r0
            r1 = 1
            r4.q = r1
            boolean r2 = r4.t
            if (r2 == 0) goto L_0x0014
            boolean r2 = r4.isLayoutRequested()
            if (r2 != 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            r4.t = r1
            androidx.recyclerview.widget.RecyclerView$i r1 = r4.n
            if (r1 == 0) goto L_0x001e
            r1.c((androidx.recyclerview.widget.RecyclerView) r4)
        L_0x001e:
            r4.G = r0
            boolean r0 = f2704d
            if (r0 == 0) goto L_0x0069
            java.lang.ThreadLocal<androidx.recyclerview.widget.h> r0 = androidx.recyclerview.widget.h.f2907a
            java.lang.Object r0 = r0.get()
            androidx.recyclerview.widget.h r0 = (androidx.recyclerview.widget.h) r0
            r4.B = r0
            androidx.recyclerview.widget.h r0 = r4.B
            if (r0 != 0) goto L_0x0064
            androidx.recyclerview.widget.h r0 = new androidx.recyclerview.widget.h
            r0.<init>()
            r4.B = r0
            android.view.Display r0 = androidx.core.g.w.F(r4)
            r1 = 1114636288(0x42700000, float:60.0)
            boolean r2 = r4.isInEditMode()
            if (r2 != 0) goto L_0x0052
            if (r0 == 0) goto L_0x0052
            float r0 = r0.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0052
            goto L_0x0054
        L_0x0052:
            r0 = 1114636288(0x42700000, float:60.0)
        L_0x0054:
            androidx.recyclerview.widget.h r1 = r4.B
            r2 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r2 = r2 / r0
            long r2 = (long) r2
            r1.f2911d = r2
            java.lang.ThreadLocal<androidx.recyclerview.widget.h> r0 = androidx.recyclerview.widget.h.f2907a
            androidx.recyclerview.widget.h r1 = r4.B
            r0.set(r1)
        L_0x0064:
            androidx.recyclerview.widget.h r0 = r4.B
            r0.a((androidx.recyclerview.widget.RecyclerView) r4)
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f fVar = this.z;
        if (fVar != null) {
            fVar.endAnimations();
        }
        f();
        this.q = false;
        i iVar = this.n;
        if (iVar != null) {
            iVar.b(this, this.f2705e);
        }
        this.K.clear();
        removeCallbacks(this.aH);
        this.h.b();
        if (f2704d) {
            h hVar = this.B;
            if (hVar != null) {
                hVar.b(this);
                this.B = null;
            }
        }
    }

    public boolean isAttachedToWindow() {
        return this.q;
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        if (o()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + a());
            }
            throw new IllegalStateException(str);
        } else if (this.af > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + a()));
        }
    }

    public void a(m mVar) {
        this.U.add(mVar);
    }

    public void b(m mVar) {
        this.U.remove(mVar);
        if (this.V == mVar) {
            this.V = null;
        }
    }

    private boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.V = null;
        }
        int size = this.U.size();
        int i2 = 0;
        while (i2 < size) {
            m mVar = this.U.get(i2);
            if (!mVar.a(this, motionEvent) || action == 3) {
                i2++;
            } else {
                this.V = mVar;
                return true;
            }
        }
        return false;
    }

    private boolean b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        m mVar = this.V;
        if (mVar != null) {
            if (action == 0) {
                this.V = null;
            } else {
                mVar.b(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.V = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.U.size();
            for (int i2 = 0; i2 < size; i2++) {
                m mVar2 = this.U.get(i2);
                if (mVar2.a(this, motionEvent)) {
                    this.V = mVar2;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.v) {
            return false;
        }
        if (a(motionEvent)) {
            E();
            return true;
        }
        i iVar = this.n;
        if (iVar == null) {
            return false;
        }
        boolean f2 = iVar.f();
        boolean g2 = this.n.g();
        if (this.an == null) {
            this.an = VelocityTracker.obtain();
        }
        this.an.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.aa) {
                this.aa = false;
            }
            this.am = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.aq = x2;
            this.ao = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.ar = y2;
            this.ap = y2;
            if (this.al == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
            int[] iArr = this.aG;
            iArr[1] = 0;
            iArr[0] = 0;
            int i2 = f2 ? 1 : 0;
            if (g2) {
                i2 |= 2;
            }
            j(i2, 0);
        } else if (actionMasked == 1) {
            this.an.clear();
            a(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.am);
            if (findPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.am + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.al != 1) {
                int i3 = x3 - this.ao;
                int i4 = y3 - this.ap;
                if (!f2 || Math.abs(i3) <= this.as) {
                    z2 = false;
                } else {
                    this.aq = x3;
                    z2 = true;
                }
                if (g2 && Math.abs(i4) > this.as) {
                    this.ar = y3;
                    z2 = true;
                }
                if (z2) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            E();
        } else if (actionMasked == 5) {
            this.am = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.aq = x4;
            this.ao = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.ar = y4;
            this.ap = y4;
        } else if (actionMasked == 6) {
            c(motionEvent);
        }
        if (this.al == 1) {
            return true;
        }
        return false;
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.U.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.U.get(i2).a(z2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x011c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r15) {
        /*
            r14 = this;
            boolean r0 = r14.v
            r1 = 0
            if (r0 != 0) goto L_0x01c7
            boolean r0 = r14.aa
            if (r0 == 0) goto L_0x000b
            goto L_0x01c7
        L_0x000b:
            boolean r0 = r14.b((android.view.MotionEvent) r15)
            r2 = 1
            if (r0 == 0) goto L_0x0016
            r14.E()
            return r2
        L_0x0016:
            androidx.recyclerview.widget.RecyclerView$i r0 = r14.n
            if (r0 != 0) goto L_0x001b
            return r1
        L_0x001b:
            boolean r0 = r0.f()
            androidx.recyclerview.widget.RecyclerView$i r3 = r14.n
            boolean r3 = r3.g()
            android.view.VelocityTracker r4 = r14.an
            if (r4 != 0) goto L_0x002f
            android.view.VelocityTracker r4 = android.view.VelocityTracker.obtain()
            r14.an = r4
        L_0x002f:
            android.view.MotionEvent r4 = android.view.MotionEvent.obtain(r15)
            int r5 = r15.getActionMasked()
            int r6 = r15.getActionIndex()
            if (r5 != 0) goto L_0x0043
            int[] r7 = r14.aG
            r7[r2] = r1
            r7[r1] = r1
        L_0x0043:
            int[] r7 = r14.aG
            r8 = r7[r1]
            float r8 = (float) r8
            r7 = r7[r2]
            float r7 = (float) r7
            r4.offsetLocation(r8, r7)
            r7 = 1056964608(0x3f000000, float:0.5)
            if (r5 == 0) goto L_0x0196
            if (r5 == r2) goto L_0x0154
            r8 = 2
            if (r5 == r8) goto L_0x0088
            r0 = 3
            if (r5 == r0) goto L_0x0083
            r0 = 5
            if (r5 == r0) goto L_0x0067
            r0 = 6
            if (r5 == r0) goto L_0x0062
            goto L_0x01bc
        L_0x0062:
            r14.c((android.view.MotionEvent) r15)
            goto L_0x01bc
        L_0x0067:
            int r0 = r15.getPointerId(r6)
            r14.am = r0
            float r0 = r15.getX(r6)
            float r0 = r0 + r7
            int r0 = (int) r0
            r14.aq = r0
            r14.ao = r0
            float r15 = r15.getY(r6)
            float r15 = r15 + r7
            int r15 = (int) r15
            r14.ar = r15
            r14.ap = r15
            goto L_0x01bc
        L_0x0083:
            r14.E()
            goto L_0x01bc
        L_0x0088:
            int r5 = r14.am
            int r5 = r15.findPointerIndex(r5)
            if (r5 >= 0) goto L_0x00ae
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r0 = "Error processing scroll; pointer index for id "
            r15.append(r0)
            int r0 = r14.am
            r15.append(r0)
            java.lang.String r0 = " not found. Did any MotionEvents get skipped?"
            r15.append(r0)
            java.lang.String r15 = r15.toString()
            java.lang.String r0 = "RecyclerView"
            android.util.Log.e(r0, r15)
            return r1
        L_0x00ae:
            float r6 = r15.getX(r5)
            float r6 = r6 + r7
            int r6 = (int) r6
            float r15 = r15.getY(r5)
            float r15 = r15 + r7
            int r15 = (int) r15
            int r5 = r14.aq
            int r5 = r5 - r6
            int r7 = r14.ar
            int r13 = r7 - r15
            int[] r10 = r14.I
            int[] r11 = r14.aF
            r12 = 0
            r7 = r14
            r8 = r5
            r9 = r13
            boolean r7 = r7.a((int) r8, (int) r9, (int[]) r10, (int[]) r11, (int) r12)
            if (r7 == 0) goto L_0x00f4
            int[] r7 = r14.I
            r8 = r7[r1]
            int r5 = r5 - r8
            r7 = r7[r2]
            int r13 = r13 - r7
            int[] r7 = r14.aF
            r8 = r7[r1]
            float r8 = (float) r8
            r7 = r7[r2]
            float r7 = (float) r7
            r4.offsetLocation(r8, r7)
            int[] r7 = r14.aG
            r8 = r7[r1]
            int[] r9 = r14.aF
            r10 = r9[r1]
            int r8 = r8 + r10
            r7[r1] = r8
            r8 = r7[r2]
            r9 = r9[r2]
            int r8 = r8 + r9
            r7[r2] = r8
        L_0x00f4:
            int r7 = r14.al
            if (r7 == r2) goto L_0x011f
            if (r0 == 0) goto L_0x0109
            int r7 = java.lang.Math.abs(r5)
            int r8 = r14.as
            if (r7 <= r8) goto L_0x0109
            if (r5 <= 0) goto L_0x0106
            int r5 = r5 - r8
            goto L_0x0107
        L_0x0106:
            int r5 = r5 + r8
        L_0x0107:
            r7 = 1
            goto L_0x010a
        L_0x0109:
            r7 = 0
        L_0x010a:
            if (r3 == 0) goto L_0x011a
            int r8 = java.lang.Math.abs(r13)
            int r9 = r14.as
            if (r8 <= r9) goto L_0x011a
            if (r13 <= 0) goto L_0x0118
            int r13 = r13 - r9
            goto L_0x0119
        L_0x0118:
            int r13 = r13 + r9
        L_0x0119:
            r7 = 1
        L_0x011a:
            if (r7 == 0) goto L_0x011f
            r14.setScrollState(r2)
        L_0x011f:
            int r7 = r14.al
            if (r7 != r2) goto L_0x01bc
            int[] r7 = r14.aF
            r8 = r7[r1]
            int r6 = r6 - r8
            r14.aq = r6
            r6 = r7[r2]
            int r15 = r15 - r6
            r14.ar = r15
            if (r0 == 0) goto L_0x0133
            r15 = r5
            goto L_0x0134
        L_0x0133:
            r15 = 0
        L_0x0134:
            if (r3 == 0) goto L_0x0138
            r0 = r13
            goto L_0x0139
        L_0x0138:
            r0 = 0
        L_0x0139:
            boolean r15 = r14.a((int) r15, (int) r0, (android.view.MotionEvent) r4)
            if (r15 == 0) goto L_0x0146
            android.view.ViewParent r15 = r14.getParent()
            r15.requestDisallowInterceptTouchEvent(r2)
        L_0x0146:
            androidx.recyclerview.widget.h r15 = r14.B
            if (r15 == 0) goto L_0x01bc
            if (r5 != 0) goto L_0x014e
            if (r13 == 0) goto L_0x01bc
        L_0x014e:
            androidx.recyclerview.widget.h r15 = r14.B
            r15.a((androidx.recyclerview.widget.RecyclerView) r14, (int) r5, (int) r13)
            goto L_0x01bc
        L_0x0154:
            android.view.VelocityTracker r15 = r14.an
            r15.addMovement(r4)
            android.view.VelocityTracker r15 = r14.an
            r5 = 1000(0x3e8, float:1.401E-42)
            int r6 = r14.av
            float r6 = (float) r6
            r15.computeCurrentVelocity(r5, r6)
            r15 = 0
            if (r0 == 0) goto L_0x0170
            android.view.VelocityTracker r0 = r14.an
            int r5 = r14.am
            float r0 = r0.getXVelocity(r5)
            float r0 = -r0
            goto L_0x0171
        L_0x0170:
            r0 = 0
        L_0x0171:
            if (r3 == 0) goto L_0x017d
            android.view.VelocityTracker r3 = r14.an
            int r5 = r14.am
            float r3 = r3.getYVelocity(r5)
            float r3 = -r3
            goto L_0x017e
        L_0x017d:
            r3 = 0
        L_0x017e:
            int r5 = (r0 > r15 ? 1 : (r0 == r15 ? 0 : -1))
            if (r5 != 0) goto L_0x0186
            int r15 = (r3 > r15 ? 1 : (r3 == r15 ? 0 : -1))
            if (r15 == 0) goto L_0x018e
        L_0x0186:
            int r15 = (int) r0
            int r0 = (int) r3
            boolean r15 = r14.b(r15, r0)
            if (r15 != 0) goto L_0x0191
        L_0x018e:
            r14.setScrollState(r1)
        L_0x0191:
            r14.D()
            r1 = 1
            goto L_0x01bc
        L_0x0196:
            int r5 = r15.getPointerId(r1)
            r14.am = r5
            float r5 = r15.getX()
            float r5 = r5 + r7
            int r5 = (int) r5
            r14.aq = r5
            r14.ao = r5
            float r15 = r15.getY()
            float r15 = r15 + r7
            int r15 = (int) r15
            r14.ar = r15
            r14.ap = r15
            if (r0 == 0) goto L_0x01b4
            r15 = 1
            goto L_0x01b5
        L_0x01b4:
            r15 = 0
        L_0x01b5:
            if (r3 == 0) goto L_0x01b9
            r15 = r15 | 2
        L_0x01b9:
            r14.j(r15, r1)
        L_0x01bc:
            if (r1 != 0) goto L_0x01c3
            android.view.VelocityTracker r15 = r14.an
            r15.addMovement(r4)
        L_0x01c3:
            r4.recycle()
            return r2
        L_0x01c7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void D() {
        VelocityTracker velocityTracker = this.an;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        a(0);
        C();
    }

    private void E() {
        D();
        setScrollState(0);
    }

    private void c(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.am) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.am = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.aq = x2;
            this.ao = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.ar = y2;
            this.ap = y2;
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f2;
        float f3;
        if (this.n != null && !this.v && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f3 = this.n.g() ? -motionEvent.getAxisValue(9) : BitmapDescriptorFactory.HUE_RED;
                if (this.n.f()) {
                    f2 = motionEvent.getAxisValue(10);
                    if (!(f3 == BitmapDescriptorFactory.HUE_RED && f2 == BitmapDescriptorFactory.HUE_RED)) {
                        a((int) (f2 * this.aw), (int) (f3 * this.ax), motionEvent);
                    }
                }
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    float axisValue = motionEvent.getAxisValue(26);
                    if (this.n.g()) {
                        f3 = -axisValue;
                    } else if (this.n.f()) {
                        f2 = axisValue;
                        f3 = BitmapDescriptorFactory.HUE_RED;
                        a((int) (f2 * this.aw), (int) (f3 * this.ax), motionEvent);
                    }
                }
                f3 = BitmapDescriptorFactory.HUE_RED;
            }
            f2 = BitmapDescriptorFactory.HUE_RED;
            a((int) (f2 * this.aw), (int) (f3 * this.ax), motionEvent);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        i iVar = this.n;
        if (iVar == null) {
            e(i2, i3);
            return;
        }
        boolean z2 = false;
        if (iVar.d()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.n.a(this.f2705e, this.D, i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z2 = true;
            }
            if (!z2 && this.m != null) {
                if (this.D.f2767d == 1) {
                    M();
                }
                this.n.d(i2, i3);
                this.D.i = true;
                N();
                this.n.e(i2, i3);
                if (this.n.m()) {
                    this.n.d(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.D.i = true;
                    N();
                    this.n.e(i2, i3);
                }
            }
        } else if (this.r) {
            this.n.a(this.f2705e, this.D, i2, i3);
        } else {
            if (this.w) {
                e();
                l();
                H();
                m();
                if (this.D.k) {
                    this.D.f2770g = true;
                } else {
                    this.f2706f.e();
                    this.D.f2770g = false;
                }
                this.w = false;
                a(false);
            } else if (this.D.k) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            a aVar = this.m;
            if (aVar != null) {
                this.D.f2768e = aVar.getItemCount();
            } else {
                this.D.f2768e = 0;
            }
            e();
            this.n.a(this.f2705e, this.D, i2, i3);
            a(false);
            this.D.f2770g = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void e(int i2, int i3) {
        setMeasuredDimension(i.a(i2, getPaddingLeft() + getPaddingRight(), androidx.core.g.w.l(this)), i.a(i3, getPaddingTop() + getPaddingBottom(), androidx.core.g.w.m(this)));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4 || i3 != i5) {
            k();
        }
    }

    public void setItemAnimator(f fVar) {
        f fVar2 = this.z;
        if (fVar2 != null) {
            fVar2.endAnimations();
            this.z.setListener((f.b) null);
        }
        this.z = fVar;
        f fVar3 = this.z;
        if (fVar3 != null) {
            fVar3.setListener(this.aB);
        }
    }

    /* access modifiers changed from: package-private */
    public void l() {
        this.ae++;
    }

    /* access modifiers changed from: package-private */
    public void m() {
        b(true);
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z2) {
        this.ae--;
        if (this.ae < 1) {
            this.ae = 0;
            if (z2) {
                F();
                x();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean n() {
        AccessibilityManager accessibilityManager = this.ac;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    private void F() {
        int i2 = this.ab;
        this.ab = 0;
        if (i2 != 0 && n()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            androidx.core.g.a.b.a(obtain, i2);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    public boolean o() {
        return this.ae > 0;
    }

    /* access modifiers changed from: package-private */
    public boolean a(AccessibilityEvent accessibilityEvent) {
        if (!o()) {
            return false;
        }
        int a2 = accessibilityEvent != null ? androidx.core.g.a.b.a(accessibilityEvent) : 0;
        if (a2 == 0) {
            a2 = 0;
        }
        this.ab = a2 | this.ab;
        return true;
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!a(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public f getItemAnimator() {
        return this.z;
    }

    /* access modifiers changed from: package-private */
    public void p() {
        if (!this.G && this.q) {
            androidx.core.g.w.a((View) this, this.aH);
            this.G = true;
        }
    }

    private boolean G() {
        return this.z != null && this.n.c();
    }

    private void H() {
        if (this.x) {
            this.f2706f.a();
            if (this.y) {
                this.n.a(this);
            }
        }
        if (G()) {
            this.f2706f.b();
        } else {
            this.f2706f.e();
        }
        boolean z2 = false;
        boolean z3 = this.E || this.F;
        this.D.j = this.t && this.z != null && (this.x || z3 || this.n.u) && (!this.x || this.m.hasStableIds());
        t tVar = this.D;
        if (tVar.j && z3 && !this.x && G()) {
            z2 = true;
        }
        tVar.k = z2;
    }

    /* access modifiers changed from: package-private */
    public void q() {
        if (this.m == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.n == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            t tVar = this.D;
            tVar.i = false;
            if (tVar.f2767d == 1) {
                M();
                this.n.f(this);
                N();
            } else if (!this.f2706f.f() && this.n.B() == getWidth() && this.n.C() == getHeight()) {
                this.n.f(this);
            } else {
                this.n.f(this);
                N();
            }
            O();
        }
    }

    private void I() {
        int i2;
        w wVar = null;
        View focusedChild = (!this.ay || !hasFocus() || this.m == null) ? null : getFocusedChild();
        if (focusedChild != null) {
            wVar = d(focusedChild);
        }
        if (wVar == null) {
            J();
            return;
        }
        this.D.m = this.m.hasStableIds() ? wVar.getItemId() : -1;
        t tVar = this.D;
        if (this.x) {
            i2 = -1;
        } else if (wVar.isRemoved()) {
            i2 = wVar.mOldPosition;
        } else {
            i2 = wVar.getAdapterPosition();
        }
        tVar.l = i2;
        this.D.n = n(wVar.itemView);
    }

    private void J() {
        t tVar = this.D;
        tVar.m = -1;
        tVar.l = -1;
        tVar.n = -1;
    }

    private View K() {
        int i2 = this.D.l != -1 ? this.D.l : 0;
        int e2 = this.D.e();
        int i3 = i2;
        while (i3 < e2) {
            w e3 = e(i3);
            if (e3 == null) {
                break;
            } else if (e3.itemView.hasFocusable()) {
                return e3.itemView;
            } else {
                i3++;
            }
        }
        int min = Math.min(e2, i2);
        while (true) {
            min--;
            if (min < 0) {
                return null;
            }
            w e4 = e(min);
            if (e4 == null) {
                return null;
            }
            if (e4.itemView.hasFocusable()) {
                return e4.itemView;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00af, code lost:
        if (r0.isFocusable() != false) goto L_0x00b3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void L() {
        /*
            r6 = this;
            boolean r0 = r6.ay
            if (r0 == 0) goto L_0x00b6
            androidx.recyclerview.widget.RecyclerView$a r0 = r6.m
            if (r0 == 0) goto L_0x00b6
            boolean r0 = r6.hasFocus()
            if (r0 == 0) goto L_0x00b6
            int r0 = r6.getDescendantFocusability()
            r1 = 393216(0x60000, float:5.51013E-40)
            if (r0 == r1) goto L_0x00b6
            int r0 = r6.getDescendantFocusability()
            r1 = 131072(0x20000, float:1.83671E-40)
            if (r0 != r1) goto L_0x0026
            boolean r0 = r6.isFocused()
            if (r0 == 0) goto L_0x0026
            goto L_0x00b6
        L_0x0026:
            boolean r0 = r6.isFocused()
            if (r0 != 0) goto L_0x0055
            android.view.View r0 = r6.getFocusedChild()
            boolean r1 = P
            if (r1 == 0) goto L_0x004c
            android.view.ViewParent r1 = r0.getParent()
            if (r1 == 0) goto L_0x0040
            boolean r1 = r0.hasFocus()
            if (r1 != 0) goto L_0x004c
        L_0x0040:
            androidx.recyclerview.widget.d r0 = r6.f2707g
            int r0 = r0.b()
            if (r0 != 0) goto L_0x0055
            r6.requestFocus()
            return
        L_0x004c:
            androidx.recyclerview.widget.d r1 = r6.f2707g
            boolean r0 = r1.c((android.view.View) r0)
            if (r0 != 0) goto L_0x0055
            return
        L_0x0055:
            androidx.recyclerview.widget.RecyclerView$t r0 = r6.D
            long r0 = r0.m
            r2 = -1
            r4 = 0
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x0071
            androidx.recyclerview.widget.RecyclerView$a r0 = r6.m
            boolean r0 = r0.hasStableIds()
            if (r0 == 0) goto L_0x0071
            androidx.recyclerview.widget.RecyclerView$t r0 = r6.D
            long r0 = r0.m
            androidx.recyclerview.widget.RecyclerView$w r0 = r6.a((long) r0)
            goto L_0x0072
        L_0x0071:
            r0 = r4
        L_0x0072:
            if (r0 == 0) goto L_0x008a
            androidx.recyclerview.widget.d r1 = r6.f2707g
            android.view.View r5 = r0.itemView
            boolean r1 = r1.c((android.view.View) r5)
            if (r1 != 0) goto L_0x008a
            android.view.View r1 = r0.itemView
            boolean r1 = r1.hasFocusable()
            if (r1 != 0) goto L_0x0087
            goto L_0x008a
        L_0x0087:
            android.view.View r4 = r0.itemView
            goto L_0x0096
        L_0x008a:
            androidx.recyclerview.widget.d r0 = r6.f2707g
            int r0 = r0.b()
            if (r0 <= 0) goto L_0x0096
            android.view.View r4 = r6.K()
        L_0x0096:
            if (r4 == 0) goto L_0x00b6
            androidx.recyclerview.widget.RecyclerView$t r0 = r6.D
            int r0 = r0.n
            long r0 = (long) r0
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x00b2
            androidx.recyclerview.widget.RecyclerView$t r0 = r6.D
            int r0 = r0.n
            android.view.View r0 = r4.findViewById(r0)
            if (r0 == 0) goto L_0x00b2
            boolean r1 = r0.isFocusable()
            if (r1 == 0) goto L_0x00b2
            goto L_0x00b3
        L_0x00b2:
            r0 = r4
        L_0x00b3:
            r0.requestFocus()
        L_0x00b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.L():void");
    }

    private int n(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.A.f2771a;
            tVar.o = overScroller.getFinalX() - overScroller.getCurrX();
            tVar.p = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        tVar.o = 0;
        tVar.p = 0;
    }

    private void M() {
        boolean z2 = true;
        this.D.a(1);
        a(this.D);
        this.D.i = false;
        e();
        this.h.a();
        l();
        H();
        I();
        t tVar = this.D;
        if (!tVar.j || !this.F) {
            z2 = false;
        }
        tVar.h = z2;
        this.F = false;
        this.E = false;
        t tVar2 = this.D;
        tVar2.f2770g = tVar2.k;
        this.D.f2768e = this.m.getItemCount();
        a(this.aD);
        if (this.D.j) {
            int b2 = this.f2707g.b();
            for (int i2 = 0; i2 < b2; i2++) {
                w e2 = e(this.f2707g.b(i2));
                if (!e2.shouldIgnore() && (!e2.isInvalid() || this.m.hasStableIds())) {
                    this.h.a(e2, this.z.recordPreLayoutInformation(this.D, e2, f.buildAdapterChangeFlagsForAnimations(e2), e2.getUnmodifiedPayloads()));
                    if (this.D.h && e2.isUpdated() && !e2.isRemoved() && !e2.shouldIgnore() && !e2.isInvalid()) {
                        this.h.a(a(e2), e2);
                    }
                }
            }
        }
        if (this.D.k) {
            s();
            boolean z3 = this.D.f2769f;
            t tVar3 = this.D;
            tVar3.f2769f = false;
            this.n.c(this.f2705e, tVar3);
            this.D.f2769f = z3;
            for (int i3 = 0; i3 < this.f2707g.b(); i3++) {
                w e3 = e(this.f2707g.b(i3));
                if (!e3.shouldIgnore() && !this.h.d(e3)) {
                    int buildAdapterChangeFlagsForAnimations = f.buildAdapterChangeFlagsForAnimations(e3);
                    boolean hasAnyOfTheFlags = e3.hasAnyOfTheFlags(8192);
                    if (!hasAnyOfTheFlags) {
                        buildAdapterChangeFlagsForAnimations |= 4096;
                    }
                    f.c recordPreLayoutInformation = this.z.recordPreLayoutInformation(this.D, e3, buildAdapterChangeFlagsForAnimations, e3.getUnmodifiedPayloads());
                    if (hasAnyOfTheFlags) {
                        a(e3, recordPreLayoutInformation);
                    } else {
                        this.h.b(e3, recordPreLayoutInformation);
                    }
                }
            }
            t();
        } else {
            t();
        }
        m();
        a(false);
        this.D.f2767d = 2;
    }

    private void N() {
        e();
        l();
        this.D.a(6);
        this.f2706f.e();
        this.D.f2768e = this.m.getItemCount();
        t tVar = this.D;
        tVar.f2766c = 0;
        tVar.f2770g = false;
        this.n.c(this.f2705e, tVar);
        t tVar2 = this.D;
        tVar2.f2769f = false;
        this.S = null;
        tVar2.j = tVar2.j && this.z != null;
        this.D.f2767d = 4;
        m();
        a(false);
    }

    private void O() {
        this.D.a(4);
        e();
        l();
        t tVar = this.D;
        tVar.f2767d = 1;
        if (tVar.j) {
            for (int b2 = this.f2707g.b() - 1; b2 >= 0; b2--) {
                w e2 = e(this.f2707g.b(b2));
                if (!e2.shouldIgnore()) {
                    long a2 = a(e2);
                    f.c recordPostLayoutInformation = this.z.recordPostLayoutInformation(this.D, e2);
                    w a3 = this.h.a(a2);
                    if (a3 == null || a3.shouldIgnore()) {
                        this.h.c(e2, recordPostLayoutInformation);
                    } else {
                        boolean a4 = this.h.a(a3);
                        boolean a5 = this.h.a(e2);
                        if (!a4 || a3 != e2) {
                            f.c b3 = this.h.b(a3);
                            this.h.c(e2, recordPostLayoutInformation);
                            f.c c2 = this.h.c(e2);
                            if (b3 == null) {
                                a(a2, e2, a3);
                            } else {
                                a(a3, e2, b3, c2, a4, a5);
                            }
                        } else {
                            this.h.c(e2, recordPostLayoutInformation);
                        }
                    }
                }
            }
            this.h.a(this.aI);
        }
        this.n.b(this.f2705e);
        t tVar2 = this.D;
        tVar2.f2765b = tVar2.f2768e;
        this.x = false;
        this.y = false;
        t tVar3 = this.D;
        tVar3.j = false;
        tVar3.k = false;
        this.n.u = false;
        if (this.f2705e.f2743b != null) {
            this.f2705e.f2743b.clear();
        }
        if (this.n.y) {
            i iVar = this.n;
            iVar.x = 0;
            iVar.y = false;
            this.f2705e.b();
        }
        this.n.a(this.D);
        m();
        a(false);
        this.h.a();
        int[] iArr = this.aD;
        if (k(iArr[0], iArr[1])) {
            i(0, 0);
        }
        L();
        J();
    }

    private void a(long j2, w wVar, w wVar2) {
        int b2 = this.f2707g.b();
        for (int i2 = 0; i2 < b2; i2++) {
            w e2 = e(this.f2707g.b(i2));
            if (e2 != wVar && a(e2) == j2) {
                a aVar = this.m;
                if (aVar == null || !aVar.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + e2 + " \n View Holder 2:" + wVar + a());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + e2 + " \n View Holder 2:" + wVar + a());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + wVar2 + " cannot be found but it is necessary for " + wVar + a());
    }

    /* access modifiers changed from: package-private */
    public void a(w wVar, f.c cVar) {
        wVar.setFlags(0, 8192);
        if (this.D.h && wVar.isUpdated() && !wVar.isRemoved() && !wVar.shouldIgnore()) {
            this.h.a(a(wVar), wVar);
        }
        this.h.a(wVar, cVar);
    }

    private void a(int[] iArr) {
        int b2 = this.f2707g.b();
        if (b2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = RNCartPanelDataEntity.NULL_VALUE;
        for (int i4 = 0; i4 < b2; i4++) {
            w e2 = e(this.f2707g.b(i4));
            if (!e2.shouldIgnore()) {
                int layoutPosition = e2.getLayoutPosition();
                if (layoutPosition < i2) {
                    i2 = layoutPosition;
                }
                if (layoutPosition > i3) {
                    i3 = layoutPosition;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    private boolean k(int i2, int i3) {
        a(this.aD);
        int[] iArr = this.aD;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    /* access modifiers changed from: protected */
    public void removeDetachedView(View view, boolean z2) {
        w e2 = e(view);
        if (e2 != null) {
            if (e2.isTmpDetached()) {
                e2.clearTmpDetachFlag();
            } else if (!e2.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + e2 + a());
            }
        }
        view.clearAnimation();
        l(view);
        super.removeDetachedView(view, z2);
    }

    /* access modifiers changed from: package-private */
    public long a(w wVar) {
        return this.m.hasStableIds() ? wVar.getItemId() : (long) wVar.mPosition;
    }

    /* access modifiers changed from: package-private */
    public void a(w wVar, f.c cVar, f.c cVar2) {
        wVar.setIsRecyclable(false);
        if (this.z.animateAppearance(wVar, cVar, cVar2)) {
            p();
        }
    }

    /* access modifiers changed from: package-private */
    public void b(w wVar, f.c cVar, f.c cVar2) {
        e(wVar);
        wVar.setIsRecyclable(false);
        if (this.z.animateDisappearance(wVar, cVar, cVar2)) {
            p();
        }
    }

    private void a(w wVar, w wVar2, f.c cVar, f.c cVar2, boolean z2, boolean z3) {
        wVar.setIsRecyclable(false);
        if (z2) {
            e(wVar);
        }
        if (wVar != wVar2) {
            if (z3) {
                e(wVar2);
            }
            wVar.mShadowedHolder = wVar2;
            e(wVar);
            this.f2705e.c(wVar);
            wVar2.setIsRecyclable(false);
            wVar2.mShadowingHolder = wVar;
        }
        if (this.z.animateChange(wVar, wVar2, cVar, cVar2)) {
            p();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        androidx.core.d.f.a("RV OnLayout");
        q();
        androidx.core.d.f.a();
        this.t = true;
    }

    public void requestLayout() {
        if (this.W != 0 || this.v) {
            this.u = true;
        } else {
            super.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void r() {
        int c2 = this.f2707g.c();
        for (int i2 = 0; i2 < c2; i2++) {
            ((j) this.f2707g.d(i2).getLayoutParams()).f2734e = true;
        }
        this.f2705e.j();
    }

    public void draw(Canvas canvas) {
        boolean z2;
        boolean z3;
        super.draw(canvas);
        int size = this.p.size();
        boolean z4 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.p.get(i2).a(canvas, this, this.D);
        }
        EdgeEffect edgeEffect = this.ah;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.i ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + paddingBottom), BitmapDescriptorFactory.HUE_RED);
            EdgeEffect edgeEffect2 = this.ah;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.ai;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.i) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.ai;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.aj;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.i ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) (-paddingTop), (float) (-width));
            EdgeEffect edgeEffect6 = this.aj;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.ak;
        if (edgeEffect7 == null || edgeEffect7.isFinished()) {
            z3 = z2;
        } else {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.i) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            EdgeEffect edgeEffect8 = this.ak;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z4 = true;
            }
            z3 = z4 | z2;
            canvas.restoreToCount(save4);
        }
        if (!z3 && this.z != null && this.p.size() > 0 && this.z.isRunning()) {
            z3 = true;
        }
        if (z3) {
            androidx.core.g.w.e(this);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.p.get(i2).b(canvas, this, this.D);
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof j) && this.n.a((j) layoutParams);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        i iVar = this.n;
        if (iVar != null) {
            return iVar.a();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + a());
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        i iVar = this.n;
        if (iVar != null) {
            return iVar.a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + a());
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        i iVar = this.n;
        if (iVar != null) {
            return iVar.a(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + a());
    }

    /* access modifiers changed from: package-private */
    public void s() {
        int c2 = this.f2707g.c();
        for (int i2 = 0; i2 < c2; i2++) {
            w e2 = e(this.f2707g.d(i2));
            if (!e2.shouldIgnore()) {
                e2.saveOldPosition();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void t() {
        int c2 = this.f2707g.c();
        for (int i2 = 0; i2 < c2; i2++) {
            w e2 = e(this.f2707g.d(i2));
            if (!e2.shouldIgnore()) {
                e2.clearOldPosition();
            }
        }
        this.f2705e.i();
    }

    /* access modifiers changed from: package-private */
    public void f(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int c2 = this.f2707g.c();
        if (i2 < i3) {
            i6 = i2;
            i5 = i3;
            i4 = -1;
        } else {
            i5 = i2;
            i6 = i3;
            i4 = 1;
        }
        for (int i7 = 0; i7 < c2; i7++) {
            w e2 = e(this.f2707g.d(i7));
            if (e2 != null && e2.mPosition >= i6 && e2.mPosition <= i5) {
                if (e2.mPosition == i2) {
                    e2.offsetPosition(i3 - i2, false);
                } else {
                    e2.offsetPosition(i4, false);
                }
                this.D.f2769f = true;
            }
        }
        this.f2705e.a(i2, i3);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void g(int i2, int i3) {
        int c2 = this.f2707g.c();
        for (int i4 = 0; i4 < c2; i4++) {
            w e2 = e(this.f2707g.d(i4));
            if (e2 != null && !e2.shouldIgnore() && e2.mPosition >= i2) {
                e2.offsetPosition(i3, false);
                this.D.f2769f = true;
            }
        }
        this.f2705e.b(i2, i3);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int c2 = this.f2707g.c();
        for (int i5 = 0; i5 < c2; i5++) {
            w e2 = e(this.f2707g.d(i5));
            if (e2 != null && !e2.shouldIgnore()) {
                if (e2.mPosition >= i4) {
                    e2.offsetPosition(-i3, z2);
                    this.D.f2769f = true;
                } else if (e2.mPosition >= i2) {
                    e2.flagRemovedAndOffsetPosition(i2 - 1, -i3, z2);
                    this.D.f2769f = true;
                }
            }
        }
        this.f2705e.a(i2, i3, z2);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, Object obj) {
        int c2 = this.f2707g.c();
        int i4 = i2 + i3;
        for (int i5 = 0; i5 < c2; i5++) {
            View d2 = this.f2707g.d(i5);
            w e2 = e(d2);
            if (e2 != null && !e2.shouldIgnore() && e2.mPosition >= i2 && e2.mPosition < i4) {
                e2.addFlags(2);
                e2.addChangePayload(obj);
                ((j) d2.getLayoutParams()).f2734e = true;
            }
        }
        this.f2705e.c(i2, i3);
    }

    /* access modifiers changed from: package-private */
    public boolean b(w wVar) {
        f fVar = this.z;
        return fVar == null || fVar.canReuseUpdatedViewHolder(wVar, wVar.getUnmodifiedPayloads());
    }

    /* access modifiers changed from: package-private */
    public void c(boolean z2) {
        this.y = z2 | this.y;
        this.x = true;
        u();
    }

    /* access modifiers changed from: package-private */
    public void u() {
        int c2 = this.f2707g.c();
        for (int i2 = 0; i2 < c2; i2++) {
            w e2 = e(this.f2707g.d(i2));
            if (e2 != null && !e2.shouldIgnore()) {
                e2.addFlags(6);
            }
        }
        r();
        this.f2705e.h();
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.ay;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.ay = z2;
    }

    public w b(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return e(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public View c(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = (View) parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public w d(View view) {
        View c2 = c(view);
        if (c2 == null) {
            return null;
        }
        return b(c2);
    }

    static w e(View view) {
        if (view == null) {
            return null;
        }
        return ((j) view.getLayoutParams()).f2732c;
    }

    public int f(View view) {
        w e2 = e(view);
        if (e2 != null) {
            return e2.getAdapterPosition();
        }
        return -1;
    }

    public int g(View view) {
        w e2 = e(view);
        if (e2 != null) {
            return e2.getLayoutPosition();
        }
        return -1;
    }

    public w e(int i2) {
        w wVar = null;
        if (this.x) {
            return null;
        }
        int c2 = this.f2707g.c();
        for (int i3 = 0; i3 < c2; i3++) {
            w e2 = e(this.f2707g.d(i3));
            if (e2 != null && !e2.isRemoved() && d(e2) == i2) {
                if (!this.f2707g.c(e2.itemView)) {
                    return e2;
                }
                wVar = e2;
            }
        }
        return wVar;
    }

    /* access modifiers changed from: package-private */
    public w a(int i2, boolean z2) {
        int c2 = this.f2707g.c();
        w wVar = null;
        for (int i3 = 0; i3 < c2; i3++) {
            w e2 = e(this.f2707g.d(i3));
            if (e2 != null && !e2.isRemoved()) {
                if (z2) {
                    if (e2.mPosition != i2) {
                        continue;
                    }
                } else if (e2.getLayoutPosition() != i2) {
                    continue;
                }
                if (!this.f2707g.c(e2.itemView)) {
                    return e2;
                }
                wVar = e2;
            }
        }
        return wVar;
    }

    public w a(long j2) {
        a aVar = this.m;
        w wVar = null;
        if (aVar != null && aVar.hasStableIds()) {
            int c2 = this.f2707g.c();
            for (int i2 = 0; i2 < c2; i2++) {
                w e2 = e(this.f2707g.d(i2));
                if (e2 != null && !e2.isRemoved() && e2.getItemId() == j2) {
                    if (!this.f2707g.c(e2.itemView)) {
                        return e2;
                    }
                    wVar = e2;
                }
            }
        }
        return wVar;
    }

    public View a(float f2, float f3) {
        for (int b2 = this.f2707g.b() - 1; b2 >= 0; b2--) {
            View b3 = this.f2707g.b(b2);
            float translationX = b3.getTranslationX();
            float translationY = b3.getTranslationY();
            if (f2 >= ((float) b3.getLeft()) + translationX && f2 <= ((float) b3.getRight()) + translationX && f3 >= ((float) b3.getTop()) + translationY && f3 <= ((float) b3.getBottom()) + translationY) {
                return b3;
            }
        }
        return null;
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public void f(int i2) {
        int b2 = this.f2707g.b();
        for (int i3 = 0; i3 < b2; i3++) {
            this.f2707g.b(i3).offsetTopAndBottom(i2);
        }
    }

    public void g(int i2) {
        int b2 = this.f2707g.b();
        for (int i3 = 0; i3 < b2; i3++) {
            this.f2707g.b(i3).offsetLeftAndRight(i2);
        }
    }

    static void a(View view, Rect rect) {
        j jVar = (j) view.getLayoutParams();
        Rect rect2 = jVar.f2733d;
        rect.set((view.getLeft() - rect2.left) - jVar.leftMargin, (view.getTop() - rect2.top) - jVar.topMargin, view.getRight() + rect2.right + jVar.rightMargin, view.getBottom() + rect2.bottom + jVar.bottomMargin);
    }

    /* access modifiers changed from: package-private */
    public Rect j(View view) {
        j jVar = (j) view.getLayoutParams();
        if (!jVar.f2734e) {
            return jVar.f2733d;
        }
        if (this.D.a() && (jVar.e() || jVar.c())) {
            return jVar.f2733d;
        }
        Rect rect = jVar.f2733d;
        rect.set(0, 0, 0, 0);
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.k.set(0, 0, 0, 0);
            this.p.get(i2).a(this.k, view, this, this.D);
            rect.left += this.k.left;
            rect.top += this.k.top;
            rect.right += this.k.right;
            rect.bottom += this.k.bottom;
        }
        jVar.f2734e = false;
        return rect;
    }

    /* access modifiers changed from: package-private */
    public void i(int i2, int i3) {
        this.af++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        h(i2, i3);
        n nVar = this.az;
        if (nVar != null) {
            nVar.onScrolled(this, i2, i3);
        }
        List<n> list = this.aA;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.aA.get(size).onScrolled(this, i2, i3);
            }
        }
        this.af--;
    }

    /* access modifiers changed from: package-private */
    public void i(int i2) {
        i iVar = this.n;
        if (iVar != null) {
            iVar.l(i2);
        }
        h(i2);
        n nVar = this.az;
        if (nVar != null) {
            nVar.onScrollStateChanged(this, i2);
        }
        List<n> list = this.aA;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.aA.get(size).onScrollStateChanged(this, i2);
            }
        }
    }

    public boolean v() {
        return !this.t || this.x || this.f2706f.d();
    }

    class v implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        OverScroller f2771a;

        /* renamed from: b  reason: collision with root package name */
        Interpolator f2772b = RecyclerView.L;

        /* renamed from: d  reason: collision with root package name */
        private int f2774d;

        /* renamed from: e  reason: collision with root package name */
        private int f2775e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f2776f = false;

        /* renamed from: g  reason: collision with root package name */
        private boolean f2777g = false;

        v() {
            this.f2771a = new OverScroller(RecyclerView.this.getContext(), RecyclerView.L);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f1, code lost:
            if (r8 > 0) goto L_0x00f5;
         */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00ed  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x00fd  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r22 = this;
                r0 = r22
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$i r1 = r1.n
                if (r1 != 0) goto L_0x000c
                r22.b()
                return
            L_0x000c:
                r22.c()
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                r1.d()
                android.widget.OverScroller r1 = r0.f2771a
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$i r2 = r2.n
                androidx.recyclerview.widget.RecyclerView$s r2 = r2.t
                boolean r3 = r1.computeScrollOffset()
                r4 = 0
                if (r3 == 0) goto L_0x0197
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                int[] r3 = r3.I
                int r11 = r1.getCurrX()
                int r12 = r1.getCurrY()
                int r5 = r0.f2774d
                int r13 = r11 - r5
                int r5 = r0.f2775e
                int r14 = r12 - r5
                r0.f2774d = r11
                r0.f2775e = r12
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                r9 = 0
                r10 = 1
                r6 = r13
                r7 = r14
                r8 = r3
                boolean r5 = r5.a((int) r6, (int) r7, (int[]) r8, (int[]) r9, (int) r10)
                r6 = 1
                if (r5 == 0) goto L_0x004f
                r5 = r3[r4]
                int r13 = r13 - r5
                r3 = r3[r6]
                int r14 = r14 - r3
            L_0x004f:
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r3 = r3.m
                if (r3 == 0) goto L_0x00a2
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                int[] r5 = r3.J
                r3.a((int) r13, (int) r14, (int[]) r5)
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                int[] r3 = r3.J
                r3 = r3[r4]
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                int[] r5 = r5.J
                r5 = r5[r6]
                int r7 = r13 - r3
                int r8 = r14 - r5
                if (r2 == 0) goto L_0x00a6
                boolean r9 = r2.g()
                if (r9 != 0) goto L_0x00a6
                boolean r9 = r2.h()
                if (r9 == 0) goto L_0x00a6
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$t r9 = r9.D
                int r9 = r9.e()
                if (r9 != 0) goto L_0x0088
                r2.f()
                goto L_0x00a6
            L_0x0088:
                int r10 = r2.i()
                if (r10 < r9) goto L_0x009a
                int r9 = r9 - r6
                r2.c(r9)
                int r9 = r13 - r7
                int r10 = r14 - r8
                r2.a((int) r9, (int) r10)
                goto L_0x00a6
            L_0x009a:
                int r9 = r13 - r7
                int r10 = r14 - r8
                r2.a((int) r9, (int) r10)
                goto L_0x00a6
            L_0x00a2:
                r3 = 0
                r5 = 0
                r7 = 0
                r8 = 0
            L_0x00a6:
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$h> r9 = r9.p
                boolean r9 = r9.isEmpty()
                if (r9 != 0) goto L_0x00b5
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                r9.invalidate()
            L_0x00b5:
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                int r9 = r9.getOverScrollMode()
                r10 = 2
                if (r9 == r10) goto L_0x00c3
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                r9.c(r13, r14)
            L_0x00c3:
                androidx.recyclerview.widget.RecyclerView r15 = androidx.recyclerview.widget.RecyclerView.this
                r20 = 0
                r21 = 1
                r16 = r3
                r17 = r5
                r18 = r7
                r19 = r8
                boolean r9 = r15.a((int) r16, (int) r17, (int) r18, (int) r19, (int[]) r20, (int) r21)
                if (r9 != 0) goto L_0x0119
                if (r7 != 0) goto L_0x00db
                if (r8 == 0) goto L_0x0119
            L_0x00db:
                float r9 = r1.getCurrVelocity()
                int r9 = (int) r9
                if (r7 == r11) goto L_0x00ea
                if (r7 >= 0) goto L_0x00e6
                int r15 = -r9
                goto L_0x00eb
            L_0x00e6:
                if (r7 <= 0) goto L_0x00ea
                r15 = r9
                goto L_0x00eb
            L_0x00ea:
                r15 = 0
            L_0x00eb:
                if (r8 == r12) goto L_0x00f4
                if (r8 >= 0) goto L_0x00f1
                int r9 = -r9
                goto L_0x00f5
            L_0x00f1:
                if (r8 <= 0) goto L_0x00f4
                goto L_0x00f5
            L_0x00f4:
                r9 = 0
            L_0x00f5:
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                int r4 = r4.getOverScrollMode()
                if (r4 == r10) goto L_0x0102
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                r4.d(r15, r9)
            L_0x0102:
                if (r15 != 0) goto L_0x010c
                if (r7 == r11) goto L_0x010c
                int r4 = r1.getFinalX()
                if (r4 != 0) goto L_0x0119
            L_0x010c:
                if (r9 != 0) goto L_0x0116
                if (r8 == r12) goto L_0x0116
                int r4 = r1.getFinalY()
                if (r4 != 0) goto L_0x0119
            L_0x0116:
                r1.abortAnimation()
            L_0x0119:
                if (r3 != 0) goto L_0x011d
                if (r5 == 0) goto L_0x0122
            L_0x011d:
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                r4.i(r3, r5)
            L_0x0122:
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                boolean r4 = r4.awakenScrollBars()
                if (r4 != 0) goto L_0x012f
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                r4.invalidate()
            L_0x012f:
                if (r14 == 0) goto L_0x013f
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$i r4 = r4.n
                boolean r4 = r4.g()
                if (r4 == 0) goto L_0x013f
                if (r5 != r14) goto L_0x013f
                r4 = 1
                goto L_0x0140
            L_0x013f:
                r4 = 0
            L_0x0140:
                if (r13 == 0) goto L_0x0150
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$i r5 = r5.n
                boolean r5 = r5.f()
                if (r5 == 0) goto L_0x0150
                if (r3 != r13) goto L_0x0150
                r3 = 1
                goto L_0x0151
            L_0x0150:
                r3 = 0
            L_0x0151:
                if (r13 != 0) goto L_0x0155
                if (r14 == 0) goto L_0x015c
            L_0x0155:
                if (r3 != 0) goto L_0x015c
                if (r4 == 0) goto L_0x015a
                goto L_0x015c
            L_0x015a:
                r3 = 0
                goto L_0x015d
            L_0x015c:
                r3 = 1
            L_0x015d:
                boolean r1 = r1.isFinished()
                if (r1 != 0) goto L_0x0181
                if (r3 != 0) goto L_0x016e
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                boolean r1 = r1.j((int) r6)
                if (r1 != 0) goto L_0x016e
                goto L_0x0181
            L_0x016e:
                r22.a()
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.h r1 = r1.B
                if (r1 == 0) goto L_0x0197
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.h r1 = r1.B
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                r1.a((androidx.recyclerview.widget.RecyclerView) r3, (int) r13, (int) r14)
                goto L_0x0197
            L_0x0181:
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                r3 = 0
                r1.setScrollState(r3)
                boolean r1 = androidx.recyclerview.widget.RecyclerView.f2704d
                if (r1 == 0) goto L_0x0192
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.h$a r1 = r1.C
                r1.a()
            L_0x0192:
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                r1.a((int) r6)
            L_0x0197:
                if (r2 == 0) goto L_0x01aa
                boolean r1 = r2.g()
                if (r1 == 0) goto L_0x01a3
                r1 = 0
                r2.a((int) r1, (int) r1)
            L_0x01a3:
                boolean r1 = r0.f2777g
                if (r1 != 0) goto L_0x01aa
                r2.f()
            L_0x01aa:
                r22.d()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.v.run():void");
        }

        private void c() {
            this.f2777g = false;
            this.f2776f = true;
        }

        private void d() {
            this.f2776f = false;
            if (this.f2777g) {
                a();
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (this.f2776f) {
                this.f2777g = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            androidx.core.g.w.a((View) RecyclerView.this, (Runnable) this);
        }

        public void a(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.f2775e = 0;
            this.f2774d = 0;
            this.f2771a.fling(0, 0, i, i2, RNCartPanelDataEntity.NULL_VALUE, Integer.MAX_VALUE, RNCartPanelDataEntity.NULL_VALUE, Integer.MAX_VALUE);
            a();
        }

        public void b(int i, int i2) {
            a(i, i2, 0, 0);
        }

        public void a(int i, int i2, int i3, int i4) {
            a(i, i2, b(i, i2, i3, i4));
        }

        private float a(float f2) {
            return (float) Math.sin((double) ((f2 - 0.5f) * 0.47123894f));
        }

        private int b(int i, int i2, int i3, int i4) {
            int i5;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
            int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
            int width = z ? RecyclerView.this.getWidth() : RecyclerView.this.getHeight();
            int i6 = width / 2;
            float f2 = (float) width;
            float f3 = (float) i6;
            float a2 = f3 + (a(Math.min(1.0f, (((float) sqrt2) * 1.0f) / f2)) * f3);
            if (sqrt > 0) {
                i5 = Math.round(Math.abs(a2 / ((float) sqrt)) * 1000.0f) * 4;
            } else {
                if (!z) {
                    abs = abs2;
                }
                i5 = (int) (((((float) abs) / f2) + 1.0f) * 300.0f);
            }
            return Math.min(i5, 2000);
        }

        public void a(int i, int i2, int i3) {
            a(i, i2, i3, RecyclerView.L);
        }

        public void a(int i, int i2, Interpolator interpolator) {
            int b2 = b(i, i2, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.L;
            }
            a(i, i2, b2, interpolator);
        }

        public void a(int i, int i2, int i3, Interpolator interpolator) {
            if (this.f2772b != interpolator) {
                this.f2772b = interpolator;
                this.f2771a = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.f2775e = 0;
            this.f2774d = 0;
            this.f2771a.startScroll(0, 0, i, i2, i3);
            if (Build.VERSION.SDK_INT < 23) {
                this.f2771a.computeScrollOffset();
            }
            a();
        }

        public void b() {
            RecyclerView.this.removeCallbacks(this);
            this.f2771a.abortAnimation();
        }
    }

    /* access modifiers changed from: package-private */
    public void w() {
        int b2 = this.f2707g.b();
        for (int i2 = 0; i2 < b2; i2++) {
            View b3 = this.f2707g.b(i2);
            w b4 = b(b3);
            if (!(b4 == null || b4.mShadowingHolder == null)) {
                View view = b4.mShadowingHolder.itemView;
                int left = b3.getLeft();
                int top = b3.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    private class r extends c {
        r() {
        }

        public void a() {
            RecyclerView.this.a((String) null);
            RecyclerView.this.D.f2769f = true;
            RecyclerView.this.c(true);
            if (!RecyclerView.this.f2706f.d()) {
                RecyclerView.this.requestLayout();
            }
        }

        public void a(int i, int i2, Object obj) {
            RecyclerView.this.a((String) null);
            if (RecyclerView.this.f2706f.a(i, i2, obj)) {
                b();
            }
        }

        public void b(int i, int i2) {
            RecyclerView.this.a((String) null);
            if (RecyclerView.this.f2706f.b(i, i2)) {
                b();
            }
        }

        public void c(int i, int i2) {
            RecyclerView.this.a((String) null);
            if (RecyclerView.this.f2706f.c(i, i2)) {
                b();
            }
        }

        public void a(int i, int i2, int i3) {
            RecyclerView.this.a((String) null);
            if (RecyclerView.this.f2706f.a(i, i2, i3)) {
                b();
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (!RecyclerView.f2703c || !RecyclerView.this.r || !RecyclerView.this.q) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.w = true;
                recyclerView.requestLayout();
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            androidx.core.g.w.a((View) recyclerView2, recyclerView2.j);
        }
    }

    public static class e {
        /* access modifiers changed from: protected */
        public EdgeEffect a(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static class o {

        /* renamed from: a  reason: collision with root package name */
        SparseArray<a> f2736a = new SparseArray<>();

        /* renamed from: b  reason: collision with root package name */
        private int f2737b = 0;

        static class a {

            /* renamed from: a  reason: collision with root package name */
            final ArrayList<w> f2738a = new ArrayList<>();

            /* renamed from: b  reason: collision with root package name */
            int f2739b = 5;

            /* renamed from: c  reason: collision with root package name */
            long f2740c = 0;

            /* renamed from: d  reason: collision with root package name */
            long f2741d = 0;

            a() {
            }
        }

        public void a() {
            for (int i = 0; i < this.f2736a.size(); i++) {
                this.f2736a.valueAt(i).f2738a.clear();
            }
        }

        public w a(int i) {
            a aVar = this.f2736a.get(i);
            if (aVar == null || aVar.f2738a.isEmpty()) {
                return null;
            }
            ArrayList<w> arrayList = aVar.f2738a;
            return arrayList.remove(arrayList.size() - 1);
        }

        public void a(w wVar) {
            int itemViewType = wVar.getItemViewType();
            ArrayList<w> arrayList = b(itemViewType).f2738a;
            if (this.f2736a.get(itemViewType).f2739b > arrayList.size()) {
                wVar.resetInternal();
                arrayList.add(wVar);
            }
        }

        /* access modifiers changed from: package-private */
        public long a(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        /* access modifiers changed from: package-private */
        public void a(int i, long j) {
            a b2 = b(i);
            b2.f2740c = a(b2.f2740c, j);
        }

        /* access modifiers changed from: package-private */
        public void b(int i, long j) {
            a b2 = b(i);
            b2.f2741d = a(b2.f2741d, j);
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i, long j, long j2) {
            long j3 = b(i).f2740c;
            return j3 == 0 || j + j3 < j2;
        }

        /* access modifiers changed from: package-private */
        public boolean b(int i, long j, long j2) {
            long j3 = b(i).f2741d;
            return j3 == 0 || j + j3 < j2;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f2737b++;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.f2737b--;
        }

        /* access modifiers changed from: package-private */
        public void a(a aVar, a aVar2, boolean z) {
            if (aVar != null) {
                c();
            }
            if (!z && this.f2737b == 0) {
                a();
            }
            if (aVar2 != null) {
                b();
            }
        }

        private a b(int i) {
            a aVar = this.f2736a.get(i);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f2736a.put(i, aVar2);
            return aVar2;
        }
    }

    static RecyclerView k(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView k2 = k(viewGroup.getChildAt(i2));
            if (k2 != null) {
                return k2;
            }
        }
        return null;
    }

    static void c(w wVar) {
        if (wVar.mNestedRecyclerView != null) {
            View view = (View) wVar.mNestedRecyclerView.get();
            while (view != null) {
                if (view != wVar.itemView) {
                    ViewParent parent = view.getParent();
                    view = parent instanceof View ? (View) parent : null;
                } else {
                    return;
                }
            }
            wVar.mNestedRecyclerView = null;
        }
    }

    /* access modifiers changed from: package-private */
    public long getNanoTime() {
        if (f2704d) {
            return System.nanoTime();
        }
        return 0;
    }

    public final class p {

        /* renamed from: a  reason: collision with root package name */
        final ArrayList<w> f2742a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        ArrayList<w> f2743b = null;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<w> f2744c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        int f2745d = 2;

        /* renamed from: e  reason: collision with root package name */
        o f2746e;

        /* renamed from: g  reason: collision with root package name */
        private final List<w> f2748g = Collections.unmodifiableList(this.f2742a);
        private int h = 2;
        private u i;

        public p() {
        }

        public void a() {
            this.f2742a.clear();
            d();
        }

        public void a(int i2) {
            this.h = i2;
            b();
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f2745d = this.h + (RecyclerView.this.n != null ? RecyclerView.this.n.x : 0);
            for (int size = this.f2744c.size() - 1; size >= 0 && this.f2744c.size() > this.f2745d; size--) {
                d(size);
            }
        }

        public List<w> c() {
            return this.f2748g;
        }

        /* access modifiers changed from: package-private */
        public boolean a(w wVar) {
            if (wVar.isRemoved()) {
                return RecyclerView.this.D.a();
            }
            if (wVar.mPosition < 0 || wVar.mPosition >= RecyclerView.this.m.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + wVar + RecyclerView.this.a());
            } else if (!RecyclerView.this.D.a() && RecyclerView.this.m.getItemViewType(wVar.mPosition) != wVar.getItemViewType()) {
                return false;
            } else {
                if (!RecyclerView.this.m.hasStableIds() || wVar.getItemId() == RecyclerView.this.m.getItemId(wVar.mPosition)) {
                    return true;
                }
                return false;
            }
        }

        private boolean a(w wVar, int i2, int i3, long j) {
            wVar.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = wVar.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != Clock.MAX_TIME && !this.f2746e.b(itemViewType, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.m.bindViewHolder(wVar, i2);
            this.f2746e.b(wVar.getItemViewType(), RecyclerView.this.getNanoTime() - nanoTime);
            e(wVar);
            if (!RecyclerView.this.D.a()) {
                return true;
            }
            wVar.mPreLayoutPosition = i3;
            return true;
        }

        public int b(int i2) {
            if (i2 < 0 || i2 >= RecyclerView.this.D.e()) {
                throw new IndexOutOfBoundsException("invalid position " + i2 + ". State " + "item count is " + RecyclerView.this.D.e() + RecyclerView.this.a());
            } else if (!RecyclerView.this.D.a()) {
                return i2;
            } else {
                return RecyclerView.this.f2706f.b(i2);
            }
        }

        public View c(int i2) {
            return a(i2, false);
        }

        /* access modifiers changed from: package-private */
        public View a(int i2, boolean z) {
            return a(i2, z, (long) Clock.MAX_TIME).itemView;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x005f  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x01a8  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x01cd  */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x0206  */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x0214  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.recyclerview.widget.RecyclerView.w a(int r17, boolean r18, long r19) {
            /*
                r16 = this;
                r6 = r16
                r3 = r17
                r0 = r18
                if (r3 < 0) goto L_0x0237
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$t r1 = r1.D
                int r1 = r1.e()
                if (r3 >= r1) goto L_0x0237
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$t r1 = r1.D
                boolean r1 = r1.a()
                r2 = 0
                r7 = 1
                r8 = 0
                if (r1 == 0) goto L_0x0027
                androidx.recyclerview.widget.RecyclerView$w r1 = r16.f((int) r17)
                if (r1 == 0) goto L_0x0028
                r4 = 1
                goto L_0x0029
            L_0x0027:
                r1 = r2
            L_0x0028:
                r4 = 0
            L_0x0029:
                if (r1 != 0) goto L_0x005d
                androidx.recyclerview.widget.RecyclerView$w r1 = r16.b((int) r17, (boolean) r18)
                if (r1 == 0) goto L_0x005d
                boolean r5 = r6.a((androidx.recyclerview.widget.RecyclerView.w) r1)
                if (r5 != 0) goto L_0x005c
                if (r0 != 0) goto L_0x005a
                r5 = 4
                r1.addFlags(r5)
                boolean r5 = r1.isScrap()
                if (r5 == 0) goto L_0x004e
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                android.view.View r9 = r1.itemView
                r5.removeDetachedView(r9, r8)
                r1.unScrap()
                goto L_0x0057
            L_0x004e:
                boolean r5 = r1.wasReturnedFromScrap()
                if (r5 == 0) goto L_0x0057
                r1.clearReturnedFromScrapFlag()
            L_0x0057:
                r6.b((androidx.recyclerview.widget.RecyclerView.w) r1)
            L_0x005a:
                r1 = r2
                goto L_0x005d
            L_0x005c:
                r4 = 1
            L_0x005d:
                if (r1 != 0) goto L_0x0187
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.a r5 = r5.f2706f
                int r5 = r5.b((int) r3)
                if (r5 < 0) goto L_0x014a
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r9 = r9.m
                int r9 = r9.getItemCount()
                if (r5 >= r9) goto L_0x014a
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r9 = r9.m
                int r9 = r9.getItemViewType(r5)
                androidx.recyclerview.widget.RecyclerView r10 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r10 = r10.m
                boolean r10 = r10.hasStableIds()
                if (r10 == 0) goto L_0x0096
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r1 = r1.m
                long r10 = r1.getItemId(r5)
                androidx.recyclerview.widget.RecyclerView$w r1 = r6.a((long) r10, (int) r9, (boolean) r0)
                if (r1 == 0) goto L_0x0096
                r1.mPosition = r5
                r4 = 1
            L_0x0096:
                if (r1 != 0) goto L_0x00eb
                androidx.recyclerview.widget.RecyclerView$u r0 = r6.i
                if (r0 == 0) goto L_0x00eb
                android.view.View r0 = r0.a(r6, r3, r9)
                if (r0 == 0) goto L_0x00eb
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$w r1 = r1.b((android.view.View) r0)
                if (r1 == 0) goto L_0x00ce
                boolean r0 = r1.shouldIgnore()
                if (r0 != 0) goto L_0x00b1
                goto L_0x00eb
            L_0x00b1:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view."
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.a()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00ce:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getViewForPositionAndType returned a view which does not have a ViewHolder"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.a()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00eb:
                if (r1 != 0) goto L_0x0101
                androidx.recyclerview.widget.RecyclerView$o r0 = r16.g()
                androidx.recyclerview.widget.RecyclerView$w r1 = r0.a((int) r9)
                if (r1 == 0) goto L_0x0101
                r1.resetInternal()
                boolean r0 = androidx.recyclerview.widget.RecyclerView.f2701a
                if (r0 == 0) goto L_0x0101
                r6.f((androidx.recyclerview.widget.RecyclerView.w) r1)
            L_0x0101:
                if (r1 != 0) goto L_0x0187
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                long r0 = r0.getNanoTime()
                r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r5 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
                if (r5 == 0) goto L_0x011f
                androidx.recyclerview.widget.RecyclerView$o r10 = r6.f2746e
                r11 = r9
                r12 = r0
                r14 = r19
                boolean r5 = r10.a((int) r11, (long) r12, (long) r14)
                if (r5 != 0) goto L_0x011f
                return r2
            L_0x011f:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r2 = r2.m
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$w r2 = r2.createViewHolder(r5, r9)
                boolean r5 = androidx.recyclerview.widget.RecyclerView.f2704d
                if (r5 == 0) goto L_0x013c
                android.view.View r5 = r2.itemView
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.k(r5)
                if (r5 == 0) goto L_0x013c
                java.lang.ref.WeakReference r10 = new java.lang.ref.WeakReference
                r10.<init>(r5)
                r2.mNestedRecyclerView = r10
            L_0x013c:
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                long r10 = r5.getNanoTime()
                androidx.recyclerview.widget.RecyclerView$o r5 = r6.f2746e
                long r10 = r10 - r0
                r5.a((int) r9, (long) r10)
                r10 = r2
                goto L_0x0188
            L_0x014a:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Inconsistency detected. Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "(offset:"
                r1.append(r2)
                r1.append(r5)
                java.lang.String r2 = ")."
                r1.append(r2)
                java.lang.String r2 = "state:"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$t r2 = r2.D
                int r2 = r2.e()
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.a()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0187:
                r10 = r1
            L_0x0188:
                r9 = r4
                if (r9 == 0) goto L_0x01c3
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$t r0 = r0.D
                boolean r0 = r0.a()
                if (r0 != 0) goto L_0x01c3
                r0 = 8192(0x2000, float:1.14794E-41)
                boolean r1 = r10.hasAnyOfTheFlags(r0)
                if (r1 == 0) goto L_0x01c3
                r10.setFlags(r8, r0)
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$t r0 = r0.D
                boolean r0 = r0.j
                if (r0 == 0) goto L_0x01c3
                int r0 = androidx.recyclerview.widget.RecyclerView.f.buildAdapterChangeFlagsForAnimations(r10)
                r0 = r0 | 4096(0x1000, float:5.74E-42)
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$f r1 = r1.z
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$t r2 = r2.D
                java.util.List r4 = r10.getUnmodifiedPayloads()
                androidx.recyclerview.widget.RecyclerView$f$c r0 = r1.recordPreLayoutInformation(r2, r10, r0, r4)
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                r1.a((androidx.recyclerview.widget.RecyclerView.w) r10, (androidx.recyclerview.widget.RecyclerView.f.c) r0)
            L_0x01c3:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$t r0 = r0.D
                boolean r0 = r0.a()
                if (r0 == 0) goto L_0x01d6
                boolean r0 = r10.isBound()
                if (r0 == 0) goto L_0x01d6
                r10.mPreLayoutPosition = r3
                goto L_0x01e9
            L_0x01d6:
                boolean r0 = r10.isBound()
                if (r0 == 0) goto L_0x01eb
                boolean r0 = r10.needsUpdate()
                if (r0 != 0) goto L_0x01eb
                boolean r0 = r10.isInvalid()
                if (r0 == 0) goto L_0x01e9
                goto L_0x01eb
            L_0x01e9:
                r0 = 0
                goto L_0x01fe
            L_0x01eb:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.a r0 = r0.f2706f
                int r2 = r0.b((int) r3)
                r0 = r16
                r1 = r10
                r3 = r17
                r4 = r19
                boolean r0 = r0.a(r1, r2, r3, r4)
            L_0x01fe:
                android.view.View r1 = r10.itemView
                android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
                if (r1 != 0) goto L_0x0214
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r1.generateDefaultLayoutParams()
                androidx.recyclerview.widget.RecyclerView$j r1 = (androidx.recyclerview.widget.RecyclerView.j) r1
                android.view.View r2 = r10.itemView
                r2.setLayoutParams(r1)
                goto L_0x022c
            L_0x0214:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                boolean r2 = r2.checkLayoutParams(r1)
                if (r2 != 0) goto L_0x022a
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r2.generateLayoutParams((android.view.ViewGroup.LayoutParams) r1)
                androidx.recyclerview.widget.RecyclerView$j r1 = (androidx.recyclerview.widget.RecyclerView.j) r1
                android.view.View r2 = r10.itemView
                r2.setLayoutParams(r1)
                goto L_0x022c
            L_0x022a:
                androidx.recyclerview.widget.RecyclerView$j r1 = (androidx.recyclerview.widget.RecyclerView.j) r1
            L_0x022c:
                r1.f2732c = r10
                if (r9 == 0) goto L_0x0233
                if (r0 == 0) goto L_0x0233
                goto L_0x0234
            L_0x0233:
                r7 = 0
            L_0x0234:
                r1.f2735f = r7
                return r10
            L_0x0237:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "("
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "). Item count:"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$t r2 = r2.D
                int r2 = r2.e()
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.a()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.p.a(int, boolean, long):androidx.recyclerview.widget.RecyclerView$w");
        }

        private void e(w wVar) {
            if (RecyclerView.this.n()) {
                View view = wVar.itemView;
                if (androidx.core.g.w.f(view) == 0) {
                    androidx.core.g.w.d(view, 1);
                }
                if (!androidx.core.g.w.c(view)) {
                    wVar.addFlags(TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE);
                    androidx.core.g.w.a(view, RecyclerView.this.H.b());
                }
            }
        }

        private void f(w wVar) {
            if (wVar.itemView instanceof ViewGroup) {
                a((ViewGroup) wVar.itemView, false);
            }
        }

        private void a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        public void a(View view) {
            w e2 = RecyclerView.e(view);
            if (e2.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (e2.isScrap()) {
                e2.unScrap();
            } else if (e2.wasReturnedFromScrap()) {
                e2.clearReturnedFromScrapFlag();
            }
            b(e2);
        }

        /* access modifiers changed from: package-private */
        public void d() {
            for (int size = this.f2744c.size() - 1; size >= 0; size--) {
                d(size);
            }
            this.f2744c.clear();
            if (RecyclerView.f2704d) {
                RecyclerView.this.C.a();
            }
        }

        /* access modifiers changed from: package-private */
        public void d(int i2) {
            a(this.f2744c.get(i2), true);
            this.f2744c.remove(i2);
        }

        /* access modifiers changed from: package-private */
        public void b(w wVar) {
            boolean z;
            boolean z2 = false;
            if (wVar.isScrap() || wVar.itemView.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(wVar.isScrap());
                sb.append(" isAttached:");
                if (wVar.itemView.getParent() != null) {
                    z2 = true;
                }
                sb.append(z2);
                sb.append(RecyclerView.this.a());
                throw new IllegalArgumentException(sb.toString());
            } else if (wVar.isTmpDetached()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + wVar + RecyclerView.this.a());
            } else if (!wVar.shouldIgnore()) {
                boolean doesTransientStatePreventRecycling = wVar.doesTransientStatePreventRecycling();
                if ((RecyclerView.this.m != null && doesTransientStatePreventRecycling && RecyclerView.this.m.onFailedToRecycleView(wVar)) || wVar.isRecyclable()) {
                    if (this.f2745d <= 0 || wVar.hasAnyOfTheFlags(526)) {
                        z = false;
                    } else {
                        int size = this.f2744c.size();
                        if (size >= this.f2745d && size > 0) {
                            d(0);
                            size--;
                        }
                        if (RecyclerView.f2704d && size > 0 && !RecyclerView.this.C.a(wVar.mPosition)) {
                            int i2 = size - 1;
                            while (i2 >= 0) {
                                if (!RecyclerView.this.C.a(this.f2744c.get(i2).mPosition)) {
                                    break;
                                }
                                i2--;
                            }
                            size = i2 + 1;
                        }
                        this.f2744c.add(size, wVar);
                        z = true;
                    }
                    if (!z) {
                        a(wVar, true);
                        z2 = true;
                    }
                } else {
                    z = false;
                }
                RecyclerView.this.h.g(wVar);
                if (!z && !z2 && doesTransientStatePreventRecycling) {
                    wVar.mOwnerRecyclerView = null;
                }
            } else {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.a());
            }
        }

        /* access modifiers changed from: package-private */
        public void a(w wVar, boolean z) {
            RecyclerView.c(wVar);
            if (wVar.hasAnyOfTheFlags(TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE)) {
                wVar.setFlags(0, TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE);
                androidx.core.g.w.a(wVar.itemView, (androidx.core.g.a) null);
            }
            if (z) {
                d(wVar);
            }
            wVar.mOwnerRecyclerView = null;
            g().a(wVar);
        }

        /* access modifiers changed from: package-private */
        public void b(View view) {
            w e2 = RecyclerView.e(view);
            e2.mScrapContainer = null;
            e2.mInChangeScrap = false;
            e2.clearReturnedFromScrapFlag();
            b(e2);
        }

        /* access modifiers changed from: package-private */
        public void c(View view) {
            w e2 = RecyclerView.e(view);
            if (!e2.hasAnyOfTheFlags(12) && e2.isUpdated() && !RecyclerView.this.b(e2)) {
                if (this.f2743b == null) {
                    this.f2743b = new ArrayList<>();
                }
                e2.setScrapContainer(this, true);
                this.f2743b.add(e2);
            } else if (!e2.isInvalid() || e2.isRemoved() || RecyclerView.this.m.hasStableIds()) {
                e2.setScrapContainer(this, false);
                this.f2742a.add(e2);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.a());
            }
        }

        /* access modifiers changed from: package-private */
        public void c(w wVar) {
            if (wVar.mInChangeScrap) {
                this.f2743b.remove(wVar);
            } else {
                this.f2742a.remove(wVar);
            }
            wVar.mScrapContainer = null;
            wVar.mInChangeScrap = false;
            wVar.clearReturnedFromScrapFlag();
        }

        /* access modifiers changed from: package-private */
        public int e() {
            return this.f2742a.size();
        }

        /* access modifiers changed from: package-private */
        public View e(int i2) {
            return this.f2742a.get(i2).itemView;
        }

        /* access modifiers changed from: package-private */
        public void f() {
            this.f2742a.clear();
            ArrayList<w> arrayList = this.f2743b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public w f(int i2) {
            ArrayList<w> arrayList = this.f2743b;
            if (arrayList != null) {
                int size = arrayList.size();
                if (size != 0) {
                    int i3 = 0;
                    int i4 = 0;
                    while (i4 < size) {
                        w wVar = this.f2743b.get(i4);
                        if (wVar.wasReturnedFromScrap() || wVar.getLayoutPosition() != i2) {
                            i4++;
                        } else {
                            wVar.addFlags(32);
                            return wVar;
                        }
                    }
                    if (RecyclerView.this.m.hasStableIds()) {
                        int b2 = RecyclerView.this.f2706f.b(i2);
                        if (b2 > 0 && b2 < RecyclerView.this.m.getItemCount()) {
                            long itemId = RecyclerView.this.m.getItemId(b2);
                            while (i3 < size) {
                                w wVar2 = this.f2743b.get(i3);
                                if (wVar2.wasReturnedFromScrap() || wVar2.getItemId() != itemId) {
                                    i3++;
                                } else {
                                    wVar2.addFlags(32);
                                    return wVar2;
                                }
                            }
                        }
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public w b(int i2, boolean z) {
            int size = this.f2742a.size();
            int i3 = 0;
            int i4 = 0;
            while (i4 < size) {
                w wVar = this.f2742a.get(i4);
                if (wVar.wasReturnedFromScrap() || wVar.getLayoutPosition() != i2 || wVar.isInvalid() || (!RecyclerView.this.D.f2770g && wVar.isRemoved())) {
                    i4++;
                } else {
                    wVar.addFlags(32);
                    return wVar;
                }
            }
            if (!z) {
                View c2 = RecyclerView.this.f2707g.c(i2);
                if (c2 != null) {
                    w e2 = RecyclerView.e(c2);
                    RecyclerView.this.f2707g.e(c2);
                    int b2 = RecyclerView.this.f2707g.b(c2);
                    if (b2 != -1) {
                        RecyclerView.this.f2707g.e(b2);
                        c(c2);
                        e2.addFlags(8224);
                        return e2;
                    }
                    throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + e2 + RecyclerView.this.a());
                }
            }
            int size2 = this.f2744c.size();
            while (i3 < size2) {
                w wVar2 = this.f2744c.get(i3);
                if (wVar2.isInvalid() || wVar2.getLayoutPosition() != i2) {
                    i3++;
                } else {
                    if (!z) {
                        this.f2744c.remove(i3);
                    }
                    return wVar2;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public w a(long j, int i2, boolean z) {
            for (int size = this.f2742a.size() - 1; size >= 0; size--) {
                w wVar = this.f2742a.get(size);
                if (wVar.getItemId() == j && !wVar.wasReturnedFromScrap()) {
                    if (i2 == wVar.getItemViewType()) {
                        wVar.addFlags(32);
                        if (wVar.isRemoved() && !RecyclerView.this.D.a()) {
                            wVar.setFlags(2, 14);
                        }
                        return wVar;
                    } else if (!z) {
                        this.f2742a.remove(size);
                        RecyclerView.this.removeDetachedView(wVar.itemView, false);
                        b(wVar.itemView);
                    }
                }
            }
            int size2 = this.f2744c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                w wVar2 = this.f2744c.get(size2);
                if (wVar2.getItemId() == j) {
                    if (i2 == wVar2.getItemViewType()) {
                        if (!z) {
                            this.f2744c.remove(size2);
                        }
                        return wVar2;
                    } else if (!z) {
                        d(size2);
                        return null;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d(w wVar) {
            if (RecyclerView.this.o != null) {
                RecyclerView.this.o.a(wVar);
            }
            if (RecyclerView.this.m != null) {
                RecyclerView.this.m.onViewRecycled(wVar);
            }
            if (RecyclerView.this.D != null) {
                RecyclerView.this.h.g(wVar);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(a aVar, a aVar2, boolean z) {
            a();
            g().a(aVar, aVar2, z);
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3) {
            int i4;
            int i5;
            int i6;
            if (i2 < i3) {
                i6 = i2;
                i5 = i3;
                i4 = -1;
            } else {
                i5 = i2;
                i6 = i3;
                i4 = 1;
            }
            int size = this.f2744c.size();
            for (int i7 = 0; i7 < size; i7++) {
                w wVar = this.f2744c.get(i7);
                if (wVar != null && wVar.mPosition >= i6 && wVar.mPosition <= i5) {
                    if (wVar.mPosition == i2) {
                        wVar.offsetPosition(i3 - i2, false);
                    } else {
                        wVar.offsetPosition(i4, false);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int i2, int i3) {
            int size = this.f2744c.size();
            for (int i4 = 0; i4 < size; i4++) {
                w wVar = this.f2744c.get(i4);
                if (wVar != null && wVar.mPosition >= i2) {
                    wVar.offsetPosition(i3, true);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3, boolean z) {
            int i4 = i2 + i3;
            for (int size = this.f2744c.size() - 1; size >= 0; size--) {
                w wVar = this.f2744c.get(size);
                if (wVar != null) {
                    if (wVar.mPosition >= i4) {
                        wVar.offsetPosition(-i3, z);
                    } else if (wVar.mPosition >= i2) {
                        wVar.addFlags(8);
                        d(size);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(u uVar) {
            this.i = uVar;
        }

        /* access modifiers changed from: package-private */
        public void a(o oVar) {
            o oVar2 = this.f2746e;
            if (oVar2 != null) {
                oVar2.c();
            }
            this.f2746e = oVar;
            if (this.f2746e != null && RecyclerView.this.getAdapter() != null) {
                this.f2746e.b();
            }
        }

        /* access modifiers changed from: package-private */
        public o g() {
            if (this.f2746e == null) {
                this.f2746e = new o();
            }
            return this.f2746e;
        }

        /* access modifiers changed from: package-private */
        public void c(int i2, int i3) {
            int i4 = i3 + i2;
            for (int size = this.f2744c.size() - 1; size >= 0; size--) {
                w wVar = this.f2744c.get(size);
                if (wVar != null) {
                    int i5 = wVar.mPosition;
                    if (i5 >= i2 && i5 < i4) {
                        wVar.addFlags(2);
                        d(size);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void h() {
            int size = this.f2744c.size();
            for (int i2 = 0; i2 < size; i2++) {
                w wVar = this.f2744c.get(i2);
                if (wVar != null) {
                    wVar.addFlags(6);
                    wVar.addChangePayload((Object) null);
                }
            }
            if (RecyclerView.this.m == null || !RecyclerView.this.m.hasStableIds()) {
                d();
            }
        }

        /* access modifiers changed from: package-private */
        public void i() {
            int size = this.f2744c.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f2744c.get(i2).clearOldPosition();
            }
            int size2 = this.f2742a.size();
            for (int i3 = 0; i3 < size2; i3++) {
                this.f2742a.get(i3).clearOldPosition();
            }
            ArrayList<w> arrayList = this.f2743b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    this.f2743b.get(i4).clearOldPosition();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void j() {
            int size = this.f2744c.size();
            for (int i2 = 0; i2 < size; i2++) {
                j jVar = (j) this.f2744c.get(i2).itemView.getLayoutParams();
                if (jVar != null) {
                    jVar.f2734e = true;
                }
            }
        }
    }

    public static abstract class a<VH extends w> {
        private boolean mHasStableIds = false;
        private final b mObservable = new b();

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh, int i);

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }

        public void onBindViewHolder(VH vh, int i, List<Object> list) {
            onBindViewHolder(vh, i);
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i) {
            try {
                androidx.core.d.f.a("RV CreateView");
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i);
                if (onCreateViewHolder.itemView.getParent() == null) {
                    onCreateViewHolder.mItemViewType = i;
                    return onCreateViewHolder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                androidx.core.d.f.a();
            }
        }

        public final void bindViewHolder(VH vh, int i) {
            vh.mPosition = i;
            if (hasStableIds()) {
                vh.mItemId = getItemId(i);
            }
            vh.setFlags(1, 519);
            androidx.core.d.f.a("RV OnBindView");
            onBindViewHolder(vh, i, vh.getUnmodifiedPayloads());
            vh.clearPayload();
            ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
            if (layoutParams instanceof j) {
                ((j) layoutParams).f2734e = true;
            }
            androidx.core.d.f.a();
        }

        public void setHasStableIds(boolean z) {
            if (!hasObservers()) {
                this.mHasStableIds = z;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final boolean hasObservers() {
            return this.mObservable.a();
        }

        public void registerAdapterDataObserver(c cVar) {
            this.mObservable.registerObserver(cVar);
        }

        public void unregisterAdapterDataObserver(c cVar) {
            this.mObservable.unregisterObserver(cVar);
        }

        public final void notifyDataSetChanged() {
            this.mObservable.b();
        }

        public final void notifyItemChanged(int i) {
            this.mObservable.a(i, 1);
        }

        public final void notifyItemChanged(int i, Object obj) {
            this.mObservable.a(i, 1, obj);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.mObservable.a(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2, Object obj) {
            this.mObservable.a(i, i2, obj);
        }

        public final void notifyItemInserted(int i) {
            this.mObservable.b(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.mObservable.d(i, i2);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.mObservable.b(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.mObservable.c(i, 1);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.mObservable.c(i, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void l(View view) {
        w e2 = e(view);
        i(view);
        a aVar = this.m;
        if (!(aVar == null || e2 == null)) {
            aVar.onViewDetachedFromWindow(e2);
        }
        List<k> list = this.ad;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.ad.get(size).b(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void m(View view) {
        w e2 = e(view);
        h(view);
        a aVar = this.m;
        if (!(aVar == null || e2 == null)) {
            aVar.onViewAttachedToWindow(e2);
        }
        List<k> list = this.ad;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.ad.get(size).a(view);
            }
        }
    }

    public static abstract class i {

        /* renamed from: a  reason: collision with root package name */
        private final t.b f2719a = new t.b() {
            public View a(int i) {
                return i.this.i(i);
            }

            public int a() {
                return i.this.D();
            }

            public int b() {
                return i.this.B() - i.this.F();
            }

            public int a(View view) {
                return i.this.h(view) - ((j) view.getLayoutParams()).leftMargin;
            }

            public int b(View view) {
                return i.this.j(view) + ((j) view.getLayoutParams()).rightMargin;
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private final t.b f2720b = new t.b() {
            public View a(int i) {
                return i.this.i(i);
            }

            public int a() {
                return i.this.E();
            }

            public int b() {
                return i.this.C() - i.this.G();
            }

            public int a(View view) {
                return i.this.i(view) - ((j) view.getLayoutParams()).topMargin;
            }

            public int b(View view) {
                return i.this.k(view) + ((j) view.getLayoutParams()).bottomMargin;
            }
        };

        /* renamed from: c  reason: collision with root package name */
        private boolean f2721c = true;

        /* renamed from: d  reason: collision with root package name */
        private boolean f2722d = true;

        /* renamed from: e  reason: collision with root package name */
        private int f2723e;

        /* renamed from: f  reason: collision with root package name */
        private int f2724f;

        /* renamed from: g  reason: collision with root package name */
        private int f2725g;
        private int h;
        d p;
        RecyclerView q;
        t r = new t(this.f2719a);
        t s = new t(this.f2720b);
        s t;
        boolean u = false;
        boolean v = false;
        boolean w = false;
        int x;
        boolean y;

        public interface a {
            void b(int i, int i2);
        }

        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public int f2728a;

            /* renamed from: b  reason: collision with root package name */
            public int f2729b;

            /* renamed from: c  reason: collision with root package name */
            public boolean f2730c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f2731d;
        }

        public int a(int i, p pVar, t tVar) {
            return 0;
        }

        public View a(View view, int i, p pVar, t tVar) {
            return null;
        }

        public abstract j a();

        public void a(int i, int i2, t tVar, a aVar) {
        }

        public void a(int i, a aVar) {
        }

        public void a(Parcelable parcelable) {
        }

        public void a(a aVar, a aVar2) {
        }

        public void a(t tVar) {
        }

        public void a(RecyclerView recyclerView) {
        }

        public void a(RecyclerView recyclerView, int i, int i2) {
        }

        public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public boolean a(j jVar) {
            return jVar != null;
        }

        public boolean a(p pVar, t tVar, View view, int i, Bundle bundle) {
            return false;
        }

        public boolean a(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public int b(int i, p pVar, t tVar) {
            return 0;
        }

        public void b(RecyclerView recyclerView, int i, int i2) {
        }

        public int c(t tVar) {
            return 0;
        }

        public void c(RecyclerView recyclerView, int i, int i2) {
        }

        public boolean c() {
            return false;
        }

        public int d(p pVar, t tVar) {
            return 0;
        }

        public int d(t tVar) {
            return 0;
        }

        public View d(View view, int i) {
            return null;
        }

        public void d(RecyclerView recyclerView) {
        }

        public int e(t tVar) {
            return 0;
        }

        public Parcelable e() {
            return null;
        }

        public void e(int i) {
        }

        @Deprecated
        public void e(RecyclerView recyclerView) {
        }

        public boolean e(p pVar, t tVar) {
            return false;
        }

        public int f(t tVar) {
            return 0;
        }

        public boolean f() {
            return false;
        }

        public int g(t tVar) {
            return 0;
        }

        public boolean g() {
            return false;
        }

        public int h(t tVar) {
            return 0;
        }

        public void l(int i) {
        }

        /* access modifiers changed from: package-private */
        public boolean m() {
            return false;
        }

        public int x() {
            return -1;
        }

        /* access modifiers changed from: package-private */
        public void b(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.q = null;
                this.p = null;
                this.f2725g = 0;
                this.h = 0;
            } else {
                this.q = recyclerView;
                this.p = recyclerView.f2707g;
                this.f2725g = recyclerView.getWidth();
                this.h = recyclerView.getHeight();
            }
            this.f2723e = 1073741824;
            this.f2724f = 1073741824;
        }

        /* access modifiers changed from: package-private */
        public void d(int i, int i2) {
            this.f2725g = View.MeasureSpec.getSize(i);
            this.f2723e = View.MeasureSpec.getMode(i);
            if (this.f2723e == 0 && !RecyclerView.f2702b) {
                this.f2725g = 0;
            }
            this.h = View.MeasureSpec.getSize(i2);
            this.f2724f = View.MeasureSpec.getMode(i2);
            if (this.f2724f == 0 && !RecyclerView.f2702b) {
                this.h = 0;
            }
        }

        /* access modifiers changed from: package-private */
        public void e(int i, int i2) {
            int y2 = y();
            if (y2 == 0) {
                this.q.e(i, i2);
                return;
            }
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = RNCartPanelDataEntity.NULL_VALUE;
            int i6 = RNCartPanelDataEntity.NULL_VALUE;
            for (int i7 = 0; i7 < y2; i7++) {
                View i8 = i(i7);
                Rect rect = this.q.k;
                a(i8, rect);
                if (rect.left < i3) {
                    i3 = rect.left;
                }
                if (rect.right > i5) {
                    i5 = rect.right;
                }
                if (rect.top < i4) {
                    i4 = rect.top;
                }
                if (rect.bottom > i6) {
                    i6 = rect.bottom;
                }
            }
            this.q.k.set(i3, i4, i5, i6);
            a(this.q.k, i, i2);
        }

        public void a(Rect rect, int i, int i2) {
            g(a(i, rect.width() + D() + F(), J()), a(i2, rect.height() + E() + G(), K()));
        }

        public void r() {
            RecyclerView recyclerView = this.q;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public static int a(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        public void a(String str) {
            RecyclerView recyclerView = this.q;
            if (recyclerView != null) {
                recyclerView.a(str);
            }
        }

        @Deprecated
        public void c(boolean z) {
            this.w = z;
        }

        public boolean d() {
            return this.w;
        }

        public final boolean s() {
            return this.f2722d;
        }

        /* access modifiers changed from: package-private */
        public void c(RecyclerView recyclerView) {
            this.v = true;
            d(recyclerView);
        }

        /* access modifiers changed from: package-private */
        public void b(RecyclerView recyclerView, p pVar) {
            this.v = false;
            a(recyclerView, pVar);
        }

        public boolean t() {
            return this.v;
        }

        public boolean a(Runnable runnable) {
            RecyclerView recyclerView = this.q;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void a(RecyclerView recyclerView, p pVar) {
            e(recyclerView);
        }

        public boolean u() {
            RecyclerView recyclerView = this.q;
            return recyclerView != null && recyclerView.i;
        }

        public void c(p pVar, t tVar) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public j a(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof j) {
                return new j((j) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new j((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new j(layoutParams);
        }

        public j a(Context context, AttributeSet attributeSet) {
            return new j(context, attributeSet);
        }

        public void a(RecyclerView recyclerView, t tVar, int i) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void a(s sVar) {
            s sVar2 = this.t;
            if (!(sVar2 == null || sVar == sVar2 || !sVar2.h())) {
                this.t.f();
            }
            this.t = sVar;
            this.t.a(this.q, this);
        }

        public boolean v() {
            s sVar = this.t;
            return sVar != null && sVar.h();
        }

        public int w() {
            return androidx.core.g.w.g(this.q);
        }

        public void a(View view) {
            a(view, -1);
        }

        public void a(View view, int i) {
            a(view, i, true);
        }

        public void b(View view) {
            b(view, -1);
        }

        public void b(View view, int i) {
            a(view, i, false);
        }

        private void a(View view, int i, boolean z) {
            w e2 = RecyclerView.e(view);
            if (z || e2.isRemoved()) {
                this.q.h.e(e2);
            } else {
                this.q.h.f(e2);
            }
            j jVar = (j) view.getLayoutParams();
            if (e2.wasReturnedFromScrap() || e2.isScrap()) {
                if (e2.isScrap()) {
                    e2.unScrap();
                } else {
                    e2.clearReturnedFromScrapFlag();
                }
                this.p.a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.q) {
                int b2 = this.p.b(view);
                if (i == -1) {
                    i = this.p.b();
                }
                if (b2 == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.q.indexOfChild(view) + this.q.a());
                } else if (b2 != i) {
                    this.q.n.f(b2, i);
                }
            } else {
                this.p.a(view, i, false);
                jVar.f2734e = true;
                s sVar = this.t;
                if (sVar != null && sVar.h()) {
                    this.t.b(view);
                }
            }
            if (jVar.f2735f) {
                e2.itemView.invalidate();
                jVar.f2735f = false;
            }
        }

        public void c(View view) {
            this.p.a(view);
        }

        public void g(int i) {
            if (i(i) != null) {
                this.p.a(i);
            }
        }

        public int d(View view) {
            return ((j) view.getLayoutParams()).f();
        }

        public View e(View view) {
            RecyclerView recyclerView = this.q;
            if (recyclerView == null) {
                return null;
            }
            View c2 = recyclerView.c(view);
            if (c2 != null && !this.p.c(c2)) {
                return c2;
            }
            return null;
        }

        public View c(int i) {
            int y2 = y();
            for (int i2 = 0; i2 < y2; i2++) {
                View i3 = i(i2);
                w e2 = RecyclerView.e(i3);
                if (e2 != null && e2.getLayoutPosition() == i && !e2.shouldIgnore() && (this.q.D.a() || !e2.isRemoved())) {
                    return i3;
                }
            }
            return null;
        }

        public void h(int i) {
            a(i, i(i));
        }

        private void a(int i, View view) {
            this.p.e(i);
        }

        public void a(View view, int i, j jVar) {
            w e2 = RecyclerView.e(view);
            if (e2.isRemoved()) {
                this.q.h.e(e2);
            } else {
                this.q.h.f(e2);
            }
            this.p.a(view, i, jVar, e2.isRemoved());
        }

        public void c(View view, int i) {
            a(view, i, (j) view.getLayoutParams());
        }

        public void f(int i, int i2) {
            View i3 = i(i);
            if (i3 != null) {
                h(i);
                c(i3, i2);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.q.toString());
        }

        public void a(View view, p pVar) {
            c(view);
            pVar.a(view);
        }

        public void a(int i, p pVar) {
            View i2 = i(i);
            g(i);
            pVar.a(i2);
        }

        public int y() {
            d dVar = this.p;
            if (dVar != null) {
                return dVar.b();
            }
            return 0;
        }

        public View i(int i) {
            d dVar = this.p;
            if (dVar != null) {
                return dVar.b(i);
            }
            return null;
        }

        public int z() {
            return this.f2723e;
        }

        public int A() {
            return this.f2724f;
        }

        public int B() {
            return this.f2725g;
        }

        public int C() {
            return this.h;
        }

        public int D() {
            RecyclerView recyclerView = this.q;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int E() {
            RecyclerView recyclerView = this.q;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int F() {
            RecyclerView recyclerView = this.q;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int G() {
            RecyclerView recyclerView = this.q;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public View H() {
            RecyclerView recyclerView = this.q;
            if (recyclerView == null) {
                return null;
            }
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null || this.p.c(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int I() {
            RecyclerView recyclerView = this.q;
            a adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public void j(int i) {
            RecyclerView recyclerView = this.q;
            if (recyclerView != null) {
                recyclerView.g(i);
            }
        }

        public void k(int i) {
            RecyclerView recyclerView = this.q;
            if (recyclerView != null) {
                recyclerView.f(i);
            }
        }

        public void a(p pVar) {
            for (int y2 = y() - 1; y2 >= 0; y2--) {
                a(pVar, y2, i(y2));
            }
        }

        private void a(p pVar, int i, View view) {
            w e2 = RecyclerView.e(view);
            if (!e2.shouldIgnore()) {
                if (!e2.isInvalid() || e2.isRemoved() || this.q.m.hasStableIds()) {
                    h(i);
                    pVar.c(view);
                    this.q.h.h(e2);
                    return;
                }
                g(i);
                pVar.b(e2);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(p pVar) {
            int e2 = pVar.e();
            for (int i = e2 - 1; i >= 0; i--) {
                View e3 = pVar.e(i);
                w e4 = RecyclerView.e(e3);
                if (!e4.shouldIgnore()) {
                    e4.setIsRecyclable(false);
                    if (e4.isTmpDetached()) {
                        this.q.removeDetachedView(e3, false);
                    }
                    if (this.q.z != null) {
                        this.q.z.endAnimation(e4);
                    }
                    e4.setIsRecyclable(true);
                    pVar.b(e3);
                }
            }
            pVar.f();
            if (e2 > 0) {
                this.q.invalidate();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a(View view, int i, int i2, j jVar) {
            return !this.f2721c || !b(view.getMeasuredWidth(), i, jVar.width) || !b(view.getMeasuredHeight(), i2, jVar.height);
        }

        /* access modifiers changed from: package-private */
        public boolean b(View view, int i, int i2, j jVar) {
            return view.isLayoutRequested() || !this.f2721c || !b(view.getWidth(), i, jVar.width) || !b(view.getHeight(), i2, jVar.height);
        }

        private static boolean b(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        public void a(View view, int i, int i2) {
            j jVar = (j) view.getLayoutParams();
            Rect j = this.q.j(view);
            int i3 = i + j.left + j.right;
            int i4 = i2 + j.top + j.bottom;
            int a2 = a(B(), z(), D() + F() + jVar.leftMargin + jVar.rightMargin + i3, jVar.width, f());
            int a3 = a(C(), A(), E() + G() + jVar.topMargin + jVar.bottomMargin + i4, jVar.height, g());
            if (b(view, a2, a3, jVar)) {
                view.measure(a2, a3);
            }
        }

        public static int a(int i, int i2, int i3, int i4, boolean z) {
            int i5;
            int i6 = i - i3;
            int i7 = 0;
            int max = Math.max(0, i6);
            if (z) {
                if (i4 < 0) {
                    if (i4 == -1) {
                        if (i2 == Integer.MIN_VALUE || (i2 != 0 && i2 == 1073741824)) {
                            i5 = max;
                        } else {
                            i2 = 0;
                            i5 = 0;
                        }
                        i7 = i2;
                        max = i5;
                        return View.MeasureSpec.makeMeasureSpec(max, i7);
                    }
                    max = 0;
                    return View.MeasureSpec.makeMeasureSpec(max, i7);
                }
            } else if (i4 < 0) {
                if (i4 == -1) {
                    i7 = i2;
                } else {
                    if (i4 == -2) {
                        if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                            i7 = RNCartPanelDataEntity.NULL_VALUE;
                        }
                    }
                    max = 0;
                }
                return View.MeasureSpec.makeMeasureSpec(max, i7);
            }
            max = i4;
            i7 = 1073741824;
            return View.MeasureSpec.makeMeasureSpec(max, i7);
        }

        public int f(View view) {
            Rect rect = ((j) view.getLayoutParams()).f2733d;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int g(View view) {
            Rect rect = ((j) view.getLayoutParams()).f2733d;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void a(View view, int i, int i2, int i3, int i4) {
            j jVar = (j) view.getLayoutParams();
            Rect rect = jVar.f2733d;
            view.layout(i + rect.left + jVar.leftMargin, i2 + rect.top + jVar.topMargin, (i3 - rect.right) - jVar.rightMargin, (i4 - rect.bottom) - jVar.bottomMargin);
        }

        public void a(View view, boolean z, Rect rect) {
            if (z) {
                Rect rect2 = ((j) view.getLayoutParams()).f2733d;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.q != null) {
                Matrix matrix = view.getMatrix();
                if (matrix != null && !matrix.isIdentity()) {
                    RectF rectF = this.q.l;
                    rectF.set(rect);
                    matrix.mapRect(rectF);
                    rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
                }
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void a(View view, Rect rect) {
            RecyclerView.a(view, rect);
        }

        public int h(View view) {
            return view.getLeft() - n(view);
        }

        public int i(View view) {
            return view.getTop() - l(view);
        }

        public int j(View view) {
            return view.getRight() + o(view);
        }

        public int k(View view) {
            return view.getBottom() + m(view);
        }

        public void b(View view, Rect rect) {
            RecyclerView recyclerView = this.q;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.j(view));
            }
        }

        public int l(View view) {
            return ((j) view.getLayoutParams()).f2733d.top;
        }

        public int m(View view) {
            return ((j) view.getLayoutParams()).f2733d.bottom;
        }

        public int n(View view) {
            return ((j) view.getLayoutParams()).f2733d.left;
        }

        public int o(View view) {
            return ((j) view.getLayoutParams()).f2733d.right;
        }

        private int[] b(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int[] iArr = new int[2];
            int D = D();
            int E = E();
            int B = B() - F();
            int C = C() - G();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i = left - D;
            int min = Math.min(0, i);
            int i2 = top - E;
            int min2 = Math.min(0, i2);
            int i3 = width - B;
            int max = Math.max(0, i3);
            int max2 = Math.max(0, height - C);
            if (w() != 1) {
                if (min == 0) {
                    min = Math.min(i, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i3);
            }
            if (min2 == 0) {
                min2 = Math.min(i2, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return a(recyclerView, view, rect, z, false);
        }

        public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] b2 = b(recyclerView, view, rect, z);
            int i = b2[0];
            int i2 = b2[1];
            if ((z2 && !d(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.a(i, i2);
            }
            return true;
        }

        public boolean a(View view, boolean z, boolean z2) {
            boolean z3 = this.r.a(view, 24579) && this.s.a(view, 24579);
            return z ? z3 : !z3;
        }

        private boolean d(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int D = D();
            int E = E();
            int B = B() - F();
            int C = C() - G();
            Rect rect = this.q.k;
            a(focusedChild, rect);
            if (rect.left - i >= B || rect.right - i <= D || rect.top - i2 >= C || rect.bottom - i2 <= E) {
                return false;
            }
            return true;
        }

        @Deprecated
        public boolean a(RecyclerView recyclerView, View view, View view2) {
            return v() || recyclerView.o();
        }

        public boolean a(RecyclerView recyclerView, t tVar, View view, View view2) {
            return a(recyclerView, view, view2);
        }

        public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
            c(recyclerView, i, i2);
        }

        public void a(p pVar, t tVar, int i, int i2) {
            this.q.e(i, i2);
        }

        public void g(int i, int i2) {
            this.q.setMeasuredDimension(i, i2);
        }

        public int J() {
            return androidx.core.g.w.l(this.q);
        }

        public int K() {
            return androidx.core.g.w.m(this.q);
        }

        /* access modifiers changed from: package-private */
        public void L() {
            s sVar = this.t;
            if (sVar != null) {
                sVar.f();
            }
        }

        /* access modifiers changed from: package-private */
        public void b(s sVar) {
            if (this.t == sVar) {
                this.t = null;
            }
        }

        public void c(p pVar) {
            for (int y2 = y() - 1; y2 >= 0; y2--) {
                if (!RecyclerView.e(i(y2)).shouldIgnore()) {
                    a(y2, pVar);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(androidx.core.g.a.d dVar) {
            a(this.q.f2705e, this.q.D, dVar);
        }

        public void a(p pVar, t tVar, androidx.core.g.a.d dVar) {
            if (this.q.canScrollVertically(-1) || this.q.canScrollHorizontally(-1)) {
                dVar.a(8192);
                dVar.k(true);
            }
            if (this.q.canScrollVertically(1) || this.q.canScrollHorizontally(1)) {
                dVar.a(4096);
                dVar.k(true);
            }
            dVar.a((Object) d.b.a(a(pVar, tVar), b(pVar, tVar), e(pVar, tVar), d(pVar, tVar)));
        }

        public void a(AccessibilityEvent accessibilityEvent) {
            a(this.q.f2705e, this.q.D, accessibilityEvent);
        }

        public void a(p pVar, t tVar, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.q;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z = true;
                if (!recyclerView.canScrollVertically(1) && !this.q.canScrollVertically(-1) && !this.q.canScrollHorizontally(-1) && !this.q.canScrollHorizontally(1)) {
                    z = false;
                }
                accessibilityEvent.setScrollable(z);
                if (this.q.m != null) {
                    accessibilityEvent.setItemCount(this.q.m.getItemCount());
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(View view, androidx.core.g.a.d dVar) {
            w e2 = RecyclerView.e(view);
            if (e2 != null && !e2.isRemoved() && !this.p.c(e2.itemView)) {
                a(this.q.f2705e, this.q.D, view, dVar);
            }
        }

        public void a(p pVar, t tVar, View view, androidx.core.g.a.d dVar) {
            dVar.b((Object) d.c.a(g() ? d(view) : 0, 1, f() ? d(view) : 0, 1, false, false));
        }

        public void M() {
            this.u = true;
        }

        public int a(p pVar, t tVar) {
            RecyclerView recyclerView = this.q;
            if (recyclerView == null || recyclerView.m == null || !g()) {
                return 1;
            }
            return this.q.m.getItemCount();
        }

        public int b(p pVar, t tVar) {
            RecyclerView recyclerView = this.q;
            if (recyclerView == null || recyclerView.m == null || !f()) {
                return 1;
            }
            return this.q.m.getItemCount();
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i, Bundle bundle) {
            return a(this.q.f2705e, this.q.D, i, bundle);
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x0070 A[ADDED_TO_REGION] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(androidx.recyclerview.widget.RecyclerView.p r2, androidx.recyclerview.widget.RecyclerView.t r3, int r4, android.os.Bundle r5) {
            /*
                r1 = this;
                androidx.recyclerview.widget.RecyclerView r2 = r1.q
                r3 = 0
                if (r2 != 0) goto L_0x0006
                return r3
            L_0x0006:
                r5 = 4096(0x1000, float:5.74E-42)
                r0 = 1
                if (r4 == r5) goto L_0x0042
                r5 = 8192(0x2000, float:1.14794E-41)
                if (r4 == r5) goto L_0x0012
                r2 = 0
            L_0x0010:
                r4 = 0
                goto L_0x006e
            L_0x0012:
                r4 = -1
                boolean r2 = r2.canScrollVertically(r4)
                if (r2 == 0) goto L_0x0029
                int r2 = r1.C()
                int r5 = r1.E()
                int r2 = r2 - r5
                int r5 = r1.G()
                int r2 = r2 - r5
                int r2 = -r2
                goto L_0x002a
            L_0x0029:
                r2 = 0
            L_0x002a:
                androidx.recyclerview.widget.RecyclerView r5 = r1.q
                boolean r4 = r5.canScrollHorizontally(r4)
                if (r4 == 0) goto L_0x0010
                int r4 = r1.B()
                int r5 = r1.D()
                int r4 = r4 - r5
                int r5 = r1.F()
                int r4 = r4 - r5
                int r4 = -r4
                goto L_0x006e
            L_0x0042:
                boolean r2 = r2.canScrollVertically(r0)
                if (r2 == 0) goto L_0x0057
                int r2 = r1.C()
                int r4 = r1.E()
                int r2 = r2 - r4
                int r4 = r1.G()
                int r2 = r2 - r4
                goto L_0x0058
            L_0x0057:
                r2 = 0
            L_0x0058:
                androidx.recyclerview.widget.RecyclerView r4 = r1.q
                boolean r4 = r4.canScrollHorizontally(r0)
                if (r4 == 0) goto L_0x0010
                int r4 = r1.B()
                int r5 = r1.D()
                int r4 = r4 - r5
                int r5 = r1.F()
                int r4 = r4 - r5
            L_0x006e:
                if (r2 != 0) goto L_0x0073
                if (r4 != 0) goto L_0x0073
                return r3
            L_0x0073:
                androidx.recyclerview.widget.RecyclerView r3 = r1.q
                r3.a((int) r4, (int) r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.i.a(androidx.recyclerview.widget.RecyclerView$p, androidx.recyclerview.widget.RecyclerView$t, int, android.os.Bundle):boolean");
        }

        /* access modifiers changed from: package-private */
        public boolean a(View view, int i, Bundle bundle) {
            return a(this.q.f2705e, this.q.D, view, i, bundle);
        }

        public static b a(Context context, AttributeSet attributeSet, int i, int i2) {
            b bVar = new b();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.c.RecyclerView, i, i2);
            bVar.f2728a = obtainStyledAttributes.getInt(a.c.RecyclerView_android_orientation, 1);
            bVar.f2729b = obtainStyledAttributes.getInt(a.c.RecyclerView_spanCount, 1);
            bVar.f2730c = obtainStyledAttributes.getBoolean(a.c.RecyclerView_reverseLayout, false);
            bVar.f2731d = obtainStyledAttributes.getBoolean(a.c.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return bVar;
        }

        /* access modifiers changed from: package-private */
        public void f(RecyclerView recyclerView) {
            d(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        /* access modifiers changed from: package-private */
        public boolean N() {
            int y2 = y();
            for (int i = 0; i < y2; i++) {
                ViewGroup.LayoutParams layoutParams = i(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    public static abstract class h {
        @Deprecated
        public void a(Canvas canvas, RecyclerView recyclerView) {
        }

        @Deprecated
        public void b(Canvas canvas, RecyclerView recyclerView) {
        }

        public void b(Canvas canvas, RecyclerView recyclerView, t tVar) {
            a(canvas, recyclerView);
        }

        public void a(Canvas canvas, RecyclerView recyclerView, t tVar) {
            b(canvas, recyclerView);
        }

        @Deprecated
        public void a(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void a(Rect rect, View view, RecyclerView recyclerView, t tVar) {
            a(rect, ((j) view.getLayoutParams()).f(), recyclerView);
        }
    }

    public static abstract class w {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_SET_A11Y_ITEM_DELEGATE = 16384;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        int mFlags;
        boolean mInChangeScrap = false;
        private int mIsRecyclableCount = 0;
        long mItemId = -1;
        int mItemViewType = -1;
        WeakReference<RecyclerView> mNestedRecyclerView;
        int mOldPosition = -1;
        RecyclerView mOwnerRecyclerView;
        List<Object> mPayloads = null;
        int mPendingAccessibilityState = -1;
        int mPosition = -1;
        int mPreLayoutPosition = -1;
        p mScrapContainer = null;
        w mShadowedHolder = null;
        w mShadowingHolder = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mWasImportantForAccessibilityBeforeHidden = 0;

        public w(View view) {
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        /* access modifiers changed from: package-private */
        public void flagRemovedAndOffsetPosition(int i, int i2, boolean z) {
            addFlags(8);
            offsetPosition(i2, z);
            this.mPosition = i;
        }

        /* access modifiers changed from: package-private */
        public void offsetPosition(int i, boolean z) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += i;
            }
            this.mPosition += i;
            if (this.itemView.getLayoutParams() != null) {
                ((j) this.itemView.getLayoutParams()).f2734e = true;
            }
        }

        /* access modifiers changed from: package-private */
        public void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        /* access modifiers changed from: package-private */
        public void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean shouldIgnore() {
            return (this.mFlags & 128) != 0;
        }

        @Deprecated
        public final int getPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public final int getLayoutPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public final int getAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.d(this);
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        /* access modifiers changed from: package-private */
        public boolean isScrap() {
            return this.mScrapContainer != null;
        }

        /* access modifiers changed from: package-private */
        public void unScrap() {
            this.mScrapContainer.c(this);
        }

        /* access modifiers changed from: package-private */
        public boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }

        /* access modifiers changed from: package-private */
        public void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        /* access modifiers changed from: package-private */
        public void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        /* access modifiers changed from: package-private */
        public void stopIgnoring() {
            this.mFlags &= -129;
        }

        /* access modifiers changed from: package-private */
        public void setScrapContainer(p pVar, boolean z) {
            this.mScrapContainer = pVar;
            this.mInChangeScrap = z;
        }

        /* access modifiers changed from: package-private */
        public boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean hasAnyOfTheFlags(int i) {
            return (i & this.mFlags) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isAdapterPositionUnknown() {
            return (this.mFlags & 512) != 0 || isInvalid();
        }

        /* access modifiers changed from: package-private */
        public void setFlags(int i, int i2) {
            this.mFlags = (i & i2) | (this.mFlags & (i2 ^ -1));
        }

        /* access modifiers changed from: package-private */
        public void addFlags(int i) {
            this.mFlags = i | this.mFlags;
        }

        /* access modifiers changed from: package-private */
        public void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                this.mPayloads = new ArrayList();
                this.mUnmodifiedPayloads = Collections.unmodifiableList(this.mPayloads);
            }
        }

        /* access modifiers changed from: package-private */
        public void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        /* access modifiers changed from: package-private */
        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            List<Object> list = this.mPayloads;
            if (list == null || list.size() == 0) {
                return FULLUPDATE_PAYLOADS;
            }
            return this.mUnmodifiedPayloads;
        }

        /* access modifiers changed from: package-private */
        public void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.c(this);
        }

        /* access modifiers changed from: package-private */
        public void onEnteredHiddenState(RecyclerView recyclerView) {
            int i = this.mPendingAccessibilityState;
            if (i != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = androidx.core.g.w.f(this.itemView);
            }
            recyclerView.a(this, 4);
        }

        /* access modifiers changed from: package-private */
        public void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.a(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb.append(" scrap ");
                sb.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (needsUpdate()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.mIsRecyclableCount + SQLBuilder.PARENTHESES_RIGHT);
            }
            if (isAdapterPositionUnknown()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final void setIsRecyclable(boolean z) {
            this.mIsRecyclableCount = z ? this.mIsRecyclableCount - 1 : this.mIsRecyclableCount + 1;
            int i = this.mIsRecyclableCount;
            if (i < 0) {
                this.mIsRecyclableCount = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && i == 1) {
                this.mFlags |= 16;
            } else if (z && this.mIsRecyclableCount == 0) {
                this.mFlags &= -17;
            }
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !androidx.core.g.w.d(this.itemView);
        }

        /* access modifiers changed from: package-private */
        public boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && androidx.core.g.w.d(this.itemView);
        }

        /* access modifiers changed from: package-private */
        public boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(w wVar, int i2) {
        if (o()) {
            wVar.mPendingAccessibilityState = i2;
            this.K.add(wVar);
            return false;
        }
        androidx.core.g.w.d(wVar.itemView, i2);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void x() {
        for (int size = this.K.size() - 1; size >= 0; size--) {
            w wVar = this.K.get(size);
            if (wVar.itemView.getParent() == this && !wVar.shouldIgnore()) {
                int i2 = wVar.mPendingAccessibilityState;
                if (i2 != -1) {
                    androidx.core.g.w.d(wVar.itemView, i2);
                    wVar.mPendingAccessibilityState = -1;
                }
            }
        }
        this.K.clear();
    }

    /* access modifiers changed from: package-private */
    public int d(w wVar) {
        if (wVar.hasAnyOfTheFlags(524) || !wVar.isBound()) {
            return -1;
        }
        return this.f2706f.c(wVar.mPosition);
    }

    /* access modifiers changed from: package-private */
    public void a(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + a());
        }
        Resources resources = getContext().getResources();
        new g(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(a.C0061a.fastscroll_default_thickness), resources.getDimensionPixelSize(a.C0061a.fastscroll_minimum_range), resources.getDimensionPixelOffset(a.C0061a.fastscroll_margin));
    }

    public void setNestedScrollingEnabled(boolean z2) {
        getScrollingChildHelper().a(z2);
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().a();
    }

    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().b(i2);
    }

    public boolean j(int i2, int i3) {
        return getScrollingChildHelper().a(i2, i3);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().c();
    }

    public void a(int i2) {
        getScrollingChildHelper().c(i2);
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().b();
    }

    public boolean j(int i2) {
        return getScrollingChildHelper().a(i2);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().a(i2, i3, i4, i5, iArr);
    }

    public boolean a(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().a(i2, i3, i4, i5, iArr, i6);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2);
    }

    public boolean a(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2, i4);
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return getScrollingChildHelper().a(f2, f3, z2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().a(f2, f3);
    }

    public static class j extends ViewGroup.MarginLayoutParams {

        /* renamed from: c  reason: collision with root package name */
        w f2732c;

        /* renamed from: d  reason: collision with root package name */
        final Rect f2733d = new Rect();

        /* renamed from: e  reason: collision with root package name */
        boolean f2734e = true;

        /* renamed from: f  reason: collision with root package name */
        boolean f2735f = false;

        public j(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public j(int i, int i2) {
            super(i, i2);
        }

        public j(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public j(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public j(j jVar) {
            super(jVar);
        }

        public boolean c() {
            return this.f2732c.isInvalid();
        }

        public boolean d() {
            return this.f2732c.isRemoved();
        }

        public boolean e() {
            return this.f2732c.isUpdated();
        }

        public int f() {
            return this.f2732c.getLayoutPosition();
        }
    }

    public static abstract class c {
        public void a() {
        }

        public void a(int i, int i2) {
        }

        public void a(int i, int i2, int i3) {
        }

        public void b(int i, int i2) {
        }

        public void c(int i, int i2) {
        }

        public void a(int i, int i2, Object obj) {
            a(i, i2);
        }
    }

    public static abstract class s {

        /* renamed from: a  reason: collision with root package name */
        private int f2750a = -1;

        /* renamed from: b  reason: collision with root package name */
        private RecyclerView f2751b;

        /* renamed from: c  reason: collision with root package name */
        private i f2752c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f2753d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f2754e;

        /* renamed from: f  reason: collision with root package name */
        private View f2755f;

        /* renamed from: g  reason: collision with root package name */
        private final a f2756g = new a(0, 0);
        private boolean h;

        public interface b {
            PointF d(int i);
        }

        /* access modifiers changed from: protected */
        public abstract void a();

        /* access modifiers changed from: protected */
        public abstract void a(int i, int i2, t tVar, a aVar);

        /* access modifiers changed from: protected */
        public abstract void a(View view, t tVar, a aVar);

        /* access modifiers changed from: protected */
        public abstract void b();

        /* access modifiers changed from: package-private */
        public void a(RecyclerView recyclerView, i iVar) {
            if (this.h) {
                Log.w("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started " + "more than once. Each instance of" + getClass().getSimpleName() + SQLBuilder.BLANK + "is intended to only be used once. You should create a new instance for " + "each use.");
            }
            this.f2751b = recyclerView;
            this.f2752c = iVar;
            if (this.f2750a != -1) {
                this.f2751b.D.f2764a = this.f2750a;
                this.f2754e = true;
                this.f2753d = true;
                this.f2755f = e(i());
                a();
                this.f2751b.A.a();
                this.h = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        public void c(int i) {
            this.f2750a = i;
        }

        public PointF d(int i) {
            i e2 = e();
            if (e2 instanceof b) {
                return ((b) e2).d(i);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        public i e() {
            return this.f2752c;
        }

        /* access modifiers changed from: protected */
        public final void f() {
            if (this.f2754e) {
                this.f2754e = false;
                b();
                this.f2751b.D.f2764a = -1;
                this.f2755f = null;
                this.f2750a = -1;
                this.f2753d = false;
                this.f2752c.b(this);
                this.f2752c = null;
                this.f2751b = null;
            }
        }

        public boolean g() {
            return this.f2753d;
        }

        public boolean h() {
            return this.f2754e;
        }

        public int i() {
            return this.f2750a;
        }

        /* access modifiers changed from: package-private */
        public void a(int i, int i2) {
            RecyclerView recyclerView = this.f2751b;
            if (!this.f2754e || this.f2750a == -1 || recyclerView == null) {
                f();
            }
            if (this.f2753d && this.f2755f == null && this.f2752c != null) {
                PointF d2 = d(this.f2750a);
                if (!(d2 == null || (d2.x == BitmapDescriptorFactory.HUE_RED && d2.y == BitmapDescriptorFactory.HUE_RED))) {
                    recyclerView.a((int) Math.signum(d2.x), (int) Math.signum(d2.y), (int[]) null);
                }
            }
            this.f2753d = false;
            View view = this.f2755f;
            if (view != null) {
                if (a(view) == this.f2750a) {
                    a(this.f2755f, recyclerView.D, this.f2756g);
                    this.f2756g.a(recyclerView);
                    f();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f2755f = null;
                }
            }
            if (this.f2754e) {
                a(i, i2, recyclerView.D, this.f2756g);
                boolean a2 = this.f2756g.a();
                this.f2756g.a(recyclerView);
                if (!a2) {
                    return;
                }
                if (this.f2754e) {
                    this.f2753d = true;
                    recyclerView.A.a();
                    return;
                }
                f();
            }
        }

        public int a(View view) {
            return this.f2751b.g(view);
        }

        public int j() {
            return this.f2751b.n.y();
        }

        public View e(int i) {
            return this.f2751b.n.c(i);
        }

        /* access modifiers changed from: protected */
        public void b(View view) {
            if (a(view) == i()) {
                this.f2755f = view;
            }
        }

        /* access modifiers changed from: protected */
        public void a(PointF pointF) {
            float sqrt = (float) Math.sqrt((double) ((pointF.x * pointF.x) + (pointF.y * pointF.y)));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            private int f2757a;

            /* renamed from: b  reason: collision with root package name */
            private int f2758b;

            /* renamed from: c  reason: collision with root package name */
            private int f2759c;

            /* renamed from: d  reason: collision with root package name */
            private int f2760d;

            /* renamed from: e  reason: collision with root package name */
            private Interpolator f2761e;

            /* renamed from: f  reason: collision with root package name */
            private boolean f2762f;

            /* renamed from: g  reason: collision with root package name */
            private int f2763g;

            public a(int i, int i2) {
                this(i, i2, RNCartPanelDataEntity.NULL_VALUE, (Interpolator) null);
            }

            public a(int i, int i2, int i3, Interpolator interpolator) {
                this.f2760d = -1;
                this.f2762f = false;
                this.f2763g = 0;
                this.f2757a = i;
                this.f2758b = i2;
                this.f2759c = i3;
                this.f2761e = interpolator;
            }

            public void a(int i) {
                this.f2760d = i;
            }

            /* access modifiers changed from: package-private */
            public boolean a() {
                return this.f2760d >= 0;
            }

            /* access modifiers changed from: package-private */
            public void a(RecyclerView recyclerView) {
                int i = this.f2760d;
                if (i >= 0) {
                    this.f2760d = -1;
                    recyclerView.c(i);
                    this.f2762f = false;
                } else if (this.f2762f) {
                    b();
                    if (this.f2761e != null) {
                        recyclerView.A.a(this.f2757a, this.f2758b, this.f2759c, this.f2761e);
                    } else if (this.f2759c == Integer.MIN_VALUE) {
                        recyclerView.A.b(this.f2757a, this.f2758b);
                    } else {
                        recyclerView.A.a(this.f2757a, this.f2758b, this.f2759c);
                    }
                    this.f2763g++;
                    if (this.f2763g > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f2762f = false;
                } else {
                    this.f2763g = 0;
                }
            }

            private void b() {
                if (this.f2761e != null && this.f2759c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.f2759c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public void a(int i, int i2, int i3, Interpolator interpolator) {
                this.f2757a = i;
                this.f2758b = i2;
                this.f2759c = i3;
                this.f2761e = interpolator;
                this.f2762f = true;
            }
        }
    }

    static class b extends Observable<c> {
        b() {
        }

        public boolean a() {
            return !this.mObservers.isEmpty();
        }

        public void b() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).a();
            }
        }

        public void a(int i, int i2) {
            a(i, i2, (Object) null);
        }

        public void a(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).a(i, i2, obj);
            }
        }

        public void b(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).b(i, i2);
            }
        }

        public void c(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).c(i, i2);
            }
        }

        public void d(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).a(i, i2, 1);
            }
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        Parcelable f2713a;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2713a = parcel.readParcelable(classLoader == null ? i.class.getClassLoader() : classLoader);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f2713a, 0);
        }

        /* access modifiers changed from: package-private */
        public void a(SavedState savedState) {
            this.f2713a = savedState.f2713a;
        }
    }

    public static class t {

        /* renamed from: a  reason: collision with root package name */
        int f2764a = -1;

        /* renamed from: b  reason: collision with root package name */
        int f2765b = 0;

        /* renamed from: c  reason: collision with root package name */
        int f2766c = 0;

        /* renamed from: d  reason: collision with root package name */
        int f2767d = 1;

        /* renamed from: e  reason: collision with root package name */
        int f2768e = 0;

        /* renamed from: f  reason: collision with root package name */
        boolean f2769f = false;

        /* renamed from: g  reason: collision with root package name */
        boolean f2770g = false;
        boolean h = false;
        boolean i = false;
        boolean j = false;
        boolean k = false;
        int l;
        long m;
        int n;
        int o;
        int p;
        private SparseArray<Object> q;

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            if ((this.f2767d & i2) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i2) + " but it is " + Integer.toBinaryString(this.f2767d));
            }
        }

        /* access modifiers changed from: package-private */
        public void a(a aVar) {
            this.f2767d = 1;
            this.f2768e = aVar.getItemCount();
            this.f2770g = false;
            this.h = false;
            this.i = false;
        }

        public boolean a() {
            return this.f2770g;
        }

        public boolean b() {
            return this.k;
        }

        public int c() {
            return this.f2764a;
        }

        public boolean d() {
            return this.f2764a != -1;
        }

        public int e() {
            return this.f2770g ? this.f2765b - this.f2766c : this.f2768e;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f2764a + ", mData=" + this.q + ", mItemCount=" + this.f2768e + ", mIsMeasuring=" + this.i + ", mPreviousLayoutItemCount=" + this.f2765b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f2766c + ", mStructureChanged=" + this.f2769f + ", mInPreLayout=" + this.f2770g + ", mRunSimpleAnimations=" + this.j + ", mRunPredictiveAnimations=" + this.k + '}';
        }
    }

    private class g implements f.b {
        g() {
        }

        public void a(w wVar) {
            wVar.setIsRecyclable(true);
            if (wVar.mShadowedHolder != null && wVar.mShadowingHolder == null) {
                wVar.mShadowedHolder = null;
            }
            wVar.mShadowingHolder = null;
            if (!wVar.shouldBeKeptAsChild() && !RecyclerView.this.a(wVar.itemView) && wVar.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(wVar.itemView, false);
            }
        }
    }

    public static abstract class f {
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_CHANGED = 2;
        public static final int FLAG_INVALIDATED = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_REMOVED = 8;
        private long mAddDuration = 120;
        private long mChangeDuration = 250;
        private ArrayList<a> mFinishedListeners = new ArrayList<>();
        private b mListener = null;
        private long mMoveDuration = 250;
        private long mRemoveDuration = 120;

        public interface a {
            void a();
        }

        interface b {
            void a(w wVar);
        }

        public abstract boolean animateAppearance(w wVar, c cVar, c cVar2);

        public abstract boolean animateChange(w wVar, w wVar2, c cVar, c cVar2);

        public abstract boolean animateDisappearance(w wVar, c cVar, c cVar2);

        public abstract boolean animatePersistence(w wVar, c cVar, c cVar2);

        public boolean canReuseUpdatedViewHolder(w wVar) {
            return true;
        }

        public abstract void endAnimation(w wVar);

        public abstract void endAnimations();

        public abstract boolean isRunning();

        public void onAnimationFinished(w wVar) {
        }

        public void onAnimationStarted(w wVar) {
        }

        public abstract void runPendingAnimations();

        public long getMoveDuration() {
            return this.mMoveDuration;
        }

        public void setMoveDuration(long j) {
            this.mMoveDuration = j;
        }

        public long getAddDuration() {
            return this.mAddDuration;
        }

        public void setAddDuration(long j) {
            this.mAddDuration = j;
        }

        public long getRemoveDuration() {
            return this.mRemoveDuration;
        }

        public void setRemoveDuration(long j) {
            this.mRemoveDuration = j;
        }

        public long getChangeDuration() {
            return this.mChangeDuration;
        }

        public void setChangeDuration(long j) {
            this.mChangeDuration = j;
        }

        /* access modifiers changed from: package-private */
        public void setListener(b bVar) {
            this.mListener = bVar;
        }

        public c recordPreLayoutInformation(t tVar, w wVar, int i, List<Object> list) {
            return obtainHolderInfo().a(wVar);
        }

        public c recordPostLayoutInformation(t tVar, w wVar) {
            return obtainHolderInfo().a(wVar);
        }

        static int buildAdapterChangeFlagsForAnimations(w wVar) {
            int i = wVar.mFlags & 14;
            if (wVar.isInvalid()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int oldPosition = wVar.getOldPosition();
            int adapterPosition = wVar.getAdapterPosition();
            return (oldPosition == -1 || adapterPosition == -1 || oldPosition == adapterPosition) ? i : i | 2048;
        }

        public final void dispatchAnimationFinished(w wVar) {
            onAnimationFinished(wVar);
            b bVar = this.mListener;
            if (bVar != null) {
                bVar.a(wVar);
            }
        }

        public final void dispatchAnimationStarted(w wVar) {
            onAnimationStarted(wVar);
        }

        public final boolean isRunning(a aVar) {
            boolean isRunning = isRunning();
            if (aVar != null) {
                if (!isRunning) {
                    aVar.a();
                } else {
                    this.mFinishedListeners.add(aVar);
                }
            }
            return isRunning;
        }

        public boolean canReuseUpdatedViewHolder(w wVar, List<Object> list) {
            return canReuseUpdatedViewHolder(wVar);
        }

        public final void dispatchAnimationsFinished() {
            int size = this.mFinishedListeners.size();
            for (int i = 0; i < size; i++) {
                this.mFinishedListeners.get(i).a();
            }
            this.mFinishedListeners.clear();
        }

        public c obtainHolderInfo() {
            return new c();
        }

        public static class c {

            /* renamed from: a  reason: collision with root package name */
            public int f2714a;

            /* renamed from: b  reason: collision with root package name */
            public int f2715b;

            /* renamed from: c  reason: collision with root package name */
            public int f2716c;

            /* renamed from: d  reason: collision with root package name */
            public int f2717d;

            public c a(w wVar) {
                return a(wVar, 0);
            }

            public c a(w wVar, int i) {
                View view = wVar.itemView;
                this.f2714a = view.getLeft();
                this.f2715b = view.getTop();
                this.f2716c = view.getRight();
                this.f2717d = view.getBottom();
                return this;
            }
        }
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        d dVar = this.aC;
        if (dVar == null) {
            return super.getChildDrawingOrder(i2, i3);
        }
        return dVar.a(i2, i3);
    }

    private androidx.core.g.m getScrollingChildHelper() {
        if (this.aE == null) {
            this.aE = new androidx.core.g.m(this);
        }
        return this.aE;
    }
}
