package com.shopee.app.ui.income.b;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class e extends d implements a, b {

    /* renamed from: g  reason: collision with root package name */
    private boolean f23165g = false;
    private final c h = new c();

    public e(Context context, int i) {
        super(context, i);
        i();
    }

    public static d a(Context context, int i) {
        e eVar = new e(context, i);
        eVar.onFinishInflate();
        return eVar;
    }

    public void onFinishInflate() {
        if (!this.f23165g) {
            this.f23165g = true;
            inflate(getContext(), R.layout.transaction_list_layout, this);
            this.h.a((a) this);
        }
        super.onFinishInflate();
    }

    private void i() {
        c a2 = c.a(this.h);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f23157a = (ListView) aVar.internalFindViewById(R.id.listView);
        this.f23158b = (RelativeLayout) aVar.internalFindViewById(R.id.emptyView);
        this.f23159c = aVar.internalFindViewById(R.id.progress_wheel);
        if (this.f23157a != null) {
            this.f23157a.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* JADX WARNING: type inference failed for: r1v0, types: [android.widget.AdapterView<?>, android.widget.AdapterView] */
                /* JADX WARNING: Unknown variable types count: 1 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onItemClick(android.widget.AdapterView<?> r1, android.view.View r2, int r3, long r4) {
                    /*
                        r0 = this;
                        com.shopee.app.ui.income.b.e r2 = com.shopee.app.ui.income.b.e.this
                        android.widget.Adapter r1 = r1.getAdapter()
                        java.lang.Object r1 = r1.getItem(r3)
                        com.shopee.app.data.viewmodel.income.TransactionItem r1 = (com.shopee.app.data.viewmodel.income.TransactionItem) r1
                        r2.a((com.shopee.app.data.viewmodel.income.TransactionItem) r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.income.b.e.AnonymousClass1.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
                }
            });
        }
        d();
    }
}
