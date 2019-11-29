package com.shopee.app.ui.product.b.a;

import com.shopee.app.network.http.data.ListingConfig;
import d.d.b.j;

public final class g implements com.shopee.app.util.q.g {

    /* renamed from: a  reason: collision with root package name */
    public static final a f24373a = new a((g) null);

    /* renamed from: c  reason: collision with root package name */
    private final int f24374c;

    /* renamed from: d  reason: collision with root package name */
    private final int f24375d;

    public g(int i, int i2) {
        this.f24374c = i;
        this.f24375d = i2;
    }

    public final int a() {
        return this.f24374c;
    }

    public final int b() {
        return this.f24375d;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final g a(ListingConfig listingConfig) {
            j.b(listingConfig, "listingConfig");
            Integer num = null;
            Integer num2 = num;
            for (ListingConfig.ListingAttribute listingAttribute : listingConfig.getListingAttrs()) {
                if (j.a((Object) "stock.limit.min", (Object) listingAttribute.getKey())) {
                    num = Integer.valueOf(Integer.parseInt(listingAttribute.getValue()));
                }
                if (j.a((Object) "stock.limit.max", (Object) listingAttribute.getKey())) {
                    num2 = Integer.valueOf(Integer.parseInt(listingAttribute.getValue()));
                }
            }
            if (num == null || num2 == null) {
                return null;
            }
            if (num == null) {
                j.a();
            }
            int intValue = num.intValue();
            if (num2 == null) {
                j.a();
            }
            return new g(intValue, num2.intValue());
        }
    }
}
