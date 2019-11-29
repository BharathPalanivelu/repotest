package com.shopee.app.ui.home.me.v3.feature.a;

import android.content.Context;
import android.view.View;
import com.shopee.app.ui.home.me.v3.feature.i;
import com.shopee.app.ui.home.me.v3.feature.n;
import d.a.j;
import java.util.ArrayList;
import java.util.List;

public final class f extends n {

    /* renamed from: b  reason: collision with root package name */
    public static final f f22554b = new f();

    /* renamed from: c  reason: collision with root package name */
    private static final List<String> f22555c = j.a((T[]) new String[]{"to_pay", "to_receive", "to_ship", "to_return", "to_rate"});

    /* renamed from: d  reason: collision with root package name */
    private static final List<String> f22556d = new ArrayList();

    public boolean a(i iVar) {
        d.d.b.j.b(iVar, "metaData");
        return true;
    }

    private f() {
        super("order", "my_purchase");
    }

    public final List<String> a() {
        return f22555c;
    }

    public final List<String> b() {
        return f22556d;
    }

    public View a(Context context) {
        d.d.b.j.b(context, "context");
        g a2 = h.a(context);
        d.d.b.j.a((Object) a2, "MyPurchaseFeatureView_.build(context)");
        return a2;
    }
}
