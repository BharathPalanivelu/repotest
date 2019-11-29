package com.shopee.app.ui.common.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.garena.android.appkit.btmsheet.MaxHeightScrollView;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.uikit.fluid.tagcloud.GTagCloud;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.RegionConfig;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.h.r;
import com.shopee.app.tracking.f;
import com.shopee.app.ui.common.TierVariationView;
import com.shopee.app.ui.common.al;
import com.shopee.app.ui.common.m;
import com.shopee.app.ui.dialog.g;
import com.shopee.app.ui.home.i;
import com.shopee.app.ui.image.ImageBrowserActivity_;
import com.shopee.app.ui.image.MediaData;
import com.shopee.app.util.af;
import com.shopee.app.util.ak;
import com.shopee.app.util.au;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
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
    public static e F;
    /* access modifiers changed from: private */
    public static List<e> I = new ArrayList();
    Activity A;
    String B;
    int C;
    int D;
    private final int E;
    /* access modifiers changed from: private */
    public AddCartMessage G = null;
    private d H = new d();
    private long J;
    private int K;
    private ItemDetail L = null;
    private String M;
    private com.garena.android.appkit.btmsheet.a N;
    /* access modifiers changed from: private */
    public com.shopee.app.util.o.a O = new com.shopee.app.util.o.a();

    /* renamed from: a  reason: collision with root package name */
    m f21070a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f21071b;

    /* renamed from: c  reason: collision with root package name */
    TextView f21072c;

    /* renamed from: d  reason: collision with root package name */
    TextView f21073d;

    /* renamed from: e  reason: collision with root package name */
    MaxHeightScrollView f21074e;

    /* renamed from: f  reason: collision with root package name */
    TextView f21075f;

    /* renamed from: g  reason: collision with root package name */
    TextView f21076g;
    TierVariationView h;
    GTagCloud i;
    View j;
    g k;
    View l;
    Button m;
    View n;
    TextView o;
    a p;
    bc q;
    UserInfo r;
    f s;
    com.shopee.app.tracking.trackingv3.b t;
    RegionConfig u;
    SettingConfigStore v;
    s w;
    ak x;
    com.shopee.app.d.c.b y;
    bi z;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f21081a;

        /* renamed from: b  reason: collision with root package name */
        public String f21082b;

        /* renamed from: c  reason: collision with root package name */
        public String f21083c;

        /* renamed from: d  reason: collision with root package name */
        public int f21084d;

        /* renamed from: e  reason: collision with root package name */
        public int f21085e;

        /* renamed from: f  reason: collision with root package name */
        public long f21086f;

        /* renamed from: g  reason: collision with root package name */
        public AddCartMessage f21087g;
    }

    /* renamed from: com.shopee.app.ui.common.a.c$c  reason: collision with other inner class name */
    public interface C0313c {
        void a(c cVar);
    }

    public c(Context context, int i2) {
        super(context);
        this.E = i2;
        a(context);
    }

    private void a(Context context) {
        setOrientation(1);
        ((C0313c) ((x) context).b()).a(this);
        if (this.u.isFullBuild()) {
            this.D = 0;
        } else {
            this.D = 1;
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.q.a(this.p);
        this.p.a(this);
        this.i.setChildPadding(b.a.f7696g);
        this.i.setLineMargin(b.a.f7696g);
        this.i.setAdapter(this.H);
        this.f21074e.setMaxHeight(b.a.f7696g * 20);
        this.k.setOnQuantityChanged(this.p);
        TextView textView = this.o;
        textView.setText("[" + com.garena.android.appkit.tools.b.e(R.string.wholesale) + "]");
        TextView textView2 = this.f21076g;
        textView2.setPaintFlags(textView2.getPaintFlags() | 8);
    }

    private void j() {
        this.k.setEditable(true);
        this.k.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
    }

    /* access modifiers changed from: private */
    public void k() {
        this.k.setEditable(false);
        this.k.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return true;
                }
                c.this.l();
                return true;
            }
        });
    }

    /* access modifiers changed from: private */
    public void l() {
        this.f21074e.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.no_variation_highlight));
        this.H.c();
    }

    private void m() {
        this.f21074e.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.white));
    }

    public void setData(AddCartMessage addCartMessage) {
        this.G = addCartMessage;
        this.O = new com.shopee.app.util.o.a(this.G.isOfficialShop());
        n();
        v();
        a(addCartMessage);
        if (this.G.isAddOnly()) {
            this.m.setText(com.garena.android.appkit.tools.b.e(R.string.sp_label_add_to_cart));
        }
        if (!TextUtils.isEmpty(this.G.getButtonText())) {
            this.m.setText(this.G.getButtonText());
        }
    }

    private void n() {
        int a2 = this.O.a();
        this.f21070a.setColor(a2);
        this.f21072c.setTextColor(a2);
        this.m.setBackgroundResource(this.O.b());
        this.k.setQuantityEditTextColor(a2);
        this.k.setThemeColor(a2);
    }

    public void a(ItemDetail itemDetail) {
        if (itemDetail != null && itemDetail.getId() == this.J) {
            this.L = itemDetail;
            if (this.L.isOutStock()) {
                a(com.garena.android.appkit.tools.b.e(R.string.sp_item_out_of_stock_buy_tip));
                e();
                return;
            }
            this.G = AddCartMessage.from(itemDetail, this.K);
            v();
            a(this.G);
            if (!af.a(this.L.getModelDetails()) || this.L.isCanUseWholesale()) {
                com.garena.android.appkit.btmsheet.a aVar = this.N;
                if (aVar != null && !aVar.isShowing()) {
                    this.N.show();
                    return;
                }
                return;
            }
            c();
            e();
        }
    }

    private void a(AddCartMessage addCartMessage) {
        this.p.a(this.G);
        if (this.G.isStatusBannedOrDeleted()) {
            o();
        } else {
            this.M = addCartMessage.itemImage;
            z.b(getContext()).a(addCartMessage.itemImage).a((ah) new u()).a(this.f21071b);
            if (this.G.hasTwoTierVariations() && this.w.a("tier_variations")) {
                this.f21074e.setVisibility(8);
                this.h.setVisibility(0);
                this.h.a(this.G, (al) new al() {
                    public void a(TextView textView, boolean z) {
                        c.this.a(textView, z);
                    }

                    public void a() {
                        c.this.d();
                    }
                });
                this.h.setOnVariantSelectedCallback(new com.shopee.app.ui.common.u() {
                    public void a() {
                        c.this.r();
                    }

                    public void a(Variant variant) {
                        c.this.setDataForSelectedVariation(variant);
                    }
                });
                r();
            } else if (this.G.hasVariations()) {
                this.H.e();
                this.i.a();
                this.f21074e.setVisibility(0);
                this.h.setVisibility(8);
                s();
            } else {
                p();
            }
            a(this.f21076g, !TextUtils.isEmpty(this.G.getSizeChartImage()));
        }
        if (!addCartMessage.isCanUseWholesale() || af.a(addCartMessage.getWholesaleTiers())) {
            this.k.b();
        } else {
            this.k.c();
        }
    }

    public void a(long j2, int i2, int i3) {
        this.J = j2;
        this.K = i3;
        this.p.a(j2, i2);
    }

    /* access modifiers changed from: private */
    public void a(TextView textView, boolean z2) {
        if (z2) {
            textView.setVisibility(0);
            this.t.a("product", "size_chart_link");
            return;
        }
        textView.setVisibility(8);
    }

    private void o() {
        this.f21073d.setVisibility(4);
        setPrice(com.garena.android.appkit.tools.b.e(R.string.sp_item_banner_or_deleted));
        this.f21074e.setVisibility(8);
        this.n.setVisibility(8);
        this.k.setEditable(false);
        this.m.setEnabled(false);
    }

    private void p() {
        if (this.G.isHideStock()) {
            this.f21073d.setVisibility(4);
        } else {
            this.f21073d.setVisibility(0);
            this.f21073d.setText(com.garena.android.appkit.tools.b.a(R.string.sp_stock_n, Integer.valueOf(this.G.getStock())));
        }
        if (this.G.isHideStock()) {
            this.k.a(this.G.stock, 1);
        } else {
            this.k.a(this.G.stock, 0);
        }
        setPrice(this.G.getPriceStr());
        this.f21074e.setVisibility(8);
        this.n.setVisibility(8);
        if ((this.E & 2) != 0) {
            this.k.setVisibility(0);
            this.k.a(this.G.getStock(), this.D);
            this.j.setVisibility(0);
        } else {
            this.k.setVisibility(8);
            this.j.setVisibility(8);
        }
        if ((this.E & 4) != 0) {
            this.m.setVisibility(0);
            this.l.setVisibility(0);
        } else {
            this.m.setVisibility(8);
            this.l.setVisibility(8);
        }
        q();
    }

    private void q() {
        e eVar = F;
        if (eVar != null && eVar.f21094a == this.G.itemID) {
            this.k.setQuantity(F.f21097d > 0 ? F.f21097d : 1);
        }
    }

    /* access modifiers changed from: private */
    public void r() {
        this.k.a(this.G.getStock(), this.D);
        this.k.setEditable(false);
        if (this.G.isHideStock()) {
            this.f21073d.setVisibility(4);
        } else {
            this.f21073d.setVisibility(0);
            this.f21073d.setText(com.garena.android.appkit.tools.b.a(R.string.sp_stock_n, Integer.valueOf(this.G.getStock())));
        }
        setPrice(this.G.getPriceStr());
    }

    private void s() {
        if (this.G.isHideStock()) {
            this.f21073d.setVisibility(4);
        } else {
            this.f21073d.setVisibility(0);
            this.f21073d.setText(com.garena.android.appkit.tools.b.a(R.string.sp_stock_n, Integer.valueOf(this.G.getStock())));
        }
        setPrice(this.G.getPriceStr());
        this.n.setVisibility(0);
        this.f21074e.setVisibility(0);
        this.i.a();
        if ((this.E & 2) != 0) {
            this.k.setVisibility(0);
            this.k.a(this.G.getStock(), this.D);
            this.j.setVisibility(0);
        } else {
            this.k.setVisibility(8);
            this.j.setVisibility(8);
        }
        if ((this.E & 4) != 0) {
            this.m.setVisibility(0);
            this.l.setVisibility(0);
        } else {
            this.m.setVisibility(8);
            this.l.setVisibility(8);
        }
        if ((this.E & 1) != 0) {
            this.n.setVisibility(0);
            this.f21074e.setVisibility(0);
        } else {
            this.n.setVisibility(8);
            this.f21074e.setVisibility(8);
        }
        this.H.d();
    }

    /* access modifiers changed from: private */
    public void setDataForSelectedVariation(Variant variant) {
        e eVar;
        Iterator<e> it = I.iterator();
        while (true) {
            if (!it.hasNext()) {
                eVar = null;
                break;
            }
            eVar = it.next();
            if (eVar.f21094a == variant.modelID) {
                F = eVar;
                eVar.f21096c = variant.modelPrice;
                break;
            }
        }
        int i2 = 1;
        if (this.G.isHideStock()) {
            this.f21073d.setVisibility(4);
        } else {
            this.f21073d.setVisibility(0);
            this.f21073d.setText(com.garena.android.appkit.tools.b.a(R.string.sp_stock_n, Integer.valueOf(variant.modelStock)));
        }
        j();
        this.k.a(variant.modelStock, this.D);
        a(eVar == null ? variant.modelPrice : eVar.f21096c, variant.modelPriceBeforeDiscount);
        g gVar = this.k;
        if (eVar != null) {
            i2 = eVar.f21097d;
        }
        gVar.setQuantity(i2);
        m();
    }

    public void setPrice(String str) {
        com.a.a.f a2 = com.a.a.f.a(getContext());
        a2.a().a().b(this.O.a()).a(this.C).c().a((Object) str).b();
        a2.a(this.f21072c);
    }

    private void a(long j2, long j3) {
        if (j3 > 0) {
            com.a.a.f a2 = com.a.a.f.a(getContext(), this.B);
            a2.a().a().b().b(com.garena.android.appkit.tools.b.a(R.color.black26)).a(this.C).c().a((Object) au.b(j3)).b();
            a2.a().a().b(this.O.a()).a(this.C).c().a((Object) au.b(j2)).b();
            a2.a(this.f21072c);
            return;
        }
        setPrice(au.b(j2));
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (this.N != null) {
            com.shopee.app.c.a.a((View) this.k);
            this.N.cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.G == null) {
            a(com.garena.android.appkit.tools.b.e(R.string.sp_item_detail_not_ready));
            return;
        }
        int quantity = this.k.getQuantity();
        if (quantity == -1) {
            a(com.garena.android.appkit.tools.b.e(R.string.sp_invalid_offer_qty));
        } else if (quantity == -2) {
            a(com.garena.android.appkit.tools.b.e(R.string.sp_quantity_not_0));
        } else if (quantity == -3) {
            a(com.garena.android.appkit.tools.b.e(R.string.sp_quantity_exceed_stock));
        } else {
            if (this.u.isFullBuild()) {
                t();
            } else {
                u();
            }
            int[] iArr = new int[2];
            this.f21071b.getLocationOnScreen(iArr);
            Activity activity = this.A;
            if (activity instanceof com.shopee.app.ui.a.b) {
                com.shopee.app.ui.actionbar.a v2 = ((com.shopee.app.ui.a.b) activity).v();
                if (v2 != null) {
                    this.z.a("ON_ADD_CART_ANIMATION", new com.garena.android.appkit.b.a(new b(iArr, v2.getCartLocation(), this.M, true)));
                } else {
                    this.z.a("ON_ADD_CART_ANIMATION", new com.garena.android.appkit.b.a(new b(iArr, new int[]{-1, -1}, this.M, true)));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (!TextUtils.isEmpty(this.G.getSizeChartImage())) {
            MediaData newImageData = MediaData.newImageData(this.G.getSizeChartImage());
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(newImageData);
            ImageBrowserActivity_.a(getContext()).a((ArrayList<MediaData>) arrayList).a(true).a();
            this.t.a("size_chart_link", "", com.shopee.app.tracking.trackingv3.b.f19172a, "product");
        }
    }

    private void t() {
        if (this.G.hasVariations()) {
            Variant b2 = (!this.w.a("tier_variations") || !this.G.hasTwoTierVariations()) ? this.H.b() : this.h.getSelectedVariant();
            if (b2 == null) {
                l();
                r.a().b((int) R.string.sp_no_variation_selected_err);
            } else if (!this.r.isLoggedIn()) {
                if (!this.G.skipServerRequest()) {
                    a aVar = new a();
                    aVar.f21081a = this.G.itemID;
                    aVar.f21082b = "IDR";
                    aVar.f21083c = au.a(this.G.price);
                    aVar.f21084d = this.k.getQuantity();
                    aVar.f21085e = this.G.shopID;
                    aVar.f21086f = b2.modelID;
                    aVar.f21087g = this.G;
                    i.f22227a = aVar;
                } else {
                    a(b2.modelID, this.k.getQuantity());
                }
                this.x.f();
            } else if (!this.G.skipServerRequest()) {
                this.s.a(this.G.itemID, "IDR", au.a(this.G.price), this.k.getQuantity(), this.G.shopID, this.G.getCategoryIDs());
                new com.shopee.app.network.d.g().a(this.G.itemID, this.k.getQuantity(), this.G.shopID, b2.modelID, this.G);
            } else {
                a(b2.modelID, this.k.getQuantity());
            }
        } else if (!this.r.isLoggedIn()) {
            if (!this.G.skipServerRequest()) {
                a aVar2 = new a();
                aVar2.f21081a = this.G.itemID;
                aVar2.f21082b = "IDR";
                aVar2.f21083c = au.a(this.G.price);
                aVar2.f21084d = this.k.getQuantity();
                aVar2.f21085e = this.G.shopID;
                aVar2.f21086f = 0;
                aVar2.f21087g = this.G;
                i.f22227a = aVar2;
            } else {
                a(0, this.k.getQuantity());
            }
            this.x.f();
        } else if (!this.G.skipServerRequest()) {
            this.s.a(this.G.itemID, "IDR", au.a(this.G.price), this.k.getQuantity(), this.G.shopID, this.G.getCategoryIDs());
            new com.shopee.app.network.d.g().a(this.G.itemID, this.k.getQuantity(), this.G.shopID, this.G);
        } else {
            a(0, this.k.getQuantity());
        }
    }

    private void u() {
        if (!this.G.hasVariations()) {
            this.s.a(this.G.itemID, "IDR", au.a(this.G.price), this.k.getQuantity(), this.G.shopID);
        } else if (this.H.b() == null) {
            l();
            r.a().b((int) R.string.sp_no_variation_selected_err);
        } else {
            this.s.a(this.G.itemID, "IDR", au.a(this.G.price), this.k.getQuantity(), this.G.shopID);
        }
        this.x.a(this.G.itemID, this.G.shopID, this.G.userID);
    }

    private void a(long j2, int i2) {
        AddCartMessage addCartMessage = this.G;
        if (addCartMessage != null) {
            addCartMessage.setSelectedModelId(j2);
            this.G.setQuantity(i2);
            this.z.a().Z.a(this.G).a();
            com.garena.android.appkit.btmsheet.a aVar = this.N;
            if (aVar != null) {
                aVar.dismiss();
            }
        }
    }

    public void a(String str) {
        r.a().a(str);
    }

    public View getScrollingView() {
        if (this.h.getVisibility() == 0) {
            return this.h;
        }
        return this.f21074e;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.p.b();
        if (this.G.hasVariations()) {
            e eVar = F;
            if (eVar != null) {
                F = new e(eVar.f21094a, F.f21095b, F.f21096c, this.k.getQuantity());
                return;
            }
        }
        F = new e(this.G.itemID, "", this.G.price, this.k.getQuantity());
    }

    public void setDialog(com.garena.android.appkit.btmsheet.a aVar) {
        this.N = aVar;
    }

    public void e() {
        this.q.b(this.p);
        this.p.d();
        this.p.b();
        com.garena.android.appkit.btmsheet.a aVar = this.N;
        if (aVar != null && !aVar.isShowing()) {
            this.N.dismiss();
            this.N = null;
        }
    }

    public void f() {
        this.o.setVisibility(0);
    }

    public void g() {
        this.o.setVisibility(8);
    }

    private void v() {
        if (this.G.isHideStock()) {
            this.D = 1;
        } else {
            this.D = 0;
        }
    }

    private class d implements View.OnClickListener, GTagCloud.a {

        /* renamed from: b  reason: collision with root package name */
        private List<f> f21093b;

        private d() {
            this.f21093b = new ArrayList();
        }

        public int a() {
            if (c.this.G == null || c.this.G.variations == null) {
                return 0;
            }
            return c.this.G.variations.size();
        }

        /* access modifiers changed from: private */
        public void e() {
            boolean z = true;
            if (c.I.size() == c.this.G.variations.size()) {
                int size = c.this.G.variations.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        z = false;
                        break;
                    } else if (((e) c.I.get(i)).f21094a != c.this.G.variations.get(i).modelID) {
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
                for (Variant next : c.this.G.variations) {
                    e eVar = new e(next);
                    if (c.F != null && c.F.f21094a == next.modelID) {
                        eVar.f21096c = c.F.f21096c;
                        eVar.f21097d = c.F.f21097d;
                    }
                    c.I.add(eVar);
                }
            }
        }

        public View a(Context context, int i) {
            f fVar;
            if (this.f21093b.size() > i) {
                fVar = this.f21093b.get(i);
            } else {
                fVar = g.a(context);
                fVar.setData(c.this.G.variations.get(i));
                fVar.setActiveBgRes(c.this.O.b());
                this.f21093b.add(i, fVar);
            }
            fVar.setOnClickListener(this);
            return fVar;
        }

        public void onClick(View view) {
            f fVar = (f) view;
            if (fVar.d()) {
                Iterator<f> it = this.f21093b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    f next = it.next();
                    if (next.c()) {
                        Iterator it2 = c.I.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            e eVar = (e) it2.next();
                            if (eVar.f21094a == next.getData().modelID) {
                                eVar.f21097d = c.this.k.getQuantity();
                                break;
                            }
                        }
                    }
                }
                for (f next2 : this.f21093b) {
                    if (next2.equals(fVar)) {
                        next2.setActive(true);
                    } else if (next2.d()) {
                        next2.setActive(false);
                    }
                }
                c.this.setDataForSelectedVariation(fVar.getData());
            }
        }

        public Variant b() {
            for (f next : this.f21093b) {
                if (next.c()) {
                    return next.getData();
                }
            }
            return null;
        }

        public void c() {
            for (f b2 : this.f21093b) {
                b2.b();
            }
        }

        public void d() {
            boolean z;
            int i = 0;
            if (c.F != null) {
                Iterator<f> it = this.f21093b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    f next = it.next();
                    if (next.getData().modelID == c.F.f21094a && next.d()) {
                        c.this.k.setQuantity(c.F.f21097d);
                        next.performClick();
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    e unused = c.F = null;
                } else {
                    return;
                }
            }
            if (this.f21093b.size() > 1) {
                for (f data : this.f21093b) {
                    if (data.getData().modelStock > 0) {
                        i++;
                    }
                }
                if (i != 1) {
                    c.this.k();
                    return;
                }
            }
            for (f next2 : this.f21093b) {
                if (next2.d()) {
                    next2.performClick();
                    return;
                }
            }
        }
    }

    private static class e {

        /* renamed from: a  reason: collision with root package name */
        public long f21094a;

        /* renamed from: b  reason: collision with root package name */
        public String f21095b;

        /* renamed from: c  reason: collision with root package name */
        public long f21096c;

        /* renamed from: d  reason: collision with root package name */
        public int f21097d;

        public e(Variant variant) {
            this.f21094a = variant.modelID;
            this.f21095b = variant.modelName;
            this.f21096c = variant.modelPrice;
            this.f21097d = 1;
        }

        public e(long j, String str, long j2, int i) {
            this.f21094a = j;
            this.f21095b = str;
            this.f21096c = j2;
            this.f21097d = i;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int[] f21088a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f21089b;

        /* renamed from: c  reason: collision with root package name */
        public final String f21090c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f21091d;

        public b(int[] iArr, int[] iArr2, String str, boolean z) {
            this.f21088a = iArr;
            this.f21089b = iArr2;
            this.f21090c = str;
            this.f21091d = z;
        }
    }
}
