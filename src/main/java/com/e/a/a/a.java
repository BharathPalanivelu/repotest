package com.e.a.a;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import tencent.tls.platform.SigType;

public class a extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final Rect f6651a;

    /* renamed from: b  reason: collision with root package name */
    private long f6652b;

    /* renamed from: c  reason: collision with root package name */
    private Scroller f6653c;

    /* renamed from: d  reason: collision with root package name */
    private C0116a f6654d;
    @ViewDebug.ExportedProperty(category = "layout")

    /* renamed from: e  reason: collision with root package name */
    private boolean f6655e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f6656f;

    /* renamed from: g  reason: collision with root package name */
    private float f6657g;
    private float h;
    private boolean i;
    private View j;
    private boolean k;
    private VelocityTracker l;
    private int m;
    private int n;
    private int o;

    /* renamed from: com.e.a.a.a$a  reason: collision with other inner class name */
    public interface C0116a {
        void a(View view, int i, int i2, int i3, int i4);
    }

    private int a(int i2, int i3, int i4) {
        if (i3 >= i4 || i2 < 0) {
            return 0;
        }
        return i3 + i2 > i4 ? i4 - i3 : i2;
    }

    public a(Context context) {
        this(context, (AttributeSet) null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6651a = new Rect();
        this.i = true;
        this.j = null;
        this.k = false;
        a(context, attributeSet);
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f6651a = new Rect();
        this.i = true;
        this.j = null;
        this.k = false;
        a(context, attributeSet);
    }

    public void setScrollChangeListner(C0116a aVar) {
        this.f6654d = aVar;
    }

    public void setFillViewport(boolean z) {
        if (z != this.f6655e) {
            this.f6655e = z;
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f6655e && View.MeasureSpec.getMode(i3) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), View.MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.i = false;
        View view = this.j;
        if (view != null && a(view, (View) this)) {
            a(this.j);
        }
        this.j = null;
        scrollTo(getScrollX(), getScrollY());
    }

    public int getMaxScrollAmountVertical() {
        return (int) (((float) getHeight()) * 0.5f);
    }

    public int getMaxScrollAmountHorizontal() {
        return (int) (((float) getWidth()) * 0.5f);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.f6653c = new Scroller(getContext());
        setFocusable(true);
        setDescendantFocusability(SigType.D2);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.m = viewConfiguration.getScaledTouchSlop();
        this.n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.o = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private boolean a() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return false;
        }
        int height = childAt.getHeight();
        int width = childAt.getWidth();
        if (getHeight() < height + getPaddingTop() + getPaddingBottom() || getWidth() < width + getPaddingLeft() + getPaddingRight()) {
            return true;
        }
        return false;
    }

    public boolean a(KeyEvent keyEvent) {
        this.f6651a.setEmpty();
        if (!a()) {
            if (!isFocused()) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            if (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) {
                return false;
            }
            return true;
        } else if (keyEvent.getAction() != 0) {
            return false;
        } else {
            switch (keyEvent.getKeyCode()) {
                case 19:
                    if (!keyEvent.isAltPressed()) {
                        return b(33, false);
                    }
                    return a(33, false);
                case 20:
                    if (!keyEvent.isAltPressed()) {
                        return b(130, false);
                    }
                    return a(130, false);
                case 21:
                    if (!keyEvent.isAltPressed()) {
                        return b(17, true);
                    }
                    return a(17, true);
                case 22:
                    if (!keyEvent.isAltPressed()) {
                        return b(66, true);
                    }
                    return a(66, true);
                default:
                    return false;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
        if (getScrollX() < 0) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0077, code lost:
        if (getScrollY() < 0) goto L_0x009b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getAction()
            r1 = 0
            if (r0 != 0) goto L_0x000e
            int r0 = r7.getEdgeFlags()
            if (r0 == 0) goto L_0x000e
            return r1
        L_0x000e:
            boolean r0 = r6.a()
            if (r0 != 0) goto L_0x0015
            return r1
        L_0x0015:
            android.view.VelocityTracker r0 = r6.l
            if (r0 != 0) goto L_0x001f
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r6.l = r0
        L_0x001f:
            android.view.VelocityTracker r0 = r6.l
            r0.addMovement(r7)
            int r0 = r7.getAction()
            float r2 = r7.getY()
            float r7 = r7.getX()
            r3 = 1
            if (r0 == 0) goto L_0x00da
            if (r0 == r3) goto L_0x00a3
            r4 = 2
            if (r0 == r4) goto L_0x003a
            goto L_0x00eb
        L_0x003a:
            float r0 = r6.h
            float r0 = r0 - r7
            int r0 = (int) r0
            float r4 = r6.f6657g
            float r4 = r4 - r2
            int r4 = (int) r4
            r6.h = r7
            r6.f6657g = r2
            if (r0 >= 0) goto L_0x0050
            int r7 = r6.getScrollX()
            if (r7 >= 0) goto L_0x0070
        L_0x004e:
            r7 = 0
            goto L_0x0071
        L_0x0050:
            if (r0 <= 0) goto L_0x0070
            int r7 = r6.getWidth()
            int r2 = r6.getPaddingRight()
            int r7 = r7 - r2
            android.view.View r2 = r6.getChildAt(r1)
            int r2 = r2.getRight()
            int r5 = r6.getScrollX()
            int r2 = r2 - r5
            int r2 = r2 - r7
            if (r2 <= 0) goto L_0x004e
            int r7 = java.lang.Math.min(r2, r0)
            goto L_0x0071
        L_0x0070:
            r7 = r0
        L_0x0071:
            if (r4 >= 0) goto L_0x007a
            int r0 = r6.getScrollY()
            if (r0 >= 0) goto L_0x009a
            goto L_0x009b
        L_0x007a:
            if (r4 <= 0) goto L_0x009a
            int r0 = r6.getHeight()
            int r2 = r6.getPaddingBottom()
            int r0 = r0 - r2
            android.view.View r2 = r6.getChildAt(r1)
            int r2 = r2.getBottom()
            int r5 = r6.getScrollY()
            int r2 = r2 - r5
            int r2 = r2 - r0
            if (r2 <= 0) goto L_0x009b
            int r1 = java.lang.Math.min(r2, r4)
            goto L_0x009b
        L_0x009a:
            r1 = r4
        L_0x009b:
            if (r1 != 0) goto L_0x009f
            if (r7 == 0) goto L_0x00eb
        L_0x009f:
            r6.scrollBy(r7, r1)
            goto L_0x00eb
        L_0x00a3:
            android.view.VelocityTracker r7 = r6.l
            r0 = 1000(0x3e8, float:1.401E-42)
            int r1 = r6.o
            float r1 = (float) r1
            r7.computeCurrentVelocity(r0, r1)
            float r0 = r7.getXVelocity()
            int r0 = (int) r0
            float r7 = r7.getYVelocity()
            int r7 = (int) r7
            int r1 = java.lang.Math.abs(r0)
            int r2 = java.lang.Math.abs(r7)
            int r1 = r1 + r2
            int r2 = r6.n
            if (r1 <= r2) goto L_0x00cf
            int r1 = r6.getChildCount()
            if (r1 <= 0) goto L_0x00cf
            int r0 = -r0
            int r7 = -r7
            r6.b((int) r0, (int) r7)
        L_0x00cf:
            android.view.VelocityTracker r7 = r6.l
            if (r7 == 0) goto L_0x00eb
            r7.recycle()
            r7 = 0
            r6.l = r7
            goto L_0x00eb
        L_0x00da:
            android.widget.Scroller r0 = r6.f6653c
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x00e7
            android.widget.Scroller r0 = r6.f6653c
            r0.abortAnimation()
        L_0x00e7:
            r6.f6657g = r2
            r6.h = r7
        L_0x00eb:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.e.a.a.a.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        C0116a aVar = this.f6654d;
        if (aVar != null) {
            aVar.a(this, i2, i3, i4, i5);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus) {
            findFocus.getDrawingRect(this.f6651a);
            offsetDescendantRectToMyCoords(findFocus, this.f6651a);
            c(a(this.f6651a), a(this.f6651a));
        }
    }

    public void scrollTo(int i2, int i3) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int a2 = a(i2, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int a3 = a(i3, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (a2 != getScrollX() || a3 != getScrollY()) {
                super.scrollTo(a2, a3);
            }
        }
    }

    public void computeScroll() {
        if (this.f6653c.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f6653c.getCurrX();
            int currY = this.f6653c.getCurrY();
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                scrollTo(a(currX, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth()), a(currY, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight()));
            } else {
                scrollTo(currX, currY);
            }
            if (!(scrollX == getScrollX() && scrollY == getScrollY())) {
                onScrollChanged(getScrollX(), getScrollY(), scrollX, scrollY);
            }
            postInvalidate();
        }
    }

    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (getScrollY() < verticalFadingEdgeLength) {
            return ((float) getScrollY()) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    /* access modifiers changed from: protected */
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    /* access modifiers changed from: protected */
    public float getLeftFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (getScrollX() < horizontalFadingEdgeLength) {
            return ((float) getScrollX()) / ((float) horizontalFadingEdgeLength);
        }
        return 1.0f;
    }

    /* access modifiers changed from: protected */
    public float getRightFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int right = (getChildAt(0).getRight() - getScrollX()) - (getWidth() - getPaddingRight());
        if (right < horizontalFadingEdgeLength) {
            return ((float) right) / ((float) horizontalFadingEdgeLength);
        }
        return 1.0f;
    }

    /* access modifiers changed from: protected */
    public int computeHorizontalScrollRange() {
        return getChildCount() == 0 ? getWidth() : getChildAt(0).getRight();
    }

    /* access modifiers changed from: protected */
    public int computeVerticalScrollRange() {
        return getChildCount() == 0 ? getHeight() : getChildAt(0).getBottom();
    }

    public void requestLayout() {
        this.i = true;
        super.requestLayout();
    }

    private View a(boolean z, int i2, boolean z2, int i3, View view) {
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength() / 2;
        int i4 = i2 + verticalFadingEdgeLength;
        int height = (i2 + getHeight()) - verticalFadingEdgeLength;
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength() / 2;
        int i5 = i3 + horizontalFadingEdgeLength;
        int width = (i3 + getWidth()) - horizontalFadingEdgeLength;
        if (view == null || view.getTop() >= height || view.getBottom() <= i4 || view.getLeft() >= width || view.getRight() <= i5) {
            return a(z, i4, height, z2, i5, width);
        }
        return view;
    }

    private View a(boolean z, int i2, int i3, boolean z2, int i4, int i5) {
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        int i9 = i5;
        ArrayList focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z3 = false;
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = (View) focusables.get(i10);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            int left = view2.getLeft();
            int right = view2.getRight();
            if (i6 < bottom && top < i7 && i8 < right && left < i9) {
                boolean z4 = i6 < top && bottom < i7 && i8 < left && right < i9;
                if (view == null) {
                    view = view2;
                    z3 = z4;
                } else {
                    boolean z5 = (z && top < view.getTop()) || (!z && bottom > view.getBottom());
                    boolean z6 = (z2 && left < view.getLeft()) || (!z2 && right > view.getRight());
                    if (z3) {
                        if (z4) {
                            if (z5) {
                                if (!z6) {
                                }
                            }
                        }
                    } else if (z4) {
                        view = view2;
                        z3 = true;
                    } else if (z5) {
                        if (!z6) {
                        }
                    }
                    view = view2;
                }
            }
        }
        return view;
    }

    public boolean a(int i2, boolean z) {
        if (!z) {
            boolean z2 = i2 == 130;
            int height = getHeight();
            Rect rect = this.f6651a;
            rect.top = 0;
            rect.bottom = height;
            if (z2) {
                int childCount = getChildCount();
                if (childCount > 0) {
                    this.f6651a.bottom = getChildAt(childCount - 1).getBottom();
                    Rect rect2 = this.f6651a;
                    rect2.top = rect2.bottom - height;
                }
            }
            return a(i2, this.f6651a.top, this.f6651a.bottom, 0, 0, 0);
        }
        boolean z3 = i2 == 130;
        int width = getWidth();
        Rect rect3 = this.f6651a;
        rect3.left = 0;
        rect3.right = width;
        if (z3) {
            int childCount2 = getChildCount();
            if (childCount2 > 0) {
                this.f6651a.right = getChildAt(childCount2 - 1).getBottom();
                Rect rect4 = this.f6651a;
                rect4.left = rect4.right - width;
            }
        }
        return a(0, 0, 0, i2, this.f6651a.top, this.f6651a.bottom);
    }

    private boolean a(int i2, int i3, int i4, int i5, int i6, int i7) {
        boolean z;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i6;
        int i12 = i7;
        int height = getHeight();
        int scrollY = getScrollY();
        int i13 = scrollY + height;
        boolean z2 = i8 == 33;
        int width = getWidth();
        int scrollX = getScrollX();
        int i14 = scrollX + width;
        boolean z3 = i5 == 33;
        int i15 = i14;
        int i16 = scrollX;
        View a2 = a(z2, i3, i4, z3, i6, i7);
        if (a2 == null) {
            a2 = this;
        }
        if ((i9 < scrollY || i10 > i13) && (i11 < i16 || i12 > i15)) {
            c(z3 ? i11 - i16 : i12 - i15, z2 ? i9 - scrollY : i10 - i13);
            z = true;
        } else {
            z = false;
        }
        if (a2 != findFocus() && a2.requestFocus(i2)) {
            this.f6656f = true;
            this.f6656f = false;
        }
        return z;
    }

    public boolean b(int i2, boolean z) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i2);
        int maxScrollAmountHorizontal = z ? getMaxScrollAmountHorizontal() : getMaxScrollAmountVertical();
        if (!z) {
            if (findNextFocus != null) {
                findNextFocus.getDrawingRect(this.f6651a);
                offsetDescendantRectToMyCoords(findNextFocus, this.f6651a);
                c(0, a(this.f6651a));
                findNextFocus.requestFocus(i2);
                return true;
            }
            if (i2 == 33 && getScrollY() < maxScrollAmountHorizontal) {
                maxScrollAmountHorizontal = getScrollY();
            } else if (i2 == 130 && getChildCount() > 0) {
                int bottom = getChildAt(0).getBottom() - (getScrollY() + getHeight());
                if (bottom < maxScrollAmountHorizontal) {
                    maxScrollAmountHorizontal = bottom;
                }
            }
            if (maxScrollAmountHorizontal == 0) {
                return false;
            }
            if (i2 != 130) {
                maxScrollAmountHorizontal = -maxScrollAmountHorizontal;
            }
            c(0, maxScrollAmountHorizontal);
            return true;
        } else if (findNextFocus != null) {
            findNextFocus.getDrawingRect(this.f6651a);
            offsetDescendantRectToMyCoords(findNextFocus, this.f6651a);
            c(a(this.f6651a), 0);
            findNextFocus.requestFocus(i2);
            return true;
        } else {
            if (i2 == 33 && getScrollY() < maxScrollAmountHorizontal) {
                maxScrollAmountHorizontal = getScrollY();
            } else if (i2 == 130 && getChildCount() > 0) {
                int bottom2 = getChildAt(0).getBottom() - (getScrollY() + getHeight());
                if (bottom2 < maxScrollAmountHorizontal) {
                    maxScrollAmountHorizontal = bottom2;
                }
            }
            if (maxScrollAmountHorizontal == 0) {
                return false;
            }
            if (i2 != 130) {
                maxScrollAmountHorizontal = -maxScrollAmountHorizontal;
            }
            c(maxScrollAmountHorizontal, 0);
            return true;
        }
    }

    private void c(int i2, int i3) {
        if (i2 != 0 || i3 != 0) {
            a(i2, i3);
        }
    }

    public void a(int i2, int i3) {
        if (AnimationUtils.currentAnimationTimeMillis() - this.f6652b > 250) {
            this.f6653c.startScroll(getScrollX(), getScrollY(), i2, i3);
            awakenScrollBars(this.f6653c.getDuration());
            invalidate();
        } else {
            if (!this.f6653c.isFinished()) {
                this.f6653c.abortAnimation();
            }
            scrollBy(i2, i3);
        }
        this.f6652b = AnimationUtils.currentAnimationTimeMillis();
    }

    private void a(View view) {
        view.getDrawingRect(this.f6651a);
        offsetDescendantRectToMyCoords(view, this.f6651a);
        int a2 = a(this.f6651a);
        if (a2 != 0) {
            scrollBy(0, a2);
        }
    }

    private boolean a(Rect rect, boolean z) {
        int a2 = a(rect);
        boolean z2 = a2 != 0;
        if (z2) {
            if (z) {
                scrollBy(0, a2);
            } else {
                a(0, a2);
            }
        }
        return z2;
    }

    /* access modifiers changed from: protected */
    public int a(Rect rect) {
        int i2;
        int i3;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i4 -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i4 && rect.top > scrollY) {
            if (rect.height() > height) {
                i3 = rect.top - scrollY;
            } else {
                i3 = rect.bottom - i4;
            }
            return Math.min(i3 + 0, getChildAt(0).getBottom() - i4);
        } else if (rect.top >= scrollY || rect.bottom >= i4) {
            return 0;
        } else {
            if (rect.height() > height) {
                i2 = 0 - (i4 - rect.bottom);
            } else {
                i2 = 0 - (scrollY - rect.top);
            }
            return Math.max(i2, -getScrollY());
        }
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.f6656f) {
            if (!this.i) {
                a(view2);
            } else {
                this.j = view2;
            }
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return a(rect, z);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || a(keyEvent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        if (r0 != 3) goto L_0x0052;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getAction()
            r1 = 2
            r2 = 1
            if (r0 != r1) goto L_0x000d
            boolean r3 = r5.k
            if (r3 == 0) goto L_0x000d
            return r2
        L_0x000d:
            boolean r3 = r5.a()
            r4 = 0
            if (r3 != 0) goto L_0x0017
            r5.k = r4
            return r4
        L_0x0017:
            float r3 = r6.getY()
            float r6 = r6.getX()
            if (r0 == 0) goto L_0x0045
            if (r0 == r2) goto L_0x0042
            if (r0 == r1) goto L_0x0029
            r6 = 3
            if (r0 == r6) goto L_0x0042
            goto L_0x0052
        L_0x0029:
            float r0 = r5.f6657g
            float r3 = r3 - r0
            float r0 = java.lang.Math.abs(r3)
            int r0 = (int) r0
            float r1 = r5.h
            float r6 = r6 - r1
            float r6 = java.lang.Math.abs(r6)
            int r6 = (int) r6
            int r1 = r5.m
            if (r0 > r1) goto L_0x003f
            if (r6 <= r1) goto L_0x0052
        L_0x003f:
            r5.k = r2
            goto L_0x0052
        L_0x0042:
            r5.k = r4
            goto L_0x0052
        L_0x0045:
            r5.f6657g = r3
            r5.h = r6
            android.widget.Scroller r6 = r5.f6653c
            boolean r6 = r6.isFinished()
            r6 = r6 ^ r2
            r5.k = r6
        L_0x0052:
            boolean r6 = r5.k
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.e.a.a.a.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        View view;
        if (i2 == 2) {
            i2 = 130;
        } else if (i2 == 1) {
            i2 = 33;
        }
        if (rect == null) {
            view = FocusFinder.getInstance().findNextFocus(this, (View) null, i2);
        } else {
            view = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i2);
        }
        if (view == null || !view.requestFocus(i2, rect)) {
            return false;
        }
        return true;
    }

    public void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("TwoDScrollView can host only one direct child");
    }

    public void addView(View view, int i2) {
        if (getChildCount() <= 0) {
            super.addView(view, i2);
            return;
        }
        throw new IllegalStateException("TwoDScrollView can host only one direct child");
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("TwoDScrollView can host only one direct child");
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new IllegalStateException("TwoDScrollView can host only one direct child");
    }

    /* access modifiers changed from: protected */
    public void measureChild(View view, int i2, int i3) {
        view.measure(getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* access modifiers changed from: protected */
    public void measureChildWithMargins(View view, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(View.MeasureSpec.makeMeasureSpec(marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, 0), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    private boolean a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup) || !a((View) parent, view2)) {
            return false;
        }
        return true;
    }

    public void b(int i2, int i3) {
        if (getChildCount() > 0) {
            int i4 = i2;
            int i5 = i3;
            this.f6653c.fling(getScrollX(), getScrollY(), i4, i5, 0, getChildAt(0).getWidth() - ((getWidth() - getPaddingRight()) - getPaddingLeft()), 0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
            boolean z = i3 > 0;
            View a2 = a(i2 > 0, this.f6653c.getFinalX(), z, this.f6653c.getFinalY(), findFocus());
            if (a2 == null) {
                a2 = this;
            }
            if (a2 != findFocus()) {
                if (a2.requestFocus(z ? 130 : 33)) {
                    this.f6656f = true;
                    this.f6656f = false;
                }
            }
            awakenScrollBars(this.f6653c.getDuration());
            invalidate();
        }
    }
}
