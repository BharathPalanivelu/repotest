package com.shopee.app.ui.product.search;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.shopee.app.web.protocol.SearchConfig;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class p extends o implements a, b {
    private boolean p = false;
    private final c q = new c();

    public p(Context context, String str, SearchConfig searchConfig, int i) {
        super(context, str, searchConfig, i);
        i();
    }

    public static o a(Context context, String str, SearchConfig searchConfig, int i) {
        p pVar = new p(context, str, searchConfig, i);
        pVar.onFinishInflate();
        return pVar;
    }

    public void onFinishInflate() {
        if (!this.p) {
            this.p = true;
            inflate(getContext(), R.layout.search_user_layout, this);
            this.q.a((a) this);
        }
        super.onFinishInflate();
    }

    private void i() {
        c a2 = c.a(this.q);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f24867b = (ListView) aVar.internalFindViewById(R.id.search_user_list);
        this.f24868c = (ProgressBar) aVar.internalFindViewById(R.id.progress);
        if (this.f24867b != null) {
            this.f24867b.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    p.this.a(i);
                }
            });
        }
        a();
    }
}
