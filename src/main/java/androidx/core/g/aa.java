package androidx.core.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class aa {

    /* renamed from: a  reason: collision with root package name */
    Runnable f1757a = null;

    /* renamed from: b  reason: collision with root package name */
    Runnable f1758b = null;

    /* renamed from: c  reason: collision with root package name */
    int f1759c = -1;

    /* renamed from: d  reason: collision with root package name */
    private WeakReference<View> f1760d;

    aa(View view) {
        this.f1760d = new WeakReference<>(view);
    }

    static class a implements ab {

        /* renamed from: a  reason: collision with root package name */
        aa f1767a;

        /* renamed from: b  reason: collision with root package name */
        boolean f1768b;

        a(aa aaVar) {
            this.f1767a = aaVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.core.g.ab} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(android.view.View r4) {
            /*
                r3 = this;
                r0 = 0
                r3.f1768b = r0
                androidx.core.g.aa r0 = r3.f1767a
                int r0 = r0.f1759c
                r1 = 0
                r2 = -1
                if (r0 <= r2) goto L_0x000f
                r0 = 2
                r4.setLayerType(r0, r1)
            L_0x000f:
                androidx.core.g.aa r0 = r3.f1767a
                java.lang.Runnable r0 = r0.f1757a
                if (r0 == 0) goto L_0x0020
                androidx.core.g.aa r0 = r3.f1767a
                java.lang.Runnable r0 = r0.f1757a
                androidx.core.g.aa r2 = r3.f1767a
                r2.f1757a = r1
                r0.run()
            L_0x0020:
                r0 = 2113929216(0x7e000000, float:4.2535296E37)
                java.lang.Object r0 = r4.getTag(r0)
                boolean r2 = r0 instanceof androidx.core.g.ab
                if (r2 == 0) goto L_0x002d
                r1 = r0
                androidx.core.g.ab r1 = (androidx.core.g.ab) r1
            L_0x002d:
                if (r1 == 0) goto L_0x0032
                r1.a(r4)
            L_0x0032:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.g.aa.a.a(android.view.View):void");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: androidx.core.g.ab} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(android.view.View r4) {
            /*
                r3 = this;
                androidx.core.g.aa r0 = r3.f1767a
                int r0 = r0.f1759c
                r1 = -1
                r2 = 0
                if (r0 <= r1) goto L_0x0013
                androidx.core.g.aa r0 = r3.f1767a
                int r0 = r0.f1759c
                r4.setLayerType(r0, r2)
                androidx.core.g.aa r0 = r3.f1767a
                r0.f1759c = r1
            L_0x0013:
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 16
                if (r0 >= r1) goto L_0x001d
                boolean r0 = r3.f1768b
                if (r0 != 0) goto L_0x0043
            L_0x001d:
                androidx.core.g.aa r0 = r3.f1767a
                java.lang.Runnable r0 = r0.f1758b
                if (r0 == 0) goto L_0x002e
                androidx.core.g.aa r0 = r3.f1767a
                java.lang.Runnable r0 = r0.f1758b
                androidx.core.g.aa r1 = r3.f1767a
                r1.f1758b = r2
                r0.run()
            L_0x002e:
                r0 = 2113929216(0x7e000000, float:4.2535296E37)
                java.lang.Object r0 = r4.getTag(r0)
                boolean r1 = r0 instanceof androidx.core.g.ab
                if (r1 == 0) goto L_0x003b
                r2 = r0
                androidx.core.g.ab r2 = (androidx.core.g.ab) r2
            L_0x003b:
                if (r2 == 0) goto L_0x0040
                r2.b(r4)
            L_0x0040:
                r4 = 1
                r3.f1768b = r4
            L_0x0043:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.g.aa.a.b(android.view.View):void");
        }

        public void c(View view) {
            Object tag = view.getTag(2113929216);
            ab abVar = tag instanceof ab ? (ab) tag : null;
            if (abVar != null) {
                abVar.c(view);
            }
        }
    }

    public aa a(long j) {
        View view = (View) this.f1760d.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public aa a(float f2) {
        View view = (View) this.f1760d.get();
        if (view != null) {
            view.animate().alpha(f2);
        }
        return this;
    }

    public aa b(float f2) {
        View view = (View) this.f1760d.get();
        if (view != null) {
            view.animate().translationY(f2);
        }
        return this;
    }

    public long a() {
        View view = (View) this.f1760d.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0;
    }

    public aa a(Interpolator interpolator) {
        View view = (View) this.f1760d.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public aa b(long j) {
        View view = (View) this.f1760d.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public void b() {
        View view = (View) this.f1760d.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public void c() {
        View view = (View) this.f1760d.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public aa a(ab abVar) {
        View view = (View) this.f1760d.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                a(view, abVar);
            } else {
                view.setTag(2113929216, abVar);
                a(view, new a(this));
            }
        }
        return this;
    }

    private void a(final View view, final ab abVar) {
        if (abVar != null) {
            view.animate().setListener(new AnimatorListenerAdapter() {
                public void onAnimationCancel(Animator animator) {
                    abVar.c(view);
                }

                public void onAnimationEnd(Animator animator) {
                    abVar.b(view);
                }

                public void onAnimationStart(Animator animator) {
                    abVar.a(view);
                }
            });
        } else {
            view.animate().setListener((Animator.AnimatorListener) null);
        }
    }

    public aa a(final ad adVar) {
        final View view = (View) this.f1760d.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            AnonymousClass2 r1 = null;
            if (adVar != null) {
                r1 = new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        adVar.a(view);
                    }
                };
            }
            view.animate().setUpdateListener(r1);
        }
        return this;
    }
}
