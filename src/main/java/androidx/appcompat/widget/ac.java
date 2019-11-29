package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.appcompat.view.menu.p;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public abstract class ac implements View.OnAttachStateChangeListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private final float f1059a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1060b;

    /* renamed from: c  reason: collision with root package name */
    final View f1061c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1062d;

    /* renamed from: e  reason: collision with root package name */
    private Runnable f1063e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f1064f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1065g;
    private int h;
    private final int[] i = new int[2];

    public abstract p a();

    public void onViewAttachedToWindow(View view) {
    }

    public ac(View view) {
        this.f1061c = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1059a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f1060b = ViewConfiguration.getTapTimeout();
        this.f1062d = (this.f1060b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.f1065g;
        if (z2) {
            z = b(motionEvent) || !c();
        } else {
            z = a(motionEvent) && b();
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
                this.f1061c.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.f1065g = z;
        if (z || z2) {
            return true;
        }
        return false;
    }

    public void onViewDetachedFromWindow(View view) {
        this.f1065g = false;
        this.h = -1;
        Runnable runnable = this.f1063e;
        if (runnable != null) {
            this.f1061c.removeCallbacks(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        p a2 = a();
        if (a2 == null || a2.e()) {
            return true;
        }
        a2.a_();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        p a2 = a();
        if (a2 == null || !a2.e()) {
            return true;
        }
        a2.d();
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        if (r1 != 3) goto L_0x006d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f1061c
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L_0x0041
            r3 = 1
            if (r1 == r3) goto L_0x003d
            r4 = 2
            if (r1 == r4) goto L_0x001a
            r6 = 3
            if (r1 == r6) goto L_0x003d
            goto L_0x006d
        L_0x001a:
            int r1 = r5.h
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L_0x006d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f1059a
            boolean r6 = a(r0, r4, r6, r1)
            if (r6 != 0) goto L_0x006d
            r5.e()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L_0x003d:
            r5.e()
            goto L_0x006d
        L_0x0041:
            int r6 = r6.getPointerId(r2)
            r5.h = r6
            java.lang.Runnable r6 = r5.f1063e
            if (r6 != 0) goto L_0x0052
            androidx.appcompat.widget.ac$a r6 = new androidx.appcompat.widget.ac$a
            r6.<init>()
            r5.f1063e = r6
        L_0x0052:
            java.lang.Runnable r6 = r5.f1063e
            int r1 = r5.f1060b
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f1064f
            if (r6 != 0) goto L_0x0065
            androidx.appcompat.widget.ac$b r6 = new androidx.appcompat.widget.ac$b
            r6.<init>()
            r5.f1064f = r6
        L_0x0065:
            java.lang.Runnable r6 = r5.f1064f
            int r1 = r5.f1062d
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L_0x006d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ac.a(android.view.MotionEvent):boolean");
    }

    private void e() {
        Runnable runnable = this.f1064f;
        if (runnable != null) {
            this.f1061c.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f1063e;
        if (runnable2 != null) {
            this.f1061c.removeCallbacks(runnable2);
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        e();
        View view = this.f1061c;
        if (view.isEnabled() && !view.isLongClickable() && b()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f1065g = true;
        }
    }

    private boolean b(MotionEvent motionEvent) {
        View view = this.f1061c;
        p a2 = a();
        if (a2 != null && a2.e()) {
            aa aaVar = (aa) a2.g();
            if (aaVar != null && aaVar.isShown()) {
                MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                b(view, obtainNoHistory);
                a(aaVar, obtainNoHistory);
                boolean a3 = aaVar.a(obtainNoHistory, this.h);
                obtainNoHistory.recycle();
                int actionMasked = motionEvent.getActionMasked();
                return a3 && (actionMasked != 1 && actionMasked != 3);
            }
        }
        return false;
    }

    private static boolean a(View view, float f2, float f3, float f4) {
        float f5 = -f4;
        return f2 >= f5 && f3 >= f5 && f2 < ((float) (view.getRight() - view.getLeft())) + f4 && f3 < ((float) (view.getBottom() - view.getTop())) + f4;
    }

    private boolean a(View view, MotionEvent motionEvent) {
        int[] iArr = this.i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
        return true;
    }

    private boolean b(View view, MotionEvent motionEvent) {
        int[] iArr = this.i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
        return true;
    }

    private class a implements Runnable {
        a() {
        }

        public void run() {
            ViewParent parent = ac.this.f1061c.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    private class b implements Runnable {
        b() {
        }

        public void run() {
            ac.this.d();
        }
    }
}
