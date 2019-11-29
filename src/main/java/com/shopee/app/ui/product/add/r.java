package com.shopee.app.ui.product.add;

import android.content.Context;
import android.view.View;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class r extends q implements a, b {

    /* renamed from: e  reason: collision with root package name */
    private boolean f24152e = false;

    /* renamed from: f  reason: collision with root package name */
    private final c f24153f = new c();

    public r(Context context) {
        super(context);
        e();
    }

    public static q a(Context context) {
        r rVar = new r(context);
        rVar.onFinishInflate();
        return rVar;
    }

    public void onFinishInflate() {
        if (!this.f24152e) {
            this.f24152e = true;
            inflate(getContext(), R.layout.facebook_header_layout, this);
            this.f24153f.a((a) this);
        }
        super.onFinishInflate();
    }

    private void e() {
        c a2 = c.a(this.f24153f);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f24148a = aVar.internalFindViewById(R.id.title);
        this.f24149b = aVar.internalFindViewById(R.id.divider);
        this.f24150c = aVar.internalFindViewById(R.id.toggle_button);
        View internalFindViewById = aVar.internalFindViewById(R.id.no_page);
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    r.this.b();
                }
            });
        }
        a();
    }
}
