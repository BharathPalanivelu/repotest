package com.shopee.app.ui.myproduct.a;

import android.content.Context;
import android.widget.ListView;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.ui.a.g;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.a.o;
import com.shopee.app.ui.a.z;
import com.shopee.app.ui.common.p;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.myproduct.a.a;
import com.shopee.app.ui.myproduct.c;
import com.shopee.app.upload.UploadManager;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.List;

public class h extends g implements o {

    /* renamed from: a  reason: collision with root package name */
    ListView f23417a;

    /* renamed from: b  reason: collision with root package name */
    f f23418b;

    /* renamed from: c  reason: collision with root package name */
    r f23419c;

    /* renamed from: d  reason: collision with root package name */
    bi f23420d;

    /* renamed from: e  reason: collision with root package name */
    ak f23421e;

    /* renamed from: f  reason: collision with root package name */
    bc f23422f;

    /* renamed from: g  reason: collision with root package name */
    UploadManager f23423g;
    SettingConfigStore h;
    private p i;
    /* access modifiers changed from: private */
    public int j;
    /* access modifiers changed from: private */
    public boolean k = false;
    private a l;
    private e m = new com.garena.android.appkit.b.g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ItemDetail itemDetail = (ItemDetail) aVar.data;
            h.this.f23421e.b(itemDetail.getShopId(), itemDetail.getId());
        }
    };
    private e n = new com.garena.android.appkit.b.g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            a.C0368a aVar2 = (a.C0368a) aVar;
            int i = aVar2.f23387a;
            if (i != 0) {
                if (i != 1) {
                    if (i == 3) {
                        boolean unused = h.this.k = false;
                        h.this.f23418b.a(h.this.j, 0, h.this.k);
                    } else if (i == 4) {
                        boolean unused2 = h.this.k = true;
                        h.this.f23418b.a(h.this.j, 0, h.this.k);
                    } else if (i == 5) {
                        if (h.this.f23418b.e()) {
                            h.this.a(b.e(R.string.sp_vacation_add_edit_error));
                        } else {
                            h.this.f23418b.a(aVar2.f23388b);
                        }
                    }
                } else if (h.this.f23418b.e()) {
                    h.this.a(b.e(R.string.sp_vacation_add_edit_error));
                } else {
                    h.this.f23418b.a(aVar2.f23388b.getId());
                }
            } else if (h.this.f23418b.e()) {
                h.this.a(b.e(R.string.sp_vacation_add_edit_error));
            } else {
                h.this.f23421e.a(aVar2.f23388b.getId(), h.this.f23423g);
            }
        }
    };

    public h(Context context, int i2) {
        super(context);
        ((c) ((x) context).b()).a(this);
        this.j = i2;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.f23422f.a(this.f23418b);
        this.f23418b.a(this);
        this.l = new a(this.j);
        this.f23417a.setAdapter(this.l);
        this.i = new p(this.f23417a);
        this.i.a((p.a) this.f23418b);
        this.f23418b.a(this.j, 0, this.k);
    }

    public void a() {
        super.a();
        this.f23420d.a("PRODUCT_DROPDOWN_ACTION", this.n);
        this.f23420d.a("PRODUCT_VIEW", this.m);
    }

    public void b() {
        super.b();
        this.f23420d.b("PRODUCT_DROPDOWN_ACTION", this.n);
        this.f23420d.b("PRODUCT_VIEW", this.m);
    }

    public void x_() {
        this.f23419c.a();
    }

    public void d() {
        this.f23419c.b();
    }

    public void a(List<ItemDetail> list) {
        this.l.a(list);
        this.l.notifyDataSetChanged();
        this.f23417a.setEmptyView(findViewById(R.id.emptyView));
    }

    public void a(String str) {
        if (y_()) {
            com.shopee.app.h.r.a().a(str);
        }
    }

    public void f() {
        this.i.c();
    }

    public void g() {
        this.i.b();
    }

    public void h() {
        this.f23417a.setSelectionAfterHeaderView();
    }

    public static class a extends z<ItemDetail> {

        /* renamed from: b  reason: collision with root package name */
        private int f23426b;

        a(int i) {
            this.f23426b = i;
        }

        /* access modifiers changed from: protected */
        public n<ItemDetail> a(Context context, int i) {
            return c.a(context, this.f23426b);
        }
    }
}
