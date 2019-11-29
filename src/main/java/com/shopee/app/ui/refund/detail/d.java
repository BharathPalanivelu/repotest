package com.shopee.app.ui.refund.detail;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class d extends c implements a, b {
    private boolean h = false;
    private final c i = new c();

    public d(Context context, long j, int i2) {
        super(context, j, i2);
        b();
    }

    public static c a(Context context, long j, int i2) {
        d dVar = new d(context, j, i2);
        dVar.onFinishInflate();
        return dVar;
    }

    public void onFinishInflate() {
        if (!this.h) {
            this.h = true;
            inflate(getContext(), R.layout.refund_detail_layout, this);
            this.i.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.i);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.f24974e = resources.getDimensionPixelSize(R.dimen.sp12);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public void onViewChanged(a aVar) {
        this.f24970a = (TextView) aVar.internalFindViewById(R.id.refund_amount);
        this.f24971b = (TextView) aVar.internalFindViewById(R.id.payment);
        this.f24972c = (TextView) aVar.internalFindViewById(R.id.reason);
        this.f24973d = (TextView) aVar.internalFindViewById(R.id.explanation);
        a();
    }
}
