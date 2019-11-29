package com.shopee.feeds.feedlibrary.editor.multitouch;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.editor.multitouch.b;
import com.shopee.feeds.feedlibrary.util.h;
import com.shopee.feeds.feedlibrary.util.j;
import com.shopee.feeds.feedlibrary.util.l;

public class a implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public static float f27938a = 0.1f;
    private float A = 1.0f;
    private float B = BitmapDescriptorFactory.HUE_RED;
    private float C = -2.14748365E9f;
    private float D = -2.14748365E9f;
    private b E = null;
    private com.shopee.feeds.feedlibrary.editor.b.c F;
    private int G = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f27939b = false;

    /* renamed from: c  reason: collision with root package name */
    private final GestureDetector f27940c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f27941d = true;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f27942e = true;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f27943f = true;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public float f27944g = 10.0f;
    private int h = -1;
    private float i;
    private float j;
    private b k;
    private int[] l = new int[2];
    private Rect m;
    private View n;
    private View o;
    private boolean p = false;
    private boolean q = true;
    /* access modifiers changed from: private */
    public c r;
    /* access modifiers changed from: private */
    public boolean s;
    private boolean t;
    /* access modifiers changed from: private */
    public float u;
    /* access modifiers changed from: private */
    public float v;
    /* access modifiers changed from: private */
    public boolean w = false;
    private AnimatorSet x = new AnimatorSet();
    private AnimatorSet y = new AnimatorSet();
    private boolean z = false;

    public interface b {
        void a(com.shopee.feeds.feedlibrary.editor.b.c cVar);
    }

    public interface c {
        void a();

        void a(int i, int i2, float f2, float f3);

        void a(View view);
    }

    private static float a(float f2) {
        return f2 > 180.0f ? f2 - 360.0f : f2 < -180.0f ? f2 + 360.0f : f2;
    }

    private void a() {
    }

    public a(View view, View view2, boolean z2) {
        this.s = z2;
        this.k = new b(new d());
        this.f27940c = new GestureDetector(new C0430a());
        this.n = view;
        this.o = view2;
        if (view2 != null) {
            this.m = new Rect(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
        } else {
            this.m = new Rect(0, 0, 0, 0);
        }
    }

    public void a(boolean z2) {
        this.q = z2;
    }

    public void b(boolean z2) {
        this.p = z2;
    }

    /* access modifiers changed from: private */
    public void a(View view, e eVar) {
        b(view, eVar.f27958e, eVar.f27959f);
        float max = Math.max(eVar.f27960g, Math.min(eVar.h, view.getScaleX() * eVar.f27956c));
        view.setScaleX(max);
        view.setScaleY(max);
        float a2 = a(view.getRotation() + eVar.f27957d);
        view.setRotation(a2);
        h.b("", "move it " + a2 + "," + max + "," + eVar.f27959f + "," + eVar.f27958e);
        if (a(view, max, a2)) {
            float f2 = this.D;
            if (f2 != -2.14748365E9f) {
                b(view, this.C, f2);
            }
            view.setScaleX(this.A);
            view.setScaleY(this.A);
            b(this.A);
            view.setRotation(this.B);
            h.b("s", "inViewInvisible move " + this.A + "," + this.B + "," + view.getX() + "," + view.getTranslationX() + "," + view.getY());
            b(view);
            return;
        }
        this.C = eVar.f27958e;
        this.D = eVar.f27959f;
        this.u = max;
        this.v = max;
        this.A = max;
        this.B = a2;
        a(view, eVar.f27954a, eVar.f27955b, false);
    }

    private void a(View view, float f2, float f3, boolean z2) {
        float[] fArr = {f2, f3};
        view.getMatrix().mapVectors(fArr);
        view.setTranslationX(view.getTranslationX() + fArr[0]);
        view.setTranslationY(view.getTranslationY() + fArr[1]);
        h.b("", "adjustTranslation is " + z2 + "," + this.A + "," + this.B);
        if (a(view, this.A, this.B)) {
            view.setTranslationX(view.getTranslationX() - fArr[0]);
            if (a(view, this.A, this.B)) {
                view.setTranslationX(view.getTranslationX() + fArr[0]);
                view.setTranslationY(view.getTranslationY() - fArr[1]);
                if (a(view, this.A, this.B)) {
                    view.setTranslationY(view.getTranslationY() + fArr[1]);
                    view.setTranslationX(view.getTranslationX() - fArr[0]);
                    view.setTranslationY(view.getTranslationY() - fArr[1]);
                    b(view);
                    return;
                }
            }
        }
        if (this.r != null) {
            float rotation = view.getRotation();
            if (rotation < BitmapDescriptorFactory.HUE_RED) {
                rotation += 360.0f;
            }
            if (this.z) {
                a(view);
            }
            this.r.a(((int) view.getX()) + (view.getMeasuredWidth() / 2), ((int) view.getY()) + (view.getMeasuredHeight() / 2), view.getScaleX(), rotation);
            h.b("%s", "logdb1 " + view.getX() + "," + view.getMeasuredWidth());
        }
    }

    private void b(float f2) {
        this.v = f2;
        this.u = f2;
        this.A = f2;
    }

    private void b(View view, float f2, float f3, boolean z2) {
        float[] fArr = {f2, f3};
        view.setTranslationX(view.getTranslationX() + fArr[0]);
        view.setTranslationY(view.getTranslationY() + fArr[1]);
        if (a(view, this.A, this.B)) {
            view.setTranslationX(view.getTranslationX() - fArr[0]);
            if (a(view, this.A, this.B)) {
                view.setTranslationX(view.getTranslationX() + fArr[0]);
                view.setTranslationY(view.getTranslationY() - fArr[1]);
                if (a(view, this.A, this.B)) {
                    view.setTranslationY(view.getTranslationY() + fArr[1]);
                    view.setTranslationX(view.getTranslationX() - fArr[0]);
                    view.setTranslationY(view.getTranslationY() - fArr[1]);
                    b(view);
                    return;
                }
            }
        }
        if (this.r != null) {
            float rotation = view.getRotation();
            if (rotation < BitmapDescriptorFactory.HUE_RED) {
                rotation += 360.0f;
            }
            if (this.z) {
                a(view);
            }
            this.r.a(((int) view.getX()) + (view.getMeasuredWidth() / 2), ((int) view.getY()) + (view.getMeasuredHeight() / 2), view.getScaleX(), rotation);
            h.b("%s", "logdb2 " + view.getX() + "," + view.getMeasuredWidth());
        }
    }

    private void a(View view) {
        if (l.a(40, view.getContext()) >= ((int) (((float) Math.min((view.getHeight() - view.getPaddingBottom()) - view.getPaddingTop(), (view.getWidth() - view.getPaddingLeft()) - view.getPaddingRight())) * view.getScaleX()))) {
            l.a(20, view.getContext());
        }
    }

    private void b(View view, float f2, float f3) {
        if (view.getPivotX() != f2 || view.getPivotY() != f3) {
            float[] fArr = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};
            view.getMatrix().mapPoints(fArr);
            view.setPivotX(f2);
            view.setPivotY(f3);
            float[] fArr2 = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};
            view.getMatrix().mapPoints(fArr2);
            float f4 = fArr2[0] - fArr[0];
            float f5 = fArr2[1] - fArr[1];
            view.setTranslationX(view.getTranslationX() - f4);
            view.setTranslationY(view.getTranslationY() - f5);
        }
    }

    public void c(boolean z2) {
        this.z = z2;
    }

    public void a(b bVar) {
        this.E = bVar;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.k.a(view, motionEvent);
        this.f27940c.onTouchEvent(motionEvent);
        if (!this.f27942e) {
            return true;
        }
        int action = motionEvent.getAction();
        int i2 = 0;
        if ((motionEvent.getActionMasked() & action) == 0) {
            com.shopee.feeds.feedlibrary.editor.b.c cVar = (com.shopee.feeds.feedlibrary.editor.b.c) view;
            if (j.a().g(cVar.getViewId())) {
                return false;
            }
            j.a().a(cVar.getViewId(), true);
        }
        b bVar = this.E;
        if (bVar != null) {
            bVar.a((com.shopee.feeds.feedlibrary.editor.b.c) view);
        }
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int actionMasked = motionEvent.getActionMasked() & action;
        if (actionMasked == 0) {
            this.t = false;
            this.i = motionEvent.getX();
            this.j = motionEvent.getY();
            this.h = motionEvent.getPointerId(0);
            View view2 = this.o;
            if (view2 != null && this.q) {
                view2.setVisibility(0);
                boolean a2 = a(this.o, rawX, rawY);
                ImageView imageView = (ImageView) ((ViewGroup) this.o).getChildAt(0);
                imageView.setBackground(com.garena.android.appkit.tools.b.f(a2 ? c.d.feeds_bg_photo_editor_delete_ring_active : c.d.feeds_bg_photo_editor_delete_ring));
                imageView.setImageDrawable(com.garena.android.appkit.tools.b.f(a2 ? c.d.feeds_ic_photo_editor_delete_active : c.d.feeds_ic_photo_editor_delete));
                float f2 = 1.5f;
                imageView.setScaleX(a2 ? 1.5f : 1.0f);
                if (!a2) {
                    f2 = 1.0f;
                }
                imageView.setScaleY(f2);
            }
        } else if (actionMasked == 1) {
            this.h = -1;
            if (this.o != null && Build.VERSION.SDK_INT >= 23 && this.q) {
                ((ViewGroup) this.o).getChildAt(0).setForeground((Drawable) null);
            }
            View view3 = this.o;
            if (view3 != null && this.q) {
                if (a(view3, rawX, rawY)) {
                    c cVar2 = this.r;
                    if (cVar2 != null) {
                        cVar2.a(view);
                    }
                } else {
                    a(this.n, rawX, rawY);
                }
                this.o.setVisibility(8);
            }
            a();
            j.a().a(((com.shopee.feeds.feedlibrary.editor.b.c) view).getViewId(), false);
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                this.h = -1;
                View view4 = this.o;
                if (view4 != null && this.q) {
                    view4.setVisibility(8);
                }
                a();
                j.a().a(((com.shopee.feeds.feedlibrary.editor.b.c) view).getViewId(), false);
            } else if (actionMasked == 6) {
                int i3 = (65280 & action) >> 8;
                if (motionEvent.getPointerId(i3) == this.h) {
                    if (i3 == 0) {
                        i2 = 1;
                    }
                    this.i = motionEvent.getX(i2);
                    this.j = motionEvent.getY(i2);
                    this.h = motionEvent.getPointerId(i2);
                }
            }
        } else if (!this.t) {
            if (!a(this.n, rawX, rawY)) {
                this.t = true;
            }
            int findPointerIndex = motionEvent.findPointerIndex(this.h);
            if (findPointerIndex != -1) {
                float x2 = motionEvent.getX(findPointerIndex);
                float y2 = motionEvent.getY(findPointerIndex);
                if (!this.k.a()) {
                    a(view, x2 - this.i, y2 - this.j, true);
                }
            }
            View view5 = this.o;
            if (view5 != null && this.q) {
                boolean a3 = a(view5, rawX, rawY);
                ImageView imageView2 = (ImageView) ((ViewGroup) this.o).getChildAt(0);
                imageView2.setBackground(com.garena.android.appkit.tools.b.f(a3 ? c.d.feeds_bg_photo_editor_delete_ring_active : c.d.feeds_bg_photo_editor_delete_ring));
                imageView2.setImageDrawable(com.garena.android.appkit.tools.b.f(a3 ? c.d.feeds_ic_photo_editor_delete_active : c.d.feeds_ic_photo_editor_delete));
                if (!a3 && this.w) {
                    this.x.cancel();
                    this.w = false;
                }
                if (a3 && !this.x.isRunning() && !this.w) {
                    Log.d("move>>", " start mAnimatorSet");
                    a((View) imageView2, a3);
                    c(view);
                } else if (!a3 && view != null && view.getScaleX() < this.u && !this.y.isRunning() && !this.w) {
                    Log.d("move>>", " start animatorSet2>>");
                    c(view, this.u, this.v);
                    a((View) imageView2, a3);
                }
            }
        }
        return true;
    }

    private boolean a(View view, int i2, int i3) {
        view.getDrawingRect(this.m);
        view.getLocationOnScreen(this.l);
        Rect rect = this.m;
        int[] iArr = this.l;
        rect.offset(iArr[0], iArr[1]);
        return this.m.contains(i2, i3);
    }

    /* access modifiers changed from: protected */
    public boolean a(View view, float f2, float f3) {
        if (!this.p) {
            return false;
        }
        Rect rect = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
        view.getWidth();
        view.getHeight();
        int width = (int) (((float) view.getWidth()) * f2);
        int height = (int) (((float) view.getHeight()) * f2);
        int width2 = rect.width();
        int height2 = rect.height();
        if (f3 < BitmapDescriptorFactory.HUE_RED) {
            f3 += 360.0f;
        }
        double d2 = (double) f3;
        float abs = Math.abs((float) Math.sin(Math.toRadians(d2)));
        float abs2 = Math.abs((float) Math.cos(Math.toRadians(d2)));
        if (globalVisibleRect) {
            float f4 = (float) height;
            float f5 = (float) width;
            int i2 = (int) ((f4 * abs) + (f5 * abs2));
            int i3 = (int) ((f4 * abs2) + (f5 * abs));
            h.b("%s", "isViewCover db " + width2 + "," + height2 + ";;;;" + i2 + "," + i3 + ",sc" + f2 + "rata" + f3 + ",sin " + abs + " ...." + abs2);
            if (width2 >= i2 && height2 >= i3) {
                h.b("%s", "isViewCover  false");
                return !globalVisibleRect;
            }
        }
        return true;
    }

    public void a(c cVar) {
        this.r = cVar;
    }

    private class d extends b.C0431b {

        /* renamed from: b  reason: collision with root package name */
        private float f27951b;

        /* renamed from: c  reason: collision with root package name */
        private float f27952c;

        /* renamed from: d  reason: collision with root package name */
        private Vector2D f27953d;

        private d() {
            this.f27953d = new Vector2D();
        }

        public boolean a(View view, b bVar) {
            this.f27951b = bVar.b();
            this.f27952c = bVar.c();
            this.f27953d.set(bVar.d());
            return a.this.s;
        }

        public boolean b(View view, b bVar) {
            e eVar = new e();
            eVar.f27956c = a.this.f27943f ? bVar.e() : 1.0f;
            boolean c2 = a.this.f27941d;
            float f2 = BitmapDescriptorFactory.HUE_RED;
            eVar.f27957d = c2 ? Vector2D.a(this.f27953d, bVar.d()) : BitmapDescriptorFactory.HUE_RED;
            eVar.f27954a = a.this.f27942e ? bVar.b() - this.f27951b : BitmapDescriptorFactory.HUE_RED;
            if (a.this.f27942e) {
                f2 = bVar.c() - this.f27952c;
            }
            eVar.f27955b = f2;
            eVar.f27958e = view.getPivotX();
            eVar.f27959f = view.getPivotY();
            eVar.f27960g = a.f27938a;
            eVar.h = a.this.f27944g;
            a.this.a(view, eVar);
            return !a.this.s;
        }
    }

    public void a(com.shopee.feeds.feedlibrary.editor.b.c cVar) {
        this.F = cVar;
        if (this.F instanceof com.shopee.feeds.feedlibrary.editor.sticker.a) {
            this.B = 6.0f;
        }
    }

    public void a(float f2, float f3) {
        if (!this.p) {
            this.G++;
            if (this.G % 2 != 0) {
                f2 = f2 > 1.0f ? ((f2 - 1.0f) * 0.2f) + 1.0f : 1.0f - ((1.0f - f2) * 0.2f);
            } else {
                return;
            }
        }
        float f4 = f27938a;
        float max = Math.max(f27938a, this.F.getScaleX() * f2);
        this.F.setScaleX(max);
        this.F.setScaleY(max);
        float a2 = a(this.F.getRotation() + f3);
        h.b("%s", "ondb scale " + f2 + " ，" + f3 + "," + a2);
        this.F.setRotation(a2);
        if (a((View) this.F, max, a2)) {
            this.F.setScaleX(this.A);
            this.F.setScaleY(this.A);
            this.F.setRotation(this.B);
            h.b("%s", "ondb scale fail " + this.B + "," + this.A);
            b((View) this.F);
            return;
        }
        b(max);
        this.B = a2;
        if (this.r != null) {
            float rotation = this.F.getRotation();
            if (rotation < BitmapDescriptorFactory.HUE_RED) {
                rotation += 360.0f;
            }
            this.r.a(((int) this.F.getX()) + (this.F.getMeasuredWidth() / 2), ((int) this.F.getY()) + (this.F.getMeasuredHeight() / 2), this.F.getScaleX(), rotation);
            h.b("%s", "logdb3 " + this.F.getX() + "," + this.F.getMeasuredWidth());
        }
    }

    private void b(View view) {
        if (this.r != null) {
            float rotation = view.getRotation();
            if (rotation < BitmapDescriptorFactory.HUE_RED) {
                rotation += 360.0f;
            }
            this.r.a(((int) view.getX()) + (view.getMeasuredWidth() / 2), ((int) view.getY()) + (view.getMeasuredHeight() / 2), view.getScaleX(), rotation);
            h.b("%s", "logdb4 " + view.getX() + "," + view.getMeasuredWidth());
        }
    }

    public void a(float f2, float f3, float f4, float f5, Context context) {
        int[] iArr = new int[2];
        this.F.getLocationOnScreen(iArr);
        float sqrt = (float) Math.sqrt((double) (((f2 - ((float) iArr[0])) * (f2 - ((float) iArr[0]))) + ((f3 - ((float) iArr[1])) * (f3 - ((float) iArr[1])))));
        float min = Math.min(((float) this.F.getMeasuredWidth()) * this.F.getScaleX(), ((float) this.F.getMeasuredHeight()) * this.F.getScaleY());
        if (min < ((float) l.a(40, context)) && sqrt <= ((float) l.a(30, context))) {
            h.b("'%s", "outRangeMove " + sqrt + "," + min + "," + f4 + "," + f5);
            b(this.F, f4, f5, true);
        }
    }

    private class e {

        /* renamed from: a  reason: collision with root package name */
        float f27954a;

        /* renamed from: b  reason: collision with root package name */
        float f27955b;

        /* renamed from: c  reason: collision with root package name */
        float f27956c;

        /* renamed from: d  reason: collision with root package name */
        float f27957d;

        /* renamed from: e  reason: collision with root package name */
        float f27958e;

        /* renamed from: f  reason: collision with root package name */
        float f27959f;

        /* renamed from: g  reason: collision with root package name */
        float f27960g;
        float h;

        private e() {
        }
    }

    /* renamed from: com.shopee.feeds.feedlibrary.editor.multitouch.a$a  reason: collision with other inner class name */
    private final class C0430a extends GestureDetector.SimpleOnGestureListener {
        private C0430a() {
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (a.this.r == null) {
                return true;
            }
            a.this.r.a();
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
            super.onLongPress(motionEvent);
        }
    }

    private void c(View view, float f2, float f3) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.SCALE_X, new float[]{0.0f, f2});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, View.SCALE_Y, new float[]{0.0f, f3});
        ofFloat.setRepeatMode(-1);
        ofFloat2.setRepeatMode(-1);
        this.y.playTogether(new Animator[]{ofFloat, ofFloat2});
        this.y.setDuration(300);
        this.y.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                boolean unused = a.this.w = true;
            }
        });
        this.y.start();
    }

    private void c(final View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.SCALE_X, new float[]{view.getScaleX(), 0.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, View.SCALE_Y, new float[]{view.getScaleY(), 0.0f});
        ofFloat.setRepeatMode(-1);
        ofFloat2.setRepeatMode(-1);
        this.x.playTogether(new Animator[]{ofFloat, ofFloat2});
        this.x.setDuration(300);
        this.x.addListener(new Animator.AnimatorListener() {
            public void onAnimationEnd(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                float unused = a.this.u = view.getScaleX();
                float unused2 = a.this.v = view.getScaleY();
                boolean unused3 = a.this.w = true;
            }

            public void onAnimationCancel(Animator animator) {
                boolean unused = a.this.w = false;
            }
        });
        this.x.start();
    }

    private void a(View view, boolean z2) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        if (z2) {
            objectAnimator = ObjectAnimator.ofFloat(view, View.SCALE_X, new float[]{1.0f, 1.5f});
            objectAnimator2 = ObjectAnimator.ofFloat(view, View.SCALE_Y, new float[]{1.0f, 1.5f});
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view, View.SCALE_X, new float[]{1.5f, 1.0f});
            objectAnimator2 = ObjectAnimator.ofFloat(view, View.SCALE_Y, new float[]{1.5f, 1.0f});
        }
        objectAnimator.setRepeatMode(-1);
        objectAnimator2.setRepeatMode(-1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{objectAnimator, objectAnimator2});
        animatorSet.setDuration(300);
        animatorSet.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }
        });
        animatorSet.start();
    }
}
