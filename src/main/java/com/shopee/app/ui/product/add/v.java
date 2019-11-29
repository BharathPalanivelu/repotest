package com.shopee.app.ui.product.add;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class v extends u implements a, b {

    /* renamed from: e  reason: collision with root package name */
    private boolean f24165e = false;

    /* renamed from: f  reason: collision with root package name */
    private final c f24166f = new c();

    public v(Context context) {
        super(context);
        b();
    }

    public static u a(Context context) {
        v vVar = new v(context);
        vVar.onFinishInflate();
        return vVar;
    }

    public void onFinishInflate() {
        if (!this.f24165e) {
            this.f24165e = true;
            inflate(getContext(), R.layout.facebook_item_layout, this);
            this.f24166f.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f24166f);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f24159a = (TextView) aVar.internalFindViewById(R.id.page_name);
        this.f24160b = (RelativeLayout) aVar.internalFindViewById(R.id.category_layout);
        this.f24161c = aVar.internalFindViewById(R.id.toggle_button);
        a();
    }
}
