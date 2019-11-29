package com.shopee.app.ui.product.b.a;

import com.shopee.app.network.http.data.ListingConfig;
import com.shopee.app.util.q.g;
import d.d.b.j;
import java.util.List;

public final class b implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final a f24356a = new a((g) null);

    /* renamed from: c  reason: collision with root package name */
    private final List<Integer> f24357c;

    public b(List<Integer> list) {
        j.b(list, "idList");
        this.f24357c = list;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final b a(ListingConfig listingConfig) {
            j.b(listingConfig, "listingConfig");
            List<Integer> list = null;
            for (ListingConfig.ListingAttribute listingAttribute : listingConfig.getListingAttrs()) {
                if (j.a((Object) "category.blacklist", (Object) listingAttribute.getKey())) {
                    list = com.shopee.app.util.q.b.a(listingAttribute.getValue());
                }
            }
            if (list == null) {
                return null;
            }
            if (list == null) {
                j.a();
            }
            return new b(list);
        }
    }
}
