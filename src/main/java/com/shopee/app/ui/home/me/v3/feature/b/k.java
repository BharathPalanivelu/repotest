package com.shopee.app.ui.home.me.v3.feature.b;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.shopee.app.ui.home.me.tracking.seller.b;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.ui.home.me.v3.feature.MeFeature;
import com.shopee.app.ui.home.me.v3.feature.f;
import com.shopee.app.ui.home.me.v3.feature.h;
import com.shopee.app.ui.home.me.v3.feature.i;
import com.shopee.app.ui.home.me.v3.feature.k;
import com.shopee.app.ui.home.me.v3.feature.n;
import com.shopee.app.util.au;
import com.shopee.app.util.bn;
import com.shopee.id.R;
import d.d.b.j;
import d.p;

public final class k extends n {

    /* renamed from: b  reason: collision with root package name */
    public static final k f22611b = new k();

    private k() {
        super("others", "seller_wallet");
    }

    public boolean a(i iVar) {
        j.b(iVar, "metaData");
        return iVar.j().isWalletFeatureOn();
    }

    public static final class a extends OptionRow implements h {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f22612b;

        /* renamed from: com.shopee.app.ui.home.me.v3.feature.b.k$a$a  reason: collision with other inner class name */
        static final class C0351a extends d.d.b.k implements d.d.a.a<p> {
            final /* synthetic */ MeFeature $meFeature;
            final /* synthetic */ i $metaData;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0351a(i iVar, MeFeature meFeature) {
                super(0);
                this.$metaData = iVar;
                this.$meFeature = meFeature;
            }

            public /* synthetic */ Object invoke() {
                a();
                return p.f32714a;
            }

            public final void a() {
                this.$metaData.k().a("WALLET", "type=1", "action");
                b i = this.$metaData.i();
                if (i != null) {
                    i.a(this.$meFeature, "wallet");
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context, Context context2) {
            super(context2, (AttributeSet) null, 0, 6, (g) null);
            this.f22612b = context;
        }

        public void a(i iVar, MeFeature meFeature) {
            j.b(iVar, "metaData");
            j.b(meFeature, "meFeature");
            int buyerWalletProvider = iVar.j().getBuyerWalletProvider();
            boolean a2 = iVar.n().a();
            String d2 = bn.d(buyerWalletProvider, a2);
            long a3 = iVar instanceof k.a ? ((k.a) iVar).a() : 0;
            setValue(a3 > 0 ? au.b(a3) : "");
            setText(d2);
            setIcon(bn.c(buyerWalletProvider, a2));
            f.a(this, iVar, new C0351a(iVar, meFeature));
        }

        public void a(MeFeature meFeature) {
            setIcon(this.f22612b.getResources().getDrawable(R.drawable.ic_me_seller_balance));
        }
    }

    public View a(Context context) {
        j.b(context, "context");
        return new a(context, context);
    }
}
