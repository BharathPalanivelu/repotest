package com.airpay.paysdk.result.widget;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airpay.paysdk.base.d.f;
import com.airpay.paysdk.base.d.l;
import com.airpay.paysdk.c;
import com.airpay.paysdk.result.bean.a;

public class b extends LinearLayout {
    public b(Context context, a aVar) {
        super(context);
        setOrientation(1);
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setTextSize(2, 10.0f);
        int a2 = l.a(context, 16.0f);
        textView.setPadding(a2, a2, a2, a2);
        textView.setCompoundDrawablePadding(l.a(context, 8.0f));
        textView.setTextColor(getResources().getColor(c.b.com_garena_beepay_txt_color_light));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        textView.setLayoutParams(layoutParams);
        a(aVar, textView);
        f.a(textView);
        addView(textView);
    }

    private void a(a aVar, TextView textView) {
        String e2 = com.airpay.paysdk.base.different.a.a().e();
        Context context = getContext();
        CharSequence b2 = f.b(context, getResources().getString(c.i.com_garena_beepay_disclaimer_epin_topup_tip) + " [" + e2 + "]");
        Spannable b3 = f.b(context, getResources().getString(c.i.com_garena_beepay_label_airpay_customer_service, new Object[]{e2}));
        int r = aVar.r();
        if (r == 20011 || r == 20076) {
            b2 = TextUtils.concat(new CharSequence[]{getResources().getString(c.i.com_garena_beepay_ais_prepaid_disclaimer), "\n", b3});
        }
        int u = com.airpay.paysdk.pay.b.a.u(aVar.q().getExtraData());
        if (u == 1) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("  ");
            spannableStringBuilder.append(context.getString(c.i.com_garena_beepay_label_true_gateway_disclaimer));
            spannableStringBuilder.setSpan(new com.airpay.paysdk.result.c(textView.getContext(), c.d.disclaimer_truemoney), 0, 1, 33);
            b2 = TextUtils.concat(new CharSequence[]{spannableStringBuilder, "\n", b3});
        } else if (u == 2) {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("  ");
            spannableStringBuilder2.append(context.getString(c.i.com_garena_beepay_ais_prepaid_disclaimer));
            spannableStringBuilder2.setSpan(new com.airpay.paysdk.result.c(textView.getContext(), c.d.com_garena_beepay_icon_ais_disclaimer), 0, 1, 33);
            b2 = TextUtils.concat(new CharSequence[]{spannableStringBuilder2, "\n", b3});
        }
        textView.setText(b2);
    }
}
