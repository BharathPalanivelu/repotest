package com.shopee.app.ui.setting;

import android.content.Context;
import android.view.View;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class j extends i implements a, b {

    /* renamed from: b  reason: collision with root package name */
    private boolean f25239b = false;

    /* renamed from: c  reason: collision with root package name */
    private final c f25240c = new c();

    public j(Context context) {
        super(context);
        d();
    }

    public static i a(Context context) {
        j jVar = new j(context);
        jVar.onFinishInflate();
        return jVar;
    }

    public void onFinishInflate() {
        if (!this.f25239b) {
            this.f25239b = true;
            inflate(getContext(), R.layout.notification_batch_layout, this);
            this.f25240c.a((a) this);
        }
        super.onFinishInflate();
    }

    private void d() {
        c a2 = c.a(this.f25240c);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        View internalFindViewById = aVar.internalFindViewById(R.id.push_notification);
        View internalFindViewById2 = aVar.internalFindViewById(R.id.email_notification);
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    j.this.b();
                }
            });
        }
        if (internalFindViewById2 != null) {
            internalFindViewById2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    j.this.c();
                }
            });
        }
        a();
    }
}
