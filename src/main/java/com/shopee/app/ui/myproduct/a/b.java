package com.shopee.app.ui.myproduct.a;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.garena.android.appkit.b.a;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.ui.myproduct.a.a;
import com.shopee.app.ui.myproduct.c;
import com.shopee.app.util.s;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class b extends a {
    TextView A;
    View B;
    s C;
    String v;
    String w;
    String x;
    TextView y;
    TextView z;

    public b(Context context, int i) {
        super(context, i);
        ((c) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.z.setVisibility(this.C.a("delist_product") ? 0 : 8);
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.s.a("PRODUCT_DROPDOWN_ACTION", (a) new a.C0368a(1, this.u));
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.s.a("PRODUCT_DROPDOWN_ACTION", (com.garena.android.appkit.b.a) new a.C0368a(5, this.u));
    }

    public void a(ItemDetail itemDetail) {
        super.a(itemDetail);
        int i = 0;
        if (itemDetail.getViewCount() >= 0) {
            this.y.setText(String.format(this.x, new Object[]{Long.valueOf(itemDetail.getViewCount())}));
        }
        this.z.setText(com.garena.android.appkit.tools.b.e(this.u.isDeList() ? R.string.publish : R.string.delist));
        View view = this.B;
        if (!this.u.isDeList()) {
            i = 8;
        }
        view.setVisibility(i);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        super.a();
        this.z.setVisibility(8);
        this.A.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public String a(String str) {
        return String.format(this.w, new Object[]{str});
    }

    /* access modifiers changed from: protected */
    public String a(int i) {
        return String.format(this.v, new Object[]{Integer.valueOf(i)});
    }
}
