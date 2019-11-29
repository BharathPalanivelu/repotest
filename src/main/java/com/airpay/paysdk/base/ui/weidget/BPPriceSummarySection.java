package com.airpay.paysdk.base.ui.weidget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airpay.paysdk.base.d.f;
import com.airpay.paysdk.base.d.l;
import com.airpay.paysdk.c;
import com.airpay.paysdk.pay.b;
import java.lang.ref.WeakReference;

public class BPPriceSummarySection extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    protected View f3874a;

    /* renamed from: b  reason: collision with root package name */
    protected TextView f3875b;

    /* renamed from: c  reason: collision with root package name */
    protected TextView f3876c;

    /* renamed from: d  reason: collision with root package name */
    protected TextView f3877d;

    /* renamed from: e  reason: collision with root package name */
    protected TextView f3878e;

    /* renamed from: f  reason: collision with root package name */
    protected Button f3879f;

    /* renamed from: g  reason: collision with root package name */
    protected WeakReference<a> f3880g;
    protected CharSequence h;
    private ClickableSpan i = new ClickableSpan() {
        public void onClick(View view) {
            if (!TextUtils.isEmpty(BPPriceSummarySection.this.h)) {
                BPPriceSummarySection bPPriceSummarySection = BPPriceSummarySection.this;
                bPPriceSummarySection.a(bPPriceSummarySection.h);
            }
            if (BPPriceSummarySection.this.f3880g != null && BPPriceSummarySection.this.f3880g.get() != null) {
                ((a) BPPriceSummarySection.this.f3880g.get()).a();
            }
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
        }
    };

    public interface a {
        void a();
    }

    public BPPriceSummarySection(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public BPPriceSummarySection(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public BPPriceSummarySection(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    @TargetApi(21)
    public BPPriceSummarySection(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        inflate(context, c.h.com_garena_beepay_section_price_summary, this);
        this.f3875b = (TextView) findViewById(c.f.com_garena_beepay_txt_label);
        this.f3876c = (TextView) findViewById(c.f.com_garena_beepay_txt_price);
        this.f3877d = (TextView) findViewById(c.f.com_garena_beepay_txt_usual_price);
        this.f3879f = (Button) findViewById(c.f.com_garena_beepay_btn_next);
        this.f3874a = findViewById(c.f.com_garena_beepay_info_layout);
        this.f3878e = (TextView) findViewById(c.f.com_garena_beepay_txt_try_again);
        f.a(this.f3878e);
        int i2 = c.b.bg_color_blue;
        int i3 = c.b.bg_color_blue_dark;
        int i4 = c.b.bg_color_disabled;
        String string = context.getString(c.i.com_garena_beepay_label_subtotal);
        String string2 = context.getString(c.i.com_garena_beepay_label_next);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.k.BPPriceSummarySection);
            i2 = obtainStyledAttributes.getResourceId(c.k.BPPriceSummarySection_normal_color, i2);
            i3 = obtainStyledAttributes.getResourceId(c.k.BPPriceSummarySection_highlight_color, i3);
            i4 = obtainStyledAttributes.getResourceId(c.k.BPPriceSummarySection_disabled_color, i4);
            String string3 = obtainStyledAttributes.getString(c.k.BPPriceSummarySection_label_text);
            if (!TextUtils.isEmpty(string3)) {
                string = string3;
            }
            String string4 = obtainStyledAttributes.getString(c.k.BPPriceSummarySection_ap_btn_text);
            if (!TextUtils.isEmpty(string4)) {
                string2 = string4;
            }
            obtainStyledAttributes.recycle();
        }
        Resources resources = context.getResources();
        a(resources.getColor(i2), resources.getColor(i3), resources.getColor(i4));
        this.f3879f.setText(string2);
        this.f3879f.setEnabled(false);
        this.f3875b.setText(string);
    }

    public void a(int i2, int i3, int i4) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        float a2 = (float) l.a(getContext(), 2.0f);
        gradientDrawable.setCornerRadius(a2);
        gradientDrawable.setColor(i4);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(a2);
        gradientDrawable2.setColor(i2);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setCornerRadius(a2);
        gradientDrawable3.setColor(i3);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910, 16842919}, gradientDrawable3);
        stateListDrawable.addState(new int[]{16842910}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        if (Build.VERSION.SDK_INT >= 16) {
            this.f3879f.setBackground(stateListDrawable);
        } else {
            this.f3879f.setBackgroundDrawable(stateListDrawable);
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f3879f.setEnabled(z);
    }

    public void setOnNextPressedListener(View.OnClickListener onClickListener) {
        this.f3879f.setOnClickListener(onClickListener);
    }

    public void setBtnText(CharSequence charSequence) {
        this.f3879f.setText(charSequence);
    }

    public void a(long j, CharSequence charSequence) {
        this.f3878e.setVisibility(8);
        this.f3876c.setVisibility(0);
        this.f3876c.setText(b.b((double) j));
        if (TextUtils.isEmpty(charSequence)) {
            this.f3877d.setVisibility(8);
            return;
        }
        this.f3877d.setVisibility(0);
        this.f3877d.setText(charSequence);
    }

    public void setInfoLayoutVisibility(int i2) {
        this.f3874a.setVisibility(i2);
    }

    public void a(CharSequence charSequence) {
        this.f3878e.setVisibility(0);
        this.f3876c.setVisibility(8);
        this.f3877d.setVisibility(8);
        this.f3878e.setText(charSequence);
    }
}
