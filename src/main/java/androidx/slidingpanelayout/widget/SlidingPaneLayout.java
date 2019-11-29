package androidx.slidingpanelayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.g.w;
import androidx.customview.view.AbsSavedState;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    View f2992a;

    /* renamed from: b  reason: collision with root package name */
    float f2993b;

    /* renamed from: c  reason: collision with root package name */
    int f2994c;

    /* renamed from: d  reason: collision with root package name */
    boolean f2995d;

    /* renamed from: e  reason: collision with root package name */
    final androidx.customview.a.a f2996e;

    /* renamed from: f  reason: collision with root package name */
    boolean f2997f;

    /* renamed from: g  reason: collision with root package name */
    final ArrayList<a> f2998g;
    private int h;
    private int i;
    private Drawable j;
    private Drawable k;
    private final int l;
    private boolean m;
    private float n;
    private int o;
    private float p;
    private float q;
    private c r;
    private boolean s;
    private final Rect t;
    private Method u;
    private Field v;
    private boolean w;

    public interface c {
    }

    public void setParallaxDistance(int i2) {
        this.o = i2;
        requestLayout();
    }

    public int getParallaxDistance() {
        return this.o;
    }

    public void setSliderFadeColor(int i2) {
        this.h = i2;
    }

    public int getSliderFadeColor() {
        return this.h;
    }

    public void setCoveredFadeColor(int i2) {
        this.i = i2;
    }

    public int getCoveredFadeColor() {
        return this.i;
    }

    public void setPanelSlideListener(c cVar) {
        this.r = cVar;
    }

    /* access modifiers changed from: package-private */
    public void a(View view) {
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z;
        int i6;
        View view2 = view;
        boolean f2 = f();
        int width = f2 ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = f2 ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !d(view)) {
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
        } else {
            i5 = view.getLeft();
            i4 = view.getRight();
            i3 = view.getTop();
            i2 = view.getBottom();
        }
        int childCount = getChildCount();
        int i7 = 0;
        while (i7 < childCount) {
            View childAt = getChildAt(i7);
            if (childAt != view2) {
                if (childAt.getVisibility() == 8) {
                    z = f2;
                } else {
                    int max = Math.max(f2 ? paddingLeft : width, childAt.getLeft());
                    int max2 = Math.max(paddingTop, childAt.getTop());
                    if (f2) {
                        z = f2;
                        i6 = width;
                    } else {
                        z = f2;
                        i6 = paddingLeft;
                    }
                    childAt.setVisibility((max < i5 || max2 < i3 || Math.min(i6, childAt.getRight()) > i4 || Math.min(height, childAt.getBottom()) > i2) ? 0 : 4);
                }
                i7++;
                view2 = view;
                f2 = z;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    private static boolean d(View view) {
        if (view.isOpaque()) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            return false;
        }
        Drawable background = view.getBackground();
        if (background == null || background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.s = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.s = true;
        int size = this.f2998g.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f2998g.get(i2).run();
        }
        this.f2998g.clear();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            } else if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
        } else if (mode2 == 0) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Height must not be UNSPECIFIED");
            } else if (mode2 == 0) {
                mode2 = RNCartPanelDataEntity.NULL_VALUE;
                size2 = 300;
            }
        }
        boolean z = false;
        if (mode2 == Integer.MIN_VALUE) {
            i4 = (size2 - getPaddingTop()) - getPaddingBottom();
            i5 = 0;
        } else if (mode2 != 1073741824) {
            i5 = 0;
            i4 = 0;
        } else {
            i5 = (size2 - getPaddingTop()) - getPaddingBottom();
            i4 = i5;
        }
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.f2992a = null;
        int i14 = i5;
        int i15 = paddingLeft;
        int i16 = 0;
        boolean z2 = false;
        float f2 = BitmapDescriptorFactory.HUE_RED;
        while (true) {
            i6 = 8;
            if (i16 >= childCount) {
                break;
            }
            View childAt = getChildAt(i16);
            b bVar = (b) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                bVar.f3005c = z;
            } else {
                if (bVar.f3003a > BitmapDescriptorFactory.HUE_RED) {
                    f2 += bVar.f3003a;
                    if (bVar.width == 0) {
                    }
                }
                int i17 = bVar.leftMargin + bVar.rightMargin;
                if (bVar.width == -2) {
                    i12 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i17, RNCartPanelDataEntity.NULL_VALUE);
                } else if (bVar.width == -1) {
                    i12 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i17, 1073741824);
                } else {
                    i12 = View.MeasureSpec.makeMeasureSpec(bVar.width, 1073741824);
                }
                if (bVar.height == -2) {
                    i13 = View.MeasureSpec.makeMeasureSpec(i4, RNCartPanelDataEntity.NULL_VALUE);
                } else if (bVar.height == -1) {
                    i13 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                } else {
                    i13 = View.MeasureSpec.makeMeasureSpec(bVar.height, 1073741824);
                }
                childAt.measure(i12, i13);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (mode2 == Integer.MIN_VALUE && measuredHeight > i14) {
                    i14 = Math.min(measuredHeight, i4);
                }
                i15 -= measuredWidth;
                boolean z3 = i15 < 0;
                bVar.f3004b = z3;
                boolean z4 = z3 | z2;
                if (bVar.f3004b) {
                    this.f2992a = childAt;
                }
                z2 = z4;
            }
            i16++;
            z = false;
        }
        if (z2 || f2 > BitmapDescriptorFactory.HUE_RED) {
            int i18 = paddingLeft - this.l;
            int i19 = 0;
            while (i19 < childCount) {
                View childAt2 = getChildAt(i19);
                if (childAt2.getVisibility() != i6) {
                    b bVar2 = (b) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != i6) {
                        boolean z5 = bVar2.width == 0 && bVar2.f3003a > BitmapDescriptorFactory.HUE_RED;
                        if (z5) {
                            i8 = 0;
                        } else {
                            i8 = childAt2.getMeasuredWidth();
                        }
                        if (!z2 || childAt2 == this.f2992a) {
                            if (bVar2.f3003a > BitmapDescriptorFactory.HUE_RED) {
                                if (bVar2.width != 0) {
                                    i9 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                } else if (bVar2.height == -2) {
                                    i9 = View.MeasureSpec.makeMeasureSpec(i4, RNCartPanelDataEntity.NULL_VALUE);
                                } else if (bVar2.height == -1) {
                                    i9 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                                } else {
                                    i9 = View.MeasureSpec.makeMeasureSpec(bVar2.height, 1073741824);
                                }
                                if (z2) {
                                    int i20 = paddingLeft - (bVar2.leftMargin + bVar2.rightMargin);
                                    i7 = i18;
                                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i20, 1073741824);
                                    if (i8 != i20) {
                                        childAt2.measure(makeMeasureSpec, i9);
                                    }
                                    i19++;
                                    i18 = i7;
                                    i6 = 8;
                                } else {
                                    i7 = i18;
                                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(i8 + ((int) ((bVar2.f3003a * ((float) Math.max(0, i15))) / f2)), 1073741824), i9);
                                    i19++;
                                    i18 = i7;
                                    i6 = 8;
                                }
                            }
                        } else if (bVar2.width < 0 && (i8 > i18 || bVar2.f3003a > BitmapDescriptorFactory.HUE_RED)) {
                            if (!z5) {
                                i10 = 1073741824;
                                i11 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            } else if (bVar2.height == -2) {
                                i11 = View.MeasureSpec.makeMeasureSpec(i4, RNCartPanelDataEntity.NULL_VALUE);
                                i10 = 1073741824;
                            } else if (bVar2.height == -1) {
                                i10 = 1073741824;
                                i11 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                            } else {
                                i10 = 1073741824;
                                i11 = View.MeasureSpec.makeMeasureSpec(bVar2.height, 1073741824);
                            }
                            childAt2.measure(View.MeasureSpec.makeMeasureSpec(i18, i10), i11);
                        }
                    }
                }
                i7 = i18;
                i19++;
                i18 = i7;
                i6 = 8;
            }
        }
        setMeasuredDimension(size, i14 + getPaddingTop() + getPaddingBottom());
        this.m = z2;
        if (this.f2996e.a() != 0 && !z2) {
            this.f2996e.f();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        boolean f2 = f();
        if (f2) {
            this.f2996e.a(2);
        } else {
            this.f2996e.a(1);
        }
        int i10 = i4 - i2;
        int paddingRight = f2 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = f2 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.s) {
            this.f2993b = (!this.m || !this.f2997f) ? BitmapDescriptorFactory.HUE_RED : 1.0f;
        }
        int i11 = paddingRight;
        int i12 = i11;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                b bVar = (b) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (bVar.f3004b) {
                    int i14 = i10 - paddingLeft;
                    int min = (Math.min(i11, i14 - this.l) - i12) - (bVar.leftMargin + bVar.rightMargin);
                    this.f2994c = min;
                    int i15 = f2 ? bVar.rightMargin : bVar.leftMargin;
                    bVar.f3005c = ((i12 + i15) + min) + (measuredWidth / 2) > i14;
                    int i16 = (int) (((float) min) * this.f2993b);
                    i7 = i15 + i16 + i12;
                    this.f2993b = ((float) i16) / ((float) this.f2994c);
                    i6 = 0;
                } else {
                    if (this.m) {
                        int i17 = this.o;
                        if (i17 != 0) {
                            i6 = (int) ((1.0f - this.f2993b) * ((float) i17));
                            i7 = i11;
                        }
                    }
                    i7 = i11;
                    i6 = 0;
                }
                if (f2) {
                    i8 = (i10 - i7) + i6;
                    i9 = i8 - measuredWidth;
                } else {
                    i9 = i7 - i6;
                    i8 = i9 + measuredWidth;
                }
                childAt.layout(i9, paddingTop, i8, childAt.getMeasuredHeight() + paddingTop);
                i11 += childAt.getWidth();
                i12 = i7;
            }
        }
        if (this.s) {
            if (this.m) {
                if (this.o != 0) {
                    a(this.f2993b);
                }
                if (((b) this.f2992a.getLayoutParams()).f3005c) {
                    a(this.f2992a, this.f2993b, this.h);
                }
            } else {
                for (int i18 = 0; i18 < childCount; i18++) {
                    a(getChildAt(i18), BitmapDescriptorFactory.HUE_RED, this.h);
                }
            }
            a(this.f2992a);
        }
        this.s = false;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            this.s = true;
        }
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.m) {
            this.f2997f = view == this.f2992a;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.m && actionMasked == 0 && getChildCount() > 1) {
            View childAt = getChildAt(1);
            if (childAt != null) {
                this.f2997f = !this.f2996e.b(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
            }
        }
        if (!this.m || (this.f2995d && actionMasked != 0)) {
            this.f2996e.e();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (actionMasked == 3 || actionMasked == 1) {
            this.f2996e.e();
            return false;
        } else {
            if (actionMasked == 0) {
                this.f2995d = false;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.p = x;
                this.q = y;
                if (this.f2996e.b(this.f2992a, (int) x, (int) y) && c(this.f2992a)) {
                    z = true;
                    if (this.f2996e.a(motionEvent) && !z) {
                        return false;
                    }
                }
            } else if (actionMasked == 2) {
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                float abs = Math.abs(x2 - this.p);
                float abs2 = Math.abs(y2 - this.q);
                if (abs > ((float) this.f2996e.d()) && abs2 > abs) {
                    this.f2996e.e();
                    this.f2995d = true;
                    return false;
                }
            }
            z = false;
            return this.f2996e.a(motionEvent) ? true : true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.m) {
            return super.onTouchEvent(motionEvent);
        }
        this.f2996e.b(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.p = x;
            this.q = y;
        } else if (actionMasked == 1 && c(this.f2992a)) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float f2 = x2 - this.p;
            float f3 = y2 - this.q;
            int d2 = this.f2996e.d();
            if ((f2 * f2) + (f3 * f3) < ((float) (d2 * d2)) && this.f2996e.b(this.f2992a, (int) x2, (int) y2)) {
                a(this.f2992a, 0);
            }
        }
        return true;
    }

    private boolean a(View view, int i2) {
        if (!this.s && !a((float) BitmapDescriptorFactory.HUE_RED, i2)) {
            return false;
        }
        this.f2997f = false;
        return true;
    }

    private boolean b(View view, int i2) {
        if (!this.s && !a(1.0f, i2)) {
            return false;
        }
        this.f2997f = true;
        return true;
    }

    public boolean b() {
        return b(this.f2992a, 0);
    }

    public boolean c() {
        return a(this.f2992a, 0);
    }

    public boolean d() {
        return !this.m || this.f2993b == 1.0f;
    }

    public boolean e() {
        return this.m;
    }

    private void a(View view, float f2, int i2) {
        b bVar = (b) view.getLayoutParams();
        if (f2 > BitmapDescriptorFactory.HUE_RED && i2 != 0) {
            int i3 = (((int) (((float) ((-16777216 & i2) >>> 24)) * f2)) << 24) | (i2 & 16777215);
            if (bVar.f3006d == null) {
                bVar.f3006d = new Paint();
            }
            bVar.f3006d.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, bVar.f3006d);
            }
            b(view);
        } else if (view.getLayerType() != 0) {
            if (bVar.f3006d != null) {
                bVar.f3006d.setColorFilter((ColorFilter) null);
            }
            a aVar = new a(view);
            this.f2998g.add(aVar);
            w.a((View) this, (Runnable) aVar);
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        b bVar = (b) view.getLayoutParams();
        int save = canvas.save();
        if (this.m && !bVar.f3004b && this.f2992a != null) {
            canvas.getClipBounds(this.t);
            if (f()) {
                Rect rect = this.t;
                rect.left = Math.max(rect.left, this.f2992a.getRight());
            } else {
                Rect rect2 = this.t;
                rect2.right = Math.min(rect2.right, this.f2992a.getLeft());
            }
            canvas.clipRect(this.t);
        }
        boolean drawChild = super.drawChild(canvas, view, j2);
        canvas.restoreToCount(save);
        return drawChild;
    }

    /* access modifiers changed from: package-private */
    public void b(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            w.a(view, ((b) view.getLayoutParams()).f3006d);
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            if (!this.w) {
                try {
                    this.u = View.class.getDeclaredMethod("getDisplayList", (Class[]) null);
                } catch (NoSuchMethodException e2) {
                    Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e2);
                }
                try {
                    this.v = View.class.getDeclaredField("mRecreateDisplayList");
                    this.v.setAccessible(true);
                } catch (NoSuchFieldException e3) {
                    Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e3);
                }
                this.w = true;
            }
            if (this.u != null) {
                Field field = this.v;
                if (field != null) {
                    try {
                        field.setBoolean(view, true);
                        this.u.invoke(view, (Object[]) null);
                    } catch (Exception e4) {
                        Log.e("SlidingPaneLayout", "Error refreshing display list state", e4);
                    }
                }
            }
            view.invalidate();
            return;
        }
        w.a(this, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    /* access modifiers changed from: package-private */
    public boolean a(float f2, int i2) {
        int i3;
        if (!this.m) {
            return false;
        }
        boolean f3 = f();
        b bVar = (b) this.f2992a.getLayoutParams();
        if (f3) {
            i3 = (int) (((float) getWidth()) - ((((float) (getPaddingRight() + bVar.rightMargin)) + (f2 * ((float) this.f2994c))) + ((float) this.f2992a.getWidth())));
        } else {
            i3 = (int) (((float) (getPaddingLeft() + bVar.leftMargin)) + (f2 * ((float) this.f2994c)));
        }
        androidx.customview.a.a aVar = this.f2996e;
        View view = this.f2992a;
        if (!aVar.a(view, i3, view.getTop())) {
            return false;
        }
        a();
        w.e(this);
        return true;
    }

    public void computeScroll() {
        if (!this.f2996e.a(true)) {
            return;
        }
        if (!this.m) {
            this.f2996e.f();
        } else {
            w.e(this);
        }
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.j = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.k = drawable;
    }

    @Deprecated
    public void setShadowResource(int i2) {
        setShadowDrawable(getResources().getDrawable(i2));
    }

    public void setShadowResourceLeft(int i2) {
        setShadowDrawableLeft(androidx.core.content.b.a(getContext(), i2));
    }

    public void setShadowResourceRight(int i2) {
        setShadowDrawableRight(androidx.core.content.b.a(getContext(), i2));
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        int i2;
        int i3;
        super.draw(canvas);
        if (f()) {
            drawable = this.k;
        } else {
            drawable = this.j;
        }
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (f()) {
                i3 = childAt.getRight();
                i2 = intrinsicWidth + i3;
            } else {
                int left = childAt.getLeft();
                int i4 = left - intrinsicWidth;
                i2 = left;
                i3 = i4;
            }
            drawable.setBounds(i3, top, i2, bottom);
            drawable.draw(canvas);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(float r10) {
        /*
            r9 = this;
            boolean r0 = r9.f()
            android.view.View r1 = r9.f2992a
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.slidingpanelayout.widget.SlidingPaneLayout$b r1 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.b) r1
            boolean r2 = r1.f3005c
            r3 = 0
            if (r2 == 0) goto L_0x001c
            if (r0 == 0) goto L_0x0016
            int r1 = r1.rightMargin
            goto L_0x0018
        L_0x0016:
            int r1 = r1.leftMargin
        L_0x0018:
            if (r1 > 0) goto L_0x001c
            r1 = 1
            goto L_0x001d
        L_0x001c:
            r1 = 0
        L_0x001d:
            int r2 = r9.getChildCount()
        L_0x0021:
            if (r3 >= r2) goto L_0x005b
            android.view.View r4 = r9.getChildAt(r3)
            android.view.View r5 = r9.f2992a
            if (r4 != r5) goto L_0x002c
            goto L_0x0058
        L_0x002c:
            float r5 = r9.n
            r6 = 1065353216(0x3f800000, float:1.0)
            float r5 = r6 - r5
            int r7 = r9.o
            float r8 = (float) r7
            float r5 = r5 * r8
            int r5 = (int) r5
            r9.n = r10
            float r8 = r6 - r10
            float r7 = (float) r7
            float r8 = r8 * r7
            int r7 = (int) r8
            int r5 = r5 - r7
            if (r0 == 0) goto L_0x0044
            int r5 = -r5
        L_0x0044:
            r4.offsetLeftAndRight(r5)
            if (r1 == 0) goto L_0x0058
            if (r0 == 0) goto L_0x004f
            float r5 = r9.n
            float r5 = r5 - r6
            goto L_0x0053
        L_0x004f:
            float r5 = r9.n
            float r5 = r6 - r5
        L_0x0053:
            int r6 = r9.i
            r9.a(r4, r5, r6)
        L_0x0058:
            int r3 = r3 + 1
            goto L_0x0021
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.a(float):void");
    }

    /* access modifiers changed from: package-private */
    public boolean c(View view) {
        if (view == null) {
            return false;
        }
        b bVar = (b) view.getLayoutParams();
        if (!this.m || !bVar.f3005c || this.f2993b <= BitmapDescriptorFactory.HUE_RED) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new b();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof b) && super.checkLayoutParams(layoutParams);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2999a = e() ? d() : this.f2997f;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        if (savedState.f2999a) {
            b();
        } else {
            c();
        }
        this.f2997f = savedState.f2999a;
    }

    public static class b extends ViewGroup.MarginLayoutParams {

        /* renamed from: e  reason: collision with root package name */
        private static final int[] f3002e = {16843137};

        /* renamed from: a  reason: collision with root package name */
        public float f3003a = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: b  reason: collision with root package name */
        boolean f3004b;

        /* renamed from: c  reason: collision with root package name */
        boolean f3005c;

        /* renamed from: d  reason: collision with root package name */
        Paint f3006d;

        public b() {
            super(-1, -1);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3002e);
            this.f3003a = obtainStyledAttributes.getFloat(0, BitmapDescriptorFactory.HUE_RED);
            obtainStyledAttributes.recycle();
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        boolean f2999a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2999a = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2999a ? 1 : 0);
        }
    }

    private class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final View f3000a;

        a(View view) {
            this.f3000a = view;
        }

        public void run() {
            if (this.f3000a.getParent() == SlidingPaneLayout.this) {
                this.f3000a.setLayerType(0, (Paint) null);
                SlidingPaneLayout.this.b(this.f3000a);
            }
            SlidingPaneLayout.this.f2998g.remove(this);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return w.g(this) == 1;
    }
}
