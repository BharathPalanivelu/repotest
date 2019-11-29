package com.shopee.app.ui.order.b.a;

import android.content.Context;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.CheckoutItem;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.data.viewmodel.order.ReturnItem;
import com.shopee.app.ui.a.m;
import com.shopee.app.ui.order.views.c;
import com.shopee.id.R;

public class b extends m<com.shopee.app.ui.order.views.b, a> {

    /* renamed from: a  reason: collision with root package name */
    private boolean f23486a = true;

    public int b() {
        return 3;
    }

    public com.shopee.app.ui.order.views.b a(Context context, a aVar, int i) {
        return c.a(context);
    }

    public void a(com.shopee.app.ui.order.views.b bVar, a aVar) {
        bVar.setIds(aVar.a());
        if (this.f23486a) {
            a.C0251a d2 = aVar.d();
            bVar.setButtonText(d2.f15983a);
            bVar.setButtonEnabled(d2.b());
            bVar.setButtonVisibility(d2.a());
            bVar.setButtonClickListener(d2.f15984b);
            a.C0251a e2 = aVar.e();
            bVar.setButton1Text(e2.f15983a);
            bVar.setButton1Enabled(e2.b());
            bVar.setButton1Visibility(e2.a());
            bVar.setButton1ClickListener(e2.f15984b);
        } else {
            bVar.setButtonVisibility(8);
        }
        bVar.setLabel(aVar.b());
        if (!(aVar instanceof com.shopee.app.d.b.a.b.e.b) || !((com.shopee.app.d.b.a.b.e.b) aVar).s()) {
            bVar.c();
        } else {
            bVar.b();
        }
        Object a2 = a();
        if (a2 instanceof CheckoutItem) {
            if (((CheckoutItem) a2).isUnread()) {
                bVar.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.unread_bg));
                bVar.setTag(R.id.button, Integer.valueOf(R.color.unread_bg));
                return;
            }
            bVar.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.white));
            bVar.setTag(R.id.button, Integer.valueOf(R.color.white));
        } else if (a2 instanceof OrderDetail) {
            if (((OrderDetail) a2).isUnread()) {
                bVar.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.unread_bg));
                bVar.setTag(R.id.button, Integer.valueOf(R.color.unread_bg));
                return;
            }
            bVar.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.white));
            bVar.setTag(R.id.button, Integer.valueOf(R.color.white));
        } else if (!(a2 instanceof ReturnItem)) {
            bVar.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.white));
            bVar.setTag(R.id.button, Integer.valueOf(R.color.white));
        } else if (((ReturnItem) a2).isUnread()) {
            bVar.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.unread_bg));
            bVar.setTag(R.id.button, Integer.valueOf(R.color.unread_bg));
        } else {
            bVar.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.white));
            bVar.setTag(R.id.button, Integer.valueOf(R.color.white));
        }
    }

    public void a(boolean z) {
        this.f23486a = z;
    }
}
