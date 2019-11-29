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

public final class PriceManageView_ extends b implements a, b {

    /* renamed from: e  reason: collision with root package name */
    private boolean f21486e = false;

    /* renamed from: f  reason: collision with root package name */
    private final c f21487f = new c();

    public PriceManageView_(Context context) {
        super(context);
        b();
    }

    public PriceManageView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public PriceManageView_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    public static b a(Context context) {
        PriceManageView_ priceManageView_ = new PriceManageView_(context);
        priceManageView_.onFinishInflate();
        return priceManageView_;
    }

    public void onFinishInflate() {
        if (!this.f21486e) {
            this.f21486e = true;
            inflate(getContext(), R.layout.price_manage_view_layout, this);
            this.f21487f.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f21487f);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21532a = (MaterialEditText) aVar.internalFindViewById(R.id.price_offer);
        this.f21533b = (TextView) aVar.internalFindViewById(R.id.price_title);
        this.f21534c = (TextView) aVar.internalFindViewById(R.id.head_title);
        this.f21535d = (RelativeLayout) aVar.internalFindViewById(R.id.price_section);
        a();
    }
}
