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
import com.shopee.app.ui.home.me.v3.feature.n;
import com.shopee.id.R;
import d.d.b.j;
import d.d.b.k;
import d.p;

public final class c extends n {

    /* renamed from: b  reason: collision with root package name */
    public static final c f22593b = new c();

    public boolean a(i iVar) {
        j.b(iVar, "metaData");
        return true;
    }

    private c() {
        super("others", "my_income");
    }

    public static final class a extends OptionRow implements h {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f22594b;

        /* renamed from: com.shopee.app.ui.home.me.v3.feature.b.c$a$a  reason: collision with other inner class name */
        static final class C0346a extends k implements d.d.a.a<p> {
            final /* synthetic */ MeFeature $meFeature;
            final /* synthetic */ i $metaData;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0346a(i iVar, MeFeature meFeature) {
                super(0);
                this.$metaData = iVar;
                this.$meFeature = meFeature;
            }

            public /* synthetic */ Object invoke() {
                a();
                return p.f32714a;
            }

            public final void a() {
                this.$metaData.k().F();
                b i = this.$metaData.i();
                if (i != null) {
                    b.a(i, this.$meFeature, (String) null, 2, (Object) null);
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context, Context context2) {
            super(context2, (AttributeSet) null, 0, 6, (g) null);
            this.f22594b = context;
        }

        public void a(i iVar, MeFeature meFeature) {
            j.b(iVar, "metaData");
            j.b(meFeature, "meFeature");
            f.a(this, iVar, new C0346a(iVar, meFeature));
        }

        public void a(MeFeature meFeature) {
            setIcon(this.f22594b.getResources().getDrawable(R.drawable.ic_me_income));
            setText(this.f22594b.getResources().getString(R.string.sp_label_my_income));
        }
    }

    public View a(Context context) {
        j.b(context, "context");
        return new a(context, context);
    }
}
