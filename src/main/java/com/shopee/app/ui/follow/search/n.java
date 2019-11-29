package com.shopee.app.ui.follow.search;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class n extends m implements a, b {
    private boolean q = false;
    private final c r = new c();

    public n(Context context, String str, boolean z, int i, boolean z2, String str2) {
        super(context, str, z, i, z2, str2);
        k();
    }

    public static m a(Context context, String str, boolean z, int i, boolean z2, String str2) {
        n nVar = new n(context, str, z, i, z2, str2);
        nVar.onFinishInflate();
        return nVar;
    }

    public void onFinishInflate() {
        if (!this.q) {
            this.q = true;
            inflate(getContext(), R.layout.search_user_layout, this);
            this.r.a((a) this);
        }
        super.onFinishInflate();
    }

    private void k() {
        c a2 = c.a(this.r);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21818a = (ListView) aVar.internalFindViewById(R.id.search_user_list);
        this.f21819b = (ListView) aVar.internalFindViewById(R.id.history_and_hotKey_list);
        this.h = aVar.internalFindViewById(R.id.emptyView);
        if (this.f21819b != null) {
            this.f21819b.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* JADX WARNING: type inference failed for: r1v0, types: [android.widget.AdapterView<?>, android.widget.AdapterView] */
                /* JADX WARNING: Unknown variable types count: 1 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onItemClick(android.widget.AdapterView<?> r1, android.view.View r2, int r3, long r4) {
                    /*
                        r0 = this;
                        com.shopee.app.ui.follow.search.n r2 = com.shopee.app.ui.follow.search.n.this
                        android.widget.Adapter r1 = r1.getAdapter()
                        java.lang.Object r1 = r1.getItem(r3)
                        com.shopee.app.data.viewmodel.SearchProductItem r1 = (com.shopee.app.data.viewmodel.SearchProductItem) r1
                        r2.a((com.shopee.app.data.viewmodel.SearchProductItem) r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.follow.search.n.AnonymousClass1.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
                }
            });
        }
        if (this.f21818a != null) {
            this.f21818a.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    n.this.a(i);
                }
            });
        }
        a();
    }
}
