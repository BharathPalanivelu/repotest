package com.shopee.app.ui.refund.cancel;

import android.content.Context;
import android.view.View;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class d extends c implements a, b {

    /* renamed from: e  reason: collision with root package name */
    private boolean f24954e = false;

    /* renamed from: f  reason: collision with root package name */
    private final c f24955f = new c();

    public d(Context context, long j, int i) {
        super(context, j, i);
        c();
    }

    public static c a(Context context, long j, int i) {
        d dVar = new d(context, j, i);
        dVar.onFinishInflate();
        return dVar;
    }

    public void onFinishInflate() {
        if (!this.f24954e) {
            this.f24954e = true;
            inflate(getContext(), R.layout.order_cancel_layout, this);
            this.f24955f.a((a) this);
        }
        super.onFinishInflate();
    }

    private void c() {
        c a2 = c.a(this.f24955f);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f24948a = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.refund_amount);
        this.f24949b = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.reason_select);
        if (this.f24949b != null) {
            this.f24949b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    d.this.b();
                }
            });
        }
        a();
    }
}
