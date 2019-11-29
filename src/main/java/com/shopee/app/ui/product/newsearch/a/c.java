package com.shopee.app.ui.product.newsearch.a;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.shopee.app.web.protocol.SearchConfig;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;

public final class c extends b implements a, b {
    private boolean h = false;
    private final org.a.a.b.c i = new org.a.a.b.c();

    public c(Context context, String str, SearchConfig searchConfig) {
        super(context, str, searchConfig);
        e();
    }

    public static b a(Context context, String str, SearchConfig searchConfig) {
        c cVar = new c(context, str, searchConfig);
        cVar.onFinishInflate();
        return cVar;
    }

    public void onFinishInflate() {
        if (!this.h) {
            this.h = true;
            inflate(getContext(), R.layout.search_generic_layout, this);
            this.i.a((a) this);
        }
        super.onFinishInflate();
    }

    private void e() {
        org.a.a.b.c a2 = org.a.a.b.c.a(this.i);
        org.a.a.b.c.a((b) this);
        org.a.a.b.c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public void onViewChanged(a aVar) {
        this.f24661a = (RecyclerView) aVar.internalFindViewById(R.id.recycler_view);
        this.f24662b = aVar.internalFindViewById(R.id.emptyView);
        this.f24663c = (TextView) aVar.internalFindViewById(R.id.label);
        d();
    }
}
