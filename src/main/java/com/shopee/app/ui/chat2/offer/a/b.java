package com.shopee.app.ui.chat2.offer.a;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.c;

public final class b extends a implements a, org.a.a.b.b {
    private boolean l = false;
    private final c m = new c();

    public b(Context context) {
        super(context);
        e();
    }

    public static a a(Context context) {
        b bVar = new b(context);
        bVar.onFinishInflate();
        return bVar;
    }

    public void onFinishInflate() {
        if (!this.l) {
            this.l = true;
            inflate(getContext(), R.layout.chat_offer_history_item_view, this);
            this.m.a((a) this);
        }
        super.onFinishInflate();
    }

    private void e() {
        c a2 = c.a(this.m);
        c.a((org.a.a.b.b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f20559a = (TextView) aVar.internalFindViewById(R.id.quantity);
        this.f20560b = (ImageView) aVar.internalFindViewById(R.id.icon);
        this.f20561c = (TextView) aVar.internalFindViewById(R.id.title);
        this.f20562d = (TextView) aVar.internalFindViewById(R.id.price);
        this.f20563e = (CheckBox) aVar.internalFindViewById(R.id.checkbox);
        this.f20564f = (TextView) aVar.internalFindViewById(R.id.status_label);
        this.f20565g = (TextView) aVar.internalFindViewById(R.id.variation);
        a();
    }
}
