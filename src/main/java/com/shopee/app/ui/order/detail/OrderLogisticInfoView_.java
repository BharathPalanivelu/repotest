package com.shopee.app.ui.order.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class OrderLogisticInfoView_ extends j implements a, b {

    /* renamed from: e  reason: collision with root package name */
    private boolean f23582e = false;

    /* renamed from: f  reason: collision with root package name */
    private final c f23583f = new c();

    public OrderLogisticInfoView_(Context context) {
        super(context);
        a();
    }

    public OrderLogisticInfoView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public OrderLogisticInfoView_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public void onFinishInflate() {
        if (!this.f23582e) {
            this.f23582e = true;
            inflate(getContext(), R.layout.extra_logistic_info_layout, this);
            this.f23583f.a((a) this);
        }
        super.onFinishInflate();
    }

    private void a() {
        c a2 = c.a(this.f23583f);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f23640a = (TextView) aVar.internalFindViewById(R.id.text_status);
        this.f23641b = (TextView) aVar.internalFindViewById(R.id.text_track);
        this.f23642c = (TextView) aVar.internalFindViewById(R.id.time_status);
        this.f23643d = aVar.internalFindViewById(R.id.icon_panel2);
    }
}
