package com.shopee.app.ui.order.detail;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class l extends k implements a, b {
    private boolean o = false;
    private final c p = new c();

    public l(Context context) {
        super(context);
        d();
    }

    public static k a(Context context) {
        l lVar = new l(context);
        lVar.onFinishInflate();
        return lVar;
    }

    public void onFinishInflate() {
        if (!this.o) {
            this.o = true;
            inflate(getContext(), R.layout.order_product_info_view, this);
            this.p.a((a) this);
        }
        super.onFinishInflate();
    }

    private void d() {
        c a2 = c.a(this.p);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.k = resources.getString(R.string.sp_new_n_old_price);
        this.f23650g = resources.getDimensionPixelSize(R.dimen.dp16);
        this.h = resources.getDimensionPixelSize(R.dimen.dp8);
        this.i = resources.getDimensionPixelSize(R.dimen.font_size_14);
        this.j = androidx.core.content.b.c(getContext(), R.color.black26);
        a();
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f23644a = (ImageView) aVar.internalFindViewById(R.id.product_image);
        this.f23645b = (TextView) aVar.internalFindViewById(R.id.product_title);
        this.f23646c = (TextView) aVar.internalFindViewById(R.id.product_variation);
        this.f23647d = (TextView) aVar.internalFindViewById(R.id.product_price);
        this.f23648e = (TextView) aVar.internalFindViewById(R.id.product_quantity);
        this.f23649f = (TextView) aVar.internalFindViewById(R.id.send_btn);
        if (this.f23649f != null) {
            this.f23649f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    l.this.c();
                }
            });
        }
    }
}
