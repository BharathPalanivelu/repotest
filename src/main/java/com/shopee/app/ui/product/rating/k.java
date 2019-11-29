package com.shopee.app.ui.product.rating;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.devspark.robototextview.widget.RobotoTextView;
import com.shopee.app.ui.common.AvatarView;
import com.shopee.app.ui.common.m;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class k extends j implements a, b {
    private boolean j = false;
    private final c k = new c();

    public k(Context context) {
        super(context);
        e();
    }

    public static j a(Context context) {
        k kVar = new k(context);
        kVar.onFinishInflate();
        return kVar;
    }

    public void onFinishInflate() {
        if (!this.j) {
            this.j = true;
            inflate(getContext(), R.layout.rating_image_overlay, this);
            this.k.a((a) this);
        }
        super.onFinishInflate();
    }

    private void e() {
        c a2 = c.a(this.k);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f24773b = (m) aVar.internalFindViewById(R.id.open_btn);
        this.f24774c = aVar.internalFindViewById(R.id.container);
        this.f24775d = aVar.internalFindViewById(R.id.bottom);
        this.f24776e = (RobotoTextView) aVar.internalFindViewById(R.id.content);
        this.f24777f = (AvatarView) aVar.internalFindViewById(R.id.avatar);
        this.f24778g = (RobotoTextView) aVar.internalFindViewById(R.id.username);
        this.h = (LinearLayout) aVar.internalFindViewById(R.id.five_star_panel);
        this.i = (RobotoTextView) aVar.internalFindViewById(R.id.time);
        a();
    }
}
