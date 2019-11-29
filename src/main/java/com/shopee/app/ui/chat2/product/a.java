package com.shopee.app.ui.chat2.product;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.garena.android.appkit.tools.a.b;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.SearchProductItem;
import com.shopee.app.data.viewmodel.category.CategoryNode;
import com.shopee.app.data.viewmodel.chatP2P.VMOfferHistory;
import com.shopee.app.ui.a.n;
import com.shopee.id.R;

public class a extends FrameLayout implements n<Object> {

    /* renamed from: a  reason: collision with root package name */
    TextView f20691a;

    public a(Context context) {
        super(context);
        setLayoutParams(new RecyclerView.j(-1, -2));
        setBackgroundResource(R.drawable.bottom_border_no_background);
        setPadding(b.a.k, b.a.f7695f, b.a.k, b.a.f7695f);
    }

    public void a(Object obj) {
        if (obj instanceof ItemDetail) {
            this.f20691a.setText(((ItemDetail) obj).getItemName());
        } else if (obj instanceof VMOfferHistory) {
            this.f20691a.setText(((VMOfferHistory) obj).getTitle());
        } else {
            if (obj instanceof CategoryNode) {
                this.f20691a.setText(((CategoryNode) obj).getName());
            }
            if (obj instanceof SearchProductItem) {
                this.f20691a.setText(((SearchProductItem) obj).getKeyword());
            }
        }
    }
}
