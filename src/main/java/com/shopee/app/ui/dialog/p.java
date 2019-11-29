package com.shopee.app.ui.dialog;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class p extends o implements a, b {

    /* renamed from: e  reason: collision with root package name */
    private boolean f21601e = false;

    /* renamed from: f  reason: collision with root package name */
    private final c f21602f = new c();

    public p(Context context) {
        super(context);
        a();
    }

    public static o a(Context context) {
        p pVar = new p(context);
        pVar.onFinishInflate();
        return pVar;
    }

    public void onFinishInflate() {
        if (!this.f21601e) {
            this.f21601e = true;
            inflate(getContext(), R.layout.voucher_view, this);
            this.f21602f.a((a) this);
        }
        super.onFinishInflate();
    }

    private void a() {
        c a2 = c.a(this.f21602f);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21597a = (TextView) aVar.internalFindViewById(R.id.text_voucher_title);
        this.f21598b = (TextView) aVar.internalFindViewById(R.id.text_voucher_code);
        this.f21599c = (TextView) aVar.internalFindViewById(R.id.text_voucher_desc);
        this.f21600d = (Button) aVar.internalFindViewById(R.id.btn_copy_code);
    }
}
