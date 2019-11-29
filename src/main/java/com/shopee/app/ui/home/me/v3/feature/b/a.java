package com.shopee.app.ui.home.me.v3.feature.b;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.ui.home.me.v3.f;
import com.shopee.app.ui.home.me.v3.feature.MeFeature;
import com.shopee.app.ui.home.me.v3.feature.h;
import com.shopee.app.ui.home.me.v3.feature.i;
import com.shopee.app.ui.home.me.v3.feature.n;
import com.shopee.id.R;
import d.d.a.b;
import d.d.b.j;
import d.d.b.k;
import d.p;

public final class a extends n {

    /* renamed from: b  reason: collision with root package name */
    public static final a f22589b = new a();

    public boolean a(i iVar) {
        j.b(iVar, "metaData");
        return true;
    }

    private a() {
        super("add_product", "add_new_products");
    }

    /* renamed from: com.shopee.app.ui.home.me.v3.feature.b.a$a  reason: collision with other inner class name */
    public static final class C0343a extends OptionRow implements h {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f22590b;

        /* renamed from: com.shopee.app.ui.home.me.v3.feature.b.a$a$a  reason: collision with other inner class name */
        static final class C0344a extends k implements b<View, p> {
            final /* synthetic */ MeFeature $meFeature;
            final /* synthetic */ i $metaData;
            final /* synthetic */ C0343a this$0;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0344a(C0343a aVar, i iVar, MeFeature meFeature) {
                super(1);
                this.this$0 = aVar;
                this.$metaData = iVar;
                this.$meFeature = meFeature;
            }

            public /* bridge */ /* synthetic */ Object a(Object obj) {
                a((View) obj);
                return p.f32714a;
            }

            public final void a(View view) {
                com.shopee.app.ui.home.me.v3.feature.k kVar = (com.shopee.app.ui.home.me.v3.feature.k) ((f) this.this$0.f22590b).findViewById(R.id.meSellerView);
                if (kVar != null) {
                    kVar.c();
                }
                com.shopee.app.ui.home.me.tracking.seller.b i = this.$metaData.i();
                if (i != null) {
                    com.shopee.app.ui.home.me.tracking.seller.b.a(i, this.$meFeature, (String) null, 2, (Object) null);
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0343a(Context context, Context context2) {
            super(context2, (AttributeSet) null, 0, 6, (g) null);
            this.f22590b = context;
        }

        public void a(i iVar, MeFeature meFeature) {
            j.b(iVar, "metaData");
            j.b(meFeature, "meFeature");
            if (this.f22590b instanceof f) {
                com.shopee.app.e.b.a((View) this, (b<? super View, p>) new C0344a(this, iVar, meFeature));
            }
        }

        public void a(MeFeature meFeature) {
            setIcon(this.f22590b.getResources().getDrawable(R.drawable.ic_chat_plus));
            setText(this.f22590b.getResources().getString(R.string.sp_label_add_new_products));
        }
    }

    public View a(Context context) {
        j.b(context, "context");
        return new C0343a(context, context);
    }
}
