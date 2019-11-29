package com.shopee.feeds.feedlibrary.editor.tag;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.devspark.robototextview.widget.RobotoTextView;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.editor.text.PriceTextView;

public class e extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    View f28030a;

    /* renamed from: b  reason: collision with root package name */
    RelativeLayout f28031b;

    /* renamed from: c  reason: collision with root package name */
    RobotoTextView f28032c;

    /* renamed from: d  reason: collision with root package name */
    PriceTextView f28033d;

    public e(Context context) {
        this(context, (AttributeSet) null);
    }

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        this.f28030a = LayoutInflater.from(getContext()).inflate(c.f.feeds_layout_product_select, this, true);
        this.f28031b = (RelativeLayout) this.f28030a.findViewById(c.e.rl_product);
        this.f28032c = (RobotoTextView) this.f28030a.findViewById(c.e.tv_product_name);
        this.f28033d = (PriceTextView) this.f28030a.findViewById(c.e.tv_product_price);
    }

    public void setTagInfo(b bVar) {
        this.f28032c.setText(bVar.q());
        this.f28033d.setPriceWithOutIntervalPriceAndSmall(bVar.n());
    }
}
