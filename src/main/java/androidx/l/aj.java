package androidx.l;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.l.a;
import androidx.l.n;

public abstract class aj extends n {
    private static final String[] h = {"android:visibility:visibility", "android:visibility:parent"};
    private int i = 3;

    public Animator a(ViewGroup viewGroup, View view, t tVar, t tVar2) {
        return null;
    }

    public Animator b(ViewGroup viewGroup, View view, t tVar, t tVar2) {
        return null;
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        boolean f2443a;

        /* renamed from: b  reason: collision with root package name */
        boolean f2444b;

        /* renamed from: c  reason: collision with root package name */
        int f2445c;

        /* renamed from: d  reason: collision with root package name */
        int f2446d;

        /* renamed from: e  reason: collision with root package name */
        ViewGroup f2447e;

        /* renamed from: f  reason: collision with root package name */
        ViewGroup f2448f;

        b() {
        }
    }

    public void a(int i2) {
        if ((i2 & -4) == 0) {
            this.i = i2;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    public String[] a() {
        return h;
    }

    private void d(t tVar) {
        tVar.f2533a.put("android:visibility:visibility", Integer.valueOf(tVar.f2534b.getVisibility()));
        tVar.f2533a.put("android:visibility:parent", tVar.f2534b.getParent());
        int[] iArr = new int[2];
        tVar.f2534b.getLocationOnScreen(iArr);
        tVar.f2533a.put("android:visibility:screenLocation", iArr);
    }

    public void a(t tVar) {
        d(tVar);
    }

    public void b(t tVar) {
        d(tVar);
    }

    private b b(t tVar, t tVar2) {
        b bVar = new b();
        bVar.f2443a = false;
        bVar.f2444b = false;
        if (tVar == null || !tVar.f2533a.containsKey("android:visibility:visibility")) {
            bVar.f2445c = -1;
            bVar.f2447e = null;
        } else {
            bVar.f2445c = ((Integer) tVar.f2533a.get("android:visibility:visibility")).intValue();
            bVar.f2447e = (ViewGroup) tVar.f2533a.get("android:visibility:parent");
        }
        if (tVar2 == null || !tVar2.f2533a.containsKey("android:visibility:visibility")) {
            bVar.f2446d = -1;
            bVar.f2448f = null;
        } else {
            bVar.f2446d = ((Integer) tVar2.f2533a.get("android:visibility:visibility")).intValue();
            bVar.f2448f = (ViewGroup) tVar2.f2533a.get("android:visibility:parent");
        }
        if (tVar == null || tVar2 == null) {
            if (tVar == null && bVar.f2446d == 0) {
                bVar.f2444b = true;
                bVar.f2443a = true;
            } else if (tVar2 == null && bVar.f2445c == 0) {
                bVar.f2444b = false;
                bVar.f2443a = true;
            }
        } else if (bVar.f2445c == bVar.f2446d && bVar.f2447e == bVar.f2448f) {
            return bVar;
        } else {
            if (bVar.f2445c != bVar.f2446d) {
                if (bVar.f2445c == 0) {
                    bVar.f2444b = false;
                    bVar.f2443a = true;
                } else if (bVar.f2446d == 0) {
                    bVar.f2444b = true;
                    bVar.f2443a = true;
                }
            } else if (bVar.f2448f == null) {
                bVar.f2444b = false;
                bVar.f2443a = true;
            } else if (bVar.f2447e == null) {
                bVar.f2444b = true;
                bVar.f2443a = true;
            }
        }
        return bVar;
    }

    public Animator a(ViewGroup viewGroup, t tVar, t tVar2) {
        b b2 = b(tVar, tVar2);
        if (!b2.f2443a) {
            return null;
        }
        if (b2.f2447e == null && b2.f2448f == null) {
            return null;
        }
        if (b2.f2444b) {
            return a(viewGroup, tVar, b2.f2445c, tVar2, b2.f2446d);
        }
        return b(viewGroup, tVar, b2.f2445c, tVar2, b2.f2446d);
    }

    public Animator a(ViewGroup viewGroup, t tVar, int i2, t tVar2, int i3) {
        if ((this.i & 1) != 1 || tVar2 == null) {
            return null;
        }
        if (tVar == null) {
            View view = (View) tVar2.f2534b.getParent();
            if (b(b(view, false), a(view, false)).f2443a) {
                return null;
            }
        }
        return a(viewGroup, tVar2.f2534b, tVar, tVar2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007d, code lost:
        if (r6.f2509e != false) goto L_0x003a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0087 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00f0 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator b(android.view.ViewGroup r7, androidx.l.t r8, int r9, androidx.l.t r10, int r11) {
        /*
            r6 = this;
            int r9 = r6.i
            r0 = 2
            r9 = r9 & r0
            r1 = 0
            if (r9 == r0) goto L_0x0008
            return r1
        L_0x0008:
            if (r8 == 0) goto L_0x000d
            android.view.View r9 = r8.f2534b
            goto L_0x000e
        L_0x000d:
            r9 = r1
        L_0x000e:
            if (r10 == 0) goto L_0x0013
            android.view.View r2 = r10.f2534b
            goto L_0x0014
        L_0x0013:
            r2 = r1
        L_0x0014:
            r3 = 1
            if (r2 == 0) goto L_0x0037
            android.view.ViewParent r4 = r2.getParent()
            if (r4 != 0) goto L_0x001e
            goto L_0x0037
        L_0x001e:
            r4 = 4
            if (r11 != r4) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            if (r9 != r2) goto L_0x0027
        L_0x0024:
            r9 = r1
            goto L_0x0084
        L_0x0027:
            boolean r2 = r6.f2509e
            if (r2 == 0) goto L_0x002c
            goto L_0x0044
        L_0x002c:
            android.view.ViewParent r2 = r9.getParent()
            android.view.View r2 = (android.view.View) r2
            android.view.View r9 = androidx.l.s.a(r7, r9, r2)
            goto L_0x003a
        L_0x0037:
            if (r2 == 0) goto L_0x003c
            r9 = r2
        L_0x003a:
            r2 = r1
            goto L_0x0084
        L_0x003c:
            if (r9 == 0) goto L_0x0082
            android.view.ViewParent r2 = r9.getParent()
            if (r2 != 0) goto L_0x0045
        L_0x0044:
            goto L_0x003a
        L_0x0045:
            android.view.ViewParent r2 = r9.getParent()
            boolean r2 = r2 instanceof android.view.View
            if (r2 == 0) goto L_0x0082
            android.view.ViewParent r2 = r9.getParent()
            android.view.View r2 = (android.view.View) r2
            androidx.l.t r4 = r6.a((android.view.View) r2, (boolean) r3)
            androidx.l.t r5 = r6.b((android.view.View) r2, (boolean) r3)
            androidx.l.aj$b r4 = r6.b(r4, r5)
            boolean r4 = r4.f2443a
            if (r4 != 0) goto L_0x0068
            android.view.View r9 = androidx.l.s.a(r7, r9, r2)
            goto L_0x003a
        L_0x0068:
            android.view.ViewParent r4 = r2.getParent()
            if (r4 != 0) goto L_0x0080
            int r2 = r2.getId()
            r4 = -1
            if (r2 == r4) goto L_0x0080
            android.view.View r2 = r7.findViewById(r2)
            if (r2 == 0) goto L_0x0080
            boolean r2 = r6.f2509e
            if (r2 == 0) goto L_0x0080
            goto L_0x003a
        L_0x0080:
            r9 = r1
            goto L_0x003a
        L_0x0082:
            r9 = r1
            r2 = r9
        L_0x0084:
            r4 = 0
            if (r9 == 0) goto L_0x00ce
            if (r8 == 0) goto L_0x00ce
            java.util.Map<java.lang.String, java.lang.Object> r11 = r8.f2533a
            java.lang.String r1 = "android:visibility:screenLocation"
            java.lang.Object r11 = r11.get(r1)
            int[] r11 = (int[]) r11
            int[] r11 = (int[]) r11
            r1 = r11[r4]
            r11 = r11[r3]
            int[] r0 = new int[r0]
            r7.getLocationOnScreen(r0)
            r2 = r0[r4]
            int r1 = r1 - r2
            int r2 = r9.getLeft()
            int r1 = r1 - r2
            r9.offsetLeftAndRight(r1)
            r0 = r0[r3]
            int r11 = r11 - r0
            int r0 = r9.getTop()
            int r11 = r11 - r0
            r9.offsetTopAndBottom(r11)
            androidx.l.x r11 = androidx.l.y.a(r7)
            r11.a(r9)
            android.animation.Animator r7 = r6.b(r7, r9, r8, r10)
            if (r7 != 0) goto L_0x00c5
            r11.b(r9)
            goto L_0x00cd
        L_0x00c5:
            androidx.l.aj$1 r8 = new androidx.l.aj$1
            r8.<init>(r11, r9)
            r7.addListener(r8)
        L_0x00cd:
            return r7
        L_0x00ce:
            if (r2 == 0) goto L_0x00f0
            int r9 = r2.getVisibility()
            androidx.l.ae.a((android.view.View) r2, (int) r4)
            android.animation.Animator r7 = r6.b(r7, r2, r8, r10)
            if (r7 == 0) goto L_0x00ec
            androidx.l.aj$a r8 = new androidx.l.aj$a
            r8.<init>(r2, r11, r3)
            r7.addListener(r8)
            androidx.l.a.a(r7, r8)
            r6.a((androidx.l.n.c) r8)
            goto L_0x00ef
        L_0x00ec:
            androidx.l.ae.a((android.view.View) r2, (int) r9)
        L_0x00ef:
            return r7
        L_0x00f0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.l.aj.b(android.view.ViewGroup, androidx.l.t, int, androidx.l.t, int):android.animation.Animator");
    }

    public boolean a(t tVar, t tVar2) {
        if (tVar == null && tVar2 == null) {
            return false;
        }
        if (tVar != null && tVar2 != null && tVar2.f2533a.containsKey("android:visibility:visibility") != tVar.f2533a.containsKey("android:visibility:visibility")) {
            return false;
        }
        b b2 = b(tVar, tVar2);
        if (!b2.f2443a) {
            return false;
        }
        if (b2.f2445c == 0 || b2.f2446d == 0) {
            return true;
        }
        return false;
    }

    private static class a extends AnimatorListenerAdapter implements a.C0059a, n.c {

        /* renamed from: a  reason: collision with root package name */
        boolean f2437a = false;

        /* renamed from: b  reason: collision with root package name */
        private final View f2438b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2439c;

        /* renamed from: d  reason: collision with root package name */
        private final ViewGroup f2440d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f2441e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f2442f;

        public void d(n nVar) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        a(View view, int i, boolean z) {
            this.f2438b = view;
            this.f2439c = i;
            this.f2440d = (ViewGroup) view.getParent();
            this.f2441e = z;
            a(true);
        }

        public void onAnimationPause(Animator animator) {
            if (!this.f2437a) {
                ae.a(this.f2438b, this.f2439c);
            }
        }

        public void onAnimationResume(Animator animator) {
            if (!this.f2437a) {
                ae.a(this.f2438b, 0);
            }
        }

        public void onAnimationCancel(Animator animator) {
            this.f2437a = true;
        }

        public void onAnimationEnd(Animator animator) {
            a();
        }

        public void a(n nVar) {
            a();
            nVar.b((n.c) this);
        }

        public void b(n nVar) {
            a(false);
        }

        public void c(n nVar) {
            a(true);
        }

        private void a() {
            if (!this.f2437a) {
                ae.a(this.f2438b, this.f2439c);
                ViewGroup viewGroup = this.f2440d;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            a(false);
        }

        private void a(boolean z) {
            if (this.f2441e && this.f2442f != z) {
                ViewGroup viewGroup = this.f2440d;
                if (viewGroup != null) {
                    this.f2442f = z;
                    y.a(viewGroup, z);
                }
            }
        }
    }
}
