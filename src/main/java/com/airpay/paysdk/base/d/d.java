package com.airpay.paysdk.base.d;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.airpay.paysdk.common.b.a;

public class d {
    public static void a(View view, int i, CharSequence charSequence) {
        View findViewById = view.findViewById(i);
        if (findViewById instanceof TextView) {
            ((TextView) findViewById).setText(charSequence);
            return;
        }
        a.a("not textview control:%s", findViewById);
    }

    public static void a(View view, int i, int i2) {
        View findViewById = view.findViewById(i);
        if (findViewById instanceof TextView) {
            ((TextView) findViewById).setText(i2);
        } else {
            a.a("not textview control", new Object[0]);
        }
    }

    public static void a(View view, int i, View.OnClickListener onClickListener) {
        View findViewById = view.findViewById(i);
        if (findViewById != null) {
            findViewById.setOnClickListener(onClickListener);
        }
    }

    public static void b(View view, int i, int i2) {
        View findViewById = view.findViewById(i);
        if (findViewById != null) {
            findViewById.setVisibility(i2);
        }
    }

    public static void a(Activity activity, int i, int i2) {
        View findViewById = activity.findViewById(i);
        if (findViewById != null) {
            findViewById.setVisibility(i2);
        }
    }
}
