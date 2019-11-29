package com.shopee.live.livestreaming.ui.view.d;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.live.livestreaming.c;

public class b {
    public static void a(Context context, TextView textView, String str, String str2, String str3, float f2, float f3, int i, int i2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + SQLBuilder.BLANK + str2 + "：" + str3);
        int length = str.length() + str2.length() + 2;
        if (!(str == null || "" == str)) {
            spannableStringBuilder.setSpan(new a(context.getResources().getColor(c.b.main_color), context.getResources().getColor(c.b.white), i2, (int) a(context, (float) i)), 0, str.length(), 33);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) a(context, f2)), 0, str.length(), 18);
        }
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FFDBD0")), str.length(), length, 33);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) a(context, f3)), str.length(), length, 18);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) a(context, (float) i)), length, spannableStringBuilder.length(), 18);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        spannableStringBuilder2.append(spannableStringBuilder);
        textView.setText(spannableStringBuilder2);
    }

    public static void a(Context context, TextView textView, String str, String str2, float f2, int i) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + "：" + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#EEEBC3")), 0, str.length() + 1, 33);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) a(context, f2)), 0, str.length() + 1, 18);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) a(context, (float) i)), str.length() + 1, spannableStringBuilder.length(), 18);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        spannableStringBuilder2.append(spannableStringBuilder);
        textView.setText(spannableStringBuilder2);
    }

    public static float a(Context context, float f2) {
        return f2 * context.getResources().getDisplayMetrics().scaledDensity;
    }
}
