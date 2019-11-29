package com.shopee.app.ui.chat2.product.c;

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
    RecyclerView f20756a;

    /* renamed from: b  reason: collision with root package name */
    View f20757b;

    /* renamed from: c  reason: collision with root package name */
    TextView f20758c;

    /* renamed from: d  reason: collision with root package name */
    bc f20759d;

    /* renamed from: e  reason: collision with root package name */
    d f20760e;

    /* renamed from: f  reason: collision with root package name */
    Activity f20761f;

    /* renamed from: g  reason: collision with root package name */
    com.shopee.app.ui.actionbar.a f20762g;
    private b h;
    private ae i;
    private final int j;

    /* renamed from: com.shopee.app.ui.chat2.product.c.a$a  reason: collision with other inner class name */
    public interface C0309a {
        void a(a aVar);
    }

    public a(Context context, int i2) {
        super(context);
        this.j = i2;
        ((C0309a) ((x) getContext()).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f20759d.a(this.f20760e);
        this.f20760e.a(this);
        this.h = new b(new m());
        d.a(this.f20756a, this.f20757b, this.h);
        this.f20756a.setLayoutManager(new NPALinearLayoutManager(getContext()));
        ((s) this.f20756a.getItemAnimator()).setSupportsChangeAnimations(false);
        this.i = new ae(this.f20756a, this.h);
        this.i.a((ae.a) this.f20760e);
        this.f20756a.setAdapter(this.h);
        this.f20760e.a(this.j, 0);
    }

    public void e() {
        if (this.f20760e.h()) {
            this.f20758c.setText(R.string.sp_search_product_not_found);
        } else {
            this.f20758c.setText(R.string.sp_no_product_yet);
        }
    }

    public void a(List<ItemDetail> list) {
        this.h.a(list);
        this.h.notifyDataSetChanged();
    }

    public void f() {
        this.i.c();
    }

    public void g() {
        this.i.b();
    }

    public void h() {
        this.i.d();
    }

    public void a() {
        this.f20760e.c();
        this.f20760e.a(this.f20762g.getSearchView());
    }

    public void b() {
        this.f20760e.d();
    }

    private static class b extends y<ItemDetail> {
        public b(com.shopee.app.ui.a.s<ItemDetail> sVar) {
            super(sVar);
        }
    }
}
