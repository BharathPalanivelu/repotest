package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.g.w;
import androidx.core.g.x;
import com.salesforce.android.service.common.utilities.threading.Timer;

class au implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener {
    private static au j;
    private static au k;

    /* renamed from: a  reason: collision with root package name */
    private final View f1164a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f1165b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1166c;

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f1167d = new Runnable() {
        public void run() {
            au.this.a(false);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final Runnable f1168e = new Runnable() {
        public void run() {
            au.this.a();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private int f1169f;

    /* renamed from: g  reason: collision with root package name */
    private int f1170g;
    private av h;
    private boolean i;

    public void onViewAttachedToWindow(View view) {
    }

    public static void a(View view, CharSequence charSequence) {
        au auVar = j;
        if (auVar != null && auVar.f1164a == view) {
            a((au) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            au auVar2 = k;
            if (auVar2 != null && auVar2.f1164a == view) {
                auVar2.a();
            }
            view.setOnLongClickListener((View.OnLongClickListener) null);
            view.setLongClickable(false);
            view.setOnHoverListener((View.OnHoverListener) null);
            return;
        }
        new au(view, charSequence);
    }

    private au(View view, CharSequence charSequence) {
        this.f1164a = view;
        this.f1165b = charSequence;
        this.f1166c = x.b(ViewConfiguration.get(this.f1164a.getContext()));
        d();
        this.f1164a.setOnLongClickListener(this);
        this.f1164a.setOnHoverListener(this);
    }

    public boolean onLongClick(View view) {
        this.f1169f = view.getWidth() / 2;
        this.f1170g = view.getHeight() / 2;
        a(true);
        return true;
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.h != null && this.i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f1164a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                d();
                a();
            }
        } else if (this.f1164a.isEnabled() && this.h == null && a(motionEvent)) {
            a(this);
        }
        return false;
    }

    public void onViewDetachedFromWindow(View view) {
        a();
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        long j2;
        int i2;
        long j3;
        if (w.D(this.f1164a)) {
            a((au) null);
            au auVar = k;
            if (auVar != null) {
                auVar.a();
            }
            k = this;
            this.i = z;
            this.h = new av(this.f1164a.getContext());
            this.h.a(this.f1164a, this.f1169f, this.f1170g, this.i, this.f1165b);
            this.f1164a.addOnAttachStateChangeListener(this);
            if (this.i) {
                j2 = 2500;
            } else {
                if ((w.r(this.f1164a) & 1) == 1) {
                    j3 = 3000;
                    i2 = ViewConfiguration.getLongPressTimeout();
                } else {
                    j3 = Timer.DEFAULT_TIMER_DELAY_MS;
                    i2 = ViewConfiguration.getLongPressTimeout();
                }
                j2 = j3 - ((long) i2);
            }
            this.f1164a.removeCallbacks(this.f1168e);
            this.f1164a.postDelayed(this.f1168e, j2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (k == this) {
            k = null;
            av avVar = this.h;
            if (avVar != null) {
                avVar.a();
                this.h = null;
                d();
                this.f1164a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (j == this) {
            a((au) null);
        }
        this.f1164a.removeCallbacks(this.f1168e);
    }

    private static void a(au auVar) {
        au auVar2 = j;
        if (auVar2 != null) {
            auVar2.c();
        }
        j = auVar;
        au auVar3 = j;
        if (auVar3 != null) {
            auVar3.b();
        }
    }

    private void b() {
        this.f1164a.postDelayed(this.f1167d, (long) ViewConfiguration.getLongPressTimeout());
    }

    private void c() {
        this.f1164a.removeCallbacks(this.f1167d);
    }

    private boolean a(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.f1169f) <= this.f1166c && Math.abs(y - this.f1170g) <= this.f1166c) {
            return false;
        }
        this.f1169f = x;
        this.f1170g = y;
        return true;
    }

    private void d() {
        this.f1169f = Integer.MAX_VALUE;
        this.f1170g = Integer.MAX_VALUE;
    }
}
