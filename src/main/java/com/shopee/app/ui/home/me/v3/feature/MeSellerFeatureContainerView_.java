package com.shopee.app.ui.home.me.v3.feature;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class MeSellerFeatureContainerView_ extends k implements a, b {

    /* renamed from: f  reason: collision with root package name */
    private boolean f22539f = false;

    /* renamed from: g  reason: collision with root package name */
    private final c f22540g = new c();

    public MeSellerFeatureContainerView_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g();
    }

    public MeSellerFeatureContainerView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    public MeSellerFeatureContainerView_(Context context) {
        super(context);
        g();
    }

    public void onFinishInflate() {
        if (!this.f22539f) {
            this.f22539f = true;
            inflate(getContext(), R.layout.me_tab_seller_view_4, this);
            this.f22540g.a((a) this);
        }
        super.onFinishInflate();
    }

    private void g() {
        c a2 = c.a(this.f22540g);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f22628a = (MeFeatureRecyclerView) aVar.internalFindViewById(R.id.recycler_view);
        View internalFindViewById = aVar.internalFindViewById(R.id.vacationMode);
        View internalFindViewById2 = aVar.internalFindViewById(R.id.btnViewMyShop);
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MeSellerFeatureContainerView_.this.f();
                }
            });
        }
        if (internalFindViewById2 != null) {
            internalFindViewById2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MeSellerFeatureContainerView_.this.a(view);
                }
            });
        }
        a();
    }
}
