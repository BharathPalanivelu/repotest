package com.shopee.livequiz.g;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.shopee.livequiz.b;
import com.shopee.livequiz.c;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private static Toast f29875a;

    public static void a(String str) {
        Context c2 = b.a().c();
        if (f29875a == null) {
            f29875a = Toast.makeText(c2, (CharSequence) null, 0);
        }
        TextView textView = new TextView(c2);
        textView.setBackgroundResource(c.C0454c.livequiz_bg_toast);
        textView.setTextColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int d2 = com.garena.android.appkit.tools.b.d(c.b.livequiz_custom_toast_width);
        int d3 = com.garena.android.appkit.tools.b.d(c.b.livequiz_custom_toast_min_height);
        int d4 = com.garena.android.appkit.tools.b.d(c.b.livequiz_custom_toast_padding_horizontal);
        int d5 = com.garena.android.appkit.tools.b.d(c.b.livequiz_custom_toast_padding_vertical);
        layoutParams.width = d2;
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(0, (float) com.garena.android.appkit.tools.b.d(c.b.livequiz_toast_text_size));
        textView.setWidth(d2);
        textView.setMinHeight(d3);
        textView.setPadding(d4, d5, d4, d5);
        textView.setGravity(17);
        textView.setText(str);
        f29875a.setView(textView);
        f29875a.setGravity(17, 0, 0);
        f29875a.show();
    }
}
