package com.airpay.paysdk.base.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.airpay.paysdk.base.d.k;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f3784a = new a();

    public static a a() {
        return f3784a;
    }

    /* renamed from: a */
    public void b(Context context, String str) {
        com.airpay.paysdk.common.c.a a2 = com.airpay.paysdk.common.c.a.a();
        if (!com.airpay.paysdk.common.c.a.c()) {
            a2.a(new Runnable(context, str) {
                private final /* synthetic */ Context f$1;
                private final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    a.this.b(this.f$1, this.f$2);
                }
            });
            return;
        }
        Toast makeText = Toast.makeText(context, str, 0);
        a(makeText.getView());
        makeText.show();
    }

    public void a(Context context, int i) {
        b(context, context.getString(i));
    }

    private void a(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setTypeface(k.a(childAt.getContext(), 3));
                    return;
                }
            }
        }
    }
}
