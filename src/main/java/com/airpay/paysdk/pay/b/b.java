package com.airpay.paysdk.pay.b;

import android.view.View;
import com.airpay.paysdk.base.ui.weidget.c;

public class b {
    public static void a(View view, String str, int i, c.a aVar) {
        c cVar = new c(view.getContext());
        cVar.a((CharSequence) str);
        cVar.a(aVar);
        if (i != -1) {
            cVar.a(i);
        }
        cVar.a(view);
    }
}
