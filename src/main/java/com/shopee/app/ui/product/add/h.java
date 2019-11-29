package com.shopee.app.ui.product.add;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.pnikosis.materialishprogress.ProgressWheel;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class h extends g implements a, b {

    /* renamed from: f  reason: collision with root package name */
    private boolean f24071f = false;

    /* renamed from: g  reason: collision with root package name */
    private final c f24072g = new c();

    public h(Context context) {
        super(context);
        b();
    }

    public static g a(Context context) {
        h hVar = new h(context);
        hVar.onFinishInflate();
        return hVar;
    }

    public void onFinishInflate() {
        if (!this.f24071f) {
            this.f24071f = true;
            inflate(getContext(), R.layout.add_product_progress, this);
            this.f24072g.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f24072g);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f24065a = (ProgressWheel) aVar.internalFindViewById(R.id.progress_wheel);
        this.f24066b = (TextView) aVar.internalFindViewById(R.id.label);
        a();
    }
}
