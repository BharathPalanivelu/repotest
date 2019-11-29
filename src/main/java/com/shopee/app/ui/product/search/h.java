package com.shopee.app.ui.product.search;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.graphics.drawable.a;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.viewmodel.SearchProductItem;
import com.shopee.app.ui.a.n;
import com.shopee.app.util.l;
import com.shopee.id.R;

public class h extends RelativeLayout implements n<SearchProductItem> {

    /* renamed from: a  reason: collision with root package name */
    TextView f24833a;

    public h(Context context) {
        super(context);
        setBackgroundResource(R.drawable.white_background_hightlight);
    }

    public void setLeftDrawable(int i) {
        Drawable g2 = a.g(b.f(i).mutate());
        a.a(g2, b.a(R.color.primary));
        this.f24833a.setCompoundDrawablesWithIntrinsicBounds(g2, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void a(SearchProductItem searchProductItem) {
        String replace = searchProductItem.getKeyword().replace("<b2>", "<font color=\"#00BFA5\">").replace("</b2>", "</font>");
        this.f24833a.setText(Html.fromHtml(replace.replace("<y2>", "<font color=\"" + l.w + "\">").replace("</y2>", "</font>")));
    }
}
