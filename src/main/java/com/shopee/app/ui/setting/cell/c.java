package com.shopee.app.ui.setting.cell;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;

public final class c extends b implements a, b {

    /* renamed from: c  reason: collision with root package name */
    private boolean f25203c = false;

    /* renamed from: d  reason: collision with root package name */
    private final org.a.a.b.c f25204d = new org.a.a.b.c();

    public c(Context context) {
        super(context);
        a();
    }

    public static b a(Context context) {
        c cVar = new c(context);
        cVar.onFinishInflate();
        return cVar;
    }

    public void onFinishInflate() {
        if (!this.f25203c) {
            this.f25203c = true;
            inflate(getContext(), R.layout.settings_item_layout, this);
            this.f25204d.a((a) this);
        }
        super.onFinishInflate();
    }

    private void a() {
        org.a.a.b.c a2 = org.a.a.b.c.a(this.f25204d);
        org.a.a.b.c.a((b) this);
        org.a.a.b.c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f25201a = (ImageView) aVar.internalFindViewById(R.id.check);
        this.f25202b = (TextView) aVar.internalFindViewById(R.id.text);
    }
}
