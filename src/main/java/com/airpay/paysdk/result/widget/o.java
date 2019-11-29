package com.airpay.paysdk.result.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airpay.paysdk.c;

public abstract class o extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public View f4541a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f4542b;

    /* renamed from: c  reason: collision with root package name */
    private View.OnClickListener f4543c;

    /* renamed from: d  reason: collision with root package name */
    private int f4544d = 2;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f4545e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4546f = false;

    public abstract void a();

    public abstract void b();

    public abstract int getLayoutResId();

    public o(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        inflate(context, getLayoutResId(), this);
        this.f4542b = (TextView) findViewById(c.f.com_garena_beepay_txt_content);
        this.f4541a = findViewById(c.f.com_garena_beepay_img_expand);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.k.BPExpandableTextLayout);
            this.f4544d = obtainStyledAttributes.getInt(c.k.BPExpandableTextLayout_allowed_lines, 2);
            obtainStyledAttributes.recycle();
        }
        this.f4543c = new View.OnClickListener() {
            public void onClick(View view) {
                o oVar = o.this;
                boolean unused = oVar.f4545e = !oVar.f4545e;
                o oVar2 = o.this;
                oVar2.a(oVar2.f4545e);
            }
        };
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f4546f) {
            super.onMeasure(i, i2);
            return;
        }
        this.f4542b.setMaxLines(Integer.MAX_VALUE);
        super.onMeasure(i, i2);
        if (this.f4542b.getLineCount() > this.f4544d) {
            this.f4541a.setVisibility(0);
            a(this.f4545e);
            setOnClickListener(this.f4543c);
        } else {
            this.f4541a.setVisibility(8);
            a(true);
            setOnClickListener((View.OnClickListener) null);
        }
        this.f4546f = true;
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.f4542b.setMaxLines(Integer.MAX_VALUE);
            this.f4542b.setEllipsize((TextUtils.TruncateAt) null);
            this.f4542b.setMovementMethod(LinkMovementMethod.getInstance());
            a();
        } else {
            this.f4542b.setMaxLines(this.f4544d);
            this.f4542b.setEllipsize(TextUtils.TruncateAt.END);
            this.f4542b.setMovementMethod((MovementMethod) null);
            b();
        }
        requestLayout();
    }

    public void c() {
        this.f4546f = false;
    }

    public void setText(CharSequence charSequence) {
        this.f4542b.setText(charSequence);
        c();
    }

    public void setTypeface(Typeface typeface) {
        this.f4542b.setTypeface(typeface);
        c();
    }

    public void a(int i, int i2) {
        this.f4542b.setTextSize(i, (float) i2);
        c();
    }

    public void setTextGravity(int i) {
        this.f4542b.setGravity(i);
    }

    public void setTextColor(int i) {
        this.f4542b.setTextColor(i);
    }

    public int getLineCount() {
        return this.f4542b.getLineCount();
    }
}
