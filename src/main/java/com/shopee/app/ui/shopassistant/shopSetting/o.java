package com.shopee.app.ui.shopassistant.shopSetting;

import android.content.Context;
import android.view.View;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class o extends n implements a, b {
    private boolean n = false;
    private final c o = new c();

    public o(Context context) {
        super(context);
        f();
    }

    public static n a(Context context) {
        o oVar = new o(context);
        oVar.onFinishInflate();
        return oVar;
    }

    public void onFinishInflate() {
        if (!this.n) {
            this.n = true;
            inflate(getContext(), R.layout.shop_settings_layout, this);
            this.o.a((a) this);
        }
        super.onFinishInflate();
    }

    private void f() {
        c a2 = c.a(this.o);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f25614g = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.buyer_seller_self);
        this.h = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.allow_negotiation);
        this.i = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.show_full_address);
        this.j = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.phone_visible_setting);
        this.k = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.vacation_mode);
        this.l = aVar.internalFindViewById(R.id.chat_auto_reply);
        if (this.l != null) {
            this.l.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    o.this.e();
                }
            });
        }
        c();
    }
}
