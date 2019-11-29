package com.shopee.app.ui.chat2.buy;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class e extends d implements a, b {
    private boolean i = false;
    private final c j = new c();

    public e(Context context, int i2, int i3) {
        super(context, i2, i3);
        g();
    }

    public static d a(Context context, int i2, int i3) {
        e eVar = new e(context, i2, i3);
        eVar.onFinishInflate();
        return eVar;
    }

    public void onFinishInflate() {
        if (!this.i) {
            this.i = true;
            inflate(getContext(), R.layout.offer_product_selection_list_layout, this);
            this.j.a((a) this);
        }
        super.onFinishInflate();
    }

    private void g() {
        c a2 = c.a(this.j);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public void onViewChanged(a aVar) {
        this.f20391a = (RecyclerView) aVar.internalFindViewById(R.id.list);
        this.f20393c = aVar.internalFindViewById(R.id.emptyView);
        this.f20394d = (TextView) aVar.internalFindViewById(R.id.label);
        this.f20395e = (ImageView) aVar.internalFindViewById(R.id.circle_icon);
        d();
    }
}
