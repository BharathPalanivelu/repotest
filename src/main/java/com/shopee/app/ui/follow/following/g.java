package com.shopee.app.ui.follow.following;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class g extends f implements a, b {
    private boolean o = false;
    private final c p = new c();

    public g(Context context) {
        super(context);
        h();
    }

    public static f a(Context context) {
        g gVar = new g(context);
        gVar.onFinishInflate();
        return gVar;
    }

    public void onFinishInflate() {
        if (!this.o) {
            this.o = true;
            inflate(getContext(), R.layout.add_friend_layout, this);
            this.p.a((a) this);
        }
        super.onFinishInflate();
    }

    private void h() {
        c a2 = c.a(this.p);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21634a = (ListView) aVar.internalFindViewById(R.id.recommend_friends_list);
        if (this.f21634a != null) {
            this.f21634a.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* JADX WARNING: type inference failed for: r1v0, types: [android.widget.AdapterView<?>, android.widget.AdapterView] */
                /* JADX WARNING: Unknown variable types count: 1 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onItemClick(android.widget.AdapterView<?> r1, android.view.View r2, int r3, long r4) {
                    /*
                        r0 = this;
                        com.shopee.app.ui.follow.following.g r2 = com.shopee.app.ui.follow.following.g.this
                        android.widget.Adapter r1 = r1.getAdapter()
                        java.lang.Object r1 = r1.getItem(r3)
                        com.shopee.app.ui.follow.following.t r1 = (com.shopee.app.ui.follow.following.t) r1
                        r2.a((com.shopee.app.ui.follow.following.t) r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.follow.following.g.AnonymousClass1.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
                }
            });
        }
        a();
    }
}
