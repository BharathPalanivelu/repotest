package com.shopee.app.ui.common.b;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.garena.android.appkit.btmsheet.MaxHeightScrollView;
import com.garena.android.uikit.fluid.tagcloud.GTagCloud;
import com.shopee.app.ui.common.TierVariationView;
import com.shopee.app.ui.dialog.g;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class d extends c implements a, b {
    private boolean A = false;
    private final c B = new c();

    public d(Context context) {
        super(context);
        i();
    }

    public static c a(Context context) {
        d dVar = new d(context);
        dVar.onFinishInflate();
        return dVar;
    }

    public void onFinishInflate() {
        if (!this.A) {
            this.A = true;
            inflate(getContext(), R.layout.make_offer_layout2, this);
            this.B.a((a) this);
        }
        super.onFinishInflate();
    }

    private void i() {
        c a2 = c.a(this.B);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.w = resources.getString(R.string.sp_new_n_old_price);
        this.x = resources.getDimensionPixelSize(R.dimen.font_size_14);
        this.y = resources.getDimensionPixelSize(R.dimen.font_size_18);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21235a = (ImageView) aVar.internalFindViewById(R.id.icon);
        this.f21236b = (TextView) aVar.internalFindViewById(R.id.price);
        this.f21237c = (TextView) aVar.internalFindViewById(R.id.stock);
        this.f21238d = (MaxHeightScrollView) aVar.internalFindViewById(R.id.oldVariant);
        this.f21239e = (TextView) aVar.internalFindViewById(R.id.variationTitle);
        this.f21240f = (TextView) aVar.internalFindViewById(R.id.textSizeChart);
        this.f21241g = (TierVariationView) aVar.internalFindViewById(R.id.tierVariant);
        this.h = (GTagCloud) aVar.internalFindViewById(R.id.variationGrid);
        this.i = (g) aVar.internalFindViewById(R.id.quantity_section);
        this.j = (com.shopee.app.ui.dialog.c) aVar.internalFindViewById(R.id.price_section);
        this.k = aVar.internalFindViewById(R.id.variationDivider);
        this.l = aVar.internalFindViewById(R.id.divider_quantity);
        this.m = aVar.internalFindViewById(R.id.divider_price);
        this.n = aVar.internalFindViewById(R.id.button_panel);
        this.o = (Button) aVar.internalFindViewById(R.id.submit);
        View internalFindViewById = aVar.internalFindViewById(R.id.closeButton);
        View internalFindViewById2 = aVar.internalFindViewById(R.id.cancel);
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    d.this.b();
                }
            });
        }
        if (internalFindViewById2 != null) {
            internalFindViewById2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    d.this.c();
                }
            });
        }
        if (this.o != null) {
            this.o.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    d.this.d();
                }
            });
        }
        if (this.f21240f != null) {
            this.f21240f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    d.this.e();
                }
            });
        }
        a();
    }
}
