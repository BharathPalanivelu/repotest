package com.shopee.app.ui.image;

import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.appkit.tools.c;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Collections;

public abstract class a extends ViewGroup implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public static float f22729a = 0.9f;
    public static int l = 150;

    /* renamed from: b  reason: collision with root package name */
    protected int f22730b = 1;

    /* renamed from: c  reason: collision with root package name */
    protected final int f22731c = (b.a.f7691b * 4);

    /* renamed from: d  reason: collision with root package name */
    protected int f22732d = 0;

    /* renamed from: e  reason: collision with root package name */
    protected float f22733e = BitmapDescriptorFactory.HUE_RED;

    /* renamed from: f  reason: collision with root package name */
    protected int f22734f = -1;

    /* renamed from: g  reason: collision with root package name */
    protected int f22735g = -1;
    protected int h = -1;
    protected int i = -1;
    protected boolean j = true;
    protected boolean k = false;
    protected ArrayList<Integer> m = new ArrayList<>();
    protected C0354a n;
    protected View.OnClickListener o;
    protected boolean p;
    protected b q;
    private final int r = c.a().a(104);
    private AdapterView.OnItemClickListener s;
    private int t;
    private int u;

    /* renamed from: com.shopee.app.ui.image.a$a  reason: collision with other inner class name */
    public interface C0354a {
        void a(int i, int i2);

        void i_(int i);
    }

    /* access modifiers changed from: protected */
    public abstract void e();

    public boolean onLongClick(View view) {
        return false;
    }

    public a(Context context) {
        super(context);
        int i2 = this.r;
        this.t = i2;
        this.u = i2;
        this.p = true;
        a();
        setChildrenDrawingOrderEnabled(true);
    }

    /* access modifiers changed from: protected */
    public void a() {
        setOnTouchListener(this);
        super.setOnClickListener(this);
        setOnLongClickListener(this);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.o = onClickListener;
    }

    public void addView(View view) {
        super.addView(view);
        this.m.add(-1);
    }

    public void removeViewAt(int i2) {
        super.removeViewAt(i2);
        this.m.remove(i2);
    }

    public int getChildWidth() {
        return this.t;
    }

    public int getChildHeight() {
        return this.u;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int childCount = getChildCount();
        int i4 = this.f22731c;
        int childWidth = (getChildWidth() * childCount) + (childCount * i4) + i4;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            if (i5 != this.f22734f) {
                View childAt = getChildAt(i5);
                if (childAt != null) {
                    measureChild(childAt, View.MeasureSpec.makeMeasureSpec(getChildWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getChildHeight(), 1073741824));
                }
            }
        }
        setMeasuredDimension(childWidth, getDefaultSize(getSuggestedMinimumHeight(), i3));
    }

    public void a_(int i2, int i3) {
        this.t = i2;
        this.u = i3;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        a(i2, i3, i4, i5);
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        int i4 = this.f22734f;
        if (i4 == -1) {
            return i3;
        }
        if (i3 == i2 - 1) {
            return i4;
        }
        return i3 >= i4 ? i3 + 1 : i3;
    }

    public int b(int i2, int i3) {
        int a2 = a(i2);
        int a3 = a(i3 + this.f22732d);
        if (a2 == -1 || a3 == -1) {
            return -1;
        }
        int i4 = (a3 * this.f22730b) + a2;
        if (i4 >= getChildCount()) {
            return -1;
        }
        return i4;
    }

    /* access modifiers changed from: protected */
    public int a(int i2) {
        int i3 = i2 - this.f22731c;
        int i4 = 0;
        while (i3 > 0) {
            if (i3 < getChildWidth()) {
                return i4;
            }
            i3 -= getChildWidth() + this.f22731c;
            i4++;
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public int c(int i2, int i3) {
        int i4 = -1;
        if (a(this.f22732d + i3) == -1) {
            return -1;
        }
        int b2 = b(i2 - (getChildWidth() / 4), i3);
        int b3 = b(i2 + (getChildWidth() / 4), i3);
        if ((b2 == -1 && b3 == -1) || b2 == b3) {
            return -1;
        }
        if (b3 > -1) {
            i4 = b3;
        } else if (b2 > -1) {
            i4 = b2 + 1;
        }
        return this.f22734f < i4 ? i4 - 1 : i4;
    }

    /* access modifiers changed from: protected */
    public Point b(int i2) {
        int i3 = this.f22731c;
        int childWidth = getChildWidth();
        int i4 = this.f22731c;
        return new Point(i3 + ((childWidth + i4) * i2), i4 - this.f22732d);
    }

    public void onClick(View view) {
        if (this.j) {
            View.OnClickListener onClickListener = this.o;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            if (this.s != null && getLastIndex() != -1) {
                this.s.onItemClick((AdapterView) null, getChildAt(getLastIndex()), getLastIndex(), (long) (getLastIndex() / this.f22730b));
            }
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.j = true;
            this.f22735g = (int) motionEvent.getX();
            this.h = (int) motionEvent.getY();
            this.k = true;
        } else if (action == 1) {
            int i2 = this.f22734f;
            if (i2 != -1) {
                View childAt = getChildAt(i2);
                if (childAt != null) {
                    if (this.i != -1) {
                        b();
                    } else {
                        Point b2 = b(this.f22734f);
                        childAt.layout(b2.x, b2.y, b2.x + getChildWidth(), b2.y + getChildHeight());
                    }
                    childAt.clearAnimation();
                    if (childAt instanceof ImageView) {
                        ((ImageView) childAt).setAlpha(255);
                    }
                    C0354a aVar = this.n;
                    if (aVar != null) {
                        aVar.i_(this.f22734f);
                    }
                    this.i = -1;
                    this.f22734f = -1;
                }
            }
            this.k = false;
        } else if (action == 2) {
            if (!this.p) {
                return false;
            }
            int y = this.h - ((int) motionEvent.getY());
            if (this.f22734f != -1) {
                int x = (int) motionEvent.getX();
                int y2 = (int) motionEvent.getY();
                int childWidth = x - ((getChildWidth() * 3) / 4);
                int childHeight = y2 - ((getChildHeight() * 3) / 4);
                View childAt2 = getChildAt(this.f22734f);
                if (childAt2 != null) {
                    childAt2.layout(childWidth, childHeight, ((getChildWidth() * 3) / 2) + childWidth, ((getChildHeight() * 3) / 2) + childHeight);
                }
                int c2 = c(x, y2);
                if (!(this.i == c2 || c2 == -1)) {
                    c(c2);
                    this.i = c2;
                }
            }
            this.f22735g = (int) motionEvent.getX();
            this.h = (int) motionEvent.getY();
            this.f22733e = (float) y;
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(this.f22734f != -1);
            }
        }
        if (this.f22734f != -1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void c(int i2) {
        int i3;
        int i4 = i2;
        int i5 = 0;
        while (i5 < getChildCount()) {
            View childAt = getChildAt(i5);
            int i6 = this.f22734f;
            if (i5 != i6) {
                if (i6 >= i4 || i5 < i6 + 1 || i5 > i4) {
                    int i7 = this.f22734f;
                    i3 = (i4 >= i7 || i5 < i4 || i5 >= i7) ? i5 : i5 + 1;
                } else {
                    i3 = i5 - 1;
                }
                int intValue = this.m.get(i5).intValue() != -1 ? this.m.get(i5).intValue() : i5;
                if (intValue != i3) {
                    Point b2 = b(intValue);
                    Point b3 = b(i3);
                    Point point = new Point(b2.x - childAt.getLeft(), b2.y - childAt.getTop());
                    Point point2 = new Point(b3.x - childAt.getLeft(), b3.y - childAt.getTop());
                    TranslateAnimation translateAnimation = new TranslateAnimation(0, (float) point.x, 0, (float) point2.x, 0, (float) point.y, 0, (float) point2.y);
                    translateAnimation.setDuration((long) l);
                    translateAnimation.setFillEnabled(true);
                    translateAnimation.setFillAfter(true);
                    childAt.clearAnimation();
                    childAt.startAnimation(translateAnimation);
                    this.m.set(i5, Integer.valueOf(i3));
                }
            }
            i5++;
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        C0354a aVar = this.n;
        if (aVar != null) {
            aVar.a(this.f22734f, this.i);
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            getChildAt(i2).clearAnimation();
            arrayList.add(getChildAt(i2));
        }
        removeAllViews();
        while (true) {
            int i3 = this.f22734f;
            int i4 = this.i;
            if (i3 == i4) {
                break;
            } else if (i4 == arrayList.size()) {
                arrayList.add(arrayList.remove(this.f22734f));
                this.f22734f = this.i;
            } else {
                int i5 = this.f22734f;
                int i6 = this.i;
                if (i5 < i6) {
                    Collections.swap(arrayList, i5, i5 + 1);
                    this.f22734f++;
                } else if (i5 > i6) {
                    Collections.swap(arrayList, i5, i5 - 1);
                    this.f22734f--;
                }
            }
        }
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            this.m.set(i7, -1);
            addView((View) arrayList.get(i7));
        }
        a(getLeft(), getTop(), getRight(), getBottom());
    }

    private void a(int i2, int i3, int i4, int i5) {
        this.f22730b = Math.max(this.f22730b, 1);
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            if (i6 != this.f22734f) {
                Point b2 = b(i6);
                View childAt = getChildAt(i6);
                if (childAt != null) {
                    childAt.layout(b2.x, b2.y, b2.x + getChildWidth(), b2.y + getChildHeight());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public int getMaxScroll() {
        double childCount = (double) getChildCount();
        double d2 = (double) this.f22730b;
        Double.isNaN(childCount);
        Double.isNaN(d2);
        int ceil = (int) Math.ceil(childCount / d2);
        return ((getChildWidth() * ceil) + ((ceil + 1) * this.f22731c)) - getHeight();
    }

    public int getLastIndex() {
        return b(this.f22735g, this.h);
    }

    public void setOnRearrangeListener(C0354a aVar) {
        this.n = aVar;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.s = onItemClickListener;
    }

    public void setAdapter(b bVar) {
        this.q = bVar;
    }

    public void c() {
        if (this.q != null) {
            removeAllViews();
            e();
            postInvalidate();
        }
    }

    public void setEditable(boolean z) {
        this.p = z;
        c();
    }

    public boolean d() {
        return this.p;
    }
}
