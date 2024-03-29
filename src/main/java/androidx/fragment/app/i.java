package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.h;
import androidx.lifecycle.e;
import androidx.lifecycle.s;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class i extends h implements LayoutInflater.Factory2 {
    static final Interpolator D = new DecelerateInterpolator(2.5f);
    static final Interpolator E = new DecelerateInterpolator(1.5f);

    /* renamed from: b  reason: collision with root package name */
    static boolean f2176b = false;
    SparseArray<Parcelable> A = null;
    ArrayList<g> B;
    Runnable C = new Runnable() {
        public void run() {
            i.this.l();
        }
    };
    private OnBackPressedDispatcher F;
    private final androidx.activity.c G = new androidx.activity.c(false) {
        public void c() {
            i.this.g();
        }
    };
    private final CopyOnWriteArrayList<c> H = new CopyOnWriteArrayList<>();
    private j I;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<e> f2177c;

    /* renamed from: d  reason: collision with root package name */
    boolean f2178d;

    /* renamed from: e  reason: collision with root package name */
    int f2179e = 0;

    /* renamed from: f  reason: collision with root package name */
    final ArrayList<Fragment> f2180f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    final HashMap<String, Fragment> f2181g = new HashMap<>();
    ArrayList<a> h;
    ArrayList<Fragment> i;
    ArrayList<a> j;
    ArrayList<Integer> k;
    ArrayList<h.b> l;
    int m = 0;
    g n;
    d o;
    Fragment p;
    Fragment q;
    boolean r;
    boolean s;
    boolean t;
    boolean u;
    boolean v;
    ArrayList<a> w;
    ArrayList<Boolean> x;
    ArrayList<Fragment> y;
    Bundle z = null;

    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        final h.a f2204a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f2205b;
    }

    static class d {

        /* renamed from: a  reason: collision with root package name */
        public static final int[] f2206a = {16842755, 16842960, 16842961};
    }

    interface e {
        boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2);
    }

    public static int b(int i2, boolean z2) {
        if (i2 == 4097) {
            return z2 ? 1 : 2;
        }
        if (i2 == 4099) {
            return z2 ? 5 : 6;
        }
        if (i2 != 8194) {
            return -1;
        }
        return z2 ? 3 : 4;
    }

    public static int d(int i2) {
        if (i2 == 4097) {
            return 8194;
        }
        if (i2 != 4099) {
            return i2 != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    /* access modifiers changed from: package-private */
    public LayoutInflater.Factory2 C() {
        return this;
    }

    i() {
    }

    private void a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new androidx.core.util.b("FragmentManager"));
        g gVar = this.n;
        if (gVar != null) {
            try {
                gVar.a("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        } else {
            try {
                a("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e3) {
                Log.e("FragmentManager", "Failed dumping state", e3);
            }
        }
        throw runtimeException;
    }

    public l a() {
        return new a(this);
    }

    public boolean b() {
        boolean l2 = l();
        G();
        return l2;
    }

    private void D() {
        ArrayList<e> arrayList = this.f2177c;
        boolean z2 = true;
        if (arrayList == null || arrayList.isEmpty()) {
            androidx.activity.c cVar = this.G;
            if (h() <= 0 || !b(this.p)) {
                z2 = false;
            }
            cVar.a(z2);
            return;
        }
        this.G.a(true);
    }

    /* access modifiers changed from: package-private */
    public boolean b(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        i iVar = fragment.mFragmentManager;
        if (fragment != iVar.A() || !b(iVar.p)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void g() {
        l();
        if (this.G.a()) {
            c();
        } else {
            this.F.a();
        }
    }

    public boolean c() {
        E();
        return a((String) null, -1, 0);
    }

    public void a(int i2, int i3) {
        if (i2 >= 0) {
            a((e) new f((String) null, i2, i3), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    private boolean a(String str, int i2, int i3) {
        l();
        c(true);
        Fragment fragment = this.q;
        if (fragment != null && i2 < 0 && str == null && fragment.getChildFragmentManager().c()) {
            return true;
        }
        boolean a2 = a(this.w, this.x, str, i2, i3);
        if (a2) {
            this.f2178d = true;
            try {
                b(this.w, this.x);
            } finally {
                F();
            }
        }
        D();
        m();
        I();
        return a2;
    }

    public int h() {
        ArrayList<a> arrayList = this.h;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public void a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            a((RuntimeException) new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.mWho);
    }

    public Fragment a(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment fragment = this.f2181g.get(string);
        if (fragment == null) {
            a((RuntimeException) new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return fragment;
    }

    public List<Fragment> d() {
        List<Fragment> list;
        if (this.f2180f.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f2180f) {
            list = (List) this.f2180f.clone();
        }
        return list;
    }

    /* access modifiers changed from: package-private */
    public s c(Fragment fragment) {
        return this.I.e(fragment);
    }

    /* access modifiers changed from: package-private */
    public j d(Fragment fragment) {
        return this.I.d(fragment);
    }

    /* access modifiers changed from: package-private */
    public void e(Fragment fragment) {
        if (f()) {
            if (f2176b) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (this.I.a(fragment) && f2176b) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
        }
    }

    /* access modifiers changed from: package-private */
    public void f(Fragment fragment) {
        if (f()) {
            if (f2176b) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else if (this.I.c(fragment) && f2176b) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    public Fragment.SavedState a(Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            a((RuntimeException) new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        if (fragment.mState <= 0) {
            return null;
        }
        Bundle t2 = t(fragment);
        if (t2 != null) {
            return new Fragment.SavedState(t2);
        }
        return null;
    }

    public boolean i() {
        return this.u;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.p;
        if (fragment != null) {
            androidx.core.util.a.a(fragment, sb);
        } else {
            androidx.core.util.a.a(this.n, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f2181g.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (Fragment next : this.f2181g.values()) {
                printWriter.print(str);
                printWriter.println(next);
                if (next != null) {
                    next.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size = this.f2180f.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(this.f2180f.get(i2).toString());
            }
        }
        ArrayList<Fragment> arrayList = this.i;
        if (arrayList != null) {
            int size2 = arrayList.size();
            if (size2 > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (int i3 = 0; i3 < size2; i3++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i3);
                    printWriter.print(": ");
                    printWriter.println(this.i.get(i3).toString());
                }
            }
        }
        ArrayList<a> arrayList2 = this.h;
        if (arrayList2 != null) {
            int size3 = arrayList2.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (int i4 = 0; i4 < size3; i4++) {
                    a aVar = this.h.get(i4);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(aVar.toString());
                    aVar.a(str2, printWriter);
                }
            }
        }
        synchronized (this) {
            if (this.j != null) {
                int size4 = this.j.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (int i5 = 0; i5 < size4; i5++) {
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i5);
                        printWriter.print(": ");
                        printWriter.println(this.j.get(i5));
                    }
                }
            }
            if (this.k != null && this.k.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.k.toArray()));
            }
        }
        ArrayList<e> arrayList3 = this.f2177c;
        if (arrayList3 != null) {
            int size5 = arrayList3.size();
            if (size5 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i6 = 0; i6 < size5; i6++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i6);
                    printWriter.print(": ");
                    printWriter.println(this.f2177c.get(i6));
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.n);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.o);
        if (this.p != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.p);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.m);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.s);
        printWriter.print(" mStopped=");
        printWriter.print(this.t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.u);
        if (this.r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.r);
        }
    }

    static a a(float f2, float f3, float f4, float f5) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(D);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f5);
        alphaAnimation.setInterpolator(E);
        alphaAnimation.setDuration(220);
        animationSet.addAnimation(alphaAnimation);
        return new a((Animation) animationSet);
    }

    static a a(float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setInterpolator(E);
        alphaAnimation.setDuration(220);
        return new a((Animation) alphaAnimation);
    }

    /* access modifiers changed from: package-private */
    public a a(Fragment fragment, int i2, boolean z2, int i3) {
        int nextAnim = fragment.getNextAnim();
        boolean z3 = false;
        fragment.setNextAnim(0);
        if (fragment.mContainer != null && fragment.mContainer.getLayoutTransition() != null) {
            return null;
        }
        Animation onCreateAnimation = fragment.onCreateAnimation(i2, z2, nextAnim);
        if (onCreateAnimation != null) {
            return new a(onCreateAnimation);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(i2, z2, nextAnim);
        if (onCreateAnimator != null) {
            return new a(onCreateAnimator);
        }
        if (nextAnim != 0) {
            boolean equals = "anim".equals(this.n.i().getResources().getResourceTypeName(nextAnim));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.n.i(), nextAnim);
                    if (loadAnimation != null) {
                        return new a(loadAnimation);
                    }
                    z3 = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            }
            if (!z3) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(this.n.i(), nextAnim);
                    if (loadAnimator != null) {
                        return new a(loadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.n.i(), nextAnim);
                        if (loadAnimation2 != null) {
                            return new a(loadAnimation2);
                        }
                    } else {
                        throw e3;
                    }
                }
            }
        }
        if (i2 == 0) {
            return null;
        }
        int b2 = b(i2, z2);
        if (b2 < 0) {
            return null;
        }
        switch (b2) {
            case 1:
                return a(1.125f, 1.0f, (float) BitmapDescriptorFactory.HUE_RED, 1.0f);
            case 2:
                return a(1.0f, 0.975f, 1.0f, (float) BitmapDescriptorFactory.HUE_RED);
            case 3:
                return a(0.975f, 1.0f, (float) BitmapDescriptorFactory.HUE_RED, 1.0f);
            case 4:
                return a(1.0f, 1.075f, 1.0f, (float) BitmapDescriptorFactory.HUE_RED);
            case 5:
                return a((float) BitmapDescriptorFactory.HUE_RED, 1.0f);
            case 6:
                return a(1.0f, (float) BitmapDescriptorFactory.HUE_RED);
            default:
                if (i3 == 0 && this.n.e()) {
                    i3 = this.n.f();
                }
                if (i3 == 0) {
                }
                return null;
        }
    }

    public void g(Fragment fragment) {
        if (!fragment.mDeferStart) {
            return;
        }
        if (this.f2178d) {
            this.v = true;
            return;
        }
        fragment.mDeferStart = false;
        a(fragment, this.m, 0, 0, false);
    }

    /* access modifiers changed from: package-private */
    public boolean b(int i2) {
        return this.m >= i2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v12, resolved type: int} */
    /* JADX WARNING: type inference failed for: r11v1 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0088, code lost:
        if (r0 != 3) goto L_0x04f8;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x02f7  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x04fd  */
    /* JADX WARNING: Removed duplicated region for block: B:265:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.fragment.app.Fragment r19, int r20, int r21, int r22, boolean r23) {
        /*
            r18 = this;
            r6 = r18
            r7 = r19
            boolean r0 = r7.mAdded
            r8 = 1
            if (r0 == 0) goto L_0x0011
            boolean r0 = r7.mDetached
            if (r0 == 0) goto L_0x000e
            goto L_0x0011
        L_0x000e:
            r0 = r20
            goto L_0x0016
        L_0x0011:
            r0 = r20
            if (r0 <= r8) goto L_0x0016
            r0 = 1
        L_0x0016:
            boolean r1 = r7.mRemoving
            if (r1 == 0) goto L_0x002c
            int r1 = r7.mState
            if (r0 <= r1) goto L_0x002c
            int r0 = r7.mState
            if (r0 != 0) goto L_0x002a
            boolean r0 = r19.isInBackStack()
            if (r0 == 0) goto L_0x002a
            r0 = 1
            goto L_0x002c
        L_0x002a:
            int r0 = r7.mState
        L_0x002c:
            boolean r1 = r7.mDeferStart
            r9 = 3
            r10 = 2
            if (r1 == 0) goto L_0x0039
            int r1 = r7.mState
            if (r1 >= r9) goto L_0x0039
            if (r0 <= r10) goto L_0x0039
            r0 = 2
        L_0x0039:
            androidx.lifecycle.e$b r1 = r7.mMaxState
            androidx.lifecycle.e$b r2 = androidx.lifecycle.e.b.CREATED
            if (r1 != r2) goto L_0x0044
            int r0 = java.lang.Math.min(r0, r8)
            goto L_0x004e
        L_0x0044:
            androidx.lifecycle.e$b r1 = r7.mMaxState
            int r1 = r1.ordinal()
            int r0 = java.lang.Math.min(r0, r1)
        L_0x004e:
            r11 = r0
            int r0 = r7.mState
            java.lang.String r12 = "FragmentManager"
            r13 = 0
            r14 = 0
            if (r0 > r11) goto L_0x033d
            boolean r0 = r7.mFromLayout
            if (r0 == 0) goto L_0x0060
            boolean r0 = r7.mInLayout
            if (r0 != 0) goto L_0x0060
            return
        L_0x0060:
            android.view.View r0 = r19.getAnimatingAway()
            if (r0 != 0) goto L_0x006c
            android.animation.Animator r0 = r19.getAnimator()
            if (r0 == 0) goto L_0x0080
        L_0x006c:
            r7.setAnimatingAway(r14)
            r7.setAnimator(r14)
            int r2 = r19.getStateAfterAnimating()
            r3 = 0
            r4 = 0
            r5 = 1
            r0 = r18
            r1 = r19
            r0.a((androidx.fragment.app.Fragment) r1, (int) r2, (int) r3, (int) r4, (boolean) r5)
        L_0x0080:
            int r0 = r7.mState
            if (r0 == 0) goto L_0x0092
            if (r0 == r8) goto L_0x01f9
            if (r0 == r10) goto L_0x008f
            if (r0 == r9) goto L_0x008c
            goto L_0x04f8
        L_0x008c:
            r0 = 3
            goto L_0x0317
        L_0x008f:
            r0 = 2
            goto L_0x02f5
        L_0x0092:
            if (r11 <= 0) goto L_0x01f9
            boolean r0 = f2176b
            if (r0 == 0) goto L_0x00ac
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveto CREATED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x00ac:
            android.os.Bundle r0 = r7.mSavedFragmentState
            if (r0 == 0) goto L_0x0109
            android.os.Bundle r0 = r7.mSavedFragmentState
            androidx.fragment.app.g r1 = r6.n
            android.content.Context r1 = r1.i()
            java.lang.ClassLoader r1 = r1.getClassLoader()
            r0.setClassLoader(r1)
            android.os.Bundle r0 = r7.mSavedFragmentState
            java.lang.String r1 = "android:view_state"
            android.util.SparseArray r0 = r0.getSparseParcelableArray(r1)
            r7.mSavedViewState = r0
            android.os.Bundle r0 = r7.mSavedFragmentState
            java.lang.String r1 = "android:target_state"
            androidx.fragment.app.Fragment r0 = r6.a((android.os.Bundle) r0, (java.lang.String) r1)
            if (r0 == 0) goto L_0x00d6
            java.lang.String r0 = r0.mWho
            goto L_0x00d7
        L_0x00d6:
            r0 = r14
        L_0x00d7:
            r7.mTargetWho = r0
            java.lang.String r0 = r7.mTargetWho
            if (r0 == 0) goto L_0x00e7
            android.os.Bundle r0 = r7.mSavedFragmentState
            java.lang.String r1 = "android:target_req_state"
            int r0 = r0.getInt(r1, r13)
            r7.mTargetRequestCode = r0
        L_0x00e7:
            java.lang.Boolean r0 = r7.mSavedUserVisibleHint
            if (r0 == 0) goto L_0x00f6
            java.lang.Boolean r0 = r7.mSavedUserVisibleHint
            boolean r0 = r0.booleanValue()
            r7.mUserVisibleHint = r0
            r7.mSavedUserVisibleHint = r14
            goto L_0x0100
        L_0x00f6:
            android.os.Bundle r0 = r7.mSavedFragmentState
            java.lang.String r1 = "android:user_visible_hint"
            boolean r0 = r0.getBoolean(r1, r8)
            r7.mUserVisibleHint = r0
        L_0x0100:
            boolean r0 = r7.mUserVisibleHint
            if (r0 != 0) goto L_0x0109
            r7.mDeferStart = r8
            if (r11 <= r10) goto L_0x0109
            r11 = 2
        L_0x0109:
            androidx.fragment.app.g r0 = r6.n
            r7.mHost = r0
            androidx.fragment.app.Fragment r1 = r6.p
            r7.mParentFragment = r1
            if (r1 == 0) goto L_0x0116
            androidx.fragment.app.i r0 = r1.mChildFragmentManager
            goto L_0x0118
        L_0x0116:
            androidx.fragment.app.i r0 = r0.f2170b
        L_0x0118:
            r7.mFragmentManager = r0
            androidx.fragment.app.Fragment r0 = r7.mTarget
            java.lang.String r15 = " that does not belong to this FragmentManager!"
            java.lang.String r5 = " declared target fragment "
            java.lang.String r4 = "Fragment "
            if (r0 == 0) goto L_0x0179
            java.util.HashMap<java.lang.String, androidx.fragment.app.Fragment> r0 = r6.f2181g
            androidx.fragment.app.Fragment r1 = r7.mTarget
            java.lang.String r1 = r1.mWho
            java.lang.Object r0 = r0.get(r1)
            androidx.fragment.app.Fragment r1 = r7.mTarget
            if (r0 != r1) goto L_0x0157
            androidx.fragment.app.Fragment r0 = r7.mTarget
            int r0 = r0.mState
            if (r0 >= r8) goto L_0x014c
            androidx.fragment.app.Fragment r1 = r7.mTarget
            r2 = 1
            r3 = 0
            r16 = 0
            r17 = 1
            r0 = r18
            r9 = r4
            r4 = r16
            r10 = r5
            r5 = r17
            r0.a((androidx.fragment.app.Fragment) r1, (int) r2, (int) r3, (int) r4, (boolean) r5)
            goto L_0x014e
        L_0x014c:
            r9 = r4
            r10 = r5
        L_0x014e:
            androidx.fragment.app.Fragment r0 = r7.mTarget
            java.lang.String r0 = r0.mWho
            r7.mTargetWho = r0
            r7.mTarget = r14
            goto L_0x017b
        L_0x0157:
            r9 = r4
            r10 = r5
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r9)
            r1.append(r7)
            r1.append(r10)
            androidx.fragment.app.Fragment r2 = r7.mTarget
            r1.append(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0179:
            r9 = r4
            r10 = r5
        L_0x017b:
            java.lang.String r0 = r7.mTargetWho
            if (r0 == 0) goto L_0x01ba
            java.util.HashMap<java.lang.String, androidx.fragment.app.Fragment> r0 = r6.f2181g
            java.lang.String r1 = r7.mTargetWho
            java.lang.Object r0 = r0.get(r1)
            r1 = r0
            androidx.fragment.app.Fragment r1 = (androidx.fragment.app.Fragment) r1
            if (r1 == 0) goto L_0x019a
            int r0 = r1.mState
            if (r0 >= r8) goto L_0x01ba
            r2 = 1
            r3 = 0
            r4 = 0
            r5 = 1
            r0 = r18
            r0.a((androidx.fragment.app.Fragment) r1, (int) r2, (int) r3, (int) r4, (boolean) r5)
            goto L_0x01ba
        L_0x019a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r9)
            r1.append(r7)
            r1.append(r10)
            java.lang.String r2 = r7.mTargetWho
            r1.append(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x01ba:
            androidx.fragment.app.g r0 = r6.n
            android.content.Context r0 = r0.i()
            r6.a((androidx.fragment.app.Fragment) r7, (android.content.Context) r0, (boolean) r13)
            r19.performAttach()
            androidx.fragment.app.Fragment r0 = r7.mParentFragment
            if (r0 != 0) goto L_0x01d0
            androidx.fragment.app.g r0 = r6.n
            r0.b(r7)
            goto L_0x01d5
        L_0x01d0:
            androidx.fragment.app.Fragment r0 = r7.mParentFragment
            r0.onAttachFragment(r7)
        L_0x01d5:
            androidx.fragment.app.g r0 = r6.n
            android.content.Context r0 = r0.i()
            r6.b((androidx.fragment.app.Fragment) r7, (android.content.Context) r0, (boolean) r13)
            boolean r0 = r7.mIsCreated
            if (r0 != 0) goto L_0x01f2
            android.os.Bundle r0 = r7.mSavedFragmentState
            r6.a((androidx.fragment.app.Fragment) r7, (android.os.Bundle) r0, (boolean) r13)
            android.os.Bundle r0 = r7.mSavedFragmentState
            r7.performCreate(r0)
            android.os.Bundle r0 = r7.mSavedFragmentState
            r6.b((androidx.fragment.app.Fragment) r7, (android.os.Bundle) r0, (boolean) r13)
            goto L_0x01f9
        L_0x01f2:
            android.os.Bundle r0 = r7.mSavedFragmentState
            r7.restoreChildFragmentState(r0)
            r7.mState = r8
        L_0x01f9:
            if (r11 <= 0) goto L_0x01fe
            r18.i(r19)
        L_0x01fe:
            if (r11 <= r8) goto L_0x008f
            boolean r0 = f2176b
            if (r0 == 0) goto L_0x0218
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveto ACTIVITY_CREATED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x0218:
            boolean r0 = r7.mFromLayout
            if (r0 != 0) goto L_0x02de
            int r0 = r7.mContainerId
            if (r0 == 0) goto L_0x0290
            int r0 = r7.mContainerId
            r1 = -1
            if (r0 != r1) goto L_0x0243
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot create fragment "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r2 = " for a container view with no id"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            r6.a((java.lang.RuntimeException) r0)
        L_0x0243:
            androidx.fragment.app.d r0 = r6.o
            int r1 = r7.mContainerId
            android.view.View r0 = r0.a(r1)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            if (r0 != 0) goto L_0x0291
            boolean r1 = r7.mRestored
            if (r1 != 0) goto L_0x0291
            android.content.res.Resources r1 = r19.getResources()     // Catch:{ NotFoundException -> 0x025e }
            int r2 = r7.mContainerId     // Catch:{ NotFoundException -> 0x025e }
            java.lang.String r1 = r1.getResourceName(r2)     // Catch:{ NotFoundException -> 0x025e }
            goto L_0x0260
        L_0x025e:
            java.lang.String r1 = "unknown"
        L_0x0260:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "No view found for id 0x"
            r3.append(r4)
            int r4 = r7.mContainerId
            java.lang.String r4 = java.lang.Integer.toHexString(r4)
            r3.append(r4)
            java.lang.String r4 = " ("
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = ") for fragment "
            r3.append(r1)
            r3.append(r7)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            r6.a((java.lang.RuntimeException) r2)
            goto L_0x0291
        L_0x0290:
            r0 = r14
        L_0x0291:
            r7.mContainer = r0
            android.os.Bundle r1 = r7.mSavedFragmentState
            android.view.LayoutInflater r1 = r7.performGetLayoutInflater(r1)
            android.os.Bundle r2 = r7.mSavedFragmentState
            r7.performCreateView(r1, r0, r2)
            android.view.View r1 = r7.mView
            if (r1 == 0) goto L_0x02dc
            android.view.View r1 = r7.mView
            r7.mInnerView = r1
            android.view.View r1 = r7.mView
            r1.setSaveFromParentEnabled(r13)
            if (r0 == 0) goto L_0x02b2
            android.view.View r1 = r7.mView
            r0.addView(r1)
        L_0x02b2:
            boolean r0 = r7.mHidden
            if (r0 == 0) goto L_0x02bd
            android.view.View r0 = r7.mView
            r1 = 8
            r0.setVisibility(r1)
        L_0x02bd:
            android.view.View r0 = r7.mView
            android.os.Bundle r1 = r7.mSavedFragmentState
            r7.onViewCreated(r0, r1)
            android.view.View r0 = r7.mView
            android.os.Bundle r1 = r7.mSavedFragmentState
            r6.a((androidx.fragment.app.Fragment) r7, (android.view.View) r0, (android.os.Bundle) r1, (boolean) r13)
            android.view.View r0 = r7.mView
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x02d8
            android.view.ViewGroup r0 = r7.mContainer
            if (r0 == 0) goto L_0x02d8
            goto L_0x02d9
        L_0x02d8:
            r8 = 0
        L_0x02d9:
            r7.mIsNewlyAdded = r8
            goto L_0x02de
        L_0x02dc:
            r7.mInnerView = r14
        L_0x02de:
            android.os.Bundle r0 = r7.mSavedFragmentState
            r7.performActivityCreated(r0)
            android.os.Bundle r0 = r7.mSavedFragmentState
            r6.c(r7, r0, r13)
            android.view.View r0 = r7.mView
            if (r0 == 0) goto L_0x02f1
            android.os.Bundle r0 = r7.mSavedFragmentState
            r7.restoreViewState(r0)
        L_0x02f1:
            r7.mSavedFragmentState = r14
            goto L_0x008f
        L_0x02f5:
            if (r11 <= r0) goto L_0x008c
            boolean r0 = f2176b
            if (r0 == 0) goto L_0x030f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveto STARTED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x030f:
            r19.performStart()
            r6.b((androidx.fragment.app.Fragment) r7, (boolean) r13)
            goto L_0x008c
        L_0x0317:
            if (r11 <= r0) goto L_0x04f8
            boolean r0 = f2176b
            if (r0 == 0) goto L_0x0331
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveto RESUMED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x0331:
            r19.performResume()
            r6.c((androidx.fragment.app.Fragment) r7, (boolean) r13)
            r7.mSavedFragmentState = r14
            r7.mSavedViewState = r14
            goto L_0x04f8
        L_0x033d:
            int r0 = r7.mState
            if (r0 <= r11) goto L_0x04f8
            int r0 = r7.mState
            if (r0 == r8) goto L_0x0425
            r1 = 2
            if (r0 == r1) goto L_0x0391
            r1 = 3
            if (r0 == r1) goto L_0x0370
            r1 = 4
            if (r0 == r1) goto L_0x0350
            goto L_0x04f8
        L_0x0350:
            if (r11 >= r1) goto L_0x0370
            boolean r0 = f2176b
            if (r0 == 0) goto L_0x036a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "movefrom RESUMED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x036a:
            r19.performPause()
            r6.d(r7, r13)
        L_0x0370:
            r0 = 3
            if (r11 >= r0) goto L_0x0391
            boolean r0 = f2176b
            if (r0 == 0) goto L_0x038b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "movefrom STARTED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x038b:
            r19.performStop()
            r6.e(r7, r13)
        L_0x0391:
            r0 = 2
            if (r11 >= r0) goto L_0x0425
            boolean r0 = f2176b
            if (r0 == 0) goto L_0x03ac
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "movefrom ACTIVITY_CREATED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x03ac:
            android.view.View r0 = r7.mView
            if (r0 == 0) goto L_0x03bf
            androidx.fragment.app.g r0 = r6.n
            boolean r0 = r0.a((androidx.fragment.app.Fragment) r7)
            if (r0 == 0) goto L_0x03bf
            android.util.SparseArray<android.os.Parcelable> r0 = r7.mSavedViewState
            if (r0 != 0) goto L_0x03bf
            r18.s(r19)
        L_0x03bf:
            r19.performDestroyView()
            r6.f(r7, r13)
            android.view.View r0 = r7.mView
            if (r0 == 0) goto L_0x0416
            android.view.ViewGroup r0 = r7.mContainer
            if (r0 == 0) goto L_0x0416
            android.view.ViewGroup r0 = r7.mContainer
            android.view.View r1 = r7.mView
            r0.endViewTransition(r1)
            android.view.View r0 = r7.mView
            r0.clearAnimation()
            androidx.fragment.app.Fragment r0 = r19.getParentFragment()
            if (r0 == 0) goto L_0x03e7
            androidx.fragment.app.Fragment r0 = r19.getParentFragment()
            boolean r0 = r0.mRemoving
            if (r0 != 0) goto L_0x0416
        L_0x03e7:
            int r0 = r6.m
            r1 = 0
            if (r0 <= 0) goto L_0x0407
            boolean r0 = r6.u
            if (r0 != 0) goto L_0x0407
            android.view.View r0 = r7.mView
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0407
            float r0 = r7.mPostponedAlpha
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0407
            r0 = r21
            r2 = r22
            androidx.fragment.app.i$a r0 = r6.a((androidx.fragment.app.Fragment) r7, (int) r0, (boolean) r13, (int) r2)
            goto L_0x0408
        L_0x0407:
            r0 = r14
        L_0x0408:
            r7.mPostponedAlpha = r1
            if (r0 == 0) goto L_0x040f
            r6.a((androidx.fragment.app.Fragment) r7, (androidx.fragment.app.i.a) r0, (int) r11)
        L_0x040f:
            android.view.ViewGroup r0 = r7.mContainer
            android.view.View r1 = r7.mView
            r0.removeView(r1)
        L_0x0416:
            r7.mContainer = r14
            r7.mView = r14
            r7.mViewLifecycleOwner = r14
            androidx.lifecycle.m<androidx.lifecycle.h> r0 = r7.mViewLifecycleOwnerLiveData
            r0.b(r14)
            r7.mInnerView = r14
            r7.mInLayout = r13
        L_0x0425:
            if (r11 >= r8) goto L_0x04f8
            boolean r0 = r6.u
            if (r0 == 0) goto L_0x044c
            android.view.View r0 = r19.getAnimatingAway()
            if (r0 == 0) goto L_0x043c
            android.view.View r0 = r19.getAnimatingAway()
            r7.setAnimatingAway(r14)
            r0.clearAnimation()
            goto L_0x044c
        L_0x043c:
            android.animation.Animator r0 = r19.getAnimator()
            if (r0 == 0) goto L_0x044c
            android.animation.Animator r0 = r19.getAnimator()
            r7.setAnimator(r14)
            r0.cancel()
        L_0x044c:
            android.view.View r0 = r19.getAnimatingAway()
            if (r0 != 0) goto L_0x04f4
            android.animation.Animator r0 = r19.getAnimator()
            if (r0 == 0) goto L_0x045a
            goto L_0x04f4
        L_0x045a:
            boolean r0 = f2176b
            if (r0 == 0) goto L_0x0472
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "movefrom CREATED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x0472:
            boolean r0 = r7.mRemoving
            if (r0 == 0) goto L_0x047e
            boolean r0 = r19.isInBackStack()
            if (r0 != 0) goto L_0x047e
            r0 = 1
            goto L_0x047f
        L_0x047e:
            r0 = 0
        L_0x047f:
            if (r0 != 0) goto L_0x048d
            androidx.fragment.app.j r1 = r6.I
            boolean r1 = r1.b(r7)
            if (r1 == 0) goto L_0x048a
            goto L_0x048d
        L_0x048a:
            r7.mState = r13
            goto L_0x04be
        L_0x048d:
            androidx.fragment.app.g r1 = r6.n
            boolean r2 = r1 instanceof androidx.lifecycle.t
            if (r2 == 0) goto L_0x049a
            androidx.fragment.app.j r1 = r6.I
            boolean r8 = r1.b()
            goto L_0x04af
        L_0x049a:
            android.content.Context r1 = r1.i()
            boolean r1 = r1 instanceof android.app.Activity
            if (r1 == 0) goto L_0x04af
            androidx.fragment.app.g r1 = r6.n
            android.content.Context r1 = r1.i()
            android.app.Activity r1 = (android.app.Activity) r1
            boolean r1 = r1.isChangingConfigurations()
            r8 = r8 ^ r1
        L_0x04af:
            if (r0 != 0) goto L_0x04b3
            if (r8 == 0) goto L_0x04b8
        L_0x04b3:
            androidx.fragment.app.j r1 = r6.I
            r1.f(r7)
        L_0x04b8:
            r19.performDestroy()
            r6.g(r7, r13)
        L_0x04be:
            r19.performDetach()
            r6.h(r7, r13)
            if (r23 != 0) goto L_0x04f8
            if (r0 != 0) goto L_0x04f0
            androidx.fragment.app.j r0 = r6.I
            boolean r0 = r0.b(r7)
            if (r0 == 0) goto L_0x04d1
            goto L_0x04f0
        L_0x04d1:
            r7.mHost = r14
            r7.mParentFragment = r14
            r7.mFragmentManager = r14
            java.lang.String r0 = r7.mTargetWho
            if (r0 == 0) goto L_0x04f8
            java.util.HashMap<java.lang.String, androidx.fragment.app.Fragment> r0 = r6.f2181g
            java.lang.String r1 = r7.mTargetWho
            java.lang.Object r0 = r0.get(r1)
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            if (r0 == 0) goto L_0x04f8
            boolean r1 = r0.getRetainInstance()
            if (r1 == 0) goto L_0x04f8
            r7.mTarget = r0
            goto L_0x04f8
        L_0x04f0:
            r18.m(r19)
            goto L_0x04f8
        L_0x04f4:
            r7.setStateAfterAnimating(r11)
            goto L_0x04f9
        L_0x04f8:
            r8 = r11
        L_0x04f9:
            int r0 = r7.mState
            if (r0 == r8) goto L_0x0525
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveToState: Fragment state for "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r1 = " not updated inline; expected state "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r1 = " found "
            r0.append(r1)
            int r1 = r7.mState
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r12, r0)
            r7.mState = r8
        L_0x0525:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.i.a(androidx.fragment.app.Fragment, int, int, int, boolean):void");
    }

    private void a(final Fragment fragment, a aVar, int i2) {
        final View view = fragment.mView;
        final ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        fragment.setStateAfterAnimating(i2);
        if (aVar.f2197a != null) {
            b bVar = new b(aVar.f2197a, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            bVar.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    viewGroup.post(new Runnable() {
                        public void run() {
                            if (fragment.getAnimatingAway() != null) {
                                fragment.setAnimatingAway((View) null);
                                i.this.a(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
                            }
                        }
                    });
                }
            });
            fragment.mView.startAnimation(bVar);
            return;
        }
        Animator animator = aVar.f2198b;
        fragment.setAnimator(aVar.f2198b);
        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                viewGroup.endViewTransition(view);
                Animator animator2 = fragment.getAnimator();
                fragment.setAnimator((Animator) null);
                if (animator2 != null && viewGroup.indexOfChild(view) < 0) {
                    i iVar = i.this;
                    Fragment fragment = fragment;
                    iVar.a(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
                }
            }
        });
        animator.setTarget(fragment.mView);
        animator.start();
    }

    /* access modifiers changed from: package-private */
    public void h(Fragment fragment) {
        a(fragment, this.m, 0, 0, false);
    }

    /* access modifiers changed from: package-private */
    public void i(Fragment fragment) {
        if (fragment.mFromLayout && !fragment.mPerformedCreateView) {
            fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), (ViewGroup) null, fragment.mSavedFragmentState);
            if (fragment.mView != null) {
                fragment.mInnerView = fragment.mView;
                fragment.mView.setSaveFromParentEnabled(false);
                if (fragment.mHidden) {
                    fragment.mView.setVisibility(8);
                }
                fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
                a(fragment, fragment.mView, fragment.mSavedFragmentState, false);
                return;
            }
            fragment.mInnerView = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void j(final Fragment fragment) {
        if (fragment.mView != null) {
            a a2 = a(fragment, fragment.getNextTransition(), !fragment.mHidden, fragment.getNextTransitionStyle());
            if (a2 == null || a2.f2198b == null) {
                if (a2 != null) {
                    fragment.mView.startAnimation(a2.f2197a);
                    a2.f2197a.start();
                }
                fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            } else {
                a2.f2198b.setTarget(fragment.mView);
                if (!fragment.mHidden) {
                    fragment.mView.setVisibility(0);
                } else if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                } else {
                    final ViewGroup viewGroup = fragment.mContainer;
                    final View view = fragment.mView;
                    viewGroup.startViewTransition(view);
                    a2.f2198b.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            viewGroup.endViewTransition(view);
                            animator.removeListener(this);
                            if (fragment.mView != null && fragment.mHidden) {
                                fragment.mView.setVisibility(8);
                            }
                        }
                    });
                }
                a2.f2198b.start();
            }
        }
        if (fragment.mAdded && x(fragment)) {
            this.r = true;
        }
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    /* access modifiers changed from: package-private */
    public void k(Fragment fragment) {
        if (fragment != null) {
            if (this.f2181g.containsKey(fragment.mWho)) {
                int i2 = this.m;
                if (fragment.mRemoving) {
                    if (fragment.isInBackStack()) {
                        i2 = Math.min(i2, 1);
                    } else {
                        i2 = Math.min(i2, 0);
                    }
                }
                a(fragment, i2, fragment.getNextTransition(), fragment.getNextTransitionStyle(), false);
                if (fragment.mView != null) {
                    Fragment v2 = v(fragment);
                    if (v2 != null) {
                        View view = v2.mView;
                        ViewGroup viewGroup = fragment.mContainer;
                        int indexOfChild = viewGroup.indexOfChild(view);
                        int indexOfChild2 = viewGroup.indexOfChild(fragment.mView);
                        if (indexOfChild2 < indexOfChild) {
                            viewGroup.removeViewAt(indexOfChild2);
                            viewGroup.addView(fragment.mView, indexOfChild);
                        }
                    }
                    if (fragment.mIsNewlyAdded && fragment.mContainer != null) {
                        if (fragment.mPostponedAlpha > BitmapDescriptorFactory.HUE_RED) {
                            fragment.mView.setAlpha(fragment.mPostponedAlpha);
                        }
                        fragment.mPostponedAlpha = BitmapDescriptorFactory.HUE_RED;
                        fragment.mIsNewlyAdded = false;
                        a a2 = a(fragment, fragment.getNextTransition(), true, fragment.getNextTransitionStyle());
                        if (a2 != null) {
                            if (a2.f2197a != null) {
                                fragment.mView.startAnimation(a2.f2197a);
                            } else {
                                a2.f2198b.setTarget(fragment.mView);
                                a2.f2198b.start();
                            }
                        }
                    }
                }
                if (fragment.mHiddenChanged) {
                    j(fragment);
                }
            } else if (f2176b) {
                Log.v("FragmentManager", "Ignoring moving " + fragment + " to state " + this.m + "since it is not added to " + this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, boolean z2) {
        if (this.n == null && i2 != 0) {
            throw new IllegalStateException("No activity");
        } else if (z2 || i2 != this.m) {
            this.m = i2;
            int size = this.f2180f.size();
            for (int i3 = 0; i3 < size; i3++) {
                k(this.f2180f.get(i3));
            }
            for (Fragment next : this.f2181g.values()) {
                if (next != null && ((next.mRemoving || next.mDetached) && !next.mIsNewlyAdded)) {
                    k(next);
                }
            }
            j();
            if (this.r) {
                g gVar = this.n;
                if (gVar != null && this.m == 4) {
                    gVar.d();
                    this.r = false;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        for (Fragment next : this.f2181g.values()) {
            if (next != null) {
                g(next);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void l(Fragment fragment) {
        if (this.f2181g.get(fragment.mWho) == null) {
            this.f2181g.put(fragment.mWho, fragment);
            if (fragment.mRetainInstanceChangedWhileDetached) {
                if (fragment.mRetainInstance) {
                    e(fragment);
                } else {
                    f(fragment);
                }
                fragment.mRetainInstanceChangedWhileDetached = false;
            }
            if (f2176b) {
                Log.v("FragmentManager", "Added fragment to active set " + fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void m(Fragment fragment) {
        if (this.f2181g.get(fragment.mWho) != null) {
            if (f2176b) {
                Log.v("FragmentManager", "Removed fragment from active set " + fragment);
            }
            for (Fragment next : this.f2181g.values()) {
                if (next != null && fragment.mWho.equals(next.mTargetWho)) {
                    next.mTarget = fragment;
                    next.mTargetWho = null;
                }
            }
            this.f2181g.put(fragment.mWho, (Object) null);
            f(fragment);
            if (fragment.mTargetWho != null) {
                fragment.mTarget = this.f2181g.get(fragment.mTargetWho);
            }
            fragment.initState();
        }
    }

    public void a(Fragment fragment, boolean z2) {
        if (f2176b) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        l(fragment);
        if (fragment.mDetached) {
            return;
        }
        if (!this.f2180f.contains(fragment)) {
            synchronized (this.f2180f) {
                this.f2180f.add(fragment);
            }
            fragment.mAdded = true;
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (x(fragment)) {
                this.r = true;
            }
            if (z2) {
                h(fragment);
                return;
            }
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    public void n(Fragment fragment) {
        if (f2176b) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z2 = !fragment.isInBackStack();
        if (!fragment.mDetached || z2) {
            synchronized (this.f2180f) {
                this.f2180f.remove(fragment);
            }
            if (x(fragment)) {
                this.r = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
        }
    }

    public void o(Fragment fragment) {
        if (f2176b) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        }
    }

    public void p(Fragment fragment) {
        if (f2176b) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public void q(Fragment fragment) {
        if (f2176b) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (f2176b) {
                    Log.v("FragmentManager", "remove from detach: " + fragment);
                }
                synchronized (this.f2180f) {
                    this.f2180f.remove(fragment);
                }
                if (x(fragment)) {
                    this.r = true;
                }
                fragment.mAdded = false;
            }
        }
    }

    public void r(Fragment fragment) {
        if (f2176b) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            if (!this.f2180f.contains(fragment)) {
                if (f2176b) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                synchronized (this.f2180f) {
                    this.f2180f.add(fragment);
                }
                fragment.mAdded = true;
                if (x(fragment)) {
                    this.r = true;
                    return;
                }
                return;
            }
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
    }

    public Fragment a(int i2) {
        for (int size = this.f2180f.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f2180f.get(size);
            if (fragment != null && fragment.mFragmentId == i2) {
                return fragment;
            }
        }
        for (Fragment next : this.f2181g.values()) {
            if (next != null && next.mFragmentId == i2) {
                return next;
            }
        }
        return null;
    }

    public Fragment a(String str) {
        if (str != null) {
            for (int size = this.f2180f.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f2180f.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (Fragment next : this.f2181g.values()) {
            if (next != null && str.equals(next.mTag)) {
                return next;
            }
        }
        return null;
    }

    public Fragment b(String str) {
        for (Fragment next : this.f2181g.values()) {
            if (next != null) {
                Fragment findFragmentByWho = next.findFragmentByWho(str);
                if (findFragmentByWho != null) {
                    return findFragmentByWho;
                }
            }
        }
        return null;
    }

    private void E() {
        if (f()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public boolean f() {
        return this.s || this.t;
    }

    public void a(e eVar, boolean z2) {
        if (!z2) {
            E();
        }
        synchronized (this) {
            if (!this.u) {
                if (this.n != null) {
                    if (this.f2177c == null) {
                        this.f2177c = new ArrayList<>();
                    }
                    this.f2177c.add(eVar);
                    k();
                    return;
                }
            }
            if (!z2) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void k() {
        synchronized (this) {
            boolean z2 = false;
            boolean z3 = this.B != null && !this.B.isEmpty();
            if (this.f2177c != null && this.f2177c.size() == 1) {
                z2 = true;
            }
            if (z3 || z2) {
                this.n.j().removeCallbacks(this.C);
                this.n.j().post(this.C);
                D();
            }
        }
    }

    public int a(a aVar) {
        synchronized (this) {
            if (this.k != null) {
                if (this.k.size() > 0) {
                    int intValue = this.k.remove(this.k.size() - 1).intValue();
                    if (f2176b) {
                        Log.v("FragmentManager", "Adding back stack index " + intValue + " with " + aVar);
                    }
                    this.j.set(intValue, aVar);
                    return intValue;
                }
            }
            if (this.j == null) {
                this.j = new ArrayList<>();
            }
            int size = this.j.size();
            if (f2176b) {
                Log.v("FragmentManager", "Setting back stack index " + size + " to " + aVar);
            }
            this.j.add(aVar);
            return size;
        }
    }

    public void a(int i2, a aVar) {
        synchronized (this) {
            if (this.j == null) {
                this.j = new ArrayList<>();
            }
            int size = this.j.size();
            if (i2 < size) {
                if (f2176b) {
                    Log.v("FragmentManager", "Setting back stack index " + i2 + " to " + aVar);
                }
                this.j.set(i2, aVar);
            } else {
                while (size < i2) {
                    this.j.add((Object) null);
                    if (this.k == null) {
                        this.k = new ArrayList<>();
                    }
                    if (f2176b) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.k.add(Integer.valueOf(size));
                    size++;
                }
                if (f2176b) {
                    Log.v("FragmentManager", "Adding back stack index " + i2 + " with " + aVar);
                }
                this.j.add(aVar);
            }
        }
    }

    public void c(int i2) {
        synchronized (this) {
            this.j.set(i2, (Object) null);
            if (this.k == null) {
                this.k = new ArrayList<>();
            }
            if (f2176b) {
                Log.v("FragmentManager", "Freeing back stack index " + i2);
            }
            this.k.add(Integer.valueOf(i2));
        }
    }

    private void c(boolean z2) {
        if (this.f2178d) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.n == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        } else if (Looper.myLooper() == this.n.j().getLooper()) {
            if (!z2) {
                E();
            }
            if (this.w == null) {
                this.w = new ArrayList<>();
                this.x = new ArrayList<>();
            }
            this.f2178d = true;
            try {
                a((ArrayList<a>) null, (ArrayList<Boolean>) null);
            } finally {
                this.f2178d = false;
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    public void b(e eVar, boolean z2) {
        if (!z2 || (this.n != null && !this.u)) {
            c(z2);
            if (eVar.a(this.w, this.x)) {
                this.f2178d = true;
                try {
                    b(this.w, this.x);
                } finally {
                    F();
                }
            }
            D();
            m();
            I();
        }
    }

    private void F() {
        this.f2178d = false;
        this.x.clear();
        this.w.clear();
    }

    /* JADX INFO: finally extract failed */
    public boolean l() {
        c(true);
        boolean z2 = false;
        while (c(this.w, this.x)) {
            this.f2178d = true;
            try {
                b(this.w, this.x);
                F();
                z2 = true;
            } catch (Throwable th) {
                F();
                throw th;
            }
        }
        D();
        m();
        I();
        return z2;
    }

    private void a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        ArrayList<g> arrayList3 = this.B;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            g gVar = this.B.get(i2);
            if (arrayList != null && !gVar.f2211a) {
                int indexOf = arrayList.indexOf(gVar.f2212b);
                if (indexOf != -1 && arrayList2.get(indexOf).booleanValue()) {
                    this.B.remove(i2);
                    i2--;
                    size--;
                    gVar.e();
                    i2++;
                }
            }
            if (gVar.c() || (arrayList != null && gVar.f2212b.a(arrayList, 0, arrayList.size()))) {
                this.B.remove(i2);
                i2--;
                size--;
                if (arrayList != null && !gVar.f2211a) {
                    int indexOf2 = arrayList.indexOf(gVar.f2212b);
                    if (indexOf2 != -1 && arrayList2.get(indexOf2).booleanValue()) {
                        gVar.e();
                    }
                }
                gVar.d();
            }
            i2++;
        }
    }

    private void b(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList != null && !arrayList.isEmpty()) {
            if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
                throw new IllegalStateException("Internal error with the back stack records");
            }
            a(arrayList, arrayList2);
            int size = arrayList.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                if (!arrayList.get(i2).t) {
                    if (i3 != i2) {
                        a(arrayList, arrayList2, i3, i2);
                    }
                    i3 = i2 + 1;
                    if (arrayList2.get(i2).booleanValue()) {
                        while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).t) {
                            i3++;
                        }
                    }
                    a(arrayList, arrayList2, i2, i3);
                    i2 = i3 - 1;
                }
                i2++;
            }
            if (i3 != size) {
                a(arrayList, arrayList2, i3, size);
            }
        }
    }

    private void a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        int i4;
        ArrayList<a> arrayList3 = arrayList;
        ArrayList<Boolean> arrayList4 = arrayList2;
        int i5 = i2;
        int i6 = i3;
        boolean z2 = arrayList3.get(i5).t;
        ArrayList<Fragment> arrayList5 = this.y;
        if (arrayList5 == null) {
            this.y = new ArrayList<>();
        } else {
            arrayList5.clear();
        }
        this.y.addAll(this.f2180f);
        Fragment A2 = A();
        boolean z3 = false;
        for (int i7 = i5; i7 < i6; i7++) {
            a aVar = arrayList3.get(i7);
            if (!arrayList4.get(i7).booleanValue()) {
                A2 = aVar.a(this.y, A2);
            } else {
                A2 = aVar.b(this.y, A2);
            }
            z3 = z3 || aVar.k;
        }
        this.y.clear();
        if (!z2) {
            m.a(this, arrayList, arrayList2, i2, i3, false);
        }
        b(arrayList, arrayList2, i2, i3);
        if (z2) {
            androidx.b.b bVar = new androidx.b.b();
            b((androidx.b.b<Fragment>) bVar);
            int a2 = a(arrayList, arrayList2, i2, i3, (androidx.b.b<Fragment>) bVar);
            a((androidx.b.b<Fragment>) bVar);
            i4 = a2;
        } else {
            i4 = i6;
        }
        if (i4 != i5 && z2) {
            m.a(this, arrayList, arrayList2, i2, i4, true);
            a(this.m, true);
        }
        while (i5 < i6) {
            a aVar2 = arrayList3.get(i5);
            if (arrayList4.get(i5).booleanValue() && aVar2.f2164c >= 0) {
                c(aVar2.f2164c);
                aVar2.f2164c = -1;
            }
            aVar2.a();
            i5++;
        }
        if (z3) {
            n();
        }
    }

    private void a(androidx.b.b<Fragment> bVar) {
        int size = bVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment b2 = bVar.b(i2);
            if (!b2.mAdded) {
                View requireView = b2.requireView();
                b2.mPostponedAlpha = requireView.getAlpha();
                requireView.setAlpha(BitmapDescriptorFactory.HUE_RED);
            }
        }
    }

    private int a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, androidx.b.b<Fragment> bVar) {
        int i4 = i3;
        for (int i5 = i3 - 1; i5 >= i2; i5--) {
            a aVar = arrayList.get(i5);
            boolean booleanValue = arrayList2.get(i5).booleanValue();
            if (aVar.g() && !aVar.a(arrayList, i5 + 1, i3)) {
                if (this.B == null) {
                    this.B = new ArrayList<>();
                }
                g gVar = new g(aVar, booleanValue);
                this.B.add(gVar);
                aVar.a((Fragment.c) gVar);
                if (booleanValue) {
                    aVar.f();
                } else {
                    aVar.b(false);
                }
                i4--;
                if (i5 != i4) {
                    arrayList.remove(i5);
                    arrayList.add(i4, aVar);
                }
                b(bVar);
            }
        }
        return i4;
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar, boolean z2, boolean z3, boolean z4) {
        if (z2) {
            aVar.b(z4);
        } else {
            aVar.f();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z2));
        if (z3) {
            m.a(this, (ArrayList<a>) arrayList, (ArrayList<Boolean>) arrayList2, 0, 1, true);
        }
        if (z4) {
            a(this.m, true);
        }
        for (Fragment next : this.f2181g.values()) {
            if (next != null && next.mView != null && next.mIsNewlyAdded && aVar.b(next.mContainerId)) {
                if (next.mPostponedAlpha > BitmapDescriptorFactory.HUE_RED) {
                    next.mView.setAlpha(next.mPostponedAlpha);
                }
                if (z4) {
                    next.mPostponedAlpha = BitmapDescriptorFactory.HUE_RED;
                } else {
                    next.mPostponedAlpha = -1.0f;
                    next.mIsNewlyAdded = false;
                }
            }
        }
    }

    private Fragment v(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        View view = fragment.mView;
        if (!(viewGroup == null || view == null)) {
            for (int indexOf = this.f2180f.indexOf(fragment) - 1; indexOf >= 0; indexOf--) {
                Fragment fragment2 = this.f2180f.get(indexOf);
                if (fragment2.mContainer == viewGroup && fragment2.mView != null) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    private static void b(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        while (i2 < i3) {
            a aVar = arrayList.get(i2);
            boolean z2 = true;
            if (arrayList2.get(i2).booleanValue()) {
                aVar.a(-1);
                if (i2 != i3 - 1) {
                    z2 = false;
                }
                aVar.b(z2);
            } else {
                aVar.a(1);
                aVar.f();
            }
            i2++;
        }
    }

    private void b(androidx.b.b<Fragment> bVar) {
        int i2 = this.m;
        if (i2 >= 1) {
            int min = Math.min(i2, 3);
            int size = this.f2180f.size();
            for (int i3 = 0; i3 < size; i3++) {
                Fragment fragment = this.f2180f.get(i3);
                if (fragment.mState < min) {
                    a(fragment, min, fragment.getNextAnim(), fragment.getNextTransition(), false);
                    if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                        bVar.add(fragment);
                    }
                }
            }
        }
    }

    private void G() {
        if (this.B != null) {
            while (!this.B.isEmpty()) {
                this.B.remove(0).d();
            }
        }
    }

    private void H() {
        for (Fragment next : this.f2181g.values()) {
            if (next != null) {
                if (next.getAnimatingAway() != null) {
                    int stateAfterAnimating = next.getStateAfterAnimating();
                    View animatingAway = next.getAnimatingAway();
                    Animation animation = animatingAway.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        animatingAway.clearAnimation();
                    }
                    next.setAnimatingAway((View) null);
                    a(next, stateAfterAnimating, 0, 0, false);
                } else if (next.getAnimator() != null) {
                    next.getAnimator().end();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c(java.util.ArrayList<androidx.fragment.app.a> r5, java.util.ArrayList<java.lang.Boolean> r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.ArrayList<androidx.fragment.app.i$e> r0 = r4.f2177c     // Catch:{ all -> 0x003c }
            r1 = 0
            if (r0 == 0) goto L_0x003a
            java.util.ArrayList<androidx.fragment.app.i$e> r0 = r4.f2177c     // Catch:{ all -> 0x003c }
            int r0 = r0.size()     // Catch:{ all -> 0x003c }
            if (r0 != 0) goto L_0x000f
            goto L_0x003a
        L_0x000f:
            java.util.ArrayList<androidx.fragment.app.i$e> r0 = r4.f2177c     // Catch:{ all -> 0x003c }
            int r0 = r0.size()     // Catch:{ all -> 0x003c }
            r2 = 0
        L_0x0016:
            if (r1 >= r0) goto L_0x0028
            java.util.ArrayList<androidx.fragment.app.i$e> r3 = r4.f2177c     // Catch:{ all -> 0x003c }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ all -> 0x003c }
            androidx.fragment.app.i$e r3 = (androidx.fragment.app.i.e) r3     // Catch:{ all -> 0x003c }
            boolean r3 = r3.a(r5, r6)     // Catch:{ all -> 0x003c }
            r2 = r2 | r3
            int r1 = r1 + 1
            goto L_0x0016
        L_0x0028:
            java.util.ArrayList<androidx.fragment.app.i$e> r5 = r4.f2177c     // Catch:{ all -> 0x003c }
            r5.clear()     // Catch:{ all -> 0x003c }
            androidx.fragment.app.g r5 = r4.n     // Catch:{ all -> 0x003c }
            android.os.Handler r5 = r5.j()     // Catch:{ all -> 0x003c }
            java.lang.Runnable r6 = r4.C     // Catch:{ all -> 0x003c }
            r5.removeCallbacks(r6)     // Catch:{ all -> 0x003c }
            monitor-exit(r4)     // Catch:{ all -> 0x003c }
            return r2
        L_0x003a:
            monitor-exit(r4)     // Catch:{ all -> 0x003c }
            return r1
        L_0x003c:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x003c }
            goto L_0x0040
        L_0x003f:
            throw r5
        L_0x0040:
            goto L_0x003f
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.i.c(java.util.ArrayList, java.util.ArrayList):boolean");
    }

    /* access modifiers changed from: package-private */
    public void m() {
        if (this.v) {
            this.v = false;
            j();
        }
    }

    /* access modifiers changed from: package-private */
    public void n() {
        if (this.l != null) {
            for (int i2 = 0; i2 < this.l.size(); i2++) {
                this.l.get(i2).a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(a aVar) {
        if (this.h == null) {
            this.h = new ArrayList<>();
        }
        this.h.add(aVar);
    }

    /* access modifiers changed from: package-private */
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        int i4;
        ArrayList<a> arrayList3 = this.h;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.h.remove(size));
            arrayList2.add(true);
        } else {
            if (str != null || i2 >= 0) {
                i4 = this.h.size() - 1;
                while (i4 >= 0) {
                    a aVar = this.h.get(i4);
                    if ((str != null && str.equals(aVar.h())) || (i2 >= 0 && i2 == aVar.f2164c)) {
                        break;
                    }
                    i4--;
                }
                if (i4 < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        i4--;
                        if (i4 < 0) {
                            break;
                        }
                        a aVar2 = this.h.get(i4);
                        if ((str == null || !str.equals(aVar2.h())) && (i2 < 0 || i2 != aVar2.f2164c)) {
                            break;
                        }
                    }
                }
            } else {
                i4 = -1;
            }
            if (i4 == this.h.size() - 1) {
                return false;
            }
            for (int size2 = this.h.size() - 1; size2 > i4; size2--) {
                arrayList.add(this.h.remove(size2));
                arrayList2.add(true);
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void s(Fragment fragment) {
        if (fragment.mInnerView != null) {
            SparseArray<Parcelable> sparseArray = this.A;
            if (sparseArray == null) {
                this.A = new SparseArray<>();
            } else {
                sparseArray.clear();
            }
            fragment.mInnerView.saveHierarchyState(this.A);
            if (this.A.size() > 0) {
                fragment.mSavedViewState = this.A;
                this.A = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Bundle t(Fragment fragment) {
        Bundle bundle;
        if (this.z == null) {
            this.z = new Bundle();
        }
        fragment.performSaveInstanceState(this.z);
        d(fragment, this.z, false);
        if (!this.z.isEmpty()) {
            bundle = this.z;
            this.z = null;
        } else {
            bundle = null;
        }
        if (fragment.mView != null) {
            s(fragment);
        }
        if (fragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
        }
        if (!fragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
        }
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public Parcelable o() {
        ArrayList<String> arrayList;
        G();
        H();
        l();
        this.s = true;
        BackStackState[] backStackStateArr = null;
        if (this.f2181g.isEmpty()) {
            return null;
        }
        ArrayList<FragmentState> arrayList2 = new ArrayList<>(this.f2181g.size());
        boolean z2 = false;
        for (Fragment next : this.f2181g.values()) {
            if (next != null) {
                if (next.mFragmentManager != this) {
                    a((RuntimeException) new IllegalStateException("Failure saving state: active " + next + " was removed from the FragmentManager"));
                }
                FragmentState fragmentState = new FragmentState(next);
                arrayList2.add(fragmentState);
                if (next.mState <= 0 || fragmentState.m != null) {
                    fragmentState.m = next.mSavedFragmentState;
                } else {
                    fragmentState.m = t(next);
                    if (next.mTargetWho != null) {
                        Fragment fragment = this.f2181g.get(next.mTargetWho);
                        if (fragment == null) {
                            a((RuntimeException) new IllegalStateException("Failure saving state: " + next + " has target not in fragment manager: " + next.mTargetWho));
                        }
                        if (fragmentState.m == null) {
                            fragmentState.m = new Bundle();
                        }
                        a(fragmentState.m, "android:target_state", fragment);
                        if (next.mTargetRequestCode != 0) {
                            fragmentState.m.putInt("android:target_req_state", next.mTargetRequestCode);
                        }
                    }
                }
                if (f2176b) {
                    Log.v("FragmentManager", "Saved state of " + next + ": " + fragmentState.m);
                }
                z2 = true;
            }
        }
        if (!z2) {
            if (f2176b) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        int size = this.f2180f.size();
        if (size > 0) {
            arrayList = new ArrayList<>(size);
            Iterator<Fragment> it = this.f2180f.iterator();
            while (it.hasNext()) {
                Fragment next2 = it.next();
                arrayList.add(next2.mWho);
                if (next2.mFragmentManager != this) {
                    a((RuntimeException) new IllegalStateException("Failure saving state: active " + next2 + " was removed from the FragmentManager"));
                }
                if (f2176b) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + next2.mWho + "): " + next2);
                }
            }
        } else {
            arrayList = null;
        }
        ArrayList<a> arrayList3 = this.h;
        if (arrayList3 != null) {
            int size2 = arrayList3.size();
            if (size2 > 0) {
                backStackStateArr = new BackStackState[size2];
                for (int i2 = 0; i2 < size2; i2++) {
                    backStackStateArr[i2] = new BackStackState(this.h.get(i2));
                    if (f2176b) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.h.get(i2));
                    }
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.f2138a = arrayList2;
        fragmentManagerState.f2139b = arrayList;
        fragmentManagerState.f2140c = backStackStateArr;
        Fragment fragment2 = this.q;
        if (fragment2 != null) {
            fragmentManagerState.f2141d = fragment2.mWho;
        }
        fragmentManagerState.f2142e = this.f2179e;
        return fragmentManagerState;
    }

    /* access modifiers changed from: package-private */
    public void a(Parcelable parcelable) {
        FragmentState fragmentState;
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.f2138a != null) {
                for (Fragment next : this.I.c()) {
                    if (f2176b) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + next);
                    }
                    Iterator<FragmentState> it = fragmentManagerState.f2138a.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            fragmentState = null;
                            break;
                        }
                        fragmentState = it.next();
                        if (fragmentState.f2144b.equals(next.mWho)) {
                            break;
                        }
                    }
                    if (fragmentState == null) {
                        if (f2176b) {
                            Log.v("FragmentManager", "Discarding retained Fragment " + next + " that was not found in the set of active Fragments " + fragmentManagerState.f2138a);
                        }
                        Fragment fragment = next;
                        a(fragment, 1, 0, 0, false);
                        next.mRemoving = true;
                        a(fragment, 0, 0, 0, false);
                    } else {
                        fragmentState.n = next;
                        next.mSavedViewState = null;
                        next.mBackStackNesting = 0;
                        next.mInLayout = false;
                        next.mAdded = false;
                        next.mTargetWho = next.mTarget != null ? next.mTarget.mWho : null;
                        next.mTarget = null;
                        if (fragmentState.m != null) {
                            fragmentState.m.setClassLoader(this.n.i().getClassLoader());
                            next.mSavedViewState = fragmentState.m.getSparseParcelableArray("android:view_state");
                            next.mSavedFragmentState = fragmentState.m;
                        }
                    }
                }
                this.f2181g.clear();
                Iterator<FragmentState> it2 = fragmentManagerState.f2138a.iterator();
                while (it2.hasNext()) {
                    FragmentState next2 = it2.next();
                    if (next2 != null) {
                        Fragment a2 = next2.a(this.n.i().getClassLoader(), e());
                        a2.mFragmentManager = this;
                        if (f2176b) {
                            Log.v("FragmentManager", "restoreSaveState: active (" + a2.mWho + "): " + a2);
                        }
                        this.f2181g.put(a2.mWho, a2);
                        next2.n = null;
                    }
                }
                this.f2180f.clear();
                if (fragmentManagerState.f2139b != null) {
                    Iterator<String> it3 = fragmentManagerState.f2139b.iterator();
                    while (it3.hasNext()) {
                        String next3 = it3.next();
                        Fragment fragment2 = this.f2181g.get(next3);
                        if (fragment2 == null) {
                            a((RuntimeException) new IllegalStateException("No instantiated fragment for (" + next3 + SQLBuilder.PARENTHESES_RIGHT));
                        }
                        fragment2.mAdded = true;
                        if (f2176b) {
                            Log.v("FragmentManager", "restoreSaveState: added (" + next3 + "): " + fragment2);
                        }
                        if (!this.f2180f.contains(fragment2)) {
                            synchronized (this.f2180f) {
                                this.f2180f.add(fragment2);
                            }
                        } else {
                            throw new IllegalStateException("Already added " + fragment2);
                        }
                    }
                }
                if (fragmentManagerState.f2140c != null) {
                    this.h = new ArrayList<>(fragmentManagerState.f2140c.length);
                    for (int i2 = 0; i2 < fragmentManagerState.f2140c.length; i2++) {
                        a a3 = fragmentManagerState.f2140c[i2].a(this);
                        if (f2176b) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + a3.f2164c + "): " + a3);
                            PrintWriter printWriter = new PrintWriter(new androidx.core.util.b("FragmentManager"));
                            a3.a("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.h.add(a3);
                        if (a3.f2164c >= 0) {
                            a(a3.f2164c, a3);
                        }
                    }
                } else {
                    this.h = null;
                }
                if (fragmentManagerState.f2141d != null) {
                    this.q = this.f2181g.get(fragmentManagerState.f2141d);
                    w(this.q);
                }
                this.f2179e = fragmentManagerState.f2142e;
            }
        }
    }

    private void I() {
        this.f2181g.values().removeAll(Collections.singleton((Object) null));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: androidx.activity.d} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: androidx.fragment.app.Fragment} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.fragment.app.g r3, androidx.fragment.app.d r4, androidx.fragment.app.Fragment r5) {
        /*
            r2 = this;
            androidx.fragment.app.g r0 = r2.n
            if (r0 != 0) goto L_0x004d
            r2.n = r3
            r2.o = r4
            r2.p = r5
            androidx.fragment.app.Fragment r4 = r2.p
            if (r4 == 0) goto L_0x0011
            r2.D()
        L_0x0011:
            boolean r4 = r3 instanceof androidx.activity.d
            if (r4 == 0) goto L_0x0028
            r4 = r3
            androidx.activity.d r4 = (androidx.activity.d) r4
            androidx.activity.OnBackPressedDispatcher r0 = r4.getOnBackPressedDispatcher()
            r2.F = r0
            if (r5 == 0) goto L_0x0021
            r4 = r5
        L_0x0021:
            androidx.activity.OnBackPressedDispatcher r0 = r2.F
            androidx.activity.c r1 = r2.G
            r0.a(r4, r1)
        L_0x0028:
            if (r5 == 0) goto L_0x0033
            androidx.fragment.app.i r3 = r5.mFragmentManager
            androidx.fragment.app.j r3 = r3.d((androidx.fragment.app.Fragment) r5)
            r2.I = r3
            goto L_0x004c
        L_0x0033:
            boolean r4 = r3 instanceof androidx.lifecycle.t
            if (r4 == 0) goto L_0x0044
            androidx.lifecycle.t r3 = (androidx.lifecycle.t) r3
            androidx.lifecycle.s r3 = r3.getViewModelStore()
            androidx.fragment.app.j r3 = androidx.fragment.app.j.a((androidx.lifecycle.s) r3)
            r2.I = r3
            goto L_0x004c
        L_0x0044:
            androidx.fragment.app.j r3 = new androidx.fragment.app.j
            r4 = 0
            r3.<init>(r4)
            r2.I = r3
        L_0x004c:
            return
        L_0x004d:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "Already attached"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.i.a(androidx.fragment.app.g, androidx.fragment.app.d, androidx.fragment.app.Fragment):void");
    }

    public void p() {
        this.s = false;
        this.t = false;
        int size = this.f2180f.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.f2180f.get(i2);
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    public void q() {
        this.s = false;
        this.t = false;
        e(1);
    }

    public void r() {
        this.s = false;
        this.t = false;
        e(2);
    }

    public void s() {
        this.s = false;
        this.t = false;
        e(3);
    }

    public void t() {
        this.s = false;
        this.t = false;
        e(4);
    }

    public void u() {
        e(3);
    }

    public void v() {
        this.t = true;
        e(2);
    }

    public void w() {
        e(1);
    }

    public void x() {
        this.u = true;
        l();
        e(0);
        this.n = null;
        this.o = null;
        this.p = null;
        if (this.F != null) {
            this.G.b();
            this.F = null;
        }
    }

    /* JADX INFO: finally extract failed */
    private void e(int i2) {
        try {
            this.f2178d = true;
            a(i2, false);
            this.f2178d = false;
            l();
        } catch (Throwable th) {
            this.f2178d = false;
            throw th;
        }
    }

    public void a(boolean z2) {
        for (int size = this.f2180f.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f2180f.get(size);
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z2);
            }
        }
    }

    public void b(boolean z2) {
        for (int size = this.f2180f.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f2180f.get(size);
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z2);
            }
        }
    }

    public void a(Configuration configuration) {
        for (int i2 = 0; i2 < this.f2180f.size(); i2++) {
            Fragment fragment = this.f2180f.get(i2);
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    public void y() {
        for (int i2 = 0; i2 < this.f2180f.size(); i2++) {
            Fragment fragment = this.f2180f.get(i2);
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        if (this.m < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z2 = false;
        for (int i2 = 0; i2 < this.f2180f.size(); i2++) {
            Fragment fragment = this.f2180f.get(i2);
            if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z2 = true;
            }
        }
        if (this.i != null) {
            for (int i3 = 0; i3 < this.i.size(); i3++) {
                Fragment fragment2 = this.i.get(i3);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.i = arrayList;
        return z2;
    }

    public boolean a(Menu menu) {
        if (this.m < 1) {
            return false;
        }
        boolean z2 = false;
        for (int i2 = 0; i2 < this.f2180f.size(); i2++) {
            Fragment fragment = this.f2180f.get(i2);
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z2 = true;
            }
        }
        return z2;
    }

    public boolean a(MenuItem menuItem) {
        if (this.m < 1) {
            return false;
        }
        for (int i2 = 0; i2 < this.f2180f.size(); i2++) {
            Fragment fragment = this.f2180f.get(i2);
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean b(MenuItem menuItem) {
        if (this.m < 1) {
            return false;
        }
        for (int i2 = 0; i2 < this.f2180f.size(); i2++) {
            Fragment fragment = this.f2180f.get(i2);
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void b(Menu menu) {
        if (this.m >= 1) {
            for (int i2 = 0; i2 < this.f2180f.size(); i2++) {
                Fragment fragment = this.f2180f.get(i2);
                if (fragment != null) {
                    fragment.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    public void u(Fragment fragment) {
        if (fragment == null || (this.f2181g.get(fragment.mWho) == fragment && (fragment.mHost == null || fragment.getFragmentManager() == this))) {
            Fragment fragment2 = this.q;
            this.q = fragment;
            w(fragment2);
            w(this.q);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    private void w(Fragment fragment) {
        if (fragment != null && this.f2181g.get(fragment.mWho) == fragment) {
            fragment.performPrimaryNavigationFragmentChanged();
        }
    }

    /* access modifiers changed from: package-private */
    public void z() {
        D();
        w(this.q);
    }

    public Fragment A() {
        return this.q;
    }

    public void a(Fragment fragment, e.b bVar) {
        if (this.f2181g.get(fragment.mWho) == fragment && (fragment.mHost == null || fragment.getFragmentManager() == this)) {
            fragment.mMaxState = bVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public f e() {
        if (super.e() == f2174a) {
            Fragment fragment = this.p;
            if (fragment != null) {
                return fragment.mFragmentManager.e();
            }
            a((f) new f() {
                public Fragment c(ClassLoader classLoader, String str) {
                    return i.this.n.a(i.this.n.i(), str, (Bundle) null);
                }
            });
        }
        return super.e();
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment, Context context, boolean z2) {
        Fragment fragment2 = this.p;
        if (fragment2 != null) {
            h fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof i) {
                ((i) fragmentManager).a(fragment, context, true);
            }
        }
        Iterator<c> it = this.H.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!z2 || next.f2205b) {
                next.f2204a.a((h) this, fragment, context);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Fragment fragment, Context context, boolean z2) {
        Fragment fragment2 = this.p;
        if (fragment2 != null) {
            h fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof i) {
                ((i) fragmentManager).b(fragment, context, true);
            }
        }
        Iterator<c> it = this.H.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!z2 || next.f2205b) {
                next.f2204a.b((h) this, fragment, context);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment fragment2 = this.p;
        if (fragment2 != null) {
            h fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof i) {
                ((i) fragmentManager).a(fragment, bundle, true);
            }
        }
        Iterator<c> it = this.H.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!z2 || next.f2205b) {
                next.f2204a.a((h) this, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment fragment2 = this.p;
        if (fragment2 != null) {
            h fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof i) {
                ((i) fragmentManager).b(fragment, bundle, true);
            }
        }
        Iterator<c> it = this.H.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!z2 || next.f2205b) {
                next.f2204a.b((h) this, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment fragment2 = this.p;
        if (fragment2 != null) {
            h fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof i) {
                ((i) fragmentManager).c(fragment, bundle, true);
            }
        }
        Iterator<c> it = this.H.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!z2 || next.f2205b) {
                next.f2204a.c(this, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment, View view, Bundle bundle, boolean z2) {
        Fragment fragment2 = this.p;
        if (fragment2 != null) {
            h fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof i) {
                ((i) fragmentManager).a(fragment, view, bundle, true);
            }
        }
        Iterator<c> it = this.H.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!z2 || next.f2205b) {
                next.f2204a.a(this, fragment, view, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Fragment fragment, boolean z2) {
        Fragment fragment2 = this.p;
        if (fragment2 != null) {
            h fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof i) {
                ((i) fragmentManager).b(fragment, true);
            }
        }
        Iterator<c> it = this.H.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!z2 || next.f2205b) {
                next.f2204a.a(this, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(Fragment fragment, boolean z2) {
        Fragment fragment2 = this.p;
        if (fragment2 != null) {
            h fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof i) {
                ((i) fragmentManager).c(fragment, true);
            }
        }
        Iterator<c> it = this.H.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!z2 || next.f2205b) {
                next.f2204a.b(this, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(Fragment fragment, boolean z2) {
        Fragment fragment2 = this.p;
        if (fragment2 != null) {
            h fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof i) {
                ((i) fragmentManager).d(fragment, true);
            }
        }
        Iterator<c> it = this.H.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!z2 || next.f2205b) {
                next.f2204a.c(this, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e(Fragment fragment, boolean z2) {
        Fragment fragment2 = this.p;
        if (fragment2 != null) {
            h fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof i) {
                ((i) fragmentManager).e(fragment, true);
            }
        }
        Iterator<c> it = this.H.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!z2 || next.f2205b) {
                next.f2204a.d(this, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment fragment2 = this.p;
        if (fragment2 != null) {
            h fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof i) {
                ((i) fragmentManager).d(fragment, bundle, true);
            }
        }
        Iterator<c> it = this.H.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!z2 || next.f2205b) {
                next.f2204a.d(this, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f(Fragment fragment, boolean z2) {
        Fragment fragment2 = this.p;
        if (fragment2 != null) {
            h fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof i) {
                ((i) fragmentManager).f(fragment, true);
            }
        }
        Iterator<c> it = this.H.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!z2 || next.f2205b) {
                next.f2204a.e(this, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void g(Fragment fragment, boolean z2) {
        Fragment fragment2 = this.p;
        if (fragment2 != null) {
            h fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof i) {
                ((i) fragmentManager).g(fragment, true);
            }
        }
        Iterator<c> it = this.H.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!z2 || next.f2205b) {
                next.f2204a.f(this, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void h(Fragment fragment, boolean z2) {
        Fragment fragment2 = this.p;
        if (fragment2 != null) {
            h fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof i) {
                ((i) fragmentManager).h(fragment, true);
            }
        }
        Iterator<c> it = this.H.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!z2 || next.f2205b) {
                next.f2204a.g(this, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean B() {
        boolean z2 = false;
        for (Fragment next : this.f2181g.values()) {
            if (next != null) {
                z2 = x(next);
                continue;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    private boolean x(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.B();
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        Fragment fragment;
        AttributeSet attributeSet2 = attributeSet;
        String str2 = str;
        Fragment fragment2 = null;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet2.getAttributeValue((String) null, "class");
        Context context2 = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet2, d.f2206a);
        int i2 = 0;
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        String str3 = attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (str3 == null || !f.a(context.getClassLoader(), str3)) {
            return null;
        }
        if (view != null) {
            i2 = view.getId();
        }
        if (i2 == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str3);
        }
        if (resourceId != -1) {
            fragment2 = a(resourceId);
        }
        if (fragment2 == null && string != null) {
            fragment2 = a(string);
        }
        if (fragment2 == null && i2 != -1) {
            fragment2 = a(i2);
        }
        if (f2176b) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str3 + " existing=" + fragment2);
        }
        if (fragment2 == null) {
            Fragment c2 = e().c(context.getClassLoader(), str3);
            c2.mFromLayout = true;
            c2.mFragmentId = resourceId != 0 ? resourceId : i2;
            c2.mContainerId = i2;
            c2.mTag = string;
            c2.mInLayout = true;
            c2.mFragmentManager = this;
            g gVar = this.n;
            c2.mHost = gVar;
            c2.onInflate(gVar.i(), attributeSet2, c2.mSavedFragmentState);
            a(c2, true);
            fragment = c2;
        } else if (!fragment2.mInLayout) {
            fragment2.mInLayout = true;
            g gVar2 = this.n;
            fragment2.mHost = gVar2;
            fragment2.onInflate(gVar2.i(), attributeSet2, fragment2.mSavedFragmentState);
            fragment = fragment2;
        } else {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(i2) + " with another fragment for " + str3);
        }
        if (this.m >= 1 || !fragment.mFromLayout) {
            h(fragment);
        } else {
            a(fragment, 1, 0, 0, false);
        }
        if (fragment.mView != null) {
            if (resourceId != 0) {
                fragment.mView.setId(resourceId);
            }
            if (fragment.mView.getTag() == null) {
                fragment.mView.setTag(string);
            }
            return fragment.mView;
        }
        throw new IllegalStateException("Fragment " + str3 + " did not create a view.");
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    private class f implements e {

        /* renamed from: a  reason: collision with root package name */
        final String f2207a;

        /* renamed from: b  reason: collision with root package name */
        final int f2208b;

        /* renamed from: c  reason: collision with root package name */
        final int f2209c;

        f(String str, int i, int i2) {
            this.f2207a = str;
            this.f2208b = i;
            this.f2209c = i2;
        }

        public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
            if (i.this.q != null && this.f2208b < 0 && this.f2207a == null && i.this.q.getChildFragmentManager().c()) {
                return false;
            }
            return i.this.a(arrayList, arrayList2, this.f2207a, this.f2208b, this.f2209c);
        }
    }

    static class g implements Fragment.c {

        /* renamed from: a  reason: collision with root package name */
        final boolean f2211a;

        /* renamed from: b  reason: collision with root package name */
        final a f2212b;

        /* renamed from: c  reason: collision with root package name */
        private int f2213c;

        g(a aVar, boolean z) {
            this.f2211a = z;
            this.f2212b = aVar;
        }

        public void a() {
            this.f2213c--;
            if (this.f2213c == 0) {
                this.f2212b.f2162a.k();
            }
        }

        public void b() {
            this.f2213c++;
        }

        public boolean c() {
            return this.f2213c == 0;
        }

        public void d() {
            boolean z = this.f2213c > 0;
            i iVar = this.f2212b.f2162a;
            int size = iVar.f2180f.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = iVar.f2180f.get(i);
                fragment.setOnStartEnterTransitionListener((Fragment.c) null);
                if (z && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            this.f2212b.f2162a.a(this.f2212b, this.f2211a, !z, true);
        }

        public void e() {
            this.f2212b.f2162a.a(this.f2212b, this.f2211a, false, false);
        }
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Animation f2197a;

        /* renamed from: b  reason: collision with root package name */
        public final Animator f2198b;

        a(Animation animation) {
            this.f2197a = animation;
            this.f2198b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        a(Animator animator) {
            this.f2197a = null;
            this.f2198b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    private static class b extends AnimationSet implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f2199a;

        /* renamed from: b  reason: collision with root package name */
        private final View f2200b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f2201c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f2202d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f2203e = true;

        b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f2199a = viewGroup;
            this.f2200b = view;
            addAnimation(animation);
            this.f2199a.post(this);
        }

        public boolean getTransformation(long j, Transformation transformation) {
            this.f2203e = true;
            if (this.f2201c) {
                return !this.f2202d;
            }
            if (!super.getTransformation(j, transformation)) {
                this.f2201c = true;
                androidx.core.g.s.a(this.f2199a, this);
            }
            return true;
        }

        public boolean getTransformation(long j, Transformation transformation, float f2) {
            this.f2203e = true;
            if (this.f2201c) {
                return !this.f2202d;
            }
            if (!super.getTransformation(j, transformation, f2)) {
                this.f2201c = true;
                androidx.core.g.s.a(this.f2199a, this);
            }
            return true;
        }

        public void run() {
            if (this.f2201c || !this.f2203e) {
                this.f2199a.endViewTransition(this.f2200b);
                this.f2202d = true;
                return;
            }
            this.f2203e = false;
            this.f2199a.post(this);
        }
    }
}
