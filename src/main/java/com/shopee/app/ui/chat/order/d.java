package com.shopee.app.ui.chat.order;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.shopee.app.data.viewmodel.OrderItemInfo;
import com.shopee.app.ui.order.detail.k;
import com.shopee.app.ui.order.detail.l;
import com.shopee.id.R;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import java.util.List;

public class d extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    LinearLayout f20186a;

    /* access modifiers changed from: package-private */
    public void a() {
    }

    public d(Context context) {
        super(context);
        setBackgroundResource(R.drawable.bottom_border_white_background);
    }

    public void setProducts(List<OrderItemInfo> list) {
        this.f20186a.removeAllViews();
        for (OrderItemInfo orderItemInfo : list) {
            k a2 = l.a(getContext());
            a2.setOrderItemInfo(orderItemInfo);
            a2.b();
            this.f20186a.addView(a2);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(a(getResources(), 220), RNCartPanelDataEntity.NULL_VALUE));
    }

    private int a(Resources resources, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, resources.getDisplayMetrics());
    }
}
