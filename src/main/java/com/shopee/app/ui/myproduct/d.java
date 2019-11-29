package com.shopee.app.ui.myproduct;

import android.content.Context;
import android.view.View;
import com.garena.android.uikit.a.a;
import com.garena.android.uikit.a.a.b;
import com.shopee.app.ui.common.an;
import com.shopee.app.ui.common.ao;
import com.shopee.app.ui.myproduct.a.i;
import com.shopee.id.R;

public class d extends a {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f23430c = {R.string.sp_label_latest, R.string.sp_label_popular, R.string.sp_label_stock, R.string.sp_label_sold_out, R.string.unlisted};

    /* renamed from: d  reason: collision with root package name */
    private final boolean f23431d;

    public View a(Context context) {
        return null;
    }

    public d(boolean z) {
        this.f23431d = z;
    }

    public int b() {
        return this.f23431d ? 5 : 4;
    }

    public b d(Context context, int i) {
        ao aoVar;
        if (i == 1) {
            aoVar = new an(context, 1);
        } else if (i != 2) {
            aoVar = new ao(context);
        } else {
            aoVar = new an(context, 0);
        }
        aoVar.setTitle(com.garena.android.appkit.tools.b.e(f23430c[i]));
        return aoVar;
    }

    public com.garena.android.uikit.a.a.a e(Context context, int i) {
        if (i == 1) {
            return i.a(context, 2);
        }
        if (i == 2) {
            return i.a(context, 3);
        }
        if (i == 3) {
            return i.a(context, 4);
        }
        if (i != 4) {
            return i.a(context, 1);
        }
        return i.a(context, 9);
    }
}
