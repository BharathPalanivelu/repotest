package com.shopee.app.ui.product.b.a;

import com.shopee.app.network.http.data.ListingConfig;
import com.shopee.app.util.q.g;
import d.d.b.j;

public final class f implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final a f24370a = new a((g) null);

    /* renamed from: c  reason: collision with root package name */
    private final long f24371c;

    /* renamed from: d  reason: collision with root package name */
    private final long f24372d;

    public f(long j, long j2) {
        this.f24371c = j;
        this.f24372d = j2;
    }

    public final long a() {
        return this.f24371c;
    }

    public final long b() {
        return this.f24372d;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final f a(ListingConfig listingConfig) {
            j.b(listingConfig, "listingConfig");
            Long l = null;
            Long l2 = l;
            for (ListingConfig.ListingAttribute listingAttribute : listingConfig.getListingAttrs()) {
                if (j.a((Object) "price.limit.min", (Object) listingAttribute.getKey())) {
                    l = Long.valueOf((long) Double.parseDouble(listingAttribute.getValue()));
                }
                if (j.a((Object) "price.limit.max", (Object) listingAttribute.getKey())) {
                    l2 = Long.valueOf((long) Double.parseDouble(listingAttribute.getValue()));
                }
            }
            if (l == null || l2 == null) {
                return null;
            }
            if (l == null) {
                j.a();
            }
            long longValue = l.longValue();
            if (l2 == null) {
                j.a();
            }
            return new f(longValue, l2.longValue());
        }
    }
}
