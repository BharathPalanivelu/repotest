package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import androidx.core.g.w;
import androidx.recyclerview.a;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;

public class i extends RecyclerView.h implements RecyclerView.k {
    private b A;
    private final RecyclerView.m B = new RecyclerView.m() {
        public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
            i.this.p.a(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                i.this.f2928g = motionEvent.getPointerId(0);
                i.this.f2924c = motionEvent.getX();
                i.this.f2925d = motionEvent.getY();
                i.this.c();
                if (i.this.f2923b == null) {
                    c b2 = i.this.b(motionEvent);
                    if (b2 != null) {
                        i.this.f2924c -= b2.l;
                        i.this.f2925d -= b2.m;
                        i.this.a(b2.h, true);
                        if (i.this.f2922a.remove(b2.h.itemView)) {
                            i.this.h.d(i.this.k, b2.h);
                        }
                        i.this.a(b2.h, b2.i);
                        i iVar = i.this;
                        iVar.a(motionEvent, iVar.i, 0);
                    }
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                i iVar2 = i.this;
                iVar2.f2928g = -1;
                iVar2.a((RecyclerView.w) null, 0);
            } else if (i.this.f2928g != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(i.this.f2928g);
                if (findPointerIndex >= 0) {
                    i.this.a(actionMasked, motionEvent, findPointerIndex);
                }
            }
            if (i.this.m != null) {
                i.this.m.addMovement(motionEvent);
            }
            if (i.this.f2923b != null) {
                return true;
            }
            return false;
        }

        public void b(RecyclerView recyclerView, MotionEvent motionEvent) {
            i.this.p.a(motionEvent);
            if (i.this.m != null) {
                i.this.m.addMovement(motionEvent);
            }
            if (i.this.f2928g != -1) {
                int actionMasked = motionEvent.getActionMasked();
                int findPointerIndex = motionEvent.findPointerIndex(i.this.f2928g);
                if (findPointerIndex >= 0) {
                    i.this.a(actionMasked, motionEvent, findPointerIndex);
                }
                RecyclerView.w wVar = i.this.f2923b;
                if (wVar != null) {
                    int i = 0;
                    if (actionMasked != 1) {
                        if (actionMasked != 2) {
                            if (actionMasked != 3) {
                                if (actionMasked == 6) {
                                    int actionIndex = motionEvent.getActionIndex();
                                    if (motionEvent.getPointerId(actionIndex) == i.this.f2928g) {
                                        if (actionIndex == 0) {
                                            i = 1;
                                        }
                                        i.this.f2928g = motionEvent.getPointerId(i);
                                        i iVar = i.this;
                                        iVar.a(motionEvent, iVar.i, actionIndex);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            } else if (i.this.m != null) {
                                i.this.m.clear();
                            }
                        } else if (findPointerIndex >= 0) {
                            i iVar2 = i.this;
                            iVar2.a(motionEvent, iVar2.i, findPointerIndex);
                            i.this.a(wVar);
                            i.this.k.removeCallbacks(i.this.l);
                            i.this.l.run();
                            i.this.k.invalidate();
                            return;
                        } else {
                            return;
                        }
                    }
                    i.this.a((RecyclerView.w) null, 0);
                    i.this.f2928g = -1;
                }
            }
        }

        public void a(boolean z) {
            if (z) {
                i.this.a((RecyclerView.w) null, 0);
            }
        }
    };
    private Rect C;
    private long D;

    /* renamed from: a  reason: collision with root package name */
    final List<View> f2922a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    RecyclerView.w f2923b = null;

    /* renamed from: c  reason: collision with root package name */
    float f2924c;

    /* renamed from: d  reason: collision with root package name */
    float f2925d;

    /* renamed from: e  reason: collision with root package name */
    float f2926e;

    /* renamed from: f  reason: collision with root package name */
    float f2927f;

    /* renamed from: g  reason: collision with root package name */
    int f2928g = -1;
    a h;
    int i;
    List<c> j = new ArrayList();
    RecyclerView k;
    final Runnable l = new Runnable() {
        public void run() {
            if (i.this.f2923b != null && i.this.b()) {
                if (i.this.f2923b != null) {
                    i iVar = i.this;
                    iVar.a(iVar.f2923b);
                }
                i.this.k.removeCallbacks(i.this.l);
                w.a((View) i.this.k, (Runnable) this);
            }
        }
    };
    VelocityTracker m;
    View n = null;
    int o = -1;
    androidx.core.g.c p;
    private final float[] q = new float[2];
    private float r;
    private float s;
    private float t;
    private float u;
    private int v = 0;
    private int w;
    private List<RecyclerView.w> x;
    private List<Integer> y;
    private RecyclerView.d z = null;

    public interface d {
        void a(View view, View view2, int i, int i2);
    }

    public void a(View view) {
    }

    public i(a aVar) {
        this.h = aVar;
    }

    private static boolean a(View view, float f2, float f3, float f4, float f5) {
        return f2 >= f4 && f2 <= f4 + ((float) view.getWidth()) && f3 >= f5 && f3 <= f5 + ((float) view.getHeight());
    }

    public void a(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.k;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                e();
            }
            this.k = recyclerView;
            if (recyclerView != null) {
                Resources resources = recyclerView.getResources();
                this.r = resources.getDimension(a.C0061a.item_touch_helper_swipe_escape_velocity);
                this.s = resources.getDimension(a.C0061a.item_touch_helper_swipe_escape_max_velocity);
                d();
            }
        }
    }

    private void d() {
        this.w = ViewConfiguration.get(this.k.getContext()).getScaledTouchSlop();
        this.k.a((RecyclerView.h) this);
        this.k.a(this.B);
        this.k.a((RecyclerView.k) this);
        f();
    }

    private void e() {
        this.k.b((RecyclerView.h) this);
        this.k.b(this.B);
        this.k.b((RecyclerView.k) this);
        for (int size = this.j.size() - 1; size >= 0; size--) {
            this.h.d(this.k, this.j.get(0).h);
        }
        this.j.clear();
        this.n = null;
        this.o = -1;
        h();
        g();
    }

    private void f() {
        this.A = new b();
        this.p = new androidx.core.g.c(this.k.getContext(), this.A);
    }

    private void g() {
        b bVar = this.A;
        if (bVar != null) {
            bVar.a();
            this.A = null;
        }
        if (this.p != null) {
            this.p = null;
        }
    }

    private void a(float[] fArr) {
        if ((this.i & 12) != 0) {
            fArr[0] = (this.t + this.f2926e) - ((float) this.f2923b.itemView.getLeft());
        } else {
            fArr[0] = this.f2923b.itemView.getTranslationX();
        }
        if ((this.i & 3) != 0) {
            fArr[1] = (this.u + this.f2927f) - ((float) this.f2923b.itemView.getTop());
        } else {
            fArr[1] = this.f2923b.itemView.getTranslationY();
        }
    }

    public void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.t tVar) {
        float f2;
        float f3;
        if (this.f2923b != null) {
            a(this.q);
            float[] fArr = this.q;
            float f4 = fArr[0];
            f2 = fArr[1];
            f3 = f4;
        } else {
            f3 = BitmapDescriptorFactory.HUE_RED;
            f2 = BitmapDescriptorFactory.HUE_RED;
        }
        this.h.b(canvas, recyclerView, this.f2923b, this.j, this.v, f3, f2);
    }

    public void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.t tVar) {
        float f2;
        float f3;
        this.o = -1;
        if (this.f2923b != null) {
            a(this.q);
            float[] fArr = this.q;
            float f4 = fArr[0];
            f2 = fArr[1];
            f3 = f4;
        } else {
            f3 = BitmapDescriptorFactory.HUE_RED;
            f2 = BitmapDescriptorFactory.HUE_RED;
        }
        this.h.a(canvas, recyclerView, this.f2923b, this.j, this.v, f3, f2);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0137  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.recyclerview.widget.RecyclerView.w r24, int r25) {
        /*
            r23 = this;
            r11 = r23
            r12 = r24
            r13 = r25
            androidx.recyclerview.widget.RecyclerView$w r0 = r11.f2923b
            if (r12 != r0) goto L_0x000f
            int r0 = r11.v
            if (r13 != r0) goto L_0x000f
            return
        L_0x000f:
            r0 = -9223372036854775808
            r11.D = r0
            int r4 = r11.v
            r14 = 1
            r11.a((androidx.recyclerview.widget.RecyclerView.w) r12, (boolean) r14)
            r11.v = r13
            r15 = 2
            if (r13 != r15) goto L_0x0030
            if (r12 == 0) goto L_0x0028
            android.view.View r0 = r12.itemView
            r11.n = r0
            r23.i()
            goto L_0x0030
        L_0x0028:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Must pass a ViewHolder when dragging"
            r0.<init>(r1)
            throw r0
        L_0x0030:
            int r0 = r13 * 8
            r10 = 8
            int r0 = r0 + r10
            int r0 = r14 << r0
            int r16 = r0 + -1
            androidx.recyclerview.widget.RecyclerView$w r9 = r11.f2923b
            r8 = 0
            if (r9 == 0) goto L_0x00ee
            android.view.View r0 = r9.itemView
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L_0x00da
            if (r4 != r15) goto L_0x004a
            r7 = 0
            goto L_0x004f
        L_0x004a:
            int r0 = r11.d(r9)
            r7 = r0
        L_0x004f:
            r23.h()
            r0 = 4
            r1 = 0
            if (r7 == r14) goto L_0x007b
            if (r7 == r15) goto L_0x007b
            if (r7 == r0) goto L_0x0069
            if (r7 == r10) goto L_0x0069
            r2 = 16
            if (r7 == r2) goto L_0x0069
            r2 = 32
            if (r7 == r2) goto L_0x0069
            r17 = 0
        L_0x0066:
            r18 = 0
            goto L_0x008e
        L_0x0069:
            float r2 = r11.f2926e
            float r2 = java.lang.Math.signum(r2)
            androidx.recyclerview.widget.RecyclerView r3 = r11.k
            int r3 = r3.getWidth()
            float r3 = (float) r3
            float r2 = r2 * r3
            r17 = r2
            goto L_0x0066
        L_0x007b:
            float r2 = r11.f2927f
            float r2 = java.lang.Math.signum(r2)
            androidx.recyclerview.widget.RecyclerView r3 = r11.k
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r2 = r2 * r3
            r18 = r2
            r17 = 0
        L_0x008e:
            if (r4 != r15) goto L_0x0093
            r6 = 8
            goto L_0x0098
        L_0x0093:
            if (r7 <= 0) goto L_0x0097
            r6 = 2
            goto L_0x0098
        L_0x0097:
            r6 = 4
        L_0x0098:
            float[] r0 = r11.q
            r11.a((float[]) r0)
            float[] r0 = r11.q
            r19 = r0[r8]
            r20 = r0[r14]
            androidx.recyclerview.widget.i$3 r5 = new androidx.recyclerview.widget.i$3
            r0 = r5
            r1 = r23
            r2 = r9
            r3 = r6
            r14 = r5
            r5 = r19
            r15 = r6
            r6 = r20
            r21 = r7
            r7 = r17
            r8 = r18
            r22 = r9
            r9 = r21
            r21 = 8
            r10 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            androidx.recyclerview.widget.i$a r0 = r11.h
            androidx.recyclerview.widget.RecyclerView r1 = r11.k
            float r2 = r17 - r19
            float r3 = r18 - r20
            long r0 = r0.a((androidx.recyclerview.widget.RecyclerView) r1, (int) r15, (float) r2, (float) r3)
            r14.a((long) r0)
            java.util.List<androidx.recyclerview.widget.i$c> r0 = r11.j
            r0.add(r14)
            r14.a()
            r8 = 1
            goto L_0x00ea
        L_0x00da:
            r0 = r9
            r21 = 8
            android.view.View r1 = r0.itemView
            r11.c((android.view.View) r1)
            androidx.recyclerview.widget.i$a r1 = r11.h
            androidx.recyclerview.widget.RecyclerView r2 = r11.k
            r1.d((androidx.recyclerview.widget.RecyclerView) r2, (androidx.recyclerview.widget.RecyclerView.w) r0)
            r8 = 0
        L_0x00ea:
            r0 = 0
            r11.f2923b = r0
            goto L_0x00f1
        L_0x00ee:
            r21 = 8
            r8 = 0
        L_0x00f1:
            if (r12 == 0) goto L_0x0124
            androidx.recyclerview.widget.i$a r0 = r11.h
            androidx.recyclerview.widget.RecyclerView r1 = r11.k
            int r0 = r0.b((androidx.recyclerview.widget.RecyclerView) r1, (androidx.recyclerview.widget.RecyclerView.w) r12)
            r0 = r0 & r16
            int r1 = r11.v
            int r1 = r1 * 8
            int r0 = r0 >> r1
            r11.i = r0
            android.view.View r0 = r12.itemView
            int r0 = r0.getLeft()
            float r0 = (float) r0
            r11.t = r0
            android.view.View r0 = r12.itemView
            int r0 = r0.getTop()
            float r0 = (float) r0
            r11.u = r0
            r11.f2923b = r12
            r0 = 2
            if (r13 != r0) goto L_0x0124
            androidx.recyclerview.widget.RecyclerView$w r0 = r11.f2923b
            android.view.View r0 = r0.itemView
            r1 = 0
            r0.performHapticFeedback(r1)
            goto L_0x0125
        L_0x0124:
            r1 = 0
        L_0x0125:
            androidx.recyclerview.widget.RecyclerView r0 = r11.k
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L_0x0135
            androidx.recyclerview.widget.RecyclerView$w r2 = r11.f2923b
            if (r2 == 0) goto L_0x0132
            r1 = 1
        L_0x0132:
            r0.requestDisallowInterceptTouchEvent(r1)
        L_0x0135:
            if (r8 != 0) goto L_0x0140
            androidx.recyclerview.widget.RecyclerView r0 = r11.k
            androidx.recyclerview.widget.RecyclerView$i r0 = r0.getLayoutManager()
            r0.M()
        L_0x0140:
            androidx.recyclerview.widget.i$a r0 = r11.h
            androidx.recyclerview.widget.RecyclerView$w r1 = r11.f2923b
            int r2 = r11.v
            r0.b((androidx.recyclerview.widget.RecyclerView.w) r1, (int) r2)
            androidx.recyclerview.widget.RecyclerView r0 = r11.k
            r0.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.i.a(androidx.recyclerview.widget.RecyclerView$w, int):void");
    }

    /* access modifiers changed from: package-private */
    public void a(final c cVar, final int i2) {
        this.k.post(new Runnable() {
            public void run() {
                if (i.this.k != null && i.this.k.isAttachedToWindow() && !cVar.n && cVar.h.getAdapterPosition() != -1) {
                    RecyclerView.f itemAnimator = i.this.k.getItemAnimator();
                    if ((itemAnimator == null || !itemAnimator.isRunning((RecyclerView.f.a) null)) && !i.this.a()) {
                        i.this.h.a(cVar.h, i2);
                    } else {
                        i.this.k.post(this);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!this.j.get(i2).o) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c5, code lost:
        if (r1 > 0) goto L_0x00c9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0104 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0110  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b() {
        /*
            r16 = this;
            r0 = r16
            androidx.recyclerview.widget.RecyclerView$w r1 = r0.f2923b
            r2 = 0
            r3 = -9223372036854775808
            if (r1 != 0) goto L_0x000c
            r0.D = r3
            return r2
        L_0x000c:
            long r5 = java.lang.System.currentTimeMillis()
            long r7 = r0.D
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x0019
            r7 = 0
            goto L_0x001b
        L_0x0019:
            long r7 = r5 - r7
        L_0x001b:
            androidx.recyclerview.widget.RecyclerView r1 = r0.k
            androidx.recyclerview.widget.RecyclerView$i r1 = r1.getLayoutManager()
            android.graphics.Rect r9 = r0.C
            if (r9 != 0) goto L_0x002c
            android.graphics.Rect r9 = new android.graphics.Rect
            r9.<init>()
            r0.C = r9
        L_0x002c:
            androidx.recyclerview.widget.RecyclerView$w r9 = r0.f2923b
            android.view.View r9 = r9.itemView
            android.graphics.Rect r10 = r0.C
            r1.b((android.view.View) r9, (android.graphics.Rect) r10)
            boolean r9 = r1.f()
            r10 = 0
            if (r9 == 0) goto L_0x007f
            float r9 = r0.t
            float r11 = r0.f2926e
            float r9 = r9 + r11
            int r9 = (int) r9
            android.graphics.Rect r11 = r0.C
            int r11 = r11.left
            int r11 = r9 - r11
            androidx.recyclerview.widget.RecyclerView r12 = r0.k
            int r12 = r12.getPaddingLeft()
            int r11 = r11 - r12
            float r12 = r0.f2926e
            int r12 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r12 >= 0) goto L_0x0059
            if (r11 >= 0) goto L_0x0059
            r12 = r11
            goto L_0x0080
        L_0x0059:
            float r11 = r0.f2926e
            int r11 = (r11 > r10 ? 1 : (r11 == r10 ? 0 : -1))
            if (r11 <= 0) goto L_0x007f
            androidx.recyclerview.widget.RecyclerView$w r11 = r0.f2923b
            android.view.View r11 = r11.itemView
            int r11 = r11.getWidth()
            int r9 = r9 + r11
            android.graphics.Rect r11 = r0.C
            int r11 = r11.right
            int r9 = r9 + r11
            androidx.recyclerview.widget.RecyclerView r11 = r0.k
            int r11 = r11.getWidth()
            androidx.recyclerview.widget.RecyclerView r12 = r0.k
            int r12 = r12.getPaddingRight()
            int r11 = r11 - r12
            int r9 = r9 - r11
            if (r9 <= 0) goto L_0x007f
            r12 = r9
            goto L_0x0080
        L_0x007f:
            r12 = 0
        L_0x0080:
            boolean r1 = r1.g()
            if (r1 == 0) goto L_0x00c8
            float r1 = r0.u
            float r9 = r0.f2927f
            float r1 = r1 + r9
            int r1 = (int) r1
            android.graphics.Rect r9 = r0.C
            int r9 = r9.top
            int r9 = r1 - r9
            androidx.recyclerview.widget.RecyclerView r11 = r0.k
            int r11 = r11.getPaddingTop()
            int r9 = r9 - r11
            float r11 = r0.f2927f
            int r11 = (r11 > r10 ? 1 : (r11 == r10 ? 0 : -1))
            if (r11 >= 0) goto L_0x00a3
            if (r9 >= 0) goto L_0x00a3
            r1 = r9
            goto L_0x00c9
        L_0x00a3:
            float r9 = r0.f2927f
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x00c8
            androidx.recyclerview.widget.RecyclerView$w r9 = r0.f2923b
            android.view.View r9 = r9.itemView
            int r9 = r9.getHeight()
            int r1 = r1 + r9
            android.graphics.Rect r9 = r0.C
            int r9 = r9.bottom
            int r1 = r1 + r9
            androidx.recyclerview.widget.RecyclerView r9 = r0.k
            int r9 = r9.getHeight()
            androidx.recyclerview.widget.RecyclerView r10 = r0.k
            int r10 = r10.getPaddingBottom()
            int r9 = r9 - r10
            int r1 = r1 - r9
            if (r1 <= 0) goto L_0x00c8
            goto L_0x00c9
        L_0x00c8:
            r1 = 0
        L_0x00c9:
            if (r12 == 0) goto L_0x00e2
            androidx.recyclerview.widget.i$a r9 = r0.h
            androidx.recyclerview.widget.RecyclerView r10 = r0.k
            androidx.recyclerview.widget.RecyclerView$w r11 = r0.f2923b
            android.view.View r11 = r11.itemView
            int r11 = r11.getWidth()
            androidx.recyclerview.widget.RecyclerView r13 = r0.k
            int r13 = r13.getWidth()
            r14 = r7
            int r12 = r9.a(r10, r11, r12, r13, r14)
        L_0x00e2:
            r14 = r12
            if (r1 == 0) goto L_0x0101
            androidx.recyclerview.widget.i$a r9 = r0.h
            androidx.recyclerview.widget.RecyclerView r10 = r0.k
            androidx.recyclerview.widget.RecyclerView$w r11 = r0.f2923b
            android.view.View r11 = r11.itemView
            int r11 = r11.getHeight()
            androidx.recyclerview.widget.RecyclerView r12 = r0.k
            int r13 = r12.getHeight()
            r12 = r1
            r1 = r14
            r14 = r7
            int r7 = r9.a(r10, r11, r12, r13, r14)
            r12 = r1
            r1 = r7
            goto L_0x0102
        L_0x0101:
            r12 = r14
        L_0x0102:
            if (r12 != 0) goto L_0x010a
            if (r1 == 0) goto L_0x0107
            goto L_0x010a
        L_0x0107:
            r0.D = r3
            return r2
        L_0x010a:
            long r7 = r0.D
            int r2 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x0112
            r0.D = r5
        L_0x0112:
            androidx.recyclerview.widget.RecyclerView r2 = r0.k
            r2.scrollBy(r12, r1)
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.i.b():boolean");
    }

    private List<RecyclerView.w> c(RecyclerView.w wVar) {
        RecyclerView.w wVar2 = wVar;
        List<RecyclerView.w> list = this.x;
        if (list == null) {
            this.x = new ArrayList();
            this.y = new ArrayList();
        } else {
            list.clear();
            this.y.clear();
        }
        int d2 = this.h.d();
        int round = Math.round(this.t + this.f2926e) - d2;
        int round2 = Math.round(this.u + this.f2927f) - d2;
        int i2 = d2 * 2;
        int width = wVar2.itemView.getWidth() + round + i2;
        int height = wVar2.itemView.getHeight() + round2 + i2;
        int i3 = (round + width) / 2;
        int i4 = (round2 + height) / 2;
        RecyclerView.i layoutManager = this.k.getLayoutManager();
        int y2 = layoutManager.y();
        int i5 = 0;
        while (i5 < y2) {
            View i6 = layoutManager.i(i5);
            if (i6 != wVar2.itemView && i6.getBottom() >= round2 && i6.getTop() <= height && i6.getRight() >= round && i6.getLeft() <= width) {
                RecyclerView.w b2 = this.k.b(i6);
                if (this.h.a(this.k, this.f2923b, b2)) {
                    int abs = Math.abs(i3 - ((i6.getLeft() + i6.getRight()) / 2));
                    int abs2 = Math.abs(i4 - ((i6.getTop() + i6.getBottom()) / 2));
                    int i7 = (abs * abs) + (abs2 * abs2);
                    int size = this.x.size();
                    int i8 = 0;
                    int i9 = 0;
                    while (i8 < size && i7 > this.y.get(i8).intValue()) {
                        i9++;
                        i8++;
                        RecyclerView.w wVar3 = wVar;
                    }
                    this.x.add(i9, b2);
                    this.y.add(i9, Integer.valueOf(i7));
                }
            }
            i5++;
            wVar2 = wVar;
        }
        return this.x;
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.w wVar) {
        if (!this.k.isLayoutRequested() && this.v == 2) {
            float b2 = this.h.b(wVar);
            int i2 = (int) (this.t + this.f2926e);
            int i3 = (int) (this.u + this.f2927f);
            if (((float) Math.abs(i3 - wVar.itemView.getTop())) >= ((float) wVar.itemView.getHeight()) * b2 || ((float) Math.abs(i2 - wVar.itemView.getLeft())) >= ((float) wVar.itemView.getWidth()) * b2) {
                List<RecyclerView.w> c2 = c(wVar);
                if (c2.size() != 0) {
                    RecyclerView.w a2 = this.h.a(wVar, c2, i2, i3);
                    if (a2 == null) {
                        this.x.clear();
                        this.y.clear();
                        return;
                    }
                    int adapterPosition = a2.getAdapterPosition();
                    int adapterPosition2 = wVar.getAdapterPosition();
                    if (this.h.b(this.k, wVar, a2)) {
                        this.h.a(this.k, wVar, adapterPosition2, a2, adapterPosition, i2, i3);
                    }
                }
            }
        }
    }

    public void b(View view) {
        c(view);
        RecyclerView.w b2 = this.k.b(view);
        if (b2 != null) {
            RecyclerView.w wVar = this.f2923b;
            if (wVar == null || b2 != wVar) {
                a(b2, false);
                if (this.f2922a.remove(b2.itemView)) {
                    this.h.d(this.k, b2);
                    return;
                }
                return;
            }
            a((RecyclerView.w) null, 0);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.w wVar, boolean z2) {
        for (int size = this.j.size() - 1; size >= 0; size--) {
            c cVar = this.j.get(size);
            if (cVar.h == wVar) {
                cVar.n |= z2;
                if (!cVar.o) {
                    cVar.b();
                }
                this.j.remove(size);
                return;
            }
        }
    }

    public void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.t tVar) {
        rect.setEmpty();
    }

    /* access modifiers changed from: package-private */
    public void c() {
        VelocityTracker velocityTracker = this.m;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.m = VelocityTracker.obtain();
    }

    private void h() {
        VelocityTracker velocityTracker = this.m;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.m = null;
        }
    }

    private RecyclerView.w c(MotionEvent motionEvent) {
        RecyclerView.i layoutManager = this.k.getLayoutManager();
        int i2 = this.f2928g;
        if (i2 == -1) {
            return null;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i2);
        float abs = Math.abs(motionEvent.getX(findPointerIndex) - this.f2924c);
        float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.f2925d);
        int i3 = this.w;
        if (abs < ((float) i3) && abs2 < ((float) i3)) {
            return null;
        }
        if (abs > abs2 && layoutManager.f()) {
            return null;
        }
        if (abs2 > abs && layoutManager.g()) {
            return null;
        }
        View a2 = a(motionEvent);
        if (a2 == null) {
            return null;
        }
        return this.k.b(a2);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, MotionEvent motionEvent, int i3) {
        if (this.f2923b == null && i2 == 2 && this.v != 2 && this.h.c() && this.k.getScrollState() != 1) {
            RecyclerView.w c2 = c(motionEvent);
            if (c2 != null) {
                int b2 = (this.h.b(this.k, c2) & 65280) >> 8;
                if (b2 != 0) {
                    float x2 = motionEvent.getX(i3);
                    float y2 = motionEvent.getY(i3);
                    float f2 = x2 - this.f2924c;
                    float f3 = y2 - this.f2925d;
                    float abs = Math.abs(f2);
                    float abs2 = Math.abs(f3);
                    int i4 = this.w;
                    if (abs >= ((float) i4) || abs2 >= ((float) i4)) {
                        if (abs > abs2) {
                            if (f2 < BitmapDescriptorFactory.HUE_RED && (b2 & 4) == 0) {
                                return;
                            }
                            if (f2 > BitmapDescriptorFactory.HUE_RED && (b2 & 8) == 0) {
                                return;
                            }
                        } else if (f3 < BitmapDescriptorFactory.HUE_RED && (b2 & 1) == 0) {
                            return;
                        } else {
                            if (f3 > BitmapDescriptorFactory.HUE_RED && (b2 & 2) == 0) {
                                return;
                            }
                        }
                        this.f2927f = BitmapDescriptorFactory.HUE_RED;
                        this.f2926e = BitmapDescriptorFactory.HUE_RED;
                        this.f2928g = motionEvent.getPointerId(0);
                        a(c2, 1);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public View a(MotionEvent motionEvent) {
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        RecyclerView.w wVar = this.f2923b;
        if (wVar != null) {
            View view = wVar.itemView;
            if (a(view, x2, y2, this.t + this.f2926e, this.u + this.f2927f)) {
                return view;
            }
        }
        for (int size = this.j.size() - 1; size >= 0; size--) {
            c cVar = this.j.get(size);
            View view2 = cVar.h.itemView;
            if (a(view2, x2, y2, cVar.l, cVar.m)) {
                return view2;
            }
        }
        return this.k.a(x2, y2);
    }

    public void b(RecyclerView.w wVar) {
        if (!this.h.c(this.k, wVar)) {
            Log.e("ItemTouchHelper", "Start drag has been called but dragging is not enabled");
        } else if (wVar.itemView.getParent() != this.k) {
            Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
        } else {
            c();
            this.f2927f = BitmapDescriptorFactory.HUE_RED;
            this.f2926e = BitmapDescriptorFactory.HUE_RED;
            a(wVar, 2);
        }
    }

    /* access modifiers changed from: package-private */
    public c b(MotionEvent motionEvent) {
        if (this.j.isEmpty()) {
            return null;
        }
        View a2 = a(motionEvent);
        for (int size = this.j.size() - 1; size >= 0; size--) {
            c cVar = this.j.get(size);
            if (cVar.h.itemView == a2) {
                return cVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(MotionEvent motionEvent, int i2, int i3) {
        float x2 = motionEvent.getX(i3);
        float y2 = motionEvent.getY(i3);
        this.f2926e = x2 - this.f2924c;
        this.f2927f = y2 - this.f2925d;
        if ((i2 & 4) == 0) {
            this.f2926e = Math.max(BitmapDescriptorFactory.HUE_RED, this.f2926e);
        }
        if ((i2 & 8) == 0) {
            this.f2926e = Math.min(BitmapDescriptorFactory.HUE_RED, this.f2926e);
        }
        if ((i2 & 1) == 0) {
            this.f2927f = Math.max(BitmapDescriptorFactory.HUE_RED, this.f2927f);
        }
        if ((i2 & 2) == 0) {
            this.f2927f = Math.min(BitmapDescriptorFactory.HUE_RED, this.f2927f);
        }
    }

    private int d(RecyclerView.w wVar) {
        if (this.v == 2) {
            return 0;
        }
        int a2 = this.h.a(this.k, wVar);
        int d2 = (this.h.d(a2, w.g(this.k)) & 65280) >> 8;
        if (d2 == 0) {
            return 0;
        }
        int i2 = (a2 & 65280) >> 8;
        if (Math.abs(this.f2926e) > Math.abs(this.f2927f)) {
            int b2 = b(wVar, d2);
            if (b2 > 0) {
                return (i2 & b2) == 0 ? a.a(b2, w.g(this.k)) : b2;
            }
            int c2 = c(wVar, d2);
            if (c2 > 0) {
                return c2;
            }
        } else {
            int c3 = c(wVar, d2);
            if (c3 > 0) {
                return c3;
            }
            int b3 = b(wVar, d2);
            if (b3 > 0) {
                return (i2 & b3) == 0 ? a.a(b3, w.g(this.k)) : b3;
            }
        }
        return 0;
    }

    private int b(RecyclerView.w wVar, int i2) {
        if ((i2 & 12) == 0) {
            return 0;
        }
        int i3 = 8;
        int i4 = this.f2926e > BitmapDescriptorFactory.HUE_RED ? 8 : 4;
        VelocityTracker velocityTracker = this.m;
        if (velocityTracker != null && this.f2928g > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.h.b(this.s));
            float xVelocity = this.m.getXVelocity(this.f2928g);
            float yVelocity = this.m.getYVelocity(this.f2928g);
            if (xVelocity <= BitmapDescriptorFactory.HUE_RED) {
                i3 = 4;
            }
            float abs = Math.abs(xVelocity);
            if ((i3 & i2) != 0 && i4 == i3 && abs >= this.h.a(this.r) && abs > Math.abs(yVelocity)) {
                return i3;
            }
        }
        float width = ((float) this.k.getWidth()) * this.h.a(wVar);
        if ((i2 & i4) == 0 || Math.abs(this.f2926e) <= width) {
            return 0;
        }
        return i4;
    }

    private int c(RecyclerView.w wVar, int i2) {
        if ((i2 & 3) == 0) {
            return 0;
        }
        int i3 = 2;
        int i4 = this.f2927f > BitmapDescriptorFactory.HUE_RED ? 2 : 1;
        VelocityTracker velocityTracker = this.m;
        if (velocityTracker != null && this.f2928g > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.h.b(this.s));
            float xVelocity = this.m.getXVelocity(this.f2928g);
            float yVelocity = this.m.getYVelocity(this.f2928g);
            if (yVelocity <= BitmapDescriptorFactory.HUE_RED) {
                i3 = 1;
            }
            float abs = Math.abs(yVelocity);
            if ((i3 & i2) != 0 && i3 == i4 && abs >= this.h.a(this.r) && abs > Math.abs(xVelocity)) {
                return i3;
            }
        }
        float height = ((float) this.k.getHeight()) * this.h.a(wVar);
        if ((i2 & i4) == 0 || Math.abs(this.f2927f) <= height) {
            return 0;
        }
        return i4;
    }

    private void i() {
        if (Build.VERSION.SDK_INT < 21) {
            if (this.z == null) {
                this.z = new RecyclerView.d() {
                    public int a(int i, int i2) {
                        if (i.this.n == null) {
                            return i2;
                        }
                        int i3 = i.this.o;
                        if (i3 == -1) {
                            i3 = i.this.k.indexOfChild(i.this.n);
                            i.this.o = i3;
                        }
                        if (i2 == i - 1) {
                            return i3;
                        }
                        return i2 < i3 ? i2 : i2 + 1;
                    }
                };
            }
            this.k.setChildDrawingOrderCallback(this.z);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(View view) {
        if (view == this.n) {
            this.n = null;
            if (this.z != null) {
                this.k.setChildDrawingOrderCallback((RecyclerView.d) null);
            }
        }
    }

    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        private static final Interpolator f2938a = new Interpolator() {
            public float getInterpolation(float f2) {
                return f2 * f2 * f2 * f2 * f2;
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private static final Interpolator f2939b = new Interpolator() {
            public float getInterpolation(float f2) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            }
        };

        /* renamed from: c  reason: collision with root package name */
        private int f2940c = -1;

        public static int a(int i, int i2) {
            int i3;
            int i4 = i & 789516;
            if (i4 == 0) {
                return i;
            }
            int i5 = i & (i4 ^ -1);
            if (i2 == 0) {
                i3 = i4 << 2;
            } else {
                int i6 = i4 << 1;
                i5 |= -789517 & i6;
                i3 = (i6 & 789516) << 2;
            }
            return i5 | i3;
        }

        public static int c(int i, int i2) {
            return i2 << (i * 8);
        }

        public float a(float f2) {
            return f2;
        }

        public float a(RecyclerView.w wVar) {
            return 0.5f;
        }

        public abstract int a(RecyclerView recyclerView, RecyclerView.w wVar);

        public abstract void a(RecyclerView.w wVar, int i);

        public boolean a(RecyclerView recyclerView, RecyclerView.w wVar, RecyclerView.w wVar2) {
            return true;
        }

        public float b(float f2) {
            return f2;
        }

        public float b(RecyclerView.w wVar) {
            return 0.5f;
        }

        public boolean b() {
            return true;
        }

        public abstract boolean b(RecyclerView recyclerView, RecyclerView.w wVar, RecyclerView.w wVar2);

        public boolean c() {
            return true;
        }

        public int d() {
            return 0;
        }

        public int d(int i, int i2) {
            int i3;
            int i4 = i & 3158064;
            if (i4 == 0) {
                return i;
            }
            int i5 = i & (i4 ^ -1);
            if (i2 == 0) {
                i3 = i4 >> 2;
            } else {
                int i6 = i4 >> 1;
                i5 |= -3158065 & i6;
                i3 = (i6 & 3158064) >> 2;
            }
            return i5 | i3;
        }

        public static j a() {
            return k.f2950a;
        }

        public static int b(int i, int i2) {
            int c2 = c(0, i2 | i);
            return c(2, i) | c(1, i2) | c2;
        }

        /* access modifiers changed from: package-private */
        public final int b(RecyclerView recyclerView, RecyclerView.w wVar) {
            return d(a(recyclerView, wVar), w.g(recyclerView));
        }

        /* access modifiers changed from: package-private */
        public boolean c(RecyclerView recyclerView, RecyclerView.w wVar) {
            return (b(recyclerView, wVar) & 16711680) != 0;
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0056  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0078  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x009a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.recyclerview.widget.RecyclerView.w a(androidx.recyclerview.widget.RecyclerView.w r15, java.util.List<androidx.recyclerview.widget.RecyclerView.w> r16, int r17, int r18) {
            /*
                r14 = this;
                r0 = r15
                android.view.View r1 = r0.itemView
                int r1 = r1.getWidth()
                int r1 = r17 + r1
                android.view.View r2 = r0.itemView
                int r2 = r2.getHeight()
                int r2 = r18 + r2
                android.view.View r3 = r0.itemView
                int r3 = r3.getLeft()
                int r3 = r17 - r3
                android.view.View r4 = r0.itemView
                int r4 = r4.getTop()
                int r4 = r18 - r4
                int r5 = r16.size()
                r6 = 0
                r7 = -1
                r8 = 0
            L_0x0028:
                if (r8 >= r5) goto L_0x00be
                r9 = r16
                java.lang.Object r10 = r9.get(r8)
                androidx.recyclerview.widget.RecyclerView$w r10 = (androidx.recyclerview.widget.RecyclerView.w) r10
                if (r3 <= 0) goto L_0x0053
                android.view.View r11 = r10.itemView
                int r11 = r11.getRight()
                int r11 = r11 - r1
                if (r11 >= 0) goto L_0x0053
                android.view.View r12 = r10.itemView
                int r12 = r12.getRight()
                android.view.View r13 = r0.itemView
                int r13 = r13.getRight()
                if (r12 <= r13) goto L_0x0053
                int r11 = java.lang.Math.abs(r11)
                if (r11 <= r7) goto L_0x0053
                r6 = r10
                goto L_0x0054
            L_0x0053:
                r11 = r7
            L_0x0054:
                if (r3 >= 0) goto L_0x0076
                android.view.View r7 = r10.itemView
                int r7 = r7.getLeft()
                int r7 = r7 - r17
                if (r7 <= 0) goto L_0x0076
                android.view.View r12 = r10.itemView
                int r12 = r12.getLeft()
                android.view.View r13 = r0.itemView
                int r13 = r13.getLeft()
                if (r12 >= r13) goto L_0x0076
                int r7 = java.lang.Math.abs(r7)
                if (r7 <= r11) goto L_0x0076
                r11 = r7
                r6 = r10
            L_0x0076:
                if (r4 >= 0) goto L_0x0098
                android.view.View r7 = r10.itemView
                int r7 = r7.getTop()
                int r7 = r7 - r18
                if (r7 <= 0) goto L_0x0098
                android.view.View r12 = r10.itemView
                int r12 = r12.getTop()
                android.view.View r13 = r0.itemView
                int r13 = r13.getTop()
                if (r12 >= r13) goto L_0x0098
                int r7 = java.lang.Math.abs(r7)
                if (r7 <= r11) goto L_0x0098
                r11 = r7
                r6 = r10
            L_0x0098:
                if (r4 <= 0) goto L_0x00b9
                android.view.View r7 = r10.itemView
                int r7 = r7.getBottom()
                int r7 = r7 - r2
                if (r7 >= 0) goto L_0x00b9
                android.view.View r12 = r10.itemView
                int r12 = r12.getBottom()
                android.view.View r13 = r0.itemView
                int r13 = r13.getBottom()
                if (r12 <= r13) goto L_0x00b9
                int r7 = java.lang.Math.abs(r7)
                if (r7 <= r11) goto L_0x00b9
                r6 = r10
                goto L_0x00ba
            L_0x00b9:
                r7 = r11
            L_0x00ba:
                int r8 = r8 + 1
                goto L_0x0028
            L_0x00be:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.i.a.a(androidx.recyclerview.widget.RecyclerView$w, java.util.List, int, int):androidx.recyclerview.widget.RecyclerView$w");
        }

        public void b(RecyclerView.w wVar, int i) {
            if (wVar != null) {
                k.f2950a.b(wVar.itemView);
            }
        }

        private int a(RecyclerView recyclerView) {
            if (this.f2940c == -1) {
                this.f2940c = recyclerView.getResources().getDimensionPixelSize(a.C0061a.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.f2940c;
        }

        public void a(RecyclerView recyclerView, RecyclerView.w wVar, int i, RecyclerView.w wVar2, int i2, int i3, int i4) {
            RecyclerView.i layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof d) {
                ((d) layoutManager).a(wVar.itemView, wVar2.itemView, i3, i4);
                return;
            }
            if (layoutManager.f()) {
                if (layoutManager.h(wVar2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.b(i2);
                }
                if (layoutManager.j(wVar2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.b(i2);
                }
            }
            if (layoutManager.g()) {
                if (layoutManager.i(wVar2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.b(i2);
                }
                if (layoutManager.k(wVar2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.b(i2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.w wVar, List<c> list, int i, float f2, float f3) {
            Canvas canvas2 = canvas;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                c cVar = list.get(i2);
                cVar.c();
                int save = canvas.save();
                a(canvas, recyclerView, cVar.h, cVar.l, cVar.m, cVar.i, false);
                canvas.restoreToCount(save);
            }
            if (wVar != null) {
                int save2 = canvas.save();
                a(canvas, recyclerView, wVar, f2, f3, i, true);
                canvas.restoreToCount(save2);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.w wVar, List<c> list, int i, float f2, float f3) {
            Canvas canvas2 = canvas;
            List<c> list2 = list;
            int size = list.size();
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                c cVar = list2.get(i2);
                int save = canvas.save();
                b(canvas, recyclerView, cVar.h, cVar.l, cVar.m, cVar.i, false);
                canvas.restoreToCount(save);
            }
            if (wVar != null) {
                int save2 = canvas.save();
                b(canvas, recyclerView, wVar, f2, f3, i, true);
                canvas.restoreToCount(save2);
            }
            for (int i3 = size - 1; i3 >= 0; i3--) {
                c cVar2 = list2.get(i3);
                if (cVar2.o && !cVar2.k) {
                    list2.remove(i3);
                } else if (!cVar2.o) {
                    z = true;
                }
            }
            if (z) {
                recyclerView.invalidate();
            }
        }

        public void d(RecyclerView recyclerView, RecyclerView.w wVar) {
            k.f2950a.a(wVar.itemView);
        }

        public void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.w wVar, float f2, float f3, int i, boolean z) {
            k.f2950a.a(canvas, recyclerView, wVar.itemView, f2, f3, i, z);
        }

        public void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.w wVar, float f2, float f3, int i, boolean z) {
            k.f2950a.b(canvas, recyclerView, wVar.itemView, f2, f3, i, z);
        }

        public long a(RecyclerView recyclerView, int i, float f2, float f3) {
            RecyclerView.f itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator == null) {
                return i == 8 ? 200 : 250;
            }
            if (i == 8) {
                return itemAnimator.getMoveDuration();
            }
            return itemAnimator.getRemoveDuration();
        }

        public int a(RecyclerView recyclerView, int i, int i2, int i3, long j) {
            float f2 = 1.0f;
            int signum = (int) (((float) (((int) Math.signum((float) i2)) * a(recyclerView))) * f2939b.getInterpolation(Math.min(1.0f, (((float) Math.abs(i2)) * 1.0f) / ((float) i))));
            if (j <= 2000) {
                f2 = ((float) j) / 2000.0f;
            }
            int interpolation = (int) (((float) signum) * f2938a.getInterpolation(f2));
            if (interpolation == 0) {
                return i2 > 0 ? 1 : -1;
            }
            return interpolation;
        }
    }

    private class b extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: b  reason: collision with root package name */
        private boolean f2942b = true;

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        b() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f2942b = false;
        }

        public void onLongPress(MotionEvent motionEvent) {
            if (this.f2942b) {
                View a2 = i.this.a(motionEvent);
                if (a2 != null) {
                    RecyclerView.w b2 = i.this.k.b(a2);
                    if (b2 != null && i.this.h.c(i.this.k, b2) && motionEvent.getPointerId(0) == i.this.f2928g) {
                        int findPointerIndex = motionEvent.findPointerIndex(i.this.f2928g);
                        float x = motionEvent.getX(findPointerIndex);
                        float y = motionEvent.getY(findPointerIndex);
                        i iVar = i.this;
                        iVar.f2924c = x;
                        iVar.f2925d = y;
                        iVar.f2927f = BitmapDescriptorFactory.HUE_RED;
                        iVar.f2926e = BitmapDescriptorFactory.HUE_RED;
                        if (iVar.h.b()) {
                            i.this.a(b2, 2);
                        }
                    }
                }
            }
        }
    }

    private static class c implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        private final ValueAnimator f2943a;

        /* renamed from: b  reason: collision with root package name */
        private float f2944b;

        /* renamed from: d  reason: collision with root package name */
        final float f2945d;

        /* renamed from: e  reason: collision with root package name */
        final float f2946e;

        /* renamed from: f  reason: collision with root package name */
        final float f2947f;

        /* renamed from: g  reason: collision with root package name */
        final float f2948g;
        final RecyclerView.w h;
        final int i;
        final int j;
        boolean k;
        float l;
        float m;
        boolean n = false;
        boolean o = false;

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        c(RecyclerView.w wVar, int i2, int i3, float f2, float f3, float f4, float f5) {
            this.i = i3;
            this.j = i2;
            this.h = wVar;
            this.f2945d = f2;
            this.f2946e = f3;
            this.f2947f = f4;
            this.f2948g = f5;
            this.f2943a = ValueAnimator.ofFloat(new float[]{BitmapDescriptorFactory.HUE_RED, 1.0f});
            this.f2943a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    c.this.a(valueAnimator.getAnimatedFraction());
                }
            });
            this.f2943a.setTarget(wVar.itemView);
            this.f2943a.addListener(this);
            a((float) BitmapDescriptorFactory.HUE_RED);
        }

        public void a(long j2) {
            this.f2943a.setDuration(j2);
        }

        public void a() {
            this.h.setIsRecyclable(false);
            this.f2943a.start();
        }

        public void b() {
            this.f2943a.cancel();
        }

        public void a(float f2) {
            this.f2944b = f2;
        }

        public void c() {
            float f2 = this.f2945d;
            float f3 = this.f2947f;
            if (f2 == f3) {
                this.l = this.h.itemView.getTranslationX();
            } else {
                this.l = f2 + (this.f2944b * (f3 - f2));
            }
            float f4 = this.f2946e;
            float f5 = this.f2948g;
            if (f4 == f5) {
                this.m = this.h.itemView.getTranslationY();
            } else {
                this.m = f4 + (this.f2944b * (f5 - f4));
            }
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.o) {
                this.h.setIsRecyclable(true);
            }
            this.o = true;
        }

        public void onAnimationCancel(Animator animator) {
            a(1.0f);
        }
    }
}
