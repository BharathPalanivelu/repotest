package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.a;
import androidx.core.g.w;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import tencent.tls.platform.SigType;

public class ActionBarContainer extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    Drawable f902a;

    /* renamed from: b  reason: collision with root package name */
    Drawable f903b;

    /* renamed from: c  reason: collision with root package name */
    Drawable f904c;

    /* renamed from: d  reason: collision with root package name */
    boolean f905d;

    /* renamed from: e  reason: collision with root package name */
    boolean f906e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f907f;

    /* renamed from: g  reason: collision with root package name */
    private View f908g;
    private View h;
    private View i;
    private int j;

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public ActionBarContainer(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        w.a((View) this, (Drawable) new b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.ActionBar);
        this.f902a = obtainStyledAttributes.getDrawable(a.j.ActionBar_background);
        this.f903b = obtainStyledAttributes.getDrawable(a.j.ActionBar_backgroundStacked);
        this.j = obtainStyledAttributes.getDimensionPixelSize(a.j.ActionBar_height, -1);
        if (getId() == a.f.split_action_bar) {
            this.f905d = true;
            this.f904c = obtainStyledAttributes.getDrawable(a.j.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = false;
        if (!this.f905d ? this.f902a == null && this.f903b == null : this.f904c == null) {
            z = true;
        }
        setWillNotDraw(z);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.h = findViewById(a.f.action_bar);
        this.i = findViewById(a.f.action_context_bar);
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f902a;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f902a);
        }
        this.f902a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.h;
            if (view != null) {
                this.f902a.setBounds(view.getLeft(), this.h.getTop(), this.h.getRight(), this.h.getBottom());
            }
        }
        boolean z = true;
        if (!this.f905d ? !(this.f902a == null && this.f903b == null) : this.f904c != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2 = this.f903b;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f903b);
        }
        this.f903b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f906e) {
                Drawable drawable3 = this.f903b;
                if (drawable3 != null) {
                    drawable3.setBounds(this.f908g.getLeft(), this.f908g.getTop(), this.f908g.getRight(), this.f908g.getBottom());
                }
            }
        }
        boolean z = true;
        if (!this.f905d ? !(this.f902a == null && this.f903b == null) : this.f904c != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2 = this.f904c;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f904c);
        }
        this.f904c = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f905d) {
                Drawable drawable3 = this.f904c;
                if (drawable3 != null) {
                    drawable3.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                }
            }
        }
        if (!this.f905d ? this.f902a == null && this.f903b == null : this.f904c == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.f902a;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f903b;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.f904c;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f902a && !this.f905d) || (drawable == this.f903b && this.f906e) || ((drawable == this.f904c && this.f905d) || super.verifyDrawable(drawable));
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f902a;
        if (drawable != null && drawable.isStateful()) {
            this.f902a.setState(getDrawableState());
        }
        Drawable drawable2 = this.f903b;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f903b.setState(getDrawableState());
        }
        Drawable drawable3 = this.f904c;
        if (drawable3 != null && drawable3.isStateful()) {
            this.f904c.setState(getDrawableState());
        }
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f902a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f903b;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f904c;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public void setTransitioning(boolean z) {
        this.f907f = z;
        setDescendantFocusability(z ? 393216 : SigType.D2);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f907f || super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public void setTabContainer(ak akVar) {
        View view = this.f908g;
        if (view != null) {
            removeView(view);
        }
        this.f908g = akVar;
        if (akVar != null) {
            addView(akVar);
            ViewGroup.LayoutParams layoutParams = akVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            akVar.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.f908g;
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i2) {
        if (i2 != 0) {
            return super.startActionModeForChild(view, callback, i2);
        }
        return null;
    }

    private boolean a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private int b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        if (this.h == null && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE) {
            int i5 = this.j;
            if (i5 >= 0) {
                i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i5, View.MeasureSpec.getSize(i3)), RNCartPanelDataEntity.NULL_VALUE);
            }
        }
        super.onMeasure(i2, i3);
        if (this.h != null) {
            int mode = View.MeasureSpec.getMode(i3);
            View view = this.f908g;
            if (view != null && view.getVisibility() != 8 && mode != 1073741824) {
                if (!a(this.h)) {
                    i4 = b(this.h);
                } else {
                    i4 = !a(this.i) ? b(this.i) : 0;
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(i4 + b(this.f908g), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i3) : Integer.MAX_VALUE));
            }
        }
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        View view = this.f908g;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i2, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i4, measuredHeight - layoutParams.bottomMargin);
        }
        if (this.f905d) {
            Drawable drawable = this.f904c;
            if (drawable != null) {
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.f902a != null) {
                if (this.h.getVisibility() == 0) {
                    this.f902a.setBounds(this.h.getLeft(), this.h.getTop(), this.h.getRight(), this.h.getBottom());
                } else {
                    View view2 = this.i;
                    if (view2 == null || view2.getVisibility() != 0) {
                        this.f902a.setBounds(0, 0, 0, 0);
                    } else {
                        this.f902a.setBounds(this.i.getLeft(), this.i.getTop(), this.i.getRight(), this.i.getBottom());
                    }
                }
                z3 = true;
            }
            this.f906e = z4;
            if (z4) {
                Drawable drawable2 = this.f903b;
                if (drawable2 != null) {
                    drawable2.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                }
            }
            z2 = z3;
        }
        if (z2) {
            invalidate();
        }
    }
}
