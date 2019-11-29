package com.shopee.app.ui.product.search.b;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.c;

public final class b extends a implements a, org.a.a.b.b {
    private boolean i = false;
    private final c j = new c();

    public b(Context context) {
        super(context);
        b();
    }

    public static a a(Context context) {
        b bVar = new b(context);
        bVar.onFinishInflate();
        return bVar;
    }

    public void onFinishInflate() {
        if (!this.i) {
            this.i = true;
            inflate(getContext(), R.layout.search_hot_word_grid_item_row_layout, this);
            this.j.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.j);
        c.a((org.a.a.b.b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public void onViewChanged(a aVar) {
        this.f24800a = aVar.internalFindViewById(R.id.first);
        this.f24801b = aVar.internalFindViewById(R.id.second);
        this.f24802c = (TextView) aVar.internalFindViewById(R.id.text1);
        this.f24803d = (ImageView) aVar.internalFindViewById(R.id.image1);
        this.f24804e = (ImageView) aVar.internalFindViewById(R.id.hot_icon1);
        this.f24805f = (TextView) aVar.internalFindViewById(R.id.text2);
        this.f24806g = (ImageView) aVar.internalFindViewById(R.id.image2);
        this.h = (ImageView) aVar.internalFindViewById(R.id.hot_icon2);
        a();
    }
}
