package com.shopee.app.ui.order.search;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.shopee.app.ui.a.n;
import com.shopee.app.util.ak;
import com.shopee.app.util.x;

public class g extends LinearLayout implements n<f> {

    /* renamed from: a  reason: collision with root package name */
    TextView f23817a;

    /* renamed from: b  reason: collision with root package name */
    TextView f23818b;

    /* renamed from: c  reason: collision with root package name */
    ak f23819c;

    /* renamed from: d  reason: collision with root package name */
    private f f23820d;

    public interface a {
        void a(g gVar);
    }

    public g(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        ((a) ((x) context).b()).a(this);
    }

    public void a(f fVar) {
        this.f23820d = fVar;
        this.f23817a.setText(fVar.f23811b);
        if (fVar.f23814e <= 3) {
            this.f23818b.setVisibility(8);
        } else {
            this.f23818b.setVisibility(0);
        }
    }
}
