package com.shopee.app.ui.product.search;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.garena.android.uikit.fluid.tagcloud.GTagCloud;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class k extends j implements a, b {

    /* renamed from: d  reason: collision with root package name */
    private boolean f24844d = false;

    /* renamed from: e  reason: collision with root package name */
    private final c f24845e = new c();

    public k(Context context) {
        super(context);
        b();
    }

    public static j a(Context context) {
        k kVar = new k(context);
        kVar.onFinishInflate();
        return kVar;
    }

    public void onFinishInflate() {
        if (!this.f24844d) {
            this.f24844d = true;
            inflate(getContext(), R.layout.search_hot_word_item_layout, this);
            this.f24845e.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f24845e);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f24836a = (GTagCloud) aVar.internalFindViewById(R.id.tagCloud);
        this.f24837b = aVar.internalFindViewById(R.id.divider);
        this.f24838c = (TextView) aVar.internalFindViewById(R.id.label);
        a();
    }
}
