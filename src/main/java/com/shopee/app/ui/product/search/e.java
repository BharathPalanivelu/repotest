package com.shopee.app.ui.product.search;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class e extends d implements a, b {

    /* renamed from: g  reason: collision with root package name */
    private boolean f24829g = false;
    private final c h = new c();

    public e(Context context) {
        super(context);
        b();
    }

    public static d a(Context context) {
        e eVar = new e(context);
        eVar.onFinishInflate();
        return eVar;
    }

    public void onFinishInflate() {
        if (!this.f24829g) {
            this.f24829g = true;
            inflate(getContext(), R.layout.search_hint_item_layout, this);
            this.h.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.h);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.f24827e = resources.getDimensionPixelSize(R.dimen.spacing_normal);
        this.f24828f = resources.getDimensionPixelSize(R.dimen.spacing_small);
        a();
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f24823a = (TextView) aVar.internalFindViewById(R.id.keyword);
        this.f24824b = (TextView) aVar.internalFindViewById(R.id.category);
        this.f24825c = (TextView) aVar.internalFindViewById(R.id.label);
        this.f24826d = (ImageView) aVar.internalFindViewById(R.id.search_icon);
    }
}
