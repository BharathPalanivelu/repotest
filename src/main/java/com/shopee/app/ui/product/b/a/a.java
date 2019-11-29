package com.shopee.app.ui.product.b.a;

import com.shopee.app.network.http.data.ListingConfig;
import com.shopee.app.util.q.b;
import com.shopee.app.util.q.g;
import d.d.b.j;
import java.util.List;

public final class a implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final C0374a f24354a = new C0374a((g) null);

    /* renamed from: c  reason: collision with root package name */
    private final List<Integer> f24355c;

    public a(List<Integer> list) {
        j.b(list, "idList");
        this.f24355c = list;
    }

    /* renamed from: com.shopee.app.ui.product.b.a.a$a  reason: collision with other inner class name */
    public static final class C0374a {
        private C0374a() {
        }

        public /* synthetic */ C0374a(g gVar) {
            this();
        }

        public final a a(ListingConfig listingConfig) {
            j.b(listingConfig, "listingConfig");
            List<Integer> list = null;
            for (ListingConfig.ListingAttribute listingAttribute : listingConfig.getListingAttrs()) {
                if (j.a((Object) "brand.blacklist", (Object) listingAttribute.getKey())) {
                    list = b.a(listingAttribute.getValue());
                }
            }
            if (list == null) {
                return null;
            }
            if (list == null) {
                j.a();
            }
            return new a(list);
        }
    }
}
