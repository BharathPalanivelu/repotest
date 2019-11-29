package com.shopee.app.ui.home.me.v3.feature.b;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.ui.home.me.tracking.seller.b;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.ui.home.me.v3.feature.MeFeature;
import com.shopee.app.ui.home.me.v3.feature.f;
import com.shopee.app.ui.home.me.v3.feature.h;
import com.shopee.app.ui.home.me.v3.feature.i;
import com.shopee.app.ui.home.me.v3.feature.k;
import com.shopee.app.ui.home.me.v3.feature.n;
import com.shopee.id.R;
import d.d.b.j;
import d.d.b.k;
import d.p;

public final class l extends n {

    /* renamed from: b  reason: collision with root package name */
    public static final l f22613b = new l();

    public boolean a(i iVar) {
        j.b(iVar, "metaData");
        return true;
    }

    private l() {
        super("others", "shop_rating");
    }

    public static final class a extends OptionRow implements h {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f22614b;

        /* renamed from: com.shopee.app.ui.home.me.v3.feature.b.l$a$a  reason: collision with other inner class name */
        static final class C0352a extends k implements d.d.a.a<p> {
            final /* synthetic */ MeFeature $meFeature;
            final /* synthetic */ i $metaData;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0352a(i iVar, MeFeature meFeature) {
                super(0);
                this.$metaData = iVar;
                this.$meFeature = meFeature;
            }

            public /* synthetic */ Object invoke() {
                a();
                return p.f32714a;
            }

            public final void a() {
                i iVar = this.$metaData;
                if (iVar instanceof k.a) {
                    ShopDetail c2 = ((k.a) iVar).c();
                    if (c2 != null) {
                        this.$metaData.k().a(c2.getUserId(), true);
                        b i = this.$metaData.i();
                        if (i != null) {
                            i.a(this.$meFeature, "my_rating");
                        }
                    }
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context, Context context2) {
            super(context2, (AttributeSet) null, 0, 6, (g) null);
            this.f22614b = context;
        }

        public void a(i iVar, MeFeature meFeature) {
            j.b(iVar, "metaData");
            j.b(meFeature, "meFeature");
            f.a(this, iVar, new C0352a(iVar, meFeature));
        }

        public void a(MeFeature meFeature) {
            setIcon(this.f22614b.getResources().getDrawable(R.drawable.ic_me_rating));
            setText(this.f22614b.getString(R.string.sp_view_shop_rating));
        }
    }

    public View a(Context context) {
        j.b(context, "context");
        return new a(context, context);
    }
}
