package com.shopee.app.ui.product.a;

import android.content.Context;
import android.view.View;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.c;

public final class b extends a implements a, org.a.a.b.b {

    /* renamed from: b  reason: collision with root package name */
    private boolean f23938b = false;

    /* renamed from: c  reason: collision with root package name */
    private final c f23939c = new c();

    public b(Context context, String str) {
        super(context, str);
        c();
    }

    public static a a(Context context, String str) {
        b bVar = new b(context, str);
        bVar.onFinishInflate();
        return bVar;
    }

    public void onFinishInflate() {
        if (!this.f23938b) {
            this.f23938b = true;
            inflate(getContext(), R.layout.scam_popup_layout, this);
            this.f23939c.a((a) this);
        }
        super.onFinishInflate();
    }

    private void c() {
        c a2 = c.a(this.f23939c);
        c.a((org.a.a.b.b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        View internalFindViewById = aVar.internalFindViewById(R.id.submit_btn);
        View internalFindViewById2 = aVar.internalFindViewById(R.id.close_btn);
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    b.this.a();
                }
            });
        }
        if (internalFindViewById2 != null) {
            internalFindViewById2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    b.this.b();
                }
            });
        }
    }
}
