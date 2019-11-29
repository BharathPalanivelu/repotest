package com.shopee.app.ui.follow.following.recommend;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class k extends j implements a, b {
    private boolean k = false;
    private final c l = new c();

    public k(Context context, int i, int i2) {
        super(context, i, i2);
        h();
    }

    public static j a(Context context, int i, int i2) {
        k kVar = new k(context, i, i2);
        kVar.onFinishInflate();
        return kVar;
    }

    public void onFinishInflate() {
        if (!this.k) {
            this.k = true;
            inflate(getContext(), R.layout.recommend_friend_layout, this);
            this.l.a((a) this);
        }
        super.onFinishInflate();
    }

    private void h() {
        c a2 = c.a(this.l);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21714a = (TextView) aVar.internalFindViewById(R.id.empty_view_label);
        this.h = (ListView) aVar.internalFindViewById(R.id.recommend_friends_list);
        this.i = (TextView) aVar.internalFindViewById(R.id.bottom_text_view);
        this.j = (RelativeLayout) aVar.internalFindViewById(R.id.bottom_view);
        View internalFindViewById = aVar.internalFindViewById(R.id.follow_all_button);
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    k.this.a();
                }
            });
        }
        if (this.h != null) {
            this.h.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* JADX WARNING: type inference failed for: r1v0, types: [android.widget.AdapterView<?>, android.widget.AdapterView] */
                /* JADX WARNING: Unknown variable types count: 1 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onItemClick(android.widget.AdapterView<?> r1, android.view.View r2, int r3, long r4) {
                    /*
                        r0 = this;
                        com.shopee.app.ui.follow.following.recommend.k r2 = com.shopee.app.ui.follow.following.recommend.k.this
                        android.widget.Adapter r1 = r1.getAdapter()
                        java.lang.Object r1 = r1.getItem(r3)
                        com.shopee.app.database.orm.bean.DBContactInfo r1 = (com.shopee.app.database.orm.bean.DBContactInfo) r1
                        r2.a((com.shopee.app.database.orm.bean.DBContactInfo) r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.follow.following.recommend.k.AnonymousClass2.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
                }
            });
        }
        e();
    }
}
