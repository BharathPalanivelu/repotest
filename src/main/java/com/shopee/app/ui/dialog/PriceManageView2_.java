package com.shopee.app.ui.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class PriceManageView2_ extends c implements a, b {

    /* renamed from: d  reason: collision with root package name */
    private boolean f21484d = false;

    /* renamed from: e  reason: collision with root package name */
    private final c f21485e = new c();

    public PriceManageView2_(Context context) {
        super(context);
        b();
    }

    public PriceManageView2_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public PriceManageView2_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    public void onFinishInflate() {
        if (!this.f21484d) {
            this.f21484d = true;
            inflate(getContext(), R.layout.price_manage_view_layout2, this);
            this.f21485e.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f21485e);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21538a = (MaterialEditText) aVar.internalFindViewById(R.id.price_offer);
        this.f21539b = (TextView) aVar.internalFindViewById(R.id.price_title);
        this.f21540c = (RelativeLayout) aVar.internalFindViewById(R.id.price_section);
        a();
    }
}
