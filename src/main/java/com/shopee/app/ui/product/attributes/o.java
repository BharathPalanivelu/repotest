package com.shopee.app.ui.product.attributes;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class o extends n implements a, b {

    /* renamed from: f  reason: collision with root package name */
    private boolean f24329f = false;

    /* renamed from: g  reason: collision with root package name */
    private final c f24330g = new c();

    public o(Context context) {
        super(context);
        e();
    }

    public static n a(Context context) {
        o oVar = new o(context);
        oVar.onFinishInflate();
        return oVar;
    }

    public void onFinishInflate() {
        if (!this.f24329f) {
            this.f24329f = true;
            inflate(getContext(), R.layout.attribute_list_self_define_item, this);
            this.f24330g.a((a) this);
        }
        super.onFinishInflate();
    }

    private void e() {
        c a2 = c.a(this.f24330g);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f24317a = (EditText) aVar.internalFindViewById(R.id.sub_attribute_name);
        this.f24318b = (Button) aVar.internalFindViewById(R.id.button1);
        if (this.f24318b != null) {
            this.f24318b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    o.this.c();
                }
            });
        }
        a();
    }
}
