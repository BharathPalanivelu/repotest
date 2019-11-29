package com.shopee.app.ui.common.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.garena.android.appkit.btmsheet.MaxHeightScrollView;
import com.garena.android.uikit.fluid.tagcloud.GTagCloud;
import com.shopee.app.ui.common.TierVariationView;
import com.shopee.app.ui.common.m;
import com.shopee.app.ui.dialog.g;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class d extends c implements a, b {
    private boolean E = false;
    private final c F = new c();

    public d(Context context, int i) {
        super(context, i);
        j();
    }

    public static c a(Context context, int i) {
        d dVar = new d(context, i);
        dVar.onFinishInflate();
        return dVar;
    }

    public void onFinishInflate() {
        if (!this.E) {
            this.E = true;
            inflate(getContext(), R.layout.buy_now_view, this);
            this.F.a((a) this);
        }
        super.onFinishInflate();
    }

    private void j() {
        c a2 = c.a(this.F);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.B = resources.getString(R.string.sp_new_n_old_price);
        this.C = resources.getDimensionPixelSize(R.dimen.font_size_14);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21070a = (m) aVar.internalFindViewById(R.id.closeButton);
        this.f21071b = (ImageView) aVar.internalFindViewById(R.id.icon);
        this.f21072c = (TextView) aVar.internalFindViewById(R.id.price);
        this.f21073d = (TextView) aVar.internalFindViewById(R.id.stock);
        this.f21074e = (MaxHeightScrollView) aVar.internalFindViewById(R.id.oldVariant);
        this.f21075f = (TextView) aVar.internalFindViewById(R.id.variationTitle);
        this.f21076g = (TextView) aVar.internalFindViewById(R.id.textSizeChart);
        this.h = (TierVariationView) aVar.internalFindViewById(R.id.tierVariant);
        this.i = (GTagCloud) aVar.internalFindViewById(R.id.variationGrid);
        this.j = aVar.internalFindViewById(R.id.divider_quantity);
        this.k = (g) aVar.internalFindViewById(R.id.quantity_section);
        this.l = aVar.internalFindViewById(R.id.divider_buy_now);
        this.m = (Button) aVar.internalFindViewById(R.id.buy_btn);
        this.n = aVar.internalFindViewById(R.id.variationDivider);
        this.o = (TextView) aVar.internalFindViewById(R.id.wholeSaleView);
        if (this.f21070a != null) {
            this.f21070a.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    d.this.b();
                }
            });
        }
        if (this.m != null) {
            this.m.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    d.this.c();
                }
            });
        }
        if (this.f21076g != null) {
            this.f21076g.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    d.this.d();
                }
            });
        }
        a();
    }
}
