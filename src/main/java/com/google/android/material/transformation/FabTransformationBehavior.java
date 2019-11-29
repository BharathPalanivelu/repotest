package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.g.w;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.a;
import com.google.android.material.a.b;
import com.google.android.material.a.c;
import com.google.android.material.a.e;
import com.google.android.material.a.h;
import com.google.android.material.a.i;
import com.google.android.material.a.j;
import com.google.android.material.c.d;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: a  reason: collision with root package name */
    private final Rect f13546a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    private final RectF f13547b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    private final RectF f13548c = new RectF();

    /* renamed from: d  reason: collision with root package name */
    private final int[] f13549d = new int[2];

    /* access modifiers changed from: protected */
    public abstract a a(Context context, boolean z);

    public FabTransformationBehavior() {
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        } else if (!(view2 instanceof FloatingActionButton)) {
            return false;
        } else {
            int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
            if (expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId()) {
                return true;
            }
            return false;
        }
    }

    public void onAttachedToLayoutParams(CoordinatorLayout.e eVar) {
        if (eVar.h == 0) {
            eVar.h = 80;
        }
    }

    /* access modifiers changed from: protected */
    public AnimatorSet b(View view, View view2, boolean z, boolean z2) {
        final boolean z3 = z;
        a a2 = a(view2.getContext(), z3);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            a(view, view2, z, z2, a2, arrayList, arrayList2);
        }
        RectF rectF = this.f13547b;
        View view3 = view;
        View view4 = view2;
        boolean z4 = z;
        boolean z5 = z2;
        a aVar = a2;
        ArrayList arrayList3 = arrayList;
        ArrayList arrayList4 = arrayList2;
        a(view3, view4, z4, z5, aVar, (List<Animator>) arrayList3, (List<Animator.AnimatorListener>) arrayList4, rectF);
        float width = rectF.width();
        float height = rectF.height();
        b(view3, view4, z4, z5, aVar, arrayList3, arrayList4);
        a(view3, view4, z4, z5, aVar, width, height, (List<Animator>) arrayList, (List<Animator.AnimatorListener>) arrayList2);
        ArrayList arrayList5 = arrayList;
        ArrayList arrayList6 = arrayList2;
        c(view3, view4, z4, z5, aVar, arrayList5, arrayList6);
        d(view3, view4, z4, z5, aVar, arrayList5, arrayList6);
        AnimatorSet animatorSet = new AnimatorSet();
        b.a(animatorSet, arrayList);
        final View view5 = view;
        final View view6 = view2;
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                if (z3) {
                    view6.setVisibility(0);
                    view5.setAlpha(BitmapDescriptorFactory.HUE_RED);
                    view5.setVisibility(4);
                }
            }

            public void onAnimationEnd(Animator animator) {
                if (!z3) {
                    view6.setVisibility(4);
                    view5.setAlpha(1.0f);
                    view5.setVisibility(0);
                }
            }
        });
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList2.get(i));
        }
        return animatorSet;
    }

    @TargetApi(21)
    private void a(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        float o = w.o(view2) - w.o(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-o);
            }
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, new float[]{0.0f});
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, new float[]{-o});
        }
        aVar.f13561a.b("elevation").a((Animator) objectAnimator);
        list.add(objectAnimator);
    }

    private void a(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2, RectF rectF) {
        i iVar;
        i iVar2;
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        View view3 = view;
        View view4 = view2;
        a aVar2 = aVar;
        List<Animator> list3 = list;
        float a2 = a(view3, view4, aVar2.f13562b);
        float b2 = b(view3, view4, aVar2.f13562b);
        if (a2 == BitmapDescriptorFactory.HUE_RED || b2 == BitmapDescriptorFactory.HUE_RED) {
            iVar2 = aVar2.f13561a.b("translationXLinear");
            iVar = aVar2.f13561a.b("translationYLinear");
        } else if ((!z || b2 >= BitmapDescriptorFactory.HUE_RED) && (z || b2 <= BitmapDescriptorFactory.HUE_RED)) {
            iVar2 = aVar2.f13561a.b("translationXCurveDownwards");
            iVar = aVar2.f13561a.b("translationYCurveDownwards");
        } else {
            iVar2 = aVar2.f13561a.b("translationXCurveUpwards");
            iVar = aVar2.f13561a.b("translationYCurveUpwards");
        }
        i iVar3 = iVar2;
        i iVar4 = iVar;
        if (z) {
            if (!z2) {
                view4.setTranslationX(-a2);
                view4.setTranslationY(-b2);
            }
            objectAnimator2 = ObjectAnimator.ofFloat(view4, View.TRANSLATION_X, new float[]{0.0f});
            objectAnimator = ObjectAnimator.ofFloat(view4, View.TRANSLATION_Y, new float[]{0.0f});
            a(view2, aVar, iVar3, iVar4, -a2, -b2, (float) BitmapDescriptorFactory.HUE_RED, (float) BitmapDescriptorFactory.HUE_RED, rectF);
        } else {
            objectAnimator2 = ObjectAnimator.ofFloat(view4, View.TRANSLATION_X, new float[]{-a2});
            objectAnimator = ObjectAnimator.ofFloat(view4, View.TRANSLATION_Y, new float[]{-b2});
        }
        iVar3.a((Animator) objectAnimator2);
        iVar4.a((Animator) objectAnimator);
        list3.add(objectAnimator2);
        list3.add(objectAnimator);
    }

    private void b(View view, final View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        if ((view2 instanceof d) && (view instanceof ImageView)) {
            final d dVar = (d) view2;
            final Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable != null) {
                drawable.mutate();
                if (z) {
                    if (!z2) {
                        drawable.setAlpha(255);
                    }
                    objectAnimator = ObjectAnimator.ofInt(drawable, e.f13105a, new int[]{0});
                } else {
                    objectAnimator = ObjectAnimator.ofInt(drawable, e.f13105a, new int[]{255});
                }
                objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        view2.invalidate();
                    }
                });
                aVar.f13561a.b("iconFade").a((Animator) objectAnimator);
                list.add(objectAnimator);
                list2.add(new AnimatorListenerAdapter() {
                    public void onAnimationStart(Animator animator) {
                        dVar.setCircularRevealOverlayDrawable(drawable);
                    }

                    public void onAnimationEnd(Animator animator) {
                        dVar.setCircularRevealOverlayDrawable((Drawable) null);
                    }
                });
            }
        }
    }

    private void a(View view, View view2, boolean z, boolean z2, a aVar, float f2, float f3, List<Animator> list, List<Animator.AnimatorListener> list2) {
        Animator animator;
        View view3 = view;
        View view4 = view2;
        a aVar2 = aVar;
        if (view4 instanceof d) {
            final d dVar = (d) view4;
            float c2 = c(view3, view4, aVar2.f13562b);
            float d2 = d(view3, view4, aVar2.f13562b);
            ((FloatingActionButton) view3).a(this.f13546a);
            float width = ((float) this.f13546a.width()) / 2.0f;
            i b2 = aVar2.f13561a.b("expansion");
            if (z) {
                if (!z2) {
                    dVar.setRevealInfo(new d.C0216d(c2, d2, width));
                }
                if (z2) {
                    width = dVar.getRevealInfo().f13275c;
                }
                animator = com.google.android.material.c.a.a(dVar, c2, d2, com.google.android.material.e.a.a(c2, d2, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, f2, f3));
                animator.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        d.C0216d revealInfo = dVar.getRevealInfo();
                        revealInfo.f13275c = Float.MAX_VALUE;
                        dVar.setRevealInfo(revealInfo);
                    }
                });
                a(view2, b2.a(), (int) c2, (int) d2, width, list);
            } else {
                float f4 = dVar.getRevealInfo().f13275c;
                Animator a2 = com.google.android.material.c.a.a(dVar, c2, d2, width);
                int i = (int) c2;
                int i2 = (int) d2;
                View view5 = view2;
                a(view5, b2.a(), i, i2, f4, list);
                long a3 = b2.a();
                long b3 = b2.b();
                long a4 = aVar2.f13561a.a();
                a(view5, a3, b3, a4, i, i2, width, list);
                animator = a2;
            }
            b2.a(animator);
            list.add(animator);
            list2.add(com.google.android.material.c.a.a(dVar));
        }
    }

    private void c(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        if (view2 instanceof d) {
            d dVar = (d) view2;
            int c2 = c(view);
            int i = 16777215 & c2;
            if (z) {
                if (!z2) {
                    dVar.setCircularRevealScrimColor(c2);
                }
                objectAnimator = ObjectAnimator.ofInt(dVar, d.c.f13272a, new int[]{i});
            } else {
                objectAnimator = ObjectAnimator.ofInt(dVar, d.c.f13272a, new int[]{c2});
            }
            objectAnimator.setEvaluator(c.a());
            aVar.f13561a.b(ViewProps.COLOR).a((Animator) objectAnimator);
            list.add(objectAnimator);
        }
    }

    private void d(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        if (view2 instanceof ViewGroup) {
            if (!(view2 instanceof d) || com.google.android.material.c.c.f13262a != 0) {
                ViewGroup a2 = a(view2);
                if (a2 != null) {
                    if (z) {
                        if (!z2) {
                            com.google.android.material.a.d.f13104a.set(a2, Float.valueOf(BitmapDescriptorFactory.HUE_RED));
                        }
                        objectAnimator = ObjectAnimator.ofFloat(a2, com.google.android.material.a.d.f13104a, new float[]{1.0f});
                    } else {
                        objectAnimator = ObjectAnimator.ofFloat(a2, com.google.android.material.a.d.f13104a, new float[]{0.0f});
                    }
                    aVar.f13561a.b("contentFade").a((Animator) objectAnimator);
                    list.add(objectAnimator);
                }
            }
        }
    }

    private float a(View view, View view2, j jVar) {
        float f2;
        float f3;
        float f4;
        RectF rectF = this.f13547b;
        RectF rectF2 = this.f13548c;
        a(view, rectF);
        a(view2, rectF2);
        int i = jVar.f13117a & 7;
        if (i == 1) {
            f4 = rectF2.centerX();
            f3 = rectF.centerX();
        } else if (i == 3) {
            f4 = rectF2.left;
            f3 = rectF.left;
        } else if (i != 5) {
            f2 = BitmapDescriptorFactory.HUE_RED;
            return f2 + jVar.f13118b;
        } else {
            f4 = rectF2.right;
            f3 = rectF.right;
        }
        f2 = f4 - f3;
        return f2 + jVar.f13118b;
    }

    private float b(View view, View view2, j jVar) {
        float f2;
        float f3;
        float f4;
        RectF rectF = this.f13547b;
        RectF rectF2 = this.f13548c;
        a(view, rectF);
        a(view2, rectF2);
        int i = jVar.f13117a & 112;
        if (i == 16) {
            f4 = rectF2.centerY();
            f3 = rectF.centerY();
        } else if (i == 48) {
            f4 = rectF2.top;
            f3 = rectF.top;
        } else if (i != 80) {
            f2 = BitmapDescriptorFactory.HUE_RED;
            return f2 + jVar.f13119c;
        } else {
            f4 = rectF2.bottom;
            f3 = rectF.bottom;
        }
        f2 = f4 - f3;
        return f2 + jVar.f13119c;
    }

    private void a(View view, RectF rectF) {
        rectF.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) view.getWidth(), (float) view.getHeight());
        int[] iArr = this.f13549d;
        view.getLocationInWindow(iArr);
        rectF.offsetTo((float) iArr[0], (float) iArr[1]);
        rectF.offset((float) ((int) (-view.getTranslationX())), (float) ((int) (-view.getTranslationY())));
    }

    private float c(View view, View view2, j jVar) {
        RectF rectF = this.f13547b;
        RectF rectF2 = this.f13548c;
        a(view, rectF);
        a(view2, rectF2);
        rectF2.offset(-a(view, view2, jVar), BitmapDescriptorFactory.HUE_RED);
        return rectF.centerX() - rectF2.left;
    }

    private float d(View view, View view2, j jVar) {
        RectF rectF = this.f13547b;
        RectF rectF2 = this.f13548c;
        a(view, rectF);
        a(view2, rectF2);
        rectF2.offset(BitmapDescriptorFactory.HUE_RED, -b(view, view2, jVar));
        return rectF.centerY() - rectF2.top;
    }

    private void a(View view, a aVar, i iVar, i iVar2, float f2, float f3, float f4, float f5, RectF rectF) {
        float a2 = a(aVar, iVar, f2, f4);
        float a3 = a(aVar, iVar2, f3, f5);
        Rect rect = this.f13546a;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f13547b;
        rectF2.set(rect);
        RectF rectF3 = this.f13548c;
        a(view, rectF3);
        rectF3.offset(a2, a3);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private float a(a aVar, i iVar, float f2, float f3) {
        long a2 = iVar.a();
        long b2 = iVar.b();
        i b3 = aVar.f13561a.b("expansion");
        return com.google.android.material.a.a.a(f2, f3, iVar.c().getInterpolation(((float) (((b3.a() + b3.b()) + 17) - a2)) / ((float) b2)));
    }

    private ViewGroup a(View view) {
        View findViewById = view.findViewById(a.f.mtrl_child_content_container);
        if (findViewById != null) {
            return b(findViewById);
        }
        if ((view instanceof b) || (view instanceof a)) {
            return b(((ViewGroup) view).getChildAt(0));
        }
        return b(view);
    }

    private ViewGroup b(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    private int c(View view) {
        ColorStateList w = w.w(view);
        if (w != null) {
            return w.getColorForState(view.getDrawableState(), w.getDefaultColor());
        }
        return 0;
    }

    private void a(View view, long j, int i, int i2, float f2, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21 && j > 0) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f2, f2);
            createCircularReveal.setStartDelay(0);
            createCircularReveal.setDuration(j);
            list.add(createCircularReveal);
        }
    }

    private void a(View view, long j, long j2, long j3, int i, int i2, float f2, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21) {
            long j4 = j + j2;
            if (j4 < j3) {
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f2, f2);
                createCircularReveal.setStartDelay(j4);
                createCircularReveal.setDuration(j3 - j4);
                list.add(createCircularReveal);
            }
        }
    }

    protected static class a {

        /* renamed from: a  reason: collision with root package name */
        public h f13561a;

        /* renamed from: b  reason: collision with root package name */
        public j f13562b;

        protected a() {
        }
    }
}
