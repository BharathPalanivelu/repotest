package com.shopee.app.ui.product.add;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class ah extends ag implements a, b {
    private boolean k = false;
    private final c l = new c();

    public ah(Context context) {
        super(context);
        c();
    }

    public static ag a(Context context) {
        ah ahVar = new ah(context);
        ahVar.onFinishInflate();
        return ahVar;
    }

    public void onFinishInflate() {
        if (!this.k) {
            this.k = true;
            inflate(getContext(), R.layout.model_view, this);
            this.l.a((a) this);
        }
        super.onFinishInflate();
    }

    private void c() {
        c a2 = c.a(this.l);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.h = resources.getDimensionPixelSize(R.dimen.dp1);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f23990a = (EditText) aVar.internalFindViewById(R.id.model_price_input);
        this.f23991b = (EditText) aVar.internalFindViewById(R.id.model_stock_input);
        this.f23992c = (EditText) aVar.internalFindViewById(R.id.set_model_input);
        this.f23993d = (TextView) aVar.internalFindViewById(R.id.model_price_title);
        this.f23994e = (TextView) aVar.internalFindViewById(R.id.model_stock_text);
        this.f23995f = aVar.internalFindViewById(R.id.model_stock);
        this.f23996g = (TextView) aVar.internalFindViewById(R.id.model_type_text);
        View internalFindViewById = aVar.internalFindViewById(R.id.delete_icon);
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ah.this.b();
                }
            });
        }
        a();
    }
}
