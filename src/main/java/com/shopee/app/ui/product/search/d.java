package com.shopee.app.ui.product.search;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.store.SearchHistoryData;
import com.shopee.app.data.viewmodel.SearchProductItem;
import com.shopee.app.ui.a.n;
import com.shopee.id.R;
import com.squareup.a.w;

public class d extends LinearLayout implements n<SearchProductItem> {

    /* renamed from: a  reason: collision with root package name */
    TextView f24823a;

    /* renamed from: b  reason: collision with root package name */
    TextView f24824b;

    /* renamed from: c  reason: collision with root package name */
    TextView f24825c;

    /* renamed from: d  reason: collision with root package name */
    ImageView f24826d;

    /* renamed from: e  reason: collision with root package name */
    int f24827e;

    /* renamed from: f  reason: collision with root package name */
    int f24828f;

    public d(Context context) {
        super(context);
        setOrientation(1);
        setGravity(16);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        int i = this.f24827e;
        int i2 = this.f24828f;
        setPadding(i, i2, i, i2);
        setMinimumHeight(b.d(R.dimen.dp48));
        setBackgroundResource(R.drawable.white_background_hightlight);
    }

    public void a(SearchProductItem searchProductItem) {
        String keyword = searchProductItem.getKeyword();
        if (searchProductItem.isHashTagHint()) {
            keyword = "#" + keyword;
        }
        String originalKeyword = searchProductItem.getOriginalKeyword();
        SpannableString valueOf = SpannableString.valueOf(keyword);
        String str = "";
        String lowerCase = TextUtils.isEmpty(originalKeyword) ? str : originalKeyword.trim().toLowerCase();
        if (!TextUtils.isEmpty(keyword)) {
            str = keyword.toLowerCase();
        }
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(b.a(R.color.black80));
        if (TextUtils.isEmpty(lowerCase) || !str.contains(lowerCase)) {
            valueOf.setSpan(foregroundColorSpan, 0, str.length(), 33);
        } else {
            int indexOf = str.indexOf(lowerCase);
            ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(b.a(R.color.black54));
            int length = lowerCase.length() + indexOf;
            valueOf.setSpan(foregroundColorSpan, 0, indexOf, 33);
            valueOf.setSpan(foregroundColorSpan2, indexOf, length, 33);
            valueOf.setSpan(foregroundColorSpan, length, str.length(), 33);
        }
        this.f24823a.setText(valueOf);
        if (!TextUtils.isEmpty(searchProductItem.getCategoryName())) {
            this.f24824b.setVisibility(0);
            this.f24824b.setText(b.a(R.string.search_in, searchProductItem.getCategoryName()));
        } else {
            this.f24824b.setVisibility(8);
        }
        if (searchProductItem.getExtra() instanceof SearchHistoryData) {
            SearchHistoryData searchHistoryData = (SearchHistoryData) searchProductItem.getExtra();
            if (searchHistoryData.getType() != 2 || !searchHistoryData.showType()) {
                this.f24825c.setVisibility(8);
            } else {
                this.f24825c.setVisibility(0);
                this.f24825c.setText(b.e(R.string.sp_label_shop));
            }
        } else {
            this.f24825c.setVisibility(8);
        }
        if (!TextUtils.isEmpty(searchProductItem.getLogoUrl())) {
            this.f24825c.setVisibility(8);
            w.a(getContext()).a(searchProductItem.getLogoUrl()).b(0, b.a.n).e().a(this.f24826d);
            this.f24826d.setVisibility(0);
        }
    }
}
