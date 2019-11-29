package com.shopee.app.ui.dialog;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class e extends d implements a, b {

    /* renamed from: c  reason: collision with root package name */
    private boolean f21546c = false;

    /* renamed from: d  reason: collision with root package name */
    private final c f21547d = new c();

    public e(Context context) {
        super(context);
        c();
    }

    public static d a(Context context) {
        e eVar = new e(context);
        eVar.onFinishInflate();
        return eVar;
    }

    public void onFinishInflate() {
        if (!this.f21546c) {
            this.f21546c = true;
            inflate(getContext(), R.layout.choose_quantity_layout, this);
            this.f21547d.a((a) this);
        }
        super.onFinishInflate();
    }

    private void c() {
        c a2 = c.a(this.f21547d);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21543a = (f) aVar.internalFindViewById(R.id.quantity_section);
        this.f21544b = (Button) aVar.internalFindViewById(R.id.buy_btn);
        if (this.f21544b != null) {
            this.f21544b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    e.this.b();
                }
            });
        }
        a();
    }
}
