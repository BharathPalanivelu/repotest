package com.shopee.app.ui.order.detail;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class f extends e implements a, b {
    private boolean K = false;
    private final c L = new c();

    public f(Context context, long j, long j2) {
        super(context, j, j2);
        e();
    }

    public static e a(Context context, long j, long j2) {
        f fVar = new f(context, j, j2);
        fVar.onFinishInflate();
        return fVar;
    }

    public void onFinishInflate() {
        if (!this.K) {
            this.K = true;
            inflate(getContext(), R.layout.checkout_details_layout2, this);
            this.L.a((a) this);
        }
        super.onFinishInflate();
    }

    private void e() {
        c a2 = c.a(this.L);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.F = resources.getString(R.string.sp_label_order_total);
        this.G = resources.getString(R.string.sp_amount_payable);
        this.C = resources.getDimensionPixelSize(R.dimen.dp8);
        this.D = resources.getDimensionPixelSize(R.dimen.dp16);
        this.E = androidx.core.content.b.c(getContext(), R.color.black87);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f23610d = aVar.internalFindViewById(R.id.checkout_info_section);
        this.f23611e = (ScrollView) aVar.internalFindViewById(R.id.scroll_view);
        this.f23612f = aVar.internalFindViewById(R.id.status_container);
        this.f23613g = (TextView) aVar.internalFindViewById(R.id.status_bar);
        this.h = (TextView) aVar.internalFindViewById(R.id.status_text);
        this.i = (i) aVar.internalFindViewById(R.id.shipment);
        this.j = (LinearLayout) aVar.internalFindViewById(R.id.item_container);
        this.k = (TextView) aVar.internalFindViewById(R.id.order_total);
        this.l = (TextView) aVar.internalFindViewById(R.id.order_promo);
        this.m = (TextView) aVar.internalFindViewById(R.id.order_paid);
        this.n = (TextView) aVar.internalFindViewById(R.id.order_unique_code);
        this.o = (TextView) aVar.internalFindViewById(R.id.order_total_payment);
        this.p = (TextView) aVar.internalFindViewById(R.id.order_total_value);
        this.q = (TextView) aVar.internalFindViewById(R.id.order_promo_value);
        this.r = (TextView) aVar.internalFindViewById(R.id.order_paid_value);
        this.s = (TextView) aVar.internalFindViewById(R.id.order_unique_code_value);
        this.t = (TextView) aVar.internalFindViewById(R.id.order_total_payment_value);
        this.u = aVar.internalFindViewById(R.id.button_container);
        this.v = aVar.internalFindViewById(R.id.emptyView);
        this.w = (TextView) aVar.internalFindViewById(R.id.payment_method_value);
        this.x = (Button) aVar.internalFindViewById(R.id.button_up);
        this.y = (Button) aVar.internalFindViewById(R.id.button_below);
        this.z = (Button) aVar.internalFindViewById(R.id.button_below1);
        this.A = (Button) aVar.internalFindViewById(R.id.button_below2);
        this.B = (Button) aVar.internalFindViewById(R.id.button_right);
        View internalFindViewById = aVar.internalFindViewById(R.id.change_payment_method);
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    f.this.b();
                }
            });
        }
        a();
    }
}
