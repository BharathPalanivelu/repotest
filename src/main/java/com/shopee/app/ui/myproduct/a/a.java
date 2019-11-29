package com.shopee.app.ui.myproduct.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.h.o;
import com.shopee.app.network.d.az;
import com.shopee.app.network.d.bj;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.myproduct.c;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class a extends RelativeLayout implements n<ItemDetail> {

    /* renamed from: a  reason: collision with root package name */
    ImageView f23380a;

    /* renamed from: b  reason: collision with root package name */
    TextView f23381b;

    /* renamed from: c  reason: collision with root package name */
    TextView f23382c;

    /* renamed from: d  reason: collision with root package name */
    TextView f23383d;

    /* renamed from: e  reason: collision with root package name */
    TextView f23384e;

    /* renamed from: f  reason: collision with root package name */
    TextView f23385f;

    /* renamed from: g  reason: collision with root package name */
    TextView f23386g;
    TextView h;
    TextView i;
    ImageView j;
    View k;
    View l;
    TextView m;
    String n;
    String o;
    String p;
    int q;
    int r;
    bi s;
    com.shopee.app.tracking.a t;
    ItemDetail u;
    private final int v;

    /* access modifiers changed from: protected */
    public String a(String str) {
        return str;
    }

    public a(Context context, int i2) {
        super(context);
        this.v = i2;
        ((c) ((x) context).b()).a(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.shopee.app.data.viewmodel.ItemDetail r9) {
        /*
            r8 = this;
            r8.u = r9
            android.widget.TextView r0 = r8.f23381b
            java.lang.String r1 = r9.getItemName()
            r0.setText(r1)
            android.widget.TextView r0 = r8.f23382c
            java.lang.String r1 = r9.getVariationNoOOSPriceString()
            r0.setText(r1)
            android.widget.TextView r0 = r8.i
            r1 = 0
            r0.setVisibility(r1)
            android.widget.ImageView r0 = r8.j
            r0.setVisibility(r1)
            android.view.View r0 = r8.k
            r0.setVisibility(r1)
            int r0 = r9.getStatus()
            r2 = 2131231641(0x7f080399, float:1.8079369E38)
            r3 = 4
            r4 = 2
            r5 = 8
            if (r0 == 0) goto L_0x009c
            r6 = 2131231480(0x7f0802f8, float:1.8079042E38)
            if (r0 == r4) goto L_0x008e
            r7 = 3
            if (r0 == r7) goto L_0x0080
            if (r0 == r3) goto L_0x009c
            r6 = 5
            if (r0 == r6) goto L_0x009c
            android.widget.ImageView r0 = r8.j
            r0.setVisibility(r5)
            boolean r0 = r9.isDeListBySystem()
            if (r0 == 0) goto L_0x0057
            android.widget.TextView r0 = r8.i
            r6 = 2131887367(0x7f120507, float:1.940934E38)
            r0.setText(r6)
            android.widget.ImageView r0 = r8.j
            r0.setImageResource(r2)
            goto L_0x00a9
        L_0x0057:
            boolean r0 = r9.isInvalidCategory()
            if (r0 == 0) goto L_0x0066
            android.widget.TextView r0 = r8.i
            r2 = 2131887366(0x7f120506, float:1.9409337E38)
            r0.setText(r2)
            goto L_0x00a9
        L_0x0066:
            int r0 = r9.getAttributeStatus()
            if (r0 != 0) goto L_0x0075
            android.widget.TextView r0 = r8.i
            r2 = 2131887365(0x7f120505, float:1.9409335E38)
            r0.setText(r2)
            goto L_0x00a9
        L_0x0075:
            android.widget.TextView r0 = r8.i
            r0.setVisibility(r5)
            android.view.View r0 = r8.k
            r0.setVisibility(r5)
            goto L_0x00a9
        L_0x0080:
            android.widget.TextView r0 = r8.i
            r2 = 2131888865(0x7f120ae1, float:1.9412377E38)
            r0.setText(r2)
            android.widget.ImageView r0 = r8.j
            r0.setImageResource(r6)
            goto L_0x00a9
        L_0x008e:
            android.widget.TextView r0 = r8.i
            r2 = 2131888883(0x7f120af3, float:1.9412414E38)
            r0.setText(r2)
            android.widget.ImageView r0 = r8.j
            r0.setImageResource(r6)
            goto L_0x00a9
        L_0x009c:
            android.widget.TextView r0 = r8.i
            r6 = 2131888868(0x7f120ae4, float:1.9412383E38)
            r0.setText(r6)
            android.widget.ImageView r0 = r8.j
            r0.setImageResource(r2)
        L_0x00a9:
            android.widget.TextView r0 = r8.m
            r0.setVisibility(r5)
            android.view.View r0 = r8.l
            r0.setVisibility(r5)
            int r0 = r8.v
            if (r0 != r3) goto L_0x0112
            java.util.List r0 = r9.getModelDetails()
            if (r0 == 0) goto L_0x0112
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.util.List r2 = r9.getModelDetails()
            java.util.Iterator r2 = r2.iterator()
        L_0x00ca:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00e9
            java.lang.Object r3 = r2.next()
            com.shopee.app.data.viewmodel.ModelDetail r3 = (com.shopee.app.data.viewmodel.ModelDetail) r3
            int r5 = r3.getStock()
            if (r5 > 0) goto L_0x00ca
            java.lang.String r3 = r3.getName()
            r0.append(r3)
            java.lang.String r3 = ", "
            r0.append(r3)
            goto L_0x00ca
        L_0x00e9:
            int r2 = r0.length()
            if (r2 <= 0) goto L_0x0112
            int r2 = r0.length()
            int r2 = r2 - r4
            r0.deleteCharAt(r2)
            android.widget.TextView r2 = r8.m
            r2.setVisibility(r1)
            android.view.View r2 = r8.l
            r2.setVisibility(r1)
            android.widget.TextView r2 = r8.m
            r3 = 2131889266(0x7f120c72, float:1.941319E38)
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r1] = r0
            java.lang.String r0 = com.garena.android.appkit.tools.b.a(r3, r4)
            r2.setText(r0)
        L_0x0112:
            r8.d()
            android.content.Context r0 = r8.getContext()
            com.shopee.app.util.z$d r0 = com.shopee.app.util.z.b((android.content.Context) r0)
            java.lang.String r1 = r9.getImages()
            com.shopee.app.util.z$d r0 = r0.a((java.lang.String) r1)
            android.widget.ImageView r1 = r8.f23380a
            r0.a((android.widget.ImageView) r1)
            r8.b(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.myproduct.a.a.a(com.shopee.app.data.viewmodel.ItemDetail):void");
    }

    private void b(ItemDetail itemDetail) {
        this.f23384e.setVisibility(0);
        this.f23385f.setVisibility(0);
        this.f23386g.setVisibility(0);
        this.f23384e.setText(String.format(this.n, new Object[]{Integer.valueOf(itemDetail.getStock())}));
        this.f23385f.setText(a(itemDetail.getSold()));
        this.f23386g.setText(a(itemDetail.getLikedString()));
    }

    /* access modifiers changed from: protected */
    public String a(int i2) {
        return String.format(this.o, new Object[]{Integer.valueOf(i2)});
    }

    private void d() {
        int status = this.u.getStatus();
        if (status != 0) {
            if (status == 2 || status == 3) {
                f();
                return;
            } else if (!(status == 4 || status == 5)) {
                if (this.u.hasInvalidAttribute() || this.u.isInvalidCategory()) {
                    f();
                    return;
                } else {
                    e();
                    return;
                }
            }
        }
        a();
    }

    private void e() {
        this.h.setVisibility(8);
        this.f23383d.setVisibility(0);
    }

    private void f() {
        this.h.setText(b.e(R.string.sp_label_update));
        this.h.setVisibility(0);
        this.f23383d.setVisibility(8);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.h.setText(b.e(R.string.sp_click_to_dismiss));
        this.h.setVisibility(0);
        this.f23383d.setVisibility(8);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.s.a("PRODUCT_VIEW", new com.garena.android.appkit.b.a(this.u));
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.u.isInvalidCategory()) {
            this.t.a((long) this.u.getShopId(), this.u.getId());
        }
        int status = this.u.getStatus();
        if (status != 0) {
            if (status == 2 || status == 3) {
                g();
                return;
            } else if (!(status == 4 || status == 5)) {
                g();
                return;
            }
        }
        bj bjVar = new bj();
        o.a().a((az) bjVar);
        bjVar.a(this.u.getShopId(), this.u.getId());
    }

    private void g() {
        this.s.a("PRODUCT_DROPDOWN_ACTION", (com.garena.android.appkit.b.a) new C0368a(0, this.u));
    }

    /* access modifiers changed from: package-private */
    public void a(View view) {
        this.s.a("PRODUCT_DROPDOWN_ACTION", (com.garena.android.appkit.b.a) new C0368a(0, this.u));
    }

    /* renamed from: com.shopee.app.ui.myproduct.a.a$a  reason: collision with other inner class name */
    public static class C0368a extends com.garena.android.appkit.b.a {

        /* renamed from: a  reason: collision with root package name */
        public int f23387a;

        /* renamed from: b  reason: collision with root package name */
        public ItemDetail f23388b;

        public C0368a(int i, ItemDetail itemDetail) {
            this.f23387a = i;
            this.f23388b = itemDetail;
        }
    }
}
