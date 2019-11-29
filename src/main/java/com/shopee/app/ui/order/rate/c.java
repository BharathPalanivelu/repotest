package com.shopee.app.ui.order.rate;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;

public final class c extends b implements a, b {
    private boolean m = false;
    private final org.a.a.b.c n = new org.a.a.b.c();

    public c(Context context) {
        super(context);
        f();
    }

    public static b a(Context context) {
        c cVar = new c(context);
        cVar.onFinishInflate();
        return cVar;
    }

    public void onFinishInflate() {
        if (!this.m) {
            this.m = true;
            inflate(getContext(), R.layout.order_rate_item_layout, this);
            this.n.a((a) this);
        }
        super.onFinishInflate();
    }

    private void f() {
        org.a.a.b.c a2 = org.a.a.b.c.a(this.n);
        Resources resources = getContext().getResources();
        org.a.a.b.c.a((b) this);
        this.l = resources.getDimensionPixelSize(R.dimen.font_size_14);
        this.j = androidx.core.content.b.c(getContext(), R.color.black87);
        this.k = androidx.core.content.b.c(getContext(), R.color.black26);
        org.a.a.b.c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f23763b = (ImageView) aVar.internalFindViewById(R.id.product_image);
        this.f23764c = (TextView) aVar.internalFindViewById(R.id.product_title);
        this.f23765d = (TextView) aVar.internalFindViewById(R.id.product_price);
        this.f23766e = (TextView) aVar.internalFindViewById(R.id.product_variation);
        this.f23767f = (Button) aVar.internalFindViewById(R.id.btn_left);
        this.f23768g = (Button) aVar.internalFindViewById(R.id.btn_middle);
        this.h = (Button) aVar.internalFindViewById(R.id.btn_right);
        this.i = (EditText) aVar.internalFindViewById(R.id.comment);
        if (this.f23767f != null) {
            this.f23767f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.b();
                }
            });
        }
        if (this.f23768g != null) {
            this.f23768g.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.c();
                }
            });
        }
        if (this.h != null) {
            this.h.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.d();
                }
            });
        }
        TextView textView = (TextView) aVar.internalFindViewById(R.id.comment);
        if (textView != null) {
            textView.addTextChangedListener(new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void afterTextChanged(Editable editable) {
                    c.this.a(editable);
                }
            });
        }
        a();
    }
}
