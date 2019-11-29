package com.shopee.app.ui.product.comment.FeedsComment;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.shopee.app.ui.common.AvatarView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.c;

public final class b extends a implements a, org.a.a.b.b {
    private boolean l = false;
    private final c m = new c();

    public b(Context context) {
        super(context);
        c();
    }

    public static a a(Context context) {
        b bVar = new b(context);
        bVar.onFinishInflate();
        return bVar;
    }

    public void onFinishInflate() {
        if (!this.l) {
            this.l = true;
            inflate(getContext(), R.layout.comment_item_layout, this);
            this.m.a((a) this);
        }
        super.onFinishInflate();
    }

    private void c() {
        c a2 = c.a(this.m);
        Resources resources = getContext().getResources();
        c.a((org.a.a.b.b) this);
        this.j = resources.getDimensionPixelSize(R.dimen.dp8);
        this.k = resources.getDimensionPixelSize(R.dimen.dp1);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f24410a = (AvatarView) aVar.internalFindViewById(R.id.avatar);
        this.f24411b = (TextView) aVar.internalFindViewById(R.id.username);
        this.f24412c = (LinearLayout) aVar.internalFindViewById(R.id.buyer_review_panel);
        this.f24413d = (LinearLayout) aVar.internalFindViewById(R.id.five_star_panel);
        this.f24414e = (TextView) aVar.internalFindViewById(R.id.label);
        this.f24415f = (TextView) aVar.internalFindViewById(R.id.time);
        this.f24416g = (TextView) aVar.internalFindViewById(R.id.content);
    }
}
