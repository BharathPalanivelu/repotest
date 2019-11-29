package com.shopee.app.ui.product.b.a;

import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.network.http.data.ListingConfig;
import com.shopee.app.util.q.g;
import d.d.b.j;

public final class c implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final a f24358a = new a((g) null);

    /* renamed from: c  reason: collision with root package name */
    private final int f24359c;

    /* renamed from: d  reason: collision with root package name */
    private final int f24360d;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (this.f24359c == cVar.f24359c) {
                    if (this.f24360d == cVar.f24360d) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (Integer.valueOf(this.f24359c).hashCode() * 31) + Integer.valueOf(this.f24360d).hashCode();
    }

    public String toString() {
        return "DescriptionValidatorConfig(minLen=" + this.f24359c + ", maxLen=" + this.f24360d + SQLBuilder.PARENTHESES_RIGHT;
    }

    public c(int i, int i2) {
        this.f24359c = i;
        this.f24360d = i2;
    }

    public final int a() {
        return this.f24359c;
    }

    public final int b() {
        return this.f24360d;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final c a(ListingConfig listingConfig) {
            j.b(listingConfig, "listingConfig");
            Integer num = null;
            Integer num2 = num;
            for (ListingConfig.ListingAttribute listingAttribute : listingConfig.getListingAttrs()) {
                if (j.a((Object) "description.length.min", (Object) listingAttribute.getKey())) {
                    num = Integer.valueOf(Integer.parseInt(listingAttribute.getValue()));
                }
                if (j.a((Object) "description.length.max", (Object) listingAttribute.getKey())) {
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
            return new c(intValue, num2.intValue());
        }
    }
}
