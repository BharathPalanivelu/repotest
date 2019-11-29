package com.shopee.app.ui.order.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.tabs.TabLayout;
import com.shopee.app.data.viewmodel.OrderKey;
import com.shopee.id.R;
import java.util.List;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class f extends e implements a, b {
    private boolean h = false;
    private final c i = new c();

    public f(Context context, List<OrderKey> list, String str) {
        super(context, list, str);
        g();
    }

    public static e a(Context context, List<OrderKey> list, String str) {
        f fVar = new f(context, list, str);
        fVar.onFinishInflate();
        return fVar;
    }

    public void onFinishInflate() {
        if (!this.h) {
            this.h = true;
            inflate(getContext(), R.layout.order_container_layout, this);
            this.i.a((a) this);
        }
        super.onFinishInflate();
    }

    private void g() {
        c a2 = c.a(this.i);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public void onViewChanged(a aVar) {
        this.f23575d = (TabLayout) aVar.internalFindViewById(R.id.tab);
        this.f23576e = (ViewGroup) aVar.internalFindViewById(R.id.tabView);
        this.f23577f = aVar.internalFindViewById(R.id.groupBuyOrderNotice);
        if (this.f23577f != null) {
            this.f23577f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    f.this.e();
                }
            });
        }
        d();
    }
}
