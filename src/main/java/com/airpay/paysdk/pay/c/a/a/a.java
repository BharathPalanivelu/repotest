package com.airpay.paysdk.pay.c.a.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airpay.paysdk.base.d.l;
import com.airpay.paysdk.c;

public abstract class a extends com.airpay.paysdk.pay.c.a.a {

    /* renamed from: b  reason: collision with root package name */
    private int f4164b;

    /* renamed from: c  reason: collision with root package name */
    private int f4165c;

    /* access modifiers changed from: protected */
    public abstract C0082a a(Context context);

    public a(boolean z, int i, int i2) {
        this.f4163a = z;
        this.f4164b = i;
        this.f4165c = i2;
    }

    public void a(View view) {
        b bVar = (b) view.getTag();
        C0082a a2 = a(view.getContext());
        bVar.f4175c.setImageResource(a2.f4168c);
        if (TextUtils.isEmpty(a2.f4167b)) {
            bVar.f4178f.setVisibility(8);
        } else {
            bVar.f4178f.setVisibility(0);
            bVar.f4178f.setText(a2.f4167b);
        }
        bVar.f4176d.setText(a2.f4166a);
        bVar.f4177e.setText(a2.f4169d);
        a(bVar.f4179g, a2.f4170e);
        a(bVar.h, a2.f4171f);
        a(bVar.j, a2.h);
        a(bVar.i, a2.f4172g);
        a(bVar.k, this.f4164b);
        a(bVar.l, this.f4165c);
        bVar.f4174b.setImageResource(a2.i);
        bVar.f4174b.setSelected(this.f4163a);
        bVar.f4177e.setSelected(this.f4163a);
        if (a2.j) {
            bVar.f4173a.setAlpha(1.0f);
            bVar.f4177e.setVisibility(0);
            return;
        }
        bVar.f4173a.setAlpha(0.5f);
        bVar.f4177e.setVisibility(4);
    }

    private void a(View view, int i) {
        if (i == 0) {
            view.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            view.setLayoutParams(layoutParams);
        } else if (i != 1) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams2.setMargins(l.a(view.getContext(), 48.0f), 0, 0, 0);
            view.setLayoutParams(layoutParams2);
        }
    }

    private void a(TextView textView, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(charSequence);
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(c.h.com_garena_beepay_item_payment_option_choice, viewGroup, false);
        b bVar = new b();
        View unused = bVar.f4173a = inflate.findViewById(c.f.layout_content);
        ImageView unused2 = bVar.f4175c = (ImageView) inflate.findViewById(c.f.com_garena_beepay_img_channel_icon);
        ImageView unused3 = bVar.f4174b = (ImageView) inflate.findViewById(c.f.com_garena_beepay_img_selection);
        TextView unused4 = bVar.f4176d = (TextView) inflate.findViewById(c.f.com_garena_beepay_txt_channel_name);
        TextView unused5 = bVar.f4177e = (TextView) inflate.findViewById(c.f.com_garena_beepay_txt_amount);
        TextView unused6 = bVar.f4178f = (TextView) inflate.findViewById(c.f.com_garena_beepay_txt_extra);
        TextView unused7 = bVar.f4179g = (TextView) inflate.findViewById(c.f.com_garena_beepay_txt_transaction_fee);
        TextView unused8 = bVar.h = (TextView) inflate.findViewById(c.f.com_garena_beepay_txt_discount);
        TextView unused9 = bVar.j = (TextView) inflate.findViewById(c.f.com_garena_beepay_txt_promotion);
        TextView unused10 = bVar.i = (TextView) inflate.findViewById(c.f.com_garena_beepay_txt_rebate);
        View unused11 = bVar.k = inflate.findViewById(c.f.com_garena_beepay_divider_top);
        View unused12 = bVar.l = inflate.findViewById(c.f.com_garena_beepay_divider_bottom);
        inflate.setTag(bVar);
        return inflate;
    }

    private static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public View f4173a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public ImageView f4174b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public ImageView f4175c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public TextView f4176d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public TextView f4177e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public TextView f4178f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public TextView f4179g;
        /* access modifiers changed from: private */
        public TextView h;
        /* access modifiers changed from: private */
        public TextView i;
        /* access modifiers changed from: private */
        public TextView j;
        /* access modifiers changed from: private */
        public View k;
        /* access modifiers changed from: private */
        public View l;

        private b() {
        }
    }

    /* renamed from: com.airpay.paysdk.pay.c.a.a.a$a  reason: collision with other inner class name */
    protected static class C0082a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f4166a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f4167b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f4168c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public CharSequence f4169d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public CharSequence f4170e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f4171f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public CharSequence f4172g;
        /* access modifiers changed from: private */
        public CharSequence h;
        /* access modifiers changed from: private */
        public int i;
        /* access modifiers changed from: private */
        public boolean j;

        public C0082a(String str, String str2, int i2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, int i3, boolean z) {
            this.f4166a = str;
            this.f4167b = str2;
            this.f4168c = i2;
            this.f4169d = charSequence;
            this.f4170e = charSequence2;
            this.f4171f = charSequence3;
            this.f4172g = charSequence4;
            this.h = charSequence5;
            this.i = i3;
            this.j = z;
        }
    }
}
