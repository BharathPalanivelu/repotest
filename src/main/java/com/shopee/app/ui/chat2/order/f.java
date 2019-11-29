package com.shopee.app.ui.chat2.order;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.ui.a.i;
import com.shopee.app.ui.a.m;
import com.shopee.app.ui.common.p;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.ui.order.b.a.c;
import com.shopee.app.ui.order.b.a.d;
import com.shopee.app.ui.order.b.a.g;
import com.shopee.app.util.ae;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class f extends com.garena.android.uikit.a.a.a {
    private static CharSequence[] i = new CharSequence[2];

    /* renamed from: a  reason: collision with root package name */
    ListView f20668a;

    /* renamed from: b  reason: collision with root package name */
    b f20669b;

    /* renamed from: c  reason: collision with root package name */
    bc f20670c;

    /* renamed from: d  reason: collision with root package name */
    Activity f20671d;

    /* renamed from: e  reason: collision with root package name */
    ak f20672e;

    /* renamed from: f  reason: collision with root package name */
    private a f20673f;

    /* renamed from: g  reason: collision with root package name */
    private final int f20674g;
    private final int h;
    private p j;

    public void g() {
    }

    static {
        i[0] = b.e(R.string.sp_view_order);
        i[1] = b.e(R.string.sp_send_link2);
    }

    public f(Context context, int i2, int i3) {
        super(context);
        this.f20674g = i3;
        this.h = i2;
        ((com.shopee.app.ui.chat.b) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f20670c.a(this.f20669b);
        this.f20669b.a(this);
        this.f20673f = new a();
        this.f20673f.a(new ae(this.f20668a));
        this.j = new p(this.f20668a);
        this.j.a((p.a) this.f20669b);
        this.f20668a.setAdapter(this.f20673f);
        this.f20668a.setEmptyView(findViewById(R.id.emptyView));
        this.f20669b.a(this.h, this.f20674g);
    }

    public void a(List<OrderDetail> list) {
        this.f20673f.a(list);
        this.f20673f.notifyDataSetChanged();
    }

    public void e() {
        this.j.c();
    }

    public void f() {
        this.j.b();
    }

    /* access modifiers changed from: package-private */
    public void a(m mVar) {
        final Object a2 = mVar.a();
        if (a2 != null && (a2 instanceof OrderDetail)) {
            final OrderDetail orderDetail = (OrderDetail) a2;
            com.shopee.app.ui.dialog.a.a(getContext(), i, (a.c) new a.c() {
                public void a(com.afollestad.materialdialogs.f fVar, View view, int i, CharSequence charSequence) {
                    if (i == 0) {
                        f.this.f20672e.a(orderDetail.getOrderId(), orderDetail.getShopId());
                    } else if (i == 1) {
                        com.shopee.app.ui.chat.a.f20002b = (OrderDetail) a2;
                        f.this.f20671d.setResult(-1);
                        f.this.f20671d.finish();
                    }
                    fVar.dismiss();
                }
            });
        }
    }

    private static class a extends i<OrderDetail> {

        /* renamed from: c  reason: collision with root package name */
        private ae f20678c;

        /* access modifiers changed from: protected */
        public int a() {
            return 8;
        }

        private a() {
        }

        public void a(ae aeVar) {
            this.f20678c = aeVar;
        }

        /* access modifiers changed from: protected */
        public List<m> b(List<OrderDetail> list) {
            ArrayList arrayList = new ArrayList();
            for (OrderDetail next : list) {
                com.shopee.app.d.b.a.a a2 = com.shopee.app.d.b.a.d.i.a(next);
                arrayList.add(new com.shopee.app.ui.order.b.a.a());
                c cVar = new c();
                cVar.b(next);
                cVar.a(new c.a(next, a2));
                arrayList.add(cVar);
                d dVar = new d();
                dVar.a(new d.a(next));
                dVar.b(next);
                arrayList.add(dVar);
                g gVar = new g();
                gVar.b(next);
                gVar.d();
                gVar.a(new g.b(next, 0));
                arrayList.add(gVar);
                if (a2.c()) {
                    com.shopee.app.ui.order.b.a.b bVar = new com.shopee.app.ui.order.b.a.b();
                    bVar.b(next);
                    bVar.a(false);
                    bVar.a(a2);
                    arrayList.add(bVar);
                }
                if (next.isSelling()) {
                    if (!a2.c()) {
                        a2.a(true);
                    }
                    com.shopee.app.ui.order.m mVar = new com.shopee.app.ui.order.m();
                    mVar.b(next);
                    mVar.a(a2);
                    arrayList.add(mVar);
                }
            }
            return arrayList;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2 = super.getView(i, view, viewGroup);
            view2.setOnTouchListener(this.f20678c);
            view2.setTag("TOUCH_" + i);
            return view2;
        }
    }
}
