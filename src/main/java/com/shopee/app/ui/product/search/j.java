package com.shopee.app.ui.product.search;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.uikit.fluid.tagcloud.GTagCloud;
import com.shopee.app.data.viewmodel.SearchProductItem;
import com.shopee.app.ui.a.n;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class j extends RelativeLayout implements n<SearchProductItem> {

    /* renamed from: a  reason: collision with root package name */
    GTagCloud f24836a;

    /* renamed from: b  reason: collision with root package name */
    View f24837b;

    /* renamed from: c  reason: collision with root package name */
    TextView f24838c;

    /* renamed from: d  reason: collision with root package name */
    private a f24839d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public b f24840e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public SearchProductItem f24841f;

    public interface b {
        void a(View view, String str, int i, SearchProductItem searchProductItem);
    }

    public j(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f24839d = new a();
        this.f24836a.setAdapter(this.f24839d);
        this.f24836a.setChildPadding(b.a.f7696g);
        this.f24836a.setLineMargin(b.a.f7696g);
    }

    public void a(SearchProductItem searchProductItem) {
        this.f24841f = searchProductItem;
        this.f24838c.setText(searchProductItem.getKeyword());
        this.f24839d.a(searchProductItem.getKeywords());
        this.f24836a.a();
    }

    public void setOnItemClickListener(b bVar) {
        this.f24840e = bVar;
    }

    private class a implements View.OnClickListener, GTagCloud.a {

        /* renamed from: b  reason: collision with root package name */
        private List<String> f24843b;

        private a() {
            this.f24843b = new ArrayList();
        }

        public void a(List<String> list) {
            this.f24843b = list;
        }

        public int a() {
            return this.f24843b.size();
        }

        public View a(Context context, int i) {
            TextView textView = (TextView) View.inflate(context, R.layout.hot_word_tag_layout, (ViewGroup) null);
            textView.setText(this.f24843b.get(i));
            textView.setTag(R.id.hash_tag_view, Integer.valueOf(i));
            textView.setOnClickListener(this);
            return textView;
        }

        public void onClick(View view) {
            TextView textView = (TextView) view;
            int intValue = ((Integer) textView.getTag(R.id.hash_tag_view)).intValue();
            if (j.this.f24840e != null) {
                j.this.f24840e.a(textView, textView.getText().toString(), intValue, j.this.f24841f);
            }
        }
    }
}
