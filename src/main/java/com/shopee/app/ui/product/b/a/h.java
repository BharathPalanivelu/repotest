package com.shopee.app.ui.product.b.a;

import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.network.http.data.ListingConfig;
import com.shopee.app.util.q.b;
import com.shopee.app.util.q.g;
import d.d.b.j;
import java.util.List;

public final class h implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final a f24376a = new a((g) null);

    /* renamed from: c  reason: collision with root package name */
    private final int f24377c;

    /* renamed from: d  reason: collision with root package name */
    private final int f24378d;

    /* renamed from: e  reason: collision with root package name */
    private final List<String> f24379e;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof h) {
                h hVar = (h) obj;
                if (this.f24377c == hVar.f24377c) {
                    if (!(this.f24378d == hVar.f24378d) || !j.a((Object) this.f24379e, (Object) hVar.f24379e)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = ((Integer.valueOf(this.f24377c).hashCode() * 31) + Integer.valueOf(this.f24378d).hashCode()) * 31;
        List<String> list = this.f24379e;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "TitleValidatorConfig(minLen=" + this.f24377c + ", maxLen=" + this.f24378d + ", blacklistChars=" + this.f24379e + SQLBuilder.PARENTHESES_RIGHT;
    }

    public h(int i, int i2, List<String> list) {
        j.b(list, "blacklistChars");
        this.f24377c = i;
        this.f24378d = i2;
        this.f24379e = list;
    }

    public final int a() {
        return this.f24377c;
    }

    public final int b() {
        return this.f24378d;
    }

    public final List<String> c() {
        return this.f24379e;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final h a(ListingConfig listingConfig) {
            j.b(listingConfig, "listingConfig");
            List<String> list = null;
            Integer num = null;
            Integer num2 = num;
            for (ListingConfig.ListingAttribute listingAttribute : listingConfig.getListingAttrs()) {
                if (j.a((Object) "title.character_blacklist", (Object) listingAttribute.getKey())) {
                    list = b.b(listingAttribute.getValue());
                }
                if (j.a((Object) "title.length.min", (Object) listingAttribute.getKey())) {
                    num = Integer.valueOf(Integer.parseInt(listingAttribute.getValue()));
                }
                if (j.a((Object) "title.length.max", (Object) listingAttribute.getKey())) {
                    num2 = Integer.valueOf(Integer.parseInt(listingAttribute.getValue()));
                }
            }
            if (list == null || num == null || num2 == null) {
                return null;
            }
            if (num == null) {
                j.a();
            }
            int intValue = num.intValue();
            if (num2 == null) {
                j.a();
            }
            int intValue2 = num2.intValue();
            if (list == null) {
                j.a();
            }
            return new h(intValue, intValue2, list);
        }
    }
}
