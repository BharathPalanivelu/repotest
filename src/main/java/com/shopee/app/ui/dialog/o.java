package com.shopee.app.ui.dialog;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.a;
import com.shopee.app.util.au;
import com.shopee.id.R;

public class o extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    TextView f21597a;

    /* renamed from: b  reason: collision with root package name */
    TextView f21598b;

    /* renamed from: c  reason: collision with root package name */
    TextView f21599c;

    /* renamed from: d  reason: collision with root package name */
    Button f21600d;

    public o(Context context) {
        super(context);
    }

    public boolean a(a aVar, View.OnClickListener onClickListener) {
        try {
            this.f21597a.setText(b.a(R.string.sp_label_voucher_info_title, au.b(aVar.d())));
            this.f21598b.setText(aVar.b());
            if (aVar.c() > 0) {
                this.f21599c.setText(b.a(R.string.sp_label_voucher_info_desc, au.b(aVar.c())));
            } else {
                this.f21599c.setText("");
            }
            this.f21600d.setOnClickListener(onClickListener);
            return true;
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return false;
        }
    }
}
