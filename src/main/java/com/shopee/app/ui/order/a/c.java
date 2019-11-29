package com.shopee.app.ui.order.a;

import com.garena.android.appkit.b.a;
import com.shopee.app.data.viewmodel.order.ReturnItem;
import java.util.List;

public class c extends a {

    /* renamed from: a  reason: collision with root package name */
    private final int f23461a;

    public c(int i, List<ReturnItem> list) {
        this.f23461a = i;
        this.data = list;
    }

    public int a() {
        return this.f23461a;
    }

    public List<ReturnItem> b() {
        return (List) this.data;
    }
}
