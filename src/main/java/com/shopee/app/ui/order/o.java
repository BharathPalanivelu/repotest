package com.shopee.app.ui.order;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class o extends n implements a, b {

    /* renamed from: e  reason: collision with root package name */
    private boolean f23740e = false;

    /* renamed from: f  reason: collision with root package name */
    private final c f23741f = new c();

    public o(Context context) {
        super(context);
        b();
    }

    public static n a(Context context) {
        o oVar = new o(context);
        oVar.onFinishInflate();
        return oVar;
    }

    public void onFinishInflate() {
        if (!this.f23740e) {
            this.f23740e = true;
            inflate(getContext(), R.layout.order_id_layout, this);
            this.f23741f.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f23741f);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.f23737c = resources.getDimensionPixelSize(R.dimen.dp16);
        this.f23738d = resources.getDimensionPixelSize(R.dimen.dp8);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f23735a = (TextView) aVar.internalFindViewById(R.id.order_id);
        this.f23736b = aVar.internalFindViewById(R.id.divider);
        a();
    }
}
