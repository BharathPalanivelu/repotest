package com.shopee.app.ui.product.attributes;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class j extends i implements a, b {

    /* renamed from: c  reason: collision with root package name */
    private boolean f24293c = false;

    /* renamed from: d  reason: collision with root package name */
    private final c f24294d = new c();

    public j(Context context) {
        super(context);
        a();
    }

    public void onFinishInflate() {
        if (!this.f24293c) {
            this.f24293c = true;
            inflate(getContext(), R.layout.simple_list_string_item_layout, this);
            this.f24294d.a((a) this);
        }
        super.onFinishInflate();
    }

    private void a() {
        c a2 = c.a(this.f24294d);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public static i a(Context context) {
        j jVar = new j(context);
        jVar.onFinishInflate();
        return jVar;
    }

    public void onViewChanged(a aVar) {
        this.f24291a = aVar.internalFindViewById(R.id.item_selected);
        this.f24292b = (TextView) aVar.internalFindViewById(R.id.label);
    }
}
