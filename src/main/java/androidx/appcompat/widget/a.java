package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.a;
import androidx.core.g.aa;
import androidx.core.g.ab;
import androidx.core.g.w;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;

abstract class a extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    protected final C0019a f1040a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f1041b;

    /* renamed from: c  reason: collision with root package name */
    protected ActionMenuView f1042c;

    /* renamed from: d  reason: collision with root package name */
    protected ActionMenuPresenter f1043d;

    /* renamed from: e  reason: collision with root package name */
    protected int f1044e;

    /* renamed from: f  reason: collision with root package name */
    protected aa f1045f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1046g;
    private boolean h;

    protected static int a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    a(Context context) {
        this(context, (AttributeSet) null);
    }

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1040a = new C0019a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(a.C0012a.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f1041b = context;
        } else {
            this.f1041b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes((AttributeSet) null, a.j.ActionBar, a.C0012a.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(a.j.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.f1043d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.a(configuration);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1046g = false;
        }
        if (!this.f1046g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f1046g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1046g = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.h = false;
        }
        if (!this.h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.h = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.f1044e = i;
        requestLayout();
    }

    public int getContentHeight() {
        return this.f1044e;
    }

    public int getAnimatedVisibility() {
        if (this.f1045f != null) {
            return this.f1040a.f1047a;
        }
        return getVisibility();
    }

    public aa a(int i, long j) {
        aa aaVar = this.f1045f;
        if (aaVar != null) {
            aaVar.b();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(BitmapDescriptorFactory.HUE_RED);
            }
            aa a2 = w.n(this).a(1.0f);
            a2.a(j);
            a2.a((ab) this.f1040a.a(a2, i));
            return a2;
        }
        aa a3 = w.n(this).a((float) BitmapDescriptorFactory.HUE_RED);
        a3.a(j);
        a3.a((ab) this.f1040a.a(a3, i));
        return a3;
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            aa aaVar = this.f1045f;
            if (aaVar != null) {
                aaVar.b();
            }
            super.setVisibility(i);
        }
    }

    public boolean a() {
        ActionMenuPresenter actionMenuPresenter = this.f1043d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.e();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public int a(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, RNCartPanelDataEntity.NULL_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    /* access modifiers changed from: protected */
    public int a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    /* renamed from: androidx.appcompat.widget.a$a  reason: collision with other inner class name */
    protected class C0019a implements ab {

        /* renamed from: a  reason: collision with root package name */
        int f1047a;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1049c = false;

        protected C0019a() {
        }

        public C0019a a(aa aaVar, int i) {
            a.this.f1045f = aaVar;
            this.f1047a = i;
            return this;
        }

        public void a(View view) {
            a.super.setVisibility(0);
            this.f1049c = false;
        }

        public void b(View view) {
            if (!this.f1049c) {
                a aVar = a.this;
                aVar.f1045f = null;
                a.super.setVisibility(this.f1047a);
            }
        }

        public void c(View view) {
            this.f1049c = true;
        }
    }
}
