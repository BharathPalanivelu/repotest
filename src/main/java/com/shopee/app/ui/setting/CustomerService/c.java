package com.shopee.app.ui.setting.CustomerService;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.devspark.robototextview.widget.RobotoTextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;

public final class c extends b implements a, b {

    /* renamed from: g  reason: collision with root package name */
    private boolean f25007g = false;
    private final org.a.a.b.c h = new org.a.a.b.c();

    public c(Context context) {
        super(context);
        b();
    }

    public static b a(Context context) {
        c cVar = new c(context);
        cVar.onFinishInflate();
        return cVar;
    }

    public void onFinishInflate() {
        if (!this.f25007g) {
            this.f25007g = true;
            inflate(getContext(), R.layout.customer_contact_layout, this);
            this.h.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        org.a.a.b.c a2 = org.a.a.b.c.a(this.h);
        Resources resources = getContext().getResources();
        org.a.a.b.c.a((b) this);
        this.f25005e = resources.getDimensionPixelOffset(R.dimen.font_size_12);
        this.f25004d = androidx.core.content.b.c(getContext(), R.color.black54);
        org.a.a.b.c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f25002b = (RobotoTextView) aVar.internalFindViewById(R.id.customer_phone);
        this.f25003c = (RobotoTextView) aVar.internalFindViewById(R.id.customer_email);
        if (this.f25003c != null) {
            this.f25003c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.a(view);
                }
            });
        }
        if (this.f25002b != null) {
            this.f25002b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.a(view);
                }
            });
        }
        a();
    }
}
