package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ac;
import androidx.appcompat.widget.at;

public class ActionMenuItemView extends AppCompatTextView implements View.OnClickListener, n.a, ActionMenuView.a {

    /* renamed from: a  reason: collision with root package name */
    i f784a;

    /* renamed from: b  reason: collision with root package name */
    g.b f785b;

    /* renamed from: c  reason: collision with root package name */
    b f786c;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f787e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f788f;

    /* renamed from: g  reason: collision with root package name */
    private ac f789g;
    private boolean h;
    private boolean i;
    private int j;
    private int k;
    private int l;

    public static abstract class b {
        public abstract p a();
    }

    public boolean a() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public ActionMenuItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Resources resources = context.getResources();
        this.h = e();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.ActionMenuItemView, i2, 0);
        this.j = obtainStyledAttributes.getDimensionPixelSize(a.j.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.l = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.k = -1;
        setSaveEnabled(false);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.h = e();
        f();
    }

    private boolean e() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        return i2 >= 480 || (i2 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        this.k = i2;
        super.setPadding(i2, i3, i4, i5);
    }

    public i getItemData() {
        return this.f784a;
    }

    public void a(i iVar, int i2) {
        this.f784a = iVar;
        setIcon(iVar.getIcon());
        setTitle(iVar.a((n.a) this));
        setId(iVar.getItemId());
        setVisibility(iVar.isVisible() ? 0 : 8);
        setEnabled(iVar.isEnabled());
        if (iVar.hasSubMenu() && this.f789g == null) {
            this.f789g = new a();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f784a.hasSubMenu()) {
            ac acVar = this.f789g;
            if (acVar != null && acVar.onTouch(this, motionEvent)) {
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onClick(View view) {
        g.b bVar = this.f785b;
        if (bVar != null) {
            bVar.a(this.f784a);
        }
    }

    public void setItemInvoker(g.b bVar) {
        this.f785b = bVar;
    }

    public void setPopupCallback(b bVar) {
        this.f786c = bVar;
    }

    public void setExpandedFormat(boolean z) {
        if (this.i != z) {
            this.i = z;
            i iVar = this.f784a;
            if (iVar != null) {
                iVar.h();
            }
        }
    }

    private void f() {
        CharSequence charSequence;
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f787e);
        if (this.f788f != null && (!this.f784a.m() || (!this.h && !this.i))) {
            z = false;
        }
        boolean z3 = z2 & z;
        CharSequence charSequence2 = null;
        setText(z3 ? this.f787e : null);
        CharSequence contentDescription = this.f784a.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            if (z3) {
                charSequence = null;
            } else {
                charSequence = this.f784a.getTitle();
            }
            setContentDescription(charSequence);
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f784a.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            if (!z3) {
                charSequence2 = this.f784a.getTitle();
            }
            at.a(this, charSequence2);
            return;
        }
        at.a(this, tooltipText);
    }

    public void setIcon(Drawable drawable) {
        this.f788f = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i2 = this.l;
            if (intrinsicWidth > i2) {
                intrinsicHeight = (int) (((float) intrinsicHeight) * (((float) i2) / ((float) intrinsicWidth)));
                intrinsicWidth = i2;
            }
            int i3 = this.l;
            if (intrinsicHeight > i3) {
                intrinsicWidth = (int) (((float) intrinsicWidth) * (((float) i3) / ((float) intrinsicHeight)));
                intrinsicHeight = i3;
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        f();
    }

    public boolean b() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence charSequence) {
        this.f787e = charSequence;
        f();
    }

    public boolean c() {
        return b() && this.f784a.getIcon() == null;
    }

    public boolean d() {
        return b();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        boolean b2 = b();
        if (b2) {
            int i4 = this.k;
            if (i4 >= 0) {
                super.setPadding(i4, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            }
        }
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.j) : this.j;
        if (mode != 1073741824 && this.j > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i3);
        }
        if (!b2 && this.f788f != null) {
            super.setPadding((getMeasuredWidth() - this.f788f.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    private class a extends ac {
        public a() {
            super(ActionMenuItemView.this);
        }

        public p a() {
            if (ActionMenuItemView.this.f786c != null) {
                return ActionMenuItemView.this.f786c.a();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public boolean b() {
            if (ActionMenuItemView.this.f785b == null || !ActionMenuItemView.this.f785b.a(ActionMenuItemView.this.f784a)) {
                return false;
            }
            p a2 = a();
            if (a2 == null || !a2.e()) {
                return false;
            }
            return true;
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState((Parcelable) null);
    }
}
