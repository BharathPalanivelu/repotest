package com.shopee.app.ui.chat2.product.a;

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
    RecyclerView f20692a;

    /* renamed from: b  reason: collision with root package name */
    View f20693b;

    /* renamed from: c  reason: collision with root package name */
    TextView f20694c;

    /* renamed from: d  reason: collision with root package name */
    bc f20695d;

    /* renamed from: e  reason: collision with root package name */
    d f20696e;

    /* renamed from: f  reason: collision with root package name */
    Activity f20697f;

    /* renamed from: g  reason: collision with root package name */
    com.shopee.app.ui.actionbar.a f20698g;
    private b h;
    private ae i;

    /* renamed from: com.shopee.app.ui.chat2.product.a.a$a  reason: collision with other inner class name */
    public interface C0307a {
        void a(a aVar);
    }

    public a(Context context) {
        super(context);
        ((C0307a) ((x) getContext()).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f20695d.a(this.f20696e);
        this.f20696e.a(this);
        this.h = new b(new m());
        d.a(this.f20692a, this.f20693b, this.h);
        this.f20692a.setLayoutManager(new NPALinearLayoutManager(getContext()));
        ((s) this.f20692a.getItemAnimator()).setSupportsChangeAnimations(false);
        this.i = new ae(this.f20692a, this.h);
        this.i.a((ae.a) this.f20696e);
        this.f20692a.setAdapter(this.h);
        this.f20696e.a(0, false);
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

    public void g() {
        this.i.d();
    }

    public void h() {
        if (this.f20696e.g()) {
            this.f20694c.setText(R.string.sp_search_product_not_found);
        } else {
            this.f20694c.setText(R.string.sp_no_product_yet);
        }
    }

    public void a() {
        this.f20696e.c();
        this.f20696e.a(this.f20698g.getSearchView());
    }

    public void b() {
        this.f20696e.d();
    }

    private static class b extends y<ItemDetail> {
        public b(com.shopee.app.ui.a.s<ItemDetail> sVar) {
            super(sVar);
        }
    }
}
