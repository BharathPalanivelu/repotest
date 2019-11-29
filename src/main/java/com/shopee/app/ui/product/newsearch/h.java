package com.shopee.app.ui.product.newsearch;

import android.content.Context;
import android.view.View;
import com.shopee.app.camera.ImageSearchHint;
import com.shopee.app.ui.common.MaterialTabView;
import com.shopee.app.web.protocol.SearchConfig;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class h extends f implements a, b {

    /* renamed from: g  reason: collision with root package name */
    private boolean f24708g = false;
    private final c h = new c();

    public h(Context context, String str, SearchConfig searchConfig, int i) {
        super(context, str, searchConfig, i);
        g();
    }

    public static f a(Context context, String str, SearchConfig searchConfig, int i) {
        h hVar = new h(context, str, searchConfig, i);
        hVar.onFinishInflate();
        return hVar;
    }

    public void onFinishInflate() {
        if (!this.f24708g) {
            this.f24708g = true;
            inflate(getContext(), R.layout.search_tab_layout, this);
            this.h.a((a) this);
        }
        super.onFinishInflate();
    }

    private void g() {
        c a2 = c.a(this.h);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f24697a = (MaterialTabView) aVar.internalFindViewById(R.id.tab_view);
        this.f24698b = (ImageSearchHint) aVar.internalFindViewById(R.id.imageSearchHint);
        if (this.f24698b != null) {
            this.f24698b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    h.this.e();
                }
            });
        }
        a();
    }
}
