package androidx.l;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.g.w;
import androidx.l.n;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Map;

public class c extends n {
    private static final String[] h = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> i = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") {

        /* renamed from: a  reason: collision with root package name */
        private Rect f2451a = new Rect();

        /* renamed from: a */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f2451a);
            this.f2451a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f2451a);
        }

        /* renamed from: a */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f2451a);
            return new PointF((float) this.f2451a.left, (float) this.f2451a.top);
        }
    };
    private static final Property<a, PointF> j = new Property<a, PointF>(PointF.class, "topLeft") {
        /* renamed from: a */
        public PointF get(a aVar) {
            return null;
        }

        /* renamed from: a */
        public void set(a aVar, PointF pointF) {
            aVar.a(pointF);
        }
    };
    private static final Property<a, PointF> k = new Property<a, PointF>(PointF.class, "bottomRight") {
        /* renamed from: a */
        public PointF get(a aVar) {
            return null;
        }

        /* renamed from: a */
        public void set(a aVar, PointF pointF) {
            aVar.b(pointF);
        }
    };
    private static final Property<View, PointF> l = new Property<View, PointF>(PointF.class, "bottomRight") {
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: a */
        public void set(View view, PointF pointF) {
            ae.a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    };
    private static final Property<View, PointF> m = new Property<View, PointF>(PointF.class, "topLeft") {
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: a */
        public void set(View view, PointF pointF) {
            ae.a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    };
    private static final Property<View, PointF> n = new Property<View, PointF>(PointF.class, ViewProps.POSITION) {
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: a */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            ae.a(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    };
    private static l r = new l();
    private int[] o = new int[2];
    private boolean p = false;
    private boolean q = false;

    public String[] a() {
        return h;
    }

    private void d(t tVar) {
        View view = tVar.f2534b;
        if (w.A(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            tVar.f2533a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            tVar.f2533a.put("android:changeBounds:parent", tVar.f2534b.getParent());
            if (this.q) {
                tVar.f2534b.getLocationInWindow(this.o);
                tVar.f2533a.put("android:changeBounds:windowX", Integer.valueOf(this.o[0]));
                tVar.f2533a.put("android:changeBounds:windowY", Integer.valueOf(this.o[1]));
            }
            if (this.p) {
                tVar.f2533a.put("android:changeBounds:clip", w.C(view));
            }
        }
    }

    public void a(t tVar) {
        d(tVar);
    }

    public void b(t tVar) {
        d(tVar);
    }

    private boolean a(View view, View view2) {
        if (!this.q) {
            return true;
        }
        t b2 = b(view, true);
        if (b2 == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == b2.f2534b) {
            return true;
        }
        return false;
    }

    public Animator a(ViewGroup viewGroup, t tVar, t tVar2) {
        int i2;
        View view;
        Animator animator;
        ObjectAnimator objectAnimator;
        int i3;
        Rect rect;
        ObjectAnimator objectAnimator2;
        t tVar3 = tVar;
        t tVar4 = tVar2;
        if (tVar3 == null || tVar4 == null) {
            return null;
        }
        Map<String, Object> map = tVar3.f2533a;
        Map<String, Object> map2 = tVar4.f2533a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = tVar4.f2534b;
        if (a(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) tVar3.f2533a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) tVar4.f2533a.get("android:changeBounds:bounds");
            int i4 = rect2.left;
            int i5 = rect3.left;
            int i6 = rect2.top;
            int i7 = rect3.top;
            int i8 = rect2.right;
            int i9 = rect3.right;
            int i10 = rect2.bottom;
            int i11 = rect3.bottom;
            int i12 = i8 - i4;
            int i13 = i10 - i6;
            int i14 = i9 - i5;
            int i15 = i11 - i7;
            View view3 = view2;
            Rect rect4 = (Rect) tVar3.f2533a.get("android:changeBounds:clip");
            Rect rect5 = (Rect) tVar4.f2533a.get("android:changeBounds:clip");
            if ((i12 == 0 || i13 == 0) && (i14 == 0 || i15 == 0)) {
                i2 = 0;
            } else {
                i2 = (i4 == i5 && i6 == i7) ? 0 : 1;
                if (!(i8 == i9 && i10 == i11)) {
                    i2++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i2++;
            }
            if (i2 <= 0) {
                return null;
            }
            Rect rect6 = rect5;
            Rect rect7 = rect4;
            if (!this.p) {
                view = view3;
                ae.a(view, i4, i6, i8, i10);
                if (i2 == 2) {
                    if (i12 == i14 && i13 == i15) {
                        animator = g.a(view, n, l().a((float) i4, (float) i6, (float) i5, (float) i7));
                    } else {
                        final a aVar = new a(view);
                        ObjectAnimator a2 = g.a(aVar, j, l().a((float) i4, (float) i6, (float) i5, (float) i7));
                        ObjectAnimator a3 = g.a(aVar, k, l().a((float) i8, (float) i10, (float) i9, (float) i11));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(new Animator[]{a2, a3});
                        animatorSet.addListener(new AnimatorListenerAdapter() {
                            private a mViewBounds = aVar;
                        });
                        animator = animatorSet;
                    }
                } else if (i4 == i5 && i6 == i7) {
                    animator = g.a(view, l, l().a((float) i8, (float) i10, (float) i9, (float) i11));
                } else {
                    animator = g.a(view, m, l().a((float) i4, (float) i6, (float) i5, (float) i7));
                }
            } else {
                view = view3;
                ae.a(view, i4, i6, Math.max(i12, i14) + i4, Math.max(i13, i15) + i6);
                if (i4 == i5 && i6 == i7) {
                    objectAnimator = null;
                } else {
                    objectAnimator = g.a(view, n, l().a((float) i4, (float) i6, (float) i5, (float) i7));
                }
                if (rect7 == null) {
                    i3 = 0;
                    rect = new Rect(0, 0, i12, i13);
                } else {
                    i3 = 0;
                    rect = rect7;
                }
                Rect rect8 = rect6 == null ? new Rect(i3, i3, i14, i15) : rect6;
                if (!rect.equals(rect8)) {
                    w.a(view, rect);
                    l lVar = r;
                    Object[] objArr = new Object[2];
                    objArr[i3] = rect;
                    objArr[1] = rect8;
                    objectAnimator2 = ObjectAnimator.ofObject(view, "clipBounds", lVar, objArr);
                    final View view4 = view;
                    final Rect rect9 = rect6;
                    final int i16 = i5;
                    final int i17 = i7;
                    final int i18 = i9;
                    final int i19 = i11;
                    objectAnimator2.addListener(new AnimatorListenerAdapter() {
                        private boolean h;

                        public void onAnimationCancel(Animator animator) {
                            this.h = true;
                        }

                        public void onAnimationEnd(Animator animator) {
                            if (!this.h) {
                                w.a(view4, rect9);
                                ae.a(view4, i16, i17, i18, i19);
                            }
                        }
                    });
                } else {
                    objectAnimator2 = null;
                }
                animator = s.a(objectAnimator, objectAnimator2);
            }
            if (view.getParent() instanceof ViewGroup) {
                final ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                y.a(viewGroup4, true);
                a((n.c) new o() {

                    /* renamed from: a  reason: collision with root package name */
                    boolean f2452a = false;

                    public void a(n nVar) {
                        if (!this.f2452a) {
                            y.a(viewGroup4, false);
                        }
                        nVar.b((n.c) this);
                    }

                    public void b(n nVar) {
                        y.a(viewGroup4, false);
                    }

                    public void c(n nVar) {
                        y.a(viewGroup4, true);
                    }
                });
            }
            return animator;
        }
        int intValue = ((Integer) tVar3.f2533a.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) tVar3.f2533a.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) tVar4.f2533a.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) tVar4.f2533a.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.o);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float c2 = ae.c(view2);
        ae.a(view2, (float) BitmapDescriptorFactory.HUE_RED);
        ae.a(viewGroup).a(bitmapDrawable);
        h l2 = l();
        int[] iArr = this.o;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, new PropertyValuesHolder[]{j.a(i, l2.a((float) (intValue - iArr[0]), (float) (intValue2 - iArr[1]), (float) (intValue3 - iArr[0]), (float) (intValue4 - iArr[1])))});
        final ViewGroup viewGroup5 = viewGroup;
        final BitmapDrawable bitmapDrawable2 = bitmapDrawable;
        final View view5 = view2;
        final float f2 = c2;
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                ae.a(viewGroup5).b(bitmapDrawable2);
                ae.a(view5, f2);
            }
        });
        return ofPropertyValuesHolder;
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f2469a;

        /* renamed from: b  reason: collision with root package name */
        private int f2470b;

        /* renamed from: c  reason: collision with root package name */
        private int f2471c;

        /* renamed from: d  reason: collision with root package name */
        private int f2472d;

        /* renamed from: e  reason: collision with root package name */
        private View f2473e;

        /* renamed from: f  reason: collision with root package name */
        private int f2474f;

        /* renamed from: g  reason: collision with root package name */
        private int f2475g;

        a(View view) {
            this.f2473e = view;
        }

        /* access modifiers changed from: package-private */
        public void a(PointF pointF) {
            this.f2469a = Math.round(pointF.x);
            this.f2470b = Math.round(pointF.y);
            this.f2474f++;
            if (this.f2474f == this.f2475g) {
                a();
            }
        }

        /* access modifiers changed from: package-private */
        public void b(PointF pointF) {
            this.f2471c = Math.round(pointF.x);
            this.f2472d = Math.round(pointF.y);
            this.f2475g++;
            if (this.f2474f == this.f2475g) {
                a();
            }
        }

        private void a() {
            ae.a(this.f2473e, this.f2469a, this.f2470b, this.f2471c, this.f2472d);
            this.f2474f = 0;
            this.f2475g = 0;
        }
    }
}
