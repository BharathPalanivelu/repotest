package com.shopee.app.ui.product.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.a.a.f;
import com.garena.android.appkit.tools.a.b;
import com.shopee.app.g.d;
import com.shopee.app.ui.dialog.a;
import com.shopee.id.R;

public class b extends a implements View.OnClickListener {
    public b(Context context) {
        super(context);
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void d() {
        f a2 = f.a(getContext());
        a2.a(" (").a().b(com.garena.android.appkit.tools.b.a(R.color.black26)).a(b.a.h).c().b().b().a((int) R.string.sp_label_shipping_fee_included).a().b(com.garena.android.appkit.tools.b.a(R.color.black26)).a(b.a.h).c().b().b().a(") ").a().b(com.garena.android.appkit.tools.b.a(R.color.black26)).a(b.a.h).c().b().b().b((int) R.drawable.com_garena_shopee_ic_help_outline).b(b.a.j).c(b.a.j).a();
        this.f24611c.append(a2.b());
        this.f24611c.setOnClickListener(this);
    }

    public void a(Context context) {
        super.a(context);
        d.a(this.f24609a);
    }

    public void onClick(View view) {
        a.a(getContext(), 0, (int) R.string.sp_shipping_fee_tooltip, 0, (int) R.string.sp_label_ok);
    }
}
