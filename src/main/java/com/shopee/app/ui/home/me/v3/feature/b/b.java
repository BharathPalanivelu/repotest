package com.shopee.app.ui.home.me.v3.feature.b;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.ui.home.me.v3.feature.MeFeature;
import com.shopee.app.ui.home.me.v3.feature.f;
import com.shopee.app.ui.home.me.v3.feature.h;
import com.shopee.app.ui.home.me.v3.feature.i;
import com.shopee.app.ui.home.me.v3.feature.k;
import com.shopee.app.ui.home.me.v3.feature.n;
import com.shopee.id.R;
import d.d.b.j;
import d.p;

public final class b extends n {

    /* renamed from: b  reason: collision with root package name */
    public static final b f22591b = new b();

    private b() {
        super("others", "jko_pay_wallet");
    }

    public boolean a(i iVar) {
        j.b(iVar, "metaData");
        return (iVar instanceof k.a) && ((k.a) iVar).d();
    }

    public static final class a extends OptionRow implements h {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f22592b;

        /* renamed from: com.shopee.app.ui.home.me.v3.feature.b.b$a$a  reason: collision with other inner class name */
        static final class C0345a extends d.d.b.k implements d.d.a.a<p> {
            final /* synthetic */ MeFeature $meFeature;
            final /* synthetic */ i $metaData;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0345a(i iVar, MeFeature meFeature) {
                super(0);
                this.$metaData = iVar;
                this.$meFeature = meFeature;
            }

            public /* synthetic */ Object invoke() {
                a();
                return p.f32714a;
            }

            public final void a() {
                this.$metaData.k().ar();
                com.shopee.app.ui.home.me.tracking.seller.b i = this.$metaData.i();
                if (i != null) {
                    com.shopee.app.ui.home.me.tracking.seller.b.a(i, this.$meFeature, (String) null, 2, (Object) null);
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context, Context context2) {
            super(context2, (AttributeSet) null, 0, 6, (g) null);
            this.f22592b = context;
        }

        public void a(i iVar, MeFeature meFeature) {
            j.b(iVar, "metaData");
            j.b(meFeature, "meFeature");
            f.a(this, iVar, new C0345a(iVar, meFeature));
        }

        public void a(MeFeature meFeature) {
            setIcon(this.f22592b.getResources().getDrawable(R.drawable.ic_me_jkopay));
            setText(this.f22592b.getResources().getString(R.string.sp_label_jko_pay));
        }
    }

    public View a(Context context) {
        j.b(context, "context");
        return new a(context, context);
    }
}
