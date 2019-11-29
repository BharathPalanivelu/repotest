package com.shopee.app.h;

import android.view.View;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.google.android.material.snackbar.Snackbar;
import com.shopee.id.R;

public class q {
    public static void a(View view, String str) {
        a(view, str, -1);
    }

    public static void a(View view, int i) {
        a(view, b.e(i), -1);
    }

    public static void b(View view, String str) {
        a(view, str, 0);
    }

    private static void a(View view, String str, int i) {
        if (view.isShown()) {
            Snackbar a2 = Snackbar.a(view, str, i);
            TextView textView = (TextView) a2.d().findViewById(R.id.snackbar_text);
            textView.setTextColor(b.a(R.color.white));
            textView.setMaxLines(5);
            a2.e();
        }
    }
}
