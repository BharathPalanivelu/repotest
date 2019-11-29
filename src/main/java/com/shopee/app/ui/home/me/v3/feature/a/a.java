package com.shopee.app.ui.home.me.v3.feature.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.shopee.app.ui.home.me.tracking.d;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.ui.home.me.v3.feature.MeFeature;
import com.shopee.app.ui.home.me.v3.feature.b;
import com.shopee.app.ui.home.me.v3.feature.f;
import com.shopee.app.ui.home.me.v3.feature.h;
import com.shopee.app.ui.home.me.v3.feature.i;
import com.shopee.app.ui.home.me.v3.feature.n;
import com.shopee.id.R;
import d.d.b.j;
import d.d.b.k;
import d.p;

public final class a extends n {

    /* renamed from: b  reason: collision with root package name */
    public static final a f22544b = new a();

    private a() {
        super("order", "digital_purchase");
    }

    public boolean a(i iVar) {
        j.b(iVar, "metaData");
        if (iVar instanceof b.a) {
            return iVar.o().a("digital_product");
        }
        return false;
    }

    /* renamed from: com.shopee.app.ui.home.me.v3.feature.a.a$a  reason: collision with other inner class name */
    public static final class C0328a extends OptionRow implements h {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f22545b;

        /* renamed from: com.shopee.app.ui.home.me.v3.feature.a.a$a$a  reason: collision with other inner class name */
        static final class C0329a extends k implements d.d.a.a<p> {
            final /* synthetic */ MeFeature $meFeature;
            final /* synthetic */ i $metaData;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0329a(i iVar, MeFeature meFeature) {
                super(0);
                this.$metaData = iVar;
                this.$meFeature = meFeature;
            }

            public /* synthetic */ Object invoke() {
                a();
                return p.f32714a;
            }

            public final void a() {
                this.$metaData.k().n();
                d h = this.$metaData.h();
                if (h != null) {
                    d.a(h, this.$meFeature, (String) null, 2, (Object) null);
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0328a(Context context, Context context2) {
            super(context2, (AttributeSet) null, 0, 6, (g) null);
            this.f22545b = context;
        }

        public void a(i iVar, MeFeature meFeature) {
            j.b(iVar, "metaData");
            j.b(meFeature, "meFeature");
            f.a(this, iVar, new C0329a(iVar, meFeature));
        }

        public void a(MeFeature meFeature) {
            setIcon(this.f22545b.getResources().getDrawable(R.drawable.ic_me_digital_purchase));
            setText(this.f22545b.getResources().getString(R.string.sp_label_digital_purchase));
        }
    }

    public View a(Context context) {
        j.b(context, "context");
        return new C0328a(context, context);
    }
}
