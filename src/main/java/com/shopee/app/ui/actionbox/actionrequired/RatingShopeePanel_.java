package com.shopee.app.ui.actionbox.actionrequired;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class RatingShopeePanel_ extends c implements a, b {
    private boolean l = false;
    private final c m = new c();

    public RatingShopeePanel_(Context context) {
        super(context);
        c();
    }

    public RatingShopeePanel_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public RatingShopeePanel_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c();
    }

    public static c a(Context context) {
        RatingShopeePanel_ ratingShopeePanel_ = new RatingShopeePanel_(context);
        ratingShopeePanel_.onFinishInflate();
        return ratingShopeePanel_;
    }

    public void onFinishInflate() {
        if (!this.l) {
            this.l = true;
            inflate(getContext(), R.layout.rating_shopee_view, this);
            this.m.a((a) this);
        }
        super.onFinishInflate();
    }

    private void c() {
        c a2 = c.a(this.m);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.f19352f = resources.getDimensionPixelSize(R.dimen.dp36);
        this.f19353g = resources.getDimensionPixelSize(R.dimen.dp8);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f19347a = (TextView) aVar.internalFindViewById(R.id.rating_title);
        this.f19348b = (LinearLayout) aVar.internalFindViewById(R.id.rating_btn_panel);
        this.f19349c = (Button) aVar.internalFindViewById(R.id.button_left);
        this.f19350d = (Button) aVar.internalFindViewById(R.id.button_right);
        this.f19351e = (Button) aVar.internalFindViewById(R.id.btn_whole_row);
        View internalFindViewById = aVar.internalFindViewById(R.id.rating_close);
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    RatingShopeePanel_.this.b();
                }
            });
        }
        a();
    }
}
