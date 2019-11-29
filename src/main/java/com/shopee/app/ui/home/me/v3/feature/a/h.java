package com.shopee.app.ui.home.me.v3.feature.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.shopee.app.ui.home.me.v3.OptionBox;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class h extends g implements a, b {
    private boolean h = false;
    private final c i = new c();

    public h(Context context) {
        super(context);
        a();
    }

    public static g a(Context context) {
        h hVar = new h(context);
        hVar.onFinishInflate();
        return hVar;
    }

    public void onFinishInflate() {
        if (!this.h) {
            this.h = true;
            inflate(getContext(), R.layout.me_my_purchase_view, this);
            this.i.a((a) this);
        }
        super.onFinishInflate();
    }

    private void a() {
        c a2 = c.a(this.i);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public void onViewChanged(a aVar) {
        this.f22557a = (ViewGroup) aVar.internalFindViewById(R.id.my_purchase_detail_panel);
        this.f22558b = (OptionRow) aVar.internalFindViewById(R.id.my_purchase_button);
        this.f22559c = (OptionBox) aVar.internalFindViewById(R.id.my_purchase_to_pay_button);
        this.f22560d = (OptionBox) aVar.internalFindViewById(R.id.my_purchase_to_ship_button);
        this.f22561e = (OptionBox) aVar.internalFindViewById(R.id.my_purchase_to_return_button);
        this.f22562f = (OptionBox) aVar.internalFindViewById(R.id.my_purchase_to_receive_button);
        this.f22563g = (OptionBox) aVar.internalFindViewById(R.id.my_purchase_to_rate_button);
    }
}
