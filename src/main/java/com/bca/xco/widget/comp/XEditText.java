package com.bca.xco.widget.comp;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.bca.xco.widget.b.c;
import com.bca.xco.widget.e.e;
import com.bca.xco.widget.h;

public class XEditText extends EditText implements View.OnFocusChangeListener, View.OnTouchListener, c.a {

    /* renamed from: a  reason: collision with root package name */
    private b f4701a = b.RIGHT;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f4702b;

    /* renamed from: c  reason: collision with root package name */
    private a f4703c;

    /* renamed from: d  reason: collision with root package name */
    private View.OnTouchListener f4704d;

    /* renamed from: e  reason: collision with root package name */
    private View.OnFocusChangeListener f4705e;

    public interface a {
        void a();
    }

    public enum b {
        LEFT(0),
        RIGHT(2);
        

        /* renamed from: c  reason: collision with root package name */
        final int f4709c;

        private b(int i) {
            this.f4709c = i;
        }
    }

    public XEditText(Context context) {
        super(context);
        a();
        a(context, 0);
    }

    public XEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
        a(context, 0);
    }

    public XEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
        a(context, 0);
    }

    private void a(Context context, int i) {
        if (i == 1) {
            setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Bold.ttf"));
        } else {
            setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Regular.ttf"));
        }
    }

    public void setListener(a aVar) {
        this.f4703c = aVar;
    }

    public void setIconLocation(b bVar) {
        this.f4701a = bVar;
        b();
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.f4704d = onTouchListener;
    }

    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f4705e = onFocusChangeListener;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (getDisplayedDrawable() != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (x >= (this.f4701a == b.LEFT ? 0 : (getWidth() - getPaddingRight()) - this.f4702b.getIntrinsicWidth()) && x <= (this.f4701a == b.LEFT ? getPaddingLeft() + this.f4702b.getIntrinsicWidth() : getWidth()) && y >= 0 && y <= getBottom() - getTop()) {
                if (motionEvent.getAction() == 1) {
                    setText("");
                    a aVar = this.f4703c;
                    if (aVar != null) {
                        aVar.a();
                    }
                }
                return true;
            }
        }
        View.OnTouchListener onTouchListener = this.f4704d;
        if (onTouchListener != null) {
            return onTouchListener.onTouch(view, motionEvent);
        }
        return false;
    }

    public void onFocusChange(View view, boolean z) {
        if (z) {
            setClearIconVisible(e.a(getText()));
        } else {
            setClearIconVisible(false);
        }
        View.OnFocusChangeListener onFocusChangeListener = this.f4705e;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(view, z);
        }
    }

    public void a(EditText editText, String str) {
        if (isFocused()) {
            setClearIconVisible(e.a(str));
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        b();
    }

    private void a() {
        super.setOnTouchListener(this);
        super.setOnFocusChangeListener(this);
        addTextChangedListener(new c(this, this));
        b();
        setClearIconVisible(false);
    }

    private void b() {
        this.f4702b = null;
        if (this.f4701a != null) {
            this.f4702b = getCompoundDrawables()[this.f4701a.f4709c];
        }
        if (this.f4702b == null) {
            this.f4702b = getResources().getDrawable(h.c.xco_ic_cancel);
        }
        Drawable drawable = this.f4702b;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f4702b.getIntrinsicHeight());
        int paddingTop = getPaddingTop() + this.f4702b.getIntrinsicHeight() + getPaddingBottom();
        if (getSuggestedMinimumHeight() < paddingTop) {
            setMinimumHeight(paddingTop);
        }
    }

    private Drawable getDisplayedDrawable() {
        if (this.f4701a != null) {
            return getCompoundDrawables()[this.f4701a.f4709c];
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void setClearIconVisible(boolean z) {
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (z != (getDisplayedDrawable() != null)) {
            Drawable drawable = z ? this.f4702b : null;
            Drawable drawable2 = this.f4701a == b.LEFT ? drawable : compoundDrawables[0];
            Drawable drawable3 = compoundDrawables[1];
            if (this.f4701a != b.RIGHT) {
                drawable = compoundDrawables[2];
            }
            super.setCompoundDrawables(drawable2, drawable3, drawable, compoundDrawables[3]);
        }
    }
}
