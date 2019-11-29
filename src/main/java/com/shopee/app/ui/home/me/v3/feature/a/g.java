package com.shopee.app.ui.home.me.v3.feature.a;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.shopee.app.data.viewmodel.order.BuyerOrderCountItem;
import com.shopee.app.ui.home.me.v3.OptionBox;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.ui.home.me.v3.feature.MeFeature;
import com.shopee.app.ui.home.me.v3.feature.b;
import com.shopee.app.ui.home.me.v3.feature.h;
import com.shopee.app.ui.home.me.v3.feature.i;
import com.shopee.id.R;
import d.d.b.j;
import d.d.b.k;
import d.p;

public class g extends LinearLayout implements h {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f22557a;

    /* renamed from: b  reason: collision with root package name */
    public OptionRow f22558b;

    /* renamed from: c  reason: collision with root package name */
    public OptionBox f22559c;

    /* renamed from: d  reason: collision with root package name */
    public OptionBox f22560d;

    /* renamed from: e  reason: collision with root package name */
    public OptionBox f22561e;

    /* renamed from: f  reason: collision with root package name */
    public OptionBox f22562f;

    /* renamed from: g  reason: collision with root package name */
    public OptionBox f22563g;

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
            this.$metaData.k().h(3);
            com.shopee.app.ui.home.me.tracking.d h = this.$metaData.h();
            if (h != null) {
                com.shopee.app.ui.home.me.tracking.d.a(h, this.$meFeature, (String) null, 2, (Object) null);
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
            this.$metaData.k().h(0);
            com.shopee.app.ui.home.me.tracking.d h = this.$metaData.h();
            if (h != null) {
                h.a(this.$meFeature, "to_pay");
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
            this.$metaData.k().h(2);
            com.shopee.app.ui.home.me.tracking.d h = this.$metaData.h();
            if (h != null) {
                h.a(this.$meFeature, "to_receive");
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
            this.$metaData.k().h(1);
            com.shopee.app.ui.home.me.tracking.d h = this.$metaData.h();
            if (h != null) {
                h.a(this.$meFeature, "to_ship");
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
            this.$metaData.k().h(5);
            com.shopee.app.ui.home.me.tracking.d h = this.$metaData.h();
            if (h != null) {
                h.a(this.$meFeature, "to_return");
            }
        }
    }

    static final class f extends k implements d.d.a.a<p> {
        final /* synthetic */ MeFeature $meFeature;
        final /* synthetic */ i $metaData;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(i iVar, MeFeature meFeature) {
            super(0);
            this.$metaData = iVar;
            this.$meFeature = meFeature;
        }

        public /* synthetic */ Object invoke() {
            a();
            return p.f32714a;
        }

        public final void a() {
            this.$metaData.k().h(3);
            com.shopee.app.ui.home.me.tracking.d h = this.$metaData.h();
            if (h != null) {
                h.a(this.$meFeature, "to_rate");
            }
        }
    }

    public g(Context context) {
        super(context);
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    }

    public ViewGroup getPurchaseDetailPanel() {
        ViewGroup viewGroup = this.f22557a;
        if (viewGroup == null) {
            j.b("purchaseDetailPanel");
        }
        return viewGroup;
    }

    public void setPurchaseDetailPanel(ViewGroup viewGroup) {
        j.b(viewGroup, "<set-?>");
        this.f22557a = viewGroup;
    }

    public OptionRow getPurchaseButton() {
        OptionRow optionRow = this.f22558b;
        if (optionRow == null) {
            j.b("purchaseButton");
        }
        return optionRow;
    }

    public void setPurchaseButton(OptionRow optionRow) {
        j.b(optionRow, "<set-?>");
        this.f22558b = optionRow;
    }

    public OptionBox getToPayButton() {
        OptionBox optionBox = this.f22559c;
        if (optionBox == null) {
            j.b("toPayButton");
        }
        return optionBox;
    }

    public void setToPayButton(OptionBox optionBox) {
        j.b(optionBox, "<set-?>");
        this.f22559c = optionBox;
    }

    public OptionBox getToShipButton() {
        OptionBox optionBox = this.f22560d;
        if (optionBox == null) {
            j.b("toShipButton");
        }
        return optionBox;
    }

    public void setToShipButton(OptionBox optionBox) {
        j.b(optionBox, "<set-?>");
        this.f22560d = optionBox;
    }

    public OptionBox getToReturnButton() {
        OptionBox optionBox = this.f22561e;
        if (optionBox == null) {
            j.b("toReturnButton");
        }
        return optionBox;
    }

    public void setToReturnButton(OptionBox optionBox) {
        j.b(optionBox, "<set-?>");
        this.f22561e = optionBox;
    }

    public OptionBox getToReceiveButton() {
        OptionBox optionBox = this.f22562f;
        if (optionBox == null) {
            j.b("toReceiveButton");
        }
        return optionBox;
    }

    public void setToReceiveButton(OptionBox optionBox) {
        j.b(optionBox, "<set-?>");
        this.f22562f = optionBox;
    }

    public OptionBox getToRateButton() {
        OptionBox optionBox = this.f22563g;
        if (optionBox == null) {
            j.b("toRateButton");
        }
        return optionBox;
    }

    public void setToRateButton(OptionBox optionBox) {
        j.b(optionBox, "<set-?>");
        this.f22563g = optionBox;
    }

    public void a(i iVar, MeFeature meFeature) {
        j.b(iVar, "metaData");
        j.b(meFeature, "meFeature");
        if (iVar instanceof b.a) {
            if (iVar.j().isLoggedIn()) {
                getPurchaseDetailPanel().setVisibility(0);
                getPurchaseButton().setValue(getContext().getString(R.string.sp_view_purchase_history));
                f.f22554b.b().addAll(f.f22554b.a());
            } else {
                getPurchaseDetailPanel().setVisibility(8);
                getPurchaseButton().setValue("");
                f.f22554b.b().clear();
            }
            com.shopee.app.ui.home.me.v3.feature.f.a(getPurchaseButton(), iVar, new a(iVar, meFeature));
            com.shopee.app.ui.home.me.v3.feature.f.a(getToPayButton(), iVar, new b(iVar, meFeature));
            com.shopee.app.ui.home.me.v3.feature.f.a(getToReceiveButton(), iVar, new c(iVar, meFeature));
            com.shopee.app.ui.home.me.v3.feature.f.a(getToShipButton(), iVar, new d(iVar, meFeature));
            com.shopee.app.ui.home.me.v3.feature.f.a(getToReturnButton(), iVar, new e(iVar, meFeature));
            com.shopee.app.ui.home.me.v3.feature.f.a(getToRateButton(), iVar, new f(iVar, meFeature));
            BuyerOrderCountItem f2 = ((b.a) iVar).f();
            if (f2 != null) {
                getToPayButton().setNumber(f2.getBuyerUnpaid());
                getToShipButton().setNumber(f2.getBuyerToShip());
                getToReceiveButton().setNumber(f2.getBuyerShipping());
                getToReturnButton().setNumber(f2.getBuyerReturn());
                getToRateButton().setNumber(f2.getBuyerRate());
                if (j.a(f2.getBuyerReturn().intValue(), 0) > 0) {
                    getToReturnButton().setVisibility(0);
                    getToRateButton().setVisibility(8);
                    f.f22554b.b().remove("to_rate");
                    return;
                }
                getToReturnButton().setVisibility(8);
                getToRateButton().setVisibility(0);
                f.f22554b.b().remove("to_return");
            }
        }
    }
}
