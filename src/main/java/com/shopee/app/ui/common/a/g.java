package com.shopee.app.ui.common.a;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class g extends f implements a, b {

    /* renamed from: b  reason: collision with root package name */
    private boolean f21106b = false;

    /* renamed from: c  reason: collision with root package name */
    private final c f21107c = new c();

    public g(Context context) {
        super(context);
        e();
    }

    public static f a(Context context) {
        g gVar = new g(context);
        gVar.onFinishInflate();
        return gVar;
    }

    public void onFinishInflate() {
        if (!this.f21106b) {
            this.f21106b = true;
            inflate(getContext(), R.layout.model_grid_item_view, this);
            this.f21107c.a((a) this);
        }
        super.onFinishInflate();
    }

    private void e() {
        c a2 = c.a(this.f21107c);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21101a = (TextView) aVar.internalFindViewById(R.id.label);
        a();
    }
}
