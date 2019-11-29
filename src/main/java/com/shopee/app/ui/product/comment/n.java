package com.shopee.app.ui.product.comment;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.shopee.app.ui.common.ag;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class n extends m implements a, b {
    private boolean m = false;
    private final c n = new c();

    public n(Context context, int i, long j, int i2) {
        super(context, i, j, i2);
        h();
    }

    public static m a(Context context, int i, long j, int i2) {
        n nVar = new n(context, i, j, i2);
        nVar.onFinishInflate();
        return nVar;
    }

    public void onFinishInflate() {
        if (!this.m) {
            this.m = true;
            inflate(getContext(), R.layout.product_comments_layout, this);
            this.n.a((a) this);
        }
        super.onFinishInflate();
    }

    private void h() {
        c a2 = c.a(this.n);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f24553a = (ListView) aVar.internalFindViewById(R.id.comment_list);
        this.f24554b = (ListView) aVar.internalFindViewById(R.id.user_list);
        this.f24555c = (ag) aVar.internalFindViewById(R.id.comment_text);
        this.f24556d = (TextView) aVar.internalFindViewById(R.id.label);
        this.f24557e = (ImageView) aVar.internalFindViewById(R.id.circle_icon);
        this.h = (f) aVar.internalFindViewById(R.id.buyer_review_switch);
        if (this.f24554b != null) {
            this.f24554b.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* JADX WARNING: type inference failed for: r1v0, types: [android.widget.AdapterView<?>, android.widget.AdapterView] */
                /* JADX WARNING: Unknown variable types count: 1 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onItemClick(android.widget.AdapterView<?> r1, android.view.View r2, int r3, long r4) {
                    /*
                        r0 = this;
                        com.shopee.app.ui.product.comment.n r2 = com.shopee.app.ui.product.comment.n.this
                        android.widget.Adapter r1 = r1.getAdapter()
                        java.lang.Object r1 = r1.getItem(r3)
                        com.shopee.app.data.viewmodel.UserBriefInfo r1 = (com.shopee.app.data.viewmodel.UserBriefInfo) r1
                        r2.a((com.shopee.app.data.viewmodel.UserBriefInfo) r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.product.comment.n.AnonymousClass1.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
                }
            });
        }
        d();
    }
}
