package com.shopee.app.ui.product.comment.FeedsComment;

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

public final class h extends g implements a, b {
    private boolean l = false;
    private final c m = new c();

    public h(Context context, int i, long j) {
        super(context, i, j);
        g();
    }

    public static g a(Context context, int i, long j) {
        h hVar = new h(context, i, j);
        hVar.onFinishInflate();
        return hVar;
    }

    public void onFinishInflate() {
        if (!this.l) {
            this.l = true;
            inflate(getContext(), R.layout.feeds_comment_list_layout, this);
            this.m.a((a) this);
        }
        super.onFinishInflate();
    }

    private void g() {
        c a2 = c.a(this.m);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f24458a = (ListView) aVar.internalFindViewById(R.id.comment_list);
        this.f24459b = (ListView) aVar.internalFindViewById(R.id.user_list);
        this.f24460c = (ag) aVar.internalFindViewById(R.id.comment_text);
        this.j = (ImageView) aVar.internalFindViewById(R.id.circle_icon);
        this.k = (TextView) aVar.internalFindViewById(R.id.label);
        if (this.f24459b != null) {
            this.f24459b.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* JADX WARNING: type inference failed for: r1v0, types: [android.widget.AdapterView<?>, android.widget.AdapterView] */
                /* JADX WARNING: Unknown variable types count: 1 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onItemClick(android.widget.AdapterView<?> r1, android.view.View r2, int r3, long r4) {
                    /*
                        r0 = this;
                        com.shopee.app.ui.product.comment.FeedsComment.h r2 = com.shopee.app.ui.product.comment.FeedsComment.h.this
                        android.widget.Adapter r1 = r1.getAdapter()
                        java.lang.Object r1 = r1.getItem(r3)
                        com.shopee.app.data.viewmodel.UserBriefInfo r1 = (com.shopee.app.data.viewmodel.UserBriefInfo) r1
                        r2.a((com.shopee.app.data.viewmodel.UserBriefInfo) r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.product.comment.FeedsComment.h.AnonymousClass1.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
                }
            });
        }
        a();
    }
}
