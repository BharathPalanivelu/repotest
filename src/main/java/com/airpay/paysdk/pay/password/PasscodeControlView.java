package com.airpay.paysdk.pay.password;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.airpay.paysdk.base.d.l;
import com.airpay.paysdk.base.ui.weidget.d;
import com.airpay.paysdk.c;
import com.airpay.paysdk.pay.ui.b;
import java.util.ArrayList;
import java.util.List;

public class PasscodeControlView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f4218a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f4219b;

    /* renamed from: c  reason: collision with root package name */
    private EditText f4220c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public List<ImageView> f4221d = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f4222e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f4223f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f4224g;
    private Drawable h;
    private com.airpay.paysdk.pay.ui.b i;
    /* access modifiers changed from: private */
    public a j;
    private Runnable k = new Runnable() {
        public void run() {
            if (PasscodeControlView.this.j != null) {
                PasscodeControlView.this.j.onComplete();
            }
            int unused = PasscodeControlView.this.f4222e = 0;
        }
    };
    private b.a l = new b.a() {
        public final void onStop() {
            PasscodeControlView.this.e();
        }
    };
    /* access modifiers changed from: private */
    public int m = 0;
    /* access modifiers changed from: private */
    public b n;
    private TextWatcher o = new TextWatcher() {
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (PasscodeControlView.this.n != null) {
                PasscodeControlView.this.n.a(i);
            }
        }

        public void afterTextChanged(Editable editable) {
            int length = editable.length();
            if (length == PasscodeControlView.this.m + 1) {
                PasscodeControlView passcodeControlView = PasscodeControlView.this;
                passcodeControlView.a((ImageView) passcodeControlView.f4221d.get(length - 1), true);
            } else if (length == PasscodeControlView.this.m - 1) {
                PasscodeControlView passcodeControlView2 = PasscodeControlView.this;
                passcodeControlView2.a((ImageView) passcodeControlView2.f4221d.get(PasscodeControlView.this.m - 1));
            } else {
                PasscodeControlView.this.f();
            }
            int unused = PasscodeControlView.this.m = length;
            if (length == 6 && PasscodeControlView.this.n != null) {
                PasscodeControlView.this.n.a();
            }
        }
    };

    public interface a {
        void onComplete();
    }

    public interface b {
        void a();

        void a(int i);
    }

    public PasscodeControlView(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public PasscodeControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public PasscodeControlView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        int i2;
        int i3;
        this.f4224g = androidx.appcompat.a.a.a.b(context, c.d.widget_password_dot_default);
        this.h = androidx.appcompat.a.a.a.b(context, c.d.widget_password_dot_error);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.k.PasscodeControlView);
        this.f4223f = obtainStyledAttributes.getInt(c.k.PasscodeControlView_passcode_input_style, 0);
        obtainStyledAttributes.recycle();
        inflate(context, c.h.com_garena_beepay_password_control, this);
        this.f4220c = (EditText) findViewById(c.f.com_garena_beepay_payment_password_field);
        this.f4220c.setSaveEnabled(false);
        this.f4219b = (LinearLayout) findViewById(c.f.com_garena_beepay_dot_linear);
        this.f4218a = (ImageView) findViewById(c.f.com_garena_beepay_loading_image_view);
        Resources resources = context.getResources();
        if (this.f4223f != 1) {
            i2 = l.a(context, 40.0f);
            i3 = l.a(context, 36.0f);
        } else {
            int a2 = l.a(context, 24.0f);
            this.f4219b.setBackgroundResource(c.d.com_garena_beepay_view_border_section_bg);
            this.f4219b.setDividerDrawable(resources.getDrawable(c.d.com_garena_beepay_divider_vertical));
            this.f4219b.setShowDividers(7);
            i2 = (int) resources.getDimension(c.C0074c.com_garena_beepay_item_height);
            i3 = a2;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i3, i3);
        for (int i4 = 0; i4 < 6; i4++) {
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            a(imageView);
            this.f4221d.add(imageView);
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setGravity(17);
            linearLayout.addView(imageView, layoutParams2);
            this.f4219b.addView(linearLayout, layoutParams);
        }
        this.f4220c.addTextChangedListener(this.o);
        a(true);
    }

    public void setDefaultDrawable(Drawable drawable) {
        this.f4224g = drawable;
        f();
    }

    public void a() {
        if (this.f4222e != 1) {
            androidx.m.a.a.c a2 = androidx.m.a.a.c.a(getContext(), c.d.com_garena_beepay_animated_payment_loading);
            com.airpay.paysdk.pay.ui.b bVar = this.i;
            if (bVar != null) {
                bVar.c();
                this.i = null;
                com.airpay.paysdk.common.c.a.a().b(this.k);
            }
            if (a2 != null) {
                int integer = getResources().getInteger(c.g.payment_loading_total_period);
                this.f4218a.setImageDrawable(a2);
                this.i = new com.airpay.paysdk.pay.ui.b(a2, integer);
                this.i.a();
            }
            this.f4218a.setVisibility(0);
            this.f4219b.setVisibility(4);
            this.f4220c.setVisibility(4);
            this.f4220c.setEnabled(false);
            this.f4222e = 1;
        }
    }

    public void a(a aVar) {
        if (this.f4222e != 2) {
            this.j = aVar;
            com.airpay.paysdk.pay.ui.b bVar = this.i;
            if (bVar != null) {
                bVar.a(this.l);
                this.i = null;
                com.airpay.paysdk.common.c.a.a().b(this.k);
            } else {
                e();
            }
            this.f4218a.setVisibility(0);
            this.f4219b.setVisibility(4);
            this.f4220c.setVisibility(4);
            this.f4220c.setEnabled(false);
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        androidx.m.a.a.c a2 = androidx.m.a.a.c.a(getContext(), c.d.com_garena_beepay_animated_payment_successful);
        if (a2 != null) {
            this.f4218a.setImageDrawable(a2);
            a2.start();
        }
        if (this.j != null) {
            com.airpay.paysdk.common.c.a.a().a(this.k, (long) (getResources().getInteger(c.g.payment_loading_period) + 1000));
        }
        this.f4222e = 2;
    }

    public void a(int i2) {
        com.airpay.paysdk.pay.ui.b bVar = this.i;
        if (bVar != null) {
            bVar.c();
            this.i = null;
            com.airpay.paysdk.common.c.a.a().b(this.k);
        }
        this.f4218a.setVisibility(0);
        this.f4219b.setVisibility(4);
        this.f4220c.setVisibility(4);
        this.f4220c.setEnabled(false);
        this.f4218a.setImageResource(i2);
        this.f4222e = 0;
    }

    public void b() {
        com.airpay.paysdk.pay.ui.b bVar = this.i;
        if (bVar != null) {
            bVar.b();
            this.i = null;
            com.airpay.paysdk.common.c.a.a().b(this.k);
        }
    }

    public void c() {
        this.f4218a.setVisibility(4);
        this.f4219b.setVisibility(0);
        this.f4220c.setVisibility(0);
        this.f4220c.setEnabled(true);
        com.airpay.paysdk.pay.ui.b bVar = this.i;
        if (bVar != null) {
            bVar.c();
            this.i = null;
            com.airpay.paysdk.common.c.a.a().b(this.k);
        }
        f();
        this.f4222e = 0;
    }

    public String getPassword() {
        return this.f4220c.getText().toString();
    }

    public void d() {
        this.f4220c.setText("");
    }

    public void a(boolean z) {
        if (!z || !this.f4220c.isEnabled()) {
            this.f4220c.clearFocus();
            d.a((View) this.f4220c);
            return;
        }
        this.f4220c.requestFocus();
        d.b(this.f4220c);
    }

    public void setPasswordFieldEnabled(boolean z) {
        this.f4220c.setEnabled(z);
    }

    public void setCompleteCallback(b bVar) {
        this.n = bVar;
    }

    /* access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        androidx.m.a.a.c a2 = androidx.m.a.a.c.a(getContext(), c.d.widget_password_dot_filled_animated);
        if (a2 != null) {
            imageView.setImageDrawable(a2);
            if (z) {
                a2.start();
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(ImageView imageView) {
        if (this.f4223f == 0) {
            Drawable drawable = this.f4224g;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                return;
            }
        }
        imageView.setImageDrawable((Drawable) null);
    }

    /* access modifiers changed from: private */
    public void f() {
        int length = this.f4220c.getText().length();
        int i2 = 0;
        for (ImageView next : this.f4221d) {
            int i3 = length - 1;
            if (i2 < i3) {
                a(next, false);
            } else if (i2 == i3) {
                a(next, this.m < length);
            } else {
                a(next);
            }
            i2++;
        }
    }
}
