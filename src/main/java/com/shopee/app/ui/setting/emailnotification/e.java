package com.shopee.app.ui.setting.emailnotification;

import android.content.Context;
import android.view.View;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class e extends d implements a, b {
    private boolean m = false;
    private final c n = new c();

    public e(Context context) {
        super(context);
        f();
    }

    public static d a(Context context) {
        e eVar = new e(context);
        eVar.onFinishInflate();
        return eVar;
    }

    public void onFinishInflate() {
        if (!this.m) {
            this.m = true;
            inflate(getContext(), R.layout.email_notification_layout, this);
            this.n.a((a) this);
        }
        super.onFinishInflate();
    }

    private void f() {
        c a2 = c.a(this.n);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f25225a = aVar.internalFindViewById(R.id.container);
        this.f25226b = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.allow_email_setting);
        this.f25227c = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.order_notification);
        this.f25228d = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.listing_notification);
        this.f25229e = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.newsletter_notification);
        this.f25230f = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.personalised_content_notification);
        if (this.f25226b != null) {
            this.f25226b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    e.this.a(view);
                }
            });
        }
        if (this.f25230f != null) {
            this.f25230f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    e.this.b(view);
                }
            });
        }
        if (this.f25228d != null) {
            this.f25228d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    e.this.c(view);
                }
            });
        }
        if (this.f25229e != null) {
            this.f25229e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    e.this.d(view);
                }
            });
        }
        if (this.f25227c != null) {
            this.f25227c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    e.this.e(view);
                }
            });
        }
        a();
    }
}
