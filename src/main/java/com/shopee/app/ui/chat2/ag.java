package com.shopee.app.ui.chat2;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class ag extends af implements a, b {
    private boolean m = false;
    private final c n = new c();

    public ag(Context context) {
        super(context);
        e();
    }

    public static af a(Context context) {
        ag agVar = new ag(context);
        agVar.onFinishInflate();
        return agVar;
    }

    public void onFinishInflate() {
        if (!this.m) {
            this.m = true;
            inflate(getContext(), R.layout.message_shortcut_layout, this);
            this.n.a((a) this);
        }
        super.onFinishInflate();
    }

    private void e() {
        c a2 = c.a(this.n);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f20267a = (ListView) aVar.internalFindViewById(R.id.msg_shortcut_list);
        this.f20268b = (TextView) aVar.internalFindViewById(R.id.msg_shortcut_info);
        this.f20269c = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.message_shortcut_option);
        this.f20270d = aVar.internalFindViewById(R.id.divider);
        if (this.f20267a != null) {
            this.f20267a.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* JADX WARNING: type inference failed for: r1v0, types: [android.widget.AdapterView<?>, android.widget.AdapterView] */
                /* JADX WARNING: Unknown variable types count: 1 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onItemClick(android.widget.AdapterView<?> r1, android.view.View r2, int r3, long r4) {
                    /*
                        r0 = this;
                        com.shopee.app.ui.chat2.ag r2 = com.shopee.app.ui.chat2.ag.this
                        android.widget.Adapter r1 = r1.getAdapter()
                        java.lang.Object r1 = r1.getItem(r3)
                        com.shopee.app.ui.chat2.aj r1 = (com.shopee.app.ui.chat2.aj) r1
                        r2.a((com.shopee.app.ui.chat2.aj) r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.chat2.ag.AnonymousClass1.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
                }
            });
            this.f20267a.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                /* JADX WARNING: type inference failed for: r1v0, types: [android.widget.AdapterView<?>, android.widget.AdapterView] */
                /* JADX WARNING: Unknown variable types count: 1 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public boolean onItemLongClick(android.widget.AdapterView<?> r1, android.view.View r2, int r3, long r4) {
                    /*
                        r0 = this;
                        com.shopee.app.ui.chat2.ag r2 = com.shopee.app.ui.chat2.ag.this
                        android.widget.Adapter r1 = r1.getAdapter()
                        java.lang.Object r1 = r1.getItem(r3)
                        com.shopee.app.ui.chat2.aj r1 = (com.shopee.app.ui.chat2.aj) r1
                        r2.b((com.shopee.app.ui.chat2.aj) r1)
                        r1 = 1
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.chat2.ag.AnonymousClass2.onItemLongClick(android.widget.AdapterView, android.view.View, int, long):boolean");
                }
            });
        }
        a();
    }
}
