package com.shopee.app.ui.chat2.offer.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.s;
import com.shopee.app.data.viewmodel.chatP2P.VMOfferHistory;
import com.shopee.app.g.d;
import com.shopee.app.ui.a.y;
import com.shopee.app.ui.chat.b;
import com.shopee.app.ui.common.NPALinearLayoutManager;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import java.util.List;

public class g extends com.garena.android.uikit.a.a.a {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f20596a;

    /* renamed from: b  reason: collision with root package name */
    View f20597b;

    /* renamed from: c  reason: collision with root package name */
    e f20598c;

    /* renamed from: d  reason: collision with root package name */
    bc f20599d;

    /* renamed from: e  reason: collision with root package name */
    Activity f20600e;

    /* renamed from: f  reason: collision with root package name */
    private a f20601f;

    /* renamed from: g  reason: collision with root package name */
    private final int f20602g;

    public g(Context context, int i) {
        super(context);
        this.f20602g = i;
        ((b) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f20599d.a(this.f20598c);
        this.f20598c.a(this);
        this.f20601f = new a(new d());
        d.a(this.f20596a, this.f20597b, this.f20601f);
        this.f20596a.setLayoutManager(new NPALinearLayoutManager(getContext()));
        ((s) this.f20596a.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f20596a.setAdapter(this.f20601f);
        this.f20598c.a(this.f20602g);
    }

    public void b() {
        this.f20598c.d();
    }

    public void a() {
        this.f20598c.c();
    }

    public void a(List<VMOfferHistory> list) {
        this.f20601f.a(list);
        this.f20601f.notifyItemRangeChanged(0, list.size());
    }

    public void e() {
        Intent intent = new Intent();
        intent.putExtra("type", 2);
        this.f20600e.setResult(-1, intent);
        this.f20600e.finish();
    }

    public void f() {
        this.f20600e.finish();
    }

    private static class a extends y<VMOfferHistory> {
        public a(com.shopee.app.ui.a.s<VMOfferHistory> sVar) {
            super(sVar);
        }
    }
}
