package com.shopee.app.ui.error;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;

public final class c extends b implements a, b {

    /* renamed from: c  reason: collision with root package name */
    private boolean f21609c = false;

    /* renamed from: d  reason: collision with root package name */
    private final org.a.a.b.c f21610d = new org.a.a.b.c();

    public c(Context context) {
        super(context);
        d();
    }

    public static b a(Context context) {
        c cVar = new c(context);
        cVar.onFinishInflate();
        return cVar;
    }

    public void onFinishInflate() {
        if (!this.f21609c) {
            this.f21609c = true;
            inflate(getContext(), R.layout.error_layout, this);
            this.f21610d.a((a) this);
        }
        super.onFinishInflate();
    }

    private void d() {
        org.a.a.b.c a2 = org.a.a.b.c.a(this.f21610d);
        org.a.a.b.c.a((b) this);
        org.a.a.b.c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21606a = (TextView) aVar.internalFindViewById(R.id.error_text);
        this.f21607b = (ImageButton) aVar.internalFindViewById(R.id.back_button);
        View internalFindViewById = aVar.internalFindViewById(R.id.button);
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.b();
                }
            });
        }
        if (this.f21607b != null) {
            this.f21607b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.c();
                }
            });
        }
        a();
    }
}
