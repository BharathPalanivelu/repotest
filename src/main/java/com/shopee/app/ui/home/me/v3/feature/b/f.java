package com.shopee.app.ui.home.me.v3.feature.b;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.shopee.app.data.viewmodel.order.SellerOrderCountItem;
import com.shopee.app.ui.home.me.v3.OptionBox;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.ui.home.me.v3.feature.MeFeature;
import com.shopee.app.ui.home.me.v3.feature.h;
import com.shopee.app.ui.home.me.v3.feature.i;
import com.shopee.app.ui.home.me.v3.feature.k;
import d.d.b.j;
import d.d.b.k;
import d.p;

public class f extends LinearLayout implements h {

    /* renamed from: a  reason: collision with root package name */
    public OptionRow f22598a;

    /* renamed from: b  reason: collision with root package name */
    public OptionBox f22599b;

    /* renamed from: c  reason: collision with root package name */
    public OptionBox f22600c;

    /* renamed from: d  reason: collision with root package name */
    public OptionBox f22601d;

    /* renamed from: e  reason: collision with root package name */
    public OptionBox f22602e;

    public void a(MeFeature meFeature) {
    }

    static final class a extends k implements d.d.a.a<p> {
        final /* synthetic */ MeFeature $meFeature;
        final /* synthetic */ i $metaData;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(i iVar, MeFeature meFeature) {
            super(0);
            this.$metaData = iVar;
            this.$meFeature = meFeature;
        }

        public /* synthetic */ Object invoke() {
            a();
            return p.f32714a;
        }

        public final void a() {
            this.$metaData.k().g(3);
            com.shopee.app.ui.home.me.tracking.seller.b i = this.$metaData.i();
            if (i != null) {
                i.a(this.$meFeature, "my_sales");
            }
        }
    }

    static final class b extends k implements d.d.a.a<p> {
        final /* synthetic */ MeFeature $meFeature;
        final /* synthetic */ i $metaData;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(i iVar, MeFeature meFeature) {
            super(0);
            this.$metaData = iVar;
            this.$meFeature = meFeature;
        }

        public /* synthetic */ Object invoke() {
            a();
            return p.f32714a;
        }

        public final void a() {
            this.$metaData.k().g(1);
            com.shopee.app.ui.home.me.tracking.seller.b i = this.$metaData.i();
            if (i != null) {
                i.a(this.$meFeature, "to_ship");
            }
        }
    }

    static final class c extends k implements d.d.a.a<p> {
        final /* synthetic */ MeFeature $meFeature;
        final /* synthetic */ i $metaData;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(i iVar, MeFeature meFeature) {
            super(0);
            this.$metaData = iVar;
            this.$meFeature = meFeature;
        }

        public /* synthetic */ Object invoke() {
            a();
            return p.f32714a;
        }

        public final void a() {
            this.$metaData.k().g(4);
            com.shopee.app.ui.home.me.tracking.seller.b i = this.$metaData.i();
            if (i != null) {
                i.a(this.$meFeature, "to_cancel");
            }
        }
    }

    static final class d extends k implements d.d.a.a<p> {
        final /* synthetic */ MeFeature $meFeature;
        final /* synthetic */ i $metaData;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(i iVar, MeFeature meFeature) {
            super(0);
            this.$metaData = iVar;
            this.$meFeature = meFeature;
        }

        public /* synthetic */ Object invoke() {
            a();
            return p.f32714a;
        }

        public final void a() {
            this.$metaData.k().g(5);
            com.shopee.app.ui.home.me.tracking.seller.b i = this.$metaData.i();
            if (i != null) {
                i.a(this.$meFeature, "return_and_refund");
            }
        }
    }

    static final class e extends k implements d.d.a.a<p> {
        final /* synthetic */ MeFeature $meFeature;
        final /* synthetic */ i $metaData;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(i iVar, MeFeature meFeature) {
            super(0);
            this.$metaData = iVar;
            this.$meFeature = meFeature;
        }

        public /* synthetic */ Object invoke() {
            a();
            return p.f32714a;
        }

        public final void a() {
            this.$metaData.k().g(0);
            com.shopee.app.ui.home.me.tracking.seller.b i = this.$metaData.i();
            if (i != null) {
                i.a(this.$meFeature, "more");
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(Context context) {
        super(context);
        j.b(context, "context");
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public OptionRow getMySaleButton() {
        OptionRow optionRow = this.f22598a;
        if (optionRow == null) {
            j.b("mySaleButton");
        }
        return optionRow;
    }

    public void setMySaleButton(OptionRow optionRow) {
        j.b(optionRow, "<set-?>");
        this.f22598a = optionRow;
    }

    public OptionBox getToShipButton() {
        OptionBox optionBox = this.f22599b;
        if (optionBox == null) {
            j.b("toShipButton");
        }
        return optionBox;
    }

    public void setToShipButton(OptionBox optionBox) {
        j.b(optionBox, "<set-?>");
        this.f22599b = optionBox;
    }

    public OptionBox getToCancelledButton() {
        OptionBox optionBox = this.f22600c;
        if (optionBox == null) {
            j.b("toCancelledButton");
        }
        return optionBox;
    }

    public void setToCancelledButton(OptionBox optionBox) {
        j.b(optionBox, "<set-?>");
        this.f22600c = optionBox;
    }

    public OptionBox getToRefundButton() {
        OptionBox optionBox = this.f22601d;
        if (optionBox == null) {
            j.b("toRefundButton");
        }
        return optionBox;
    }

    public void setToRefundButton(OptionBox optionBox) {
        j.b(optionBox, "<set-?>");
        this.f22601d = optionBox;
    }

    public OptionBox getMoreButton() {
        OptionBox optionBox = this.f22602e;
        if (optionBox == null) {
            j.b("moreButton");
        }
        return optionBox;
    }

    public void setMoreButton(OptionBox optionBox) {
        j.b(optionBox, "<set-?>");
        this.f22602e = optionBox;
    }

    public void a(i iVar, MeFeature meFeature) {
        j.b(iVar, "metaData");
        j.b(meFeature, "meFeature");
        if (iVar instanceof k.a) {
            SellerOrderCountItem b2 = ((k.a) iVar).b();
            if (b2 != null) {
                getToShipButton().setNumber(b2.getSellerToShip());
                getToRefundButton().setNumber(b2.getSellerToReturn());
            }
        }
        com.shopee.app.ui.home.me.v3.feature.f.a(getMySaleButton(), iVar, new a(iVar, meFeature));
        com.shopee.app.ui.home.me.v3.feature.f.a(getToShipButton(), iVar, new b(iVar, meFeature));
        com.shopee.app.ui.home.me.v3.feature.f.a(getToCancelledButton(), iVar, new c(iVar, meFeature));
        com.shopee.app.ui.home.me.v3.feature.f.a(getToRefundButton(), iVar, new d(iVar, meFeature));
        com.shopee.app.ui.home.me.v3.feature.f.a(getMoreButton(), iVar, new e(iVar, meFeature));
    }
}
