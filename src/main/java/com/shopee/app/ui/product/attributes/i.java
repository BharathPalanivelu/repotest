package com.shopee.app.ui.product.attributes;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.garena.android.appkit.d.a;
import com.shopee.app.ui.a.n;
import com.shopee.app.util.bm;

public class i extends LinearLayout implements n<v> {

    /* renamed from: a  reason: collision with root package name */
    View f24291a;

    /* renamed from: b  reason: collision with root package name */
    TextView f24292b;

    public i(Context context) {
        super(context);
    }

    public void a(v vVar) {
        this.f24291a.setVisibility(vVar.f24353g ? 0 : 8);
        this.f24292b.setText(Html.fromHtml(bm.b(a(vVar.f24352f, vVar.f24350d), vVar.a())));
    }

    private String a(String str, int i) {
        if (i != 6) {
            return str;
        }
        int i2 = -1;
        try {
            i2 = Integer.valueOf(str).intValue();
        } catch (NumberFormatException e2) {
            a.a(e2);
        }
        return i2 >= 0 ? com.garena.android.appkit.tools.a.a.c(i2, "ID") : "";
    }
}
