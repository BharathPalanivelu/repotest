package com.shopee.app.util;

import android.content.Context;
import com.a.a.f;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.id.R;

public class at {
    public static f a(Context context, String str, long j) {
        String b2 = au.b(j);
        if (str.equals(b2)) {
            f a2 = f.a(context);
            a2.a().a((Object) str).a().b(b.a(R.color.black87)).c().b();
            return a2;
        }
        f a3 = f.a(context);
        a3.a().a((Object) str).a().b(b.a(R.color.black26)).b().c().b();
        a3.a("  ").b();
        a3.a().a((Object) b2).a().b(b.a(R.color.black87)).c().b();
        return a3;
    }

    public static f a(Context context, ItemDetail itemDetail) {
        if (itemDetail.isOutStock()) {
            if (itemDetail.hasPromotion()) {
                f a2 = f.a(context);
                a2.a().a((Object) itemDetail.getVariationNoOOSBeforeDiscountPriceString()).a().b(b.a(R.color.black26)).b().c().b();
                a2.a("  ").b();
                a2.a().a((Object) itemDetail.getVariationNoOOSPriceString()).a().b(b.a(R.color.black54)).c().b();
                return a2;
            }
            f a3 = f.a(context);
            a3.a().a((Object) itemDetail.getVariationNoOOSPriceString()).a().b(b.a(R.color.black26)).c().b();
            return a3;
        } else if (itemDetail.hasPromotion()) {
            f a4 = f.a(context);
            a4.a().a((Object) itemDetail.getVariationNoOOSBeforeDiscountPriceString()).a().b(b.a(R.color.black26)).b().c().b();
            a4.a("  ").b();
            a4.a().a((Object) itemDetail.getVariationNoOOSPriceString()).a().b(b.a(R.color.primary)).c().b();
            return a4;
        } else {
            f a5 = f.a(context);
            a5.a().a((Object) itemDetail.getVariationNoOOSPriceString()).a().b(b.a(R.color.primary)).c().b();
            return a5;
        }
    }
}
