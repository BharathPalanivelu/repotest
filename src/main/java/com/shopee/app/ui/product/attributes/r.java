package com.shopee.app.ui.product.attributes;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class r extends q implements a, b {
    private boolean i = false;
    private final c j = new c();

    public r(Context context, int i2, String str, int i3, byte[] bArr, int i4, boolean z) {
        super(context, i2, str, i3, bArr, i4, z);
        f();
    }

    public static q a(Context context, int i2, String str, int i3, byte[] bArr, int i4, boolean z) {
        r rVar = new r(context, i2, str, i3, bArr, i4, z);
        rVar.onFinishInflate();
        return rVar;
    }

    public void onFinishInflate() {
        if (!this.i) {
            this.i = true;
            inflate(getContext(), R.layout.attribute_list_layout, this);
            this.j.a((a) this);
        }
        super.onFinishInflate();
    }

    private void f() {
        c a2 = c.a(this.j);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public void onViewChanged(a aVar) {
        this.f24332a = (ListView) aVar.internalFindViewById(R.id.attr_list);
        this.f24333b = aVar.internalFindViewById(R.id.empty_vew);
        if (this.f24332a != null) {
            this.f24332a.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* JADX WARNING: type inference failed for: r1v0, types: [android.widget.AdapterView<?>, android.widget.AdapterView] */
                /* JADX WARNING: Unknown variable types count: 1 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onItemClick(android.widget.AdapterView<?> r1, android.view.View r2, int r3, long r4) {
                    /*
                        r0 = this;
                        com.shopee.app.ui.product.attributes.r r2 = com.shopee.app.ui.product.attributes.r.this
                        android.widget.Adapter r1 = r1.getAdapter()
                        java.lang.Object r1 = r1.getItem(r3)
                        com.shopee.app.ui.product.attributes.v r1 = (com.shopee.app.ui.product.attributes.v) r1
                        r2.a((com.shopee.app.ui.product.attributes.v) r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.product.attributes.r.AnonymousClass1.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
                }
            });
        }
        a();
    }
}
