package com.shopee.app.ui.chat2.product;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.s;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.h.r;
import com.shopee.app.ui.a.y;
import com.shopee.app.ui.chat.b;
import com.shopee.app.ui.chat2.ai;
import com.shopee.app.ui.common.NPALinearLayoutManager;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.List;

public class h extends com.garena.android.uikit.a.a.a implements y.a<ItemDetail> {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f20801a;

    /* renamed from: b  reason: collision with root package name */
    bc f20802b;

    /* renamed from: c  reason: collision with root package name */
    k f20803c;

    /* renamed from: d  reason: collision with root package name */
    Activity f20804d;

    /* renamed from: e  reason: collision with root package name */
    private final int f20805e;

    /* renamed from: f  reason: collision with root package name */
    private a f20806f;

    /* renamed from: g  reason: collision with root package name */
    private final int f20807g;

    public h(Context context, int i, int i2) {
        super(context);
        ((b) ((x) context).b()).a(this);
        this.f20805e = i;
        this.f20807g = i2;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f20802b.a(this.f20803c);
        this.f20803c.a(this);
        this.f20806f = new a(new ai());
        this.f20806f.a(this);
        this.f20801a.setLayoutManager(new NPALinearLayoutManager(getContext()));
        ((s) this.f20801a.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f20801a.setAdapter(this.f20806f);
    }

    public void a(View view, ItemDetail itemDetail, int i) {
        if (itemDetail.isOutStock()) {
            r.a().b((int) R.string.sp_item_out_of_stock_buy_tip);
            return;
        }
        com.shopee.app.ui.chat.a.f20001a = itemDetail;
        this.f20804d.setResult(-1);
        this.f20804d.finish();
    }

    public void a(List<ItemDetail> list) {
        this.f20806f.a(list);
        this.f20806f.notifyItemRangeChanged(0, list.size());
    }

    private static class a extends y<ItemDetail> {
        public a(com.shopee.app.ui.a.s<ItemDetail> sVar) {
            super(sVar);
        }
    }
}
