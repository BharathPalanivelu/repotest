package com.airpay.paysdk.result.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airpay.paysdk.base.d.l;
import com.airpay.paysdk.c;
import com.airpay.paysdk.result.d;
import com.litesuits.orm.db.assit.SQLBuilder;

public abstract class m extends f {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final int f4528a = l.a(com.airpay.paysdk.a.a().b(), 16.0f);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final int f4529b = l.a(com.airpay.paysdk.a.a().b(), 16.0f);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final int f4530c = l.a(com.airpay.paysdk.a.a().b(), 4.0f);

    /* renamed from: d  reason: collision with root package name */
    private static final int f4531d = l.a(com.airpay.paysdk.a.a().b(), 7.0f);

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: protected */
    public abstract int getBottomDividerStatus();

    /* access modifiers changed from: protected */
    public abstract int getTopDividerStatus();

    public m(Context context) {
        super(context);
        setOrientation(1);
        setBackgroundResource(c.d.com_garena_beepay_view_touchable_white_bg);
    }

    public void b() {
        Context context = getContext();
        removeAllViews();
        a(context, getTopDividerStatus(), false);
        a();
        a(context, getBottomDividerStatus(), true);
    }

    private void a(Context context, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        View view = new View(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (int) getResources().getDimension(c.C0074c.com_garena_beepay_border_width_thin));
        int i5 = 0;
        if (i == 1) {
            i3 = l.a(getContext(), 16.0f);
            i2 = l.a(getContext(), 16.0f);
        } else {
            i3 = 0;
            i2 = 0;
        }
        if (z) {
            i4 = f4531d;
        } else {
            i5 = f4531d;
            i4 = 0;
        }
        layoutParams.setMargins(i3, i4, i2, i5);
        view.setLayoutParams(layoutParams);
        if (i == 2 || i == 1) {
            view.setBackgroundResource(c.b.border_color_normal);
        } else {
            view.setBackgroundResource(c.b.transparent);
        }
        addView(view);
    }

    public static class c extends LinearLayout implements d {

        /* renamed from: a  reason: collision with root package name */
        private TextView f4536a;

        /* renamed from: b  reason: collision with root package name */
        private TextView f4537b;

        public c(Context context, CharSequence charSequence, CharSequence charSequence2) {
            this(context, charSequence, charSequence2, false);
        }

        public c(Context context, CharSequence charSequence, CharSequence charSequence2, int i) {
            this(context, charSequence, charSequence2, i, false);
        }

        public c(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z) {
            this(context, charSequence, charSequence2, c.b.txt_color_grey, z);
        }

        public c(Context context, CharSequence charSequence, CharSequence charSequence2, int i, boolean z) {
            super(context);
            setBackgroundResource(c.b.transparent);
            setOrientation(0);
            setGravity(48);
            setPadding(m.f4528a, m.f4530c, m.f4528a, m.f4530c);
            this.f4536a = new TextView(context);
            this.f4536a.setTextSize(2, 15.0f);
            Resources resources = getResources();
            this.f4536a.setTextColor(resources.getColor(c.b.txt_color_grey));
            this.f4536a.setText(charSequence);
            this.f4537b = new TextView(context);
            this.f4537b.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.f4537b.setText(charSequence2);
            this.f4537b.setTextSize(2, 15.0f);
            this.f4537b.setPadding(m.f4529b, 0, 0, 0);
            this.f4537b.setGravity(8388613);
            this.f4537b.setTextColor(resources.getColor(i));
            if (z) {
                Drawable drawable = resources.getDrawable(c.d.com_garena_beepay_icon_arrow_right);
                drawable.setBounds(0, 0, m.f4529b, m.f4529b);
                this.f4537b.setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            }
            addView(this.f4536a);
            addView(this.f4537b);
        }

        public int getFieldMeasuredWidth() {
            return this.f4536a.getMeasuredWidth();
        }

        public void setFieldWidth(int i) {
            this.f4536a.getLayoutParams().width = i;
        }

        public void a(int i, int i2) {
            this.f4537b.setTextSize(2, (float) i);
            this.f4537b.setTextColor(i2);
        }
    }

    public static class b extends LinearLayout implements d {

        /* renamed from: a  reason: collision with root package name */
        private TextView f4534a;

        /* renamed from: b  reason: collision with root package name */
        private TextView f4535b;

        @SuppressLint({"SetTextI18n"})
        public b(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4) {
            super(context);
            setBackgroundResource(c.b.transparent);
            setOrientation(0);
            setGravity(48);
            setPadding(m.f4528a, m.f4530c, m.f4528a, m.f4530c);
            this.f4534a = new TextView(context);
            this.f4534a.setTextSize(2, 15.0f);
            Resources resources = getResources();
            this.f4534a.setTextColor(resources.getColor(c.b.txt_color_grey));
            this.f4534a.setText(charSequence);
            this.f4535b = new TextView(context);
            this.f4535b.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            TextView textView = this.f4535b;
            textView.setText(charSequence2 + SQLBuilder.BLANK + charSequence3 + SQLBuilder.BLANK + charSequence4);
            this.f4535b.setTextSize(2, 15.0f);
            this.f4535b.setPadding(m.f4529b, 0, 0, 0);
            this.f4535b.setGravity(8388613);
            this.f4535b.setMaxLines(2);
            this.f4535b.setTextColor(resources.getColor(c.b.txt_color_grey));
            addView(this.f4534a);
            addView(this.f4535b);
        }

        public int getFieldMeasuredWidth() {
            return this.f4534a.getWidth();
        }

        public void setFieldWidth(int i) {
            this.f4534a.getLayoutParams().width = i;
            this.f4535b.requestLayout();
        }
    }

    public static class a extends LinearLayout implements d {

        /* renamed from: a  reason: collision with root package name */
        private TextView f4532a;

        /* renamed from: b  reason: collision with root package name */
        private d f4533b;

        public a(Context context, CharSequence charSequence, CharSequence charSequence2) {
            super(context);
            setBackgroundResource(c.b.transparent);
            setPadding(m.f4528a, m.f4530c, m.f4528a, m.f4530c);
            this.f4532a = new TextView(context);
            this.f4532a.setTextSize(2, 15.0f);
            Resources resources = getResources();
            this.f4532a.setTextColor(resources.getColor(c.b.txt_color_grey));
            this.f4532a.setText(charSequence);
            this.f4533b = new d(context);
            this.f4533b.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.f4533b.a(2, 15);
            this.f4533b.setPadding(m.f4529b, 0, 0, 0);
            this.f4533b.setTextGravity(8388613);
            this.f4533b.setTextColor(resources.getColor(c.b.txt_color_grey));
            this.f4533b.setText(charSequence2);
            addView(this.f4532a);
            addView(this.f4533b);
        }

        public int getFieldMeasuredWidth() {
            return this.f4532a.getMeasuredWidth();
        }

        public void setFieldWidth(int i) {
            this.f4532a.getLayoutParams().width = i;
            this.f4533b.c();
        }

        public void a(int i, int i2) {
            this.f4533b.a(2, i);
            this.f4533b.setTextColor(i2);
        }
    }
}
