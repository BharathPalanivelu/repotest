package androidx.l;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.g.w;
import androidx.l.n;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class e extends aj {
    public e(int i) {
        a(i);
    }

    public e() {
    }

    public void a(t tVar) {
        super.a(tVar);
        tVar.f2533a.put("android:fade:transitionAlpha", Float.valueOf(ae.c(tVar.f2534b)));
    }

    private Animator a(final View view, float f2, float f3) {
        if (f2 == f3) {
            return null;
        }
        ae.a(view, f2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, ae.f2419a, new float[]{f3});
        ofFloat.addListener(new a(view));
        a((n.c) new o() {
            public void a(n nVar) {
                ae.a(view, 1.0f);
                ae.e(view);
                nVar.b((n.c) this);
            }
        });
        return ofFloat;
    }

    public Animator a(ViewGroup viewGroup, View view, t tVar, t tVar2) {
        float f2 = BitmapDescriptorFactory.HUE_RED;
        float a2 = a(tVar, BitmapDescriptorFactory.HUE_RED);
        if (a2 != 1.0f) {
            f2 = a2;
        }
        return a(view, f2, 1.0f);
    }

    public Animator b(ViewGroup viewGroup, View view, t tVar, t tVar2) {
        ae.d(view);
        return a(view, a(tVar, 1.0f), BitmapDescriptorFactory.HUE_RED);
    }

    private static float a(t tVar, float f2) {
        if (tVar == null) {
            return f2;
        }
        Float f3 = (Float) tVar.f2533a.get("android:fade:transitionAlpha");
        return f3 != null ? f3.floatValue() : f2;
    }

    private static class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final View f2480a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f2481b = false;

        a(View view) {
            this.f2480a = view;
        }

        public void onAnimationStart(Animator animator) {
            if (w.u(this.f2480a) && this.f2480a.getLayerType() == 0) {
                this.f2481b = true;
                this.f2480a.setLayerType(2, (Paint) null);
            }
        }

        public void onAnimationEnd(Animator animator) {
            ae.a(this.f2480a, 1.0f);
            if (this.f2481b) {
                this.f2480a.setLayerType(0, (Paint) null);
            }
        }
    }
}
