package com.shopee.app.ui.common;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.tools.a.b;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.ui.actionbar.e;
import com.shopee.app.ui.myproduct.a.a;
import com.shopee.id.R;

public class an extends ao implements PopupWindow.OnDismissListener, e.c {

    /* renamed from: b  reason: collision with root package name */
    private boolean f21150b;

    /* renamed from: c  reason: collision with root package name */
    private int f21151c = 3;

    /* renamed from: d  reason: collision with root package name */
    private final int f21152d;

    public an(Context context, int i) {
        super(context);
        this.f21152d = i;
    }

    /* access modifiers changed from: protected */
    public void a(Context context, String str) {
        super.a(context, str);
        this.f21153a.setOnClickListener(this);
        this.f21153a.setCompoundDrawablePadding(b.a.f7693d);
        setDrawableRes(R.drawable.com_garena_shopee_arrownormal);
    }

    public void onClick(View view) {
        if (this.f21150b) {
            int i = this.f21152d;
            int i2 = R.string.sp_sort_by_stock_desc;
            int i3 = R.string.sp_sort_by_stock_asc;
            if (i != 0 && i == 1) {
                i3 = R.string.sp_sort_by_popularity_asc;
                i2 = R.string.sp_sort_by_popularity_desc;
            }
            e.a aVar = new e.a();
            int i4 = this.f21151c;
            int i5 = R.drawable.com_garena_shopee_ic_ok;
            e.a a2 = aVar.a(i2, 3, (Object) null, i4 == 3 ? R.drawable.com_garena_shopee_ic_ok : 0);
            if (this.f21151c != 4) {
                i5 = 0;
            }
            e b2 = a2.a(i3, 4, (Object) null, i5).a((e.c) this).a(false).b(getContext());
            b2.b((View) this.f21153a);
            setDrawableRes(R.drawable.com_garena_shopee_arrowclick);
            b2.a((PopupWindow.OnDismissListener) this);
            return;
        }
        performClick();
    }

    public void setDrawableRes(int i) {
        this.f21153a.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
    }

    public void a() {
        super.a();
        this.f21150b = true;
        setDrawableRes(R.drawable.com_garena_shopee_arrowcurrent);
    }

    public void b() {
        super.b();
        this.f21150b = false;
        setDrawableRes(R.drawable.com_garena_shopee_arrownormal);
    }

    public void a(int i, Object obj) {
        this.f21151c = i;
        com.garena.android.appkit.b.b.a("PRODUCT_DROPDOWN_ACTION", (a) new a.C0368a(i, (ItemDetail) null), b.a.UI_BUS);
    }

    public void onDismiss() {
        setDrawableRes(R.drawable.com_garena_shopee_arrowcurrent);
    }
}
