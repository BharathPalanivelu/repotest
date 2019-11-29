package com.shopee.app.ui.product.search.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.viewmodel.HotWordData;
import com.shopee.app.data.viewmodel.SearchProductItem;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.product.search.j;
import com.shopee.app.util.af;
import com.shopee.id.R;
import java.util.List;

public class c extends RelativeLayout implements n<SearchProductItem>, j.b {

    /* renamed from: a  reason: collision with root package name */
    LinearLayout f24813a;

    /* renamed from: b  reason: collision with root package name */
    TextView f24814b;

    /* renamed from: c  reason: collision with root package name */
    private j.b f24815c;

    /* renamed from: d  reason: collision with root package name */
    private SearchProductItem f24816d;

    /* access modifiers changed from: package-private */
    public void a() {
    }

    public c(Context context) {
        super(context);
    }

    public void a(SearchProductItem searchProductItem) {
        this.f24813a.removeAllViews();
        this.f24816d = searchProductItem;
        this.f24814b.setText(searchProductItem.getKeyword());
        List<HotWordData> keywordsTrackingData = searchProductItem.getKeywordsTrackingData();
        if (!af.a(keywordsTrackingData)) {
            for (int i = 0; i < keywordsTrackingData.size(); i += 2) {
                HotWordData hotWordData = keywordsTrackingData.get(i);
                int i2 = i + 1;
                HotWordData hotWordData2 = i2 < keywordsTrackingData.size() ? keywordsTrackingData.get(i2) : null;
                a a2 = b.a(getContext());
                a2.a(i, hotWordData, i2, hotWordData2);
                a2.setOnItemClickListener(this);
                b();
                this.f24813a.addView(a2);
            }
        }
    }

    private void b() {
        View view = new View(getContext());
        view.setBackgroundColor(b.a(R.color.background_color));
        this.f24813a.addView(view, new ViewGroup.LayoutParams(-1, b.a.f7690a));
    }

    public void setOnItemClickListener(j.b bVar) {
        this.f24815c = bVar;
    }

    public void a(View view, String str, int i, SearchProductItem searchProductItem) {
        j.b bVar = this.f24815c;
        if (bVar != null) {
            bVar.a(this, str, i, this.f24816d);
        }
    }
}
