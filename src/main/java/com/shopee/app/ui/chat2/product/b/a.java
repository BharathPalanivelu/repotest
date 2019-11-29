package com.shopee.app.ui.chat2.product.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.s;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.g.d;
import com.shopee.app.ui.a.y;
import com.shopee.app.ui.chat2.product.m;
import com.shopee.app.ui.common.NPALinearLayoutManager;
import com.shopee.app.ui.common.ae;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.List;

public class a extends com.garena.android.uikit.a.a.a {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f20725a;

    /* renamed from: b  reason: collision with root package name */
    View f20726b;

    /* renamed from: c  reason: collision with root package name */
    TextView f20727c;

    /* renamed from: d  reason: collision with root package name */
    bc f20728d;

    /* renamed from: e  reason: collision with root package name */
    d f20729e;

    /* renamed from: f  reason: collision with root package name */
    Activity f20730f;

    /* renamed from: g  reason: collision with root package name */
    com.shopee.app.ui.actionbar.a f20731g;
    private b h;
    private ae i;
    private final int j;
    private String k;

    /* renamed from: com.shopee.app.ui.chat2.product.b.a$a  reason: collision with other inner class name */
    public interface C0308a {
        void a(a aVar);
    }

    public a(Context context, int i2, String str) {
        super(context);
        this.j = i2;
        this.k = str;
        ((C0308a) ((x) getContext()).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f20728d.a(this.f20729e);
        this.f20729e.a(this);
        this.h = new b(new m());
        d.a(this.f20725a, this.f20726b, this.h);
        this.f20725a.setLayoutManager(new NPALinearLayoutManager(getContext()));
        ((s) this.f20725a.getItemAnimator()).setSupportsChangeAnimations(false);
        this.i = new ae(this.f20725a, this.h);
        this.i.a((ae.a) this.f20729e);
        this.f20725a.setAdapter(this.h);
        this.f20729e.a(this.j, 0, this.k);
    }

    public void a(boolean z) {
        if (z) {
            this.f20727c.setText(R.string.sp_search_product_not_found);
        } else {
            this.f20727c.setText(R.string.sp_no_product_yet);
        }
    }

    public void a(List<ItemDetail> list) {
        this.h.a(list);
        this.h.notifyDataSetChanged();
    }

    public void e() {
        this.i.c();
    }

    public void f() {
        this.i.b();
    }

    public void a() {
        this.f20729e.c();
        this.f20729e.a(this.f20731g.getSearchView());
    }

    public void b() {
        this.f20729e.d();
    }

    private static class b extends y<ItemDetail> {
        public b(com.shopee.app.ui.a.s<ItemDetail> sVar) {
            super(sVar);
        }
    }
}
