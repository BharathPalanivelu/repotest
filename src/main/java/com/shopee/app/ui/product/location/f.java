package com.shopee.app.ui.product.location;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class f extends e implements a, b {

    /* renamed from: e  reason: collision with root package name */
    private boolean f24643e = false;

    /* renamed from: f  reason: collision with root package name */
    private final c f24644f = new c();

    public f(Context context) {
        super(context);
        i();
    }

    public static e a(Context context) {
        f fVar = new f(context);
        fVar.onFinishInflate();
        return fVar;
    }

    public void onFinishInflate() {
        if (!this.f24643e) {
            this.f24643e = true;
            inflate(getContext(), R.layout.set_location_notice_layout, this);
            this.f24644f.a((a) this);
        }
        super.onFinishInflate();
    }

    private void i() {
        c a2 = c.a(this.f24644f);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f24636a = (TextView) aVar.internalFindViewById(R.id.shop_location_maps);
        this.f24637b = (EditText) aVar.internalFindViewById(R.id.shop_location);
        if (this.f24636a != null) {
            this.f24636a.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    f.this.h();
                }
            });
        }
        if (this.f24637b != null) {
            this.f24637b.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z) {
                    f.this.g();
                }
            });
        }
        a();
    }
}
