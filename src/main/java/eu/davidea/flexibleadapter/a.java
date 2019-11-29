package eu.davidea.flexibleadapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.EnumSet;

public abstract class a extends e {

    /* renamed from: a  reason: collision with root package name */
    protected static final String f32800a = "a";

    /* renamed from: b  reason: collision with root package name */
    private Interpolator f32801b = new LinearInterpolator();

    /* renamed from: c  reason: collision with root package name */
    private C0501a f32802c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f32803d = true;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final SparseArray<Animator> f32804e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    private int f32805f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f32806g = -1;
    private EnumSet<b> h = EnumSet.noneOf(b.class);
    private boolean i = false;
    private boolean j = false;
    private boolean o = false;
    private boolean p = false;
    /* access modifiers changed from: private */
    public boolean q = false;
    private long r = 0;
    private long s = 100;
    private long t = 300;

    private enum b {
        ALPHA,
        SLIDE_IN_LEFT,
        SLIDE_IN_RIGHT,
        SLIDE_IN_BOTTOM,
        SLIDE_IN_TOP,
        SCALE
    }

    public a(boolean z) {
        if (z && k) {
            Log.i(f32800a, "Setting StableIds");
        }
        setHasStableIds(z);
        this.f32802c = new C0501a();
        registerAdapterDataObserver(this.f32802c);
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        this.q = z;
    }

    public boolean a() {
        return this.j;
    }

    public void onViewAttachedToWindow(RecyclerView.w wVar) {
        a(wVar, wVar.getAdapterPosition());
    }

    private void a(int i2) {
        Animator animator = this.f32804e.get(i2);
        if (animator != null) {
            animator.end();
        }
    }

    /* access modifiers changed from: protected */
    public void a(RecyclerView.w wVar, int i2) {
        if ((wVar instanceof eu.davidea.a.b) && this.j && !this.p && !this.f32802c.b() && (this.i || i2 > this.f32805f || (i2 == 0 && this.l.getChildCount() == 0))) {
            int hashCode = wVar.itemView.hashCode();
            a(hashCode);
            ArrayList arrayList = new ArrayList();
            ((eu.davidea.a.b) wVar).a(arrayList, i2, i2 > this.f32805f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            animatorSet.setInterpolator(this.f32801b);
            animatorSet.setDuration(this.t);
            animatorSet.addListener(new c(hashCode));
            if (this.f32803d) {
                animatorSet.setStartDelay(d(i2));
            }
            animatorSet.start();
            this.f32804e.put(hashCode, animatorSet);
            if (k) {
                String str = f32800a;
                Log.d(str, "Started Animation on position " + i2);
            }
            if (this.o && i2 >= this.f32806g) {
                this.j = false;
            }
        }
        this.f32802c.c();
        this.f32805f = i2;
    }

    private long d(int i2) {
        int b2 = eu.davidea.flexibleadapter.c.a.b(this.l.getLayoutManager());
        int c2 = eu.davidea.flexibleadapter.c.a.c(this.l.getLayoutManager());
        int i3 = this.f32805f;
        if (i3 > c2) {
            c2 = i3;
        }
        int i4 = c2 - b2;
        int i5 = i2 - 1;
        if (this.f32806g < this.l.getChildCount()) {
            this.f32806g = this.l.getChildCount();
        }
        if (i4 != 0 && i4 >= i5 && ((b2 <= 1 || b2 > this.f32806g) && (i2 <= this.f32806g || b2 != -1 || this.l.getChildCount() != 0))) {
            return this.r + (((long) i2) * this.s);
        }
        long j2 = this.s;
        if (i4 <= 1) {
            j2 += this.r;
        } else {
            this.r = 0;
        }
        long j3 = j2;
        if (!(this.l.getLayoutManager() instanceof GridLayoutManager)) {
            return j3;
        }
        return this.r + (this.s * ((long) (i2 % ((GridLayoutManager) this.l.getLayoutManager()).b())));
    }

    /* renamed from: eu.davidea.flexibleadapter.a$a  reason: collision with other inner class name */
    private class C0501a extends RecyclerView.c {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f32808b;

        /* renamed from: c  reason: collision with root package name */
        private Handler f32809c;

        private C0501a() {
            this.f32809c = new Handler(Looper.getMainLooper(), new Handler.Callback() {
                public boolean handleMessage(Message message) {
                    if (e.k) {
                        Log.v(a.f32800a, "Clear notified for binding Animations");
                    }
                    boolean unused = C0501a.this.f32808b = false;
                    return true;
                }
            });
        }

        public boolean b() {
            return this.f32808b;
        }

        public void c() {
            if (this.f32808b) {
                this.f32809c.removeCallbacksAndMessages((Object) null);
                Handler handler = this.f32809c;
                handler.sendMessageDelayed(Message.obtain(handler), 200);
            }
        }

        private void d() {
            this.f32808b = !a.this.q;
        }

        public void a() {
            d();
        }

        public void a(int i, int i2) {
            d();
        }

        public void b(int i, int i2) {
            d();
        }

        public void c(int i, int i2) {
            d();
        }

        public void a(int i, int i2, int i3) {
            d();
        }
    }

    private class c implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        int f32827a;

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        c(int i) {
            this.f32827a = i;
        }

        public void onAnimationEnd(Animator animator) {
            a.this.f32804e.remove(this.f32827a);
        }
    }
}
