package com.shopee.app.ui.chat2.product.a;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.c;

public final class b extends a implements a, org.a.a.b.b {
    private boolean h = false;
    private final c i = new c();

    public b(Context context) {
        super(context);
        i();
    }

    public static a a(Context context) {
        b bVar = new b(context);
        bVar.onFinishInflate();
        return bVar;
    }

    public void onFinishInflate() {
        if (!this.h) {
            this.h = true;
            inflate(getContext(), R.layout.product_selection_list_layout, this);
            this.i.a((a) this);
        }
        super.onFinishInflate();
    }

    private void i() {
        c a2 = c.a(this.i);
        c.a((org.a.a.b.b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public void onViewChanged(a aVar) {
        this.f20692a = (RecyclerView) aVar.internalFindViewById(R.id.list);
        this.f20693b = aVar.internalFindViewById(R.id.emptyView);
        this.f20694c = (TextView) aVar.internalFindViewById(R.id.label);
        d();
    }
}
