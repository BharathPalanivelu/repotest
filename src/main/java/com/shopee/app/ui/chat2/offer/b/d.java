package com.shopee.app.ui.chat2.offer.b;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class d extends c implements a, b {
    private boolean h = false;
    private final c i = new c();

    public d(Context context, int i2, int i3, boolean z) {
        super(context, i2, i3, z);
        h();
    }

    public static c a(Context context, int i2, int i3, boolean z) {
        d dVar = new d(context, i2, i3, z);
        dVar.onFinishInflate();
        return dVar;
    }

    public void onFinishInflate() {
        if (!this.h) {
            this.h = true;
            inflate(getContext(), R.layout.offer_product_selection_list_layout, this);
            this.i.a((a) this);
        }
        super.onFinishInflate();
    }

    private void h() {
        c a2 = c.a(this.i);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public void onViewChanged(a aVar) {
        this.f20625a = (RecyclerView) aVar.internalFindViewById(R.id.list);
        this.f20627c = aVar.internalFindViewById(R.id.emptyView);
        this.f20628d = (TextView) aVar.internalFindViewById(R.id.label);
        this.f20629e = (ImageView) aVar.internalFindViewById(R.id.circle_icon);
        d();
    }
}
