package com.shopee.app.ui.product.comment;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.garena.android.uikit.grid.GGridView;
import com.shopee.app.ui.common.AvatarView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class d extends c implements a, b {
    private boolean r = false;
    private final c s = new c();

    public d(Context context) {
        super(context);
        b();
    }

    public static c a(Context context) {
        d dVar = new d(context);
        dVar.onFinishInflate();
        return dVar;
    }

    public void onFinishInflate() {
        if (!this.r) {
            this.r = true;
            inflate(getContext(), R.layout.comment_item_layout, this);
            this.s.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.s);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.p = resources.getDimensionPixelSize(R.dimen.dp8);
        this.q = resources.getDimensionPixelSize(R.dimen.dp1);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f24469a = (AvatarView) aVar.internalFindViewById(R.id.avatar);
        this.f24470b = (TextView) aVar.internalFindViewById(R.id.username);
        this.f24471c = (LinearLayout) aVar.internalFindViewById(R.id.buyer_review_panel);
        this.f24472d = (LinearLayout) aVar.internalFindViewById(R.id.five_star_panel);
        this.f24473e = (TextView) aVar.internalFindViewById(R.id.label);
        this.f24474f = (TextView) aVar.internalFindViewById(R.id.time);
        this.f24475g = (TextView) aVar.internalFindViewById(R.id.content);
        this.h = (GGridView) aVar.internalFindViewById(R.id.imageGrid);
        this.i = (ImageView) aVar.internalFindViewById(R.id.singleImage);
        this.j = aVar.internalFindViewById(R.id.imageContainer);
        this.k = (ImageView) aVar.internalFindViewById(R.id.option_icon);
        this.l = aVar.internalFindViewById(R.id.option_container);
        a();
    }
}
