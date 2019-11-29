package com.shopee.app.ui.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.shopee.app.a;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.util.av;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class ag extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    TagEditText f21134a;

    /* renamed from: b  reason: collision with root package name */
    ImageButton f21135b;

    /* renamed from: c  reason: collision with root package name */
    ImageButton f21136c;

    /* renamed from: d  reason: collision with root package name */
    ImageButton f21137d;

    /* renamed from: e  reason: collision with root package name */
    Animation f21138e;

    /* renamed from: f  reason: collision with root package name */
    Animation f21139f;

    /* renamed from: g  reason: collision with root package name */
    Animation f21140g;
    Animation h;
    af i;
    bi j;
    bc k;
    UserInfo l;
    private String m;
    private boolean n = false;
    private boolean o = false;
    private boolean p = true;
    private int q = -1;

    public interface a {
        void a(ag agVar);
    }

    public ag(Context context) {
        super(context);
        a(context);
    }

    public ag(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
        a(context, attributeSet);
    }

    public ag(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.b.SendTextItem);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == 0) {
                this.q = obtainStyledAttributes.getInt(index, -1);
            } else if (index == 1) {
                this.n = obtainStyledAttributes.getBoolean(index, false);
            } else if (index == 2) {
                this.o = obtainStyledAttributes.getBoolean(index, false);
            } else if (index == 3) {
                this.m = obtainStyledAttributes.getString(index);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void a(Context context) {
        ((a) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        av.a(this.f21135b);
        this.k.a(this.i);
        this.i.a(this);
        this.f21134a.addTextChangedListener(this.i);
        this.f21134a.setHint(this.m);
        i();
        int i2 = this.q;
        if (i2 != -1) {
            this.f21134a.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
        }
    }

    private void i() {
        this.f21135b.setEnabled(false);
        this.f21137d.setVisibility(this.o ? 0 : 8);
        if (this.n) {
            this.f21136c.setVisibility(0);
            this.f21135b.setVisibility(8);
            return;
        }
        this.f21136c.setVisibility(8);
        this.f21135b.setVisibility(0);
    }

    public void setText(String str) {
        this.f21134a.setText(str);
    }

    public void b() {
        this.f21134a.setText("");
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.i.a(this.f21134a.getText().toString(), this.f21134a.getUserTags());
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.i.f();
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.i.e();
    }

    /* access modifiers changed from: package-private */
    public boolean a(MotionEvent motionEvent) {
        if (this.l.isLoggedIn()) {
            return false;
        }
        if (motionEvent.getAction() != 0) {
            return true;
        }
        com.shopee.app.ui.dialog.a.a(getContext(), (int) R.string.sp_login_msg_comments, 0);
        return true;
    }

    public boolean f() {
        return this.f21135b.isEnabled();
    }

    public void a(boolean z) {
        this.f21135b.setEnabled(z);
    }

    public void g() {
        if (this.n) {
            this.f21135b.startAnimation(this.f21138e);
            this.f21135b.setVisibility(0);
            this.f21136c.startAnimation(this.f21139f);
            this.f21136c.setVisibility(8);
        }
    }

    public void h() {
        if (this.n) {
            this.f21135b.startAnimation(this.h);
            this.f21135b.setVisibility(8);
            this.f21136c.startAnimation(this.f21140g);
            this.f21136c.setVisibility(0);
        }
    }

    public EditText getEditText() {
        return this.f21134a;
    }

    public Editable getEditable() {
        return this.f21134a.getEditableText();
    }

    public void setPhoneAvailable(boolean z) {
        this.n = z & this.n;
        i();
    }
}
