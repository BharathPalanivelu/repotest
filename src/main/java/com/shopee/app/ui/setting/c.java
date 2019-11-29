package com.shopee.app.ui.setting;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;

public final class c extends b implements a, b {

    /* renamed from: b  reason: collision with root package name */
    private boolean f25185b = false;

    /* renamed from: c  reason: collision with root package name */
    private final org.a.a.b.c f25186c = new org.a.a.b.c();

    public c(Context context) {
        super(context);
        c();
    }

    public static b a(Context context) {
        c cVar = new c(context);
        cVar.onFinishInflate();
        return cVar;
    }

    public void onFinishInflate() {
        if (!this.f25185b) {
            this.f25185b = true;
            inflate(getContext(), R.layout.font_demo_view, this);
            this.f25186c.a((a) this);
        }
        super.onFinishInflate();
    }

    private void c() {
        org.a.a.b.c a2 = org.a.a.b.c.a(this.f25186c);
        org.a.a.b.c.a((b) this);
        org.a.a.b.c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f25182a = (TextView) aVar.internalFindViewById(R.id.font_demo);
        View internalFindViewById = aVar.internalFindViewById(R.id.button_confirm);
        View internalFindViewById2 = aVar.internalFindViewById(R.id.button_cancel);
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.a();
                }
            });
        }
        if (internalFindViewById2 != null) {
            internalFindViewById2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.b();
                }
            });
        }
    }
}
