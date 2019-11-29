package com.shopee.app.ui.myproduct.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;

public final class c extends b implements a, b {
    private boolean D = false;
    private final org.a.a.b.c E = new org.a.a.b.c();

    public c(Context context, int i) {
        super(context, i);
        g();
    }

    public static b a(Context context, int i) {
        c cVar = new c(context, i);
        cVar.onFinishInflate();
        return cVar;
    }

    public void onFinishInflate() {
        if (!this.D) {
            this.D = true;
            inflate(getContext(), R.layout.my_product_item_layout_with_view_count, this);
            this.E.a((a) this);
        }
        super.onFinishInflate();
    }

    private void g() {
        org.a.a.b.c a2 = org.a.a.b.c.a(this.E);
        Resources resources = getContext().getResources();
        org.a.a.b.c.a((b) this);
        this.n = resources.getString(R.string.sp_stock_n);
        this.o = resources.getString(R.string.sp_sold_n);
        this.p = resources.getString(R.string.sp_like_n);
        this.v = resources.getString(R.string.sp_sold_count);
        this.w = resources.getString(R.string.sp_like_count);
        this.x = resources.getString(R.string.sp_view_count);
        this.q = androidx.core.content.b.c(getContext(), R.color.black54);
        this.r = androidx.core.content.b.c(getContext(), R.color.black87);
        org.a.a.b.c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f23380a = (ImageView) aVar.internalFindViewById(R.id.product_image);
        this.f23381b = (TextView) aVar.internalFindViewById(R.id.product_title);
        this.f23382c = (TextView) aVar.internalFindViewById(R.id.product_price);
        this.f23383d = (TextView) aVar.internalFindViewById(R.id.edit_btn);
        this.f23384e = (TextView) aVar.internalFindViewById(R.id.stock);
        this.f23385f = (TextView) aVar.internalFindViewById(R.id.sold);
        this.f23386g = (TextView) aVar.internalFindViewById(R.id.like);
        this.h = (TextView) aVar.internalFindViewById(R.id.update_btn);
        this.i = (TextView) aVar.internalFindViewById(R.id.errorView);
        this.j = (ImageView) aVar.internalFindViewById(R.id.overlay);
        this.k = aVar.internalFindViewById(R.id.footer_divider);
        this.l = aVar.internalFindViewById(R.id.errorViewDivider);
        this.m = (TextView) aVar.internalFindViewById(R.id.outOfStockVariations);
        this.y = (TextView) aVar.internalFindViewById(R.id.view_count);
        this.z = (TextView) aVar.internalFindViewById(R.id.publish);
        this.A = (TextView) aVar.internalFindViewById(R.id.delete);
        this.B = aVar.internalFindViewById(R.id.unlisted_label);
        View internalFindViewById = aVar.internalFindViewById(R.id.item_container);
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.b();
                }
            });
        }
        if (this.h != null) {
            this.h.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.c();
                }
            });
        }
        if (this.f23383d != null) {
            this.f23383d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.a(view);
                }
            });
        }
        if (this.A != null) {
            this.A.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.e();
                }
            });
        }
        if (this.z != null) {
            this.z.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.f();
                }
            });
        }
        d();
    }
}
