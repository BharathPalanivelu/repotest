package com.shopee.app.ui.common.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.a.a.f;
import com.garena.android.appkit.btmsheet.MaxHeightScrollView;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.uikit.fluid.tagcloud.GTagCloud;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.RegionConfig;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.chatP2P.VMOffer;
import com.shopee.app.h.r;
import com.shopee.app.ui.common.TierVariationView;
import com.shopee.app.ui.common.al;
import com.shopee.app.ui.dialog.g;
import com.shopee.app.ui.image.ImageBrowserActivity_;
import com.shopee.app.ui.image.MediaData;
import com.shopee.app.util.au;
import com.shopee.app.util.bc;
import com.shopee.app.util.s;
import com.shopee.app.util.u;
import com.shopee.app.util.x;
import com.shopee.app.util.z;
import com.shopee.app.web.protocol.AddCartMessage;
import com.shopee.app.web.protocol.Variant;
import com.shopee.id.R;
import com.squareup.a.ah;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c extends LinearLayout {
    /* access modifiers changed from: private */
    public static d A;
    /* access modifiers changed from: private */
    public static List<d> I = new ArrayList();
    /* access modifiers changed from: private */
    public AddCartMessage B = null;
    private b C;
    private C0314c D;
    private long E;
    private int F;
    private int G;
    private ItemDetail H = null;
    private com.garena.android.appkit.btmsheet.a J;

    /* renamed from: a  reason: collision with root package name */
    ImageView f21235a;

    /* renamed from: b  reason: collision with root package name */
    TextView f21236b;

    /* renamed from: c  reason: collision with root package name */
    TextView f21237c;

    /* renamed from: d  reason: collision with root package name */
    MaxHeightScrollView f21238d;

    /* renamed from: e  reason: collision with root package name */
    TextView f21239e;

    /* renamed from: f  reason: collision with root package name */
    TextView f21240f;

    /* renamed from: g  reason: collision with root package name */
    TierVariationView f21241g;
    GTagCloud h;
    g i;
    com.shopee.app.ui.dialog.c j;
    View k;
    View l;
    View m;
    View n;
    Button o;
    a p;
    bc q;
    UserInfo r;
    RegionConfig s;
    SettingConfigStore t;
    s u;
    com.shopee.app.tracking.trackingv3.b v;
    String w;
    int x;
    int y;
    int z;

    public interface a {
        void a(c cVar);
    }

    public interface b {
        void a(int i, long j, long j2);
    }

    public c(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        setOrientation(1);
        ((a) ((x) context).b()).a(this);
    }

    public void setDialog(com.garena.android.appkit.btmsheet.a aVar) {
        this.J = aVar;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (this.s.isFullBuild()) {
            this.z = 0;
        } else {
            this.z = 1;
        }
        this.q.a(this.p);
        this.p.a(this);
        this.h.setChildPadding(b.a.f7696g);
        this.h.setLineMargin(b.a.f7696g);
        this.D = new C0314c();
        this.h.setAdapter(this.D);
        this.h.a();
        this.f21238d.setMaxHeight(Math.min(b.a.f7696g * 20, (com.garena.android.appkit.tools.b.d() / 4) - 20));
        this.i.b();
        TextView textView = this.f21240f;
        textView.setPaintFlags(textView.getPaintFlags() | 8);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
        if (this.B.hasVariations()) {
            d dVar = A;
            if (dVar != null) {
                A = new d(dVar.f21249a, A.f21250b, this.j.getPrice(), this.i.getQuantity());
                return;
            }
        }
        A = new d(this.B.itemID, "", this.j.getPrice(), this.i.getQuantity());
    }

    public void a(long j2, int i2, int i3, b bVar) {
        this.E = j2;
        this.F = i2;
        this.G = i3;
        this.p.a(j2, i2);
        this.C = bVar;
    }

    public void a(AddCartMessage addCartMessage, b bVar) {
        this.B = addCartMessage;
        this.C = bVar;
        s();
        if (this.B.isStatusBannedOrDeleted()) {
            i();
            return;
        }
        z.b(getContext()).a(addCartMessage.itemImage).a((ah) new u()).a(this.f21235a);
        p();
        a(this.f21240f, !TextUtils.isEmpty(this.B.getSizeChartImage()));
    }

    /* access modifiers changed from: private */
    public void a(TextView textView, boolean z2) {
        if (z2) {
            textView.setVisibility(0);
            this.v.a("product", "size_chart_link");
            return;
        }
        textView.setVisibility(8);
    }

    private void setPrice(String str) {
        int i2;
        if (str.length() > 20) {
            i2 = this.x;
        } else {
            i2 = this.y;
        }
        f a2 = f.a(getContext());
        a2.a().a().b(com.garena.android.appkit.tools.b.a(R.color.primary)).a(i2).c().a((Object) str).b();
        a2.a(this.f21236b);
    }

    private void a(long j2, long j3) {
        if (j3 > 0) {
            f a2 = f.a(getContext(), this.w);
            a2.a().a().b().b(com.garena.android.appkit.tools.b.a(R.color.black26)).a(this.y).c().a((Object) au.b(j3)).b();
            a2.a().a().b(com.garena.android.appkit.tools.b.a(R.color.primary)).a(this.y).c().a((Object) au.b(j2)).b();
            a2.a(this.f21236b);
            return;
        }
        setPrice(au.b(j2));
    }

    private void i() {
        this.f21237c.setVisibility(4);
        setPrice(com.garena.android.appkit.tools.b.e(R.string.sp_item_banner_or_deleted));
        this.f21238d.setVisibility(8);
        this.k.setVisibility(8);
        this.i.setEditable(false);
        this.j.a(com.garena.android.appkit.tools.b.a(R.string.sp_price_origin, au.a(this.B.price, this.B.currency)), this.B.price);
        this.j.setEditable(false);
        this.o.setEnabled(false);
    }

    private void j() {
        if (this.t.isHideStock(this.B.shopID)) {
            this.f21237c.setVisibility(4);
        } else {
            this.f21237c.setVisibility(0);
            this.f21237c.setText(com.garena.android.appkit.tools.b.a(R.string.sp_stock_n, Integer.valueOf(this.B.getStock())));
        }
        this.f21238d.setVisibility(0);
        this.k.setVisibility(0);
        if (this.B.shopID == this.r.getShopId()) {
            this.i.setVisibility(8);
            this.j.setVisibility(8);
            this.n.setVisibility(8);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
        } else {
            this.i.setVisibility(0);
            this.j.setVisibility(0);
            this.n.setVisibility(0);
            this.k.setVisibility(0);
            this.l.setVisibility(0);
            this.m.setVisibility(0);
            this.i.a(this.B.getStock(), this.z);
            d dVar = A;
            long j2 = dVar == null ? this.B.price : dVar.f21251c;
            this.j.setPrice(j2);
            this.j.setCurrency(this.B.currency);
            this.j.a(com.garena.android.appkit.tools.b.a(R.string.sp_price_origin, au.a(j2, this.B.currency)), j2);
            setPrice(this.B.getPriceStr());
        }
        this.D.d();
    }

    private void k() {
        if (this.t.isHideStock(this.B.shopID)) {
            this.f21237c.setVisibility(4);
        } else {
            this.f21237c.setVisibility(0);
            this.f21237c.setText(com.garena.android.appkit.tools.b.a(R.string.sp_stock_n, Integer.valueOf(this.B.getStock())));
        }
        this.i.a(this.B.stock, this.z);
        this.i.setQuantity(1);
        this.j.setPrice(this.B.price);
        this.j.setCurrency(this.B.currency);
        this.j.a(com.garena.android.appkit.tools.b.a(R.string.sp_price_origin, au.a(this.B.price, this.B.currency)), this.B.price);
        this.f21238d.setVisibility(8);
        this.k.setVisibility(8);
        a(this.B.price, this.B.priceBeforeDiscount);
        l();
    }

    private void l() {
        d dVar = A;
        if (dVar != null && dVar.f21249a == this.B.itemID) {
            int i2 = 1;
            this.j.a(com.garena.android.appkit.tools.b.a(R.string.sp_price_origin, au.a(this.B.price, this.B.currency)), A.f21251c);
            g gVar = this.i;
            if (A.f21252d > 0) {
                i2 = A.f21252d;
            }
            gVar.setQuantity(i2);
        }
    }

    /* access modifiers changed from: private */
    public void m() {
        this.i.a(this.B.getStock(), this.z);
        if (this.t.isHideStock(this.B.shopID)) {
            this.f21237c.setVisibility(4);
        } else {
            this.f21237c.setVisibility(0);
            this.f21237c.setText(com.garena.android.appkit.tools.b.a(R.string.sp_stock_n, Integer.valueOf(this.B.getStock())));
        }
        setPrice(this.B.getPriceStr());
        this.i.setEditable(false);
        d dVar = A;
        long j2 = dVar == null ? this.B.price : dVar.f21251c;
        this.j.setEditable(false);
        this.j.setPrice(j2);
        this.j.setCurrency(this.B.currency);
        this.j.a(com.garena.android.appkit.tools.b.a(R.string.sp_price_origin, au.a(j2, this.B.currency)), j2);
        setPrice(this.B.getPriceStr());
    }

    /* access modifiers changed from: private */
    public void setDataForSelectedVariation(Variant variant) {
        d dVar;
        Iterator<d> it = I.iterator();
        while (true) {
            if (!it.hasNext()) {
                dVar = null;
                break;
            }
            dVar = it.next();
            if (dVar.f21249a == variant.modelID) {
                A = dVar;
                break;
            }
        }
        if (this.t.isHideStock(this.B.shopID)) {
            this.f21237c.setVisibility(4);
        } else {
            this.f21237c.setVisibility(0);
            this.f21237c.setText(com.garena.android.appkit.tools.b.a(R.string.sp_stock_n, Integer.valueOf(variant.modelStock)));
        }
        this.i.a(variant.modelStock, this.z);
        this.i.setQuantity(dVar == null ? 1 : dVar.f21252d);
        this.j.setPrice(dVar == null ? variant.modelPrice : dVar.f21251c);
        this.j.setCurrency(this.B.currency);
        this.j.a(com.garena.android.appkit.tools.b.a(R.string.sp_price_origin, au.a(variant.modelPrice, this.B.currency)), dVar == null ? variant.modelPrice : dVar.f21251c);
        a(dVar == null ? variant.modelPrice : dVar.f21251c, variant.modelPriceBeforeDiscount);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        com.garena.android.appkit.btmsheet.a aVar = this.J;
        if (aVar != null) {
            aVar.dismiss();
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        com.garena.android.appkit.btmsheet.a aVar = this.J;
        if (aVar != null) {
            aVar.dismiss();
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (this.B == null) {
            a(com.garena.android.appkit.tools.b.e(R.string.sp_item_detail_not_ready));
            return;
        }
        int quantity = this.i.getQuantity();
        if (quantity == -1) {
            b(com.garena.android.appkit.tools.b.e(R.string.sp_invalid_offer_qty));
        } else if (quantity == -2) {
            b(com.garena.android.appkit.tools.b.e(R.string.sp_quantity_not_0));
        } else if (quantity == -3) {
            b(com.garena.android.appkit.tools.b.e(R.string.sp_quantity_exceed_stock));
        } else {
            long price = this.j.getPrice();
            if (price <= 0) {
                b(com.garena.android.appkit.tools.b.e(R.string.sp_error_invalid_price));
            } else if (this.C == null) {
            } else {
                if (this.B.hasVariations()) {
                    Variant b2 = (!this.u.a("tier_variations") || !this.B.hasTwoTierVariations()) ? this.D.b() : this.f21241g.getSelectedVariant();
                    if (b2 == null) {
                        n();
                        r.a().b((int) R.string.sp_no_variation_selected_err);
                        return;
                    }
                    long j2 = b2.modelID;
                    this.C.a(quantity, price, j2);
                    ItemDetail itemDetail = this.H;
                    if (itemDetail != null) {
                        this.p.a(itemDetail, quantity, price, j2, this.G);
                        return;
                    }
                    return;
                }
                this.C.a(quantity, price, -1);
                ItemDetail itemDetail2 = this.H;
                if (itemDetail2 != null) {
                    this.p.a(itemDetail2, quantity, price, -1, this.G);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        if (!TextUtils.isEmpty(this.B.getSizeChartImage())) {
            MediaData newImageData = MediaData.newImageData(this.B.getSizeChartImage());
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(newImageData);
            ImageBrowserActivity_.a(getContext()).a((ArrayList<MediaData>) arrayList).a(true).a();
            this.v.a("size_chart_link", "", com.shopee.app.tracking.trackingv3.b.f19172a, "product");
        }
    }

    /* access modifiers changed from: private */
    public void n() {
        this.f21238d.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.no_variation_highlight));
        this.D.c();
    }

    /* access modifiers changed from: private */
    public void o() {
        this.f21238d.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.white));
    }

    private void b(String str) {
        r.a().a(str);
    }

    public void setLastOffer(VMOffer vMOffer) {
        AddCartMessage addCartMessage = this.B;
        if (addCartMessage != null && !addCartMessage.isStatusBannedOrDeleted()) {
            if (this.B.hasTwoTierVariations() && this.u.a("tier_variations")) {
                Iterator<Variant> it = this.B.variations.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Variant next = it.next();
                    if (next.modelID == vMOffer.getModelid()) {
                        this.f21241g.a(this.B, vMOffer, next, new al() {
                            public void a(TextView textView, boolean z) {
                                c.this.a(textView, z);
                            }

                            public void a() {
                                c.this.e();
                            }
                        });
                        if (this.t.isHideStock(this.B.shopID)) {
                            this.f21237c.setVisibility(4);
                        } else {
                            this.f21237c.setVisibility(0);
                            this.f21237c.setText(com.garena.android.appkit.tools.b.a(R.string.sp_stock_n, Integer.valueOf(next.modelStock)));
                        }
                    }
                }
            } else if (this.B.hasVariations()) {
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= this.B.variations.size()) {
                        break;
                    } else if (this.B.variations.get(i3).modelID == vMOffer.getModelid()) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i2 >= 0) {
                    ((com.shopee.app.ui.common.a.f) this.D.f21248b.get(i2)).performClick();
                }
            }
            this.i.setQuantity(vMOffer.getBuyCount());
            this.j.setPrice(vMOffer.getOfferPrice());
            this.j.setCurrency(this.B.currency);
            this.j.a(com.garena.android.appkit.tools.b.a(R.string.sp_price_origin, au.a(this.B.price, this.B.currency)), vMOffer.getOfferPrice());
        }
    }

    public View getScrollingView() {
        if (this.f21241g.getVisibility() == 0) {
            return this.f21241g;
        }
        return this.f21238d;
    }

    public void a(ItemDetail itemDetail) {
        if (itemDetail != null && itemDetail.getId() == this.E) {
            this.H = itemDetail;
            if (this.H.isOutStock()) {
                a(com.garena.android.appkit.tools.b.e(R.string.sp_item_out_of_stock_buy_tip));
                f();
                return;
            }
            AddCartMessage from = AddCartMessage.from(itemDetail, this.G);
            this.B = from;
            s();
            this.D.e();
            this.h.a();
            if (this.B.isStatusBannedOrDeleted()) {
                i();
            } else {
                z.b(getContext()).a(from.itemImage).a((ah) new u()).a(this.f21235a);
                p();
            }
            com.garena.android.appkit.btmsheet.a aVar = this.J;
            if (aVar != null && !aVar.isShowing()) {
                this.J.show();
            }
        }
    }

    private void p() {
        if (this.B.hasTwoTierVariations() && this.u.a("tier_variations")) {
            this.f21238d.setVisibility(8);
            this.f21241g.setVisibility(0);
            this.f21241g.a(this.B, (al) new al() {
                public void a(TextView textView, boolean z) {
                    c.this.a(textView, z);
                }

                public void a() {
                    c.this.e();
                }
            });
            this.f21241g.setOnVariantSelectedCallback(new com.shopee.app.ui.common.u() {
                public void a() {
                    c.this.m();
                }

                public void a(Variant variant) {
                    c.this.setDataForSelectedVariation(variant);
                    c.this.o();
                    c.this.q();
                }
            });
            m();
            this.D.e();
        } else if (this.B.hasVariations()) {
            this.f21238d.setVisibility(0);
            this.f21241g.setVisibility(8);
            this.D.e();
            this.h.a();
            j();
        } else {
            k();
        }
    }

    public void f() {
        this.q.b(this.p);
        this.p.d();
        this.p.b();
        com.garena.android.appkit.btmsheet.a aVar = this.J;
        if (aVar != null && !aVar.isShowing()) {
            this.J.dismiss();
            this.J = null;
        }
    }

    /* access modifiers changed from: private */
    public void q() {
        this.i.setEditable(true);
        AnonymousClass4 r0 = new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        };
        this.i.setOnTouchListener(r0);
        this.j.setEditable(true);
        this.j.setOnTouchListener(r0);
    }

    /* access modifiers changed from: private */
    public void r() {
        this.i.setEditable(false);
        AnonymousClass5 r0 = new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return true;
                }
                c.this.n();
                return true;
            }
        };
        this.i.setOnTouchListener(r0);
        this.j.setEditable(false);
        this.j.setOnTouchListener(r0);
    }

    private void s() {
        if (this.t.isHideStock(this.B.shopID)) {
            this.z = 1;
        } else {
            this.z = 0;
        }
    }

    /* renamed from: com.shopee.app.ui.common.b.c$c  reason: collision with other inner class name */
    private class C0314c implements View.OnClickListener, GTagCloud.a {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public List<com.shopee.app.ui.common.a.f> f21248b;

        private C0314c() {
            this.f21248b = new ArrayList();
        }

        public int a() {
            if (c.this.B == null || c.this.B.variations == null) {
                return 0;
            }
            return c.this.B.variations.size();
        }

        /* access modifiers changed from: private */
        public void e() {
            boolean z = true;
            if (c.I.size() == c.this.B.variations.size()) {
                int size = c.this.B.variations.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        z = false;
                        break;
                    } else if (((d) c.I.get(i)).f21249a != c.this.B.variations.get(i).modelID) {
                        c.I.clear();
                        break;
                    } else {
                        i++;
                    }
                }
            } else {
                c.I.clear();
            }
            if (z) {
                for (Variant next : c.this.B.variations) {
                    d dVar = new d(next);
                    if (c.A != null && c.A.f21249a == next.modelID) {
                        dVar.f21251c = c.A.f21251c;
                        dVar.f21252d = c.A.f21252d;
                    }
                    c.I.add(dVar);
                }
            }
        }

        public View a(Context context, int i) {
            com.shopee.app.ui.common.a.f fVar;
            if (this.f21248b.size() > i) {
                fVar = this.f21248b.get(i);
            } else {
                fVar = com.shopee.app.ui.common.a.g.a(context);
                fVar.setData(c.this.B.variations.get(i));
                this.f21248b.add(i, fVar);
            }
            fVar.setOnClickListener(this);
            return fVar;
        }

        public void onClick(View view) {
            com.shopee.app.ui.common.a.f fVar = (com.shopee.app.ui.common.a.f) view;
            if (fVar.d()) {
                Iterator<com.shopee.app.ui.common.a.f> it = this.f21248b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.shopee.app.ui.common.a.f next = it.next();
                    if (next.c()) {
                        Iterator it2 = c.I.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            d dVar = (d) it2.next();
                            if (dVar.f21249a == next.getData().modelID) {
                                dVar.f21252d = c.this.i.getQuantity();
                                dVar.f21251c = c.this.j.getPrice();
                                break;
                            }
                        }
                    }
                }
                for (com.shopee.app.ui.common.a.f next2 : this.f21248b) {
                    if (next2.equals(fVar)) {
                        next2.setActive(true);
                    } else if (next2.d()) {
                        next2.setActive(false);
                    }
                }
                c.this.setDataForSelectedVariation(fVar.getData());
                g();
            }
        }

        public Variant b() {
            for (com.shopee.app.ui.common.a.f next : this.f21248b) {
                if (next.c()) {
                    return next.getData();
                }
            }
            return null;
        }

        private void f() {
            c.this.i.setEditable(false);
            c.this.i.a(c.this.B.getStock(), c.this.z);
            c.this.j.setPrice(c.this.B.price);
            c.this.j.setCurrency(c.this.B.currency);
            c.this.j.a(com.garena.android.appkit.tools.b.a(R.string.sp_price_origin, au.a(c.this.B.price, c.this.B.currency)), c.this.B.price);
            c.this.r();
        }

        private void g() {
            c.this.o();
            c.this.q();
        }

        public void c() {
            for (com.shopee.app.ui.common.a.f b2 : this.f21248b) {
                b2.b();
            }
        }

        public void d() {
            boolean z;
            int i = 0;
            if (c.A != null) {
                Iterator<com.shopee.app.ui.common.a.f> it = this.f21248b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    com.shopee.app.ui.common.a.f next = it.next();
                    if (next.getData().modelID == c.A.f21249a && next.d()) {
                        c.this.i.setQuantity(c.A.f21252d);
                        next.performClick();
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    d unused = c.A = null;
                } else {
                    return;
                }
            }
            if (this.f21248b.size() > 1) {
                for (com.shopee.app.ui.common.a.f data : this.f21248b) {
                    if (data.getData().modelStock > 0) {
                        i++;
                    }
                }
                if (i != 1) {
                    f();
                    return;
                }
            }
            for (com.shopee.app.ui.common.a.f next2 : this.f21248b) {
                if (next2.d()) {
                    next2.performClick();
                    return;
                }
            }
        }
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        public long f21249a;

        /* renamed from: b  reason: collision with root package name */
        public String f21250b;

        /* renamed from: c  reason: collision with root package name */
        public long f21251c;

        /* renamed from: d  reason: collision with root package name */
        public int f21252d;

        public d(Variant variant) {
            this.f21249a = variant.modelID;
            this.f21250b = variant.modelName;
            this.f21251c = variant.modelPrice;
            this.f21252d = 1;
        }

        public d(long j, String str, long j2, int i) {
            this.f21249a = j;
            this.f21250b = str;
            this.f21251c = j2;
            this.f21252d = i;
        }
    }

    public void a(String str) {
        r.a().a(str);
    }
}
