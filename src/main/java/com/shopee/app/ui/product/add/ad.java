package com.shopee.app.ui.product.add;

import android.widget.FrameLayout;
import com.shopee.app.data.viewmodel.SearchProductItem;
import com.shopee.app.ui.a.aa;
import java.util.List;

public class ad extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private b f23975a;

    /* renamed from: b  reason: collision with root package name */
    private a f23976b;

    public static class a extends aa<SearchProductItem> {
    }

    public interface b {
    }

    public void setOnItemClickListener(b bVar) {
        this.f23975a = bVar;
    }

    public void a(List<SearchProductItem> list) {
        this.f23976b.a(list);
        this.f23976b.notifyDataSetChanged();
    }
}
