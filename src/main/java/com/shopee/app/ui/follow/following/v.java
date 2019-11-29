package com.shopee.app.ui.follow.following;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.devspark.robototextview.widget.RobotoButton;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class v extends u implements a, b {
    private boolean t = false;
    private final c u = new c();

    public v(Context context) {
        super(context);
        b();
    }

    public static u a(Context context) {
        v vVar = new v(context);
        vVar.onFinishInflate();
        return vVar;
    }

    public void onFinishInflate() {
        if (!this.t) {
            this.t = true;
            inflate(getContext(), R.layout.recommend_friend_item_layout, this);
            this.u.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.u);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21736a = (ImageView) aVar.internalFindViewById(R.id.avatar);
        this.f21737b = (TextView) aVar.internalFindViewById(R.id.username);
        this.f21738c = (TextView) aVar.internalFindViewById(R.id.description);
        this.f21739d = (RobotoButton) aVar.internalFindViewById(R.id.follow_button);
        this.f21740e = (LinearLayout) aVar.internalFindViewById(R.id.products_panel);
        this.f21741f = (ImageView) aVar.internalFindViewById(R.id.product1);
        this.f21742g = (ImageView) aVar.internalFindViewById(R.id.product2);
        this.h = (ImageView) aVar.internalFindViewById(R.id.product3);
        this.i = (ImageView) aVar.internalFindViewById(R.id.product0);
        this.j = (TextView) aVar.internalFindViewById(R.id.product_text1);
        this.k = (TextView) aVar.internalFindViewById(R.id.product_text2);
        this.l = (TextView) aVar.internalFindViewById(R.id.product_text3);
        this.m = (TextView) aVar.internalFindViewById(R.id.product_text0);
        this.n = (RelativeLayout) aVar.internalFindViewById(R.id.product_panel1);
        this.o = (RelativeLayout) aVar.internalFindViewById(R.id.product_panel2);
        this.p = (RelativeLayout) aVar.internalFindViewById(R.id.product_panel3);
        this.q = (RelativeLayout) aVar.internalFindViewById(R.id.product_panel0);
        if (this.f21739d != null) {
            this.f21739d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    v.this.a();
                }
            });
        }
    }
}
