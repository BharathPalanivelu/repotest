package com.shopee.app.ui.myproduct.a;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class i extends h implements a, b {
    private boolean i = false;
    private final c j = new c();

    public i(Context context, int i2) {
        super(context, i2);
        i();
    }

    public static h a(Context context, int i2) {
        i iVar = new i(context, i2);
        iVar.onFinishInflate();
        return iVar;
    }

    public void onFinishInflate() {
        if (!this.i) {
            this.i = true;
            inflate(getContext(), R.layout.latest_items_tab_layout, this);
            this.j.a((a) this);
        }
        super.onFinishInflate();
    }

    private void i() {
        c a2 = c.a(this.j);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public void onViewChanged(a aVar) {
        this.f23417a = (ListView) aVar.internalFindViewById(R.id.item_list);
        e();
    }
}
