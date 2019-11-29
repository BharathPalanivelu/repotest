package com.shopee.app.ui.product.b.a;

import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.network.http.data.ListingConfig;
import com.shopee.app.util.q.g;
import d.d.b.j;

public final class e implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final a f24366a = new a((g) null);

    /* renamed from: c  reason: collision with root package name */
    private final int f24367c;

    /* renamed from: d  reason: collision with root package name */
    private final int f24368d;

    /* renamed from: e  reason: collision with root package name */
    private final int f24369e;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof e) {
                e eVar = (e) obj;
                if (this.f24367c == eVar.f24367c) {
                    if (this.f24368d == eVar.f24368d) {
                        if (this.f24369e == eVar.f24369e) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((Integer.valueOf(this.f24367c).hashCode() * 31) + Integer.valueOf(this.f24368d).hashCode()) * 31) + Integer.valueOf(this.f24369e).hashCode();
    }

    public String toString() {
        return "ImagesValidatorConfig(minImages=" + this.f24367c + ", minWidth=" + this.f24368d + ", minHeight=" + this.f24369e + SQLBuilder.PARENTHESES_RIGHT;
    }

    public e(int i, int i2, int i3) {
        this.f24367c = i;
        this.f24368d = i2;
        this.f24369e = i3;
    }

    public final int a() {
        return this.f24367c;
    }

    public final int b() {
        return this.f24368d;
    }

    public final int c() {
        return this.f24369e;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final e a(ListingConfig listingConfig) {
            j.b(listingConfig, "listingConfig");
            Integer num = null;
            Integer num2 = num;
            Integer num3 = num2;
            for (ListingConfig.ListingAttribute listingAttribute : listingConfig.getListingAttrs()) {
                if (j.a((Object) "image.num.min", (Object) listingAttribute.getKey())) {
                    num = Integer.valueOf(Integer.parseInt(listingAttribute.getValue()));
                }
                if (j.a((Object) "image.height.min", (Object) listingAttribute.getKey())) {
                    num2 = Integer.valueOf(Integer.parseInt(listingAttribute.getValue()));
                }
                if (j.a((Object) "image.width.min", (Object) listingAttribute.getKey())) {
                    num3 = Integer.valueOf(Integer.parseInt(listingAttribute.getValue()));
                }
            }
            if (num == null || num2 == null || num3 == null) {
                return null;
            }
            if (num == null) {
                j.a();
            }
            int intValue = num.intValue();
            if (num3 == null) {
                j.a();
            }
            int intValue2 = num3.intValue();
            if (num2 == null) {
                j.a();
            }
            return new e(intValue, intValue2, num2.intValue());
        }
    }
}
