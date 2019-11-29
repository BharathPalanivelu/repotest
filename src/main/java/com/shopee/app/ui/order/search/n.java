package com.shopee.app.ui.order.search;

import android.content.Context;
import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.ui.a.s;
import com.shopee.id.R;

public class n implements s<f> {
    public int a() {
        return 9;
    }

    public int a(f fVar, int i) {
        return fVar.f23810a;
    }

    public View a(Context context, int i) {
        switch (i) {
            case 0:
                View view = new View(context);
                view.setBackgroundColor(b.a(R.color.background_divider));
                return view;
            case 1:
            case 2:
            case 3:
                return k.a(context);
            case 4:
                return h.a(context);
            case 5:
            case 6:
            case 7:
                return h.a(context);
            case 8:
                return h.a(context);
            default:
                return null;
        }
    }
}
