package com.shopee.app.ui.home.me.v3.feature.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.shopee.app.data.viewmodel.ShopDetail;
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

public final class e extends n {

    /* renamed from: b  reason: collision with root package name */
    public static final e f22552b = new e();

    public boolean a(i iVar) {
        j.b(iVar, "metaData");
        return true;
    }

    private e() {
        super("activity", "my_likes");
    }

    public static final class a extends OptionRow implements h {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f22553b;

        /* renamed from: com.shopee.app.ui.home.me.v3.feature.a.e$a$a  reason: collision with other inner class name */
        static final class C0333a extends k implements d.d.a.a<p> {
            final /* synthetic */ MeFeature $meFeature;
            final /* synthetic */ i $metaData;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0333a(i iVar, MeFeature meFeature) {
                super(0);
                this.$metaData = iVar;
                this.$meFeature = meFeature;
            }

            public /* synthetic */ Object invoke() {
                a();
                return p.f32714a;
            }

            public final void a() {
                this.$metaData.k().m();
                d h = this.$metaData.h();
                if (h != null) {
                    d.a(h, this.$meFeature, (String) null, 2, (Object) null);
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context, Context context2) {
            super(context2, (AttributeSet) null, 0, 6, (g) null);
            this.f22553b = context;
        }

        public void a(i iVar, MeFeature meFeature) {
            String str;
            j.b(iVar, "metaData");
            j.b(meFeature, "meFeature");
            if (iVar instanceof b.a) {
                ShopDetail a2 = ((b.a) iVar).a();
                if (a2 != null) {
                    if (a2.getLikedCount() <= 0) {
                        str = "";
                    } else if (a2.getLikedCount() == 1) {
                        str = com.garena.android.appkit.tools.b.e(R.string.sp_chat_list_1_item);
                    } else {
                        str = com.garena.android.appkit.tools.b.a(R.string.sp_chat_list_n_items, a2.getLikedCountString());
                    }
                    setValue(str);
                }
            }
            f.a(this, iVar, new C0333a(iVar, meFeature));
        }

        public void a(MeFeature meFeature) {
            setIcon(this.f22553b.getResources().getDrawable(R.drawable.ic_me_likes));
            setText(this.f22553b.getResources().getString(R.string.sp_my_likes));
        }
    }

    public View a(Context context) {
        j.b(context, "context");
        return new a(context, context);
    }
}
