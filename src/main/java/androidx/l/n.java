package androidx.l;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.b.d;
import androidx.b.g;
import androidx.core.g.w;
import com.facebook.common.time.Clock;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class n implements Cloneable {
    private static ThreadLocal<androidx.b.a<Animator, a>> A = new ThreadLocal<>();
    private static final int[] h = {2, 1, 3, 4};
    private static final h i = new h() {
        public Path a(float f2, float f3, float f4, float f5) {
            Path path = new Path();
            path.moveTo(f2, f3);
            path.lineTo(f4, f5);
            return path;
        }
    };
    private ViewGroup B = null;
    private int C = 0;
    private boolean D = false;
    private boolean E = false;
    private ArrayList<c> F = null;
    private ArrayList<Animator> G = new ArrayList<>();
    private b H;
    private androidx.b.a<String, String> I;
    private h J = i;

    /* renamed from: a  reason: collision with root package name */
    long f2505a = -1;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<Integer> f2506b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    ArrayList<View> f2507c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    r f2508d = null;

    /* renamed from: e  reason: collision with root package name */
    boolean f2509e = false;

    /* renamed from: f  reason: collision with root package name */
    ArrayList<Animator> f2510f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    q f2511g;
    private String j = getClass().getName();
    private long k = -1;
    private TimeInterpolator l = null;
    private ArrayList<String> m = null;
    private ArrayList<Class> n = null;
    private ArrayList<Integer> o = null;
    private ArrayList<View> p = null;
    private ArrayList<Class> q = null;
    private ArrayList<String> r = null;
    private ArrayList<Integer> s = null;
    private ArrayList<View> t = null;
    private ArrayList<Class> u = null;
    private u v = new u();
    private u w = new u();
    private int[] x = h;
    private ArrayList<t> y;
    private ArrayList<t> z;

    public static abstract class b {
    }

    public interface c {
        void a(n nVar);

        void b(n nVar);

        void c(n nVar);

        void d(n nVar);
    }

    public Animator a(ViewGroup viewGroup, t tVar, t tVar2) {
        return null;
    }

    public abstract void a(t tVar);

    public String[] a() {
        return null;
    }

    public abstract void b(t tVar);

    public n a(long j2) {
        this.f2505a = j2;
        return this;
    }

    public long b() {
        return this.f2505a;
    }

    public n b(long j2) {
        this.k = j2;
        return this;
    }

    public long c() {
        return this.k;
    }

    public n a(TimeInterpolator timeInterpolator) {
        this.l = timeInterpolator;
        return this;
    }

    public TimeInterpolator d() {
        return this.l;
    }

    private void a(androidx.b.a<View, t> aVar, androidx.b.a<View, t> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View b2 = aVar.b(size);
            if (b2 != null && a(b2)) {
                t remove = aVar2.remove(b2);
                if (!(remove == null || remove.f2534b == null || !a(remove.f2534b))) {
                    this.y.add(aVar.d(size));
                    this.z.add(remove);
                }
            }
        }
    }

    private void a(androidx.b.a<View, t> aVar, androidx.b.a<View, t> aVar2, d<View> dVar, d<View> dVar2) {
        int b2 = dVar.b();
        for (int i2 = 0; i2 < b2; i2++) {
            View c2 = dVar.c(i2);
            if (c2 != null && a(c2)) {
                View a2 = dVar2.a(dVar.b(i2));
                if (a2 != null && a(a2)) {
                    t tVar = aVar.get(c2);
                    t tVar2 = aVar2.get(a2);
                    if (!(tVar == null || tVar2 == null)) {
                        this.y.add(tVar);
                        this.z.add(tVar2);
                        aVar.remove(c2);
                        aVar2.remove(a2);
                    }
                }
            }
        }
    }

    private void a(androidx.b.a<View, t> aVar, androidx.b.a<View, t> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            View valueAt = sparseArray.valueAt(i2);
            if (valueAt != null && a(valueAt)) {
                View view = sparseArray2.get(sparseArray.keyAt(i2));
                if (view != null && a(view)) {
                    t tVar = aVar.get(valueAt);
                    t tVar2 = aVar2.get(view);
                    if (!(tVar == null || tVar2 == null)) {
                        this.y.add(tVar);
                        this.z.add(tVar2);
                        aVar.remove(valueAt);
                        aVar2.remove(view);
                    }
                }
            }
        }
    }

    private void a(androidx.b.a<View, t> aVar, androidx.b.a<View, t> aVar2, androidx.b.a<String, View> aVar3, androidx.b.a<String, View> aVar4) {
        int size = aVar3.size();
        for (int i2 = 0; i2 < size; i2++) {
            View c2 = aVar3.c(i2);
            if (c2 != null && a(c2)) {
                View view = aVar4.get(aVar3.b(i2));
                if (view != null && a(view)) {
                    t tVar = aVar.get(c2);
                    t tVar2 = aVar2.get(view);
                    if (!(tVar == null || tVar2 == null)) {
                        this.y.add(tVar);
                        this.z.add(tVar2);
                        aVar.remove(c2);
                        aVar2.remove(view);
                    }
                }
            }
        }
    }

    private void b(androidx.b.a<View, t> aVar, androidx.b.a<View, t> aVar2) {
        for (int i2 = 0; i2 < aVar.size(); i2++) {
            t c2 = aVar.c(i2);
            if (a(c2.f2534b)) {
                this.y.add(c2);
                this.z.add((Object) null);
            }
        }
        for (int i3 = 0; i3 < aVar2.size(); i3++) {
            t c3 = aVar2.c(i3);
            if (a(c3.f2534b)) {
                this.z.add(c3);
                this.y.add((Object) null);
            }
        }
    }

    private void a(u uVar, u uVar2) {
        androidx.b.a aVar = new androidx.b.a((g) uVar.f2536a);
        androidx.b.a aVar2 = new androidx.b.a((g) uVar2.f2536a);
        int i2 = 0;
        while (true) {
            int[] iArr = this.x;
            if (i2 < iArr.length) {
                int i3 = iArr[i2];
                if (i3 == 1) {
                    a((androidx.b.a<View, t>) aVar, (androidx.b.a<View, t>) aVar2);
                } else if (i3 == 2) {
                    a((androidx.b.a<View, t>) aVar, (androidx.b.a<View, t>) aVar2, uVar.f2539d, uVar2.f2539d);
                } else if (i3 == 3) {
                    a((androidx.b.a<View, t>) aVar, (androidx.b.a<View, t>) aVar2, uVar.f2537b, uVar2.f2537b);
                } else if (i3 == 4) {
                    a((androidx.b.a<View, t>) aVar, (androidx.b.a<View, t>) aVar2, uVar.f2538c, uVar2.f2538c);
                }
                i2++;
            } else {
                b((androidx.b.a<View, t>) aVar, (androidx.b.a<View, t>) aVar2);
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(ViewGroup viewGroup, u uVar, u uVar2, ArrayList<t> arrayList, ArrayList<t> arrayList2) {
        int i2;
        int i3;
        View view;
        Animator animator;
        t tVar;
        t tVar2;
        Animator animator2;
        ViewGroup viewGroup2 = viewGroup;
        androidx.b.a<Animator, a> q2 = q();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j2 = Clock.MAX_TIME;
        int i4 = 0;
        while (i4 < size) {
            t tVar3 = arrayList.get(i4);
            t tVar4 = arrayList2.get(i4);
            if (tVar3 != null && !tVar3.f2535c.contains(this)) {
                tVar3 = null;
            }
            if (tVar4 != null && !tVar4.f2535c.contains(this)) {
                tVar4 = null;
            }
            if (!(tVar3 == null && tVar4 == null)) {
                if (tVar3 == null || tVar4 == null || a(tVar3, tVar4)) {
                    Animator a2 = a(viewGroup2, tVar3, tVar4);
                    if (a2 != null) {
                        if (tVar4 != null) {
                            view = tVar4.f2534b;
                            String[] a3 = a();
                            if (view != null && a3 != null && a3.length > 0) {
                                tVar2 = new t();
                                tVar2.f2534b = view;
                                Animator animator3 = a2;
                                i3 = size;
                                t tVar5 = uVar2.f2536a.get(view);
                                if (tVar5 != null) {
                                    int i5 = 0;
                                    while (i5 < a3.length) {
                                        tVar2.f2533a.put(a3[i5], tVar5.f2533a.get(a3[i5]));
                                        i5++;
                                        ArrayList<t> arrayList3 = arrayList2;
                                        i4 = i4;
                                        tVar5 = tVar5;
                                    }
                                }
                                i2 = i4;
                                int size2 = q2.size();
                                int i6 = 0;
                                while (true) {
                                    if (i6 >= size2) {
                                        animator2 = animator3;
                                        break;
                                    }
                                    a aVar = q2.get(q2.b(i6));
                                    if (aVar.f2517c != null && aVar.f2515a == view && aVar.f2516b.equals(p()) && aVar.f2517c.equals(tVar2)) {
                                        animator2 = null;
                                        break;
                                    }
                                    i6++;
                                }
                            } else {
                                i3 = size;
                                i2 = i4;
                                animator2 = a2;
                                tVar2 = null;
                            }
                            animator = animator2;
                            tVar = tVar2;
                        } else {
                            i3 = size;
                            i2 = i4;
                            view = tVar3.f2534b;
                            animator = a2;
                            tVar = null;
                        }
                        if (animator != null) {
                            q qVar = this.f2511g;
                            if (qVar != null) {
                                long a4 = qVar.a(viewGroup2, this, tVar3, tVar4);
                                sparseIntArray.put(this.G.size(), (int) a4);
                                j2 = Math.min(a4, j2);
                            }
                            q2.put(animator, new a(view, p(), this, ae.b(viewGroup), tVar));
                            this.G.add(animator);
                            j2 = j2;
                        }
                        i4 = i2 + 1;
                        size = i3;
                    }
                }
            }
            i3 = size;
            i2 = i4;
            i4 = i2 + 1;
            size = i3;
        }
        if (j2 != 0) {
            for (int i7 = 0; i7 < sparseIntArray.size(); i7++) {
                Animator animator4 = this.G.get(sparseIntArray.keyAt(i7));
                animator4.setStartDelay((((long) sparseIntArray.valueAt(i7)) - j2) + animator4.getStartDelay());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(View view) {
        int id = view.getId();
        ArrayList<Integer> arrayList = this.o;
        if (arrayList != null && arrayList.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList2 = this.p;
        if (arrayList2 != null && arrayList2.contains(view)) {
            return false;
        }
        ArrayList<Class> arrayList3 = this.q;
        if (arrayList3 != null) {
            int size = arrayList3.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.q.get(i2).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.r != null && w.q(view) != null && this.r.contains(w.q(view))) {
            return false;
        }
        if (this.f2506b.size() == 0 && this.f2507c.size() == 0) {
            ArrayList<Class> arrayList4 = this.n;
            if (arrayList4 == null || arrayList4.isEmpty()) {
                ArrayList<String> arrayList5 = this.m;
                if (arrayList5 == null || arrayList5.isEmpty()) {
                    return true;
                }
            }
        }
        if (this.f2506b.contains(Integer.valueOf(id)) || this.f2507c.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.m;
        if (arrayList6 != null && arrayList6.contains(w.q(view))) {
            return true;
        }
        if (this.n != null) {
            for (int i3 = 0; i3 < this.n.size(); i3++) {
                if (this.n.get(i3).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static androidx.b.a<Animator, a> q() {
        androidx.b.a<Animator, a> aVar = A.get();
        if (aVar != null) {
            return aVar;
        }
        androidx.b.a<Animator, a> aVar2 = new androidx.b.a<>();
        A.set(aVar2);
        return aVar2;
    }

    /* access modifiers changed from: protected */
    public void e() {
        j();
        androidx.b.a<Animator, a> q2 = q();
        Iterator<Animator> it = this.G.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (q2.containsKey(next)) {
                j();
                a(next, q2);
            }
        }
        this.G.clear();
        k();
    }

    private void a(Animator animator, final androidx.b.a<Animator, a> aVar) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    n.this.f2510f.add(animator);
                }

                public void onAnimationEnd(Animator animator) {
                    aVar.remove(animator);
                    n.this.f2510f.remove(animator);
                }
            });
            a(animator);
        }
    }

    public n b(View view) {
        this.f2507c.add(view);
        return this;
    }

    public n c(View view) {
        this.f2507c.remove(view);
        return this;
    }

    public List<Integer> f() {
        return this.f2506b;
    }

    public List<View> g() {
        return this.f2507c;
    }

    public List<String> h() {
        return this.m;
    }

    public List<Class> i() {
        return this.n;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:61:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.view.ViewGroup r6, boolean r7) {
        /*
            r5 = this;
            r5.a((boolean) r7)
            java.util.ArrayList<java.lang.Integer> r0 = r5.f2506b
            int r0 = r0.size()
            r1 = 0
            if (r0 > 0) goto L_0x0014
            java.util.ArrayList<android.view.View> r0 = r5.f2507c
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0029
        L_0x0014:
            java.util.ArrayList<java.lang.String> r0 = r5.m
            if (r0 == 0) goto L_0x001e
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0029
        L_0x001e:
            java.util.ArrayList<java.lang.Class> r0 = r5.n
            if (r0 == 0) goto L_0x002e
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0029
            goto L_0x002e
        L_0x0029:
            r5.c(r6, r7)
            goto L_0x00aa
        L_0x002e:
            r0 = 0
        L_0x002f:
            java.util.ArrayList<java.lang.Integer> r2 = r5.f2506b
            int r2 = r2.size()
            if (r0 >= r2) goto L_0x0071
            java.util.ArrayList<java.lang.Integer> r2 = r5.f2506b
            java.lang.Object r2 = r2.get(r0)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            android.view.View r2 = r6.findViewById(r2)
            if (r2 == 0) goto L_0x006e
            androidx.l.t r3 = new androidx.l.t
            r3.<init>()
            r3.f2534b = r2
            if (r7 == 0) goto L_0x0056
            r5.a((androidx.l.t) r3)
            goto L_0x0059
        L_0x0056:
            r5.b((androidx.l.t) r3)
        L_0x0059:
            java.util.ArrayList<androidx.l.n> r4 = r3.f2535c
            r4.add(r5)
            r5.c((androidx.l.t) r3)
            if (r7 == 0) goto L_0x0069
            androidx.l.u r4 = r5.v
            a((androidx.l.u) r4, (android.view.View) r2, (androidx.l.t) r3)
            goto L_0x006e
        L_0x0069:
            androidx.l.u r4 = r5.w
            a((androidx.l.u) r4, (android.view.View) r2, (androidx.l.t) r3)
        L_0x006e:
            int r0 = r0 + 1
            goto L_0x002f
        L_0x0071:
            r6 = 0
        L_0x0072:
            java.util.ArrayList<android.view.View> r0 = r5.f2507c
            int r0 = r0.size()
            if (r6 >= r0) goto L_0x00aa
            java.util.ArrayList<android.view.View> r0 = r5.f2507c
            java.lang.Object r0 = r0.get(r6)
            android.view.View r0 = (android.view.View) r0
            androidx.l.t r2 = new androidx.l.t
            r2.<init>()
            r2.f2534b = r0
            if (r7 == 0) goto L_0x008f
            r5.a((androidx.l.t) r2)
            goto L_0x0092
        L_0x008f:
            r5.b((androidx.l.t) r2)
        L_0x0092:
            java.util.ArrayList<androidx.l.n> r3 = r2.f2535c
            r3.add(r5)
            r5.c((androidx.l.t) r2)
            if (r7 == 0) goto L_0x00a2
            androidx.l.u r3 = r5.v
            a((androidx.l.u) r3, (android.view.View) r0, (androidx.l.t) r2)
            goto L_0x00a7
        L_0x00a2:
            androidx.l.u r3 = r5.w
            a((androidx.l.u) r3, (android.view.View) r0, (androidx.l.t) r2)
        L_0x00a7:
            int r6 = r6 + 1
            goto L_0x0072
        L_0x00aa:
            if (r7 != 0) goto L_0x00ee
            androidx.b.a<java.lang.String, java.lang.String> r6 = r5.I
            if (r6 == 0) goto L_0x00ee
            int r6 = r6.size()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>(r6)
            r0 = 0
        L_0x00ba:
            if (r0 >= r6) goto L_0x00d2
            androidx.b.a<java.lang.String, java.lang.String> r2 = r5.I
            java.lang.Object r2 = r2.b((int) r0)
            java.lang.String r2 = (java.lang.String) r2
            androidx.l.u r3 = r5.v
            androidx.b.a<java.lang.String, android.view.View> r3 = r3.f2539d
            java.lang.Object r2 = r3.remove(r2)
            r7.add(r2)
            int r0 = r0 + 1
            goto L_0x00ba
        L_0x00d2:
            if (r1 >= r6) goto L_0x00ee
            java.lang.Object r0 = r7.get(r1)
            android.view.View r0 = (android.view.View) r0
            if (r0 == 0) goto L_0x00eb
            androidx.b.a<java.lang.String, java.lang.String> r2 = r5.I
            java.lang.Object r2 = r2.c(r1)
            java.lang.String r2 = (java.lang.String) r2
            androidx.l.u r3 = r5.v
            androidx.b.a<java.lang.String, android.view.View> r3 = r3.f2539d
            r3.put(r2, r0)
        L_0x00eb:
            int r1 = r1 + 1
            goto L_0x00d2
        L_0x00ee:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.l.n.a(android.view.ViewGroup, boolean):void");
    }

    private static void a(u uVar, View view, t tVar) {
        uVar.f2536a.put(view, tVar);
        int id = view.getId();
        if (id >= 0) {
            if (uVar.f2537b.indexOfKey(id) >= 0) {
                uVar.f2537b.put(id, (Object) null);
            } else {
                uVar.f2537b.put(id, view);
            }
        }
        String q2 = w.q(view);
        if (q2 != null) {
            if (uVar.f2539d.containsKey(q2)) {
                uVar.f2539d.put(q2, null);
            } else {
                uVar.f2539d.put(q2, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (uVar.f2538c.d(itemIdAtPosition) >= 0) {
                    View a2 = uVar.f2538c.a(itemIdAtPosition);
                    if (a2 != null) {
                        w.a(a2, false);
                        uVar.f2538c.b(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                w.a(view, true);
                uVar.f2538c.b(itemIdAtPosition, view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        if (z2) {
            this.v.f2536a.clear();
            this.v.f2537b.clear();
            this.v.f2538c.c();
            return;
        }
        this.w.f2536a.clear();
        this.w.f2537b.clear();
        this.w.f2538c.c();
    }

    private void c(View view, boolean z2) {
        if (view != null) {
            int id = view.getId();
            ArrayList<Integer> arrayList = this.o;
            if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
                ArrayList<View> arrayList2 = this.p;
                if (arrayList2 == null || !arrayList2.contains(view)) {
                    ArrayList<Class> arrayList3 = this.q;
                    if (arrayList3 != null) {
                        int size = arrayList3.size();
                        int i2 = 0;
                        while (i2 < size) {
                            if (!this.q.get(i2).isInstance(view)) {
                                i2++;
                            } else {
                                return;
                            }
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        t tVar = new t();
                        tVar.f2534b = view;
                        if (z2) {
                            a(tVar);
                        } else {
                            b(tVar);
                        }
                        tVar.f2535c.add(this);
                        c(tVar);
                        if (z2) {
                            a(this.v, view, tVar);
                        } else {
                            a(this.w, view, tVar);
                        }
                    }
                    if (view instanceof ViewGroup) {
                        ArrayList<Integer> arrayList4 = this.s;
                        if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                            ArrayList<View> arrayList5 = this.t;
                            if (arrayList5 == null || !arrayList5.contains(view)) {
                                ArrayList<Class> arrayList6 = this.u;
                                if (arrayList6 != null) {
                                    int size2 = arrayList6.size();
                                    int i3 = 0;
                                    while (i3 < size2) {
                                        if (!this.u.get(i3).isInstance(view)) {
                                            i3++;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                ViewGroup viewGroup = (ViewGroup) view;
                                for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                                    c(viewGroup.getChildAt(i4), z2);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public t a(View view, boolean z2) {
        r rVar = this.f2508d;
        if (rVar != null) {
            return rVar.a(view, z2);
        }
        return (z2 ? this.v : this.w).f2536a.get(view);
    }

    /* access modifiers changed from: package-private */
    public t b(View view, boolean z2) {
        r rVar = this.f2508d;
        if (rVar != null) {
            return rVar.b(view, z2);
        }
        ArrayList<t> arrayList = z2 ? this.y : this.z;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            t tVar = arrayList.get(i3);
            if (tVar == null) {
                return null;
            }
            if (tVar.f2534b == view) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 < 0) {
            return null;
        }
        return (z2 ? this.z : this.y).get(i2);
    }

    public void d(View view) {
        if (!this.E) {
            androidx.b.a<Animator, a> q2 = q();
            int size = q2.size();
            am b2 = ae.b(view);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                a c2 = q2.c(i2);
                if (c2.f2515a != null && b2.equals(c2.f2518d)) {
                    a.a(q2.b(i2));
                }
            }
            ArrayList<c> arrayList = this.F;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.F.clone();
                int size2 = arrayList2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    ((c) arrayList2.get(i3)).b(this);
                }
            }
            this.D = true;
        }
    }

    public void e(View view) {
        if (this.D) {
            if (!this.E) {
                androidx.b.a<Animator, a> q2 = q();
                int size = q2.size();
                am b2 = ae.b(view);
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    a c2 = q2.c(i2);
                    if (c2.f2515a != null && b2.equals(c2.f2518d)) {
                        a.b(q2.b(i2));
                    }
                }
                ArrayList<c> arrayList = this.F;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.F.clone();
                    int size2 = arrayList2.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        ((c) arrayList2.get(i3)).c(this);
                    }
                }
            }
            this.D = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ViewGroup viewGroup) {
        this.y = new ArrayList<>();
        this.z = new ArrayList<>();
        a(this.v, this.w);
        androidx.b.a<Animator, a> q2 = q();
        int size = q2.size();
        am b2 = ae.b(viewGroup);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            Animator b3 = q2.b(i2);
            if (b3 != null) {
                a aVar = q2.get(b3);
                if (!(aVar == null || aVar.f2515a == null || !b2.equals(aVar.f2518d))) {
                    t tVar = aVar.f2517c;
                    View view = aVar.f2515a;
                    t a2 = a(view, true);
                    t b4 = b(view, true);
                    if (!(a2 == null && b4 == null) && aVar.f2519e.a(tVar, b4)) {
                        if (b3.isRunning() || b3.isStarted()) {
                            b3.cancel();
                        } else {
                            q2.remove(b3);
                        }
                    }
                }
            }
        }
        a(viewGroup, this.v, this.w, this.y, this.z);
        e();
    }

    public boolean a(t tVar, t tVar2) {
        if (tVar == null || tVar2 == null) {
            return false;
        }
        String[] a2 = a();
        if (a2 != null) {
            int length = a2.length;
            int i2 = 0;
            while (i2 < length) {
                if (!a(tVar, tVar2, a2[i2])) {
                    i2++;
                }
            }
            return false;
        }
        for (String a3 : tVar.f2533a.keySet()) {
            if (a(tVar, tVar2, a3)) {
            }
        }
        return false;
        return true;
    }

    private static boolean a(t tVar, t tVar2, String str) {
        Object obj = tVar.f2533a.get(str);
        Object obj2 = tVar2.f2533a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    /* access modifiers changed from: protected */
    public void a(Animator animator) {
        if (animator == null) {
            k();
            return;
        }
        if (b() >= 0) {
            animator.setDuration(b());
        }
        if (c() >= 0) {
            animator.setStartDelay(c());
        }
        if (d() != null) {
            animator.setInterpolator(d());
        }
        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                n.this.k();
                animator.removeListener(this);
            }
        });
        animator.start();
    }

    /* access modifiers changed from: protected */
    public void j() {
        if (this.C == 0) {
            ArrayList<c> arrayList = this.F;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.F.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((c) arrayList2.get(i2)).d(this);
                }
            }
            this.E = false;
        }
        this.C++;
    }

    /* access modifiers changed from: protected */
    public void k() {
        this.C--;
        if (this.C == 0) {
            ArrayList<c> arrayList = this.F;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.F.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((c) arrayList2.get(i2)).a(this);
                }
            }
            for (int i3 = 0; i3 < this.v.f2538c.b(); i3++) {
                View c2 = this.v.f2538c.c(i3);
                if (c2 != null) {
                    w.a(c2, false);
                }
            }
            for (int i4 = 0; i4 < this.w.f2538c.b(); i4++) {
                View c3 = this.w.f2538c.c(i4);
                if (c3 != null) {
                    w.a(c3, false);
                }
            }
            this.E = true;
        }
    }

    public n a(c cVar) {
        if (this.F == null) {
            this.F = new ArrayList<>();
        }
        this.F.add(cVar);
        return this;
    }

    public n b(c cVar) {
        ArrayList<c> arrayList = this.F;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(cVar);
        if (this.F.size() == 0) {
            this.F = null;
        }
        return this;
    }

    public void a(h hVar) {
        if (hVar == null) {
            this.J = i;
        } else {
            this.J = hVar;
        }
    }

    public h l() {
        return this.J;
    }

    public void a(b bVar) {
        this.H = bVar;
    }

    public b m() {
        return this.H;
    }

    public void a(q qVar) {
        this.f2511g = qVar;
    }

    public q n() {
        return this.f2511g;
    }

    /* access modifiers changed from: package-private */
    public void c(t tVar) {
        if (this.f2511g != null && !tVar.f2533a.isEmpty()) {
            String[] a2 = this.f2511g.a();
            if (a2 != null) {
                boolean z2 = false;
                int i2 = 0;
                while (true) {
                    if (i2 >= a2.length) {
                        z2 = true;
                        break;
                    } else if (!tVar.f2533a.containsKey(a2[i2])) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (!z2) {
                    this.f2511g.a(tVar);
                }
            }
        }
    }

    public String toString() {
        return a("");
    }

    /* renamed from: o */
    public n clone() {
        try {
            n nVar = (n) super.clone();
            nVar.G = new ArrayList<>();
            nVar.v = new u();
            nVar.w = new u();
            nVar.y = null;
            nVar.z = null;
            return nVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public String p() {
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public String a(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f2505a != -1) {
            str2 = str2 + "dur(" + this.f2505a + ") ";
        }
        if (this.k != -1) {
            str2 = str2 + "dly(" + this.k + ") ";
        }
        if (this.l != null) {
            str2 = str2 + "interp(" + this.l + ") ";
        }
        if (this.f2506b.size() <= 0 && this.f2507c.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f2506b.size() > 0) {
            String str4 = str3;
            for (int i2 = 0; i2 < this.f2506b.size(); i2++) {
                if (i2 > 0) {
                    str4 = str4 + ", ";
                }
                str4 = str4 + this.f2506b.get(i2);
            }
            str3 = str4;
        }
        if (this.f2507c.size() > 0) {
            for (int i3 = 0; i3 < this.f2507c.size(); i3++) {
                if (i3 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f2507c.get(i3);
            }
        }
        return str3 + SQLBuilder.PARENTHESES_RIGHT;
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        View f2515a;

        /* renamed from: b  reason: collision with root package name */
        String f2516b;

        /* renamed from: c  reason: collision with root package name */
        t f2517c;

        /* renamed from: d  reason: collision with root package name */
        am f2518d;

        /* renamed from: e  reason: collision with root package name */
        n f2519e;

        a(View view, String str, n nVar, am amVar, t tVar) {
            this.f2515a = view;
            this.f2516b = str;
            this.f2517c = tVar;
            this.f2518d = amVar;
            this.f2519e = nVar;
        }
    }
}
