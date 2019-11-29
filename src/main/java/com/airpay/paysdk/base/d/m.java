package com.airpay.paysdk.base.d;

import android.text.TextUtils;
import android.widget.ImageView;
import com.squareup.a.w;

public class m {
    public static void a(ImageView imageView, String str, int i) {
        if (TextUtils.isEmpty(str)) {
            imageView.setImageResource(i);
        } else {
            w.a(imageView.getContext()).a(str).a(i).a(imageView);
        }
    }
}
