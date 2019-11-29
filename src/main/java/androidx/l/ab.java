package androidx.l;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.g.w;
import java.lang.reflect.Method;
import java.util.ArrayList;

class ab implements ad {

    /* renamed from: a  reason: collision with root package name */
    protected a f2412a;

    ab(Context context, ViewGroup viewGroup, View view) {
        this.f2412a = new a(context, viewGroup, view, this);
    }

    static ViewGroup c(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof ViewGroup)) {
                return (ViewGroup) view;
            }
            if (view.getParent() instanceof ViewGroup) {
                view = (ViewGroup) view.getParent();
            }
        }
        return null;
    }

    static ab d(View view) {
        ViewGroup c2 = c(view);
        if (c2 == null) {
            return null;
        }
        int childCount = c2.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = c2.getChildAt(i);
            if (childAt instanceof a) {
                return ((a) childAt).f2417e;
            }
        }
        return new v(c2.getContext(), c2, view);
    }

    public void a(Drawable drawable) {
        this.f2412a.a(drawable);
    }

    public void b(Drawable drawable) {
        this.f2412a.b(drawable);
    }

    static class a extends ViewGroup {

        /* renamed from: a  reason: collision with root package name */
        static Method f2413a;

        /* renamed from: b  reason: collision with root package name */
        ViewGroup f2414b;

        /* renamed from: c  reason: collision with root package name */
        View f2415c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<Drawable> f2416d = null;

        /* renamed from: e  reason: collision with root package name */
        ab f2417e;

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        static {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                f2413a = cls.getDeclaredMethod("invalidateChildInParentFast", new Class[]{Integer.TYPE, Integer.TYPE, Rect.class});
            } catch (NoSuchMethodException unused) {
            }
        }

        a(Context context, ViewGroup viewGroup, View view, ab abVar) {
            super(context);
            this.f2414b = viewGroup;
            this.f2415c = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f2417e = abVar;
        }

        public void a(Drawable drawable) {
            if (this.f2416d == null) {
                this.f2416d = new ArrayList<>();
            }
            if (!this.f2416d.contains(drawable)) {
                this.f2416d.add(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(this);
            }
        }

        public void b(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.f2416d;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback((Drawable.Callback) null);
            }
        }

        /* access modifiers changed from: protected */
        public boolean verifyDrawable(Drawable drawable) {
            if (!super.verifyDrawable(drawable)) {
                ArrayList<Drawable> arrayList = this.f2416d;
                if (arrayList == null || !arrayList.contains(drawable)) {
                    return false;
                }
            }
            return true;
        }

        public void a(View view) {
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (!(viewGroup == this.f2414b || viewGroup.getParent() == null || !w.D(viewGroup))) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f2414b.getLocationOnScreen(iArr2);
                    w.i(view, iArr[0] - iArr2[0]);
                    w.h(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view, getChildCount() - 1);
        }

        public void b(View view) {
            super.removeView(view);
            if (a()) {
                this.f2414b.removeView(this);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.f2416d;
                if (arrayList == null || arrayList.size() == 0) {
                    return true;
                }
            }
            return false;
        }

        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        /* access modifiers changed from: protected */
        public void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.f2414b.getLocationOnScreen(iArr);
            this.f2415c.getLocationOnScreen(iArr2);
            canvas.translate((float) (iArr2[0] - iArr[0]), (float) (iArr2[1] - iArr[1]));
            canvas.clipRect(new Rect(0, 0, this.f2415c.getWidth(), this.f2415c.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.f2416d;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i = 0; i < size; i++) {
                this.f2416d.get(i).draw(canvas);
            }
        }

        private void a(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f2414b.getLocationOnScreen(iArr2);
            this.f2415c.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f2414b == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            if (this.f2414b instanceof ViewGroup) {
                iArr[0] = 0;
                iArr[1] = 0;
                int[] iArr2 = new int[2];
                a(iArr2);
                rect.offset(iArr2[0], iArr2[1]);
                return super.invalidateChildInParent(iArr, rect);
            }
            invalidate(rect);
            return null;
        }
    }
}
