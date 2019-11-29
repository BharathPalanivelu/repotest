package com.shopee.app.ui.product.attributes;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.garena.android.uikit.fluid.tagcloud.GTagCloud;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class d extends c implements a, b {
    private boolean m = false;
    private final c n = new c();

    public d(Context context) {
        super(context);
        f();
    }

    public static c a(Context context) {
        d dVar = new d(context);
        dVar.onFinishInflate();
        return dVar;
    }

    public void onFinishInflate() {
        if (!this.m) {
            this.m = true;
            inflate(getContext(), R.layout.attribute_item_layout, this);
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
        this.f24248a = (GTagCloud) aVar.internalFindViewById(R.id.tagCloud);
        this.f24249b = aVar.internalFindViewById(R.id.divider2);
        this.f24250c = aVar.internalFindViewById(R.id.attribute_layout);
        this.f24251d = (TextView) aVar.internalFindViewById(R.id.sub_attribute_name);
        this.f24252e = (ImageButton) aVar.internalFindViewById(R.id.attribute_help);
        this.f24253f = (TextView) aVar.internalFindViewById(R.id.toggle_view);
        this.f24254g = (EditText) aVar.internalFindViewById(R.id.edit_view);
        if (this.f24251d != null) {
            this.f24251d.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    d.this.d();
                    return true;
                }
            });
        }
        a();
    }
}
